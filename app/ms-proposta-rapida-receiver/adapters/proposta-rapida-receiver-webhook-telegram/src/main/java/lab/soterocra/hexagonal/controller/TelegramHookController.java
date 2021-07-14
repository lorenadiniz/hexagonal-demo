package lab.lorenadiniz.hexagonal.controller;

import lab.lorenadiniz.hexagonal.dto.TelegramDTO;
import lab.lorenadiniz.hexagonal.mapper.TelegramMapper;
import lab.lorenadiniz.hexagonal.ports.in.ReceiverPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("telegram-hook")
public class TelegramHookController {

    private final ReceiverPort port;
    private final TelegramMapper mapper = new TelegramMapper();

    @PostMapping
    private ResponseEntity<Void> hook(@RequestBody TelegramDTO body) throws Exception {
        port.hook(mapper.toDomainMessage(body));
        return ResponseEntity.ok().build();
    }

}
