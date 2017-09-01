            var listaProgramas =[];

            function cambiarPagina(number){
                sessionStorage.programa = listaProgramas[number];
                window.location.href = "verPrograma.html";
            }

            cargarProgramas = function(){
                var promise = function(data){
                    console.log(data);

                    $("#programas").children().remove();
                    for(i = 0; i < data.length; i++){
                        listaProgramas.push(data[i].name);
                        $("#programas").append("<li>\n<button class='customButton' type='button' onclick='cambiarPagina("+i+")'>\n"+data[i].name+"\n</button>\n</li><p></p>");
                    }
                }
                $.get("/programs").then(promise);
            }

            function Program(name){
                this.name = name
            }

            registrarPrograma = function(){
                var name = $("#nuevoPrograma").val();
                var program = new Program(name);
                $.ajax({
                    type: "POST",
                    url: "/programs",
                    headers: {"X-HTTP-Method-Override": "POST", "Content-Type": "application/json"},
                    data: JSON.stringify(program)
                }).fail(function (response) {
                    console.log(response);
                    alert(response.responseText);
                }).then(function (){
					alert("Programa añadido");
					cargarProgramas();
				});
            }

            $(document).ready(
                function(){
                    cargarProgramas();
                }
            )