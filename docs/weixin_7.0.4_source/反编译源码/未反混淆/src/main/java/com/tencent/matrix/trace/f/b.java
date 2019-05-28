package com.tencent.matrix.trace.f;

import com.tencent.matrix.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends e {
    final com.tencent.matrix.trace.a.a bYH;
    private com.tencent.matrix.trace.core.AppMethodBeat.a bZC;
    private long[] bZD = new long[3];
    private long bZE;
    private boolean bZF;

    class a implements Runnable {
        long[] bZG;
        long bZH;
        long bZI;
        long bZJ;
        long[] bZh;

        a(long[] jArr, long[] jArr2, long j, long j2, long j3) {
            this.bZI = j2;
            this.bZH = j;
            this.bZG = jArr;
            this.bZh = jArr2;
            this.bZJ = j3;
        }

        public final void run() {
            String p = com.tencent.matrix.trace.g.b.p(this.bZH, this.bZI);
            List linkedList = new LinkedList();
            if (this.bZG.length > 0) {
                com.tencent.matrix.trace.g.a.a(this.bZG, linkedList, true, this.bZJ);
                com.tencent.matrix.trace.g.a.a(linkedList, new com.tencent.matrix.trace.g.a.a() {
                    public final boolean c(long j, int i) {
                        return j < ((long) (i * 5));
                    }

                    public final void e(List<com.tencent.matrix.trace.d.a> list, int i) {
                        c.w("Matrix.EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), Integer.valueOf(30), list);
                        ListIterator listIterator = list.listIterator(Math.min(i, 30));
                        while (listIterator.hasNext()) {
                            listIterator.next();
                            listIterator.remove();
                        }
                    }
                });
            }
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            long max = Math.max(this.bZI, com.tencent.matrix.trace.g.a.a(linkedList, stringBuilder, stringBuilder2));
            String a = com.tencent.matrix.trace.g.a.a(linkedList, max);
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
            if (b.this.bYH.isDebug) {
                stringBuilder3.append(stringBuilder2.toString());
            }
            stringBuilder3.append("=========================================================================");
            objArr[0] = stringBuilder3.toString();
            c.w(str, str2, objArr);
            try {
                com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class);
                JSONObject a2 = com.tencent.matrix.d.a.a(new JSONObject(), com.tencent.matrix.a.yK().application);
                a2.put("detail", com.tencent.matrix.trace.b.a.a.NORMAL);
                a2.put("cost", max);
                a2.put("usage", p);
                a2.put(SharePluginInfo.ISSUE_KEY_STACK, stringBuilder.toString());
                a2.put("stackKey", a);
                com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b();
                bVar.tag = "Trace_EvilMethod";
                bVar.bWv = a2;
                aVar.onDetectIssue(bVar);
            } catch (JSONException e) {
                c.e("Matrix.EvilMethodTracer", "[JSONException error: %s", e);
            }
        }
    }

    public b(com.tencent.matrix.trace.a.a aVar) {
        int i = 1000;
        this.bYH = aVar;
        if (aVar.bWX != null) {
            i = aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_trace_evil_method_threshold.name(), 1000);
        }
        this.bZE = (long) i;
        this.bZF = aVar.bYB;
    }

    public final void zC() {
        super.zC();
        if (this.bZF) {
            com.tencent.matrix.trace.core.b.zx().a((com.tencent.matrix.trace.e.c) this);
        }
    }

    public final void zD() {
        super.zD();
        if (this.bZF) {
            com.tencent.matrix.trace.core.b.zx().b((com.tencent.matrix.trace.e.c) this);
        }
    }

    public final void c(long j, long j2, long j3) {
        super.c(j, j2, j3);
        this.bZC = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
    }

    public final void a(String str, long j, long j2, long j3, long j4) {
        this.bZD[0] = j2;
        this.bZD[1] = j3;
        this.bZD[2] = j4;
    }

    public final void a(long j, long j2, long j3, long j4, long j5, boolean z) {
        super.a(j, j2, j3, j4, j5, z);
        long currentTimeMillis = this.bYH.bYE ? System.currentTimeMillis() : 0;
        try {
            if (j3 - j >= this.bZE) {
                long[] copyData = AppMethodBeat.getInstance().copyData(this.bZC);
                long[] jArr = new long[3];
                System.arraycopy(this.bZD, 0, jArr, 0, 3);
                com.tencent.matrix.d.b.zM().post(new a(copyData, jArr, j4 - j2, j3 - j, j3));
            }
            this.bZC.release();
            if (this.bYH.bYE) {
                String p = com.tencent.matrix.trace.g.b.p(j4 - j2, j3 - j);
                c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", Long.valueOf(j5), Long.valueOf(j3 - j), Long.valueOf(j4 - j2), p, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Throwable th) {
            this.bZC.release();
            if (this.bYH.bYE) {
                String p2 = com.tencent.matrix.trace.g.b.p(j4 - j2, j3 - j);
                c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", Long.valueOf(j5), Long.valueOf(j3 - j), Long.valueOf(j4 - j2), p2, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }
}
