package com.commands.api.commandsAPI.controllers;

import com.commands.api.commandsAPI.entities.Command;
import com.commands.api.commandsAPI.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Talks to service class
@RequestMapping("/api")
public class CommandController {
    @Autowired
    private CommandService commandService; //Inject service


    //Binds Content of the HTTP request body to the command parameter.
    @PostMapping("/addCommand")
    public Command addCommand(@RequestBody Command command){
        return commandService.saveCommand(command);
    }
    @PostMapping("/addCommands")
    public List<Command> addCommands(@RequestBody List<Command> commands){
        return  commandService.saveCommands(commands);
    }

    @GetMapping("/allCommands")
    public List<Command> getAllCommands() {
        return commandService.getAllCommands();
    }
    @GetMapping("commandsByOs/{os}")
    public List<Command> getCommandsByOs(@PathVariable String os){
        return commandService.commandsByOs(os);
    }
    @GetMapping("/commandById/{id}")
    public Command findCommandById(@PathVariable Integer id){ //PathVariable allows to use {id}
        return commandService.getCommandById(id);
    }

    @GetMapping("/commandByName/{name}")
    public Command findCommandByName(@PathVariable String name){
        return commandService.getCommandByName(name);
    }

    @PutMapping("/updateCommand")
    public Command updateCommand(@RequestBody Command command){
        return commandService.updateCommand(command);
    }



    @DeleteMapping("/deleteById/{id}")
    public String deleteCommand(@PathVariable Integer id){
        return commandService.deleteCommand(id);
    }

}
