package com.tencent.mm.plugin.normsg.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.b.b.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class a implements g {
    public static final a<String> oTR;
    private long oTS;
    private long oTT;
    private long oTU;
    private long oTV;
    private long oTW;
    private int oTX;
    private boolean oTY;
    private long oTZ;

    public static final class a<T> extends HashSet<T> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean add(T t) {
            AppMethodBeat.i(10361);
            if (contains(t)) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(10361);
                throw unsupportedOperationException;
            }
            boolean add = super.add(t);
            AppMethodBeat.o(10361);
            return add;
        }

        public final boolean addAll(Collection collection) {
            AppMethodBeat.i(10362);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(10362);
            throw unsupportedOperationException;
        }

        public final void clear() {
            AppMethodBeat.i(10363);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(10363);
            throw unsupportedOperationException;
        }

        public final boolean remove(Object obj) {
            AppMethodBeat.i(10364);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(10364);
            throw unsupportedOperationException;
        }

        public final boolean removeAll(Collection<?> collection) {
            AppMethodBeat.i(10365);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(10365);
            throw unsupportedOperationException;
        }
    }

    public static final class c {
        private c() {
        }

        public static boolean isEnabled() {
            AppMethodBeat.i(10367);
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(d.TQ("Úà¯ßºÔ"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(a.fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.o(10367);
                    return false;
                }
                AppMethodBeat.o(10367);
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(a.fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.o(10367);
                    return false;
                }
                AppMethodBeat.o(10367);
                return true;
            }
        }

        static boolean bVZ() {
            AppMethodBeat.i(10368);
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(d.TQ("Þä¦Ê¡ã¡"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(a.fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.o(10368);
                    return false;
                }
                AppMethodBeat.o(10368);
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(a.fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.o(10368);
                    return false;
                }
                AppMethodBeat.o(10368);
                return true;
            }
        }

        public static int bWa() {
            Throwable th;
            AppMethodBeat.i(10369);
            StringBuilder stringBuilder = new StringBuilder();
            int hashCode;
            String stringBuilder2;
            int hashCode2;
            try {
                stringBuilder.append(d.TQ("S\u0000D\u000fF(\\\tK"));
                hashCode = (c.class.hashCode() >>> 31) | 1;
                stringBuilder2 = stringBuilder.toString();
                if (hashCode != 0) {
                    try {
                        hashCode2 = ((c.class.hashCode() >>> 31) | 1) ^ 1;
                        try {
                            stringBuilder.delete(0, stringBuilder.length());
                            stringBuilder.append(hashCode2);
                            hashCode = bo.getInt(a.fw(stringBuilder2, stringBuilder.toString()), hashCode2);
                            AppMethodBeat.o(10369);
                            return hashCode;
                        } catch (Throwable th2) {
                            th = th2;
                            stringBuilder.append(hashCode2);
                            AppMethodBeat.o(10369);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        hashCode2 = hashCode;
                        stringBuilder.append(hashCode2);
                        AppMethodBeat.o(10369);
                        throw th;
                    }
                }
                AppMethodBeat.o(10369);
                return hashCode;
            } catch (Throwable th22) {
                th = th22;
                stringBuilder.append(hashCode2);
                AppMethodBeat.o(10369);
                throw th;
            }
        }

        static boolean bWb() {
            AppMethodBeat.i(10370);
            StringBuilder stringBuilder = new StringBuilder();
            String stringBuilder2;
            try {
                stringBuilder.append(d.TQ("Àú¿ÑÄ"));
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(a.fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.o(10370);
                    return false;
                }
                AppMethodBeat.o(10370);
                return true;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder.toString().equals(a.fw(stringBuilder2, stringBuilder.toString()))) {
                    AppMethodBeat.o(10370);
                    return false;
                }
                AppMethodBeat.o(10370);
                return true;
            }
        }
    }

    static final class b {
        static final a oUa = new a();

        static {
            AppMethodBeat.i(10366);
            AppMethodBeat.o(10366);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    static /* synthetic */ String fw(String str, String str2) {
        AppMethodBeat.i(10387);
        String fv = fv(str, str2);
        AppMethodBeat.o(10387);
        return fv;
    }

    static {
        AppMethodBeat.i(10388);
        a aVar = new a();
        oTR = aVar;
        aVar.add("");
        oTR.add(":tools");
        oTR.add(":toolsmp");
        oTR.add(":appbrand0");
        oTR.add(":appbrand1");
        oTR.add(":appbrand2");
        oTR.add(":appbrand3");
        oTR.add(":appbrand4");
        AppMethodBeat.o(10388);
    }

    public static a bVT() {
        return b.oUa;
    }

    private a() {
        AppMethodBeat.i(10371);
        this.oTS = 0;
        this.oTT = 0;
        this.oTU = 0;
        this.oTV = 0;
        this.oTW = 0;
        this.oTX = 0;
        this.oTY = false;
        this.oTZ = 0;
        bVW();
        AppMethodBeat.o(10371);
    }

    public final synchronized void Ao(int i) {
        this.oTX = i;
    }

    public final void a(int i, View view, List<AccessibilityNodeInfo> list) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(10372);
        String view2 = view != null ? view.toString() : "";
        String Ap = Ap(i);
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
        ab.i(str, str2, objArr);
        if (list != null) {
            i2 = list.size();
        }
        cL(Ap, i2);
        if (c.bVZ() && Ap != null && Ap.contains(d.TQ(">\u0010r\u001bc\u0001xV")) && list != null) {
            list.clear();
        }
        AppMethodBeat.o(10372);
    }

    public final boolean a(int i, int i2, View view) {
        AppMethodBeat.i(10373);
        String view2 = view != null ? view.toString() : "";
        String Ap = Ap(i2);
        ab.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", Integer.valueOf(i2), Ap, view2, Integer.valueOf(i));
        e(i, view);
        z(i, Ap, view2);
        if (c.bVZ() && Ap != null && Ap.contains(d.TQ(">\u0010r\u001bc\u0001xV"))) {
            AppMethodBeat.o(10373);
            return false;
        }
        AppMethodBeat.o(10373);
        return true;
    }

    public final void onError(Throwable th) {
        AppMethodBeat.i(10374);
        ab.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] unexpected error happens.", new Object[0]);
        j(th);
        AppMethodBeat.o(10374);
    }

    public final synchronized long bVU() {
        long j;
        AppMethodBeat.i(10375);
        j = this.oTW;
        bVV();
        AppMethodBeat.o(10375);
        return j;
    }

    private synchronized void bVV() {
        AppMethodBeat.i(10376);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oTV >= 259200000) {
            this.oTW = 0;
            this.oTV = currentTimeMillis;
            bVX();
        }
        AppMethodBeat.o(10376);
    }

    private synchronized void bVW() {
        Throwable th;
        AppMethodBeat.i(10377);
        Closeable dataInputStream;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(ah.getContext().getCacheDir(), d.TQ("ãçÜºÈ­Üòù")))));
            try {
                if (((long) dataInputStream.readInt()) != -606158847) {
                    IllegalStateException illegalStateException = new IllegalStateException("bad magic.");
                    AppMethodBeat.o(10377);
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
                bo.b(dataInputStream);
                AppMethodBeat.o(10377);
            } catch (Throwable th2) {
                th = th2;
                try {
                    ab.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to load rec.", new Object[0]);
                    this.oTS = 0;
                    this.oTT = 0;
                    this.oTU = 0;
                    this.oTV = System.currentTimeMillis();
                    this.oTW = 0;
                    bVX();
                    bo.b(dataInputStream);
                    AppMethodBeat.o(10377);
                } catch (Throwable th3) {
                    th = th3;
                    bo.b(dataInputStream);
                    AppMethodBeat.o(10377);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            bo.b(dataInputStream);
            AppMethodBeat.o(10377);
            throw th;
        }
    }

    private synchronized void bVX() {
        Throwable th;
        AppMethodBeat.i(10378);
        Closeable dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(ah.getContext().getCacheDir(), d.TQ("ãçÜºÈ­Üòù")))));
            try {
                dataOutputStream.writeInt(-606158847);
                dataOutputStream.writeLong(this.oTS);
                dataOutputStream.writeLong(this.oTT);
                dataOutputStream.writeLong(this.oTU);
                dataOutputStream.writeLong(this.oTV);
                dataOutputStream.writeLong(this.oTW);
                bo.b(dataOutputStream);
                AppMethodBeat.o(10378);
            } catch (Throwable th2) {
                th = th2;
                try {
                    ab.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to save rec.", new Object[0]);
                    bo.b(dataOutputStream);
                    AppMethodBeat.o(10378);
                } catch (Throwable th3) {
                    th = th3;
                    bo.b(dataOutputStream);
                    AppMethodBeat.o(10378);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            bo.b(dataOutputStream);
            AppMethodBeat.o(10378);
            throw th;
        }
    }

    private synchronized void e(int i, View view) {
        AppMethodBeat.i(10379);
        if (view == null) {
            AppMethodBeat.o(10379);
        } else if (i != 16) {
            AppMethodBeat.o(10379);
        } else {
            synchronized (this) {
                try {
                    int i2 = this.oTX;
                    if (i2 == 0) {
                        AppMethodBeat.o(i2);
                    } else {
                        if ((view instanceof Button) && view.getId() == this.oTX) {
                            this.oTW++;
                            bVX();
                        }
                        AppMethodBeat.o(10379);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10379);
                }
            }
        }
    }

    private synchronized void cL(String str, int i) {
        AppMethodBeat.i(10380);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oTS > 86400000) {
            h.pYm.g("Normsg_AED", "findview, pkg: " + str + ", res_count: " + i, null);
            this.oTS = currentTimeMillis;
            bVX();
        }
        if (com.tencent.mm.compatible.util.h.Ms() && c.bWb()) {
            bVY();
        }
        AppMethodBeat.o(10380);
    }

    private synchronized void z(int i, String str, String str2) {
        AppMethodBeat.i(10381);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oTT > 86400000) {
            h.pYm.g("Normsg_AED", "action: " + i + ", pkg: " + str + ", view: " + str2, null);
            this.oTT = currentTimeMillis;
            bVX();
        }
        if (com.tencent.mm.compatible.util.h.Ms() && c.bWb()) {
            bVY();
        }
        AppMethodBeat.o(10381);
    }

    private synchronized void bVY() {
        AppMethodBeat.i(10382);
        if (!this.oTY) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.oTZ < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                AppMethodBeat.o(10382);
            } else {
                this.oTZ = currentTimeMillis;
                this.oTY = true;
                d.qjp.Ch(-2147483647);
            }
        }
        AppMethodBeat.o(10382);
    }

    public final synchronized void j(Throwable th) {
        Throwable th2;
        Closeable closeable;
        AppMethodBeat.i(10383);
        if (th == null) {
            AppMethodBeat.o(10383);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.oTU > 86400000) {
                StringWriter stringWriter = new StringWriter();
                Closeable printWriter;
                try {
                    printWriter = new PrintWriter(stringWriter);
                    try {
                        th.printStackTrace(printWriter);
                        bo.b(printWriter);
                    } catch (Throwable th3) {
                        th2 = th3;
                        closeable = printWriter;
                        bo.b(closeable);
                        AppMethodBeat.o(10383);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    closeable = null;
                    bo.b(closeable);
                    AppMethodBeat.o(10383);
                    throw th2;
                }
                h.pYm.g("Normsg_AED_Errors", "error:" + stringWriter.toString(), null);
                this.oTU = currentTimeMillis;
                bVX();
            }
            AppMethodBeat.o(10383);
        }
    }

    private static String Ap(int i) {
        Throwable th;
        AppMethodBeat.i(10384);
        ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
        String str;
        if (activityManager == null) {
            str = "";
            AppMethodBeat.o(10384);
            return str;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        str = runningAppProcessInfo.processName;
                        AppMethodBeat.o(10384);
                        return str;
                    }
                }
            }
        } catch (Throwable th2) {
            ab.printErrStackTrace("MircoMsg.AEDHLP", th2, "[tomys] failure on step1.", new Object[0]);
        }
        try {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(16384);
            if (runningServices != null) {
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == i) {
                        str = runningServiceInfo.process;
                        AppMethodBeat.o(10384);
                        return str;
                    }
                }
            }
        } catch (Throwable th3) {
            ab.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step2.", new Object[0]);
        }
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, d.TQ("ÃìîâÍè£À­É¥Ì¢Ç"), new Object[]{Integer.valueOf(i)})));
            try {
                str = bufferedReader.readLine();
                if (str != null) {
                    str = str.trim();
                    bo.b(bufferedReader);
                    AppMethodBeat.o(10384);
                    return str;
                }
                bo.b(bufferedReader);
                str = "";
                AppMethodBeat.o(10384);
                return str;
            } catch (Throwable th4) {
                th3 = th4;
                try {
                    ab.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step3.", new Object[0]);
                    bo.b(bufferedReader);
                    str = "";
                    AppMethodBeat.o(10384);
                    return str;
                } catch (Throwable th5) {
                    th3 = th5;
                    closeable = bufferedReader;
                    bo.b(closeable);
                    AppMethodBeat.o(10384);
                    throw th3;
                }
            }
        } catch (Throwable th6) {
            th3 = th6;
            bo.b(closeable);
            AppMethodBeat.o(10384);
            throw th3;
        }
    }

    public static String TS(String str) {
        AppMethodBeat.i(10385);
        int indexOf = str.indexOf(58);
        String substring;
        if (indexOf != -1) {
            substring = str.substring(indexOf);
            AppMethodBeat.o(10385);
            return substring;
        }
        substring = "";
        AppMethodBeat.o(10385);
        return substring;
    }

    private static String fv(String str, String str2) {
        AppMethodBeat.i(10386);
        try {
            com.tencent.mm.kernel.g.RN().QU();
            try {
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
                com.tencent.mm.storage.c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100373");
                if (ll == null || !ll.isValid()) {
                    ab.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
                    AppMethodBeat.o(10386);
                    return str2;
                }
                Map dru = ll.dru();
                if (dru == null) {
                    ab.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
                    AppMethodBeat.o(10386);
                    return str2;
                }
                String str3 = (String) dru.get(str);
                if (str3 == null || str3.length() <= 0) {
                    AppMethodBeat.o(10386);
                    return str2;
                }
                AppMethodBeat.o(10386);
                return str3;
            } catch (com.tencent.mm.model.b e) {
                ab.printErrStackTrace("MircoMsg.AEDHLP", e, "check point 1-1, explained by src code.", new Object[0]);
                AppMethodBeat.o(10386);
                return str2;
            }
        } catch (com.tencent.mm.model.b e2) {
            ab.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
            AppMethodBeat.o(10386);
            return str2;
        }
    }
}
