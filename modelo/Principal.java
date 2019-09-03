/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conta conta01 = new Conta("Thiago", 1, 5000);
        Conta conta02 = new Conta("Marlon", 2, 7000);
        Conta conta03 = new Conta("Matheus", 3, 2000);
       
        ArrayList<Conta> listaConta = new ArrayList<Conta>();
        listaConta.add(conta01);
        listaConta.add(conta02);
        listaConta.add(conta03);

        Scanner entrada = new Scanner(System.in);
        int opc, idLoc, destino;
        double valor;
        Conta objConta = new Conta();
        Conta objDestino = new Conta();
        Conta objTransferir = new Conta();
        System.out.println("\nSelecione uma operação:\n1-Sacar\n2-Depositar\n3-Transferir");
        System.out.println("Opção: ");
        opc = entrada.nextInt();

        switch (opc) {
            case 1:
                System.out.println("\nInforme o ID da Conta para Sacar: ");
                idLoc = entrada.nextInt();
                for (int i = 0; i < listaConta.size(); i++) {
                    objConta = listaConta.get(i);
                    if (objConta.getNumConta() == idLoc) {
                        System.out.println("\nConta: " + objConta.getNumConta() + " - " + objConta.getNomeDono() + " - " + objConta.saldo);
                        System.out.println("Inf o Valor para Sacar:");
                        valor = entrada.nextDouble();
                        if (valor <= objConta.getSaldo()) {
                            objConta.sacar(valor);
                            System.out.println("Operação realizada - Saldo Restante:" + objConta.getSaldo());
                        } else {
                            System.out.println("Saldo indisponivel");
                        }
                    }
                }
                break;
            case 2:
                System.out.println("\nInforme o ID da Conta para Depositar: ");
                idLoc = entrada.nextInt();
                for (int i = 0; i < listaConta.size(); i++) {
                    objConta = listaConta.get(i);
                    if (objConta.getNumConta() == idLoc) {
                        System.out.println("\nConta: " + objConta.getNumConta() + " - " + objConta.getNomeDono() + " - " + objConta.saldo);
                        System.out.println("Inf o Valor para Depositar:");
                        valor = entrada.nextDouble();
                        objConta.depositar(valor);
                        System.out.println("Operação realizada - Novo Saldo:" + objConta.getSaldo());

                    }
                }
                break;
            case 3:
                System.out.println("\nInforme o ID da Conta que ira trasferir: ");
                idLoc = entrada.nextInt();
                for (int i = 0; i < listaConta.size(); i++) {
                    objConta = listaConta.get(i);
                    if (objConta.getNumConta() == idLoc) {
                        System.out.println("\nConta: " + objConta.getNumConta() + " - " + objConta.getNomeDono() + " - " + objConta.saldo);
                        objTransferir = objConta;
                        System.out.println("\nInf o ID da conta destino:");
                        destino = entrada.nextInt();
                        for (int j = 0; j < listaConta.size(); j++) {
                            objConta = listaConta.get(j);
                            if (objConta.getNumConta() == destino) {
                                System.out.println("\nConta Destino: " + objConta.getNumConta() + " - " + objConta.getNomeDono() + " - " + objConta.saldo);
                                objDestino = objConta;
                                System.out.println("\nInf o valor a ser trasferido:");
                                valor = entrada.nextDouble();
                                objConta.Trasferir(objTransferir, objDestino, valor);

                                System.out.println("\nNovo Saldo Conta " + objTransferir.getNomeDono() + " = " + objTransferir.getSaldo());
                                System.out.println("\nNovo Saldo Conta " + objDestino.getNomeDono() + " = " + objDestino.getSaldo());
                                
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Opção invalida...");
                break;
        }

    }

}
