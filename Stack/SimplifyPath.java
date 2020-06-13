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
// method 2 use ArrayList to store each of the word and assign the pointer to limit the valid folder
class Solution {  
    public String simplifyPath(String path) {
        ArrayList<String> list = new ArrayList<String>();
        int length = 0;
        String words[] = path.split("/");
        for (String word: words){
            if (word.equals("..")){
                if (length > 0){
                    System.out.println("pop "+ list.get(length - 1));
                    length --;
                } 
            }
            else if (word.equals(".") || word.equals("")) continue;
            else{
               list.add(length, word);
               length++;
            } 
        }
        if (length == 0) return "/";
        String result = "";
        for (int i = 0; i < length; i++){
            result += "/";
            result += list.get(i);
        }
        return result;
    } 
}
