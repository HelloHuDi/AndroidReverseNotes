package com.tencent.p177mm.p213cd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C7293f;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.cd.h */
public class C7480h implements C7293f {
    String TAG = "MicroMsg.SqliteDB";
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private long jsG = 0;
    private C1363a ybO = null;
    public C1356a ybP = new C1356a();
    private String ybQ = "";
    public C1367e ybR = null;
    public String ybS = "";
    final LinkedList<C1364b> ybT = new LinkedList();
    private C7306ak ybU = null;
    protected C6395f ybk = null;

    /* renamed from: com.tencent.mm.cd.h$a */
    public interface C1363a {
        /* renamed from: RF */
        void mo4747RF();

        /* renamed from: RG */
        void mo4748RG();

        /* renamed from: RH */
        void mo4749RH();
    }

    /* renamed from: com.tencent.mm.cd.h$b */
    public static class C1364b {
        public long lastReportTime;
        public String table;
        public WeakReference<Cursor> ybY;
        public String ybZ;
        public long yca;
        public boolean ycb;
        public String ycc;
        public C1365c ycd;
    }

    /* renamed from: com.tencent.mm.cd.h$c */
    static class C1365c extends AssertionError {
        C1365c() {
        }

        C1365c(String str) {
            super(str);
        }
    }

    /* renamed from: com.tencent.mm.cd.h$d */
    public interface C1366d {
        /* renamed from: Af */
        String[] mo4750Af();
    }

    /* renamed from: com.tencent.mm.cd.h$e */
    public interface C1367e {
        /* renamed from: RI */
        void mo4751RI();
    }

    public C7480h(C1363a c1363a) {
        AppMethodBeat.m2504i(59101);
        this.ybO = c1363a;
        AppMethodBeat.m2505o(59101);
    }

    public C7480h() {
        AppMethodBeat.m2504i(59102);
        AppMethodBeat.m2505o(59102);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(59103);
        mo5708jC(null);
        AppMethodBeat.m2505o(59103);
    }

    public void closeDB() {
        AppMethodBeat.m2504i(59104);
        mo5708jC(null);
        AppMethodBeat.m2505o(59104);
    }

    /* renamed from: jC */
    public void mo5708jC(String str) {
        AppMethodBeat.m2504i(59105);
        if (this.ybk == null) {
            AppMethodBeat.m2505o(59105);
            return;
        }
        if (this.ybO != null) {
            this.ybO.mo4747RF();
        }
        C4990ab.m7421w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.jsG), Long.valueOf(Thread.currentThread().getId()), C5046bo.dpG());
        C1446a c1446a = new C1446a();
        if (str != null) {
            this.ybQ = str;
        }
        this.ybk.close();
        this.ybk = null;
        C4990ab.m7411d(this.TAG, "end close db time:%d", Long.valueOf(c1446a.mo4908Mr()));
        AppMethodBeat.m2505o(59105);
    }

    public final boolean dpU() {
        AppMethodBeat.m2504i(59106);
        if (this.ybk == null || !this.ybk.isOpen()) {
            AppMethodBeat.m2505o(59106);
            return true;
        }
        AppMethodBeat.m2505o(59106);
        return false;
    }

    private void aqw(String str) {
        AppMethodBeat.m2504i(59107);
        String processName = C4996ah.getProcessName();
        String packageName = C4996ah.getPackageName();
        C4990ab.m7417i(this.TAG, "check process :[%s] [%s] path[%s]", processName, packageName, str);
        if (!(processName == null || packageName == null || packageName.equals(processName))) {
            Assert.assertTrue("processName:" + processName + "  packagename:" + packageName, false);
        }
        AppMethodBeat.m2505o(59107);
    }

    /* renamed from: b */
    public final boolean mo16661b(String str, HashMap<Integer, C1366d> hashMap, boolean z) {
        AppMethodBeat.m2504i(59108);
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        aqw(str);
        if (!this.ybP.mo4728a(str, (HashMap) hashMap, z) || this.ybP.ybk == null) {
            this.ybk = null;
            this.ybP = null;
            C4990ab.m7412e(this.TAG, "initDB failed.");
            AppMethodBeat.m2505o(59108);
            return false;
        }
        this.ybk = this.ybP.ybk;
        C4990ab.m7417i(this.TAG, "SqliteDB db %s", this.ybk);
        AppMethodBeat.m2505o(59108);
        return true;
    }

    /* renamed from: b */
    public final boolean mo16660b(String str, String str2, String str3, long j, HashMap<Integer, C1366d> hashMap, boolean z) {
        AppMethodBeat.m2504i(59109);
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        aqw(str2);
        if (!this.ybP.mo4727a(str, str2, str3, j, hashMap, z) || this.ybP.ybk == null) {
            this.ybS = this.ybP.getError();
            this.ybk = null;
            this.ybP = null;
            C4990ab.m7417i(this.TAG, "initDB failed. %s", this.ybS);
            AppMethodBeat.m2505o(59109);
            return false;
        }
        this.ybS = this.ybP.getError();
        this.ybk = this.ybP.ybk;
        AppMethodBeat.m2505o(59109);
        return true;
    }

    /* renamed from: a */
    public final boolean mo16657a(String str, String str2, long j, HashMap<Integer, C1366d> hashMap) {
        AppMethodBeat.m2504i(59110);
        boolean b = mo16660b(str, str2, "", j, hashMap, true);
        AppMethodBeat.m2505o(59110);
        return b;
    }

    public final boolean isOpen() {
        AppMethodBeat.m2504i(59111);
        if (this.ybk == null || !this.ybk.isOpen()) {
            Assert.assertTrue("DB has been closed :[" + this.ybQ + "]", C5046bo.isNullOrNil(this.ybQ));
            AppMethodBeat.m2505o(59111);
            return false;
        }
        AppMethodBeat.m2505o(59111);
        return true;
    }

    public final String getKey() {
        if (this.ybP == null) {
            return null;
        }
        return this.ybP.key;
    }

    public final String getPath() {
        AppMethodBeat.m2504i(59112);
        if (isOpen()) {
            String path = this.ybk.getPath();
            AppMethodBeat.m2505o(59112);
            return path;
        }
        C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
        AppMethodBeat.m2505o(59112);
        return null;
    }

    public static String escape(String str) {
        AppMethodBeat.m2504i(59113);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(59113);
            return str2;
        }
        str2 = DatabaseUtils.sqlEscapeString(str);
        AppMethodBeat.m2505o(59113);
        return str2;
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(59114);
        Cursor a = mo10105a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        AppMethodBeat.m2505o(59114);
        return a;
    }

    /* renamed from: a */
    public final Cursor mo10105a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        AppMethodBeat.m2504i(59115);
        Cursor a;
        if (isOpen()) {
            int doL;
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i2 = WXHardCoderJNI.hcDBDelayQuery;
            int i3 = WXHardCoderJNI.hcDBCPU;
            int i4 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = C1720g.m3539RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
            C1358c.begin();
            try {
                a = this.ybk.mo14613a(str, strArr, str2, strArr2, str3, str4, str5, i);
                C1358c.m2912a(str, a, this.jsG);
                return a;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 10, 1, false);
                C4990ab.m7412e(this.TAG, "execSQL Error :" + e.getMessage());
                C1358c.m2913k(e);
                a = C6394d.dvo();
                return a;
            } finally {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59115);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            a = C6394d.dvo();
            AppMethodBeat.m2505o(59115);
            return a;
        }
    }

    /* renamed from: a */
    public final Cursor mo10104a(final String str, String[] strArr, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(59116);
        Assert.assertTrue("sql is null ", !C5046bo.isNullOrNil(str));
        final Cursor a;
        if (isOpen()) {
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i3 = WXHardCoderJNI.hcDBDelayQuery;
            int i4 = WXHardCoderJNI.hcDBCPU;
            int i5 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                i2 = C1720g.m3539RS().doL();
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
            C1358c.begin();
            try {
                a = this.ybk.mo14612a(str, strArr, i);
                if (C4872b.dnM() || C4872b.dnO()) {
                    if (this.ybU == null) {
                        HandlerThread anM = C7305d.anM("CheckCursor");
                        anM.start();
                        this.ybU = new C7306ak(anM.getLooper());
                    }
                    final C1365c c1365c = new C1365c();
                    this.ybU.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(59100);
                            try {
                                long anU = C5046bo.anU();
                                if (a == null || a.isClosed()) {
                                    AppMethodBeat.m2505o(59100);
                                    return;
                                }
                                int intValue;
                                String str;
                                String className;
                                HashMap hashMap = new HashMap();
                                int i = 0;
                                C1365c c1365c = null;
                                synchronized (C7480h.this.ybT) {
                                    Pair pair;
                                    C1365c c1365c2;
                                    int i2;
                                    Iterator it = C7480h.this.ybT.iterator();
                                    while (it.hasNext()) {
                                        C1364b c1364b = (C1364b) it.next();
                                        Cursor cursor = c1364b == null ? null : (Cursor) c1364b.ybY.get();
                                        if (cursor == null || cursor.isClosed()) {
                                            it.remove();
                                        } else {
                                            Pair pair2;
                                            if ((anU - c1364b.lastReportTime) / 1000 > 100) {
                                                c1364b.lastReportTime = anU;
                                                if (!c1364b.ycb) {
                                                    C4990ab.m7421w(C7480h.this.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(anU - c1364b.yca), Integer.valueOf(c1364b.ybY.hashCode()), c1364b.ybZ, Boolean.valueOf(c1364b.ycb), c1364b.ycc);
                                                } else if (TextUtils.isEmpty(c1364b.ycc)) {
                                                    C4990ab.m7421w(C7480h.this.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(anU - c1364b.yca), Integer.valueOf(c1364b.ybY.hashCode()), c1364b.ybZ, Boolean.valueOf(c1364b.ycb), c1364b.ycc);
                                                } else {
                                                    C4990ab.m7421w(C7480h.this.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(anU - c1364b.yca), Integer.valueOf(c1364b.ybY.hashCode()), c1364b.ybZ, Boolean.valueOf(c1364b.ycb), c1364b.ycc);
                                                }
                                            }
                                            pair = (Pair) hashMap.get(c1364b.ybZ);
                                            if (pair == null) {
                                                pair = new Pair(Integer.valueOf(anU - c1364b.yca > 30000 ? 1 : 0), c1364b);
                                                hashMap.put(c1364b.ybZ, pair);
                                                pair2 = pair;
                                            } else if (anU - c1364b.yca > 30000) {
                                                Pair pair3 = new Pair(Integer.valueOf(((Integer) pair.first).intValue() + 1), pair.second);
                                                hashMap.put(c1364b.ybZ, pair3);
                                                pair2 = pair3;
                                            } else {
                                                pair2 = pair;
                                            }
                                            if (i < ((Integer) pair2.first).intValue()) {
                                                intValue = ((Integer) pair2.first).intValue();
                                                c1365c2 = ((C1364b) pair2.second).ycd;
                                            } else {
                                                c1365c2 = c1365c;
                                                intValue = i;
                                            }
                                            c1365c = c1365c2;
                                            i = intValue;
                                        }
                                    }
                                    C4990ab.m7411d(C7480h.this.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", Integer.valueOf(i), Integer.valueOf(C7480h.this.ybT.size()), Integer.valueOf(hashMap.size()));
                                    if (C4872b.dnM()) {
                                        i2 = 20;
                                    } else {
                                        i2 = 50;
                                    }
                                    if (i <= i2) {
                                        if (C7480h.this.ybT.size() <= (C4872b.dnM() ? 50 : 100)) {
                                        }
                                    }
                                    str = "";
                                    for (String className2 : hashMap.keySet()) {
                                        pair = (Pair) hashMap.get(className2);
                                        str = str + className2 + "," + pair.first + "," + ((C1364b) pair.second).ycb + "," + ((C1364b) pair.second).ycc + ";";
                                    }
                                    if (c1365c != null) {
                                        c1365c2 = new C1365c(str);
                                        c1365c2.setStackTrace(c1365c.getStackTrace());
                                        AppMethodBeat.m2505o(59100);
                                        throw c1365c2;
                                    }
                                    AssertionError assertionError = new AssertionError(str);
                                    AppMethodBeat.m2505o(59100);
                                    throw assertionError;
                                }
                                long anU2 = C5046bo.anU();
                                C1364b c1364b2 = new C1364b();
                                c1364b2.ybY = new WeakReference(a);
                                c1364b2.table = str;
                                c1364b2.yca = anU;
                                c1364b2.ybZ = "";
                                c1364b2.ycb = true;
                                c1364b2.ycd = c1365c;
                                StackTraceElement[] stackTrace = c1365c.getStackTrace();
                                for (intValue = 0; intValue < stackTrace.length; intValue++) {
                                    Object obj;
                                    className2 = stackTrace[intValue].getClassName();
                                    String methodName = stackTrace[intValue].getMethodName();
                                    str = className2.replace("com.tencent.mm.", "") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + methodName + "(" + stackTrace[intValue].getLineNumber() + ")";
                                    Class cls = Class.forName(className2);
                                    try {
                                        obj = cls.getDeclaredField("field_MARK_CURSOR_CHECK_IGNORE") != null ? 1 : null;
                                    } catch (Exception e) {
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        if (!TextUtils.isEmpty(c1364b2.ybZ)) {
                                            if (!c1364b2.ycb) {
                                                break;
                                            }
                                            className2 = str.toLowerCase();
                                            if (className2.contains("cursor") || className2.contains("adapter")) {
                                                c1364b2.ycc = str;
                                            }
                                        } else {
                                            c1364b2.ybZ = str;
                                            boolean z = false;
                                            for (Method method : cls.getMethods()) {
                                                if (method.getName().equals(methodName)) {
                                                    z = method.getReturnType().getName().contains(".Cursor");
                                                    if (z) {
                                                        break;
                                                    }
                                                }
                                            }
                                            c1364b2.ycb = z;
                                        }
                                    }
                                }
                                if (TextUtils.isEmpty(c1364b2.ybZ)) {
                                    c1364b2.ybZ = C5007an.stackTraceToString(stackTrace);
                                }
                                synchronized (C7480h.this.ybT) {
                                    C7480h.this.ybT.add(c1364b2);
                                }
                                C4990ab.m7411d(C7480h.this.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", Long.valueOf(anU2 - anU), Long.valueOf(C5046bo.m7566gb(anU)), c1364b2.ybZ, Boolean.valueOf(c1364b2.ycb), c1364b2.ycc);
                                AppMethodBeat.m2505o(59100);
                            } catch (Exception e2) {
                                C4990ab.m7413e(C7480h.this.TAG, "checkCursor table:[%s] e:%s[%s]", str, e2.getMessage(), C5046bo.m7574l(e2));
                                AppMethodBeat.m2505o(59100);
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(59100);
                                throw th;
                            }
                        }
                    }, 500);
                }
                C1358c.m2912a(str, a, this.jsG);
                return a;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 10, 1, false);
                C4990ab.m7412e(this.TAG, "execSQL Error :" + e.getMessage());
                C1358c.m2913k(e);
                a = C6394d.dvo();
                return a;
            } finally {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59116);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            a = C6394d.dvo();
            AppMethodBeat.m2505o(59116);
            return a;
        }
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.m2504i(139013);
        Cursor a = mo10104a(str, strArr, 0);
        AppMethodBeat.m2505o(139013);
        return a;
    }

    /* renamed from: a */
    public final boolean mo16658a(String str, String str2, String str3, List<String> list, ExecuteSqlCallback executeSqlCallback) {
        AppMethodBeat.m2504i(59118);
        if (isOpen()) {
            boolean doRecoveryDb = DBDumpUtil.doRecoveryDb(this.ybk.ybt, str, str2, str3, list, null, executeSqlCallback, true);
            AppMethodBeat.m2505o(59118);
            return doRecoveryDb;
        }
        C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
        AppMethodBeat.m2505o(59118);
        return false;
    }

    public final long getPageSize() {
        AppMethodBeat.m2504i(59119);
        long pageSize = this.ybk.ybt.getPageSize();
        AppMethodBeat.m2505o(59119);
        return pageSize;
    }

    public final C6395f dvw() {
        return this.ybk;
    }

    public final SQLiteDatabase dvx() {
        C6395f c6395f = this.ybk;
        if (c6395f.ybt != null) {
            return c6395f.ybt;
        }
        return c6395f.ybu;
    }

    /* renamed from: hY */
    public final boolean mo10108hY(String str, String str2) {
        AppMethodBeat.m2504i(59120);
        Assert.assertTrue("sql is null ", !C5046bo.isNullOrNil(str2));
        if (isOpen()) {
            int doL;
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i = WXHardCoderJNI.hcDBDelayWrite;
            int i2 = WXHardCoderJNI.hcDBCPU;
            int i3 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = C1720g.m3539RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            C1358c.begin();
            try {
                this.ybk.execSQL(str2);
                C1358c.m2912a(str2, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59120);
                return true;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 11, 1, false);
                String message = e.getMessage();
                C4990ab.m7412e(this.TAG, "execSQL Error :".concat(String.valueOf(message)));
                if (message == null || !message.contains("no such table")) {
                    C1358c.m2913k(e);
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                    AppMethodBeat.m2505o(59120);
                    return false;
                }
                C4990ab.m7411d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", this.ybP.ybl);
                C5730e.deleteFile(r1.ybl);
                if (this.ybR != null) {
                    this.ybR.mo4751RI();
                }
                AppMethodBeat.m2505o(59120);
                throw e;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59120);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            AppMethodBeat.m2505o(59120);
            return false;
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.m2504i(59121);
        long a = mo16656a(str, str2, contentValues, false);
        AppMethodBeat.m2505o(59121);
        return a;
    }

    /* renamed from: a */
    public final long mo16656a(String str, String str2, ContentValues contentValues, boolean z) {
        AppMethodBeat.m2504i(59122);
        if (isOpen()) {
            int doL;
            boolean z2 = WXHardCoderJNI.hcDBEnable;
            int i = WXHardCoderJNI.hcDBDelayWrite;
            int i2 = WXHardCoderJNI.hcDBCPU;
            int i3 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = C1720g.m3539RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z2, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            C1358c.begin();
            try {
                long insert = this.ybk.insert(str, str2, contentValues);
                C1358c.m2912a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59122);
                return insert;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 11, 1, false);
                C4990ab.m7412e(this.TAG, "insert Error :" + e.getMessage());
                C1358c.m2913k(e);
                if (z) {
                    AppMethodBeat.m2505o(59122);
                    throw e;
                }
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59122);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59122);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            AppMethodBeat.m2505o(59122);
            return -2;
        }
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.m2504i(59123);
        if (isOpen()) {
            int doL;
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i = WXHardCoderJNI.hcDBDelayWrite;
            int i2 = WXHardCoderJNI.hcDBCPU;
            int i3 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = C1720g.m3539RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            C1358c.begin();
            try {
                int update = this.ybk.update(str, contentValues, str2, strArr);
                C1358c.m2912a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59123);
                return update;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 11, 1, false);
                C4990ab.m7412e(this.TAG, "update Error :" + e.getMessage());
                C1358c.m2913k(e);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59123);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59123);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            AppMethodBeat.m2505o(59123);
            return -2;
        }
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        int i = 0;
        AppMethodBeat.m2504i(59124);
        if (isOpen()) {
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i2 = WXHardCoderJNI.hcDBDelayWrite;
            int i3 = WXHardCoderJNI.hcDBCPU;
            int i4 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                i = C1720g.m3539RS().doL();
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            C1358c.begin();
            try {
                long replace = this.ybk.replace(str, str2, contentValues);
                C1358c.m2912a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59124);
                return replace;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 11, 1, false);
                C4990ab.m7412e(this.TAG, "repalce  Error :" + e.getMessage());
                C1358c.m2913k(e);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59124);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59124);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            AppMethodBeat.m2505o(59124);
            return -2;
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        int i = 0;
        AppMethodBeat.m2504i(59125);
        if (isOpen()) {
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i2 = WXHardCoderJNI.hcDBDelayWrite;
            int i3 = WXHardCoderJNI.hcDBCPU;
            int i4 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                i = C1720g.m3539RS().doL();
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            C1358c.begin();
            try {
                int delete = this.ybk.delete(str, str2, strArr);
                C1358c.m2912a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59125);
                return delete;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 11, 1, false);
                C4990ab.m7412e(this.TAG, "delete Error :" + e.getMessage());
                C1358c.m2913k(e);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59125);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.m2505o(59125);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            AppMethodBeat.m2505o(59125);
            return -2;
        }
    }

    public final boolean aqx(String str) {
        AppMethodBeat.m2504i(59126);
        if (isOpen()) {
            try {
                this.ybk.execSQL("DROP TABLE ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(59126);
            } catch (Exception e) {
                C7053e.pXa.mo8378a(181, 11, 1, false);
                C4990ab.m7412e(this.TAG, "drop table Error :" + e.getMessage());
                C1358c.m2913k(e);
                AppMethodBeat.m2505o(59126);
            }
        } else {
            C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
            AppMethodBeat.m2505o(59126);
        }
        return false;
    }

    /* renamed from: iV */
    public final synchronized long mo15639iV(long j) {
        long j2 = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(59127);
            C4990ab.m7417i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", Long.valueOf(j), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(this.jsG), Boolean.valueOf(isOpen()));
            if (!isOpen()) {
                C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
                j2 = -4;
                AppMethodBeat.m2505o(59127);
            } else if (this.jsG > 0) {
                C4990ab.m7412e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.jsG);
                AppMethodBeat.m2505o(59127);
            } else if (C5004al.isMainThread() || j != -1) {
                try {
                    C1358c.begin();
                    this.ybk.beginTransaction();
                    C1358c.m2912a("beginTrans", null, 0);
                    this.jsG = C5046bo.anU() & 2147483647L;
                    this.jsG |= (r2 & 2147483647L) << 32;
                    if (this.ybO != null) {
                        this.ybO.mo4748RG();
                    }
                    j2 = this.jsG;
                    AppMethodBeat.m2505o(59127);
                } catch (Exception e) {
                    C7053e.pXa.mo8378a(181, 8, 1, false);
                    C4990ab.m7412e(this.TAG, "beginTransaction Error :" + e.getMessage());
                    C1358c.m2913k(e);
                    j2 = -3;
                    AppMethodBeat.m2505o(59127);
                }
            } else {
                C4990ab.m7413e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j), Long.valueOf(r2));
                j2 = -2;
                AppMethodBeat.m2505o(59127);
            }
        }
        return j2;
    }

    /* renamed from: mB */
    public final synchronized int mo15640mB(long j) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(59128);
            long anU = C5046bo.anU();
            C4990ab.m7417i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(j), Long.valueOf(this.jsG), Boolean.valueOf(isOpen()));
            if (!isOpen()) {
                C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
                i = -4;
                AppMethodBeat.m2505o(59128);
            } else if (j != this.jsG) {
                C4990ab.m7412e(this.TAG, "ERROR endTransaction ticket:" + j + " transactionTicket:" + this.jsG);
                i = -1;
                AppMethodBeat.m2505o(59128);
            } else {
                if (((j >> 32) & 2147483647L) != r4) {
                    C4990ab.m7413e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j), Long.valueOf((j >> 32) & 2147483647L), Long.valueOf(r4));
                    i = -2;
                    AppMethodBeat.m2505o(59128);
                } else {
                    try {
                        C1358c.begin();
                        this.ybk.endTransaction();
                        C4990ab.m7417i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", Long.valueOf(C5046bo.m7566gb(anU)), Long.valueOf(r4), Long.valueOf(j), Long.valueOf(this.jsG), Boolean.valueOf(isOpen()));
                        C1358c.m2912a("endTrans", null, 0);
                        this.jsG = 0;
                        if (this.ybO != null) {
                            this.ybO.mo4749RH();
                        }
                        AppMethodBeat.m2505o(59128);
                    } catch (Exception e) {
                        C4990ab.m7412e(this.TAG, "endTransaction Error :" + e.getMessage());
                        C7053e.pXa.mo8378a(181, 9, 1, false);
                        C1358c.m2913k(e);
                        i = -3;
                        AppMethodBeat.m2505o(59128);
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(59129);
            if (!isOpen()) {
                C4990ab.m7413e(this.TAG, "DB IS CLOSED ! {%s}", C5046bo.dpG());
                AppMethodBeat.m2505o(59129);
            } else if (this.jsG > 0) {
                AppMethodBeat.m2505o(59129);
                z = true;
            } else {
                AppMethodBeat.m2505o(59129);
            }
        }
        return z;
    }
}
