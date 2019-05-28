package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b implements e {
    private long bqO;
    private long eTA;
    private int eTJ;
    private boolean fAA = false;
    private String fYM;
    private int frameCount = 0;
    private a oxF;
    private byte[] oxq = null;

    public final int i(String str, long j, long j2) {
        AppMethodBeat.i(3604);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", str, Long.valueOf(j), Long.valueOf(j2));
        this.fYM = str;
        this.bqO = j;
        this.eTA = j2;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(3604);
            return -1;
        }
        long yz = bo.yz();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(3604);
        return ffmpegOpenAndSeekFile;
    }

    public final void z(Runnable runnable) {
        AppMethodBeat.i(3605);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.fAA = true;
        this.frameCount = 0;
        while (this.fAA) {
            long yz = bo.yz();
            this.oxq = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.oxq);
            ab.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(bo.az(yz)));
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.oxq == null || ffmpegCheckIfReachEndTimestamp) {
                ab.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestamp));
                this.fAA = false;
                runnable.run();
                AppMethodBeat.o(3605);
                return;
            }
            this.frameCount++;
            if ((this.eTJ <= 1 || this.frameCount % this.eTJ != 0) && this.oxF != null) {
                this.oxF.ba(this.oxq);
            }
        }
        AppMethodBeat.o(3605);
    }

    public final void a(a aVar) {
        this.oxF = aVar;
    }

    public final Point alJ() {
        AppMethodBeat.i(3606);
        Point point = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
        AppMethodBeat.o(3606);
        return point;
    }

    public final void stop() {
        AppMethodBeat.i(3607);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", Boolean.valueOf(this.fAA));
        this.fAA = false;
        AppMethodBeat.o(3607);
    }

    public final int alK() {
        return 2;
    }

    public final void mp(int i) {
        AppMethodBeat.i(3608);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", Integer.valueOf(i));
        this.eTJ = i;
        AppMethodBeat.o(3608);
    }
}
