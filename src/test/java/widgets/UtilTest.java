package widgets;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class UtilTest {

    public static Stream<Arguments> newUserDataProvider() {
        return Stream.of(
                Arguments.of("Jan Kowalski", "JanKowalski@gmail.com", "12345"),
                Arguments.of("Marek Nowak", "MarekNowak@gmail.com", "12345"),
                Arguments.of("Anna Kowalska", "AnnaKowalska@gmail.com", "12345")
                // przypadek 2 i 3 będzie na fail ze względu na asercje.
        );
    }
}