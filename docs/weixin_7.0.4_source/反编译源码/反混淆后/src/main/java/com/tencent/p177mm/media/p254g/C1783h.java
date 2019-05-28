package com.tencent.p177mm.media.p254g;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0006J4\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u001cJ$\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006J\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006$"}, dWq = {"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "(JJI)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", "duration", "frameCount", "isRelease", "", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "size", "writeVideoData", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.g.h */
public final class C1783h {
    final String TAG = "MicroMsg.MixMuxerController";
    private int duration = ((int) (this.eXN - this.eXM));
    int eTa;
    boolean eWi;
    final long eXM;
    final long eXN;
    private final int eYm;
    int frameCount;

    public C1783h(long j, long j2, int i) {
        AppMethodBeat.m2504i(13082);
        this.eXM = j;
        this.eXN = j2;
        this.eYm = i;
        if (this.duration != 0) {
            this.eTa = SightVideoJNI.initDataBufferForRemux();
        }
        this.eWi = false;
        C4990ab.m7416i(this.TAG, "init endTime:" + this.eXN + ", startTime:" + this.eXM + ", duration:" + this.duration + ", bufId:" + this.eTa);
        AppMethodBeat.m2505o(13082);
    }

    /* renamed from: c */
    public final void mo5331c(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(13078);
        C25052j.m39376p(byteBuffer, "encodeData");
        if (this.eWi) {
            C4990ab.m7412e(this.TAG, "writeAACData, already release");
            AppMethodBeat.m2505o(13078);
            return;
        }
        C4990ab.m7416i(this.TAG, "writeAACData: " + byteBuffer.capacity() + ", " + i + ", bufId:" + this.eTa);
        SightVideoJNI.writeAACDataLock(this.eTa, byteBuffer, i);
        AppMethodBeat.m2505o(13078);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo5329a(C32742a c32742a, String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(13079);
        C25052j.m39376p(c32742a, "mediaExtractor");
        C25052j.m39376p(str, "muxOuputFilePath");
        if (this.eWi) {
            C4990ab.m7412e(this.TAG, "output, already release");
            AppMethodBeat.m2505o(13079);
            return -1;
        } else if (this.frameCount <= 0) {
            C4990ab.m7412e(this.TAG, "output, no write h264 frame!!");
            C18594c c18594c = C18594c.faj;
            C18594c.m28986Wb();
            AppMethodBeat.m2505o(13079);
            return -1;
        } else {
            int i3;
            int integer;
            int i4;
            float f;
            if (i == 0 || i2 == 0) {
                i3 = c32742a.eWd;
                String UW = c32742a.mo53293UW();
                MediaFormat mediaFormat = c32742a.eWf;
                if (!(i3 < 0 || mediaFormat == null || C5046bo.isNullOrNil(UW))) {
                    i2 = mediaFormat.getInteger("channel-count");
                    integer = mediaFormat.getInteger("sample-rate");
                    i4 = i2;
                    f = (((float) this.frameCount) * 1000.0f) / ((float) this.duration);
                    C4990ab.m7416i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.eYm + ", finalChannelCount:" + i4 + ", finalSampleRate:" + integer + ", outputPath:" + str + ", bufId:" + this.eTa);
                    i3 = SightVideoJNI.muxingLock(this.eTa, null, integer, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, 0, str, f, Math.max(1000, this.duration), this.eYm, C29014b.qwW, 8, 2, 23.0f, null, 0, false, z);
                    release();
                    if (i3 < 0) {
                        C18594c c18594c2 = C18594c.faj;
                        C18594c.m28987Wc();
                    }
                    AppMethodBeat.m2505o(13079);
                    return i3;
                }
            }
            integer = i;
            i4 = i2;
            f = (((float) this.frameCount) * 1000.0f) / ((float) this.duration);
            C4990ab.m7416i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.eYm + ", finalChannelCount:" + i4 + ", finalSampleRate:" + integer + ", outputPath:" + str + ", bufId:" + this.eTa);
            i3 = SightVideoJNI.muxingLock(this.eTa, null, integer, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, 0, str, f, Math.max(1000, this.duration), this.eYm, C29014b.qwW, 8, 2, 23.0f, null, 0, false, z);
            release();
            if (i3 < 0) {
            }
            AppMethodBeat.m2505o(13079);
            return i3;
        }
    }

    private void release() {
        AppMethodBeat.m2504i(13080);
        SightVideoJNI.releaseDataBuffer(this.eTa);
        this.eWi = true;
        AppMethodBeat.m2505o(13080);
    }

    /* renamed from: a */
    public final void mo5330a(C32742a c32742a, long j, long j2) {
        AppMethodBeat.m2504i(13081);
        if (c32742a == null) {
            AppMethodBeat.m2505o(13081);
        } else if (this.eWi) {
            C4990ab.m7412e(this.TAG, "writeAudioData, already release");
            AppMethodBeat.m2505o(13081);
        } else {
            int i = c32742a.eWd;
            String UW = c32742a.mo53293UW();
            MediaFormat mediaFormat = c32742a.eWf;
            if (i < 0 || mediaFormat == null || C5046bo.isNullOrNil(UW)) {
                AppMethodBeat.m2505o(13081);
                return;
            }
            C4990ab.m7416i(this.TAG, "writeAudioData, startTime: ".concat(String.valueOf(j)));
            c32742a.mo53291UU();
            if (j > 0) {
                c32742a.seek(1000 * j);
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(mediaFormat.getInteger("max-input-size"));
            while (true) {
                allocateDirect.clear();
                C25052j.m39375o(allocateDirect, "dstBuf");
                c32742a.mo53296k(allocateDirect);
                int i2 = c32742a.sampleSize;
                C4990ab.m7411d(this.TAG, "sampleSize: %d", Integer.valueOf(i2));
                if (i2 <= 0) {
                    C4990ab.m7417i(this.TAG, "muxAudio size = %d. Saw eos.", Integer.valueOf(i2));
                    AppMethodBeat.m2505o(13081);
                    return;
                }
                long sampleTime = c32742a.getSampleTime();
                C4990ab.m7416i(this.TAG, "aac pts:".concat(String.valueOf(sampleTime)));
                if (sampleTime >= 1000 * j2 || sampleTime < 0) {
                    C4990ab.m7416i(this.TAG, "pts exceed endTime");
                    AppMethodBeat.m2505o(13081);
                } else if (c32742a.eWb.getSampleTrackIndex() != i) {
                    C4990ab.m7412e(this.TAG, "track index not match! break");
                    AppMethodBeat.m2505o(13081);
                    return;
                } else if (sampleTime < 1000 * j) {
                    C4990ab.m7416i(this.TAG, "not reach start");
                } else {
                    allocateDirect.position(0);
                    mo5331c(allocateDirect, i2);
                }
            }
            C4990ab.m7416i(this.TAG, "pts exceed endTime");
            AppMethodBeat.m2505o(13081);
        }
    }
}
