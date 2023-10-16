package fr.insat.bemyhelper.Model;

import org.jetbrains.annotations.NotNull;

public class User {
    private final String first;
    private final String last;
    private final String user;
    private final UserType type;

    public User(@NotNull String first, @NotNull String last, @NotNull String user, @NotNull String type_str) throws IllegalArgumentException {
        if (first.matches("[A-Za-z-]{3,64}"))
            this.first = first;
        else
            throw new IllegalArgumentException();

        if (last.matches("[A-Za-z-]{3,64}"))
            this.last = last;
        else
            throw new IllegalArgumentException();

        if (user.matches("\\w{3,32}"))
            this.user = user;
        else
            throw new IllegalArgumentException();

        this.type = UserType.valueOf(type_str);
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getUser() {
        return user;
    }

    public UserType getType() {
        return type;
    }
}
