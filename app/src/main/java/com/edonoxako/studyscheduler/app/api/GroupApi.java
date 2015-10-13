package com.edonoxako.studyscheduler.app.api;

import com.edonoxako.studyscheduler.app.model.Group;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Евгений on 13.10.2015.
 */
public class GroupApi {

    private List<Group> groups;

    public GroupApi() {
        groups = new LinkedList<Group>();
        groups.add(new Group("KI11-11", "ISIT"));
        groups.add(new Group("KI10-15", "ISIT"));
        groups.add(new Group("KI13-19", "ISIT"));
        groups.add(new Group("KI11-03", "ISIT"));
        groups.add(new Group("KI11-06", "ISIT"));
    }

    public List<Group> fetchGroups() {
        return groups;
    }

    public Group fetchOneGroup(int pos) {
        return groups.get(pos);
    }

}
