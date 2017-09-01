
            function Course(objective, name, studyPlans, mnemonicCode, numericCode, justification, requisites, methodology, evaluation, weeklyIntensity, bibliography, credits, pragmaticContent) {
                this.objective = objective;
                this.name = name;
                this.studyPlans = studyPlans;
                this.mnemonicCode = mnemonicCode;
                this.numericCode = numericCode;
                this.justification = justification;
                this.requisites = requisites;
                this.methodology = methodology;
                this.evaluation = evaluation.evaluate;
                this.weeklyIntensity = weeklyIntensity.intensity;
                this.bibliography = bibliography.books;
                this.credits = credits.creditHours;
                this.pragmaticContent = pragmaticContent.pragCont;
            }

            function Evaluation(noteOnePercent, noteTwoPercent, noteThreePercent, noteLabPercent) {
                this.evaluate = {"noteOnePercent":noteOnePercent,"noteTwoPercent":noteTwoPercent,"noteThreePercent":noteThreePercent,"noteLabPercent":noteLabPercent};
            }

            function WeeklyIntensity(magistral, monitor, lab) {
                this.intensity = {"magistral":magistral, "monitor":monitor, "lab":lab};
            }

            function Bibliography(principalText, otherTexts) {
                this.books = {"principalText":principalText, "otherTexts":otherTexts};
            }

            function Credits(magistral, independent) {
                this.creditHours = {"magistral":magistral, "independent":independent};
            }

            function PragmaticContent(summary, detailedThemes) {
                this.pragCont = {"summary":summary,"detailedThemes":detailedThemes};
            }

            registrarCurso= function(){
                var evaluacion = new Evaluation($("#notaPrimerTeoria").val(),$("#notaSegundoTeoria").val(),$("#notaTerceroTeoria").val(),$("#notaLaboratorio").val());
                var intensidadSemanal = new WeeklyIntensity($("#magistral").val(),$("#monitoria").val(),$("#laboratorio").val());
                var bibliografia = new Bibliography($("#textoPrincipal").val(),$("#otrosTextos").val());
                var creditos = new Credits($("#horasPresenciales").val(), $("#horasIndependientes").val());
                var contenido = new PragmaticContent($("#resumenContenido").val(),$("#contenidoDetallado").val());
                var name = $("#name").val();
                var plans = $("#studyPlans").val();
                var nemonico = $("#mnemonic").val();
                var codigo = $("#numeric").val();
                var objetivoMateria = $("#objetivo").val();
                var justificacion = $("#justificacion").val();
                var requisitos = $("#requisitos").val();
                var metodo = $("#metodologia").val();

                var curso = new Course(objetivoMateria, name, plans,nemonico,codigo,justificacion,requisitos,metodo,evaluacion,intensidadSemanal,bibliografia,creditos,contenido);
                console.log(JSON.stringify(curso));

                    $.ajax({
                        type: "POST",
                        url: "/programs/"+sessionStorage.programa+"/"+sessionStorage.linea,
                        headers: {"X-HTTP-Method-Override": "POST", "Content-Type": "application/json"},
                        data: JSON.stringify(curso)
                    }).fail(function (response) {
                        console.log("Error al agregar");
                        alert("Error al agregar");
                    }).then(function(){
                        alert("Materia agregada");
                    });
            }

            regresar = function(){
                window.location.href = "verLinea.html";
            }

            $(document).ready(
                function(){
                    if(sessionStorage.programa == null || sessionStorage.linea == null){
                        window.location.href = "home.html";
                    }
                    $("#departamento").children().remove();
                    $("#departamento").append("Departamento: "+sessionStorage.programa+"<p>");
                }
            )