package pl.machnikovsky.fullstacktest.security;

public enum ApplicationUserPermission {

    BLOGGER_READ("blogger:read"),
    BLOGGER_WRITE("blogger:write"),
    BLOG_READ("blog:read"),
    BLOG_WRITE("blog:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
