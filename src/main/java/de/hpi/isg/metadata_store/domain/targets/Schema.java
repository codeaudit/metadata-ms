package de.hpi.isg.metadata_store.domain.targets;

import java.util.Collection;

import de.hpi.isg.metadata_store.domain.Location;
import de.hpi.isg.metadata_store.domain.MetadataStore;
import de.hpi.isg.metadata_store.domain.Target;
import de.hpi.isg.metadata_store.exceptions.NameAmbigousException;

/**
 * A {@link Schema} combines multiple corresponding {@link Table}s.
 */

public interface Schema extends Target {

    /**
     * Adds a new table with the given name to this schema.
     *
     * @param metadataStore
     *        is the metadata store in which the new table shall be stored
     * @param name
     *        is the name of the table
     * @param location
     *        is the location of the table
     * @return the added table
     */
    public Table addTable(MetadataStore metadataStore, String name, String description, Location location);

    /**
     * @deprecated use {@link #addTable(String, Location)} instead
     */
    @Deprecated
    public Schema addTable(Table table);

    public Table getTableByName(String name) throws NameAmbigousException;

    public Collection<Table> getTablesByName(String name);

    public Table getTableById(int id);

    public Collection<Table> getTables();

    /**
     * Searches for a {@link Column} inside all of its known {@link Table}s.
     *
     * @param id
     * @return
     */
    Column findColumn(int id);

}
