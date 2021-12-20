<?php
require_once('../vendor/autoload.php');
session_start();
if(!isset($_SESSION["email"]) || !isset($_SESSION["pw"]) || !isset($_SESSION["id"])){
  header("Location: index.php");
  exit;
}
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="../style.css">
    <meta charset="utf-8">
    <title>Profile - PfotenFreunde</title>
    <link rel="icon" type="image/x-icon" href="../img/favicon.png">
  </head>
  <body>
    <?php
    if(isset($_POST["submit"])){
      $petApi = new OpenAPI\Client\Api\PetApi();
      $petApi->getConfig()
        ->setUsername($_SESSION['email'])
        ->setPassword($_SESSION['pw']);
      $pet = new OpenAPI\Client\Model\Pet();
      $pet
        ->setName($_POST["animalname"])
        ->setDescription($_POST["description"])
        ->setOwnerId($_SESSION["id"])
        ->setSpecies((int)($_POST["species"]));

      $petApi->petPost($pet);
      header("Location: profiles.php?success");
    }
    ?>
    <div class="flex-container">
      <div class="ContentLeft1">
        <div>
          <img style="object-fit: contain; width: 200px;" src="../img/logo.png" class="logo">
        </div>
        <a class="navbtns1" href="search.php">Search</a><br>
        <a class="navbtns2" href="friends.php">Friends</a><br>
        <a class="navbtns3" href="chat.php">Chat</a><br>
        <a class="navbtns4 active" href="profiles.php">Petprofiles</a><br>
        <a class="logout" href="logout.php">Logout</a><br>
        <a class="language" href="../profiles.php">In German!</a>
      </div>
        <div class="ContentMiddle1">
          <div class="Profiles">
              <form method="post" autocomplete="off">
                <input type="text" name="animalname" placeholder="Animalname" class="animalname" required><br>
                <textarea name="description" placeholder="Describe your pet! (Optional)" class="textarea" maxlength="70"></textarea>
                <p style="color: white;"><input type="radio" name="species" value="1" required>Dog
                <input type="radio" name="species" value="0">Cat
                <input type="radio" name="species" value="2">Elephant</p>
                <button type="submit" name="submit" class="submit">Upload</button>
            </form>
            <div class="tablediv">
              <table class="table">
                <thead>
                  <tr>
                    <th>Animalname</th>
                    <th>Description</th>
                  </tr>
                </thead>
              <tbody>
              <?php
                $personApi = new OpenAPI\Client\Api\PersonApi();
                $personApi->getConfig()
                  ->setUsername($_SESSION['email'])        
                  ->setPassword($_SESSION['pw']);
                $pets = $personApi->personIdPetsGet($_SESSION["id"]);

                    foreach($pets as $pet){
                      echo "<tr><td>{$pet->getName()}</td><td>{$pet->getDescription()}</td></tr>\n";    
                  }
               ?>
              </tbody>
              </table>
            </div>
          </div>
        </div>
    </div>
  </body>
</html>

