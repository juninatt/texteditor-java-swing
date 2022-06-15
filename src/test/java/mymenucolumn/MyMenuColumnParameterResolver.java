package mymenucolumn;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import texteditor.console.MyMenuColumn;

import javax.swing.*;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class MyMenuColumnParameterResolver implements ParameterResolver {

    private final Map<String, MyMenuColumn> columns;

    public MyMenuColumnParameterResolver() {
        Map<String, MyMenuColumn> columns = new HashMap<>();
        columns.put("My Menu Column", new MyMenuColumn(new JMenu(), new HashSet<>(), new HashSet<>()));
        this.columns = columns;
    }

    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().
                getTypeName(), "java.util.Map<java.lang.String, texteditor.console.MyMenuColumn>");
    }

    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException {
        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.create(MyMenuColumn.class));
        return store.getOrComputeIfAbsent("columns", c -> getMenuColumns());
    }

    private Map<String, MyMenuColumn> getMenuColumns() {
        return columns;
    }
}
