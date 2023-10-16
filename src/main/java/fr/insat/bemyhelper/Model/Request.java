package fr.insat.bemyhelper.Model;

import org.jetbrains.annotations.NotNull;

public class Request {
    private final User requester;
    private final String descrition;
    private final long id;
    private final RequestState state;

    public Request(@NotNull User requester, @NotNull String descrition, long id, @NotNull RequestState state) {
        this.requester = requester;
        this.descrition = descrition;
        this.id = id;
        this.state = state;
    }

    public User getRequester() {
        return requester;
    }

    public String getDescrition() {
        return descrition;
    }

    public long getId() {
        return id;
    }

    public RequestState getState() {
        return state;
    }
}
