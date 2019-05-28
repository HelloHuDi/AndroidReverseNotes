package com.tencent.matrix.iocanary.core;

import java.util.List;

public interface OnJniIssuePublishListener {
    void onIssuePublish(List<IOIssue> list);
}
