package application.models;

import application.controllers.ExamController;

import java.sql.Date;
import java.util.UUID;

public class Exam extends Test {

    private UUID uuid;

    public Exam(UUID uuid, UUID unit, Date date) {
        super(unit, date);
        this.setUuid(uuid);
    }

    public Exam(UUID unit, Date date) {
        super(unit, date);
        this.setUuid(UUID.randomUUID());
    }

    public void save() {
        ExamController.saveExam(this);
    }

    public void update(Date date) {
        this.setUnit(this.getUnit());
        this.setDate(date);
        ExamController.editExam(this);
    }

    public void delete() {
        ExamController.deleteExam(this);
    }

    @Override
    public String toString() {
        return String.format("Exam{'unit': %s, 'date': %s}",
                this.getUnitObject(), this.getDate());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
