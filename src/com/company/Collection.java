package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

/**
 * contains all collections elements and info
 */

public class Collection {
    public Queue<StudyGroup> Collection = new PriorityQueue<>();
    public String adress1;
    public String adress2;
    //public ZonedDateTime time = ;
    /**
     * adds new element
     * @param studyGroup
     */
    void add(StudyGroup studyGroup){
        this.Collection.add(studyGroup);
    }
    /**
     * creates and adds new element
     * @return
     */
    StudyGroup addElement() {
        StudyGroup Group = new StudyGroup();
        System.out.print("Please, enter the name ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!InputDecoder.isNormalName(str)) {
            System.out.print("Please, enter valid name ");
            str = scanner.nextLine();
            if (str == ""){
                str= null;
            }
        }
        Group.setName(str);
        //System.out.println(Group.get_name());
        StudyGroup.Coordinates c = new StudyGroup.Coordinates();
        c.setX(null);
        c.setY(null);

        while (!InputDecoder.isNormalCoordinates(c)) {
            c.setX(null);
            c.setY(null);
            System.out.print("Please enter X coordinate ");
            str = scanner.nextLine();
            Float X = InputDecoder.toCoordinatesX(str);
            //System.out.println(X);
            System.out.print("Please enter Y coordinate ");
            str = scanner.nextLine();
            Integer Y = InputDecoder.toCoordinatesY(str);
            //System.out.println(Y);
            c.setY(Y);
            c.setX(X);
            //System.out.println(Main.isNormalCoordinates(c));
        }
        Group.setCoordinates(c);
        //System.out.println(Group.getCoordinates());

        Integer n = null;

        while(n == null){
            System.out.print("Enter count of students ");
            str = scanner.nextLine();
            n = InputDecoder.toStudentsCount(str);
        }
        Group.setStudentsCount(n);
        //System.out.println(Group.getStudentsCount());

        n = null;
        while(n == null){
            System.out.print("Enter count of expelled students ");
            str = scanner.nextLine();
            n = InputDecoder.toStudentsCount(str);
        }
        Group.setExpelledStudents(n);
        //System.out.println(Group.getExpelledStudents());

        StudyGroup.FormOfEducation form = null;
        boolean check = false;
        while(!check){
            System.out.print("Enter form of education, possible choices: DISTANCE_EDUCATION, FULL_TIME_EDUCATION, EVENING_CLASSES ");
            try{
                str = scanner.nextLine();
                form = InputDecoder.findEnum1(str);
                if (form != null){
                    check = true;
                }
            }catch (Exception e){}
        }
        Group.setFormOfEducation(form);
        //System.out.println(Group.getFormOfEducation());

        StudyGroup.Semester form1 = null;
        check = false;
        while(check == false){
            System.out.print("Enter semester, possible choices: FOURTH, FIFTH, EIGHTH ");
            try{
                str = scanner.nextLine();
                form1 = InputDecoder.findEnum2(str);
                if (form1 != null){
                    check = true;
                }
            }catch (Exception e){}
        }
        Group.setSemesterEnum(form1);
        //System.out.println(Group.getSemesterEnum());

        StudyGroup.Person person = new StudyGroup.Person();
        System.out.print("Enter admin's name ");

        str = scanner.nextLine();

        while (!InputDecoder.isNormalName(str)) {
            System.out.print("Please, enter valid name ");
            str = scanner.nextLine();
        }

        person.setName(str);

        StudyGroup.Color color = null;
        check = false;
        while(check == false){
            System.out.print("Enter eye color of the admin, possible choices: GREEN, RED, BLUE, YELLOW, BROWN, BLACK, ORANGE, WHITE ");
            try{
                str = scanner.nextLine();
                color = InputDecoder.findEnum3(str);
                if (color != null){
                    check = true;
                }
            }catch (Exception e){}
        }
        person.setEyeColor(color);

        color = null;
        check = false;
        while(check == false){
            System.out.print("Enter hair color of the admin, possible choices: GREEN, RED, BLUE, YELLOW, BROWN, BLACK, ORANGE, WHITE ");
            try{
                str = scanner.nextLine();
                color = InputDecoder.findEnum3(str);
                if (color != null){
                    check = true;
                }
            }catch (Exception e){}
        }
        person.setHairColor(color);

        StudyGroup.Location location = new StudyGroup.Location();
        location.setLocation(null, null, null, null);

        while (!InputDecoder.isNormalLocation(location) ) {
            location.setLocation(null, null, null, null);
            System.out.print("Please enter X coordinate ");
            str = scanner.nextLine();
            Long X = InputDecoder.toLocation(str);
            //System.out.println(X);
            System.out.print("Please enter Y coordinate ");
            str = scanner.nextLine();
            Long Y = InputDecoder.toLocation(str);
            //System.out.println(Y);
            System.out.print("Please enter Z coordinate ");
            str = scanner.nextLine();
            Long Z = InputDecoder.toLocation(str);
            System.out.print("Please enter name ");
            str = scanner.nextLine();
            location.setLocation(X,Y,Z,str);
        }
        person.setLocation(location);
        Group.setGroupAdmin(person);

        System.out.println("seems all right");
        return Group;


    }
    /**
     * shows all elements
     */
    void show(){
        for(int i= 0; i<Collection.size();i++){
            StudyGroup Group = new StudyGroup();
            Group = Collection.poll();
            System.out.println(Group.toString());
            Collection.add(Group);
            //System.out.println(Collection.peek().get_id() + " " + Collection.poll().get_name());
        }
    }
    /**
     * removes element
     * @param n
     */
    void remove_by_ID(Integer n){
        for(int i= 0; i<this.Collection.size();i++){
            StudyGroup Group = new StudyGroup();
            Group = this.Collection.poll();
            if (Group.get_id() != n)
                //System.out.println(Group.toString());
                Collection.add(Group);
        }
        System.out.println("Element "+ n +" was removed");
    }
    /**
     * removes all
     */
    void clear(){
        for(int i=0; i<=Collection.size();i++){
            Collection.poll();
        }
        System.out.println("Collection is clear");
    }
    /**
     * removes all greater
     * @param id
     */
    void remove_greater(int id){
        try{
            StudyGroup clt[] = new StudyGroup[this.Collection.size()];
            int n = this.Collection.size();
            StudyGroup group = new StudyGroup();
            for (int i = 0; i < n; i++) {
                clt[i] = this.Collection.remove();
                if (clt[i].get_id() == id){
                    group = clt[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (clt[i].compareTo(group)<0){
                    this.add(clt[i]);}
            }
            this.add(group);
        } catch (Exception e){
            System.out.println("Something is wrong");
        }
    }
    /**
     * print unique only
     */
    void print_unique(){
        int n = this.Collection.size();
        StudyGroup clt[] = new StudyGroup[this.Collection.size()];
        for (int i = 0; i < n; i++) {
            clt[i] = this.Collection.remove();
        }
        int element;
        boolean check;
        for (int i = 0; i<n;i++){
            element = clt[i].getStudentsCount();
            check = false;
            for (int i1 = 0; i1 < n; i1++){
                if (element == clt[i1].getStudentsCount() && clt[i].get_id() != clt[i1].get_id()){
                    check = true;
                }
            }
            if(!check){
                System.out.println(clt[i].getStudentsCount());
            }

        }
        for (int i = 0; i< n; i++){
            this.Collection.add(clt[i]);
        }
    }
    /**
     * add if lowest element
     * @param group
     */
    void add_if_lowest(StudyGroup group){
        int n = this.Collection.size();
        StudyGroup clt[] = new StudyGroup[this.Collection.size()];
        for (int i = 0; i < n; i++) {
            clt[i] = this.Collection.remove();
        }
        boolean check = true;
        for (int i = 0; i < n; i++){
            if (group.compareTo(clt[i])<0){
                check = false;
            }
        }
        for (int i = 0; i<n; i++){
            this.add(clt[i]);
        }
        if (check == true){
            this.add(group);
        }
    }
    /**
     * removes only if lowest
     * @param id
     */
    void remove_lower(int id){
        try{
            StudyGroup clt[] = new StudyGroup[this.Collection.size()];
            int n = this.Collection.size();
            StudyGroup group = new StudyGroup();
            for (int i = 0; i < n; i++) {
                clt[i] = this.Collection.remove();
                if (clt[i].get_id() == id){
                    group = clt[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (clt[i].compareTo(group)>0){
                    this.add(clt[i]);}
            }
            this.add(group);
        } catch (Exception e){
            System.out.println("Something is wrong");
        }
    }
    /**
     * print name with substring
     * @param str
     */
    void contain_name(String str){
        StudyGroup clt[] = new StudyGroup[this.Collection.size()];
        int n = this.Collection.size();
        StudyGroup group = new StudyGroup();
        for (int i = 0; i < n; i++) {
            clt[i] = this.Collection.remove();
            if (clt[i].get_name().contains(str)){
                System.out.println(clt[i].get_name());
            }
        }
        for (int i = 0; i < n; i++){
            this.add(clt[i]);
        }
    }
    /**
     * prints all collection
     * @return
     */
    public String collectionToString(){
        StringBuilder sb = new StringBuilder();

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
        sb.append("<Base>").append("\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int n = this.Collection.size();
        StudyGroup clt[] = new StudyGroup[n];
        for (int i = 0; i<n;i++){
            clt[i] = this.Collection.remove();
        }
        for (int i = 0; i < n; i++) {
            sb.append("\t").append("<StudyGroup>").append("\n");

            sb.append("\t\t").append("<Name>").append(clt[i].get_name()).append("</Name>").append("\n");
            sb.append("\t\t").append("<Coordinates>").append("\n");
            sb.append("\t\t\t").append("<x>").append(clt[i].getXCoord()).append("</x>").append("\n");
            sb.append("\t\t\t").append("<y>").append(clt[i].getYCoord()).append("</y>").append("\n");
            sb.append("\t\t").append("</Coordinates>").append("\n");
            sb.append("\t\t").append("<StudentsCount>").append(clt[i].getStudentsCount()).append("</StudentsCount>").append("\n");
            sb.append("\t\t").append("<ExpelledStudents>").append(clt[i].getExpelledStudents()).append("</ExpelledStudents>").append("\n");
            sb.append("\t\t").append("<FormOfEducation>").append(clt[i].getFormOfEducation().toString()).append("</FormOfEducation>").append("\n");
            sb.append("\t\t").append("<SemesterEnum>").append(clt[i].getSemesterEnum().toString()).append("</SemesterEnum>").append("\n");
            sb.append("\t\t").append("<GroupAdmin>").append("\n");
            sb.append("\t\t\t").append("<Name>").append(clt[i].getGroupAdmin().getName()).append("</Name>").append("\n");
            sb.append("\t\t\t").append("<EyeColor>").append(clt[i].getGroupAdmin().getEyeColor().toString()).append("</EyeColor>").append("\n");
            sb.append("\t\t\t").append("<HairColor>").append(clt[i].getGroupAdmin().getHairColor().toString()).append("</HairColor>").append("\n");
            sb.append("\t\t\t").append("<Location>").append("\n");
            sb.append("\t\t\t\t").append("<x>").append(clt[i].getGroupAdmin().getLocation().getX()).append("</x>").append("\n");
            sb.append("\t\t\t\t").append("<y>").append(clt[i].getGroupAdmin().getLocation().getY()).append("</y>").append("\n");
            sb.append("\t\t\t\t").append("<z>").append(clt[i].getGroupAdmin().getLocation().getZ()).append("</z>").append("\n");
            sb.append("\t\t\t\t").append("<name>").append(clt[i].getGroupAdmin().getLocation().getName()).append("</name>").append("\n");
            sb.append("\t\t\t").append("</Location>").append("\n");
            sb.append("\t\t").append("</GroupAdmin>").append("\n");
            sb.append("\t").append("</StudyGroup>").append("\n");
            this.add(clt[i]);
        }

        sb.append("</Base>");

        return sb.toString();
    }
    /**
     * parses to xml
     * @param database
     * @param dir
     * @param path
     */
    public static void dataBasetoXML(String database, String dir,String path){
        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter(dir + "/"+path);

            // Creates a BufferedWriter
            BufferedWriter buffer = new BufferedWriter(file);

            //writing and flushing to file
            //System.out.println(database);
            buffer.write(database);
            //System.out.println(dir+"/"+path);
            buffer.flush();

            System.out.println("Database was successfully saved to a new file!");
            buffer.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * writes all to xml
     * @param scanner
     * @return
     */
    public StudyGroup addFromFile(Scanner scanner) {
        try {
            StudyGroup group = new StudyGroup();
            group.setName(scanner.nextLine());
            StudyGroup.Coordinates coordinates = new StudyGroup.Coordinates();
            coordinates.setY(Integer.valueOf(scanner.nextLine()));
            coordinates.setX(Float.valueOf(scanner.nextLine()));
            group.setCoordinates(coordinates);
            group.setStudentsCount(Integer.valueOf(scanner.nextLine()));
            group.setExpelledStudents(Integer.valueOf(scanner.nextLine()));
            group.setFormOfEducation(InputDecoder.findEnum1(scanner.nextLine()));
            group.setSemesterEnum(InputDecoder.findEnum2(scanner.nextLine()));
            StudyGroup.Person person = new StudyGroup.Person();
            person.setName(scanner.nextLine());
            StudyGroup.Location location = new StudyGroup.Location();
            location.setLocation(Long.valueOf(scanner.nextLine()), Long.valueOf(scanner.nextLine()), Long.valueOf(scanner.nextLine()), scanner.nextLine());
            person.setLocation(location);
            return group;

        } catch (Exception e) {
            System.out.println("file is wrong");
            return null;
        }
    }
}
