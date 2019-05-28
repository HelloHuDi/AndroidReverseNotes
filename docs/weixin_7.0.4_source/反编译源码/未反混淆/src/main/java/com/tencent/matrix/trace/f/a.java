package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.Thread.State;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends e {
    final com.tencent.matrix.trace.a.a bYu;
    private Handler bZw;
    volatile a bZx;
    private boolean bZy;

    class a implements Runnable {
        long bYW;
        com.tencent.matrix.trace.core.AppMethodBeat.a bZz;

        a(com.tencent.matrix.trace.core.AppMethodBeat.a aVar, long j) {
            this.bZz = aVar;
            this.bYW = j;
        }

        public final void run() {
            a.this.bZx = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            long[] copyData = AppMethodBeat.getInstance().copyData(this.bZz);
            this.bZz.release();
            long[] jArr = new long[]{com.tencent.matrix.d.a.getDalvikHeap(), com.tencent.matrix.d.a.getNativeHeap(), com.tencent.matrix.d.a.zJ()};
            State state = Looper.getMainLooper().getThread().getState();
            String a = b.a(Looper.getMainLooper().getThread().getStackTrace(), "|*        ", 12);
            com.tencent.matrix.trace.core.b zx = com.tencent.matrix.trace.core.b.zx();
            long p = zx.p(0, this.bYW);
            long p2 = zx.p(1, this.bYW);
            long p3 = zx.p(2, this.bYW);
            LinkedList linkedList = new LinkedList();
            if (copyData.length > 0) {
                com.tencent.matrix.trace.g.a.a(copyData, linkedList, true, uptimeMillis);
                com.tencent.matrix.trace.g.a.a((List) linkedList, new com.tencent.matrix.trace.g.a.a() {
                    public final boolean c(long j, int i) {
                        return j < ((long) (i * 5));
                    }

                    public final void e(List<com.tencent.matrix.trace.d.a> list, int i) {
                        c.w("Matrix.AnrTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), Integer.valueOf(30), list);
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
            long max = Math.max(5000, com.tencent.matrix.trace.g.a.a(linkedList, stringBuilder, stringBuilder2));
            String a2 = com.tencent.matrix.trace.g.a.a((List) linkedList, max);
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
            if (a.this.bYu.isDebug) {
                stringBuilder3.append(stringBuilder2.toString());
            }
            stringBuilder3.append("=========================================================================");
            objArr[0] = stringBuilder3.toString();
            objArr[1] = Long.valueOf(this.bYW);
            objArr[2] = Long.valueOf(uptimeMillis);
            c.w(str, str2, objArr);
            try {
                com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class);
                JSONObject a3 = com.tencent.matrix.d.a.a(new JSONObject(), com.tencent.matrix.a.yK().application);
                a3.put("detail", com.tencent.matrix.trace.b.a.a.ANR);
                a3.put("cost", max);
                a3.put("stackKey", a2);
                a3.put(SharePluginInfo.ISSUE_KEY_STACK, stringBuilder.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dalvik_heap", jArr[0]);
                jSONObject.put("native_heap", jArr[1]);
                jSONObject.put("vm_size", jArr[2]);
                a3.put("memory", jSONObject);
                com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b();
                bVar.key = this.bYW;
                bVar.tag = "Trace_EvilMethod";
                bVar.bWv = a3;
                aVar.onDetectIssue(bVar);
            } catch (JSONException e) {
                c.e("Matrix.AnrTracer", "[JSONException error: %s", e);
            }
        }
    }

    public a(com.tencent.matrix.trace.a.a aVar) {
        this.bYu = aVar;
        this.bZy = aVar.bYD;
    }

    public final void zC() {
        super.zC();
        if (this.bZy) {
            com.tencent.matrix.trace.core.b.zx().a((com.tencent.matrix.trace.e.c) this);
            this.bZw = new Handler(com.tencent.matrix.d.b.zL().getLooper());
        }
    }

    public final void zD() {
        super.zD();
        if (this.bZy) {
            com.tencent.matrix.trace.core.b.zx().b((com.tencent.matrix.trace.e.c) this);
            if (this.bZx != null) {
                this.bZx.bZz.release();
            }
            this.bZw.removeCallbacksAndMessages(null);
        }
    }

    public final void c(long j, long j2, long j3) {
        super.c(j, j2, j3);
        if (this.bZx != null) {
            this.bZw.removeCallbacks(this.bZx);
        }
        this.bZx = new a(AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin"), j3);
        if (this.bYu.bYE) {
            c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", Long.valueOf(j3), Integer.valueOf(this.bZx.bZz.index));
        }
        this.bZw.postDelayed(this.bZx, 5000);
    }

    public final void a(String str, long j, long j2, long j3, long j4) {
        if (this.bYu.bYE) {
            c.v("Matrix.AnrTracer", "--> [doFrame] activityName:%s frameCost:%sms [%s:%s:%s]ns", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
    }

    public final void a(long j, long j2, long j3, long j4, long j5, boolean z) {
        super.a(j, j2, j3, j4, j5, z);
        if (this.bYu.bYE) {
            c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", Long.valueOf(j5), Long.valueOf(j3 - j), Long.valueOf(j4 - j2), b.p(j4 - j2, j3 - j));
        }
        if (this.bZx != null) {
            this.bZx.bZz.release();
            this.bZw.removeCallbacks(this.bZx);
        }
    }
}
