package com.tencent.matrix.trace.p175f;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1067a;
import com.tencent.matrix.p157d.C1068b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.C1141a;
import com.tencent.matrix.trace.core.C1148b;
import com.tencent.matrix.trace.p170a.C1133a;
import com.tencent.matrix.trace.p171b.C1135a.C1134a;
import com.tencent.matrix.trace.p173d.C1151a;
import com.tencent.matrix.trace.p174e.C1154c;
import com.tencent.matrix.trace.p176g.C1166a;
import com.tencent.matrix.trace.p176g.C1166a.C1165a;
import com.tencent.matrix.trace.p176g.C1167b;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.Thread.State;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.trace.f.a */
public final class C7467a extends C6293e {
    final C1133a bYu;
    private Handler bZw;
    volatile C1155a bZx;
    private boolean bZy;

    /* renamed from: com.tencent.matrix.trace.f.a$a */
    class C1155a implements Runnable {
        long bYW;
        C1141a bZz;

        /* renamed from: com.tencent.matrix.trace.f.a$a$1 */
        class C11561 implements C1165a {
            C11561() {
            }

            /* renamed from: c */
            public final boolean mo4391c(long j, int i) {
                return j < ((long) (i * 5));
            }

            /* renamed from: e */
            public final void mo4392e(List<C1151a> list, int i) {
                C1070c.m2370w("Matrix.AnrTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), Integer.valueOf(30), list);
                ListIterator listIterator = list.listIterator(Math.min(i, 30));
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }
        }

        C1155a(C1141a c1141a, long j) {
            this.bZz = c1141a;
            this.bYW = j;
        }

        public final void run() {
            C7467a.this.bZx = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            long[] copyData = AppMethodBeat.getInstance().copyData(this.bZz);
            this.bZz.release();
            long[] jArr = new long[]{C1067a.getDalvikHeap(), C1067a.getNativeHeap(), C1067a.m2355zJ()};
            State state = Looper.getMainLooper().getThread().getState();
            String a = C1167b.m2545a(Looper.getMainLooper().getThread().getStackTrace(), "|*        ", 12);
            C1148b zx = C1148b.m2518zx();
            long p = zx.mo4380p(0, this.bYW);
            long p2 = zx.mo4380p(1, this.bYW);
            long p3 = zx.mo4380p(2, this.bYW);
            LinkedList linkedList = new LinkedList();
            if (copyData.length > 0) {
                C1166a.m2541a(copyData, linkedList, true, uptimeMillis);
                C1166a.m2540a((List) linkedList, new C11561());
            }
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            long max = Math.max(5000, C1166a.m2538a(linkedList, stringBuilder, stringBuilder2));
            String a2 = C1166a.m2539a((List) linkedList, max);
            String str = "Matrix.AnrTracer";
            String str2 = "%s \npostTime:%s curTime:%s";
            Object[] objArr = new Object[3];
            long size = (long) linkedList.size();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(" \n>>>>>>>>>>>>>>>>>>>>>>> maybe happens ANR(5s)! <<<<<<<<<<<<<<<<<<<<<<<\n");
            stringBuilder3.append("|* [Memory]\n");
            stringBuilder3.append("|*   DalvikHeap: ").append(jArr[0]).append("kb\n");
            stringBuilder3.append("|*   NativeHeap: ").append(jArr[1]).append("kb\n");
            stringBuilder3.append("|*   VmSize: ").append(jArr[2]).append("kb\n");
            stringBuilder3.append("|* [doFrame]\n");
            stringBuilder3.append("|*   inputCost: ").append(p).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|*   animationCost: ").append(p2).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|*   traversalCost: ").append(p3).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|* [Thread]\n");
            stringBuilder3.append("|*   State: ").append(state).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|*   Stack: ").append(a);
            stringBuilder3.append("|* [Trace]\n");
            stringBuilder3.append("|*   StackSize: ").append(size).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|*   StackKey: ").append(a2).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (C7467a.this.bYu.isDebug) {
                stringBuilder3.append(stringBuilder2.toString());
            }
            stringBuilder3.append("=========================================================================");
            objArr[0] = stringBuilder3.toString();
            objArr[1] = Long.valueOf(this.bYW);
            objArr[2] = Long.valueOf(uptimeMillis);
            C1070c.m2370w(str, str2, objArr);
            try {
                C7466a c7466a = (C7466a) C1060a.m2339yK().mo4192F(C7466a.class);
                JSONObject a3 = C1067a.m2349a(new JSONObject(), C1060a.m2339yK().application);
                a3.put("detail", C1134a.ANR);
                a3.put("cost", max);
                a3.put("stackKey", a2);
                a3.put(SharePluginInfo.ISSUE_KEY_STACK, stringBuilder.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dalvik_heap", jArr[0]);
                jSONObject.put("native_heap", jArr[1]);
                jSONObject.put("vm_size", jArr[2]);
                a3.put("memory", jSONObject);
                C1062b c1062b = new C1062b();
                c1062b.key = this.bYW;
                c1062b.tag = "Trace_EvilMethod";
                c1062b.bWv = a3;
                c7466a.onDetectIssue(c1062b);
            } catch (JSONException e) {
                C1070c.m2367e("Matrix.AnrTracer", "[JSONException error: %s", e);
            }
        }
    }

    public C7467a(C1133a c1133a) {
        this.bYu = c1133a;
        this.bZy = c1133a.bYD;
    }

    /* renamed from: zC */
    public final void mo14533zC() {
        super.mo14533zC();
        if (this.bZy) {
            C1148b.m2518zx().mo4376a((C1154c) this);
            this.bZw = new Handler(C1068b.m2358zL().getLooper());
        }
    }

    /* renamed from: zD */
    public final void mo14534zD() {
        super.mo14534zD();
        if (this.bZy) {
            C1148b.m2518zx().mo4377b((C1154c) this);
            if (this.bZx != null) {
                this.bZx.bZz.release();
            }
            this.bZw.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: c */
    public final void mo4389c(long j, long j2, long j3) {
        super.mo4389c(j, j2, j3);
        if (this.bZx != null) {
            this.bZw.removeCallbacks(this.bZx);
        }
        this.bZx = new C1155a(AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin"), j3);
        if (this.bYu.bYE) {
            C1070c.m2369v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", Long.valueOf(j3), Integer.valueOf(this.bZx.bZz.index));
        }
        this.bZw.postDelayed(this.bZx, 5000);
    }

    /* renamed from: a */
    public final void mo4382a(String str, long j, long j2, long j3, long j4) {
        if (this.bYu.bYE) {
            C1070c.m2369v("Matrix.AnrTracer", "--> [doFrame] activityName:%s frameCost:%sms [%s:%s:%s]ns", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
    }

    /* renamed from: a */
    public final void mo4388a(long j, long j2, long j3, long j4, long j5, boolean z) {
        super.mo4388a(j, j2, j3, j4, j5, z);
        if (this.bYu.bYE) {
            C1070c.m2369v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", Long.valueOf(j5), Long.valueOf(j3 - j), Long.valueOf(j4 - j2), C1167b.m2546p(j4 - j2, j3 - j));
        }
        if (this.bZx != null) {
            this.bZx.bZz.release();
            this.bZw.removeCallbacks(this.bZx);
        }
    }
}
