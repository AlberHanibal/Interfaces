package app;

public class Principal {
    
    public static void main(String[] args){

        System.out.println("Esta es mi sencilla calculadora que por ahora solo suma:");
        Calculadora c = new Calculadora();

        int sum=c.suma("2+2+2");
        System.out.println("El resultado de sumar 2+2+2 es "+sum);

        int res=c.resta("8-2-2");
        System.out.println("El resultado de restar 8-2-2 es "+res);

        int mul=c.mult("8*2*3*2");
        System.out.println("El resultado de multiplicar 8*2*3*2 es "+mul);
    }
}
