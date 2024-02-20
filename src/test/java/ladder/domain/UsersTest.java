package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {

    @DisplayName("사용자의 이름의 개수가 2명 미만일 경우 예외가 발생한다.")
    @Test
    void newUsersTestByCountUnderSize() {
        //given
        List<User> users = List.of(new User("ted"));

        // when, then
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자는 2~10명 까지만 등록 가능합니다.");
    }

    @DisplayName("사용자의 이름의 개수가 10명 초과할 경우 예외가 발생한다.")
    @Test
    void newUsersTestByCountOverSize() {
        //given
        List<User> users = List.of(new User("ted"),
                new User("ash"),
                new User("dora"),
                new User("ella"),
                new User("daon"),
                new User("lily"),
                new User("mia"),
                new User("zozo"),
                new User("gamza"),
                new User("mason"),
                new User("woni"));

        // when, then
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자는 2~10명 까지만 등록 가능합니다.");
    }

}