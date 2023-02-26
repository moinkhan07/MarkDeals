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

//   ------------------------ Body part --------------------
let tabs = document.querySelectorAll(".tabs__toggle"),
contents = document.querySelectorAll(".tabs__content");

tabs.forEach((tab,index)=>{
    tab.addEventListener("click",()=>{
        contents.forEach((con)=>{
            con.classList.remove("is-active");
        });
        tabs.forEach((tab)=>{
            tab.classList.remove("is-active");
        });
        contents[index].classList.add("is-active");
        tabs[index].classList.add("is-active");
    });
});

// ======================== Product Page Start Here ======================

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

let getProduct = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/products");
  let data = await res.json();
  appendData(data);
}
getProduct();
let appendData = (data)=>{
  let products = document.getElementById("showProduct");
  products.innerHTML = null;
  data.forEach((el)=>{
    let tr = document.createElement("tr");
    let pid = document.createElement("td");
    pid.innerText = el.productId;
    let pimg = document.createElement("td");
    let img = document.createElement("img");
    img.src = el.imageUrl;
    pimg.append(img);
    let pname = document.createElement("td");
    pname.innerText = el.name;
    let pprice = document.createElement("td");
    pprice.innerText = el.price;
    let pcategory = document.createElement("td");
    pcategory.innerText = el.category;
    let pquantity = document.createElement("td");
    pquantity.innerText = el.quantity;
    tr.append(pid,pimg,pname,pprice,pcategory,pquantity);
    products.append(tr);
  })
  
}

let getUsers = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/users");
  let data = await res.json();
  appendUsers(data);
}
getUsers();
let appendUsers=(data)=>{
  let users = document.getElementById("showUsers");
  users.innerHTML = null;
  data.forEach((el)=>{
    let tr = document.createElement("tr");
    let uid = document.createElement("td");
    uid.innerText = el.userId;
    let uimg = document.createElement("td");
    let img = document.createElement("img");
    img.src = "https://cdn-icons-png.flaticon.com/512/1077/1077114.png";
    uimg.append(img);
    let uname = document.createElement("td");
    uname.innerText = el.firstName.charAt(0).toUpperCase() + el.firstName.slice(1)
    let uemail = document.createElement("td");
    uemail.innerText = el.userEmail;
    let umobile = document.createElement("td");
    umobile.innerText = el.userMobile;
    let ucity = document.createElement("td");
    ucity.innerText = el.address.city.charAt(0).toUpperCase() + el.address.city.slice(1);
    tr.append(uid,uimg,uname,uemail,umobile,ucity);
    users.append(tr);
  })
}

let getOrders = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders");
  let data = await res.json();
  appendOrder(data);
}
getOrders();

let appendOrder = (data)=>{
  let orders = document.getElementById("showOrders");
  orders.innerHTML = null;
  data.forEach((el)=>{
    let tr = document.createElement("tr");
    let oId = document.createElement("td");
    oId.innerText = el.orderId;
    let oDate = document.createElement("td");
    oDate.innerText = el.placedDate;
    let oStatus = document.createElement("td");
    oStatus.innerText = el.orderstatus;
    let oAmount = document.createElement("td");
    oAmount.innerText = el.totalAmount;
    tr.append(oId,oDate,oStatus,oAmount);
    orders.append(tr);
  })
}

const updateOrderStatus= async ()=>{
  let status = document.getElementById("status").value;
  let orderId = document.getElementById("orderId").value;
  let update={};
  let res = await fetch(`https://markdeals.up.railway.app/orders/${orderId}/${status}`, {
    method: "PATCH",
    body: JSON.stringify(update),
    headers: {
      "Content-Type": "application/json",
    },
  });
  let data = await res.json();
  if(data.orderstatus == status){
    alert("Order status updated!")
  }
  getOrders(data);
}


const addProduct = async () => {
  let add_item_data = {
    imageUrl: document.getElementById("url").value,
    name: document.getElementById("name").value,
    price: document.getElementById("price").value,
    category: document.getElementById("category").value,
    rating: document.getElementById("rating").value,
    quantity: document.getElementById("quantity").value,
    description: document.getElementById("description").value,
  };

  let res = await fetch("https://markdeals.up.railway.app/products", {
    method: "POST",
    body: JSON.stringify(add_item_data),
    headers: {
      "Content-Type": "application/json",
    },
  });
  let data = await res.json();
  getProduct(data);
};

const updateProductPrice = async() =>{
  let productId =document.getElementById("updatepId").value;
  let price =document.getElementById("updatedprice").value;
  let res = await fetch(`https://markdeals.up.railway.app/updateproductsprice/${productId}`, {
    method: "PATCH",
    body: JSON.stringify(price),
    headers: {
      "Content-Type": "application/json",
    },
  });
  let data = await res.json();
  getProduct(data);
}

const updateProductQuantity = async() =>{
  let productId =document.getElementById("updpId").value;

  let quantity = document.getElementById("updatedquantity").value;

  let res =await fetch(`https://markdeals.up.railway.app/updateproductsquantity/${productId}`, {
    method: "PATCH",
    body: JSON.stringify(quantity),
    headers: {
      "Content-Type": "application/json",
    },
  });
  let data = await res.json();
  getProduct(data);
}

const deleteProduct= async()=>{
    let del = document.getElementById("deleteProduct").value;
    let res = await fetch(`https://markdeals.up.railway.app/products/${del}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    });
    let data = await res.json();
    getProduct(data);
}
// ==================================Total sales today===========
let todaySales = document.getElementById("todaySales");
let totalSalesToday = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders/totalsalestoday");
  let data = await res.json();
  todaySales.append("₹"+data);
}
totalSalesToday();


let totalOrders = document.getElementById("totalorders");
let totalOrdersCount = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders/totalorders");
  let data = await res.json();
  totalOrders.append(data);
}
totalOrdersCount();


let processingorder = document.getElementById("processingorder");
let totalProcessingOrder = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders/totalprocessingorders");
  let data = await res.json();
  processingorder.append(data);
}
totalProcessingOrder();



let processedorders = document.getElementById("processedorders");
let totalProcessedOrders = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders/totalprocessedorders");
  let data = await res.json();
  processedorders.append(data);
}
totalProcessedOrders();

let outfordelivery = document.getElementById("outfordelivery");
let totalOutForDelivery=async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders/totaloutfordeliveryorders");
  let data = await res.json();
  outfordelivery.append(data);
}
totalOutForDelivery();
let delivered = document.getElementById("delivered");
let totalDelivered = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders/totaldeliveredorders");
  let data = await res.json();
  delivered.append(data);
}
totalDelivered();

let totalusers = document.getElementById("totalusers");
let totalUsersCount=async()=>{
  let res = await fetch("https://markdeals.up.railway.app/totalusers");
  let data = await res.json();
  totalusers.append(data);
}
totalUsersCount();

let totalproducts = document.getElementById("totalproducts");
let totalProductsCount =async()=>{
  let res = await fetch("https://markdeals.up.railway.app/totalproducts");
  let data = await res.json();
  totalproducts.append(data);
  getProduct(data);
}
totalProductsCount();

let cancelledorder = document.getElementById("cancelledorder");
let totalCancelledOrder = async()=>{
  let res = await fetch("https://markdeals.up.railway.app/orders/totalcancelledorders");
  let data = await res.json();
  cancelledorder.append(data);
}
totalCancelledOrder();

// ===================================Logout=============================
let logout = ()=>{
  window.location.href = "./index.html";
}