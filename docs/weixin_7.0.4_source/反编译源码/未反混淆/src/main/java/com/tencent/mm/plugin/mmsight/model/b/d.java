package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d implements a {
    private long bqO;
    private long eTA;
    private int eTJ = 0;
    private boolean fAA = false;
    private String fYM;
    private int frameCount = 0;
    private h oxp;
    private byte[] oxq = null;
    private double oxr;
    private int videoFps;

    public final int e(String str, long j, long j2, int i) {
        AppMethodBeat.i(76701);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        this.fYM = str;
        this.bqO = j;
        this.eTA = j2;
        this.videoFps = i;
        this.oxr = 1000.0d / ((double) i);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(76701);
            return -1;
        }
        long yz = bo.yz();
        int ffmpegOpenAndSeekFileLock = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(76701);
        return ffmpegOpenAndSeekFileLock;
    }

    public final void bPZ() {
        AppMethodBeat.i(76702);
        ab.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.fAA = true;
        this.frameCount = 0;
        while (this.fAA) {
            long yz = bo.yz();
            this.oxq = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.oxq);
            ab.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(bo.az(yz)));
            boolean ffmpegCheckIfReachEndTimestampLock = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
            this.frameCount++;
            if (this.eTJ <= 1 || this.frameCount % this.eTJ != 0) {
                if (this.oxp != null) {
                    h hVar = this.oxp;
                    byte[] bArr = this.oxq;
                    boolean z = this.oxq == null || ffmpegCheckIfReachEndTimestampLock;
                    hVar.a(bArr, z, (long) ((((double) this.frameCount) * this.oxr) * 1000.0d));
                }
                if (this.oxq == null || ffmpegCheckIfReachEndTimestampLock) {
                    ab.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestampLock));
                    ab.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", Integer.valueOf(this.frameCount));
                    this.fAA = false;
                    AppMethodBeat.o(76702);
                    return;
                }
            }
        }
        AppMethodBeat.o(76702);
    }

    public final void a(h hVar) {
        this.oxp = hVar;
    }

    public final Point alJ() {
        AppMethodBeat.i(76703);
        Point point = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
        AppMethodBeat.o(76703);
        return point;
    }

    public final void mp(int i) {
        this.oxr = (double) i;
    }

    public final int alK() {
        return 2;
    }
}
