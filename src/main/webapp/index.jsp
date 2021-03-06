<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">DML Warehouse</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="http://localhost:2018/warehousePro/uom/create">Uom</a></li>
      <li><a href="http://localhost:2018/warehousePro/order/create">OrderMethod</a></li>
      <li><a href="http://localhost:2018/warehousePro/shipment/create">ShipmentType</a></li>
      <li><a href="http://localhost:2018/warehousePro/item/create">Item</a></li>
      <li><a href="http://localhost:2018/warehousePro/vendor/create">Vendor</a></li>
      <li><a href="http://localhost:2018/warehousePro/customer/create">Customer</a></li>
      <li><a href="http://localhost:2018/warehousePro/user/create">WhUserType</a></li>
      <li><a href="http://localhost:2018/warehousePro/purchaseorder/create">PurchaseOrder</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  <h3>Inverted Navbar</h3>
  <p>An inverted navbar is black instead of gray.</p>
</div>

</body>
</html>
