package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class p {
    public long a;
    public byte[] b;
    private int c;
    private int d;
    private long e;
    private long f;

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A:{SYNTHETIC, Splitter:B:35:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ff A:{Splitter:B:12:0x0041, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A:{SYNTHETIC, Splitter:B:35:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ff A:{Splitter:B:12:0x0041, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:37:0x00d3, code skipped:
            if (r1.isClosed() == false) goto L_0x00d5;
     */
    /* JADX WARNING: Missing block: B:38:0x00d5, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:48:0x00ff, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:53:0x0107, code skipped:
            r0 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized List a(Context context) {
        List list;
        List list2 = null;
        synchronized (p.class) {
            AppMethodBeat.i(100523);
            ag.b(" AnalyticsDAO.queryReqData() start", new Object[0]);
            if (context == null) {
                ag.d(" AnalyticsDAO.queryReqData() context null ", new Object[0]);
                AppMethodBeat.o(100523);
                list = null;
            } else {
                Cursor query;
                try {
                    query = r.a(context).getWritableDatabase().query("t_req_data", null, null, null, null, null, "_time DESC ", "1");
                    try {
                        if (query.moveToNext()) {
                            list = new ArrayList();
                            list.add(Integer.valueOf(query.getInt(query.getColumnIndex("_id"))));
                            list.add(query.getString(query.getColumnIndex("_rid")));
                            list.add(Long.valueOf(query.getLong(query.getColumnIndex("_time"))));
                            list.add(query.getBlob(query.getColumnIndex("_datas")));
                            list.add(Integer.valueOf(query.getInt(query.getColumnIndex("_cnt"))));
                            list2 = list;
                        }
                        if (list2 != null) {
                            ag.a("queryReqData: 1", new Object[0]);
                        }
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        ag.b(" AnalyticsDAO.queryReqData() end", new Object[0]);
                        list = list2;
                    } catch (Exception e) {
                        list = null;
                        if (query != null) {
                        }
                        ag.b(" AnalyticsDAO.queryReqData() end", new Object[0]);
                        AppMethodBeat.o(100523);
                        return list;
                    } catch (Throwable th) {
                    }
                } catch (Exception e2) {
                    list = null;
                    query = null;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    query = null;
                    query.close();
                    ag.b(" AnalyticsDAO.queryReqData() end", new Object[0]);
                    AppMethodBeat.o(100523);
                    throw th3;
                }
                AppMethodBeat.o(100523);
            }
        }
        return list;
    }

    public p() {
        this.a = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.b = null;
        this.f = 0;
    }

    public p(long j, byte[] bArr) {
        AppMethodBeat.i(100522);
        this.a = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.b = null;
        this.f = 0;
        this.c = 1;
        this.d = 3;
        this.e = j;
        this.b = bArr;
        if (bArr != null) {
            this.f = (long) bArr.length;
        }
        AppMethodBeat.o(100522);
    }

    public static synchronized boolean a(Context context, byte[] bArr, String str, int i) {
        boolean z = false;
        synchronized (p.class) {
            AppMethodBeat.i(100524);
            ag.b(" AnalyticsDAO.insertReqData() start", new Object[0]);
            if (context == null || bArr == null || str == null) {
                ag.d(" AnalyticsDAO.insertReqData() have null args", new Object[0]);
                AppMethodBeat.o(100524);
            } else {
                try {
                    SQLiteDatabase writableDatabase = r.a(context).getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_rid", str);
                    contentValues.put("_time", Long.valueOf(new Date().getTime()));
                    contentValues.put("_cnt", Integer.valueOf(i));
                    contentValues.put("_datas", bArr);
                    if (writableDatabase.insert("t_req_data", null, contentValues) < 0) {
                        ag.d(" AnalyticsDAO.insertReqData() failure! return", new Object[0]);
                    } else {
                        z = true;
                    }
                    ag.b(" AnalyticsDAO.insertReqData() end", new Object[0]);
                } catch (Throwable th) {
                    ag.b(" AnalyticsDAO.insertReqData() end", new Object[0]);
                    AppMethodBeat.o(100524);
                }
                AppMethodBeat.o(100524);
            }
        }
        return z;
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z = false;
        synchronized (p.class) {
            AppMethodBeat.i(100525);
            ag.b(" AnalyticsDAO.deleteReqData() start", new Object[0]);
            if (context == null) {
                ag.a(" delete() context is null arg", new Object[0]);
                AppMethodBeat.o(100525);
            } else {
                if (str != null) {
                    if (!str.trim().equals("")) {
                        String str2 = "_rid = '" + str + "' ";
                        ag.b(" delete where: ".concat(String.valueOf(str2)), new Object[0]);
                        try {
                            int delete = r.a(context).getWritableDatabase().delete("t_req_data", str2, null);
                            ag.b(" deleted num: ".concat(String.valueOf(delete)), new Object[0]);
                            if (delete == 1) {
                                z = true;
                            }
                            ag.b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
                        } catch (Throwable th) {
                            ag.b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
                            AppMethodBeat.o(100525);
                        }
                        AppMethodBeat.o(100525);
                    }
                }
                AppMethodBeat.o(100525);
            }
        }
        return z;
    }

    public static synchronized boolean a(Context context, List<p> list) {
        boolean z;
        Throwable th;
        synchronized (p.class) {
            AppMethodBeat.i(100526);
            ag.b(" AnalyticsDAO.insert() start", new Object[0]);
            if (context == null || list == null) {
                ag.d(" AnalyticsDAO.insert() have null args", new Object[0]);
                AppMethodBeat.o(100526);
                z = false;
            } else if (list.size() <= 0) {
                ag.b(" list size == 0 return true", new Object[0]);
                AppMethodBeat.o(100526);
                z = true;
            } else {
                SQLiteDatabase sQLiteDatabase = null;
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = r.a(context).getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        for (int i = 0; i < list.size(); i++) {
                            p pVar = (p) list.get(i);
                            ContentValues contentValues = new ContentValues();
                            if (pVar.a > 0) {
                                contentValues.put("_id", Long.valueOf(pVar.a));
                            }
                            contentValues.put("_prority", Integer.valueOf(pVar.d));
                            contentValues.put("_time", Long.valueOf(pVar.e));
                            contentValues.put("_type", Integer.valueOf(pVar.c));
                            contentValues.put("_datas", pVar.b);
                            contentValues.put("_length", Long.valueOf(pVar.f));
                            long insert = writableDatabase.insert("t_event", "_id", contentValues);
                            if (insert < 0) {
                                ag.d(" AnalyticsDAO.insert() failure! return", new Object[0]);
                            }
                            pVar.a = insert;
                        }
                        writableDatabase.setTransactionSuccessful();
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception e) {
                            ag.b("AnalyticsDao db.endTransaction() error.", new Object[0]);
                        }
                        ag.b(" AnalyticsDAO.insert() end", new Object[0]);
                        z = true;
                    } catch (Throwable th2) {
                        th = th2;
                        writableDatabase.endTransaction();
                        ag.b(" AnalyticsDAO.insert() end", new Object[0]);
                        AppMethodBeat.o(100526);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writableDatabase = null;
                    writableDatabase.endTransaction();
                    ag.b(" AnalyticsDAO.insert() end", new Object[0]);
                    AppMethodBeat.o(100526);
                    throw th;
                }
                AppMethodBeat.o(100526);
            }
        }
        return z;
    }

    public static synchronized int a(Context context, int[] iArr) {
        int i = -1;
        int i2 = 0;
        synchronized (p.class) {
            AppMethodBeat.i(100527);
            ag.b(" AnalyticsDAO.delete() start", new Object[0]);
            if (context == null) {
                ag.a(" delete() context is null arg", new Object[0]);
                AppMethodBeat.o(100527);
            } else if (-1 > Long.MAX_VALUE) {
                AppMethodBeat.o(100527);
                i = 0;
            } else {
                Object obj;
                String str = "_time >= -1 and _time <= 9223372036854775807";
                if (iArr == null || iArr.length <= 0) {
                    String obj2 = str;
                } else {
                    String str2 = "";
                    while (i2 < iArr.length) {
                        str2 = str2 + " or _type = " + iArr[i2];
                        i2++;
                    }
                    obj2 = str + " and ( " + str2.substring(4) + " )";
                }
                ag.b(" delete where: ".concat(String.valueOf(obj2)), new Object[0]);
                try {
                    i2 = r.a(context).getWritableDatabase().delete("t_event", obj2, null);
                    ag.b(" deleted num: ".concat(String.valueOf(i2)), new Object[0]);
                    ag.b(" AnalyticsDAO.delete() end", new Object[0]);
                    i = i2;
                } catch (Throwable th) {
                    ag.b(" AnalyticsDAO.delete() end", new Object[0]);
                    AppMethodBeat.o(100527);
                }
                AppMethodBeat.o(100527);
            }
        }
        return i;
    }

    public static synchronized int a(Context context, Long[] lArr) {
        int i;
        Throwable th;
        int i2;
        int i3 = 0;
        synchronized (p.class) {
            AppMethodBeat.i(100528);
            ag.b(" AnalyticsDAO.deleteList() start!", new Object[0]);
            if (context == null) {
                ag.d(" deleteList() have null args!", new Object[0]);
                i = -1;
                AppMethodBeat.o(100528);
            } else {
                if (lArr != null) {
                    if (lArr.length > 0) {
                        try {
                            SQLiteDatabase writableDatabase = r.a(context).getWritableDatabase();
                            StringBuffer stringBuffer = new StringBuffer();
                            int i4 = 0;
                            i = 0;
                            while (i4 < lArr.length) {
                                try {
                                    stringBuffer.append(" or  _id = ".concat(String.valueOf(lArr[i4].longValue())));
                                    if (i4 > 0 && i4 % 25 == 0) {
                                        ag.b(" current ".concat(String.valueOf(i4)), new Object[0]);
                                        i += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                                        stringBuffer.setLength(0);
                                        ag.b(" current deleteNum: ".concat(String.valueOf(i)), new Object[0]);
                                    }
                                    i4++;
                                } catch (Throwable th2) {
                                    th = th2;
                                    i2 = i;
                                    try {
                                        ag.d(th.getMessage(), new Object[0]);
                                        ag.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                                        i = i2;
                                        AppMethodBeat.o(100528);
                                        return i;
                                    } catch (Throwable th3) {
                                        ag.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                                        AppMethodBeat.o(100528);
                                    }
                                }
                            }
                            if (stringBuffer.length() > 0) {
                                i3 = writableDatabase.delete("t_event", stringBuffer.substring(4), null) + i;
                                stringBuffer.setLength(0);
                            } else {
                                i3 = i;
                            }
                            ag.a(" total deleteNum: ".concat(String.valueOf(i3)), new Object[0]);
                            ag.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                            i = i3;
                        } catch (Throwable th4) {
                            th = th4;
                            i2 = i3;
                            ag.d(th.getMessage(), new Object[0]);
                            ag.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                            i = i2;
                            AppMethodBeat.o(100528);
                            return i;
                        }
                        AppMethodBeat.o(100528);
                    }
                }
                AppMethodBeat.o(100528);
                i = 0;
            }
        }
        return i;
    }

    public static synchronized List<p> a(Context context, int[] iArr, int i) {
        List b;
        synchronized (p.class) {
            AppMethodBeat.i(100529);
            b = b(context, iArr, i);
            AppMethodBeat.o(100529);
        }
        return b;
    }

    private static List<p> a(Cursor cursor) {
        AppMethodBeat.i(100530);
        ag.b(" in AnalyticsDAO.paserCursor() start", new Object[0]);
        if (cursor == null) {
            AppMethodBeat.o(100530);
            return null;
        }
        List<p> arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_prority");
        int columnIndex3 = cursor.getColumnIndex("_time");
        int columnIndex4 = cursor.getColumnIndex("_type");
        int columnIndex5 = cursor.getColumnIndex("_datas");
        int columnIndex6 = cursor.getColumnIndex("_length");
        while (cursor.moveToNext()) {
            p pVar = new p();
            pVar.a = cursor.getLong(columnIndex);
            pVar.b = cursor.getBlob(columnIndex5);
            pVar.d = cursor.getInt(columnIndex2);
            pVar.e = cursor.getLong(columnIndex3);
            pVar.c = cursor.getInt(columnIndex4);
            pVar.f = cursor.getLong(columnIndex6);
            arrayList.add(pVar);
        }
        ag.b(" in AnalyticsDAO.paserCursor() end", new Object[0]);
        AppMethodBeat.o(100530);
        return arrayList;
    }

    public static synchronized int b(Context context, int[] iArr) {
        Throwable th;
        int i = 0;
        synchronized (p.class) {
            AppMethodBeat.i(100531);
            ag.b(" AnalyticsDAO.querySum() start", new Object[0]);
            if (context == null) {
                ag.a(" querySum() context is null arg", new Object[0]);
                AppMethodBeat.o(100531);
                i = -1;
            } else if (-1 > Long.MAX_VALUE) {
                AppMethodBeat.o(100531);
            } else {
                Object obj = "_time >= -1 and _time <= 9223372036854775807";
                if (iArr != null && iArr.length > 0) {
                    String str = "";
                    while (i < iArr.length) {
                        str = str + " or _type = " + iArr[i];
                        i++;
                    }
                    obj = obj + " and ( " + str.substring(4) + " )";
                }
                ag.b(" query where: ".concat(String.valueOf(obj)), new Object[0]);
                Cursor query;
                try {
                    query = r.a(context).getWritableDatabase().query("t_event", new String[]{"count(*) as sum"}, obj, null, null, null, null);
                    try {
                        query.moveToNext();
                        i = query.getInt(query.getColumnIndex("sum"));
                        ag.b(" query sum: ".concat(String.valueOf(i)), new Object[0]);
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        ag.b(" AnalyticsDAO.querySum() end", new Object[0]);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ag.b(th.getMessage(), new Object[0]);
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            ag.b(" AnalyticsDAO.querySum() end", new Object[0]);
                            i = -1;
                            AppMethodBeat.o(100531);
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            if (!(query == null || query.isClosed())) {
                                query.close();
                            }
                            ag.b(" AnalyticsDAO.querySum() end", new Object[0]);
                            AppMethodBeat.o(100531);
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    query = null;
                    query.close();
                    ag.b(" AnalyticsDAO.querySum() end", new Object[0]);
                    AppMethodBeat.o(100531);
                    throw th;
                }
                AppMethodBeat.o(100531);
            }
        }
        return i;
    }

    private static synchronized List<p> b(Context context, int[] iArr, int i) {
        List c;
        synchronized (p.class) {
            AppMethodBeat.i(100532);
            c = c(context, iArr, i);
            AppMethodBeat.o(100532);
        }
        return c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c0 A:{SYNTHETIC, Splitter:B:75:0x01c0} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c0 A:{SYNTHETIC, Splitter:B:75:0x01c0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized List<p> c(Context context, int[] iArr, int i) {
        List<p> list;
        Throwable th;
        List<p> list2;
        List<p> list3 = null;
        synchronized (p.class) {
            AppMethodBeat.i(100533);
            ag.b(" in AnalyticsDAO.query() start", new Object[0]);
            if (context == null || (-1 > 0 && -1 > -1)) {
                ag.d(" query() args context == null || timeStart > timeEnd || miniCount > maxCount || miniUploadCount > maxUploadCount ,pls check", new Object[0]);
                AppMethodBeat.o(100533);
                list = null;
            } else {
                String str = "";
                if (iArr != null && iArr.length > 0) {
                    String str2 = "";
                    for (int i2 : iArr) {
                        str2 = str2 + " or _type = " + i2;
                    }
                    str = str + str2.substring(4);
                }
                String str3 = str.length() > 0 ? " ( " + str + " ) " : "";
                if (-1 >= 0) {
                    str3 = str3 + (str3.length() > 0 ? " and " : "") + "_time >= -1 ";
                }
                if (-1 >= 0) {
                    str3 = str3 + (str3.length() > 0 ? " and " : "") + "_time <= -1 ";
                }
                String str4 = ("" + "_prority ASC , ") + "_time DESC ";
                if (str4.endsWith(" , ")) {
                    str4 = str4.substring(0, str4.length() - 3);
                }
                ag.b(" query:%s", str3);
                Cursor query;
                try {
                    query = r.a(context).getWritableDatabase().query("t_event", null, str3, null, null, null, str4, i >= 0 ? String.valueOf(i) : null);
                    try {
                        ag.a("result num: " + query.getCount(), new Object[0]);
                        if (query.getCount() > 0) {
                            list3 = a(query);
                        }
                        if (list3 != null) {
                            try {
                                ag.a(" total num: " + list3.size(), new Object[0]);
                            } catch (Throwable th2) {
                                th = th2;
                                list2 = list3;
                                try {
                                    ag.b(th.getMessage(), new Object[0]);
                                    if (query != null) {
                                    }
                                    ag.b(" in AnalyticsDAO.query() end", new Object[0]);
                                    list = list2;
                                    AppMethodBeat.o(100533);
                                    return list;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    ag.b(" in AnalyticsDAO.query() end", new Object[0]);
                                    AppMethodBeat.o(100533);
                                    throw th;
                                }
                            }
                        }
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        ag.b(" in AnalyticsDAO.query() end", new Object[0]);
                        list = list3;
                    } catch (Throwable th4) {
                        th = th4;
                        list2 = null;
                        ag.b(th.getMessage(), new Object[0]);
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        ag.b(" in AnalyticsDAO.query() end", new Object[0]);
                        list = list2;
                        AppMethodBeat.o(100533);
                        return list;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    query = null;
                    query.close();
                    ag.b(" in AnalyticsDAO.query() end", new Object[0]);
                    AppMethodBeat.o(100533);
                    throw th;
                }
                AppMethodBeat.o(100533);
            }
        }
        return list;
    }
}
