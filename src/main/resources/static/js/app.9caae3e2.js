(function(t){function e(e){for(var o,s,a=e[0],c=e[1],u=e[2],f=0,d=[];f<a.length;f++)s=a[f],Object.prototype.hasOwnProperty.call(i,s)&&i[s]&&d.push(i[s][0]),i[s]=0;for(o in c)Object.prototype.hasOwnProperty.call(c,o)&&(t[o]=c[o]);l&&l(e);while(d.length)d.shift()();return r.push.apply(r,u||[]),n()}function n(){for(var t,e=0;e<r.length;e++){for(var n=r[e],o=!0,a=1;a<n.length;a++){var c=n[a];0!==i[c]&&(o=!1)}o&&(r.splice(e--,1),t=s(s.s=n[0]))}return t}var o={},i={app:0},r=[];function s(e){if(o[e])return o[e].exports;var n=o[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,s),n.l=!0,n.exports}s.m=t,s.c=o,s.d=function(t,e,n){s.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},s.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},s.t=function(t,e){if(1&e&&(t=s(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(s.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var o in t)s.d(n,o,function(e){return t[e]}.bind(null,o));return n},s.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return s.d(e,"a",e),e},s.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},s.p="/";var a=window["webpackJsonp"]=window["webpackJsonp"]||[],c=a.push.bind(a);a.push=e,a=a.slice();for(var u=0;u<a.length;u++)e(a[u]);var l=c;r.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"061b":function(t,e,n){t.exports=n.p+"img/wQ.4e4432a6.svg"},1:function(t,e){},"108c":function(t,e,n){t.exports=n.p+"img/bB.8a6bd56a.svg"},"1bbd":function(t,e,n){t.exports=n.p+"img/bK.47af274b.svg"},2:function(t,e){},"2cb6":function(t,e,n){t.exports=n.p+"img/wB.e0eb761a.svg"},3:function(t,e){},"3a9b":function(t,e,n){t.exports=n.p+"img/wK.bb430c60.svg"},4:function(t,e){},"4b52":function(t,e,n){"use strict";var o=n("81d3"),i=n.n(o);i.a},"4eb8":function(t,e,n){t.exports=n.p+"img/bQ.aed026d0.svg"},"4fac":function(t,e,n){t.exports=n.p+"img/wN.f9c6e522.svg"},5:function(t,e){},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var o=n("2b0e"),i=n("5c96"),r=n.n(i),s=(n("0fae"),function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-container",[n("el-header",{attrs:{align:"center"}},[n("h1",[t._v("Woowahan Chess")])]),n("el-row",[n("el-col",{attrs:{span:16}},[n("chess-board")],1),n("el-col",{attrs:{span:8}},[n("status-board")],1)],1)],1)}),a=[],c=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-container",{attrs:{id:"chess-board"}},t._l(t.generateXCoordinates,(function(e,o){return n("el-row",{key:o,attrs:{span:3}},[n("el-col",{attrs:{span:3}},t._l(t.generateYCoordinates,(function(o,i){return n("div",{key:i,staticClass:"board-grid",style:t.changeColorIfMovable(e+o),attrs:{id:e+o},on:{click:function(n){return t.tryMoveTo(e+o)}}},[t.pieceIsAt(e,o)?n("Piece",{attrs:{pieceName:t.pieces[e+o],"current-turn":t.turn,position:e+o},on:{"update:picked":function(e){return t.pick(e)}}}):t._e()],1)})),0)],1)})),1)},u=[],l=(n("caad"),n("2532"),function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("img",{style:t.grabCursorIfMovable,attrs:{id:"piece",width:"100%",src:n("fde8")("./"+t.pieceName+".svg"),alt:""},on:{click:function(e){return t.emitPosition(t.position)}}})}),f=[],d={name:"Piece",props:{pieceName:String,currentTurn:String,position:String},data:function(){return{color:"",movable:!1}},methods:{getColorOf:function(t){return"b"===t.charAt(0)?"black":"white"},checkMovable:function(t){return t===this.color},emitPosition:function(t){this.currentTurn===this.color&&this.$emit("update:picked",t)}},computed:{grabCursorIfMovable:function(){return this.movable?"cursor: grab":""}},watch:{currentTurn:function(){this.movable=this.checkMovable(this.currentTurn)}},created:function(){this.color=this.getColorOf(this.pieceName),this.movable=this.checkMovable(this.currentTurn)}},p=d,b=n("2877"),v=Object(b["a"])(p,l,f,!1,null,null,null),g=v.exports,h=n("30dc"),m=n.n(h),w={name:"ChessBoard",components:{Piece:g},data:function(){return{pieces:{},movablePositions:{},pickedPosition:"",turn:"",gameStatus:""}},methods:{pieceIsAt:function(t,e){return this.pieces.hasOwnProperty(t+e)},initializePieces:function(){var t=this;m()("".concat(window.location.origin,"/api/initialized-board"),(function(e,n,o){var i=JSON.parse(o);window.console.log(i),200===n.statusCode?(t.pieces=i.positionsOfPieces,t.turn=i.turn,t.getMovablePositions(t),T.$emit("updateBoard",i)):(alert("초기화 실패!"),alert(e),window.console.log(e))}))},getMovablePositions:function(t){m()("".concat(window.location.origin,"/api/movable-positions/"),(function(e,n,o){200===n.statusCode&&(window.console.log(o),t.movablePositions=JSON.parse(o))}))},pick:function(t){this.pickedPosition=t},changeColorIfMovable:function(t){return this.movablePositions.hasOwnProperty(this.pickedPosition)&&""!=this.pickedPosition&&this.movablePositions[this.pickedPosition].includes(t)?"box-shadow: inset 0 2px 45px #1a3300;\n                  cursor: pointer;":""},tryMoveTo:function(t){this.pickedPosition!==t&&(this.movablePositions[this.pickedPosition].includes(t)&&this.move(this.pickedPosition,t),this.pickedPosition="")},move:function(t,e){var n=this,o={uri:"".concat(window.location.origin,"/api/move"),method:"POST",body:{from:t,to:e},json:!0};m.a.post(o,(function(t,e,o){if(200===e.statusCode){if(n.pieces=o.positionsOfPieces,"end"===o.gameStatus)return n.movablePositions={},void T.$emit("gameOver",o);n.turn=o.turn,n.getMovablePositions(n),T.$emit("updateBoard",o)}window.console.log(t),window.console.log(e),window.console.log(o)}))}},computed:{generateXCoordinates:function(){for(var t=[],e="a".charCodeAt(0);e<="h".charCodeAt(0);e++)t.push(String.fromCharCode(e));return t},generateYCoordinates:function(){for(var t=[],e=1;e<=8;e++)t.push(e);return t}},created:function(){T.$on("startGame",this.initializePieces)},destroyed:function(){T.$off("startGame")}},P=w,y=(n("4b52"),Object(b["a"])(P,c,u,!1,null,"76df1f6a",null)),k=y.exports,_=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-container",{staticStyle:{height:"56vw"},attrs:{justify:"center"}},["ready"===t.gameStatus?n("el-row",{attrs:{align:"center",justify:"center"}},[n("el-col",[n("el-button",{staticClass:"start-button",on:{click:t.startGame}},[t._v(" 게임 시작 ")])],1)],1):t._e(),"battle"===t.gameStatus?n("el-row",{attrs:{align:"center",justify:"center"}},[n("el-col",{attrs:{cols:"12"}},[t._v(" 현재 턴 : "+t._s(t.turn)+" ")]),n("el-col",{attrs:{cols:"12"}},[t._v(" score White : "+t._s(t.score.white)+" ")]),n("el-col",{attrs:{cols:"12"}},[t._v(" score Black : "+t._s(t.score.black)+" ")]),n("el-col",{attrs:{cols:"12"}},[n("el-button",{staticClass:"start-button",on:{click:t.startGame}},[t._v(" 다시 시작 ")])],1)],1):t._e(),"end"===t.gameStatus?n("el-row",{attrs:{align:"center",justify:"center"}},[n("el-col",{attrs:{cols:"12"}},[t._v(" "+t._s(t.winner)+" 승리!! ")]),n("el-button",{staticClass:"start-button",on:{click:t.startGame}},[t._v(" 다시 시작 ")])],1):t._e()],1)},O=[],x={name:"StatusBoard",data:function(){return{gameStatus:"ready",turn:"",score:{white:"",black:""},winner:""}},methods:{startGame:function(){this.gameStatus="battle",T.$emit("startGame")},finishGame:function(){var t=this;this.gameStatus="end",m()("".concat(window.location.origin,"/api/winner"),(function(e,n,o){200===n.statusCode&&(t.winner=JSON.parse(o).winner)}))}},mounted:function(){var t=this;T.$on("gameOver",this.finishGame),T.$on("updateBoard",(function(e){t.gameStatus=e.gameStatus,t.turn=e.turn,t.score.white=e.scoreWhite,t.score.black=e.scoreBlack}))},destroyed:function(){T.$off("gameOver"),T.$off("updateBoard")}},C=x,S=Object(b["a"])(C,_,O,!1,null,null,null),j=S.exports,M={name:"app",components:{ChessBoard:k,StatusBoard:j}},$=M,B=Object(b["a"])($,s,a,!1,null,null,null),N=B.exports;n.d(e,"eventBus",(function(){return T})),o["default"].config.productionTip=!1,o["default"].use(r.a);var T=new o["default"];new o["default"]({el:"#app",render:function(t){return t(N)}}).$mount("#app")},"81d3":function(t,e,n){},"861a":function(t,e,n){t.exports=n.p+"img/bR.027332a0.svg"},9068:function(t,e,n){t.exports=n.p+"img/bP.344e161b.svg"},b356:function(t,e,n){t.exports=n.p+"img/wR.57350123.svg"},dc34:function(t,e,n){t.exports=n.p+"img/bN.0026f146.svg"},dc48:function(t,e,n){t.exports=n.p+"img/wP.4ff1ce7c.svg"},fde8:function(t,e,n){var o={"./bB.svg":"108c","./bK.svg":"1bbd","./bN.svg":"dc34","./bP.svg":"9068","./bQ.svg":"4eb8","./bR.svg":"861a","./wB.svg":"2cb6","./wK.svg":"3a9b","./wN.svg":"4fac","./wP.svg":"dc48","./wQ.svg":"061b","./wR.svg":"b356"};function i(t){var e=r(t);return n(e)}function r(t){if(!n.o(o,t)){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}return o[t]}i.keys=function(){return Object.keys(o)},i.resolve=r,t.exports=i,i.id="fde8"}});
//# sourceMappingURL=app.9caae3e2.js.map