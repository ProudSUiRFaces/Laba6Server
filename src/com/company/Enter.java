package com.company;

public enum Enter {
    HELP ("","Available commands"),
    INFO ("","Information about current stat of Collection"),
    SHOW ("","Prints all the elements"),
    ADD ("","Add a new worker"),
    UPDATE("{id}","Update worker's fields"),
    REMOVE_BY_ID("{id}","Removes worker"), //it's not me shit-naming, it's the tech task
    CLEAR("","Clears the database"),
    SAVE("","Save the database to a file"),
    EXECUTE_SCRIPT("",""),
    EXIT("","Exit database"),
    ADD_IF_MAX("","Add element, if its SALARY is max"),
    REMOVE_GREATER("{salary}","Remove all elements, greater than given"),
    REMOVE_LOWER("{salary}","Remove all elements, lower than given"),
    GROUP_COUNTING_BY_POSITION("","Print groups made by position"),
    COUNT_LESS_THAN_START_DATE("{start date (yyyy-mm-dd)}","Print number of elements with START DATE lesser than given"),
    FILTER_GREATER_THAN_START_DATE("{start date (yyyy-mm-dd)}","Print elements with START DATE greater than given"),
    ERROR("",""),
    FATAL_ERROR("","");

    private String argument;
    private String description;

    Enter(String argument, String description) {
        this.argument = argument;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getArgument(){
        return argument;
    }

    public static String[] getCommands() {
        String[] commands = new String[Enter.values().length];
        Enter[] commandsEnum = values();
        for (int i = 0; i < Enter.values().length; i++) {
            commands[i] = commandsEnum[i].toString();
        }
        return commands;
    }

    public static String[] getCommandsWithDescriptions() {
        String[] commands = new String[Enter.values().length];
        Enter[] commandsEnum = values();
        for (int i = 0; i < Enter.values().length; i++) {
            if (!commandsEnum[i].getArgument().equals("")){
                commands[i] = commandsEnum[i].toString() + " " + commandsEnum[i].getArgument() + ": " + commandsEnum[i].getDescription();
            } else {
                commands[i] = commandsEnum[i].toString() + ": " + commandsEnum[i].getDescription();
            }
        }
        return commands;
    }
}