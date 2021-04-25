package com.company;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

/**
 * contains all collections elements and info
 */

public class Collection {
    public Queue<StudyGroup> collection;
    public String adress1;
    public String adress2;

    public Collection(){
        collection = new PriorityQueue<StudyGroup>();
    }

    /**
     * adds new element
     * @param studyGroup
     */
    public void add(StudyGroup studyGroup){
        this.collection.add(studyGroup);
    }
    /**
     * shows all elements
     */
    public String show(){
        List<List<String>> rows = new ArrayList<>();
        List<String> headers = Arrays.asList("Name", "id", "Coordinates ", "CreationDate", "StudentsCount", "ExpelledStudents", "FormOfEducation", "SemesterEnum", "GroupAdmin");
        rows.add(headers);
        StringBuilder coord = new StringBuilder();
        ArrayList<String> sb = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (StudyGroup sg : collection) {
            sb.add(sg.getName());sb.add(String.valueOf(sg.getId()));

            coord.append(sg.getCoordinates().getX()).append(", ").append(sg.getCoordinates().getY());
            sb.add(coord.toString());
            coord.delete(0, coord.length());

            sb.add(sg.getCreationDate().toString());

            sb.add(sg.getStudentsCount().toString()); sb.add(sg.getExpelledStudents().toString());

            sb.add(sg.getFormOfEducation().toString());
            sb.add(sg.getSemesterEnum().toString());

            sb.add(sg.getGroupAdmin().getName());

            rows.add((List<String>) sb.clone());
            sb.clear();
        }
        return Terminal.formatAsTable(rows);
    }
    /**
     * removes element
     * @param n
     */
    void remove_by_ID(Integer n){
        for(int i= 0; i<this.collection.size();i++){
            StudyGroup Group = new StudyGroup();
            Group = this.collection.poll();
            if (Group.getId() != n)
                //System.out.println(Group.toString());
                collection.add(Group);
        }
        System.out.println("Element "+ n +" was removed");
    }
    /**
     * removes all
     */
    void clear(){
        for(int i=0; i<=collection.size();i++){
            collection.poll();
        }
        System.out.println("Collection is clear");
    }
    /**
     * removes all greater
     * @param id
     */
    void remove_greater(int id){
        try{
            StudyGroup clt[] = new StudyGroup[this.collection.size()];
            int n = this.collection.size();
            StudyGroup group = new StudyGroup();
            for (int i = 0; i < n; i++) {
                clt[i] = this.collection.remove();
                if (clt[i].getId() == id){
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
        int n = this.collection.size();
        StudyGroup clt[] = new StudyGroup[this.collection.size()];
        for (int i = 0; i < n; i++) {
            clt[i] = this.collection.remove();
        }
        int element;
        boolean check;
        for (int i = 0; i<n;i++){
            element = clt[i].getStudentsCount();
            check = false;
            for (int i1 = 0; i1 < n; i1++){
                if (element == clt[i1].getStudentsCount() && clt[i].getId() != clt[i1].getId()){
                    check = true;
                }
            }
            if(!check){
                System.out.println(clt[i].getStudentsCount());
            }

        }
        for (int i = 0; i< n; i++){
            this.collection.add(clt[i]);
        }
    }
    /**
     * add if lowest element
     * @param group
     */
    void add_if_lowest(StudyGroup group){
        int n = this.collection.size();
        StudyGroup clt[] = new StudyGroup[this.collection.size()];
        for (int i = 0; i < n; i++) {
            clt[i] = this.collection.remove();
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
            StudyGroup clt[] = new StudyGroup[this.collection.size()];
            int n = this.collection.size();
            StudyGroup group = new StudyGroup();
            for (int i = 0; i < n; i++) {
                clt[i] = this.collection.remove();
                if (clt[i].getId() == id){
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
        StudyGroup clt[] = new StudyGroup[this.collection.size()];
        int n = this.collection.size();
        StudyGroup group = new StudyGroup();
        for (int i = 0; i < n; i++) {
            clt[i] = this.collection.remove();
            if (clt[i].getName().contains(str)){
                System.out.println(clt[i].getName());
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
        int n = this.collection.size();
        StudyGroup clt[] = new StudyGroup[n];
        for (int i = 0; i<n;i++){
            clt[i] = this.collection.remove();
        }
        for (int i = 0; i < n; i++) {
            sb.append("\t").append("<StudyGroup>").append("\n");

            sb.append("\t\t").append("<Name>").append(clt[i].getName()).append("</Name>").append("\n");
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
