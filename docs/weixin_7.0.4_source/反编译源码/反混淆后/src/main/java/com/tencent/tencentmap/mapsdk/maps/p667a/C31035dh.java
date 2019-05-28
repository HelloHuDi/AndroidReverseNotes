package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dh */
public final class C31035dh extends SQLiteOpenHelper {
    /* renamed from: a */
    private static Map<String, C31035dh> f14102a = new ConcurrentHashMap();
    /* renamed from: b */
    private static final Object f14103b = new Object();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dh$a */
    public static final class C31036a {
        /* renamed from: a */
        public long f14104a;
        /* renamed from: b */
        public String f14105b;

        public C31036a(long j, String str) {
            this.f14104a = j;
            this.f14105b = str;
        }

        public C31036a(long j, String str, String str2) {
            this(j, str);
        }
    }

    static {
        AppMethodBeat.m2504i(98716);
        AppMethodBeat.m2505o(98716);
    }

    private C31035dh(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private int m49870a(boolean z, boolean z2) {
        int count;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        AppMethodBeat.m2504i(98713);
        try {
            Cursor query;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (z && z2) {
                query = writableDatabase.query("halley_action_tbl", new String[]{"key"}, null, null, null, null, null);
            } else if (z) {
                query = writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"add"}, null, null, null);
            } else {
                query = writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"remove"}, null, null, null);
            }
            if (query != null) {
                try {
                    count = query.getCount();
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    AppMethodBeat.m2505o(98713);
                    throw th;
                }
            }
            count = 0;
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            AppMethodBeat.m2505o(98713);
            throw th;
        }
        AppMethodBeat.m2505o(98713);
        return count;
    }

    /* renamed from: a */
    public static C31035dh m49871a(String str) {
        C31035dh c31035dh;
        AppMethodBeat.m2504i(98706);
        synchronized (f14103b) {
            try {
                c31035dh = (C31035dh) f14102a.get(str);
                if (c31035dh == null) {
                    c31035dh = new C31035dh(C46772bt.m88735a(), "HalleyAction_" + C46772bt.m88739c() + (C46772bt.m88738b() ? "_test_" : "_") + C46772bt.m88745i() + "_" + str + ".db", null, 2);
                    f14102a.put(str, c31035dh);
                }
            } finally {
                AppMethodBeat.m2505o(98706);
            }
        }
        return c31035dh;
    }

    /* renamed from: b */
    public final long mo50360b(String str) {
        long j = -1;
        AppMethodBeat.m2504i(98711);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98711);
        } else {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("data", str);
                contentValues.put("state", "add");
                j = writableDatabase.insert("halley_action_tbl", null, contentValues);
            } catch (Exception e) {
            } finally {
                AppMethodBeat.m2505o(98711);
            }
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final List<C31036a> mo50361b(int i) {
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.m2504i(98714);
        ArrayList arrayList = new ArrayList();
        Cursor query;
        try {
            query = getWritableDatabase().query("halley_action_tbl", null, "state=?", new String[]{"add"}, null, null, null);
            if (query != null) {
                try {
                    int min = Math.min(query.getCount(), i);
                    if (query.moveToFirst()) {
                        int i2 = 0;
                        do {
                            arrayList.add(new C31036a(query.getLong(query.getColumnIndex("key")), query.getString(query.getColumnIndex("data")), query.getString(query.getColumnIndex("state"))));
                            i2++;
                            if (i2 >= min) {
                                break;
                            }
                        } while (query.moveToNext());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.m2505o(98714);
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(98714);
            throw th;
        }
        AppMethodBeat.m2505o(98714);
        return arrayList;
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(98708);
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            if (version != 0) {
                if (version < 2) {
                    onUpgrade(sQLiteDatabase, version, 2);
                    AppMethodBeat.m2505o(98708);
                    return;
                } else if (version > 2) {
                    onDowngrade(sQLiteDatabase, version, 2);
                }
            }
            AppMethodBeat.m2505o(98708);
        } catch (Exception e) {
            AppMethodBeat.m2505o(98708);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(98707);
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.m2505o(98707);
        } catch (SQLException e) {
            AppMethodBeat.m2505o(98707);
            throw e;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.m2504i(98709);
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.m2505o(98709);
        } catch (SQLException e2) {
            AppMethodBeat.m2505o(98709);
            throw e2;
        } catch (Exception e3) {
            AppMethodBeat.m2505o(98709);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.m2504i(98710);
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.m2505o(98710);
        } catch (SQLException e2) {
            AppMethodBeat.m2505o(98710);
            throw e2;
        } catch (Exception e3) {
            AppMethodBeat.m2505o(98710);
        }
    }

    /* renamed from: a */
    public final boolean mo50359a(int i) {
        AppMethodBeat.m2504i(98712);
        if (m49870a(true, true) > i) {
            try {
                getWritableDatabase().delete("halley_action_tbl", null, null);
                AppMethodBeat.m2505o(98712);
                return true;
            } catch (SQLException e) {
                AppMethodBeat.m2505o(98712);
                throw e;
            } catch (Exception e2) {
                if (m49870a(true, true) > i) {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
                    } catch (SQLException e3) {
                    }
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
                }
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.m2505o(98712);
        return false;
    }

    /* renamed from: a */
    public final void mo50358a(List<Long> list) {
        AppMethodBeat.m2504i(98715);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(98715);
            return;
        }
        try {
            long longValue;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "remove");
            for (Long longValue2 : list) {
                longValue = longValue2.longValue();
                writableDatabase.update("halley_action_tbl", contentValues, "key=?", new String[]{String.valueOf(longValue)});
            }
            for (Long longValue22 : list) {
                longValue = longValue22.longValue();
                writableDatabase.delete("halley_action_tbl", "key=?", new String[]{String.valueOf(longValue)});
            }
            if (m49870a(false, true) <= 0 || m49870a(true, false) > 0) {
                AppMethodBeat.m2505o(98715);
                return;
            }
            try {
                writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (SQLException e) {
            }
            writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.m2505o(98715);
        } catch (SQLException e2) {
            AppMethodBeat.m2505o(98715);
            throw e2;
        } catch (Exception e3) {
            AppMethodBeat.m2505o(98715);
        }
    }
}
