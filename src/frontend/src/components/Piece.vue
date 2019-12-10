<template>
  <img id="piece"
       width="100%"
       :style="grabCursorIfMovable"
       :src="require(`../assets/merida/${pieceName}.svg`)"
       alt=""
  >
</template>

<script>
  export default {
    name: "Piece",
    props: {
      pieceName: String,
      currentTurn: String
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
    },
    computed: {
      grabCursorIfMovable() {
        if (this.movable) {
          return `cursor: grab`
        }
        return ``;
      },
    },
    created() {
      this.color = this.getColorOf(this.pieceName);
      this.movable = this.checkMovable(this.currentTurn);
    },
  }
</script>
