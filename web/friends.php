<?php
require_once(__DIR__ . '/vendor/autoload.php');
session_start();
if(!isset($_SESSION["email"]) || !isset($_SESSION["pw"]) || !isset($_SESSION["id"])){
  header("Location: index.php");
  exit;
}
if(isset($_POST["submitaccept"])){
  $queryaccept = $mysql->prepare("INSERT INTO friend (initiator_id, partner_id) VALUES (:initiator, :partner)");
  $queryaccept->bindParam(":initiator", $_POST["initiator"]);
  $queryaccept->bindParam(":partner", $_POST["partner"]);
  $querycleanup = $mysql->prepare("DELETE FROM friend_request WHERE sender_id = :initiator AND receiver_id = :partner");
  $querycleanup->bindParam(":initiator", $_POST["initiator"]);
  $querycleanup->bindParam(":partner", $_POST["partner"]);

  $queryaccept->execute();
  $querycleanup->execute();

}else {
}
if(isset($_POST["submitdecline"])){
  $querycancel = $mysql->prepare("DELETE FROM friend_request WHERE sender_id = :initiator AND receiver_id = :partner");
  $querycancel->bindParam(":initiator", $_POST["initiator"]);
  $querycancel->bindParam(":partner", $_POST["partner"]);

  $querycancel->execute();
}else {
}

?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="style.css">
    <meta charset="utf-8">
    <title>Freunde - PfotenFreunde</title>
    <link rel="icon" type="image/x-icon" href="img/favicon.png">
  </head>
  <body>
    <div class="flex-container">
      <div class="ContentLeft1">
        <a class="navbtns1" href="search.php">Suche</a><br>
        <a class="navbtns2 active" href="friends.php">Freunde</a><br>
        <a class="navbtns3" href="chat.php">Nachrichten</a><br>
        <a class="navbtns4" href="profiles.php">Haustierprofile</a><br>
        <a class="logout" href="logout.php">Logout</a><br>
        <a class="language" href="en/profiles.php">Auf Englisch!</a>
      </div>
      <div class="ContentMiddle1">
        <?php
        $receiver = $_SESSION["id"];

        $query = $mysql->prepare("SELECT * FROM friend_request WHERE receiver_id = $receiver");
        $query->execute();
        $requests = $query->fetchAll();
        foreach($requests as $req){
          $sender = $req["sender_id"];
          $stmt = $mysql->prepare("SELECT name FROM user WHERE id = $sender");
          $stmt->execute();
          $names = $stmt->fetchAll();
          foreach($names as $name){
            ?>
            <div class="forms">
              <form method="post">
                <input type="hidden" name="initiator" value="<?php echo $sender; ?>">
                <input type="hidden" name="partner" value="<?php echo $receiver; ?>">
                <input type="submit" class="submitbtn" name="submitaccept" value="<?php echo $name["name"]; ?>'s Anfrage annehmen">
              </form>
              <form method="post">
                <input type="hidden" name="initiator" value="<?php echo $sender; ?>">
                <input type="hidden" name="partner" value="<?php echo $receiver; ?>">
                <input type="submit" class="submitbtn" name="submitdecline" value="<?php echo $name["name"]; ?>'s Anfrage ablehnen">
              </form>
            </div>
              <?php
            }
          }
          ?>
      </div>
    </div>
  </body>
</html>
