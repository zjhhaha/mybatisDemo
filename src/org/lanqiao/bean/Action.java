package org.lanqiao.bean;

/**
 * Created by ccc on 2017/8/29.
 */
public class Action {
    private int actionId;
    private String actionName;
    private String  actionUrl;

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Action() {
    }

    public Action(int actionId, String actionName, String actionUrl) {
        this.actionId = actionId;
        this.actionName = actionName;
        this.actionUrl = actionUrl;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", actionName='" + actionName + '\'' +
                ", actionUrl='" + actionUrl + '\'' +
                '}';
    }
}
