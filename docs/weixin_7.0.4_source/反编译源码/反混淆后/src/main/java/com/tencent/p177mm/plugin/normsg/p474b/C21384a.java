package com.tencent.p177mm.plugin.normsg.p474b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.plugin.normsg.p474b.C28614b.C28613g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C44761d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.normsg.b.a */
public final class C21384a implements C28613g {
    public static final C21385a<String> oTR;
    private long oTS;
    private long oTT;
    private long oTU;
    private long oTV;
    private long oTW;
    private int oTX;
    private boolean oTY;
    private long oTZ;

    /* renamed from: com.tencent.mm.plugin.normsg.b.a$a */
    public static final class C21385a<T> extends HashSet<T> {
        private C21385a() {
        }

        /* synthetic */ C21385a(byte b) {
            this();
        }

        public final boolean add(T t) {
            AppMethodBeat.m2504i(10361);
            if (contains(t)) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(10361);
                throw unsupportedOperationException;
            }
            boolean add = super.add(t);
            AppMethodBeat.m2505o(10361);
            return add;
        }

        public final boolean addAll(Collection collection) {
            AppMethodBeat.m2504i(10362);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(10362);
            throw unsupportedOperationException;
        }

        public final void clear() {
            AppMethodBeat.m2504i(10363);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(10363);
            throw unsupportedOperationException;
        }

        public final boolean remove(Object obj) {
            AppMethodBeat.m2504i(10364);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(10364);
            throw unsupportedOperationException;
        }

        public final boolean removeAll(Collection<?> collection) {
            AppMethodBeat.m2504i(10365);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(10365);
            throw unsupportedOperationException;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.a$c */
    public static final class C21386c {
        private C21386c() {
        }

        public static boolean isEnabled() {
            AppMethodBeat.m2504i(10367);
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(C21394d.m32815TQ("Úà¯ßºÔ"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((C21386c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(C21384a.m32808fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.m2505o(10367);
                    return false;
                }
                AppMethodBeat.m2505o(10367);
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((C21386c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(C21384a.m32808fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.m2505o(10367);
                    return false;
                }
                AppMethodBeat.m2505o(10367);
                return true;
            }
        }

        static boolean bVZ() {
            AppMethodBeat.m2504i(10368);
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(C21394d.m32815TQ("Þä¦Ê¡ã¡"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((C21386c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(C21384a.m32808fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.m2505o(10368);
                    return false;
                }
                AppMethodBeat.m2505o(10368);
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((C21386c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(C21384a.m32808fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.m2505o(10368);
                    return false;
                }
                AppMethodBeat.m2505o(10368);
                return true;
            }
        }

        public static int bWa() {
            Throwable th;
            AppMethodBeat.m2504i(10369);
            StringBuilder stringBuilder = new StringBuilder();
            int hashCode;
            String stringBuilder2;
            int hashCode2;
            try {
                stringBuilder.append(C21394d.m32815TQ("S\u0000D\u000fF(\\\tK"));
                hashCode = (C21386c.class.hashCode() >>> 31) | 1;
                stringBuilder2 = stringBuilder.toString();
                if (hashCode != 0) {
                    try {
                        hashCode2 = ((C21386c.class.hashCode() >>> 31) | 1) ^ 1;
                        try {
                            stringBuilder.delete(0, stringBuilder.length());
                            stringBuilder.append(hashCode2);
                            hashCode = C5046bo.getInt(C21384a.m32808fw(stringBuilder2, stringBuilder.toString()), hashCode2);
                            AppMethodBeat.m2505o(10369);
                            return hashCode;
                        } catch (Throwable th2) {
                            th = th2;
                            stringBuilder.append(hashCode2);
                            AppMethodBeat.m2505o(10369);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        hashCode2 = hashCode;
                        stringBuilder.append(hashCode2);
                        AppMethodBeat.m2505o(10369);
                        throw th;
                    }
                }
                AppMethodBeat.m2505o(10369);
                return hashCode;
            } catch (Throwable th22) {
                th = th22;
                stringBuilder.append(hashCode2);
                AppMethodBeat.m2505o(10369);
                throw th;
            }
        }

        static boolean bWb() {
            AppMethodBeat.m2504i(10370);
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(C21394d.m32815TQ("Àú¿ÑÄ"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((C21386c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(C21384a.m32808fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.m2505o(10370);
                    return false;
                }
                AppMethodBeat.m2505o(10370);
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((C21386c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(C21384a.m32808fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.m2505o(10370);
                    return false;
                }
                AppMethodBeat.m2505o(10370);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.a$b */
    static final class C21387b {
        static final C21384a oUa = new C21384a();

        static {
            AppMethodBeat.m2504i(10366);
            AppMethodBeat.m2505o(10366);
        }
    }

    /* synthetic */ C21384a(byte b) {
        this();
    }

    /* renamed from: fw */
    static /* synthetic */ String m32808fw(String str, String str2) {
        AppMethodBeat.m2504i(10387);
        String fv = C21384a.m32807fv(str, str2);
        AppMethodBeat.m2505o(10387);
        return fv;
    }

    static {
        AppMethodBeat.m2504i(10388);
        C21385a c21385a = new C21385a();
        oTR = c21385a;
        c21385a.add("");
        oTR.add(":tools");
        oTR.add(":toolsmp");
        oTR.add(":appbrand0");
        oTR.add(":appbrand1");
        oTR.add(":appbrand2");
        oTR.add(":appbrand3");
        oTR.add(":appbrand4");
        AppMethodBeat.m2505o(10388);
    }

    public static C21384a bVT() {
        return C21387b.oUa;
    }

    private C21384a() {
        AppMethodBeat.m2504i(10371);
        this.oTS = 0;
        this.oTT = 0;
        this.oTU = 0;
        this.oTV = 0;
        this.oTW = 0;
        this.oTX = 0;
        this.oTY = false;
        this.oTZ = 0;
        bVW();
        AppMethodBeat.m2505o(10371);
    }

    /* renamed from: Ao */
    public final synchronized void mo36839Ao(int i) {
        this.oTX = i;
    }

    /* renamed from: a */
    public final void mo36840a(int i, View view, List<AccessibilityNodeInfo> list) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.m2504i(10372);
        String view2 = view != null ? view.toString() : "";
        String Ap = C21384a.m32803Ap(i);
        String str = "MircoMsg.AEDHLP";
        String str2 = "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Ap;
        objArr[2] = view2;
        if (list == null || list.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (list != null) {
            i2 = list.size();
        }
        m32805cL(Ap, i2);
        if (C21386c.bVZ() && Ap != null && Ap.contains(C21394d.m32815TQ(">\u0010r\u001bc\u0001xV")) && list != null) {
            list.clear();
        }
        AppMethodBeat.m2505o(10372);
    }

    /* renamed from: a */
    public final boolean mo36841a(int i, int i2, View view) {
        AppMethodBeat.m2504i(10373);
        String view2 = view != null ? view.toString() : "";
        String Ap = C21384a.m32803Ap(i2);
        C4990ab.m7417i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", Integer.valueOf(i2), Ap, view2, Integer.valueOf(i));
        m32806e(i, view);
        m32809z(i, Ap, view2);
        if (C21386c.bVZ() && Ap != null && Ap.contains(C21394d.m32815TQ(">\u0010r\u001bc\u0001xV"))) {
            AppMethodBeat.m2505o(10373);
            return false;
        }
        AppMethodBeat.m2505o(10373);
        return true;
    }

    public final void onError(Throwable th) {
        AppMethodBeat.m2504i(10374);
        C4990ab.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] unexpected error happens.", new Object[0]);
        mo36843j(th);
        AppMethodBeat.m2505o(10374);
    }

    public final synchronized long bVU() {
        long j;
        AppMethodBeat.m2504i(10375);
        j = this.oTW;
        bVV();
        AppMethodBeat.m2505o(10375);
        return j;
    }

    private synchronized void bVV() {
        AppMethodBeat.m2504i(10376);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oTV >= 259200000) {
            this.oTW = 0;
            this.oTV = currentTimeMillis;
            bVX();
        }
        AppMethodBeat.m2505o(10376);
    }

    private synchronized void bVW() {
        Throwable th;
        AppMethodBeat.m2504i(10377);
        Closeable dataInputStream;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(C4996ah.getContext().getCacheDir(), C21394d.m32815TQ("ãçÜºÈ­Üòù")))));
            try {
                if (((long) dataInputStream.readInt()) != -606158847) {
                    IllegalStateException illegalStateException = new IllegalStateException("bad magic.");
                    AppMethodBeat.m2505o(10377);
                    throw illegalStateException;
                }
                this.oTS = dataInputStream.readLong();
                this.oTT = dataInputStream.readLong();
                this.oTU = dataInputStream.readLong();
                this.oTV = dataInputStream.readLong();
                long readLong = dataInputStream.readLong();
                if (readLong > 0 && this.oTW <= 0) {
                    this.oTW = readLong;
                }
                C5046bo.m7527b(dataInputStream);
                AppMethodBeat.m2505o(10377);
            } catch (Throwable th2) {
                th = th2;
                try {
                    C4990ab.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to load rec.", new Object[0]);
                    this.oTS = 0;
                    this.oTT = 0;
                    this.oTU = 0;
                    this.oTV = System.currentTimeMillis();
                    this.oTW = 0;
                    bVX();
                    C5046bo.m7527b(dataInputStream);
                    AppMethodBeat.m2505o(10377);
                } catch (Throwable th3) {
                    th = th3;
                    C5046bo.m7527b(dataInputStream);
                    AppMethodBeat.m2505o(10377);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            C5046bo.m7527b(dataInputStream);
            AppMethodBeat.m2505o(10377);
            throw th;
        }
    }

    private synchronized void bVX() {
        Throwable th;
        AppMethodBeat.m2504i(10378);
        Closeable dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(C4996ah.getContext().getCacheDir(), C21394d.m32815TQ("ãçÜºÈ­Üòù")))));
            try {
                dataOutputStream.writeInt(-606158847);
                dataOutputStream.writeLong(this.oTS);
                dataOutputStream.writeLong(this.oTT);
                dataOutputStream.writeLong(this.oTU);
                dataOutputStream.writeLong(this.oTV);
                dataOutputStream.writeLong(this.oTW);
                C5046bo.m7527b(dataOutputStream);
                AppMethodBeat.m2505o(10378);
            } catch (Throwable th2) {
                th = th2;
                try {
                    C4990ab.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to save rec.", new Object[0]);
                    C5046bo.m7527b(dataOutputStream);
                    AppMethodBeat.m2505o(10378);
                } catch (Throwable th3) {
                    th = th3;
                    C5046bo.m7527b(dataOutputStream);
                    AppMethodBeat.m2505o(10378);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            C5046bo.m7527b(dataOutputStream);
            AppMethodBeat.m2505o(10378);
            throw th;
        }
    }

    /* renamed from: e */
    private synchronized void m32806e(int i, View view) {
        AppMethodBeat.m2504i(10379);
        if (view == null) {
            AppMethodBeat.m2505o(10379);
        } else if (i != 16) {
            AppMethodBeat.m2505o(10379);
        } else {
            synchronized (this) {
                try {
                    int i2 = this.oTX;
                    if (i2 == 0) {
                        AppMethodBeat.m2505o(i2);
                    } else {
                        if ((view instanceof Button) && view.getId() == this.oTX) {
                            this.oTW++;
                            bVX();
                        }
                        AppMethodBeat.m2505o(10379);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10379);
                }
            }
        }
    }

    /* renamed from: cL */
    private synchronized void m32805cL(String str, int i) {
        AppMethodBeat.m2504i(10380);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oTS > 86400000) {
            C7060h.pYm.mo8382g("Normsg_AED", "findview, pkg: " + str + ", res_count: " + i, null);
            this.oTS = currentTimeMillis;
            bVX();
        }
        if (C1448h.m3076Ms() && C21386c.bWb()) {
            bVY();
        }
        AppMethodBeat.m2505o(10380);
    }

    /* renamed from: z */
    private synchronized void m32809z(int i, String str, String str2) {
        AppMethodBeat.m2504i(10381);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oTT > 86400000) {
            C7060h.pYm.mo8382g("Normsg_AED", "action: " + i + ", pkg: " + str + ", view: " + str2, null);
            this.oTT = currentTimeMillis;
            bVX();
        }
        if (C1448h.m3076Ms() && C21386c.bWb()) {
            bVY();
        }
        AppMethodBeat.m2505o(10381);
    }

    private synchronized void bVY() {
        AppMethodBeat.m2504i(10382);
        if (!this.oTY) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.oTZ < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                AppMethodBeat.m2505o(10382);
            } else {
                this.oTZ = currentTimeMillis;
                this.oTY = true;
                C44761d.qjp.mo8446Ch(-2147483647);
            }
        }
        AppMethodBeat.m2505o(10382);
    }

    /* renamed from: j */
    public final synchronized void mo36843j(Throwable th) {
        Throwable th2;
        Closeable closeable;
        AppMethodBeat.m2504i(10383);
        if (th == null) {
            AppMethodBeat.m2505o(10383);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.oTU > 86400000) {
                StringWriter stringWriter = new StringWriter();
                Closeable printWriter;
                try {
                    printWriter = new PrintWriter(stringWriter);
                    try {
                        th.printStackTrace(printWriter);
                        C5046bo.m7527b(printWriter);
                    } catch (Throwable th3) {
                        th2 = th3;
                        closeable = printWriter;
                        C5046bo.m7527b(closeable);
                        AppMethodBeat.m2505o(10383);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    closeable = null;
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(10383);
                    throw th2;
                }
                C7060h.pYm.mo8382g("Normsg_AED_Errors", "error:" + stringWriter.toString(), null);
                this.oTU = currentTimeMillis;
                bVX();
            }
            AppMethodBeat.m2505o(10383);
        }
    }

    /* renamed from: Ap */
    private static String m32803Ap(int i) {
        Throwable th;
        AppMethodBeat.m2504i(10384);
        ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
        String str;
        if (activityManager == null) {
            str = "";
            AppMethodBeat.m2505o(10384);
            return str;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        str = runningAppProcessInfo.processName;
                        AppMethodBeat.m2505o(10384);
                        return str;
                    }
                }
            }
        } catch (Throwable th2) {
            C4990ab.printErrStackTrace("MircoMsg.AEDHLP", th2, "[tomys] failure on step1.", new Object[0]);
        }
        try {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(16384);
            if (runningServices != null) {
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == i) {
                        str = runningServiceInfo.process;
                        AppMethodBeat.m2505o(10384);
                        return str;
                    }
                }
            }
        } catch (Throwable th3) {
            C4990ab.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step2.", new Object[0]);
        }
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, C21394d.m32815TQ("ÃìîâÍè£À­É¥Ì¢Ç"), new Object[]{Integer.valueOf(i)})));
            try {
                str = bufferedReader.readLine();
                if (str != null) {
                    str = str.trim();
                    C5046bo.m7527b(bufferedReader);
                    AppMethodBeat.m2505o(10384);
                    return str;
                }
                C5046bo.m7527b(bufferedReader);
                str = "";
                AppMethodBeat.m2505o(10384);
                return str;
            } catch (Throwable th4) {
                th3 = th4;
                try {
                    C4990ab.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step3.", new Object[0]);
                    C5046bo.m7527b(bufferedReader);
                    str = "";
                    AppMethodBeat.m2505o(10384);
                    return str;
                } catch (Throwable th5) {
                    th3 = th5;
                    closeable = bufferedReader;
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(10384);
                    throw th3;
                }
            }
        } catch (Throwable th6) {
            th3 = th6;
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(10384);
            throw th3;
        }
    }

    /* renamed from: TS */
    public static String m32804TS(String str) {
        AppMethodBeat.m2504i(10385);
        int indexOf = str.indexOf(58);
        String substring;
        if (indexOf != -1) {
            substring = str.substring(indexOf);
            AppMethodBeat.m2505o(10385);
            return substring;
        }
        substring = "";
        AppMethodBeat.m2505o(10385);
        return substring;
    }

    /* renamed from: fv */
    private static String m32807fv(String str, String str2) {
        AppMethodBeat.m2504i(10386);
        try {
            C1720g.m3534RN().mo5159QU();
            try {
                C42142a c42142a = C32718b.eGM;
                C5141c ll = C42142a.m74295ll("100373");
                if (ll == null || !ll.isValid()) {
                    C4990ab.m7420w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
                    AppMethodBeat.m2505o(10386);
                    return str2;
                }
                Map dru = ll.dru();
                if (dru == null) {
                    C4990ab.m7420w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
                    AppMethodBeat.m2505o(10386);
                    return str2;
                }
                String str3 = (String) dru.get(str);
                if (str3 == null || str3.length() <= 0) {
                    AppMethodBeat.m2505o(10386);
                    return str2;
                }
                AppMethodBeat.m2505o(10386);
                return str3;
            } catch (C1819b e) {
                C4990ab.printErrStackTrace("MircoMsg.AEDHLP", e, "check point 1-1, explained by src code.", new Object[0]);
                AppMethodBeat.m2505o(10386);
                return str2;
            }
        } catch (C1819b e2) {
            C4990ab.m7420w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
            AppMethodBeat.m2505o(10386);
            return str2;
        }
    }
}
