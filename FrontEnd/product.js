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

let dropdown = document.querySelectorAll(".dropdown_main");
  dropdown.forEach((dropdown) => {
    let select = dropdown.querySelector(".select");
    let caret = dropdown.querySelector(".caret");
    let menu = dropdown.querySelector(".menu");
    let options_ = dropdown.querySelectorAll(".menu li");
    let selected = dropdown.querySelector(".selected");
    select.addEventListener("click",()=> {
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
    let getProduct = async()=>{
      let res = await fetch("https://markdeals.up.railway.app/products");
      data = await res.json();
      appendData(data);
      console.log(data);
    }
    getProduct();

    let appendData = (data)=>{
      let products = document.getElementById("productdiv");
      products.innerHTML = null;
      data.forEach((el)=>{
        let div = document.createElement("div");
        let pimg = document.createElement("img");
        pimg.src = el.imageUrl;
        let pname = document.createElement("p");
        pname.innerText = el.name;
        let pprice = document.createElement("p");
        pprice.innerText = "₹ " + el.price;
        let pcategory = document.createElement("p");
        pcategory.innerText = el.category;
        let addtocart = document.createElement("button")
        addtocart.innerText = "Add To Cart"
        addtocart.onclick = ()=>{
          addProductToCart(el);
        }
        div.append(pimg,pname,pprice,pcategory,addtocart);
        products.append(div);
      })
      
  }

  const addProductToCart = async (productData)=>{
    let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
    console.log(productData);
    console.log(userDataFromLs);
    let res = await fetch(`https://markdeals.up.railway.app/addtocart/${productData.productId}`, {
        method: "POST",
        body: JSON.stringify(userDataFromLs),
        headers: {
          "Content-Type": "application/json",
        },
      });
      let data = await res.json();
      console.log(data);
  }

  let cartPage=()=>{
    window.location.href="./cart.html";
  }

// ==========================Sorting=================

let lowtohigh=()=>{
  data.sort((a,b)=>{
    return  a.price - b.price;
  })
  appendData(data);
}
let hightolow=()=>{
  data.sort((a,b)=>{
    return  b.price - a.price;
  })
  appendData(data);
}

// ======================Filtering===========================

let allproducts =()=>{
  appendData(data);
}

let pants = ()=>{
  let filtered_pant = data.filter(function(elem){
      return elem.category == "Pant";
  })
  appendData(filtered_pant)
}
let shirts = ()=>{
  let filtered_shirts = data.filter(function(elem){
      return elem.category == "Shirt";
  })
  appendData(filtered_shirts)
}
let tshirts = ()=>{
  let filtered_tshirts = data.filter(function(elem){
      return elem.category == "Tshirt";
  })
  appendData(filtered_tshirts)
}
let laptop = ()=>{
  let filtered_laptop = data.filter(function(elem){
      return elem.category == "Laptop";
  })
  appendData(filtered_laptop)
}
let mobile = ()=>{
  let filtered_mobiles = data.filter(function(elem){
      return elem.category == "Mobile";
  })
  appendData(filtered_mobiles)
}
let grocery = ()=>{
  let filtered_grocery = data.filter(function(elem){
      return elem.category == "Grocery";
  })
  appendData(filtered_grocery)
}
let homekitchen = ()=>{
  let filtered_homeandkitchen = data.filter(function(elem){
      return elem.category == "Home-Kitchen";
  })
  appendData(filtered_homeandkitchen)
}
