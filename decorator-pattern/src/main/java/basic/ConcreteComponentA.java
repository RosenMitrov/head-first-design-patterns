package basic;

public class ConcreteComponentA extends Component {


    public ConcreteComponentA() {
        super.setType("CONCRETE_COMPONENT_A");
    }

    @Override
    int calculateCount() {
        return 1;
    }
}
