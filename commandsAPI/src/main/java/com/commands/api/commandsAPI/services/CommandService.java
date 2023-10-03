package com.commands.api.commandsAPI.services;


import com.commands.api.commandsAPI.entities.Command;
import com.commands.api.commandsAPI.repositories.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    @Autowired
    private CommandRepository commandRepository;
    //Save a Command
    public Command saveCommand(Command command) {
        return commandRepository.save(command);
    }
    public List<Command> saveCommands(List<Command> commands){
        return commandRepository.saveAll(commands);
    }
    // Get all commands
    public List<Command> getAllCommands(){
        return commandRepository.findAll();
    }
    //Get a command by its id

    public List<Command> commandsByOs(String os){
        return commandRepository.findByOs(os);
    }

    public Command getCommandById(Integer id){
        return commandRepository.findById(id).orElse(null);
    }

    public Command getCommandByName(String name){
        return commandRepository.findByName(name);
    }
    public String deleteCommand(Integer id){
        commandRepository.deleteById(id);
        return "product removed !!" +id;
    }

    public Command updateCommand(Command command){
        Command existingCommand = commandRepository.findById(command.getId()).orElse(null);
        existingCommand.setName(command.getName());
        existingCommand.setOs(command.getOs());
        existingCommand.setCommand(command.getCommand());
        existingCommand.setShort_description(command.getShort_description());
        return commandRepository.save(existingCommand);

    }


}
