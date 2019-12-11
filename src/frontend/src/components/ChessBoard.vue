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
          class="board-grid"
        >
          <Piece v-if="pieceIsAt(xCoordinate, yCoordinate)"
                 :pieceName="pieces[xCoordinate + yCoordinate]"
                 :current-turn="turn"
          />
        </div>
      </el-col>
    </el-row>
  </el-container>
</template>

<script>
  import Piece from "./Piece";
  import request from "request";

  export default {
    name: 'ChessBoard',
    components: {
      Piece
    },
    data() {
      return {
        pieces: {},
        movablePositions: {},
        picked: ``,
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
          const boardInfo = JSON.parse(body);
          window.console.log(boardInfo);

          if (response.statusCode === 200) {
            chessboard.pieces = boardInfo.positionsOfPieces;
            chessboard.turn = boardInfo.turn;
          } else {
            //Todo : initialize 실패시 오류 alert
            window.console.log(error);
          }
        });
      }
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
      this.initializePieces();
    },
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
