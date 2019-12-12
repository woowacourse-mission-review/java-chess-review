# java-chess

## front 요구사항
- 게임을 시작하면 체스판을 초기화한다.
- 현재 움직일 차례인 체스 말인 경우 마우스를 올렸을 때 말이 위치판 판의 색을 바꿔준다.
- 체스 말 위에 마우스를 올렸을 때, 말의 이동 가능한 위치를 표시해준다.
- api콜을 통해 이동 가능한 위치를 전달받지 못한 말들은 이동 가능한 위치가 empty인 것을 default로 한다.
- 체스 말을 클릭했을 때, 말의 이동 가능한 위치를 표시해준다.
- 체스 말이 이동할 때, 이동하려는 위치에 적팀이 있는 경우 해당 위치의 적팀 말을 없애고 이동한다.
- 말이 이동할 때마다 현재 score를 업데이트 해준다.
- 말이 이동할 때마다 게임이 끝났는지 확인하고, 게임이 끝난 경우 승자를 알려준다.
- 게임이 끝난 경우 게임을 다시 시작할지, 종료할지 묻는다.
- 게임을 다시 시작하는 경우 체스판을 초기화한다.

## Backend API 요구사항
1.해당 session의 체스판 초기화, 초기화된 체스말과 위치 반환
```
요청: 

GET /api/initialized-board HTTP/1.1

```
    
```
응답: 
200 OK

{
    "positionsOfPieces": {
        "a1": "bR", "b1": "bN", "c1": "bB", "d1": "bQ", "e1": "bK", "f1": "bB", "g1": "bN", "h1": "bR",
        "a2": "bP", "b2": "bP", "c2": "bP", "d2": "bP", "e2": "bP", "f2": "bP", "g2": "bP", "h2": "bP",
        "a7": "wP", "b7": "wP", "c7": "wP", "d7": "wP", "e7": "wP", "f7": "wP", "g7": "wP", "h7": "wP",
        "a8": "wR", "b8": "wN", "c8": "wB", "d8": "wQ", "e8": "wK", "f8": "wB", "g8": "wN", "h8": "wR"
    },
    "turn" : "white",
    "scoreWhite" : "10",
    "scoreBlack" : "15",
    "gameStatus" : "battle"
}
```

<br>

2.체스말의 이동
```
요청 예시:

POST /api/move HTTP/1.1

{
    from : "a1",
    to : "a3"
}
```

```
성공시 응답 예시 :

200 OK 

{
    "positionsOfPieces" : {
    "a1": "bR", "b1": "bN", "c1": "bB", "d1": "bK", "e1": "bQ", "f1": "bB", "g1": "bN", "h1": "bR",
    "a2": "bP", "b2": "bP", "c2": "bP", "d2": "bP", "e2": "bP", "f2": "bP", "g2": "bP", "h2": "bP",
    "a7": "wP", "b7": "wP", "c7": "wP", "d7": "wP", "e7": "wP", "f7": "wP", "g7": "wP", "h7": "wP",
    "a8": "wR", "b8": "wN", "c8": "wB", "d8": "wK", "e8": "wQ", "f8": "wB", "g8": "wN", "h8": "wR" }
    "scoreWhite" : "10",
    "scoreBlack" : "15",
    "gameStatus" : "battle" or "end",
    "turn" : "white" or "black" 
}
```
```
실패시 응답 예시:

406 Not Acceptable 

{
    "message" : "reason"
}
```

<br>

3.현재 턴인 체스말들의 이동 가능한 위치를 각각 모두 알려주기
```
요청:

GET /api/movablePositions/
```

```
성공시 응답 예시:

200 OK

{
    "a1": ["a2", "a3", "a4", "a5", "a6", "a7"],
    "b1": ["b2", "b3", "b4", "b5", "b6", "b7"],
    "c1": ["c2", "c3", "c4", "c5", "c6", "c7"]
}
```


```
실패시 응답 예시:

406 Not Acceptable

{
    "message" : "reason"
}
```

<br>

4.승자 알려주기
```
요청:

GET /api/winner
```

```
성공시 응답 예시: 

200 OK

{
    "winner" : "white" or "black" or "draw"
}
```

```
실패시 응답 예시: 

406 Not Acceptable

{
    "message" : "reason"
}
```
