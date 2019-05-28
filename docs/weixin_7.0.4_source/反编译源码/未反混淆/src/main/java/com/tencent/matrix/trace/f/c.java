package com.tencent.matrix.trace.f;

import android.os.Handler;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends e {
    private final com.tencent.matrix.trace.a.a bYH;
    private final long bZM;
    long bZN;
    private boolean bZO;
    long bZP;
    long bZQ;
    long bZR;
    long bZS;
    private long bZT;
    private HashSet<com.tencent.matrix.trace.e.b> listeners = new HashSet();

    enum a {
        DROPPED_FROZEN(4),
        DROPPED_HIGH(3),
        DROPPED_MIDDLE(2),
        DROPPED_NORMAL(1),
        DROPPED_BEST(0);
        
        int index;

        private a(int i) {
            this.index = i;
        }
    }

    class c {
        String cah;
        long cai;
        int caj = 0;
        int cak;
        int[] cal = new int[a.values().length];
        int[] cam = new int[a.values().length];

        c(String str) {
            this.cah = str;
        }

        public final String toString() {
            return "focusedActivityName=" + this.cah + ", sumFrame=" + this.caj + ", sumDroppedFrames=" + this.cak + ", sumFrameCost=" + this.cai + ", dropLevel=" + Arrays.toString(this.cal);
        }
    }

    class b extends com.tencent.matrix.trace.e.b {
        private Handler caf;
        private HashMap<String, c> cag;

        private b() {
            this.caf = new Handler(com.tencent.matrix.d.b.zL().getLooper());
            this.cag = new HashMap();
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }

        public final Handler getHandler() {
            return this.caf;
        }

        public final void a(String str, long j, int i) {
            int i2;
            super.a(str, j, i);
            if (str == null || str.equals("")) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                c cVar;
                int i3;
                int[] iArr;
                c cVar2 = (c) this.cag.get(str);
                if (cVar2 == null) {
                    cVar2 = new c(str);
                    this.cag.put(str, cVar2);
                    cVar = cVar2;
                } else {
                    cVar = cVar2;
                }
                cVar.cai = ((com.tencent.matrix.trace.core.b.zx().bZe * ((long) (i + 1))) / 1000000) + cVar.cai;
                cVar.cak += i;
                cVar.caj++;
                int[] iArr2;
                if (((long) i) >= c.this.bZP) {
                    iArr2 = cVar.cal;
                    i3 = a.DROPPED_FROZEN.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = cVar.cam;
                    i3 = a.DROPPED_FROZEN.index;
                    i2 = iArr[i3];
                } else if (((long) i) >= c.this.bZQ) {
                    iArr2 = cVar.cal;
                    i3 = a.DROPPED_HIGH.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = cVar.cam;
                    i3 = a.DROPPED_HIGH.index;
                    i2 = iArr[i3];
                } else if (((long) i) >= c.this.bZR) {
                    iArr2 = cVar.cal;
                    i3 = a.DROPPED_MIDDLE.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = cVar.cam;
                    i3 = a.DROPPED_MIDDLE.index;
                    i2 = iArr[i3];
                } else if (((long) i) >= c.this.bZS) {
                    iArr2 = cVar.cal;
                    i3 = a.DROPPED_NORMAL.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = cVar.cam;
                    i3 = a.DROPPED_NORMAL.index;
                    i2 = iArr[i3];
                } else {
                    iArr2 = cVar.cal;
                    i3 = a.DROPPED_BEST.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = cVar.cam;
                    i3 = a.DROPPED_BEST.index;
                    i2 = iArr[i3];
                    if (i < 0) {
                        i = 0;
                    }
                }
                iArr[i3] = i2 + i;
                if (cVar.cai >= c.this.bZN) {
                    this.cag.remove(str);
                    com.tencent.matrix.d.c.i("Matrix.FrameTracer", "[report] FPS:%s %s", Float.valueOf(Math.min(60.0f, (1000.0f * ((float) cVar.caj)) / ((float) cVar.cai))), cVar.toString());
                    try {
                        com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(a.DROPPED_FROZEN.name(), cVar.cal[a.DROPPED_FROZEN.index]);
                        jSONObject.put(a.DROPPED_HIGH.name(), cVar.cal[a.DROPPED_HIGH.index]);
                        jSONObject.put(a.DROPPED_MIDDLE.name(), cVar.cal[a.DROPPED_MIDDLE.index]);
                        jSONObject.put(a.DROPPED_NORMAL.name(), cVar.cal[a.DROPPED_NORMAL.index]);
                        jSONObject.put(a.DROPPED_BEST.name(), cVar.cal[a.DROPPED_BEST.index]);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(a.DROPPED_FROZEN.name(), cVar.cam[a.DROPPED_FROZEN.index]);
                        jSONObject2.put(a.DROPPED_HIGH.name(), cVar.cam[a.DROPPED_HIGH.index]);
                        jSONObject2.put(a.DROPPED_MIDDLE.name(), cVar.cam[a.DROPPED_MIDDLE.index]);
                        jSONObject2.put(a.DROPPED_NORMAL.name(), cVar.cam[a.DROPPED_NORMAL.index]);
                        jSONObject2.put(a.DROPPED_BEST.name(), cVar.cam[a.DROPPED_BEST.index]);
                        JSONObject a = com.tencent.matrix.d.a.a(new JSONObject(), aVar.getApplication());
                        a.put("scene", cVar.cah);
                        a.put("dropLevel", jSONObject);
                        a.put("dropSum", jSONObject2);
                        a.put("fps", (double) r2);
                        com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b();
                        bVar.tag = "Trace_FPS";
                        bVar.bWv = a;
                        aVar.onDetectIssue(bVar);
                    } catch (JSONException e) {
                        com.tencent.matrix.d.c.e("Matrix.FrameTracer", "json error", e);
                    }
                }
            }
        }
    }

    public c(com.tencent.matrix.trace.a.a aVar) {
        int i;
        this.bYH = aVar;
        this.bZM = TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.zx().bZe, TimeUnit.NANOSECONDS) + 1;
        if (aVar.bWX == null) {
            i = Downloads.MIN_WAIT_FOR_NETWORK;
        } else {
            i = aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_trace_fps_time_slice.name(), (int) Downloads.MIN_WAIT_FOR_NETWORK);
        }
        this.bZN = (long) i;
        this.bZO = aVar.bYA;
        if (aVar.bWX == null) {
            i = 42;
        } else {
            i = aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_fps_dropped_frozen.name(), 42);
        }
        this.bZP = (long) i;
        if (aVar.bWX == null) {
            i = 24;
        } else {
            i = aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_fps_dropped_high.name(), 24);
        }
        this.bZQ = (long) i;
        if (aVar.bWX == null) {
            i = 3;
        } else {
            i = aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_fps_dropped_normal.name(), 3);
        }
        this.bZS = (long) i;
        if (aVar.bWX == null) {
            i = 9;
        } else {
            i = aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_fps_dropped_middle.name(), 9);
        }
        this.bZR = (long) i;
        com.tencent.matrix.d.c.i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", Long.valueOf(this.bZM), Boolean.valueOf(this.bZO));
        if (this.bZO) {
            a(new b(this, (byte) 0));
        }
    }

    public final void a(com.tencent.matrix.trace.e.b bVar) {
        synchronized (this.listeners) {
            this.listeners.add(bVar);
        }
    }

    public final void b(com.tencent.matrix.trace.e.b bVar) {
        synchronized (this.listeners) {
            this.listeners.remove(bVar);
        }
    }

    public final void zC() {
        super.zC();
        com.tencent.matrix.trace.core.b.zx().a((com.tencent.matrix.trace.e.c) this);
    }

    public final void zD() {
        super.zD();
        com.tencent.matrix.trace.core.b.zx().b((com.tencent.matrix.trace.e.c) this);
    }

    public final void onForeground(boolean z) {
        super.onForeground(z);
        if (z) {
            if (this.bZT > 300) {
                com.tencent.matrix.d.c.e("Matrix.FrameTracer", "wrong! why do frame[%s] in background!!!", Long.valueOf(this.bZT));
            }
            this.bZT = 0;
        }
    }

    public final void a(String str, long j, long j2, long j3, long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            synchronized (this.listeners) {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    final com.tencent.matrix.trace.e.b bVar = (com.tencent.matrix.trace.e.b) it.next();
                    final int i = (int) (j / this.bZM);
                    if (bVar.getHandler() != null) {
                        final String str2 = str;
                        final long j5 = j;
                        bVar.getHandler().post(new Runnable() {
                            public final void run() {
                                bVar.a(str2, j5, i);
                            }
                        });
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.bYH.bYE) {
                com.tencent.matrix.d.c.v("Matrix.FrameTracer", "[notifyListener] cost:%sms", Long.valueOf(currentTimeMillis2));
            }
            if (currentTimeMillis2 > this.bZM) {
                com.tencent.matrix.d.c.w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync,but you can replace with doFrameAsync! cost:%sms", Long.valueOf(currentTimeMillis2));
            }
            if (this.bYH.isDebug && !this.caA) {
                this.bZT++;
            }
        } catch (Throwable th) {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (this.bYH.bYE) {
                com.tencent.matrix.d.c.v("Matrix.FrameTracer", "[notifyListener] cost:%sms", Long.valueOf(currentTimeMillis3));
            }
            if (currentTimeMillis3 > this.bZM) {
                com.tencent.matrix.d.c.w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync,but you can replace with doFrameAsync! cost:%sms", Long.valueOf(currentTimeMillis3));
            }
            if (this.bYH.isDebug && !this.caA) {
                this.bZT++;
            }
        }
    }
}
