package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class a implements com.tencent.mm.model.d.c.a {
    private static final String ceI;
    private static final String ceJ;
    public static String ceK = "";
    private static a foM;
    private static final String foN = (e.eSl + "/tencent/MicroMsg/Handler/");
    public static final String foO = (foN + "Handler.trace");
    private static final long foR = Looper.getMainLooper().getThread().getId();
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    long[] ceM;
    private SharedPreferences ehZ;
    private long foP;
    private volatile boolean foQ;
    private long foS;
    private long foT;
    private long foU;
    private long foV;
    private long foW;
    private long foX;
    private long foY;
    private int foZ;
    private int fpa;
    private int fpb;
    private Long[] fpc;
    public long fpd;
    private long fpe;
    private String fpf;
    private LinkedList<a> fpg;

    static class a implements Comparable<a> {
        long fpi;
        String info;

        a() {
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (((a) obj).fpi - this.fpi);
        }
    }

    static /* synthetic */ String pf(String str) {
        AppMethodBeat.i(16388);
        String pe = pe(str);
        AppMethodBeat.o(16388);
        return pe;
    }

    static {
        AppMethodBeat.i(16390);
        String LM = q.LM();
        ceI = LM;
        ceJ = p.getString(LM.hashCode());
        AppMethodBeat.o(16390);
    }

    private a() {
        AppMethodBeat.i(16379);
        this.ceM = new long[]{0, 0, 0};
        this.foP = 0;
        this.foQ = false;
        this.foS = 8000;
        this.foT = 800;
        this.foU = 25600;
        this.foV = 35840;
        this.foW = 86400000;
        this.foX = 180000;
        this.foY = 5000;
        this.foZ = 120;
        this.fpa = 50;
        this.fpb = 1800000;
        this.ehZ = ah.doB();
        this.fpc = new Long[18];
        this.fpd = 0;
        this.fpe = 0;
        this.fpf = "";
        this.fpg = new LinkedList();
        this.foS = this.ehZ.getLong("handler_debug_log_time", 8000);
        this.foT = this.ehZ.getLong("handler_debug_log_time_main", 800);
        this.foU = this.ehZ.getLong("handler_trace_file_full_size", 25600);
        this.foV = this.ehZ.getLong("handler_log_file_max_size", 35840);
        this.foW = this.ehZ.getLong("handler_upload_time_interval", 86400000);
        this.fpe = aw.RS().oAl.getLooper().getThread().getId();
        Arrays.fill(this.fpc, Long.valueOf(0));
        AppMethodBeat.o(16379);
    }

    public static a abl() {
        AppMethodBeat.i(16380);
        if (foM == null) {
            synchronized (a.class) {
                try {
                    if (foM == null) {
                        foM = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(16380);
                    }
                }
            }
        }
        a aVar = foM;
        AppMethodBeat.o(16380);
        return aVar;
    }

    private void z(File file) {
        boolean z = true;
        AppMethodBeat.i(16381);
        if (file.exists()) {
            this.foQ = file.length() > this.foU;
            if (this.foQ) {
                long j = this.ehZ.getLong("handler_trace_log_file_full_time", 0);
                String str = "MicroMsg.HandlerTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (j == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                if (j == 0) {
                    this.ehZ.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
                }
                AppMethodBeat.o(16381);
                return;
            }
        }
        this.foQ = false;
        AppMethodBeat.o(16381);
    }

    /* Access modifiers changed, original: final */
    public final String abm() {
        Object format;
        String format2;
        AppMethodBeat.i(16382);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.vxo);
        printStream.println("#accinfo.revision=" + f.REV);
        printStream.println("#accinfo.uin=" + av.fly.T("last_login_uin", ceJ));
        printStream.println("#accinfo.dev=" + ceI);
        printStream.println("#accinfo.build=" + f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + g.cdf);
        String str = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.eSl);
            format2 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ah.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            ab.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", e.getMessage());
            format2 = str;
        }
        printStream.println("#accinfo.data=".concat(String.valueOf(format2)));
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        printStream.println("#logfile.fulllast :".concat(String.valueOf(this.ehZ.getLong("handler_trace_log_file_full_time", 0) - this.ehZ.getLong("handler_trace_log_file_create_time", 0))));
        if (this.ceM[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.ceM[0] + " data size=" + this.ceM[1] + " code size=" + this.ceM[2]);
        }
        m[] lU = r.aix().lU(21);
        if (lU == null || lU.length == 0 || lU[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + lU[0].id + " version=" + lU[0].version);
        }
        printStream.println("#handler.content:");
        format2 = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(16382);
        return format2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d A:{SYNTHETIC, Splitter:B:11:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A:{SYNTHETIC, Splitter:B:17:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String pe(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.i(16383);
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(com.tencent.mm.cf.e.ce(bArr));
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                }
                AppMethodBeat.o(16383);
                return str2;
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                AppMethodBeat.o(16383);
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.o(16383);
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(16383);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
            }
            AppMethodBeat.o(16383);
            throw th;
        }
    }

    private void b(File file, boolean z) {
        AppMethodBeat.i(16384);
        ab.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            z(file);
            AppMethodBeat.o(16384);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            ab.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
        }
        Editor edit = this.ehZ.edit();
        edit.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
        edit.putLong("handler_trace_log_file_full_time", 0).commit();
        z(file);
        AppMethodBeat.o(16384);
    }

    public final void abn() {
        AppMethodBeat.i(16385);
        ab.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
        this.foS = this.ehZ.getLong("handler_debug_log_time", 8000);
        this.foT = this.ehZ.getLong("handler_debug_log_time_main", 800);
        this.foU = this.ehZ.getLong("handler_trace_file_full_size", 25600);
        this.foV = this.ehZ.getLong("handler_log_file_max_size", 35840);
        this.foW = this.ehZ.getLong("handler_upload_time_interval", 86400000);
        this.foX = this.ehZ.getLong("handler_worker_assert_time", 180000);
        this.foY = this.ehZ.getLong("handler_worker_warn_time", 5000);
        this.foZ = (int) this.ehZ.getLong("handler_worker_warn_task_max_size", 120);
        this.fpa = (int) this.ehZ.getLong("handler_worker_warn_task_keep_size", 50);
        this.fpb = (int) this.ehZ.getLong("handler_worker_warn_task_keep_size", 1800000);
        z(new File(foO));
        AppMethodBeat.o(16385);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098 A:{SYNTHETIC, Splitter:B:30:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008e A:{SYNTHETIC, Splitter:B:24:0x008e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(a aVar, String str, String str2) {
        Throwable e;
        AppMethodBeat.i(16387);
        if (com.tencent.mm.compatible.util.f.Mn()) {
            File file;
            try {
                file = new File(foN);
                if (!file.exists()) {
                    file.mkdirs();
                }
                aVar.b(new File(foN, "Handler.trace"), false);
            } catch (Exception e2) {
            }
            file = new File(str);
            if (file.length() > aVar.foV) {
                ab.e("MicroMsg.HandlerTraceManager", "summer log file invaild foramt, recreate");
                aVar.b(file, true);
            }
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(com.tencent.mm.cf.e.ce(str2.getBytes()));
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        ab.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                        if (randomAccessFile != null) {
                        }
                        aVar.z(new File(foO));
                        AppMethodBeat.o(16387);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.o(16387);
                        throw e;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                randomAccessFile = null;
                ab.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                aVar.z(new File(foO));
                AppMethodBeat.o(16387);
                return;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e7) {
                    }
                }
                AppMethodBeat.o(16387);
                throw e;
            }
            aVar.z(new File(foO));
            AppMethodBeat.o(16387);
            return;
        }
        ab.i("MicroMsg.HandlerTraceManager", "summer sdcard is not Available, appendToFile fail ");
        AppMethodBeat.o(16387);
    }
}
