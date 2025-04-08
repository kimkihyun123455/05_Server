// 목록으로 버튼 클릭 시 "/" 이동(GET)
const goToList = document.querySelector("#goToList")

// 목록으로 버튼이 클릭된 경우
goToList.addEventListener("click", ()=>{
  // "/" 메인 페이지 요청 (GET)
  location.href="/";

});

// URLSearchParams(loaction.search)
// -> ?todoNo=7를 key : todoNo value : 7 의 형태로 반환

// 할 일 상제 조회 페이지에서 쿼리스트링 값 얻어오기
// url 에서 얻어오면 된다 (쿼리스트링 부분 : ?todoNo=7)

// location.search : 쿼리스트링만 얻어오기
// URLSearchParams() : 쿼리스트링을 객체 형태로 다룰 수 있는 객체
const todoNo = new URLSearchParams(location.search).get("todoNo");

console.log(todoNo);

// 완료 여부 변경
const completeBtn = document.querySelector("#completeBtn");
completeBtn.addEventListener("click",()=>{

  // 현재 보고 있는 Todo의 완료 여부를
  // O <-> X 변경 요청하기 (GET)요청
  location.href="/todo/complete?todoNo="+todoNo;


});

// 삭제 버튼
const deleteBtn = document.querySelector("#deleteBtn")
deleteBtn.addEventListener("click", ()=>{

  location.href="/todo/delete?todoNo="+todoNo;

});

// 수정 버튼



