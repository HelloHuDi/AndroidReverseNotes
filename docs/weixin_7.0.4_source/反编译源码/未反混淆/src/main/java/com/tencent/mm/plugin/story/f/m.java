package com.tencent.mm.plugin.story.f;

import a.a.t;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J,\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class m implements f, com.tencent.mm.plugin.story.d.a.a {
    private static final String TAG = TAG;
    public static final a sal = new a();
    private String igi = "";
    private boolean rFn;
    private long rXZ;
    private long rYa;
    private long rYb;
    private int rYc = 1;
    final com.tencent.mm.plugin.story.d.a.b sak;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ m sam;

        b(m mVar) {
            this.sam = mVar;
        }

        public final void run() {
            AppMethodBeat.i(138818);
            final ArrayList arrayList = new ArrayList();
            final a.f.b.u.c cVar = new a.f.b.u.c();
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            String a = this.sam.igi;
            String a2 = this.sam.igi;
            com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
            cVar.AVE = k.a(cxT, a, bo.isEqual(a2, com.tencent.mm.plugin.story.model.j.a.cnk()), this.sam.rYb);
            if ((!((Collection) ((List) cVar.AVE)).isEmpty() ? 1 : null) != null) {
                this.sam.rYa = ((com.tencent.mm.plugin.story.h.j) t.fL((List) cVar.AVE)).field_storyID;
            } else {
                aVar = j.rST;
                cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                a = this.sam.igi;
                a2 = this.sam.igi;
                aVar2 = j.rST;
                arrayList.addAll(cxT.bw(a, bo.isEqual(a2, com.tencent.mm.plugin.story.model.j.a.cnk())));
            }
            a aVar3 = m.sal;
            ab.d(m.TAG, "localCachedMinId=" + this.sam.rYa + " infos.size=" + ((List) cVar.AVE).size() + " localMinId=" + this.sam.rYb);
            com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                final /* synthetic */ b san;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(138817);
                    this.san.sam.sak.f((List) cVar.AVE, arrayList.isEmpty());
                    y yVar = y.AUy;
                    AppMethodBeat.o(138817);
                    return yVar;
                }
            });
            AppMethodBeat.o(138818);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ m sam;

        c(m mVar) {
            this.sam = mVar;
        }

        public final void run() {
            AppMethodBeat.i(138819);
            this.sam.le(this.sam.rYa);
            this.sam.cxm();
            if (this.sam.rYc > 0) {
                this.sam.cxk();
            }
            AppMethodBeat.o(138819);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ m sam;

        d(m mVar) {
            this.sam = mVar;
        }

        public final void run() {
            AppMethodBeat.i(138820);
            this.sam.le(this.sam.rYa);
            this.sam.cxm();
            if (this.sam.rYc > 0) {
                this.sam.cxk();
            }
            AppMethodBeat.o(138820);
        }
    }

    public m(com.tencent.mm.plugin.story.d.a.b bVar) {
        a.f.b.j.p(bVar, "view");
        AppMethodBeat.i(138828);
        this.sak = bVar;
        AppMethodBeat.o(138828);
    }

    static {
        AppMethodBeat.i(138829);
        AppMethodBeat.o(138829);
    }

    public final void onCreate(String str) {
        AppMethodBeat.i(138821);
        a.f.b.j.p(str, "userName");
        this.igi = str;
        le(this.rYa);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(273, (f) this);
        RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(764, (f) this);
        AppMethodBeat.o(138821);
    }

    public final void le(long j) {
        AppMethodBeat.i(138822);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
        com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cyd();
        this.rYb = cxT.F(j, com.tencent.mm.plugin.story.model.o.a.aaC(this.igi));
        com.tencent.mm.plugin.story.f.b.a aVar3 = b.rYk;
        ab.d(b.TAG, "localMinId=" + this.rYb + ", respMaxId=" + this.rXZ);
        AppMethodBeat.o(138822);
    }

    public final void bMO() {
        AppMethodBeat.i(138823);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(273, (f) this);
        RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(764, (f) this);
        AppMethodBeat.o(138823);
    }

    public final void cxk() {
        AppMethodBeat.i(138824);
        this.rYc--;
        ab.i(TAG, "loadNpData username=" + this.igi + " maxId=" + this.rXZ);
        if (!this.rFn) {
            com.tencent.mm.kernel.b RO = g.RO();
            a.f.b.j.o(RO, "MMKernel.network()");
            p Rg = RO.Rg();
            String str = this.igi;
            long j = this.rXZ;
            String str2 = this.igi;
            com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
            com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
            Rg.d((com.tencent.mm.ai.m) new com.tencent.mm.plugin.story.model.a.j(str, j, bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk()), "", com.tencent.mm.plugin.story.h.a.sdl));
        }
        AppMethodBeat.o(138824);
    }

    public final void cxl() {
        AppMethodBeat.i(138825);
        ab.i(TAG, "loadFpData username=" + this.igi + " maxId=" + this.rXZ);
        com.tencent.mm.kernel.b RO = g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        p Rg = RO.Rg();
        String str = this.igi;
        String str2 = this.igi;
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
        Rg.d((com.tencent.mm.ai.m) new com.tencent.mm.plugin.story.model.a.j(str, 0, bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk()), "", com.tencent.mm.plugin.story.h.a.sdl));
        AppMethodBeat.o(138825);
    }

    public final void cxm() {
        AppMethodBeat.i(138826);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new b(this));
        AppMethodBeat.o(138826);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(138827);
        if (mVar instanceof com.tencent.mm.plugin.story.model.a.j) {
            int i3 = ((com.tencent.mm.plugin.story.model.a.j) mVar).cvd;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            if (i3 == com.tencent.mm.plugin.story.h.a.sdl) {
                boolean z;
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
                                this.sak.cxn();
                            }
                            this.rXZ = ((com.tencent.mm.plugin.story.model.a.j) mVar).qKi;
                            com.tencent.mm.plugin.story.model.j.a aVar3;
                            if (((com.tencent.mm.plugin.story.model.a.j) mVar).qIW) {
                                aVar3 = j.rST;
                                com.tencent.mm.plugin.story.model.j.a.cno().post(new d(this));
                            } else {
                                aVar3 = j.rST;
                                com.tencent.mm.plugin.story.model.j.a.cno().post(new c(this));
                            }
                            ab.d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
                            AppMethodBeat.o(138827);
                            return;
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
                ab.d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
                AppMethodBeat.o(138827);
                return;
            }
        }
        if (mVar instanceof com.tencent.mm.plugin.story.model.a.g) {
            com.tencent.mm.plugin.story.model.a.a cyX = ((com.tencent.mm.plugin.story.model.a.g) mVar).cyX();
            if (cyX != null) {
                if (cyX instanceof com.tencent.mm.plugin.story.model.a.l) {
                    com.tencent.mm.plugin.story.f.b.a aVar4 = b.rYk;
                    ab.i(b.TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((com.tencent.mm.plugin.story.model.a.g) mVar).cNE + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                    if (i2 == 0) {
                        com.tencent.mm.plugin.story.model.n.a aVar5 = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.fK(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE, ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                        cxm();
                    }
                }
                AppMethodBeat.o(138827);
                return;
            }
        }
        AppMethodBeat.o(138827);
    }
}
