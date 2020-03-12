package javaAgain.ChainOfResponsibility;

abstract class Handler {
    private Handler next;

    public void setNext(Handler handler) {
        this.next = handler;
    }

    public Handler getNext() {
        return this.next;
    }

    abstract void handlerRequest(String request);
}

public class Cor extends Handler {

    @Override
    void handlerRequest(String request) {
        if (request.equals("one")) {
            //
        } else {
            if (this.getNext() != null) {

                this.getNext().handlerRequest(request);
            } else {
                System.out.println("nobody handles this");
            }
        }

    }
}
