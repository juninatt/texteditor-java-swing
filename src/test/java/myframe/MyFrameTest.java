package myframe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import texteditor.console.MyFrame;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("built frame")
@ExtendWith(MyFrameParameterResolver.class)
public class MyFrameTest {

    MyFrame largeFrame;
    MyFrame smallFrame;
    MyFrame nullFrame;

    @BeforeEach
    void init(Map<String, MyFrame> frames) {
        this.largeFrame = frames.get("Large Frame");
        this.smallFrame = frames.get("Small Frame");
        this.nullFrame = frames.get("Null Frame");
    }

    @Test
    @DisplayName("has the width passed by user")
    void frameShouldHaveWidthPassedByUser() {
        assertThat(largeFrame.getWidth()).isEqualTo(1000);
    }

    @Test
    @DisplayName("has the height passed by user")
    void frameShouldHaveHeightPassedByUser() {
        assertThat(largeFrame.getHeight()).isEqualTo(1000);
    }

    @Test
    @DisplayName("has title passed by user")
    void frameShouldHaveTitlePassedByUser() {
        assertThat(largeFrame.getFrame().getTitle()).isEqualTo("Large Frame");
    }
}
