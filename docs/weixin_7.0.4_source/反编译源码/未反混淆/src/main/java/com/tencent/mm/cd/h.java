package com.tencent.mm.cd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
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

public class h implements f {
    String TAG = "MicroMsg.SqliteDB";
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private long jsG = 0;
    private a ybO = null;
    public a ybP = new a();
    private String ybQ = "";
    public e ybR = null;
    public String ybS = "";
    final LinkedList<b> ybT = new LinkedList();
    private ak ybU = null;
    protected f ybk = null;

    public interface a {
        void RF();

        void RG();

        void RH();
    }

    public static class b {
        public long lastReportTime;
        public String table;
        public WeakReference<Cursor> ybY;
        public String ybZ;
        public long yca;
        public boolean ycb;
        public String ycc;
        public c ycd;
    }

    static class c extends AssertionError {
        c() {
        }

        c(String str) {
            super(str);
        }
    }

    public interface d {
        String[] Af();
    }

    public interface e {
        void RI();
    }

    public h(a aVar) {
        AppMethodBeat.i(59101);
        this.ybO = aVar;
        AppMethodBeat.o(59101);
    }

    public h() {
        AppMethodBeat.i(59102);
        AppMethodBeat.o(59102);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(59103);
        jC(null);
        AppMethodBeat.o(59103);
    }

    public void closeDB() {
        AppMethodBeat.i(59104);
        jC(null);
        AppMethodBeat.o(59104);
    }

    public void jC(String str) {
        AppMethodBeat.i(59105);
        if (this.ybk == null) {
            AppMethodBeat.o(59105);
            return;
        }
        if (this.ybO != null) {
            this.ybO.RF();
        }
        ab.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.jsG), Long.valueOf(Thread.currentThread().getId()), bo.dpG());
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (str != null) {
            this.ybQ = str;
        }
        this.ybk.close();
        this.ybk = null;
        ab.d(this.TAG, "end close db time:%d", Long.valueOf(aVar.Mr()));
        AppMethodBeat.o(59105);
    }

    public final boolean dpU() {
        AppMethodBeat.i(59106);
        if (this.ybk == null || !this.ybk.isOpen()) {
            AppMethodBeat.o(59106);
            return true;
        }
        AppMethodBeat.o(59106);
        return false;
    }

    private void aqw(String str) {
        AppMethodBeat.i(59107);
        String processName = ah.getProcessName();
        String packageName = ah.getPackageName();
        ab.i(this.TAG, "check process :[%s] [%s] path[%s]", processName, packageName, str);
        if (!(processName == null || packageName == null || packageName.equals(processName))) {
            Assert.assertTrue("processName:" + processName + "  packagename:" + packageName, false);
        }
        AppMethodBeat.o(59107);
    }

    public final boolean b(String str, HashMap<Integer, d> hashMap, boolean z) {
        AppMethodBeat.i(59108);
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        aqw(str);
        if (!this.ybP.a(str, (HashMap) hashMap, z) || this.ybP.ybk == null) {
            this.ybk = null;
            this.ybP = null;
            ab.e(this.TAG, "initDB failed.");
            AppMethodBeat.o(59108);
            return false;
        }
        this.ybk = this.ybP.ybk;
        ab.i(this.TAG, "SqliteDB db %s", this.ybk);
        AppMethodBeat.o(59108);
        return true;
    }

    public final boolean b(String str, String str2, String str3, long j, HashMap<Integer, d> hashMap, boolean z) {
        AppMethodBeat.i(59109);
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        aqw(str2);
        if (!this.ybP.a(str, str2, str3, j, hashMap, z) || this.ybP.ybk == null) {
            this.ybS = this.ybP.getError();
            this.ybk = null;
            this.ybP = null;
            ab.i(this.TAG, "initDB failed. %s", this.ybS);
            AppMethodBeat.o(59109);
            return false;
        }
        this.ybS = this.ybP.getError();
        this.ybk = this.ybP.ybk;
        AppMethodBeat.o(59109);
        return true;
    }

    public final boolean a(String str, String str2, long j, HashMap<Integer, d> hashMap) {
        AppMethodBeat.i(59110);
        boolean b = b(str, str2, "", j, hashMap, true);
        AppMethodBeat.o(59110);
        return b;
    }

    public final boolean isOpen() {
        AppMethodBeat.i(59111);
        if (this.ybk == null || !this.ybk.isOpen()) {
            Assert.assertTrue("DB has been closed :[" + this.ybQ + "]", bo.isNullOrNil(this.ybQ));
            AppMethodBeat.o(59111);
            return false;
        }
        AppMethodBeat.o(59111);
        return true;
    }

    public final String getKey() {
        if (this.ybP == null) {
            return null;
        }
        return this.ybP.key;
    }

    public final String getPath() {
        AppMethodBeat.i(59112);
        if (isOpen()) {
            String path = this.ybk.getPath();
            AppMethodBeat.o(59112);
            return path;
        }
        ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
        AppMethodBeat.o(59112);
        return null;
    }

    public static String escape(String str) {
        AppMethodBeat.i(59113);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(59113);
            return str2;
        }
        str2 = DatabaseUtils.sqlEscapeString(str);
        AppMethodBeat.o(59113);
        return str2;
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        AppMethodBeat.i(59114);
        Cursor a = a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        AppMethodBeat.o(59114);
        return a;
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        AppMethodBeat.i(59115);
        Cursor a;
        if (isOpen()) {
            int doL;
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i2 = WXHardCoderJNI.hcDBDelayQuery;
            int i3 = WXHardCoderJNI.hcDBCPU;
            int i4 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = g.RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            try {
                a = this.ybk.a(str, strArr, str2, strArr2, str3, str4, str5, i);
                c.a(str, a, this.jsG);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 10, 1, false);
                ab.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.k(e);
                a = d.dvo();
                return a;
            } finally {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59115);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            a = d.dvo();
            AppMethodBeat.o(59115);
            return a;
        }
    }

    public final Cursor a(final String str, String[] strArr, int i) {
        int i2 = 0;
        AppMethodBeat.i(59116);
        Assert.assertTrue("sql is null ", !bo.isNullOrNil(str));
        final Cursor a;
        if (isOpen()) {
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i3 = WXHardCoderJNI.hcDBDelayQuery;
            int i4 = WXHardCoderJNI.hcDBCPU;
            int i5 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                i2 = g.RS().doL();
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            try {
                a = this.ybk.a(str, strArr, i);
                if (com.tencent.mm.sdk.a.b.dnM() || com.tencent.mm.sdk.a.b.dnO()) {
                    if (this.ybU == null) {
                        HandlerThread anM = com.tencent.mm.sdk.g.d.anM("CheckCursor");
                        anM.start();
                        this.ybU = new ak(anM.getLooper());
                    }
                    final c cVar = new c();
                    this.ybU.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(59100);
                            try {
                                long anU = bo.anU();
                                if (a == null || a.isClosed()) {
                                    AppMethodBeat.o(59100);
                                    return;
                                }
                                int intValue;
                                String str;
                                String className;
                                HashMap hashMap = new HashMap();
                                int i = 0;
                                c cVar = null;
                                synchronized (h.this.ybT) {
                                    Pair pair;
                                    c cVar2;
                                    int i2;
                                    Iterator it = h.this.ybT.iterator();
                                    while (it.hasNext()) {
                                        b bVar = (b) it.next();
                                        Cursor cursor = bVar == null ? null : (Cursor) bVar.ybY.get();
                                        if (cursor == null || cursor.isClosed()) {
                                            it.remove();
                                        } else {
                                            Pair pair2;
                                            if ((anU - bVar.lastReportTime) / 1000 > 100) {
                                                bVar.lastReportTime = anU;
                                                if (!bVar.ycb) {
                                                    ab.w(h.this.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(anU - bVar.yca), Integer.valueOf(bVar.ybY.hashCode()), bVar.ybZ, Boolean.valueOf(bVar.ycb), bVar.ycc);
                                                } else if (TextUtils.isEmpty(bVar.ycc)) {
                                                    ab.w(h.this.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(anU - bVar.yca), Integer.valueOf(bVar.ybY.hashCode()), bVar.ybZ, Boolean.valueOf(bVar.ycb), bVar.ycc);
                                                } else {
                                                    ab.w(h.this.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(anU - bVar.yca), Integer.valueOf(bVar.ybY.hashCode()), bVar.ybZ, Boolean.valueOf(bVar.ycb), bVar.ycc);
                                                }
                                            }
                                            pair = (Pair) hashMap.get(bVar.ybZ);
                                            if (pair == null) {
                                                pair = new Pair(Integer.valueOf(anU - bVar.yca > 30000 ? 1 : 0), bVar);
                                                hashMap.put(bVar.ybZ, pair);
                                                pair2 = pair;
                                            } else if (anU - bVar.yca > 30000) {
                                                Pair pair3 = new Pair(Integer.valueOf(((Integer) pair.first).intValue() + 1), pair.second);
                                                hashMap.put(bVar.ybZ, pair3);
                                                pair2 = pair3;
                                            } else {
                                                pair2 = pair;
                                            }
                                            if (i < ((Integer) pair2.first).intValue()) {
                                                intValue = ((Integer) pair2.first).intValue();
                                                cVar2 = ((b) pair2.second).ycd;
                                            } else {
                                                cVar2 = cVar;
                                                intValue = i;
                                            }
                                            cVar = cVar2;
                                            i = intValue;
                                        }
                                    }
                                    ab.d(h.this.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", Integer.valueOf(i), Integer.valueOf(h.this.ybT.size()), Integer.valueOf(hashMap.size()));
                                    if (com.tencent.mm.sdk.a.b.dnM()) {
                                        i2 = 20;
                                    } else {
                                        i2 = 50;
                                    }
                                    if (i <= i2) {
                                        if (h.this.ybT.size() <= (com.tencent.mm.sdk.a.b.dnM() ? 50 : 100)) {
                                        }
                                    }
                                    str = "";
                                    for (String className2 : hashMap.keySet()) {
                                        pair = (Pair) hashMap.get(className2);
                                        str = str + className2 + "," + pair.first + "," + ((b) pair.second).ycb + "," + ((b) pair.second).ycc + ";";
                                    }
                                    if (cVar != null) {
                                        cVar2 = new c(str);
                                        cVar2.setStackTrace(cVar.getStackTrace());
                                        AppMethodBeat.o(59100);
                                        throw cVar2;
                                    }
                                    AssertionError assertionError = new AssertionError(str);
                                    AppMethodBeat.o(59100);
                                    throw assertionError;
                                }
                                long anU2 = bo.anU();
                                b bVar2 = new b();
                                bVar2.ybY = new WeakReference(a);
                                bVar2.table = str;
                                bVar2.yca = anU;
                                bVar2.ybZ = "";
                                bVar2.ycb = true;
                                bVar2.ycd = cVar;
                                StackTraceElement[] stackTrace = cVar.getStackTrace();
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
                                        if (!TextUtils.isEmpty(bVar2.ybZ)) {
                                            if (!bVar2.ycb) {
                                                break;
                                            }
                                            className2 = str.toLowerCase();
                                            if (className2.contains("cursor") || className2.contains("adapter")) {
                                                bVar2.ycc = str;
                                            }
                                        } else {
                                            bVar2.ybZ = str;
                                            boolean z = false;
                                            for (Method method : cls.getMethods()) {
                                                if (method.getName().equals(methodName)) {
                                                    z = method.getReturnType().getName().contains(".Cursor");
                                                    if (z) {
                                                        break;
                                                    }
                                                }
                                            }
                                            bVar2.ycb = z;
                                        }
                                    }
                                }
                                if (TextUtils.isEmpty(bVar2.ybZ)) {
                                    bVar2.ybZ = an.stackTraceToString(stackTrace);
                                }
                                synchronized (h.this.ybT) {
                                    h.this.ybT.add(bVar2);
                                }
                                ab.d(h.this.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", Long.valueOf(anU2 - anU), Long.valueOf(bo.gb(anU)), bVar2.ybZ, Boolean.valueOf(bVar2.ycb), bVar2.ycc);
                                AppMethodBeat.o(59100);
                            } catch (Exception e2) {
                                ab.e(h.this.TAG, "checkCursor table:[%s] e:%s[%s]", str, e2.getMessage(), bo.l(e2));
                                AppMethodBeat.o(59100);
                            } catch (Throwable th) {
                                AppMethodBeat.o(59100);
                                throw th;
                            }
                        }
                    }, 500);
                }
                c.a(str, a, this.jsG);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 10, 1, false);
                ab.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.k(e);
                a = d.dvo();
                return a;
            } finally {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59116);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            a = d.dvo();
            AppMethodBeat.o(59116);
            return a;
        }
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(139013);
        Cursor a = a(str, strArr, 0);
        AppMethodBeat.o(139013);
        return a;
    }

    public final boolean a(String str, String str2, String str3, List<String> list, ExecuteSqlCallback executeSqlCallback) {
        AppMethodBeat.i(59118);
        if (isOpen()) {
            boolean doRecoveryDb = DBDumpUtil.doRecoveryDb(this.ybk.ybt, str, str2, str3, list, null, executeSqlCallback, true);
            AppMethodBeat.o(59118);
            return doRecoveryDb;
        }
        ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
        AppMethodBeat.o(59118);
        return false;
    }

    public final long getPageSize() {
        AppMethodBeat.i(59119);
        long pageSize = this.ybk.ybt.getPageSize();
        AppMethodBeat.o(59119);
        return pageSize;
    }

    public final f dvw() {
        return this.ybk;
    }

    public final SQLiteDatabase dvx() {
        f fVar = this.ybk;
        if (fVar.ybt != null) {
            return fVar.ybt;
        }
        return fVar.ybu;
    }

    public final boolean hY(String str, String str2) {
        AppMethodBeat.i(59120);
        Assert.assertTrue("sql is null ", !bo.isNullOrNil(str2));
        if (isOpen()) {
            int doL;
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i = WXHardCoderJNI.hcDBDelayWrite;
            int i2 = WXHardCoderJNI.hcDBCPU;
            int i3 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = g.RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                this.ybk.execSQL(str2);
                c.a(str2, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59120);
                return true;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 11, 1, false);
                String message = e.getMessage();
                ab.e(this.TAG, "execSQL Error :".concat(String.valueOf(message)));
                if (message == null || !message.contains("no such table")) {
                    c.k(e);
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                    AppMethodBeat.o(59120);
                    return false;
                }
                ab.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", this.ybP.ybl);
                com.tencent.mm.vfs.e.deleteFile(r1.ybl);
                if (this.ybR != null) {
                    this.ybR.RI();
                }
                AppMethodBeat.o(59120);
                throw e;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59120);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            AppMethodBeat.o(59120);
            return false;
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(59121);
        long a = a(str, str2, contentValues, false);
        AppMethodBeat.o(59121);
        return a;
    }

    public final long a(String str, String str2, ContentValues contentValues, boolean z) {
        AppMethodBeat.i(59122);
        if (isOpen()) {
            int doL;
            boolean z2 = WXHardCoderJNI.hcDBEnable;
            int i = WXHardCoderJNI.hcDBDelayWrite;
            int i2 = WXHardCoderJNI.hcDBCPU;
            int i3 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = g.RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z2, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                long insert = this.ybk.insert(str, str2, contentValues);
                c.a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59122);
                return insert;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 11, 1, false);
                ab.e(this.TAG, "insert Error :" + e.getMessage());
                c.k(e);
                if (z) {
                    AppMethodBeat.o(59122);
                    throw e;
                }
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59122);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59122);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            AppMethodBeat.o(59122);
            return -2;
        }
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.i(59123);
        if (isOpen()) {
            int doL;
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i = WXHardCoderJNI.hcDBDelayWrite;
            int i2 = WXHardCoderJNI.hcDBCPU;
            int i3 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = g.RS().doL();
            } else {
                doL = 0;
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                int update = this.ybk.update(str, contentValues, str2, strArr);
                c.a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59123);
                return update;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 11, 1, false);
                ab.e(this.TAG, "update Error :" + e.getMessage());
                c.k(e);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59123);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59123);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            AppMethodBeat.o(59123);
            return -2;
        }
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        int i = 0;
        AppMethodBeat.i(59124);
        if (isOpen()) {
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i2 = WXHardCoderJNI.hcDBDelayWrite;
            int i3 = WXHardCoderJNI.hcDBCPU;
            int i4 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                i = g.RS().doL();
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                long replace = this.ybk.replace(str, str2, contentValues);
                c.a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59124);
                return replace;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 11, 1, false);
                ab.e(this.TAG, "repalce  Error :" + e.getMessage());
                c.k(e);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59124);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59124);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            AppMethodBeat.o(59124);
            return -2;
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        int i = 0;
        AppMethodBeat.i(59125);
        if (isOpen()) {
            boolean z = WXHardCoderJNI.hcDBEnable;
            int i2 = WXHardCoderJNI.hcDBDelayWrite;
            int i3 = WXHardCoderJNI.hcDBCPU;
            int i4 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                i = g.RS().doL();
            }
            int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                int delete = this.ybk.delete(str, str2, strArr);
                c.a(str, null, this.jsG);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59125);
                return delete;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 11, 1, false);
                ab.e(this.TAG, "delete Error :" + e.getMessage());
                c.k(e);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59125);
                return -1;
            } catch (Throwable th) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(59125);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            AppMethodBeat.o(59125);
            return -2;
        }
    }

    public final boolean aqx(String str) {
        AppMethodBeat.i(59126);
        if (isOpen()) {
            try {
                this.ybk.execSQL("DROP TABLE ".concat(String.valueOf(str)));
                AppMethodBeat.o(59126);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 11, 1, false);
                ab.e(this.TAG, "drop table Error :" + e.getMessage());
                c.k(e);
                AppMethodBeat.o(59126);
            }
        } else {
            ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
            AppMethodBeat.o(59126);
        }
        return false;
    }

    public final synchronized long iV(long j) {
        long j2 = -1;
        synchronized (this) {
            AppMethodBeat.i(59127);
            ab.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", Long.valueOf(j), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(this.jsG), Boolean.valueOf(isOpen()));
            if (!isOpen()) {
                ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
                j2 = -4;
                AppMethodBeat.o(59127);
            } else if (this.jsG > 0) {
                ab.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.jsG);
                AppMethodBeat.o(59127);
            } else if (al.isMainThread() || j != -1) {
                try {
                    c.begin();
                    this.ybk.beginTransaction();
                    c.a("beginTrans", null, 0);
                    this.jsG = bo.anU() & 2147483647L;
                    this.jsG |= (r2 & 2147483647L) << 32;
                    if (this.ybO != null) {
                        this.ybO.RG();
                    }
                    j2 = this.jsG;
                    AppMethodBeat.o(59127);
                } catch (Exception e) {
                    com.tencent.mm.plugin.report.e.pXa.a(181, 8, 1, false);
                    ab.e(this.TAG, "beginTransaction Error :" + e.getMessage());
                    c.k(e);
                    j2 = -3;
                    AppMethodBeat.o(59127);
                }
            } else {
                ab.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j), Long.valueOf(r2));
                j2 = -2;
                AppMethodBeat.o(59127);
            }
        }
        return j2;
    }

    public final synchronized int mB(long j) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(59128);
            long anU = bo.anU();
            ab.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(j), Long.valueOf(this.jsG), Boolean.valueOf(isOpen()));
            if (!isOpen()) {
                ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
                i = -4;
                AppMethodBeat.o(59128);
            } else if (j != this.jsG) {
                ab.e(this.TAG, "ERROR endTransaction ticket:" + j + " transactionTicket:" + this.jsG);
                i = -1;
                AppMethodBeat.o(59128);
            } else {
                if (((j >> 32) & 2147483647L) != r4) {
                    ab.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j), Long.valueOf((j >> 32) & 2147483647L), Long.valueOf(r4));
                    i = -2;
                    AppMethodBeat.o(59128);
                } else {
                    try {
                        c.begin();
                        this.ybk.endTransaction();
                        ab.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", Long.valueOf(bo.gb(anU)), Long.valueOf(r4), Long.valueOf(j), Long.valueOf(this.jsG), Boolean.valueOf(isOpen()));
                        c.a("endTrans", null, 0);
                        this.jsG = 0;
                        if (this.ybO != null) {
                            this.ybO.RH();
                        }
                        AppMethodBeat.o(59128);
                    } catch (Exception e) {
                        ab.e(this.TAG, "endTransaction Error :" + e.getMessage());
                        com.tencent.mm.plugin.report.e.pXa.a(181, 9, 1, false);
                        c.k(e);
                        i = -3;
                        AppMethodBeat.o(59128);
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(59129);
            if (!isOpen()) {
                ab.e(this.TAG, "DB IS CLOSED ! {%s}", bo.dpG());
                AppMethodBeat.o(59129);
            } else if (this.jsG > 0) {
                AppMethodBeat.o(59129);
                z = true;
            } else {
                AppMethodBeat.o(59129);
            }
        }
        return z;
    }
}
