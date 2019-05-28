package com.tencent.p177mm.plugin.story.p530f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C22244o.C22245a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p744a.C7136f;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C43626e;
import com.tencent.p177mm.plugin.story.p1034d.C43628a.C43627f;
import com.tencent.p177mm.plugin.story.p1303e.C22177b;
import com.tencent.p177mm.plugin.story.p1303e.C22177b.C22178a;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46274i;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J,\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.b */
public final class C29284b implements C1202f, C43626e {
    private static final String TAG = TAG;
    public static final C22179a rYk = new C22179a();
    private String igi = "";
    private boolean rFn;
    private long rXZ;
    private long rYa;
    private long rYb;
    private final LinkedHashMap<String, ArrayList<C22213h>> rYh = new LinkedHashMap();
    private int rYi;
    final C43627f rYj;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.b$a */
    public static final class C22179a {
        private C22179a() {
        }

        public /* synthetic */ C22179a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.b$b */
    static final class C22180b implements Runnable {
        final /* synthetic */ C29284b rYl;

        C22180b(C29284b c29284b) {
            this.rYl = c29284b;
        }

        public final void run() {
            AppMethodBeat.m2504i(109499);
            ArrayList arrayList = new ArrayList();
            C4133a c4133a = C43644j.rST;
            List<C39879j> a = C46275k.m86717a(C4133a.cxT(), this.rYl.igi, this.rYl.rYb);
            if (!a.isEmpty()) {
                this.rYl.rYa = ((C39879j) C25035t.m39339fL(a)).field_storyID;
            }
            ArrayList arrayList2 = new ArrayList();
            for (C39879j c39879j : a) {
                String cBQ;
                C4133a c4133a2 = C43644j.rST;
                C46274i cxZ = C4133a.cxZ();
                C22178a c22178a = C22177b.rRO;
                C22213h aaZ = cxZ.aaZ(C22178a.m33804j(Integer.valueOf(c39879j.field_createTime)));
                C22179a c22179a = C29284b.rYk;
                String access$getTAG$cp = C29284b.TAG;
                StringBuilder append = new StringBuilder("loadDBData rawLocalId=").append((int) c39879j.xDa).append(" rawStoryId=").append(c39879j.field_storyID).append(" date=");
                if (aaZ != null) {
                    cBQ = aaZ.cBQ();
                } else {
                    cBQ = null;
                }
                C4990ab.m7410d(access$getTAG$cp, append.append(cBQ).append(" count=").append(aaZ != null ? Integer.valueOf(aaZ.field_count) : null).toString());
                if (aaZ != null) {
                    c4133a2 = C43644j.rST;
                    Object Fe = C4133a.cxT().mo74397Fe((int) c39879j.xDa);
                    if (Fe == null) {
                        Fe = new C39879j();
                    }
                    C25052j.m39376p(Fe, "<set-?>");
                    aaZ.rXz = Fe;
                    if (!arrayList2.contains(aaZ.cBQ())) {
                        arrayList.add(aaZ);
                        arrayList2.add(aaZ.cBQ());
                    }
                }
            }
            C22179a c22179a2 = C29284b.rYk;
            C4990ab.m7410d(C29284b.TAG, "localCachedMinId=" + this.rYl.rYa + " infos.size=" + arrayList.size() + " localMinId=" + this.rYl.rYb);
            final List a2 = C29284b.m46494a(this.rYl, (List) arrayList);
            C8902b.m16042a(new C31214a<C37091y>(this) {
                final /* synthetic */ C22180b rYm;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(109498);
                    this.rYm.rYl.rYj.mo17278du(a2);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(109498);
                    return c37091y;
                }
            });
            AppMethodBeat.m2505o(109499);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.b$c */
    static final class C22182c implements Runnable {
        final /* synthetic */ C29284b rYl;

        C22182c(C29284b c29284b) {
            this.rYl = c29284b;
        }

        public final void run() {
            AppMethodBeat.m2504i(109502);
            C22179a c22179a = C29284b.rYk;
            C4990ab.m7416i(C29284b.TAG, "loadFpData username=" + this.rYl.igi + " maxId=" + this.rYl.rXZ);
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            C6300p Rg = RO.mo5186Rg();
            String a = this.rYl.igi;
            long d = this.rYl.rXZ;
            String a2 = this.rYl.igi;
            C4133a c4133a = C43644j.rST;
            Rg.mo14552d((C1207m) new C7136f(a, d, C5046bo.isEqual(a2, C4133a.cnk())));
            AppMethodBeat.m2505o(109502);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.b$e */
    static final class C22183e implements Runnable {
        final /* synthetic */ C29284b rYl;

        C22183e(C29284b c29284b) {
            this.rYl = c29284b;
        }

        public final void run() {
            AppMethodBeat.m2504i(109504);
            this.rYl.mo47489le(this.rYl.rYa);
            this.rYl.cxo();
            AppMethodBeat.m2505o(109504);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.b$d */
    static final class C29285d implements Runnable {
        final /* synthetic */ C29284b rYl;

        C29285d(C29284b c29284b) {
            this.rYl = c29284b;
        }

        public final void run() {
            AppMethodBeat.m2504i(109503);
            C22179a c22179a = C29284b.rYk;
            C4990ab.m7416i(C29284b.TAG, "loadNpData username=" + this.rYl.igi + " maxId=" + this.rYl.rXZ);
            if (this.rYl.rYi == 0 && !this.rYl.rFn) {
                C29284b c29284b = this.rYl;
                c29284b.rYi = c29284b.rYi + 1;
                C1682b RO = C1720g.m3535RO();
                C25052j.m39375o(RO, "MMKernel.network()");
                C6300p Rg = RO.mo5186Rg();
                String a = this.rYl.igi;
                long d = this.rYl.rXZ;
                String a2 = this.rYl.igi;
                C4133a c4133a = C43644j.rST;
                Rg.mo14552d((C1207m) new C7136f(a, d, C5046bo.isEqual(a2, C4133a.cnk())));
            }
            AppMethodBeat.m2505o(109503);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.b$f */
    static final class C29286f implements Runnable {
        final /* synthetic */ C29284b rYl;

        C29286f(C29284b c29284b) {
            this.rYl = c29284b;
        }

        public final void run() {
            AppMethodBeat.m2504i(109505);
            this.rYl.mo47489le(this.rYl.rYa);
            this.rYl.cxo();
            AppMethodBeat.m2505o(109505);
        }
    }

    public C29284b(C43627f c43627f) {
        C25052j.m39376p(c43627f, "view");
        AppMethodBeat.m2504i(109515);
        this.rYj = c43627f;
        AppMethodBeat.m2505o(109515);
    }

    static {
        AppMethodBeat.m2504i(109516);
        AppMethodBeat.m2505o(109516);
    }

    /* renamed from: le */
    public final void mo47489le(long j) {
        AppMethodBeat.m2504i(109506);
        C4133a c4133a = C43644j.rST;
        C46275k cxT = C4133a.cxT();
        C4133a c4133a2 = C43644j.rST;
        C4133a.cyd();
        this.rYb = cxT.mo74395E(j, C22245a.aaC(this.igi));
        if (this.rXZ != 0) {
            this.rYb = this.rYb < this.rXZ ? this.rYb : this.rXZ;
        }
        C4990ab.m7410d(TAG, "localMinId=" + this.rYb + ", respMaxId=" + this.rXZ);
        AppMethodBeat.m2505o(109506);
    }

    public final void onCreate(String str) {
        AppMethodBeat.m2504i(109507);
        C25052j.m39376p(str, "userName");
        this.igi = str;
        mo47489le(this.rYa);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(191, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(3926, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(764, (C1202f) this);
        AppMethodBeat.m2505o(109507);
    }

    public final void bMO() {
        AppMethodBeat.m2504i(109508);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(191, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(3926, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(764, (C1202f) this);
        AppMethodBeat.m2505o(109508);
    }

    public final void cxo() {
        AppMethodBeat.m2504i(109509);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C22180b(this));
        AppMethodBeat.m2505o(109509);
    }

    public final void cxl() {
        AppMethodBeat.m2504i(109510);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C22182c(this));
        AppMethodBeat.m2505o(109510);
    }

    public final void cxk() {
        AppMethodBeat.m2504i(109511);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C29285d(this));
        AppMethodBeat.m2505o(109511);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(109512);
        if ((c1207m instanceof C7136f) && C5046bo.isEqual(((C7136f) c1207m).userName, this.igi)) {
            boolean z;
            C35184a c35184a = C35183a.sdm;
            if (i2 != C35183a.scI) {
                c35184a = C35183a.sdm;
                if (i2 != C35183a.scJ) {
                    z = false;
                    this.rFn = z;
                    if (this.rFn) {
                        this.rYj.cxn();
                    }
                    C4133a c4133a;
                    if (((C7136f) c1207m).qIW) {
                        this.rYi = 0;
                        c4133a = C43644j.rST;
                        C4133a.cno().post(new C29286f(this));
                    } else {
                        c4133a = C43644j.rST;
                        C4133a.cno().post(new C22183e(this));
                    }
                    this.rXZ = ((C7136f) c1207m).qKi;
                    C4990ab.m7410d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2);
                }
            }
            z = true;
            this.rFn = z;
            if (this.rFn) {
            }
            if (((C7136f) c1207m).qIW) {
            }
            this.rXZ = ((C7136f) c1207m).qKi;
            C4990ab.m7410d(TAG, "onSceneEnd username=" + this.igi + " respMaxId=" + this.rXZ + ' ' + i + ' ' + i2);
        }
        AppMethodBeat.m2505o(109512);
    }
}
