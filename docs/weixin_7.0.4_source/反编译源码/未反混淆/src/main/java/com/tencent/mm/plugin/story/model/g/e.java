package com.tencent.mm.plugin.story.model.g;

import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.g;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e extends com.tencent.mm.loader.g.c {
    private static final String TAG = TAG;
    public static final a rXU = new a();
    private j rXz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
    public static final class d implements com.tencent.mm.plugin.story.model.g.a {
        final /* synthetic */ e rXX;

        d(e eVar) {
            this.rXX = eVar;
        }

        public final void a(int i, boolean z, g gVar) {
            AppMethodBeat.i(109478);
            a.f.b.j.p(gVar, "upload");
            h hVar = h.scu;
            h.cAC().aW((long) i);
            hVar = h.scu;
            ak cAC = h.cAC();
            long currentTimeMillis = System.currentTimeMillis();
            h hVar2 = h.scu;
            cAC.aV(currentTimeMillis - h.cAC().Fu());
            hVar = h.scu;
            h.cAD();
            if (z) {
                this.rXX.a(com.tencent.mm.loader.g.h.OK);
                AppMethodBeat.o(109478);
                return;
            }
            this.rXX.a(com.tencent.mm.loader.g.h.Fail);
            AppMethodBeat.o(109478);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        public static final b rXV = new b();

        static {
            AppMethodBeat.i(109476);
            AppMethodBeat.o(109476);
        }

        b() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        public static final c rXW = new c();

        static {
            AppMethodBeat.i(109477);
            AppMethodBeat.o(109477);
        }

        c() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return y.AUy;
        }
    }

    public e(j jVar) {
        a.f.b.j.p(jVar, "storyInfo");
        AppMethodBeat.i(109481);
        this.rXz = jVar;
        AppMethodBeat.o(109481);
    }

    static {
        AppMethodBeat.i(109482);
        AppMethodBeat.o(109482);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Pa() {
        AppMethodBeat.i(109479);
        cel cBU = this.rXz.cBU();
        cek cek = (cek) this.rXz.cBR().xeA.wbK.get(0);
        com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
        String aat = com.tencent.mm.plugin.story.model.l.aat(cek.Id);
        lVar = com.tencent.mm.plugin.story.model.l.rTg;
        String aas = com.tencent.mm.plugin.story.model.l.aas(cek.Id);
        int i = cBU.wFD;
        com.tencent.mm.plugin.story.h.a.e eVar = com.tencent.mm.plugin.story.h.a.e.sdz;
        f fVar;
        if (i == com.tencent.mm.plugin.story.h.a.e.cBz()) {
            a(com.tencent.mm.loader.g.h.OK);
            AppMethodBeat.o(109479);
        } else if (cBU.eRu > 5) {
            fVar = f.rXY;
            f.a(this.rXz, -1, "", b.rXV);
            a(com.tencent.mm.loader.g.h.Fail);
            AppMethodBeat.o(109479);
        } else if (com.tencent.mm.vfs.e.asZ(aat) < 0) {
            fVar = f.rXY;
            f.a(this.rXz, -1, "", c.rXW);
            a(com.tencent.mm.loader.g.h.Fail);
            AppMethodBeat.o(109479);
        } else {
            Object obj;
            com.tencent.mm.plugin.story.h.a.e eVar2 = com.tencent.mm.plugin.story.h.a.e.sdz;
            cBU.wFD = com.tencent.mm.plugin.story.h.a.e.cBB();
            j jVar = this.rXz;
            byte[] toByteArray = cBU.toByteArray();
            a.f.b.j.o(toByteArray, "postInfo.toByteArray()");
            jVar.bk(toByteArray);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXz.xDa, this.rXz);
            s sVar = s.rTV;
            String a = s.a(cek);
            com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class);
            a.f.b.j.o(K, "MMKernel.service<IConfig…onfigService::class.java)");
            if (bo.getInt(((com.tencent.mm.plugin.zero.b.a) K).Nu().getValue("StoryCheckSendVideoBitrateExceed"), 0) == 1 && !bo.isNullOrNil(a)) {
                ab.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(a)));
                com.tencent.mm.plugin.story.c.a.c.a aVar2 = (com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw();
                if (a == null) {
                    a.f.b.j.dWJ();
                }
                if (aVar2.aab(a)) {
                    ab.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(a)));
                    com.tencent.mm.plugin.story.g.g gVar = com.tencent.mm.plugin.story.g.g.sbU;
                    com.tencent.mm.plugin.story.g.g.cAk();
                    aVar2.aaa(a);
                    String str = a + ".remux";
                    ab.i(TAG, "remux outputFilepath:".concat(String.valueOf(str)));
                    long yz = bo.yz();
                    int remuxing = SightVideoJNI.remuxing(a, str, aVar2.eTi, aVar2.eTj, aVar2.videoBitrate, com.tencent.mm.plugin.sight.base.b.qwY, 8, 2, 25.0f, (float) aVar2.eTk, null, 0, com.tencent.mm.plugin.sight.base.b.qwX);
                    ab.i(TAG, "remux cost:" + bo.az(yz) + "ms, ret:" + remuxing);
                    if (remuxing >= 0) {
                        com.tencent.mm.vfs.e.aQ(str, a);
                    } else {
                        cBU.eRu++;
                        j jVar2 = this.rXz;
                        toByteArray = cBU.toByteArray();
                        a.f.b.j.o(toByteArray, "postInfo.toByteArray()");
                        jVar2.bk(toByteArray);
                        com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXz.xDa, this.rXz);
                        com.tencent.mm.vfs.e.deleteFile(str);
                        a(com.tencent.mm.loader.g.h.Fail);
                        obj = 1;
                        if (obj == null) {
                            h hVar = h.scu;
                            h.cAC().aV(System.currentTimeMillis());
                            new b(this.rXz, aat, aas, new d(this)).cne();
                        }
                        AppMethodBeat.o(109479);
                    }
                }
                ab.i(TAG, "checkRemuxVideo, no need remux");
            }
            obj = null;
            if (obj == null) {
            }
            AppMethodBeat.o(109479);
        }
    }

    public final String Pc() {
        AppMethodBeat.i(109480);
        String valueOf = String.valueOf((int) this.rXz.xDa);
        AppMethodBeat.o(109480);
        return valueOf;
    }
}
