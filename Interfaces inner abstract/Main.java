package inner_interfacess_Abstract;

public class Main {
    public static void main(String[] args) {
        ITelephon firstcall;
        firstcall=new Diskphone();
        firstcall.poweron();
        firstcall.callphone(123);
        firstcall.answer();
        firstcall.poweron();
        firstcall.callphone
                (123);
        firstcall.answer();
    }
}
