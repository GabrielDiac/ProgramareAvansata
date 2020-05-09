package com.example.demo.Controllers;


import com.example.demo.models.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/demoPA")
public class PlayerController {
    @Autowired
    private PlayerService playerS;

    @GetMapping(path = "/players")
    public List<Player> getPlayers() {
        return playerS.listAll();

    }
    @PostMapping("/players/insertPlayer")
    public void add(@RequestBody Player player) {
        playerS.save(player);
    }
    @PutMapping("/players/update/{id}")
    public ResponseEntity<?> update(@RequestBody Player player) {


            if(playerS.exist(player.getId()))
            { playerS.save(player);
            return new ResponseEntity<>(HttpStatus.OK);}
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/players/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        if(playerS.exist(id))
        { playerS.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);}
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
