package com.tencent.p177mm.media.p250a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.media.p253f.C1774a;
import com.tencent.p177mm.media.p865c.C18580a;
import com.tencent.p177mm.media.p866d.C37887a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001IBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\u0010\fJ \u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0018H\u0002J*\u00102\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020+J\u000e\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020$J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\t2\u0006\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020\u000bH\u0002J\b\u0010=\u001a\u00020\u000bH\u0002J\u001a\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020+H\u0002J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010B\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020\u000bH\u0002J\u0018\u0010D\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020+H\u0002J\b\u0010E\u001a\u00020\u000bH\u0002J\u001a\u0010F\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020+H\u0002J\u0018\u0010G\u001a\u00020\u00182\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010)H\u0016J\b\u0010H\u001a\u00020\u0018H\u0016R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "Lcom/tencent/mm/media/codec/IAudioCodec;", "bufId", "", "mixType", "sampleRate", "channelCount", "onFrameEncode", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Landroid/media/MediaCodec$BufferInfo;", "", "(IIIILkotlin/jvm/functions/Function2;)V", "TAG", "", "cacheAACFilePath", "decodeBackgroundFrameCount", "decodeMusicFrameCount", "encodeFrameCount", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "isBackgroundDecodeEnd", "", "isDecodeEnd", "isMusicDecodeEnd", "mAudioEncoder", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mAudioMixCodec", "Lcom/tencent/mm/media/mix/AudioMixCodec;", "mBackgroundDecoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mBackgroundDecoderRunnable", "Ljava/lang/Runnable;", "mMediaFormat", "Landroid/media/MediaFormat;", "mMusicDecoder", "mMusicDecoderRunnable", "mixCount", "mixFinishCallback", "Lkotlin/Function0;", "mixStartTime", "", "useAsync", "checkPostEncoder", "data", "", "pts", "isEnd", "initDecoder", "background", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "music", "startTime", "endTime", "initEncoder", "mediaFormat", "onAudioFrameEncode", "bufferInfo", "onAudioFrameEncodeEnd", "onBackgroundDecodeEnd", "onBackgroundFrameDecodeEnd", "pcmData", "onDecodeEnd", "isBackground", "onEncodeEnd", "onFrameMix", "onFrameMixEnd", "onMusicDecodeEnd", "onMusicFrameDecodeEnd", "startCodec", "stopCodec", "EncoderData", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.a.a */
public final class C18562a {
    public final String TAG;
    public final int aOn = 1;
    private int cmI;
    public C18580a eSI;
    public C18580a eSJ;
    public C37887a eSK;
    public C1774a eSL;
    private volatile boolean eSM;
    private boolean eSN;
    private boolean eSO;
    public HandlerThread eSP;
    private C7306ak eSQ;
    public C31214a<C37091y> eSR;
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
    private final C31591m<ByteBuffer, BufferInfo, C37091y> eTc;
    public MediaFormat mMediaFormat;
    public final int sampleRate;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/media/codec/MediaCodecAACCodec$EncoderData;", "", "data", "", "pts", "", "isEnd", "", "([BJZ)V", "getData", "()[B", "()Z", "getPts", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.a.a$a */
    public static final class C1768a {
        final byte[] data;
        final long eTe;
        final boolean eTf;

        /* JADX WARNING: Missing block: B:13:0x002b, code skipped:
            if ((r7.eTf == r8.eTf) != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(12815);
            if (this != obj) {
                if (obj instanceof C1768a) {
                    C1768a c1768a = (C1768a) obj;
                    if (C25052j.m39373j(this.data, c1768a.data)) {
                        if (this.eTe == c1768a.eTe) {
                        }
                    }
                }
                AppMethodBeat.m2505o(12815);
                return false;
            }
            AppMethodBeat.m2505o(12815);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(12814);
            byte[] bArr = this.data;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            long j = this.eTe;
            int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
            hashCode = this.eTf;
            if (hashCode != 0) {
                hashCode = 1;
            }
            hashCode += i;
            AppMethodBeat.m2505o(12814);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(12813);
            String str = "EncoderData(data=" + Arrays.toString(this.data) + ", pts=" + this.eTe + ", isEnd=" + this.eTf + ")";
            AppMethodBeat.m2505o(12813);
            return str;
        }

        public C1768a(byte[] bArr, long j, boolean z) {
            C25052j.m39376p(bArr, "data");
            AppMethodBeat.m2504i(12812);
            this.data = bArr;
            this.eTe = j;
            this.eTf = z;
            AppMethodBeat.m2505o(12812);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$i */
    public static final class C1769i extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C1769i(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12823);
            C18562a.m28915b(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12823);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$j */
    public static final class C1770j extends C25053k implements C31591m<byte[], Long, C37091y> {
        final /* synthetic */ C18562a eTd;

        public C1770j(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12824);
            C18562a.m28918c(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12824);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$l */
    public static final class C9578l extends C25053k implements C31591m<byte[], Long, C37091y> {
        final /* synthetic */ C18562a eTd;

        public C9578l(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12826);
            C18562a.m28918c(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12826);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$c */
    public static final class C18560c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18560c(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12817);
            C18562a.m28911a(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12817);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$s */
    public static final class C18561s extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18561s(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12833);
            C4990ab.m7416i(this.eTd.TAG, "startCodec BackgroundDecoder");
            this.eTd.eSW.run();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12833);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    /* renamed from: com.tencent.mm.media.a.a$b */
    static final class C18563b implements C4998a {
        final /* synthetic */ C18562a eTd;

        C18563b(C18562a c18562a) {
            this.eTd = c18562a;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(12816);
            if (message.what == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                Object obj = message.obj;
                if (obj == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.media.codec.MediaCodecAACCodec.EncoderData");
                    AppMethodBeat.m2505o(12816);
                    throw c44941v;
                }
                C1768a c1768a = (C1768a) obj;
                C4990ab.m7416i(this.eTd.TAG, "start encode data " + c1768a.data.length + ", islast: " + c1768a.eTf);
                C37887a c37887a = this.eTd.eSK;
                if (c37887a == null) {
                    C25052j.avw("mAudioEncoder");
                }
                c37887a.mo44169b(c1768a.data, c1768a.eTe, c1768a.eTf);
            }
            AppMethodBeat.m2505o(12816);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.a.a$r */
    static final class C18564r implements Runnable {
        final /* synthetic */ C18562a eTd;

        C18564r(C18562a c18562a) {
            this.eTd = c18562a;
        }

        public final void run() {
            AppMethodBeat.m2504i(12832);
            C18580a c18580a = this.eTd.eSI;
            if (c18580a != null) {
                c18580a.mo33816Uz();
                AppMethodBeat.m2505o(12832);
                return;
            }
            AppMethodBeat.m2505o(12832);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$k */
    public static final class C18565k extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18565k(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12825);
            C18562a.m28917c(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12825);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$d */
    public static final class C18566d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18566d(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12818);
            C18562a.m28917c(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12818);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$g */
    public static final class C18567g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18567g(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12821);
            C18562a.m28915b(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12821);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$t */
    public static final class C18568t extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18568t(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12834);
            C4990ab.m7416i(this.eTd.TAG, "startCodec MusicDecoder");
            this.eTd.eSX.run();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12834);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "audioData", "", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$e */
    public static final class C18569e extends C25053k implements C31591m<byte[], Long, C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18569e(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12819);
            byte[] bArr = (byte[]) obj;
            long longValue = ((Number) obj2).longValue();
            C25052j.m39376p(bArr, "audioData");
            C18562a.m28913a(this.eTd, bArr, longValue);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12819);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$f */
    public static final class C18570f extends C25053k implements C31591m<byte[], Long, C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18570f(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12820);
            C18562a.m28916b(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12820);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$o */
    public static final class C18571o extends C25053k implements C31591m<ByteBuffer, BufferInfo, C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18571o(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12829);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            C25052j.m39376p(byteBuffer, "pcmData");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C18562a.m28912a(this.eTd, byteBuffer, bufferInfo);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12829);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$1 */
    static final class C185721 extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        C185721(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12810);
            C18562a.m28911a(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12810);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$h */
    public static final class C18573h extends C25053k implements C31591m<byte[], Long, C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18573h(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12822);
            C18562a.m28916b(this.eTd, (byte[]) obj, ((Number) obj2).longValue());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12822);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$n */
    public static final class C18574n extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18574n(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12828);
            C18562a.m28920d(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12828);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.a.a$q */
    static final class C18575q implements Runnable {
        final /* synthetic */ C18562a eTd;

        C18575q(C18562a c18562a) {
            this.eTd = c18562a;
        }

        public final void run() {
            AppMethodBeat.m2504i(12831);
            C18580a c18580a = this.eTd.eSJ;
            if (c18580a != null) {
                c18580a.mo33816Uz();
                AppMethodBeat.m2505o(12831);
                return;
            }
            AppMethodBeat.m2505o(12831);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "audioData", "", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$2 */
    static final class C185762 extends C25053k implements C31591m<byte[], Long, C37091y> {
        final /* synthetic */ C18562a eTd;

        C185762(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12811);
            byte[] bArr = (byte[]) obj;
            long longValue = ((Number) obj2).longValue();
            C25052j.m39376p(bArr, "audioData");
            C18562a.m28913a(this.eTd, bArr, longValue);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12811);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "pcmData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$m */
    public static final class C18577m extends C25053k implements C31591m<ByteBuffer, BufferInfo, C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18577m(C18562a c18562a) {
            this.eTd = c18562a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(12827);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            C25052j.m39376p(byteBuffer, "pcmData");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C18562a.m28912a(this.eTd, byteBuffer, bufferInfo);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12827);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.a.a$p */
    public static final class C18578p extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18562a eTd;

        public C18578p(C18562a c18562a) {
            this.eTd = c18562a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12830);
            C18562a.m28920d(this.eTd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12830);
            return c37091y;
        }
    }

    public C18562a(int i, int i2, int i3, C31591m<? super ByteBuffer, ? super BufferInfo, C37091y> c31591m) {
        AppMethodBeat.m2504i(12837);
        this.eTa = i;
        this.eTb = i2;
        this.sampleRate = i3;
        this.eTc = c31591m;
        this.TAG = "MicroMsg.MediaCodecAACCodec";
        HandlerThread anM = C7305d.anM("MediaCodecAACCodec_EncodeThread");
        C25052j.m39375o(anM, "ThreadPool.newFreeHandle…ecAACCodec_EncodeThread\")");
        this.eSP = anM;
        this.eSS = C1761b.eSn + "cache.pcm";
        this.eSW = new C18575q(this);
        this.eSX = new C18564r(this);
        C4990ab.m7416i(this.TAG, "init MediaCodecAACCodec, sampleRate:" + this.sampleRate + ", channelCount:" + this.aOn);
        this.eSL = new C1774a(this.sampleRate, this.aOn, C7987l.listOf(Integer.valueOf(3), Integer.valueOf(1)).contains(Integer.valueOf(this.eTb)), C7987l.listOf(Integer.valueOf(2), Integer.valueOf(3)).contains(Integer.valueOf(this.eTb)), new C185721(this), new C185762(this));
        AppMethodBeat.m2505o(12837);
    }

    /* renamed from: a */
    private final void m28914a(byte[] bArr, long j, boolean z) {
        AppMethodBeat.m2504i(12835);
        if (this.eSQ == null) {
            this.eSP.start();
            this.eSQ = new C7306ak(this.eSP.getLooper(), (C4998a) new C18563b(this));
        }
        C7306ak c7306ak = this.eSQ;
        Message obtainMessage = c7306ak != null ? c7306ak.obtainMessage() : null;
        if (obtainMessage != null) {
            obtainMessage.what = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        C25052j.m39375o(copyOf, "Arrays.copyOf(data, data.size)");
        C1768a c1768a = new C1768a(copyOf, j, z);
        if (obtainMessage != null) {
            obtainMessage.obj = c1768a;
        }
        C7306ak c7306ak2 = this.eSQ;
        if (c7306ak2 != null) {
            c7306ak2.sendMessage(obtainMessage);
            AppMethodBeat.m2505o(12835);
            return;
        }
        AppMethodBeat.m2505o(12835);
    }

    /* renamed from: co */
    private final synchronized void m28919co(boolean z) {
        AppMethodBeat.m2504i(12836);
        C4990ab.m7409c(this.TAG, "onDecodeEnd, isDecodeEnd:" + this.eSM + ", isBackground:" + z, new Object[0]);
        if (z) {
            this.eSO = true;
        } else {
            this.eSN = true;
        }
        C18580a c18580a;
        if (this.eTb == 3 && this.eSN && this.eSO) {
            if (!this.eSM) {
                this.eSM = true;
                c18580a = this.eSI;
                if (c18580a != null) {
                    c18580a.mo33814UA();
                }
                c18580a = this.eSJ;
                if (c18580a != null) {
                    c18580a.mo33814UA();
                }
                m28914a(new byte[0], C5046bo.m7588yz(), true);
                AppMethodBeat.m2505o(12836);
            }
            AppMethodBeat.m2505o(12836);
        } else {
            if (this.eTb == 2 && this.eSN && !this.eSM) {
                this.eSM = true;
                c18580a = this.eSI;
                if (c18580a != null) {
                    c18580a.mo33814UA();
                    AppMethodBeat.m2505o(12836);
                }
            }
            AppMethodBeat.m2505o(12836);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m28911a(C18562a c18562a) {
        AppMethodBeat.m2504i(12838);
        C4990ab.m7416i(c18562a.TAG, "onFrameMix");
        AppMethodBeat.m2505o(12838);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m28916b(C18562a c18562a, byte[] bArr, long j) {
        AppMethodBeat.m2504i(12840);
        C4990ab.m7416i(c18562a.TAG, "on background frame decode, isDecodeEnd:" + c18562a.eSM);
        if (!c18562a.eSM) {
            c18562a.eSU++;
            if (bArr != null) {
                C4990ab.m7416i(c18562a.TAG, "input background data");
                C18580a c18580a = c18562a.eSJ;
                if (c18580a != null) {
                    C1774a c1774a = c18562a.eSL;
                    if (c1774a != null) {
                        c1774a.mo5321a(bArr, "background", j, c18580a.eTt, c18580a.eTs);
                        AppMethodBeat.m2505o(12840);
                        return;
                    }
                    AppMethodBeat.m2505o(12840);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(12840);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m28915b(C18562a c18562a) {
        AppMethodBeat.m2504i(12841);
        C4990ab.m7416i(c18562a.TAG, "on background decode end");
        C1774a c1774a = c18562a.eSL;
        if (c1774a != null) {
            c1774a.mo5322lV("background");
        }
        c18562a.m28919co(true);
        AppMethodBeat.m2505o(12841);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m28918c(C18562a c18562a, byte[] bArr, long j) {
        AppMethodBeat.m2504i(12842);
        C4990ab.m7416i(c18562a.TAG, "on music frame decode, isDecodeEnd:" + c18562a.eSM);
        if (!(c18562a.eSM && c18562a.eSV == c18562a.eSU)) {
            c18562a.eSV++;
            if (bArr != null) {
                C18580a c18580a = c18562a.eSI;
                if (c18580a != null) {
                    C1774a c1774a = c18562a.eSL;
                    if (c1774a != null) {
                        c1774a.mo5321a(bArr, "music", j, c18580a.eTt, c18580a.eTs);
                    }
                }
                C4990ab.m7416i(c18562a.TAG, "input music data");
            }
        }
        AppMethodBeat.m2505o(12842);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m28917c(C18562a c18562a) {
        AppMethodBeat.m2504i(12843);
        C4990ab.m7416i(c18562a.TAG, "on music decode end");
        C1774a c1774a = c18562a.eSL;
        if (c1774a != null) {
            c1774a.mo5322lV("music");
        }
        c18562a.m28919co(false);
        AppMethodBeat.m2505o(12843);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m28920d(C18562a c18562a) {
        AppMethodBeat.m2504i(12845);
        C4990ab.m7416i(c18562a.TAG, "onFrameEncodeEnd, mixCount:" + c18562a.cmI);
        C1774a c1774a = c18562a.eSL;
        if (c1774a != null) {
            C37091y c37091y;
            C4990ab.m7416i(c1774a.TAG, "stopMix");
            List list = c1774a.eWp;
            C25052j.m39375o(list, "pcmDataList");
            synchronized (list) {
                try {
                    c1774a.eWp.clear();
                    c37091y = C37091y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(12845);
                }
            }
            synchronized (c1774a.eWt) {
                try {
                    c1774a.eWs = true;
                    try {
                        c1774a.eWt.notifyAll();
                    } catch (Exception e) {
                    }
                    c37091y = C37091y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(12845);
                }
            }
            C4990ab.m7416i(c1774a.TAG, "isMixingFinish1 " + c1774a.eWq);
            if (!c1774a.eWq) {
                synchronized (c1774a.eWu) {
                    try {
                        if (!c1774a.eWq) {
                            C4990ab.m7416i(c1774a.TAG, "isMixingFinish2 " + c1774a.eWq);
                            c1774a.eWu.wait();
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        c37091y = C37091y.AUy;
                    } catch (Throwable th3) {
                        AppMethodBeat.m2505o(12845);
                    }
                }
            }
            byte[] Ec = c1774a.eWk.mo60416Ec();
            c1774a.eWk.release();
            C4990ab.m7416i(c1774a.TAG, "stopMix, final dstAudio:" + (Ec != null ? Ec.length : 0));
            if (Ec != null) {
                c1774a.eWD.mo212m(Ec, Long.valueOf(c1774a.eWm));
            } else {
                c1774a.eWD.mo212m(new byte[0], Long.valueOf(c1774a.eWm));
            }
            C4990ab.m7416i(c1774a.TAG, "stopMix finish");
        }
        C37887a c37887a = c18562a.eSK;
        if (c37887a == null) {
            C25052j.avw("mAudioEncoder");
        }
        c37887a.stopEncoder();
        c37887a = c18562a.eSK;
        if (c37887a == null) {
            C25052j.avw("mAudioEncoder");
        }
        c37887a.mo60634UO();
        C31214a c31214a = c18562a.eSR;
        if (c31214a != null) {
            c31214a.invoke();
            AppMethodBeat.m2505o(12845);
            return;
        }
        AppMethodBeat.m2505o(12845);
    }
}
