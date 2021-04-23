package com.company;

import java.io.Serializable;

public class StudyGroup implements Comparable, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Integer expelledStudents; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле не может быть null

    /**
     *
     * @return name
     */
    public String get_name(){
        return this.name;
    }

    /**
     *
     * @return id
     */
    public int get_id(){
        return this.id;
    }

    /**
     *
     * @return coordinates
     */
    String getCoordinates(){
        return this.coordinates.getX().toString()+" "+this.coordinates.getY().toString();
    }

    /**
     *
     * @return coordinates
     */
    public String getXCoord(){return String.valueOf(this.coordinates.getX());}
    public String getYCoord(){return String.valueOf(this.coordinates.getY());}
    java.util.Date getCreationDate(){
        return this.creationDate;
    }

    /**
     *
     * @return students count
     */
    public Integer getStudentsCount(){
        return this.studentsCount;
    }

    /**
     *
     * @return expelled students
     */
    public Integer getExpelledStudents(){
        return this.expelledStudents;
    }

    /**
     *
     * @return form of education
     */
    public FormOfEducation getFormOfEducation(){
        return this.formOfEducation;
    }

    /**
     *
     * @return semester enum
     */
    public Semester getSemesterEnum(){
        return this.semesterEnum;
    }

    /**
     *
     * @return group admin
     */
    public Person getGroupAdmin(){
        return this.groupAdmin;
    }

    /**
     *
     * @param s
     */
    public void setName(String s){
        this.name = s;
    }

    /**
     *
     * @param s
     */
    public void setCoordinates(Coordinates s){
        this.coordinates = s;
    }

    /**
     *
     * @param n
     */
    public void setStudentsCount(int n){this.studentsCount=n;}

    /**
     *
     * @param n
     */
    public void setExpelledStudents(int n){this.expelledStudents=n;}

    /**
     *
     * @param p
     */
    public void setGroupAdmin(Person p){this.groupAdmin=p;}

    /**
     *
     * @param f
     */
    public void setFormOfEducation(FormOfEducation f){this.formOfEducation =f;}

    /**
     *
     * @param s
     */
    public void setSemesterEnum(Semester s){this.semesterEnum=s;}

    /**
     *
     * @param id
     */
    void setID(int id){this.id = id;}

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = ("Group ID: " + this.get_id() + "\n" + "Group name: " + this.get_name() + "\n" + "Group coordinates: x=" + this.coordinates.getX() + " y="+this.coordinates.getY() + "\n");
        s += ("Group students count: " + this.getStudentsCount() +"\n"+ "Group expelled students; " + this.getExpelledStudents() + "\n");
        s += ("Group education form: " + this.getFormOfEducation() + "\n" + "Group semester: " + this.getSemesterEnum());
        s += ("\n" + "Group admin: \n name: " + this.getGroupAdmin().getName() + "\n " + "eye color: " + this.getGroupAdmin().getEyeColor() + "\n");
        // s += ()
        return s;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static class Coordinates implements Serializable{
        private Float x; //Поле не может быть null
        private Integer y; //Максимальное значение поля: 538, Поле не может быть null

        public void setX(Float x) {
            this.x = x;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        public Float getX() {
            return x;
        }
        public Integer getY(){return y;}
    }
    public static class Person implements Serializable{
        private String name; //Поле не может быть null, Строка не может быть пустой
        private java.time.LocalDateTime birthday; //Поле не может быть null
        private Color eyeColor; //Поле не может быть null
        private Color hairColor; //Поле может быть null
        private Location location; //Поле не может быть null
        public void setName(String s){this.name=s;}
        public void setLocation(Location l){this.location=l;}
        public Location getLocation(){return this.location;}
        public String getName(){return  this.name;}
        public Color getEyeColor(){return this.eyeColor;}
        public Color getHairColor(){return this.hairColor;}
        public void setEyeColor(Color c){this.eyeColor=c;}
        public void setHairColor(Color c){this.hairColor=c;}
    }
    public static class Location implements Serializable{
        private Long x; //Поле не может быть null
        private Long y;
        private Long z; //Поле не может быть null
        private String name; //Поле не может быть null
        public void setLocation(Long x, Long y, Long z, String name){this.x=x;this.y=y;this.z=z;this.name=name;}
        public Long getX(){return this.x;}
        public Long getY(){return this.y;}
        public Long getZ(){return this.z;}
        public String getName(){return this.name;}
    }
    public enum FormOfEducation {
        DISTANCE_EDUCATION ,
        FULL_TIME_EDUCATION,
        EVENING_CLASSES;
    }
    public enum Semester {
        FOURTH,
        FIFTH,
        EIGHTH;
    }
    public enum Color {
        GREEN,
        RED,
        BLUE,
        YELLOW,
        BROWN,
        BLACK,
        ORANGE,
        WHITE;
    }
    public int compareTo(StudyGroup group){
        return Integer.valueOf(this.getStudentsCount()/this.getExpelledStudents()- group.getStudentsCount()/group.getExpelledStudents());
    }
    StudyGroup createStudyGroup(){
        StudyGroup SG = new StudyGroup();
        return SG;
    }
}