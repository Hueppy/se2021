<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="../style.css">
    <script src="../myScript.js"></script>
    <meta charset="utf-8">
    <title>Registration - PfotenFreunde</title>
    <link rel="icon" type="image/x-icon" href="../img/favicon.png">
  </head>
  <body>
    <?php
    if(isset($_POST["submit"])){
      require("../mysql.php");
      $stmtuser = $mysql->prepare("SELECT * FROM user WHERE name = :user");
      $stmtuser->bindParam(":user", $_POST["username"]);
      $stmtuser->execute();
      $count = $stmtuser->rowCount();
      if($count == 0){
        if($_POST["pw"] == $_POST["pw2"]){
          $stmtaddress = $mysql->prepare("INSERT INTO address (street, zip, city) VALUES (:street, :zip, :city)");
          $stmtaddress->bindParam(":street", $_POST["street"]);
          $stmtaddress->bindParam(":zip", $_POST["zip"]);
          $stmtaddress->bindParam(":city", $_POST["city"]);

          $stmtlogin = $mysql->prepare("INSERT INTO login (email, password_hash) VALUES (:email, :pw)");
          $stmtlogin->bindParam(":email", $_POST["email"]);
          $hash = password_hash($_POST["pw"], PASSWORD_BCRYPT);
          $stmtlogin->bindParam(":pw", $hash);

          $stmtuser = $mysql->prepare("INSERT INTO user (name, telephone, email, address_id) VALUES (:user, :telephone, (SELECT email FROM login ORDER BY email ASC LIMIT 1), (SELECT id FROM address ORDER BY id DESC LIMIT 1))");
          $stmtuser->bindParam(":user", $_POST["username"]);
          $stmtuser->bindParam(":telephone", $_POST["telephone"]);

          $stmtinstitution = $mysql->prepare("INSERT INTO institution (id, homepage) VALUES ((SELECT id FROM user ORDER BY id DESC LIMIT 1), :homepage)");
          $stmtinstitution->bindParam(":homepage", $_POST["homepage"]);

          $stmtperson = $mysql->prepare("INSERT INTO person (id, surname, age, sex, institution_id) VALUES ((SELECT id FROM user ORDER BY id DESC LIMIT 1), :surname, :age, :sex, (SELECT id FROM institution ORDER BY id DESC LIMIT 1))");
          $stmtperson->bindParam(":surname", $_POST["surname"]);
          $stmtperson->bindParam(":age", $_POST["age"]);
          $stmtperson->bindParam(":sex", $_POST["sex"]);


          $stmtaddress->execute();
          $stmtlogin->execute();
          $stmtuser->execute();
          $stmtinstitution->execute();
          $stmtperson->execute();
          $message = 'Account was created!';
        }else{
          echo '<span style="color:white;">Passwords dont match!</span>';
        }
      }else {
        echo '<span style="color:white;">Username already exists!</span>';
      }
      $message = urlencode($message);
      header("Location: index.php?$message");
    }
    ?>
    <div class="loginform">
      <img src="../img/logo.png" class="logo">
      <h1 class="txt-h1">Create Account</h1>
      <form action="register.php" method="post" autocomplete="off">
        <input type="text" name="username" placeholder="Username" class="name" maxlength="18" required><br>
        <input type="password" name="pw" placeholder="Password" class="pw" required><br>
        <input type="password" name="pw2" placeholder="Repeat password" class="pw" required><br>
        <button type="submit" name="submit" class="formsubmit">Register</button>
      </form>
      <br>
      <p class="txt-p1">Already have an account? <a href="index.php" class="hyperlinks">Login</a></p>
      <div class="dropdown">
        <button onclick="myFunction()" class="dropbtn">Language</button>
        <div id="myDropdown" class="dropdown-content">
          <a href="../register.php">German</a>
        </div>
      </div>
    </div>
  </body>
</html>
