package com.tencent.mm.plugin.story.model.e;

import a.f.a.m;
import a.f.a.q;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.g.g;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014H\u0002J\u0018\u0010;\u001a\u00020<2\u0006\u00107\u001a\u00020\r2\u0006\u00105\u001a\u00020\rH\u0002J\u0016\u0010=\u001a\u00020.2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020.0?H\u0002J\u000e\u0010@\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003J\n\u0010A\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010B\u001a\u00020.H\u0002J\b\u0010C\u001a\u00020.H\u0002JU\u0010D\u001a\u00020.2M\u0010&\u001aI\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010'R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#RU\u0010&\u001aI\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer;", "", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "drawingRect", "", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "(Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;Ljava/util/List;[FLjava/lang/String;Ljava/lang/String;I)V", "audioBitrate", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "getCaptureInfo", "()Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getDrawingRect", "()[F", "getEditorItems", "()Ljava/util/List;", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/media/mix/FrameInfo;", "getMixThumbPath", "()Ljava/lang/String;", "setMixThumbPath", "(Ljava/lang/String;)V", "getMixVideoPath", "setMixVideoPath", "onFinish", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "", "getRetryTime", "()I", "setRetryTime", "(I)V", "videoBitrate", "videoFrameRate", "videoHeight", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "calcMixEmojiSize", "Landroid/graphics/Point;", "checkAudioCache", "callback", "Lkotlin/Function0;", "createGraffitiThumb", "createThumb", "makeSureConfig", "mix", "start", "Companion", "plugin-story_release"})
public final class b {
    public static final a rWB = new a();
    private int audioSampleRate;
    private int eRs;
    public final List<com.tencent.mm.media.editor.a.b> eWG;
    public int eXL;
    public final a.f.a.b<Long, Bitmap> eXh;
    private int fzS;
    String rWA;
    private q<? super String, ? super String, ? super Boolean, y> rWt;
    private long rWu;
    private com.tencent.mm.media.f.c rWv;
    public a rWw;
    final com.tencent.mm.plugin.story.e.a rWx;
    public final float[] rWy;
    String rWz;
    private int videoBitrate;
    private int videoFrameRate;
    private int videoHeight;
    private int videoWidth;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
    static final class b extends k implements a.f.a.b<Long, Bitmap> {
        final /* synthetic */ b rWC;

        b(b bVar) {
            this.rWC = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(109331);
            long longValue = ((Number) obj).longValue();
            ab.i("MicroMsg.Media.StoryVideoMixer", "get bitmap ".concat(String.valueOf(longValue)));
            while (longValue / 1000 > this.rWC.rWu) {
                Object valueOf;
                com.tencent.mm.media.f.c UX = b.c(this.rWC).UX();
                String str = "MicroMsg.Media.StoryVideoMixer";
                StringBuilder stringBuilder = new StringBuilder("get frame ");
                if (UX != null) {
                    valueOf = Long.valueOf(UX.eWH);
                } else {
                    valueOf = null;
                }
                ab.i(str, stringBuilder.append(valueOf).append(" blendBitmapProvider: ").append(longValue).toString());
                if (UX == null || UX.eWH <= 0) {
                    break;
                }
                b bVar = this.rWC;
                bVar.rWu = bVar.rWu + UX.eWH;
                this.rWC.rWv = UX;
            }
            com.tencent.mm.media.f.c f = this.rWC.rWv;
            if (f != null) {
                Bitmap bitmap = f.bitmap;
                AppMethodBeat.o(109331);
                return bitmap;
            }
            AppMethodBeat.o(109331);
            return null;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ b rWC;
        final /* synthetic */ q rWD;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.e.b$e$1 */
        static final class AnonymousClass1 extends k implements a.f.a.a<y> {
            final /* synthetic */ e rWE;

            AnonymousClass1(e eVar) {
                this.rWE = eVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109334);
                try {
                    b.a(this.rWE.rWC);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Media.StoryVideoMixer", e, "error on startVideoMixer", new Object[0]);
                    q qVar = this.rWE.rWD;
                    if (qVar != null) {
                        qVar.g(this.rWE.rWC.rWz, this.rWE.rWC.rWA, Boolean.FALSE);
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(109334);
                return yVar;
            }
        }

        e(b bVar, q qVar) {
            this.rWC = bVar;
            this.rWD = qVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109335);
            com.tencent.mm.ab.b.a("StoryVideoMixer", (a.f.a.a) new AnonymousClass1(this));
            y yVar = y.AUy;
            AppMethodBeat.o(109335);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
    static final class c extends k implements m<Boolean, String, y> {
        final /* synthetic */ a.f.a.a lix;

        c(a.f.a.a aVar) {
            this.lix = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(109332);
            if (((Boolean) obj).booleanValue()) {
                this.lix.invoke();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109332);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class d extends k implements a.f.a.b<String, y> {
        final /* synthetic */ b rWC;

        d(b bVar) {
            this.rWC = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(109333);
            String str = (String) obj;
            CharSequence charSequence = str;
            Object obj2 = (charSequence == null || charSequence.length() == 0) ? 1 : null;
            q b;
            if (obj2 != null) {
                ab.e("MicroMsg.Media.StoryVideoMixer", "remux failed, ret path is null");
                b = this.rWC.rWt;
                if (b != null) {
                    b.g("", "", Boolean.FALSE);
                }
            } else {
                b bVar = this.rWC;
                j.p(str, "<set-?>");
                bVar.rWz = str;
                b.c(this.rWC).destroy();
                try {
                    com.tencent.mm.plugin.story.e.c.a aVar = com.tencent.mm.plugin.story.e.c.rRS;
                    com.tencent.mm.plugin.story.e.c.a.a aaj = com.tencent.mm.plugin.story.e.c.a.aaj(this.rWC.rWz);
                    if (aaj != null) {
                        g gVar = g.sbU;
                        g.h(this.rWC.rWx.fbV, aaj.videoBitrate, aaj.fps);
                    }
                } catch (Exception e) {
                }
                String d = b.d(this.rWC);
                if (bo.isNullOrNil(d)) {
                    ab.i("MicroMsg.Media.StoryVideoMixer", "mix create thumb failed");
                    b = this.rWC.rWt;
                    if (b != null) {
                        b.g(this.rWC.rWz, "", Boolean.FALSE);
                    }
                } else {
                    ab.i("MicroMsg.Media.StoryVideoMixer", "mix create thumb succ");
                    q b2 = this.rWC.rWt;
                    if (b2 != null) {
                        String str2 = this.rWC.rWz;
                        if (d == null) {
                            j.dWJ();
                        }
                        b2.g(str2, d, Boolean.TRUE);
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109333);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(109339);
        AppMethodBeat.o(109339);
    }

    private b(com.tencent.mm.plugin.story.e.a aVar, List<com.tencent.mm.media.editor.a.b> list, float[] fArr, String str, String str2) {
        com.tencent.mm.plugin.story.model.l lVar;
        j.p(aVar, "captureInfo");
        j.p(list, "editorItems");
        j.p(fArr, "drawingRect");
        j.p(str, "mixVideoPath");
        j.p(str2, "mixThumbPath");
        AppMethodBeat.i(109338);
        this.rWx = aVar;
        this.eWG = list;
        this.rWy = fArr;
        this.rWz = str;
        this.rWA = str2;
        this.eRs = 1;
        this.rWu = -1;
        if (!com.tencent.mm.vfs.e.ct(this.rWz)) {
            lVar = com.tencent.mm.plugin.story.model.l.rTg;
            com.tencent.mm.plugin.story.model.l.aay(this.rWz);
        }
        if (!com.tencent.mm.vfs.e.ct(this.rWA)) {
            lVar = com.tencent.mm.plugin.story.model.l.rTg;
            com.tencent.mm.plugin.story.model.l.aay(this.rWA);
        }
        ab.i("MicroMsg.Media.StoryVideoMixer", "create StoryVideoMixer, videoPath:" + this.rWx.fbT + ", outputFilePath:" + this.rWz + ", isCaptureVideo:" + this.rWx.fbV + ", retryTime:" + this.eRs);
        if (!com.tencent.mm.vfs.e.ct(this.rWx.fbT)) {
            f fVar = f.sbT;
            f.lJ(this.rWx.fbV);
        }
        this.eXh = new b(this);
        AppMethodBeat.o(109338);
    }

    public static final /* synthetic */ a c(b bVar) {
        AppMethodBeat.i(109341);
        a aVar = bVar.rWw;
        if (aVar == null) {
            j.avw("frameRetriever");
        }
        AppMethodBeat.o(109341);
        return aVar;
    }

    public /* synthetic */ b(com.tencent.mm.plugin.story.e.a aVar, List list, float[] fArr, String str, String str2, byte b) {
        this(aVar, list, fArr, str, str2);
    }

    public final void a(q<? super String, ? super String, ? super Boolean, y> qVar) {
        AppMethodBeat.i(109336);
        ab.i("MicroMsg.Media.StoryVideoMixer", "Start mixer " + bo.dpG());
        this.rWt = qVar;
        a.f.a.a eVar = new e(this, qVar);
        if (this.rWx.rRJ != null) {
            AudioCacheInfo audioCacheInfo = this.rWx.rRJ;
            if (audioCacheInfo == null) {
                j.dWJ();
            }
            if (!audioCacheInfo.aIM) {
                com.tencent.mm.plugin.story.model.audio.g.a aVar = com.tencent.mm.plugin.story.model.audio.g.rUG;
                com.tencent.mm.plugin.story.model.audio.g cyW = com.tencent.mm.plugin.story.model.audio.g.rUF;
                AudioCacheInfo audioCacheInfo2 = this.rWx.rRJ;
                if (audioCacheInfo2 == null) {
                    j.dWJ();
                }
                cyW.a(audioCacheInfo2, new c(eVar));
                AppMethodBeat.o(109336);
                return;
            }
        }
        eVar.invoke();
        AppMethodBeat.o(109336);
    }

    public static Point fL(int i, int i2) {
        AppMethodBeat.i(109337);
        Point point = new Point(i * 1, i2 * 1);
        AppMethodBeat.o(109337);
        return point;
    }

    public static final /* synthetic */ String d(b bVar) {
        boolean z = true;
        AppMethodBeat.i(109342);
        Bitmap tv = com.tencent.mm.plugin.mmsight.d.tv(bVar.rWz);
        if (tv != null) {
            com.tencent.mm.sdk.platformtools.d.a(tv, 70, CompressFormat.JPEG, bVar.rWA, true);
        } else {
            g gVar = g.sbU;
            g.cAj();
        }
        String str = "MicroMsg.Media.StoryVideoMixer";
        StringBuilder append = new StringBuilder(" mixVideoPath : ").append(bVar.rWz).append(" mixThumbPath:").append(bVar.rWA).append("   thumb-bitmap is null:");
        if (tv != null) {
            z = false;
        }
        ab.i(str, append.append(z).toString());
        if (tv == null) {
            AppMethodBeat.o(109342);
            return null;
        }
        String str2 = bVar.rWA;
        AppMethodBeat.o(109342);
        return str2;
    }
}
