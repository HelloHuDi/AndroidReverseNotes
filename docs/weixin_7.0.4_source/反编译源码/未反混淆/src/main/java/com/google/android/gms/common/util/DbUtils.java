package com.google.android.gms.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;
import javax.annotation.Nullable;

public final class DbUtils {
    private DbUtils() {
    }

    public static void clearDatabase(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(90149);
        zza(sQLiteDatabase, SharePluginInfo.ISSUE_KEY_TABLE, "sqlite_sequence", "android_metadata");
        zza(sQLiteDatabase, "trigger", new String[0]);
        zza(sQLiteDatabase, "view", new String[0]);
        AppMethodBeat.o(90149);
    }

    public static long countCurrentRowBytes(Cursor cursor) {
        AppMethodBeat.i(90162);
        long countCurrentRowBytes = countCurrentRowBytes(cursor, Charset.forName("UTF-8"));
        AppMethodBeat.o(90162);
        return countCurrentRowBytes;
    }

    public static long countCurrentRowBytes(Cursor cursor, Charset charset) {
        AppMethodBeat.i(90161);
        long j = 0;
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            switch (cursor.getType(i)) {
                case 0:
                case 1:
                case 2:
                    j += 4;
                    break;
                case 3:
                    j += (long) cursor.getString(i).getBytes(charset).length;
                    break;
                case 4:
                    j += (long) cursor.getBlob(i).length;
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(90161);
        return j;
    }

    public static long getDatabaseSize(Context context, String str) {
        AppMethodBeat.i(90160);
        try {
            File databasePath = context.getDatabasePath(str);
            if (databasePath != null) {
                long length = databasePath.length();
                AppMethodBeat.o(90160);
                return length;
            }
        } catch (SecurityException e) {
            String str2 = "Failed to get db size for ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
            }
        }
        AppMethodBeat.o(90160);
        return 0;
    }

    @Nullable
    public static Integer getIntegerFromCursor(Cursor cursor, int i) {
        AppMethodBeat.i(90152);
        Integer integerFromCursor = getIntegerFromCursor(cursor, i, null);
        AppMethodBeat.o(90152);
        return integerFromCursor;
    }

    @Nullable
    public static Integer getIntegerFromCursor(Cursor cursor, int i, @Nullable Integer num) {
        AppMethodBeat.i(90151);
        if (i < 0 || cursor.isNull(i)) {
            AppMethodBeat.o(90151);
            return num;
        }
        num = Integer.valueOf(cursor.getInt(i));
        AppMethodBeat.o(90151);
        return num;
    }

    @Nullable
    public static Long getLongFromCursor(Cursor cursor, int i) {
        AppMethodBeat.i(90154);
        Long longFromCursor = getLongFromCursor(cursor, i, null);
        AppMethodBeat.o(90154);
        return longFromCursor;
    }

    @Nullable
    public static Long getLongFromCursor(Cursor cursor, int i, @Nullable Long l) {
        AppMethodBeat.i(90153);
        if (i < 0 || cursor.isNull(i)) {
            AppMethodBeat.o(90153);
            return l;
        }
        l = Long.valueOf(cursor.getLong(i));
        AppMethodBeat.o(90153);
        return l;
    }

    @Nullable
    public static String getStringFromCursor(Cursor cursor, int i) {
        AppMethodBeat.i(90156);
        String stringFromCursor = getStringFromCursor(cursor, i, null);
        AppMethodBeat.o(90156);
        return stringFromCursor;
    }

    @Nullable
    public static String getStringFromCursor(Cursor cursor, int i, @Nullable String str) {
        AppMethodBeat.i(90155);
        if (i < 0 || cursor.isNull(i)) {
            AppMethodBeat.o(90155);
            return str;
        }
        str = cursor.getString(i);
        AppMethodBeat.o(90155);
        return str;
    }

    public static void putIntegerIntoContentValues(ContentValues contentValues, String str, @Nullable Integer num) {
        AppMethodBeat.i(90157);
        if (num != null) {
            contentValues.put(str, num);
            AppMethodBeat.o(90157);
            return;
        }
        contentValues.putNull(str);
        AppMethodBeat.o(90157);
    }

    public static void putLongIntoContentValues(ContentValues contentValues, String str, @Nullable Long l) {
        AppMethodBeat.i(90158);
        if (l != null) {
            contentValues.put(str, l);
            AppMethodBeat.o(90158);
            return;
        }
        contentValues.putNull(str);
        AppMethodBeat.o(90158);
    }

    public static void putStringIntoContentValues(ContentValues contentValues, String str, @Nullable String str2) {
        AppMethodBeat.i(90159);
        if (str2 != null) {
            contentValues.put(str, str2);
            AppMethodBeat.o(90159);
            return;
        }
        contentValues.putNull(str);
        AppMethodBeat.o(90159);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(SQLiteDatabase sQLiteDatabase, String str, String... strArr) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(90150);
        boolean z = SharePluginInfo.ISSUE_KEY_TABLE.equals(str) || "view".equals(str) || "trigger".equals(str);
        Preconditions.checkArgument(z);
        Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "type == ?", new String[]{str}, null, null, null);
        try {
            Set of = CollectionUtils.setOf((Object[]) strArr);
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (!of.contains(string)) {
                    sQLiteDatabase.execSQL(new StringBuilder((String.valueOf(str).length() + 8) + String.valueOf(string).length()).append("DROP ").append(str).append(" '").append(string).append("'").toString());
                }
            }
            if (query != null) {
                query.close();
                AppMethodBeat.o(90150);
                return;
            }
            AppMethodBeat.o(90150);
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            if (query != null) {
            }
            AppMethodBeat.o(90150);
            throw th;
        }
    }
}
