package view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.TextEditorPane;

public class GraphTest extends Application{
	Button loop10, loop20, loop30, loop40, loop50, loop60, loop70, loop80, loop90, loop100;
	static long start1, start44, start55, start66, start77, start777, start100;
	static long time1, time44, time55, time66, time77, time777, time100;
	static long start5, start88, start99, start1010,start1111,start1212, start888;
	static long time5, time88, time99, time1010, time1111, time1212, time888;
	static long start2;
	static long time2;
	static long start6;
	static long time6;
	static long start3;
	static long time3;
	static long start7;
	static long time7;
	static long start4;
	static long time4;
	static long start8;
	static long time8;
	
	@Override
	public void start(Stage stage) throws Exception {

		VBox vBox = new VBox();
		HBox hBox = new HBox();
		Scene scene = new Scene(vBox);
		
		loop10 = new Button("10%");
		loop20 = new Button("20%");
		loop30 = new Button("30%");
		loop40 = new Button("40%");
		loop50 = new Button("50%");
		loop60 = new Button("60%");
		loop70 = new Button("70%");
		loop80 = new Button("80%");
		loop90 = new Button("90%");
		loop100 = new Button("100%");
		
		
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Amount Of Text (%)");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Time (s)");
		
		
		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		XYChart.Series<Number, Number> data = new XYChart.Series<>();
		XYChart.Series<Number, Number> data2 = new XYChart.Series<>();
		
		lineChart.setTitle("Time vs Amount of Text");

	
		XYChart.Data<Number, Number> plot4 = new  XYChart.Data<Number, Number>(40, 0);
		XYChart.Data<Number, Number> plot3 = new  XYChart.Data<Number, Number>(30, 0);
		XYChart.Data<Number, Number> plot2 = new  XYChart.Data<Number, Number>(20, 0);
		XYChart.Data<Number, Number> plot1 = new  XYChart.Data<Number, Number>(10, 0);
		XYChart.Data<Number, Number> plot0 = new  XYChart.Data<Number, Number>(0, 0);
		XYChart.Data<Number, Number> plot44 = new  XYChart.Data<Number, Number>(50, 0);
		XYChart.Data<Number, Number> plot55 = new  XYChart.Data<Number, Number>(60, 0);
		XYChart.Data<Number, Number> plot66 = new  XYChart.Data<Number, Number>(70, 0);
		XYChart.Data<Number, Number> plot77 = new  XYChart.Data<Number, Number>(80, 0);
		XYChart.Data<Number, Number> plot777 = new  XYChart.Data<Number, Number>(90, 0);
		XYChart.Data<Number, Number> plot100 = new  XYChart.Data<Number, Number>(100, 0);
	
		
		
		data.getData().add(plot4);
		data.getData().add(plot3);
		data.getData().add(plot2);
		data.getData().add(plot1);
		data.getData().add(plot0);
		data.getData().add(plot44);
		data.getData().add(plot55);
		data.getData().add(plot66);
		data.getData().add(plot77);
		data.getData().add(plot777);
		data.getData().add(plot100);
		

		XYChart.Data<Number, Number> plot5 = new  XYChart.Data<Number, Number>(10, 0);
		XYChart.Data<Number, Number> plot6 = new  XYChart.Data<Number, Number>(20, 0);
		XYChart.Data<Number, Number> plot7 = new  XYChart.Data<Number, Number>(30, 0);
		XYChart.Data<Number, Number> plot8 = new  XYChart.Data<Number, Number>(40, 0);
		XYChart.Data<Number, Number> plot9 = new  XYChart.Data<Number, Number>(0, 0);
		XYChart.Data<Number, Number> plot88 = new  XYChart.Data<Number, Number>(50, 0);
		XYChart.Data<Number, Number> plot99 = new  XYChart.Data<Number, Number>(60, 0);
		XYChart.Data<Number, Number> plot1010 = new  XYChart.Data<Number, Number>(70, 0);
		XYChart.Data<Number, Number> plot888 = new  XYChart.Data<Number, Number>(80, 0);
		XYChart.Data<Number, Number> plot1111 = new  XYChart.Data<Number, Number>(90, 0);
		XYChart.Data<Number, Number> plot1212 = new  XYChart.Data<Number, Number>(100, 0);

		
		data2.getData().add(plot5);
		data2.getData().add(plot6);
		data2.getData().add(plot7);
		data2.getData().add(plot8);
		data2.getData().add(plot9);	
		data2.getData().add(plot88);
		data2.getData().add(plot99);
		
		data2.getData().add(plot1010);
		data2.getData().add(plot888);
		data2.getData().add(plot1111);
		data2.getData().add(plot1212);
		
		data.setName("3 loop");
	
		data2.setName("1 loop");
		HBox hBox2 = new HBox();
		hBox2.getChildren().addAll(loop10,loop20,loop30,loop40, loop50,loop60,loop70,loop80,loop90,loop100);
		
		hBox2.setSpacing(5);
		hBox2.setAlignment(Pos.BASELINE_CENTER);
		
		lineChart.getData().add(data);
		lineChart.getData().add(data2);
		
		hBox.getChildren().add(lineChart);
		
		vBox.getChildren().addAll(hBox, hBox2);
		
		stage.setScene(scene);
		stage.show();

		String text = TextEditorPane.mainTextArea.getText();
		
		String text10 = truncate(text ,10);
		String text20 = truncate(text ,20);
		String text30 =	truncate(text ,30);
		String text40 = truncate(text ,40);
		String text50 = truncate(text ,50);
		String text60 = truncate(text ,60);
		String text70 =	truncate(text ,70);
		String text80 = truncate(text ,80);	
		String text90 = truncate(text ,90);
		String text100 =	truncate(text ,100);

		plot0.setYValue(0 /   1000000000.00);

		
			loop10.setOnAction(e ->{
				start1 = System.nanoTime();
				oneLoop(text10);
				time1 = System.nanoTime() - start1;
				System.out.println(time1);
				plot1.setYValue((double)time1 /   1000000000.00);
				
				
				start5 = System.nanoTime();
				threeLoops(text10);
				time5 = System.nanoTime() - start5;
				plot5.setYValue((double)time5 /   1000000000.00);
			
			});
			loop20.setOnAction(e -> {
				start2 = System.nanoTime();
				oneLoop(text20);
				time2 = System.nanoTime() - start2;
				System.out.println(time2);
				plot2.setYValue((double)time2 /   1000000000.00);
				
				
				start6 = System.nanoTime();
				threeLoops(text20);
				time6 = System.nanoTime() - start6;
				plot6.setYValue((double)time6 /   1000000000.00);
			

			});
			loop30.setOnAction(e -> {
		
				
				start3 = System.nanoTime();
				oneLoop(text30);
				time3 = System.nanoTime() - start3;
				System.out.println(time3);
				plot3.setYValue((double)time3 /   1000000000.00);
		
				start7 = System.nanoTime();
				threeLoops(text30);
				time7 = System.nanoTime() - start7;
				plot7.setYValue((double)time7 /   1000000000.00);
			

			});
			loop40.setOnAction(e -> {
				start4 = System.nanoTime();
				oneLoop(text40);
				time4 = System.nanoTime() - start4;
				System.out.println(time4);
				plot4.setYValue((double)time4 /   1000000000.00);
				
				start8 = System.nanoTime();
				threeLoops(text40);
				time8 = System.nanoTime() - start8;
				plot8.setYValue((double)time8 /   1000000000.00);
			
			});
			loop50.setOnAction(e -> {
				start44 = System.nanoTime();
				oneLoop(text50);
				time44 = System.nanoTime() - start44;
			
				plot44.setYValue((double)time44 /   1000000000.00);
				
				start88 = System.nanoTime();
				threeLoops(text50);
				time88 = System.nanoTime() - start88;
				plot88.setYValue((double)time88 /   1000000000.00);
			
			});
			loop60.setOnAction(e -> {
				start55 = System.nanoTime();
				oneLoop(text60);
				time55 = System.nanoTime() - start55;
			
				plot55.setYValue((double)time55 /   1000000000.00);
				
				start99 = System.nanoTime();
				threeLoops(text60);
				time99 = System.nanoTime() - start99;
				plot99.setYValue((double)time99 /   1000000000.00);
			
			});
			loop70.setOnAction(e -> {
				start66 = System.nanoTime();
				oneLoop(text70);
				time66 = System.nanoTime() - start66;
			
				plot66.setYValue((double)time66 /   1000000000.00);
				
				start1010 = System.nanoTime();
				threeLoops(text70);
				time1010 = System.nanoTime() - start1010;
				plot1010.setYValue((double)time1010 /   1000000000.00);
			
			});
			loop80.setOnAction(e -> {
				start77 = System.nanoTime();
				oneLoop(text80);
				time77 = System.nanoTime() - start77;
			
				plot77.setYValue((double)time77 /   1000000000.00);
				
				start888 = System.nanoTime();
				threeLoops(text80);
				time888 = System.nanoTime() - start888;
				plot888.setYValue((double)time888 /   1000000000.00);
				
			});
			loop90.setOnAction(e -> {
				start777 = System.nanoTime();
				oneLoop(text90);
				time777 = System.nanoTime() - start777;
			
				plot777.setYValue((double)time777 /   1000000000.00);
				
				start1111 = System.nanoTime();
				threeLoops(text90);
				time1111 = System.nanoTime() - start1111;
				plot1111.setYValue((double)time1111 /   1000000000.00);
			
			});
			loop100.setOnAction(e -> {
				start100 = System.nanoTime();
				oneLoop(text100);
				time100 = System.nanoTime() - start100;
			
				plot100.setYValue((double)time100 /   1000000000.00);
				
				start1212 = System.nanoTime();
				threeLoops(text100);
				time1212 = System.nanoTime() - start1212;
				plot1212.setYValue((double)time1212 /   1000000000.00);
			
			});


			stage.setOnCloseRequest(e -> {
				printDataToFile(getData());
				System.out.println("saved");
			});
	}
	
	   public static String truncate(String value, int length) {
		   	int percent = (int)(value.length() * (length / 100.0));
	        if (value.length() > percent) {
	        	
	        	String result = new String(value.substring(0,percent)) + " . ";
	            return result;
	        } else {
	            return value;
	        }
	    }

		public static int[] threeLoops(String text) {
			final String sentREGEX = "[^?!.][?!.]";
			final String syllREGEX = "(?i)(ame)|(year)|(yell)|(else)|(umped)|[^aeiouy](ean)"
					+ "|[^aeiouy](ee)|\\s+(ache)|(mph)|(ps)|(ied)|(ies)"
					+ "|i[aeiouy]|[^n](aked)|(akes)|(ice)|r(eet)|(ened)"
					+ "|(ome)+\\s|(quent)|(use)|(all)|(poe)[aeiouy]|(lieve)"
					+ "|(ase)|(abe)+\\s|(ives)|(pet)|(ates)|(are)|[a-z][a-z]"
					+ "[^a-z](ed)|[a-z](ee)d|b(e)|(ing)|[^aeiouy](oad)|(orse)"
					+ "|(orced)|(oarse)+\\s|(ourse)+\\s|(lau)|(you)|(one)|y|"
					+ "(aced)|(ore)\\s|(ized)|(loo)|(loo)[snk]|(rey)|(ered)|"
					+ "(rea)[sdp]|(r[e]|a[l])|e[a]|au[se]|\\s+b[e]*^a|(ee)|p"
					+ "[o]|(oe)|[wshm]e+\\s(?!b?\\\\\\\\b)|i[aeiouy][aeiouy]*|"
					+ "[t]+[h]+[e]y|[e]+[bcdfghjklmnpqrstvwxz]|[i]es|[u]ee|[u]a"
					+ "a|[u]aa+[a]|[aiouy][iouy]*|e[aeiuy][ey]*(?!b?\\b)|[c]+[e]"
					+ "+[bcdfghjklmnpqrstvwxz]|[q]+[u]+[o]|[o]+[e]+[i]|e[y]|[l]+"
					+ "[e]*[aeiouy]|[u]|u[ouiy]|o[oauiy]|[o]|y[aiouy]";
			final String wordREGEX = "(?i)[\\w]*[\\w]";
			
			Matcher m1 = Pattern.compile(sentREGEX).matcher(text);
			Matcher m3 = Pattern.compile(wordREGEX).matcher(text);
			Matcher m2 = Pattern.compile(syllREGEX).matcher(text);

			int one = 0;
			int two =0;
			int three = 0;
			
			while(m1.find()) {
				if(m1.find()) {
					one++;
				}
			}

			while(m2.find()) {
				if(m2.find()) {
					two++;
				}
			}

			while(m3.find()) {
				if(m3.find()) {
					three++;
				}
			}
			return new int[]{one, two,three};
		}
		
		public static int[] oneLoop(String text) {
			
			final String sentREGEX = "[^?!.][?!.]";
			final String syllREGEX = "(?i)(ame)|(year)|(yell)|(else)|(umped)|[^aeiouy](ean)"
					+ "|[^aeiouy](ee)|\\s+(ache)|(mph)|(ps)|(ied)|(ies)"
					+ "|i[aeiouy]|[^n](aked)|(akes)|(ice)|r(eet)|(ened)"
					+ "|(ome)+\\s|(quent)|(use)|(all)|(poe)[aeiouy]|(lieve)"
					+ "|(ase)|(abe)+\\s|(ives)|(pet)|(ates)|(are)|[a-z][a-z]"
					+ "[^a-z](ed)|[a-z](ee)d|b(e)|(ing)|[^aeiouy](oad)|(orse)"
					+ "|(orced)|(oarse)+\\s|(ourse)+\\s|(lau)|(you)|(one)|y|"
					+ "(aced)|(ore)\\s|(ized)|(loo)|(loo)[snk]|(rey)|(ered)|"
					+ "(rea)[sdp]|(r[e]|a[l])|e[a]|au[se]|\\s+b[e]*^a|(ee)|p"
					+ "[o]|(oe)|[wshm]e+\\s(?!b?\\\\\\\\b)|i[aeiouy][aeiouy]*|"
					+ "[t]+[h]+[e]y|[e]+[bcdfghjklmnpqrstvwxz]|[i]es|[u]ee|[u]a"
					+ "a|[u]aa+[a]|[aiouy][iouy]*|e[aeiuy][ey]*(?!b?\\b)|[c]+[e]"
					+ "+[bcdfghjklmnpqrstvwxz]|[q]+[u]+[o]|[o]+[e]+[i]|e[y]|[l]+"
					+ "[e]*[aeiouy]|[u]|u[ouiy]|o[oauiy]|[o]|y[aiouy]";
			final String wordREGEX = "(?i)[\\w]*[\\w]";
			
			Matcher m1 = Pattern.compile(sentREGEX).matcher(text);
			Matcher m3 = Pattern.compile(wordREGEX).matcher(text);
			Matcher m2 = Pattern.compile(syllREGEX).matcher(text);

			int one = 0;
			int two =0;
			int three = 0;
			
			while(m2.find()) {
				if(m2.find()) {
					three++;
				}
				if(m1.find()) {
					one++;
				}
				if(m3.find()){
					two++;
				}
			}
		
			
			return new int[]{one, two,three};
		}
		
		public static String getData() {
			String line = "\n";
			String oneLoopData1 = "ONE LOOP/ 10% in NanoSeconds: " + time1;
			String oneLoopData2 = "ONE LOOP /20% in NanoSeconds: " + time2;
			String oneLoopData3 = "ONE LOOP /30% in NanoSeconds: " + time3;
			String oneLoopData4 = "ONE LOOP /40% in NanoSeconds: " + time4;
			String oneLoopData5 = "ONE LOOP/ 50% in NanoSeconds: " + time44;
			String oneLoopData6 = "ONE LOOP /60% in NanoSeconds: " + time55;
			String oneLoopData7 = "ONE LOOP /70% in NanoSeconds: " + time66;
			String oneLoopData8 = "ONE LOOP /80% in NanoSeconds: " + time77;
			String oneLoopData9 = "ONE LOOP/ 90% in NanoSeconds: " + time777;
			String oneLoopData10 = "ONE LOOP /100% in NanoSeconds: " + time100;
			
			
			String threeLoopData1 = "THREE LOOP / 10% in NanoSeconds: " + time5;
			String threeLoopData2 = "THREE LOOP / 20% in NanoSeconds: " + time6;
			String threeLoopData3 = "THREE LOOP / 30% in NanoSeconds: " + time7;
			String threeLoopData4 = "THREE LOOP / 40% in NanoSeconds: " + time8;
			String threeLoopData5 = "THREE LOOP / 50% in NanoSeconds: " + time88;
			String threeLoopData6 = "THREE LOOP / 60% in NanoSeconds: " + time99;
			String threeLoopData7 = "THREE LOOP / 70% in NanoSeconds: " + time1010;
			String threeLoopData8 = "THREE LOOP / 80% in NanoSeconds: " + time888;
			String threeLoopData9 = "THREE LOOP / 90% in NanoSeconds: " + time1111;
			String threeLoopData10 = "THREE LOOP / 100% in NanoSeconds: " + time1212;
			
			String fullText = oneLoopData1 + " : " + threeLoopData1 + line +
							  oneLoopData2 + " : " + threeLoopData2 + line +
							  oneLoopData3 + " : " + threeLoopData3 + line +
							  oneLoopData4 + " : " + threeLoopData4 + line +
							  oneLoopData5 + " : " + threeLoopData5 + line +
							  oneLoopData6 + " : " + threeLoopData6 + line +
							  oneLoopData7 + " : " + threeLoopData7 + line +
							  oneLoopData8 + " : " + threeLoopData8 + line +
							  oneLoopData9 + " : " + threeLoopData9 + line +
			  				  oneLoopData10 + " : " + threeLoopData10;
			return fullText;
			
		}
		public static void printDataToFile(String text) {
			try {
				PrintStream out = new PrintStream(new FileOutputStream("outputData/graphStatistics.txt"));
				out.println(text);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		

}
