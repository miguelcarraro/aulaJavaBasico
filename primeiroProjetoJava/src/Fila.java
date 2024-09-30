
class Fila {
    private String[] filaComum;
    private String[] filaPrioridade;
    private int inicioComum;
    private int fimComum;
    private int inicioPrioridade;
    private int fimPrioridade;
    private int contadorAtendimentosPrioridade;

    public Fila(int tamanho) {
        filaComum = new String[tamanho];
        filaPrioridade = new String[tamanho];
        inicioComum = fimComum = 0;
        inicioPrioridade = fimPrioridade = 0;
        contadorAtendimentosPrioridade = 0;
    }

    // Método para adicionar senha
    public void adicionarSenha(String tipo) {
        if (tipo.equalsIgnoreCase("comum")) {
            if (fimComum < filaComum.length) {
                filaComum[fimComum++] = "C" + fimComum;
                System.out.println("Senha comum adicionada: C" + fimComum);
            } else {
                System.out.println("Fila comum cheia!");
            }
        } else if (tipo.equalsIgnoreCase("prioridade")) {
            if (fimPrioridade < filaPrioridade.length) {
                filaPrioridade[fimPrioridade++] = "P" + fimPrioridade;
                System.out.println("Senha prioritária adicionada: P" + fimPrioridade);
            } else {
                System.out.println("Fila prioritária cheia!");
            }
        } else {
            System.out.println("Tipo de senha inválido!");
        }
    }

    // Método para excluir senha
    public void excluirSenha(String tipo) {
        if (tipo.equalsIgnoreCase("comum")) {
            if (inicioComum < fimComum) {
                System.out.println("Senha excluída: " + filaComum[inicioComum]);
                filaComum[inicioComum++] = null;
            } else {
                System.out.println("Nenhuma senha comum para excluir.");
            }
        } else if (tipo.equalsIgnoreCase("prioridade")) {
            if (inicioPrioridade < fimPrioridade) {
                System.out.println("Senha excluída: " + filaPrioridade[inicioPrioridade]);
                filaPrioridade[inicioPrioridade++] = null;
            } else {
                System.out.println("Nenhuma senha prioritária para excluir.");
            }
        }
    }

    // Método para listar todas as senhas
    public void listarSenhas() {
        System.out.println("Senhas Comuns:");
        for (int i = inicioComum; i < fimComum; i++) {
            System.out.println(filaComum[i]);
        }

        System.out.println("Senhas Prioritárias:");
        for (int i = inicioPrioridade; i < fimPrioridade; i++) {
            System.out.println(filaPrioridade[i]);
        }
    }

    // Método para visualizar o próximo a ser atendido
    public void visualizarProximo() {
        if (contadorAtendimentosPrioridade < 3 && inicioPrioridade < fimPrioridade) {
            System.out.println("Próximo a ser atendido (Prioridade): " + filaPrioridade[inicioPrioridade]);
        } else if (inicioComum < fimComum) {
            System.out.println("Próximo a ser atendido (Comum): " + filaComum[inicioComum]);
        } else {
            System.out.println("Nenhum paciente na fila.");
        }
    }

    // Método para chamar o próximo a ser atendido
    public void chamarProximo() {
        if (contadorAtendimentosPrioridade < 3 && inicioPrioridade < fimPrioridade) {
            System.out.println("Chamando paciente prioritário: " + filaPrioridade[inicioPrioridade]);
            filaPrioridade[inicioPrioridade++] = null;
            contadorAtendimentosPrioridade++;
        } else if (inicioComum < fimComum) {
            System.out.println("Chamando paciente comum: " + filaComum[inicioComum]);
            filaComum[inicioComum++] = null;
            contadorAtendimentosPrioridade = 0;
        } else {
            System.out.println("Nenhum paciente na fila.");
        }
    }
}
