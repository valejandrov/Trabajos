
package trabajo;


public class ControlIngresoCam extends Control{

    public ControlIngresoCam() {
    }
    
    //Excepción para validación del campo Marca
    public void validarCamaraCodigo(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Código: Campo vacio");
        
        switch (validarCodigo(txt)) {
            case 1:
                    throw new Excepciones("Código: Debe contener 4 letras mayúsculas y 3 números");
            case 2:
                    throw new Excepciones("Código: Sólo ingresar letras mayúsculas y números");
            case 3:
                    throw new Excepciones("Código: Debe contener 4 letras mayúsculas");
            case 4:
                    throw new Excepciones("Código: Debe contener sólo 2 vocales diferentes");
            case 5:
                    throw new Excepciones("Código: Debe contener sólo 2 consonantes diferentes");
            case 6:
                    throw new Excepciones("Código: Debe contener 3 números diferentes");
            default:
                System.out.println("Codigo Sin errores");
        }
    }
    
    //Excepción para validación del campo Modelo
    public void validarCamaraModelo(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Modelo: Campo vacio");
        
        //interior 3434
        //Buscamos un espacio
        String comparar1,comparar2;
        
        if( txt.indexOf(' ') == -1)
            throw new Excepciones("Modelo: No se ingresaron dos palabras");
        
        comparar1 = txt.substring(0,txt.indexOf(' '));
        
        if(!(comparar1.equals("Interior") || comparar1.equals("Exterior")))
            throw new Excepciones("Modelo: Debe comenzar con la palabra Interior o Exterior");
        
        comparar2 = txt.substring(txt.indexOf(' ')+1,txt.length());
        
        if(comparar2.length() == 0 )
            throw new Excepciones("Modelo: Ingrese la segunda palabra");
            
        for( int i = 0 ; i < comparar2.length() ; i++)
            if( !Character.isLetter(comparar2.charAt(i)) )
                throw new Excepciones("Modelo: La segunda palabra sólo debe contener letras");
        
        if(comparar2.length() > 7 )
            throw new Excepciones("Modelo: La segunda palabra excede los 7 caracteres");
        
        if( ( (comparar2.contains("H")) || (comparar2.contains("W")) || (comparar2.contains("F")) ||
                (comparar2.contains("h")) || (comparar2.contains("w")) || (comparar2.contains("f")) ) )
            throw new Excepciones("Modelo: La segunda palabra no debe contener las letras H W F h w f");    
        
    }
    
    //Excepción para validación del campo Giro
    public void validarCamaraGiro(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Giro: Campo vacio");
        
        for( int i = 0 ; i < txt.length() ; i++)
            if( !Character.isDigit( txt.charAt(i) ))
                throw new Excepciones("Giro: Ingresar sólo números");
        
        if( !((Integer.parseInt(txt) >= 0) && (Integer.parseInt(txt) <= 360)))
            throw new Excepciones("Giro: Ingresar un número entre 0 y 360");
    }
    
    //Excepción para validación del campo MegaPixeles
    public void validarCamaraMegaPixeles(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Megapixeles: Campo vacio");
        
        for( int i = 0 ; i < txt.length() ; i++)
            if( !Character.isDigit( txt.charAt(i) ))
                if(txt.charAt(i) != '.')
                    throw new Excepciones("Megapixeles: Ingresar un número decimal positivo");
        
        int contadorDePuntos = 0;
        
        if((txt.charAt(0) == '.') )
            throw new Excepciones("Megapixeles: El primer dato debe ser un número");
        
        for( int i = 0 ; i < txt.length() ; i++)
            if( txt.charAt(i) == '.' )
                contadorDePuntos++;
            
        if(contadorDePuntos>1)
            throw new Excepciones("Megapixeles: Ingresar un sólo punto");
        
        Double numero;
                
        numero = Double.valueOf(txt);
        if( !(numero >= 5.0 && numero <= 16.3))
                throw new Excepciones("Megapixeles: Ingresar un número decimal positivo entre 5.0 y 16.3");
    }

    //Excepción para validación del campo Alcance Wifi
    public void validarCamaraAlcanceWifi(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Alcance Wifi: Campo vacio");
        
        for( int i = 0 ; i < txt.length() ; i++)
            if( !Character.isDigit( txt.charAt(i) ))
                if(txt.charAt(i) != '.')
                    throw new Excepciones("Alcance Wifi: Ingresar un número decimal positivo");
        
        int contadorDePuntos = 0;
        
        if((txt.charAt(0) == '.') )
            throw new Excepciones("Alcance Wifi: El primer dato debe ser un número");
        
        for( int i = 0 ; i < txt.length() ; i++)
            if( txt.charAt(i) == '.' )
                contadorDePuntos++;
            
        if(contadorDePuntos>1)
            throw new Excepciones("Alcance Wifi: Ingresar un sólo punto");
        
        Double numero;
                
        numero = Double.valueOf(txt);
        if( !(numero >= 3.0 && numero <= 14.0))
                throw new Excepciones("Alcance Wifi: Ingresar un número decimal positivo entre 3.0 y 14.0");
    }    
    
    //Excepción para validación del campo Valor
    public void validarCamaraValor(String txt) throws Excepciones{
        
        if(txt.isEmpty())
            throw new Excepciones("Valor: Campo vacio");
        
        if(!this.valorValidoDecimal(txt))
            throw new Excepciones("Valor: El valor debe comenzar con un número y contener sólo un punto decimal");
        
        if( (Double.parseDouble( txt )) < 100 )
            throw new Excepciones("Valor: El valor debe ser mayor a 100");
            
        
    }
    
    //Método para validar el codigo
    private int validarCodigo(String txt){
        
        int contadorMayusculas = 0;
        int contadorNumeros = 0;
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        char vocales[] = new char[4];
        char consonantes[] = new char[4];
        
        
        //Validando 7 caracteres
        if(txt.length() != 7)
            return 1;
        
        //Validando letras y dígitos
        for( int i = 0 ; i < txt.length() ; i++){
            if( !Character.isLetterOrDigit(txt.charAt(i)) )
                return 2; //tiene caracteres especiales
        }
        
        //Validando las 4 letras mayúsculas y 2 vocales y 2 consontantes
        for( int i = 0 ; i < txt.length() ; i++){
            if( Character.isUpperCase(txt.charAt(i)) )
            {
                contadorMayusculas++;
                if(esVocal(txt.charAt(i))){
                    contadorVocales++;
                    vocales[contadorVocales-1]=txt.charAt(i);
                }
                else{
                    contadorConsonantes++;
                    consonantes[contadorConsonantes-1]=txt.charAt(i);
                }
            }
        }
            if( contadorMayusculas != 4 )
                return 3;
            if( !(( contadorVocales == 2 ) && ( vocales[0] != vocales[1] )))
                return 4;
            if( !((contadorConsonantes == 2 ) && ( consonantes[0] != consonantes[1] )) )
                return 5;
            
      
        char numeros[] = new char[4]; //Si llegó hasta aquí es porque tenemos 3 números
        
        //Validando los 3 numeros
        for( int i = 0 ; i < txt.length() ; i++){
            if( esNumero(txt.charAt(i)) ){
                contadorNumeros++;
                numeros[contadorNumeros] = txt.charAt(i); 
            }
        }
        contadorNumeros = 0;
        for(int i = 0 ; i < 2 ; i++)
                if(Character.toString(numeros[i]).equals(Character.toString(numeros[i+1])))
                    contadorNumeros++;
        if(Character.toString(numeros[1]).equals(Character.toString(numeros[2])))
            contadorNumeros++;
        if(contadorNumeros>0)
            return 6;
            
        return 0;   //Sin errores
    }
    
 
}
