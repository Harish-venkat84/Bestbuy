package com.bestbuy.test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bestbuy.utils.BaseUtils;

public class Menu extends BaseUtils {

	static int key = 0;

	@Test
	public void menuFirst_ThreeButton() {

		try {

			String currentWinID = getCurrentWinID();

			clickElement(pom.getHomePage().getMenuButton());

			List<WebElement> menuLists = pom.getHomePage().getMenusList();

			int getKey = 1;

			for (WebElement menulist : menuLists) {
				
				title.path = "/Titles/Application.properties";

				title.loadPropertyFile();
				
				presenceOfElement("//div[@class = 'hamburger-menu-flyout']//child::ul//child::li//child::button[text() = '"+title.getValue(String.valueOf(getKey))+"']");
				
//				getElementText(pom.getHomePage().getMenuText(title.getValue(String.valueOf(getKey))));
				
				String text = getElementText(menulist);
				
				StringBuilder name = new StringBuilder();
				
				name.append('_');
				
				for (Character letter : text.toCharArray()) {
					
					if (!Character.isWhitespace(letter)) {
						
						name.append(letter);
					}
				}
				
				text = name.toString();
				
				if (getElementText(menulist).equals(title.getValue(String.valueOf(getKey)))) {

					clickElement(menulist);

					List<WebElement> applicationList = pom.getHomePage().applicationList();

					for (WebElement list1 : applicationList) {

						clickElement(list1);

						List<WebElement> dealsList = pom.getHomePage().dealsList();

						for (WebElement list : dealsList) {

							rightClickOpen(list);

							waitForMe(10).until(ExpectedConditions.numberOfWindowsToBe(2));

							Set<String> allWinIDs = getAllWinIDs();

							for (String win : allWinIDs) {

								if (!currentWinID.equals(win)) {

									switchDriver(win);
								}

							}

							key++;
							
							title.path = "/Titles/MenuTitles.properties";

							title.createPropertyFile();

							title.write(String.valueOf(key)+text, getPageTitel());

							title.loadPropertyFile();

							Assert.assertEquals(title.getValue(String.valueOf(key)+text), getPageTitel());

							closeCurrentBrowser();

							switchDriver(currentWinID);

						}
					}

					List<WebElement> application2 = pom.getHomePage().application2();

					for (WebElement list : application2) {

						rightClickOpen(list);

						waitForMe(10).until(ExpectedConditions.numberOfWindowsToBe(2));

						Set<String> allWinIDs = getAllWinIDs();

						for (String win : allWinIDs) {

							if (!currentWinID.equals(win)) {

								switchDriver(win);
							}

						}

						key++;
						
						title.path = "/Titles/MenuTitles.properties";

						title.createPropertyFile();

						title.write(String.valueOf(key)+text, getPageTitel());

						title.loadPropertyFile();

						Assert.assertEquals(title.getValue(String.valueOf(key)+text), getPageTitel());

						closeCurrentBrowser();

						switchDriver(currentWinID);

					}

					getKey++;
					
					clickElement(pom.getHomePage().getBackButton());

				} else {

					clickElement(menulist);
					
					List<WebElement> menuLists2 = pom.getHomePage().getListLinks();

					for (WebElement list : menuLists2) {

						rightClickOpen(list);

						waitForMe(10).until(ExpectedConditions.numberOfWindowsToBe(2));

						Set<String> allWinIDs = getAllWinIDs();

						for (String win : allWinIDs) {

							if (!currentWinID.equals(win)) {

								switchDriver(win);
							}

						}

						key++;

						title.path = "/Titles/MenuTitles.properties";

						title.createPropertyFile();

						title.write(String.valueOf(key)+text, getPageTitel());

						title.loadPropertyFile();

						Assert.assertEquals(title.getValue(String.valueOf(key)+text), getPageTitel());

						closeCurrentBrowser();

						switchDriver(currentWinID);

					}
				}
				
				key = 0;
			}

			key = 0;

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
