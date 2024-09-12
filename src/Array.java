
public class Array {
    private Number[] elements;
    private int size;
    private int capacity;


    public Array() {
        this.size = 10;
        this.capacity = 10;
        this.elements = new Number[size];
        for(int i = 0; i<10;i++){
            elements[i] = new Number(Math.round(Math.random()*100),Math.round(Math.random()*100));
        }
    }

    public void input(int choice){
        if(choice == 1) {
            for (int i = 0; i < elements.length; i++) {
                System.out.print("Введите элемент массива: ");
                Number value = new Number();
                value = value.scannerNumber();
                elements[i] = value;
            }
        } else if (choice == 2) {
            for (int i = size; i < capacity; i++) {
                Number value = new Number();
                System.out.print("Введите элемент массива: ");
                value = value.scannerNumber();
                elements[i] = value;
            }
            size = capacity;
        }
        else {
            System.out.println("Ошибка ввода");
        }
    }

    public void resize(int newSize){
        Number[] numbers = new Number[newSize];
        for(int i = 0;i<newSize;i++){
            if(elements.length>i) {
                numbers[i] = elements[i];
            }
            else {
                numbers[i] = new Number();
            }
        }
        elements = numbers;
        capacity = newSize;
    }

    public void showArray(){
        for (Number element : elements) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    public void calculate(){
        int numberOfValues = elements.length;
        if(numberOfValues==0){
            System.out.println("The array is empty");
            return;
        }
        Number sum = new Number();
        for (Number element : elements) {
            sum = sum.numberSum(sum,element);
        }
        Number result1 = sum.numberDiv(sum,numberOfValues);
        System.out.println("The mean deviation is equal to " + result1);

        sum = new Number();
        Number difference = new Number();
        Number pow = new Number();
        for (Number element : elements) {
            difference = difference.numberDif(element,result1);
            pow = pow.numberSquare(difference);
            sum = sum.numberSum(sum,pow);
        }
        Number result2 = sum.numberDiv(sum,elements.length-1);
        System.out.println("The standard deviation is equal to "+ result2.numberSqrt(result2));
    }

    public void sortAscending(){
        for(int i = 0;i<elements.length-1;i++){
            boolean swapped = true;
            for(int j = 0; j<elements.length-1-i;j++){
                Number temp;
                if(elements[j].comparisonNumber(elements[j],elements[j+1]) == 1){
                    temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                    swapped = false;
                }
            }
            if(swapped){
                break;
            }
        }
    }

    public void sortDescending(){
        for(int i = 0;i<elements.length-1;i++){
            boolean swapped = true;
            for(int j = 0; j<elements.length-1-i;j++){
                Number temp;
                if(elements[j].comparisonNumber(elements[j],elements[j+1]) == -1){
                    temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                    swapped = false;
                }
            }
            if(swapped){
                break;
            }
        }
    }

    public void elementReplacement(int index){
        Number newNumber = new Number();
        System.out.print("Введите новое значение: ");
        elements[index] = newNumber.scannerNumber();

    }





}
