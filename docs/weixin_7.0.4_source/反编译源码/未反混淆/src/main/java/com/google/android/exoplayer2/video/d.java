package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
public final class d {
    final a bsL;
    final boolean bsM;
    final long bsN;
    final long bsO;
    long bsP;
    long bsQ;
    long bsR;
    boolean bsS;
    long bsT;
    long bsU;
    long bsV;

    static final class a implements Callback, FrameCallback {
        private static final a bsX = new a();
        public volatile long bsW;
        private final HandlerThread bsY = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer bsZ;
        private int bta;
        final Handler handler;

        static {
            AppMethodBeat.i(96034);
            AppMethodBeat.o(96034);
        }

        public static a tZ() {
            return bsX;
        }

        private a() {
            AppMethodBeat.i(96031);
            this.bsY.start();
            this.handler = new Handler(this.bsY.getLooper(), this);
            this.handler.sendEmptyMessage(0);
            AppMethodBeat.o(96031);
        }

        public final void doFrame(long j) {
            AppMethodBeat.i(96032);
            this.bsW = j;
            this.bsZ.postFrameCallbackDelayed(this, 500);
            AppMethodBeat.o(96032);
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(96033);
            switch (message.what) {
                case 0:
                    this.bsZ = Choreographer.getInstance();
                    AppMethodBeat.o(96033);
                    return true;
                case 1:
                    this.bta++;
                    if (this.bta == 1) {
                        this.bsZ.postFrameCallback(this);
                    }
                    AppMethodBeat.o(96033);
                    return true;
                case 2:
                    this.bta--;
                    if (this.bta == 0) {
                        this.bsZ.removeFrameCallback(this);
                        this.bsW = 0;
                    }
                    AppMethodBeat.o(96033);
                    return true;
                default:
                    AppMethodBeat.o(96033);
                    return false;
            }
        }
    }

    public d() {
        this(-1.0d);
    }

    public d(Context context) {
        double refreshRate;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager.getDefaultDisplay() != null) {
            refreshRate = (double) windowManager.getDefaultDisplay().getRefreshRate();
        } else {
            refreshRate = -1.0d;
        }
        this(refreshRate);
        AppMethodBeat.i(96035);
        AppMethodBeat.o(96035);
    }

    private d(double d) {
        AppMethodBeat.i(96036);
        this.bsM = d != -1.0d;
        if (this.bsM) {
            this.bsL = a.tZ();
            this.bsN = (long) (1.0E9d / d);
            this.bsO = (this.bsN * 80) / 100;
            AppMethodBeat.o(96036);
            return;
        }
        this.bsL = null;
        this.bsN = -1;
        this.bsO = -1;
        AppMethodBeat.o(96036);
    }

    /* Access modifiers changed, original: final */
    public final boolean m(long j, long j2) {
        AppMethodBeat.i(96037);
        if (Math.abs((j2 - this.bsT) - (j - this.bsU)) > 20000000) {
            AppMethodBeat.o(96037);
            return true;
        }
        AppMethodBeat.o(96037);
        return false;
    }
}
