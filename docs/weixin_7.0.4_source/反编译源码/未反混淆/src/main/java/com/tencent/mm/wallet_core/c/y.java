package com.tencent.mm.wallet_core.c;

import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class y extends n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS walletcache ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    public static final Object xIt = new Object();
    public a<String> AfU = new a("walletcache", "sid");
    public h fni;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private HashMap<Integer, b> xIw = new HashMap();
    private HashMap<String, b> xIx = new HashMap();
    private volatile boolean xIy;
    private final Runnable xIz = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            int i;
            int i2;
            int i3 = 1;
            int i4 = 0;
            AppMethodBeat.i(5473);
            SQLiteDatabase dvx = y.this.fni.dvx();
            if (dvx == null || !dvx.isOpen()) {
                ab.w("MicroMsg.ConfigStorage", "Skip flushing because database has been closed.");
                AppMethodBeat.o(5473);
                return;
            }
            try {
                dvx.acquireReference();
                dvx.beginTransaction();
                try {
                    Object[] objArr = new Object[3];
                    Object[] objArr2 = new Object[1];
                    synchronized (y.this) {
                        HashMap b = y.this.xIw;
                        HashMap c = y.this.xIx;
                        y.this.xIw = new HashMap();
                        y.this.xIx = new HashMap();
                        y.this.xIy = false;
                    }
                    for (Entry entry : b.entrySet()) {
                        b bVar = (b) entry.getValue();
                        if (bVar == null) {
                            objArr2[0] = entry.getKey();
                            dvx.execSQL("DELETE FROM userinfo WHERE id=?;", objArr2);
                        } else {
                            objArr[0] = entry.getKey();
                            objArr[1] = Integer.valueOf(bVar.type);
                            objArr[2] = bVar.fns;
                            dvx.execSQL("INSERT OR REPLACE INTO userinfo VALUES (?,?,?);", objArr);
                        }
                        i4++;
                    }
                    for (Entry entry2 : c.entrySet()) {
                        b bVar2 = (b) entry2.getValue();
                        if (bVar2 == null) {
                            objArr2[0] = entry2.getKey();
                            dvx.execSQL("DELETE FROM userinfo2 WHERE sid=?;", objArr2);
                        } else {
                            objArr[0] = entry2.getKey();
                            objArr[1] = Integer.valueOf(bVar2.type);
                            objArr[2] = bVar2.fns;
                            dvx.execSQL("INSERT OR REPLACE INTO userinfo2 VALUES (?,?,?);", objArr);
                        }
                        i4++;
                    }
                    dvx.setTransactionSuccessful();
                    dvx.endTransaction();
                    dvx.releaseReference();
                    ab.i("MicroMsg.ConfigStorage", "Flushed " + i4 + " entries.");
                    AppMethodBeat.o(5473);
                } catch (RuntimeException e2) {
                    e = e2;
                    i = 1;
                    i2 = i4;
                } catch (Throwable th) {
                    e = th;
                    i2 = i4;
                    if (i3 != 0) {
                        dvx.endTransaction();
                    }
                    dvx.releaseReference();
                    ab.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.o(5473);
                    throw e;
                }
            } catch (RuntimeException e3) {
                e = e3;
                i = 0;
                i2 = 0;
                try {
                    ab.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to flush ConfigStorage", new Object[0]);
                    if (i != 0) {
                        dvx.endTransaction();
                    }
                    dvx.releaseReference();
                    ab.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.o(5473);
                } catch (Throwable th2) {
                    e = th2;
                    i3 = i;
                    if (i3 != 0) {
                    }
                    dvx.releaseReference();
                    ab.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.o(5473);
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                i3 = 0;
                i2 = 0;
                if (i3 != 0) {
                }
                dvx.releaseReference();
                ab.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                AppMethodBeat.o(5473);
                throw e;
            }
        }
    };

    static class b {
        final String fns;
        final int type;

        b(int i, String str) {
            this.type = i;
            this.fns = str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(5476);
            if (obj == null) {
                AppMethodBeat.o(5476);
                return false;
            } else if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.type != bVar.type) {
                    AppMethodBeat.o(5476);
                    return false;
                } else if (this.fns != null) {
                    boolean equals = this.fns.equals(bVar.fns);
                    AppMethodBeat.o(5476);
                    return equals;
                } else if (bVar.fns == null) {
                    AppMethodBeat.o(5476);
                    return true;
                } else {
                    AppMethodBeat.o(5476);
                    return false;
                }
            } else {
                AppMethodBeat.o(5476);
                return false;
            }
        }

        /* Access modifiers changed, original: final */
        public final Object aoq() {
            Object obj = null;
            AppMethodBeat.i(5477);
            if (this.fns == y.xIt) {
                AppMethodBeat.o(5477);
            } else {
                try {
                    switch (this.type) {
                        case 1:
                            obj = Integer.valueOf(this.fns);
                            AppMethodBeat.o(5477);
                            break;
                        case 2:
                            obj = Long.valueOf(this.fns);
                            AppMethodBeat.o(5477);
                            break;
                        case 3:
                            obj = this.fns;
                            AppMethodBeat.o(5477);
                            break;
                        case 4:
                            obj = Boolean.valueOf(this.fns);
                            AppMethodBeat.o(5477);
                            break;
                        case 5:
                            obj = Float.valueOf(this.fns);
                            AppMethodBeat.o(5477);
                            break;
                        case 6:
                            obj = Double.valueOf(this.fns);
                            AppMethodBeat.o(5477);
                            break;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.ConfigStorage", "exception:%s", bo.l(e));
                }
                AppMethodBeat.o(5477);
            }
            return obj;
        }
    }

    public final class a<K> extends ae<K, Object> {
        private final String xIB;

        a(String str, String str2) {
            super(64);
            AppMethodBeat.i(5474);
            this.xIB = "SELECT * FROM " + str + " WHERE " + str2 + "=?;";
            AppMethodBeat.o(5474);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object create(K k) {
            Throwable th;
            Throwable th2;
            AppMethodBeat.i(5475);
            try {
                Cursor a = y.this.fni.a(this.xIB, new String[]{k.toString()}, 2);
                try {
                    Object aoq;
                    if (a.moveToFirst()) {
                        b bVar = new b(a.getInt(1), a.getString(2));
                        ab.i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => " + bVar.fns);
                        aoq = bVar.aoq();
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(5475);
                        return aoq;
                    }
                    ab.i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => (NOT EXIST)");
                    aoq = y.xIt;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(5475);
                    return aoq;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    if (a != null) {
                    }
                    AppMethodBeat.o(5475);
                    throw th;
                }
            } catch (RuntimeException e) {
                ab.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to query UserInfo, id: ".concat(String.valueOf(k)), new Object[0]);
                AppMethodBeat.o(5475);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.i(5482);
        AppMethodBeat.o(5482);
    }

    public y(h hVar) {
        AppMethodBeat.i(5478);
        this.fni = hVar;
        this.mHandlerThread = new HandlerThread("ConfigStorage");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        AppMethodBeat.o(5478);
    }

    public final void set(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(5479);
        if (aVar == null) {
            AppMethodBeat.o(5479);
            return;
        }
        String name = aVar.name();
        if (bo.isNullOrNil(name)) {
            AppMethodBeat.o(5479);
            return;
        }
        boolean z;
        String[] split = name.split("_");
        String str = split[split.length - 1];
        if (str.equals("SYNC")) {
            str = split[split.length - 2];
            z = true;
        } else {
            z = false;
        }
        if (a(str, obj, true)) {
            String substring = name.substring(0, str.length() + name.lastIndexOf(str));
            if (!obj.equals(this.AfU.put(substring, obj))) {
                Object obj2;
                if (obj == xIt) {
                    obj2 = null;
                } else {
                    obj2 = new b(3, obj.toString());
                }
                synchronized (this) {
                    try {
                        this.xIx.put(substring, obj2);
                        if (z) {
                            synchronized (this) {
                                this.mHandler.removeCallbacks(this.xIz);
                                this.mHandler.post(this.xIz);
                                this.xIy = true;
                            }
                            ab.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
                        } else if (!this.xIy) {
                            this.xIy = true;
                            this.mHandler.postDelayed(this.xIz, 30000);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(5479);
                    }
                }
                b(obj == xIt ? 5 : 4, this, substring);
            }
            ab.i("MicroMsg.ConfigStorage", "SET: " + substring + " => " + (obj == xIt ? "(DELETED)" : obj.toString()));
            AppMethodBeat.o(5479);
            return;
        }
        AppMethodBeat.o(5479);
    }

    public static boolean a(String str, Object obj, boolean z) {
        AppMethodBeat.i(5480);
        if (obj == null && z) {
            AppMethodBeat.o(5480);
            return true;
        } else if (str.equals("INT") && (obj instanceof Integer)) {
            AppMethodBeat.o(5480);
            return true;
        } else if (str.equals("LONG") && (obj instanceof Long)) {
            AppMethodBeat.o(5480);
            return true;
        } else if (str.equals("STRING") && (obj instanceof String)) {
            AppMethodBeat.o(5480);
            return true;
        } else if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            AppMethodBeat.o(5480);
            return true;
        } else if (str.equals("FLOAT") && (obj instanceof Float)) {
            AppMethodBeat.o(5480);
            return true;
        } else if (str.equals("DOUBLE") && (obj instanceof Double)) {
            AppMethodBeat.o(5480);
            return true;
        } else {
            if (obj != null && com.tencent.mm.sdk.a.b.dnO()) {
                Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
            }
            if (z) {
                ab.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
            }
            AppMethodBeat.o(5480);
            return false;
        }
    }

    public final boolean apK() {
        AppMethodBeat.i(5481);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.ConfigStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            ab.w(str, str2, objArr);
            AppMethodBeat.o(5481);
            return false;
        }
        AppMethodBeat.o(5481);
        return true;
    }
}
