package com.tencent.wcdb;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseConfiguration;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.util.List;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String[] SUFFIX_TO_BACKUP = new String[]{"", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1"};
    private static final String TAG = "WCDB.DefaultDatabaseErrorHandler";
    private final boolean mNoCorruptionBackup;

    public DefaultDatabaseErrorHandler() {
        this.mNoCorruptionBackup = false;
    }

    public DefaultDatabaseErrorHandler(boolean z) {
        this.mNoCorruptionBackup = z;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(12169);
        Log.e(TAG, "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
        if (sQLiteDatabase.isOpen()) {
            List list = null;
            try {
                list = sQLiteDatabase.getAttachedDbs();
            } catch (SQLiteException e) {
            }
            SQLiteTrace traceCallback = sQLiteDatabase.getTraceCallback();
            if (traceCallback != null) {
                traceCallback.onDatabaseCorrupted(sQLiteDatabase);
            }
            try {
                sQLiteDatabase.close();
                if (list != null) {
                    for (Pair pair : list) {
                        deleteDatabaseFile((String) pair.second);
                    }
                    AppMethodBeat.o(12169);
                    return;
                }
                deleteDatabaseFile(sQLiteDatabase.getPath());
                AppMethodBeat.o(12169);
            } catch (SQLiteException e2) {
                if (list != null) {
                    for (Pair pair2 : list) {
                        deleteDatabaseFile((String) pair2.second);
                    }
                    AppMethodBeat.o(12169);
                    return;
                }
                deleteDatabaseFile(sQLiteDatabase.getPath());
                AppMethodBeat.o(12169);
            } catch (Throwable th) {
                if (list != null) {
                    for (Pair pair22 : list) {
                        deleteDatabaseFile((String) pair22.second);
                    }
                } else {
                    deleteDatabaseFile(sQLiteDatabase.getPath());
                }
                AppMethodBeat.o(12169);
            }
        } else {
            deleteDatabaseFile(sQLiteDatabase.getPath());
            AppMethodBeat.o(12169);
        }
    }

    private void deleteDatabaseFile(String str) {
        int i = 0;
        AppMethodBeat.i(12170);
        if (str.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) || str.trim().length() == 0) {
            AppMethodBeat.o(12170);
            return;
        }
        Log.e(TAG, "Remove database file: ".concat(String.valueOf(str)));
        if (this.mNoCorruptionBackup) {
            String[] strArr = SUFFIX_TO_BACKUP;
            int length = strArr.length;
            while (i < length) {
                deleteFile(str + strArr[i]);
                i++;
            }
            AppMethodBeat.o(12170);
            return;
        }
        File file = new File(str);
        File file2 = new File(file.getParentFile(), "corrupted");
        if (!file2.mkdirs()) {
            Log.e(TAG, "Could not create directory for corrupted database. Corruption backup may be unavailable.");
        }
        String str2 = file2.getPath() + "/" + file.getName();
        String[] strArr2 = SUFFIX_TO_BACKUP;
        int length2 = strArr2.length;
        while (i < length2) {
            String str3 = strArr2[i];
            moveOrDeleteFile(str + str3, str2 + str3);
            i++;
        }
        AppMethodBeat.o(12170);
    }

    private static boolean moveOrDeleteFile(String str, String str2) {
        AppMethodBeat.i(12171);
        File file = new File(str);
        boolean renameTo = file.renameTo(new File(str2));
        if (!renameTo) {
            file.delete();
        }
        AppMethodBeat.o(12171);
        return renameTo;
    }

    private static boolean deleteFile(String str) {
        AppMethodBeat.i(12172);
        boolean delete = new File(str).delete();
        AppMethodBeat.o(12172);
        return delete;
    }
}
