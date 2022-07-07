import java.sql.*;

class Main {
    public static void main(String[] args)  {
//        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/esis", "root", "");
            Statement monInstruction = connection.createStatement();
            String requete = "Select * From etudiant where id % 2 != 0 ";
            ResultSet monResultat = monInstruction.executeQuery(requete);


            while (monResultat.next()) {
                System.out.println(monResultat.getInt("id"));
                System.out.println(monResultat.getString("nom"));
                System.out.println(monResultat.getString("matricule"));
            }

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("impossible de se connecter");
        }

    }
}
