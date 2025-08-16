# 📄 Processador de Contratos
*Programa de console em **Java** (POO com **interfaces**) para processar contratos e gerar parcelas.*

## 📌 Visão Geral
Uma empresa deseja automatizar o processamento de seus contratos. O processamento de um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no número de meses desejado.
A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas. Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa por pagamento. Por enquanto, o serviço contratado pela empresa é o do **PayPal**, que aplica **juros simples de 1% a cada parcela**, mais **uma taxa de pagamento de 2%**.
Fazer um programa para ler os dados de um contrato (**número do contrato**, **data do contrato**, e **valor total do contrato**). Em seguida, o programa deve ler o **número de meses** para parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (**data e valor**), sendo a primeira parcela a ser paga **um mês após a data do contrato**, a segunda parcela **dois meses após o contrato** e assim por diante. **Mostrar os dados das parcelas no console**.

---

## 🧠 Conceitos e Arquitetura
- **POO (Programação Orientada a Objetos)**: separação de responsabilidades e encapsulamento.
- **Interface** `OnlinePaymentService`: contrato para serviços de pagamento.
- **Implementação** `PaypalService`: juros simples de **1%/mês** e taxa de **2%** por parcela.
- **Serviço** `ContractService`: orquestra o processamento das parcelas.
- **Entidades**:
  - `Contract` (número, data, valor total, lista de parcelas)
  - `Installment` (data de vencimento e valor)

### Estrutura de diretórios (sugerida)
```
src/
 ├─ application/
 │   └─ Program.java          # classe principal (executa o console)
 ├─ entities/
 │   ├─ Contract.java
 │   └─ Installment.java
 └─ services/
     ├─ ContractService.java
     ├─ OnlinePaymentService.java  # interface
     └─ PaypalService.java         # implementação da interface
```

---

## 🧮 Regras de Cálculo (PayPal)
Para **N** meses:
1. **Quota básica mensal** = `valor_total / N`
2. Para a parcela **i** (1..N), aplicar:
   - **Juros simples**: `quota * (1% * i)`
   - **Taxa de pagamento**: `2%` sobre o valor após os juros

**Fórmula (parcela i):**
```
quota = valor_total / N
valor_com_juros = quota * (1 + 0.01 * i)
valor_final = valor_com_juros * 1.02
```

**Exemplo (600.00 em 3x):**
```
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12
```

---

## ▶️ Como Executar (simples e objetivo)

### Opção A — IntelliJ IDEA (console)
1) Abra o projeto no **IntelliJ IDEA**  
2) Configure a JDK (17+ recomendado) em *Project Structure*  
3) Execute a classe **`application.Program`** (botão *Run*)  
4) Informe os dados solicitados no **console** (número, data no formato `dd/MM/yyyy`, valor, e número de parcelas)

### Opção B — Terminal
No diretório raiz do projeto:
```bash
# Compilar (Linux/Mac)
find src -name "*.java" | xargs javac -d out

# Executar
java -cp out application.Program
```

No Windows (PowerShell):
```powershell
# Compilar
Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object {$_.FullName} | javac -d out -cp .

# Executar
java -cp out application.Program
```

> Se sua classe principal tiver outro nome/pacote, ajuste o comando de **execução** conforme necessário.

---
## 🖼️ Diagramas e Exemplos (embutidos) 
### 1) Exemplo de execução no console (entrada/saída) 
<img alt="Exemplo de execução no console (entrada/saída)" src="C:\Users\lucas\OneDrive\Documentos\Curso Java - Nelio\exeIntefaces1 - Finalizado\exeIntefaces1 - Finalizado\contract-installment\imagens\input-output.png" /> 
### 2) Diagrama de domínio (Entities) 
<img alt="Diagrama de domínio (Entities)" src="C:\Users\lucas\OneDrive\Documentos\Curso Java - Nelio\exeIntefaces1 - Finalizado\exeIntefaces1 - Finalizado\contract-installment\imagens\diagrama-principal.png" /> 
### 3) Diagrama de serviços (Service Layer) 
<img alt="Diagrama de serviços (Service Layer)" src="C:\Users\lucas\OneDrive\Documentos\Curso Java - Nelio\exeIntefaces1 - Finalizado\exeIntefaces1 - Finalizado\contract-installment\imagens\services.png" /> 

---

## ✍️ Desenvolvido Por:
**Lucas França**

---
