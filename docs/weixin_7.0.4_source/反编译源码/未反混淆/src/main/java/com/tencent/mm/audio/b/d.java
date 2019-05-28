package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Arrays;

public final class d extends f {
    AudioRecord cpL;
    a cpM;
    byte[] cpV = null;
    private int cpW;
    int cpX;
    private OnRecordPositionUpdateListener cpY = new OnRecordPositionUpdateListener() {
        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        public final void onPeriodicNotification(AudioRecord audioRecord) {
            AppMethodBeat.i(55745);
            if (d.this.mIsPause) {
                AppMethodBeat.o(55745);
                return;
            }
            if (d.this.cpL != null) {
                if (d.this.cpx || d.this.cpV == null) {
                    d.this.cpV = new byte[d.this.cpX];
                }
                int read = d.this.cpL.read(d.this.cpV, 0, d.this.cpX);
                ab.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(read)));
                if (d.this.cpT != null) {
                    d.this.cpT.d(read, d.this.cpV);
                }
                if (read > d.this.cpV.length) {
                    read = d.this.cpV.length;
                }
                if (d.this.mIsMute && read > 0) {
                    Arrays.fill(d.this.cpV, 0, read, (byte) 0);
                }
                if (d.this.cpM != null && read > 0) {
                    d.this.cpM.u(d.this.cpV, read);
                }
            }
            AppMethodBeat.o(55745);
        }
    };
    boolean cpx;
    private HandlerThread mHandlerThread = null;
    boolean mIsMute;

    public d(AudioRecord audioRecord, a aVar, boolean z, int i, int i2) {
        AppMethodBeat.i(55746);
        this.cpL = audioRecord;
        this.cpM = aVar;
        this.cpx = z;
        this.cpW = i;
        this.cpX = i2;
        AppMethodBeat.o(55746);
    }

    public final boolean EL() {
        AppMethodBeat.i(55747);
        if (this.mHandlerThread != null) {
            ab.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            AppMethodBeat.o(55747);
            return false;
        }
        this.mHandlerThread = com.tencent.mm.sdk.g.d.ek("RecordModeAsyncCallback_handlerThread", 10);
        this.mHandlerThread.start();
        this.cpL.setRecordPositionUpdateListener(this.cpY, ak.fetchFreeHandler(this.mHandlerThread.getLooper()));
        this.cpL.setPositionNotificationPeriod(this.cpW);
        if (this.cpx || this.cpV == null) {
            this.cpV = new byte[this.cpX];
        }
        int read = this.cpL.read(this.cpV, 0, this.cpX);
        ab.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(read)));
        if (this.cpM != null && read > 0) {
            this.cpM.u(this.cpV, read);
        }
        AppMethodBeat.o(55747);
        return true;
    }

    public final void stopRecord() {
        AppMethodBeat.i(55748);
        this.cpL.setRecordPositionUpdateListener(null);
        this.cpL = null;
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
        AppMethodBeat.o(55748);
    }

    public final void bs(boolean z) {
        this.mIsMute = z;
    }
}
