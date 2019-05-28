package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C12542a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C28499b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.i */
public final class C21299i implements C43303c {
    private int audioSampleRate;
    private int fzS;
    C12542a ovU;
    private C7306ak ovX = new C213001();
    private MediaRecorder owh;
    private boolean owi = false;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.i$1 */
    class C213001 extends C7306ak {
        C213001() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(76585);
            if (C21299i.this.ovU != null) {
                C21299i.this.ovU.mo14867WU();
                C21299i.this.ovU = null;
            }
            AppMethodBeat.m2505o(76585);
        }
    }

    public C21299i(int i, int i2) {
        AppMethodBeat.m2504i(76586);
        this.audioSampleRate = i;
        this.fzS = i2;
        C4990ab.m7417i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(76586);
    }

    /* renamed from: q */
    public final int mo20926q(int i, String str) {
        AppMethodBeat.m2504i(76587);
        C4990ab.m7417i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", str, Integer.valueOf(this.audioSampleRate));
        this.owh = new MediaRecorder();
        this.owh.setAudioSource(1);
        this.owh.setOutputFormat(2);
        this.owh.setAudioEncoder(3);
        this.owh.setAudioChannels(1);
        this.owh.setAudioEncodingBitRate(this.fzS);
        this.owh.setAudioSamplingRate(this.audioSampleRate);
        this.owh.setOutputFile(str);
        try {
            this.owh.prepare();
            AppMethodBeat.m2505o(76587);
            return 0;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "mediaRecorder prepare error: %s", e.getMessage());
            AppMethodBeat.m2505o(76587);
            return -1;
        }
    }

    /* renamed from: a */
    public final int mo36708a(C12542a c12542a) {
        AppMethodBeat.m2504i(76588);
        C4990ab.m7417i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", c12542a);
        this.ovU = c12542a;
        try {
            if (!(this.owh == null || this.owi)) {
                this.owh.start();
            }
            this.ovX.sendEmptyMessage(0);
            AppMethodBeat.m2505o(76588);
            return 0;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "start record aac.mp4 error:%s", e.getMessage());
            this.ovX.sendEmptyMessage(0);
            AppMethodBeat.m2505o(76588);
            return -1;
        } catch (Throwable th) {
            this.ovX.sendEmptyMessage(0);
            AppMethodBeat.m2505o(76588);
        }
    }

    /* renamed from: a */
    public final int mo36709a(C28499b c28499b) {
        AppMethodBeat.m2504i(76589);
        C4990ab.m7417i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", this.owh, c28499b);
        if (this.owh == null) {
            if (c28499b != null) {
                c28499b.mo14866WT();
            }
            AppMethodBeat.m2505o(76589);
            return 0;
        }
        try {
            if (!this.owi) {
                this.owh.stop();
                this.owh.release();
            }
            this.owh = null;
            if (c28499b != null) {
                c28499b.mo14866WT();
            }
            AppMethodBeat.m2505o(76589);
            return 0;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "stop record aac.mp4 error:%s", e.getMessage());
            AppMethodBeat.m2505o(76589);
            return -1;
        }
    }

    public final void clear() {
        AppMethodBeat.m2504i(76590);
        try {
            if (this.owh != null) {
                if (!this.owi) {
                    this.owh.stop();
                    this.owh.release();
                }
                this.owh = null;
            }
            AppMethodBeat.m2505o(76590);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.m2505o(76590);
        }
    }

    public final void bPM() {
    }

    public final C1293a bPN() {
        return null;
    }

    /* renamed from: iW */
    public final void mo36714iW(boolean z) {
        this.owi = z;
    }
}
