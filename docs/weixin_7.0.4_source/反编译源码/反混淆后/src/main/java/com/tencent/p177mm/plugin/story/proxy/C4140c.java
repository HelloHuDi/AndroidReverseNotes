package com.tencent.p177mm.plugin.story.proxy;

import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import com.tencent.p177mm.loader.p864g.C42155f;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.loader.p864g.p1196a.C18536g;
import com.tencent.p177mm.loader.p864g.p1196a.C18537h;
import com.tencent.p177mm.loader.p864g.p1196a.C46886a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.C46277g;
import com.tencent.p177mm.plugin.story.model.audio.C46277g.C4125a;
import com.tencent.p177mm.plugin.story.model.p1036e.C46282b;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a.C29281a;
import com.tencent.p177mm.plugin.story.p1303e.C39872a;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C39877f;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35186d;
import com.tencent.p177mm.plugin.story.p532h.C39878d;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.util.C6037d;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37091y;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "", "()V", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "reStartMix", "", "storyEditorItem", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Companion", "MixTask", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.proxy.c */
public final class C4140c {
    private static final String TAG = TAG;
    private static final C44856f eQz = C17344i.m26854g(C4144b.saV);
    public static final C4141a saU = new C4141a();
    private C26366d<C4142c> liD;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "instance$delegate", "Lkotlin/Lazy;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.c$a */
    public static final class C4141a {
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C4141a.class), "instance", "getInstance()Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;"))};

        static {
            AppMethodBeat.m2504i(109739);
            AppMethodBeat.m2505o(109739);
        }

        public static C4140c czN() {
            AppMethodBeat.m2504i(109740);
            C4140c c4140c = (C4140c) C4140c.eQz.getValue();
            AppMethodBeat.m2505o(109740);
            return c4140c;
        }

        private C4141a() {
        }

        public /* synthetic */ C4141a(byte b) {
            this();
        }

        public static String getTAG() {
            AppMethodBeat.m2504i(109741);
            String access$getTAG$cp = C4140c.TAG;
            AppMethodBeat.m2505o(109741);
            return access$getTAG$cp;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "(Lcom/tencent/mm/plugin/story/storage/StoryEditorData;)V", "isCaptureVideo", "", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "startPerformance", "", "call", "", "runMix", "uniqueId", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.c$c */
    public static final class C4142c extends C26365c {
        int ehv;
        private boolean fbV;
        private cei rWk;
        C39878d saW;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.proxy.c$c$a */
        static final class C4139a implements Runnable {
            final /* synthetic */ C4142c saX;

            C4139a(C4142c c4142c) {
                this.saX = c4142c;
            }

            public final void run() {
                C39877f c39877f;
                AppMethodBeat.m2504i(109742);
                C4141a c4141a = C4140c.saU;
                C4990ab.m7416i(C4141a.getTAG(), "call reStart background mix " + this.saX.saW.xDa + " it " + this.saX.saW + " mixRetryTime:" + this.saX.saW.field_mixRetryTime);
                C1331a cee = new cee();
                try {
                    cee.parseFrom(this.saX.saW.field_baseItemData);
                } catch (Exception e) {
                    C4990ab.m7408b("safeParser", "", e);
                    cee = null;
                }
                cee cee2 = (cee) cee;
                if (cee2 != null) {
                    c39877f = C39877f.sbT;
                    C39877f.m68291lG(cee2.fbV);
                }
                C22210l c22210l;
                if (this.saX.saW.field_mixRetryTime < 3) {
                    c22210l = C22210l.sac;
                    C22210l.m33883lg(this.saX.saW.xDa);
                    if (cee2 != null) {
                        C4133a c4133a = C43644j.rST;
                        C39878d ls = C4133a.cxY().mo17051ls(this.saX.saW.xDa);
                        if (ls != null) {
                            this.saX.saW = ls;
                        }
                    }
                    C4142c.m6475a(this.saX);
                    AppMethodBeat.m2505o(109742);
                    return;
                }
                C4141a c4141a2 = C4140c.saU;
                C4990ab.m7416i(C4141a.getTAG(), "retry mix third and still failed");
                c22210l = C22210l.sac;
                C22210l.m33882lf(this.saX.saW.xDa);
                if (cee2 != null) {
                    c39877f = C39877f.sbT;
                    C39877f.m68293lI(cee2.fbV);
                }
                this.saX.mo44157a(C45423h.Fail);
                AppMethodBeat.m2505o(109742);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "mixVideoPath", "", "mixThumb", "ret", "", "invoke", "com/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask$runMix$1$1"})
        /* renamed from: com.tencent.mm.plugin.story.proxy.c$c$b */
        static final class C4143b extends C25053k implements C36933q<String, String, Boolean, C37091y> {
            final /* synthetic */ ArrayList rYM;
            final /* synthetic */ C4142c saX;
            final /* synthetic */ C39872a saY;
            final /* synthetic */ cee saZ;

            C4143b(C39872a c39872a, ArrayList arrayList, C4142c c4142c, cee cee) {
                this.saY = c39872a;
                this.rYM = arrayList;
                this.saX = c4142c;
                this.saZ = cee;
                super(3);
            }

            /* JADX WARNING: Removed duplicated region for block: B:22:0x010f  */
            /* JADX WARNING: Missing block: B:18:0x00f4, code skipped:
            if (r4 < ((long) r0)) goto L_0x00f6;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: g */
            public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.m2504i(109743);
                String str = (String) obj;
                String str2 = (String) obj2;
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                C25052j.m39376p(str, "mixVideoPath");
                C25052j.m39376p(str2, "mixThumb");
                C4141a c4141a = C4140c.saU;
                C4990ab.m7416i(C4141a.getTAG(), "mixer task done " + this.saX.saW.xDa + " ret " + booleanValue + " mixVideoPath " + str + " mixThumb " + str2);
                if (this.saX.ehv != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, this.saX.ehv);
                    C4990ab.m7417i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(this.saX.ehv));
                    this.saX.ehv = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                C22212h c22212h = C22212h.scu;
                long Ft = currentTimeMillis - C22212h.cAC().mo4987Ft();
                C22212h c22212h2 = C22212h.scu;
                C22212h.cAC().mo4989aT(Ft);
                c22212h2 = C22212h.scu;
                C22212h.cAC().mo4990aU(booleanValue ? 0 : -1);
                c22212h2 = C22212h.scu;
                C22212h.cAC().mo4991aV(System.currentTimeMillis());
                if (booleanValue) {
                    boolean z;
                    C22210l c22210l;
                    C4133a c4133a;
                    c22212h2 = C22212h.scu;
                    C22212h.m33894bl(this.saX.saW.field_storyLocalId, str);
                    C29283a c29283a = C29282c.rRS;
                    C29281a aaj = C29283a.aaj(this.saY.fbT);
                    if (!this.saY.fbV) {
                        if (!this.saY.fbV) {
                            if (this.rYM.size() <= 0) {
                                long j = this.saY.rRH - this.saY.rRG;
                                int i;
                                if (aaj != null) {
                                    i = aaj.duration;
                                } else {
                                    i = 0;
                                }
                            }
                        }
                        z = false;
                        c22210l = C22210l.sac;
                        C22210l.m33873a(this.saX.saW.xDa, str, str2, z);
                        c4133a = C43644j.rST;
                        C4133a.cya().czx();
                        if (this.saZ != null) {
                            C39877f c39877f = C39877f.sbT;
                            C39877f.m68292lH(this.saZ.fbV);
                            c39877f = C39877f.sbT;
                            C39877f.m68289f(this.saZ.fbV, Ft);
                            c39877f = C39877f.sbT;
                            C39877f.m68288ai(this.saX.saW.field_mixRetryTime, this.saZ.fbV);
                        }
                        this.saX.mo44157a(C45423h.OK);
                    }
                    z = true;
                    c22210l = C22210l.sac;
                    C22210l.m33873a(this.saX.saW.xDa, str, str2, z);
                    c4133a = C43644j.rST;
                    C4133a.cya().czx();
                    if (this.saZ != null) {
                    }
                    this.saX.mo44157a(C45423h.OK);
                } else {
                    this.saX.mo44157a(C45423h.Wait);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109743);
                return c37091y;
            }
        }

        public C4142c(C39878d c39878d) {
            C25052j.m39376p(c39878d, "editorData");
            AppMethodBeat.m2504i(109746);
            this.saW = c39878d;
            AppMethodBeat.m2505o(109746);
        }

        /* renamed from: Pa */
        public final void mo9026Pa() {
            AppMethodBeat.m2504i(109744);
            C7305d.xDG.mo10151b(new C4139a(this), "StoryMixHandler");
            AppMethodBeat.m2505o(109744);
        }

        /* renamed from: Pc */
        public final String mo9027Pc() {
            AppMethodBeat.m2504i(109745);
            String str = "mixTask_" + this.saW + ".localId";
            AppMethodBeat.m2505o(109745);
            return str;
        }

        /* renamed from: a */
        public static final /* synthetic */ void m6475a(C4142c c4142c) {
            C22210l c22210l;
            AppMethodBeat.m2504i(109747);
            C4141a c4141a = C4140c.saU;
            C4990ab.m7416i(C4141a.getTAG(), "runMix from StoryMixHandler");
            C4125a c4125a = C46277g.rUG;
            C46277g.rUF.cancelAll();
            C1331a cee = new cee();
            try {
                cee.parseFrom(c4142c.saW.field_baseItemData);
            } catch (Exception e) {
                C4990ab.m7408b("safeParser", "", e);
                cee = null;
            }
            cee cee2 = (cee) cee;
            if (cee2 != null) {
                Object obj;
                c22210l = C22210l.sac;
                C25052j.m39376p(cee2, "storyEditorProtoData");
                String str = cee2.videoPath;
                C25052j.m39375o(str, "storyEditorProtoData.videoPath");
                if (C22210l.m33881gA(str, cee2.xdY.xdN)) {
                    str = cee2.thumbPath;
                    C25052j.m39375o(str, "storyEditorProtoData.thumbPath");
                    if (C22210l.m33881gA(str, cee2.xdY.xdQ)) {
                        if (cee2.xdR != null) {
                            str = cee2.xdR;
                            C25052j.m39375o(str, "storyEditorProtoData.backgroundPath");
                            if (!C22210l.m33881gA(str, cee2.xdY.xdP)) {
                                C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "now the background path md5 is unequal as befor is" + cee2.xdY.xdP + "and now is " + C6037d.m9501cz(cee2.xdR));
                                obj = null;
                            }
                        }
                        if (cee2.eYi != null) {
                            str = cee2.eYi;
                            C25052j.m39375o(str, "storyEditorProtoData.musicPath");
                            if (!C22210l.m33881gA(str, cee2.xdY.xdO)) {
                                C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "now the music path md5 is unequal as befor is" + cee2.xdY.xdO + "and now is " + C6037d.m9501cz(cee2.eYi));
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "now the thumb path md5 is unequal as befor is" + cee2.xdY.xdQ + "and now is " + C6037d.m9501cz(cee2.thumbPath));
                        obj = null;
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "now the video path md5 is unequal as befor is" + cee2.xdY.xdN + "and now is " + C6037d.m9501cz(cee2.videoPath));
                    obj = null;
                }
                if (obj != null) {
                    AudioCacheInfo audioCacheInfo;
                    c22210l = C22210l.sac;
                    C25052j.m39376p(cee2, "storyEditorProtoData");
                    C39872a c39872a = new C39872a();
                    C25052j.m39376p(cee2, "storyEditorProtoData");
                    if (cee2.eTb == 0 || cee2.eTb == 1) {
                        audioCacheInfo = null;
                    } else {
                        audioCacheInfo = new AudioCacheInfo();
                        audioCacheInfo.musicUrl = cee2.musicUrl;
                        audioCacheInfo.rTW = cee2.rTW;
                        audioCacheInfo.aIM = cee2.aIM;
                        audioCacheInfo.rTZ = cee2.rTZ;
                        audioCacheInfo.cachePath = cee2.eYi;
                        audioCacheInfo.position = cee2.xdZ;
                        audioCacheInfo.rUb = cee2.xea;
                    }
                    c39872a.rRJ = audioCacheInfo;
                    c39872a.rRI = cee2.eTb;
                    c39872a.rRG = cee2.startTime;
                    c39872a.rRH = cee2.endTime;
                    str = cee2.videoPath;
                    C25052j.m39375o(str, "storyEditorProtoData.videoPath");
                    c39872a.aad(str);
                    str = cee2.thumbPath;
                    C25052j.m39375o(str, "storyEditorProtoData.thumbPath");
                    c39872a.aae(str);
                    c39872a.fbV = cee2.fbV;
                    c22210l = C22210l.sac;
                    Context context = C4996ah.getContext();
                    C25052j.m39375o(context, "MMApplicationContext.getContext()");
                    ArrayList a = C22210l.m33871a(cee2, context);
                    c22210l = C22210l.sac;
                    float[] a2 = C22210l.m33878a(cee2);
                    long aaE = C1839cb.aaE();
                    C46282b c46282b = new C46282b(c39872a, a, a2, C29309l.aau(String.valueOf(aaE)), C29309l.aav(String.valueOf(aaE)), (byte) 0);
                    c4142c.rWk = cee2.smk;
                    c4142c.fbV = cee2.fbV;
                    C22212h c22212h = C22212h.scu;
                    C22212h.cAC().mo4989aT(System.currentTimeMillis());
                    c22212h = C22212h.scu;
                    C22212h.m33895g(c4142c.saW.field_storyLocalId, c39872a.fbT, c39872a.fbV);
                    c4142c.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.Media.StoryVideoMixer");
                    C4990ab.m7417i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(c4142c.ehv));
                    c46282b.mo74423a((C36933q) new C4143b(c39872a, a, c4142c, cee2));
                    AppMethodBeat.m2505o(109747);
                    return;
                }
            }
            C39877f c39877f = C39877f.sbT;
            C39877f.cAh();
            c22210l = C22210l.sac;
            C22210l.m33882lf(c4142c.saW.xDa);
            c4142c.mo44157a(C45423h.Fail);
            AppMethodBeat.m2505o(109747);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.c$b */
    static final class C4144b extends C25053k implements C31214a<C4140c> {
        public static final C4144b saV = new C4144b();

        static {
            AppMethodBeat.m2504i(109738);
            AppMethodBeat.m2505o(109738);
        }

        C4144b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109737);
            C4140c c4140c = new C4140c();
            AppMethodBeat.m2505o(109737);
            return c4140c;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$1$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.c$d */
    public static final class C4145d implements C42155f<C4142c> {
        final /* synthetic */ C4140c sba;
        final /* synthetic */ C39878d sbb;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$1$1$onLoaderFin$1"})
        /* renamed from: com.tencent.mm.plugin.story.proxy.c$d$1 */
        static final class C41461 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C4145d sbc;

            C41461(C4145d c4145d) {
                this.sbc = c4145d;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109748);
                C4133a c4133a = C43644j.rST;
                C39878d ls = C4133a.cxY().mo17051ls(this.sbc.sbb.xDa);
                if (ls != null) {
                    int i = ls.field_mixFlag;
                    C35186d c35186d = C35186d.sdv;
                    if (C8902b.m16046cf(i, C35186d.cBx())) {
                        this.sbc.sba.mo9024a(ls);
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109748);
                return c37091y;
            }
        }

        C4145d(C4140c c4140c, C39878d c39878d) {
            this.sba = c4140c;
            this.sbb = c39878d;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(109749);
            C4142c c4142c = (C4142c) c26365c;
            C25052j.m39376p(c4142c, "task");
            C25052j.m39376p(c45423h, "status");
            C4141a c4141a = C4140c.saU;
            C4990ab.m7416i(C4141a.getTAG(), "reStart next work! status " + c45423h + ' ' + c4142c);
            if (c45423h == C45423h.OK) {
                this.sba.czM();
                AppMethodBeat.m2505o(109749);
                return;
            }
            if (c45423h == C45423h.Wait) {
                C8902b.m16041a(60000, (C31214a) new C41461(this));
            }
            AppMethodBeat.m2505o(109749);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$2$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.c$e */
    public static final class C4147e implements C42155f<C4142c> {
        final /* synthetic */ C4140c sba;
        final /* synthetic */ C39878d sbb;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$2$1$onLoaderFin$1"})
        /* renamed from: com.tencent.mm.plugin.story.proxy.c$e$1 */
        static final class C41481 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C4147e sbd;

            C41481(C4147e c4147e) {
                this.sbd = c4147e;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109750);
                C4133a c4133a = C43644j.rST;
                C39878d ls = C4133a.cxY().mo17051ls(this.sbd.sbb.xDa);
                if (ls != null) {
                    int i = ls.field_mixFlag;
                    C35186d c35186d = C35186d.sdv;
                    if (C8902b.m16046cf(i, C35186d.cBx())) {
                        this.sbd.sba.mo9024a(ls);
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109750);
                return c37091y;
            }
        }

        C4147e(C4140c c4140c, C39878d c39878d) {
            this.sba = c4140c;
            this.sbb = c39878d;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(109751);
            C4142c c4142c = (C4142c) c26365c;
            C25052j.m39376p(c4142c, "task");
            C25052j.m39376p(c45423h, "status");
            C4141a c4141a = C4140c.saU;
            C4990ab.m7416i(C4141a.getTAG(), "reStart next work! status " + c45423h + ' ' + c4142c);
            if (c45423h == C45423h.OK) {
                this.sba.mo9024a(this.sbb);
                AppMethodBeat.m2505o(109751);
                return;
            }
            if (c45423h == C45423h.Wait) {
                C8902b.m16041a(60000, (C31214a) new C41481(this));
            }
            AppMethodBeat.m2505o(109751);
        }
    }

    private C4140c() {
        AppMethodBeat.m2504i(109754);
        this.liD = new C26366d(new C18536g(new C46886a(5), new C18537h(), "storyMixTask"));
        AppMethodBeat.m2505o(109754);
    }

    public /* synthetic */ C4140c(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(109755);
        AppMethodBeat.m2505o(109755);
    }

    public final boolean czM() {
        AppMethodBeat.m2504i(109752);
        C4133a c4133a = C43644j.rST;
        C39878d cBH = C4133a.cxY().cBH();
        if (cBH != null) {
            C4990ab.m7416i(TAG, "reStart background mix1 " + cBH.xDa + " it " + cBH);
            this.liD.mo44159a(new C4142c(cBH), new C4145d(this, cBH));
            AppMethodBeat.m2505o(109752);
        } else {
            C4990ab.m7410d(TAG, "mix task is empty");
            AppMethodBeat.m2505o(109752);
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo9024a(C39878d c39878d) {
        AppMethodBeat.m2504i(109753);
        C25052j.m39376p(c39878d, "storyEditorItem");
        C4990ab.m7416i(TAG, "reStart background mix2 " + c39878d.xDa + " it " + c39878d);
        this.liD.mo44159a(new C4142c(c39878d), new C4147e(this, c39878d));
        AppMethodBeat.m2505o(109753);
        return true;
    }
}
