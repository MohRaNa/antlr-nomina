grammar nomina;

calculo: 'Calcular' '(' calculo_operacion ')' ;

calculo_operacion: 'salario_base' '=' FLOAT ',' 
                   'horas_trabajadas' '=' FLOAT ',' 
                   'tasa_impuestos' '=' FLOAT ',' 
                   'deducciones' '=' FLOAT;

FLOAT: [0-9]+ ('.' [0-9]+)? ;
WS: [ \t\r\n]+ -> skip ;
