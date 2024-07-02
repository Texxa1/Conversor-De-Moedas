package br.com.texxas.conversordemoedas.menu;

import br.com.texxas.conversordemoedas.conversorApi.Conversor;
import br.com.texxas.conversordemoedas.conversorApi.ConversorApi;

import java.util.Scanner;

public class Menu {
    Scanner escolha = new Scanner(System.in);

    public void menu(){
        boolean exibeMenu = true;
        while (exibeMenu){
            System.out.println("""
                ------------------------------------------------------
                
                          Bem vindo ao Conversor de Moedas!    
                   
                ------------------------------------------------------

                        1- Real/(BRL)                      para     Euro/(EUR)
                        2- Real/(BRL)                      para     Peso Argentino/(ARS) 
                        3- Real/(BRL)                      para     Dólar dos Estados Unidos/(USD)
                        4- Euro/(EUR)                      para     Real/(BRL)
                        5- Peso Argentino/(ARS)            para     Real/(BRL)
                        6- Dólar dos Estados Unidos/(USD)  para     Real/(BRL)
                        7- Sair
                        
                ------------------------------------------------------   
                """);

            System.out.println("Escolha uma opção de conversão:");
            String opcao = escolha.next();

            switch (opcao){
                case "1":
                    this.converter("BRL","EUR");
                    break;

                case "2":
                    this.converter("BRL","ARS");
                    break;

                case "3":
                    this.converter("BRL","USD");
                    break;

                case "4":
                    this.converter("EUR","BRL" );
                    break;

                case "5":
                    this.converter("ARS","BRL");
                    break;

                case "6":
                    this.converter("USD","BRL" );
                    break;

                default:
                    if (opcao.equals("7")){
                        System.out.println("Obrigado !");
                        exibeMenu = false;
                    }else {
                        System.out.println("Opção Inválida ! " +
                                           "Selecione uma opção valida, ou, Opção \"7\" para sair. ");
                    }
                    break;
            }
        }
    }

    public void converter (String base_code, String target_code){
        System.out.println("Informe um valor para conversão: ");
        try {
            double valor = this.escolha.nextDouble();
            Conversor conversor = new Conversor(base_code, target_code, valor);
            ConversorApi api = new ConversorApi(conversor);
            System.out.println(api.chamadaApi());
        } catch (Exception e) {
            System.out.println("O valor digitado é inválido... Utilize ',' para converter numeros decimais.");
        }

    }
}
