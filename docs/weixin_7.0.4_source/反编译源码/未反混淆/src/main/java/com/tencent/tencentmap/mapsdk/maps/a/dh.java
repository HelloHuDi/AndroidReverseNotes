package com.tencent.tencentmap.mapsdk.maps.a;

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

public final class dh extends SQLiteOpenHelper {
    private static Map<String, dh> a = new ConcurrentHashMap();
    private static final Object b = new Object();

    public static final class a {
        public long a;
        public String b;

        public a(long j, String str) {
            this.a = j;
            this.b = str;
        }

        public a(long j, String str, String str2) {
            this(j, str);
        }
    }

    static {
        AppMethodBeat.i(98716);
        AppMethodBeat.o(98716);
    }

    private dh(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(boolean z, boolean z2) {
        int count;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        AppMethodBeat.i(98713);
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
                    AppMethodBeat.o(98713);
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
            AppMethodBeat.o(98713);
            throw th;
        }
        AppMethodBeat.o(98713);
        return count;
    }

    public static dh a(String str) {
        dh dhVar;
        AppMethodBeat.i(98706);
        synchronized (b) {
            try {
                dhVar = (dh) a.get(str);
                if (dhVar == null) {
                    dhVar = new dh(bt.a(), "HalleyAction_" + bt.c() + (bt.b() ? "_test_" : "_") + bt.i() + "_" + str + ".db", null, 2);
                    a.put(str, dhVar);
                }
            } finally {
                AppMethodBeat.o(98706);
            }
        }
        return dhVar;
    }

    public final long b(String str) {
        long j = -1;
        AppMethodBeat.i(98711);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98711);
        } else {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("data", str);
                contentValues.put("state", "add");
                j = writableDatabase.insert("halley_action_tbl", null, contentValues);
            } catch (Exception e) {
            } finally {
                AppMethodBeat.o(98711);
            }
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<a> b(int i) {
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.i(98714);
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
                            arrayList.add(new a(query.getLong(query.getColumnIndex("key")), query.getString(query.getColumnIndex("data")), query.getString(query.getColumnIndex("state"))));
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
                    AppMethodBeat.o(98714);
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
            AppMethodBeat.o(98714);
            throw th;
        }
        AppMethodBeat.o(98714);
        return arrayList;
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(98708);
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            if (version != 0) {
                if (version < 2) {
                    onUpgrade(sQLiteDatabase, version, 2);
                    AppMethodBeat.o(98708);
                    return;
                } else if (version > 2) {
                    onDowngrade(sQLiteDatabase, version, 2);
                }
            }
            AppMethodBeat.o(98708);
        } catch (Exception e) {
            AppMethodBeat.o(98708);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(98707);
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.o(98707);
        } catch (SQLException e) {
            AppMethodBeat.o(98707);
            throw e;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.i(98709);
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.o(98709);
        } catch (SQLException e2) {
            AppMethodBeat.o(98709);
            throw e2;
        } catch (Exception e3) {
            AppMethodBeat.o(98709);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.i(98710);
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.o(98710);
        } catch (SQLException e2) {
            AppMethodBeat.o(98710);
            throw e2;
        } catch (Exception e3) {
            AppMethodBeat.o(98710);
        }
    }

    public final boolean a(int i) {
        AppMethodBeat.i(98712);
        if (a(true, true) > i) {
            try {
                getWritableDatabase().delete("halley_action_tbl", null, null);
                AppMethodBeat.o(98712);
                return true;
            } catch (SQLException e) {
                AppMethodBeat.o(98712);
                throw e;
            } catch (Exception e2) {
                if (a(true, true) > i) {
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
        AppMethodBeat.o(98712);
        return false;
    }

    public final void a(List<Long> list) {
        AppMethodBeat.i(98715);
        if (list.size() <= 0) {
            AppMethodBeat.o(98715);
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
            if (a(false, true) <= 0 || a(true, false) > 0) {
                AppMethodBeat.o(98715);
                return;
            }
            try {
                writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (SQLException e) {
            }
            writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            AppMethodBeat.o(98715);
        } catch (SQLException e2) {
            AppMethodBeat.o(98715);
            throw e2;
        } catch (Exception e3) {
            AppMethodBeat.o(98715);
        }
    }
}
