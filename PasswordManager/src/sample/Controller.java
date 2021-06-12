package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DBConnect;
import model.Note;
import model.PasswordGenerator;

import java.sql.SQLException;

public class Controller {

    public TextField pass;
    public TextField us;
    public TextField url;
    public TextField ns;
    public TextField com;
    public TextField cat;
    public TextField dat;
    public TableView tableView;
    public TableColumn colUser;
    public TableColumn colPass;
    public TableColumn colURL;
    public TableColumn colName;
    public TableColumn colCom;
    public TableColumn colCat;
    public TableColumn colDate;

    public void initialize() throws SQLException {
      //  DBConnect.createDb();
      // DBConnect.createTable();
        try {
            updating();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void on_Generate(ActionEvent actionEvent) {
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();
        String password = passwordGenerator.generate(8);
        pass.setText(password);
    }

    public void on_CLick(ActionEvent actionEvent) {
        try {
            DBConnect.updateDb("INSERT INTO manager.manager (username, password, siteURL, siteName, comment, category, date) VALUES('"+us.getText()+"','"+pass.getText()+"','"+url.getText()+"','"+ns.getText()+"','"+com.getText()+"','"+cat.getText()+"','"+dat.getText()+"') ");
            updating();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updating() throws SQLException {
        tableView.setItems(DBConnect.getDataFromDb("SELECT * FROM manager.manager"));
        colUser.setCellValueFactory(new PropertyValueFactory<Note, String>("username"));
        colPass.setCellValueFactory(new PropertyValueFactory<Note, String>("password"));
        colURL.setCellValueFactory(new PropertyValueFactory<Note, String>("siteURL"));
        colName.setCellValueFactory(new PropertyValueFactory<Note, String>("siteName"));
        colCom.setCellValueFactory(new PropertyValueFactory<Note, String>("comment"));
        colCat.setCellValueFactory(new PropertyValueFactory<Note, String>("category"));
        colDate.setCellValueFactory(new PropertyValueFactory<Note, String>("date"));
    }
}
