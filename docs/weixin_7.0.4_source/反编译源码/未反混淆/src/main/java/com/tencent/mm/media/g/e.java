package com.tencent.mm.media.g;

import a.f.a.m;
import a.y;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.a.a.n;
import com.tencent.mm.media.a.a.o;
import com.tencent.mm.media.a.a.p;
import com.tencent.mm.media.a.a.s;
import com.tencent.mm.media.a.a.t;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import java.nio.ByteBuffer;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012%\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012¢\u0006\u0002\u0010\u0017J\b\u0010H\u001a\u00020\u0016H\u0002J\u0010\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u0003H\u0002J\b\u0010K\u001a\u00020\u0016H\u0002J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020,H\u0002J\b\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020,H\u0002J\b\u0010R\u001a\u00020\u0006H\u0016J\u0010\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010V\u001a\u00020\u0016H\u0002J\u0010\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020 H\u0016J\u001c\u0010Y\u001a\u00020\u00162\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010 0\u0012R\u000e\u0010\u0018\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R-\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006["}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIIIIJJLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "firstFrameDraw", "", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "useRequestDraw", "videoDuration", "videoFps", "videoMixHandlerThread", "videoRotate", "checkFrameDrawTimeout", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "renderer", "Lcom/tencent/mm/media/render/MixRenderer;", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "Companion", "plugin-mediaeditor_release"})
public final class e extends c {
    private static final long eYr = 1000;
    public static final a eYs = new a();
    private final String TAG = "MicroMsg.MediaCodecRemuxer";
    private int eST;
    private int eTb;
    private com.tencent.mm.media.e.a eTz;
    private int eWK = -1;
    private com.tencent.mm.media.c.b eXA;
    private int eXJ;
    private int eXK;
    private int eXL;
    private long eXM;
    private long eXN;
    private com.tencent.mm.media.d.b eXO;
    private com.tencent.mm.media.a.a eXP;
    public a eXQ;
    private h eXR;
    private com.tencent.mm.media.e.a eXS;
    private com.tencent.mm.media.e.a eXT;
    private al eXU;
    private al eXV;
    private boolean eXW;
    private boolean eXX;
    private f eXY;
    private long eXZ;
    public a.f.a.b<? super Long, Bitmap> eXh;
    private Bitmap eXi;
    private final com.tencent.mm.media.i.a eYa;
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
    private a.f.a.b<? super String, y> eYq;
    private String filePath;
    private int videoFps;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$Companion;", "", "()V", "CHECK_FRAME_DRWA_TIMEOUT", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ e eYt;

        b(e eVar) {
            this.eYt = eVar;
        }

        public final void run() {
            AppMethodBeat.i(13042);
            ab.i(this.eYt.TAG, "delay check frameDraw: " + this.eYt.eYg);
            if (!this.eYt.eYg) {
                ab.e(this.eYt.TAG, "after " + e.eYr + " ms, first frame stil not draw!!!");
                com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.Wd();
            }
            AppMethodBeat.o(13042);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ e eYt;

        c(e eVar) {
            this.eYt = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13043);
            e.z(this.eYt);
            y yVar = y.AUy;
            AppMethodBeat.o(13043);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ e eYt;

        d(e eVar) {
            this.eYt = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13044);
            com.tencent.mm.media.c.b h = this.eYt.eXA;
            if (h != null) {
                h.UB();
            }
            e.A(this.eYt);
            y yVar = y.AUy;
            AppMethodBeat.o(13044);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class j extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ e eYt;

        j(e eVar) {
            this.eYt = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13054);
            com.tencent.mm.media.d.b d = this.eYt.eXO;
            if (d != null) {
                d.release();
            }
            e.a(this.eYt, true);
            y yVar = y.AUy;
            AppMethodBeat.o(13054);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    static final class k extends a.f.b.k implements m<ByteBuffer, BufferInfo, y> {
        final /* synthetic */ e eYt;

        k(e eVar) {
            this.eYt = eVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(13055);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            a.f.b.j.p(byteBuffer, "buffer");
            a.f.b.j.p(bufferInfo, "bufferInfo");
            f c = this.eYt.eXY;
            if (c != null) {
                m mVar = c.eYF;
                if (mVar != null) {
                    mVar.m(byteBuffer, bufferInfo);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13055);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    static final class i extends a.f.b.k implements m<ByteBuffer, BufferInfo, y> {
        final /* synthetic */ e eYt;

        i(e eVar) {
            this.eYt = eVar;
            super(2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0053  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object m(Object obj, Object obj2) {
            y yVar;
            AppMethodBeat.i(13053);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            a.f.b.j.p(byteBuffer, "byteBuffer");
            a.f.b.j.p(bufferInfo, "bufferInfo");
            ab.i(this.eYt.TAG, "onEncode: " + this.eYt.eST);
            e eVar = this.eYt;
            eVar.eST = eVar.eST + 1;
            f c = this.eYt.eXY;
            if (c != null) {
                m mVar = c.eYE;
                if (mVar != null) {
                    yVar = (y) mVar.m(byteBuffer, bufferInfo);
                    if (yVar == null) {
                        a.f.b.j.dWJ();
                    }
                    yVar = y.AUy;
                    AppMethodBeat.o(13053);
                    return yVar;
                }
            }
            yVar = null;
            if (yVar == null) {
            }
            yVar = y.AUy;
            AppMethodBeat.o(13053);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class l extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ e eYt;
        final /* synthetic */ long eYz;

        l(e eVar, long j) {
            this.eYt = eVar;
            this.eYz = j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13056);
            com.tencent.mm.media.a.a x = this.eYt.eXP;
            if (x != null) {
                com.tencent.mm.media.c.a aVar = x.eSJ;
                if (aVar != null) {
                    aVar.UA();
                }
                aVar = x.eSI;
                if (aVar != null) {
                    aVar.UA();
                }
                com.tencent.mm.media.d.a aVar2 = x.eSK;
                if (aVar2 == null) {
                    a.f.b.j.avw("mAudioEncoder");
                }
                aVar2.stopEncoder();
                com.tencent.mm.sdk.g.d.xDG.remove(x.eSX);
                com.tencent.mm.sdk.g.d.xDG.remove(x.eSW);
                x.eSP.quit();
                if (x.eSZ > 0) {
                    long az = bo.az(x.eSZ);
                    com.tencent.mm.media.i.c cVar;
                    if (x.eSY) {
                        cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.VR();
                        cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.fg(az);
                    } else {
                        cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.VS();
                        cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.fh(az);
                    }
                }
            }
            ab.i(this.eYt.TAG, "mix audio used " + bo.az(this.eYz));
            com.tencent.mm.media.e.a y = this.eYt.eXS;
            if (y != null) {
                y.release();
            }
            e.a(this.eYt, false);
            y yVar = y.AUy;
            AppMethodBeat.o(13056);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1"})
    static final class e extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ e eYt;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1$onDecodeEnd$1"})
        /* renamed from: com.tencent.mm.media.g.e$e$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ e eYu;

            AnonymousClass1(e eVar) {
                this.eYu = eVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(13045);
                ab.i(this.eYu.eYt.TAG, "onDecodeEnd");
                e.i(this.eYu.eYt);
                y yVar = y.AUy;
                AppMethodBeat.o(13045);
                return yVar;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1$1"})
        /* renamed from: com.tencent.mm.media.g.e$e$3 */
        static final class AnonymousClass3 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ e eYu;

            AnonymousClass3(e eVar) {
                this.eYu = eVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(138367);
                ab.i(this.eYu.eYt.TAG, "onDrawFrameOnFrameAvailableFailed!! force use request draw");
                this.eYu.eYt.eYh = true;
                com.tencent.mm.media.c.b h = this.eYu.eYt.eXA;
                if (h != null) {
                    h.cp(false);
                }
                com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.We();
                a o = this.eYu.eYt.eXQ;
                if (o != null) {
                    o.eXk = null;
                }
                y yVar = y.AUy;
                AppMethodBeat.o(138367);
                return yVar;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "invoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$remuxImpl$5$1$onDecode$1"})
        /* renamed from: com.tencent.mm.media.g.e$e$2 */
        static final class AnonymousClass2 extends a.f.b.k implements m<ByteBuffer, Long, y> {
            final /* synthetic */ e eYu;

            AnonymousClass2(e eVar) {
                this.eYu = eVar;
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                long k;
                AppMethodBeat.i(13046);
                long longValue = ((Number) obj2).longValue();
                e eVar = this.eYu.eYt;
                eVar.eYe = eVar.eYe + 1;
                com.tencent.mm.media.c.b h = this.eYu.eYt.eXA;
                if (h != null) {
                    h.cp(true);
                }
                if (this.eYu.eYt.eXM >= 0) {
                    k = longValue - (this.eYu.eYt.eXM * 1000);
                } else {
                    k = longValue;
                }
                ab.d(this.eYu.eYt.TAG, "onDecode, drawPts:" + k + ", pts:" + longValue + ", remuxStartTime:" + this.eYu.eYt.eXM);
                if (this.eYu.eYt.eYh) {
                    a o;
                    if (this.eYu.eYt.eXi != null) {
                        o = this.eYu.eYt.eXQ;
                        if (o != null) {
                            o.a(k * 1000, this.eYu.eYt.eXi);
                        }
                    } else {
                        o = this.eYu.eYt.eXQ;
                        if (o != null) {
                            long j = k * 1000;
                            a.f.a.b p = this.eYu.eYt.eXh;
                            o.a(j, p != null ? (Bitmap) p.am(Long.valueOf(k)) : null);
                        }
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(13046);
                return yVar;
            }
        }

        e(e eVar) {
            this.eYt = eVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            com.tencent.mm.media.i.c cVar;
            AppMethodBeat.i(13049);
            if (!((Boolean) obj).booleanValue()) {
                cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VM();
            }
            final a.f.a.a anonymousClass1 = new AnonymousClass1(this);
            final m anonymousClass2 = new AnonymousClass2(this);
            a o = this.eYt.eXQ;
            if (o != null) {
                o.eXk = new AnonymousClass3(this);
            }
            try {
                com.tencent.mm.media.c.b fVar;
                e eVar = this.eYt;
                long k;
                long q;
                com.tencent.mm.media.e.a r;
                a o2;
                if (com.tencent.mm.compatible.util.d.iW(23)) {
                    k = this.eYt.eXM;
                    q = this.eYt.eXN;
                    r = this.eYt.eTz;
                    o2 = this.eYt.eXQ;
                    if (o2 == null) {
                        a.f.b.j.dWJ();
                    }
                    fVar = new com.tencent.mm.media.c.f(k, q, r, o2.UY(), new a.f.a.b<com.tencent.mm.media.c.b, y>() {
                        public final /* synthetic */ Object am(Object obj) {
                            AppMethodBeat.i(13048);
                            com.tencent.mm.media.c.b bVar = (com.tencent.mm.media.c.b) obj;
                            a.f.b.j.p(bVar, "receiver$0");
                            bVar.eTG = anonymousClass2;
                            bVar.eTH = anonymousClass1;
                            bVar.eTO = true;
                            y yVar = y.AUy;
                            AppMethodBeat.o(13048);
                            return yVar;
                        }
                    });
                } else {
                    k = this.eYt.eXM;
                    q = this.eYt.eXN;
                    r = this.eYt.eTz;
                    o2 = this.eYt.eXQ;
                    if (o2 == null) {
                        a.f.b.j.dWJ();
                    }
                    fVar = new com.tencent.mm.media.c.e(k, q, r, o2.UY(), new a.f.a.b<com.tencent.mm.media.c.b, y>() {
                        public final /* synthetic */ Object am(Object obj) {
                            AppMethodBeat.i(138368);
                            com.tencent.mm.media.c.b bVar = (com.tencent.mm.media.c.b) obj;
                            a.f.b.j.p(bVar, "receiver$0");
                            bVar.eTG = anonymousClass2;
                            bVar.eTH = anonymousClass1;
                            bVar.eTO = true;
                            y yVar = y.AUy;
                            AppMethodBeat.o(138368);
                            return yVar;
                        }
                    });
                }
                eVar.eXA = fVar;
            } catch (Exception e) {
                ab.printErrStackTrace(this.eYt.TAG, e, "init decoder error", new Object[0]);
                cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VL();
                e.s(this.eYt);
            }
            int t = this.eYt.videoFps - 1;
            int u = this.eYt.eYp;
            if (1 <= u && t >= u) {
                com.tencent.mm.media.c.b h = this.eYt.eXA;
                if (h != null) {
                    u = (int) Math.ceil((double) (((float) this.eYt.videoFps) / ((float) this.eYt.eYp)));
                    ab.i(h.TAG, "setFrameDropInterval: ".concat(String.valueOf(u)));
                    h.eTJ = u;
                    if (h.eTJ > 1) {
                        cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.Wa();
                    }
                }
            }
            this.eYt.eXW = true;
            if (this.eYt.eXX) {
                this.eYt.Va();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13049);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "checker", "Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.e$1 */
    static final class AnonymousClass1 extends a.f.b.k implements m<MediaFormat, d, y> {
        final /* synthetic */ e eYt;

        AnonymousClass1(e eVar) {
            this.eYt = eVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            y yVar;
            AppMethodBeat.i(13041);
            MediaFormat mediaFormat = (MediaFormat) obj;
            a.f.b.j.p((d) obj2, "checker");
            if (mediaFormat != null) {
                int i;
                a.f.b.j.p(mediaFormat, "mediaFormat");
                if (mediaFormat.containsKey("crop-left") || mediaFormat.containsKey("crop-top") || mediaFormat.containsKey("crop-right") || mediaFormat.containsKey("crop-bottom")) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    int integer;
                    int integer2;
                    com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.VH();
                    ab.i(this.eYt.TAG, "after check, has crop rect:".concat(String.valueOf(mediaFormat)));
                    a.f.b.j.p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-left")) {
                        integer = mediaFormat.getInteger("crop-left");
                    } else {
                        integer = 0;
                    }
                    a.f.b.j.p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-right")) {
                        i = mediaFormat.getInteger("crop-right");
                    } else {
                        i = 0;
                    }
                    int i2 = i + 1;
                    a.f.b.j.p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-top")) {
                        integer2 = mediaFormat.getInteger("crop-top");
                    } else {
                        integer2 = 0;
                    }
                    a.f.b.j.p(mediaFormat, "mediaFormat");
                    if (mediaFormat.containsKey("crop-bottom")) {
                        i = mediaFormat.getInteger("crop-bottom");
                    } else {
                        i = 0;
                    }
                    int i3 = i + 1;
                    ab.i(this.eYt.TAG, "cropRect:[" + integer + ", " + integer2 + ", " + i2 + ", " + i3 + ']');
                    com.tencent.mm.media.h.c cVar2 = new com.tencent.mm.media.h.c(this.eYt.eYk, this.eYt.eYl, this.eYt.eYk, this.eYt.eYl, 0, 3, 16);
                    Rect rect = new Rect(integer, integer2, i2, i3);
                    a.f.b.j.p(rect, "rect");
                    cVar2.eZd = rect;
                    this.eYt.eYk = this.eYt.eXJ;
                    this.eYt.eYl = this.eYt.eXK;
                    e.a(this.eYt, cVar2);
                    yVar = y.AUy;
                    AppMethodBeat.o(13041);
                    return yVar;
                }
            }
            e.a(this.eYt, new com.tencent.mm.media.h.c(this.eYt.eXJ, this.eYt.eXK, this.eYt.eYk, this.eYt.eYl, 0, 0, 48));
            yVar = y.AUy;
            AppMethodBeat.o(13041);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.b<com.tencent.mm.media.d.b, y> {
        final /* synthetic */ m eYx;
        final /* synthetic */ a.f.a.a eYy;

        f(m mVar, a.f.a.a aVar) {
            this.eYx = mVar;
            this.eYy = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13050);
            com.tencent.mm.media.d.b bVar = (com.tencent.mm.media.d.b) obj;
            a.f.b.j.p(bVar, "receiver$0");
            bVar.eVy = this.eYx;
            bVar.eVz = this.eYy;
            bVar.eTO = true;
            y yVar = y.AUy;
            AppMethodBeat.o(13050);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ e eYt;

        h(e eVar) {
            this.eYt = eVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13052);
            if (!((Boolean) obj).booleanValue()) {
                com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VN();
            }
            e eVar = this.eYt;
            eVar.eYf = eVar.eYf + 1;
            this.eYt.eYg = true;
            f c = this.eYt.eXY;
            if (c != null) {
                a.f.a.a aVar = c.eYH;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
            com.tencent.mm.media.d.b d = this.eYt.eXO;
            if (d != null) {
                d.UP();
            }
            com.tencent.mm.media.c.b h = this.eYt.eXA;
            if (h != null) {
                h.cp(false);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13052);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    static final class g extends a.f.b.k implements a.f.a.b<com.tencent.mm.media.d.b, y> {
        final /* synthetic */ m eYx;
        final /* synthetic */ a.f.a.a eYy;

        g(m mVar, a.f.a.a aVar) {
            this.eYx = mVar;
            this.eYy = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13051);
            com.tencent.mm.media.d.b bVar = (com.tencent.mm.media.d.b) obj;
            a.f.b.j.p(bVar, "receiver$0");
            bVar.eVy = this.eYx;
            bVar.eVz = this.eYy;
            bVar.eTO = true;
            y yVar = y.AUy;
            AppMethodBeat.o(13051);
            return yVar;
        }
    }

    public static final /* synthetic */ void s(e eVar) {
        AppMethodBeat.i(13066);
        eVar.cr(true);
        AppMethodBeat.o(13066);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x02d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(String str, String str2, int i, String str3, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2, a.f.a.b<? super String, y> bVar) {
        a.f.b.j.p(str2, "filePath");
        a.f.b.j.p(str3, "outputFilePath");
        AppMethodBeat.i(13062);
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
        this.eYq = bVar;
        this.eXM = j;
        this.eXN = -1;
        this.eYa = new com.tencent.mm.media.i.a("remuxCost");
        com.tencent.mm.media.i.c cVar;
        Throwable illegalArgumentException;
        if (bo.isNullOrNil(this.filePath) || !com.tencent.mm.vfs.e.ct(this.filePath) || bo.isNullOrNil(this.eYj) || this.eYk <= 0 || this.eYl <= 0) {
            ab.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.eYj + ", outputWidth:" + this.eYk + ", outputHeight:" + this.eYl + ", videoFps:" + this.videoFps + ", outputFps:" + this.eYp);
            cVar = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.VE();
            illegalArgumentException = new IllegalArgumentException("create MediaCodecRemuxer error");
            AppMethodBeat.o(13062);
            throw illegalArgumentException;
        }
        cVar = com.tencent.mm.media.i.c.faj;
        com.tencent.mm.media.i.c.kc(this.eTb);
        if (com.tencent.mm.bj.e.uD(this.filePath)) {
            ab.i(this.TAG, "remux h265 format");
            cVar = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.VD();
        }
        com.tencent.mm.vfs.e.tf(com.tencent.mm.vfs.e.atb(this.eYj));
        this.eXL = SightVideoJNI.getMp4Rotate(this.filePath);
        com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(this.filePath);
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
                this.eXJ = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                this.eXK = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                mediaMetadataRetriever.release();
            } catch (Exception e) {
            }
        }
        if (this.videoFps <= 0) {
            ab.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
            cVar = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.VE();
            illegalArgumentException = new IllegalArgumentException("create MediaCodecRemuxer error");
            AppMethodBeat.o(13062);
            throw illegalArgumentException;
        }
        boolean z;
        if (j2 == 0) {
            this.eXN = (long) this.eWK;
        } else {
            this.eXN = j2;
        }
        this.eXR = new h(this.eXM, this.eXN, this.eYm);
        ab.c(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.eYj + ", inputWidth: " + this.eXJ + ", inputHeight: " + this.eXK + ", videoRotate: " + this.eXL + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.eYm + ", outputAudioBitrate:" + this.eYn + " , outputWidth: " + this.eYk + ", outputHeight: " + this.eYl + ',' + " startTimeMs: " + j + ", endTimeMs: " + j2 + " , outputFps: " + this.eYp + " , videoDuration: " + this.eWK + " , remuxStartTime: " + this.eXM + " ,remuxEndTime: " + this.eXN + " , input bitrate:" + WR.videoBitrate, new Object[0]);
        this.eTz = new com.tencent.mm.media.e.a(this.filePath);
        if (this.eTz.eWh) {
            cVar = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.VF();
        }
        int i8 = this.eYk - this.eXJ;
        if (1 > i8 || 16 <= i8) {
            i8 = this.eYl - this.eXK;
            if (1 > i8 || 16 <= i8) {
                z = false;
                ab.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(z)));
                if (z) {
                    a(new com.tencent.mm.media.h.c(this.eXJ, this.eXK, this.eYk, this.eYl, 0, 0, 48));
                    AppMethodBeat.o(13062);
                    return;
                }
                cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VG();
                d dVar = new d(this.eTz);
                m anonymousClass1 = new AnonymousClass1(this);
                dVar.exT = anonymousClass1;
                try {
                    com.tencent.mm.media.c.b fVar;
                    if (com.tencent.mm.compatible.util.d.iW(23)) {
                        fVar = new com.tencent.mm.media.c.f(0, (long) (dVar.eXD.getDuration() / 1000), dVar.eXD, null, new c(dVar));
                    } else {
                        fVar = new com.tencent.mm.media.c.e(0, (long) (dVar.eXD.getDuration() / 1000), dVar.eXD, null, new d(dVar));
                    }
                    dVar.eXA = fVar;
                } catch (Exception e2) {
                    ab.printErrStackTrace(dVar.TAG, e2, "start check init decoder error", new Object[0]);
                    com.tencent.mm.media.i.c cVar2 = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.VZ();
                    anonymousClass1.m(null, dVar);
                }
                com.tencent.mm.ab.b.b(new e(dVar), "MediaCodecCheckVideoCropRect_decode");
                AppMethodBeat.o(13062);
                return;
            }
        }
        z = true;
        ab.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(z)));
        if (z) {
        }
    }

    private final void a(com.tencent.mm.media.h.c cVar) {
        com.tencent.mm.media.i.c cVar2;
        AppMethodBeat.i(13057);
        String str = this.filePath;
        com.tencent.mm.media.g.i.a aVar = i.eYK;
        String lY = com.tencent.mm.media.g.i.a.lY(str);
        if (str == null) {
            ab.e(this.TAG, "copyVideoFile invalid parameters, can not be null");
        } else {
            if (com.tencent.mm.vfs.e.ct(lY)) {
                com.tencent.mm.vfs.e.deleteFile(lY);
            }
            ab.i(this.TAG, "copyVideoFile from %s, to %s", str, lY);
            long yz = bo.yz();
            long y = com.tencent.mm.vfs.e.y(str, lY);
            ab.i(this.TAG, "copy video file cost " + bo.az(yz));
            if (y <= 0) {
                cVar2 = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VI();
            }
        }
        aVar = i.eYK;
        this.eXT = new com.tencent.mm.media.e.a(com.tencent.mm.media.g.i.a.lY(this.filePath));
        str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("useAudioRecord:false, cpVideoFile:");
        com.tencent.mm.media.g.i.a aVar2 = i.eYK;
        stringBuilder = stringBuilder.append(com.tencent.mm.media.g.i.a.lY(this.filePath)).append(", audioCpFile:");
        aVar2 = i.eYK;
        ab.i(str, stringBuilder.append(com.tencent.mm.media.g.i.a.lX(this.filePath)).toString());
        com.tencent.mm.media.e.a aVar3 = this.eXT;
        if (aVar3 != null) {
            this.eXY = new f(this.eXR, aVar3, this.eYj, this.eTb, this.eYo);
            if (com.tencent.mm.vfs.e.ct(this.eYi)) {
                lY = this.eYi;
                if (lY == null) {
                    a.f.b.j.dWJ();
                }
                com.tencent.mm.media.e.a aVar4 = new com.tencent.mm.media.e.a(lY);
                if (aVar4.eWh) {
                    com.tencent.mm.media.i.c cVar3 = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.VJ();
                }
                this.eXS = aVar4;
            }
        }
        f fVar = this.eXY;
        if (fVar != null) {
            fVar.eXL = this.eXL;
        }
        try {
            com.tencent.mm.media.d.b fVar2;
            int min = this.eYp > 0 ? Math.min(this.eYp, this.videoFps) : this.videoFps;
            com.tencent.mm.media.b.c cVar4 = new com.tencent.mm.media.b.c();
            cVar4.bitrate = this.eYm;
            cVar4.eTk = min;
            cVar4.eTj = this.eYl;
            cVar4.eTi = this.eYk;
            m iVar = new i(this);
            a.f.a.a jVar = new j(this);
            try {
                if (com.tencent.mm.compatible.util.d.iW(23)) {
                    fVar2 = new com.tencent.mm.media.d.f(cVar4, new f(iVar, jVar));
                } else {
                    fVar2 = new com.tencent.mm.media.d.e(cVar4, new g(iVar, jVar));
                }
                this.eXO = fVar2;
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "create encoder error", new Object[0]);
                cVar2 = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VK();
                cr(false);
            }
            this.eXQ = new a(cVar);
            a aVar5 = this.eXQ;
            if (aVar5 != null) {
                aVar5.eXd = new h(this);
            }
            this.eYh = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_remuxer_with_surface_timestamp, 0) == 0;
            ab.i(this.TAG, "remuxImpl, use useRequestDraw:" + this.eYh);
            if (bp.dpL()) {
                ab.i(this.TAG, "in debug environment, set useRequestDraw to false");
                this.eYh = false;
            }
            fVar2 = this.eXO;
            if (fVar2 != null) {
                a aVar6 = this.eXQ;
                if (aVar6 != null) {
                    Surface inputSurface = fVar2.getInputSurface();
                    a.f.a.b eVar = new e(this);
                    a.f.b.j.p(inputSurface, "surface");
                    aVar6.aOO = inputSurface;
                    aVar6.eXj = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_remuxer_with_surface_timestamp, 0) == 1;
                    ab.i(aVar6.TAG, aVar6.hashCode() + " initForRemuxer, surface:" + inputSurface + ", callback:false, drawInOnFrameAvailable:" + aVar6.eXj);
                    if (bp.dpL()) {
                        ab.i(aVar6.TAG, "in debug environment, set drawInOnFrameAvailable to true");
                        aVar6.eXj = true;
                    }
                    aVar6.b((a.f.a.a) new b(aVar6, inputSurface, eVar));
                    AppMethodBeat.o(13057);
                    return;
                }
                AppMethodBeat.o(13057);
                return;
            }
            AppMethodBeat.o(13057);
        } catch (Exception e2) {
            ab.printErrStackTrace(this.TAG, e2, "remux impl error", new Object[0]);
            AppMethodBeat.o(13057);
        }
    }

    public final void r(Bitmap bitmap) {
        AppMethodBeat.i(13058);
        a.f.b.j.p(bitmap, "bitmap");
        this.eXi = bitmap;
        a aVar = this.eXQ;
        if (aVar != null) {
            ab.i(aVar.TAG, "setDrawBlendBitmap:" + (bitmap != null ? bitmap.hashCode() : 0));
            aVar.eXi = bitmap;
            AppMethodBeat.o(13058);
            return;
        }
        AppMethodBeat.o(13058);
    }

    public final int Va() {
        AppMethodBeat.i(13059);
        ab.i(this.TAG, "start remux, initFinish:" + this.eXW);
        this.eXZ = bo.yz();
        if (this.eXi != null && this.eXL > 0) {
            this.eXi = com.tencent.mm.sdk.platformtools.d.b(this.eXi, -((float) this.eXL));
        }
        this.eYa.eOm.reset();
        if (this.eXW) {
            al alVar = this.eXU;
            if (alVar != null) {
                alVar.quit();
            }
            this.eXU = com.tencent.mm.ab.b.b(new c(this), "MediaCodecRemux_audioMix");
            alVar = this.eXV;
            if (alVar != null) {
                alVar.quit();
            }
            if (this.eXA != null) {
                this.eXV = com.tencent.mm.ab.b.b(new d(this), "MediaCodecRemux_videoMix");
            }
        } else {
            this.eXX = true;
        }
        AppMethodBeat.o(13059);
        return 0;
    }

    private final synchronized void cq(boolean z) {
        AppMethodBeat.i(13060);
        ab.i(this.TAG, "finishRemux, isVideo: " + z + ", isAudioRemuxFinish:" + this.eYd + ", isVideoRemuxFinish:" + this.eYc + ", isInvokeEndCallback:" + this.eYb);
        if (z) {
            this.eYc = true;
        } else {
            this.eYd = true;
        }
        if (this.eYd && this.eYc && !this.eYb) {
            a aVar = this.eXQ;
            if (aVar != null) {
                aVar.release();
            }
            this.eYa.SW();
            this.eYb = true;
            try {
                com.tencent.mm.media.g.i.a aVar2 = i.eYK;
                com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.media.g.i.a.lX(this.filePath));
                aVar2 = i.eYK;
                com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.media.g.i.a.lY(this.filePath));
            } catch (Exception e) {
            }
            this.eTz.release();
            com.tencent.mm.media.e.a aVar3 = this.eXT;
            if (aVar3 != null) {
                aVar3.release();
            }
            f fVar = this.eXY;
            if (fVar != null) {
                a.f.a.b bVar = fVar.eYG;
                if (bVar != null) {
                    bVar.am(this.eYq);
                }
            }
            al alVar = this.eXU;
            if (alVar != null) {
                alVar.quit();
            }
            alVar = this.eXV;
            if (alVar != null) {
                alVar.quit();
            }
            long az = bo.az(this.eXZ);
            ab.i(this.TAG, "remux used " + az + " decodeFrame:" + this.eYe + ", encodeFrame:" + this.eST + ", drawFrameCount:" + this.eYf);
            try {
                com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(this.eYj);
                if (WR != null) {
                    com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.t(this.eTb, az);
                    com.tencent.mm.media.i.c cVar2 = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.d((long) WR.videoBitrate, (long) WR.eTk, (long) this.videoFps);
                    if (((double) (((float) this.eYe) / ((float) this.eST))) >= 1.5d) {
                        cVar2 = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.VT();
                        AppMethodBeat.o(13060);
                    }
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(13060);
    }

    private final synchronized void cr(boolean z) {
        AppMethodBeat.i(13061);
        ab.i(this.TAG, "onDecoderEncoderFailed, isDecoder:".concat(String.valueOf(z)));
        if (!this.eYb) {
            a aVar = this.eXQ;
            if (aVar != null) {
                aVar.release();
            }
            this.eYa.SW();
            this.eYb = true;
            try {
                com.tencent.mm.media.g.i.a aVar2 = i.eYK;
                com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.media.g.i.a.lX(this.filePath));
                aVar2 = i.eYK;
                com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.media.g.i.a.lY(this.filePath));
                this.eTz.release();
                com.tencent.mm.media.e.a aVar3 = this.eXT;
                if (aVar3 != null) {
                    aVar3.release();
                }
                al alVar = this.eXU;
                if (alVar != null) {
                    alVar.quit();
                }
                alVar = this.eXV;
                if (alVar != null) {
                    alVar.quit();
                }
                com.tencent.mm.vfs.e.deleteFile(this.eYj);
                ab.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(bo.az(this.eXZ))));
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "onDecoderEncoderFailed error:" + e.getMessage(), new Object[0]);
            }
            a.f.a.b bVar = this.eYq;
            if (bVar != null) {
                bVar.am(null);
                AppMethodBeat.o(13061);
            }
        }
        AppMethodBeat.o(13061);
        return;
    }

    static {
        AppMethodBeat.i(13063);
        AppMethodBeat.o(13063);
    }

    public static final /* synthetic */ void i(e eVar) {
        AppMethodBeat.i(13065);
        com.tencent.mm.media.d.b bVar = eVar.eXO;
        if (bVar != null) {
            bVar.UO();
            AppMethodBeat.o(13065);
            return;
        }
        AppMethodBeat.o(13065);
    }

    public static final /* synthetic */ void z(e eVar) {
        com.tencent.mm.media.i.c cVar;
        AppMethodBeat.i(13067);
        ab.i(eVar.TAG, "runAudioMix, mixType:" + eVar.eTb);
        com.tencent.mm.media.e.a aVar = eVar.eXT;
        if (aVar != null) {
            aVar.UU();
        }
        int i = eVar.eTb;
        if (i == 1) {
            h hVar = eVar.eXR;
            hVar.a(eVar.eXT, hVar.eXM, hVar.eXN);
            eVar.cq(false);
            AppMethodBeat.o(13067);
            return;
        }
        if (a.a.l.listOf(Integer.valueOf(2), Integer.valueOf(3)).contains(Integer.valueOf(i))) {
            MediaFormat mediaFormat;
            long yz = bo.yz();
            eVar.eXP = new com.tencent.mm.media.a.a(eVar.eXR.eTa, eVar.eTb, eVar.eYo, new k(eVar));
            com.tencent.mm.media.a.a aVar2 = eVar.eXP;
            if (aVar2 != null) {
                MediaFormat mediaFormat2;
                com.tencent.mm.media.c.a cVar2;
                com.tencent.mm.media.e.a aVar3 = eVar.eXT;
                com.tencent.mm.media.e.a aVar4 = eVar.eXS;
                long j = eVar.eXR.eXM;
                long j2 = eVar.eXR.eXN;
                ab.i(aVar2.TAG, "init decoder background " + aVar3 + "music is " + aVar4);
                if (aVar3 != null) {
                    try {
                        mediaFormat2 = aVar3.eWf;
                    } catch (Exception e) {
                        ab.printErrStackTrace(aVar2.TAG, e, "", new Object[0]);
                        cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.VO();
                        Throwable th = e;
                        AppMethodBeat.o(13067);
                        throw th;
                    } catch (Exception e2) {
                        ab.printErrStackTrace(eVar.TAG, e2, "mix audio error: " + e2.getMessage(), new Object[0]);
                        eVar.cq(false);
                        AppMethodBeat.o(13067);
                        return;
                    }
                }
                mediaFormat2 = null;
                aVar2.mMediaFormat = mediaFormat2;
                if (aVar2.mMediaFormat == null && aVar2.eTb == 3) {
                    aVar2.eTb = 2;
                    ab.w(aVar2.TAG, "background AudioFormat is null, recreate AudioMixCodec, sampleRate:" + aVar2.sampleRate + ", channelCount:" + aVar2.aOn);
                    aVar2.eSL = new com.tencent.mm.media.f.a(aVar2.sampleRate, aVar2.aOn, a.a.l.listOf(Integer.valueOf(3), Integer.valueOf(1)).contains(Integer.valueOf(aVar2.eTb)), a.a.l.listOf(Integer.valueOf(2), Integer.valueOf(3)).contains(Integer.valueOf(aVar2.eTb)), new com.tencent.mm.media.a.a.c(aVar2), new com.tencent.mm.media.a.a.e(aVar2));
                    cVar = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.VU();
                }
                if (aVar2.eTb == 3 && aVar3 != null) {
                    aVar2.mMediaFormat = aVar3.eWf;
                    if (com.tencent.luggage.g.b.fP(23)) {
                        cVar2 = new com.tencent.mm.media.c.c(aVar3, "background", j, j2, new com.tencent.mm.media.a.a.f(aVar2), new com.tencent.mm.media.a.a.g(aVar2));
                    } else {
                        aVar2.eSY = true;
                        cVar2 = new com.tencent.mm.media.c.d(aVar3, "background", j, j2, new com.tencent.mm.media.a.a.h(aVar2), new com.tencent.mm.media.a.a.i(aVar2));
                    }
                    aVar2.eSJ = cVar2;
                }
                if (aVar4 != null) {
                    if (com.tencent.luggage.g.b.fP(23)) {
                        cVar2 = new com.tencent.mm.media.c.c(aVar4, "music", 0, j2 - j, new com.tencent.mm.media.a.a.j(aVar2), new com.tencent.mm.media.a.a.k(aVar2));
                    } else {
                        aVar2.eSY = true;
                        cVar2 = new com.tencent.mm.media.c.d(aVar4, "music", 0, j2 - j, new com.tencent.mm.media.a.a.l(aVar2), new com.tencent.mm.media.a.a.d(aVar2));
                    }
                    aVar2.eSI = cVar2;
                }
            }
            aVar = eVar.eXS;
            if (aVar != null) {
                mediaFormat = aVar.eWf;
            } else {
                mediaFormat = null;
            }
            if (mediaFormat == null) {
                a.f.b.j.dWJ();
            }
            if (!mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) {
                mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, eVar.eYn);
            }
            com.tencent.mm.media.a.a aVar5 = eVar.eXP;
            if (aVar5 != null) {
                a.f.b.j.p(mediaFormat, "mediaFormat");
                try {
                    com.tencent.mm.media.d.a cVar3;
                    if (com.tencent.luggage.g.b.fP(23)) {
                        cVar3 = new com.tencent.mm.media.d.c(mediaFormat, new com.tencent.mm.media.a.a.m(aVar5), new n(aVar5));
                    } else {
                        aVar5.eSY = true;
                        cVar3 = new com.tencent.mm.media.d.d(mediaFormat, new o(aVar5), new p(aVar5));
                    }
                    aVar5.eSK = cVar3;
                } catch (Exception e3) {
                    ab.printErrStackTrace(aVar5.TAG, e3, "", new Object[0]);
                    cVar = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.VP();
                }
            }
            com.tencent.mm.media.a.a aVar6 = eVar.eXP;
            if (aVar6 != null) {
                a.f.a.a lVar = new l(eVar, yz);
                com.tencent.mm.media.f.a aVar7 = aVar6.eSL;
                if (aVar7 != null) {
                    ab.i(aVar7.TAG, "startMix");
                    com.tencent.mm.ab.b.a((a.f.a.a) new com.tencent.mm.media.f.a.c(aVar7), "AudioMixCodec_MixAudio");
                    aVar7.eWr = true;
                }
                if (aVar6.eTb == 3) {
                    com.tencent.mm.ab.b.a((a.f.a.a) new s(aVar6), "BackgroundDecoder");
                }
                com.tencent.mm.ab.b.a((a.f.a.a) new t(aVar6), "MusicDecoder");
                ab.i(aVar6.TAG, "startCodec");
                aVar6.eSR = lVar;
                aVar6.eSZ = bo.yz();
                AppMethodBeat.o(13067);
                return;
            }
            AppMethodBeat.o(13067);
            return;
        }
        if (i == 0) {
            eVar.cq(false);
        }
        AppMethodBeat.o(13067);
    }

    public static final /* synthetic */ void A(e eVar) {
        AppMethodBeat.i(13068);
        al.n(new b(eVar), eYr);
        AppMethodBeat.o(13068);
    }
}
