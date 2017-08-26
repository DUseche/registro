
function User(user, pass){
    this.username=user;
    this.password=pass;
}

            autenticar = function(){
                var user=$("#username").val();
                var pass=$("#password").val();
                var usuario = new User(user,pass);
                //alert(JSON.stringify(usuario))
                $.ajax({
                    type: "POST",
                    url: "/auth",
                    headers: {"X-HTTP-Method-Override": "POST", "Content-Type": "application/json"},
                    data: JSON.stringify(usuario)
                }).fail(function (response) {
                    alert("Error al loguear");
                }).then(cambiarPagina());
            }
     function cambiarPagina(){
        alert("Todo bien")
        window.location.href = "home.html";
     }
