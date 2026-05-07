package controllers;

import dao.EnrollmentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Enrollment;

public class EnrollmentController {

    @FXML private TextField studentIdField;
    @FXML private TextField courseIdField;
    @FXML private DatePicker datePicker;

    @FXML private TableView<Enrollment> table;
    @FXML private TableColumn<Enrollment, Integer> idColumn;
    @FXML private TableColumn<Enrollment, Integer> studentColumn;
    @FXML private TableColumn<Enrollment, Integer> courseColumn;
    @FXML private TableColumn<Enrollment, String> dateColumn;

    EnrollmentDAO dao = new EnrollmentDAO();

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("enrollmentDate"));

        load();
    }

    // ADD
    @FXML
    public void addEnrollment() {

        try {

            if (studentIdField.getText().isEmpty()
                    || courseIdField.getText().isEmpty()
                    || datePicker.getValue() == null) {

                System.out.println("Fill all fields");
                return;
            }

            Enrollment e = new Enrollment(
                    Integer.parseInt(studentIdField.getText()),
                    Integer.parseInt(courseIdField.getText()),
                    datePicker.getValue().toString()
            );

            dao.add(e);

            System.out.println("Added");

            load();
            clear();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // UPDATE
    @FXML
    public void updateEnrollment() {

        try {

            Enrollment selected = table.getSelectionModel().getSelectedItem();

            if (selected == null) return;

            Enrollment e = new Enrollment(
                    selected.getId(),
                    Integer.parseInt(studentIdField.getText()),
                    Integer.parseInt(courseIdField.getText()),
                    datePicker.getValue().toString()
            );

            dao.update(e);

            System.out.println("Updated");

            load();
            clear();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // DELETE
    @FXML
    public void deleteEnrollment() {

        try {

            Enrollment selected = table.getSelectionModel().getSelectedItem();

            if (selected == null) return;

            dao.delete(selected.getId());

            System.out.println("Deleted");

            load();
            clear();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // VIEW
    @FXML
    public void viewEnrollments() {
        load();
    }

    private void load() {

        try {

            ObservableList<Enrollment> list =
                    FXCollections.observableArrayList(dao.getAll());

            table.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        studentIdField.clear();
        courseIdField.clear();
        datePicker.setValue(null);
    }
}