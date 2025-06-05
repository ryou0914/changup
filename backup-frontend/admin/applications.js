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
          <span class="label">전화번호</span>
          <div class="content">[${form.name}] ${form.content}</div>
        </div>
        <div class="timestamp">${form.createdAt?.replace("T", " ").substring(0, 16) || "-"}</div>
      `;

      container.appendChild(wrapper);
    });

  } catch (err) {
    console.error("견적 목록 불러오기 실패:", err);
    alert("조회에 실패했습니다. 로그인 상태를 확인해주세요.");
  }
});
