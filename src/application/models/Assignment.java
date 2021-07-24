package application.models;

import application.controllers.AssignmentController;
import application.controllers.ReportController;

import java.sql.Date;
import java.util.UUID;

public class Assignment extends Submission {

    /*
     * 1 -> Group assignment
     * 2 -> Individual individual assignment
     * */

    private UUID uuid;
    private int type;

    public Assignment(UUID uuid, UUID unit, Date date, int type) {
        super(unit, date);
        this.setUuid(uuid);
        this.setType(type);
    }

    public Assignment(UUID unit, Date date, int type) {
        super(unit, date);
        this.setUuid(UUID.randomUUID());
        this.setType(type);
        AssignmentController.saveAssignment(this);
    }

    public void update(Date date, int type) {
        this.setUnit(this.getUnit());
        this.setDate(date);
        this.setType(type);
        AssignmentController.editAssignment(this);
    }

    public void delete() {
        AssignmentController.deleteAssignment(this);
    }

    @Override
    public String toString() {
        return String.format("Report{'unit': %s, 'date': %s, 'type': %s}",
                this.getUnitObject(), this.getDate(), this.getTypeToString());
    }

    public String getTypeToString() {
        return switch (this.type) {
            case 1 -> "group";
            case 2 -> "individual";
            default -> "invalid-type";
        };
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
