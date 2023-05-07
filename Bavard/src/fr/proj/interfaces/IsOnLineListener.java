package fr.proj.interfaces;

import fr.proj.event.OnLineBavardEvent;

public interface IsOnLineListener {
    void isOnlineAlert(OnLineBavardEvent onLineBavardEvent, Boolean connected);


}
