package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class i implements c {
    private int audioSampleRate;
    private int fzS;
    a ovU;
    private ak ovX = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(76585);
            if (i.this.ovU != null) {
                i.this.ovU.WU();
                i.this.ovU = null;
            }
            AppMethodBeat.o(76585);
        }
    };
    private MediaRecorder owh;
    private boolean owi = false;

    public i(int i, int i2) {
        AppMethodBeat.i(76586);
        this.audioSampleRate = i;
        this.fzS = i2;
        ab.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(76586);
    }

    public final int q(int i, String str) {
        AppMethodBeat.i(76587);
        ab.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", str, Integer.valueOf(this.audioSampleRate));
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
            AppMethodBeat.o(76587);
            return 0;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "mediaRecorder prepare error: %s", e.getMessage());
            AppMethodBeat.o(76587);
            return -1;
        }
    }

    public final int a(a aVar) {
        AppMethodBeat.i(76588);
        ab.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", aVar);
        this.ovU = aVar;
        try {
            if (!(this.owh == null || this.owi)) {
                this.owh.start();
            }
            this.ovX.sendEmptyMessage(0);
            AppMethodBeat.o(76588);
            return 0;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "start record aac.mp4 error:%s", e.getMessage());
            this.ovX.sendEmptyMessage(0);
            AppMethodBeat.o(76588);
            return -1;
        } catch (Throwable th) {
            this.ovX.sendEmptyMessage(0);
            AppMethodBeat.o(76588);
        }
    }

    public final int a(b bVar) {
        AppMethodBeat.i(76589);
        ab.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", this.owh, bVar);
        if (this.owh == null) {
            if (bVar != null) {
                bVar.WT();
            }
            AppMethodBeat.o(76589);
            return 0;
        }
        try {
            if (!this.owi) {
                this.owh.stop();
                this.owh.release();
            }
            this.owh = null;
            if (bVar != null) {
                bVar.WT();
            }
            AppMethodBeat.o(76589);
            return 0;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "stop record aac.mp4 error:%s", e.getMessage());
            AppMethodBeat.o(76589);
            return -1;
        }
    }

    public final void clear() {
        AppMethodBeat.i(76590);
        try {
            if (this.owh != null) {
                if (!this.owi) {
                    this.owh.stop();
                    this.owh.release();
                }
                this.owh = null;
            }
            AppMethodBeat.o(76590);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.o(76590);
        }
    }

    public final void bPM() {
    }

    public final c.a bPN() {
        return null;
    }

    public final void iW(boolean z) {
        this.owi = z;
    }
}
