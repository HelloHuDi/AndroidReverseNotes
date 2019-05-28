package com.tencent.mm.media.g;

import a.f.b.j;
import a.l;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.a;
import com.tencent.mm.media.i.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0006J4\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u001cJ$\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006J\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006$"}, dWq = {"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "(JJI)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", "duration", "frameCount", "isRelease", "", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "size", "writeVideoData", "plugin-mediaeditor_release"})
public final class h {
    final String TAG = "MicroMsg.MixMuxerController";
    private int duration = ((int) (this.eXN - this.eXM));
    int eTa;
    boolean eWi;
    final long eXM;
    final long eXN;
    private final int eYm;
    int frameCount;

    public h(long j, long j2, int i) {
        AppMethodBeat.i(13082);
        this.eXM = j;
        this.eXN = j2;
        this.eYm = i;
        if (this.duration != 0) {
            this.eTa = SightVideoJNI.initDataBufferForRemux();
        }
        this.eWi = false;
        ab.i(this.TAG, "init endTime:" + this.eXN + ", startTime:" + this.eXM + ", duration:" + this.duration + ", bufId:" + this.eTa);
        AppMethodBeat.o(13082);
    }

    public final void c(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(13078);
        j.p(byteBuffer, "encodeData");
        if (this.eWi) {
            ab.e(this.TAG, "writeAACData, already release");
            AppMethodBeat.o(13078);
            return;
        }
        ab.i(this.TAG, "writeAACData: " + byteBuffer.capacity() + ", " + i + ", bufId:" + this.eTa);
        SightVideoJNI.writeAACDataLock(this.eTa, byteBuffer, i);
        AppMethodBeat.o(13078);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(a aVar, String str, int i, int i2, boolean z) {
        AppMethodBeat.i(13079);
        j.p(aVar, "mediaExtractor");
        j.p(str, "muxOuputFilePath");
        if (this.eWi) {
            ab.e(this.TAG, "output, already release");
            AppMethodBeat.o(13079);
            return -1;
        } else if (this.frameCount <= 0) {
            ab.e(this.TAG, "output, no write h264 frame!!");
            c cVar = c.faj;
            c.Wb();
            AppMethodBeat.o(13079);
            return -1;
        } else {
            int i3;
            int integer;
            int i4;
            float f;
            if (i == 0 || i2 == 0) {
                i3 = aVar.eWd;
                String UW = aVar.UW();
                MediaFormat mediaFormat = aVar.eWf;
                if (!(i3 < 0 || mediaFormat == null || bo.isNullOrNil(UW))) {
                    i2 = mediaFormat.getInteger("channel-count");
                    integer = mediaFormat.getInteger("sample-rate");
                    i4 = i2;
                    f = (((float) this.frameCount) * 1000.0f) / ((float) this.duration);
                    ab.i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.eYm + ", finalChannelCount:" + i4 + ", finalSampleRate:" + integer + ", outputPath:" + str + ", bufId:" + this.eTa);
                    i3 = SightVideoJNI.muxingLock(this.eTa, null, integer, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, 0, str, f, Math.max(1000, this.duration), this.eYm, b.qwW, 8, 2, 23.0f, null, 0, false, z);
                    release();
                    if (i3 < 0) {
                        c cVar2 = c.faj;
                        c.Wc();
                    }
                    AppMethodBeat.o(13079);
                    return i3;
                }
            }
            integer = i;
            i4 = i2;
            f = (((float) this.frameCount) * 1000.0f) / ((float) this.duration);
            ab.i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.eYm + ", finalChannelCount:" + i4 + ", finalSampleRate:" + integer + ", outputPath:" + str + ", bufId:" + this.eTa);
            i3 = SightVideoJNI.muxingLock(this.eTa, null, integer, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, 0, str, f, Math.max(1000, this.duration), this.eYm, b.qwW, 8, 2, 23.0f, null, 0, false, z);
            release();
            if (i3 < 0) {
            }
            AppMethodBeat.o(13079);
            return i3;
        }
    }

    private void release() {
        AppMethodBeat.i(13080);
        SightVideoJNI.releaseDataBuffer(this.eTa);
        this.eWi = true;
        AppMethodBeat.o(13080);
    }

    public final void a(a aVar, long j, long j2) {
        AppMethodBeat.i(13081);
        if (aVar == null) {
            AppMethodBeat.o(13081);
        } else if (this.eWi) {
            ab.e(this.TAG, "writeAudioData, already release");
            AppMethodBeat.o(13081);
        } else {
            int i = aVar.eWd;
            String UW = aVar.UW();
            MediaFormat mediaFormat = aVar.eWf;
            if (i < 0 || mediaFormat == null || bo.isNullOrNil(UW)) {
                AppMethodBeat.o(13081);
                return;
            }
            ab.i(this.TAG, "writeAudioData, startTime: ".concat(String.valueOf(j)));
            aVar.UU();
            if (j > 0) {
                aVar.seek(1000 * j);
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(mediaFormat.getInteger("max-input-size"));
            while (true) {
                allocateDirect.clear();
                j.o(allocateDirect, "dstBuf");
                aVar.k(allocateDirect);
                int i2 = aVar.sampleSize;
                ab.d(this.TAG, "sampleSize: %d", Integer.valueOf(i2));
                if (i2 <= 0) {
                    ab.i(this.TAG, "muxAudio size = %d. Saw eos.", Integer.valueOf(i2));
                    AppMethodBeat.o(13081);
                    return;
                }
                long sampleTime = aVar.getSampleTime();
                ab.i(this.TAG, "aac pts:".concat(String.valueOf(sampleTime)));
                if (sampleTime >= 1000 * j2 || sampleTime < 0) {
                    ab.i(this.TAG, "pts exceed endTime");
                    AppMethodBeat.o(13081);
                } else if (aVar.eWb.getSampleTrackIndex() != i) {
                    ab.e(this.TAG, "track index not match! break");
                    AppMethodBeat.o(13081);
                    return;
                } else if (sampleTime < 1000 * j) {
                    ab.i(this.TAG, "not reach start");
                } else {
                    allocateDirect.position(0);
                    c(allocateDirect, i2);
                }
            }
            ab.i(this.TAG, "pts exceed endTime");
            AppMethodBeat.o(13081);
        }
    }
}
