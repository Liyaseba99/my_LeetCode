class Solution {
    public String alienOrder(String[] words) {
        int n = words.length;
        
        // Step 1: Build the graph
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[26]; // To store the indegree of each node
        Set<Character> allChars = new HashSet<>(); // To store all unique characters seen in words

        // Initialize adjacency list for 26 characters
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph from the list of words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c); // Track all unique characters
            }
        }

        // Create edges based on word pairwise comparison
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());

            // If s1 is a prefix of s2 and longer, it's an invalid case
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return ""; // Invalid order because "ab" can't come before "abc"
            }

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int from = s1.charAt(j) - 'a';
                    int to = s2.charAt(j) - 'a';
                    adj.get(from).add(to);
                    indegree[to]++; // Increase the indegree of the to node
                    break; // We only need the first differing character
                }
            }
        }

        // Step 2: Perform topological sort using Kahn's Algorithm (BFS)
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();
        
        // Start with nodes having zero indegree
        for (char c : allChars) {
            int node = c - 'a';
            if (indegree[node] == 0) {
                q.add(node);
            }
        }

        // BFS for topological sorting
        while (!q.isEmpty()) {
            int node = q.poll();
            topoSort.add(node);

            // For all neighbors, reduce their indegree
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If we couldn't sort all the characters, return ""
        if (topoSort.size() != allChars.size()) {
            return "";
        }

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (int node : topoSort) {
            result.append((char) (node + 'a'));
        }
        
        return result.toString();

    }
}