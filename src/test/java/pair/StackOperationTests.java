package pair;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StackOperationTests<StackOperation> {
    StackOperations sut;
    @BeforeEach
    public void setUp(){
        sut = new StackOperations();
    }
    @Test
    public void count_WhenStackIsNull_ShouldReturn0(){
        //Arrange

        //Act
        int result = sut.count();

        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void push_WhenStackHasNewElement_ShouldNotReturn0(){
        //Arrange

        //Act
        int oldSize = sut.count();
        sut.push("new element");
        int newSize = sut.count();
        //Assert
        assertThat(newSize).isEqualTo(oldSize+1);
    }

    @Test
    public void pop_WhenDeleteElementFromStack_ShouldNotReturnNull(){
        //Arrange

        //Act
        sut.push("new element");
        String result = sut.pop();

        //Assert
        assertThat(result).isNotEmpty();
    }
    @Test
    public void pop_WhenDeleteElementFromEmptyStack_ShouldThrowException(){
        //Arrange

        //Act
        Throwable throwable = catchThrowable(() -> sut.pop());
        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("stack is empty for pop operation");
    }
    @Test
    public void pop_WhenDeleteElement_ShouldReturnLastAddedElement(){
        //Arrange
        //Act
        sut.push("first");
        sut.push("last");
        String result = sut.pop();
        //Assert
        assertThat(result).isEqualTo("last");
    }
    @Test
    public void peek_WhenGetElement_ShouldReturnLastElement(){
        //Arrange
        //Act
        sut.push("first");
        sut.push("last");
        String result = sut.peek();
        //Assert
        assertThat(result).isEqualTo("last");
    }
    @Test
    public void peek_WhenGetElement_ShouldNotChangeStackSize(){
        //Arrange
        //Act
        sut.push("first");
        sut.push("last");
        int oldSize = sut.count();
        String result = sut.peek();
        int newSize = sut.count();
        //Assert
        assertThat(oldSize).isEqualTo(newSize);
    }

}
