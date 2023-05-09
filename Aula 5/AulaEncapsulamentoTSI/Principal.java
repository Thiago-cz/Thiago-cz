import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
  public static void main(String[] args) {
    ArrayList<Conta> listaContas = new ArrayList<Conta>();
    int opcaoMenu;
    String receberDados;
    double valor;
    Conta usuarioAtual;

    Titular t1 = new Titular("Joao da Silva", "123.123.213-45", "Rua Limeira, n89, Centro", "(64)98800-8765");
    Titular t2 = new Titular("Pedro Alvarez", "123.123.213-45", "Rua Limeira, n89, Centro", "(64)98800-8765");
    Titular t3 = new Titular("Fernando Barroso", "123.123.213-45", "Rua Limeira, n89, Centro", "(64)98800-8765");

    Conta c1 = new Conta(t1, "001", "12345");
    Conta c2 = new Conta(t2, "002", "12345");
    Conta c3 = new Conta(t3, "003", "54321");

    listaContas.add(c1);
    listaContas.add(c2);
    listaContas.add(c3);

    JOptionPane.showMessageDialog(null, "Ola, bem vindo ao banco!!!");

    while (true) {

      opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog(null,
          "Digite a operação desejada.\n Sacar ---1--- \n Depositar ---2--- \n Transferir ---3--- \n Extrato ---4--- \n Criar nova conta ---5--- \n Sair ---0---"));

      switch (opcaoMenu) {
        case 1: // sacar
          receberDados = JOptionPane.showInputDialog(null, "Digite o numero da conta !!!");
          if (verificarConta(receberDados, listaContas)) {
            usuarioAtual = getConta(receberDados, listaContas);
            receberDados = JOptionPane.showInputDialog(null, "Digite a senha da conta!!!");
            if (verificarSenha(receberDados, usuarioAtual)) {
              valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor para sacar!!"));
              if (usuarioAtual.sacar(valor)) {
                msgResposta("Saque de " + valor + " realizado com suecesso!!!");
                if (continuar())
                  continue;
                break;
              } else {
                msgResposta("Saldo insuficiente!!");
                if (continuar())
                  continue;
                break;
              }
            } else {
              msgResposta("Senha incorreta!!");
              if (continuar())
                continue;
              break;
            }
          } else {
            msgResposta("Numero da conta inexistente!!");
            if (continuar())
              continue;
            break;
          }

        case 2: // Depositar
          receberDados = JOptionPane.showInputDialog(null, "Digite o numero da conta !!!");
          if (verificarConta(receberDados, listaContas)) {
            usuarioAtual = getConta(receberDados, listaContas);
            valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor para depositar!!"));
            if (usuarioAtual.depositar(valor)) {
              msgResposta("Deposito de R$ " + valor + " realizado com sucesso!!");
              if (continuar())
                continue;
              break;
            } else {
              msgResposta("Não foi possivel depositar esse valor!!!");
              if (continuar())
                continue;
              break;
            }
          } else {
            JOptionPane.showMessageDialog(null, "Numero da conta incorreta!!");
            if (continuar())
              continue;
            break;
          }

        case 3: // Transferir
          receberDados = JOptionPane.showInputDialog("Digite o seu numero da conta!");
          if (verificarConta(receberDados, listaContas)) {
            usuarioAtual = getConta(receberDados, listaContas);
            receberDados = JOptionPane.showInputDialog("Digite o numero da conta que deseja transferir!!!");
            if (verificarConta(receberDados, listaContas)) {
              valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor para transferir!!!"));
              usuarioAtual.transferir(valor, getConta(receberDados, listaContas));
              msgResposta("Trasnferencia de " + valor + " realizada com sucesso!!!");
              if (continuar())
                continue;
              break;
            } else {
              msgResposta("Essa conta não existe!!!");
              if (continuar())
                continue;
              break;
            }
          } else {
            msgResposta("Essa conta não existe!!!");
            if (continuar())
              continue;
            break;
          }
        case 4: // Extrato
          receberDados = JOptionPane.showInputDialog(null, "Digite o numero da conta");
          if (verificarConta(receberDados, listaContas)) {
            usuarioAtual = getConta(receberDados, listaContas);
            receberDados = JOptionPane.showInputDialog(null, "Digite a senha");
            if (verificarSenha(receberDados, usuarioAtual)) {
              msgResposta(
                    "\nTitular da conta: " + usuarioAtual.getTitular().getNome()+
                      "\nNumero da conta: " + usuarioAtual.getNroConta()+
                      "\nAgencia: " + usuarioAtual.getAgencia()+
                      "\nBanco: " + usuarioAtual.getBanco()+
                      "\nSaldo disponivel: " + usuarioAtual.getSaldo());
              if (continuar())
                continue;
              break;
            } else {
              msgResposta("Senha incorreta!!!");
              if (continuar())
                continue;
              break;
            }
          } else {
            msgResposta("Essa conta não existe!!!");
            if (continuar())
              continue;
            break;
          }

        case 5: // Criar nova conta
          String nome, cpf, endereco, telefone, senha, nroConta;
          double saldoInicial = 0;

          nome = JOptionPane.showInputDialog(null, "Digite o nome completo");
          cpf = JOptionPane.showInputDialog(null, "Digite o cpf");
          endereco = JOptionPane.showInputDialog(null, "Digite o endereco");
          telefone = JOptionPane.showInputDialog(null, "Digite o telefone");
          Titular novoTitular = new Titular(nome, cpf, endereco, telefone);

          nroConta = JOptionPane.showInputDialog(null, "Digite o numero da conta");
          senha = JOptionPane.showInputDialog(null, "Digite a senha da conta");
          saldoInicial = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o saldo inical!!!"));
          Conta novaConta = new Conta(novoTitular, nroConta, senha, saldoInicial);
          listaContas.add(novaConta);
          msgResposta("Conta criada com sucesso!!");
          if (continuar())
            continue;
          break;

        case 0:
          msgResposta("Obrigado por utilizar nosso banco, volte sempre!!");
          break;

        default:
          msgResposta("Digite alguma opcao valida!!!");
          continue;
      }
      break;
    }

  }

  static boolean continuar() {
    String continuar = JOptionPane.showInputDialog(null, "Se deseja continuar digite sim");

    if (continuar.toLowerCase().equals("sim"))
      return true;
    return false;
  }

  static void msgResposta(String msg) {
    JOptionPane.showMessageDialog(null, msg);
  }

  static Conta getConta(String nroConta, ArrayList<Conta> array) {
    for (Conta usuario : array) {

      if (usuario.getNroConta().equals(nroConta)) {
        return usuario;
      }
    }
    return null;
  }

  static boolean verificarConta(String nroConta, ArrayList<Conta> array) {
    for (Conta usuario : array) {
      if (usuario.getNroConta().equals(nroConta))
        return true;
    }
    return false;
  }

  static boolean verificarSenha(String senha, Conta usuario) {
    if (usuario.getSenha().equals(senha)) {
      return true;
    }
    return false;
  }

}
