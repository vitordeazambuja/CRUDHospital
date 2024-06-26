package view;

import controller.ControlaPaciente;
import model.Paciente;

import controller.ControlaMedico;
import model.Medico;

import controller.ControlaConsulta;
import model.Consulta;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ControlaPaciente controlaPaciente;
    private ControlaMedico controlaMedico;
    private ControlaConsulta controlaConsulta;

    public Menu(){
        this.scanner = new Scanner(System.in);
        this.controlaPaciente = new ControlaPaciente();
        this.controlaMedico = new ControlaMedico();
        this.controlaConsulta = new ControlaConsulta();
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
                System.out.println("Paciente ID: " + paciente.getId());
                System.out.println("Nome: " + paciente.getNome());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("Data de Nascimento: " + paciente.getDataNascimento());
                System.out.println("Sexo: " + paciente.getSexo());
                System.out.println("Email: " + paciente.getEmail());
                System.out.println("Telefone: " + paciente.getTelefone());
                System.out.println("Endereco: " + paciente.getEndereco());
                System.out.println("Numero de Identificacao: " + paciente.getNumeroIdentificacao());
                System.out.println();
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
            for (Medico medico : medicos) {
                System.out.println("Medico ID: " + medico.getId());
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CPF: " + medico.getCpf());
                System.out.println("Email: " + medico.getEmail());
                System.out.println("Telefone: " + medico.getTelefone());
                System.out.println("Endereco: " + medico.getEndereco());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("Numero de Identificacao: " + medico.getNumeroIdentificacao());
                System.out.println();
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

    public void gerenciarConsultas() {
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
                    adicionarConsulta();
                    break;
                case 2:
                    listarConsultas();
                    break;
                case 3:
                    editarConsulta();
                    break;
                case 4:
                    removerConsulta();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    private void adicionarConsulta() {
        scanner.nextLine();

        System.out.print("ID do Paciente: ");
        int pacienteId = scanner.nextInt();
        System.out.print("ID do Medico: ");
        int medicoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data (AAAA-MM-DD): ");
        String data = scanner.nextLine();
        System.out.print("Hora (HH:MM): ");
        String hora = scanner.nextLine();

        Paciente paciente = new Paciente();
        paciente.setId(pacienteId);

        Medico medico = new Medico();
        medico.setId(medicoId);

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setData(data);
        consulta.setHora(hora);

        boolean sucesso = controlaConsulta.adicionarConsulta(consulta);
        if (sucesso) {
            System.out.println("Consulta adicionada com sucesso!");
        } else {
            System.out.println("Erro ao adicionar consulta.");
        }
    }

    private void listarConsultas() {
        List<Consulta> consultas = controlaConsulta.listarConsultas();

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            for (Consulta consulta : consultas) {
                System.out.println("Consulta ID: " + consulta.getId());
                System.out.println("Paciente: " + consulta.getPaciente().getNome());
                System.out.println("Medico: " + consulta.getMedico().getNome());
                System.out.println("Data: " + consulta.getData());
                System.out.println("Hora: " + consulta.getHora());
                System.out.println();
            }
        }
    }

    private void editarConsulta() {
        System.out.print("ID da consulta a ser editada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Paciente: ");
        int pacienteId = scanner.nextInt();
        System.out.print("ID do Medico: ");
        int medicoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nova data (AAAA-MM-DD): ");
        String data = scanner.nextLine();
        System.out.print("Nova hora (HH:MM): ");
        String hora = scanner.nextLine();

        Paciente paciente = new Paciente();
        paciente.setId(pacienteId);

        Medico medico = new Medico();
        medico.setId(medicoId);

        Consulta consulta = new Consulta();
        consulta.setId(id);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setData(data);
        consulta.setHora(hora);

        boolean sucesso = controlaConsulta.editarConsulta(consulta);
        if (sucesso) {
            System.out.println("Consulta editada com sucesso!");
        } else {
            System.out.println("Erro ao editar consulta.");
        }
    }

    private void removerConsulta() {
        System.out.print("ID da consulta a ser removida: ");
        int id = scanner.nextInt();

        boolean sucesso = controlaConsulta.removerConsulta(id);
        if (sucesso) {
            System.out.println("Consulta removida com sucesso!");
        } else {
            System.out.println("Erro ao remover consulta.");
        }
    }
}
