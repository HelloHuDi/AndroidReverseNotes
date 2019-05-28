package com.tencent.mm.plugin.story.f;

import a.a.t;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J,\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class b implements com.tencent.mm.ai.f, com.tencent.mm.plugin.story.d.a.e {
    private static final String TAG = TAG;
    public static final a rYk = new a();
    private String igi = "";
    private boolean rFn;
    private long rXZ;
    private long rYa;
    private long rYb;
    private final LinkedHashMap<String, ArrayList<h>> rYh = new LinkedHashMap();
    private int rYi;
    final com.tencent.mm.plugin.story.d.a.f rYj;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ b rYl;

        b(b bVar) {
            this.rYl = bVar;
        }

        public final void run() {
            AppMethodBeat.i(109499);
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            List<com.tencent.mm.plugin.story.h.j> a = k.a(com.tencent.mm.plugin.story.model.j.a.cxT(), this.rYl.igi, this.rYl.rYb);
            if (!a.isEmpty()) {
                this.rYl.rYa = ((com.tencent.mm.plugin.story.h.j) t.fL(a)).field_storyID;
            }
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.mm.plugin.story.h.j jVar : a) {
                String cBQ;
                com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
                i cxZ = com.tencent.mm.plugin.story.model.j.a.cxZ();
                com.tencent.mm.plugin.story.e.b.a aVar3 = com.tencent.mm.plugin.story.e.b.rRO;
                h aaZ = cxZ.aaZ(com.tencent.mm.plugin.story.e.b.a.j(Integer.valueOf(jVar.field_createTime)));
                a aVar4 = b.rYk;
                String access$getTAG$cp = b.TAG;
                StringBuilder append = new StringBuilder("loadDBData rawLocalId=").append((int) jVar.xDa).append(" rawStoryId=").append(jVar.field_storyID).append(" date=");
                if (aaZ != null) {
                    cBQ = aaZ.cBQ();
                } else {
                    cBQ = null;
                }
                ab.d(access$getTAG$cp, append.append(cBQ).append(" count=").append(aaZ != null ? Integer.valueOf(aaZ.field_count) : null).toString());
                if (aaZ != null) {
                    aVar2 = j.rST;
                    Object Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe((int) jVar.xDa);
                    if (Fe == null) {
                        Fe = new com.tencent.mm.plugin.story.h.j();
                    }
                    a.f.b.j.p(Fe, "<set-?>");
                    aaZ.rXz = Fe;
                    if (!arrayList2.contains(aaZ.cBQ())) {
                        arrayList.add(aaZ);
                        arrayList2.add(aaZ.cBQ());
                    }
                }
            }
            a aVar5 = b.rYk;
            ab.d(b.TAG, "localCachedMinId=" + this.rYl.rYa + " infos.size=" + arrayList.size() + " localMinId=" + this.rYl.rYb);
            final List a2 = b.a(this.rYl, (List) arrayList);
            com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                final /* synthetic */ b rYm;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(109498);
                    this.rYm.rYl.rYj.du(a2);
                    y yVar = y.AUy;
                    AppMethodBeat.o(109498);
                    return yVar;
                }
            });
            AppMethodBeat.o(109499);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ b rYl;

        c(b bVar) {
            this.rYl = bVar;
        }

        public final void run() {
            AppMethodBeat.i(109502);
            a aVar = b.rYk;
            ab.i(b.TAG, "loadFpData username=" + this.rYl.igi + " maxId=" + this.rYl.rXZ);
            com.tencent.mm.kernel.b RO = g.RO();
            a.f.b.j.o(RO, "MMKernel.network()");
            p Rg = RO.Rg();
            String a = this.rYl.igi;
            long d = this.rYl.rXZ;
            String a2 = this.rYl.igi;
            com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
            Rg.d((m) new com.tencent.mm.plugin.story.model.a.f(a, d, bo.isEqual(a2, com.tencent.mm.plugin.story.model.j.a.cnk())));
            AppMethodBeat.o(109502);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ b rYl;

        e(b bVar) {
            this.rYl = bVar;
        }

        public final void run() {
            AppMethodBeat.i(109504);
            this.rYl.le(this.rYl.rYa);
            this.rYl.cxo();
            AppMethodBeat.o(109504);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ b rYl;

        d(b bVar) {
            this.rYl = bVar;
        }

        public final void run() {
            AppMethodBeat.i(109503);
            a aVar = b.rYk;
            ab.i(b.TAG, "loadNpData username=" + this.rYl.igi + " maxId=" + this.rYl.rXZ);
            if (this.rYl.rYi == 0 && !this.rYl.rFn) {
                b bVar = this.rYl;
                bVar.rYi = bVar.rYi + 1;
                com.tencent.mm.kernel.b RO = g.RO();
                a.f.b.j.o(RO, "MMKernel.network()");
                p Rg = RO.Rg();
                String a = this.rYl.igi;
                long d = this.rYl.rXZ;
                String a2 = this.rYl.igi;
                com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
                Rg.d((m) new com.tencent.mm.plugin.story.model.a.f(a, d, bo.isEqual(a2, com.tencent.mm.plugin.story.model.j.a.cnk())));
            }
            AppMethodBeat.o(109503);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ b rYl;

        f(b bVar) {
            this.rYl = bVar;
        }

        public final void run() {
            AppMethodBeat.i(109505);
            this.rYl.le(this.rYl.rYa);
            this.rYl.cxo();
            AppMethodBeat.o(109505);
        }
    }

    public b(com.tencent.mm.plugin.story.d.a.f fVar) {
        a.f.b.j.p(fVar, "view");
        AppMethodBeat.i(109515);
        this.rYj = fVar;
        AppMethodBeat.o(109515);
    }

    static {
        AppMethodBeat.i(109516);
        AppMethodBeat.o(109516);
    }

    public final void le(long j) {
        AppMethodBeat.i(109506);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
        com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cyd();
        this.rYb = cxT.E(j, com.tencent.mm.plugin.story.model.o.a.aaC(this.igi));
        if (this.rXZ != 0) {
            this.rYb = this.rYb < this.rXZ ? this.rYb : this.rXZ;
        }
        ab.d(TAG, "localMinId=" + this.rYb + ", respMaxId=" + this.rXZ);
        AppMethodBeat.o(109506);
    }

    public final void onCreate(String str) {
        AppMethodBeat.i(109507);
        a.f.b.j.p(str, "userName");
        this.igi = str;
        le(this.rYa);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(191, (com.tencent.mm.ai.f) this);
        RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(3926, (com.tencent.mm.ai.f) this);
        RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(764, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(109507);
    }

    public final void bMO() {
        AppMethodBeat.i(109508);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(191, (com.tencent.mm.ai.f) this);
        RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(3926, (com.tencent.mm.ai.f) this);
        RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(764, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(109508);
    }

    public final void cxo() {
        AppMethodBeat.i(109509);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new b(this));
        AppMethodBeat.o(109509);
    }

    public final void cxl() {
        AppMethodBeat.i(109510);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new c(this));
        AppMethodBeat.o(109510);
    }

    public final void cxk() {
        AppMethodBeat.i(109511);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new d(this));
        AppMethodBeat.o(109511);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(109512);
        if ((mVar instanceof com.tencent.mm.plugin.story.model.a.f) && bo.isEqual(((com.tencent.mm.plugin.story.model.a.f) mVar).userName, this.igi)) {
            boolean z;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            if (i2 != com.tencent.mm.plugin.story.h.a.scI) {
                aVar = com.tencent.mm.plugin.story.h.a.sdm;
                if (i2 != com.tencent.mm.plugin.story.h.a.scJ) {
                    z = false;
                    this.rFn = z;
                    if (this.rFn) {
                        this.rYj.cxn();
                    }
                    com.tencent.mm.plugin.story.model.j.a aVar2;
                    if (((com.tencent.mm.plugin.story.model.a.f) mVar).qIW) {
                        this.rYi = 0;
                        aVar2 = j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cno().post(new f(this));
                    } else {
                        aVar2 = j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cno().post(new e(this));
                    }
                    this.rXZ = ((com.tencent.mm.plugin.story.model.a.f) mVar).qKi;
                    ab.d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2);
                }
            }
            z = true;
            this.rFn = z;
            if (this.rFn) {
            }
            if (((com.tencent.mm.plugin.story.model.a.f) mVar).qIW) {
            }
            this.rXZ = ((com.tencent.mm.plugin.story.model.a.f) mVar).qKi;
            ab.d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2);
        }
        AppMethodBeat.o(109512);
    }
}
