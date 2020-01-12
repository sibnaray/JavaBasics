package dynamicprograms.wordbreakproblem;

class TrieNode{
    TrieNode[] arr;
    boolean isEnd;
    public TrieNode(){
        this.arr = new TrieNode[26];
    }
}
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word){
        TrieNode p = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p = p.arr[index];
            }
        }
        p.isEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean searchWord(String word){
        TrieNode p = searchNode(word);
        if(p==null)
            return false;
        else{
            if(p.isEnd)
                return true;
        }
        return false;
    }

    public TrieNode searchNode(String word){
        TrieNode p = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.arr[index]!=null)
                p=p.arr[index];
            else
                return null;
        }
        if(p==root)
            return null;
        return p;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("true");
        System.out.println(trie.searchWord("true"));
    }
}

