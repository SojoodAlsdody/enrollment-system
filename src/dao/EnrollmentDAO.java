package dao;

import config.DBConnection;
import models.Enrollment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public boolean add(Enrollment e) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO enrollment(student_id, course_id, enrollment_date) VALUES (?,?,?)"
            );

            ps.setInt(1, e.getStudentId());
            ps.setInt(2, e.getCourseId());
            ps.setString(3, e.getEnrollmentDate());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Enrollment e) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE enrollment SET student_id=?, course_id=?, enrollment_date=? WHERE id=?"
            );

            ps.setInt(1, e.getStudentId());
            ps.setInt(2, e.getCourseId());
            ps.setString(3, e.getEnrollmentDate());
            ps.setInt(4, e.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM enrollment WHERE id=?"
            );

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Enrollment> getAll() {

        List<Enrollment> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getInstance().getConnection();

            ResultSet rs = conn.createStatement()
                    .executeQuery("SELECT * FROM enrollment");

            while (rs.next()) {
                list.add(new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getString("enrollment_date")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
}