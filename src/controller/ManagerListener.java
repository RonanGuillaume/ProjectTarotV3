package controller;

import java.awt.event.ActionListener;

/**
 * Created by Ronan
 * on 13/03/2017.
 */
public interface ManagerListener extends ActionListener {
    void playerCreated(PlayerEvent playerEvent);
    void goBackPlayerView();
    void showCreatePlayerView();
    void playerDeleted(PlayerEvent playerEvent);
    void playerNameModified(PlayerEvent playerEvent);
}
