# 🏠 Chá de Casa Nova — Pedro e Maria
## Guia Completo para Iniciantes

---

## 📚 ANTES DE TUDO — O QUE É CADA COISA?

### ☕ O que é Java?
Java é uma linguagem de programação criada em 1995. Pense nela como
um idioma que os computadores entendem. Você escreve instruções em Java,
e o computador executa essas instruções.

Java roda em praticamente qualquer computador (Windows, Mac, Linux),
por isso o slogan histórico é: "Write once, run anywhere" (escreva
uma vez, rode em qualquer lugar).

### 🍃 O que é Spring Boot?
Spring Boot é um "framework" para Java. Um framework é como uma caixa
de ferramentas pronta — ele já tem soluções prontas para problemas
comuns, poupando você de escrever centenas de linhas.

Com Spring Boot você transforma seu computador em um servidor web em
minutos. Sem ele, você precisaria configurar muita coisa manualmente.

**Analogia:** Java é o carro, Spring Boot é o GPS e o ar-condicionado
já incluídos — você só dirige.

### 📦 O que é JSON?
JSON (JavaScript Object Notation) é um formato para salvar e
transportar dados de forma organizada. Parece um texto, mas tem
estrutura. Os navegadores e servidores adoram JSON.

**Exemplo simples:**
```json
{
  "nome": "Geladeira",
  "valor": 2500,
  "comodo": "Cozinha"
}
```

---

## 📂 ESTRUTURA DO PROJETO

```
cha-casa-nova/
│
├── pom.xml                          ← "lista de compras" do projeto
│
└── src/
    └── main/
        ├── java/
        │   └── com/chacasanova/
        │       ├── ChaCasaNovaApplication.java  ← ponto de entrada
        │       └── SiteController.java          ← as "rotas" da API
        │
        └── resources/
            ├── application.properties           ← configurações do servidor
            ├── presentes.json                   ← 🛒 EDITE AQUI os presentes
            ├── config.json                      ← 🔑 EDITE AQUI o PIX
            └── static/
                └── index.html                   ← 🌐 o site completo
```

---

## ⚙️ PRÉ-REQUISITOS (instalar antes de rodar)

### 1. Java 17 (ou superior)

**Verificar se já tem:**
```bash
java -version
```
Se aparecer "version 17..." ou maior, pode pular!

**Instalar no Windows:**
1. Acesse: https://adoptium.net/
2. Baixe o "Temurin 17 (LTS)"
3. Execute o instalador
4. Reinicie o terminal/computador

**Instalar no Mac:**
```bash
brew install openjdk@17
```

**Instalar no Ubuntu/Linux:**
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### 2. Maven (gerenciador do projeto)

**Verificar:**
```bash
mvn -version
```

**Instalar no Windows:**
1. Acesse: https://maven.apache.org/download.cgi
2. Baixe o "Binary zip archive"
3. Extraia em C:\maven
4. Adicione C:\maven\bin ao PATH (variáveis de ambiente)

**Instalar no Mac:**
```bash
brew install maven
```

**Instalar no Ubuntu/Linux:**
```bash
sudo apt install maven
```

---

## 🚀 COMO RODAR O PROJETO

### Passo 1: Abrir o terminal na pasta do projeto

No Windows: clique com botão direito dentro da pasta → "Abrir no Terminal"
No Mac/Linux: cd até a pasta

```bash
cd cha-casa-nova
```

### Passo 2: Baixar as dependências (só na primeira vez)

```bash
mvn install -DskipTests
```

Isso pode demorar alguns minutos na primeira vez (está baixando bibliotecas da internet).

### Passo 3: Rodar o projeto!

```bash
mvn spring-boot:run
```

Você verá algo como:
```
╔══════════════════════════════════════════╗
║   🏠 Chá de Casa Nova - Servidor ligado! ║
║   Acesse: http://localhost:8080           ║
╚══════════════════════════════════════════╝
```

### Passo 4: Abrir no navegador

Acesse: **http://localhost:8080**

🎉 Pronto! Seu site está rodando!

Para parar o servidor: pressione `Ctrl + C` no terminal.

---

## ✏️ COMO EDITAR OS PRESENTES

Abra o arquivo: `src/main/resources/presentes.json`

Cada item tem esta estrutura:
```json
{
  "id": 1,
  "nome": "Geladeira",
  "valor": 2500,
  "descricao": "Descrição do item aqui",
  "imagem": "https://link-da-imagem.com/foto.jpg",
  "comodo": "Cozinha"
}
```

**Para ADICIONAR um presente:**
- Copie um bloco `{ ... }` existente
- Cole após o último item (antes do `]`)
- Separe com vírgula: `}, {`
- Mude o `id` para um número único

**Para REMOVER um presente:**
- Delete o bloco `{ ... }` do item
- Garanta que não fique vírgula sobrando

**Cômodos disponíveis** (você pode criar outros!):
- `"Cozinha"`, `"Sala"`, `"Quarto"`, `"Banheiro"`

---

## 🔑 COMO TROCAR A CHAVE PIX

Abra o arquivo: `src/main/resources/config.json`

```json
{
  "nomeRecebedor": "Pedro e Maria",
  "chavePix": "chavepix@email.com",
  "cidade": "São Paulo",
  "mensagemPix": "Cha Casa Nova Pedro e Maria"
}
```

Troque:
- `"nomeRecebedor"` → o nome que aparece no PIX
- `"chavePix"` → sua chave PIX (e-mail, CPF, celular ou chave aleatória)
- `"cidade"` → sua cidade

**Tipos de chave PIX aceitos:**
- E-mail: `joao@gmail.com`
- CPF (somente números): `12345678901`
- Celular (com código do país): `+5511999999999`
- Chave aleatória: `123e4567-e89b-...`

---

## 🖼️ COMO TROCAR AS IMAGENS

As imagens ficam no campo `"imagem"` do JSON. Você tem 3 opções:

### Opção 1: Link externo (mais fácil)
Use qualquer URL de imagem da internet:
```json
"imagem": "https://meusite.com/foto-da-geladeira.jpg"
```

### Opção 2: Unsplash (fotos gratuitas, alta qualidade)
1. Acesse https://unsplash.com
2. Busque o item (ex: "refrigerator")
3. Clique na foto, copie a URL
4. Adicione `?w=400&q=80` no final para otimizar

### Opção 3: Upload local
1. Coloque a imagem em: `src/main/resources/static/imagens/geladeira.jpg`
2. No JSON, use o caminho relativo:
```json
"imagem": "/imagens/geladeira.jpg"
```

---

## 🌍 COLOCAR O SITE ONLINE

### Opção A: Railway (recomendado — gratuito e fácil)

1. **Crie uma conta** em https://railway.app (pode usar sua conta GitHub)

2. **Crie uma conta no GitHub** em https://github.com e suba seu projeto:
   ```bash
   git init
   git add .
   git commit -m "primeiro commit"
   git branch -M main
   git remote add origin https://github.com/SEU-USUARIO/cha-casa-nova.git
   git push -u origin main
   ```

3. **No Railway:**
   - Clique em "New Project"
   - Clique em "Deploy from GitHub repo"
   - Selecione seu repositório
   - Railway detecta automaticamente que é Java/Maven
   - Aguarde o deploy (2-5 minutos)

4. **Obter o link público:**
   - Vá em Settings → Domains → "Generate Domain"
   - Você terá algo como: `https://cha-casa-nova-production.up.railway.app`

---

### Opção B: Render (alternativa gratuita)

1. Crie conta em https://render.com

2. Clique em "New" → "Web Service"

3. Conecte seu repositório GitHub

4. Configure:
   - **Build Command:** `mvn clean package -DskipTests`
   - **Start Command:** `java -jar target/cha-casa-nova-1.0.0.jar`
   - **Environment:** Java

5. Clique em "Create Web Service"

6. Aguarde o deploy. Você receberá um link público!

---

### Opção C: Ngrok (para compartilhar temporariamente — mais rápido)

Útil para mostrar para amigos sem precisar de hospedagem.

1. **Baixe o Ngrok:** https://ngrok.com/download

2. **Com o projeto rodando localmente**, abra outro terminal:
   ```bash
   ngrok http 8080
   ```

3. O Ngrok gera uma URL pública temporária como:
   `https://abc123.ngrok.io`

4. Compartilhe essa URL! (funciona enquanto o terminal ficar aberto)

---

## 🐛 PROBLEMAS COMUNS

### "Port 8080 already in use"
Outra coisa está usando a porta 8080. Solução:
```bash
# Mudar para porta 8090 no arquivo application.properties:
server.port=8090
```
Depois acesse: http://localhost:8090

### "java: command not found"
Java não está instalado ou não está no PATH. Instale seguindo os passos acima.

### QR Code não abre no banco
Isso pode acontecer com a chave PIX de exemplo. Atualize o `config.json`
com sua chave PIX real e reinicie o servidor.

### As imagens não carregam
Verifique se os links de imagem são válidos. Tente abrir a URL da imagem
diretamente no navegador.

---

## 📞 ESTRUTURA DAS ROTAS DA API

| Rota         | Método | O que faz                        |
|--------------|--------|----------------------------------|
| `/`          | GET    | Serve o site (index.html)        |
| `/presentes` | GET    | Retorna a lista de presentes     |
| `/config`    | GET    | Retorna configurações do PIX     |

---

## 💡 DICAS EXTRAS

- **Sempre reinicie o servidor** após editar os arquivos `.json` ou `.java`
- Para parar: `Ctrl + C` no terminal
- Para reiniciar: `mvn spring-boot:run` novamente
- Os arquivos HTML/CSS/JS **não precisam** reiniciar o servidor ao mudar
  (basta recarregar a página no navegador com F5)

---

Feito com 🤍 para Pedro e Maria
