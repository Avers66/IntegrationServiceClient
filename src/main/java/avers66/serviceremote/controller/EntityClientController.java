package avers66.serviceremote.controller;

import avers66.serviceremote.clients.OkHttpClientSender;
import avers66.serviceremote.model.EntityModel;
import avers66.serviceremote.model.EntityRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * EntityClientController
 *
 * @Author Tretyakov Alexandr
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class EntityClientController {

    private final OkHttpClientSender client;

    @GetMapping
    public ResponseEntity<List<EntityModel>> entityList() {
        return ResponseEntity.ok(client.getEntityList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<EntityModel> getEntityByName(@PathVariable String name) {
        return ResponseEntity.ok(client.getEntityByName(name));
    }

    @PostMapping
    public ResponseEntity<EntityModel> createEntity(@RequestBody EntityRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(client.createEntity(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel> updateEntity(@PathVariable UUID id, @RequestBody EntityRequest request) {
        return ResponseEntity.ok(client.updateEntity(id, request));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteEntity(@PathVariable UUID id) {
        client.deleteEntityById(id);
        return ResponseEntity.noContent().build();
    }

}
