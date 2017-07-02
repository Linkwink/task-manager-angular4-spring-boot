package ua.com.hromoi.infrastructure.domain;

import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectForSave;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectForView;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public interface ProjectService extends BaseService<
        ProjectForSave,
        ProjectAsListItem,
        ProjectForView,
        Integer> {

}
