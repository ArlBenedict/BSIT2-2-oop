import java.util.*;

public class PostManager {

    public int calculateEngagement(int... interactions) {
        if (interactions == null || interactions.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : interactions) {
            sum += i;
        }
        return sum;
    }

    public String getCategoryRating(int engagementScore) {
        if (engagementScore >= 1000) {
            return "Viral";
        } else if (engagementScore >= 500) {
            return "Popular";
        } else if (engagementScore >= 100) {
            return "Good";
        } else if (engagementScore >= 50) {
            return "Low";
        } else {
            return "Poor";
        }
    }

    public void displayPostStats(String postTitle, int engagementScore) {
        System.out.println("Post: " + postTitle);
        System.out.println("Engagement Score: " + engagementScore);
    }

    public void displayPostStats(String postTitle, int engagementScore, String category) {
        System.out.println("Post: " + postTitle);
        System.out.println("Engagement Score: " + engagementScore);
        System.out.println("Category: " + category);
    }

    
    public ArrayList<String> manageHashtags(String[] hashtags) {
        ArrayList<String> uniqueHashtags = new ArrayList<>();
        if (hashtags == null) return uniqueHashtags;
        String[] fixedSize = new String[5];
        for (int i = 0; i < 5; i++) {
            if (hashtags.length > i && hashtags[i] != null)
                fixedSize[i] = hashtags[i];
            else
                fixedSize[i] = "";
        }
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(fixedSize));
        set.remove(""); 
        uniqueHashtags.addAll(set);
        return uniqueHashtags;
    }

    public LinkedList<String> findTrendingPosts(ArrayList<String> posts, HashMap<String, Integer> postEngagement) {
        LinkedList<String> trending = new LinkedList<>();
        if (posts == null || postEngagement == null) return trending;
        for (String post : posts) {
            Integer engagement = postEngagement.get(post);
            if (engagement != null && engagement > 500) {
                trending.add(post);
            }
        }
        return trending;
    }

    public LinkedHashSet<String> getUniqueAuthors(String... authors) {
        LinkedHashSet<String> unique = new LinkedHashSet<>();
        if (authors == null) return unique;
        for (String a : authors) {
            if (a != null) unique.add(a);
        }
        return unique;
    }

    public static void main(String[] args) {
        System.out.println("\n=== Social Media Post Manager ===\n");

        PostManager pm = new PostManager();

        String postTitle = "Java Programming Tips";
        int likes = 150, comments = 75, shares = 25;
        int engagementScore = pm.calculateEngagement(likes, comments, shares);

        String category = pm.getCategoryRating(engagementScore);
        pm.displayPostStats(postTitle, engagementScore, category);

       
        String[] hashtags = {"#java", "#coding", "#programming", "#java", "#tips"};
        ArrayList<String> uniqueHashtags = pm.manageHashtags(hashtags);
        System.out.println("\nUnique Hashtags: " + uniqueHashtags);

      
        ArrayList<String> postList = new ArrayList<>();
        postList.add("Java Programming Tips");
        postList.add("Advanced Java Tutorial");
        postList.add("Spring Boot Guide");

        HashMap<String, Integer> postEngagement = new HashMap<>();
        postEngagement.put("Java Programming Tips", engagementScore); 
        postEngagement.put("Advanced Java Tutorial", 700);
        postEngagement.put("Spring Boot Guide", 1000);

        LinkedList<String> trending = pm.findTrendingPosts(postList, postEngagement);
        System.out.println("Trending Posts: " + trending);

       
        LinkedHashSet<String> uniqueAuthors = pm.getUniqueAuthors("Alice", "Bob", "Alice", "Charlie", "Bob");
        System.out.println("Unique Authors: " + uniqueAuthors);
    }
}
