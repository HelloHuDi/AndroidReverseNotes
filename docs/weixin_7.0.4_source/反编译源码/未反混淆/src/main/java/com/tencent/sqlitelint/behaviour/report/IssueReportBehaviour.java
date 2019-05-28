package com.tencent.sqlitelint.behaviour.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import java.util.List;

public class IssueReportBehaviour extends BaseBehaviour {
    private final IReportDelegate mReportDelegate;

    public interface IReportDelegate {
        void report(SQLiteLintIssue sQLiteLintIssue);
    }

    public IssueReportBehaviour(IReportDelegate iReportDelegate) {
        this.mReportDelegate = iReportDelegate;
    }

    public void onPublish(List<SQLiteLintIssue> list) {
        AppMethodBeat.i(94094);
        if (this.mReportDelegate != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                this.mReportDelegate.report((SQLiteLintIssue) list.get(i2));
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(94094);
    }
}
