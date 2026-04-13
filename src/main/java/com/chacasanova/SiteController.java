package com.chacasanova;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

/**
 * ╔══════════════════════════════════════════════════════════════════╗
 * ║  ARQUIVO: SiteController.java                                    ║
 * ║                                                                  ║
 * ║  O QUE É UM CONTROLLER?                                          ║
 * ║  É como um recepcionista de hotel.                               ║
 * ║  Quando alguém bate na porta (faz uma requisição),               ║
 * ║  o Controller decide o que responder.                            ║
 * ║                                                                  ║
 * ║  EXEMPLOS:                                                       ║
 * ║  Visitante acessa "/"          → mostra a página inicial         ║
 * ║  Visitante acessa "/presentes" → devolve o JSON de presentes     ║
 * ║  Visitante acessa "/config"    → devolve as configurações de PIX ║
 * ╚══════════════════════════════════════════════════════════════════╝
 */
@Controller  // Diz ao Spring: "esta classe é um Controller (recepcionista)"
public class SiteController {

    // ObjectMapper é a ferramenta para ler arquivos JSON
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * ROTA: GET /
     * Quando alguém acessa http://localhost:8080/
     * Spring Boot já serve index.html automaticamente da pasta static/
     * Por isso não precisamos fazer nada aqui além de deixar o Spring trabalhar.
     * 
     * O arquivo index.html fica em: src/main/resources/static/index.html
     */

    /**
     * ROTA: GET /presentes
     * Quando o JavaScript do site pedir os presentes,
     * este método lê o arquivo presentes.json e devolve o conteúdo.
     * 
     * @ResponseBody = "devolva isso direto como resposta, não renderize uma página"
     * ResponseEntity = permite controlar o que é devolvido (conteúdo + tipo)
     */
    @GetMapping("/presentes")
    @ResponseBody
    public ResponseEntity<JsonNode> getPresentes() {
        try {
            // ClassPathResource procura o arquivo dentro de src/main/resources/
            InputStream inputStream = new ClassPathResource("presentes.json").getInputStream();
            
            // Lê o JSON e converte em um objeto Java
            JsonNode presentes = objectMapper.readTree(inputStream);
            
            // Devolve com status 200 (OK) e tipo de conteúdo JSON
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(presentes);
                    
        } catch (Exception e) {
            // Se algo der errado, devolve status 500 (erro interno)
            System.err.println("Erro ao ler presentes.json: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * ROTA: GET /config
     * Devolve as configurações do PIX (chave e nome do recebedor).
     * O JavaScript usa isso para gerar o QR Code e o código PIX.
     */
    @GetMapping("/config")
    @ResponseBody
    public ResponseEntity<JsonNode> getConfig() {
        try {
            InputStream inputStream = new ClassPathResource("config.json").getInputStream();
            JsonNode config = objectMapper.readTree(inputStream);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(config);
                    
        } catch (Exception e) {
            System.err.println("Erro ao ler config.json: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
