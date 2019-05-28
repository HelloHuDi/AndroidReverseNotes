package com.tencent.p177mm.p215cf;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C8900q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.tencent.mm.cf.d */
public final class C37634d implements EventListener {
    static C7306ak fbD = new C376332();
    public static C26007a ydB = null;
    public static C37634d ydG;
    private static int ydH = 5242880;
    public static final String ydJ = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    private volatile boolean fPO;
    private volatile boolean ydI;
    private LinkedBlockingQueue<C37636a> ydK;
    ExecutorService ydL;
    public WeakReference<C1371b> ydM;

    /* renamed from: com.tencent.mm.cf.d$b */
    public interface C1371b {
        void dvX();
    }

    /* renamed from: com.tencent.mm.cf.d$2 */
    static class C376332 extends C7306ak {
        C376332() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(76904);
            C4990ab.m7417i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", Integer.valueOf(message.what));
            if (message.what == 0) {
                C37634d.ydG.mo60466b((C37636a) message.obj);
            } else if (message.what != 1) {
                C37634d.m63575a(C37634d.ydG, (C37636a) message.obj);
            } else if (C37634d.ydG.ydM != null) {
                C1371b c1371b = (C1371b) C37634d.ydG.ydM.get();
                if (c1371b != null) {
                    c1371b.dvX();
                }
            }
            super.handleMessage(message);
            AppMethodBeat.m2505o(76904);
        }
    }

    /* renamed from: com.tencent.mm.cf.d$a */
    public static final class C37636a {
        int cPw;
        String className;
        String savePath;
        int ydP;
        int ydQ;

        public C37636a(String str, int i, int i2, int i3) {
            AppMethodBeat.m2504i(76906);
            this.className = str;
            this.cPw = i;
            this.ydP = i2;
            this.ydQ = i3;
            StringBuilder stringBuilder = new StringBuilder();
            if (C5046bo.isNullOrNil(str)) {
                stringBuilder.append(C37634d.ydJ).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
            } else {
                StringBuilder append = stringBuilder.append(C37634d.ydJ).append(str).append("_");
                String str2 = "";
                switch (i) {
                    case 1:
                        str2 = "onResume";
                        break;
                    case 2:
                        str2 = "onPause";
                        break;
                    case 3:
                        str2 = "onCreate";
                        break;
                    case 4:
                        str2 = "onScrool";
                        break;
                    case 5:
                        str2 = "all";
                        break;
                }
                append.append(str2).append(".trace");
            }
            C4990ab.m7417i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", stringBuilder.toString(), Integer.valueOf(i2));
            this.savePath = stringBuilder.toString();
            AppMethodBeat.m2505o(76906);
        }
    }

    /* renamed from: ac */
    static /* synthetic */ String m63579ac(File file) {
        AppMethodBeat.m2504i(76917);
        String ab = C37634d.m63578ab(file);
        AppMethodBeat.m2505o(76917);
        return ab;
    }

    static {
        AppMethodBeat.m2504i(76920);
        AppMethodBeat.m2505o(76920);
    }

    public static C37634d dvV() {
        AppMethodBeat.m2504i(76907);
        if (ydG == null) {
            ydG = new C37634d();
        }
        C37634d c37634d = ydG;
        AppMethodBeat.m2505o(76907);
        return c37634d;
    }

    /* renamed from: a */
    private void m63574a(C37636a c37636a) {
        AppMethodBeat.m2504i(76908);
        if (this.ydI) {
            AppMethodBeat.m2505o(76908);
        } else if (C45279c.m83488Mn()) {
            C37634d.dvW();
            try {
                File file = new File(ydJ);
                if (c37636a.cPw != 6 && file.exists()) {
                    C4990ab.m7416i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                    C37634d.m63577aa(file);
                }
                file.mkdirs();
                Debug.startMethodTracing(c37636a.savePath, c37636a.ydP <= 0 ? ydH : (c37636a.ydP * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.ydI = true;
            } catch (IncompatibleClassChangeError e) {
                C4990ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                AppMethodBeat.m2505o(76908);
                throw e2;
            } catch (Throwable th) {
                this.ydI = false;
                C4990ab.printErrStackTrace("MicroMsg.TraceDebugManager", th, "TRACE startMethodTracing ERROR", new Object[0]);
            }
            if (c37636a.cPw == 6) {
                C4990ab.m7416i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                AppMethodBeat.m2505o(76908);
            } else if (this.ydI) {
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = c37636a;
                if (C5046bo.isNullOrNil(c37636a.className) || c37636a.cPw == 5) {
                    fbD.sendMessageDelayed(obtain, 15000);
                    AppMethodBeat.m2505o(76908);
                    return;
                }
                fbD.sendMessageDelayed(obtain, 10000);
                AppMethodBeat.m2505o(76908);
            } else {
                AppMethodBeat.m2505o(76908);
            }
        } else {
            C4990ab.m7416i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
            AppMethodBeat.m2505o(76908);
        }
    }

    private static void dvW() {
        AppMethodBeat.m2504i(76909);
        fbD.removeMessages(0);
        fbD.removeMessages(2);
        fbD.removeMessages(1);
        AppMethodBeat.m2505o(76909);
    }

    /* renamed from: aa */
    private static void m63577aa(File file) {
        AppMethodBeat.m2504i(76910);
        if (file.isFile()) {
            file.delete();
            AppMethodBeat.m2505o(76910);
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                AppMethodBeat.m2505o(76910);
                return;
            }
            for (File aa : listFiles) {
                C37634d.m63577aa(aa);
            }
            file.delete();
        }
        AppMethodBeat.m2505o(76910);
    }

    /* renamed from: b */
    public final boolean mo60466b(final C37636a c37636a) {
        AppMethodBeat.m2504i(76911);
        C37634d.dvW();
        if (!this.ydI || this.fPO) {
            C4990ab.m7417i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", Boolean.valueOf(this.ydI), Boolean.valueOf(this.fPO));
            AppMethodBeat.m2505o(76911);
            return false;
        } else if (C45279c.m83488Mn()) {
            this.ydL.execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(76903);
                    try {
                        Debug.stopMethodTracing();
                        String str = c37636a.savePath;
                        int i = c37636a.ydQ;
                        if (c37636a.savePath == null) {
                            C37634d.this.ydI = false;
                            AppMethodBeat.m2505o(76903);
                            return;
                        }
                        File file = new File(str);
                        File file2 = new File(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
                        long currentTimeMillis = System.currentTimeMillis();
                        file.renameTo(file2);
                        file.delete();
                        C4990ab.m7416i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
                        Process.setThreadPriority(10);
                        if (c37636a.cPw == 6) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(file2);
                            try {
                                C8900q.m16037a(arrayList, new File(file2.getAbsolutePath() + ".zip"));
                                C37634d.fbD.sendEmptyMessage(1);
                                C37634d.this.ydI = false;
                                AppMethodBeat.m2505o(76903);
                                return;
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.TraceDebugManager", "exception:%s", C5046bo.m7574l(e));
                                C4990ab.m7413e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
                                C37634d.this.ydI = false;
                                AppMethodBeat.m2505o(76903);
                                return;
                            }
                        }
                        if (C37634d.this.ydK == null || C37634d.this.ydK.size() == 0) {
                            str = C37634d.m63579ac(file2);
                            if (!C5046bo.isNullOrNil(str)) {
                                C37634d c37634d = C37634d.this;
                                if (i == 1 || (i == 3 && C5023at.isWifi(C4996ah.getContext()))) {
                                    c37634d.aqA(str);
                                }
                            }
                        }
                        C37634d.this.ydI = false;
                        AppMethodBeat.m2505o(76903);
                    } catch (IncompatibleClassChangeError e2) {
                        C4990ab.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        IncompatibleClassChangeError e22 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e22);
                        AppMethodBeat.m2505o(76903);
                        throw e22;
                    } catch (Throwable th) {
                        C37634d.this.ydI = false;
                        AppMethodBeat.m2505o(76903);
                    }
                }
            });
            AppMethodBeat.m2505o(76911);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            AppMethodBeat.m2505o(76911);
            return false;
        }
    }

    /* renamed from: ab */
    private static String m63578ab(File file) {
        AppMethodBeat.m2504i(76912);
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            C4990ab.m7416i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                C4990ab.m7412e("MicroMsg.TraceDebugManager", " get file list failed");
                AppMethodBeat.m2505o(76912);
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(file);
        }
        File file2 = new File(ydJ + C5046bo.anU() + ".zip");
        try {
            C8900q.m16037a(arrayList, file2);
            for (int i = 0; i < arrayList.size(); i++) {
                ((File) arrayList.get(i)).delete();
            }
            if (file2.length() > 3145728) {
                C4990ab.m7413e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", Long.valueOf(file2.length()));
                AppMethodBeat.m2505o(76912);
                return null;
            }
            String absolutePath = file2.getAbsolutePath();
            AppMethodBeat.m2505o(76912);
            return absolutePath;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.TraceDebugManager", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
            AppMethodBeat.m2505o(76912);
            return null;
        }
    }

    private C37634d() {
    }

    /* renamed from: ev */
    public final void mo60468ev(String str, int i) {
        AppMethodBeat.m2504i(76913);
        if (this.ydK != null && this.ydK.size() > 0) {
            C4990ab.m7417i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", Boolean.valueOf(this.fPO), Boolean.valueOf(this.ydI), str, Integer.valueOf(i));
            if (!(this.fPO || this.ydI)) {
                Iterator it = this.ydK.iterator();
                while (it.hasNext()) {
                    C37636a c37636a = (C37636a) it.next();
                    if (c37636a.className == null) {
                        m63574a(null);
                        this.ydK.remove(c37636a);
                        AppMethodBeat.m2505o(76913);
                        return;
                    } else if (c37636a.className.equals(str) && c37636a.cPw == i) {
                        m63574a(c37636a);
                        this.ydK.remove(c37636a);
                        AppMethodBeat.m2505o(76913);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(76913);
    }

    /* Access modifiers changed, original: final */
    public final void aqA(String str) {
        AppMethodBeat.m2504i(76914);
        if (str == null) {
            AppMethodBeat.m2505o(76914);
            return;
        }
        this.fPO = true;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", str);
        } else if (C45279c.m83488Mn()) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    str = C37634d.m63578ab(file);
                }
                if (str != null && new File(str).length() >= 131072) {
                    if (ydB == null) {
                        C4990ab.m7412e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
                    } else {
                        C4990ab.m7417i("MicroMsg.TraceDebugManager", "TRACE upload : %b", Boolean.valueOf(ydB.mo43886UC(str)));
                        if (ydB.mo43886UC(str)) {
                            C1173e.m2575t(new File(ydJ));
                        }
                    }
                }
            } else {
                C4990ab.m7412e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
            }
        } else {
            C4990ab.m7412e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
        }
        this.fPO = false;
        AppMethodBeat.m2505o(76914);
    }

    /* renamed from: c */
    public final void mo60467c(C37636a c37636a) {
        AppMethodBeat.m2504i(76915);
        if (c37636a.cPw <= 0) {
            AppMethodBeat.m2505o(76915);
            return;
        }
        if (this.ydL == null) {
            this.ydL = Executors.newSingleThreadExecutor();
        }
        if (this.fPO || this.ydI) {
            C4990ab.m7417i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", Boolean.valueOf(this.fPO), Boolean.valueOf(this.ydI));
            AppMethodBeat.m2505o(76915);
            return;
        }
        fbD.removeMessages(0);
        if (c37636a.ydQ == 4 || c37636a.ydQ == 5) {
            m63572ML(c37636a.ydQ);
        } else if (c37636a.cPw == 6 || c37636a.cPw == 5) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = c37636a;
            if (c37636a.cPw == 5) {
                fbD.sendMessage(obtain);
            } else {
                fbD.sendMessageDelayed(obtain, 500);
            }
        } else {
            if (this.ydK == null) {
                this.ydK = new LinkedBlockingQueue();
            }
            this.ydK.clear();
            this.ydK.add(c37636a);
        }
        C4990ab.m7417i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", c37636a.className, Integer.valueOf(c37636a.cPw), Integer.valueOf(c37636a.ydQ));
        AppMethodBeat.m2505o(76915);
    }

    /* renamed from: ML */
    private void m63572ML(final int i) {
        AppMethodBeat.m2504i(76916);
        this.ydL.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(76905);
                C37634d.m63576a(C37634d.this, i == 4 ? "/data/anr/" : C37634d.ydJ);
                AppMethodBeat.m2505o(76905);
            }
        });
        AppMethodBeat.m2505o(76916);
    }
}
