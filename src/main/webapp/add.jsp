<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un projet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Ajouter un nouveau projet</h1>
    <form action="save" method="post">
        <label for="nom">Nom :</label>
        <input type="text" name="nom" required /><br />
        <br><label for="description">Description :</label>
        <textarea name="description" required></textarea><br />
         <br><label for="image">Image link :</label>
        <input type="text" name="image" /><br />
         <br><button type="submit"  class="btn btn-success">Enregistrer</button>
    </form>
</body>
</html>
