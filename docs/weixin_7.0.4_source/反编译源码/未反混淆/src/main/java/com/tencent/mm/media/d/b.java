package com.tencent.mm.media.d;

import a.f.a.a;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u0010\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020\u0006H&J\u0006\u0010;\u001a\u00020\u0012J\u0006\u0010<\u001a\u00020\fJ\b\u0010=\u001a\u000209H&J@\u0010>\u001a\u00020\u000628\u0010?\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cJ\u0016\u0010'\u001a\u00020\u00062\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010(J\u0018\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0004J\b\u0010B\u001a\u00020\u0006H&J\u000e\u0010C\u001a\u00020\u00062\u0006\u0010C\u001a\u00020.R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R-\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRL\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006D"}, dWq = {"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "", "getUseInRemuxer", "()Z", "setUseInRemuxer", "(Z)V", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "release", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b {
    private final String TAG = "MicroMsg.IMediaCodecTransEncoder";
    public boolean eTO;
    private c eVA;
    private a.f.a.b<? super b, y> eVB;
    protected Surface eVx;
    public m<? super ByteBuffer, ? super BufferInfo, y> eVy;
    public a<y> eVz;
    public int frameNum;

    public abstract void UO();

    public abstract void UP();

    public abstract long UQ();

    public abstract void release();

    public b(c cVar, a.f.a.b<? super b, y> bVar) {
        j.p(cVar, "videoCodecConfig");
        this.eVA = cVar;
        this.eVB = bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(Surface surface) {
        j.p(surface, "<set-?>");
        this.eVx = surface;
    }

    public final Surface getInputSurface() {
        Surface surface = this.eVx;
        if (surface == null) {
            j.avw("codecSurface");
        }
        return surface;
    }

    /* Access modifiers changed, original: protected|final */
    public final void f(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        j.p(byteBuffer, "buffer");
        j.p(bufferInfo, "bufferInfo");
        ab.i(this.TAG, "processEncodeBuffer, buffer " + byteBuffer + ", pts: " + bufferInfo.presentationTimeUs + ", size: " + bufferInfo.size + ", isMain: " + j.j(Looper.getMainLooper(), Looper.myLooper()));
        m mVar = this.eVy;
        if (mVar != null) {
            mVar.m(byteBuffer, bufferInfo);
        }
        this.frameNum++;
    }
}
