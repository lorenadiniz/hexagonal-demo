package lab.lorenadiniz.hexagonal.ports.out;

import lab.lorenadiniz.hexagonal.domain.model.Message;

public interface PostMessagePort {
    void sendMessage(Message message);
}
