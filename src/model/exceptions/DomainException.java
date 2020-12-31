package model.exceptions;

public class DomainException extends RuntimeException { 
  /*Run é um tipo de exceção que o compilador não obriga a tratar. 
  Poderia ser Exception, que nesse caso obriga o tratamento igual ao ParseException*/

private static final long serialVersionUID = 1L; // quando a classe é serializable é obrigado a gerar um número de série

  public DomainException(String msg) { 
    /* esse construtor permiti instanciar o Domain (que é a exceção personalizada) passando uma msg pra ela
    fincando armazendada dentro da exceção*/
    super(msg); // repassando a mensagem para o construtor da super classe
  }
}
