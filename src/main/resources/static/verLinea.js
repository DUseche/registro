
                var listaMaterias = [];

                function modificarMateria(number){
                    sessionStorage.materia = listaMaterias[number];
                    window.location.href = "modificarMateria.html";
                }

                cargarMaterias = function(){
                    var promise = function(data){
                        console.log(data);
                        $("#materias").children().remove();
                        for(i = 0; i < data.courses.length; i++){
                            listaMaterias.push(data.courses[i].name);
                            $("#materias").append("<li>\n<button type='button' onclick='modificarMateria("+i+")'>\n"+data.courses[i].name+"\n</button>\n</li>");
                        }
                    }
                    $.get("/programs/"+sessionStorage.programa+"/"+sessionStorage.linea).then(promise);
                };

                registrarMateria = function(){
                    window.location.href = "nuevaMateria.html"
                };

                function Line(name){
                    this.name=name
                }

                actualizarLinea = function(){
                    var name = $("#nuevoNombre").val();
                    var line = new Line(name);
                    $.ajax({
                        type: "PUT",
                        url: "/programs/"+sessionStorage.programa+"/"+sessionStorage.linea,
                        headers: {"X-HTTP-Method-Override": "PUT", "Content-Type": "application/json"},
                        data: JSON.stringify(line)
                    }).fail(function (response) {
                        console.log(response);
                        alert(response.responseText);
                    });
                }

            regresar = function(){
                window.location.href = "verPrograma.html";
            }
                $(document).ready(
                    function(){
                        if(sessionStorage.programa == null || sessionStorage.linea == null){
                            window.location.href = "home.html";
                        }
                        cargarMaterias();
                    }
                );