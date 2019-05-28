package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wxmm.v2helper;
import java.io.File;

public final class Context {
    public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;

    static {
        AppMethodBeat.i(12707);
        SQLiteGlobal.loadLib();
        AppMethodBeat.o(12707);
    }

    private static File getDataDirFile(android.content.Context context) {
        AppMethodBeat.i(12697);
        if (context != null) {
            String str = context.getApplicationInfo().dataDir;
            if (str != null) {
                File file = new File(str);
                AppMethodBeat.o(12697);
                return file;
            }
            AppMethodBeat.o(12697);
            return null;
        }
        RuntimeException runtimeException = new RuntimeException("Not supported in system context");
        AppMethodBeat.o(12697);
        throw runtimeException;
    }

    private static File getDatabasesDir(android.content.Context context) {
        AppMethodBeat.i(12698);
        File file = new File(getDataDirFile(context), "databases");
        if (file.getPath().equals("databases")) {
            file = new File("/data/system");
        }
        AppMethodBeat.o(12698);
        return file;
    }

    private static File makeFilename(File file, String str) {
        AppMethodBeat.i(12699);
        if (str.indexOf(File.separatorChar) < 0) {
            File file2 = new File(file, str);
            AppMethodBeat.o(12699);
            return file2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("File " + str + " contains a path separator");
        AppMethodBeat.o(12699);
        throw illegalArgumentException;
    }

    private static File validateFilePath(android.content.Context context, String str, boolean z) {
        File file;
        File file2;
        AppMethodBeat.i(12700);
        if (str.charAt(0) == File.separatorChar) {
            file = new File(str.substring(0, str.lastIndexOf(File.separatorChar)));
            file2 = new File(file, str.substring(str.lastIndexOf(File.separatorChar)));
        } else {
            file = getDatabasesDir(context);
            file2 = makeFilename(file, str);
        }
        if (z && !file.isDirectory() && file.mkdir()) {
            FileUtils.setPermissions(file.getPath(), 505, -1, -1);
        }
        AppMethodBeat.o(12700);
        return file2;
    }

    private static void setFilePermissionsFromMode(String str, int i, int i2) {
        AppMethodBeat.i(12701);
        int i3 = i2 | v2helper.EMethodSetSendToNetworkOn;
        if ((i & 1) != 0) {
            i3 |= 4;
        }
        if ((i & 2) != 0) {
            i3 |= 2;
        }
        FileUtils.setPermissions(str, i3, -1, -1);
        AppMethodBeat.o(12701);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, int i, CursorFactory cursorFactory) {
        AppMethodBeat.i(12702);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, null, null, i, cursorFactory, null, 0);
        AppMethodBeat.o(12702);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12703);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, null, null, i, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(12703);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i, CursorFactory cursorFactory) {
        AppMethodBeat.i(12704);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, bArr, sQLiteCipherSpec, i, cursorFactory, null, 0);
        AppMethodBeat.o(12704);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(12705);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, bArr, sQLiteCipherSpec, i, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(12705);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(12706);
        File validateFilePath = validateFilePath(context, str, true);
        int i3 = 268435456;
        if ((i & 8) != 0) {
            i3 = 805306368;
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(validateFilePath.getPath(), bArr, sQLiteCipherSpec, cursorFactory, i3, databaseErrorHandler, i2);
        setFilePermissionsFromMode(validateFilePath.getPath(), i, 0);
        AppMethodBeat.o(12706);
        return openDatabase;
    }
}
