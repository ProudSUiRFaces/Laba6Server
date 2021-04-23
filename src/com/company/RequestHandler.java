package com.company;

import javax.xml.bind.Element;

public class RequestHandler {
    Collection collection = new Collection();
    public String consoleDecoder(Messages messages){
        String str = new String();
        Enter enter =(Enter) messages.strings.get(0);
        if (enter == Enter.HELP){
            str = "Available commands: \nhelp : вывести справку по доступным командам"+ "\n";
            str += "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n";
            str += "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n";
            str += "add {element} : добавить новый элемент в коллекцию\n";
            str += "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n";
            str += "remove_by_id id : удалить элемент из коллекции по его id\n";
            str += "clear : очистить коллекцию\n";
            str += "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n";
            str += "exit : завершить программу (без сохранения в файл)\n";
            str += "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n";
            str += "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n";
            str += "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n";
            str += "min_by_name : вывести любой объект из коллекции, значение поля name которого является минимальным\n";
            str += "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку\n";
            str += "print_unique_students_count : вывести уникальные значения поля studentsCount всех элементов в коллекции";
        } if (enter == Enter.ADD){
            this.collection.Collection.add((StudyGroup) messages.strings.get(1));
            System.out.println("check");
            str = "Element was added";
        } if (enter == Enter.UPDATE){
            try {
                System.out.println(messages.strings.get(1));
                this.collection.remove_by_ID(Integer.valueOf((String) messages.strings.get(1)));
                StudyGroup group = (StudyGroup) messages.strings.get(2);
                group.setID((Integer) messages.strings.get(1));
                str = "Element was updated";
            }catch (ArrayIndexOutOfBoundsException e){
                str = "No such ID";
            }
        }
        /*else{
            str = "Something wrong, try help";
        }*/
        System.out.println(this.collection.Collection);
        System.out.println(enter);
        return str;
    }
}
