package com.tencent.p177mm.media.p866d;

import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.p177mm.media.p251b.C24670c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u0010\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020\u0006H&J\u0006\u0010;\u001a\u00020\u0012J\u0006\u0010<\u001a\u00020\fJ\b\u0010=\u001a\u000209H&J@\u0010>\u001a\u00020\u000628\u0010?\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cJ\u0016\u0010'\u001a\u00020\u00062\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010(J\u0018\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0004J\b\u0010B\u001a\u00020\u0006H&J\u000e\u0010C\u001a\u00020\u00062\u0006\u0010C\u001a\u00020.R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R-\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRL\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006D"}, dWq = {"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "", "getUseInRemuxer", "()Z", "setUseInRemuxer", "(Z)V", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "release", "useInRemux", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.d.b */
public abstract class C45426b {
    private final String TAG = "MicroMsg.IMediaCodecTransEncoder";
    public boolean eTO;
    private C24670c eVA;
    private C17126b<? super C45426b, C37091y> eVB;
    protected Surface eVx;
    public C31591m<? super ByteBuffer, ? super BufferInfo, C37091y> eVy;
    public C31214a<C37091y> eVz;
    public int frameNum;

    /* renamed from: UO */
    public abstract void mo20899UO();

    /* renamed from: UP */
    public abstract void mo20900UP();

    /* renamed from: UQ */
    public abstract long mo20901UQ();

    public abstract void release();

    public C45426b(C24670c c24670c, C17126b<? super C45426b, C37091y> c17126b) {
        C25052j.m39376p(c24670c, "videoCodecConfig");
        this.eVA = c24670c;
        this.eVB = c17126b;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final void mo73220e(Surface surface) {
        C25052j.m39376p(surface, "<set-?>");
        this.eVx = surface;
    }

    public final Surface getInputSurface() {
        Surface surface = this.eVx;
        if (surface == null) {
            C25052j.avw("codecSurface");
        }
        return surface;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: f */
    public final void mo73221f(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        C25052j.m39376p(byteBuffer, "buffer");
        C25052j.m39376p(bufferInfo, "bufferInfo");
        C4990ab.m7416i(this.TAG, "processEncodeBuffer, buffer " + byteBuffer + ", pts: " + bufferInfo.presentationTimeUs + ", size: " + bufferInfo.size + ", isMain: " + C25052j.m39373j(Looper.getMainLooper(), Looper.myLooper()));
        C31591m c31591m = this.eVy;
        if (c31591m != null) {
            c31591m.mo212m(byteBuffer, bufferInfo);
        }
        this.frameNum++;
    }
}
