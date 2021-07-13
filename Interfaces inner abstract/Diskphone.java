package inner_interfacess_Abstract;

public class Diskphone implements ITelephon{
    private int phonenumber =123;
    private boolean isRinging;

    @Override
    public void poweron() {
        System.out.println("There is no action taken");
    }

    @Override
    public void dial(int phonenumber) {
        System.out.println("now Ringing " + phonenumber+" on desk phone.");
    }

    @Override
    public void answer() {
        if (isRinging){
            System.out.println("Answering the desk phone");
            isRinging=false;
        }
    }

    @Override
    public boolean callphone(int phonenumber) {
        if (phonenumber==this.phonenumber){
            isRinging=true;
            System.out.println("Ring Ring");
        }
        else {
            isRinging=false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
