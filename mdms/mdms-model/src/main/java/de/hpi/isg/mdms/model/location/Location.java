package de.hpi.isg.mdms.model.location;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * A {@link Location} represents the physical location of {@link de.hpi.isg.mdms.model.targets.Target}s.
 * 
 */
public interface Location extends Serializable {

    String TYPE = "TYPE";

    String INDEX = "INDEX";

    String PATH = "PATH";

    Map<String, String> getProperties();

    /**
     * Short-cut for setting a property.
     * 
     * @param propertyKey
     *        is the key of the property
     * @param value
     *        is the value of the property
     * @see #getProperties()
     */
    void set(String propertyKey, String value);

    /**
     * Short-cut for getting a property value.
     * 
     * @param propertyKey
     *        is the key of the property
     * @return
     * @see #getProperties()
     */
    String getIfExists(String propertyKey);

    /**
     * Short-cut for getting a property value. In contrast to {@link #getIfExists(String)}, this method demands that the
     * property exists.
     * 
     * @param propertyKey
     *        is the key of the property
     * @throws IllegalArgumentException
     *         if there is no property associated with the given key
     * @see #getProperties()
     */
    String get(String propertyKey);

    /**
     * Deletes the property with the given key if it exists.
     * 
     * @param propertyKey
     *        is the key of the property to be removed
     */
    void delete(String propertyKey);

    /**
     * Optional to allow for memory usage improvements.
     * 
     * @return all property keys that are potentially used by this {@link Location}
     */
    Collection<String> getAllPropertyKeys();

    /**
     * Optional to allow for memory usage improvements.
     * 
     * @return property keys used by this {@link Location} that are probably hosting only a few distinct values
     */
    Collection<String> getPropertyKeysForValueCanonicalization();

}
