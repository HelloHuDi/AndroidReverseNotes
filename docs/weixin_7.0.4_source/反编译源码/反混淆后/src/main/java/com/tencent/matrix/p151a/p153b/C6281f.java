package com.tencent.matrix.p151a.p153b;

import android.os.Environment;
import com.tencent.matrix.p151a.p152a.C1024a;
import com.tencent.matrix.p151a.p154c.C1055a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p156c.C1064c;
import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1073d;
import com.tencent.mrs.p656b.C5774a.C5773a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.a.b.f */
public final class C6281f extends C1064c {
    final Map<String, C1053d> bVD = new HashMap();
    final Map<String, C1052c> bVE = new HashMap();
    final int bVF;
    private final int bVG;
    private final int bVH;
    final C1050a bVI;
    final Runnable bVJ;
    final C1054e bVK;

    /* renamed from: com.tencent.matrix.a.b.f$1 */
    class C10491 implements Runnable {
        C10491() {
        }

        public final void run() {
            for (Entry value : C6281f.this.bVE.entrySet()) {
                ((C1052c) value.getValue()).mo4186yX();
            }
            C6281f.this.mo14513yU();
        }
    }

    /* renamed from: com.tencent.matrix.a.b.f$a */
    public interface C1050a {
        /* renamed from: e */
        void mo4182e(Runnable runnable, long j);

        boolean isScreenOn();
    }

    /* renamed from: com.tencent.matrix.a.b.f$b */
    static final class C1051b {
        final Vector<String> bVM = new Vector();

        C1051b() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cd */
        public final void mo4184cd(String str) {
            this.bVM.add(str);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bVM.size()) {
                    return stringBuilder.toString();
                }
                stringBuilder.append((String) this.bVM.get(i2)).append("\t\t");
                i = i2 + 1;
            }
        }
    }

    /* renamed from: com.tencent.matrix.a.b.f$c */
    static final class C1052c {
        final long bVN = System.currentTimeMillis();
        long bVO = 0;
        long bVP = 0;
        int bVQ = 0;
        int bVR = 0;
        C1051b bVS = new C1051b();
        final Map<String, Boolean> bVT = new HashMap();
        long bVU = -1;
        boolean bVV;
        final String tag;

        C1052c(String str) {
            this.tag = str;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: yX */
        public final void mo4186yX() {
            if (this.bVU >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.bVO += currentTimeMillis - this.bVU;
                if (!this.bVV) {
                    this.bVP += currentTimeMillis - this.bVU;
                }
                this.bVU = currentTimeMillis;
            }
        }
    }

    /* renamed from: com.tencent.matrix.a.b.f$d */
    static final class C1053d {
        C1051b bVS = new C1051b();
        final String bVW;
        final long bVX;
        final int flags;
        final String tag;

        C1053d(String str, String str2, int i, long j) {
            this.bVW = str;
            this.tag = str2;
            this.flags = i;
            this.bVX = j;
        }
    }

    /* renamed from: com.tencent.matrix.a.b.f$e */
    static final class C1054e {
        private final String bUS;
        int bVY;
        final StringBuilder bVZ = new StringBuilder();

        C1054e() {
            String formatTime = C1073d.formatTime("yyyy-MM-dd", System.currentTimeMillis());
            this.bUS = String.format("%s/com.tencent.matrix/wakelock-detector-record/%s/wakelocks-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), C1055a.getPackageName(), formatTime});
            C1070c.m2368i("Matrix.WakeLockDetector", "WakeLockInfoRecorder path:%s", this.bUS);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: yY */
        public final void mo4187yY() {
            if (this.bVY >= 10) {
                m2332yZ();
                this.bVY = 0;
                this.bVZ.delete(0, this.bVZ.length());
            }
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0051=Splitter:B:14:0x0051, B:21:0x006d=Splitter:B:21:0x006d} */
        /* JADX WARNING: Removed duplicated region for block: B:40:? A:{SYNTHETIC, RETURN, Catch:{ FileNotFoundException -> 0x0050, IOException -> 0x006c }} */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A:{SYNTHETIC, Splitter:B:17:0x0066} */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, Catch:{ FileNotFoundException -> 0x0050, IOException -> 0x006c }} */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0082 A:{SYNTHETIC, Splitter:B:24:0x0082} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x008b A:{SYNTHETIC, Splitter:B:29:0x008b} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: yZ */
        private void m2332yZ() {
            FileNotFoundException e;
            Throwable th;
            IOException e2;
            BufferedWriter bufferedWriter = null;
            try {
                File file = new File(this.bUS);
                if (file.getParentFile().mkdirs() || file.getParentFile().exists()) {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                    try {
                        String stringBuilder = this.bVZ.toString();
                        bufferedWriter2.write(stringBuilder, 0, stringBuilder.length());
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                            return;
                        } catch (IOException e3) {
                            return;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedWriter = bufferedWriter2;
                        try {
                            C1070c.m2370w("Matrix.WakeLockDetector", "dumpCache exp:%s", e.getLocalizedMessage());
                            if (bufferedWriter == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedWriter != null) {
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e2 = e5;
                        bufferedWriter = bufferedWriter2;
                        C1070c.m2370w("Matrix.WakeLockDetector", "dumpCache exp:%s", e2.getLocalizedMessage());
                        if (bufferedWriter == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw th;
                    }
                }
                C1070c.m2367e("Matrix.WakeLockDetector", "doRecord mkdirs failed", new Object[0]);
            } catch (FileNotFoundException e7) {
                e = e7;
                C1070c.m2370w("Matrix.WakeLockDetector", "dumpCache exp:%s", e.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e8) {
                    }
                }
            } catch (IOException e9) {
                e2 = e9;
                C1070c.m2370w("Matrix.WakeLockDetector", "dumpCache exp:%s", e2.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e10) {
                    }
                }
            }
        }
    }

    public C6281f(C1063a c1063a, C1024a c1024a, C1050a c1050a) {
        super(c1063a);
        this.bVF = c1024a.bUG.get(C5773a.clicfg_matrix_battery_wake_lock_hold_time_threshold.name(), 120000);
        this.bVG = c1024a.bUG.get(C5773a.clicfg_matrix_battery_wake_lock_1h_hold_time_threshold.name(), 600000);
        this.bVH = c1024a.bUG.get(C5773a.clicfg_matrix_battery_wake_lock_1h_acquire_cnt_threshold.name(), 20);
        this.bVI = c1050a;
        this.bVJ = new C10491();
        if (c1024a.mo4163yN()) {
            this.bVK = new C1054e();
        } else {
            this.bVK = null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: yU */
    public final void mo14513yU() {
        m10289yV();
        m10290yW();
    }

    /* renamed from: yV */
    private void m10289yV() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Entry value : this.bVD.entrySet()) {
            C1053d c1053d = (C1053d) value.getValue();
            if (currentTimeMillis - c1053d.bVX >= ((long) this.bVF)) {
                String format = String.format("%s:%d", new Object[]{c1053d.tag, Integer.valueOf(1)});
                if (mo4202cg(format)) {
                    C1070c.m2369v("Matrix.WakeLockDetector", "detectWakeLockOnceHoldTime issue already published: %s", format);
                } else {
                    C1062b c1062b = new C1062b(1);
                    c1062b.key = format;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("subTag", "wakeLock");
                        jSONObject.put("wakeLockTag", c1053d.tag);
                        jSONObject.put("flags", c1053d.flags);
                        jSONObject.put("holdTime", currentTimeMillis - c1053d.bVX);
                        jSONObject.put("stackHistory", c1053d.bVS);
                    } catch (JSONException e) {
                        C1070c.m2367e("Matrix.WakeLockDetector", "json content error: %s", e);
                    }
                    C1070c.m2368i("Matrix.WakeLockDetector", "detected lock once too long, token:%s, tag:%s", c1053d.bVW, c1053d.tag);
                    c1062b.bWv = jSONObject;
                    mo4200b(c1062b);
                    mo4201cf(format);
                }
            }
        }
    }

    /* renamed from: yW */
    private void m10290yW() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Entry entry : this.bVE.entrySet()) {
            String str = (String) entry.getKey();
            C1052c c1052c = (C1052c) entry.getValue();
            long j = currentTimeMillis - c1052c.bVN;
            int i = ((int) (j / 3600000)) + 1;
            long j2 = c1052c.bVP / ((long) i);
            if (c1052c.bVR / i > this.bVH / 2) {
                String format = String.format("%s:%d", new Object[]{str, Integer.valueOf(2)});
                if (mo4202cg(format)) {
                    C1070c.m2369v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", format);
                } else {
                    C1062b c1062b = new C1062b(2);
                    c1062b.key = format;
                    c1062b.bWv = C6281f.m10287a(c1052c, j);
                    mo4200b(c1062b);
                    mo4201cf(format);
                }
            }
            if (j2 >= ((long) this.bVG)) {
                str = String.format("%s:%d", new Object[]{str, Integer.valueOf(3)});
                if (mo4202cg(str)) {
                    C1070c.m2369v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", str);
                } else {
                    C1062b c1062b2 = new C1062b(3);
                    c1062b2.key = str;
                    c1062b2.bWv = C6281f.m10287a(c1052c, j);
                    mo4200b(c1062b2);
                    mo4201cf(str);
                }
            }
        }
    }

    /* renamed from: a */
    private static JSONObject m10287a(C1052c c1052c, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wakeLockTag", c1052c.tag);
            jSONObject.put("subTag", "wakeLock");
            jSONObject.put("timeFrame", j);
            jSONObject.put("acquireCnt", c1052c.bVQ);
            jSONObject.put("acquireCntWhenScreenOff", c1052c.bVR);
            jSONObject.put("statisticalHoldTime", c1052c.bVO);
            jSONObject.put("stackHistory", c1052c.bVS);
        } catch (JSONException e) {
            C1070c.m2367e("Matrix.WakeLockDetector", "json content error: %s", e);
        }
        return jSONObject;
    }
}
