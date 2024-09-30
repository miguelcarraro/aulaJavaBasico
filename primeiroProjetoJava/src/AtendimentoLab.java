public class AtendimentoLab {
    public static void main(String[] args) {
        java.io.Console console = System.console();
        if (console == null) {
            System.out.println("Console não está disponível.");
            System.exit(1);
        }

        Fila fila = new Fila(10);
        String opcao;

        do {
            System.out.println("\n--- Menu de Atendimento ---");
            System.out.println("1. Solicitar nova senha");
            System.out.println("2. Excluir uma senha");
            System.out.println("3. Listar todas as senhas");
            System.out.println("4. Visualizar próximo a ser atendido");
            System.out.println("5. Chamar próximo a ser atendido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = console.readLine();

            switch (opcao) {
                case "1":
                    System.out.print("Informe o tipo de senha (Comum ou Prioridade): ");
                    String tipoSenha = console.readLine();
                    fila.adicionarSenha(tipoSenha);
                    break;
                case "2":
                    System.out.print("Informe o tipo de senha a excluir (Comum ou Prioridade): ");
                    String tipoExcluir = console.readLine();
                    fila.excluirSenha(tipoExcluir);
                    break;
                case "3":
                    fila.listarSenhas();
                    break;
                case "4":
                    fila.visualizarProximo();
                    break;
                case "5":
                    fila.chamarProximo();
                    break;
                case "0":
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("0"));
    }
}
