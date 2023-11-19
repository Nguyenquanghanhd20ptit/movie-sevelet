<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>



<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Mục Sản Phẩm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        #product-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            padding: 20px;
        }

        .product-card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 15px;
            padding: 20px;
            width: 300px;
            text-align: center;
            transition: transform 0.3s;
        }

        .product-card:hover {
            transform: scale(1.05);
        }

        .product-image {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
            margin-bottom: 10px;
        }

        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
            z-index: 1;
        }

        .form-container {
            display: none;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
            position: relative;
            z-index: 2;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        #cancelButton {
            background-color: #f44336;
        }

        #cancelButton:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <header>
        <h1>Danh sách phim</h1>
    </header>

    <div id="product-container">
        
       <% 
        List<Category> categoryList = (List<Category>)request.getAttribute("categoryList");
        for (Category category : categoryList) {
    %>
        <div class="product-card">
            <img class="product-image" src="<%= category.getImage() %>" alt="Product">
            <h2><%= category.getName() %></h2>
            <p><%= category.getType() %></p>
            <p>Giá vé: <%= category.getPrice() %> vnd</p>
            <button onclick="showForm('<%= category.getName() %>', <%= category.getPrice() %>)">Đặt vé</button>
        </div>
    <%
        }
    %>
    <div class="overlay" id="overlay">
        <div class="form-container" id="formContainer">
            <form>
                <label for="name">Tên phim:</label> <p id="tenphim" name="name"></p>
                
                <label for="price">Giá vé:</label> <p id="giave" name="price"></p>

                <label for="seat">Chọn Ghế:</label>
                <select id="seat" name="seat">
                    <option value="vip">VIP</option>
                    <option value="standard">Thường</option>
                </select><br><br>

                <label for="cinema">Chọn Rạp:</label>
                <select id="cinema" name="cinema">
                    <option value="cinema1">Rạp 1</option>
                    <option value="cinema2">Rạp 2</option>
                </select><br><br>

                <button type="button" onclick="confirmBooking()">Xác Nhận</button>
                <button type="button" id="cancelButton" onclick="cancelBooking()">Hủy</button>
            </form>
        </div>
    </div>

    <script>
        function showForm(productName, price) {
            var overlay = document.getElementById('overlay');
            var formContainer = document.getElementById('formContainer');
            
            overlay.style.display = 'flex';
            formContainer.style.display = 'block';
            document.getElementById('tenphim').innerHTML = productName;
            document.getElementById('giave').innerHTML = price;
            
            
        }

        function confirmBooking() {
            var name = document.getElementById('tenphim').innerHTML;
            var giave = document.getElementById('giave').innerHTML;
            var seat = document.getElementById('seat').value;
            var cinema = document.getElementById('cinema').value;

            alert(`Đặt vé thành công!\nTên: ${name}\nGía vé: ${giave}\nGhế: ${seat}\nRạp: ${cinema}`);
         
            document.getElementById('overlay').style.display = 'none';
            document.getElementById('formContainer').style.display = 'none';
        }

        function cancelBooking() {
           
            document.getElementById('overlay').style.display = 'none';
            document.getElementById('formContainer').style.display = 'none';
        }

       

    </script>
</body>
</html>
