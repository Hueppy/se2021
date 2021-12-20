<?php
require("../mysql.php");
session_start();
if(!isset($_SESSION["email"])){
  header("Location: index.php");
  exit;
}
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="../style.css">
    <meta charset="utf-8">
    <title>Suche - PfotenFreunde</title>
    <link rel="icon" type="image/x-icon" href="../img/favicon.png">
  </head>
  <body>
    <div class="flex-container">
      <div class="ContentLeft1">
        <p style="text-align:center;"><?php echo $_SESSION["email"]; ?></p>
        <a class="navbtns1 active" href="search.php">Search</a><br>
        <a class="navbtns2" href="friends.php">Friends</a><br>
        <a class="navbtns3" href="chat.php">Messages</a><br>
        <a class="navbtns4" href="profiles.php">Petprofiles</a><br>
        <a class="logout" href="logout.php">Logout</a>
        <a class="language" href="../profiles.php">In German!</a>
      </div>
      <div class="ContentMiddle1">
      </div>
      <div class="ContentRight1">
      </div>
    </div>
  </body>
</html>
