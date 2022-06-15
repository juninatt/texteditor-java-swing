package myframe;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import texteditor.console.MyFrame;

import javax.swing.*;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyFrameParameterResolver implements ParameterResolver {

    private final Map<String, MyFrame> frames;

    public MyFrameParameterResolver() {
        Map<String, MyFrame> frames = new HashMap<>();
        frames.put("Large Frame", new MyFrame(new JFrame("Large Frame"), new JTextArea()));
        frames.put("Small Frame", new MyFrame(new JFrame("Small Frame"), new JTextArea()));
        this.frames = frames;
    }

    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().
                getTypeName(), "java.util.Map<java.lang.String, texteditor.console.MyFrame>");
    }

    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException {
        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.create(MyFrame.class));
        return store.getOrComputeIfAbsent("frames", f -> getFrames());
    }

    private Map<String, MyFrame> getFrames() {
        return frames;
    }
}
