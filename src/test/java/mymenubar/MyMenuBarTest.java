package mymenubar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import texteditor.console.MyMenuBar;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MyMenuBar")
@ExtendWith(MyMenuBarParameterResolver.class)
public class MyMenuBarTest {

    MyMenuBar myMenuBar;

    @BeforeEach
    void init(Map<String, MyMenuBar> menuBar) {
        this.myMenuBar = menuBar.get("My Menu Bar");
    }

    @Test
    @DisplayName("has no null values")
    void noFieldsAreNull() {
        assertThat(myMenuBar).hasNoNullFieldsOrProperties();
    }
}
