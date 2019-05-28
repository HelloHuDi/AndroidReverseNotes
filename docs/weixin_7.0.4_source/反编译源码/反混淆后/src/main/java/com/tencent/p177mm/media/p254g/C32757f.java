package com.tencent.p177mm.media.p254g;

import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u00106\u001a\u00020\u0016H\u0002R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000RJ\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!RX\u0010\"\u001a<\u00122\u00120\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0016\u0018\u00010#¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00160#8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R-\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0016\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000RJ\u0010.\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001a\u00101\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "getVideoEncodeCallback", "setVideoEncodeCallback", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.g.f */
public final class C32757f {
    final String TAG = "MicroMsg.RemuxerCallback";
    int eTb;
    int eXL;
    C1783h eXR;
    C32742a eYA;
    int eYB;
    int eYC;
    C17126b<? super String, C37091y> eYD;
    C31591m<? super ByteBuffer, ? super BufferInfo, C37091y> eYE = new C32758d(this);
    C31591m<? super ByteBuffer, ? super BufferInfo, C37091y> eYF = new C9604a(this);
    C17126b<? super C17126b<? super String, C37091y>, C37091y> eYG = new C32756c(this);
    C31214a<C37091y> eYH = new C1782b(this);
    String eYj = "";
    String eys = "";
    int frameCount;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.f$b */
    static final class C1782b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C32757f eYI;

        C1782b(C32757f c32757f) {
            this.eYI = c32757f;
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            C32757f c32757f = this.eYI;
            c32757f.frameCount++;
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.f$a */
    static final class C9604a extends C25053k implements C31591m<ByteBuffer, BufferInfo, C37091y> {
        final /* synthetic */ C32757f eYI;

        C9604a(C32757f c32757f) {
            this.eYI = c32757f;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(13070);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            C25052j.m39376p(byteBuffer, "data");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C1783h c1783h = this.eYI.eXR;
            if (c1783h != null) {
                c1783h.mo5331c(byteBuffer, bufferInfo.size);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13070);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012%\u0010\u0002\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "it", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path", "invoke"})
    /* renamed from: com.tencent.mm.media.g.f$c */
    static final class C32756c extends C25053k implements C17126b<C17126b<? super String, ? extends C37091y>, C37091y> {
        final /* synthetic */ C32757f eYI;

        C32756c(C32757f c32757f) {
            this.eYI = c32757f;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            int a;
            int i = -1;
            int i2 = 0;
            AppMethodBeat.m2504i(13071);
            C17126b c17126b = (C17126b) obj;
            C4990ab.m7416i(this.eYI.TAG, "onEncodeEnd");
            this.eYI.eYD = c17126b;
            C32757f c32757f = this.eYI;
            C32742a c32742a = c32757f.eYA;
            if (c32742a != null) {
                boolean z = c32757f.eTb == 0;
                if (C5046bo.isNullOrNil(c32757f.eYj)) {
                    i = 0;
                } else {
                    int i3;
                    if (c32757f.eTb == 1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    C1783h c1783h;
                    String str;
                    int i4;
                    if (c32757f.eXL > 0) {
                        c1783h = c32757f.eXR;
                        if (c1783h != null) {
                            str = c32757f.eYj;
                            i4 = i3 != 0 ? 0 : c32757f.eYB;
                            if (i3 == 0) {
                                i2 = c32757f.eYC;
                            }
                            a = c1783h.mo5329a(c32742a, str, i4, i2, z);
                        } else {
                            a = -1;
                        }
                        SightVideoJNI.tagRotateVideo(c32757f.eYj, c32757f.eys, c32757f.eXL);
                        C5730e.m8623aQ(c32757f.eys, c32757f.eYj);
                    } else {
                        c1783h = c32757f.eXR;
                        if (c1783h != null) {
                            str = c32757f.eYj;
                            if (i3 != 0) {
                                i4 = 0;
                            } else {
                                i4 = c32757f.eYB;
                            }
                            if (i3 == 0) {
                                i2 = c32757f.eYC;
                            }
                            i = c1783h.mo5329a(c32742a, str, i4, i2, z);
                        }
                    }
                }
                a = i;
            } else {
                a = 0;
            }
            C4990ab.m7416i(c32757f.TAG, "output mediaInfo :".concat(String.valueOf(C21846d.m33388WR(c32757f.eYj))));
            C4990ab.m7416i(c32757f.TAG, "finish process, ret:".concat(String.valueOf(a)));
            C17126b c17126b2;
            if (a >= 0) {
                c17126b2 = c32757f.eYD;
                if (c17126b2 != null) {
                    c17126b2.mo50am(c32757f.eYj);
                }
            } else {
                c17126b2 = c32757f.eYD;
                if (c17126b2 != null) {
                    c17126b2.mo50am(null);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13071);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    /* renamed from: com.tencent.mm.media.g.f$d */
    static final class C32758d extends C25053k implements C31591m<ByteBuffer, BufferInfo, C37091y> {
        final /* synthetic */ C32757f eYI;

        C32758d(C32757f c32757f) {
            this.eYI = c32757f;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(13072);
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            BufferInfo bufferInfo = (BufferInfo) obj2;
            C25052j.m39376p(byteBuffer, "data");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C1783h c1783h = this.eYI.eXR;
            if (c1783h != null) {
                int i = bufferInfo.size;
                C25052j.m39376p(byteBuffer, "encodeData");
                if (c1783h.eWi) {
                    C4990ab.m7412e(c1783h.TAG, "writeVideoData, already release");
                } else {
                    C4990ab.m7416i(c1783h.TAG, "writeH264Data: " + byteBuffer.capacity() + ", " + i + ", bufId:" + c1783h.eTa);
                    SightVideoJNI.writeH264DataLock(c1783h.eTa, byteBuffer, i);
                    c1783h.frameCount++;
                    C4990ab.m7416i(c1783h.TAG, "frameCount: " + c1783h.frameCount);
                }
            }
            C4990ab.m7416i("MicroMsg.TimeCost", "onFrameDraw : " + this.eYI.frameCount);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13072);
            return c37091y;
        }
    }

    public C32757f(C1783h c1783h, C32742a c32742a, String str, int i, int i2) {
        C25052j.m39376p(c1783h, "mixMuxerController");
        C25052j.m39376p(c32742a, "mediaExtractorWrapper");
        C25052j.m39376p(str, "outputFilePath");
        AppMethodBeat.m2504i(13073);
        this.eys = str + "_" + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
        this.eXR = c1783h;
        this.eYA = c32742a;
        this.eYj = str;
        this.eYB = i2;
        this.eYC = 1;
        this.eTb = i;
        AppMethodBeat.m2505o(13073);
    }
}
