const buttons = document.querySelectorAll(".tab");
const panels = document.querySelectorAll(".tab-panel");

function activateTab(targetId) {
  buttons.forEach((button) => {
    button.classList.toggle("active", button.dataset.target === targetId);
  });

  panels.forEach((panel) => {
    panel.classList.toggle("active", panel.id === targetId);
  });
}

buttons.forEach((button) => {
  button.addEventListener("click", () => {
    activateTab(button.dataset.target);
  });
});
