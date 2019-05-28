package com.tencent.p177mm.storage;

import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.z */
public final class C7580z extends C7298n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private static final Object xIt = new Object();
    private C7480h fni;
    private Handler mHandler;
    public HandlerThread mHandlerThread;
    private C7313a<Integer> xIu = new C7313a("userinfo", "id");
    private C7313a<String> xIv = new C7313a("userinfo2", "sid");
    private HashMap<Integer, C5146b> xIw = new HashMap();
    private HashMap<String, C5146b> xIx = new HashMap();
    private volatile boolean xIy;
    private final Runnable xIz = new C51451();

    /* renamed from: com.tencent.mm.storage.z$1 */
    class C51451 implements Runnable {
        C51451() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ec  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            int i;
            int i2;
            int i3 = 1;
            int i4 = 0;
            AppMethodBeat.m2504i(58964);
            SQLiteDatabase dvx = C7580z.this.fni.dvx();
            if (dvx == null || !dvx.isOpen()) {
                C4990ab.m7420w("MicroMsg.ConfigStorage", "Skip flushing because database has been closed.");
                AppMethodBeat.m2505o(58964);
                return;
            }
            try {
                dvx.acquireReference();
                dvx.beginTransaction();
                try {
                    Object[] objArr = new Object[3];
                    Object[] objArr2 = new Object[1];
                    synchronized (C7580z.this) {
                        HashMap b = C7580z.this.xIw;
                        HashMap c = C7580z.this.xIx;
                        C7580z.this.xIw = new HashMap();
                        C7580z.this.xIx = new HashMap();
                        C7580z.this.xIy = false;
                    }
                    for (Entry entry : b.entrySet()) {
                        C5146b c5146b = (C5146b) entry.getValue();
                        if (c5146b == null) {
                            objArr2[0] = entry.getKey();
                            dvx.execSQL("DELETE FROM userinfo WHERE id=?;", objArr2);
                        } else {
                            objArr[0] = entry.getKey();
                            objArr[1] = Integer.valueOf(c5146b.type);
                            objArr[2] = c5146b.fns;
                            dvx.execSQL("INSERT OR REPLACE INTO userinfo VALUES (?,?,?);", objArr);
                        }
                        i4++;
                    }
                    for (Entry entry2 : c.entrySet()) {
                        C5146b c5146b2 = (C5146b) entry2.getValue();
                        if (c5146b2 == null) {
                            objArr2[0] = entry2.getKey();
                            dvx.execSQL("DELETE FROM userinfo2 WHERE sid=?;", objArr2);
                        } else {
                            objArr[0] = entry2.getKey();
                            objArr[1] = Integer.valueOf(c5146b2.type);
                            objArr[2] = c5146b2.fns;
                            dvx.execSQL("INSERT OR REPLACE INTO userinfo2 VALUES (?,?,?);", objArr);
                        }
                        i4++;
                    }
                    dvx.setTransactionSuccessful();
                    dvx.endTransaction();
                    dvx.releaseReference();
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "Flushed " + i4 + " entries.");
                    AppMethodBeat.m2505o(58964);
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
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.m2505o(58964);
                    throw e;
                }
            } catch (RuntimeException e3) {
                e = e3;
                i = 0;
                i2 = 0;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to flush ConfigStorage", new Object[0]);
                    if (i != 0) {
                        dvx.endTransaction();
                    }
                    dvx.releaseReference();
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.m2505o(58964);
                } catch (Throwable th2) {
                    e = th2;
                    i3 = i;
                    if (i3 != 0) {
                    }
                    dvx.releaseReference();
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.m2505o(58964);
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                i3 = 0;
                i2 = 0;
                if (i3 != 0) {
                }
                dvx.releaseReference();
                C4990ab.m7416i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                AppMethodBeat.m2505o(58964);
                throw e;
            }
        }
    }

    /* renamed from: com.tencent.mm.storage.z$b */
    static class C5146b {
        final String fns;
        final int type;

        C5146b(int i, String str) {
            this.type = i;
            this.fns = str;
        }

        /* renamed from: cI */
        static C5146b m7826cI(Object obj) {
            int i;
            AppMethodBeat.m2504i(58967);
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
                C4990ab.m7412e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
                AppMethodBeat.m2505o(58967);
                return null;
            }
            C5146b c5146b = new C5146b(i, obj.toString());
            AppMethodBeat.m2505o(58967);
            return c5146b;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(58968);
            if (obj == null) {
                AppMethodBeat.m2505o(58968);
                return false;
            } else if (obj instanceof C5146b) {
                C5146b c5146b = (C5146b) obj;
                if (this.type != c5146b.type) {
                    AppMethodBeat.m2505o(58968);
                    return false;
                } else if (this.fns != null) {
                    boolean equals = this.fns.equals(c5146b.fns);
                    AppMethodBeat.m2505o(58968);
                    return equals;
                } else if (c5146b.fns == null) {
                    AppMethodBeat.m2505o(58968);
                    return true;
                } else {
                    AppMethodBeat.m2505o(58968);
                    return false;
                }
            } else {
                AppMethodBeat.m2505o(58968);
                return false;
            }
        }

        /* Access modifiers changed, original: final */
        public final Object aoq() {
            Object obj = null;
            AppMethodBeat.m2504i(58969);
            if (this.fns == C7580z.xIt) {
                AppMethodBeat.m2505o(58969);
            } else {
                try {
                    switch (this.type) {
                        case 1:
                            obj = Integer.valueOf(this.fns);
                            AppMethodBeat.m2505o(58969);
                            break;
                        case 2:
                            obj = Long.valueOf(this.fns);
                            AppMethodBeat.m2505o(58969);
                            break;
                        case 3:
                            obj = this.fns;
                            AppMethodBeat.m2505o(58969);
                            break;
                        case 4:
                            obj = Boolean.valueOf(this.fns);
                            AppMethodBeat.m2505o(58969);
                            break;
                        case 5:
                            obj = Float.valueOf(this.fns);
                            AppMethodBeat.m2505o(58969);
                            break;
                        case 6:
                            obj = Double.valueOf(this.fns);
                            AppMethodBeat.m2505o(58969);
                            break;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ConfigStorage", "exception:%s", C5046bo.m7574l(e));
                }
                AppMethodBeat.m2505o(58969);
            }
            return obj;
        }
    }

    /* renamed from: com.tencent.mm.storage.z$a */
    final class C7313a<K> extends C4993ae<K, Object> {
        private final String xIB;

        C7313a(String str, String str2) {
            super(64);
            AppMethodBeat.m2504i(58965);
            this.xIB = "SELECT * FROM " + str + " WHERE " + str2 + "=?;";
            AppMethodBeat.m2505o(58965);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object create(K k) {
            Throwable th;
            Throwable th2;
            AppMethodBeat.m2504i(58966);
            try {
                Cursor a = C7580z.this.fni.mo10104a(this.xIB, new String[]{k.toString()}, 2);
                try {
                    Object aoq;
                    if (a.moveToFirst()) {
                        C5146b c5146b = new C5146b(a.getInt(1), a.getString(2));
                        C4990ab.m7416i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => " + c5146b.fns);
                        aoq = c5146b.aoq();
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(58966);
                        return aoq;
                    }
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => (NOT EXIST)");
                    aoq = C7580z.xIt;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(58966);
                    return aoq;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    if (a != null) {
                    }
                    AppMethodBeat.m2505o(58966);
                    throw th;
                }
            } catch (RuntimeException e) {
                C4990ab.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to query UserInfo, id: ".concat(String.valueOf(k)), new Object[0]);
                AppMethodBeat.m2505o(58966);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(58988);
        AppMethodBeat.m2505o(58988);
    }

    public C7580z(C7480h c7480h) {
        AppMethodBeat.m2504i(58970);
        this.fni = c7480h;
        this.mHandlerThread = new HandlerThread("ConfigStorage");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        AppMethodBeat.m2505o(58970);
    }

    public final Object get(int i) {
        AppMethodBeat.m2504i(139011);
        Object obj = get(i, null);
        AppMethodBeat.m2505o(139011);
        return obj;
    }

    public final Object get(int i, Object obj) {
        AppMethodBeat.m2504i(58972);
        Assert.assertNotNull("db is null", this.fni);
        Object obj2 = this.xIu.get(Integer.valueOf(i));
        if (obj2 == null || obj2 == xIt) {
            AppMethodBeat.m2505o(58972);
            return obj;
        }
        AppMethodBeat.m2505o(58972);
        return obj2;
    }

    /* renamed from: i */
    public final Object mo16822i(C5127a c5127a) {
        AppMethodBeat.m2504i(139012);
        Object obj = get(c5127a, null);
        AppMethodBeat.m2505o(139012);
        return obj;
    }

    public final Object get(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(58974);
        if (c5127a == null) {
            AppMethodBeat.m2505o(58974);
            return obj;
        }
        String name = c5127a.name();
        if (C5046bo.isNullOrNil(name)) {
            AppMethodBeat.m2505o(58974);
            return obj;
        }
        String[] split = name.split("_");
        String str = split[split.length - 1];
        if (str.equals("SYNC")) {
            str = split[split.length - 2];
        }
        Object obj2 = get(name.substring(0, name.lastIndexOf(str) + str.length()), obj);
        if (C7580z.m13411a(str, obj2, false)) {
            AppMethodBeat.m2505o(58974);
            return obj2;
        }
        AppMethodBeat.m2505o(58974);
        return obj;
    }

    public final boolean getBoolean(C5127a c5127a, boolean z) {
        AppMethodBeat.m2504i(58975);
        Object obj = get(c5127a, Boolean.valueOf(z));
        if (obj == null || !(obj instanceof Boolean)) {
            AppMethodBeat.m2505o(58975);
            return z;
        }
        z = ((Boolean) obj).booleanValue();
        AppMethodBeat.m2505o(58975);
        return z;
    }

    /* renamed from: a */
    public final long mo16814a(C5127a c5127a, long j) {
        AppMethodBeat.m2504i(58976);
        Object obj = get(c5127a, Long.valueOf(j));
        if (obj == null || !(obj instanceof Long)) {
            AppMethodBeat.m2505o(58976);
            return j;
        }
        j = ((Long) obj).longValue();
        AppMethodBeat.m2505o(58976);
        return j;
    }

    public final int getInt(C5127a c5127a, int i) {
        AppMethodBeat.m2504i(58977);
        Object obj = get(c5127a, Integer.valueOf(i));
        if (obj == null || !(obj instanceof Integer)) {
            AppMethodBeat.m2505o(58977);
            return i;
        }
        i = ((Integer) obj).intValue();
        AppMethodBeat.m2505o(58977);
        return i;
    }

    private Object get(String str, Object obj) {
        AppMethodBeat.m2504i(58978);
        Assert.assertNotNull("db is null", this.fni);
        Object obj2 = this.xIv.get(str);
        if (obj2 == null || obj2 == xIt) {
            AppMethodBeat.m2505o(58978);
            return obj;
        }
        AppMethodBeat.m2505o(58978);
        return obj2;
    }

    public final void set(int i, Object obj) {
        AppMethodBeat.m2504i(58979);
        Assert.assertNotNull("db is null", this.fni);
        if (obj == null) {
            obj = xIt;
        }
        if (!obj.equals(this.xIu.put(Integer.valueOf(i), obj))) {
            Object obj2;
            if (obj == xIt) {
                obj2 = null;
            } else {
                obj2 = C5146b.m7826cI(obj);
                if (obj2 == null) {
                    AppMethodBeat.m2505o(58979);
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
                        AppMethodBeat.m2505o(58979);
                    }
                }
            }
            mo10120b(obj == xIt ? 5 : 4, this, Integer.valueOf(i));
        }
        C4990ab.m7416i("MicroMsg.ConfigStorage", "SET: " + i + " => " + (obj == xIt ? "(DELETED)" : obj.toString()));
        AppMethodBeat.m2505o(58979);
    }

    public final void set(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(58980);
        if (c5127a == null) {
            AppMethodBeat.m2505o(58980);
            return;
        }
        String name = c5127a.name();
        if (C5046bo.isNullOrNil(name)) {
            AppMethodBeat.m2505o(58980);
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
        if (C7580z.m13411a(str, obj, true)) {
            String substring = name.substring(0, str.length() + name.lastIndexOf(str));
            if (obj == null) {
                obj = xIt;
            }
            if (!obj.equals(this.xIv.put(substring, obj))) {
                Object obj2;
                if (obj == xIt) {
                    obj2 = null;
                } else {
                    obj2 = C5146b.m7826cI(obj);
                    if (obj2 == null) {
                        AppMethodBeat.m2505o(58980);
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
                        AppMethodBeat.m2505o(58980);
                    }
                }
                mo10120b(obj == xIt ? 5 : 4, this, substring);
            }
            C4990ab.m7416i("MicroMsg.ConfigStorage", "SET: " + substring + " => " + (obj == xIt ? "(DELETED)" : obj.toString()));
            AppMethodBeat.m2505o(58980);
            return;
        }
        AppMethodBeat.m2505o(58980);
    }

    /* renamed from: a */
    private static boolean m13411a(String str, Object obj, boolean z) {
        AppMethodBeat.m2504i(58981);
        if (obj == null && z) {
            AppMethodBeat.m2505o(58981);
            return true;
        } else if (str.equals("INT") && (obj instanceof Integer)) {
            AppMethodBeat.m2505o(58981);
            return true;
        } else if (str.equals("LONG") && (obj instanceof Long)) {
            AppMethodBeat.m2505o(58981);
            return true;
        } else if (str.equals("STRING") && (obj instanceof String)) {
            AppMethodBeat.m2505o(58981);
            return true;
        } else if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            AppMethodBeat.m2505o(58981);
            return true;
        } else if (str.equals("FLOAT") && (obj instanceof Float)) {
            AppMethodBeat.m2505o(58981);
            return true;
        } else if (str.equals("DOUBLE") && (obj instanceof Double)) {
            AppMethodBeat.m2505o(58981);
            return true;
        } else {
            if (obj != null && C4872b.dnO()) {
                Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
            }
            if (z) {
                C4990ab.m7413e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
            }
            AppMethodBeat.m2505o(58981);
            return false;
        }
    }

    public final boolean apK() {
        AppMethodBeat.m2504i(58982);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.ConfigStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(58982);
            return false;
        }
        AppMethodBeat.m2505o(58982);
        return true;
    }

    public final void dsb() {
        AppMethodBeat.m2504i(58983);
        synchronized (this) {
            try {
                this.mHandler.removeCallbacks(this.xIz);
                this.mHandler.post(this.xIz);
                this.xIy = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58983);
            }
        }
        C4990ab.m7416i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
    }

    public final void setInt(int i, int i2) {
        AppMethodBeat.m2504i(58984);
        set(i, Integer.valueOf(i2));
        AppMethodBeat.m2505o(58984);
    }

    public final void setLong(int i, long j) {
        AppMethodBeat.m2504i(58986);
        set(i, Long.valueOf(j));
        AppMethodBeat.m2505o(58986);
    }

    public final int getInt(int i, int i2) {
        AppMethodBeat.m2504i(58985);
        Integer num = (Integer) get(i, null);
        if (num == null) {
            AppMethodBeat.m2505o(58985);
            return i2;
        }
        i2 = num.intValue();
        AppMethodBeat.m2505o(58985);
        return i2;
    }

    /* renamed from: Mm */
    public final long mo16813Mm(int i) {
        AppMethodBeat.m2504i(58987);
        Long l = (Long) get(i, null);
        if (l == null) {
            AppMethodBeat.m2505o(58987);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.m2505o(58987);
        return longValue;
    }
}
