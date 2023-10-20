package com.avics.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.avics.framework.constants.KeyWordConstants;
import com.avics.framework.data.TestScript;
import com.avics.framework.keywords.ClickButton;
import com.avics.framework.keywords.EnterText;
import com.avics.framework.keywords.LaunchBrowser;
import com.avics.framework.keywords.VerifyImage;

public class AutomationFramework {
	private WebDriver driver;

	AutomationFramework() {
		List<TestScript> scriptList = loadTestScriptAndData1();

		/* read data from arraylist */

		for (TestScript ts : scriptList) {
			System.out.println(ts.getKeyword());

			switch (ts.getKeyword()) {
			case KeyWordConstants.LAUNCH:
				LaunchBrowser lb = new LaunchBrowser(ts.getParam1(), ts.getParam2());
				this.driver = lb.launch();
			//	this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Launched Browser " + ts.getParam1());
				break;
			case KeyWordConstants.VERIFY_IMAGE:
				VerifyImage vl = new VerifyImage(ts.getParam1(), ts.getParam2());
				boolean logoExists = vl.verify(driver);
				System.out.println("Logo Verified =  " + logoExists);
				break;
			case KeyWordConstants.ENTER_TEXT:
				EnterText enterText = new EnterText(ts.getParam1(), ts.getParam2(), ts.getParam3());
				enterText.enter(driver);
				System.out.println("Enter Text =  " + ts.getParam3());
				break;
			case KeyWordConstants.CLICK_BUTTON:
				ClickButton clickButton = new ClickButton(ts.getParam1(), ts.getParam2());
				try {
					
					clickButton.click(driver);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Button Clicked=  " + ts.getParam2());
				break;

			}// End of Switch

		}

	}

	public static void main(String[] args) {
		new AutomationFramework();
	}

	public List<TestScript> loadTestScriptAndData() {
		/* Read the file */
		BufferedReader br = null;
		File file = new File("C:\\Framework\\configruration.properties");
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		TestScript ts = new TestScript();
		ArrayList<TestScript> list = new ArrayList<TestScript>();
		try {
			line = br.readLine();
			// System.out.println("Header Line = " + line);
			String data[];
			/* Data Lines */
			while (line != null) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				// System.out.println("Data Line = " + line);
				data = line.split(",");

				
				  for (String a : data) { System.out.println(a); }
				 

				/* set the file data in a data object */
				ts = new TestScript();
				ts.setTestId(data[0]);
				ts.setDesc(data[1]);
				ts.setKeyword(data[2]);
				if (data[3].equals("N")) {
					ts.setSkip(false);
				} else {
					ts.setSkip(true);
				}
				ts.setParam1(data[4]);
				ts.setParam2(data[5]);
				ts.setParam3(data[6]);
				/* add the data object in a list */
				list.add(ts);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<TestScript> loadTestScriptAndData1() {
		/* Read the file */
		Path path = Paths.get("C:\\Framework\\configruration.properties");
		File file = new File("C:\\Framework\\configruration.properties");
		try {
			String output = FileUtils.readFileToString(file, "UTF-8");
			System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestScript ts = new TestScript();
		ArrayList<TestScript> list = new ArrayList<TestScript>();
		String data[];
		try {
			List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
			for (String line : lines) {
				System.out.println(line);
				System.out.println("मुख्य माहिती");
				if (line == null) {
					break;
				}
				// System.out.println("Data Line = " + line);
				data = line.split(",");

				/*
				 * for (String a : data) { System.out.println(a); }
				 */

				/* set the file data in a data object */
				ts = new TestScript();
				ts.setTestId(data[0]);
				ts.setDesc(data[1]);
				ts.setKeyword(data[2]);
				if (data[3].equals("N")) {
					ts.setSkip(false);
				} else {
					ts.setSkip(true);
				}
				ts.setParam1(data[4]);
				ts.setParam2(data[5]);
				ts.setParam3(data[6]);
				/* add the data object in a list */
				list.add(ts);

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}
}
