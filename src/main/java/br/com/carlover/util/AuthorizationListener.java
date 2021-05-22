package br.com.carlover.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("[PHASE] " + event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
