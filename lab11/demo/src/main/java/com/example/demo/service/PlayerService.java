package com.example.demo.service;

import com.example.demo.models.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PlayerService {


        @Autowired
        private PlayerRepository repo;

        public List<Player> listAll() {
            List<Player> players=repo.findAll();
            return players;
        }

        public void save(Player player) {
            repo.save(player);
        }

        public Player get(Integer id) {
            return repo.findById(id).get();
        }
        public Boolean exist(Integer id) {

            return repo.existsById(id);
         }

        public void delete(Integer id) {
            repo.deleteById(id);
        }

}
