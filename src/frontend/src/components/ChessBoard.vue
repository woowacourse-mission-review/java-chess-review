<template>
  <el-container id="chess-board">
    <el-row
      :span="3"
      v-for="(xCoordinate,i) in generateXCoordinates"
      :key="i">
      <el-col
        :span="3"
      >
        <div
          :id="xCoordinate + yCoordinate"
          v-for="(yCoordinate, i) in generateYCoordinates"
          :key="i"
          @click="tryMoveTo(xCoordinate + yCoordinate)"
          class="board-grid"
          :style="changeColorIfMovable(xCoordinate + yCoordinate)"
        >
          <Piece v-if="pieceIsAt(xCoordinate, yCoordinate)"
                 :pieceName="pieces[xCoordinate + yCoordinate]"
                 :current-turn="turn"
                 :position="xCoordinate + yCoordinate"
                 @update:picked="pick($event)"
          />
        </div>
      </el-col>
    </el-row>
  </el-container>
</template>

<script>
  import Piece from "./Piece";
  import request from "request";
  import {eventBus} from "../main";

  export default {
    name: 'ChessBoard',
    components: {
      Piece
    },
    data() {
      return {
        pieces: {},
        movablePositions: {},
        pickedPosition: ``,
        turn: ``,
        gameStatus: ``,
      }
    },
    methods: {
      pieceIsAt(x, y) {
        return this.pieces.hasOwnProperty(x + y);
      },
      initializePieces() {
        const chessboard = this;

        request(`${window.location.origin}/api/initialized-board`, function (error, response, body) {
          const boardStatus = JSON.parse(body);
          window.console.log(boardStatus);

          if (response.statusCode === 200) {
            chessboard.pieces = boardStatus.positionsOfPieces;
            chessboard.turn = boardStatus.turn;
            chessboard.getMovablePositions(chessboard);
            eventBus.$emit(`updateBoard`, boardStatus);
          } else {
            alert(`초기화 실패!`);
            alert(error);
            window.console.log(error);
          }
        });
      },
      getMovablePositions(chessboard) {
        request(`${window.location.origin}/api/movable-positions/`, function (error, response, body) {
          if (response.statusCode === 200) {
            window.console.log(body);
            chessboard.movablePositions = JSON.parse(body);
          }
        });
      },
      pick(positionOfPiece) {
        this.pickedPosition = positionOfPiece;
      },
      changeColorIfMovable(position) {
        if (this.movablePositions.hasOwnProperty(this.pickedPosition)) {
          if (this.pickedPosition != '' && this.movablePositions[this.pickedPosition].includes(position)) {
            return `box-shadow: inset 0 2px 45px #1a3300;
                    cursor: pointer;`
          }
        }
        return ``;
      },
      tryMoveTo(position) {
        if (this.pickedPosition === position) {
          return;
        }

        if (this.movablePositions[this.pickedPosition].includes(position)) {
          this.move(this.pickedPosition, position)
        }
        this.pickedPosition = ``;
      },
      move(from, to) {
        const chessboard = this;
        const movingInfo = {
          uri: `${window.location.origin}/api/move`,
          method: `POST`,
          body: {
            from: from,
            to: to,
          },
          json: true,
        };

        request.post(movingInfo, function (error, response, body) {
          if (response.statusCode === 200) {
            chessboard.pieces = body.positionsOfPieces;

            if (body.gameStatus === `end`) {
              chessboard.movablePositions = {};
              eventBus.$emit(`gameOver`, body);
              return;
            }
            chessboard.turn = body.turn;
            chessboard.getMovablePositions(chessboard);
            eventBus.$emit(`updateBoard`, body);
          }
          window.console.log(error);
          window.console.log(response);
          window.console.log(body);
        });
      },
    },
    computed: {
      generateXCoordinates() {
        const coordinates = [];

        for (let i = `a`.charCodeAt(0); i <= `h`.charCodeAt(0); i++) {
          coordinates.push(String.fromCharCode(i));
        }
        return coordinates;
      },
      generateYCoordinates() {
        const coordinates = [];

        for (let i = 1; i <= 8; i++) {
          coordinates.push(i);
        }
        return coordinates;
      },
    },
    created() {
      eventBus.$on(`startGame`, this.initializePieces);
    },
    destroyed() {
      eventBus.$off(`startGame`);
    }
  }
</script>

<style scoped>
  #chess-board {
    width: 56vw;
    height: 56vw;
    background-image: url('../assets/wood2.jpg');
    background-size: 100% 100%;
  }

  .board-grid {
    height: 7vw;
    width: 7vw;
  }

  /*.board-grid:hover {*/
  /*    height: 7vw;*/
  /*    width: 7vw;*/
  /*    background-color: #5D4F27;*/
  /*}*/

</style>
