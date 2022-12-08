package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * This class manipulates the gui attributes.
 * It shows the evaluation of the expression given.
 * @author sonishkandel
 *
 */
public class MainView {
  
  private String expression = "";
  private String answer = "";
  private boolean isInfix = true;
  private CalcModel calculator = new CalcModel();

  @FXML
  private ButtonBar buttonBar;

  @FXML
  private Button evaluateButton;

  @FXML
  private TextField expressionAnswer;

  @FXML
  private Label expressionLable;

  @FXML
  private Label resultLable;

  @FXML
  private TextField expressionText;

  @FXML
  private RadioButton infixButton;

  @FXML
  private RadioButton postfixButton;

  @FXML
  private Label title;

  @FXML
  private ToggleGroup type;

  
  @FXML
  void evaluateButtonPressed(ActionEvent event) 
      throws InvalidExpressionException, BadTypeException {
    expression = expressionText.getText();
    expressionAnswer.setStyle("-fx-text-inner-color: #000000;");

    try {
      answer = Float.toString(calculator.evaulate(expression, isInfix));
    } catch (InvalidExpressionException e) {
      answer = e.getMessage();
      expressionAnswer.setStyle("-fx-text-inner-color: #FF0000;");
    }
    
    expressionAnswer.setText(answer);

  }

  @FXML
  void radioCheck(ActionEvent event) {
    if (infixButton.isSelected()) {
      expressionText.setPromptText("3 + 4");
      expressionText.setText("");
      expressionAnswer.setText("");
      isInfix = true;
      
    } else {
      expressionText.setPromptText("3 4 +");
      expressionText.setText("");
      expressionAnswer.setText("");
      isInfix = false;
    }

  }
  

  

  
  

}
