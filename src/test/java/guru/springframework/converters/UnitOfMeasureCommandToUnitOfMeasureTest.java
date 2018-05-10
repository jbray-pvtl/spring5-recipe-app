package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.internal.matchers.InstanceOf;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;


class UnitOfMeasureCommandToUnitOfMeasureTest {

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    void shouldReturnNullIfParameterIsNull() {
        UnitOfMeasure actual = converter.convert(null);
        assertNull(actual);
    }

    @Test
    void shouldReturnInstanceOfUnitOfMeasure() {
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        assertThat(converter.convert(unitOfMeasureCommand), instanceOf(UnitOfMeasure.class));
    }
}