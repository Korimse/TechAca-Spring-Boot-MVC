package first.project.api.designPatterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FactorMethodTest {
    @Test
    @DisplayName("팩토리 메소드 테스트")
    void main() {
        FlooringFactory.getFlooring(5, 20).installation();
        FlooringFactory.getFlooring(5, 40).installation();
        FlooringFactory.getFlooring(10, 15).installation();
    }
}
interface Flooring{void installation();}
class ConcreteFlooring implements Flooring{
    @Override
    public void installation() {
        System.out.println("컨트리트 바닥 시공됨");
    }
}
class CorkFlooring implements Flooring{
    @Override
    public void installation() {
        System.out.println("코크 바닥 시공됨");
    }
}
class WoodenFlooring implements Flooring{
    @Override
    public void installation() {
        System.out.println("목재 바닥 시공됨");
    }
}
class FlooringFactory{
    static Flooring getFlooring(int min, int max){
        Supplier<Flooring> flooring;
        if(min <= 5 && max <= 20){ flooring = WoodenFlooring::new;}
        else if(min <= 5 && max <= 45){ flooring = CorkFlooring::new;}
        else{ flooring = ConcreteFlooring::new;}
        return flooring.get();
    }
}