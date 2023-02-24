let dropdown_2 = document.querySelectorAll(".dropdown_main_");
  dropdown_2.forEach((drop) => {
    let select_2 = drop.querySelector(".select_");
    let caret_2 = drop.querySelector(".caret_");
    let menu_2 = drop.querySelector(".menu_2_");
    // let options_2 = drop.querySelectorAll(".menu_2_ li");
    let selected_2 = drop.querySelector(".selected_");
    select_2.addEventListener("click",()=> {
      select_2.classList.toggle("select_-clicked");
      caret_2.classList.toggle("caret_-rotate");
      menu_2.classList.toggle("menu_2_-open");
    });
});
let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
// ===================================Logout=============================
let logout = ()=>{
  window.location.href = "./user_register_login.html";
}
// =================================Profile alphabet =============================

let userFirstNameFirstLetter = document.querySelector(".selected_");
userFirstNameFirstLetter.innerText = userDataFromLs.firstName.charAt(0).toUpperCase();

// ================================Go to product page====================
let gotoproductpage=()=>{
  window.location.href="./product.html";
}
let cartPage=()=>{
  window.location.href="./cart.html";
}

let getOrders = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders");
  let data = await res.json();
  // appendData(data);
  console.log(data);
}
getOrders();