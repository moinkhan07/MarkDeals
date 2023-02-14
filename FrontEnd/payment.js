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

let barcode =()=>{
    let passcode = "789789";
    let input = document.getElementById("otp");
    if(passcode == input.value){
        alert("Payment Successfully!");
    }else{
        alert("Enter correct OTP!");
    }
}

let cod = ()=>{
    let checkbox = document.getElementById("cod").checked;
    if(checkbox){
        alert("Order Placed!")
    }else{
        alert("Checkbox not checked!");
    }
}