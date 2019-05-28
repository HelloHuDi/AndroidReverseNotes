package com.tencent.matrix.trace.p175f;

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
import com.tencent.mrs.p656b.C5774a.C5773a;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.trace.f.b */
public final class C7468b extends C6293e {
    final C1133a bYH;
    private C1141a bZC;
    private long[] bZD = new long[3];
    private long bZE;
    private boolean bZF;

    /* renamed from: com.tencent.matrix.trace.f.b$a */
    class C1157a implements Runnable {
        long[] bZG;
        long bZH;
        long bZI;
        long bZJ;
        long[] bZh;

        /* renamed from: com.tencent.matrix.trace.f.b$a$1 */
        class C11581 implements C1165a {
            C11581() {
            }

            /* renamed from: c */
            public final boolean mo4391c(long j, int i) {
                return j < ((long) (i * 5));
            }

            /* renamed from: e */
            public final void mo4392e(List<C1151a> list, int i) {
                C1070c.m2370w("Matrix.EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), Integer.valueOf(30), list);
                ListIterator listIterator = list.listIterator(Math.min(i, 30));
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }
        }

        C1157a(long[] jArr, long[] jArr2, long j, long j2, long j3) {
            this.bZI = j2;
            this.bZH = j;
            this.bZG = jArr;
            this.bZh = jArr2;
            this.bZJ = j3;
        }

        public final void run() {
            String p = C1167b.m2546p(this.bZH, this.bZI);
            List linkedList = new LinkedList();
            if (this.bZG.length > 0) {
                C1166a.m2541a(this.bZG, linkedList, true, this.bZJ);
                C1166a.m2540a(linkedList, new C11581());
            }
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            long max = Math.max(this.bZI, C1166a.m2538a(linkedList, stringBuilder, stringBuilder2));
            String a = C1166a.m2539a(linkedList, max);
            String str = "Matrix.EvilMethodTracer";
            String str2 = "%s";
            Object[] objArr = new Object[1];
            long size = (long) linkedList.size();
            long j = this.bZh[0];
            long j2 = this.bZh[1];
            long j3 = this.bZh[2];
            long j4 = this.bZI;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(String.format(" \n>>>>>>>>>>>>>>>>>>>>> maybe happens Jankiness!(%sms) <<<<<<<<<<<<<<<<<<<<<\n", new Object[]{Long.valueOf(j4)}));
            stringBuilder3.append("|* [CPU]\n");
            stringBuilder3.append("|*   usage: ").append(p).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|* [Memory]\n");
            stringBuilder3.append("|* [doFrame]\n");
            stringBuilder3.append("|*   inputCost: ").append(j).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|*   animationCost: ").append(j2).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|*   traversalCost: ").append(j3).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|* [Trace]\n");
            stringBuilder3.append("|*   StackSize: ").append(size).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder3.append("|*   StackKey: ").append(a).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (C7468b.this.bYH.isDebug) {
                stringBuilder3.append(stringBuilder2.toString());
            }
            stringBuilder3.append("=========================================================================");
            objArr[0] = stringBuilder3.toString();
            C1070c.m2370w(str, str2, objArr);
            try {
                C7466a c7466a = (C7466a) C1060a.m2339yK().mo4192F(C7466a.class);
                JSONObject a2 = C1067a.m2349a(new JSONObject(), C1060a.m2339yK().application);
                a2.put("detail", C1134a.NORMAL);
                a2.put("cost", max);
                a2.put("usage", p);
                a2.put(SharePluginInfo.ISSUE_KEY_STACK, stringBuilder.toString());
                a2.put("stackKey", a);
                C1062b c1062b = new C1062b();
                c1062b.tag = "Trace_EvilMethod";
                c1062b.bWv = a2;
                c7466a.onDetectIssue(c1062b);
            } catch (JSONException e) {
                C1070c.m2367e("Matrix.EvilMethodTracer", "[JSONException error: %s", e);
            }
        }
    }

    public C7468b(C1133a c1133a) {
        int i = 1000;
        this.bYH = c1133a;
        if (c1133a.bWX != null) {
            i = c1133a.bWX.get(C5773a.clicfg_matrix_trace_evil_method_threshold.name(), 1000);
        }
        this.bZE = (long) i;
        this.bZF = c1133a.bYB;
    }

    /* renamed from: zC */
    public final void mo14533zC() {
        super.mo14533zC();
        if (this.bZF) {
            C1148b.m2518zx().mo4376a((C1154c) this);
        }
    }

    /* renamed from: zD */
    public final void mo14534zD() {
        super.mo14534zD();
        if (this.bZF) {
            C1148b.m2518zx().mo4377b((C1154c) this);
        }
    }

    /* renamed from: c */
    public final void mo4389c(long j, long j2, long j3) {
        super.mo4389c(j, j2, j3);
        this.bZC = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
    }

    /* renamed from: a */
    public final void mo4382a(String str, long j, long j2, long j3, long j4) {
        this.bZD[0] = j2;
        this.bZD[1] = j3;
        this.bZD[2] = j4;
    }

    /* renamed from: a */
    public final void mo4388a(long j, long j2, long j3, long j4, long j5, boolean z) {
        super.mo4388a(j, j2, j3, j4, j5, z);
        long currentTimeMillis = this.bYH.bYE ? System.currentTimeMillis() : 0;
        try {
            if (j3 - j >= this.bZE) {
                long[] copyData = AppMethodBeat.getInstance().copyData(this.bZC);
                long[] jArr = new long[3];
                System.arraycopy(this.bZD, 0, jArr, 0, 3);
                C1068b.m2359zM().post(new C1157a(copyData, jArr, j4 - j2, j3 - j, j3));
            }
            this.bZC.release();
            if (this.bYH.bYE) {
                String p = C1167b.m2546p(j4 - j2, j3 - j);
                C1070c.m2369v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", Long.valueOf(j5), Long.valueOf(j3 - j), Long.valueOf(j4 - j2), p, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Throwable th) {
            this.bZC.release();
            if (this.bYH.bYE) {
                String p2 = C1167b.m2546p(j4 - j2, j3 - j);
                C1070c.m2369v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", Long.valueOf(j5), Long.valueOf(j3 - j), Long.valueOf(j4 - j2), p2, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }
}
