package model.entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {

    // Atributos da classe LogEntry
    private String username; // Nome de usuário que acessou o site
    private Date moment; // Momento em que o acesso ocorreu

    // Construtor que inicializa os atributos
    public LogEntry(String username, Date moment) {
        this.username = username;
        this.moment = moment;
    }

    // Getter para o nome de usuário
    public String getUsername() {
        return username;
    }

    // Setter para o nome de usuário
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter para a data e hora do acesso
    public Date getMoment() {
        return moment;
    }

    // Setter para a data e hora do acesso
    public void setMoment(Date moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        // Verifica se o objeto atual é o mesmo que o objeto comparado
        if (this == o) return true;
        // Verifica se o objeto comparado é do tipo LogEntry
        if (!(o instanceof LogEntry)) return false;

        // Faz o cast para LogEntry
        LogEntry logEntry = (LogEntry) o;

        // Compara apenas o atributo username, considerando possíveis valores nulos
        return Objects.equals(username, logEntry.username);
    }

    @Override
    public int hashCode() {
        // Gera um código hash baseado apenas no atributo username
        return Objects.hash(username);
    }

    /**
     * - A implementação dos métodos equals e hashCode é fundamental para a comparação correta de objetos do tipo LogEntry, especialmente em coleções como Set e Map.
     * - Utiliza Objects.equals(...) e Objects.hash(...) para simplificar o código e tratar valores nulos, evitando NullPointerException.
     * - A verificação 'if (this == o)' permite uma comparação rápida entre referências.
     * - O uso de 'instanceof' assegura que o objeto comparado é do tipo LogEntry, evitando falhas de tipo.
     * - A comparação de username e moment considera valores nulos, garantindo robustez.
     * - O método hashCode gera um valor único baseado nos atributos relevantes, mantendo a consistência com equals.
     * - Se dois objetos são iguais segundo equals, devem ter o mesmo hash code, conforme as convenções de Java.
     * - Para evitar problemas em coleções, considere tornar username e moment finais (final) se não devem ser alterados após a criação.
     **/
}