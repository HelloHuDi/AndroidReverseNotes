package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ap extends ak {
    private static int xyU;
    private final boolean hZl;
    private boolean mStop = false;
    private final int xyV;
    private long xzC = 0;
    private final a xzD;

    public interface a {
        boolean BI();
    }

    public ap(a aVar, boolean z) {
        AppMethodBeat.i(52157);
        this.xzD = aVar;
        this.xyV = doS();
        this.hZl = z;
        if (getLooper().getThread().getName().equals("initThread")) {
            ab.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bo.dpG());
        }
        AppMethodBeat.o(52157);
    }

    public ap(Looper looper, a aVar, boolean z) {
        super(looper);
        AppMethodBeat.i(52158);
        this.xzD = aVar;
        this.xyV = doS();
        this.hZl = z;
        if (looper.getThread().getName().equals("initThread")) {
            ab.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bo.dpG());
        }
        AppMethodBeat.o(52158);
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
        AppMethodBeat.i(52159);
        stopTimer();
        super.finalize();
        AppMethodBeat.o(52159);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(52160);
        if (message.what == this.xyV) {
            if (this.xzD == null) {
                AppMethodBeat.o(52160);
                return;
            } else if (!this.xzD.BI()) {
                AppMethodBeat.o(52160);
                return;
            } else if (this.hZl && !this.mStop) {
                sendEmptyMessageDelayed(this.xyV, this.xzC);
            }
        }
        AppMethodBeat.o(52160);
    }

    public final void ms(long j) {
        AppMethodBeat.i(138963);
        ae(j, j);
        AppMethodBeat.o(138963);
    }

    public final void stopTimer() {
        AppMethodBeat.i(52162);
        removeMessages(this.xyV);
        this.mStop = true;
        AppMethodBeat.o(52162);
    }

    public final void ae(long j, long j2) {
        AppMethodBeat.i(52163);
        this.xzC = j2;
        stopTimer();
        this.mStop = false;
        sendEmptyMessageDelayed(this.xyV, j);
        AppMethodBeat.o(52163);
    }

    public final boolean doT() {
        AppMethodBeat.i(52164);
        if (this.mStop || !hasMessages(this.xyV)) {
            AppMethodBeat.o(52164);
            return true;
        }
        AppMethodBeat.o(52164);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(52165);
        String str;
        if (this.xzD == null) {
            str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
            AppMethodBeat.o(52165);
            return str;
        }
        str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.xzD.getClass().getName() + "}";
        AppMethodBeat.o(52165);
        return str;
    }
}
