package com.tencent.mm.media.a;

import a.v;
import a.y;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001IBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\u0010\fJ \u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0018H\u0002J*\u00102\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020+J\u000e\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020$J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\t2\u0006\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020\u000bH\u0002J\b\u0010=\u001a\u00020\u000bH\u0002J\u001a\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020+H\u0002J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010B\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020\u000bH\u0002J\u0018\u0010D\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020+H\u0002J\b\u0010E\u001a\u00020\u000bH\u0002J\u001a\u0010F\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020+H\u0002J\u0018\u0010G\u001a\u00020\u00182\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010)H\u0016J\b\u0010H\u001a\u00020\u0018H\u0016R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "Lcom/tencent/mm/media/codec/IAudioCodec;", "bufId", "", "mixType", "sampleRate", "channelCount", "onFrameEncode", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Landroid/media/MediaCodec$BufferInfo;", "", "(IIIILkotlin/jvm/functions/Function2;)V", "TAG", "", "cacheAACFilePath", "decodeBackgroundFrameCount", "decodeMusicFrameCount", "encodeFrameCount", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "isBackgroundDecodeEnd", "", "isDecodeEnd", "isMusicDecodeEnd", "mAudioEncoder", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mAudioMixCodec", "Lcom/tencent/mm/media/mix/AudioMixCodec;", "mBackgroundDecoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mBackgroundDecoderRunnable", "Ljava/lang/Runnable;", "mMediaFormat", "Landroid/media/MediaFormat;", "mMusicDecoder", "mMusicDecoderRunnable", "mixCount", "mixFinishCallback", "Lkotlin/Function0;", "mixStartTime", "", "useAsync", "checkPostEncoder", "data", "", "pts", "isEnd", "initDecoder", "background", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "music", "startTime", "endTime", "initEncoder", "mediaFormat", "onAudioFrameEncode", "bufferInfo", "onAudioFrameEncodeEnd", "onBackgroundDecodeEnd", "onBackgroundFrameDecodeEnd", "pcmData", "onDecodeEnd", "isBackground", "onEncodeEnd", "onFrameMix", "onFrameMixEnd", "onMusicDecodeEnd", "onMusicFrameDecodeEnd", "startCodec", "stopCodec", "EncoderData", "plugin-mediaeditor_release"})
public final class a {
    public final String TAG;
    public final int aOn = 1;
    private int cmI;
    public com.tencent.mm.media.c.a eSI;
    public com.tencent.mm.media.c.a eSJ;
    public com.tencent.mm.media.d.a eSK;
    public com.tencent.mm.media.f.a eSL;
    private volatile boolean eSM;
    private boolean eSN;
    private boolean eSO;
    public HandlerThread eSP;
    private ak eSQ;
    public a.f.a.a<y> eSR;
    private final String eSS;
    private int eST;
    private int eSU;
    private int eSV;
    public Runnable eSW;
    public Runnable eSX;
    public boolean eSY;
    public long eSZ;
    private final int eTa;
    public int eTb;
    private final a.f.a.m<ByteBuffer, BufferInfo, y> eTc;
    public MediaFormat mMediaFormat;
    public final int sampleRate;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/media/codec/MediaCodecAACCodec$EncoderData;", "", "data", "", "pts", "", "isEnd", "", "([BJZ)V", "getData", "()[B", "()Z", "getPts", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
    public static final class a {
        final byte[] data;
        final long eTe;
        final boolean eTf;

        /* JADX WARNING: Missing block: B:13:0x002b, code skipped:
            if ((r7.eTf == r8.eTf) != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(12815);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (a.f.b.j.j(this.data, aVar.data)) {
                        if (this.eTe == aVar.eTe) {
                        }
                    }
                }
                AppMethodBeat.o(12815);
                return false;
            }
            AppMethodBeat.o(12815);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(12814);
            byte[] bArr = this.data;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            long j = this.eTe;
            int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
            hashCode = this.eTf;
            if (hashCode != 0) {
                hashCode = 1;
            }
            hashCode += i;
            AppMethodBeat.o(12814);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(12813);
            String str = "EncoderData(data=" + Arrays.toString(this.data) + ", pts=" + this.eTe + ", isEnd=" + this.eTf + ")";
            AppMethodBeat.o(12813);
            return str;
        }

        public a(byte[] bArr, long j, boolean z) {
            a.f.b.j.p(bArr, "data");
            AppMethodBeat.i(12812);
            this.data = bArr;
            this.eTe = j;
            this.eTf = z;
            AppMethodBeat.o(12812);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class i extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public i(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12823);
            a.b(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12823);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    public static final class j extends a.f.b.k implements a.f.a.m<byte[], Long, y> {
        final /* synthetic */ a eTd;

        public j(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12824);
            a.c(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            y yVar = y.AUy;
            AppMethodBeat.o(12824);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    public static final class l extends a.f.b.k implements a.f.a.m<byte[], Long, y> {
        final /* synthetic */ a eTd;

        public l(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12826);
            a.c(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            y yVar = y.AUy;
            AppMethodBeat.o(12826);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class c extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public c(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12817);
            a.a(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12817);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class s extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public s(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12833);
            ab.i(this.eTd.TAG, "startCodec BackgroundDecoder");
            this.eTd.eSW.run();
            y yVar = y.AUy;
            AppMethodBeat.o(12833);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class b implements com.tencent.mm.sdk.platformtools.ak.a {
        final /* synthetic */ a eTd;

        b(a aVar) {
            this.eTd = aVar;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(12816);
            if (message.what == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                Object obj = message.obj;
                if (obj == null) {
                    v vVar = new v("null cannot be cast to non-null type com.tencent.mm.media.codec.MediaCodecAACCodec.EncoderData");
                    AppMethodBeat.o(12816);
                    throw vVar;
                }
                a aVar = (a) obj;
                ab.i(this.eTd.TAG, "start encode data " + aVar.data.length + ", islast: " + aVar.eTf);
                com.tencent.mm.media.d.a aVar2 = this.eTd.eSK;
                if (aVar2 == null) {
                    a.f.b.j.avw("mAudioEncoder");
                }
                aVar2.b(aVar.data, aVar.eTe, aVar.eTf);
            }
            AppMethodBeat.o(12816);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class r implements Runnable {
        final /* synthetic */ a eTd;

        r(a aVar) {
            this.eTd = aVar;
        }

        public final void run() {
            AppMethodBeat.i(12832);
            com.tencent.mm.media.c.a aVar = this.eTd.eSI;
            if (aVar != null) {
                aVar.Uz();
                AppMethodBeat.o(12832);
                return;
            }
            AppMethodBeat.o(12832);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class k extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public k(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12825);
            a.c(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12825);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class d extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public d(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12818);
            a.c(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12818);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class g extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public g(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12821);
            a.b(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12821);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class t extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public t(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12834);
            ab.i(this.eTd.TAG, "startCodec MusicDecoder");
            this.eTd.eSX.run();
            y yVar = y.AUy;
            AppMethodBeat.o(12834);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "audioData", "", "pts", "", "invoke"})
    public static final class e extends a.f.b.k implements a.f.a.m<byte[], Long, y> {
        final /* synthetic */ a eTd;

        public e(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12819);
            byte[] bArr = (byte[]) obj;
            long longValue = ((Number) obj2).longValue();
            a.f.b.j.p(bArr, "audioData");
            a.a(this.eTd, bArr, longValue);
            y yVar = y.AUy;
            AppMethodBeat.o(12819);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    public static final class f extends a.f.b.k implements a.f.a.m<byte[], Long, y> {
        final /* synthetic */ a eTd;

        public f(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12820);
            a.b(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            y yVar = y.AUy;
            AppMethodBeat.o(12820);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    public static final class o extends a.f.b.k implements a.f.a.m<ByteBuffer, BufferInfo, y> {
        final /* synthetic */ a eTd;

        public o(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12829);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            a.f.b.j.p(byteBuffer, "pcmData");
            a.f.b.j.p(bufferInfo, "bufferInfo");
            a.a(this.eTd, byteBuffer, bufferInfo);
            y yVar = y.AUy;
            AppMethodBeat.o(12829);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$1 */
    static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        AnonymousClass1(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12810);
            a.a(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12810);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    public static final class h extends a.f.b.k implements a.f.a.m<byte[], Long, y> {
        final /* synthetic */ a eTd;

        public h(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12822);
            a.b(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            y yVar = y.AUy;
            AppMethodBeat.o(12822);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class n extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public n(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12828);
            a.d(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12828);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class q implements Runnable {
        final /* synthetic */ a eTd;

        q(a aVar) {
            this.eTd = aVar;
        }

        public final void run() {
            AppMethodBeat.i(12831);
            com.tencent.mm.media.c.a aVar = this.eTd.eSJ;
            if (aVar != null) {
                aVar.Uz();
                AppMethodBeat.o(12831);
                return;
            }
            AppMethodBeat.o(12831);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "audioData", "", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$2 */
    static final class AnonymousClass2 extends a.f.b.k implements a.f.a.m<byte[], Long, y> {
        final /* synthetic */ a eTd;

        AnonymousClass2(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12811);
            byte[] bArr = (byte[]) obj;
            long longValue = ((Number) obj2).longValue();
            a.f.b.j.p(bArr, "audioData");
            a.a(this.eTd, bArr, longValue);
            y yVar = y.AUy;
            AppMethodBeat.o(12811);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    public static final class m extends a.f.b.k implements a.f.a.m<ByteBuffer, BufferInfo, y> {
        final /* synthetic */ a eTd;

        public m(a aVar) {
            this.eTd = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(12827);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            a.f.b.j.p(byteBuffer, "pcmData");
            a.f.b.j.p(bufferInfo, "bufferInfo");
            a.a(this.eTd, byteBuffer, bufferInfo);
            y yVar = y.AUy;
            AppMethodBeat.o(12827);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class p extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ a eTd;

        public p(a aVar) {
            this.eTd = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12830);
            a.d(this.eTd);
            y yVar = y.AUy;
            AppMethodBeat.o(12830);
            return yVar;
        }
    }

    public a(int i, int i2, int i3, a.f.a.m<? super ByteBuffer, ? super BufferInfo, y> mVar) {
        AppMethodBeat.i(12837);
        this.eTa = i;
        this.eTb = i2;
        this.sampleRate = i3;
        this.eTc = mVar;
        this.TAG = "MicroMsg.MediaCodecAACCodec";
        HandlerThread anM = com.tencent.mm.sdk.g.d.anM("MediaCodecAACCodec_EncodeThread");
        a.f.b.j.o(anM, "ThreadPool.newFreeHandle…ecAACCodec_EncodeThread\")");
        this.eSP = anM;
        this.eSS = com.tencent.mm.loader.j.b.eSn + "cache.pcm";
        this.eSW = new q(this);
        this.eSX = new r(this);
        ab.i(this.TAG, "init MediaCodecAACCodec, sampleRate:" + this.sampleRate + ", channelCount:" + this.aOn);
        this.eSL = new com.tencent.mm.media.f.a(this.sampleRate, this.aOn, a.a.l.listOf(Integer.valueOf(3), Integer.valueOf(1)).contains(Integer.valueOf(this.eTb)), a.a.l.listOf(Integer.valueOf(2), Integer.valueOf(3)).contains(Integer.valueOf(this.eTb)), new AnonymousClass1(this), new AnonymousClass2(this));
        AppMethodBeat.o(12837);
    }

    private final void a(byte[] bArr, long j, boolean z) {
        AppMethodBeat.i(12835);
        if (this.eSQ == null) {
            this.eSP.start();
            this.eSQ = new ak(this.eSP.getLooper(), (com.tencent.mm.sdk.platformtools.ak.a) new b(this));
        }
        ak akVar = this.eSQ;
        Message obtainMessage = akVar != null ? akVar.obtainMessage() : null;
        if (obtainMessage != null) {
            obtainMessage.what = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        a.f.b.j.o(copyOf, "Arrays.copyOf(data, data.size)");
        a aVar = new a(copyOf, j, z);
        if (obtainMessage != null) {
            obtainMessage.obj = aVar;
        }
        ak akVar2 = this.eSQ;
        if (akVar2 != null) {
            akVar2.sendMessage(obtainMessage);
            AppMethodBeat.o(12835);
            return;
        }
        AppMethodBeat.o(12835);
    }

    private final synchronized void co(boolean z) {
        AppMethodBeat.i(12836);
        ab.c(this.TAG, "onDecodeEnd, isDecodeEnd:" + this.eSM + ", isBackground:" + z, new Object[0]);
        if (z) {
            this.eSO = true;
        } else {
            this.eSN = true;
        }
        com.tencent.mm.media.c.a aVar;
        if (this.eTb == 3 && this.eSN && this.eSO) {
            if (!this.eSM) {
                this.eSM = true;
                aVar = this.eSI;
                if (aVar != null) {
                    aVar.UA();
                }
                aVar = this.eSJ;
                if (aVar != null) {
                    aVar.UA();
                }
                a(new byte[0], bo.yz(), true);
                AppMethodBeat.o(12836);
            }
            AppMethodBeat.o(12836);
        } else {
            if (this.eTb == 2 && this.eSN && !this.eSM) {
                this.eSM = true;
                aVar = this.eSI;
                if (aVar != null) {
                    aVar.UA();
                    AppMethodBeat.o(12836);
                }
            }
            AppMethodBeat.o(12836);
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(12838);
        ab.i(aVar.TAG, "onFrameMix");
        AppMethodBeat.o(12838);
    }

    public static final /* synthetic */ void b(a aVar, byte[] bArr, long j) {
        AppMethodBeat.i(12840);
        ab.i(aVar.TAG, "on background frame decode, isDecodeEnd:" + aVar.eSM);
        if (!aVar.eSM) {
            aVar.eSU++;
            if (bArr != null) {
                ab.i(aVar.TAG, "input background data");
                com.tencent.mm.media.c.a aVar2 = aVar.eSJ;
                if (aVar2 != null) {
                    com.tencent.mm.media.f.a aVar3 = aVar.eSL;
                    if (aVar3 != null) {
                        aVar3.a(bArr, "background", j, aVar2.eTt, aVar2.eTs);
                        AppMethodBeat.o(12840);
                        return;
                    }
                    AppMethodBeat.o(12840);
                    return;
                }
            }
        }
        AppMethodBeat.o(12840);
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(12841);
        ab.i(aVar.TAG, "on background decode end");
        com.tencent.mm.media.f.a aVar2 = aVar.eSL;
        if (aVar2 != null) {
            aVar2.lV("background");
        }
        aVar.co(true);
        AppMethodBeat.o(12841);
    }

    public static final /* synthetic */ void c(a aVar, byte[] bArr, long j) {
        AppMethodBeat.i(12842);
        ab.i(aVar.TAG, "on music frame decode, isDecodeEnd:" + aVar.eSM);
        if (!(aVar.eSM && aVar.eSV == aVar.eSU)) {
            aVar.eSV++;
            if (bArr != null) {
                com.tencent.mm.media.c.a aVar2 = aVar.eSI;
                if (aVar2 != null) {
                    com.tencent.mm.media.f.a aVar3 = aVar.eSL;
                    if (aVar3 != null) {
                        aVar3.a(bArr, "music", j, aVar2.eTt, aVar2.eTs);
                    }
                }
                ab.i(aVar.TAG, "input music data");
            }
        }
        AppMethodBeat.o(12842);
    }

    public static final /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(12843);
        ab.i(aVar.TAG, "on music decode end");
        com.tencent.mm.media.f.a aVar2 = aVar.eSL;
        if (aVar2 != null) {
            aVar2.lV("music");
        }
        aVar.co(false);
        AppMethodBeat.o(12843);
    }

    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(12845);
        ab.i(aVar.TAG, "onFrameEncodeEnd, mixCount:" + aVar.cmI);
        com.tencent.mm.media.f.a aVar2 = aVar.eSL;
        if (aVar2 != null) {
            y yVar;
            ab.i(aVar2.TAG, "stopMix");
            List list = aVar2.eWp;
            a.f.b.j.o(list, "pcmDataList");
            synchronized (list) {
                try {
                    aVar2.eWp.clear();
                    yVar = y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.o(12845);
                }
            }
            synchronized (aVar2.eWt) {
                try {
                    aVar2.eWs = true;
                    try {
                        aVar2.eWt.notifyAll();
                    } catch (Exception e) {
                    }
                    yVar = y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.o(12845);
                }
            }
            ab.i(aVar2.TAG, "isMixingFinish1 " + aVar2.eWq);
            if (!aVar2.eWq) {
                synchronized (aVar2.eWu) {
                    try {
                        if (!aVar2.eWq) {
                            ab.i(aVar2.TAG, "isMixingFinish2 " + aVar2.eWq);
                            aVar2.eWu.wait();
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        yVar = y.AUy;
                    } catch (Throwable th3) {
                        AppMethodBeat.o(12845);
                    }
                }
            }
            byte[] Ec = aVar2.eWk.Ec();
            aVar2.eWk.release();
            ab.i(aVar2.TAG, "stopMix, final dstAudio:" + (Ec != null ? Ec.length : 0));
            if (Ec != null) {
                aVar2.eWD.m(Ec, Long.valueOf(aVar2.eWm));
            } else {
                aVar2.eWD.m(new byte[0], Long.valueOf(aVar2.eWm));
            }
            ab.i(aVar2.TAG, "stopMix finish");
        }
        com.tencent.mm.media.d.a aVar3 = aVar.eSK;
        if (aVar3 == null) {
            a.f.b.j.avw("mAudioEncoder");
        }
        aVar3.stopEncoder();
        aVar3 = aVar.eSK;
        if (aVar3 == null) {
            a.f.b.j.avw("mAudioEncoder");
        }
        aVar3.UO();
        a.f.a.a aVar4 = aVar.eSR;
        if (aVar4 != null) {
            aVar4.invoke();
            AppMethodBeat.o(12845);
            return;
        }
        AppMethodBeat.o(12845);
    }
}
