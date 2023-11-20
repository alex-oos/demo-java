package org.example.playwightdemo;

import com.microsoft.playwright.*;

import java.nio.file.Paths;


/**
 * <P></p>
 *
 * @author Alex
 * @since 2023/11/16 下午6:34
 */


public class PlaywrightDemo {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        // 启动浏览器，设置为无头模式
        Browser browser =
                playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setDevtools(true));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("http://shxdx.jxjy.chaoxing.com/login");
        Thread.sleep(500);
        System.out.println("page.title() = " + page.title());
        // page.innerText()
        page.pause();
        // 截图
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
    }


}
