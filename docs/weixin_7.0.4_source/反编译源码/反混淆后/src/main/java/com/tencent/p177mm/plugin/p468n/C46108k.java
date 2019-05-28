package com.tencent.p177mm.plugin.p468n;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.n.k */
public final class C46108k extends C12693h {
    Surface aOO;
    float iac = 1.0f;
    boolean osn = false;
    private boolean oso = false;
    boolean osp = false;
    private long osq = 0;
    long osr = -1;
    private int videoHeight;
    private int videoWidth;

    public C46108k(C3546g c3546g, C7306ak c7306ak) {
        super(c3546g, c7306ak);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo24680a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(117908);
        C4990ab.m7411d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", aZm(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (C46107d.m86024yF(this.state)) {
            C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", aZm());
            mediaCodec.releaseOutputBuffer(i, true);
            setState(4);
            AppMethodBeat.m2505o(117908);
            return true;
        } else if (C46107d.m86023yE(this.state)) {
            Object obj;
            C4990ab.m7411d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", aZm(), Long.valueOf(bufferInfo.presentationTimeUs / 1000), Long.valueOf(j), Long.valueOf(j - (bufferInfo.presentationTimeUs / 1000)));
            if (j - (bufferInfo.presentationTimeUs / 1000) <= 30) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", aZm());
                mediaCodec.releaseOutputBuffer(i, true);
                if (this.oso) {
                    setState(7);
                    this.oso = false;
                }
                this.oso = true;
            } else {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            AppMethodBeat.m2505o(117908);
            return true;
        } else if (C46107d.m86025yG(this.state)) {
            long j3 = bufferInfo.presentationTimeUs / 1000;
            long elapsedRealtime = (long) (((((float) j3) / this.iac) - ((float) j)) - ((float) (SystemClock.elapsedRealtime() - j2)));
            C4990ab.m7411d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", aZm(), Long.valueOf(elapsedRealtime), Long.valueOf(r6), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
            if (elapsedRealtime < -30) {
                C4990ab.m7411d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", aZm());
                mediaCodec.releaseOutputBuffer(i, false);
                this.orH.orC = 0;
                AppMethodBeat.m2505o(117908);
                return true;
            } else if (elapsedRealtime < 30) {
                this.orH.orz = bufferInfo.presentationTimeUs;
                if (elapsedRealtime > 11) {
                    try {
                        Thread.sleep(elapsedRealtime - 10);
                    } catch (Exception e) {
                    }
                }
                if (C46107d.m86025yG(this.state)) {
                    if (Math.abs(j3 - this.osq) > 1000) {
                        C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", aZm(), Integer.valueOf(i), Long.valueOf(j3));
                        this.osq = j3;
                    }
                    mediaCodec.releaseOutputBuffer(i, true);
                    AppMethodBeat.m2505o(117908);
                    return true;
                }
                C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", aZm(), Integer.valueOf(this.state));
                AppMethodBeat.m2505o(117908);
                return false;
            } else {
                C4990ab.m7411d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", aZm());
                AppMethodBeat.m2505o(117908);
                return false;
            }
        } else {
            C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", aZm(), Integer.valueOf(this.state));
            AppMethodBeat.m2505o(117908);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final String type() {
        return "video";
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo24683b(MediaCodec mediaCodec) {
        AppMethodBeat.m2504i(117909);
        if (mediaCodec == null) {
            AppMethodBeat.m2505o(117909);
        } else {
            MediaFormat mediaFormat;
            if (this.aOO == null) {
                C4990ab.m7421w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", aZm());
                this.osn = false;
            } else {
                this.osn = true;
            }
            C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", aZm());
            if (this.clX == null) {
                mediaFormat = this.orM;
            } else {
                mediaFormat = this.clX.getTrackFormat(this.orN);
            }
            mediaCodec.configure(mediaFormat, this.aOO, null, 0);
            AppMethodBeat.m2505o(117909);
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo24686c(MediaCodec mediaCodec) {
        AppMethodBeat.m2504i(117910);
        C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s output format changed", aZm());
        mediaCodec.setVideoScalingMode(1);
        AppMethodBeat.m2505o(117910);
    }

    /* Access modifiers changed, original: final */
    @TargetApi(23)
    public final void bPe() {
        AppMethodBeat.m2504i(117911);
        try {
            if (this.eTq != null) {
                this.eTq.setOutputSurface(this.aOO);
            }
            AppMethodBeat.m2505o(117911);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoTrackDataSource", e, "%s change surface23 error [%s]", aZm(), e.toString());
            bPf();
            AppMethodBeat.m2505o(117911);
        }
    }

    /* Access modifiers changed, original: final */
    public final void bPf() {
        AppMethodBeat.m2504i(117912);
        C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", aZm());
        if (this.eTq != null) {
            mo24692sI();
            mo24677N(this.orH.orz, -1);
            bOZ();
        }
        AppMethodBeat.m2505o(117912);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo24682b(MediaFormat mediaFormat, String str, int i) {
        int integer;
        int i2;
        AppMethodBeat.m2504i(117913);
        super.mo24682b(mediaFormat, str, i);
        this.videoHeight = mediaFormat.getInteger("height");
        this.videoWidth = mediaFormat.getInteger("width");
        if (mediaFormat.containsKey("rotation-degrees")) {
            integer = mediaFormat.getInteger("rotation-degrees");
            i2 = 1;
        } else {
            integer = SightVideoJNI.getMp4Rotate(this.path);
            C4990ab.m7421w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", aZm(), Integer.valueOf(integer));
            i2 = 0;
        }
        if (Math.abs(integer) == 90 || Math.abs(integer) == 270) {
            int i3 = this.videoWidth;
            this.videoWidth = this.videoHeight;
            this.videoHeight = i3;
        }
        if (i2 != 0) {
            integer = 0;
        }
        this.orI.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(integer)).sendToTarget();
        C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", aZm(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(integer));
        AppMethodBeat.m2505o(117913);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: R */
    public final boolean mo24678R(int i, long j) {
        AppMethodBeat.m2504i(117914);
        C4990ab.m7411d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", aZm(), Integer.valueOf(i), Boolean.valueOf(this.orH.llI));
        if (this.orH.llI && i == 1 && this.osr != j) {
            boolean N = mo24677N(j, -1);
            this.osr = j;
            AppMethodBeat.m2505o(117914);
            return N;
        }
        AppMethodBeat.m2505o(117914);
        return false;
    }
}
