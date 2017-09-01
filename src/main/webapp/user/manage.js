
cargarUsuarios = function(){
    var promise = function(data){
        console.log(data)
    }
    $.get("/user/all").then(promise);
}

                $(document).ready(
                    function(){
                        cargarUsuarios();
                    }
                );