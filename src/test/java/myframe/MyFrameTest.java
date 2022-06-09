package myframe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import texteditor.console.MyFrame;

import javax.swing.*;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MyFrame")
@ExtendWith(MyFrameParameterResolver.class)
public class MyFrameTest {

    MyFrame largeFrame;
    MyFrame smallFrame;

    @BeforeEach
    void init(Map<String, MyFrame> frames) {
        this.largeFrame = frames.get("Large Frame");
        this.smallFrame = frames.get("Small Frame");
    }

    @Test
    @DisplayName("has no null fields")
    void noFieldsAreNull() {
        assertThat(smallFrame).hasNoNullFieldsOrProperties();
    }

    @Nested
    @DisplayName("frame")
    class MyFrameFieldsTests {

        @Test
        @DisplayName("has title passed by user")
        void frameShouldHaveTitlePassedByUser() {
            assertThat(largeFrame.getFrame().getTitle()).isEqualTo("Large Frame");
        }

        @Test
        @DisplayName("has no menu-bar before build is called")
        void frameShouldNotHaveMenuBarBeforeBuildIsCalled () {
            assertThat(largeFrame.getFrame().getJMenuBar()).isNull();
        }
    }

    @Nested
    @DisplayName("size")
    class MyFrameSizeTests {

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
    }

    @Nested
    @DisplayName("menu-bar")
    class MyFrameMenuBarTests {

        JMenuBar jMenuBar;

        @BeforeEach
        void init() {
            this.jMenuBar = new JMenuBar();
        }

        @Test
        @DisplayName("is not null after calling build")
        void frameMenuBarShouldNotBeNull() {
            smallFrame.buildFrame(new JMenuBar());
            assertThat(smallFrame.getFrame().getJMenuBar()).isNotNull();
        }
    }
}
