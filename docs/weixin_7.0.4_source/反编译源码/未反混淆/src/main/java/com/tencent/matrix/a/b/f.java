package com.tencent.matrix.a.b;

import android.os.Environment;
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

public final class f extends com.tencent.matrix.c.c {
    final Map<String, d> bVD = new HashMap();
    final Map<String, c> bVE = new HashMap();
    final int bVF;
    private final int bVG;
    private final int bVH;
    final a bVI;
    final Runnable bVJ;
    final e bVK;

    public interface a {
        void e(Runnable runnable, long j);

        boolean isScreenOn();
    }

    static final class b {
        final Vector<String> bVM = new Vector();

        b() {
        }

        /* Access modifiers changed, original: final */
        public final void cd(String str) {
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

    static final class c {
        final long bVN = System.currentTimeMillis();
        long bVO = 0;
        long bVP = 0;
        int bVQ = 0;
        int bVR = 0;
        b bVS = new b();
        final Map<String, Boolean> bVT = new HashMap();
        long bVU = -1;
        boolean bVV;
        final String tag;

        c(String str) {
            this.tag = str;
        }

        /* Access modifiers changed, original: final */
        public final void yX() {
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

    static final class d {
        b bVS = new b();
        final String bVW;
        final long bVX;
        final int flags;
        final String tag;

        d(String str, String str2, int i, long j) {
            this.bVW = str;
            this.tag = str2;
            this.flags = i;
            this.bVX = j;
        }
    }

    static final class e {
        private final String bUS;
        int bVY;
        final StringBuilder bVZ = new StringBuilder();

        e() {
            String formatTime = com.tencent.matrix.d.d.formatTime("yyyy-MM-dd", System.currentTimeMillis());
            this.bUS = String.format("%s/com.tencent.matrix/wakelock-detector-record/%s/wakelocks-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), formatTime});
            com.tencent.matrix.d.c.i("Matrix.WakeLockDetector", "WakeLockInfoRecorder path:%s", this.bUS);
        }

        /* Access modifiers changed, original: final */
        public final void yY() {
            if (this.bVY >= 10) {
                yZ();
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
        private void yZ() {
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
                            com.tencent.matrix.d.c.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e.getLocalizedMessage());
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
                        com.tencent.matrix.d.c.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e2.getLocalizedMessage());
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
                com.tencent.matrix.d.c.e("Matrix.WakeLockDetector", "doRecord mkdirs failed", new Object[0]);
            } catch (FileNotFoundException e7) {
                e = e7;
                com.tencent.matrix.d.c.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e8) {
                    }
                }
            } catch (IOException e9) {
                e2 = e9;
                com.tencent.matrix.d.c.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e2.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e10) {
                    }
                }
            }
        }
    }

    public f(com.tencent.matrix.c.c.a aVar, com.tencent.matrix.a.a.a aVar2, a aVar3) {
        super(aVar);
        this.bVF = aVar2.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_wake_lock_hold_time_threshold.name(), 120000);
        this.bVG = aVar2.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_wake_lock_1h_hold_time_threshold.name(), 600000);
        this.bVH = aVar2.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_wake_lock_1h_acquire_cnt_threshold.name(), 20);
        this.bVI = aVar3;
        this.bVJ = new Runnable() {
            public final void run() {
                for (Entry value : f.this.bVE.entrySet()) {
                    ((c) value.getValue()).yX();
                }
                f.this.yU();
            }
        };
        if (aVar2.yN()) {
            this.bVK = new e();
        } else {
            this.bVK = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void yU() {
        yV();
        yW();
    }

    private void yV() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Entry value : this.bVD.entrySet()) {
            d dVar = (d) value.getValue();
            if (currentTimeMillis - dVar.bVX >= ((long) this.bVF)) {
                String format = String.format("%s:%d", new Object[]{dVar.tag, Integer.valueOf(1)});
                if (cg(format)) {
                    com.tencent.matrix.d.c.v("Matrix.WakeLockDetector", "detectWakeLockOnceHoldTime issue already published: %s", format);
                } else {
                    com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(1);
                    bVar.key = format;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("subTag", "wakeLock");
                        jSONObject.put("wakeLockTag", dVar.tag);
                        jSONObject.put("flags", dVar.flags);
                        jSONObject.put("holdTime", currentTimeMillis - dVar.bVX);
                        jSONObject.put("stackHistory", dVar.bVS);
                    } catch (JSONException e) {
                        com.tencent.matrix.d.c.e("Matrix.WakeLockDetector", "json content error: %s", e);
                    }
                    com.tencent.matrix.d.c.i("Matrix.WakeLockDetector", "detected lock once too long, token:%s, tag:%s", dVar.bVW, dVar.tag);
                    bVar.bWv = jSONObject;
                    b(bVar);
                    cf(format);
                }
            }
        }
    }

    private void yW() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Entry entry : this.bVE.entrySet()) {
            String str = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            long j = currentTimeMillis - cVar.bVN;
            int i = ((int) (j / 3600000)) + 1;
            long j2 = cVar.bVP / ((long) i);
            if (cVar.bVR / i > this.bVH / 2) {
                String format = String.format("%s:%d", new Object[]{str, Integer.valueOf(2)});
                if (cg(format)) {
                    com.tencent.matrix.d.c.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", format);
                } else {
                    com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(2);
                    bVar.key = format;
                    bVar.bWv = a(cVar, j);
                    b(bVar);
                    cf(format);
                }
            }
            if (j2 >= ((long) this.bVG)) {
                str = String.format("%s:%d", new Object[]{str, Integer.valueOf(3)});
                if (cg(str)) {
                    com.tencent.matrix.d.c.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", str);
                } else {
                    com.tencent.matrix.c.b bVar2 = new com.tencent.matrix.c.b(3);
                    bVar2.key = str;
                    bVar2.bWv = a(cVar, j);
                    b(bVar2);
                    cf(str);
                }
            }
        }
    }

    private static JSONObject a(c cVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wakeLockTag", cVar.tag);
            jSONObject.put("subTag", "wakeLock");
            jSONObject.put("timeFrame", j);
            jSONObject.put("acquireCnt", cVar.bVQ);
            jSONObject.put("acquireCntWhenScreenOff", cVar.bVR);
            jSONObject.put("statisticalHoldTime", cVar.bVO);
            jSONObject.put("stackHistory", cVar.bVS);
        } catch (JSONException e) {
            com.tencent.matrix.d.c.e("Matrix.WakeLockDetector", "json content error: %s", e);
        }
        return jSONObject;
    }
}
