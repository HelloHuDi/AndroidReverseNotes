package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;

public class IssueAlertBehaviour extends BaseBehaviour {
    private static final String NAME = "SQLiteLint";
    private static final String TAG = "Matrix.IssueAlertBehaviour";
    private static Handler sMainHandler = new Handler(Looper.getMainLooper());
    private final String mConcernedDbPath;
    private final Context mContext;
    private long mLastInsertRowId;

    /* renamed from: com.tencent.sqlitelint.behaviour.alert.IssueAlertBehaviour$1 */
    class C58311 implements Runnable {
        C58311() {
        }

        public void run() {
            AppMethodBeat.m2504i(94057);
            Intent intent = new Intent();
            intent.setClass(IssueAlertBehaviour.this.mContext, CheckResultActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(CheckResultActivity.KEY_DB_LABEL, IssueAlertBehaviour.this.mConcernedDbPath);
            IssueAlertBehaviour.this.mContext.startActivity(intent);
            AppMethodBeat.m2505o(94057);
        }
    }

    static {
        AppMethodBeat.m2504i(94061);
        AppMethodBeat.m2505o(94061);
    }

    public IssueAlertBehaviour(Context context, String str) {
        AppMethodBeat.m2504i(94058);
        this.mContext = context;
        this.mConcernedDbPath = str;
        createShortCut(context);
        AppMethodBeat.m2505o(94058);
    }

    public void onPublish(List<SQLiteLintIssue> list) {
        AppMethodBeat.m2504i(94059);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(94059);
            return;
        }
        long lastRowId = IssueStorage.getLastRowId();
        if (lastRowId == this.mLastInsertRowId) {
            SLog.m8894v(TAG, "no new issue", new Object[0]);
            AppMethodBeat.m2505o(94059);
            return;
        }
        this.mLastInsertRowId = lastRowId;
        sMainHandler.post(new C58311());
        AppMethodBeat.m2505o(94059);
    }

    private static void createShortCut(Context context) {
        AppMethodBeat.m2504i(94060);
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.launcher2.settings/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{"SQLiteLint"}, null);
        if (query != null) {
            int count = query.getCount();
            query.close();
            if (count > 0) {
                AppMethodBeat.m2505o(94060);
                return;
            }
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", "SQLiteLint");
        intent.putExtra("duplicate", false);
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.setClassName(context, CheckedDatabaseListActivity.class.getName());
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, C25738R.drawable.bii));
        context.sendBroadcast(intent);
        AppMethodBeat.m2505o(94060);
    }
}
