package com.tencent.matrix.trace.p175f;

import android.os.Handler;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1067a;
import com.tencent.matrix.p157d.C1068b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.C1148b;
import com.tencent.matrix.trace.p170a.C1133a;
import com.tencent.matrix.trace.p174e.C1153b;
import com.tencent.matrix.trace.p174e.C1154c;
import com.tencent.mrs.p656b.C5774a.C5773a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.trace.f.c */
public final class C7469c extends C6293e {
    private final C1133a bYH;
    private final long bZM;
    long bZN;
    private boolean bZO;
    long bZP;
    long bZQ;
    long bZR;
    long bZS;
    private long bZT;
    private HashSet<C1153b> listeners = new HashSet();

    /* renamed from: com.tencent.matrix.trace.f.c$a */
    enum C1160a {
        DROPPED_FROZEN(4),
        DROPPED_HIGH(3),
        DROPPED_MIDDLE(2),
        DROPPED_NORMAL(1),
        DROPPED_BEST(0);
        
        int index;

        private C1160a(int i) {
            this.index = i;
        }
    }

    /* renamed from: com.tencent.matrix.trace.f.c$c */
    class C1161c {
        String cah;
        long cai;
        int caj = 0;
        int cak;
        int[] cal = new int[C1160a.values().length];
        int[] cam = new int[C1160a.values().length];

        C1161c(String str) {
            this.cah = str;
        }

        public final String toString() {
            return "focusedActivityName=" + this.cah + ", sumFrame=" + this.caj + ", sumDroppedFrames=" + this.cak + ", sumFrameCost=" + this.cai + ", dropLevel=" + Arrays.toString(this.cal);
        }
    }

    /* renamed from: com.tencent.matrix.trace.f.c$b */
    class C6292b extends C1153b {
        private Handler caf;
        private HashMap<String, C1161c> cag;

        private C6292b() {
            this.caf = new Handler(C1068b.m2358zL().getLooper());
            this.cag = new HashMap();
        }

        /* synthetic */ C6292b(C7469c c7469c, byte b) {
            this();
        }

        public final Handler getHandler() {
            return this.caf;
        }

        /* renamed from: a */
        public final void mo4386a(String str, long j, int i) {
            int i2;
            super.mo4386a(str, j, i);
            if (str == null || str.equals("")) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                C1161c c1161c;
                int i3;
                int[] iArr;
                C1161c c1161c2 = (C1161c) this.cag.get(str);
                if (c1161c2 == null) {
                    c1161c2 = new C1161c(str);
                    this.cag.put(str, c1161c2);
                    c1161c = c1161c2;
                } else {
                    c1161c = c1161c2;
                }
                c1161c.cai = ((C1148b.m2518zx().bZe * ((long) (i + 1))) / 1000000) + c1161c.cai;
                c1161c.cak += i;
                c1161c.caj++;
                int[] iArr2;
                if (((long) i) >= C7469c.this.bZP) {
                    iArr2 = c1161c.cal;
                    i3 = C1160a.DROPPED_FROZEN.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = c1161c.cam;
                    i3 = C1160a.DROPPED_FROZEN.index;
                    i2 = iArr[i3];
                } else if (((long) i) >= C7469c.this.bZQ) {
                    iArr2 = c1161c.cal;
                    i3 = C1160a.DROPPED_HIGH.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = c1161c.cam;
                    i3 = C1160a.DROPPED_HIGH.index;
                    i2 = iArr[i3];
                } else if (((long) i) >= C7469c.this.bZR) {
                    iArr2 = c1161c.cal;
                    i3 = C1160a.DROPPED_MIDDLE.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = c1161c.cam;
                    i3 = C1160a.DROPPED_MIDDLE.index;
                    i2 = iArr[i3];
                } else if (((long) i) >= C7469c.this.bZS) {
                    iArr2 = c1161c.cal;
                    i3 = C1160a.DROPPED_NORMAL.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = c1161c.cam;
                    i3 = C1160a.DROPPED_NORMAL.index;
                    i2 = iArr[i3];
                } else {
                    iArr2 = c1161c.cal;
                    i3 = C1160a.DROPPED_BEST.index;
                    iArr2[i3] = iArr2[i3] + 1;
                    iArr = c1161c.cam;
                    i3 = C1160a.DROPPED_BEST.index;
                    i2 = iArr[i3];
                    if (i < 0) {
                        i = 0;
                    }
                }
                iArr[i3] = i2 + i;
                if (c1161c.cai >= C7469c.this.bZN) {
                    this.cag.remove(str);
                    C1070c.m2368i("Matrix.FrameTracer", "[report] FPS:%s %s", Float.valueOf(Math.min(60.0f, (1000.0f * ((float) c1161c.caj)) / ((float) c1161c.cai))), c1161c.toString());
                    try {
                        C7466a c7466a = (C7466a) C1060a.m2339yK().mo4192F(C7466a.class);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(C1160a.DROPPED_FROZEN.name(), c1161c.cal[C1160a.DROPPED_FROZEN.index]);
                        jSONObject.put(C1160a.DROPPED_HIGH.name(), c1161c.cal[C1160a.DROPPED_HIGH.index]);
                        jSONObject.put(C1160a.DROPPED_MIDDLE.name(), c1161c.cal[C1160a.DROPPED_MIDDLE.index]);
                        jSONObject.put(C1160a.DROPPED_NORMAL.name(), c1161c.cal[C1160a.DROPPED_NORMAL.index]);
                        jSONObject.put(C1160a.DROPPED_BEST.name(), c1161c.cal[C1160a.DROPPED_BEST.index]);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(C1160a.DROPPED_FROZEN.name(), c1161c.cam[C1160a.DROPPED_FROZEN.index]);
                        jSONObject2.put(C1160a.DROPPED_HIGH.name(), c1161c.cam[C1160a.DROPPED_HIGH.index]);
                        jSONObject2.put(C1160a.DROPPED_MIDDLE.name(), c1161c.cam[C1160a.DROPPED_MIDDLE.index]);
                        jSONObject2.put(C1160a.DROPPED_NORMAL.name(), c1161c.cam[C1160a.DROPPED_NORMAL.index]);
                        jSONObject2.put(C1160a.DROPPED_BEST.name(), c1161c.cam[C1160a.DROPPED_BEST.index]);
                        JSONObject a = C1067a.m2349a(new JSONObject(), c7466a.getApplication());
                        a.put("scene", c1161c.cah);
                        a.put("dropLevel", jSONObject);
                        a.put("dropSum", jSONObject2);
                        a.put("fps", (double) r2);
                        C1062b c1062b = new C1062b();
                        c1062b.tag = "Trace_FPS";
                        c1062b.bWv = a;
                        c7466a.onDetectIssue(c1062b);
                    } catch (JSONException e) {
                        C1070c.m2367e("Matrix.FrameTracer", "json error", e);
                    }
                }
            }
        }
    }

    public C7469c(C1133a c1133a) {
        int i;
        this.bYH = c1133a;
        this.bZM = TimeUnit.MILLISECONDS.convert(C1148b.m2518zx().bZe, TimeUnit.NANOSECONDS) + 1;
        if (c1133a.bWX == null) {
            i = Downloads.MIN_WAIT_FOR_NETWORK;
        } else {
            i = c1133a.bWX.get(C5773a.clicfg_matrix_trace_fps_time_slice.name(), (int) Downloads.MIN_WAIT_FOR_NETWORK);
        }
        this.bZN = (long) i;
        this.bZO = c1133a.bYA;
        if (c1133a.bWX == null) {
            i = 42;
        } else {
            i = c1133a.bWX.get(C5773a.clicfg_matrix_fps_dropped_frozen.name(), 42);
        }
        this.bZP = (long) i;
        if (c1133a.bWX == null) {
            i = 24;
        } else {
            i = c1133a.bWX.get(C5773a.clicfg_matrix_fps_dropped_high.name(), 24);
        }
        this.bZQ = (long) i;
        if (c1133a.bWX == null) {
            i = 3;
        } else {
            i = c1133a.bWX.get(C5773a.clicfg_matrix_fps_dropped_normal.name(), 3);
        }
        this.bZS = (long) i;
        if (c1133a.bWX == null) {
            i = 9;
        } else {
            i = c1133a.bWX.get(C5773a.clicfg_matrix_fps_dropped_middle.name(), 9);
        }
        this.bZR = (long) i;
        C1070c.m2368i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", Long.valueOf(this.bZM), Boolean.valueOf(this.bZO));
        if (this.bZO) {
            mo16643a(new C6292b(this, (byte) 0));
        }
    }

    /* renamed from: a */
    public final void mo16643a(C1153b c1153b) {
        synchronized (this.listeners) {
            this.listeners.add(c1153b);
        }
    }

    /* renamed from: b */
    public final void mo16644b(C1153b c1153b) {
        synchronized (this.listeners) {
            this.listeners.remove(c1153b);
        }
    }

    /* renamed from: zC */
    public final void mo14533zC() {
        super.mo14533zC();
        C1148b.m2518zx().mo4376a((C1154c) this);
    }

    /* renamed from: zD */
    public final void mo14534zD() {
        super.mo14534zD();
        C1148b.m2518zx().mo4377b((C1154c) this);
    }

    public final void onForeground(boolean z) {
        super.onForeground(z);
        if (z) {
            if (this.bZT > 300) {
                C1070c.m2367e("Matrix.FrameTracer", "wrong! why do frame[%s] in background!!!", Long.valueOf(this.bZT));
            }
            this.bZT = 0;
        }
    }

    /* renamed from: a */
    public final void mo4382a(String str, long j, long j2, long j3, long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            synchronized (this.listeners) {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    final C1153b c1153b = (C1153b) it.next();
                    final int i = (int) (j / this.bZM);
                    if (c1153b.getHandler() != null) {
                        final String str2 = str;
                        final long j5 = j;
                        c1153b.getHandler().post(new Runnable() {
                            public final void run() {
                                c1153b.mo4386a(str2, j5, i);
                            }
                        });
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.bYH.bYE) {
                C1070c.m2369v("Matrix.FrameTracer", "[notifyListener] cost:%sms", Long.valueOf(currentTimeMillis2));
            }
            if (currentTimeMillis2 > this.bZM) {
                C1070c.m2370w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync,but you can replace with doFrameAsync! cost:%sms", Long.valueOf(currentTimeMillis2));
            }
            if (this.bYH.isDebug && !this.caA) {
                this.bZT++;
            }
        } catch (Throwable th) {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (this.bYH.bYE) {
                C1070c.m2369v("Matrix.FrameTracer", "[notifyListener] cost:%sms", Long.valueOf(currentTimeMillis3));
            }
            if (currentTimeMillis3 > this.bZM) {
                C1070c.m2370w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync,but you can replace with doFrameAsync! cost:%sms", Long.valueOf(currentTimeMillis3));
            }
            if (this.bYH.isDebug && !this.caA) {
                this.bZT++;
            }
        }
    }
}
