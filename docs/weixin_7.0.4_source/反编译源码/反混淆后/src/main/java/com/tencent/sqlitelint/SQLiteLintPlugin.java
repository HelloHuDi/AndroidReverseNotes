package com.tencent.sqlitelint;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.p155b.C1061c;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1067a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour.IReportDelegate;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SQLiteLintPlugin extends C6283b {
    private static final String TAG = "Matrix.SQLiteLintPlugin";
    private final SQLiteLintConfig mConfig;
    private Context mContext;

    /* renamed from: com.tencent.sqlitelint.SQLiteLintPlugin$1 */
    class C73901 implements IReportDelegate {
        C73901() {
        }

        public void report(SQLiteLintIssue sQLiteLintIssue) {
            AppMethodBeat.m2504i(94023);
            if (sQLiteLintIssue == null) {
                AppMethodBeat.m2505o(94023);
                return;
            }
            SQLiteLintPlugin.access$000(SQLiteLintPlugin.this, sQLiteLintIssue);
            AppMethodBeat.m2505o(94023);
        }
    }

    static /* synthetic */ void access$000(SQLiteLintPlugin sQLiteLintPlugin, SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.m2504i(94031);
        sQLiteLintPlugin.reportMatrixIssue(sQLiteLintIssue);
        AppMethodBeat.m2505o(94031);
    }

    public SQLiteLintPlugin(SQLiteLintConfig sQLiteLintConfig) {
        this.mConfig = sQLiteLintConfig;
    }

    public void init(Application application, C1061c c1061c) {
        AppMethodBeat.m2504i(94024);
        super.init(application, c1061c);
        SQLiteLint.setPackageName(application);
        this.mContext = application.getApplicationContext();
        AppMethodBeat.m2505o(94024);
    }

    public void start() {
        AppMethodBeat.m2504i(94025);
        super.start();
        if (isSupported()) {
            SQLiteLint.setReportDelegate(new C73901());
            List concernDbList = this.mConfig.getConcernDbList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < concernDbList.size()) {
                    ConcernDb concernDb = (ConcernDb) concernDbList.get(i2);
                    String concernedDbPath = concernDb.getInstallEnv().getConcernedDbPath();
                    SQLiteLint.install(this.mContext, concernDb.getInstallEnv(), concernDb.getOptions());
                    SQLiteLint.setWhiteList(concernedDbPath, concernDb.getWhiteListXmlResId());
                    SQLiteLint.enableCheckers(concernedDbPath, concernDb.getEnableCheckerList());
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(94025);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(94025);
    }

    public void stop() {
        AppMethodBeat.m2504i(94026);
        super.stop();
        if (isSupported()) {
            List concernDbList = this.mConfig.getConcernDbList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < concernDbList.size()) {
                    SQLiteLint.uninstall(((ConcernDb) concernDbList.get(i2)).getInstallEnv().getConcernedDbPath());
                    i = i2 + 1;
                } else {
                    SQLiteLint.setReportDelegate(null);
                    AppMethodBeat.m2505o(94026);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(94026);
    }

    public void destroy() {
        AppMethodBeat.m2504i(94027);
        super.destroy();
        AppMethodBeat.m2505o(94027);
    }

    public String getTag() {
        return SharePluginInfo.TAG_PLUGIN;
    }

    public void notifySqlExecution(String str, String str2, int i) {
        AppMethodBeat.m2504i(94028);
        if (isPluginStarted()) {
            SQLiteLint.notifySqlExecution(str, str2, i);
            AppMethodBeat.m2505o(94028);
            return;
        }
        SLog.m8893i(TAG, "notifySqlExecution isPluginStarted not", new Object[0]);
        AppMethodBeat.m2505o(94028);
    }

    public void addConcernedDB(ConcernDb concernDb) {
        AppMethodBeat.m2504i(94029);
        if (!isPluginStarted()) {
            SLog.m8893i(TAG, "addConcernedDB isPluginStarted not", new Object[0]);
            AppMethodBeat.m2505o(94029);
        } else if (concernDb == null) {
            AppMethodBeat.m2505o(94029);
        } else {
            this.mConfig.addConcernDB(concernDb);
            String concernedDbPath = concernDb.getInstallEnv().getConcernedDbPath();
            SQLiteLint.install(this.mContext, concernDb.getInstallEnv(), concernDb.getOptions());
            SQLiteLint.setWhiteList(concernedDbPath, concernDb.getWhiteListXmlResId());
            SQLiteLint.enableCheckers(concernedDbPath, concernDb.getEnableCheckerList());
            AppMethodBeat.m2505o(94029);
        }
    }

    private void reportMatrixIssue(SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.m2504i(94030);
        SLog.m8893i(TAG, "reportMatrixIssue type:%d, isNew %b", Integer.valueOf(sQLiteLintIssue.type), Boolean.valueOf(sQLiteLintIssue.isNew));
        if (sQLiteLintIssue.isNew) {
            C1062b c1062b = new C1062b(sQLiteLintIssue.type);
            c1062b.key = sQLiteLintIssue.f1435id;
            JSONObject jSONObject = new JSONObject();
            c1062b.bWv = jSONObject;
            try {
                jSONObject.put("machine", C1067a.m2350aC(getApplication()));
                jSONObject.put("id", sQLiteLintIssue.f1435id);
                jSONObject.put("dbPath", sQLiteLintIssue.dbPath);
                jSONObject.put("level", sQLiteLintIssue.level);
                jSONObject.put(SharePluginInfo.ISSUE_KEY_SQL, sQLiteLintIssue.sql);
                jSONObject.put(SharePluginInfo.ISSUE_KEY_TABLE, sQLiteLintIssue.table);
                jSONObject.put("desc", sQLiteLintIssue.desc);
                jSONObject.put("detail", sQLiteLintIssue.detail);
                jSONObject.put("advice", sQLiteLintIssue.advice);
                jSONObject.put("createTime", sQLiteLintIssue.createTime);
                jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, sQLiteLintIssue.extInfo);
                jSONObject.put("sqlTimeCost", sQLiteLintIssue.sqlTimeCost);
                jSONObject.put(SharePluginInfo.ISSUE_KEY_IS_IN_MAIN_THREAD, sQLiteLintIssue.isInMainThread);
            } catch (JSONException e) {
                SLog.m8893i(TAG, "reportMatrixIssue e:%s", e.getLocalizedMessage());
            }
            onDetectIssue(c1062b);
            AppMethodBeat.m2505o(94030);
            return;
        }
        AppMethodBeat.m2505o(94030);
    }
}
