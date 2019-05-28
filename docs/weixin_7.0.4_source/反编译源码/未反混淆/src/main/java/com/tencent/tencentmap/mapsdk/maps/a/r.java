package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public final class r extends SQLiteOpenHelper {
    public static Object a = new Object();
    private static SQLiteDatabase c = null;
    private Context b;

    static {
        AppMethodBeat.i(100541);
        AppMethodBeat.o(100541);
    }

    private r(Context context) {
        super(context, "beacon_tmap_db", null, 22);
        this.b = context;
    }

    public static synchronized r a(Context context) {
        r rVar;
        synchronized (r.class) {
            AppMethodBeat.i(100535);
            rVar = new r(context);
            AppMethodBeat.o(100535);
        }
        return rVar;
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            AppMethodBeat.i(100536);
            if (!(sQLiteDatabase == null || q.a == null)) {
                for (Object[] objArr : q.a) {
                    ag.g("table:%s", objArr[0]);
                    sQLiteDatabase.execSQL(objArr[1]);
                }
            }
            AppMethodBeat.o(100536);
        }
    }

    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.i(100537);
        ag.g("upgrade a db  [%s] from v %d to v %d , deleted all tables!", "beacon_tmap_db", Integer.valueOf(i), Integer.valueOf(i2));
        if (a(sQLiteDatabase)) {
            ag.g("drop all success recreate!", new Object[0]);
            onCreate(sQLiteDatabase);
            AppMethodBeat.o(100537);
        } else {
            ag.d("drop all fail try deleted file,may next time will success!", new Object[0]);
            File databasePath = this.b.getDatabasePath("beacon_tmap_db");
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
            AppMethodBeat.o(100537);
        }
    }

    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AppMethodBeat.i(100538);
        e.a(this.b);
        if (Integer.parseInt(e.c()) >= 11) {
            ag.g("downgrade a db  [%s] from v %d to  v%d , deleted all tables!", "beacon_tmap_db", Integer.valueOf(i), Integer.valueOf(i2));
            if (a(sQLiteDatabase)) {
                ag.g("drop all success recreate!", new Object[0]);
                onCreate(sQLiteDatabase);
                AppMethodBeat.o(100538);
            } else {
                ag.d("drop all fail try deleted file,may next time will success!", new Object[0]);
                File databasePath = this.b.getDatabasePath("beacon_tmap_db");
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
        AppMethodBeat.o(100538);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a A:{SYNTHETIC, Splitter:B:39:0x009a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        boolean z;
        AppMethodBeat.i(100539);
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
                            ag.a(th);
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                            AppMethodBeat.o(100539);
                            z = false;
                            return z;
                        } catch (Throwable th3) {
                            th = th3;
                            if (query != null) {
                            }
                            AppMethodBeat.o(100539);
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
                        ag.g("drop %s", str2);
                    }
                }
            }
            if (query != null) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
            AppMethodBeat.o(100539);
            z = true;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
            AppMethodBeat.o(100539);
            throw th;
        }
        return z;
    }

    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(100540);
            while (c == null && i < 5) {
                i++;
                try {
                    c = super.getWritableDatabase();
                } catch (Exception e) {
                    ag.c("getWritableDatabase error count %d", Integer.valueOf(i));
                    if (i == 5) {
                        ag.d("error get DB failed", new Object[0]);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e2) {
                        ag.a(e2);
                    }
                }
            }
            sQLiteDatabase = c;
            AppMethodBeat.o(100540);
        }
        return sQLiteDatabase;
    }
}
