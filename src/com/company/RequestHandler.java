package com.company;

public class RequestHandler {

    private Collection collection;

    public RequestHandler(Collection database){
        this.collection = database;
    }

    public String consoleDecoder(Messages messages){
        StringBuilder sb = new StringBuilder();
        String output;
        Enter enter =(Enter) messages.strings.get(0);

        System.out.println("Command was " + enter.toString());

        switch (enter){
            case HELP:
                for (int i = 0; i < Enter.values().length; i++) {
                    sb.append(" " + Enter.getCommandsWithDescriptions()[i] + "\n");
                }
                break;
            case ADD:
                System.out.println("adding");
                collection.add((StudyGroup) messages.strings.get(1));
                System.out.println("check");
                sb.append("Element was added");
                break;
            case UPDATE:
                try {
                    System.out.println(messages.strings.get(1));
                    collection.remove_by_ID(Integer.valueOf((String) messages.strings.get(1)));
                    StudyGroup group = (StudyGroup) messages.strings.get(2);
                    group.setID((Integer) messages.strings.get(1));
                    sb.append("Element was updated");
                }catch (ArrayIndexOutOfBoundsException e){
                    sb.append("No such ID");
                }
                break;
            case SHOW:
                sb.append(collection.show());
                break;
        }

        output = sb.toString();
        sb.delete(0, sb.length());
        return output;
    }
}
