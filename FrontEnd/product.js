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
    // ===============================================

    let getProduct = async()=>{
      let res = await fetch("http://localhost:8888/products");
      let data = await res.json();
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
        let pquantity = document.createElement("p");
        pquantity.innerText = el.quantity;
        let addtocart = document.createElement("button")
        addtocart.innerText = "Add To Cart"
        div.append(pimg,pname,pprice,pcategory,pquantity,addtocart);
        products.append(div);
      })
      
    }