package ua.com.hromoi.infrastructure.domain;

import ua.com.hromoi.infrastructure.viewmodels.Task.TaskAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForSave;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForView;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public interface TaskService extends BaseService<
        TaskForSave,
        TaskAsListItem,
        TaskForView,
        Integer> {

}
