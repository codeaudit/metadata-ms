package de.hpi.isg.mdms.domain.targets;

import de.hpi.isg.mdms.model.location.Location;
import de.hpi.isg.mdms.model.common.ExcludeHashCodeEquals;
import de.hpi.isg.mdms.model.common.Printable;
import de.hpi.isg.mdms.domain.RDBMSMetadataStore;
import de.hpi.isg.mdms.model.targets.Column;
import de.hpi.isg.mdms.model.targets.Table;

/**
 * The default implementation of the {@link Column}.
 *
 */

public class RDBMSColumn extends AbstractRDBMSTarget implements Column {

    private static final long serialVersionUID = 2505519123200337186L;

    @ExcludeHashCodeEquals
    private final Table table;

    @Printable
    private final Location location;

    public static RDBMSColumn buildAndRegisterAndAdd(final RDBMSMetadataStore observer, final Table table,
            final int id,
            final String name, String description, final Location location) {

        final RDBMSColumn newColumn = new RDBMSColumn(observer, table, id, name, description, location, true);
        newColumn.register();
        // newColumn.getSqlInterface().addColumnToTable(newColumn, table);
        return newColumn;
    }

    public static RDBMSColumn restore(final RDBMSMetadataStore observer, final Table table, final int id,
            final String name, String description, final Location location) {

        final RDBMSColumn newColumn = new RDBMSColumn(observer, table, id, name, description, location, false);
        return newColumn;
    }

    private RDBMSColumn(final RDBMSMetadataStore observer, final Table table, final int id, final String name,
            String description, final Location location, boolean isFreshlyCreated) {
        super(observer, id, name, description, location, isFreshlyCreated);
        this.location = location;
        this.table = table;
    }

    @Override
    public void store() {
        this.sqlInterface.addColumnToTable(this, this.table);
    }

    /**
     * @return the parent table
     */
    @Override
    public Table getTable() {
        return this.table;
    }

    @Override
    public String getNameWithTableName() {
        return getTable().getName() + "." + getName();
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        return String.format("Column[%s, %08x, %s]", getNameWithTableName(), getId(),
                getLocation());

    }
}
