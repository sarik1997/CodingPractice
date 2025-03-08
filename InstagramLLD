/**Low-Level Design (LLD) for Instagram**
*1. Requirements**
    **Functional Requirements**
        ✔ User registration, login, and authentication
        ✔ Create, edit, and delete posts (images/videos)
        ✔ Like, comment, and share posts
        ✔ Follow/unfollow users
        ✔ Notifications for likes, comments, follows
        ✔ Search users and posts
        ✔ Direct messaging between users

        ### **Non-Functional Requirements**
        ✔ Scalable and highly available
        ✔ Low-latency responses
        ✔ Secure user data storage
        ✔ Efficient media storage and retrieval

 2. Identifying Key Entities and Classes**
      **Main Entities:**
        - `User`
        - `Post`
        - `Comment`
        - `Like`
        - `Follow`
        - `Notification`
        - `Message`

        ### **Class Diagram (Conceptual)**
        ```
        User
        ├── String userId
        ├── String name
        ├── List<Post> posts
        ├── List<User> followers
        ├── List<User> following
        ├── List<Notification> notifications
        ├── followUser(User user)
        ├── unfollowUser(User user)

        Post
        ├── String postId
        ├── String userId
        ├── String mediaUrl
        ├── String caption
        ├── List<Comment> comments
        ├── List<Like> likes

        Comment
        ├── String commentId
        ├── String userId
        ├── String text

        Like
        ├── String likeId
        ├── String userId

        Follow
        ├── String followId
        ├── String followerId
        ├── String followingId

        Notification
        ├── String notificationId
        ├── String userId
        ├── String message

        Message
        ├── String messageId
        ├── String senderId
        ├── String receiverId
        ├── String text
        ├── LocalDateTime timestamp
**/

import java.time.LocalDateTime;
import java.util.List;

class User {
    private String userId;
    private String name;
    private List<Post> posts;
    private List<User> followers;
    private List<User> following;
    private List<Notification> notifications;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void followUser(User user) {
        following.add(user);
        user.followers.add(this);
    }

    public void unfollowUser(User user) {
        following.remove(user);
        user.followers.remove(this);
    }
}
//2.Post

class Post {
    private String postId;
    private String userId;
    private String mediaUrl;
    private String caption;
    private List<Comment> comments;
    private List<Like> likes;

    public Post(String postId, String userId, String mediaUrl, String caption) {
        this.postId = postId;
        this.userId = userId;
        this.mediaUrl = mediaUrl;
        this.caption = caption;
    }
}
//3️⃣ Like and Comment
class Like {
    private String likeId;
    private String userId;
    public Like(String likeId, String userId) {
        this.likeId = likeId;
        this.userId = userId;
    }
}

class Comment {
    private String commentId;
    private String userId;
    private String text;
    public Comment(String commentId, String userId, String text) {
        this.commentId = commentId;
        this.userId = userId;
        this.text = text;
    }
}
//4️⃣ Follow and Notification
class Follow {
    private String followId;
    private String followerId;
    private String followingId;
    public Follow(String followId, String followerId, String followingId) {
        this.followId = followId;
        this.followerId = followerId;
        this.followingId = followingId;
    }
}

class Notification {
    private String notificationId;
    private String userId;
    private String message;
    public Notification(String notificationId, String userId, String message) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
    }
}
//5️⃣ Message

class Message {
    private String messageId;
    private String senderId;
    private String receiverId;
    private String text;
    private LocalDateTime timestamp;

    public Message(String messageId, String senderId, String receiverId, String text) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }
}
/**
        ## **4. Enhancements & Optimizations**
        ✔ **Use a database** instead of in-memory lists for scalability
✔ **Implement media storage** using AWS S3 or a CDN
✔ **Add caching** for frequently accessed data
✔ **Optimize search** with Elasticsearch
✔ **Introduce push notifications** for better engagement
✔ **Implement rate limiting** to prevent spam/fake accounts

**/
