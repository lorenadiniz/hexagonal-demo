package lab.lorenadiniz.hexagonal.ports.in;

import lab.lorenadiniz.hexagonal.domain.model.Message;

public interface ReceiverPort {
    void hook(Message message) throws Exception;
}
