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
  
    let res = await fetch("http://localhost:8888/users", {
      method: "POST",
      body: JSON.stringify(userdata),
      headers: {
        "Content-Type": "application/json",
      },
    });
    let data = await res.json();
    console.log(data);
  };
  
const loginuser = async ()=>{
  let email = document.getElementById("loginemail").value;
  let pass = document.getElementById("loginpass").value;
  let res = await fetch(`http://localhost:8888/userlogin/${email}/${pass}`);
  let data = await res.json();
  console.log(data);
  if(data.message !== "Wrong Credential"){
    alert("Successfully login!");
    window.location.href="./product.html";
  }else{
    alert("Wrong Credential!");
  }
}