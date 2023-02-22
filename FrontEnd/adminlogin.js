const adminlogin = async ()=>{
    let email = document.getElementById("loginemail").value;
    let pass = document.getElementById("loginpass").value;

    let res = await fetch(`https://markdeals.up.railway.app/admins/${email}/${pass}`);
    let data = await res.json();

    if(data.message !== "Wrong Credential"){
      alert("Admin Successfully login!");
      window.location.href="./admindashboard.html";
    }else{
      alert("Wrong Credential!");
    }
}