package com.tencent.sqlitelint;

import java.util.List;

public interface IOnIssuePublishListener {
    void onPublish(List<SQLiteLintIssue> list);
}
