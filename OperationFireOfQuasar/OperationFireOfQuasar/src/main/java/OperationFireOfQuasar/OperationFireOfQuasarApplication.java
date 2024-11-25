package operationFireOfQuasar;


import operationFireOfQuasar.infraestructure.input.ConsoleAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OperationFireOfQuasarApplication implements CommandLineRunner {

    @Autowired
    private ConsoleAdapter level1;

    public static void main(String[] args) {
        SpringApplication.run(OperationFireOfQuasarApplication.class, args);
    }
    

    public ConsoleAdapter getLevel1() {
        return level1;
    }

    public void setLevel1(ConsoleAdapter level1) {
        this.level1 = level1;
    }

    public void run(String... args) throws Exception {
        this.level1.level1Controller();
    }
    
    

}
