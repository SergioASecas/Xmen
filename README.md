# Xmen
Backend para detectar mutantes


1. Seleccionar el servicio "http://localhost:8090/api/mutant/" 

2. Mediante el método POST enviar en formato JSON la secuencia de Strings de ADN. 

EJ: 
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

El servicio devolverá httpStatus 200 si es mutante, ó httpStatus 403 si no lo es. 
