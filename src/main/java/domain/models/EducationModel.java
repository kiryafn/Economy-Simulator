package domain.models;

import data.Model;
import data.annotations.Bind;

public class EducationModel implements Model{
    @Bind private int[] YEARS;      //years [from, to]

    @Bind private double[] grSTUD;  //growth rate of students
    @Bind private double[] grTEA;   //growth rate of teachers

    @Bind private double[] STUD;    //student's number
    @Bind private double[] TEA;     //teacher's number
    @Bind private double[] STUDENT_TEACHER_RATIO;    //students per teacher

    public EducationModel() { }

    @Override
    public void run() {
        STUDENT_TEACHER_RATIO = new double[YEARS.length];
        STUDENT_TEACHER_RATIO[0] = STUD[0] / TEA[0];
        for (int t = 1; t < YEARS.length; t++) {
            STUD[t] = grSTUD[t] * STUD[t - 1];
            TEA[t] = grTEA[t] * TEA[t - 1];
            STUDENT_TEACHER_RATIO[t] = STUD[t] / TEA[t];
        }
    }
}