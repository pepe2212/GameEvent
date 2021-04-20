package com.truelogic.playersProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truelogic.playersProject.model.Player;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, Integer>{

}
