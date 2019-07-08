
package trabajo;


public class ControlIngresoTv extends Control{

    public ControlIngresoTv() {
    }
    
    
    //Excepción para validación del campo Marca
    public void validarTelevisorMarca(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Marca: Campo vacio");
        
        if(!validarLargo(txt,4)){
            throw new Excepciones("Marca: Debe ingresar al menos 4 caracteres");
        }
        
        if(!esSoloLetrasMayus(txt)){
            throw new Excepciones("Marca: Debe ingresar sólo letras MAYÚSCULAS");
        }
        
        if(seRepitenLetras(txt)){
            throw new Excepciones("Marca: No se pueden repetir las letras");
        }
    }
    
    //Excepción para validación del campo Modelo
    public void validarTelevisorModelo(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Modelo: Campo vacio");
        
        //6 caracteres
        if(txt.length()!=6)
            throw new Excepciones("Modelo: Debe contener 6 caracteres alfanuméricos");
        
        //Alfanuméricos
        for (int i = 0; i < txt.length(); i++)
	{
		char caracter = txt.charAt(i);
		int valorASCII = (int)caracter;

                if ( !((valorASCII >= 48 && valorASCII <= 57) || (valorASCII >= 65 && valorASCII <= 90) || (valorASCII >= 97 && valorASCII <= 122)
                        || valorASCII==164 || valorASCII==165) )
                    throw new Excepciones("Modelo: Debe contener 6 caracteres alfanuméricos");
        }
        
        //Primeras dos letras consonantes distintas
        //Los dos primeros caracteres son vocales o iguales?
        if( esVocal(txt.charAt(0)) || esVocal(txt.charAt(1)) || (txt.charAt(0))==txt.charAt(1))
            throw new Excepciones("Modelo: Las dos primeras letras deben ser consonantes y distintas");
        
        //Los dos primeros caracteres son numeros?
        if( esNumero(txt.charAt(0)) || esNumero(txt.charAt(1)) )
            throw new Excepciones("Modelo: Las dos primeras letras deben ser consonantes y distintas");
        
                Character letra_probar = '1';
        Integer numero = 2;
        String numeroEnString = numero.toString();
        String letraEnString = letra_probar.toString();
        
        
        if( numeroEnString.equals(letraEnString) )
            System.out.println("Son iguales");
        
        //Restantes caracteres deben ser números
        if(!esNumero(txt.charAt(2)) || !esNumero(txt.charAt(3)) || !esNumero(txt.charAt(4)) ||
                 !esNumero(txt.charAt(5)) )
            throw new Excepciones("Modelo: Luego de las dos consonantes debe ingresar números");   // alguno de ellos no es número
        
        //El primer número diferente de 0
        if(Character.toString(txt.charAt(2)).equals("0"))
            throw new Excepciones("Modelo: El primer número debe ser diferente a 0");
        
        int modelo_numeros [] = new int [4];
        modelo_numeros[0] = Integer.parseInt(Character.toString(txt.charAt(2)));   
        modelo_numeros[1] = Integer.parseInt(Character.toString(txt.charAt(3)));  
        modelo_numeros[2] = Integer.parseInt(Character.toString(txt.charAt(4)));
        modelo_numeros[3] = Integer.parseInt(Character.toString(txt.charAt(5)));
        
        //El último(cuarto - i=3) no puede ser par
        if( (modelo_numeros[3]%2) == 0)
            throw new Excepciones("Modelo: El último número no puede ser par");
        
        if( (modelo_numeros[0] + modelo_numeros[1] + modelo_numeros[2] + modelo_numeros[3]) > 20)
            throw new Excepciones("Modelo: La suma de los números debe ser menor a 20");
        
        int contador_sietes = 0;
        
        for(int i = 0 ; i < 4 ; i++)
            if( modelo_numeros[i] == 7)
                contador_sietes ++;
        if(contador_sietes == 0)
            throw new Excepciones("Modelo: Debe haber al menos un 7 entre los números");
            
    }
        
    
    //Excepción para validación del campo Pulgadas
    public void validarTelevisorPulgadas(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Pulgadas: Campo vacio");
        
        if(!esEntero(txt))
            throw new Excepciones("Pulgadas: Ingrese un valor entero");
                
        if( !(( Integer.parseInt(txt) >= 32 ) && ( Integer.parseInt(txt) <= 55 )) )
            throw new Excepciones("Pulgadas: Ingrese un valor entero entre 32 y 55");
        
    }
    
    //Excepción para validación del campo Nombre Empresa
    public void validarTelevisorEmpresaCable(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Empresa Cable: Campo vacio");
        
        if(!validarEmpresaCable(txt)){
            throw new Excepciones("Nombre Empresa: La primer letra debe ser mayúscula, y no contener más de 8 letras");
        }
        
    }
    
    //Excepción para validación del campo Nombre Empresa
    public boolean validarEmpresaCable(String txt){
    
        if(txt.length() > 8 || txt.isEmpty() )
            return false;
        
        if( !Character.isUpperCase(txt.charAt(0)) )
            return false;
        
        for( int i = 1 ; i < txt.length() ; i++){
            if( Character.isUpperCase(txt.charAt(i)) )
                return false;
        }
        
        return true;
    }
    
    //Excepción para validación del campo Valor
    public void validarTelevisorValor(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Valor: Campo vacio");
        
        if(!valorValidoDecimal(txt)){
            throw new Excepciones("Valor: El valor debe comenzar con un número y contener sólo un punto decimal");
        }
        
        if( (Double.parseDouble( txt)) > 1000 || (Double.parseDouble( txt)) == 0 )
            throw new Excepciones("Valor: El valor debe ser inferior a 1000");
    }
    
}
