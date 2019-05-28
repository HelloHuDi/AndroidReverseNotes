package com.tencent.p177mm.audio.p195b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Arrays;

/* renamed from: com.tencent.mm.audio.b.d */
public final class C9040d extends C32303f {
    AudioRecord cpL;
    C1293a cpM;
    byte[] cpV = null;
    private int cpW;
    int cpX;
    private OnRecordPositionUpdateListener cpY = new C90411();
    boolean cpx;
    private HandlerThread mHandlerThread = null;
    boolean mIsMute;

    /* renamed from: com.tencent.mm.audio.b.d$1 */
    class C90411 implements OnRecordPositionUpdateListener {
        C90411() {
        }

        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        public final void onPeriodicNotification(AudioRecord audioRecord) {
            AppMethodBeat.m2504i(55745);
            if (C9040d.this.mIsPause) {
                AppMethodBeat.m2505o(55745);
                return;
            }
            if (C9040d.this.cpL != null) {
                if (C9040d.this.cpx || C9040d.this.cpV == null) {
                    C9040d.this.cpV = new byte[C9040d.this.cpX];
                }
                int read = C9040d.this.cpL.read(C9040d.this.cpV, 0, C9040d.this.cpX);
                C4990ab.m7410d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(read)));
                if (C9040d.this.cpT != null) {
                    C9040d.this.cpT.mo4589d(read, C9040d.this.cpV);
                }
                if (read > C9040d.this.cpV.length) {
                    read = C9040d.this.cpV.length;
                }
                if (C9040d.this.mIsMute && read > 0) {
                    Arrays.fill(C9040d.this.cpV, 0, read, (byte) 0);
                }
                if (C9040d.this.cpM != null && read > 0) {
                    C9040d.this.cpM.mo4601u(C9040d.this.cpV, read);
                }
            }
            AppMethodBeat.m2505o(55745);
        }
    }

    public C9040d(AudioRecord audioRecord, C1293a c1293a, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(55746);
        this.cpL = audioRecord;
        this.cpM = c1293a;
        this.cpx = z;
        this.cpW = i;
        this.cpX = i2;
        AppMethodBeat.m2505o(55746);
    }

    /* renamed from: EL */
    public final boolean mo20481EL() {
        AppMethodBeat.m2504i(55747);
        if (this.mHandlerThread != null) {
            C4990ab.m7412e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            AppMethodBeat.m2505o(55747);
            return false;
        }
        this.mHandlerThread = C7305d.m12297ek("RecordModeAsyncCallback_handlerThread", 10);
        this.mHandlerThread.start();
        this.cpL.setRecordPositionUpdateListener(this.cpY, C7306ak.fetchFreeHandler(this.mHandlerThread.getLooper()));
        this.cpL.setPositionNotificationPeriod(this.cpW);
        if (this.cpx || this.cpV == null) {
            this.cpV = new byte[this.cpX];
        }
        int read = this.cpL.read(this.cpV, 0, this.cpX);
        C4990ab.m7410d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(read)));
        if (this.cpM != null && read > 0) {
            this.cpM.mo4601u(this.cpV, read);
        }
        AppMethodBeat.m2505o(55747);
        return true;
    }

    public final void stopRecord() {
        AppMethodBeat.m2504i(55748);
        this.cpL.setRecordPositionUpdateListener(null);
        this.cpL = null;
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
        AppMethodBeat.m2505o(55748);
    }

    /* renamed from: bs */
    public final void mo20482bs(boolean z) {
        this.mIsMute = z;
    }
}
