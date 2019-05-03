package no208;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 */
public class Trie {

    Trie[] childArray;
    boolean isEnd;

    public Trie() {
        childArray = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Character c = null;
        Trie  t = this;
        for (int i  = 0;i < word.length(); i++) {
            c = word.charAt(i);

            if (t.childArray[ c - 'a'] == null ){
                t.childArray[c-'a'] = new Trie();
            }
            if( i == word.length()-1 ) {
                t.childArray[c-'a'].isEnd = true;
            }

            t = t.childArray[c-'a'];
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Character c = null;
        Trie t = this;
        for (int i = 0;i < word.length();i++) {
            c = word.charAt(i);
            if (t.childArray[c - 'a'] == null ){
                return false;
            }

            t = t.childArray[c - 'a'];

        }
        return t.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Character c = null;
        Trie t = this;
        for (int i = 0;i < prefix.length();i++) {
            c = prefix.charAt(i);
            if (t.childArray[c - 'a'] == null ){
                return false;
            }
            t = t.childArray[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args){
        Trie root = new Trie();
        root.insert("abcd");
        System.out.println(root.search("abcd"));
        System.out.println(root.startsWith("abcd"));
        System.out.println(root.search("abc"));
        System.out.println(root.startsWith("abc"));
    }

}
