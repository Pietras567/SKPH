package Mail;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

// Importy wygenerowanych klas z mailSystem.proto
import Mail.GreeterGrpc;
import Mail.MailSystem.mailRequest;
import Mail.MailSystem.mailResponse;

@Service
public class MailManager {
    // Tworzenie kanału połączenia z serwerem
    ManagedChannel channel;

    // Tworzenie stub'a klienta
    private GreeterGrpc.GreeterBlockingStub stub;

    @PostConstruct
    private void init() {
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        stub = GreeterGrpc.newBlockingStub(channel);
    }

    @PreDestroy
    private void destroy() {
        channel.shutdown();
    }

    public void sendMail(String mail, String name, int accountType) {
        // Budowanie żądania
        mailRequest request = mailRequest.newBuilder()
                .setEmail(mail)
                .setName(name)
                .setAccountType(accountType)
                .build();

        // Wysłanie żądania i odbiór odpowiedzi
        mailResponse response = stub.sendMail(request);

        // Dodatkowa logika (np. logowanie odpowiedzi)
        System.out.println("Odpowiedź z serwera: " + response);
    }
}
