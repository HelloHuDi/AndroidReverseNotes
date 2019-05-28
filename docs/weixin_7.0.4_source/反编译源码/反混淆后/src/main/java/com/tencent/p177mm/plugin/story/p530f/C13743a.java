package com.tencent.p177mm.plugin.story.p530f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p744a.C35194j;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C22176d;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C35174c;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41381u.C31596c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J,\u0010 \u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\"\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/AlbumFavPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "TAG", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "favorite", "replaced", "updateLocalMinId", "lastId", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.a */
public final class C13743a implements C1202f, C35174c {
    final String TAG = "MicroMsg.AlbumFavPresenter";
    private String igi = "";
    private boolean rFn;
    private long rXZ;
    long rYa;
    long rYb;
    int rYc;
    final C22176d rYd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.a$c */
    static final class C13744c implements Runnable {
        final /* synthetic */ C13743a rYe;

        C13744c(C13743a c13743a) {
            this.rYe = c13743a;
        }

        public final void run() {
            AppMethodBeat.m2504i(109488);
            this.rYe.mo25960le(this.rYe.rYa);
            this.rYe.cxo();
            if (this.rYe.rYc > 0) {
                this.rYe.cxk();
            }
            AppMethodBeat.m2505o(109488);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.a$a */
    static final class C13745a implements Runnable {
        final /* synthetic */ C13743a rYe;

        C13745a(C13743a c13743a) {
            this.rYe = c13743a;
        }

        public final void run() {
            AppMethodBeat.m2504i(109486);
            final C31596c c31596c = new C31596c();
            C4133a c4133a = C43644j.rST;
            c31596c.AVE = C46275k.m86716a(C4133a.cxT(), this.rYe.rYb);
            if (!((List) c31596c.AVE).isEmpty()) {
                this.rYe.rYa = ((C39879j) C25035t.m39339fL((List) c31596c.AVE)).field_storyID;
            }
            C4990ab.m7410d(this.rYe.TAG, "localCachedMinId=" + this.rYe.rYa + " infos.size=" + ((List) c31596c.AVE).size() + " localMinId=" + this.rYe.rYb);
            C8902b.m16042a(new C31214a<C37091y>(this) {
                final /* synthetic */ C13745a rYf;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(109485);
                    C22176d c22176d = this.rYf.rYe.rYd;
                    Collection arrayList = new ArrayList();
                    for (Object next : (List) c31596c.AVE) {
                        C39879j c39879j = (C39879j) next;
                        Object obj = (c39879j.field_storyID == 0 || ((c39879j.cBV() && !c39879j.cBX()) || c39879j.cBW())) ? null : 1;
                        if (obj != null) {
                            arrayList.add(next);
                        }
                    }
                    c22176d.mo37733du((List) arrayList);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(109485);
                    return c37091y;
                }
            });
            AppMethodBeat.m2505o(109486);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.a$b */
    static final class C13746b implements Runnable {
        final /* synthetic */ C13743a rYe;

        C13746b(C13743a c13743a) {
            this.rYe = c13743a;
        }

        public final void run() {
            AppMethodBeat.m2504i(109487);
            this.rYe.mo25960le(this.rYe.rYa);
            this.rYe.cxo();
            if (this.rYe.rYc > 0) {
                this.rYe.cxk();
            }
            AppMethodBeat.m2505o(109487);
        }
    }

    public C13743a(C22176d c22176d) {
        C25052j.m39376p(c22176d, "view");
        AppMethodBeat.m2504i(109497);
        this.rYd = c22176d;
        AppMethodBeat.m2505o(109497);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: le */
    public final void mo25960le(long j) {
        AppMethodBeat.m2504i(109489);
        C4133a c4133a = C43644j.rST;
        C46275k cxT = C4133a.cxT();
        c4133a = C43644j.rST;
        C4133a.cyd();
        C25052j.m39376p(this.igi, "userName");
        C35184a c35184a = C35183a.sdm;
        int cAR = C35183a.scA;
        String str = this.igi;
        String str2 = this.igi;
        C4133a c4133a2 = C43644j.rST;
        this.rYb = cxT.mo74404b(j, cAR, str, C5046bo.isEqual(str2, C4133a.cnk()));
        if (this.rXZ != 0) {
            this.rYb = this.rYb < this.rXZ ? this.rYb : this.rXZ;
        }
        C4990ab.m7410d(this.TAG, "localMinId=" + this.rYb + ", respMaxId=" + this.rXZ);
        AppMethodBeat.m2505o(109489);
    }

    public final void onCreate(String str) {
        AppMethodBeat.m2504i(109490);
        C25052j.m39376p(str, "userName");
        this.igi = str;
        mo25960le(this.rYa);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(273, (C1202f) this);
        AppMethodBeat.m2505o(109490);
    }

    public final void bMO() {
        AppMethodBeat.m2504i(109491);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(273, (C1202f) this);
        AppMethodBeat.m2505o(109491);
    }

    public final void cxo() {
        AppMethodBeat.m2504i(109492);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C13745a(this));
        AppMethodBeat.m2505o(109492);
    }

    public final void cxk() {
        AppMethodBeat.m2504i(109493);
        this.rYc--;
        C4990ab.m7416i(this.TAG, "loadNpData username=" + this.igi + " maxId=" + this.rXZ);
        if (!this.rFn) {
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            C6300p Rg = RO.mo5186Rg();
            String str = this.igi;
            long j = this.rXZ;
            String str2 = this.igi;
            C4133a c4133a = C43644j.rST;
            C35184a c35184a = C35183a.sdm;
            Rg.mo14552d((C1207m) new C35194j(str, j, C5046bo.isEqual(str2, C4133a.cnk()), "", C35183a.sdk));
        }
        AppMethodBeat.m2505o(109493);
    }

    public final void cxl() {
        AppMethodBeat.m2504i(109494);
        C4990ab.m7416i(this.TAG, "loadFpData username=" + this.igi + " maxId=" + this.rXZ);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        C6300p Rg = RO.mo5186Rg();
        String str = this.igi;
        String str2 = this.igi;
        C4133a c4133a = C43644j.rST;
        C35184a c35184a = C35183a.sdm;
        Rg.mo14552d((C1207m) new C35194j(str, 0, C5046bo.isEqual(str2, C4133a.cnk()), "", C35183a.sdk));
        AppMethodBeat.m2505o(109494);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(109495);
        C4990ab.m7416i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str + ' ' + c1207m);
        if ((c1207m instanceof C35194j) && C5046bo.isEqual(((C35194j) c1207m).userName, this.igi)) {
            int i3 = ((C35194j) c1207m).cvd;
            C35184a c35184a = C35183a.sdm;
            if (i3 == C35183a.sdk) {
                boolean z;
                C4990ab.m7410d(this.TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + ' ' + ((C35194j) c1207m).qKi);
                long j = ((C35194j) c1207m).qKi;
                C35184a c35184a2 = C35183a.sdm;
                if (i2 != C35183a.scI) {
                    c35184a2 = C35183a.sdm;
                    if (!(i2 == C35183a.scJ || (i == 0 && i2 == 0 && j == 0))) {
                        c35184a2 = C35183a.sdm;
                        if (!(i2 == C35183a.scH && j == 0)) {
                            z = false;
                            this.rFn = z;
                            if (this.rFn) {
                                this.rYd.cxn();
                            }
                            this.rXZ = ((C35194j) c1207m).qKi;
                            C4133a c4133a;
                            if (((C35194j) c1207m).qIW) {
                                c4133a = C43644j.rST;
                                C4133a.cno().post(new C13744c(this));
                            } else {
                                c4133a = C43644j.rST;
                                C4133a.cno().post(new C13746b(this));
                            }
                            C4990ab.m7410d(this.TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
                        }
                    }
                }
                z = true;
                this.rFn = z;
                if (this.rFn) {
                }
                this.rXZ = ((C35194j) c1207m).qKi;
                if (((C35194j) c1207m).qIW) {
                }
                C4990ab.m7410d(this.TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
            }
        }
        AppMethodBeat.m2505o(109495);
    }

    /* renamed from: a */
    public final void mo25955a(C39879j c39879j) {
        AppMethodBeat.m2504i(138798);
        C25052j.m39376p(c39879j, "storyInfo");
        C4990ab.m7416i(this.TAG, "LogStory: setFavorite storyId:" + c39879j.field_storyID + " localid:" + ((int) c39879j.xDa) + " targetFavorite:true replacedStory:" + null);
        C29311a c29311a = C29310n.rTi;
        C29311a.m46539h(c39879j.field_storyID, (int) c39879j.xDa, true);
        C22212h c22212h = C22212h.scu;
        C22212h.m33893a(1, String.valueOf(c39879j.field_storyID), 0, 0, 1);
        AppMethodBeat.m2505o(138798);
    }
}
