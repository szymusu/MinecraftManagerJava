package pl.lelenet.UI.arg;

@FullName("list")
@Abbreviation('l')
public class List extends Argument {

    @Override
    public void run() {
        System.out.println("listing all versions");
    }

    @Override
    void reactToOther(Argument other) { }

    @Override
    void reactToValue(Value other) { }
}
