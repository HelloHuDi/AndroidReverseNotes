package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.r */
public final class C31082r extends SQLiteOpenHelper {
    /* renamed from: a */
    public static Object f14320a = new Object();
    /* renamed from: c */
    private static SQLiteDatabase f14321c = null;
    /* renamed from: b */
    private Context f14322b;

    static {
        AppMethodBeat.m2504i(100541);
        AppMethodBeat.m2505o(100541);
    }

    private C31082r(Context context) {
        super(context, "beacon_tmap_db", null, 22);
        this.f14322b = context;
    }

    /* renamed from: a */
    public static synchronized C31082r m50139a(Context context) {
        C31082r c31082r;
        synchronized (C31082r.class) {
            AppMethodBeat.m2504i(100535);
            c31082r = new C31082r(context);
            AppMethodBeat.m2505o(100535);
        }
        return c31082r;
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            AppMethodBeat.m2504i(100536);
            if (!(sQLiteDatabase == null || C41081q.f16554a == null)) {
                for (Object[] objArr : C41081q.f16554a) {
                    C16205ag.m24690g("table:%s", objArr[0]);
                    sQLiteDatabase.execSQL(objArr[1]);
                }
            }
            AppMethodBeat.m2505o(100536);
        }
    }

    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.m2504i(100537);
        C16205ag.m24690g("upgrade a db  [%s] from v %d to v %d , deleted all tables!", "beacon_tmap_db", Integer.valueOf(i), Integer.valueOf(i2));
        if (m50140a(sQLiteDatabase)) {
            C16205ag.m24690g("drop all success recreate!", new Object[0]);
            onCreate(sQLiteDatabase);
            AppMethodBeat.m2505o(100537);
        } else {
            C16205ag.m24687d("drop all fail try deleted file,may next time will success!", new Object[0]);
            File databasePath = this.f14322b.getDatabasePath("beacon_tmap_db");
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
            AppMethodBeat.m2505o(100537);
        }
    }

    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.m2504i(100538);
        C24349e.m37573a(this.f14322b);
        if (Integer.parseInt(C24349e.m37601c()) >= 11) {
            C16205ag.m24690g("downgrade a db  [%s] from v %d to  v%d , deleted all tables!", "beacon_tmap_db", Integer.valueOf(i), Integer.valueOf(i2));
            if (m50140a(sQLiteDatabase)) {
                C16205ag.m24690g("drop all success recreate!", new Object[0]);
                onCreate(sQLiteDatabase);
                AppMethodBeat.m2505o(100538);
            } else {
                C16205ag.m24687d("drop all fail try deleted file,may next time will success!", new Object[0]);
                File databasePath = this.f14322b.getDatabasePath("beacon_tmap_db");
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
        AppMethodBeat.m2505o(100538);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a A:{SYNTHETIC, Splitter:B:39:0x009a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private synchronized boolean m50140a(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        boolean z;
        AppMethodBeat.m2504i(100539);
        Cursor query;
        try {
            ArrayList<String> arrayList = new ArrayList();
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("sqlite_master", new String[]{"name"}, "type = 'table'", null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        arrayList.add(query.getString(0));
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            C16205ag.m24684a(th);
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            AppMethodBeat.m2505o(100539);
                            z = false;
                            return z;
                        } catch (Throwable th3) {
                            th = th3;
                            if (query != null) {
                            }
                            AppMethodBeat.m2505o(100539);
                            throw th;
                        }
                    }
                }
            }
            String str = "drop table if exists %s";
            if (arrayList.size() > 0) {
                for (String str2 : arrayList) {
                    if (!(str2.equals("sqlite_sequence") || str2.equals("android_metadata"))) {
                        sQLiteDatabase.execSQL(String.format(Locale.US, str, new Object[]{str2}));
                        C16205ag.m24690g("drop %s", str2);
                    }
                }
            }
            if (query != null) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
            AppMethodBeat.m2505o(100539);
            z = true;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
            AppMethodBeat.m2505o(100539);
            throw th;
        }
        return z;
    }

    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(100540);
            while (f14321c == null && i < 5) {
                i++;
                try {
                    f14321c = super.getWritableDatabase();
                } catch (Exception e) {
                    C16205ag.m24686c("getWritableDatabase error count %d", Integer.valueOf(i));
                    if (i == 5) {
                        C16205ag.m24687d("error get DB failed", new Object[0]);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e2) {
                        C16205ag.m24684a(e2);
                    }
                }
            }
            sQLiteDatabase = f14321c;
            AppMethodBeat.m2505o(100540);
        }
        return sQLiteDatabase;
    }
}
