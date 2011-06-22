package soc.common.server;

import java.util.ArrayList;
import java.util.List;

import soc.common.actions.Valid;
import soc.common.actions.ValidateResult;
import soc.common.lobby.GameInfo;
import soc.common.lobby.LoginResponse;
import soc.common.server.entities.User;
import soc.common.server.entities.UserList;

public class LoginResponseImpl implements LoginResponse
{
    private static final long serialVersionUID = -1979935151683745494L;
    private List<GameInfo> games = new ArrayList<GameInfo>();
    private UserList users = new UserList();
    private User user;
    private ValidateResult authenticated;;

    @Override
    public List<GameInfo> getLobbyGames()
    {
        return games;
    }

    @Override
    public UserList getLoggedInUsers()
    {
        return users;
    }

    public LoginResponseImpl()
    {
    }

    public LoginResponseImpl(List<GameInfo> games, UserList users)
    {
        this.games = games;
        this.users = users;
        authenticated = new Valid();
    }

    public LoginResponseImpl(ValidateResult b)
    {
    }

    @Override
    public User getUser()
    {
        return user;
    }

    @Override
    public LoginResponse setUser(User user)
    {
        this.user = user;
        return this;
    }

    @Override
    public ValidateResult isAuthenticated()
    {
        return authenticated;
    }
}