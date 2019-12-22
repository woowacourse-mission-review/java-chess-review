<template>
  <img id="piece"
       width="100%"
       :style="grabCursorIfMovable"
       :src="require(`../assets/merida/${pieceName}.svg`)"
       alt=""
       @click="emitPosition(position)"
  >
</template>

<script>
  export default {
    name: "Piece",
    props: {
      pieceName: String,
      currentTurn: String,
      position: String
    },
    data() {
      return {
        color: '',
        movable: false,
      }
    },
    methods: {
      getColorOf(pieceName) {
        if (pieceName.charAt(0) === `b`) {
          return `black`;
        }
        return `white`;
      },
      checkMovable(currentTurn) {
        return currentTurn === this.color;
      },
      emitPosition(position) {
        if (this.currentTurn === this.color) {
          this.$emit(`update:picked`, position);
        }
      },
    },
    computed: {
      grabCursorIfMovable() {
        if (this.movable) {
          return `cursor: grab`
        }
        return ``;
      },
    },
    watch: {
      currentTurn: function () {
        this.movable = this.checkMovable(this.currentTurn)
      }
    },
    created() {
      this.color = this.getColorOf(this.pieceName);
      this.movable = this.checkMovable(this.currentTurn);
    },
  }
</script>
