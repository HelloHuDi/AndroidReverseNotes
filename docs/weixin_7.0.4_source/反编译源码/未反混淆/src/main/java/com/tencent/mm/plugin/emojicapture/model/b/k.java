package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.b.d.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import javax.microedition.khronos.opengles.GL10;

@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J-\u0010)\u001a\u00020\u001f2%\b\u0002\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "hasSticker", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZZZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
public final class k {
    public static final a lje = new a();
    long eyR;
    private final long ezZ;
    int frameCount;
    final String hzs;
    final boolean liB;
    final boolean liC;
    private l liW;
    com.tencent.mm.plugin.emojicapture.ui.b.d liX;
    com.tencent.mm.media.f.e liY;
    c liZ;
    final int liz;
    a.f.a.b<? super Boolean, y> lja;
    private long ljb;
    final a ljc;
    final boolean ljd;
    final String videoPath;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ boolean eyb;
        final /* synthetic */ k ljf;

        b(k kVar, boolean z) {
            this.ljf = kVar;
            this.eyb = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2697);
            this.ljf.ljb = bo.gb(this.ljf.eyR);
            ab.i("MicroMsg.EmojiMixer", "mix used " + this.ljf.ljb + "ms, frame:" + this.ljf.frameCount);
            if (this.eyb) {
                com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                com.tencent.mm.plugin.emojicapture.model.d.p(this.ljf.ljb, this.ljf.ljd);
            }
            a.f.a.b j = this.ljf.lja;
            if (j != null) {
                j.am(Boolean.valueOf(this.eyb));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2697);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "skipFrame", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ k ljf;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$c$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.b<byte[], y> {
            final /* synthetic */ c ljg;

            AnonymousClass1(c cVar) {
                this.ljg = cVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(2698);
                byte[] bArr = (byte[]) obj;
                j.p(bArr, "it");
                k.e(this.ljg.ljf).bnH();
                c g = this.ljg.ljf.liZ;
                if (g != null) {
                    c.a(g, bArr);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(2698);
                return yVar;
            }
        }

        c(k kVar) {
            this.ljf = kVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2699);
            if (((Boolean) obj).booleanValue()) {
                k.e(this.ljf).bnH();
            } else {
                a.f.a.b anonymousClass1 = new AnonymousClass1(this);
                com.tencent.mm.plugin.emojicapture.ui.b.e eVar = k.c(this.ljf).loU;
                if (eVar == null) {
                    j.avw("renderer");
                }
                byte[] bArr = new byte[((eVar.eZr * eVar.eZs) * 4)];
                eVar.lpt.position(0);
                eVar.lpt.get(bArr);
                anonymousClass1.am(bArr);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2699);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ k ljf;
        final /* synthetic */ com.tencent.mm.plugin.sight.base.a ljh;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$e$2 */
        static final class AnonymousClass2 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ e ljj;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$e$2$1 */
            static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
                final /* synthetic */ AnonymousClass2 ljk;

                AnonymousClass1(AnonymousClass2 anonymousClass2) {
                    this.ljk = anonymousClass2;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(2703);
                    k.a(this.ljk.ljj.ljf, this.ljk.ljj.ljf.frameCount > 0);
                    com.tencent.mm.plugin.emojicapture.ui.b.d c = k.c(this.ljk.ljj.ljf);
                    c.b((a.f.a.a) new com.tencent.mm.plugin.emojicapture.ui.b.d.a(c));
                    y yVar = y.AUy;
                    AppMethodBeat.o(2703);
                    return yVar;
                }
            }

            AnonymousClass2(e eVar) {
                this.ljj = eVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(2704);
                k.c(this.ljj.ljf).b((a.f.a.a) new AnonymousClass1(this));
                y yVar = y.AUy;
                AppMethodBeat.o(2704);
                return yVar;
            }
        }

        e(k kVar, com.tencent.mm.plugin.sight.base.a aVar) {
            this.ljf = kVar;
            this.ljh = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            l jVar;
            AppMethodBeat.i(2705);
            com.tencent.mm.plugin.emojicapture.ui.b.d c = k.c(this.ljf);
            c.b((a.f.a.a) new f(c, this.ljf.ljd));
            k kVar = this.ljf;
            if (com.tencent.mm.compatible.util.d.iW(23)) {
                ab.i("MicroMsg.EmojiMixer", "api level 23 user async decoder");
                String f = this.ljf.videoPath;
                com.tencent.mm.plugin.sight.base.a aVar = this.ljh;
                jVar = new j(f, aVar != null ? aVar.eWK : 0, k.c(this.ljf).bog());
            } else {
                ab.i("MicroMsg.EmojiMixer", "api level below 23 user sync decoder");
                jVar = new i(this.ljf.videoPath, k.c(this.ljf).bog());
            }
            kVar.liW = jVar;
            k.e(this.ljf).ljl = AnonymousClass1.lji;
            k.e(this.ljf).ljm = new AnonymousClass2(this);
            if (k.e(this.ljf).init() < 0) {
                com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                com.tencent.mm.plugin.emojicapture.model.d.bnb();
            }
            k.e(this.ljf).UB();
            y yVar = y.AUy;
            AppMethodBeat.o(2705);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ k ljf;

        d(k kVar) {
            this.ljf = kVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2700);
            k kVar = this.ljf;
            kVar.frameCount = kVar.frameCount + 1;
            k.b(this.ljf);
            y yVar = y.AUy;
            AppMethodBeat.o(2700);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(2707);
        AppMethodBeat.o(2707);
    }

    public k(String str, a aVar, String str2, int i, boolean z, boolean z2, boolean z3, long j) {
        j.p(str, "videoPath");
        j.p(aVar, "emojiFrameRetriever");
        j.p(str2, "gifPath");
        AppMethodBeat.i(2706);
        this.videoPath = str;
        this.ljc = aVar;
        this.hzs = str2;
        this.liz = i;
        this.ljd = z;
        this.liB = z2;
        this.liC = z3;
        this.ezZ = j;
        AppMethodBeat.o(2706);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.emojicapture.ui.b.d c(k kVar) {
        AppMethodBeat.i(2709);
        com.tencent.mm.plugin.emojicapture.ui.b.d dVar = kVar.liX;
        if (dVar == null) {
            j.avw("mixPixelBuffer");
        }
        AppMethodBeat.o(2709);
        return dVar;
    }

    public static final /* synthetic */ l e(k kVar) {
        AppMethodBeat.i(2710);
        l lVar = kVar.liW;
        if (lVar == null) {
            j.avw("videoDecoder");
        }
        AppMethodBeat.o(2710);
        return lVar;
    }

    public static final /* synthetic */ void b(k kVar) {
        boolean z;
        AppMethodBeat.i(2708);
        com.tencent.mm.plugin.emojicapture.ui.b.d dVar = kVar.liX;
        if (dVar == null) {
            j.avw("mixPixelBuffer");
        }
        com.tencent.mm.media.f.e eVar = kVar.liY;
        if (eVar == null) {
            j.avw("syncMgr");
        }
        int i = kVar.frameCount;
        ab.i(eVar.TAG, "after syncMixNextFrame, framePass " + i + ", videoPassFrame:" + eVar.eWL + ", targetPassFrame:" + eVar.eWQ + ", emojiPassDuration: " + eVar.eWO);
        i--;
        if (i > 0 && eVar.eWL < i) {
            eVar.eWL = i;
        }
        eVar.eWV = eVar.eWU * ((float) eVar.eWQ);
        eVar.eWT = eVar.eWS * ((float) eVar.eWL);
        while (eVar.eWV >= eVar.eWO) {
            com.tencent.mm.media.f.c UX = eVar.eWW.UX();
            if (UX == null || UX.eWH <= 0) {
                break;
            }
            eVar.eWO += (float) UX.eWH;
            eVar.eWN = UX.bitmap;
        }
        Bitmap bitmap = eVar.eWN;
        if (eVar.eWS * ((float) eVar.eWL) < eVar.eWU * ((float) eVar.eWQ)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ab.i(eVar.TAG, "syncMixNextFrame, skip frame");
        } else {
            eVar.eWQ++;
            ab.i(eVar.TAG, "syncMixNextFrame pass frame: " + eVar.eWQ);
        }
        eVar.eWL++;
        com.tencent.mm.media.f.e.a aVar = new com.tencent.mm.media.f.e.a(bitmap, z);
        a.f.a.b cVar = new c(kVar);
        ab.i(dVar.TAG, "mixVideoAndEmojiFrame, skip: " + Boolean.valueOf(aVar.cAi));
        if (j.j(Boolean.valueOf(aVar.cAi), Boolean.FALSE)) {
            com.tencent.mm.plugin.emojicapture.ui.b.e eVar2 = dVar.loU;
            if (eVar2 == null) {
                j.avw("renderer");
            }
            eVar2.eZt = aVar.eWX;
            com.tencent.mm.plugin.emojicapture.ui.b.e eVar3 = dVar.loU;
            if (eVar3 == null) {
                j.avw("renderer");
            }
            GL10 gl10 = dVar.loT;
            if (gl10 == null) {
                j.avw("gl");
            }
            eVar3.onDrawFrame(gl10);
            cVar.am(Boolean.FALSE);
            AppMethodBeat.o(2708);
            return;
        }
        com.tencent.mm.plugin.emojicapture.ui.b.e eVar4 = dVar.loU;
        if (eVar4 == null) {
            j.avw("renderer");
        }
        eVar4.boh().updateTexImage();
        cVar.am(Boolean.TRUE);
        AppMethodBeat.o(2708);
    }
}
