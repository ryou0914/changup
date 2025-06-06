document.addEventListener("DOMContentLoaded", async () => {
  try {
    const response = await fetch("http://localhost:8080/admin/applications", {
      method: "GET",
      credentials: "include" // 로그인 세션 쿠키 포함
    });

    if (!response.ok) {
      throw new Error("조회 실패");
    }

    const data = await response.json();
    const container = document.getElementById("applications-list");

    data.forEach(form => {
      const wrapper = document.createElement("div");
      wrapper.className = "question-box";

      wrapper.innerHTML = `
        <div class="question-left">
          <span class="label">${form.number}</span>
          <div class="content">[${form.name}] ${form.content}</div>
        </div>
        <div class="question-right">
         <button class="delete-button" style="background-color: red; color: white; border: none;"data-id="${form.id}">삭제</button>
          <div class="timestamp">${form.createdAt?.replace("T", " ").substring(0, 16) || "-"}</div>
        </div>
        
      `;

      container.appendChild(wrapper);
    });

  } catch (err) {
    console.error("견적 목록 불러오기 실패:", err);
    alert("조회에 실패했습니다. 로그인 상태를 확인해주세요.");
  }
});


// 삭제 버튼 클릭 이벤트 핸들러
document.addEventListener("click", async (e) => {
  if (e.target.classList.contains("delete-button")) {
    const id = e.target.dataset.id;

    const confirmed = confirm("정말 삭제하시겠습니까?");
    if (!confirmed) return;

    try {
      const response = await fetch(`http://localhost:8080/admin/applications/${id}`, {
        method: "DELETE",
        credentials: "include"
      });

      if (!response.ok) {
        throw new Error("삭제 실패");
      }

      // 성공 시 DOM에서 제거
      const questionBox = e.target.closest(".question-box");
      if (questionBox) questionBox.remove();

    } catch (err) {
      console.error("삭제 중 오류:", err);
      alert("삭제에 실패했습니다. 다시 시도해주세요.");
    }
  }
});
