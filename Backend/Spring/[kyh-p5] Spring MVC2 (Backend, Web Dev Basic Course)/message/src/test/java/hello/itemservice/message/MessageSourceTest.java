package hello.itemservice.message;

import static org.assertj.core.api.Assertions.*;

import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessageSourceTest {
  @Autowired
  MessageSource ms;

  @BeforeEach
  void beforeEach() {
    System.out.println(Locale.getDefault());
  }

  @Test
  void helloMessage() {
    String result = ms.getMessage("hello", null, null);
    assertThat(result).isEqualTo("안녕");
  }

  @Test
  void notFoundMessageCode() {
    assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
        .isInstanceOf(NoSuchMessageException.class);
  }

  @Test
  void notFoundMessageCodeDefaultMessage() {
    String result = ms.getMessage("no_code", null, "기본 메시지", null);
    assertThat(result).isEqualTo("기본 메시지");
  }

  @Test
  void argumentMessage() {
    String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
    assertThat(message).isEqualTo("안녕 Spring");
  }

  @Test
  void defaultLang() {
    assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
    assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
  }
}
