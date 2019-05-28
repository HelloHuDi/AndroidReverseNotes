package com.tencent.p177mm.plugin.emojicapture.model.p388b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.media.p253f.C1778c;
import com.tencent.p177mm.media.p253f.C32745e;
import com.tencent.p177mm.media.p253f.C32745e.C32746a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C11623d;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C11623d.C11625f;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C11623d.C11629a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C45872e;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import javax.microedition.khronos.opengles.GL10;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J-\u0010)\u001a\u00020\u001f2%\b\u0002\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "hasSticker", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZZZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k */
public final class C38916k {
    public static final C2959a lje = new C2959a();
    long eyR;
    private final long ezZ;
    int frameCount;
    final String hzs;
    final boolean liB;
    final boolean liC;
    private C45868l liW;
    C11623d liX;
    C32745e liY;
    C45867c liZ;
    final int liz;
    C17126b<? super Boolean, C37091y> lja;
    private long ljb;
    final C42972a ljc;
    final boolean ljd;
    final String videoPath;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$a */
    public static final class C2959a {
        private C2959a() {
        }

        public /* synthetic */ C2959a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$b */
    static final class C2960b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean eyb;
        final /* synthetic */ C38916k ljf;

        C2960b(C38916k c38916k, boolean z) {
            this.ljf = c38916k;
            this.eyb = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2697);
            this.ljf.ljb = C5046bo.m7566gb(this.ljf.eyR);
            C4990ab.m7416i("MicroMsg.EmojiMixer", "mix used " + this.ljf.ljb + "ms, frame:" + this.ljf.frameCount);
            if (this.eyb) {
                C34007d c34007d = C34007d.lhz;
                C34007d.m55708p(this.ljf.ljb, this.ljf.ljd);
            }
            C17126b j = this.ljf.lja;
            if (j != null) {
                j.mo50am(Boolean.valueOf(this.eyb));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2697);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "skipFrame", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$c */
    static final class C24750c extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C38916k ljf;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$c$1 */
        static final class C247491 extends C25053k implements C17126b<byte[], C37091y> {
            final /* synthetic */ C24750c ljg;

            C247491(C24750c c24750c) {
                this.ljg = c24750c;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(2698);
                byte[] bArr = (byte[]) obj;
                C25052j.m39376p(bArr, "it");
                C38916k.m66056e(this.ljg.ljf).bnH();
                C45867c g = this.ljg.ljf.liZ;
                if (g != null) {
                    C45867c.m84973a(g, bArr);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2698);
                return c37091y;
            }
        }

        C24750c(C38916k c38916k) {
            this.ljf = c38916k;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2699);
            if (((Boolean) obj).booleanValue()) {
                C38916k.m66056e(this.ljf).bnH();
            } else {
                C17126b c247491 = new C247491(this);
                C45872e c45872e = C38916k.m66054c(this.ljf).loU;
                if (c45872e == null) {
                    C25052j.avw("renderer");
                }
                byte[] bArr = new byte[((c45872e.eZr * c45872e.eZs) * 4)];
                c45872e.lpt.position(0);
                c45872e.lpt.get(bArr);
                c247491.mo50am(bArr);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2699);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$e */
    static final class C38915e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C38916k ljf;
        final /* synthetic */ C43528a ljh;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$e$2 */
        static final class C340042 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C38915e ljj;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$e$2$1 */
            static final class C340051 extends C25053k implements C31214a<C37091y> {
                final /* synthetic */ C340042 ljk;

                C340051(C340042 c340042) {
                    this.ljk = c340042;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(2703);
                    C38916k.m66052a(this.ljk.ljj.ljf, this.ljk.ljj.ljf.frameCount > 0);
                    C11623d c = C38916k.m66054c(this.ljk.ljj.ljf);
                    c.mo23373b((C31214a) new C11629a(c));
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(2703);
                    return c37091y;
                }
            }

            C340042(C38915e c38915e) {
                this.ljj = c38915e;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(2704);
                C38916k.m66054c(this.ljj.ljf).mo23373b((C31214a) new C340051(this));
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2704);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$e$1 */
        static final class C389141 extends C25053k implements C17126b<Long, C37091y> {
            public static final C389141 lji = new C389141();

            static {
                AppMethodBeat.m2504i(2702);
                AppMethodBeat.m2505o(2702);
            }

            C389141() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(2701);
                ((Number) obj).longValue();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2701);
                return c37091y;
            }
        }

        C38915e(C38916k c38916k, C43528a c43528a) {
            this.ljf = c38916k;
            this.ljh = c43528a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            C45868l c42973j;
            AppMethodBeat.m2504i(2705);
            C11623d c = C38916k.m66054c(this.ljf);
            c.mo23373b((C31214a) new C11625f(c, this.ljf.ljd));
            C38916k c38916k = this.ljf;
            if (C1443d.m3068iW(23)) {
                C4990ab.m7416i("MicroMsg.EmojiMixer", "api level 23 user async decoder");
                String f = this.ljf.videoPath;
                C43528a c43528a = this.ljh;
                c42973j = new C42973j(f, c43528a != null ? c43528a.eWK : 0, C38916k.m66054c(this.ljf).bog());
            } else {
                C4990ab.m7416i("MicroMsg.EmojiMixer", "api level below 23 user sync decoder");
                c42973j = new C38912i(this.ljf.videoPath, C38916k.m66054c(this.ljf).bog());
            }
            c38916k.liW = c42973j;
            C38916k.m66056e(this.ljf).ljl = C389141.lji;
            C38916k.m66056e(this.ljf).ljm = new C340042(this);
            if (C38916k.m66056e(this.ljf).init() < 0) {
                C34007d c34007d = C34007d.lhz;
                C34007d.bnb();
            }
            C38916k.m66056e(this.ljf).mo61799UB();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2705);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.k$d */
    static final class C38917d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C38916k ljf;

        C38917d(C38916k c38916k) {
            this.ljf = c38916k;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2700);
            C38916k c38916k = this.ljf;
            c38916k.frameCount = c38916k.frameCount + 1;
            C38916k.m66053b(this.ljf);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2700);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(2707);
        AppMethodBeat.m2505o(2707);
    }

    public C38916k(String str, C42972a c42972a, String str2, int i, boolean z, boolean z2, boolean z3, long j) {
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(c42972a, "emojiFrameRetriever");
        C25052j.m39376p(str2, "gifPath");
        AppMethodBeat.m2504i(2706);
        this.videoPath = str;
        this.ljc = c42972a;
        this.hzs = str2;
        this.liz = i;
        this.ljd = z;
        this.liB = z2;
        this.liC = z3;
        this.ezZ = j;
        AppMethodBeat.m2505o(2706);
    }

    /* renamed from: c */
    public static final /* synthetic */ C11623d m66054c(C38916k c38916k) {
        AppMethodBeat.m2504i(2709);
        C11623d c11623d = c38916k.liX;
        if (c11623d == null) {
            C25052j.avw("mixPixelBuffer");
        }
        AppMethodBeat.m2505o(2709);
        return c11623d;
    }

    /* renamed from: e */
    public static final /* synthetic */ C45868l m66056e(C38916k c38916k) {
        AppMethodBeat.m2504i(2710);
        C45868l c45868l = c38916k.liW;
        if (c45868l == null) {
            C25052j.avw("videoDecoder");
        }
        AppMethodBeat.m2505o(2710);
        return c45868l;
    }

    /* renamed from: b */
    public static final /* synthetic */ void m66053b(C38916k c38916k) {
        boolean z;
        AppMethodBeat.m2504i(2708);
        C11623d c11623d = c38916k.liX;
        if (c11623d == null) {
            C25052j.avw("mixPixelBuffer");
        }
        C32745e c32745e = c38916k.liY;
        if (c32745e == null) {
            C25052j.avw("syncMgr");
        }
        int i = c38916k.frameCount;
        C4990ab.m7416i(c32745e.TAG, "after syncMixNextFrame, framePass " + i + ", videoPassFrame:" + c32745e.eWL + ", targetPassFrame:" + c32745e.eWQ + ", emojiPassDuration: " + c32745e.eWO);
        i--;
        if (i > 0 && c32745e.eWL < i) {
            c32745e.eWL = i;
        }
        c32745e.eWV = c32745e.eWU * ((float) c32745e.eWQ);
        c32745e.eWT = c32745e.eWS * ((float) c32745e.eWL);
        while (c32745e.eWV >= c32745e.eWO) {
            C1778c UX = c32745e.eWW.mo5327UX();
            if (UX == null || UX.eWH <= 0) {
                break;
            }
            c32745e.eWO += (float) UX.eWH;
            c32745e.eWN = UX.bitmap;
        }
        Bitmap bitmap = c32745e.eWN;
        if (c32745e.eWS * ((float) c32745e.eWL) < c32745e.eWU * ((float) c32745e.eWQ)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C4990ab.m7416i(c32745e.TAG, "syncMixNextFrame, skip frame");
        } else {
            c32745e.eWQ++;
            C4990ab.m7416i(c32745e.TAG, "syncMixNextFrame pass frame: " + c32745e.eWQ);
        }
        c32745e.eWL++;
        C32746a c32746a = new C32746a(bitmap, z);
        C17126b c24750c = new C24750c(c38916k);
        C4990ab.m7416i(c11623d.TAG, "mixVideoAndEmojiFrame, skip: " + Boolean.valueOf(c32746a.cAi));
        if (C25052j.m39373j(Boolean.valueOf(c32746a.cAi), Boolean.FALSE)) {
            C45872e c45872e = c11623d.loU;
            if (c45872e == null) {
                C25052j.avw("renderer");
            }
            c45872e.eZt = c32746a.eWX;
            C45872e c45872e2 = c11623d.loU;
            if (c45872e2 == null) {
                C25052j.avw("renderer");
            }
            GL10 gl10 = c11623d.loT;
            if (gl10 == null) {
                C25052j.avw("gl");
            }
            c45872e2.onDrawFrame(gl10);
            c24750c.mo50am(Boolean.FALSE);
            AppMethodBeat.m2505o(2708);
            return;
        }
        C45872e c45872e3 = c11623d.loU;
        if (c45872e3 == null) {
            C25052j.avw("renderer");
        }
        c45872e3.boh().updateTexImage();
        c24750c.mo50am(Boolean.TRUE);
        AppMethodBeat.m2505o(2708);
    }
}
