package com.tencent.tmassistantsdk.storage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadLogTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class AstSDKDBHelper extends SqliteHelper {
    public static final String DB_NAME = "tmassistant_sdk.db";
    protected static final int DB_VERSION = 2;
    private static final Class<?>[] TABLESS = new Class[]{DownloadInfoTable.class, DownloadSettingTable.class, ClientInfoTable.class, TipsInfoLogTable.class, DownloadLogTable.class};
    protected static SqliteHelper mInstance = null;

    public AstSDKDBHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, DB_NAME, cursorFactory, i);
    }

    public static synchronized SqliteHelper getInstance() {
        SqliteHelper sqliteHelper;
        synchronized (AstSDKDBHelper.class) {
            AppMethodBeat.m2504i(76182);
            if (mInstance == null) {
                Context context = GlobalUtil.getInstance().getContext();
                if (context != null) {
                    mInstance = new AstSDKDBHelper(context, DB_NAME, null, 2);
                }
            }
            sqliteHelper = mInstance;
            AppMethodBeat.m2505o(76182);
        }
        return sqliteHelper;
    }

    public int getDBVersion() {
        return 2;
    }

    public Class<?>[] getTables() {
        return TABLESS;
    }
}
