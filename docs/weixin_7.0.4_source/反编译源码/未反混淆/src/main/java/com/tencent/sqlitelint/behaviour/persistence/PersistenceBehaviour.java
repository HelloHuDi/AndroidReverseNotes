package com.tencent.sqlitelint.behaviour.persistence;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import java.util.List;

public class PersistenceBehaviour extends BaseBehaviour {
    public void onPublish(List<SQLiteLintIssue> list) {
        AppMethodBeat.i(94078);
        IssueStorage.saveIssues(list);
        AppMethodBeat.o(94078);
    }
}
