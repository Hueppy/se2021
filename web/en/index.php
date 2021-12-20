<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="../style.css">
    <script src="../myScript.js"></script>
    <meta charset="utf-8">
    <title>Login - PfotenFreunde</title>
    <link rel="icon" type="image/x-icon" href="../img/favicon.png">
  </head>
  <body>
    <?php
    if(isset($_POST["submit"])){
      require("../mysql.php");
      $stmt = $mysql->prepare("SELECT * FROM login WHERE email = :email");
      $stmt->bindParam(":email", $_POST["email"]);
      $stmt->execute();
      $count = $stmt->rowCount();
      if($count == 1){
        $row = $stmt->fetch();
        if(password_verify($_POST["pw"], $row["password_hash"])){
          session_start();
          $_SESSION["email"] = $row["email"];
          header("Location: profiles.php");
        }else{
          echo '<span style="color:white;">Login failed!</span>';
        }

      }else{
          echo '<span style="color:white;">Login failed!</span>';
      }
    }
    ?>
    <div class="loginform">
      <img src="../img/logo.png" class="logo">
      <h1 class="txt-h1">Login</h1>
      <form action="index.php" method="post" autocomplete="off">
        <input type="email" name="email" placeholder="E-Mail Address" class="email" maxlength="18" required><br>
        <input type="password" name="pw" placeholder="Password" class="pw" required><br>
        <button type="submit" name="submit" class="formsubmit">Login</button>
      </form>
      <br>
      <p class="txt-p1">Not a member yet? <a href="register.php" class="hyperlinks"> Register</a></p>
      <div class="dropdown">
        <button onclick="myFunction()" class="dropbtn">Language</button>
        <div id="myDropdown" class="dropdown-content">
          <a href="../index.php">German</a>
        </div>
      </div>
    </div>
  </body>
</html>
