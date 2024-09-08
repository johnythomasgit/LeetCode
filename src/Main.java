import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EncodeDecodeTest encoder = new EncodeDecodeTest();
        List<String> inputList = Arrays.asList(new String[]{"johny", "bla,bla"});
        String encodedString = encoder.encode(inputList);
        System.out.println("encoded string===> "+ encodedString);
        List<String> decodedList = encoder.decode(encodedString);
        System.out.println("decoded list===> "+ decodedList);

    }

}
