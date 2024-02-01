package app;

public class Calculadora {

  public int suma(String expression) throws java.lang.NumberFormatException{
    int sum = 0;
    for (String operando : expression.split("\\+"))
      sum += Integer.valueOf(operando);
    return sum;
  }


  public int resta(String expression) throws java.lang.NumberFormatException{
    int res = 0;
    int n=0;
    for (String operando : expression.split("\\-")) {
      if (n == 0) {
        res = Integer.valueOf(operando);
      } else {
        res -= Integer.valueOf(operando);
      }
      n++;
    }
    return res;
  }

  
  public int mult(String expression) throws java.lang.NumberFormatException{
    int res = 0;
    for (String operando : expression.split("\\*")) {
      if (res == 0) {
        res = Integer.valueOf(operando);
      } else {
        res *= Integer.valueOf(operando);
      }
    }
    return res;
  }

}
