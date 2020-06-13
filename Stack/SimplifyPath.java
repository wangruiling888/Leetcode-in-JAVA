// method 1 use two stack to simplify path
// stack 1 is to store all folder name that is available
// stack 
class Solution {
    
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        Stack<String> stack_temp = new Stack<String>();
        String[] words = path.split("/");
        for (int i = 0; i < words.length; i++){
            if (words[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else if (words[i].equals(".") || words[i].equals("")) continue;
            else stack.push(words[i]);
        }
        String result = "";
        if (stack.isEmpty()) return "/";
         while(!stack.isEmpty()){
             String a = stack.pop();
             stack_temp.push(a);
        }
        while(!stack_temp.isEmpty()){
            result += "/";
            result += stack_temp.pop();
        }
        System.out.println(result);
        return result;
    }
   
}
