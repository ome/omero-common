package ome.api;

import java.security.Principal;

public interface IPrincipal extends Principal {

    String getName();

    String getGroup();

    String getEventType();

}
