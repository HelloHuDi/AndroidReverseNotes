package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieManager.a;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class x {
    public static final String a = CookieManager.LOGTAG;
    static File b;

    public static File a(Context context) {
        AppMethodBeat.i(64142);
        if (b == null && context != null) {
            b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            b = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        File file = b;
        AppMethodBeat.o(64142);
        return file;
    }

    private static String a(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.i(64146);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from ".concat(String.valueOf(str)), null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("raws:" + count + ",columns:" + columnCount + IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuilder2;
        if (count <= 0 || !rawQuery.moveToFirst()) {
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(64146);
            return stringBuilder2;
        }
        do {
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            for (count = 0; count < columnCount; count++) {
                try {
                    stringBuilder.append(rawQuery.getString(count)).append(",");
                } catch (Exception e) {
                }
            }
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        } while (rawQuery.moveToNext());
        stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(64146);
        return stringBuilder2;
    }

    public static ArrayList<String> a(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(64145);
        if (sQLiteDatabase == null) {
            AppMethodBeat.o(64145);
            return arrayList;
        }
        ArrayList<String> arrayList2 = new ArrayList();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(1);
                    rawQuery.getString(4);
                    arrayList2.add(string);
                    a(sQLiteDatabase, string);
                } while (rawQuery.moveToNext());
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (arrayList != null) {
                arrayList.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            AppMethodBeat.o(64145);
        }
        AppMethodBeat.o(64145);
        return arrayList2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e3  */
    /* JADX WARNING: Missing block: B:29:0x006c, code skipped:
            if (r0 != false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Context context, a aVar, String str, boolean z, boolean z2) {
        Cursor cursor = null;
        AppMethodBeat.i(64148);
        if (context == null) {
            AppMethodBeat.o(64148);
        } else if (aVar == a.MODE_KEYS && TextUtils.isEmpty(str)) {
            AppMethodBeat.o(64148);
        } else {
            String[] split = str.split(",");
            if (split == null || split.length <= 0) {
                AppMethodBeat.o(64148);
                return;
            }
            SQLiteDatabase c = c(context);
            if (c == null) {
                AppMethodBeat.o(64148);
                return;
            }
            HashMap hashMap = new HashMap();
            try {
                cursor = c.rawQuery("select * from cookies", null);
                int d;
                if (cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (c != null && c.isOpen()) {
                        c.close();
                    }
                    if (hashMap.isEmpty()) {
                        b(context);
                        for (Entry entry : hashMap.entrySet()) {
                            CookieManager.getInstance().setCookie((String) entry.getKey(), (String) entry.getValue(), true);
                        }
                        if (VERSION.SDK_INT >= 21) {
                            CookieManager.getInstance().flush();
                        } else {
                            CookieSyncManager.getInstance().sync();
                        }
                        if (z) {
                            a(c(context));
                            d = d(context);
                            if (d != -1) {
                                CookieManager.getInstance();
                                CookieManager.setROMCookieDBVersion(context, d);
                            }
                        }
                        AppMethodBeat.o(64148);
                        return;
                    }
                    AppMethodBeat.o(64148);
                    return;
                }
                do {
                    String string = cursor.getString(cursor.getColumnIndex("host_key"));
                    if (aVar == a.MODE_KEYS) {
                        boolean z3;
                        for (Object equals : split) {
                            if (string.equals(equals)) {
                                z3 = true;
                                break;
                            }
                        }
                        z3 = false;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cursor.getString(cursor.getColumnIndex("value")));
                    stringBuilder.append(";").append(cursor.getString(cursor.getColumnIndex("name")));
                    stringBuilder.append(";").append(cursor.getInt(cursor.getColumnIndex("expires_utc")));
                    stringBuilder.append(";").append(cursor.getInt(cursor.getColumnIndex(DownloadInfo.PRIORITY)));
                    hashMap.put(string, stringBuilder.toString());
                } while (cursor.moveToNext());
                if (cursor != null) {
                }
                c.close();
                if (hashMap.isEmpty()) {
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (c != null && c.isOpen()) {
                    c.close();
                }
                AppMethodBeat.o(64148);
            }
        }
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(64143);
        if (context == null) {
            AppMethodBeat.o(64143);
            return false;
        }
        k.a(a(context), false);
        AppMethodBeat.o(64143);
        return true;
    }

    public static SQLiteDatabase c(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        AppMethodBeat.i(64144);
        if (context == null) {
            AppMethodBeat.o(64144);
        } else {
            File a = a(context);
            if (a == null) {
                AppMethodBeat.o(64144);
            } else {
                try {
                    sQLiteDatabase = SQLiteDatabase.openDatabase(a.getAbsolutePath(), null, 0);
                } catch (Exception e) {
                }
                if (sQLiteDatabase == null) {
                    TbsLog.i(a, "dbPath is not exist!");
                }
                AppMethodBeat.o(64144);
            }
        }
        return sQLiteDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int d(Context context) {
        SQLiteDatabase c;
        Cursor rawQuery;
        Throwable th;
        int i = 0;
        AppMethodBeat.i(64147);
        System.currentTimeMillis();
        try {
            c = c(context);
            if (c == null) {
                if (c != null && c.isOpen()) {
                    c.close();
                }
                AppMethodBeat.o(64147);
                return -1;
            }
            try {
                rawQuery = c.rawQuery("select * from meta", null);
                try {
                    int count = rawQuery.getCount();
                    rawQuery.getColumnCount();
                    if (count > 0 && rawQuery.moveToFirst()) {
                        while (!rawQuery.getString(0).equals("version")) {
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                        }
                        i = Integer.parseInt(rawQuery.getString(1));
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (c != null && c.isOpen()) {
                        c.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                    }
                    c.close();
                    AppMethodBeat.o(64147);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (c != null && c.isOpen()) {
                    c.close();
                }
                AppMethodBeat.o(64147);
                throw th;
            }
            AppMethodBeat.o(64147);
            return i;
        } catch (Throwable th4) {
            th = th4;
            rawQuery = null;
            c = null;
            if (rawQuery != null) {
            }
            c.close();
            AppMethodBeat.o(64147);
            throw th;
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        if (c != null && c.isOpen()) {
            c.close();
        }
        AppMethodBeat.o(64147);
        return i;
    }
}
