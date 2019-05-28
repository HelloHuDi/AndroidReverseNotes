package com.tencent.mm.plugin.story.proxy;

import a.f;
import a.f.a.q;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
import a.y;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.g;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "", "()V", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "reStartMix", "", "storyEditorItem", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Companion", "MixTask", "plugin-story_release"})
public final class c {
    private static final String TAG = TAG;
    private static final f eQz = i.g(b.saV);
    public static final a saU = new a();
    private com.tencent.mm.loader.g.d<c> liD;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "instance$delegate", "Lkotlin/Lazy;", "plugin-story_release"})
    public static final class a {
        static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(a.class), "instance", "getInstance()Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;"))};

        static {
            AppMethodBeat.i(109739);
            AppMethodBeat.o(109739);
        }

        public static c czN() {
            AppMethodBeat.i(109740);
            c cVar = (c) c.eQz.getValue();
            AppMethodBeat.o(109740);
            return cVar;
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static String getTAG() {
            AppMethodBeat.i(109741);
            String access$getTAG$cp = c.TAG;
            AppMethodBeat.o(109741);
            return access$getTAG$cp;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "(Lcom/tencent/mm/plugin/story/storage/StoryEditorData;)V", "isCaptureVideo", "", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "startPerformance", "", "call", "", "runMix", "uniqueId", "", "plugin-story_release"})
    public static final class c extends com.tencent.mm.loader.g.c {
        int ehv;
        private boolean fbV;
        private cei rWk;
        com.tencent.mm.plugin.story.h.d saW;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c saX;

            a(c cVar) {
                this.saX = cVar;
            }

            public final void run() {
                com.tencent.mm.plugin.story.g.f fVar;
                AppMethodBeat.i(109742);
                a aVar = c.saU;
                ab.i(a.getTAG(), "call reStart background mix " + this.saX.saW.xDa + " it " + this.saX.saW + " mixRetryTime:" + this.saX.saW.field_mixRetryTime);
                com.tencent.mm.bt.a cee = new cee();
                try {
                    cee.parseFrom(this.saX.saW.field_baseItemData);
                } catch (Exception e) {
                    ab.b("safeParser", "", e);
                    cee = null;
                }
                cee cee2 = (cee) cee;
                if (cee2 != null) {
                    fVar = com.tencent.mm.plugin.story.g.f.sbT;
                    com.tencent.mm.plugin.story.g.f.lG(cee2.fbV);
                }
                com.tencent.mm.plugin.story.f.l lVar;
                if (this.saX.saW.field_mixRetryTime < 3) {
                    lVar = com.tencent.mm.plugin.story.f.l.sac;
                    com.tencent.mm.plugin.story.f.l.lg(this.saX.saW.xDa);
                    if (cee2 != null) {
                        com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
                        com.tencent.mm.plugin.story.h.d ls = com.tencent.mm.plugin.story.model.j.a.cxY().ls(this.saX.saW.xDa);
                        if (ls != null) {
                            this.saX.saW = ls;
                        }
                    }
                    c.a(this.saX);
                    AppMethodBeat.o(109742);
                    return;
                }
                a aVar3 = c.saU;
                ab.i(a.getTAG(), "retry mix third and still failed");
                lVar = com.tencent.mm.plugin.story.f.l.sac;
                com.tencent.mm.plugin.story.f.l.lf(this.saX.saW.xDa);
                if (cee2 != null) {
                    fVar = com.tencent.mm.plugin.story.g.f.sbT;
                    com.tencent.mm.plugin.story.g.f.lI(cee2.fbV);
                }
                this.saX.a(h.Fail);
                AppMethodBeat.o(109742);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "mixVideoPath", "", "mixThumb", "ret", "", "invoke", "com/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask$runMix$1$1"})
        static final class b extends a.f.b.k implements q<String, String, Boolean, y> {
            final /* synthetic */ ArrayList rYM;
            final /* synthetic */ c saX;
            final /* synthetic */ com.tencent.mm.plugin.story.e.a saY;
            final /* synthetic */ cee saZ;

            b(com.tencent.mm.plugin.story.e.a aVar, ArrayList arrayList, c cVar, cee cee) {
                this.saY = aVar;
                this.rYM = arrayList;
                this.saX = cVar;
                this.saZ = cee;
                super(3);
            }

            /* JADX WARNING: Removed duplicated region for block: B:22:0x010f  */
            /* JADX WARNING: Missing block: B:18:0x00f4, code skipped:
            if (r4 < ((long) r0)) goto L_0x00f6;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(109743);
                String str = (String) obj;
                String str2 = (String) obj2;
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                a.f.b.j.p(str, "mixVideoPath");
                a.f.b.j.p(str2, "mixThumb");
                a aVar = c.saU;
                ab.i(a.getTAG(), "mixer task done " + this.saX.saW.xDa + " ret " + booleanValue + " mixVideoPath " + str + " mixThumb " + str2);
                if (this.saX.ehv != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, this.saX.ehv);
                    ab.i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(this.saX.ehv));
                    this.saX.ehv = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                long Ft = currentTimeMillis - com.tencent.mm.plugin.story.g.h.cAC().Ft();
                com.tencent.mm.plugin.story.g.h hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAC().aT(Ft);
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAC().aU(booleanValue ? 0 : -1);
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAC().aV(System.currentTimeMillis());
                if (booleanValue) {
                    boolean z;
                    com.tencent.mm.plugin.story.f.l lVar;
                    com.tencent.mm.plugin.story.model.j.a aVar2;
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.bl(this.saX.saW.field_storyLocalId, str);
                    com.tencent.mm.plugin.story.e.c.a aVar3 = com.tencent.mm.plugin.story.e.c.rRS;
                    com.tencent.mm.plugin.story.e.c.a.a aaj = com.tencent.mm.plugin.story.e.c.a.aaj(this.saY.fbT);
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
                        lVar = com.tencent.mm.plugin.story.f.l.sac;
                        com.tencent.mm.plugin.story.f.l.a(this.saX.saW.xDa, str, str2, z);
                        aVar2 = j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cya().czx();
                        if (this.saZ != null) {
                            com.tencent.mm.plugin.story.g.f fVar = com.tencent.mm.plugin.story.g.f.sbT;
                            com.tencent.mm.plugin.story.g.f.lH(this.saZ.fbV);
                            fVar = com.tencent.mm.plugin.story.g.f.sbT;
                            com.tencent.mm.plugin.story.g.f.f(this.saZ.fbV, Ft);
                            fVar = com.tencent.mm.plugin.story.g.f.sbT;
                            com.tencent.mm.plugin.story.g.f.ai(this.saX.saW.field_mixRetryTime, this.saZ.fbV);
                        }
                        this.saX.a(h.OK);
                    }
                    z = true;
                    lVar = com.tencent.mm.plugin.story.f.l.sac;
                    com.tencent.mm.plugin.story.f.l.a(this.saX.saW.xDa, str, str2, z);
                    aVar2 = j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cya().czx();
                    if (this.saZ != null) {
                    }
                    this.saX.a(h.OK);
                } else {
                    this.saX.a(h.Wait);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(109743);
                return yVar;
            }
        }

        public c(com.tencent.mm.plugin.story.h.d dVar) {
            a.f.b.j.p(dVar, "editorData");
            AppMethodBeat.i(109746);
            this.saW = dVar;
            AppMethodBeat.o(109746);
        }

        public final void Pa() {
            AppMethodBeat.i(109744);
            com.tencent.mm.sdk.g.d.xDG.b(new a(this), "StoryMixHandler");
            AppMethodBeat.o(109744);
        }

        public final String Pc() {
            AppMethodBeat.i(109745);
            String str = "mixTask_" + this.saW + ".localId";
            AppMethodBeat.o(109745);
            return str;
        }

        public static final /* synthetic */ void a(c cVar) {
            com.tencent.mm.plugin.story.f.l lVar;
            AppMethodBeat.i(109747);
            a aVar = c.saU;
            ab.i(a.getTAG(), "runMix from StoryMixHandler");
            com.tencent.mm.plugin.story.model.audio.g.a aVar2 = g.rUG;
            g.rUF.cancelAll();
            com.tencent.mm.bt.a cee = new cee();
            try {
                cee.parseFrom(cVar.saW.field_baseItemData);
            } catch (Exception e) {
                ab.b("safeParser", "", e);
                cee = null;
            }
            cee cee2 = (cee) cee;
            if (cee2 != null) {
                Object obj;
                lVar = com.tencent.mm.plugin.story.f.l.sac;
                a.f.b.j.p(cee2, "storyEditorProtoData");
                String str = cee2.videoPath;
                a.f.b.j.o(str, "storyEditorProtoData.videoPath");
                if (com.tencent.mm.plugin.story.f.l.gA(str, cee2.xdY.xdN)) {
                    str = cee2.thumbPath;
                    a.f.b.j.o(str, "storyEditorProtoData.thumbPath");
                    if (com.tencent.mm.plugin.story.f.l.gA(str, cee2.xdY.xdQ)) {
                        if (cee2.xdR != null) {
                            str = cee2.xdR;
                            a.f.b.j.o(str, "storyEditorProtoData.backgroundPath");
                            if (!com.tencent.mm.plugin.story.f.l.gA(str, cee2.xdY.xdP)) {
                                ab.i("MicroMsg.Media.StoryDataProtoUtil", "now the background path md5 is unequal as befor is" + cee2.xdY.xdP + "and now is " + com.tencent.xweb.util.d.cz(cee2.xdR));
                                obj = null;
                            }
                        }
                        if (cee2.eYi != null) {
                            str = cee2.eYi;
                            a.f.b.j.o(str, "storyEditorProtoData.musicPath");
                            if (!com.tencent.mm.plugin.story.f.l.gA(str, cee2.xdY.xdO)) {
                                ab.i("MicroMsg.Media.StoryDataProtoUtil", "now the music path md5 is unequal as befor is" + cee2.xdY.xdO + "and now is " + com.tencent.xweb.util.d.cz(cee2.eYi));
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        ab.i("MicroMsg.Media.StoryDataProtoUtil", "now the thumb path md5 is unequal as befor is" + cee2.xdY.xdQ + "and now is " + com.tencent.xweb.util.d.cz(cee2.thumbPath));
                        obj = null;
                    }
                } else {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "now the video path md5 is unequal as befor is" + cee2.xdY.xdN + "and now is " + com.tencent.xweb.util.d.cz(cee2.videoPath));
                    obj = null;
                }
                if (obj != null) {
                    AudioCacheInfo audioCacheInfo;
                    lVar = com.tencent.mm.plugin.story.f.l.sac;
                    a.f.b.j.p(cee2, "storyEditorProtoData");
                    com.tencent.mm.plugin.story.e.a aVar3 = new com.tencent.mm.plugin.story.e.a();
                    a.f.b.j.p(cee2, "storyEditorProtoData");
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
                    aVar3.rRJ = audioCacheInfo;
                    aVar3.rRI = cee2.eTb;
                    aVar3.rRG = cee2.startTime;
                    aVar3.rRH = cee2.endTime;
                    str = cee2.videoPath;
                    a.f.b.j.o(str, "storyEditorProtoData.videoPath");
                    aVar3.aad(str);
                    str = cee2.thumbPath;
                    a.f.b.j.o(str, "storyEditorProtoData.thumbPath");
                    aVar3.aae(str);
                    aVar3.fbV = cee2.fbV;
                    lVar = com.tencent.mm.plugin.story.f.l.sac;
                    Context context = ah.getContext();
                    a.f.b.j.o(context, "MMApplicationContext.getContext()");
                    ArrayList a = com.tencent.mm.plugin.story.f.l.a(cee2, context);
                    lVar = com.tencent.mm.plugin.story.f.l.sac;
                    float[] a2 = com.tencent.mm.plugin.story.f.l.a(cee2);
                    long aaE = cb.aaE();
                    com.tencent.mm.plugin.story.model.e.b bVar = new com.tencent.mm.plugin.story.model.e.b(aVar3, a, a2, com.tencent.mm.plugin.story.model.l.aau(String.valueOf(aaE)), com.tencent.mm.plugin.story.model.l.aav(String.valueOf(aaE)), (byte) 0);
                    cVar.rWk = cee2.smk;
                    cVar.fbV = cee2.fbV;
                    com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAC().aT(System.currentTimeMillis());
                    hVar = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.g(cVar.saW.field_storyLocalId, aVar3.fbT, aVar3.fbV);
                    cVar.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.Media.StoryVideoMixer");
                    ab.i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(cVar.ehv));
                    bVar.a((q) new b(aVar3, a, cVar, cee2));
                    AppMethodBeat.o(109747);
                    return;
                }
            }
            com.tencent.mm.plugin.story.g.f fVar = com.tencent.mm.plugin.story.g.f.sbT;
            com.tencent.mm.plugin.story.g.f.cAh();
            lVar = com.tencent.mm.plugin.story.f.l.sac;
            com.tencent.mm.plugin.story.f.l.lf(cVar.saW.xDa);
            cVar.a(h.Fail);
            AppMethodBeat.o(109747);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<c> {
        public static final b saV = new b();

        static {
            AppMethodBeat.i(109738);
            AppMethodBeat.o(109738);
        }

        b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109737);
            c cVar = new c();
            AppMethodBeat.o(109737);
            return cVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$1$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class d implements com.tencent.mm.loader.g.f<c> {
        final /* synthetic */ c sba;
        final /* synthetic */ com.tencent.mm.plugin.story.h.d sbb;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$1$1$onLoaderFin$1"})
        /* renamed from: com.tencent.mm.plugin.story.proxy.c$d$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ d sbc;

            AnonymousClass1(d dVar) {
                this.sbc = dVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109748);
                com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
                com.tencent.mm.plugin.story.h.d ls = com.tencent.mm.plugin.story.model.j.a.cxY().ls(this.sbc.sbb.xDa);
                if (ls != null) {
                    int i = ls.field_mixFlag;
                    com.tencent.mm.plugin.story.h.a.d dVar = com.tencent.mm.plugin.story.h.a.d.sdv;
                    if (com.tencent.mm.ab.b.cf(i, com.tencent.mm.plugin.story.h.a.d.cBx())) {
                        this.sbc.sba.a(ls);
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(109748);
                return yVar;
            }
        }

        d(c cVar, com.tencent.mm.plugin.story.h.d dVar) {
            this.sba = cVar;
            this.sbb = dVar;
        }

        public final /* synthetic */ void a(com.tencent.mm.loader.g.c cVar, h hVar) {
            AppMethodBeat.i(109749);
            c cVar2 = (c) cVar;
            a.f.b.j.p(cVar2, "task");
            a.f.b.j.p(hVar, "status");
            a aVar = c.saU;
            ab.i(a.getTAG(), "reStart next work! status " + hVar + ' ' + cVar2);
            if (hVar == h.OK) {
                this.sba.czM();
                AppMethodBeat.o(109749);
                return;
            }
            if (hVar == h.Wait) {
                com.tencent.mm.ab.b.a(60000, (a.f.a.a) new AnonymousClass1(this));
            }
            AppMethodBeat.o(109749);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$2$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class e implements com.tencent.mm.loader.g.f<c> {
        final /* synthetic */ c sba;
        final /* synthetic */ com.tencent.mm.plugin.story.h.d sbb;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/proxy/StoryMixHandler$reStartMix$2$1$onLoaderFin$1"})
        /* renamed from: com.tencent.mm.plugin.story.proxy.c$e$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ e sbd;

            AnonymousClass1(e eVar) {
                this.sbd = eVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109750);
                com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
                com.tencent.mm.plugin.story.h.d ls = com.tencent.mm.plugin.story.model.j.a.cxY().ls(this.sbd.sbb.xDa);
                if (ls != null) {
                    int i = ls.field_mixFlag;
                    com.tencent.mm.plugin.story.h.a.d dVar = com.tencent.mm.plugin.story.h.a.d.sdv;
                    if (com.tencent.mm.ab.b.cf(i, com.tencent.mm.plugin.story.h.a.d.cBx())) {
                        this.sbd.sba.a(ls);
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(109750);
                return yVar;
            }
        }

        e(c cVar, com.tencent.mm.plugin.story.h.d dVar) {
            this.sba = cVar;
            this.sbb = dVar;
        }

        public final /* synthetic */ void a(com.tencent.mm.loader.g.c cVar, h hVar) {
            AppMethodBeat.i(109751);
            c cVar2 = (c) cVar;
            a.f.b.j.p(cVar2, "task");
            a.f.b.j.p(hVar, "status");
            a aVar = c.saU;
            ab.i(a.getTAG(), "reStart next work! status " + hVar + ' ' + cVar2);
            if (hVar == h.OK) {
                this.sba.a(this.sbb);
                AppMethodBeat.o(109751);
                return;
            }
            if (hVar == h.Wait) {
                com.tencent.mm.ab.b.a(60000, (a.f.a.a) new AnonymousClass1(this));
            }
            AppMethodBeat.o(109751);
        }
    }

    private c() {
        AppMethodBeat.i(109754);
        this.liD = new com.tencent.mm.loader.g.d(new com.tencent.mm.loader.g.a.g(new com.tencent.mm.loader.g.a.a(5), new com.tencent.mm.loader.g.a.h(), "storyMixTask"));
        AppMethodBeat.o(109754);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(109755);
        AppMethodBeat.o(109755);
    }

    public final boolean czM() {
        AppMethodBeat.i(109752);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.h.d cBH = com.tencent.mm.plugin.story.model.j.a.cxY().cBH();
        if (cBH != null) {
            ab.i(TAG, "reStart background mix1 " + cBH.xDa + " it " + cBH);
            this.liD.a(new c(cBH), new d(this, cBH));
            AppMethodBeat.o(109752);
        } else {
            ab.d(TAG, "mix task is empty");
            AppMethodBeat.o(109752);
        }
        return true;
    }

    public final boolean a(com.tencent.mm.plugin.story.h.d dVar) {
        AppMethodBeat.i(109753);
        a.f.b.j.p(dVar, "storyEditorItem");
        ab.i(TAG, "reStart background mix2 " + dVar.xDa + " it " + dVar);
        this.liD.a(new c(dVar), new e(this, dVar));
        AppMethodBeat.o(109753);
        return true;
    }
}
