package fr.javafreelance.fluentlenium.core.action;

import fr.javafreelance.fluentlenium.core.filter.Filter;
import org.openqa.selenium.WebDriver;

public class FillConstructor extends fr.javafreelance.fluentlenium.core.Fluent {
    private String cssSelector;
    private Filter[] filters;
    private FluentDefaultActions fluentList;

    public FillConstructor(String cssSelector, WebDriver webDriver, Filter... filters) {
        super(webDriver);
        this.cssSelector = cssSelector;
        this.filters = filters;
    }

    public FillConstructor(FluentDefaultActions list, WebDriver driver, Filter[] filters) {
        super(driver);
        this.filters = filters;
        this.fluentList = list;
    }

    public void with(String... values) {
        if (fluentList != null) {
            fluentList.text(values);
        } else {
            $(cssSelector, filters).text(values);
        }
    }
}