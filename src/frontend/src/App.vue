<template>
  <el-container>
    <el-header align="center"><h1>Woowahan Chess</h1></el-header>
    <el-row>
      <el-col :span="16">
        <chess-board></chess-board>
      </el-col>
      <el-col :span="8">
        <status-board></status-board>
      </el-col>
    </el-row>
  </el-container>
</template>

<script>
  import ChessBoard from "./components/ChessBoard";
  import StatusBoard from "./components/StatusBoard";

  export default {
    name: 'app',
    components: {
      ChessBoard,
      StatusBoard
    }
  }
</script>

<style>
</style>
