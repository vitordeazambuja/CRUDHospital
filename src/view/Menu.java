package view;

import controller.ControlaPaciente;
import model.Paciente;

import controller.ControlaMedico;
import model.Medico;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ControlaPaciente controlaPaciente;
    private ControlaMedico controlaMedico;

    public Menu(){
        this.scanner = new Scanner(System.in);
        this.controlaPaciente = new ControlaPaciente();
        this.controlaMedico = new ControlaMedico();
    }

    public void exibirMenu(){
        boolean sair = false;

        while (!sair){

            System.out.println("\nMenu Principal");
            System.out.println("1 - Pacientes");
            System.out.println("2 - Medicos");
            System.out.println("3 - Consultas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    gerenciarPacientes();
                    break;
                case 2:
                    gerenciarMedicos();
                    break;
                case 3:
                    gerenciarConsultas();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    public void gerenciarPacientes(){
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\nGerenciamento de Pacientes");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Editar Paciente");
            System.out.println("4. Remover Paciente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    editarPaciente();
                    break;
                case 4:
                    removerPaciente();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    private void adicionarPaciente() {
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Numero de Identificacao: ");
        int numeroIdentificacao = scanner.nextInt();

        Paciente paciente = new Paciente(0, nome, cpf, dataNascimento, sexo, email, telefone, endereco, numeroIdentificacao);

        boolean sucesso = controlaPaciente.adicionarPaciente(paciente);
        if (sucesso) {
            System.out.println("Paciente adicionado com sucesso!");
        } else {
            System.out.println("Erro ao adicionar paciente.");
        }
    }

    private void listarPacientes() {
        List<Paciente> pacientes = controlaPaciente.listarPacientes();

        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente encontrado.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }

    private void editarPaciente() {
        System.out.print("ID do paciente a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Nova data de nascimento (AAAA-MM-DD): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Novo sexo: ");
        String sexo = scanner.nextLine();

        System.out.print("Novo email: ");
        String email = scanner.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Novo endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Novo numero de identificacao: ");
        int numeroIdentificacao = scanner.nextInt();

        Paciente paciente = new Paciente(id, nome, cpf, dataNascimento, sexo, email, telefone, endereco, numeroIdentificacao);

        boolean sucesso = controlaPaciente.editarPaciente(paciente);
        if (sucesso) {
            System.out.println("Paciente editado com sucesso!");
        } else {
            System.out.println("Erro ao editar paciente.");
        }
    }

    private void removerPaciente() {
        System.out.print("ID do paciente a ser removido: ");
        int id = scanner.nextInt();

        boolean sucesso = controlaPaciente.removerPaciente(id);
        if (sucesso) {
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Erro ao remover paciente.");
        }
    }

    public void gerenciarMedicos(){
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\nGerenciamento de Medicos");
            System.out.println("1. Adicionar Medico");
            System.out.println("2. Listar Medicos");
            System.out.println("3. Editar Medico");
            System.out.println("4. Remover Medico");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarMedico();
                    break;
                case 2:
                    listarMedicos();
                    break;
                case 3:
                    editarMedico();
                    break;
                case 4:
                    removerMedico();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    private void adicionarMedico() {
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        System.out.print("Numero de Identificacao: ");
        int numeroIdentificacao = scanner.nextInt();

        Medico medico = new Medico(0,nome,cpf,email,telefone,endereco,especialidade,numeroIdentificacao);

        boolean sucesso = controlaMedico.adicionarMedico(medico);
        if (sucesso){
            System.out.println("Medico adicionado com sucesso!");
        } else{
            System.out.println("Erro ao adicionar medico.");
        }
    }

    private void listarMedicos() {
        List<Medico> medicos = controlaMedico.listarMedicos();

        if (medicos.isEmpty()) {
            System.out.println("Nenhum medico encontrado.");
        }else{
            for (Medico medico : medicos){
                System.out.println(medico);
            }
        }
    }

    private void editarMedico() {
        System.out.println("ID do medico a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Novo email: ");
        String email = scanner.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Novo endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Nova especialidade: ");
        String especialidade = scanner.nextLine();

        System.out.print("novo numero de identificacao: ");
        int numeroIdentificacao = scanner.nextInt();

        Medico medico = new Medico(id, nome, cpf, email, telefone, endereco, especialidade, numeroIdentificacao);

        boolean sucesso = controlaMedico.editarMedico(medico);

        if (sucesso){
            System.out.println("Medico editado com sucesso!");
        } else{
            System.out.println("Erro ao editar medico.");
        }
    }

    private void removerMedico() {
        System.out.print("ID do medico a ser removido: ");
        int id = scanner.nextInt();

        boolean sucesso = controlaMedico.removerMedico(id);
        if (sucesso){
            System.out.println("Medico removido com sucesso!");
        } else{
            System.out.println("Erro ao remover medico.");
        }
    }

    public void gerenciarConsultas(){
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\nGerenciamento de Consultas");
            System.out.println("1. Adicionar Consulta");
            System.out.println("2. Listar Consultas");
            System.out.println("3. Editar Consulta");
            System.out.println("4. Remover Consulta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Código para adicionar consulta
                    System.out.println("Adicionando consulta...");
                    break;
                case 2:
                    // Código para listar consultas
                    System.out.println("Listando consultas...");
                    break;
                case 3:
                    // Código para editar consulta
                    System.out.println("Editando consulta...");
                    break;
                case 4:
                    // Código para remover consulta
                    System.out.println("Removendo consulta...");
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }
}
