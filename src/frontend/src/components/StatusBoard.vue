<template>
  <el-container style="height: 56vw;" justify="center">
    <el-row
      v-if="gameStatus === `ready`"
      align="center"
      justify="center"
    >
      <el-col>
        <el-button
          class="start-button"
          @click="startGame"
        >
          게임 시작
        </el-button>
      </el-col>
    </el-row>

    <el-row
      v-if="gameStatus === `battle`"
      align="center"
      justify="center"
    >
      <el-col cols="12">
        현재 턴 : {{ turn }}
      </el-col>
      <el-col cols="12">
        score White : {{ score.white }}
      </el-col>
      <el-col cols="12">
        score Black : {{ score.black }}
      </el-col>
      <el-col cols="12">
        <el-button
          class="start-button"
          @click="startGame"
        >
          다시 시작
        </el-button>
      </el-col>
    </el-row>

    <el-row
      v-if="gameStatus === `end`"
      align="center"
      justify="center"
    >
      <el-col cols="12">
        {{ winner }} 승리!!
      </el-col>
      <el-button
        class="start-button"
        @click="startGame"
      >
        다시 시작
      </el-button>
    </el-row>
  </el-container>
</template>

<script>
  import {eventBus} from "../main";
  import request from "request";

  export default {
    name: 'StatusBoard',
    data() {
      return {
        gameStatus: `ready`,
        turn: ``,
        score: {
          white: ``,
          black: ``,
        },
        winner: ``,
      }
    },
    methods: {
      startGame() {
        this.gameStatus = `battle`;
        eventBus.$emit(`startGame`);
      },
      finishGame() {
        const statusBoard = this;
        this.gameStatus = `end`;

        request(`${window.location.origin}/api/winner`, function (error, response, body) {
          if (response.statusCode === 200) {
            statusBoard.winner = JSON.parse(body).winner;
          }
        });
      },
    },
    mounted() {
      eventBus.$on(`gameOver`, this.finishGame);
      eventBus.$on(`updateBoard`, boardStatus => {
        this.gameStatus = boardStatus.gameStatus;
        this.turn = boardStatus.turn;
        this.score.white = boardStatus.scoreWhite;
        this.score.black = boardStatus.scoreBlack;
      });
    },
    destroyed() {
      eventBus.$off(`gameOver`);
      eventBus.$off(`updateBoard`);
    }
  }
</script>

<style>
</style>
