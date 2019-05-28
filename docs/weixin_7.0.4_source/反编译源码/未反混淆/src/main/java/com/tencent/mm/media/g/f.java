package com.tencent.mm.media.g;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u00106\u001a\u00020\u0016H\u0002R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000RJ\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!RX\u0010\"\u001a<\u00122\u00120\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0016\u0018\u00010#¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00160#8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R-\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0016\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000RJ\u0010.\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001a\u00101\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "getVideoEncodeCallback", "setVideoEncodeCallback", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"})
public final class f {
    final String TAG = "MicroMsg.RemuxerCallback";
    int eTb;
    int eXL;
    h eXR;
    com.tencent.mm.media.e.a eYA;
    int eYB;
    int eYC;
    a.f.a.b<? super String, y> eYD;
    m<? super ByteBuffer, ? super BufferInfo, y> eYE = new d(this);
    m<? super ByteBuffer, ? super BufferInfo, y> eYF = new a(this);
    a.f.a.b<? super a.f.a.b<? super String, y>, y> eYG = new c(this);
    a.f.a.a<y> eYH = new b(this);
    String eYj = "";
    String eys = "";
    int frameCount;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ f eYI;

        b(f fVar) {
            this.eYI = fVar;
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            f fVar = this.eYI;
            fVar.frameCount++;
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    static final class a extends k implements m<ByteBuffer, BufferInfo, y> {
        final /* synthetic */ f eYI;

        a(f fVar) {
            this.eYI = fVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(13070);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            j.p(byteBuffer, "data");
            j.p(bufferInfo, "bufferInfo");
            h hVar = this.eYI.eXR;
            if (hVar != null) {
                hVar.c(byteBuffer, bufferInfo.size);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13070);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012%\u0010\u0002\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "it", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path", "invoke"})
    static final class c extends k implements a.f.a.b<a.f.a.b<? super String, ? extends y>, y> {
        final /* synthetic */ f eYI;

        c(f fVar) {
            this.eYI = fVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            int a;
            int i = -1;
            int i2 = 0;
            AppMethodBeat.i(13071);
            a.f.a.b bVar = (a.f.a.b) obj;
            ab.i(this.eYI.TAG, "onEncodeEnd");
            this.eYI.eYD = bVar;
            f fVar = this.eYI;
            com.tencent.mm.media.e.a aVar = fVar.eYA;
            if (aVar != null) {
                boolean z = fVar.eTb == 0;
                if (bo.isNullOrNil(fVar.eYj)) {
                    i = 0;
                } else {
                    int i3;
                    if (fVar.eTb == 1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    h hVar;
                    String str;
                    int i4;
                    if (fVar.eXL > 0) {
                        hVar = fVar.eXR;
                        if (hVar != null) {
                            str = fVar.eYj;
                            i4 = i3 != 0 ? 0 : fVar.eYB;
                            if (i3 == 0) {
                                i2 = fVar.eYC;
                            }
                            a = hVar.a(aVar, str, i4, i2, z);
                        } else {
                            a = -1;
                        }
                        SightVideoJNI.tagRotateVideo(fVar.eYj, fVar.eys, fVar.eXL);
                        e.aQ(fVar.eys, fVar.eYj);
                    } else {
                        hVar = fVar.eXR;
                        if (hVar != null) {
                            str = fVar.eYj;
                            if (i3 != 0) {
                                i4 = 0;
                            } else {
                                i4 = fVar.eYB;
                            }
                            if (i3 == 0) {
                                i2 = fVar.eYC;
                            }
                            i = hVar.a(aVar, str, i4, i2, z);
                        }
                    }
                }
                a = i;
            } else {
                a = 0;
            }
            ab.i(fVar.TAG, "output mediaInfo :".concat(String.valueOf(com.tencent.mm.plugin.sight.base.d.WR(fVar.eYj))));
            ab.i(fVar.TAG, "finish process, ret:".concat(String.valueOf(a)));
            a.f.a.b bVar2;
            if (a >= 0) {
                bVar2 = fVar.eYD;
                if (bVar2 != null) {
                    bVar2.am(fVar.eYj);
                }
            } else {
                bVar2 = fVar.eYD;
                if (bVar2 != null) {
                    bVar2.am(null);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13071);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    static final class d extends k implements m<ByteBuffer, BufferInfo, y> {
        final /* synthetic */ f eYI;

        d(f fVar) {
            this.eYI = fVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(13072);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            j.p(byteBuffer, "data");
            j.p(bufferInfo, "bufferInfo");
            h hVar = this.eYI.eXR;
            if (hVar != null) {
                int i = bufferInfo.size;
                j.p(byteBuffer, "encodeData");
                if (hVar.eWi) {
                    ab.e(hVar.TAG, "writeVideoData, already release");
                } else {
                    ab.i(hVar.TAG, "writeH264Data: " + byteBuffer.capacity() + ", " + i + ", bufId:" + hVar.eTa);
                    SightVideoJNI.writeH264DataLock(hVar.eTa, byteBuffer, i);
                    hVar.frameCount++;
                    ab.i(hVar.TAG, "frameCount: " + hVar.frameCount);
                }
            }
            ab.i("MicroMsg.TimeCost", "onFrameDraw : " + this.eYI.frameCount);
            y yVar = y.AUy;
            AppMethodBeat.o(13072);
            return yVar;
        }
    }

    public f(h hVar, com.tencent.mm.media.e.a aVar, String str, int i, int i2) {
        j.p(hVar, "mixMuxerController");
        j.p(aVar, "mediaExtractorWrapper");
        j.p(str, "outputFilePath");
        AppMethodBeat.i(13073);
        this.eys = str + "_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
        this.eXR = hVar;
        this.eYA = aVar;
        this.eYj = str;
        this.eYB = i2;
        this.eYC = 1;
        this.eTb = i;
        AppMethodBeat.o(13073);
    }
}
