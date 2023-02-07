const addProduct = async () => {
    let add_item_data = {
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
      body: JSON.stringify(add_item_data),
      headers: {
        "Content-Type": "application/json",
      },
    });
    let data = await res.json();
    console.log(data);
    // window.location.reload();
  };
  