package com.company;

import java.util.Queue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
//import java.util.Queue;
//import LabClient.StudyGroup;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.*;
import java.util.prefs.BackingStoreException;

/**
 *
 * Main class with reading file part
 * @author Anatoly Novikov
 * @version 1.1
 * new lab: 331137
 *
 */
public class InputDecoder {
    /**
     * converts string to enum
     * @param s string
     * @return form of education
     */
    public static StudyGroup.FormOfEducation findEnum1(String s) {
        s = s.toUpperCase();
        StudyGroup.FormOfEducation command = null;
        for (int i = 0; i < StudyGroup.FormOfEducation.values().length; i++) {
            if (s.equals(StudyGroup.FormOfEducation.values()[i].toString())) {
                command = StudyGroup.FormOfEducation.values()[i];
            }
        }
        return command;
    }
    /**
     * converts string to enum
     * @param s string
     * @return color
     */
    public static StudyGroup.Color findEnum3(String s) {
        s = s.toUpperCase();
        StudyGroup.Color command = null;
        for (int i = 0; i < StudyGroup.Color.values().length; i++) {
            if (s.equals(StudyGroup.Color.values()[i].toString())) {
                command = StudyGroup.Color.values()[i];
            }
        }
        return command;
    }
    /**
     * converts string to enum
     * @param s string
     * @return semester
     */
    public static StudyGroup.Semester findEnum2(String s) {
        s = s.toUpperCase();
        StudyGroup.Semester command = null;
        for (int i = 0; i < StudyGroup.Semester.values().length; i++) {
            if (s.equals(StudyGroup.Semester.values()[i].toString())) {
                command = StudyGroup.Semester.values()[i];
            }
        }
        return command;
    }
    /**
     * converts string to int
     * @param str
     * @return count of students int
     */
    static Integer toStudentsCount(String str) {
        str = str.trim();
        Integer n;
        try {
            n = Integer.valueOf(str);
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }
    /**
     *converts string to long
     * @param str
     * @return long
     */
    static Long toLocation(String str) {
        str = str.trim();

        try {
            Long x = Long.valueOf(str);
            return x;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * converts string to int
     * @param str
     * @return int
     */
    static int toExpelledStudents(String str) {
        str = str.trim();
        int n = 0;
        try {
            n = Integer.valueOf(str);
        } finally {
            return n;
        }
    }
    /**
     * converts string to float
     * @param str
     * @return float
     */
    static Float toCoordinatesX(String str) {
        str = str.trim();

        try {
            float x = Float.valueOf(str);
            return x;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * converts string to int
     * @param str
     * @return int
     */
    static Integer toCoordinatesY(String str) {
        str = str.trim();
        //String[] words = str.split(" ");
        //System.out.println(str);

        try {
            int y = Integer.valueOf(str);
            //int y = Integer.valueOf(words[1]);
            //System.out.println(x);
            //System.out.println(y);
            //StudyGroup.Coordinates coord = new StudyGroup.Coordinates();
            //coord.setX(x);
            //coord.setY(y);
            //coord.x = x;
            return y;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * check value
     * @param o
     * @return boolean
     */
    static boolean isExpelledStudents(int o) {
        if (o > 0) {
            return true;
        } else return false;
    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalStudentsCount(int o) {
        if (o > 0) {
            return true;
        } else return false;
    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalCoordinates(StudyGroup.Coordinates o) {
        //String s = "";
        try {
            if (o.getY() != null && o.getX() != null) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }

    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalName(String o) {
        try {
            o = o.trim();
            //System.out.println(o);
            if (o != null && o != "" && o.length() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalEnum(Object o) {
        if (o != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * check value
     * @param l
     * @return
     */
    static boolean isNormalLocation(StudyGroup.Location l) {
        if (l.getX() != null && l.getY() != null && l.getZ() != null && l.getName() != null) {
            return true;
        } else return false;
    }}
/**
 * all stuff here
 *
 * @return
 */
