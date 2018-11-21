package sample;

import java.io.*;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import java.awt.Desktop;

public class Controller
{
    private String pathSrc = "";

    @FXML
    void showFiles(ActionEvent event) throws Exception{
        Desktop desktop = null;
        if (Desktop.isDesktopSupported())
        {
            desktop = Desktop.getDesktop();
        }
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Pictures");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File chosenFile = fileChooser.showOpenDialog(null);
        if(chosenFile != null)
        {
            desktop.open(chosenFile);

        }

    }

    @FXML
    void deleteFile(ActionEvent event) throws Exception
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Delete file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
        if (selectedFiles != null)
        {
            try
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Warning !");
                alert.setContentText("Are you sure?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    for (File selectedFile : selectedFiles) {
                        selectedFile.delete();
                    }

                }
            }
            catch (NullPointerException e)
            {
                System.out.println(e);
            }
        }

    }

    @FXML
    void createFile(ActionEvent event) throws Exception
    {

        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Create file");
        dialog.setHeaderText("Enter name of new file");
        dialog.setContentText("Name:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent() && !result.get().isEmpty())
        {
            try
            {
                String nameFile = result.get() + ".txt";
                new PrintWriter(nameFile, "UTF-8");
                Desktop desktop = null;
                if (Desktop.isDesktopSupported())
                {
                    desktop = Desktop.getDesktop();
                }
                File file = new File(nameFile);
                desktop.open(file);
            }
            catch (NullPointerException e)
            {
                System.out.println(e);
            }


        }
        else if (result.isPresent())
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("File editor");
             alert.setHeaderText(null);
             alert.setContentText("Error! You need enter file name!");
             alert.showAndWait();
         }

    }

    @FXML
    void writeNode(ActionEvent event) throws Exception
    {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Add node");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File chosenFile = fileChooser.showOpenDialog(null);
        if(chosenFile != null)
        {
            try
            {
                pathSrc = chosenFile.getPath();

                Writer fileWriter = new BufferedWriter(new FileWriter(pathSrc, true));
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Add node");
                dialog.setHeaderText("Enter new node");
                dialog.setContentText("Node:");
                Optional <String> result = dialog.showAndWait();
                fileWriter.append("\n");
                if(result.isPresent() && !result.get().isEmpty())
                {
                    fileWriter.append(result.get());
                    fileWriter.close();
                }
                else if (result.isPresent())
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("File editor");
                    alert.setHeaderText(null);
                    alert.setContentText("Error! You need enter new node!");
                    alert.showAndWait();
                }
            }
            catch (IOException e)
            {
                System.out.println(e);
            }

        }

    }

}
