Algoritmo "Plataforma Aérea"

Const

   maxcliente = 3
   maxdestino = 3
var

      vetnome,vetend : vetor[ 1..maxcliente ] de caracter
      vetcpf,vettel : vetor[ 1..maxcliente ] de inteiro
      ID,idDestino,cond,in,IdDest:inteiro
      
      
   vetnum:     vetor[ 1..maxdestino] de inteiro
   vetduracao: vetor [1..maxdestino] de real
   vetEst,vetdestino: vetor [1..maxdestino] de caracter
    ind,condi: inteiro
   
   
   
 funcao LocalizaDestino (Destp:caracter): inteiro
var
   achou: logico
   i: inteiro
inicio
   achou <- falso
   i <- 1
   enquanto (achou = falso) e (i <= maxdestino ) faca
      se Destp = vetdestino[i] entao
         achou <- verdadeiro
      senao
          i <- i+1
      fimse
   fimenquanto
   retorne i
fimfuncao
   

  funcao localizanome (nomep:caracter ):inteiro

 var
  achou:logico
  cont:inteiro

  inicio
  achou <- falso
   cont <- 1
   enquanto (achou = falso) e (cont <= maxcliente) faca
        se nomep = vetnome[cont] entao
        achou <- verdadeiro
        senao
        cont <- cont + 1
        fimse
      fimenquanto
     retorne cont
     
fimfuncao

     
 procedimento menu()
 var
    op:inteiro
 inicio
      limpatela()
      
      
escreval("           _____  _                       _              ")
escreval("          |  ___|| |                     (_)             ")
escreval("          | |__  | |_   Agência__  _ __   _  ____  ___   ")
escreval("          |  __| | __| / _ \| '__|| '_ \ | ||_  / / _ \  ")
escreval("          | |___ | |_ |  __/| |   | | | || | / / |  __/  ")
escreval("          \____/  \__| \___||_|   |_| |_||_|/___| \___|  ")

          escreval("")

      
    escreval("            |-------------------MENU----------------|")
    escreval("            |                                       |")
    escreval("            |      1------Cadastrar clientes        |")
    escreval("            |      2------Cadastrar Destinos        |")
    escreval("            |      3------Procurar Clientes         |")
    escreval("            |      4------Consultar Destinos        |")
    escreval("            |      5------sair                      |")
    escreval("            |                                       |")
    escreval("            |---------------------------------------|")                                      |")
  repita
  escreval(" ")
  escreval("Digite a opção desejada:")
  leia(op)

  escolha(op)
  caso 1
    cadCliente()
  caso 2
    cadDestino()
  caso 3
    procCliente()
  caso 4
    consDestino()
  caso 5

    interrompa

  outrocaso
  menu ()
  fimescolha
  ate (op >= 1) e (op <=5)
 fimprocedimento
 
 
 //...............
       procedimento menu2()
 var
    op:inteiro
 inicio
      limpatela()
    escreval("            |-------------------MENU----------------|")
    escreval("            |                                       |")
    escreval("            |      1------Cadastrar clientes        |")
    escreval("            |      2------Cadastrar Destinos        |")
    escreval("            |      3------Procurar Clientes         |")
    escreval("            |      4------Consultar Destinos        |")
    escreval("            |      ESC----Sair                      |")
    escreval("            |                                       |")
    escreval("            |---------------------------------------|")
  repita
  escreval(" ")
  escreval("Digite a opção desejada:")
  leia(op)

  escolha(op)
  caso 1
    cadCliente()
  caso 2
    cadDestino()
  caso 3
    procCliente()
  caso 4
  outrocaso
  menu ()
  fimescolha
  ate (op >= 1) e (op <=4)
 fimprocedimento



 procedimento cadCliente()
 
 
        inicio
     
     limpatela()
    escreval("             ______________________________")
    escreval("            |                              |")
    escreval("            |                              |")
    escreval("            |-------CADASTRAR CLIENTE------|")
    escreval("            |                              |")
    escreval("            |______________________________|")
    
     escreval("")
     
    se ID <= maxcliente entao
    escreva("Nome do Cliente:")
    leia (vetnome[ID])
    escreva("CPF:")
    leia (vetcpf[ID])
    escreva("Telefone:")
    leia (vettel[ID])
    escreva("Endereço:")
    leia (vetend[ID])
    ID<-ID+1
    
    repita
    escreval("                Deseja cadastrar mais um cliente?")
    escreval("                          Sim -- 1")
    escreval("                          Não -- 2")
    escreval("                   Digite a opção desejada:")
    leia (condi)
    se condi = 1 entao
    limpatela()
    cadCliente()
    senao
   se condi = 2 entao
    menu2()
    fimse
        fimse
      ate (condi>=1)e(condi<=2)
  fimprocedimento
  
  //---------------
      procedimento cadDestino()
      
      var
      
        cond,condii:inteiro
       
        inicio
        
        
     limpatela()
    escreval("             ______________________________")
    escreval("            |                              |")
    escreval("            |                              |")
    escreval("            |-------CADASTRAR DESTINO------|")
    escreval("            |                              |")
    escreval("            |______________________________|")
    se idDestino <= maxdestino entao
    escreval("")
    escreval("cadastro de numero: ", IdDest)
    escreva("Digite o nome do destino/ cidade: ")
    leia (vetdestino[idDestino])
    escreva("Estado: ")
    leia (vetEst[idDestino])
    escreva("Duração de voo até o destino: ")
    leia (vetduracao[idDestino])
    IdDest <- IdDest + 1
    idDestino<-idDestino+1
    escreval(           "Deseja cadastrar mais um destino? ")
    escreval("                     1----Sim ")
    escreval("                     2----Não ")
    escreva("               Digite a opção desejada:")
    leia (cond)
    se cond=1 entao
    cadDestino()
    senao
    se cond=2 entao
    menu()
    senao("opção invalida!")
    erro()

      fimprocedimento
  
  
  
  procedimento naoEncontradoDest()
   var

    opi:inteiro
    inicio
    repita
    escreval("")
      escreval(" ")
      escreval("                    Destino não encontrado!                   ")
      escreval("    Continuar procurando    |     Menu   |  fecha x  ")
      escreval("              1             |       2    |     esc   ")
      leia(opi)
    escolha (opi)
    caso 1
    consdestino()
    caso 2
    menu2()

  outrocaso
  erro ()
  fimescolha
  ate  (opi >= 1) e (opi <= 2)

 fimprocedimento
  

    procedimento naoEncontradoCliente()
   var

    opi:inteiro
    inicio
    repita
      escreval(" ")
      escreval(" ")
      escreval("                    Cliente não Cadastrado!                   ")
      escreval("    Continuar procurando    |     Menu   |  fecha x  ")
      escreval("              1             |       2    |     esc   ")
      leia(opi)
    escolha (opi)
    caso 1
    procCliente()
    caso 2
    menu2()

  outrocaso
  erro ()
  fimescolha
  ate  (opi >= 1) e (opi <= 2)

 fimprocedimento
  
  
  
  //---------------
    procedimento erro()
    var
    
    opi:inteiro
    inicio

     repita
      escreval(" ")
      escreval(" ")
      escreval("                    Opção inválida!                   ")
      escreval("    Continuar cadastrando   |     Menu   |  fecha x  ")
      escreval("              1             |       2    |     esc   ")
      leia(opi)
    escolha (opi)
    caso 1
    cadDestino()
    caso 2
    menu2()

  outrocaso
  erro ()
  fimescolha
  ate  (opi >= 1) e (opi <= 2)

 fimprocedimento

    
    procedimento procCliente()
    
    var
    
    posnome,esc:inteiro
    nomeProc:caracter
        inicio
        

    escreval("             ______________________________")
    escreval("            |                              |")
    escreval("            |                              |")
    escreval("            |-------PROCURAR CLIENTE-------|")
    escreval("            |                              |")
    escreval("            |______________________________|")


     escreva("Digite o nome: ")
     leia (nomeProc)
         posnome <- localizanome(nomeProc)
         se posnome = maxcliente + 1   entao
         naoEncontradoCliente()
         senao
          escreval("DADOS DO CLIENTE")
       escreval("Nome: ",vetnome[posnome])
       escreval("CPF: ",vetcpf[posnome])
       escreval("TELEFONE:",vettel[posnome])
       escreval("ENDEREÇO:",vetend[posnome])
       repita
       escreval("Deseja relizar um nova pesquisa? 1(SIM), 2(NÃO)")
        leia(esc)
           se esc = 1 entao
             Limpatela()
       procCliente
          senao
      se esc = 2 entao
      limpatela
       menu2()
       fimse
           fimse

             ate(esc>=1) e (esc<=2)
    fimprocedimento
    
    
    
    
  procedimento consdestino()
    escreval("             ______________________________")
    escreval("            |                              |")
    escreval("            |                              |")
    escreval("            |-------COSULTAR DESTINO-------|")
    escreval("            |                              |")
    escreval("            |______________________________|")

   var
    posnome,esc:inteiro
    NomeDes:caracter
        inicio

       escreva("Digite o destino procurado: ")
       leia (NomeDes)
         posnome <- localizaDestino(NomeDes)
         se posnome = maxcliente + 1   entao
         naoEncontradoDest()
         senao
          escreval("Dados do destino")
           escreval("")
       escreval("Destino: ",vetdestino[posnome])
       escreval("Estado: ",vetEst[posnome])
       escreval("Duração de tempo até o destino: ",vetduracao[posnome])
       fimse
       
      repita
       escreval("Deseja relizar um nova pesquisa? 1(SIM), 2(NÃO)")
        leia(esc)
    se esc = 1 entao
             Limpatela()
       consdestino
          senao
      se esc = 2 entao
      limpatela
       menu2()
       fimse
           fimse

    ate (esc >= 1) e (esc <=2)
  
  fimprocedimento
  
  
  
 inicio
 
  IdDest <- 1
  idDestino <- 1
  ID <- 1
  menu()

Fimalgoritmo




