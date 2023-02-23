const adminlogin = async ()=>{
    let adminlogindata = {
      email:document.getElementById("loginemail").value,
      password:document.getElementById("loginpass").value,
    }

    let res = await fetch("https://markdeals.up.railway.app/adminlogin", {
      method: "POST",
      body: JSON.stringify(adminlogindata),
      headers: {
        "Content-Type": "application/json",
      },
    });
    let data = await res.json();
  if(data.message !== "Wrong Credential"){
    alert("Successfully login!");
    localStorage.setItem("adminData", JSON.stringify(data));
    window.location.href="./admindashboard.html";
  }else{
    alert("Wrong Credential!");
  }
}