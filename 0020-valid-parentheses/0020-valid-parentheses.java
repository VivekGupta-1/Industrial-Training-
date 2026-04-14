class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== '(' || s.charAt(i)== '[' || s.charAt(i)== '{'){
                stk.push(s.charAt(i));
            }else{
                if(stk.isEmpty()){return false;}
                char out =  stk.pop();
                if(out == '{' && s.charAt(i)== '}'){}
                else if(out == '(' && s.charAt(i)== ')'){}
                else if(out =='[' && s.charAt(i)==']'){}
                else{
                    return false;
                }
                
            }
        }

        if(stk.isEmpty()) return true;
        return false;
    }
}