import com.github.yorel.HumanReadableStepAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HumanReadableStepAspectTest {

    @Mock ProceedingJoinPoint pointMock;
    @Mock MethodSignature signatureMock;

    @Test
    public void convertsToHumanReadableFormat() throws Throwable {
        String emptyStep = "";
        Object[] args = {emptyStep, signatureMock};

        when(pointMock.getArgs()).thenReturn(args);
        when(signatureMock.getName()).thenReturn("nameOfMethod");

        Object result = new HumanReadableStepAspect().interceptStepName(pointMock);
        Assertions.assertThat(result)
                .isNotNull()
                .isInstanceOf(String.class)
                .isEqualTo("Name Of Method");
    }

    @Test
    public void doesntInterceptDefinedStepValues() throws Throwable {
        String stepValue = "This is custom user-defined step";
        Object[] args = {stepValue, signatureMock};

        when(pointMock.getArgs()).thenReturn(args);
        when(pointMock.proceed()).thenReturn(stepValue);

        Object result = new HumanReadableStepAspect().interceptStepName(pointMock);
        Assertions.assertThat(result)
                .isNotNull()
                .isInstanceOf(String.class)
                .isEqualTo(stepValue);
    }
}
