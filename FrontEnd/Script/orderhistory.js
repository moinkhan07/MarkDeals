const url = "http://localhost:8888/";
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
  window.location.href = "./index.html";
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
  let res = await fetch(`${url}orders/${userDataFromLs.userEmail}`);
  let data = await res.json();
  appendOrder(data);
}
getOrders();

let appendOrder = (data)=>{
  let orders = document.getElementById("showOrders");
  orders.innerHTML = null;
  data.forEach((el)=>{
    let tr = document.createElement("tr");
    let oId = document.createElement("td");
    oId.innerText = el.orderId;
    let oDate = document.createElement("td");
    oDate.innerText = el.placedDate;
    let oStatus = document.createElement("td");
    oStatus.innerText = el.orderstatus;
    let oAmount = document.createElement("td");
    oAmount.innerText = "₹" + el.totalAmount;
    let oDetails = document.createElement("td");
    let cancelOrder = document.createElement("button");
    cancelOrder.setAttribute("class","cancelorder");
    cancelOrder.innerText = "Cancel";
    cancelOrder.onclick=()=>{
      cancelOrderFunction(el);
      cancelOrder.innerText="Cancelled"
    }
    oDetails.append(cancelOrder);
    tr.append(oId,oDate,oStatus,oAmount,oDetails);
    orders.append(tr);
  })
}

let cancelOrderFunction = async (el)=>{
  let obj = {};
  let res = await fetch(`${url}orders/${el.orderId}`, {
    method: "PATCH",
    body: JSON.stringify(obj),
    headers: {
      "Content-Type": "application/json",
    },
  });
    let data = await res.json();
    if(data.orderStatus == "Cancelled"){
    alert("Order Cancelled Successfully!");
    getOrders();
    }
}
