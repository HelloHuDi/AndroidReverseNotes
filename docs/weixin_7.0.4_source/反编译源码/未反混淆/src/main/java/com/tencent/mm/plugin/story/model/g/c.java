package com.tencent.mm.plugin.story.model.g;

import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\n\u0010\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0006\u0010\u0019\u001a\u00020\bJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u0015\u001a\u00020\bJ,\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
public final class c implements com.tencent.mm.ai.f {
    public static final a rXO = new a();
    private final HashSet<j> listeners = new HashSet();
    public com.tencent.mm.loader.g.d<e> rXA = new com.tencent.mm.loader.g.d(new com.tencent.mm.loader.g.a.g(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.h(), "storyUpload"));
    public com.tencent.mm.loader.g.d<a> rXK = new com.tencent.mm.loader.g.d(new com.tencent.mm.loader.g.a.g(new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.h(), "storyPost"));
    public a.f.a.a<y> rXL;
    public final f rXM = new f(this);
    public final h rXN = new h();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ c rXP;
        final /* synthetic */ j rXQ;

        b(c cVar, j jVar) {
            this.rXP = cVar;
            this.rXQ = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109450);
            if (this.rXQ != null) {
                this.rXP.listeners.add(this.rXQ);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109450);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class h implements com.tencent.mm.loader.g.f<e> {
        h() {
        }

        public final /* synthetic */ void a(com.tencent.mm.loader.g.c cVar, com.tencent.mm.loader.g.h hVar) {
            AppMethodBeat.i(109456);
            a.f.b.j.p((e) cVar, "task");
            a.f.b.j.p(hVar, "status");
            AppMethodBeat.o(109456);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/upload/UploadManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ int rXD;
        final /* synthetic */ boolean rXE;
        final /* synthetic */ c rXP;

        c(c cVar, int i, boolean z) {
            this.rXP = cVar;
            this.rXD = i;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109451);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (com.tencent.mm.plugin.story.model.j.a.cnn()) {
                ab.e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (j cwW : this.rXP.listeners) {
                    cwW.cwW();
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109451);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ int rXD;
        final /* synthetic */ boolean rXE = false;
        final /* synthetic */ c rXP;

        d(c cVar, int i) {
            this.rXP = cVar;
            this.rXD = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109452);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (com.tencent.mm.plugin.story.model.j.a.cnn()) {
                ab.e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (j cwX : this.rXP.listeners) {
                    cwX.cwX();
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109452);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends k implements a.f.a.a<y> {
        final /* synthetic */ c rXP;
        final /* synthetic */ j rXQ;

        g(c cVar, j jVar) {
            this.rXP = cVar;
            this.rXQ = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109455);
            if (this.rXQ != null) {
                this.rXP.listeners.remove(this.rXQ);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109455);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
    public static final class f implements com.tencent.mm.loader.g.f<a> {
        final /* synthetic */ c rXP;

        f(c cVar) {
            this.rXP = cVar;
        }

        public final /* synthetic */ void a(com.tencent.mm.loader.g.c cVar, com.tencent.mm.loader.g.h hVar) {
            AppMethodBeat.i(109454);
            a aVar = (a) cVar;
            a.f.b.j.p(aVar, "task");
            a.f.b.j.p(hVar, "status");
            if (hVar == com.tencent.mm.loader.g.h.OK) {
                this.rXP.checkPost();
                AppMethodBeat.o(109454);
                return;
            }
            c.a(this.rXP, (int) aVar.rXz.xDa);
            AppMethodBeat.o(109454);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ int rXD;
        final /* synthetic */ c rXP;

        e(c cVar, int i) {
            this.rXP = cVar;
            this.rXD = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109453);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (com.tencent.mm.plugin.story.model.j.a.cnn()) {
                ab.e("MicroMsg.StoryUploadTask", "is invalid to getSnsInfoStorage");
            } else {
                for (j EI : this.rXP.listeners) {
                    EI.EI(this.rXD);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109453);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(109466);
        AppMethodBeat.o(109466);
    }

    public c() {
        AppMethodBeat.i(109465);
        AppMethodBeat.o(109465);
    }

    public final void checkPost() {
        AppMethodBeat.i(109457);
        czw();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.j cCc = com.tencent.mm.plugin.story.model.j.a.cxT().cCc();
        if (cCc == null) {
            ab.d("MicroMsg.StoryUploadTask", "All has post");
            AppMethodBeat.o(109457);
            return;
        }
        ab.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + cCc.field_storyID + ' ' + ((int) cCc.xDa) + ' ' + cCc.field_userName + ' ' + cCc.cBU().eRu);
        this.rXK.a((com.tencent.mm.loader.g.c) new a(cCc, this.rXA));
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.EY((int) cCc.xDa).co(bo.anU());
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.EY((int) cCc.xDa).cG((long) at.gC(ah.getContext()));
        AppMethodBeat.o(109457);
    }

    private static void czw() {
        AppMethodBeat.i(109458);
        com.tencent.mm.plugin.story.proxy.c.a aVar = com.tencent.mm.plugin.story.proxy.c.saU;
        com.tencent.mm.plugin.story.proxy.c.a.czN().czM();
        AppMethodBeat.o(109458);
    }

    public final void e(a.f.a.a<y> aVar) {
        AppMethodBeat.i(109459);
        a.f.b.j.p(aVar, "onFakeDataUpdate");
        this.rXL = aVar;
        AppMethodBeat.o(109459);
    }

    public final void czx() {
        AppMethodBeat.i(109460);
        a.f.a.a aVar = this.rXL;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(109460);
            return;
        }
        AppMethodBeat.o(109460);
    }

    public final void a(j jVar) {
        AppMethodBeat.i(109461);
        com.tencent.mm.ab.b.a(new b(this, jVar));
        AppMethodBeat.o(109461);
    }

    public final void b(j jVar) {
        AppMethodBeat.i(109462);
        com.tencent.mm.ab.b.a(new g(this, jVar));
        AppMethodBeat.o(109462);
    }

    private final void ah(int i, boolean z) {
        AppMethodBeat.i(109463);
        com.tencent.mm.ab.b.a(new c(this, i, z));
        AppMethodBeat.o(109463);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        m mVar2;
        AppMethodBeat.i(109464);
        if (mVar instanceof com.tencent.mm.plugin.story.model.a.h) {
            mVar2 = mVar;
        } else {
            mVar2 = null;
        }
        com.tencent.mm.plugin.story.model.a.h hVar = (com.tencent.mm.plugin.story.model.a.h) mVar2;
        if (hVar != null) {
            if (i == 4 || i2 == 0) {
                ah(hVar.cNE, true);
                y yVar;
                try {
                    com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(hVar.cNE);
                    if (Fe != null) {
                        com.tencent.mm.plugin.story.g.h hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.EY(hVar.cNE).fQ(String.valueOf(Fe.field_storyID));
                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.EY(hVar.cNE).fO(((cek) Fe.cBR().xeA.wbK.get(0)).Url);
                        com.tencent.mm.plugin.story.g.h hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.EY(hVar.cNE).cp(bo.anU());
                        hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.EZ(hVar.cNE);
                        yVar = y.AUy;
                        AppMethodBeat.o(109464);
                        return;
                    }
                    AppMethodBeat.o(109464);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.StoryUploadTask", e, "upload error", new Object[0]);
                    yVar = y.AUy;
                    AppMethodBeat.o(109464);
                    return;
                }
            }
            ah(hVar.cNE, false);
        }
        AppMethodBeat.o(109464);
    }

    public static final /* synthetic */ void a(c cVar, int i) {
        AppMethodBeat.i(109467);
        com.tencent.mm.ab.b.a(new d(cVar, i));
        AppMethodBeat.o(109467);
    }
}
