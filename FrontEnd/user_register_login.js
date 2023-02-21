const registeruser = async () => {
    let userdata = {
      firstName: document.getElementById("fn").value,
      lastName: document.getElementById("ln").value,
      userEmail: document.getElementById("email").value,
      password: document.getElementById("pass").value,
      userMobile: document.getElementById("mb").value,
      address:{
        city: document.getElementById("city").value,
       state : document.getElementById("state").value,
        country: document.getElementById("country").value,
        pincode: document.getElementById("pin").value,
      }
      
    };
  
    let res = await fetch("https://markdeals.up.railway.app/users", {
      method: "POST",
      body: JSON.stringify(userdata),
      headers: {
        "Content-Type": "application/json",
      },
    });
    let data = await res.json();
    if(data.userEmail == data.userEmail && data.userMobile == data.userMobile){
      alert("User registered!")
    }
    console.log(data);
  };
  
const loginuser = async ()=>{
  let userlogindata ={
  userEmail :document.getElementById("loginemail").value,
  password : document.getElementById("loginpass").value,
  }
  let res = await fetch("https://markdeals.up.railway.app/userlogin", {
      method: "POST",
      body: JSON.stringify(userlogindata),
      headers: {
        "Content-Type": "application/json",
      },
    });
    let data = await res.json();
    console.log(data);
  if(data.message !== "Wrong Credential"){
    alert("Successfully login!");
    localStorage.setItem("userData", JSON.stringify(data));
    window.location.href="./product.html";
  }else{
    alert("Wrong Credential!");
  }
}