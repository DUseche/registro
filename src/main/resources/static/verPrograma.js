            var listaLineas = [];

            function cambiarPagina(number){
                sessionStorage.linea = listaLineas[number];
                window.location.href = "verLinea.html";
            }

            cargarLineas = function(){
                var promise = function(data){
                    console.log(data);
                    $("#lineas").children().remove();
                    for(i = 0; i < data.lines.length; i++){
                        listaLineas.push(data.lines[i].name);
                        $("#lineas").append("<li>\n<button type='button' onclick='cambiarPagina("+i+")'>\n"+data.lines[i].name+"\n</button>\n</li>");
                    }
                }
                $.get("/programs/"+sessionStorage.programa).then(promise);
            };

            function Line(name){
                this.name=name
            }

            registrarLinea = function(){
                var name = $("#nuevaLinea").val();
                var line = new Line(name);
                $.ajax({
                    type: "POST",
                    url: "/programs/"+sessionStorage.programa,
                    headers: {"X-HTTP-Method-Override": "POST", "Content-Type": "application/json"},
                    data: JSON.stringify(line)
                }).fail(function (response) {
                    console.log(response);
                    alert(response.responseText);
                }).then(cargarLineas());
            };

            function Program(name){
                this.name = name
            }

            actualizarPrograma = function(){
                var name = $("#nuevoNombre").val();
                var program = new Program(name);
                $.ajax({
                    type: "PUT",
                    url: "/programs/"+sessionStorage.programa,
                    headers: {"X-HTTP-Method-Override": "PUT", "Content-Type": "application/json"},
                    data: JSON.stringify(program)
                }).fail(function (response) {
                        console.log("Error al agregar");
                        alert("Error al agregar");
                });
            }

            regresar = function(){
                window.location.href = "home.html";
            }
            $(document).ready(
                function(){
                    if(sessionStorage.programa == null){
                        window.location.href = "home.html";
                    }
                    cargarLineas();
                }
            );