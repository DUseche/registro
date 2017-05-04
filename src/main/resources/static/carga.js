cargarProgramas = function(){
    var promise = function(data){
        console.log(data);
        $("#programas").children().remove();
        for(i = 0; i < data.length; i++){
            $("#programas").append("<li id='"+data[i].name+"'>"+data[i].name+"</li>");
        }
    }
    $.get("/programs").then(promise);
};

$(document).ready(
    function(){
        cargarProgramas();
    }
);