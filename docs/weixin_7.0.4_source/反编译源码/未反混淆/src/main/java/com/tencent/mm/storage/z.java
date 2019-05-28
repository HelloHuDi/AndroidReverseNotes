package com.tencent.mm.storage;

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

public final class z extends n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private static final Object xIt = new Object();
    private h fni;
    private Handler mHandler;
    public HandlerThread mHandlerThread;
    private a<Integer> xIu = new a("userinfo", "id");
    private a<String> xIv = new a("userinfo2", "sid");
    private HashMap<Integer, b> xIw = new HashMap();
    private HashMap<String, b> xIx = new HashMap();
    private volatile boolean xIy;
    private final Runnable xIz = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ec  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            int i;
            int i2;
            int i3 = 1;
            int i4 = 0;
            AppMethodBeat.i(58964);
            SQLiteDatabase dvx = z.this.fni.dvx();
            if (dvx == null || !dvx.isOpen()) {
                ab.w("MicroMsg.ConfigStorage", "Skip flushing because database has been closed.");
                AppMethodBeat.o(58964);
                return;
            }
            try {
                dvx.acquireReference();
                dvx.beginTransaction();
                try {
                    Object[] objArr = new Object[3];
                    Object[] objArr2 = new Object[1];
                    synchronized (z.this) {
                        HashMap b = z.this.xIw;
                        HashMap c = z.this.xIx;
                        z.this.xIw = new HashMap();
                        z.this.xIx = new HashMap();
                        z.this.xIy = false;
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
                    AppMethodBeat.o(58964);
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
                    AppMethodBeat.o(58964);
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
                    AppMethodBeat.o(58964);
                } catch (Throwable th2) {
                    e = th2;
                    i3 = i;
                    if (i3 != 0) {
                    }
                    dvx.releaseReference();
                    ab.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.o(58964);
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
                AppMethodBeat.o(58964);
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

        static b cI(Object obj) {
            int i;
            AppMethodBeat.i(58967);
            if (obj instanceof Integer) {
                i = 1;
            } else if (obj instanceof Long) {
                i = 2;
            } else if (obj instanceof String) {
                i = 3;
            } else if (obj instanceof Boolean) {
                i = 4;
            } else if (obj instanceof Float) {
                i = 5;
            } else if (obj instanceof Double) {
                i = 6;
            } else {
                ab.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
                AppMethodBeat.o(58967);
                return null;
            }
            b bVar = new b(i, obj.toString());
            AppMethodBeat.o(58967);
            return bVar;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(58968);
            if (obj == null) {
                AppMethodBeat.o(58968);
                return false;
            } else if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.type != bVar.type) {
                    AppMethodBeat.o(58968);
                    return false;
                } else if (this.fns != null) {
                    boolean equals = this.fns.equals(bVar.fns);
                    AppMethodBeat.o(58968);
                    return equals;
                } else if (bVar.fns == null) {
                    AppMethodBeat.o(58968);
                    return true;
                } else {
                    AppMethodBeat.o(58968);
                    return false;
                }
            } else {
                AppMethodBeat.o(58968);
                return false;
            }
        }

        /* Access modifiers changed, original: final */
        public final Object aoq() {
            Object obj = null;
            AppMethodBeat.i(58969);
            if (this.fns == z.xIt) {
                AppMethodBeat.o(58969);
            } else {
                try {
                    switch (this.type) {
                        case 1:
                            obj = Integer.valueOf(this.fns);
                            AppMethodBeat.o(58969);
                            break;
                        case 2:
                            obj = Long.valueOf(this.fns);
                            AppMethodBeat.o(58969);
                            break;
                        case 3:
                            obj = this.fns;
                            AppMethodBeat.o(58969);
                            break;
                        case 4:
                            obj = Boolean.valueOf(this.fns);
                            AppMethodBeat.o(58969);
                            break;
                        case 5:
                            obj = Float.valueOf(this.fns);
                            AppMethodBeat.o(58969);
                            break;
                        case 6:
                            obj = Double.valueOf(this.fns);
                            AppMethodBeat.o(58969);
                            break;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.ConfigStorage", "exception:%s", bo.l(e));
                }
                AppMethodBeat.o(58969);
            }
            return obj;
        }
    }

    final class a<K> extends ae<K, Object> {
        private final String xIB;

        a(String str, String str2) {
            super(64);
            AppMethodBeat.i(58965);
            this.xIB = "SELECT * FROM " + str + " WHERE " + str2 + "=?;";
            AppMethodBeat.o(58965);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object create(K k) {
            Throwable th;
            Throwable th2;
            AppMethodBeat.i(58966);
            try {
                Cursor a = z.this.fni.a(this.xIB, new String[]{k.toString()}, 2);
                try {
                    Object aoq;
                    if (a.moveToFirst()) {
                        b bVar = new b(a.getInt(1), a.getString(2));
                        ab.i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => " + bVar.fns);
                        aoq = bVar.aoq();
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(58966);
                        return aoq;
                    }
                    ab.i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => (NOT EXIST)");
                    aoq = z.xIt;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(58966);
                    return aoq;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    if (a != null) {
                    }
                    AppMethodBeat.o(58966);
                    throw th;
                }
            } catch (RuntimeException e) {
                ab.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to query UserInfo, id: ".concat(String.valueOf(k)), new Object[0]);
                AppMethodBeat.o(58966);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.i(58988);
        AppMethodBeat.o(58988);
    }

    public z(h hVar) {
        AppMethodBeat.i(58970);
        this.fni = hVar;
        this.mHandlerThread = new HandlerThread("ConfigStorage");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        AppMethodBeat.o(58970);
    }

    public final Object get(int i) {
        AppMethodBeat.i(139011);
        Object obj = get(i, null);
        AppMethodBeat.o(139011);
        return obj;
    }

    public final Object get(int i, Object obj) {
        AppMethodBeat.i(58972);
        Assert.assertNotNull("db is null", this.fni);
        Object obj2 = this.xIu.get(Integer.valueOf(i));
        if (obj2 == null || obj2 == xIt) {
            AppMethodBeat.o(58972);
            return obj;
        }
        AppMethodBeat.o(58972);
        return obj2;
    }

    public final Object i(com.tencent.mm.storage.ac.a aVar) {
        AppMethodBeat.i(139012);
        Object obj = get(aVar, null);
        AppMethodBeat.o(139012);
        return obj;
    }

    public final Object get(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(58974);
        if (aVar == null) {
            AppMethodBeat.o(58974);
            return obj;
        }
        String name = aVar.name();
        if (bo.isNullOrNil(name)) {
            AppMethodBeat.o(58974);
            return obj;
        }
        String[] split = name.split("_");
        String str = split[split.length - 1];
        if (str.equals("SYNC")) {
            str = split[split.length - 2];
        }
        Object obj2 = get(name.substring(0, name.lastIndexOf(str) + str.length()), obj);
        if (a(str, obj2, false)) {
            AppMethodBeat.o(58974);
            return obj2;
        }
        AppMethodBeat.o(58974);
        return obj;
    }

    public final boolean getBoolean(com.tencent.mm.storage.ac.a aVar, boolean z) {
        AppMethodBeat.i(58975);
        Object obj = get(aVar, Boolean.valueOf(z));
        if (obj == null || !(obj instanceof Boolean)) {
            AppMethodBeat.o(58975);
            return z;
        }
        z = ((Boolean) obj).booleanValue();
        AppMethodBeat.o(58975);
        return z;
    }

    public final long a(com.tencent.mm.storage.ac.a aVar, long j) {
        AppMethodBeat.i(58976);
        Object obj = get(aVar, Long.valueOf(j));
        if (obj == null || !(obj instanceof Long)) {
            AppMethodBeat.o(58976);
            return j;
        }
        j = ((Long) obj).longValue();
        AppMethodBeat.o(58976);
        return j;
    }

    public final int getInt(com.tencent.mm.storage.ac.a aVar, int i) {
        AppMethodBeat.i(58977);
        Object obj = get(aVar, Integer.valueOf(i));
        if (obj == null || !(obj instanceof Integer)) {
            AppMethodBeat.o(58977);
            return i;
        }
        i = ((Integer) obj).intValue();
        AppMethodBeat.o(58977);
        return i;
    }

    private Object get(String str, Object obj) {
        AppMethodBeat.i(58978);
        Assert.assertNotNull("db is null", this.fni);
        Object obj2 = this.xIv.get(str);
        if (obj2 == null || obj2 == xIt) {
            AppMethodBeat.o(58978);
            return obj;
        }
        AppMethodBeat.o(58978);
        return obj2;
    }

    public final void set(int i, Object obj) {
        AppMethodBeat.i(58979);
        Assert.assertNotNull("db is null", this.fni);
        if (obj == null) {
            obj = xIt;
        }
        if (!obj.equals(this.xIu.put(Integer.valueOf(i), obj))) {
            Object obj2;
            if (obj == xIt) {
                obj2 = null;
            } else {
                obj2 = b.cI(obj);
                if (obj2 == null) {
                    AppMethodBeat.o(58979);
                    return;
                }
            }
            synchronized (this) {
                try {
                    this.xIw.put(Integer.valueOf(i), obj2);
                    if (!this.xIy) {
                        this.xIy = true;
                        this.mHandler.postDelayed(this.xIz, 30000);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(58979);
                    }
                }
            }
            b(obj == xIt ? 5 : 4, this, Integer.valueOf(i));
        }
        ab.i("MicroMsg.ConfigStorage", "SET: " + i + " => " + (obj == xIt ? "(DELETED)" : obj.toString()));
        AppMethodBeat.o(58979);
    }

    public final void set(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(58980);
        if (aVar == null) {
            AppMethodBeat.o(58980);
            return;
        }
        String name = aVar.name();
        if (bo.isNullOrNil(name)) {
            AppMethodBeat.o(58980);
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
            if (obj == null) {
                obj = xIt;
            }
            if (!obj.equals(this.xIv.put(substring, obj))) {
                Object obj2;
                if (obj == xIt) {
                    obj2 = null;
                } else {
                    obj2 = b.cI(obj);
                    if (obj2 == null) {
                        AppMethodBeat.o(58980);
                        return;
                    }
                }
                synchronized (this) {
                    try {
                        this.xIx.put(substring, obj2);
                        if (z) {
                            dsb();
                        } else if (!this.xIy) {
                            this.xIy = true;
                            this.mHandler.postDelayed(this.xIz, 30000);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(58980);
                    }
                }
                b(obj == xIt ? 5 : 4, this, substring);
            }
            ab.i("MicroMsg.ConfigStorage", "SET: " + substring + " => " + (obj == xIt ? "(DELETED)" : obj.toString()));
            AppMethodBeat.o(58980);
            return;
        }
        AppMethodBeat.o(58980);
    }

    private static boolean a(String str, Object obj, boolean z) {
        AppMethodBeat.i(58981);
        if (obj == null && z) {
            AppMethodBeat.o(58981);
            return true;
        } else if (str.equals("INT") && (obj instanceof Integer)) {
            AppMethodBeat.o(58981);
            return true;
        } else if (str.equals("LONG") && (obj instanceof Long)) {
            AppMethodBeat.o(58981);
            return true;
        } else if (str.equals("STRING") && (obj instanceof String)) {
            AppMethodBeat.o(58981);
            return true;
        } else if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            AppMethodBeat.o(58981);
            return true;
        } else if (str.equals("FLOAT") && (obj instanceof Float)) {
            AppMethodBeat.o(58981);
            return true;
        } else if (str.equals("DOUBLE") && (obj instanceof Double)) {
            AppMethodBeat.o(58981);
            return true;
        } else {
            if (obj != null && com.tencent.mm.sdk.a.b.dnO()) {
                Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
            }
            if (z) {
                ab.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
            }
            AppMethodBeat.o(58981);
            return false;
        }
    }

    public final boolean apK() {
        AppMethodBeat.i(58982);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.ConfigStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            ab.w(str, str2, objArr);
            AppMethodBeat.o(58982);
            return false;
        }
        AppMethodBeat.o(58982);
        return true;
    }

    public final void dsb() {
        AppMethodBeat.i(58983);
        synchronized (this) {
            try {
                this.mHandler.removeCallbacks(this.xIz);
                this.mHandler.post(this.xIz);
                this.xIy = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(58983);
            }
        }
        ab.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
    }

    public final void setInt(int i, int i2) {
        AppMethodBeat.i(58984);
        set(i, Integer.valueOf(i2));
        AppMethodBeat.o(58984);
    }

    public final void setLong(int i, long j) {
        AppMethodBeat.i(58986);
        set(i, Long.valueOf(j));
        AppMethodBeat.o(58986);
    }

    public final int getInt(int i, int i2) {
        AppMethodBeat.i(58985);
        Integer num = (Integer) get(i, null);
        if (num == null) {
            AppMethodBeat.o(58985);
            return i2;
        }
        i2 = num.intValue();
        AppMethodBeat.o(58985);
        return i2;
    }

    public final long Mm(int i) {
        AppMethodBeat.i(58987);
        Long l = (Long) get(i, null);
        if (l == null) {
            AppMethodBeat.o(58987);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(58987);
        return longValue;
    }
}
