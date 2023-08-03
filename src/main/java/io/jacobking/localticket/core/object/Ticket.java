package io.jacobking.localticket.core.object;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ticket {

    private final StringProperty subject = new SimpleStringProperty();

    private final StringProperty priority = new SimpleStringProperty();
    private final StringProperty information = new SimpleStringProperty();
    private final StringProperty date = new SimpleStringProperty();

    public Ticket(String subject, String priority, String information, String date) {
        setProperties(subject, priority, information, date);
    }

    private void setProperties(String subject, String priority, String information, String date) {
        this.subject.setValue(subject);
        this.priority.setValue(priority);
        this.information.setValue(information);
        this.date.setValue(date);
    }

    public String getSubject() {
        return this.subject.getValue();
    }

    public String getInformation() {
        return this.information.getValue();
    }

    public String getPriority() {
        return this.priority.getValue();
    }
    public String getDate() {
        return this.information.getValue();
    }

    public void setSubject(String subject) {
        this.subject.setValue(subject);
    }

    public void setPriority(String priority) {
        this.priority.setValue(priority);
    }

    public void setInformation(String information) {
        this.information.setValue(information);
    }

    public void setDate(String date) {
        this.date.setValue(date);
    }

}
