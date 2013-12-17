package com.altamiracorp.lumify.core.model.audit;

import com.altamiracorp.bigtable.model.ColumnFamily;
import com.altamiracorp.bigtable.model.Value;
import com.altamiracorp.lumify.core.user.User;
import org.json.JSONException;
import org.json.JSONObject;

public class AuditCommon extends ColumnFamily {
    public static final String NAME = "common";
    public static final String ACTOR_TYPE = "actorType";
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final String ACTION = "action";
    public static final String TYPE = "type";
    public static final String COMMENT = "comment";
    public static final String PROCESS = "process";

    public AuditCommon() {
        super(NAME);
    }

    public String getActorType() {
        return Value.toString(get(ACTOR_TYPE));
    }

    public AuditCommon setActorType(String actorType) {
        set(ACTOR_TYPE, actorType);
        return this;
    }

    public String getUserId() {
        return Value.toString(get(USER_ID));
    }

    public AuditCommon setUserId(String userId) {
        set(USER_ID, userId);
        return this;
    }

    public String getUserName() {
        return Value.toString(get(USER_NAME));
    }

    public AuditCommon setUserName(String userName) {
        set(USER_NAME, userName);
        return this;
    }

    public String getAction() {
        return Value.toString(get(ACTION));
    }

    public AuditCommon setAction(String action) {
        set(ACTION, action);
        return this;
    }

    public String getType() {
        return Value.toString(get(TYPE));
    }

    public AuditCommon setType(String type) {
        set(TYPE, type);
        return this;
    }

    public String getComment() {
        return Value.toString(get(COMMENT));
    }

    public AuditCommon setComment(String comment) {
        set(COMMENT, comment);
        return this;
    }

    public AuditCommon setUser(User user) {
        setUserId(user.getRowKey());
        setUserName(user.getUsername());
        setActorType(user.getUserType());
        return this;
    }

    public String getProcess () {
        return Value.toString(get(PROCESS));
    }

    public AuditCommon setProcess (String process) {
        set (PROCESS, process);
        return this;
    }

    @Override
    public JSONObject toJson() {
        try {
            JSONObject json = new JSONObject();
            json.put("actorType", getActorType());
            json.put("userId", getUserId());
            json.put("userName", getUserName());
            json.put("action", getAction());
            json.put("type", getType());
            json.put("comment", getComment());
            json.put("process", getProcess());
            return json;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
