package com.tencent.p177mm.wallet_core.p649c;

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

/* renamed from: com.tencent.mm.wallet_core.c.y */
public final class C40930y extends C7298n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS walletcache ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    public static final Object xIt = new Object();
    public C36380a<String> AfU = new C36380a("walletcache", "sid");
    public C7480h fni;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private HashMap<Integer, C5747b> xIw = new HashMap();
    private HashMap<String, C5747b> xIx = new HashMap();
    private volatile boolean xIy;
    private final Runnable xIz = new C160811();

    /* renamed from: com.tencent.mm.wallet_core.c.y$b */
    static class C5747b {
        final String fns;
        final int type;

        C5747b(int i, String str) {
            this.type = i;
            this.fns = str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(5476);
            if (obj == null) {
                AppMethodBeat.m2505o(5476);
                return false;
            } else if (obj instanceof C5747b) {
                C5747b c5747b = (C5747b) obj;
                if (this.type != c5747b.type) {
                    AppMethodBeat.m2505o(5476);
                    return false;
                } else if (this.fns != null) {
                    boolean equals = this.fns.equals(c5747b.fns);
                    AppMethodBeat.m2505o(5476);
                    return equals;
                } else if (c5747b.fns == null) {
                    AppMethodBeat.m2505o(5476);
                    return true;
                } else {
                    AppMethodBeat.m2505o(5476);
                    return false;
                }
            } else {
                AppMethodBeat.m2505o(5476);
                return false;
            }
        }

        /* Access modifiers changed, original: final */
        public final Object aoq() {
            Object obj = null;
            AppMethodBeat.m2504i(5477);
            if (this.fns == C40930y.xIt) {
                AppMethodBeat.m2505o(5477);
            } else {
                try {
                    switch (this.type) {
                        case 1:
                            obj = Integer.valueOf(this.fns);
                            AppMethodBeat.m2505o(5477);
                            break;
                        case 2:
                            obj = Long.valueOf(this.fns);
                            AppMethodBeat.m2505o(5477);
                            break;
                        case 3:
                            obj = this.fns;
                            AppMethodBeat.m2505o(5477);
                            break;
                        case 4:
                            obj = Boolean.valueOf(this.fns);
                            AppMethodBeat.m2505o(5477);
                            break;
                        case 5:
                            obj = Float.valueOf(this.fns);
                            AppMethodBeat.m2505o(5477);
                            break;
                        case 6:
                            obj = Double.valueOf(this.fns);
                            AppMethodBeat.m2505o(5477);
                            break;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ConfigStorage", "exception:%s", C5046bo.m7574l(e));
                }
                AppMethodBeat.m2505o(5477);
            }
            return obj;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.c.y$1 */
    class C160811 implements Runnable {
        C160811() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            int i;
            int i2;
            int i3 = 1;
            int i4 = 0;
            AppMethodBeat.m2504i(5473);
            SQLiteDatabase dvx = C40930y.this.fni.dvx();
            if (dvx == null || !dvx.isOpen()) {
                C4990ab.m7420w("MicroMsg.ConfigStorage", "Skip flushing because database has been closed.");
                AppMethodBeat.m2505o(5473);
                return;
            }
            try {
                dvx.acquireReference();
                dvx.beginTransaction();
                try {
                    Object[] objArr = new Object[3];
                    Object[] objArr2 = new Object[1];
                    synchronized (C40930y.this) {
                        HashMap b = C40930y.this.xIw;
                        HashMap c = C40930y.this.xIx;
                        C40930y.this.xIw = new HashMap();
                        C40930y.this.xIx = new HashMap();
                        C40930y.this.xIy = false;
                    }
                    for (Entry entry : b.entrySet()) {
                        C5747b c5747b = (C5747b) entry.getValue();
                        if (c5747b == null) {
                            objArr2[0] = entry.getKey();
                            dvx.execSQL("DELETE FROM userinfo WHERE id=?;", objArr2);
                        } else {
                            objArr[0] = entry.getKey();
                            objArr[1] = Integer.valueOf(c5747b.type);
                            objArr[2] = c5747b.fns;
                            dvx.execSQL("INSERT OR REPLACE INTO userinfo VALUES (?,?,?);", objArr);
                        }
                        i4++;
                    }
                    for (Entry entry2 : c.entrySet()) {
                        C5747b c5747b2 = (C5747b) entry2.getValue();
                        if (c5747b2 == null) {
                            objArr2[0] = entry2.getKey();
                            dvx.execSQL("DELETE FROM userinfo2 WHERE sid=?;", objArr2);
                        } else {
                            objArr[0] = entry2.getKey();
                            objArr[1] = Integer.valueOf(c5747b2.type);
                            objArr[2] = c5747b2.fns;
                            dvx.execSQL("INSERT OR REPLACE INTO userinfo2 VALUES (?,?,?);", objArr);
                        }
                        i4++;
                    }
                    dvx.setTransactionSuccessful();
                    dvx.endTransaction();
                    dvx.releaseReference();
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "Flushed " + i4 + " entries.");
                    AppMethodBeat.m2505o(5473);
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
                    AppMethodBeat.m2505o(5473);
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
                    AppMethodBeat.m2505o(5473);
                } catch (Throwable th2) {
                    e = th2;
                    i3 = i;
                    if (i3 != 0) {
                    }
                    dvx.releaseReference();
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.m2505o(5473);
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
                AppMethodBeat.m2505o(5473);
                throw e;
            }
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.c.y$a */
    public final class C36380a<K> extends C4993ae<K, Object> {
        private final String xIB;

        C36380a(String str, String str2) {
            super(64);
            AppMethodBeat.m2504i(5474);
            this.xIB = "SELECT * FROM " + str + " WHERE " + str2 + "=?;";
            AppMethodBeat.m2505o(5474);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object create(K k) {
            Throwable th;
            Throwable th2;
            AppMethodBeat.m2504i(5475);
            try {
                Cursor a = C40930y.this.fni.mo10104a(this.xIB, new String[]{k.toString()}, 2);
                try {
                    Object aoq;
                    if (a.moveToFirst()) {
                        C5747b c5747b = new C5747b(a.getInt(1), a.getString(2));
                        C4990ab.m7416i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => " + c5747b.fns);
                        aoq = c5747b.aoq();
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(5475);
                        return aoq;
                    }
                    C4990ab.m7416i("MicroMsg.ConfigStorage", "GET: " + k.toString() + " => (NOT EXIST)");
                    aoq = C40930y.xIt;
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(5475);
                    return aoq;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    if (a != null) {
                    }
                    AppMethodBeat.m2505o(5475);
                    throw th;
                }
            } catch (RuntimeException e) {
                C4990ab.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to query UserInfo, id: ".concat(String.valueOf(k)), new Object[0]);
                AppMethodBeat.m2505o(5475);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(5482);
        AppMethodBeat.m2505o(5482);
    }

    public C40930y(C7480h c7480h) {
        AppMethodBeat.m2504i(5478);
        this.fni = c7480h;
        this.mHandlerThread = new HandlerThread("ConfigStorage");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        AppMethodBeat.m2505o(5478);
    }

    public final void set(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(5479);
        if (c5127a == null) {
            AppMethodBeat.m2505o(5479);
            return;
        }
        String name = c5127a.name();
        if (C5046bo.isNullOrNil(name)) {
            AppMethodBeat.m2505o(5479);
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
        if (C40930y.m70957a(str, obj, true)) {
            String substring = name.substring(0, str.length() + name.lastIndexOf(str));
            if (!obj.equals(this.AfU.put(substring, obj))) {
                Object obj2;
                if (obj == xIt) {
                    obj2 = null;
                } else {
                    obj2 = new C5747b(3, obj.toString());
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
                            C4990ab.m7416i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
                        } else if (!this.xIy) {
                            this.xIy = true;
                            this.mHandler.postDelayed(this.xIz, 30000);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(5479);
                    }
                }
                mo10120b(obj == xIt ? 5 : 4, this, substring);
            }
            C4990ab.m7416i("MicroMsg.ConfigStorage", "SET: " + substring + " => " + (obj == xIt ? "(DELETED)" : obj.toString()));
            AppMethodBeat.m2505o(5479);
            return;
        }
        AppMethodBeat.m2505o(5479);
    }

    /* renamed from: a */
    public static boolean m70957a(String str, Object obj, boolean z) {
        AppMethodBeat.m2504i(5480);
        if (obj == null && z) {
            AppMethodBeat.m2505o(5480);
            return true;
        } else if (str.equals("INT") && (obj instanceof Integer)) {
            AppMethodBeat.m2505o(5480);
            return true;
        } else if (str.equals("LONG") && (obj instanceof Long)) {
            AppMethodBeat.m2505o(5480);
            return true;
        } else if (str.equals("STRING") && (obj instanceof String)) {
            AppMethodBeat.m2505o(5480);
            return true;
        } else if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            AppMethodBeat.m2505o(5480);
            return true;
        } else if (str.equals("FLOAT") && (obj instanceof Float)) {
            AppMethodBeat.m2505o(5480);
            return true;
        } else if (str.equals("DOUBLE") && (obj instanceof Double)) {
            AppMethodBeat.m2505o(5480);
            return true;
        } else {
            if (obj != null && C4872b.dnO()) {
                Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
            }
            if (z) {
                C4990ab.m7413e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
            }
            AppMethodBeat.m2505o(5480);
            return false;
        }
    }

    public final boolean apK() {
        AppMethodBeat.m2504i(5481);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.ConfigStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(5481);
            return false;
        }
        AppMethodBeat.m2505o(5481);
        return true;
    }
}
