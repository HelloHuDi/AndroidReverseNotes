package com.tencent.mm.plugin.story.model.g;

import a.f.b.k;
import a.l;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.model.p;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0011\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J,\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020\u0019H\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a extends com.tencent.mm.loader.g.c implements com.tencent.mm.ai.f {
    public static final a rXB = new a();
    private final HashSet<j> listeners = new HashSet();
    private final com.tencent.mm.loader.g.d<e> rXA;
    private final g rXy = new g();
    com.tencent.mm.plugin.story.h.j rXz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class f implements com.tencent.mm.loader.g.f<e> {
        final /* synthetic */ a rXC;

        f(a aVar) {
            this.rXC = aVar;
        }

        public final /* synthetic */ void a(com.tencent.mm.loader.g.c cVar, h hVar) {
            AppMethodBeat.i(109431);
            a.f.b.j.p((e) cVar, "task");
            a.f.b.j.p(hVar, "status");
            if (hVar == h.OK) {
                this.rXC.Pa();
                AppMethodBeat.o(109431);
                return;
            }
            this.rXC.a(h.Wait);
            AppMethodBeat.o(109431);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ a rXC;
        final /* synthetic */ int rXD;
        final /* synthetic */ boolean rXE = false;

        d(a aVar, int i) {
            this.rXC = aVar;
            this.rXD = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109429);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (com.tencent.mm.plugin.story.model.j.a.cnn()) {
                ab.e("MicroMsg.StoryPostTask", "is invalid to getstoryInfoStorage");
            } else {
                Iterator it = this.rXC.listeners.iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    if (jVar != null) {
                        jVar.cwW();
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109429);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ a rXC;

        c(a aVar) {
            this.rXC = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109428);
            this.rXC.a(h.Fail);
            a.a(this.rXC, (int) this.rXC.rXz.xDa);
            y yVar = y.AUy;
            AppMethodBeat.o(109428);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ String rVA;
        final /* synthetic */ a rXC;
        final /* synthetic */ String rXF;

        e(a aVar, String str, String str2) {
            this.rXC = aVar;
            this.rVA = str;
            this.rXF = str2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109430);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (com.tencent.mm.plugin.story.model.j.a.cnn()) {
                ab.e("MicroMsg.StoryPostTask", "is invalid to getstoryInfoStorage");
            } else {
                cel a = a.a(this.rXC);
                a.eRu++;
                com.tencent.mm.plugin.story.h.j jVar = this.rXC.rXz;
                byte[] toByteArray = a.toByteArray();
                a.f.b.j.o(toByteArray, "postInfo.toByteArray()");
                jVar.bk(toByteArray);
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXC.rXz.xDa, this.rXC.rXz);
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                if (com.tencent.mm.plugin.story.model.j.a.cxT().abb(((int) this.rXC.rXz.xDa) + '_' + this.rXC.rXz.field_createTime)) {
                    this.rXC.a(h.OK);
                } else {
                    com.tencent.mm.plugin.story.model.a.h hVar = new com.tencent.mm.plugin.story.model.a.h(this.rVA, this.rXF, (int) this.rXC.rXz.xDa);
                    com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
                    a.f.b.j.o(RO, "MMKernel.network()");
                    RO.Rg().a(351, (com.tencent.mm.ai.f) this.rXC);
                    RO = com.tencent.mm.kernel.g.RO();
                    a.f.b.j.o(RO, "MMKernel.network()");
                    RO.Rg().d((m) hVar);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109430);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "invoke"})
    static final class b extends k implements a.f.a.b<Exception, y> {
        final /* synthetic */ a rXC;

        b(a aVar) {
            this.rXC = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(109427);
            Exception exception = (Exception) obj;
            a.f.b.j.p(exception, "it");
            a aVar = this.rXC;
            com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
            a.a(aVar, com.tencent.mm.plugin.story.h.a.scS, "MediaPostInfo parser error:" + exception.getMessage());
            y yVar = y.AUy;
            AppMethodBeat.o(109427);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/PostTask$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class g implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c> {
        g() {
        }

        public final void a(com.tencent.mm.loader.g.c cVar, h hVar) {
            AppMethodBeat.i(109432);
            a.f.b.j.p(cVar, "task");
            a.f.b.j.p(hVar, "status");
            AppMethodBeat.o(109432);
        }
    }

    static {
        AppMethodBeat.i(109440);
        AppMethodBeat.o(109440);
    }

    public a(com.tencent.mm.plugin.story.h.j jVar, com.tencent.mm.loader.g.d<e> dVar) {
        a.f.b.j.p(jVar, "storyInfo");
        a.f.b.j.p(dVar, "uploadQueue");
        AppMethodBeat.i(109439);
        this.rXz = jVar;
        this.rXA = dVar;
        AppMethodBeat.o(109439);
    }

    public static final /* synthetic */ cel a(a aVar) {
        AppMethodBeat.i(109441);
        cel czu = aVar.czu();
        AppMethodBeat.o(109441);
        return czu;
    }

    private final cel czu() {
        AppMethodBeat.i(109433);
        com.tencent.mm.bt.a parseFrom = new cel().parseFrom(this.rXz.field_postBuf);
        if (parseFrom == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
            AppMethodBeat.o(109433);
            throw vVar;
        }
        cel cel = (cel) parseFrom;
        com.tencent.mm.plugin.story.h.j jVar = this.rXz;
        byte[] toByteArray = cel.toByteArray();
        a.f.b.j.o(toByteArray, "postInfo.toByteArray()");
        jVar.bk(toByteArray);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxT().a((int) this.rXz.xDa, this.rXz);
        AppMethodBeat.o(109433);
        return cel;
    }

    public final void Pa() {
        AppMethodBeat.i(109434);
        cel cel = (cel) com.tencent.mm.ab.b.a(new cel(), this.rXz.field_postBuf, new b(this));
        if (cel != null) {
            if (com.tencent.mm.plugin.story.h.j.ac(cel.eRu, cel.wFi)) {
                com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
                bk(com.tencent.mm.plugin.story.h.a.scW, "this item isTimeLimit");
                ab.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + ((int) this.rXz.xDa) + " is die count " + cel.eRu + " time: " + cel.wFi);
                AppMethodBeat.o(109434);
                return;
            }
            int i = cel.wFD;
            com.tencent.mm.plugin.story.h.a.e eVar = com.tencent.mm.plugin.story.h.a.e.sdz;
            if (i == com.tencent.mm.plugin.story.h.a.e.cBz()) {
                cel czu = czu();
                com.tencent.mm.plugin.story.h.a.a aVar2;
                if (com.tencent.mm.plugin.story.h.j.ac(czu.eRu, czu.wFi)) {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    bk(com.tencent.mm.plugin.story.h.a.scW, "this item isTimeLimit");
                    ab.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + ((int) this.rXz.xDa) + " is die ");
                    AppMethodBeat.o(109434);
                    return;
                }
                cfb cBR = this.rXz.cBR();
                com.tencent.mm.plugin.story.model.p.a aVar3 = p.rTj;
                String a = com.tencent.mm.plugin.story.model.p.a.a(cBR, czu.xej);
                ab.i("MicroMsg.StoryPostTask", "startPost content " + a + "  testValue " + ae.gjA);
                if (a.f.b.j.j(a, "")) {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    bk(com.tencent.mm.plugin.story.h.a.scV, "content is error");
                    AppMethodBeat.o(109434);
                    return;
                }
                String str;
                if (ae.gjA) {
                    str = "<Test>Android Test Fail</Test>";
                } else {
                    str = a;
                }
                String str2 = czu.ptv;
                a.f.b.j.o(str2, "postInfo.ClientId");
                com.tencent.mm.ab.b.a(new e(this, str, str2));
                AppMethodBeat.o(109434);
                return;
            }
            com.tencent.mm.plugin.story.h.a.e eVar2 = com.tencent.mm.plugin.story.h.a.e.sdz;
            this.rXA.a(new e(this.rXz), new f(this));
        }
        AppMethodBeat.o(109434);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(109435);
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(351, (com.tencent.mm.ai.f) this);
        a(h.OK);
        AppMethodBeat.o(109435);
    }

    public final String Pc() {
        AppMethodBeat.i(109436);
        String valueOf = String.valueOf((int) this.rXz.xDa);
        AppMethodBeat.o(109436);
        return valueOf;
    }

    static /* synthetic */ void a(a aVar, int i, String str) {
        AppMethodBeat.i(109438);
        aVar.bk(i, str);
        AppMethodBeat.o(109438);
    }

    private final void bk(int i, String str) {
        AppMethodBeat.i(109437);
        ab.i("MicroMsg.StoryPostTask", "processError localId " + ((int) this.rXz.xDa) + " processError " + i + " errMsg: " + str);
        f fVar = f.rXY;
        f.a(this.rXz, i, str, new c(this));
        AppMethodBeat.o(109437);
    }

    public static final /* synthetic */ void a(a aVar, int i) {
        AppMethodBeat.i(109442);
        com.tencent.mm.ab.b.a(new d(aVar, i));
        AppMethodBeat.o(109442);
    }
}
