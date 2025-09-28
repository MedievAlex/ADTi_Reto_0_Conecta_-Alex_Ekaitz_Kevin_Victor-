package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author Alex, Ekaitz, Kevin & Victor
 */
public class ExamSession {

    /**
     * Variables.
     */
    private String session;
    private String description;
    private Date session_date;
    private String course;
    private int eId;

    /**
     * Empty constructor.
     */
    public ExamSession() {
        this.session = "";
        this.description = "";
        this.session_date = Date.valueOf(LocalDate.now());
        this.course = "";
        this.eId = 0;
    }

    /**
     * Parametized constructor to create the EXAM SESSION with all the
     * variables.
     *
     * @param session
     * @param description
     * @param session_date
     * @param course
     * @param eId
     */
    public ExamSession(String session, String description, Date session_date, String course, int eId) {
        this.session = session;
        this.description = description;
        this.session_date = session_date;
        this.course = course;
        this.eId = eId;
    }

    /**
     * Session's getter. It gets the data of this variable from the
     * ExamStatement.
     *
     * @return session
     */
    public String getSession() {
        return session;
    }

    /**
     * Session's setter. It sets the data of this variable from the
     * TeachingUnit with the variable or value given.
     *
     * @param session
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * Description's getter. It gets the data of this variable from the
     * ExamStatement.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description's setter. It sets the data of this variable from the
     * TeachingUnit with the variable or value given.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Session Date's getter. It gets the data of this variable from the
     * ExamStatement.
     *
     * @return session_date
     */
    public Date getSession_date() {
        return session_date;
    }

    /**
     * Session Date's setter. It sets the data of this variable from the
     * TeachingUnit with the variable or value given.
     *
     * @param session_date
     */
    public void setSession_date(Date session_date) {
        this.session_date = session_date;
    }

    /**
     * Course's getter. It gets the data of this variable from the
     * ExamStatement.
     *
     * @return course
     */
    public String getCourse() {
        return course;
    }

    /**
     * Course's setter. It sets the data of this variable from the TeachingUnit
     * with the variable or value given.
     *
     * @param course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * eId's getter. It gets the data of this variable from the ExamStatement.
     *
     * @return eId
     */
    public int geteId() {
        return eId;
    }

    /**
     * eId's setter. It sets the data of this variable from the TeachingUnit
     * with the variable or value given.
     *
     * @param eId
     */
    public void seteId(int eId) {
        this.eId = eId;
    }

    /**
     * Method for the use of showing the variables of the object.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Exam Session [" + "Session: " + session + ", Description: " + description + ", Date: " + session_date + ", Course: " + course + ", Statement Id: " + eId + ']';
    }

}
