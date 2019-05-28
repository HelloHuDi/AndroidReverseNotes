package com.tencent.p177mm.plugin.story.p530f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C27003i;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p533d.C43639f;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p744a.C13768e;
import com.tencent.p177mm.plugin.story.model.p744a.C29300n;
import com.tencent.p177mm.plugin.story.model.p744a.C35197l;
import com.tencent.p177mm.plugin.story.model.p744a.C35198m;
import com.tencent.p177mm.plugin.story.model.p744a.C39885a;
import com.tencent.p177mm.plugin.story.model.p744a.C7138g;
import com.tencent.p177mm.plugin.story.p530f.C39876h.C29290a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C46273e;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u001e\u0010)\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0+H\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0010H\u0016J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u0013H\u0002J*\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u0013H\u0002J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u0013H\u0002J\b\u0010;\u001a\u00020\u001bH\u0016J\u0010\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0010H\u0002J\b\u0010>\u001a\u00020\u001bH\u0016J*\u0010?\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J \u0010C\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0013H\u0016J\b\u0010E\u001a\u00020\u001bH\u0002J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/SelfHistoryGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "username", "", "dateList", "Ljava/util/ArrayList;", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "TAG", "dateGalleryMap", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "", "deleteRowIndex", "isLoadNetScene", "", "loadingIndexQueue", "Ljava/util/LinkedList;", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "cancelDeleteItem", "", "row", "column", "checkLoadMore", "deleteItem", "destroy", "getStoryCountByDate", "date", "initExpectPosition", "expectPos", "initLoad", "loadMore", "loadNextQueuedUser", "loadStoryByDate", "notifyDateUpdate", "userGalleryItems", "", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "onSetPrivacyCallback", "isPrivacy", "pause", "preloadForUser", "dateIndex", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "updateUserGalleryItemsFromDb", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.k */
public final class C22204k extends C39876h implements C1202f {
    private final String TAG = "MicroMsg.SelfHistoryGalleryPresenter";
    private final ArrayList<ArrayList<C43640g>> rYW = new ArrayList();
    private final ArrayList<C46272g> rYX = new ArrayList();
    private final LinkedList<Integer> rYY = new LinkedList();
    private int rYZ = -1;
    private final int rZA = 3;
    private final int rZB = 1;
    private boolean rZD;
    private final ArrayList<String> rZZ;
    private int rZa = -1;
    private int rZb = -1;
    private int rZc = -1;
    private final C43632e rZe;
    private final String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$b */
    static final class C13760b implements Runnable {
        final /* synthetic */ int rZg;
        final /* synthetic */ int rZh;
        final /* synthetic */ C22204k saa;

        C13760b(C22204k c22204k, int i, int i2) {
            this.saa = c22204k;
            this.rZg = i;
            this.rZh = i2;
        }

        public final void run() {
            AppMethodBeat.m2504i(109643);
            this.saa.rYZ = this.rZg;
            this.saa.rZa = this.rZh;
            Object obj = ((ArrayList) this.saa.rYW.get(this.rZg)).get(this.rZh);
            C25052j.m39375o(obj, "dateGalleryMap[row][column]");
            final C43640g c43640g = (C43640g) obj;
            C4133a c4133a = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe(c43640g.rVZ.cNE);
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxT().aba(c43640g.rVZ.cNE + '_' + c43640g.rVZ.fDG);
            if (Fe != null) {
                C4990ab.m7416i(this.saa.TAG, "LogStory: deleteItem2 storyinfo " + c43640g + " deleteItemRow " + this.saa.rYZ + " deleteItemCol " + this.saa.rZa + " localid " + c43640g.rVZ.cNE + ' ' + Fe.field_storyID);
                if (Fe.field_storyID == 0) {
                    C29311a c29311a = C29310n.rTi;
                    C29311a.m46531EL(c43640g.rVZ.cNE);
                    C22204k.m33856g(this.saa);
                } else if (!(this.saa.rYZ == -1 || this.saa.rZa == -1)) {
                    C29311a c29311a2 = C29310n.rTi;
                    C29311a.m46530D(Fe.field_storyID, c43640g.rVZ.cNE);
                }
            }
            if (c43640g.rVZ.cze()) {
                c4133a = C43644j.rST;
                C4133a.cno().post(new Runnable(this) {
                    final /* synthetic */ C13760b sab;

                    public final void run() {
                        AppMethodBeat.m2504i(109642);
                        C4990ab.m7416i(this.sab.saa.TAG, "LogStory: deleteItem fake " + c43640g);
                        C29311a c29311a = C29310n.rTi;
                        C29311a.m46531EL(c43640g.rVZ.cNE);
                        C22210l c22210l = C22210l.sac;
                        C22210l.m33885li(c43640g.rVZ.timeStamp);
                        c22210l = C22210l.sac;
                        c22210l = C22210l.sac;
                        C22210l.m33880b(C22210l.m33884lh(c43640g.rVZ.timeStamp));
                        AppMethodBeat.m2505o(109642);
                    }
                });
            }
            AppMethodBeat.m2505o(109643);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$c */
    static final class C13762c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int rZk;
        final /* synthetic */ C22204k saa;

        C13762c(C22204k c22204k, int i) {
            this.saa = c22204k;
            this.rZk = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109644);
            this.saa.rZe.mo55966EQ(this.rZk);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109644);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$e */
    static final class C22203e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean rXE;
        final /* synthetic */ C22204k saa;

        C22203e(C22204k c22204k, boolean z) {
            this.saa = c22204k;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109646);
            if (this.rXE) {
                int size = this.saa.rYW.size();
                int b = this.saa.rYZ;
                if (b >= 0 && size > b) {
                    Object obj = this.saa.rYW.get(this.saa.rYZ);
                    C25052j.m39375o(obj, "dateGalleryMap[deleteRowIndex]");
                    ArrayList arrayList = (ArrayList) obj;
                    b = arrayList.size();
                    int c = this.saa.rZa;
                    if (c >= 0 && b > c) {
                        arrayList.remove(this.saa.rZa);
                        C22204k c22204k = this.saa;
                        Object obj2 = this.saa.rZZ.get(this.saa.rYZ);
                        C25052j.m39375o(obj2, "dateList[deleteRowIndex]");
                        C22204k.m33849a(c22204k, (String) obj2, arrayList);
                    }
                }
            }
            this.saa.rZe.mo55975lz(this.rXE);
            this.saa.rYZ = -1;
            this.saa.rZa = -1;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109646);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$d */
    static final class C22205d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int rZk;
        final /* synthetic */ List rZl;
        final /* synthetic */ C22204k saa;

        C22205d(C22204k c22204k, int i, List list) {
            this.saa = c22204k;
            this.rZk = i;
            this.rZl = list;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109645);
            this.saa.rZe.mo55972j(this.rZk, this.rZl);
            this.saa.rZe.mo55967ER(this.rZk);
            this.saa.rZe.czD();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109645);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$a */
    static final class C22206a implements Runnable {
        final /* synthetic */ int rZg;
        final /* synthetic */ C22204k saa;

        C22206a(C22204k c22204k, int i) {
            this.saa = c22204k;
            this.rZg = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(109641);
            if (((C46272g) this.saa.rYX.get(this.rZg)).rZv != 2) {
                this.saa.rYY.add(Integer.valueOf(this.rZg));
            }
            int i = this.rZg + 1;
            if (i < this.saa.rZZ.size()) {
                this.saa.rYY.add(Integer.valueOf(i));
                C22204k.m33859j(this.saa);
            }
            AppMethodBeat.m2505o(109641);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$g */
    static final class C22207g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean rZn;
        final /* synthetic */ C22204k saa;

        C22207g(C22204k c22204k, boolean z) {
            this.saa = c22204k;
            this.rZn = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109648);
            this.saa.rZe.mo55974lB(this.rZn);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109648);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$f */
    static final class C22208f implements Runnable {
        final /* synthetic */ int rZg;
        final /* synthetic */ C22204k saa;

        C22208f(C22204k c22204k, int i) {
            this.saa = c22204k;
            this.rZg = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(109647);
            if (((C46272g) this.saa.rYX.get(this.rZg)).rZv != 2) {
                this.saa.rYY.add(Integer.valueOf(this.rZg));
            }
            int i = this.rZg + 1;
            if (i < this.saa.rZZ.size()) {
                this.saa.rYY.add(Integer.valueOf(i));
                C22204k.m33859j(this.saa);
            }
            AppMethodBeat.m2505o(109647);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.k$h */
    static final class C22209h extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean rZo;
        final /* synthetic */ C22204k saa;

        C22209h(C22204k c22204k, boolean z) {
            this.saa = c22204k;
            this.rZo = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109649);
            this.saa.rZe.mo55973lA(this.rZo);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109649);
            return c37091y;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m33849a(C22204k c22204k, String str, List list) {
        AppMethodBeat.m2504i(109663);
        c22204k.m33861r(str, list);
        AppMethodBeat.m2505o(109663);
    }

    /* renamed from: g */
    public static final /* synthetic */ void m33856g(C22204k c22204k) {
        AppMethodBeat.m2504i(109664);
        c22204k.m33860ly(true);
        AppMethodBeat.m2505o(109664);
    }

    /* renamed from: j */
    public static final /* synthetic */ void m33859j(C22204k c22204k) {
        AppMethodBeat.m2504i(109665);
        c22204k.czF();
        AppMethodBeat.m2505o(109665);
    }

    public C22204k(String str, ArrayList<String> arrayList, C43632e c43632e) {
        C25052j.m39376p(str, "username");
        C25052j.m39376p(arrayList, "dateList");
        C25052j.m39376p(c43632e, "galleryUserCallback");
        AppMethodBeat.m2504i(109662);
        this.username = str;
        this.rZZ = arrayList;
        this.rZe = c43632e;
        this.rZe.mo55965EP(this.rZZ.size());
        for (String str2 : this.rZZ) {
            C4990ab.m7416i(this.TAG, "LogStory: ".concat(String.valueOf(str2)));
            this.rYW.add(new ArrayList());
            this.rYX.add(new C46272g(str2));
        }
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14539a(764, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14539a((int) C27003i.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(109662);
    }

    /* renamed from: ET */
    public final void mo37742ET(int i) {
    }

    /* renamed from: ly */
    private final void m33860ly(boolean z) {
        AppMethodBeat.m2504i(109650);
        C8902b.m16042a(new C22203e(this, z));
        AppMethodBeat.m2505o(109650);
    }

    /* renamed from: r */
    private final void m33861r(String str, List<C43640g> list) {
        AppMethodBeat.m2504i(109651);
        int indexOf = this.rZZ.indexOf(str);
        if (list.isEmpty()) {
            C8902b.m16042a(new C13762c(this, indexOf));
            AppMethodBeat.m2505o(109651);
            return;
        }
        C8902b.m16042a(new C22205d(this, indexOf, list));
        AppMethodBeat.m2505o(109651);
    }

    public final void czB() {
        AppMethodBeat.m2504i(109652);
        this.rYZ = -1;
        this.rZa = -1;
        C29311a c29311a = C29310n.rTi;
        C29311a.cyo();
        AppMethodBeat.m2505o(109652);
    }

    public final void resume() {
    }

    public final void pause() {
    }

    public final void destroy() {
        AppMethodBeat.m2504i(109653);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14546b((int) C27003i.CTRL_INDEX, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14546b(764, (C1202f) this);
        AppMethodBeat.m2505o(109653);
    }

    /* renamed from: EO */
    public final void mo37740EO(int i) {
    }

    public final void czC() {
        Object obj;
        String str;
        Object obj2;
        int i = 0;
        AppMethodBeat.m2504i(109654);
        Iterator it = this.rZZ.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                C7987l.dWs();
            }
            ((C46272g) this.rYX.get(i2)).rZv = 1;
            i2 = i3;
        }
        Iterator it2 = this.rZZ.iterator();
        int i4 = 0;
        while (it2.hasNext()) {
            int i5;
            it2.next();
            int i6 = i4 + 1;
            if (i4 < 0) {
                C7987l.dWs();
            }
            obj = this.rZZ.get(i4);
            C25052j.m39375o(obj, "dateList[dateIndex]");
            str = (String) obj;
            obj2 = this.rYW.get(i4);
            C25052j.m39375o(obj2, "dateGalleryMap[dateIndex]");
            ArrayList arrayList = (ArrayList) obj2;
            Object obj3 = this.rYX.get(i4);
            C25052j.m39375o(obj3, "dateState[dateIndex]");
            C46272g c46272g = (C46272g) obj3;
            C4133a c4133a = C43644j.rST;
            C22213h aaZ = C4133a.cxZ().aaZ(str);
            if (aaZ != null) {
                i5 = aaZ.field_count;
            } else {
                i5 = 0;
            }
            C4990ab.m7416i(this.TAG, "LogStory: preloadForDate " + str + " historyCount " + i5);
            ArrayList gz = C29290a.m46507gz(this.username, str);
            if (gz.size() > 0) {
                arrayList.addAll(gz);
                if (gz.size() == i5) {
                    c46272g.rZv = 2;
                } else {
                    c46272g.rZv = 1;
                }
                C4990ab.m7416i(this.TAG, "LogStory: preload Db data " + gz.size());
                i4 = i6;
            } else {
                if (i5 != 0) {
                    c46272g.rZv = 1;
                    C4990ab.m7416i(this.TAG, "LogStory: initLoad Sync data");
                }
                i4 = i6;
            }
        }
        if (this.rZZ.size() > 0) {
            this.rYY.add(Integer.valueOf(0));
            czF();
        }
        Iterator it3 = this.rZZ.iterator();
        while (it3.hasNext()) {
            it3.next();
            i4 = i + 1;
            if (i < 0) {
                C7987l.dWs();
            }
            obj = this.rZZ.get(i);
            C25052j.m39375o(obj, "dateList[index]");
            str = (String) obj;
            obj2 = this.rYW.get(i);
            C25052j.m39375o(obj2, "dateGalleryMap[index]");
            m33861r(str, (List) obj2);
            i = i4;
        }
        AppMethodBeat.m2505o(109654);
    }

    public final void czE() {
    }

    /* renamed from: fM */
    public final void mo37746fM(int i, int i2) {
        AppMethodBeat.m2504i(109655);
        C4990ab.m7416i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(i)));
        if (i >= 0 && i < this.rZZ.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            C4133a c4133a = C43644j.rST;
            C4133a.cno().post(new C13760b(this, i, i2));
        }
        AppMethodBeat.m2505o(109655);
    }

    /* renamed from: fN */
    public final void mo37747fN(int i, int i2) {
        Object obj = null;
        AppMethodBeat.m2504i(109656);
        this.rZb = i;
        this.rZc = i2;
        C4990ab.m7410d(this.TAG, "onSelected row=" + i + " column=" + i2);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C22208f(this, i));
        if (this.rZb >= 0 && this.rZb < this.rYW.size()) {
            C43639f c43639f;
            Object obj2 = this.rYW.get(this.rZb);
            C25052j.m39375o(obj2, "dateGalleryMap[selectedRow]");
            C43640g c43640g = (C43640g) C25035t.m39361x((ArrayList) obj2, this.rZc);
            if (c43640g != null) {
                c43639f = c43640g.rWa;
            } else {
                c43639f = null;
            }
            String str = this.TAG;
            StringBuilder append = new StringBuilder("setSelectedRead ").append(this.rZc).append(", ");
            if (c43639f != null) {
                obj = Boolean.valueOf(c43639f.rVh);
            }
            C4990ab.m7416i(str, append.append(obj).toString());
            if (c43639f != null && c43639f.rrj.size() > 0) {
                C46279b c46279b = C46279b.rVw;
                long j = c43639f.rUJ;
                obj2 = c43639f.rrj.getLast();
                C25052j.m39375o(obj2, "comment.commentList.last");
                if (C46279b.m86765b(j, (C39889a) obj2)) {
                    c43639f.rVh = false;
                    this.rZe.czD();
                }
            }
        }
        AppMethodBeat.m2505o(109656);
    }

    /* renamed from: n */
    public final void mo37753n(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(109657);
        C4990ab.m7416i(this.TAG, "LogStory: setPrivacy row:" + i + " column:" + i2);
        if (i >= 0 && i < this.rZZ.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            boolean z2 = !z;
            Object obj = ((ArrayList) this.rYW.get(i)).get(i2);
            C25052j.m39375o(obj, "dateGalleryMap[row][column]");
            C43640g c43640g = (C43640g) obj;
            C4990ab.m7416i(this.TAG, "LogStory: setPrivacy storyinfo " + c43640g + " targetPrivacy:" + z2);
            C4133a c4133a = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe((int) c43640g.rWb.xDa);
            if (Fe != null) {
                long j;
                C46273e c46273e = C46273e.sbS;
                C46273e.m86710lD(z2);
                if (z2) {
                    j = 3;
                } else {
                    j = 4;
                }
                C22212h c22212h = C22212h.scu;
                C22212h.m33892a(j, String.valueOf(Fe.field_storyID), 2, 0, 16);
                C29311a c29311a = C29310n.rTi;
                C29311a.m46535b(Fe.field_storyID, (int) Fe.xDa, z2, Fe.cBX());
                AppMethodBeat.m2505o(109657);
                return;
            }
        }
        AppMethodBeat.m2505o(109657);
    }

    /* renamed from: ES */
    public final void mo37741ES(int i) {
        AppMethodBeat.m2504i(109658);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C22206a(this, i));
        AppMethodBeat.m2505o(109658);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(109659);
        C25052j.m39376p(c1207m, "scene");
        C4990ab.m7416i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str);
        if ((c1207m instanceof C13768e) && C5046bo.isEqual(((C13768e) c1207m).userName, this.username)) {
            Integer num = (Integer) this.rYY.poll();
            if (num != null) {
                int intValue = num.intValue();
                int size = this.rZZ.size();
                if (intValue < 0) {
                    AppMethodBeat.m2505o(109659);
                    return;
                }
                if (size > intValue) {
                    C4990ab.m7410d(this.TAG, intValue + ' ' + ((String) this.rZZ.get(intValue)));
                    this.rZD = false;
                    ((C46272g) this.rYX.get(intValue)).rZv = 2;
                    C4990ab.m7416i(this.TAG, "LogStory: updateUserGalleryItemsFromDb ".concat(String.valueOf(intValue)));
                    Object obj = this.rZZ.get(intValue);
                    C25052j.m39375o(obj, "dateList[dateIndex]");
                    String str2 = (String) obj;
                    Object obj2 = this.rYW.get(intValue);
                    C25052j.m39375o(obj2, "dateGalleryMap[dateIndex]");
                    ArrayList arrayList = (ArrayList) obj2;
                    ArrayList gz = C29290a.m46507gz(this.username, str2);
                    arrayList.clear();
                    arrayList.addAll(gz);
                    C4990ab.m7416i(this.TAG, "LogStory: db data " + str2 + ' ' + arrayList.size());
                    m33861r(str2, arrayList);
                    czF();
                }
                AppMethodBeat.m2505o(109659);
                return;
            }
            AppMethodBeat.m2505o(109659);
            return;
        }
        if (c1207m instanceof C7138g) {
            C39885a cyX = ((C7138g) c1207m).cyX();
            if (cyX != null) {
                C29311a c29311a;
                if (cyX instanceof C35198m) {
                    if (i2 == 0) {
                        c29311a = C29310n.rTi;
                        C29311a.m46531EL(((C7138g) c1207m).cNE);
                    }
                    m33860ly(i2 == 0);
                    AppMethodBeat.m2505o(109659);
                    return;
                }
                if (cyX instanceof C29300n) {
                    C4990ab.m7416i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i + ", errcode:" + i2);
                    if (i2 == 0) {
                        c29311a = C29310n.rTi;
                        C29311a.m46537fJ(((C7138g) c1207m).cNE, ((C29300n) cyX).rVf);
                        if (((C29300n) cyX).rVf != 1 || ((C29300n) cyX).rVg) {
                            z = false;
                        }
                        C8902b.m16042a(new C22209h(this, z));
                        AppMethodBeat.m2505o(109659);
                        return;
                    }
                } else if (cyX instanceof C35197l) {
                    C4990ab.m7416i(this.TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((C7138g) c1207m).cNE + ", favorite:" + ((C35197l) cyX).rVe);
                    if (i2 == 0) {
                        c29311a = C29310n.rTi;
                        C29311a.m46538fK(((C7138g) c1207m).cNE, ((C35197l) cyX).rVe);
                        if (((C35197l) cyX).rVe != 1) {
                            z = false;
                        }
                        C8902b.m16042a(new C22207g(this, z));
                    }
                }
                AppMethodBeat.m2505o(109659);
                return;
            }
        }
        AppMethodBeat.m2505o(109659);
    }

    /* renamed from: o */
    public final void mo37754o(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(138816);
        C4990ab.m7416i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(i2)));
        if (i >= 0 && i < this.rZZ.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            boolean z2;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            Object obj = ((ArrayList) this.rYW.get(i)).get(i2);
            C25052j.m39375o(obj, "dateGalleryMap[row][column]");
            C43640g c43640g = (C43640g) obj;
            C4990ab.m7416i(this.TAG, "LogStory: setFavorite storyinfo " + c43640g + " localid " + c43640g.rVZ.cNE + " targetFavorite:" + z2);
            C4133a c4133a = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe((int) c43640g.rWb.xDa);
            if (Fe != null) {
                long j;
                C46273e c46273e = C46273e.sbS;
                C46273e.m86709lC(z2);
                if (z2) {
                    j = 1;
                } else {
                    j = 2;
                }
                C22212h c22212h = C22212h.scu;
                C22212h.m33892a(j, String.valueOf(Fe.field_storyID), 2, 0, 16);
                C29311a c29311a = C29310n.rTi;
                C29311a.m46539h(Fe.field_storyID, (int) Fe.xDa, z2);
            }
        }
        AppMethodBeat.m2505o(138816);
    }

    private final void czF() {
        AppMethodBeat.m2504i(109661);
        while (!this.rZD && this.rYY.size() > 0) {
            Object obj = this.rYY.get(0);
            C25052j.m39375o(obj, "loadingIndexQueue[0]");
            int intValue = ((Number) obj).intValue();
            obj = this.rZZ.get(intValue);
            C25052j.m39375o(obj, "dateList[dateIndex]");
            String str = (String) obj;
            C4990ab.m7416i(this.TAG, "LogStory: loadRemoteForDate ".concat(String.valueOf(str)));
            if (((C46272g) this.rYX.get(intValue)).rZv != 2) {
                C13768e c13768e = new C13768e(this.username, str);
                C1682b RO = C1720g.m3535RO();
                C25052j.m39375o(RO, "MMKernel.network()");
                RO.mo5186Rg().mo14552d((C1207m) c13768e);
                this.rZD = true;
                AppMethodBeat.m2505o(109661);
                return;
            }
            this.rYY.remove(0);
        }
        AppMethodBeat.m2505o(109661);
    }
}
