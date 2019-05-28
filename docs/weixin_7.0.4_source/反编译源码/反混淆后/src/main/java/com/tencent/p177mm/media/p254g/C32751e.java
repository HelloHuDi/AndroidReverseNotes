package com.tencent.p177mm.media.p254g;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.media.p250a.C18562a;
import com.tencent.p177mm.media.p250a.C18562a.C1769i;
import com.tencent.p177mm.media.p250a.C18562a.C1770j;
import com.tencent.p177mm.media.p250a.C18562a.C18560c;
import com.tencent.p177mm.media.p250a.C18562a.C18561s;
import com.tencent.p177mm.media.p250a.C18562a.C18565k;
import com.tencent.p177mm.media.p250a.C18562a.C18566d;
import com.tencent.p177mm.media.p250a.C18562a.C18567g;
import com.tencent.p177mm.media.p250a.C18562a.C18568t;
import com.tencent.p177mm.media.p250a.C18562a.C18569e;
import com.tencent.p177mm.media.p250a.C18562a.C18570f;
import com.tencent.p177mm.media.p250a.C18562a.C18571o;
import com.tencent.p177mm.media.p250a.C18562a.C18573h;
import com.tencent.p177mm.media.p250a.C18562a.C18574n;
import com.tencent.p177mm.media.p250a.C18562a.C18577m;
import com.tencent.p177mm.media.p250a.C18562a.C18578p;
import com.tencent.p177mm.media.p250a.C18562a.C9578l;
import com.tencent.p177mm.media.p251b.C24670c;
import com.tencent.p177mm.media.p253f.C1774a;
import com.tencent.p177mm.media.p253f.C1774a.C1775c;
import com.tencent.p177mm.media.p254g.C1784i.C1785a;
import com.tencent.p177mm.media.p254g.C45430d.C31558e;
import com.tencent.p177mm.media.p254g.C45430d.C9596c;
import com.tencent.p177mm.media.p254g.C45430d.C9597d;
import com.tencent.p177mm.media.p254g.C9587a.C9590b;
import com.tencent.p177mm.media.p255h.C42173c;
import com.tencent.p177mm.media.p865c.C18580a;
import com.tencent.p177mm.media.p865c.C26375f;
import com.tencent.p177mm.media.p865c.C37886c;
import com.tencent.p177mm.media.p865c.C42166d;
import com.tencent.p177mm.media.p865c.C42168e;
import com.tencent.p177mm.media.p865c.C45425b;
import com.tencent.p177mm.media.p866d.C26377d;
import com.tencent.p177mm.media.p866d.C26380f;
import com.tencent.p177mm.media.p866d.C37887a;
import com.tencent.p177mm.media.p866d.C41212c;
import com.tencent.p177mm.media.p866d.C45426b;
import com.tencent.p177mm.media.p866d.C9582e;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.media.p867i.C42174a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012%\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012¢\u0006\u0002\u0010\u0017J\b\u0010H\u001a\u00020\u0016H\u0002J\u0010\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u0003H\u0002J\b\u0010K\u001a\u00020\u0016H\u0002J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020,H\u0002J\b\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020,H\u0002J\b\u0010R\u001a\u00020\u0006H\u0016J\u0010\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010V\u001a\u00020\u0016H\u0002J\u0010\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020 H\u0016J\u001c\u0010Y\u001a\u00020\u00162\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010 0\u0012R\u000e\u0010\u0018\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R-\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006["}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIIIIJJLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "firstFrameDraw", "", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "useRequestDraw", "videoDuration", "videoFps", "videoMixHandlerThread", "videoRotate", "checkFrameDrawTimeout", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "renderer", "Lcom/tencent/mm/media/render/MixRenderer;", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.g.e */
public final class C32751e extends C37894c {
    private static final long eYr = 1000;
    public static final C1780a eYs = new C1780a();
    private final String TAG = "MicroMsg.MediaCodecRemuxer";
    private int eST;
    private int eTb;
    private C32742a eTz;
    private int eWK = -1;
    private C45425b eXA;
    private int eXJ;
    private int eXK;
    private int eXL;
    private long eXM;
    private long eXN;
    private C45426b eXO;
    private C18562a eXP;
    public C9587a eXQ;
    private C1783h eXR;
    private C32742a eXS;
    private C32742a eXT;
    private C5004al eXU;
    private C5004al eXV;
    private boolean eXW;
    private boolean eXX;
    private C32757f eXY;
    private long eXZ;
    public C17126b<? super Long, Bitmap> eXh;
    private Bitmap eXi;
    private final C42174a eYa;
    private boolean eYb;
    private boolean eYc;
    private boolean eYd;
    private int eYe;
    private int eYf;
    private volatile boolean eYg;
    private volatile boolean eYh;
    private final String eYi;
    private final String eYj;
    private int eYk;
    private int eYl;
    private int eYm;
    private int eYn;
    private int eYo;
    private int eYp;
    private C17126b<? super String, C37091y> eYq;
    private String filePath;
    private int videoFps;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$Companion;", "", "()V", "CHECK_FRAME_DRWA_TIMEOUT", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.g.e$a */
    public static final class C1780a {
        private C1780a() {
        }

        public /* synthetic */ C1780a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.g.e$b */
    static final class C1781b implements Runnable {
        final /* synthetic */ C32751e eYt;

        C1781b(C32751e c32751e) {
            this.eYt = c32751e;
        }

        public final void run() {
            AppMethodBeat.m2504i(13042);
            C4990ab.m7416i(this.eYt.TAG, "delay check frameDraw: " + this.eYt.eYg);
            if (!this.eYt.eYg) {
                C4990ab.m7412e(this.eYt.TAG, "after " + C32751e.eYr + " ms, first frame stil not draw!!!");
                C18594c c18594c = C18594c.faj;
                C18594c.m28988Wd();
            }
            AppMethodBeat.m2505o(13042);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$c */
    static final class C9598c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C32751e eYt;

        C9598c(C32751e c32751e) {
            this.eYt = c32751e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13043);
            C32751e.m53481z(this.eYt);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13043);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$d */
    static final class C9599d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C32751e eYt;

        C9599d(C32751e c32751e) {
            this.eYt = c32751e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13044);
            C45425b h = this.eYt.eXA;
            if (h != null) {
                h.mo44163UB();
            }
            C32751e.m53439A(this.eYt);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13044);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$j */
    static final class C9602j extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C32751e eYt;

        C9602j(C32751e c32751e) {
            this.eYt = c32751e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13054);
            C45426b d = this.eYt.eXO;
            if (d != null) {
                d.release();
            }
            C32751e.m53449a(this.eYt, true);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13054);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$k */
    static final class C9603k extends C25053k implements C31591m<ByteBuffer, BufferInfo, C37091y> {
        final /* synthetic */ C32751e eYt;

        C9603k(C32751e c32751e) {
            this.eYt = c32751e;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(13055);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            C25052j.m39376p(byteBuffer, "buffer");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C32757f c = this.eYt.eXY;
            if (c != null) {
                C31591m c31591m = c.eYF;
                if (c31591m != null) {
                    c31591m.mo212m(byteBuffer, bufferInfo);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13055);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$i */
    static final class C31272i extends C25053k implements C31591m<ByteBuffer, BufferInfo, C37091y> {
        final /* synthetic */ C32751e eYt;

        C31272i(C32751e c32751e) {
            this.eYt = c32751e;
            super(2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0053  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            C37091y c37091y;
            AppMethodBeat.m2504i(13053);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            C25052j.m39376p(byteBuffer, "byteBuffer");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C4990ab.m7416i(this.eYt.TAG, "onEncode: " + this.eYt.eST);
            C32751e c32751e = this.eYt;
            c32751e.eST = c32751e.eST + 1;
            C32757f c = this.eYt.eXY;
            if (c != null) {
                C31591m c31591m = c.eYE;
                if (c31591m != null) {
                    c37091y = (C37091y) c31591m.mo212m(byteBuffer, bufferInfo);
                    if (c37091y == null) {
                        C25052j.dWJ();
                    }
                    c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(13053);
                    return c37091y;
                }
            }
            c37091y = null;
            if (c37091y == null) {
            }
            c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13053);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$l */
    static final class C31559l extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C32751e eYt;
        final /* synthetic */ long eYz;

        C31559l(C32751e c32751e, long j) {
            this.eYt = c32751e;
            this.eYz = j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13056);
            C18562a x = this.eYt.eXP;
            if (x != null) {
                C18580a c18580a = x.eSJ;
                if (c18580a != null) {
                    c18580a.mo33814UA();
                }
                c18580a = x.eSI;
                if (c18580a != null) {
                    c18580a.mo33814UA();
                }
                C37887a c37887a = x.eSK;
                if (c37887a == null) {
                    C25052j.avw("mAudioEncoder");
                }
                c37887a.stopEncoder();
                C7305d.xDG.remove(x.eSX);
                C7305d.xDG.remove(x.eSW);
                x.eSP.quit();
                if (x.eSZ > 0) {
                    long az = C5046bo.m7525az(x.eSZ);
                    C18594c c18594c;
                    if (x.eSY) {
                        c18594c = C18594c.faj;
                        C18594c.m28960VR();
                        c18594c = C18594c.faj;
                        C18594c.m28993fg(az);
                    } else {
                        c18594c = C18594c.faj;
                        C18594c.m28961VS();
                        c18594c = C18594c.faj;
                        C18594c.m28994fh(az);
                    }
                }
            }
            C4990ab.m7416i(this.eYt.TAG, "mix audio used " + C5046bo.m7525az(this.eYz));
            C32742a y = this.eYt.eXS;
            if (y != null) {
                y.release();
            }
            C32751e.m53449a(this.eYt, false);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13056);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1"})
    /* renamed from: com.tencent.mm.media.g.e$e */
    static final class C32749e extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C32751e eYt;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1$onDecodeEnd$1"})
        /* renamed from: com.tencent.mm.media.g.e$e$1 */
        static final class C96001 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C32749e eYu;

            C96001(C32749e c32749e) {
                this.eYu = c32749e;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(13045);
                C4990ab.m7416i(this.eYu.eYt.TAG, "onDecodeEnd");
                C32751e.m53464i(this.eYu.eYt);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(13045);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1$1"})
        /* renamed from: com.tencent.mm.media.g.e$e$3 */
        static final class C96013 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C32749e eYu;

            C96013(C32749e c32749e) {
                this.eYu = c32749e;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(138367);
                C4990ab.m7416i(this.eYu.eYt.TAG, "onDrawFrameOnFrameAvailableFailed!! force use request draw");
                this.eYu.eYt.eYh = true;
                C45425b h = this.eYu.eYt.eXA;
                if (h != null) {
                    h.mo73219cp(false);
                }
                C18594c c18594c = C18594c.faj;
                C18594c.m28989We();
                C9587a o = this.eYu.eYt.eXQ;
                if (o != null) {
                    o.eXk = null;
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(138367);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1$onDecode$1"})
        /* renamed from: com.tencent.mm.media.g.e$e$2 */
        static final class C312702 extends C25053k implements C31591m<ByteBuffer, Long, C37091y> {
            final /* synthetic */ C32749e eYu;

            C312702(C32749e c32749e) {
                this.eYu = c32749e;
                super(2);
            }

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                long k;
                AppMethodBeat.m2504i(13046);
                long longValue = ((Number) obj2).longValue();
                C32751e c32751e = this.eYu.eYt;
                c32751e.eYe = c32751e.eYe + 1;
                C45425b h = this.eYu.eYt.eXA;
                if (h != null) {
                    h.mo73219cp(true);
                }
                if (this.eYu.eYt.eXM >= 0) {
                    k = longValue - (this.eYu.eYt.eXM * 1000);
                } else {
                    k = longValue;
                }
                C4990ab.m7410d(this.eYu.eYt.TAG, "onDecode, drawPts:" + k + ", pts:" + longValue + ", remuxStartTime:" + this.eYu.eYt.eXM);
                if (this.eYu.eYt.eYh) {
                    C9587a o;
                    if (this.eYu.eYt.eXi != null) {
                        o = this.eYu.eYt.eXQ;
                        if (o != null) {
                            o.mo20911a(k * 1000, this.eYu.eYt.eXi);
                        }
                    } else {
                        o = this.eYu.eYt.eXQ;
                        if (o != null) {
                            long j = k * 1000;
                            C17126b p = this.eYu.eYt.eXh;
                            o.mo20911a(j, p != null ? (Bitmap) p.mo50am(Long.valueOf(k)) : null);
                        }
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(13046);
                return c37091y;
            }
        }

        C32749e(C32751e c32751e) {
            this.eYt = c32751e;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            C18594c c18594c;
            AppMethodBeat.m2504i(13049);
            if (!((Boolean) obj).booleanValue()) {
                c18594c = C18594c.faj;
                C18594c.m28955VM();
            }
            final C31214a c96001 = new C96001(this);
            final C31591m c312702 = new C312702(this);
            C9587a o = this.eYt.eXQ;
            if (o != null) {
                o.eXk = new C96013(this);
            }
            try {
                C45425b c26375f;
                C32751e c32751e = this.eYt;
                long k;
                long q;
                C32742a r;
                C9587a o2;
                if (C1443d.m3068iW(23)) {
                    k = this.eYt.eXM;
                    q = this.eYt.eXN;
                    r = this.eYt.eTz;
                    o2 = this.eYt.eXQ;
                    if (o2 == null) {
                        C25052j.dWJ();
                    }
                    c26375f = new C26375f(k, q, r, o2.mo20910UY(), new C17126b<C45425b, C37091y>() {
                        /* renamed from: am */
                        public final /* synthetic */ Object mo50am(Object obj) {
                            AppMethodBeat.m2504i(13048);
                            C45425b c45425b = (C45425b) obj;
                            C25052j.m39376p(c45425b, "receiver$0");
                            c45425b.eTG = c312702;
                            c45425b.eTH = c96001;
                            c45425b.eTO = true;
                            C37091y c37091y = C37091y.AUy;
                            AppMethodBeat.m2505o(13048);
                            return c37091y;
                        }
                    });
                } else {
                    k = this.eYt.eXM;
                    q = this.eYt.eXN;
                    r = this.eYt.eTz;
                    o2 = this.eYt.eXQ;
                    if (o2 == null) {
                        C25052j.dWJ();
                    }
                    c26375f = new C42168e(k, q, r, o2.mo20910UY(), new C17126b<C45425b, C37091y>() {
                        /* renamed from: am */
                        public final /* synthetic */ Object mo50am(Object obj) {
                            AppMethodBeat.m2504i(138368);
                            C45425b c45425b = (C45425b) obj;
                            C25052j.m39376p(c45425b, "receiver$0");
                            c45425b.eTG = c312702;
                            c45425b.eTH = c96001;
                            c45425b.eTO = true;
                            C37091y c37091y = C37091y.AUy;
                            AppMethodBeat.m2505o(138368);
                            return c37091y;
                        }
                    });
                }
                c32751e.eXA = c26375f;
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eYt.TAG, e, "init decoder error", new Object[0]);
                c18594c = C18594c.faj;
                C18594c.m28954VL();
                C32751e.m53474s(this.eYt);
            }
            int t = this.eYt.videoFps - 1;
            int u = this.eYt.eYp;
            if (1 <= u && t >= u) {
                C45425b h = this.eYt.eXA;
                if (h != null) {
                    u = (int) Math.ceil((double) (((float) this.eYt.videoFps) / ((float) this.eYt.eYp)));
                    C4990ab.m7416i(h.TAG, "setFrameDropInterval: ".concat(String.valueOf(u)));
                    h.eTJ = u;
                    if (h.eTJ > 1) {
                        c18594c = C18594c.faj;
                        C18594c.m28985Wa();
                    }
                }
            }
            this.eYt.eXW = true;
            if (this.eYt.eXX) {
                this.eYt.mo53305Va();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13049);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "checker", "Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$1 */
    static final class C327521 extends C25053k implements C31591m<MediaFormat, C45430d, C37091y> {
        final /* synthetic */ C32751e eYt;

        C327521(C32751e c32751e) {
            this.eYt = c32751e;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            C37091y c37091y;
            AppMethodBeat.m2504i(13041);
            MediaFormat mediaFormat = (MediaFormat) obj;
            C25052j.m39376p((C45430d) obj2, "checker");
            if (mediaFormat != null) {
                int i;
                C25052j.m39376p(mediaFormat, "mediaFormat");
                if (mediaFormat.containsKey("crop-left") || mediaFormat.containsKey("crop-top") || mediaFormat.containsKey("crop-right") || mediaFormat.containsKey("crop-bottom")) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    int integer;
                    int integer2;
                    C18594c c18594c = C18594c.faj;
                    C18594c.m28950VH();
                    C4990ab.m7416i(this.eYt.TAG, "after check, has crop rect:".concat(String.valueOf(mediaFormat)));
                    C25052j.m39376p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-left")) {
                        integer = mediaFormat.getInteger("crop-left");
                    } else {
                        integer = 0;
                    }
                    C25052j.m39376p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-right")) {
                        i = mediaFormat.getInteger("crop-right");
                    } else {
                        i = 0;
                    }
                    int i2 = i + 1;
                    C25052j.m39376p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-top")) {
                        integer2 = mediaFormat.getInteger("crop-top");
                    } else {
                        integer2 = 0;
                    }
                    C25052j.m39376p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-bottom")) {
                        i = mediaFormat.getInteger("crop-bottom");
                    } else {
                        i = 0;
                    }
                    int i3 = i + 1;
                    C4990ab.m7416i(this.eYt.TAG, "cropRect:[" + integer + ", " + integer2 + ", " + i2 + ", " + i3 + ']');
                    C42173c c42173c = new C42173c(this.eYt.eYk, this.eYt.eYl, this.eYt.eYk, this.eYt.eYl, 0, 3, 16);
                    Rect rect = new Rect(integer, integer2, i2, i3);
                    C25052j.m39376p(rect, "rect");
                    c42173c.eZd = rect;
                    this.eYt.eYk = this.eYt.eXJ;
                    this.eYt.eYl = this.eYt.eXK;
                    C32751e.m53448a(this.eYt, c42173c);
                    c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(13041);
                    return c37091y;
                }
            }
            C32751e.m53448a(this.eYt, new C42173c(this.eYt.eXJ, this.eYt.eXK, this.eYt.eYk, this.eYt.eYl, 0, 0, 48));
            c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13041);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$f */
    static final class C32753f extends C25053k implements C17126b<C45426b, C37091y> {
        final /* synthetic */ C31591m eYx;
        final /* synthetic */ C31214a eYy;

        C32753f(C31591m c31591m, C31214a c31214a) {
            this.eYx = c31591m;
            this.eYy = c31214a;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13050);
            C45426b c45426b = (C45426b) obj;
            C25052j.m39376p(c45426b, "receiver$0");
            c45426b.eVy = this.eYx;
            c45426b.eVz = this.eYy;
            c45426b.eTO = true;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13050);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$h */
    static final class C32754h extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C32751e eYt;

        C32754h(C32751e c32751e) {
            this.eYt = c32751e;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13052);
            if (!((Boolean) obj).booleanValue()) {
                C18594c c18594c = C18594c.faj;
                C18594c.m28956VN();
            }
            C32751e c32751e = this.eYt;
            c32751e.eYf = c32751e.eYf + 1;
            this.eYt.eYg = true;
            C32757f c = this.eYt.eXY;
            if (c != null) {
                C31214a c31214a = c.eYH;
                if (c31214a != null) {
                    c31214a.invoke();
                }
            }
            C45426b d = this.eYt.eXO;
            if (d != null) {
                d.mo20900UP();
            }
            C45425b h = this.eYt.eXA;
            if (h != null) {
                h.mo73219cp(false);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13052);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$g */
    static final class C32755g extends C25053k implements C17126b<C45426b, C37091y> {
        final /* synthetic */ C31591m eYx;
        final /* synthetic */ C31214a eYy;

        C32755g(C31591m c31591m, C31214a c31214a) {
            this.eYx = c31591m;
            this.eYy = c31214a;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13051);
            C45426b c45426b = (C45426b) obj;
            C25052j.m39376p(c45426b, "receiver$0");
            c45426b.eVy = this.eYx;
            c45426b.eVz = this.eYy;
            c45426b.eTO = true;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13051);
            return c37091y;
        }
    }

    /* renamed from: s */
    public static final /* synthetic */ void m53474s(C32751e c32751e) {
        AppMethodBeat.m2504i(13066);
        c32751e.m53456cr(true);
        AppMethodBeat.m2505o(13066);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x02d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C32751e(String str, String str2, int i, String str3, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2, C17126b<? super String, C37091y> c17126b) {
        C25052j.m39376p(str2, "filePath");
        C25052j.m39376p(str3, "outputFilePath");
        AppMethodBeat.m2504i(13062);
        this.eYi = str;
        this.filePath = str2;
        this.eTb = i;
        this.eYj = str3;
        this.eYk = i2;
        this.eYl = i3;
        this.eYm = i4;
        this.eYn = i5;
        this.eYo = i6;
        this.eYp = i7;
        this.eYq = c17126b;
        this.eXM = j;
        this.eXN = -1;
        this.eYa = new C42174a("remuxCost");
        C18594c c18594c;
        Throwable illegalArgumentException;
        if (C5046bo.isNullOrNil(this.filePath) || !C5730e.m8628ct(this.filePath) || C5046bo.isNullOrNil(this.eYj) || this.eYk <= 0 || this.eYl <= 0) {
            C4990ab.m7412e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.eYj + ", outputWidth:" + this.eYk + ", outputHeight:" + this.eYl + ", videoFps:" + this.videoFps + ", outputFps:" + this.eYp);
            c18594c = C18594c.faj;
            C18594c.m28947VE();
            illegalArgumentException = new IllegalArgumentException("create MediaCodecRemuxer error");
            AppMethodBeat.m2505o(13062);
            throw illegalArgumentException;
        }
        c18594c = C18594c.faj;
        C18594c.m28995kc(this.eTb);
        if (C17987e.m28307uD(this.filePath)) {
            C4990ab.m7416i(this.TAG, "remux h265 format");
            c18594c = C18594c.faj;
            C18594c.m28946VD();
        }
        C5730e.m8643tf(C5730e.atb(this.eYj));
        this.eXL = SightVideoJNI.getMp4Rotate(this.filePath);
        C43528a WR = C21846d.m33388WR(this.filePath);
        if (WR != null) {
            this.eXJ = WR.width;
            this.eXK = WR.height;
            this.videoFps = WR.eTk;
            this.eWK = WR.eWK;
        }
        if (this.eXJ <= 0 || this.eXK <= 0) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.filePath);
                this.eXJ = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                this.eXK = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                mediaMetadataRetriever.release();
            } catch (Exception e) {
            }
        }
        if (this.videoFps <= 0) {
            C4990ab.m7412e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
            c18594c = C18594c.faj;
            C18594c.m28947VE();
            illegalArgumentException = new IllegalArgumentException("create MediaCodecRemuxer error");
            AppMethodBeat.m2505o(13062);
            throw illegalArgumentException;
        }
        boolean z;
        if (j2 == 0) {
            this.eXN = (long) this.eWK;
        } else {
            this.eXN = j2;
        }
        this.eXR = new C1783h(this.eXM, this.eXN, this.eYm);
        C4990ab.m7409c(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.eYj + ", inputWidth: " + this.eXJ + ", inputHeight: " + this.eXK + ", videoRotate: " + this.eXL + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.eYm + ", outputAudioBitrate:" + this.eYn + " , outputWidth: " + this.eYk + ", outputHeight: " + this.eYl + ',' + " startTimeMs: " + j + ", endTimeMs: " + j2 + " , outputFps: " + this.eYp + " , videoDuration: " + this.eWK + " , remuxStartTime: " + this.eXM + " ,remuxEndTime: " + this.eXN + " , input bitrate:" + WR.videoBitrate, new Object[0]);
        this.eTz = new C32742a(this.filePath);
        if (this.eTz.eWh) {
            c18594c = C18594c.faj;
            C18594c.m28948VF();
        }
        int i8 = this.eYk - this.eXJ;
        if (1 > i8 || 16 <= i8) {
            i8 = this.eYl - this.eXK;
            if (1 > i8 || 16 <= i8) {
                z = false;
                C4990ab.m7416i(this.TAG, "needCheckCropRect:".concat(String.valueOf(z)));
                if (z) {
                    m53450a(new C42173c(this.eXJ, this.eXK, this.eYk, this.eYl, 0, 0, 48));
                    AppMethodBeat.m2505o(13062);
                    return;
                }
                c18594c = C18594c.faj;
                C18594c.m28949VG();
                C45430d c45430d = new C45430d(this.eTz);
                C31591m c327521 = new C327521(this);
                c45430d.exT = c327521;
                try {
                    C45425b c26375f;
                    if (C1443d.m3068iW(23)) {
                        c26375f = new C26375f(0, (long) (c45430d.eXD.getDuration() / 1000), c45430d.eXD, null, new C9596c(c45430d));
                    } else {
                        c26375f = new C42168e(0, (long) (c45430d.eXD.getDuration() / 1000), c45430d.eXD, null, new C9597d(c45430d));
                    }
                    c45430d.eXA = c26375f;
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace(c45430d.TAG, e2, "start check init decoder error", new Object[0]);
                    C18594c c18594c2 = C18594c.faj;
                    C18594c.m28968VZ();
                    c327521.mo212m(null, c45430d);
                }
                C8902b.m16045b(new C31558e(c45430d), "MediaCodecCheckVideoCropRect_decode");
                AppMethodBeat.m2505o(13062);
                return;
            }
        }
        z = true;
        C4990ab.m7416i(this.TAG, "needCheckCropRect:".concat(String.valueOf(z)));
        if (z) {
        }
    }

    /* renamed from: a */
    private final void m53450a(C42173c c42173c) {
        C18594c c18594c;
        AppMethodBeat.m2504i(13057);
        String str = this.filePath;
        C1785a c1785a = C1784i.eYK;
        String lY = C1785a.m3671lY(str);
        if (str == null) {
            C4990ab.m7412e(this.TAG, "copyVideoFile invalid parameters, can not be null");
        } else {
            if (C5730e.m8628ct(lY)) {
                C5730e.deleteFile(lY);
            }
            C4990ab.m7417i(this.TAG, "copyVideoFile from %s, to %s", str, lY);
            long yz = C5046bo.m7588yz();
            long y = C5730e.m8644y(str, lY);
            C4990ab.m7416i(this.TAG, "copy video file cost " + C5046bo.m7525az(yz));
            if (y <= 0) {
                c18594c = C18594c.faj;
                C18594c.m28951VI();
            }
        }
        c1785a = C1784i.eYK;
        this.eXT = new C32742a(C1785a.m3671lY(this.filePath));
        str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("useAudioRecord:false, cpVideoFile:");
        C1785a c1785a2 = C1784i.eYK;
        stringBuilder = stringBuilder.append(C1785a.m3671lY(this.filePath)).append(", audioCpFile:");
        c1785a2 = C1784i.eYK;
        C4990ab.m7416i(str, stringBuilder.append(C1785a.m3670lX(this.filePath)).toString());
        C32742a c32742a = this.eXT;
        if (c32742a != null) {
            this.eXY = new C32757f(this.eXR, c32742a, this.eYj, this.eTb, this.eYo);
            if (C5730e.m8628ct(this.eYi)) {
                lY = this.eYi;
                if (lY == null) {
                    C25052j.dWJ();
                }
                C32742a c32742a2 = new C32742a(lY);
                if (c32742a2.eWh) {
                    C18594c c18594c2 = C18594c.faj;
                    C18594c.m28952VJ();
                }
                this.eXS = c32742a2;
            }
        }
        C32757f c32757f = this.eXY;
        if (c32757f != null) {
            c32757f.eXL = this.eXL;
        }
        try {
            C45426b c26380f;
            int min = this.eYp > 0 ? Math.min(this.eYp, this.videoFps) : this.videoFps;
            C24670c c24670c = new C24670c();
            c24670c.bitrate = this.eYm;
            c24670c.eTk = min;
            c24670c.eTj = this.eYl;
            c24670c.eTi = this.eYk;
            C31591m c31272i = new C31272i(this);
            C31214a c9602j = new C9602j(this);
            try {
                if (C1443d.m3068iW(23)) {
                    c26380f = new C26380f(c24670c, new C32753f(c31272i, c9602j));
                } else {
                    c26380f = new C9582e(c24670c, new C32755g(c31272i, c9602j));
                }
                this.eXO = c26380f;
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "create encoder error", new Object[0]);
                c18594c = C18594c.faj;
                C18594c.m28953VK();
                m53456cr(false);
            }
            this.eXQ = new C9587a(c42173c);
            C9587a c9587a = this.eXQ;
            if (c9587a != null) {
                c9587a.eXd = new C32754h(this);
            }
            this.eYh = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_remuxer_with_surface_timestamp, 0) == 0;
            C4990ab.m7416i(this.TAG, "remuxImpl, use useRequestDraw:" + this.eYh);
            if (C5047bp.dpL()) {
                C4990ab.m7416i(this.TAG, "in debug environment, set useRequestDraw to false");
                this.eYh = false;
            }
            c26380f = this.eXO;
            if (c26380f != null) {
                C9587a c9587a2 = this.eXQ;
                if (c9587a2 != null) {
                    Surface inputSurface = c26380f.getInputSurface();
                    C17126b c32749e = new C32749e(this);
                    C25052j.m39376p(inputSurface, "surface");
                    c9587a2.aOO = inputSurface;
                    c9587a2.eXj = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_remuxer_with_surface_timestamp, 0) == 1;
                    C4990ab.m7416i(c9587a2.TAG, c9587a2.hashCode() + " initForRemuxer, surface:" + inputSurface + ", callback:false, drawInOnFrameAvailable:" + c9587a2.eXj);
                    if (C5047bp.dpL()) {
                        C4990ab.m7416i(c9587a2.TAG, "in debug environment, set drawInOnFrameAvailable to true");
                        c9587a2.eXj = true;
                    }
                    c9587a2.mo20913b((C31214a) new C9590b(c9587a2, inputSurface, c32749e));
                    AppMethodBeat.m2505o(13057);
                    return;
                }
                AppMethodBeat.m2505o(13057);
                return;
            }
            AppMethodBeat.m2505o(13057);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace(this.TAG, e2, "remux impl error", new Object[0]);
            AppMethodBeat.m2505o(13057);
        }
    }

    /* renamed from: r */
    public final void mo53306r(Bitmap bitmap) {
        AppMethodBeat.m2504i(13058);
        C25052j.m39376p(bitmap, "bitmap");
        this.eXi = bitmap;
        C9587a c9587a = this.eXQ;
        if (c9587a != null) {
            C4990ab.m7416i(c9587a.TAG, "setDrawBlendBitmap:" + (bitmap != null ? bitmap.hashCode() : 0));
            c9587a.eXi = bitmap;
            AppMethodBeat.m2505o(13058);
            return;
        }
        AppMethodBeat.m2505o(13058);
    }

    /* renamed from: Va */
    public final int mo53305Va() {
        AppMethodBeat.m2504i(13059);
        C4990ab.m7416i(this.TAG, "start remux, initFinish:" + this.eXW);
        this.eXZ = C5046bo.m7588yz();
        if (this.eXi != null && this.eXL > 0) {
            this.eXi = C5056d.m7648b(this.eXi, -((float) this.eXL));
        }
        this.eYa.eOm.reset();
        if (this.eXW) {
            C5004al c5004al = this.eXU;
            if (c5004al != null) {
                c5004al.quit();
            }
            this.eXU = C8902b.m16045b(new C9598c(this), "MediaCodecRemux_audioMix");
            c5004al = this.eXV;
            if (c5004al != null) {
                c5004al.quit();
            }
            if (this.eXA != null) {
                this.eXV = C8902b.m16045b(new C9599d(this), "MediaCodecRemux_videoMix");
            }
        } else {
            this.eXX = true;
        }
        AppMethodBeat.m2505o(13059);
        return 0;
    }

    /* renamed from: cq */
    private final synchronized void m53455cq(boolean z) {
        AppMethodBeat.m2504i(13060);
        C4990ab.m7416i(this.TAG, "finishRemux, isVideo: " + z + ", isAudioRemuxFinish:" + this.eYd + ", isVideoRemuxFinish:" + this.eYc + ", isInvokeEndCallback:" + this.eYb);
        if (z) {
            this.eYc = true;
        } else {
            this.eYd = true;
        }
        if (this.eYd && this.eYc && !this.eYb) {
            C9587a c9587a = this.eXQ;
            if (c9587a != null) {
                c9587a.release();
            }
            this.eYa.mo67718SW();
            this.eYb = true;
            try {
                C1785a c1785a = C1784i.eYK;
                C5730e.deleteFile(C1785a.m3670lX(this.filePath));
                c1785a = C1784i.eYK;
                C5730e.deleteFile(C1785a.m3671lY(this.filePath));
            } catch (Exception e) {
            }
            this.eTz.release();
            C32742a c32742a = this.eXT;
            if (c32742a != null) {
                c32742a.release();
            }
            C32757f c32757f = this.eXY;
            if (c32757f != null) {
                C17126b c17126b = c32757f.eYG;
                if (c17126b != null) {
                    c17126b.mo50am(this.eYq);
                }
            }
            C5004al c5004al = this.eXU;
            if (c5004al != null) {
                c5004al.quit();
            }
            c5004al = this.eXV;
            if (c5004al != null) {
                c5004al.quit();
            }
            long az = C5046bo.m7525az(this.eXZ);
            C4990ab.m7416i(this.TAG, "remux used " + az + " decodeFrame:" + this.eYe + ", encodeFrame:" + this.eST + ", drawFrameCount:" + this.eYf);
            try {
                C43528a WR = C21846d.m33388WR(this.eYj);
                if (WR != null) {
                    C18594c c18594c = C18594c.faj;
                    C18594c.m28996t(this.eTb, az);
                    C18594c c18594c2 = C18594c.faj;
                    C18594c.m28992d((long) WR.videoBitrate, (long) WR.eTk, (long) this.videoFps);
                    if (((double) (((float) this.eYe) / ((float) this.eST))) >= 1.5d) {
                        c18594c2 = C18594c.faj;
                        C18594c.m28962VT();
                        AppMethodBeat.m2505o(13060);
                    }
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.m2505o(13060);
    }

    /* renamed from: cr */
    private final synchronized void m53456cr(boolean z) {
        AppMethodBeat.m2504i(13061);
        C4990ab.m7416i(this.TAG, "onDecoderEncoderFailed, isDecoder:".concat(String.valueOf(z)));
        if (!this.eYb) {
            C9587a c9587a = this.eXQ;
            if (c9587a != null) {
                c9587a.release();
            }
            this.eYa.mo67718SW();
            this.eYb = true;
            try {
                C1785a c1785a = C1784i.eYK;
                C5730e.deleteFile(C1785a.m3670lX(this.filePath));
                c1785a = C1784i.eYK;
                C5730e.deleteFile(C1785a.m3671lY(this.filePath));
                this.eTz.release();
                C32742a c32742a = this.eXT;
                if (c32742a != null) {
                    c32742a.release();
                }
                C5004al c5004al = this.eXU;
                if (c5004al != null) {
                    c5004al.quit();
                }
                c5004al = this.eXV;
                if (c5004al != null) {
                    c5004al.quit();
                }
                C5730e.deleteFile(this.eYj);
                C4990ab.m7416i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(C5046bo.m7525az(this.eXZ))));
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "onDecoderEncoderFailed error:" + e.getMessage(), new Object[0]);
            }
            C17126b c17126b = this.eYq;
            if (c17126b != null) {
                c17126b.mo50am(null);
                AppMethodBeat.m2505o(13061);
            }
        }
        AppMethodBeat.m2505o(13061);
        return;
    }

    static {
        AppMethodBeat.m2504i(13063);
        AppMethodBeat.m2505o(13063);
    }

    /* renamed from: i */
    public static final /* synthetic */ void m53464i(C32751e c32751e) {
        AppMethodBeat.m2504i(13065);
        C45426b c45426b = c32751e.eXO;
        if (c45426b != null) {
            c45426b.mo20899UO();
            AppMethodBeat.m2505o(13065);
            return;
        }
        AppMethodBeat.m2505o(13065);
    }

    /* renamed from: z */
    public static final /* synthetic */ void m53481z(C32751e c32751e) {
        C18594c c18594c;
        AppMethodBeat.m2504i(13067);
        C4990ab.m7416i(c32751e.TAG, "runAudioMix, mixType:" + c32751e.eTb);
        C32742a c32742a = c32751e.eXT;
        if (c32742a != null) {
            c32742a.mo53291UU();
        }
        int i = c32751e.eTb;
        if (i == 1) {
            C1783h c1783h = c32751e.eXR;
            c1783h.mo5330a(c32751e.eXT, c1783h.eXM, c1783h.eXN);
            c32751e.m53455cq(false);
            AppMethodBeat.m2505o(13067);
            return;
        }
        if (C7987l.listOf(Integer.valueOf(2), Integer.valueOf(3)).contains(Integer.valueOf(i))) {
            MediaFormat mediaFormat;
            long yz = C5046bo.m7588yz();
            c32751e.eXP = new C18562a(c32751e.eXR.eTa, c32751e.eTb, c32751e.eYo, new C9603k(c32751e));
            C18562a c18562a = c32751e.eXP;
            if (c18562a != null) {
                MediaFormat mediaFormat2;
                C18580a c37886c;
                C32742a c32742a2 = c32751e.eXT;
                C32742a c32742a3 = c32751e.eXS;
                long j = c32751e.eXR.eXM;
                long j2 = c32751e.eXR.eXN;
                C4990ab.m7416i(c18562a.TAG, "init decoder background " + c32742a2 + "music is " + c32742a3);
                if (c32742a2 != null) {
                    try {
                        mediaFormat2 = c32742a2.eWf;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace(c18562a.TAG, e, "", new Object[0]);
                        c18594c = C18594c.faj;
                        C18594c.m28957VO();
                        Throwable th = e;
                        AppMethodBeat.m2505o(13067);
                        throw th;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace(c32751e.TAG, e2, "mix audio error: " + e2.getMessage(), new Object[0]);
                        c32751e.m53455cq(false);
                        AppMethodBeat.m2505o(13067);
                        return;
                    }
                }
                mediaFormat2 = null;
                c18562a.mMediaFormat = mediaFormat2;
                if (c18562a.mMediaFormat == null && c18562a.eTb == 3) {
                    c18562a.eTb = 2;
                    C4990ab.m7420w(c18562a.TAG, "background AudioFormat is null, recreate AudioMixCodec, sampleRate:" + c18562a.sampleRate + ", channelCount:" + c18562a.aOn);
                    c18562a.eSL = new C1774a(c18562a.sampleRate, c18562a.aOn, C7987l.listOf(Integer.valueOf(3), Integer.valueOf(1)).contains(Integer.valueOf(c18562a.eTb)), C7987l.listOf(Integer.valueOf(2), Integer.valueOf(3)).contains(Integer.valueOf(c18562a.eTb)), new C18560c(c18562a), new C18569e(c18562a));
                    c18594c = C18594c.faj;
                    C18594c.m28963VU();
                }
                if (c18562a.eTb == 3 && c32742a2 != null) {
                    c18562a.mMediaFormat = c32742a2.eWf;
                    if (C41711b.m73393fP(23)) {
                        c37886c = new C37886c(c32742a2, "background", j, j2, new C18570f(c18562a), new C18567g(c18562a));
                    } else {
                        c18562a.eSY = true;
                        c37886c = new C42166d(c32742a2, "background", j, j2, new C18573h(c18562a), new C1769i(c18562a));
                    }
                    c18562a.eSJ = c37886c;
                }
                if (c32742a3 != null) {
                    if (C41711b.m73393fP(23)) {
                        c37886c = new C37886c(c32742a3, "music", 0, j2 - j, new C1770j(c18562a), new C18565k(c18562a));
                    } else {
                        c18562a.eSY = true;
                        c37886c = new C42166d(c32742a3, "music", 0, j2 - j, new C9578l(c18562a), new C18566d(c18562a));
                    }
                    c18562a.eSI = c37886c;
                }
            }
            c32742a = c32751e.eXS;
            if (c32742a != null) {
                mediaFormat = c32742a.eWf;
            } else {
                mediaFormat = null;
            }
            if (mediaFormat == null) {
                C25052j.dWJ();
            }
            if (!mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) {
                mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, c32751e.eYn);
            }
            C18562a c18562a2 = c32751e.eXP;
            if (c18562a2 != null) {
                C25052j.m39376p(mediaFormat, "mediaFormat");
                try {
                    C37887a c41212c;
                    if (C41711b.m73393fP(23)) {
                        c41212c = new C41212c(mediaFormat, new C18577m(c18562a2), new C18574n(c18562a2));
                    } else {
                        c18562a2.eSY = true;
                        c41212c = new C26377d(mediaFormat, new C18571o(c18562a2), new C18578p(c18562a2));
                    }
                    c18562a2.eSK = c41212c;
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace(c18562a2.TAG, e3, "", new Object[0]);
                    c18594c = C18594c.faj;
                    C18594c.m28958VP();
                }
            }
            C18562a c18562a3 = c32751e.eXP;
            if (c18562a3 != null) {
                C31214a c31559l = new C31559l(c32751e, yz);
                C1774a c1774a = c18562a3.eSL;
                if (c1774a != null) {
                    C4990ab.m7416i(c1774a.TAG, "startMix");
                    C8902b.m16043a((C31214a) new C1775c(c1774a), "AudioMixCodec_MixAudio");
                    c1774a.eWr = true;
                }
                if (c18562a3.eTb == 3) {
                    C8902b.m16043a((C31214a) new C18561s(c18562a3), "BackgroundDecoder");
                }
                C8902b.m16043a((C31214a) new C18568t(c18562a3), "MusicDecoder");
                C4990ab.m7416i(c18562a3.TAG, "startCodec");
                c18562a3.eSR = c31559l;
                c18562a3.eSZ = C5046bo.m7588yz();
                AppMethodBeat.m2505o(13067);
                return;
            }
            AppMethodBeat.m2505o(13067);
            return;
        }
        if (i == 0) {
            c32751e.m53455cq(false);
        }
        AppMethodBeat.m2505o(13067);
    }

    /* renamed from: A */
    public static final /* synthetic */ void m53439A(C32751e c32751e) {
        AppMethodBeat.m2504i(13068);
        C5004al.m7442n(new C1781b(c32751e), eYr);
        AppMethodBeat.m2505o(13068);
    }
}
