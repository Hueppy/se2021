<?php
require_once(__DIR__ . '/vendor/autoload.php');
session_start();
if(!isset($_SESSION["email"]) || !isset($_SESSION["pw"]) || !isset($_SESSION["id"])){
  header("Location: index.php");
  exit;
}
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="style.css">
    <meta charset="utf-8">
    <title>Chat - PfotenFreunde</title>
    <link rel="icon" type="image/x-icon" href="img/favicon.png">
  </head>
  <body>
    <div class="flex-container">
      <div class="ContentLeft1">
        <a class="navbtns1" href="search.php">Suche</a><br>
        <a class="navbtns2" href="friends.php">Freunde</a><br>
        <a class="navbtns3 active" href="chat.php">Nachrichten</a><br>
        <a class="navbtns4" href="profiles.php">Haustierprofile</a><br>
        <a class="logout" href="logout.php">Logout</a><br>
        <a class="language" href="en/profiles.php">Auf Englisch!</a>
      </div>
      <div class="ContentMiddle1">
      </div>
    </div>
  </body>
</html>
