package pack;

public class ArrayView {

    private ArrayModel model;

    public ArrayView() {

    }

    public ArrayView(ArrayModel model) {
        this.model = model;
    }

    public void setModel(ArrayModel model) {
        this.model = model;
    }

    public void view() {
        for (int value : model.getModel()) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public void viewReverse() {
        for (int i = model.getModel().length-1; i >= 0; i--) {
            System.out.print(model.getModel()[i] + " ");
        }

        System.out.println();
    }

}

