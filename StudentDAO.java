package studentdata;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO students (prn, name, dob, marks) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getPrn());
            ps.setString(2, student.getName());
            ps.setString(3, student.getDob());
            ps.setDouble(4, student.getMarks());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                students.add(new Student(
                    rs.getString("prn"),
                    rs.getString("name"),
                    rs.getString("dob"),
                    rs.getDouble("marks")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentByPRN(String prn) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM students WHERE prn = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, prn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getString("prn"),
                    rs.getString("name"),
                    rs.getString("dob"),
                    rs.getDouble("marks")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> searchStudentByName(String name) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                    rs.getString("prn"),
                    rs.getString("name"),
                    rs.getString("dob"),
                    rs.getDouble("marks")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void updateStudent(Student student) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE students SET name = ?, dob = ?, marks = ? WHERE prn = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getDob());
            ps.setDouble(3, student.getMarks());
            ps.setString(4, student.getPrn());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String prn) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE prn = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, prn);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
