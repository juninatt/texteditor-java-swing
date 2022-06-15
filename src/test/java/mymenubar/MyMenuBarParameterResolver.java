package mymenubar;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import texteditor.console.MyMenuBar;

import javax.swing.*;
import java.lang.reflect.Parameter;
import java.util.*;

public class MyMenuBarParameterResolver implements ParameterResolver {

    private final Map<String, MyMenuBar> menuBars;

    public MyMenuBarParameterResolver() {
        Map<String, MyMenuBar> menuBars = new HashMap<>();
        menuBars.put("My Menu Bar", new MyMenuBar(new JMenuBar(), new HashSet<>(), new HashSet<>()));
        this.menuBars = menuBars;
    }

    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().
                getTypeName(), "java.util.Map<java.lang.String, texteditor.console.MyMenuBar>");
    }

    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException {
        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.create(MyMenuBar.class));
        return store.getOrComputeIfAbsent("menuBars", f -> getMenuBars());
    }

    private Map<String, MyMenuBar> getMenuBars() {
        return menuBars;
    }
}
