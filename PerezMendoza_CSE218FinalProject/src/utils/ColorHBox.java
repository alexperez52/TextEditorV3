package utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import view.MenuBarHBox;

public class ColorHBox extends HBox{
	int wordCountNum, sentenceCountNum, fleschScoreNum;
	public static Text wordCount;
	public static Text sentenceCount;
	public static Text fleschScore;
	public ColorHBox() {
		wordCount = new Text("Word Count: " + wordCountNum);
		wordCount.setVisible(false);
		sentenceCount = new Text("| Sentence Count: " + sentenceCountNum);
		sentenceCount.setVisible(false);
		fleschScore = new Text("| Flesch Score: " + fleschScoreNum);
		fleschScore.setVisible(false);
		this.setSpacing(30);
		this.setPadding(new Insets(5));
		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setStyle("-fx-background-color: white; -fx-control-inner-background: white");
		this.setBorder(new Border(new BorderStroke(Color.DIMGREY, BorderStrokeStyle.SOLID, new CornerRadii(0),
				new BorderWidths(1, 0, 0, 0))));
		this.getChildren().addAll(wordCount, sentenceCount, fleschScore);
		
	}
	public static void toggleViewMenuItems() {
		MenuBarHBox.toggleAll.setOnAction(e -> {
			if(MenuBarHBox.imageMenuItem.isSelected()) {
				MenuBarHBox.imageMenuItem.setSelected(true);
				
			}
			else {
				MenuBarHBox.imageMenuItem.setSelected(false);
			}
			if (MenuBarHBox.wordCountItem.isSelected() && MenuBarHBox.sentenceCountItem.isSelected() && MenuBarHBox.fleschScoreItem.isSelected()) {
				MenuBarHBox.toggleAll.setSelected(false);
			} else {
				MenuBarHBox.toggleAll.setSelected(true);
			}

			if (!wordCount.isVisible() || !sentenceCount.isVisible() || !fleschScore.isVisible()) {
				wordCount.setVisible(true);
				sentenceCount.setVisible(true);
				fleschScore.setVisible(true);
				MenuBarHBox.wordCountItem.setSelected(true);
				MenuBarHBox.sentenceCountItem.setSelected(true);
				MenuBarHBox.fleschScoreItem.setSelected(true);
			} else {
				wordCount.setVisible(false);
				sentenceCount.setVisible(false);
				fleschScore.setVisible(false);
				MenuBarHBox.wordCountItem.setSelected(false);
				MenuBarHBox.sentenceCountItem.setSelected(false);
				MenuBarHBox.fleschScoreItem.setSelected(false);

			}

		});

	}
	public static void loadStatusBarActions() {
		MenuBarHBox.imageMenuItem.setOnAction(e ->{
			if(MenuBarHBox.imageMenuItem.isSelected()) {
				MenuBarHBox.newView.setVisible(true);
			}
			else {
				MenuBarHBox.newView.setVisible(false);
			}
		});
		
		MenuBarHBox.wordCountItem.setOnAction(e -> {
			if (!wordCount.isVisible()) {
				wordCount.setVisible(true);
			} else {
				wordCount.setVisible(false);
			}
		});

		MenuBarHBox.sentenceCountItem.setOnAction(e -> {
			if (!sentenceCount.isVisible()) {
				sentenceCount.setVisible(true);
			} else {
				sentenceCount.setVisible(false);
			}
		});
		MenuBarHBox.fleschScoreItem.setOnAction(e -> {
			if (!fleschScore.isVisible()) {
				fleschScore.setVisible(true);
			} else {
				fleschScore.setVisible(false);
			}
		});

	}
	
}
