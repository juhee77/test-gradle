package com.lahee.psSocial.mockitoTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MockTest2 {
    private class MyClass2 {
        public boolean getValue(String flag) {
            // 어떤 로직이 있을 것이라 가정
            return Boolean.parseBoolean(flag);
        }
    }

    // 테스트 대상 클래스
    MyClass2 myClass2;

    @BeforeEach
    public void setup() {
        myClass2 = Mockito.mock(MyClass2.class);
    }

    @Test
    @DisplayName("init 사용 예시")
    public void test2() {
        // Stubbing: 메서드 호출 시 반환값 설정
        when(myClass2.getValue(any())).thenReturn(true);

        // 검증: 예상된 값과 일치하는지 확인
        assertThat(myClass2.getValue("false")).isEqualTo(true);
    }
}
