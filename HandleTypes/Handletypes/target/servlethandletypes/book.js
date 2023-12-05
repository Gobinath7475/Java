let updateIndex = 0;
let books = [];
 
function getItems() {
    $.ajax({
        url: "http://localhost:8080/app/book",
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            _displayItems(data);
 
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
 
function _displayItems(data) {
    const tBody = document.getElementById("books");
    tBody.innerHTML = "";
 
    const button = document.createElement("button");
 
 
    data.forEach((item) => {
        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `editItem(${item.id})`);
 
        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `deleteItem(${item.id})`);
 
        let tr = tBody.insertRow();
 
        let td1 = tr.insertCell(0);
        let id = document.createTextNode(item.id);
        td1.appendChild(id);
 
        let td2 = tr.insertCell(1);
        let title = document.createTextNode(item.title);
        td2.appendChild(title);
 
        let td3 = tr.insertCell(2);
        let author = document.createTextNode(item.author);
        td3.appendChild(author);
 
        let td4 = tr.insertCell(3);
        let price = document.createTextNode(item.price);
        td4.appendChild(price);
 
        let td5 = tr.insertCell(4);
        td5.appendChild(editButton);
 
        let td6 = tr.insertCell(5);
        td6.appendChild(deleteButton);
 
    })
    books = data;
}
 
function saveORupdateItem() {
    if (document.getElementById("myBtn").innerHTML == "Save") {
        addItem();
    } else {
        updateItem();
    }
}
 
function addItem() {
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const price = document.getElementById("price").value;
 
    const item = {
        id: 0,
        title: title,
        author: author,
        price: price,
    };
 
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/app/book",
        data: JSON.stringify(item),
        success: function (result) {
            getItems();
        },
        error: function (result) {
            alert("msg");
        },
    });
}
 
function editItem(id) {
    document.getElementById("myBtn").innerHTML = "Update";
    const item = books.find((item) => item.id === id);
    document.getElementById("title").value = item.title;
    document.getElementById("author").value = item.author;
    document.getElementById("price").value = item.price;
    updateIndex = id;
}
function updateItem() {
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const price = document.getElementById("price").value;
 
    const item = {
        id: updateIndex,
        title: title,
        author: author,
        price: price,
    };
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/app/book",
        data: JSON.stringify(item),
        success: function (result) {
            getItems();
            document.getElementById("myBtn").innerHTML = "Save";
            document.getElementById("title").value = "";
            document.getElementById("author").value = "";
            document.getElementById("price").value = "";
            updateIndex = 0;
        },
        error: function (result) {
            alert("msg");
        },
    });
}
 
function deleteItem(id) {
    const item = {
      id: id,
      title: "",
      author:"",
      price:0
    };
    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/app/book",
      data: JSON.stringify(item),
      success: function (result) {
        getItems();
      },
      error: function (result) {
        alert("msg");
      },
    });
  }