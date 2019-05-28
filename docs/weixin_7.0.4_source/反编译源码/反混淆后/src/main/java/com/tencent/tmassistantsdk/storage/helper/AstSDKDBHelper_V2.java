package com.tencent.tmassistantsdk.storage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadLogTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable;
import com.tencent.tmassistantsdk.storage.table.UpdateInfoLogTable;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class AstSDKDBHelper_V2 extends SqliteHelper {
    protected static final String DB_NAME = "tmassistant_sdk_v2.db";
    protected static final int DB_VERSION = 3;
    private static final Class<?>[] TABLESS = new Class[]{DownloadInfoTable.class, DownloadSettingTable.class, ClientInfoTable.class, TipsInfoLogTable.class, DownloadLogTable.class, UpdateInfoLogTable.class};
    protected static SqliteHelper mInstance = null;

    public AstSDKDBHelper_V2(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static synchronized SqliteHelper getInstance() {
        SqliteHelper sqliteHelper;
        synchronized (AstSDKDBHelper_V2.class) {
            AppMethodBeat.m2504i(76183);
            if (mInstance == null) {
                Context context = GlobalUtil.getInstance().getContext();
                if (context != null) {
                    mInstance = new AstSDKDBHelper_V2(context, DB_NAME, null, 3);
                }
            }
            sqliteHelper = mInstance;
            AppMethodBeat.m2505o(76183);
        }
        return sqliteHelper;
    }

    public int getDBVersion() {
        return 3;
    }

    public Class<?>[] getTables() {
        return TABLESS;
    }
}
