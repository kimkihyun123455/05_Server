// 제목이 작성되지 않은 경우 form 제출 막기

const addForm = document.querySelector("#addForm");
const title = document.querySelector("[name=title]");

// addForm이 제출될 때
addForm.addEventListener("submit",(e) => {

  // e: 이벤트 객체
  // 제목 입력된 값 가져와서 양쪽 공백 제거
  const input = title.value.trim();

  // 제목이 입력되지 않았을 때
  if(input.length===0){
    // form태그에서 일어나는 제출이벤트 막기
    e.preventDefault();

    alert("제목을 입력하시오");
    title.focus();

  }

});

const logout = document.querySelector("#logout");

logout.addEventListener("click", ()=>{
  location.href="/logout";
});