package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.p */
public final class C44539p {
    /* renamed from: a */
    public long f17495a;
    /* renamed from: b */
    public byte[] f17496b;
    /* renamed from: c */
    private int f17497c;
    /* renamed from: d */
    private int f17498d;
    /* renamed from: e */
    private long f17499e;
    /* renamed from: f */
    private long f17500f;

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
    /* renamed from: a */
    public static synchronized List m80851a(Context context) {
        List list;
        List list2 = null;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100523);
            C16205ag.m24685b(" AnalyticsDAO.queryReqData() start", new Object[0]);
            if (context == null) {
                C16205ag.m24687d(" AnalyticsDAO.queryReqData() context null ", new Object[0]);
                AppMethodBeat.m2505o(100523);
                list = null;
            } else {
                Cursor query;
                try {
                    query = C31082r.m50139a(context).getWritableDatabase().query("t_req_data", null, null, null, null, null, "_time DESC ", "1");
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
                            C16205ag.m24683a("queryReqData: 1", new Object[0]);
                        }
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        C16205ag.m24685b(" AnalyticsDAO.queryReqData() end", new Object[0]);
                        list = list2;
                    } catch (Exception e) {
                        list = null;
                        if (query != null) {
                        }
                        C16205ag.m24685b(" AnalyticsDAO.queryReqData() end", new Object[0]);
                        AppMethodBeat.m2505o(100523);
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
                    C16205ag.m24685b(" AnalyticsDAO.queryReqData() end", new Object[0]);
                    AppMethodBeat.m2505o(100523);
                    throw th3;
                }
                AppMethodBeat.m2505o(100523);
            }
        }
        return list;
    }

    public C44539p() {
        this.f17495a = -1;
        this.f17497c = -1;
        this.f17498d = -1;
        this.f17499e = -1;
        this.f17496b = null;
        this.f17500f = 0;
    }

    public C44539p(long j, byte[] bArr) {
        AppMethodBeat.m2504i(100522);
        this.f17495a = -1;
        this.f17497c = -1;
        this.f17498d = -1;
        this.f17499e = -1;
        this.f17496b = null;
        this.f17500f = 0;
        this.f17497c = 1;
        this.f17498d = 3;
        this.f17499e = j;
        this.f17496b = bArr;
        if (bArr != null) {
            this.f17500f = (long) bArr.length;
        }
        AppMethodBeat.m2505o(100522);
    }

    /* renamed from: a */
    public static synchronized boolean m80856a(Context context, byte[] bArr, String str, int i) {
        boolean z = false;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100524);
            C16205ag.m24685b(" AnalyticsDAO.insertReqData() start", new Object[0]);
            if (context == null || bArr == null || str == null) {
                C16205ag.m24687d(" AnalyticsDAO.insertReqData() have null args", new Object[0]);
                AppMethodBeat.m2505o(100524);
            } else {
                try {
                    SQLiteDatabase writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_rid", str);
                    contentValues.put("_time", Long.valueOf(new Date().getTime()));
                    contentValues.put("_cnt", Integer.valueOf(i));
                    contentValues.put("_datas", bArr);
                    if (writableDatabase.insert("t_req_data", null, contentValues) < 0) {
                        C16205ag.m24687d(" AnalyticsDAO.insertReqData() failure! return", new Object[0]);
                    } else {
                        z = true;
                    }
                    C16205ag.m24685b(" AnalyticsDAO.insertReqData() end", new Object[0]);
                } catch (Throwable th) {
                    C16205ag.m24685b(" AnalyticsDAO.insertReqData() end", new Object[0]);
                    AppMethodBeat.m2505o(100524);
                }
                AppMethodBeat.m2505o(100524);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized boolean m80854a(Context context, String str) {
        boolean z = false;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100525);
            C16205ag.m24685b(" AnalyticsDAO.deleteReqData() start", new Object[0]);
            if (context == null) {
                C16205ag.m24683a(" delete() context is null arg", new Object[0]);
                AppMethodBeat.m2505o(100525);
            } else {
                if (str != null) {
                    if (!str.trim().equals("")) {
                        String str2 = "_rid = '" + str + "' ";
                        C16205ag.m24685b(" delete where: ".concat(String.valueOf(str2)), new Object[0]);
                        try {
                            int delete = C31082r.m50139a(context).getWritableDatabase().delete("t_req_data", str2, null);
                            C16205ag.m24685b(" deleted num: ".concat(String.valueOf(delete)), new Object[0]);
                            if (delete == 1) {
                                z = true;
                            }
                            C16205ag.m24685b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
                        } catch (Throwable th) {
                            C16205ag.m24685b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
                            AppMethodBeat.m2505o(100525);
                        }
                        AppMethodBeat.m2505o(100525);
                    }
                }
                AppMethodBeat.m2505o(100525);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized boolean m80855a(Context context, List<C44539p> list) {
        boolean z;
        Throwable th;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100526);
            C16205ag.m24685b(" AnalyticsDAO.insert() start", new Object[0]);
            if (context == null || list == null) {
                C16205ag.m24687d(" AnalyticsDAO.insert() have null args", new Object[0]);
                AppMethodBeat.m2505o(100526);
                z = false;
            } else if (list.size() <= 0) {
                C16205ag.m24685b(" list size == 0 return true", new Object[0]);
                AppMethodBeat.m2505o(100526);
                z = true;
            } else {
                SQLiteDatabase sQLiteDatabase = null;
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        for (int i = 0; i < list.size(); i++) {
                            C44539p c44539p = (C44539p) list.get(i);
                            ContentValues contentValues = new ContentValues();
                            if (c44539p.f17495a > 0) {
                                contentValues.put("_id", Long.valueOf(c44539p.f17495a));
                            }
                            contentValues.put("_prority", Integer.valueOf(c44539p.f17498d));
                            contentValues.put("_time", Long.valueOf(c44539p.f17499e));
                            contentValues.put("_type", Integer.valueOf(c44539p.f17497c));
                            contentValues.put("_datas", c44539p.f17496b);
                            contentValues.put("_length", Long.valueOf(c44539p.f17500f));
                            long insert = writableDatabase.insert("t_event", "_id", contentValues);
                            if (insert < 0) {
                                C16205ag.m24687d(" AnalyticsDAO.insert() failure! return", new Object[0]);
                            }
                            c44539p.f17495a = insert;
                        }
                        writableDatabase.setTransactionSuccessful();
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception e) {
                            C16205ag.m24685b("AnalyticsDao db.endTransaction() error.", new Object[0]);
                        }
                        C16205ag.m24685b(" AnalyticsDAO.insert() end", new Object[0]);
                        z = true;
                    } catch (Throwable th2) {
                        th = th2;
                        writableDatabase.endTransaction();
                        C16205ag.m24685b(" AnalyticsDAO.insert() end", new Object[0]);
                        AppMethodBeat.m2505o(100526);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writableDatabase = null;
                    writableDatabase.endTransaction();
                    C16205ag.m24685b(" AnalyticsDAO.insert() end", new Object[0]);
                    AppMethodBeat.m2505o(100526);
                    throw th;
                }
                AppMethodBeat.m2505o(100526);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized int m80849a(Context context, int[] iArr) {
        int i = -1;
        int i2 = 0;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100527);
            C16205ag.m24685b(" AnalyticsDAO.delete() start", new Object[0]);
            if (context == null) {
                C16205ag.m24683a(" delete() context is null arg", new Object[0]);
                AppMethodBeat.m2505o(100527);
            } else if (-1 > Long.MAX_VALUE) {
                AppMethodBeat.m2505o(100527);
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
                C16205ag.m24685b(" delete where: ".concat(String.valueOf(obj2)), new Object[0]);
                try {
                    i2 = C31082r.m50139a(context).getWritableDatabase().delete("t_event", obj2, null);
                    C16205ag.m24685b(" deleted num: ".concat(String.valueOf(i2)), new Object[0]);
                    C16205ag.m24685b(" AnalyticsDAO.delete() end", new Object[0]);
                    i = i2;
                } catch (Throwable th) {
                    C16205ag.m24685b(" AnalyticsDAO.delete() end", new Object[0]);
                    AppMethodBeat.m2505o(100527);
                }
                AppMethodBeat.m2505o(100527);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static synchronized int m80850a(Context context, Long[] lArr) {
        int i;
        Throwable th;
        int i2;
        int i3 = 0;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100528);
            C16205ag.m24685b(" AnalyticsDAO.deleteList() start!", new Object[0]);
            if (context == null) {
                C16205ag.m24687d(" deleteList() have null args!", new Object[0]);
                i = -1;
                AppMethodBeat.m2505o(100528);
            } else {
                if (lArr != null) {
                    if (lArr.length > 0) {
                        try {
                            SQLiteDatabase writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                            StringBuffer stringBuffer = new StringBuffer();
                            int i4 = 0;
                            i = 0;
                            while (i4 < lArr.length) {
                                try {
                                    stringBuffer.append(" or  _id = ".concat(String.valueOf(lArr[i4].longValue())));
                                    if (i4 > 0 && i4 % 25 == 0) {
                                        C16205ag.m24685b(" current ".concat(String.valueOf(i4)), new Object[0]);
                                        i += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                                        stringBuffer.setLength(0);
                                        C16205ag.m24685b(" current deleteNum: ".concat(String.valueOf(i)), new Object[0]);
                                    }
                                    i4++;
                                } catch (Throwable th2) {
                                    th = th2;
                                    i2 = i;
                                    try {
                                        C16205ag.m24687d(th.getMessage(), new Object[0]);
                                        C16205ag.m24685b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                                        i = i2;
                                        AppMethodBeat.m2505o(100528);
                                        return i;
                                    } catch (Throwable th3) {
                                        C16205ag.m24685b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                                        AppMethodBeat.m2505o(100528);
                                    }
                                }
                            }
                            if (stringBuffer.length() > 0) {
                                i3 = writableDatabase.delete("t_event", stringBuffer.substring(4), null) + i;
                                stringBuffer.setLength(0);
                            } else {
                                i3 = i;
                            }
                            C16205ag.m24683a(" total deleteNum: ".concat(String.valueOf(i3)), new Object[0]);
                            C16205ag.m24685b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                            i = i3;
                        } catch (Throwable th4) {
                            th = th4;
                            i2 = i3;
                            C16205ag.m24687d(th.getMessage(), new Object[0]);
                            C16205ag.m24685b(" AnalyticsDAO.deleteList() end!", new Object[0]);
                            i = i2;
                            AppMethodBeat.m2505o(100528);
                            return i;
                        }
                        AppMethodBeat.m2505o(100528);
                    }
                }
                AppMethodBeat.m2505o(100528);
                i = 0;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static synchronized List<C44539p> m80852a(Context context, int[] iArr, int i) {
        List b;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100529);
            b = C44539p.m80858b(context, iArr, i);
            AppMethodBeat.m2505o(100529);
        }
        return b;
    }

    /* renamed from: a */
    private static List<C44539p> m80853a(Cursor cursor) {
        AppMethodBeat.m2504i(100530);
        C16205ag.m24685b(" in AnalyticsDAO.paserCursor() start", new Object[0]);
        if (cursor == null) {
            AppMethodBeat.m2505o(100530);
            return null;
        }
        List<C44539p> arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_prority");
        int columnIndex3 = cursor.getColumnIndex("_time");
        int columnIndex4 = cursor.getColumnIndex("_type");
        int columnIndex5 = cursor.getColumnIndex("_datas");
        int columnIndex6 = cursor.getColumnIndex("_length");
        while (cursor.moveToNext()) {
            C44539p c44539p = new C44539p();
            c44539p.f17495a = cursor.getLong(columnIndex);
            c44539p.f17496b = cursor.getBlob(columnIndex5);
            c44539p.f17498d = cursor.getInt(columnIndex2);
            c44539p.f17499e = cursor.getLong(columnIndex3);
            c44539p.f17497c = cursor.getInt(columnIndex4);
            c44539p.f17500f = cursor.getLong(columnIndex6);
            arrayList.add(c44539p);
        }
        C16205ag.m24685b(" in AnalyticsDAO.paserCursor() end", new Object[0]);
        AppMethodBeat.m2505o(100530);
        return arrayList;
    }

    /* renamed from: b */
    public static synchronized int m80857b(Context context, int[] iArr) {
        Throwable th;
        int i = 0;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100531);
            C16205ag.m24685b(" AnalyticsDAO.querySum() start", new Object[0]);
            if (context == null) {
                C16205ag.m24683a(" querySum() context is null arg", new Object[0]);
                AppMethodBeat.m2505o(100531);
                i = -1;
            } else if (-1 > Long.MAX_VALUE) {
                AppMethodBeat.m2505o(100531);
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
                C16205ag.m24685b(" query where: ".concat(String.valueOf(obj)), new Object[0]);
                Cursor query;
                try {
                    query = C31082r.m50139a(context).getWritableDatabase().query("t_event", new String[]{"count(*) as sum"}, obj, null, null, null, null);
                    try {
                        query.moveToNext();
                        i = query.getInt(query.getColumnIndex("sum"));
                        C16205ag.m24685b(" query sum: ".concat(String.valueOf(i)), new Object[0]);
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        C16205ag.m24685b(" AnalyticsDAO.querySum() end", new Object[0]);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            C16205ag.m24685b(th.getMessage(), new Object[0]);
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            C16205ag.m24685b(" AnalyticsDAO.querySum() end", new Object[0]);
                            i = -1;
                            AppMethodBeat.m2505o(100531);
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            if (!(query == null || query.isClosed())) {
                                query.close();
                            }
                            C16205ag.m24685b(" AnalyticsDAO.querySum() end", new Object[0]);
                            AppMethodBeat.m2505o(100531);
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    query = null;
                    query.close();
                    C16205ag.m24685b(" AnalyticsDAO.querySum() end", new Object[0]);
                    AppMethodBeat.m2505o(100531);
                    throw th;
                }
                AppMethodBeat.m2505o(100531);
            }
        }
        return i;
    }

    /* renamed from: b */
    private static synchronized List<C44539p> m80858b(Context context, int[] iArr, int i) {
        List c;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100532);
            c = C44539p.m80859c(context, iArr, i);
            AppMethodBeat.m2505o(100532);
        }
        return c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c0 A:{SYNTHETIC, Splitter:B:75:0x01c0} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c0 A:{SYNTHETIC, Splitter:B:75:0x01c0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private static synchronized List<C44539p> m80859c(Context context, int[] iArr, int i) {
        List<C44539p> list;
        Throwable th;
        List<C44539p> list2;
        List<C44539p> list3 = null;
        synchronized (C44539p.class) {
            AppMethodBeat.m2504i(100533);
            C16205ag.m24685b(" in AnalyticsDAO.query() start", new Object[0]);
            if (context == null || (-1 > 0 && -1 > -1)) {
                C16205ag.m24687d(" query() args context == null || timeStart > timeEnd || miniCount > maxCount || miniUploadCount > maxUploadCount ,pls check", new Object[0]);
                AppMethodBeat.m2505o(100533);
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
                C16205ag.m24685b(" query:%s", str3);
                Cursor query;
                try {
                    query = C31082r.m50139a(context).getWritableDatabase().query("t_event", null, str3, null, null, null, str4, i >= 0 ? String.valueOf(i) : null);
                    try {
                        C16205ag.m24683a("result num: " + query.getCount(), new Object[0]);
                        if (query.getCount() > 0) {
                            list3 = C44539p.m80853a(query);
                        }
                        if (list3 != null) {
                            try {
                                C16205ag.m24683a(" total num: " + list3.size(), new Object[0]);
                            } catch (Throwable th2) {
                                th = th2;
                                list2 = list3;
                                try {
                                    C16205ag.m24685b(th.getMessage(), new Object[0]);
                                    if (query != null) {
                                    }
                                    C16205ag.m24685b(" in AnalyticsDAO.query() end", new Object[0]);
                                    list = list2;
                                    AppMethodBeat.m2505o(100533);
                                    return list;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    C16205ag.m24685b(" in AnalyticsDAO.query() end", new Object[0]);
                                    AppMethodBeat.m2505o(100533);
                                    throw th;
                                }
                            }
                        }
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        C16205ag.m24685b(" in AnalyticsDAO.query() end", new Object[0]);
                        list = list3;
                    } catch (Throwable th4) {
                        th = th4;
                        list2 = null;
                        C16205ag.m24685b(th.getMessage(), new Object[0]);
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                        C16205ag.m24685b(" in AnalyticsDAO.query() end", new Object[0]);
                        list = list2;
                        AppMethodBeat.m2505o(100533);
                        return list;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    query = null;
                    query.close();
                    C16205ag.m24685b(" in AnalyticsDAO.query() end", new Object[0]);
                    AppMethodBeat.m2505o(100533);
                    throw th;
                }
                AppMethodBeat.m2505o(100533);
            }
        }
        return list;
    }
}
