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

      if(userdata.firstName.length < 4){
        alert("FirstName length should more than 3");
      }
      if(userdata.lastName.length < 4){
        alert("LastName length should more than 3");
      }
      let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      if(!userdata.userEmail.match(mailformat)){
        alert("Enter correct email format!")
      }
      if(userdata.password.length < 8 || userdata.password.length > 20){
        alert("Password should be min 8 and max 20");
      }
      if(userdata.userMobile.length < 10){
        alert("Mobile Number should be of 10 digits");
      }
      if(userdata.address.pincode.length < 6){
        alert("Pincode should be of 6 digits");
      }
      else{
        let res = await fetch("https://markdeals.up.railway.app/users", {
          method: "POST",
          body: JSON.stringify(userdata),
          headers: {
            "Content-Type": "application/json",
          },
        });
        let data = await res.json();
        alert("Welcome To MarkDeals " + userdata.firstName);
    }
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
  if(data.message !== "Wrong Credential"){
    alert("Successfully login!");
    localStorage.setItem("userData", JSON.stringify(data));
    window.location.href="./product.html";
  }else{
    alert("Wrong Credential!");
  }
}