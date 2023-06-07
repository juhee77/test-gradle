package com.lahee.psSocial.mockitoTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

// 테스트 클래스

public class MockTest {
    // 테스트 대상 클래스
    private class MyClass {
        public String getValue() {
            // 어떤 로직이 있을 것이라 가정
            return "real value";
        }
    }

    @Test
    @DisplayName("stubbing 예시")
    public void test1() {
        // Mock 객체 생성
        MyClass mockObject = mock(MyClass.class);

        // Stubbing: 메서드 호출 시 반환값 설정
        when(mockObject.getValue()).thenReturn("mocked value");

        // 테스트 대상 메서드 실행
        String result = mockObject.getValue();

        // 검증: 예상된 값과 일치하는지 확인
        assertThat(result).isEqualTo("mocked value");

        // 검증: 메서드 호출 횟수 검증
        verify(mockObject, times(1)).getValue();

        assertThat(mockObject.getValue()).isEqualTo("mocked value");
        verify(mockObject, times(2)).getValue();
    }
}
