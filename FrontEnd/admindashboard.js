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
    // options_2.forEach((op) => {
    //     op.addEventListener("click", () => {
    //     selected_2.innerText = op.innerText;

    //     select_2.classList.remove("select_-clicked");
        
    //     caret_2.classList.remove("caret_-rotate");
    //     menu_2.classList.remove("menu_2_-open");
    //     options_2.forEach((op) => {
    //       op.classList.remove("active");
    //     });
    //     op.classList.add("active");
    //   });
    // });
  });

//   ------------------------ Body part --------------------
let tabs = document.querySelectorAll(".tabs__toggle"),
contents = document.querySelectorAll(".tabs__content");

tabs.forEach((tab,index)=>{
    tab.addEventListener("click",()=>{
        contents.forEach((con)=>{
            con.classList.remove("is-active");
        });
        tabs.forEach((tab)=>{
            tab.classList.remove("is-active");
        });
        contents[index].classList.add("is-active");
        tabs[index].classList.add("is-active");
    });
});

// ======================== Product Page Start Here ======================

let t = document.querySelectorAll(".tabs_toggle"),
c = document.querySelectorAll(".tabs_content");

t.forEach((tab,index)=>{
    tab.addEventListener("click",()=>{
        c.forEach((co)=>{
            co.classList.remove("is_active");
        });
        t.forEach((ta)=>{
            ta.classList.remove("is_active");
        });
        c[index].classList.add("is_active");
        t[index].classList.add("is_active");
    });
});

// imageUrl
// name
// price 
// category
// rating
// quantity
// description

const addProduct = async () => {
  let add_item_data = {
    imageUrl: document.getElementById("url").value,
    name: document.getElementById("name").value,
    price: document.getElementById("price").value,
    category: document.getElementById("category").value,
    rating: document.getElementById("rating").value,
    quantity: document.getElementById("quantity").value,
    description: document.getElementById("description").value,
  };

  let res = await fetch("http://localhost:8888/products", {
    method: "POST",
    body: JSON.stringify(add_item_data),
    headers: {
      "Content-Type": "application/json",
    },
  });
  let data = await res.json();
  console.log(data);
  window.location.reload();
};

let getProduct = async()=>{
  let res = await fetch("http://localhost:8888/products");
  let data = await res.json();
  appendData(data);
  // console.log(data);
}
getProduct();
let appendData = (data)=>{
  let products = document.getElementById("showProduct");
  products.innerHTML = null;
  data.forEach((el)=>{
    let tr = document.createElement("tr");
    let pid = document.createElement("td");
    pid.innerText = el.productId;
    let pimg = document.createElement("td");
    let img = document.createElement("img");
    img.src = el.imageUrl;
    pimg.append(img);
    let pname = document.createElement("td");
    pname.innerText = el.name;
    let pprice = document.createElement("td");
    pprice.innerText = el.price;
    let pcategory = document.createElement("td");
    pcategory.innerText = el.category;
    let pquantity = document.createElement("td");
    pquantity.innerText = el.quantity;
    tr.append(pid,pimg,pname,pprice,pcategory,pquantity);
    products.append(tr);
  })
  
}
