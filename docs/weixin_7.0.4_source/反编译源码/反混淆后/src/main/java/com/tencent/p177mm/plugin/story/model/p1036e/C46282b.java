package com.tencent.p177mm.plugin.story.model.p1036e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.media.p253f.C1778c;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.C46277g;
import com.tencent.p177mm.plugin.story.model.audio.C46277g.C4125a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a.C29281a;
import com.tencent.p177mm.plugin.story.p1303e.C39872a;
import com.tencent.p177mm.plugin.story.p531g.C29292g;
import com.tencent.p177mm.plugin.story.p531g.C39877f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014H\u0002J\u0018\u0010;\u001a\u00020<2\u0006\u00107\u001a\u00020\r2\u0006\u00105\u001a\u00020\rH\u0002J\u0016\u0010=\u001a\u00020.2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020.0?H\u0002J\u000e\u0010@\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003J\n\u0010A\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010B\u001a\u00020.H\u0002J\b\u0010C\u001a\u00020.H\u0002JU\u0010D\u001a\u00020.2M\u0010&\u001aI\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010'R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#RU\u0010&\u001aI\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer;", "", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "drawingRect", "", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "(Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;Ljava/util/List;[FLjava/lang/String;Ljava/lang/String;I)V", "audioBitrate", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "getCaptureInfo", "()Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getDrawingRect", "()[F", "getEditorItems", "()Ljava/util/List;", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/media/mix/FrameInfo;", "getMixThumbPath", "()Ljava/lang/String;", "setMixThumbPath", "(Ljava/lang/String;)V", "getMixVideoPath", "setMixVideoPath", "onFinish", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "", "getRetryTime", "()I", "setRetryTime", "(I)V", "videoBitrate", "videoFrameRate", "videoHeight", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "calcMixEmojiSize", "Landroid/graphics/Point;", "checkAudioCache", "callback", "Lkotlin/Function0;", "createGraffitiThumb", "createThumb", "makeSureConfig", "mix", "start", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.e.b */
public final class C46282b {
    public static final C13776a rWB = new C13776a();
    private int audioSampleRate;
    private int eRs;
    public final List<C9584b> eWG;
    public int eXL;
    public final C17126b<Long, Bitmap> eXh;
    private int fzS;
    String rWA;
    private C36933q<? super String, ? super String, ? super Boolean, C37091y> rWt;
    private long rWu;
    private C1778c rWv;
    public C13775a rWw;
    final C39872a rWx;
    public final float[] rWy;
    String rWz;
    private int videoBitrate;
    private int videoFrameRate;
    private int videoHeight;
    private int videoWidth;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.e.b$a */
    public static final class C13776a {
        private C13776a() {
        }

        public /* synthetic */ C13776a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.e.b$b */
    static final class C35202b extends C25053k implements C17126b<Long, Bitmap> {
        final /* synthetic */ C46282b rWC;

        C35202b(C46282b c46282b) {
            this.rWC = c46282b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(109331);
            long longValue = ((Number) obj).longValue();
            C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "get bitmap ".concat(String.valueOf(longValue)));
            while (longValue / 1000 > this.rWC.rWu) {
                Object valueOf;
                C1778c UX = C46282b.m86775c(this.rWC).mo5327UX();
                String str = "MicroMsg.Media.StoryVideoMixer";
                StringBuilder stringBuilder = new StringBuilder("get frame ");
                if (UX != null) {
                    valueOf = Long.valueOf(UX.eWH);
                } else {
                    valueOf = null;
                }
                C4990ab.m7416i(str, stringBuilder.append(valueOf).append(" blendBitmapProvider: ").append(longValue).toString());
                if (UX == null || UX.eWH <= 0) {
                    break;
                }
                C46282b c46282b = this.rWC;
                c46282b.rWu = c46282b.rWu + UX.eWH;
                this.rWC.rWv = UX;
            }
            C1778c f = this.rWC.rWv;
            if (f != null) {
                Bitmap bitmap = f.bitmap;
                AppMethodBeat.m2505o(109331);
                return bitmap;
            }
            AppMethodBeat.m2505o(109331);
            return null;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.e.b$e */
    static final class C35203e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C46282b rWC;
        final /* synthetic */ C36933q rWD;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.e.b$e$1 */
        static final class C352041 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C35203e rWE;

            C352041(C35203e c35203e) {
                this.rWE = c35203e;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109334);
                try {
                    C46282b.m86771a(this.rWE.rWC);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Media.StoryVideoMixer", e, "error on startVideoMixer", new Object[0]);
                    C36933q c36933q = this.rWE.rWD;
                    if (c36933q != null) {
                        c36933q.mo9028g(this.rWE.rWC.rWz, this.rWE.rWC.rWA, Boolean.FALSE);
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109334);
                return c37091y;
            }
        }

        C35203e(C46282b c46282b, C36933q c36933q) {
            this.rWC = c46282b;
            this.rWD = c36933q;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109335);
            C8902b.m16044a("StoryVideoMixer", (C31214a) new C352041(this));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109335);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.e.b$c */
    static final class C39891c extends C25053k implements C31591m<Boolean, String, C37091y> {
        final /* synthetic */ C31214a lix;

        C39891c(C31214a c31214a) {
            this.lix = c31214a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(109332);
            if (((Boolean) obj).booleanValue()) {
                this.lix.invoke();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109332);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.e.b$d */
    static final class C46281d extends C25053k implements C17126b<String, C37091y> {
        final /* synthetic */ C46282b rWC;

        C46281d(C46282b c46282b) {
            this.rWC = c46282b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(109333);
            String str = (String) obj;
            CharSequence charSequence = str;
            Object obj2 = (charSequence == null || charSequence.length() == 0) ? 1 : null;
            C36933q b;
            if (obj2 != null) {
                C4990ab.m7412e("MicroMsg.Media.StoryVideoMixer", "remux failed, ret path is null");
                b = this.rWC.rWt;
                if (b != null) {
                    b.mo9028g("", "", Boolean.FALSE);
                }
            } else {
                C46282b c46282b = this.rWC;
                C25052j.m39376p(str, "<set-?>");
                c46282b.rWz = str;
                C46282b.m86775c(this.rWC).destroy();
                try {
                    C29283a c29283a = C29282c.rRS;
                    C29281a aaj = C29283a.aaj(this.rWC.rWz);
                    if (aaj != null) {
                        C29292g c29292g = C29292g.sbU;
                        C29292g.m46509h(this.rWC.rWx.fbV, aaj.videoBitrate, aaj.fps);
                    }
                } catch (Exception e) {
                }
                String d = C46282b.m86776d(this.rWC);
                if (C5046bo.isNullOrNil(d)) {
                    C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "mix create thumb failed");
                    b = this.rWC.rWt;
                    if (b != null) {
                        b.mo9028g(this.rWC.rWz, "", Boolean.FALSE);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "mix create thumb succ");
                    C36933q b2 = this.rWC.rWt;
                    if (b2 != null) {
                        String str2 = this.rWC.rWz;
                        if (d == null) {
                            C25052j.dWJ();
                        }
                        b2.mo9028g(str2, d, Boolean.TRUE);
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109333);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(109339);
        AppMethodBeat.m2505o(109339);
    }

    private C46282b(C39872a c39872a, List<C9584b> list, float[] fArr, String str, String str2) {
        C29309l c29309l;
        C25052j.m39376p(c39872a, "captureInfo");
        C25052j.m39376p(list, "editorItems");
        C25052j.m39376p(fArr, "drawingRect");
        C25052j.m39376p(str, "mixVideoPath");
        C25052j.m39376p(str2, "mixThumbPath");
        AppMethodBeat.m2504i(109338);
        this.rWx = c39872a;
        this.eWG = list;
        this.rWy = fArr;
        this.rWz = str;
        this.rWA = str2;
        this.eRs = 1;
        this.rWu = -1;
        if (!C5730e.m8628ct(this.rWz)) {
            c29309l = C29309l.rTg;
            C29309l.aay(this.rWz);
        }
        if (!C5730e.m8628ct(this.rWA)) {
            c29309l = C29309l.rTg;
            C29309l.aay(this.rWA);
        }
        C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "create StoryVideoMixer, videoPath:" + this.rWx.fbT + ", outputFilePath:" + this.rWz + ", isCaptureVideo:" + this.rWx.fbV + ", retryTime:" + this.eRs);
        if (!C5730e.m8628ct(this.rWx.fbT)) {
            C39877f c39877f = C39877f.sbT;
            C39877f.m68294lJ(this.rWx.fbV);
        }
        this.eXh = new C35202b(this);
        AppMethodBeat.m2505o(109338);
    }

    /* renamed from: c */
    public static final /* synthetic */ C13775a m86775c(C46282b c46282b) {
        AppMethodBeat.m2504i(109341);
        C13775a c13775a = c46282b.rWw;
        if (c13775a == null) {
            C25052j.avw("frameRetriever");
        }
        AppMethodBeat.m2505o(109341);
        return c13775a;
    }

    public /* synthetic */ C46282b(C39872a c39872a, List list, float[] fArr, String str, String str2, byte b) {
        this(c39872a, list, fArr, str, str2);
    }

    /* renamed from: a */
    public final void mo74423a(C36933q<? super String, ? super String, ? super Boolean, C37091y> c36933q) {
        AppMethodBeat.m2504i(109336);
        C4990ab.m7416i("MicroMsg.Media.StoryVideoMixer", "Start mixer " + C5046bo.dpG());
        this.rWt = c36933q;
        C31214a c35203e = new C35203e(this, c36933q);
        if (this.rWx.rRJ != null) {
            AudioCacheInfo audioCacheInfo = this.rWx.rRJ;
            if (audioCacheInfo == null) {
                C25052j.dWJ();
            }
            if (!audioCacheInfo.aIM) {
                C4125a c4125a = C46277g.rUG;
                C46277g cyW = C46277g.rUF;
                AudioCacheInfo audioCacheInfo2 = this.rWx.rRJ;
                if (audioCacheInfo2 == null) {
                    C25052j.dWJ();
                }
                cyW.mo74419a(audioCacheInfo2, new C39891c(c35203e));
                AppMethodBeat.m2505o(109336);
                return;
            }
        }
        c35203e.invoke();
        AppMethodBeat.m2505o(109336);
    }

    /* renamed from: fL */
    public static Point m86779fL(int i, int i2) {
        AppMethodBeat.m2504i(109337);
        Point point = new Point(i * 1, i2 * 1);
        AppMethodBeat.m2505o(109337);
        return point;
    }

    /* renamed from: d */
    public static final /* synthetic */ String m86776d(C46282b c46282b) {
        boolean z = true;
        AppMethodBeat.m2504i(109342);
        Bitmap tv = C3475d.m5784tv(c46282b.rWz);
        if (tv != null) {
            C5056d.m7625a(tv, 70, CompressFormat.JPEG, c46282b.rWA, true);
        } else {
            C29292g c29292g = C29292g.sbU;
            C29292g.cAj();
        }
        String str = "MicroMsg.Media.StoryVideoMixer";
        StringBuilder append = new StringBuilder(" mixVideoPath : ").append(c46282b.rWz).append(" mixThumbPath:").append(c46282b.rWA).append("   thumb-bitmap is null:");
        if (tv != null) {
            z = false;
        }
        C4990ab.m7416i(str, append.append(z).toString());
        if (tv == null) {
            AppMethodBeat.m2505o(109342);
            return null;
        }
        String str2 = c46282b.rWA;
        AppMethodBeat.m2505o(109342);
        return str2;
    }
}
