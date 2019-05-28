package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.behaviour.alert.IssueAlertBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.behaviour.persistence.PersistenceBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.List;

class SQLiteLintAndroidCore implements IOnIssuePublishListener {
    private static final String TAG = "SQLiteLint.SQLiteLintAndroidCore";
    private final List<BaseBehaviour> mBehaviors;
    private final String mConcernedDbPath;
    private final Context mContext;
    private final ISQLiteExecutionDelegate mSQLiteExecutionDelegate;

    SQLiteLintAndroidCore(Context context, InstallEnv installEnv, Options options) {
        AppMethodBeat.m2504i(93993);
        this.mContext = context;
        SQLiteLintDbHelper.INSTANCE.initialize(context);
        this.mConcernedDbPath = installEnv.getConcernedDbPath();
        this.mSQLiteExecutionDelegate = installEnv.getSQLiteExecutionDelegate();
        if (SQLiteLint.getSqlExecutionCallbackMode() == SqlExecutionCallbackMode.HOOK) {
            SQLite3ProfileHooker.hook();
        }
        SQLiteLintNativeBridge.nativeInstall(this.mConcernedDbPath);
        this.mBehaviors = new ArrayList();
        this.mBehaviors.add(new PersistenceBehaviour());
        if (options.isAlertBehaviourEnable()) {
            this.mBehaviors.add(new IssueAlertBehaviour(context, this.mConcernedDbPath));
        }
        if (options.isReportBehaviourEnable()) {
            this.mBehaviors.add(new IssueReportBehaviour(SQLiteLint.sReportDelegate));
        }
        AppMethodBeat.m2505o(93993);
    }

    public void addBehavior(BaseBehaviour baseBehaviour) {
        AppMethodBeat.m2504i(93994);
        if (!this.mBehaviors.contains(baseBehaviour)) {
            this.mBehaviors.add(baseBehaviour);
        }
        AppMethodBeat.m2505o(93994);
    }

    public void removeBehavior(BaseBehaviour baseBehaviour) {
        AppMethodBeat.m2504i(93995);
        this.mBehaviors.remove(baseBehaviour);
        AppMethodBeat.m2505o(93995);
    }

    public void release() {
        AppMethodBeat.m2504i(93996);
        if (SQLiteLint.getSqlExecutionCallbackMode() == SqlExecutionCallbackMode.HOOK) {
            SQLite3ProfileHooker.unHook();
        }
        SQLiteLintNativeBridge.nativeUninstall(this.mConcernedDbPath);
        AppMethodBeat.m2505o(93996);
    }

    public ISQLiteExecutionDelegate getSQLiteExecutionDelegate() {
        return this.mSQLiteExecutionDelegate;
    }

    public void notifySqlExecution(String str, String str2, long j) {
        AppMethodBeat.m2504i(93997);
        String str3 = BuildConfig.COMMAND;
        if (j >= 8) {
            str3 = SQLiteLintUtil.getThrowableStack(new Throwable());
        }
        SQLiteLintNativeBridge.nativeNotifySqlExecute(str, str2, j, str3);
        AppMethodBeat.m2505o(93997);
    }

    public void setWhiteList(int i) {
        AppMethodBeat.m2504i(93998);
        CheckerWhiteListLogic.setWhiteList(this.mContext, this.mConcernedDbPath, i);
        AppMethodBeat.m2505o(93998);
    }

    public void enableCheckers(List<String> list) {
        AppMethodBeat.m2504i(93999);
        String[] strArr = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                strArr[i2] = (String) list.get(i2);
                i = i2 + 1;
            } else {
                SQLiteLintNativeBridge.nativeEnableCheckers(this.mConcernedDbPath, strArr);
                AppMethodBeat.m2505o(93999);
                return;
            }
        }
    }

    public void onPublish(List<SQLiteLintIssue> list) {
        int i = 0;
        AppMethodBeat.m2504i(94000);
        for (SQLiteLintIssue sQLiteLintIssue : list) {
            if (IssueStorage.hasIssue(sQLiteLintIssue.f1435id)) {
                sQLiteLintIssue.isNew = false;
            } else {
                sQLiteLintIssue.isNew = true;
            }
        }
        while (i < this.mBehaviors.size()) {
            ((BaseBehaviour) this.mBehaviors.get(i)).onPublish(list);
            i++;
        }
        AppMethodBeat.m2505o(94000);
    }
}
