package com.tencent.p177mm.plugin.mmsight.model.p995b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mmsight.model.b.d */
public final class C28505d implements C46076a {
    private long bqO;
    private long eTA;
    private int eTJ = 0;
    private boolean fAA = false;
    private String fYM;
    private int frameCount = 0;
    private C46077h oxp;
    private byte[] oxq = null;
    private double oxr;
    private int videoFps;

    /* renamed from: e */
    public final int mo24485e(String str, long j, long j2, int i) {
        AppMethodBeat.m2504i(76701);
        C4990ab.m7417i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        this.fYM = str;
        this.bqO = j;
        this.eTA = j2;
        this.videoFps = i;
        this.oxr = 1000.0d / ((double) i);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(76701);
            return -1;
        }
        long yz = C5046bo.m7588yz();
        int ffmpegOpenAndSeekFileLock = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        C4990ab.m7417i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(76701);
        return ffmpegOpenAndSeekFileLock;
    }

    public final void bPZ() {
        AppMethodBeat.m2504i(76702);
        C4990ab.m7416i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.fAA = true;
        this.frameCount = 0;
        while (this.fAA) {
            long yz = C5046bo.m7588yz();
            this.oxq = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.oxq);
            C4990ab.m7411d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
            boolean ffmpegCheckIfReachEndTimestampLock = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
            this.frameCount++;
            if (this.eTJ <= 1 || this.frameCount % this.eTJ != 0) {
                if (this.oxp != null) {
                    C46077h c46077h = this.oxp;
                    byte[] bArr = this.oxq;
                    boolean z = this.oxq == null || ffmpegCheckIfReachEndTimestampLock;
                    c46077h.mo46468a(bArr, z, (long) ((((double) this.frameCount) * this.oxr) * 1000.0d));
                }
                if (this.oxq == null || ffmpegCheckIfReachEndTimestampLock) {
                    C4990ab.m7413e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestampLock));
                    C4990ab.m7417i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", Integer.valueOf(this.frameCount));
                    this.fAA = false;
                    AppMethodBeat.m2505o(76702);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(76702);
    }

    /* renamed from: a */
    public final void mo24481a(C46077h c46077h) {
        this.oxp = c46077h;
    }

    public final Point alJ() {
        AppMethodBeat.m2504i(76703);
        Point point = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
        AppMethodBeat.m2505o(76703);
        return point;
    }

    /* renamed from: mp */
    public final void mo24486mp(int i) {
        this.oxr = (double) i;
    }

    public final int alK() {
        return 2;
    }
}
