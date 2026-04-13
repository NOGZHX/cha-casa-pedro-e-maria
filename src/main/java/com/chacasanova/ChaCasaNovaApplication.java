package com.chacasanova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ╔══════════════════════════════════════════════════════════════════╗
 * ║  ARQUIVO: ChaCasaNovaApplication.java                           ║
 * ║                                                                  ║
 * ║  O QUE É JAVA?                                                   ║
 * ║  Java é uma linguagem de programação criada em 1995.             ║
 * ║  É usada em milhões de empresas no mundo todo.                   ║
 * ║  É como dar instruções detalhadas para o computador.             ║
 * ║                                                                  ║
 * ║  O QUE É SPRING BOOT?                                            ║
 * ║  Spring Boot é um "framework" (conjunto de ferramentas) para     ║
 * ║  Java. Ele torna fácil criar servidores web. Sem ele,            ║
 * ║  você precisaria escrever centenas de linhas a mais de código.   ║
 * ║                                                                  ║
 * ║  ANALOGIA SIMPLES:                                               ║
 * ║  Java = a língua que você fala                                   ║
 * ║  Spring Boot = um assistente que já sabe fazer o trabalho chato  ║
 * ╚══════════════════════════════════════════════════════════════════╝
 */
@SpringBootApplication  // Esta anotação diz: "ei Spring, configure tudo automaticamente!"
public class ChaCasaNovaApplication {

    /**
     * O método main() é o PONTO DE ENTRADA do programa.
     * Quando você roda o projeto, o Java vem aqui primeiro.
     * É como a porta principal de uma casa.
     */
    public static void main(String[] args) {
        // SpringApplication.run() liga o servidor web.
        // Depois disso, seu site fica disponível em http://localhost:8080
        SpringApplication.run(ChaCasaNovaApplication.class, args);
        
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   🏠 Chá de Casa Nova - Servidor ligado! ║");
        System.out.println("║   Acesse: http://localhost:8080           ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}
