
package trabajo;


public class Control {

    public Control() {
    }
    
    //Método para corroborar que es un valor decimal que se puede pasar a una variable Double
    public boolean valorValidoDecimal(javax.swing.JTextField txt){
    
        for( int i = 0 ; i < txt.getText().length() ; i++)
            if( !Character.isDigit( txt.getText().charAt(i) ))
                if(txt.getText().charAt(i) != '.')
                    return false;                               //False por no contener sólo números y puntos
        
        int contadorDePuntos = 0;
        
        if((txt.getText().charAt(0) == '.') )
            return false;                                       //False por comenzar con un punto
        
        for( int i = 0 ; i < txt.getText().length() ; i++)
            if( txt.getText().charAt(i) == '.' )
                contadorDePuntos++;
            
        if(contadorDePuntos>1)
            return false;                                       //False por tener más de un punto
    
        return true;                                            // ES UN NÚMERO DECIMAL VÁLIDO !!!!
    }
 
    //Método que devuelve true si es un número
    public boolean esNumero(char letra){
        for(Integer i = 0 ; i <=9 ; i++)
            if( String.valueOf(i).equals(Character.toString(letra))  )
                return true;
        return false;
    }
    
    //Método que devuelve true si es vocal
    public boolean esVocal(char letra){
        if ((Character.toLowerCase(letra)=='a') || (Character.toLowerCase(letra)=='e') || (Character.toLowerCase(letra)=='i') ||
                (Character.toLowerCase(letra)=='o') || (Character.toLowerCase(letra)=='u'))
            return true;
        else
            return false;
    }
    
    //Método que devuelve FALSE si encuentra otro caracter que no sea letra MAYÚSCULA
    public boolean esSoloLetrasMayus(javax.swing.JTextField txt){
        for (int i = 0; i < txt.getText().length(); i++)
	{
		char caracter = txt.getText().charAt(i);
		int valorASCII = (int)caracter;
		if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
		return false; //Se ha encontrado un caracter que no es letra MAYÚSCULA
	}
        return true; //No encontró otra letra que no sea MAYÚSUCULA
    }
    
    //Método que devuelve true si el largo es mayor a i caracteres 
    public boolean validarLargo(javax.swing.JTextField txt,int i){
        if(txt.getText().length()>=i){
            return true;
        }else{
            return false;
        }
    }
    
    //Método para corroborar la repetición de letras
    public boolean seRepitenLetras(javax.swing.JTextField txt){
        
        for (int i = 0; i < (txt.getText().length()-1); i++)
	{
            for (int j = (i+1); j < (txt.getText().length()); j++)
                if(txt.getText().charAt(i)==txt.getText().charAt(j))
                    return true;    // Se repitió una letra
        }
        return false;
    }
    
    //Método que devuelve false si no es un Entero el dato
    public boolean esEntero(javax.swing.JTextField txt){
        
        for( int i = 0 ; i < txt.getText().length() ; i++)
            if( !Character.isDigit( txt.getText().charAt(i) ))
                return false;
        return true;
    }
   
}
