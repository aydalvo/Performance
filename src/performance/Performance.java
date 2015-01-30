package performance;

import general.General;

/**
 * 
 * Performance - performance - Performance.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 17/01/2015 13:18:52
 * @version 1.0
 *
 */
public class Performance extends General {

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 13:18:52
	 * @version 1.0
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("concatenacaoDeString()");
		concatenacaoDeString();
		
		System.out.println("concatenandoUmaString();");
		concatenandoUmaString();
		
		System.out.println("diferencaEntreStringStringBuilder()");
		diferencaEntreStringStringBuilder();
		
		System.out.println("concatenacaoComOperadorDeSoma()");
		concatenacaoComOperadorDeSoma();
		
		System.out.println("diferencaEntreStringBuilderStringBuffer()");
		diferencaEntreStringBuilderStringBuffer();
		
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 13:46:44
	 * @version 1.0
	 *
	 */
	private static void diferencaEntreStringBuilderStringBuffer() {
		
		long tStart, tEnd, tResult; 
		
		inicioBlocoStringBuilder();
		 
		StringBuilder strBuilder = new StringBuilder(); 
		tStart = retornaInstanteDeTempoExecucao(); 
		
		for(int i = 0; i < 100000; i ++){ 
			strBuilder.append("a"); 
		}
		
		tEnd = retornaInstanteDeTempoExecucao(); 
		tResult = tEnd - tStart; 
		 
		System.out.println("Tempo de Execução com StringBuilder = "+tResult+" ms"); 
		
		fimBlocoStringBuilder();
		  
		
		inicioBlocoStringBuffer();
		   
		StringBuffer strBuffer = new StringBuffer(); 
		tStart = retornaInstanteDeTempoExecucao(); 
		for(int i = 0; i < 100000; i ++) { 
			strBuffer.append("a"); 
		} 
		   
		tEnd = retornaInstanteDeTempoExecucao(); 
		tResult = tEnd - tStart; 
		   
		System.out.println("Tempo de Execução com StringBuffer = "+tResult+" ms"); 
		   
		fimBlocoStringBuffer();
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 14:08:38
	 * @version 1.0
	 *
	 */
	private static void inicioBlocoStringBuffer() {
		System.out.println("/*");
		System.out.println(" * ###########################################");
		System.out.println(" * INICIO BLOCO CONCATENAÇÃO COM StringBuffer");
		System.out.println(" * ###########################################");
		System.out.println(" *");
		System.out.println(" */");
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 14:08:15
	 * @version 1.0
	 *
	 */
	private static void fimBlocoStringBuffer() {
		System.out.println("/*");
		System.out.println(" * ###########################################");
		System.out.println(" * FIM BLOCO CONCATENAÇÃO COM StringBuffer");
		System.out.println(" * ###########################################");
		System.out.println(" *");
		System.out.println(" */");
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 13:41:34
	 * @version 1.0
	 *
	 */
	private static void concatenacaoComOperadorDeSoma() {
		
		long tStart = retornaInstanteDeTempoExecucao();
		
		inicioBlocoOperadorSoma();
		
		/*
		 * A nossa string abaixo é um uso ideal para o operador '+', 
		 * pois não estamos criando nenhum novo objeto em memória, 
		 * apenas melhorando a * legibilidade do código. 
		 * 
		 */ 
		 
		@SuppressWarnings("unused")
		String strFinal = "Feliz " + "Natal " + "Aos Leitores "+ "da DEVMEDIA "+ "hohoho..."; 
		 //Também poderiamos usar desta forma sem 
		 //prejudicar a performance do programa 
		int x = 10; int y = 20; 
		System.out.println("x:"+x+" y:"+y);
		
		long tEnd = retornaInstanteDeTempoExecucao(); 
		long tResult = tEnd - tStart; 
		System.out.println("Tempo de Execução com String = "+tResult+" ms");
		
		fimBlocoOperadorSoma();
		
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 13:36:37
	 * @version 1.0
	 *
	 */
	private static void diferencaEntreStringStringBuilder() {
		
		inicioBlocoOperadorSoma();
		 
		@SuppressWarnings("unused")
		String strFinal = ""; 
		long tStart = retornaInstanteDeTempoExecucao(); 
		
		/* 
		 * Vamos concatenar 65536 vezes o caractere 'a', 
		 * então entenda que cada vez que passarmos no laço 
		 * a JVM irá criar um novo objeto em memória. 
		 * 
		 */ 
		  
		for(int i = 0; i < 100000; i ++) { 
			strFinal += "a"; 
		} 
	  
		long tEnd = retornaInstanteDeTempoExecucao(); 
		long tResult = tEnd - tStart; 
		System.out.println("Tempo de Execução com operador '+' = "+tResult+" ms"); 
		  
		fimBlocoOperadorSoma();
		   
		inicioBlocoStringBuilder();
		   	
		 StringBuilder strBuilder = new StringBuilder(); 
		 tStart = retornaInstanteDeTempoExecucao(); 
		   	
		 for(int i = 0; i < 100000; i ++) {
			 strBuilder.append("a"); 
		 } 
		 
		 tEnd = retornaInstanteDeTempoExecucao(); 
		 tResult = tEnd - tStart; 
		 System.out.println("Tempo de Execução com StringBuilder = "+tResult+" ms"); 
		 //Saída provável: Tempo de Execução com operador '+' = 3753 ms Tempo de Execução com StringBuilder = 4 ms
		 
		 fimBlocoStringBuilder();
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 14:07:47
	 * @version 1.0
	 *
	 */
	private static void inicioBlocoOperadorSoma() {
		System.out.println("/*");
		System.out.println(" * ########################################################");
		System.out.println(" * INICIO BLOCO CONCATENAÇÃO COM String com o operador '+' ");
		System.out.println(" * ########################################################");
		System.out.println(" *");
		System.out.println(" */");
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 14:07:29
	 * @version 1.0
	 *
	 */
	private static void fimBlocoOperadorSoma() {
		System.out.println("/*");
		System.out.println(" * #####################################################");
		System.out.println(" * FIM BLOCO CONCATENAÇÃO COM String com o operador '+' ");
		System.out.println(" * #####################################################");
		System.out.println(" *");
		System.out.println(" */");
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 14:06:51
	 * @version 1.0
	 *
	 */
	private static void inicioBlocoStringBuilder() {
		System.out.println("/*");
		System.out.println(" * ###########################################");
		System.out.println(" * INICIO BLOCO CONCATENAÇÃO COM StringBuilder");
		System.out.println(" * ###########################################");
		System.out.println(" *");
		System.out.println(" */");
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 14:06:27
	 * @version 1.0
	 *
	 */
	private static void fimBlocoStringBuilder() {
		System.out.println("/*");
		 System.out.println(" * ###########################################");
		 System.out.println(" * FIM BLOCO CONCATENAÇÃO COM StringBuilder");
		 System.out.println(" * ###########################################");
		 System.out.println(" *");
		 System.out.println(" */");
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 13:30:45
	 * @version 1.0
	 *
	 */
	private static void concatenandoUmaString() {
		
		long tStart = retornaInstanteDeTempoExecucao();
		
		inicioBlocoOperadorSoma();
		
		@SuppressWarnings("unused")
		String strFinal = ""; 

		/* 
		* Vamos concatenar 65536 vezes o caractere 'a', 
		* então entenda que cada vez que passarmos no laço 
		* a JVM irá criar um novo objeto em memória. 
		* 
		*/ 

		for(int i = 0; i < 65536; i ++) { 
			strFinal += "a"; 
		}
		
		long tEnd = retornaInstanteDeTempoExecucao(); 
		long tResult = tEnd - tStart; 
		System.out.println("Tempo de Execução com String = "+tResult+" ms");
		
		fimBlocoOperadorSoma();
		
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 17/01/2015 13:27:53
	 * @version 1.0
	 *
	 */
	private static void concatenacaoDeString() {
		
		inicioBlocoOperadorSoma();
		
		long tStart = retornaInstanteDeTempoExecucao();
		//Cria um objeto em memória 
		String str = "hello"; 
		
		/* 
		 * Sabemos que nossa string agora será: "hello world". 
 		 * Ocorre que é criada a String "world" em memória, 
 		 * depois a JVM cria um outro objeto "hello world". 
 		 * No total vão ser 3 objetos para que essa 'concatenação' 
 		 * ocorra.
 		 * 
 		 */
		
		str.concat(" world");

		// Leia mais em: Diferenças entre String, StringBuilder e StringBuffer 
		// em Java http://www.devmedia.com.br/diferencas-entre-string-stringbuilder-e-stringbuffer-em-java/29865#ixzz3P5nFwJxz
		
		/* 
		 * O mesmo conceito é aplicado acima. É criada uma string 
		 * "from java" em memória, depois é criada uma 
		 * nova juntando "hello world from java". 
		 * No total temos agora 5 objetos em memória, 
		 * sendo que apenas 1 estamos utilizando, 
		 * veja que desperdício. 
		 * 
		 */
		
		str += " from Java";
		
		long tEnd = retornaInstanteDeTempoExecucao(); 
		long tResult = tEnd - tStart; 
		System.out.println("Tempo de Execução com String = "+tResult+" ms");
		
		fimBlocoOperadorSoma();
		
	}

}
