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

    let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
    let getCartData = async()=>{
      let res = await fetch(`https://markdeals.up.railway.app/cartproducts/${userDataFromLs.userEmail}`);
      let data = await res.json();
      appendData(data);
      isEmpty(data);
    }
    getCartData();
    let appendData = (data)=>{
      let products = document.getElementById("productviewdiv");
      products.innerHTML = null;
      let subtotal = 0;
      data.forEach((el)=>{
        let perProductDiv = document.createElement("div");
        perProductDiv.setAttribute("class","perproductdiv");

        let imageDiv = document.createElement("div");
        imageDiv.setAttribute("class","productimage");
        let pimg = document.createElement("img");
        pimg.src = el.imageUrl;
        imageDiv.append(pimg);

        let productDetailDiv = document.createElement("div");
        productDetailDiv.setAttribute("class","productdetails");
        let title = document.createElement("p");
        title.setAttribute("class","title")
        title.innerText = el.name;
        let category = document.createElement("p");
        category.setAttribute("class","category");
        category.innerText = "Category : " + el.category;
        let rating = document.createElement("p");
        rating.setAttribute("class","rating")
        rating.innerText ="Rating : " + el.rating;
        let removeBtn = document.createElement("button");
        removeBtn.setAttribute("class","removebtn");
        removeBtn.innerText = "Remove";
        removeBtn.onclick=()=>{
          deleteProduct(el);
        }
        productDetailDiv.append(title,category,rating,removeBtn);

        let productPriceDiv = document.createElement("div");
        productPriceDiv.setAttribute("class","productprice");
        let priceDiv = document.createElement("div");
        priceDiv.setAttribute("class","price");
        let labelTag = document.createElement("label");
        labelTag.innerText = "Quantity";
        let quantityInput = document.createElement("input");
        quantityInput.setAttribute("class","quantity");
        quantityInput.type="number";
        quantityInput.value =1;
        let pricingdiv = document.createElement("div");
        pricingdiv.setAttribute("class","pricingdiv");
        let actualPrice = document.createElement("s");
        actualPrice.innerText = "₹"+ el.price;
        let discountedPrice = document.createElement("p");
        let disAmt = el.price*10/100;
        discountedPrice.innerText = "₹" + (el.price - disAmt);
        subtotal+= (el.price-disAmt);
        pricingdiv.append(actualPrice,discountedPrice);
        let discount = document.createElement("p"); 
        discount.setAttribute("class","discount");
        discount.innerText = "You Save 10%";

        priceDiv.append(labelTag,quantityInput,pricingdiv,discount);
        productPriceDiv.append(priceDiv);
        perProductDiv.append(imageDiv,productDetailDiv,productPriceDiv);
        products.append(perProductDiv);
      })
      orderSummary(subtotal);
  }

  let deleteProduct= async(product)=>{
    let res = await fetch(`https://markdeals.up.railway.app/deleteproduct/${userDataFromLs.cart.cartId}/${product}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    });
    let data = await res.json();
    // alert("Product Removed!");
    window.location.reload;
  }

  let orderSummary =(subtotalamount)=>{
    let totalamountdiv = document.getElementById("totalamountdiv");
    totalamountdiv.innerHTML = null;

    let totalamounttitle = document.createElement("div");
    totalamounttitle.setAttribute("id","totalamountitle");
    totalamounttitle.innerText = "Order Summary";

    let line = document.createElement("hr");
    line.setAttribute("class","line_");

    let subTotal1 = document.createElement("div");
    subTotal1.setAttribute("class","subtotal");
    let subtotaltitle = document.createElement("p");
    subtotaltitle.innerText = "Subtotal:"
    subtotaltitle.setAttribute("class","sub");
    let subAmt = document.createElement("p");
    subAmt.innerText ="₹"+subtotalamount ;
    subTotal1.append(subtotaltitle,subAmt);


    let subTotal2 = document.createElement("div");
    subTotal2.setAttribute("class","subtotal");
    let subtotaltitleship = document.createElement("p");
    subtotaltitleship.innerText = "Shipping Charges:"
    subtotaltitleship.setAttribute("class","sub");
    let subamtwithshipcharges = document.createElement("p");
    subamtwithshipcharges.innerText ="₹"+ 120;
    subTotal2.append(subtotaltitleship,subamtwithshipcharges);


    let subTotal3 = document.createElement("div");
    subTotal3.setAttribute("class","subtotal");
    let subtotaltitletax = document.createElement("p");
    subtotaltitletax.innerText = "1% GST On Subtotal:"
    subtotaltitletax.setAttribute("class","sub");
    let subamtwithtax = document.createElement("p");
    subamtwithtax.innerText ="₹"+(subtotalamount * 1 / 100);
    subTotal3.append(subtotaltitletax,subamtwithtax);

    let line2 = document.createElement("hr");
    line2.setAttribute("class","line_2");

    let finalamtdiv = document.createElement("div");
    finalamtdiv.setAttribute("id","total");
    let totalptag = document.createElement("p");
    totalptag.innerText = "Total:";
    totalptag.setAttribute("id","tot");
    let finalamount = document.createElement("p");
    finalamount.innerText = "₹"+(subtotalamount + 120 + (subtotalamount * 1 / 100));
    finalamount.setAttribute("id","final");
    finalamtdiv.append(totalptag,finalamount);

    let checkoutbtn = document.createElement("button");
    checkoutbtn.setAttribute("id","checkoutbtn");
    checkoutbtn.innerText = "Checkout"
    let bal = subtotalamount + 120 + (subtotalamount * 1 / 100);
    checkoutbtn.onclick = ()=>{
      checkout(bal);
    }
    let securetext = document.createElement("p");
    let securelogo = document.createElement("img");
    securelogo.src = "./lock.png";
    securetext.innerHTML = "Secure Checkout";
    securetext.setAttribute("id","secure");
    securetext.append(securelogo);
 
    totalamountdiv.append(totalamounttitle,line,subTotal1,subTotal2,subTotal3,line2,finalamtdiv,checkoutbtn,securetext);

  }
  
let checkout = (checkoutAmount)=>{
  localStorage.setItem("checkoutAmt",checkoutAmount);
  if(checkoutAmount > "125"){
    window.location.href = "./payment.html";
  }else{
    alert("Cart Is Empty!");
  }
}
// ====================================Is empty cart===============================
let isEmpty=(product)=>{
  let mainDiv = document.getElementById("productviewdiv");
  let div = document.createElement("div");
  div.setAttribute("id","messagediv")
  let message = document.createElement("h1");
  message.innerText = "Empty Cart!"
  div.append(message);
  if(product.length == 0){
    mainDiv.append(div);
  }
}




// =================================Profile alphabet =============================

let userFirstNameFirstLetter = document.querySelector(".selected_");
userFirstNameFirstLetter.innerText = userDataFromLs.firstName.charAt(0).toUpperCase();

// ================================Go to product page====================
let gotoproductpage=()=>{
  window.location.href="./product.html";
}