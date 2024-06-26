const url = "http://localhost:8888/";
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
let paymentAmountFromLs = JSON.parse(localStorage.getItem("checkoutAmt"));
document.getElementById("payAmt").innerText = "₹" +paymentAmountFromLs;
document.getElementById("upiPayAmt").innerText = "₹" +paymentAmountFromLs;

let barcode = async () =>{
    let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
    let otp = document.getElementById("otp").value;
    let paymentData={
        users : userDataFromLs,
        paymentType : "Barcode-Scan",
    }
    if(otp.length > 0){
        if(otp == "789789"){
        let res = await fetch(`${url}savepayment`, {
            method: "POST",
            body: JSON.stringify(paymentData),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data1 = await res.json();

          let orderobj = {}

          let res2 = await fetch(`${url}orders/${userDataFromLs.userEmail}`, {
            method: "POST",
            body: JSON.stringify(orderobj),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data2 = await res2.json();
          

          let res3 = await fetch(`${url}deleteproduct/${userDataFromLs.cart.cartId}`, {
            method: "DELETE",
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data3 = await res3.json();

          window.location.href = "./orderplaced.html";
        }else{
            alert("OTP is incorrect!");
        }
    }else{
        alert("OTP field is empty!");
    }
}

let cod = async ()=>{
    let checkbox = document.getElementById("cod").checked;
    let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
    let paymentData={
        users : userDataFromLs,
        paymentType : "COD",
    }
    if(checkbox){
        let res = await fetch(`${url}savepayment`, {
            method: "POST",
            body: JSON.stringify(paymentData),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data = await res.json();

          let orderobj = {}

          let res2 = await fetch(`${url}orders/${userDataFromLs.userEmail}`, {
            method: "POST",
            body: JSON.stringify(orderobj),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data2 = await res2.json();
          

          let res3 = await fetch(`${url}deleteproduct/${userDataFromLs.cart.cartId}`, {
            method: "DELETE",
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data3 = await res3.json();

          window.location.href = "./orderplaced.html";
    }else{
        alert("Please check the checkbox!");
    }
}

const cartdetails = async ()=>{
    let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
    let cardNumber = document.getElementById("cardnumber").value;
    let month = document.getElementById("month").value;
    let year = document.getElementById("year").value;
    let cvv  = document.getElementById("cvv").value;
    let paymentData={
        users : userDataFromLs,
        paymentType : "Card",
    }
    if(cardNumber.length == 16 && month != null && year != null && cvv != null){
        if(cvv == "786"){
        let res = await fetch(`${url}savepayment`, {
            method: "POST",
            body: JSON.stringify(paymentData),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data = await res.json();

          let orderobj = {}

          let res2 = await fetch(`${url}orders/${userDataFromLs.userEmail}`, {
            method: "POST",
            body: JSON.stringify(orderobj),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data2 = await res2.json();
          

          let res3 = await fetch(`${url}deleteproduct/${userDataFromLs.cart.cartId}`, {
            method: "DELETE",
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data3 = await res3.json();


          window.location.href = "./orderplaced.html";
        }else{
            alert("CVV is incorrect!");
        }
    }else{
        alert("Card details are wrong!");
    }
  }

  let upipayment = async ()=>{
    let userDataFromLs = JSON.parse(localStorage.getItem("userData"));
    let upiId = document.getElementById("upi_id").value;
    let paymentData={
        users : userDataFromLs,
        paymentType : "UPI-ID",
    }
    if(upiId.length > 0){
        if(upiId == "1234567890@ibl"){
        let res = await fetch(`${url}savepayment`, {
            method: "POST",
            body: JSON.stringify(paymentData),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data = await res.json();

          let orderobj = {}

          let res2 = await fetch(`${url}orders/${userDataFromLs.userEmail}`, {
            method: "POST",
            body: JSON.stringify(orderobj),
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data2 = await res2.json();

          let res3 = await fetch(`${url}deleteproduct/${userDataFromLs.cart.cartId}`, {
            method: "DELETE",
            headers: {
              "Content-Type": "application/json",
            },
          });
          let data3 = await res3.json();

          window.location.href = "./orderplaced.html";
        }else{
            alert("UPI ID is incorrect!");
        }
    }else{
        alert("UPI ID field is empty!");
    }
  }
