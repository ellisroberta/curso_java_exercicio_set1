package application;

import model.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        // Criação de um Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Solicita ao usuário que insira o caminho completo do arquivo de log
        System.out.print("Enter file full path: "); // in.txt
        String path = sc.nextLine();

        // Tenta ler o arquivo de log
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // Utiliza um conjunto (Set) para armazenar entradas de log únicas
            Set<LogEntry> set = new HashSet<>(); // mais rápido e não importa a ordem de entrada (nesse problema)

            // Lê a primeira linha do arquivo
            String line = br.readLine();
            // Continua lendo até que não haja mais linhas
            while (line != null) {

                // Divide a linha em partes: nome de usuário e timestamp
                String[] fields = line.split(" ");
                String username = fields[0]; // Primeiro campo é o nome de usuário
                // O segundo campo é a data/hora em formato ISO 8601, que é convertido para Date
                Date moment = Date.from(Instant.parse(fields[1]));

                // Adiciona uma nova entrada de log ao conjunto
                set.add(new LogEntry(username, moment));

                // Lê a próxima linha do arquivo
                line = br.readLine();
            }
            // Exibe o total de usuários distintos que acessaram o site
            System.out.println("Total users: " + set.size());

        } catch (IOException e) {
            // Se ocorrer um erro ao ler o arquivo, exibe uma mensagem de erro
            System.out.println("Error: " + e.getMessage());
        }
        // Fecha o scanner para evitar vazamentos de recursos
        sc.close();
    }
}