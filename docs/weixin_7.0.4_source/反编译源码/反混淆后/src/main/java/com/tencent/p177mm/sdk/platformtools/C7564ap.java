package com.tencent.p177mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.ap */
public class C7564ap extends C7306ak {
    private static int xyU;
    private final boolean hZl;
    private boolean mStop = false;
    private final int xyV;
    private long xzC = 0;
    private final C5015a xzD;

    /* renamed from: com.tencent.mm.sdk.platformtools.ap$a */
    public interface C5015a {
        /* renamed from: BI */
        boolean mo4499BI();
    }

    public C7564ap(C5015a c5015a, boolean z) {
        AppMethodBeat.m2504i(52157);
        this.xzD = c5015a;
        this.xyV = C7564ap.doS();
        this.hZl = z;
        if (getLooper().getThread().getName().equals("initThread")) {
            C4990ab.m7413e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", C5046bo.dpG());
        }
        AppMethodBeat.m2505o(52157);
    }

    public C7564ap(Looper looper, C5015a c5015a, boolean z) {
        super(looper);
        AppMethodBeat.m2504i(52158);
        this.xzD = c5015a;
        this.xyV = C7564ap.doS();
        this.hZl = z;
        if (looper.getThread().getName().equals("initThread")) {
            C4990ab.m7413e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", C5046bo.dpG());
        }
        AppMethodBeat.m2505o(52158);
    }

    private static int doS() {
        if (xyU >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            xyU = 0;
        }
        int i = xyU + 1;
        xyU = i;
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(52159);
        stopTimer();
        super.finalize();
        AppMethodBeat.m2505o(52159);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.m2504i(52160);
        if (message.what == this.xyV) {
            if (this.xzD == null) {
                AppMethodBeat.m2505o(52160);
                return;
            } else if (!this.xzD.mo4499BI()) {
                AppMethodBeat.m2505o(52160);
                return;
            } else if (this.hZl && !this.mStop) {
                sendEmptyMessageDelayed(this.xyV, this.xzC);
            }
        }
        AppMethodBeat.m2505o(52160);
    }

    /* renamed from: ms */
    public final void mo16773ms(long j) {
        AppMethodBeat.m2504i(138963);
        mo16770ae(j, j);
        AppMethodBeat.m2505o(138963);
    }

    public final void stopTimer() {
        AppMethodBeat.m2504i(52162);
        removeMessages(this.xyV);
        this.mStop = true;
        AppMethodBeat.m2505o(52162);
    }

    /* renamed from: ae */
    public final void mo16770ae(long j, long j2) {
        AppMethodBeat.m2504i(52163);
        this.xzC = j2;
        stopTimer();
        this.mStop = false;
        sendEmptyMessageDelayed(this.xyV, j);
        AppMethodBeat.m2505o(52163);
    }

    public final boolean doT() {
        AppMethodBeat.m2504i(52164);
        if (this.mStop || !hasMessages(this.xyV)) {
            AppMethodBeat.m2505o(52164);
            return true;
        }
        AppMethodBeat.m2505o(52164);
        return false;
    }

    public String toString() {
        AppMethodBeat.m2504i(52165);
        String str;
        if (this.xzD == null) {
            str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
            AppMethodBeat.m2505o(52165);
            return str;
        }
        str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.xzD.getClass().getName() + "}";
        AppMethodBeat.m2505o(52165);
        return str;
    }
}
