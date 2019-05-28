package com.tencent.p177mm.plugin.story.p530f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C22244o.C22245a;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p744a.C35194j;
import com.tencent.p177mm.plugin.story.model.p744a.C35197l;
import com.tencent.p177mm.plugin.story.model.p744a.C39885a;
import com.tencent.p177mm.plugin.story.model.p744a.C7138g;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C22175b;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C29279a;
import com.tencent.p177mm.plugin.story.p530f.C29284b.C22179a;
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

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J,\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.m */
public final class C43633m implements C1202f, C29279a {
    private static final String TAG = TAG;
    public static final C29291a sal = new C29291a();
    private String igi = "";
    private boolean rFn;
    private long rXZ;
    private long rYa;
    private long rYb;
    private int rYc = 1;
    final C22175b sak;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.m$a */
    public static final class C29291a {
        private C29291a() {
        }

        public /* synthetic */ C29291a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.m$b */
    static final class C35176b implements Runnable {
        final /* synthetic */ C43633m sam;

        C35176b(C43633m c43633m) {
            this.sam = c43633m;
        }

        public final void run() {
            AppMethodBeat.m2504i(138818);
            final ArrayList arrayList = new ArrayList();
            final C31596c c31596c = new C31596c();
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            String a = this.sam.igi;
            String a2 = this.sam.igi;
            C4133a c4133a2 = C43644j.rST;
            c31596c.AVE = C46275k.m86719a(cxT, a, C5046bo.isEqual(a2, C4133a.cnk()), this.sam.rYb);
            if ((!((Collection) ((List) c31596c.AVE)).isEmpty() ? 1 : null) != null) {
                this.sam.rYa = ((C39879j) C25035t.m39339fL((List) c31596c.AVE)).field_storyID;
            } else {
                c4133a = C43644j.rST;
                cxT = C4133a.cxT();
                a = this.sam.igi;
                a2 = this.sam.igi;
                c4133a2 = C43644j.rST;
                arrayList.addAll(cxT.mo74406bw(a, C5046bo.isEqual(a2, C4133a.cnk())));
            }
            C29291a c29291a = C43633m.sal;
            C4990ab.m7410d(C43633m.TAG, "localCachedMinId=" + this.sam.rYa + " infos.size=" + ((List) c31596c.AVE).size() + " localMinId=" + this.sam.rYb);
            C8902b.m16042a(new C31214a<C37091y>(this) {
                final /* synthetic */ C35176b san;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(138817);
                    this.san.sam.sak.mo26005f((List) c31596c.AVE, arrayList.isEmpty());
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(138817);
                    return c37091y;
                }
            });
            AppMethodBeat.m2505o(138818);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.m$c */
    static final class C35178c implements Runnable {
        final /* synthetic */ C43633m sam;

        C35178c(C43633m c43633m) {
            this.sam = c43633m;
        }

        public final void run() {
            AppMethodBeat.m2504i(138819);
            this.sam.mo69248le(this.sam.rYa);
            this.sam.cxm();
            if (this.sam.rYc > 0) {
                this.sam.cxk();
            }
            AppMethodBeat.m2505o(138819);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.m$d */
    static final class C35179d implements Runnable {
        final /* synthetic */ C43633m sam;

        C35179d(C43633m c43633m) {
            this.sam = c43633m;
        }

        public final void run() {
            AppMethodBeat.m2504i(138820);
            this.sam.mo69248le(this.sam.rYa);
            this.sam.cxm();
            if (this.sam.rYc > 0) {
                this.sam.cxk();
            }
            AppMethodBeat.m2505o(138820);
        }
    }

    public C43633m(C22175b c22175b) {
        C25052j.m39376p(c22175b, "view");
        AppMethodBeat.m2504i(138828);
        this.sak = c22175b;
        AppMethodBeat.m2505o(138828);
    }

    static {
        AppMethodBeat.m2504i(138829);
        AppMethodBeat.m2505o(138829);
    }

    public final void onCreate(String str) {
        AppMethodBeat.m2504i(138821);
        C25052j.m39376p(str, "userName");
        this.igi = str;
        mo69248le(this.rYa);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(273, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(764, (C1202f) this);
        AppMethodBeat.m2505o(138821);
    }

    /* renamed from: le */
    public final void mo69248le(long j) {
        AppMethodBeat.m2504i(138822);
        C4133a c4133a = C43644j.rST;
        C46275k cxT = C4133a.cxT();
        C4133a c4133a2 = C43644j.rST;
        C4133a.cyd();
        this.rYb = cxT.mo74396F(j, C22245a.aaC(this.igi));
        C22179a c22179a = C29284b.rYk;
        C4990ab.m7410d(C29284b.TAG, "localMinId=" + this.rYb + ", respMaxId=" + this.rXZ);
        AppMethodBeat.m2505o(138822);
    }

    public final void bMO() {
        AppMethodBeat.m2504i(138823);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(273, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(764, (C1202f) this);
        AppMethodBeat.m2505o(138823);
    }

    public final void cxk() {
        AppMethodBeat.m2504i(138824);
        this.rYc--;
        C4990ab.m7416i(TAG, "loadNpData username=" + this.igi + " maxId=" + this.rXZ);
        if (!this.rFn) {
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            C6300p Rg = RO.mo5186Rg();
            String str = this.igi;
            long j = this.rXZ;
            String str2 = this.igi;
            C4133a c4133a = C43644j.rST;
            C35184a c35184a = C35183a.sdm;
            Rg.mo14552d((C1207m) new C35194j(str, j, C5046bo.isEqual(str2, C4133a.cnk()), "", C35183a.sdl));
        }
        AppMethodBeat.m2505o(138824);
    }

    public final void cxl() {
        AppMethodBeat.m2504i(138825);
        C4990ab.m7416i(TAG, "loadFpData username=" + this.igi + " maxId=" + this.rXZ);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        C6300p Rg = RO.mo5186Rg();
        String str = this.igi;
        String str2 = this.igi;
        C4133a c4133a = C43644j.rST;
        C35184a c35184a = C35183a.sdm;
        Rg.mo14552d((C1207m) new C35194j(str, 0, C5046bo.isEqual(str2, C4133a.cnk()), "", C35183a.sdl));
        AppMethodBeat.m2505o(138825);
    }

    public final void cxm() {
        AppMethodBeat.m2504i(138826);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C35176b(this));
        AppMethodBeat.m2505o(138826);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(138827);
        if (c1207m instanceof C35194j) {
            int i3 = ((C35194j) c1207m).cvd;
            C35184a c35184a = C35183a.sdm;
            if (i3 == C35183a.sdl) {
                boolean z;
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
                                this.sak.cxn();
                            }
                            this.rXZ = ((C35194j) c1207m).qKi;
                            C4133a c4133a;
                            if (((C35194j) c1207m).qIW) {
                                c4133a = C43644j.rST;
                                C4133a.cno().post(new C35179d(this));
                            } else {
                                c4133a = C43644j.rST;
                                C4133a.cno().post(new C35178c(this));
                            }
                            C4990ab.m7410d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
                            AppMethodBeat.m2505o(138827);
                            return;
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
                C4990ab.m7410d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2 + " isAll:" + this.rFn + " limitId:" + this.rXZ);
                AppMethodBeat.m2505o(138827);
                return;
            }
        }
        if (c1207m instanceof C7138g) {
            C39885a cyX = ((C7138g) c1207m).cyX();
            if (cyX != null) {
                if (cyX instanceof C35197l) {
                    C22179a c22179a = C29284b.rYk;
                    C4990ab.m7416i(C29284b.TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((C7138g) c1207m).cNE + ", favorite:" + ((C35197l) cyX).rVe);
                    if (i2 == 0) {
                        C29311a c29311a = C29310n.rTi;
                        C29311a.m46538fK(((C7138g) c1207m).cNE, ((C35197l) cyX).rVe);
                        cxm();
                    }
                }
                AppMethodBeat.m2505o(138827);
                return;
            }
        }
        AppMethodBeat.m2505o(138827);
    }
}
