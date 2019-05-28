package com.tencent.sqlitelint;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.b.b;
import com.tencent.matrix.b.c;
import com.tencent.matrix.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour.IReportDelegate;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SQLiteLintPlugin extends b {
    private static final String TAG = "Matrix.SQLiteLintPlugin";
    private final SQLiteLintConfig mConfig;
    private Context mContext;

    static /* synthetic */ void access$000(SQLiteLintPlugin sQLiteLintPlugin, SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(94031);
        sQLiteLintPlugin.reportMatrixIssue(sQLiteLintIssue);
        AppMethodBeat.o(94031);
    }

    public SQLiteLintPlugin(SQLiteLintConfig sQLiteLintConfig) {
        this.mConfig = sQLiteLintConfig;
    }

    public void init(Application application, c cVar) {
        AppMethodBeat.i(94024);
        super.init(application, cVar);
        SQLiteLint.setPackageName(application);
        this.mContext = application.getApplicationContext();
        AppMethodBeat.o(94024);
    }

    public void start() {
        AppMethodBeat.i(94025);
        super.start();
        if (isSupported()) {
            SQLiteLint.setReportDelegate(new IReportDelegate() {
                public void report(SQLiteLintIssue sQLiteLintIssue) {
                    AppMethodBeat.i(94023);
                    if (sQLiteLintIssue == null) {
                        AppMethodBeat.o(94023);
                        return;
                    }
                    SQLiteLintPlugin.access$000(SQLiteLintPlugin.this, sQLiteLintIssue);
                    AppMethodBeat.o(94023);
                }
            });
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
                    AppMethodBeat.o(94025);
                    return;
                }
            }
        }
        AppMethodBeat.o(94025);
    }

    public void stop() {
        AppMethodBeat.i(94026);
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
                    AppMethodBeat.o(94026);
                    return;
                }
            }
        }
        AppMethodBeat.o(94026);
    }

    public void destroy() {
        AppMethodBeat.i(94027);
        super.destroy();
        AppMethodBeat.o(94027);
    }

    public String getTag() {
        return SharePluginInfo.TAG_PLUGIN;
    }

    public void notifySqlExecution(String str, String str2, int i) {
        AppMethodBeat.i(94028);
        if (isPluginStarted()) {
            SQLiteLint.notifySqlExecution(str, str2, i);
            AppMethodBeat.o(94028);
            return;
        }
        SLog.i(TAG, "notifySqlExecution isPluginStarted not", new Object[0]);
        AppMethodBeat.o(94028);
    }

    public void addConcernedDB(ConcernDb concernDb) {
        AppMethodBeat.i(94029);
        if (!isPluginStarted()) {
            SLog.i(TAG, "addConcernedDB isPluginStarted not", new Object[0]);
            AppMethodBeat.o(94029);
        } else if (concernDb == null) {
            AppMethodBeat.o(94029);
        } else {
            this.mConfig.addConcernDB(concernDb);
            String concernedDbPath = concernDb.getInstallEnv().getConcernedDbPath();
            SQLiteLint.install(this.mContext, concernDb.getInstallEnv(), concernDb.getOptions());
            SQLiteLint.setWhiteList(concernedDbPath, concernDb.getWhiteListXmlResId());
            SQLiteLint.enableCheckers(concernedDbPath, concernDb.getEnableCheckerList());
            AppMethodBeat.o(94029);
        }
    }

    private void reportMatrixIssue(SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(94030);
        SLog.i(TAG, "reportMatrixIssue type:%d, isNew %b", Integer.valueOf(sQLiteLintIssue.type), Boolean.valueOf(sQLiteLintIssue.isNew));
        if (sQLiteLintIssue.isNew) {
            com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(sQLiteLintIssue.type);
            bVar.key = sQLiteLintIssue.id;
            JSONObject jSONObject = new JSONObject();
            bVar.bWv = jSONObject;
            try {
                jSONObject.put("machine", a.aC(getApplication()));
                jSONObject.put("id", sQLiteLintIssue.id);
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
                SLog.i(TAG, "reportMatrixIssue e:%s", e.getLocalizedMessage());
            }
            onDetectIssue(bVar);
            AppMethodBeat.o(94030);
            return;
        }
        AppMethodBeat.o(94030);
    }
}
