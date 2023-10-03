package com.commands.api.commandsAPI.repositories;

import com.commands.api.commandsAPI.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommandRepository extends JpaRepository<Command,Integer>{
    Command findByName(String name);
    List<Command> findByOs(String os);
}
