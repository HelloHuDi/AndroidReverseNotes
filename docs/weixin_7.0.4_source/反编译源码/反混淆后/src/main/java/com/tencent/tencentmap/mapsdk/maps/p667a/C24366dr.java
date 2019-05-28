package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dr */
public abstract class C24366dr {
    /* renamed from: a */
    private C24367a f4666a;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dr$a */
    class C24367a extends SQLiteOpenHelper {
        public C24367a(Context context, String str, CursorFactory cursorFactory, int i) {
            super(context, str, null, i);
        }

        /* renamed from: a */
        private void m37701a() {
            Throwable th;
            AppMethodBeat.m2504i(98734);
            try {
                ArrayList arrayList = new ArrayList();
                int a = C24362a.m37665a("apn_cache_num", 1, 100, 8);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                Cursor query;
                try {
                    query = writableDatabase.query("halley_schedule_tbl", new String[]{"apn"}, null, null, null, null, "key");
                    if (query != null) {
                        try {
                            int count = query.getCount() - a;
                            if (count > 0 && query.moveToFirst()) {
                                while (true) {
                                    String string = query.getString(query.getColumnIndex("apn"));
                                    if (!(TextUtils.isEmpty(string) || arrayList.contains(string))) {
                                        arrayList.add(string);
                                    }
                                    if (!query.moveToNext()) {
                                        break;
                                    }
                                    int i = count - 1;
                                    if (count <= 0) {
                                        break;
                                    }
                                    count = i;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(98734);
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{(String) it.next()});
                        }
                    }
                    AppMethodBeat.m2505o(98734);
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(98734);
            }
        }

        /* renamed from: a */
        public final synchronized void mo40567a(String str, byte[] bArr) {
            AppMethodBeat.m2504i(98732);
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                int delete = writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put("apn", str);
                contentValues.put("result", bArr);
                contentValues.put(Param.TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                if (-1 != writableDatabase.insert("halley_schedule_tbl", null, contentValues) && delete <= 0) {
                    m37701a();
                }
                AppMethodBeat.m2505o(98732);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(98732);
            }
            return;
        }

        /* renamed from: a */
        public final synchronized byte[] mo40568a(String str) {
            byte[] blob;
            Throwable th;
            AppMethodBeat.m2504i(98733);
            try {
                Cursor query;
                try {
                    query = getReadableDatabase().query("halley_schedule_tbl", null, "apn=?", new String[]{str}, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                blob = query.getBlob(query.getColumnIndex("result"));
                                if (!C24373eu.m37739a(blob)) {
                                    if (query != null) {
                                        query.close();
                                    }
                                    AppMethodBeat.m2505o(98733);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(98733);
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(98733);
                    blob = null;
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                }
            } catch (Throwable th4) {
            }
            return blob;
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            AppMethodBeat.m2504i(98735);
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                AppMethodBeat.m2505o(98735);
            } catch (Exception e) {
                AppMethodBeat.m2505o(98735);
            }
        }

        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            AppMethodBeat.m2504i(98736);
            super.onOpen(sQLiteDatabase);
            try {
                int version = sQLiteDatabase.getVersion();
                if (version != 0) {
                    if (version <= 0) {
                        onUpgrade(sQLiteDatabase, version, 1);
                        AppMethodBeat.m2505o(98736);
                        return;
                    } else if (version > 1) {
                        onDowngrade(sQLiteDatabase, version, 1);
                    }
                }
                AppMethodBeat.m2505o(98736);
            } catch (Exception e) {
                AppMethodBeat.m2505o(98736);
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            AppMethodBeat.m2504i(98737);
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
            } catch (SQLException e) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                AppMethodBeat.m2505o(98737);
            } catch (SQLException e2) {
                AppMethodBeat.m2505o(98737);
                throw e2;
            } catch (Exception e3) {
                AppMethodBeat.m2505o(98737);
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            AppMethodBeat.m2504i(98738);
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
            } catch (SQLException e) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                AppMethodBeat.m2505o(98738);
            } catch (SQLException e2) {
                AppMethodBeat.m2505o(98738);
                throw e2;
            } catch (Exception e3) {
                AppMethodBeat.m2505o(98738);
            }
        }
    }

    public C24366dr(String str) {
        this.f4666a = new C24367a(C46772bt.m88735a(), "halley_schedule_" + C46772bt.m88739c() + (C46772bt.m88738b() ? "_test_" : "_") + C46772bt.m88745i() + "_" + str + ".db", null, 1);
    }

    /* renamed from: a */
    public final synchronized void mo40565a(String str, byte[] bArr) {
        if (!(TextUtils.isEmpty(str) || bArr == null)) {
            this.f4666a.mo40567a(str, bArr);
        }
    }

    /* renamed from: a */
    public final synchronized byte[] mo40566a(String str) {
        return this.f4666a.mo40568a(str);
    }
}
