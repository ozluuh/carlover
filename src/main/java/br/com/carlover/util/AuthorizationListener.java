package br.com.carlover.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.carlover.model.User;

public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        User user = (User) context.getExternalContext().getSessionMap().get("user");

        if (user == null) {
            NavigationHandler navigation = context.getApplication().getNavigationHandler();
            navigation.handleNavigation(context, "", "login?faces-redirect=true");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
