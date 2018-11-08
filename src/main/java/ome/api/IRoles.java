package ome.api;

import ome.model.meta.Experimenter;
import ome.model.meta.ExperimenterGroup;

public interface IRoles {

    /**
     * @return the id of the root user
     */
    long getRootId();

    /**
     * @return the {@link Experimenter#getOmeName()} of the root user
     */
    String getRootName();

    /**
     * @return the id of the guest user
     */
    long getGuestId();

    /**
     * @return the {@link Experimenter#getOmeName()} of the guest user
     */
    String getGuestName();

    /**
     * @return the id of the system group
     */
    long getSystemGroupId();

    /**
     * @return the {@link ExperimenterGroup#getName()} of the system group
     */
    String getSystemGroupName();

    /**
     * @return the id of the user group
     */
    long getUserGroupId();

    /**
     * @return the {@link ExperimenterGroup#getName()} of the user group
     */
    String getUserGroupName();

    /**
     * @return the id of the guest group
     */
    long getGuestGroupId();

    /**
     * @return the {@link ExperimenterGroup#getName()} of the guest group
     */
    String getGuestGroupName();

    boolean isRootUser(Experimenter user);

    boolean isUserGroup(ExperimenterGroup group);

    boolean isSystemGroup(ExperimenterGroup group);
}
