import javax.swing.JOptionPane;
import TiposClientes.PessoaF;
import TiposClientes.PessoaJ;
import TiposContas.Conta;
import TiposContas.ContaCorrente;
import TiposContas.ContaEmpresarial;
import TiposContas.ContaPoupanca;
import TiposContas.ContaEspecial;

public class Banco {
    public static void main(String[] args) {
        ListaContas listaContas = new ListaContas();
        JOptionPane.showMessageDialog(null, "Bem vindo ao Banco !!!!");

        while (true) {
            int numConta;
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escolha uma opcao: \n 1 - Sacar \n 2 - Depositar \n 3  - Transferir \n 4 - Criar nova conta \n 5 - Excluir conta \n 6 - Sair"));

            switch (opcao) {
                case 1:
                    numConta = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite o numero da conta!!"));

                    if (verificarConta(numConta, listaContas)) {
                        int valor = Integer.parseInt(JOptionPane
                                .showInputDialog("Digite o valor do saque!!!"));
                        if (getConta(numConta, listaContas).sacar(valor)) {
                            JOptionPane.showMessageDialog(null,
                                    "Saque realizado com sucesso!");
                            continue;
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                            continue;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Essa conta nao exite!!!");
                        continue;
                    }
                case 2:
                    numConta = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite o numero da conta!!"));

                    if (verificarConta(numConta, listaContas)) {
                        int valor = Integer.parseInt(JOptionPane
                                .showInputDialog("Digite o valor do deposito!!"));
                        if (getConta(numConta, listaContas).depositar(valor)) {
                            JOptionPane.showMessageDialog(null,
                                    "Deposito realizado com sucesso");
                            continue;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Erro ao realizar deposito");
                            continue;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Essa conta nao existe");
                        continue;
                    }
                case 3:
                    numConta = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite o numero da primeira conta!!"));
                    if (verificarConta(numConta, listaContas)) {
                        int numConta2 = Integer.parseInt(
                                JOptionPane.showInputDialog("Digite o numero da segunda conta!!"));

                        if (verificarConta(numConta2, listaContas)) {
                            int valor = Integer
                                    .parseInt(JOptionPane.showInputDialog("Digite o valor da transferencia"));

                            if (getConta(numConta, listaContas).transferir(getConta(numConta2, listaContas), valor)) {
                                JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!!");
                                continue;
                            } else {
                                JOptionPane.showMessageDialog(null, "Nao foi possivel realizar a transferencia!!");
                                continue;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "A segunda conta nao existe!!");
                            continue;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Essa conta nao existe!!");
                        continue;
                    }
                case 4:
                    criarConta(listaContas);
                    continue;
                case 5:
                    numConta = Integer
                            .parseInt(JOptionPane.showInputDialog("Digite o numero da conta que deseja excluir"));
                    if (verificarConta(numConta, listaContas)) {
                        listaContas.listaContas.remove(getConta(numConta, listaContas));
                        JOptionPane.showMessageDialog(null, "Conta excluida com sucesso!!");
                        continue;
                    } else {
                        JOptionPane.showMessageDialog(null, "Essa conta nao existe!!!");
                        continue;
                    }
                case 6:
                    break;
            }
            
            break;
        }
    }

    public static void criarConta(ListaContas lista) {
        String dados;
        String[] arrayDados;
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Digite qual o tipo de conta que deseja criar!!! \n 1 - Conta poupanca \n 2 - Conta corrente \n 3 - Conta Empresarial \n 4 - Conta Especial"));
        switch (opcao) {
            case 1:
                dados = JOptionPane.showInputDialog(null,
                        "Digite as informacoes separadas por ifen: \n Numero da conta: \n Agencia: \n Senha:");
                arrayDados = dados.split("_");
                PessoaF novaPessoaF = criarPessoaF();
                if (novaPessoaF != null) {
                    try {
                        ContaPoupanca novaCPoupanca = new ContaPoupanca(
                                Integer.parseInt(arrayDados[0]),
                                Integer.parseInt(arrayDados[1]),
                                arrayDados[2],
                                novaPessoaF);
                        lista.listaContas.add(novaCPoupanca);
                        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!!!");
                        break;
                    } catch (Throwable t) {
                        JOptionPane.showMessageDialog(null,
                                "Existem informacoes faltando, por favor digite corretamente!!!");
                        break;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Nao foi possivel criar a conta!!");
                    break;
                }
            case 2:
                dados = JOptionPane.showInputDialog(null,
                        "Digite as informacoes separadas por ifen: \n Numero da conta: \n Agencia: \n Senha:");
                arrayDados = dados.split("_");
                novaPessoaF = criarPessoaF();

                if (novaPessoaF != null) {

                    try {
                        ContaCorrente novaCCorrente = new ContaCorrente(
                                Integer.parseInt(arrayDados[0]),
                                Integer.parseInt(arrayDados[1]),
                                arrayDados[2],
                                novaPessoaF);
                        lista.listaContas.add(novaCCorrente);
                        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!!!");
                        break;

                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Informacoes faltando, digite corretamente!!!");
                        break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nao foi possivel criar a conta!!!");
                }

            case 3:
                dados = JOptionPane.showInputDialog(null,
                        "Digite as informacoes separadas por ifen: \n Numero da conta: \n Agencia: \n Senha:");
                arrayDados = dados.split("_");
                PessoaJ novaPessoaJ = criarPessoaJ();

                if (novaPessoaJ != null) {
                    try {
                        ContaEmpresarial novaCEmpresarial = new ContaEmpresarial(
                                Integer.parseInt(arrayDados[0]),
                                Integer.parseInt(arrayDados[1]),
                                arrayDados[2],
                                novaPessoaJ);
                        lista.listaContas.add(novaCEmpresarial);
                        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!!!");
                        break;

                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Existem informacoes faltando, digite corretamente!!!");
                        break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nao foi possivel criar a conta, pois existem informacoes faltando!!!");
                            break;
                }
            case 4:
                dados = JOptionPane.showInputDialog(null,
                        "Digite as informacoes separadas por ifen: \n Numero da conta: \n Agencia: \n Senha:");
                arrayDados = dados.split("_");
                novaPessoaF = criarPessoaF();
                if (novaPessoaF != null) {
                    ContaEspecial novaCEspecial = new ContaEspecial(
                            Integer.parseInt(arrayDados[0]),
                            Integer.parseInt(arrayDados[1]),
                            arrayDados[2],
                            novaPessoaF);
                    lista.listaContas.add(novaCEspecial);
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso!!!");
                    break;

                } else {
                    JOptionPane.showMessageDialog(null, "Nao foi possivel cirar a conta!!!");
                    break;
                }
        }
    }

    static Conta getConta(int numConta, ListaContas lista) {
        for (Conta c : lista.listaContas) {
            if (c.getNumConta() == numConta)
                return c;
        }
        return null;
    }

    static boolean verificarConta(int numConta, ListaContas lista) {
        if (!getConta(numConta, lista).equals(null)) {
            return true;
        } else {
            return false;
        }
    }

    public static PessoaF criarPessoaF() {
        String receberDados = JOptionPane.showInputDialog(null,
                "Digite os seguintes dados do Titular separados por ifen: \n Nome completo: \n Telefone: \n Endereco: \n CPF: \n RG: \n Nome da mae");
        String[] dados = receberDados.split("_");

        try {
            PessoaF novoCliente = new PessoaF(
                    dados[0],
                    dados[1],
                    dados[2],
                    dados[3],
                    dados[4],
                    dados[5]);
            return novoCliente;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

    }

    public static PessoaJ criarPessoaJ() {
        String receberDados = JOptionPane.showInputDialog(null,
                "Digite os seguintes dados do Titular separados por ifen: \n Nome completo: \n Telefone: \n Endereco: \n CNPJ:");
        String[] dados = receberDados.split("_");

        try {
            PessoaJ novoCliente = new PessoaJ(
                    dados[0],
                    dados[1],
                    dados[2],
                    dados[3]);
            return novoCliente;

        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}
