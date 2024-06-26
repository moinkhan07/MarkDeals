const url = "http://localhost:8888/";

let dropdown_2 = document.querySelectorAll(".dropdown_main_");
dropdown_2.forEach((drop) => {
  let select_2 = drop.querySelector(".select_");
  let caret_2 = drop.querySelector(".caret_");
  let menu_2 = drop.querySelector(".menu_2_");
  // let options_2 = drop.querySelectorAll(".menu_2_ li");
  let selected_2 = drop.querySelector(".selected_");
  select_2.addEventListener("click", () => {
    select_2.classList.toggle("select_-clicked");
    caret_2.classList.toggle("caret_-rotate");
    menu_2.classList.toggle("menu_2_-open");
  });
});

let dropdown = document.querySelectorAll(".dropdown_main");
dropdown.forEach((dropdown) => {
  let select = dropdown.querySelector(".select");
  let caret = dropdown.querySelector(".caret");
  let menu = dropdown.querySelector(".menu");
  let options_ = dropdown.querySelectorAll(".menu li");
  let selected = dropdown.querySelector(".selected");
  select.addEventListener("click", () => {
    select.classList.toggle("select-clicked");
    caret.classList.toggle("caret-rotate");
    menu.classList.toggle("menu-open");
  });
  options_.forEach((opt) => {
    opt.addEventListener("click", () => {
      selected.innerText = opt.innerText;

      select.classList.remove("select-clicked");

      caret.classList.remove("caret-rotate");
      menu.classList.remove("menu-open");
      options_.forEach((opt) => {
        opt.classList.remove("active");
      });
      opt.classList.add("active");
    });
  });
});

// ===============================================
let data;
let flag = false;
let getProduct = async () => {
  let res = await fetch(`${url}products`);
  data = await res.json();
  appendData(data);
};
getProduct();

let appendData = (data) => {
  let products = document.getElementById("productdiv");
  products.innerHTML = null;
  data.forEach((el) => {
    let div = document.createElement("div");
    let pimg = document.createElement("img");
    pimg.src = el.imageUrl;
    let imgDiv = document.createElement("div");
    imgDiv.append(pimg);
    imgDiv.setAttribute("class", "producttop");
    let pname = document.createElement("p");
    pname.innerText = el.name;
    let pprice = document.createElement("p");
    pprice.innerText = "₹ " + el.price;
    let pcategory = document.createElement("p");
    pcategory.innerText = el.category;
    let addtocart = document.createElement("button");
    addtocart.innerText = "Add To Cart";
    addtocart.onclick = () => {
      addProductToCart(el);
    };
    let infoDiv = document.createElement("div");
    infoDiv.append(pname, pprice, pcategory, addtocart);
    infoDiv.setAttribute("class", "productbottom");
    div.append(imgDiv, infoDiv);
    products.append(div);
  });
};
let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
const addProductToCart = async (productData) => {
  let res = await fetch(`${url}addtocart/${productData.productId}`, {
    method: "POST",
    body: JSON.stringify(userDataFromLs),
    headers: {
      "Content-Type": "application/json",
    },
  });
  let data = await res.json();
  if (flag == false) {
    alert("Product added to cart");
    flag = true;
  } else {
    alert("Product is already in the cart!");
  }
};

let cartPage = () => {
  window.location.href = "./cart.html";
};

// ==========================Sorting=================

let lowtohigh = async () => {
  let res = await fetch(`${url}sortinascending`);
  let data = await res.json();
  appendData(data);
};
let hightolow = async () => {
  let res = await fetch(`${url}sortindescending`);
  let data = await res.json();
  appendData(data);
};

// ======================Filtering===========================

let allproducts = () => {
  appendData(data);
};

let pants = async () => {
  let res = await fetch(`${url}productsbycategory/${"Pant"}`);
  let data = await res.json();
  appendData(data);
};
let shirts = async () => {
  let res = await fetch(`${url}productsbycategory/${"Shirt"}`);
  let data = await res.json();
  appendData(data);
};
let tshirts = async () => {
  let res = await fetch(`${url}productsbycategory/${"Tshirt"}`);
  let data = await res.json();
  appendData(data);
};
let laptop = async () => {
  let res = await fetch(`${url}productsbycategory/${"Laptop"}`);
  let data = await res.json();
  appendData(data);
};
let mobile = async () => {
  let res = await fetch(`${url}productsbycategory/${"Mobile"}`);
  let data = await res.json();
  appendData(data);
};
let grocery = async () => {
  let res = await fetch(`${url}productsbycategory/${"Grocery"}`);
  let data = await res.json();
  appendData(data);
};
let homekitchen = async () => {
  let res = await fetch(`${url}productsbycategory/${"Home-Kitchen"}`);
  let data = await res.json();
  appendData(data);
};
// ========================Search product by search bar========================
let searchproduct = async () => {
  let pName = document.getElementById("search").value;
  let res = await fetch(`${url}productbyname/${pName}`);
  let data = await res.json();
  appendData(data);
};

// =================================Profile alphabet =============================

let userFirstNameFirstLetter = document.querySelector(".selected_");
userFirstNameFirstLetter.innerText = userDataFromLs.firstName
  .charAt(0)
  .toUpperCase();

// =======================================Order history page redirect=========================
let orderHistory = () => {
  window.location.href = "orderhistory.html";
};

// ===================================Logout=============================
let logout = () => {
  window.location.href = "./index.html";
};
