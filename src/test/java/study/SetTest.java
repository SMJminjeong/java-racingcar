package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * 요구사항 1
     * Set의 size()메소드를 활용해 Set크기를 확인
     */
    @Test
    @DisplayName("setSize test")
    void setSize() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    /**
     * 요구사항 2
     * Set의 contains()메소드를 활용해 1,2,3의 값의 존재 확인
     * JUnit의 ParameterizedTest를 활용하여 중복 코드 제거해보기
     */
    @Test
    @DisplayName("contains test")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("@ParameterizedTest 를 이용하여 중복 코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(int num) {
        assertTrue(numbers.contains(num));
    }
}
