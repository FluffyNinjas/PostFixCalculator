public class Calculator extends ArrayStack{

    public static double converter(String infix){
        Stack<Double> newStack = new ArrayStack<>();
        for(int i = 0; i<infix.length();i++){
            String n = "";
            double x = 0;
            double y = 0;
            if(Character.isDigit(infix.charAt(i))){
                n+=infix.charAt(i);
                for(int p=i+1;p<infix.length();p++){
                    if(Character.isDigit(infix.charAt(p))){
                        n+=infix.charAt(p);
                        i++;
                    }
                    else{
                        break;
                    }
                }
                newStack.push((double) Integer.valueOf(n));
            }
            else if(infix.charAt(i)=='^'){
                x = newStack.pop();
                y = newStack.pop();
                newStack.push((double) Math.pow(y,x));
            }
            else if(infix.charAt(i)=='*'){
                x = newStack.pop();
                y = newStack.pop();
                newStack.push(x*y);
            }
            else if(infix.charAt(i)=='/'){
                x = newStack.pop();
                y = newStack.pop();
                newStack.push(y/x);
            }
            else if(infix.charAt(i)=='+'){
                x = newStack.pop();
                y = newStack.pop();
                newStack.push(x+y);
            }
            else if(infix.charAt(i)=='-'){
                x = newStack.pop();
                y = newStack.pop();
                newStack.push(y-x);
            }

        }
        return Math.round(newStack.pop()*10.0)/10.0;
    }

}
