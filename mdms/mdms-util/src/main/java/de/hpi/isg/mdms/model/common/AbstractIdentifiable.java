package de.hpi.isg.mdms.model.common;

import java.io.Serializable;

/**
 * This abstract class is a convenience class taking care for {@link de.hpi.isg.mdms.model.common.Identifiable} objects by providing the field and
 * accesors.
 *
 */
public abstract class AbstractIdentifiable extends AbstractHashCodeAndEquals implements Identifiable, Serializable {

    private static final long serialVersionUID = -2489903063142674900L;
    private int id;

    public AbstractIdentifiable(final Observer observer, int id) {
        if (id == -1) {
            id = observer.generateRandomId();
        }
        this.id = id;
    }

    public AbstractIdentifiable(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

}
