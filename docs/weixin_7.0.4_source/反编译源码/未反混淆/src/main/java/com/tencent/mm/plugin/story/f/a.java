package com.tencent.mm.plugin.story.f;

import a.a.t;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J,\u0010 \u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\"\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/AlbumFavPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "TAG", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "favorite", "replaced", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class a implements f, com.tencent.mm.plugin.story.d.a.c {
    final String TAG = "MicroMsg.AlbumFavPresenter";
    private String igi = "";
    private boolean rFn;
    private long rXZ;
    long rYa;
    long rYb;
    int rYc;
    final d rYd;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ a rYe;

        c(a aVar) {
            this.rYe = aVar;
        }

        public final void run() {
            AppMethodBeat.i(109488);
            this.rYe.le(this.rYe.rYa);
            this.rYe.cxo();
            if (this.rYe.rYc > 0) {
                this.rYe.cxk();
            }
            AppMethodBeat.o(109488);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ a rYe;

        a(a aVar) {
            this.rYe = aVar;
        }

        public final void run() {
            AppMethodBeat.i(109486);
            final a.f.b.u.c cVar = new a.f.b.u.c();
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            cVar.AVE = k.a(com.tencent.mm.plugin.story.model.j.a.cxT(), this.rYe.rYb);
            if (!((List) cVar.AVE).isEmpty()) {
                this.rYe.rYa = ((com.tencent.mm.plugin.story.h.j) t.fL((List) cVar.AVE)).field_storyID;
            }
            ab.d(this.rYe.TAG, "localCachedMinId=" + this.rYe.rYa + " infos.size=" + ((List) cVar.AVE).size() + " localMinId=" + this.rYe.rYb);
            com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                final /* synthetic */ a rYf;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(109485);
                    d dVar = this.rYf.rYe.rYd;
                    Collection arrayList = new ArrayList();
                    for (Object next : (List) cVar.AVE) {
                        com.tencent.mm.plugin.story.h.j jVar = (com.tencent.mm.plugin.story.h.j) next;
                        Object obj = (jVar.field_storyID == 0 || ((jVar.cBV() && !jVar.cBX()) || jVar.cBW())) ? null : 1;
                        if (obj != null) {
                            arrayList.add(next);
                        }
                    }
                    dVar.du((List) arrayList);
                    y yVar = y.AUy;
                    AppMethodBeat.o(109485);
                    return yVar;
                }
            });
            AppMethodBeat.o(109486);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a rYe;

        b(a aVar) {
            this.rYe = aVar;
        }

        public final void run() {
            AppMethodBeat.i(109487);
            this.rYe.le(this.rYe.rYa);
            this.rYe.cxo();
            if (this.rYe.rYc > 0) {
                this.rYe.cxk();
            }
            AppMethodBeat.o(109487);
        }
    }

    public a(d dVar) {
        a.f.b.j.p(dVar, "view");
        AppMethodBeat.i(109497);
        this.rYd = dVar;
        AppMethodBeat.o(109497);
    }

    /* Access modifiers changed, original: final */
    public final void le(long j) {
        AppMethodBeat.i(109489);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
        aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cyd();
        a.f.b.j.p(this.igi, "userName");
        com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
        int cAR = com.tencent.mm.plugin.story.h.a.scA;
        String str = this.igi;
        String str2 = this.igi;
        com.tencent.mm.plugin.story.model.j.a aVar3 = j.rST;
        this.rYb = cxT.b(j, cAR, str, bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk()));
        if (this.rXZ != 0) {
            this.rYb = this.rYb < this.rXZ ? this.rYb : this.rXZ;
        }
        ab.d(this.TAG, "localMinId=" + this.rYb + ", respMaxId=" + this.rXZ);
        AppMethodBeat.o(109489);
    }

    public final void onCreate(String str) {
        AppMethodBeat.i(109490);
        a.f.b.j.p(str, "userName");
        this.igi = str;
        le(this.rYa);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(273, (f) this);
        AppMethodBeat.o(109490);
    }

    public final void bMO() {
        AppMethodBeat.i(109491);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(273, (f) this);
        AppMethodBeat.o(109491);
    }

    public final void cxo() {
        AppMethodBeat.i(109492);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new a(this));
        AppMethodBeat.o(109492);
    }

    public final void cxk() {
        AppMethodBeat.i(109493);
        this.rYc--;
        ab.i(this.TAG, "loadNpData username=" + this.igi + " maxId=" + this.rXZ);
        if (!this.rFn) {
            com.tencent.mm.kernel.b RO = g.RO();
            a.f.b.j.o(RO, "MMKernel.network()");
            p Rg = RO.Rg();
            String str = this.igi;
            long j = this.rXZ;
            String str2 = this.igi;
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
            Rg.d((m) new com.tencent.mm.plugin.story.model.a.j(str, j, bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk()), "", com.tencent.mm.plugin.story.h.a.sdk));
        }
        AppMethodBeat.o(109493);
    }

    public final void cxl() {
        AppMethodBeat.i(109494);
        ab.i(this.TAG, "loadFpData username=" + this.igi + " maxId=" + this.rXZ);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        p Rg = RO.Rg();
        String str = this.igi;
        String str2 = this.igi;
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
        Rg.d((m) new com.tencent.mm.plugin.story.model.a.j(str, 0, bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk()), "", com.tencent.mm.plugin.story.h.a.sdk));
        AppMethodBeat.o(109494);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(109495);
        ab.i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str + ' ' + mVar);
        if ((mVar instanceof com.tencent.mm.plugin.story.model.a.j) && bo.isEqual(((com.tencent.mm.plugin.story.model.a.j) mVar).userName, this.igi)) {
            int i3 = ((com.tencent.mm.plugin.story.model.a.j) mVar).cvd;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            if (i3 == com.tencent.mm.plugin.story.h.a.sdk) {
                boolean z;
                ab.d(this.TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + ' ' + ((com.tencent.mm.plugin.story.model.a.j) mVar).qKi);
                long j = ((com.tencent.mm.plugin.story.model.a.j) mVar).qKi;
                com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                if (i2 != com.tencent.mm.plugin.story.h.a.scI) {
                    aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                    if (!(i2 == com.tencent.mm.plugin.story.h.a.scJ || (i == 0 && i2 == 0 && j == 0))) {
                        aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                        if (!(i2 == com.tencent.mm.plugin.story.h.a.scH && j == 0)) {
                            z = false;
                            this.rFn = z;
                            if (this.rFn) {
                                this.rYd.cxn();
                            }
                            this.rXZ = ((com.tencent.mm.plugin.story.model.a.j) mVar).qKi;
                            com.tencent.mm.plugin.story.model.j.a aVar3;
                            if (((com.tencent.mm.plugin.story.model.a.j) mVar).qIW) {
                                aVar3 = j.rST;
                                com.tencent.mm.plugin.story.model.j.a.cno().post(new c(this));
                            } else {
                                aVar3 = j.rST;
                                com.tencent.mm.plugin.story.model.j.a.cno().post(new b(this));
                            }
                            ab.d(this.TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
                        }
                    }
                }
                z = true;
                this.rFn = z;
                if (this.rFn) {
                }
                this.rXZ = ((com.tencent.mm.plugin.story.model.a.j) mVar).qKi;
                if (((com.tencent.mm.plugin.story.model.a.j) mVar).qIW) {
                }
                ab.d(this.TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
            }
        }
        AppMethodBeat.o(109495);
    }

    public final void a(com.tencent.mm.plugin.story.h.j jVar) {
        AppMethodBeat.i(138798);
        a.f.b.j.p(jVar, "storyInfo");
        ab.i(this.TAG, "LogStory: setFavorite storyId:" + jVar.field_storyID + " localid:" + ((int) jVar.xDa) + " targetFavorite:true replacedStory:" + null);
        com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
        com.tencent.mm.plugin.story.model.n.a.h(jVar.field_storyID, (int) jVar.xDa, true);
        h hVar = h.scu;
        h.a(1, String.valueOf(jVar.field_storyID), 0, 0, 1);
        AppMethodBeat.o(138798);
    }
}
