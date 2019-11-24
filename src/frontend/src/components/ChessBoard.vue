<template>
    <el-container id="chess-board">
        <el-row>
            <el-col :span="3">
                <div id="a1" class="board-grid"></div>
                <div id="a2" class="board-grid"></div>
                <div id="a3" class="board-grid"></div>
                <div id="a4" class="board-grid"></div>
                <div id="a5" class="board-grid"></div>
                <div id="a6" class="board-grid"></div>
                <div id="a7" class="board-grid"></div>
                <div id="a8" class="board-grid"></div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <div id="b1" class="board-grid"></div>
                <div id="b2" class="board-grid"></div>
                <div id="b3" class="board-grid"></div>
                <div id="b4" class="board-grid"></div>
                <div id="b5" class="board-grid"></div>
                <div id="b6" class="board-grid"></div>
                <div id="b7" class="board-grid"></div>
                <div id="b8" class="board-grid"></div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <div id="c1" class="board-grid"></div>
                <div id="c2" class="board-grid"></div>
                <div id="c3" class="board-grid"></div>
                <div id="c4" class="board-grid"></div>
                <div id="c5" class="board-grid"></div>
                <div id="c6" class="board-grid"></div>
                <div id="c7" class="board-grid"></div>
                <div id="c8" class="board-grid"></div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <div id="d1" class="board-grid"></div>
                <div id="d2" class="board-grid"></div>
                <div id="d3" class="board-grid"></div>
                <div id="d4" class="board-grid"></div>
                <div id="d5" class="board-grid"></div>
                <div id="d6" class="board-grid"></div>
                <div id="d7" class="board-grid"></div>
                <div id="d8" class="board-grid"></div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <div id="e1" class="board-grid"></div>
                <div id="e2" class="board-grid"></div>
                <div id="e3" class="board-grid"></div>
                <div id="e4" class="board-grid"></div>
                <div id="e5" class="board-grid"></div>
                <div id="e6" class="board-grid"></div>
                <div id="e7" class="board-grid"></div>
                <div id="e8" class="board-grid"></div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <div id="f1" class="board-grid"></div>
                <div id="f2" class="board-grid"></div>
                <div id="f3" class="board-grid"></div>
                <div id="f4" class="board-grid"></div>
                <div id="f5" class="board-grid"></div>
                <div id="f6" class="board-grid"></div>
                <div id="f7" class="board-grid"></div>
                <div id="f8" class="board-grid"></div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <div id="g1" class="board-grid"></div>
                <div id="g2" class="board-grid"></div>
                <div id="g3" class="board-grid"></div>
                <div id="g4" class="board-grid"></div>
                <div id="g5" class="board-grid"></div>
                <div id="g6" class="board-grid"></div>
                <div id="g7" class="board-grid"></div>
                <div id="g8" class="board-grid"></div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <div id="h1" class="board-grid"></div>
                <div id="h2" class="board-grid"></div>
                <div id="h3" class="board-grid"></div>
                <div id="h4" class="board-grid"></div>
                <div id="h5" class="board-grid"></div>
                <div id="h6" class="board-grid"></div>
                <div id="h7" class="board-grid"></div>
                <div id="h8" class="board-grid"></div>
            </el-col>
        </el-row>
    </el-container>
</template>

<script>
    export default {
        name: 'ChessBoard',
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

    .board-grid:hover {
        height: 7vw;
        width: 7vw;
        background-color: #5D4F27;
    }
</style>
