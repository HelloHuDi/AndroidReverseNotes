package com.tencent.p177mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.C46082e.C12578a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.b */
public final class C12574b implements C46082e {
    private long bqO;
    private long eTA;
    private int eTJ;
    private boolean fAA = false;
    private String fYM;
    private int frameCount = 0;
    private C12578a oxF;
    private byte[] oxq = null;

    /* renamed from: i */
    public final int mo24498i(String str, long j, long j2) {
        AppMethodBeat.m2504i(3604);
        C4990ab.m7417i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", str, Long.valueOf(j), Long.valueOf(j2));
        this.fYM = str;
        this.bqO = j;
        this.eTA = j2;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(3604);
            return -1;
        }
        long yz = C5046bo.m7588yz();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        C4990ab.m7417i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(3604);
        return ffmpegOpenAndSeekFile;
    }

    /* renamed from: z */
    public final void mo24501z(Runnable runnable) {
        AppMethodBeat.m2504i(3605);
        C4990ab.m7416i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.fAA = true;
        this.frameCount = 0;
        while (this.fAA) {
            long yz = C5046bo.m7588yz();
            this.oxq = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.oxq);
            C4990ab.m7411d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.oxq == null || ffmpegCheckIfReachEndTimestamp) {
                C4990ab.m7413e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestamp));
                this.fAA = false;
                runnable.run();
                AppMethodBeat.m2505o(3605);
                return;
            }
            this.frameCount++;
            if ((this.eTJ <= 1 || this.frameCount % this.eTJ != 0) && this.oxF != null) {
                this.oxF.mo24511ba(this.oxq);
            }
        }
        AppMethodBeat.m2505o(3605);
    }

    /* renamed from: a */
    public final void mo24495a(C12578a c12578a) {
        this.oxF = c12578a;
    }

    public final Point alJ() {
        AppMethodBeat.m2504i(3606);
        Point point = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
        AppMethodBeat.m2505o(3606);
        return point;
    }

    public final void stop() {
        AppMethodBeat.m2504i(3607);
        C4990ab.m7417i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", Boolean.valueOf(this.fAA));
        this.fAA = false;
        AppMethodBeat.m2505o(3607);
    }

    public final int alK() {
        return 2;
    }

    /* renamed from: mp */
    public final void mo24499mp(int i) {
        AppMethodBeat.m2504i(3608);
        C4990ab.m7417i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", Integer.valueOf(i));
        this.eTJ = i;
        AppMethodBeat.m2505o(3608);
    }
}
