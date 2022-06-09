package mymenucolumn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import texteditor.console.MyMenuColumn;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MyMenuColumn")
@ExtendWith(MyMenuColumnParameterResolver.class)
public class MyMenuColumnTest {

    MyMenuColumn myMenuColumn;

    @BeforeEach
    void init(Map<String, MyMenuColumn> column) {
        this.myMenuColumn = column.get("My Menu Column");
    }

    @Test
    @DisplayName("arrays are null")
    void noFieldsAreNull() {
        assertThat(myMenuColumn).hasNoNullFieldsOrPropertiesExcept("menuItems", "menuOptions");
    }
}
