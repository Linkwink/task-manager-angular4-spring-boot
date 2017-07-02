package ua.com.hromoi.infrastructure.domain;

import ua.com.hromoi.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.hromoi.infrastructure.exceptions.EntityNotFoundException;
import ua.com.hromoi.infrastructure.exceptions.InvalidDataException;
import ua.com.hromoi.infrastructure.viewmodels.ViewModelAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.ViewModelForSave;
import ua.com.hromoi.infrastructure.viewmodels.ViewModelForView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 * Base service interface
 * @param <SAVE>  ViewModel that extends class ViewModelForSave and contains fields required for creation or updating of entity
 * @param <LIST>  ViewModel that extends class ViewModelAsListItem and contains required fields to display entity
 *                   as list item
 * @param <VIEW>  ViewModel that extends class ViewModelAsListItem and contains required fields to display entity
 *                   for details view
 * @param <ID>    class that entity uses as id
 */
public interface BaseService<
        SAVE extends ViewModelForSave,
        LIST extends ViewModelAsListItem,
        VIEW extends ViewModelForView,
        ID extends Serializable
        > {
    /**
     * Finds specific instance in database with such id
     * @param id unique id
     * @return instance of class with such id
     */
    VIEW find(ID id) throws EntityNotFoundException;

    /**
     * Gets all instances of class
     * @return collection of instances
     */
    List<LIST> findAll();

    /**
     * Saves instance in database
     * @param newEntity required fields for creation
     * @return id of the new instance in database
     */
    ID save(SAVE newEntity) throws EntityAlreadyExistsException, EntityNotFoundException, InvalidDataException;

    /**
     * Deletes instance from database
     * @param id id of the instance
     */
    void delete(ID id) throws EntityNotFoundException;

}
