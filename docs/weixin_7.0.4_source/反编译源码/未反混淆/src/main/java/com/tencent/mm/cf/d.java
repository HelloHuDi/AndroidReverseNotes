package com.tencent.mm.cf;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d implements EventListener {
    static ak fbD = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(76904);
            ab.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", Integer.valueOf(message.what));
            if (message.what == 0) {
                d.ydG.b((a) message.obj);
            } else if (message.what != 1) {
                d.a(d.ydG, (a) message.obj);
            } else if (d.ydG.ydM != null) {
                b bVar = (b) d.ydG.ydM.get();
                if (bVar != null) {
                    bVar.dvX();
                }
            }
            super.handleMessage(message);
            AppMethodBeat.o(76904);
        }
    };
    public static a ydB = null;
    public static d ydG;
    private static int ydH = 5242880;
    public static final String ydJ = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    private volatile boolean fPO;
    private volatile boolean ydI;
    private LinkedBlockingQueue<a> ydK;
    ExecutorService ydL;
    public WeakReference<b> ydM;

    public interface b {
        void dvX();
    }

    public static final class a {
        int cPw;
        String className;
        String savePath;
        int ydP;
        int ydQ;

        public a(String str, int i, int i2, int i3) {
            AppMethodBeat.i(76906);
            this.className = str;
            this.cPw = i;
            this.ydP = i2;
            this.ydQ = i3;
            StringBuilder stringBuilder = new StringBuilder();
            if (bo.isNullOrNil(str)) {
                stringBuilder.append(d.ydJ).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
            } else {
                StringBuilder append = stringBuilder.append(d.ydJ).append(str).append("_");
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
            ab.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", stringBuilder.toString(), Integer.valueOf(i2));
            this.savePath = stringBuilder.toString();
            AppMethodBeat.o(76906);
        }
    }

    static /* synthetic */ String ac(File file) {
        AppMethodBeat.i(76917);
        String ab = ab(file);
        AppMethodBeat.o(76917);
        return ab;
    }

    static {
        AppMethodBeat.i(76920);
        AppMethodBeat.o(76920);
    }

    public static d dvV() {
        AppMethodBeat.i(76907);
        if (ydG == null) {
            ydG = new d();
        }
        d dVar = ydG;
        AppMethodBeat.o(76907);
        return dVar;
    }

    private void a(a aVar) {
        AppMethodBeat.i(76908);
        if (this.ydI) {
            AppMethodBeat.o(76908);
        } else if (c.Mn()) {
            dvW();
            try {
                File file = new File(ydJ);
                if (aVar.cPw != 6 && file.exists()) {
                    ab.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                    aa(file);
                }
                file.mkdirs();
                Debug.startMethodTracing(aVar.savePath, aVar.ydP <= 0 ? ydH : (aVar.ydP * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.ydI = true;
            } catch (IncompatibleClassChangeError e) {
                ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                AppMethodBeat.o(76908);
                throw e2;
            } catch (Throwable th) {
                this.ydI = false;
                ab.printErrStackTrace("MicroMsg.TraceDebugManager", th, "TRACE startMethodTracing ERROR", new Object[0]);
            }
            if (aVar.cPw == 6) {
                ab.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                AppMethodBeat.o(76908);
            } else if (this.ydI) {
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = aVar;
                if (bo.isNullOrNil(aVar.className) || aVar.cPw == 5) {
                    fbD.sendMessageDelayed(obtain, 15000);
                    AppMethodBeat.o(76908);
                    return;
                }
                fbD.sendMessageDelayed(obtain, 10000);
                AppMethodBeat.o(76908);
            } else {
                AppMethodBeat.o(76908);
            }
        } else {
            ab.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
            AppMethodBeat.o(76908);
        }
    }

    private static void dvW() {
        AppMethodBeat.i(76909);
        fbD.removeMessages(0);
        fbD.removeMessages(2);
        fbD.removeMessages(1);
        AppMethodBeat.o(76909);
    }

    private static void aa(File file) {
        AppMethodBeat.i(76910);
        if (file.isFile()) {
            file.delete();
            AppMethodBeat.o(76910);
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                AppMethodBeat.o(76910);
                return;
            }
            for (File aa : listFiles) {
                aa(aa);
            }
            file.delete();
        }
        AppMethodBeat.o(76910);
    }

    public final boolean b(final a aVar) {
        AppMethodBeat.i(76911);
        dvW();
        if (!this.ydI || this.fPO) {
            ab.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", Boolean.valueOf(this.ydI), Boolean.valueOf(this.fPO));
            AppMethodBeat.o(76911);
            return false;
        } else if (c.Mn()) {
            this.ydL.execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(76903);
                    try {
                        Debug.stopMethodTracing();
                        String str = aVar.savePath;
                        int i = aVar.ydQ;
                        if (aVar.savePath == null) {
                            d.this.ydI = false;
                            AppMethodBeat.o(76903);
                            return;
                        }
                        File file = new File(str);
                        File file2 = new File(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
                        long currentTimeMillis = System.currentTimeMillis();
                        file.renameTo(file2);
                        file.delete();
                        ab.i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
                        Process.setThreadPriority(10);
                        if (aVar.cPw == 6) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(file2);
                            try {
                                q.a(arrayList, new File(file2.getAbsolutePath() + ".zip"));
                                d.fbD.sendEmptyMessage(1);
                                d.this.ydI = false;
                                AppMethodBeat.o(76903);
                                return;
                            } catch (Exception e) {
                                ab.e("MicroMsg.TraceDebugManager", "exception:%s", bo.l(e));
                                ab.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
                                d.this.ydI = false;
                                AppMethodBeat.o(76903);
                                return;
                            }
                        }
                        if (d.this.ydK == null || d.this.ydK.size() == 0) {
                            str = d.ac(file2);
                            if (!bo.isNullOrNil(str)) {
                                d dVar = d.this;
                                if (i == 1 || (i == 3 && at.isWifi(ah.getContext()))) {
                                    dVar.aqA(str);
                                }
                            }
                        }
                        d.this.ydI = false;
                        AppMethodBeat.o(76903);
                    } catch (IncompatibleClassChangeError e2) {
                        ab.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        IncompatibleClassChangeError e22 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e22);
                        AppMethodBeat.o(76903);
                        throw e22;
                    } catch (Throwable th) {
                        d.this.ydI = false;
                        AppMethodBeat.o(76903);
                    }
                }
            });
            AppMethodBeat.o(76911);
            return true;
        } else {
            ab.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            AppMethodBeat.o(76911);
            return false;
        }
    }

    private static String ab(File file) {
        AppMethodBeat.i(76912);
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            ab.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                ab.e("MicroMsg.TraceDebugManager", " get file list failed");
                AppMethodBeat.o(76912);
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(file);
        }
        File file2 = new File(ydJ + bo.anU() + ".zip");
        try {
            q.a(arrayList, file2);
            for (int i = 0; i < arrayList.size(); i++) {
                ((File) arrayList.get(i)).delete();
            }
            if (file2.length() > 3145728) {
                ab.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", Long.valueOf(file2.length()));
                AppMethodBeat.o(76912);
                return null;
            }
            String absolutePath = file2.getAbsolutePath();
            AppMethodBeat.o(76912);
            return absolutePath;
        } catch (Exception e) {
            ab.e("MicroMsg.TraceDebugManager", "exception:%s", bo.l(e));
            ab.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e.getMessage());
            AppMethodBeat.o(76912);
            return null;
        }
    }

    private d() {
    }

    public final void ev(String str, int i) {
        AppMethodBeat.i(76913);
        if (this.ydK != null && this.ydK.size() > 0) {
            ab.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", Boolean.valueOf(this.fPO), Boolean.valueOf(this.ydI), str, Integer.valueOf(i));
            if (!(this.fPO || this.ydI)) {
                Iterator it = this.ydK.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.className == null) {
                        a(null);
                        this.ydK.remove(aVar);
                        AppMethodBeat.o(76913);
                        return;
                    } else if (aVar.className.equals(str) && aVar.cPw == i) {
                        a(aVar);
                        this.ydK.remove(aVar);
                        AppMethodBeat.o(76913);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(76913);
    }

    /* Access modifiers changed, original: final */
    public final void aqA(String str) {
        AppMethodBeat.i(76914);
        if (str == null) {
            AppMethodBeat.o(76914);
            return;
        }
        this.fPO = true;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", str);
        } else if (c.Mn()) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    str = ab(file);
                }
                if (str != null && new File(str).length() >= 131072) {
                    if (ydB == null) {
                        ab.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
                    } else {
                        ab.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", Boolean.valueOf(ydB.UC(str)));
                        if (ydB.UC(str)) {
                            e.t(new File(ydJ));
                        }
                    }
                }
            } else {
                ab.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
            }
        } else {
            ab.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
        }
        this.fPO = false;
        AppMethodBeat.o(76914);
    }

    public final void c(a aVar) {
        AppMethodBeat.i(76915);
        if (aVar.cPw <= 0) {
            AppMethodBeat.o(76915);
            return;
        }
        if (this.ydL == null) {
            this.ydL = Executors.newSingleThreadExecutor();
        }
        if (this.fPO || this.ydI) {
            ab.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", Boolean.valueOf(this.fPO), Boolean.valueOf(this.ydI));
            AppMethodBeat.o(76915);
            return;
        }
        fbD.removeMessages(0);
        if (aVar.ydQ == 4 || aVar.ydQ == 5) {
            ML(aVar.ydQ);
        } else if (aVar.cPw == 6 || aVar.cPw == 5) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = aVar;
            if (aVar.cPw == 5) {
                fbD.sendMessage(obtain);
            } else {
                fbD.sendMessageDelayed(obtain, 500);
            }
        } else {
            if (this.ydK == null) {
                this.ydK = new LinkedBlockingQueue();
            }
            this.ydK.clear();
            this.ydK.add(aVar);
        }
        ab.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", aVar.className, Integer.valueOf(aVar.cPw), Integer.valueOf(aVar.ydQ));
        AppMethodBeat.o(76915);
    }

    private void ML(final int i) {
        AppMethodBeat.i(76916);
        this.ydL.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76905);
                d.a(d.this, i == 4 ? "/data/anr/" : d.ydJ);
                AppMethodBeat.o(76905);
            }
        });
        AppMethodBeat.o(76916);
    }
}
