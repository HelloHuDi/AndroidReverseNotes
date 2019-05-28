package com.tencent.mm.plugin.story.f;

import a.a.t;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.appbrand.jsapi.i.i;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u001e\u0010)\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0+H\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0010H\u0016J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u0013H\u0002J*\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u0013H\u0002J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u0013H\u0002J\b\u0010;\u001a\u00020\u001bH\u0016J\u0010\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0010H\u0002J\b\u0010>\u001a\u00020\u001bH\u0016J*\u0010?\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J \u0010C\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0013H\u0016J\b\u0010E\u001a\u00020\u001bH\u0002J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/SelfHistoryGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "username", "", "dateList", "Ljava/util/ArrayList;", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "TAG", "dateGalleryMap", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "", "deleteRowIndex", "isLoadNetScene", "", "loadingIndexQueue", "Ljava/util/LinkedList;", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "cancelDeleteItem", "", "row", "column", "checkLoadMore", "deleteItem", "destroy", "getStoryCountByDate", "date", "initExpectPosition", "expectPos", "initLoad", "loadMore", "loadNextQueuedUser", "loadStoryByDate", "notifyDateUpdate", "userGalleryItems", "", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "onSetPrivacyCallback", "isPrivacy", "pause", "preloadForUser", "dateIndex", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "updateUserGalleryItemsFromDb", "plugin-story_release"})
public final class k extends h implements com.tencent.mm.ai.f {
    private final String TAG = "MicroMsg.SelfHistoryGalleryPresenter";
    private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> rYW = new ArrayList();
    private final ArrayList<g> rYX = new ArrayList();
    private final LinkedList<Integer> rYY = new LinkedList();
    private int rYZ = -1;
    private final int rZA = 3;
    private final int rZB = 1;
    private boolean rZD;
    private final ArrayList<String> rZZ;
    private int rZa = -1;
    private int rZb = -1;
    private int rZc = -1;
    private final e rZe;
    private final String username;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ int rZg;
        final /* synthetic */ int rZh;
        final /* synthetic */ k saa;

        b(k kVar, int i, int i2) {
            this.saa = kVar;
            this.rZg = i;
            this.rZh = i2;
        }

        public final void run() {
            AppMethodBeat.i(109643);
            this.saa.rYZ = this.rZg;
            this.saa.rZa = this.rZh;
            Object obj = ((ArrayList) this.saa.rYW.get(this.rZg)).get(this.rZh);
            j.o(obj, "dateGalleryMap[row][column]");
            final com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(gVar.rVZ.cNE);
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().aba(gVar.rVZ.cNE + '_' + gVar.rVZ.fDG);
            if (Fe != null) {
                ab.i(this.saa.TAG, "LogStory: deleteItem2 storyinfo " + gVar + " deleteItemRow " + this.saa.rYZ + " deleteItemCol " + this.saa.rZa + " localid " + gVar.rVZ.cNE + ' ' + Fe.field_storyID);
                if (Fe.field_storyID == 0) {
                    com.tencent.mm.plugin.story.model.n.a aVar3 = n.rTi;
                    com.tencent.mm.plugin.story.model.n.a.EL(gVar.rVZ.cNE);
                    k.g(this.saa);
                } else if (!(this.saa.rYZ == -1 || this.saa.rZa == -1)) {
                    com.tencent.mm.plugin.story.model.n.a aVar4 = n.rTi;
                    com.tencent.mm.plugin.story.model.n.a.D(Fe.field_storyID, gVar.rVZ.cNE);
                }
            }
            if (gVar.rVZ.cze()) {
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cno().post(new Runnable(this) {
                    final /* synthetic */ b sab;

                    public final void run() {
                        AppMethodBeat.i(109642);
                        ab.i(this.sab.saa.TAG, "LogStory: deleteItem fake " + gVar);
                        com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.EL(gVar.rVZ.cNE);
                        l lVar = l.sac;
                        l.li(gVar.rVZ.timeStamp);
                        lVar = l.sac;
                        lVar = l.sac;
                        l.b(l.lh(gVar.rVZ.timeStamp));
                        AppMethodBeat.o(109642);
                    }
                });
            }
            AppMethodBeat.o(109643);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ int rZk;
        final /* synthetic */ k saa;

        c(k kVar, int i) {
            this.saa = kVar;
            this.rZk = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109644);
            this.saa.rZe.EQ(this.rZk);
            y yVar = y.AUy;
            AppMethodBeat.o(109644);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ boolean rXE;
        final /* synthetic */ k saa;

        e(k kVar, boolean z) {
            this.saa = kVar;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109646);
            if (this.rXE) {
                int size = this.saa.rYW.size();
                int b = this.saa.rYZ;
                if (b >= 0 && size > b) {
                    Object obj = this.saa.rYW.get(this.saa.rYZ);
                    j.o(obj, "dateGalleryMap[deleteRowIndex]");
                    ArrayList arrayList = (ArrayList) obj;
                    b = arrayList.size();
                    int c = this.saa.rZa;
                    if (c >= 0 && b > c) {
                        arrayList.remove(this.saa.rZa);
                        k kVar = this.saa;
                        Object obj2 = this.saa.rZZ.get(this.saa.rYZ);
                        j.o(obj2, "dateList[deleteRowIndex]");
                        k.a(kVar, (String) obj2, arrayList);
                    }
                }
            }
            this.saa.rZe.lz(this.rXE);
            this.saa.rYZ = -1;
            this.saa.rZa = -1;
            y yVar = y.AUy;
            AppMethodBeat.o(109646);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ int rZk;
        final /* synthetic */ List rZl;
        final /* synthetic */ k saa;

        d(k kVar, int i, List list) {
            this.saa = kVar;
            this.rZk = i;
            this.rZl = list;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109645);
            this.saa.rZe.j(this.rZk, this.rZl);
            this.saa.rZe.ER(this.rZk);
            this.saa.rZe.czD();
            y yVar = y.AUy;
            AppMethodBeat.o(109645);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ int rZg;
        final /* synthetic */ k saa;

        a(k kVar, int i) {
            this.saa = kVar;
            this.rZg = i;
        }

        public final void run() {
            AppMethodBeat.i(109641);
            if (((g) this.saa.rYX.get(this.rZg)).rZv != 2) {
                this.saa.rYY.add(Integer.valueOf(this.rZg));
            }
            int i = this.rZg + 1;
            if (i < this.saa.rZZ.size()) {
                this.saa.rYY.add(Integer.valueOf(i));
                k.j(this.saa);
            }
            AppMethodBeat.o(109641);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ boolean rZn;
        final /* synthetic */ k saa;

        g(k kVar, boolean z) {
            this.saa = kVar;
            this.rZn = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109648);
            this.saa.rZe.lB(this.rZn);
            y yVar = y.AUy;
            AppMethodBeat.o(109648);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ int rZg;
        final /* synthetic */ k saa;

        f(k kVar, int i) {
            this.saa = kVar;
            this.rZg = i;
        }

        public final void run() {
            AppMethodBeat.i(109647);
            if (((g) this.saa.rYX.get(this.rZg)).rZv != 2) {
                this.saa.rYY.add(Integer.valueOf(this.rZg));
            }
            int i = this.rZg + 1;
            if (i < this.saa.rZZ.size()) {
                this.saa.rYY.add(Integer.valueOf(i));
                k.j(this.saa);
            }
            AppMethodBeat.o(109647);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ boolean rZo;
        final /* synthetic */ k saa;

        h(k kVar, boolean z) {
            this.saa = kVar;
            this.rZo = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109649);
            this.saa.rZe.lA(this.rZo);
            y yVar = y.AUy;
            AppMethodBeat.o(109649);
            return yVar;
        }
    }

    public static final /* synthetic */ void a(k kVar, String str, List list) {
        AppMethodBeat.i(109663);
        kVar.r(str, list);
        AppMethodBeat.o(109663);
    }

    public static final /* synthetic */ void g(k kVar) {
        AppMethodBeat.i(109664);
        kVar.ly(true);
        AppMethodBeat.o(109664);
    }

    public static final /* synthetic */ void j(k kVar) {
        AppMethodBeat.i(109665);
        kVar.czF();
        AppMethodBeat.o(109665);
    }

    public k(String str, ArrayList<String> arrayList, e eVar) {
        j.p(str, "username");
        j.p(arrayList, "dateList");
        j.p(eVar, "galleryUserCallback");
        AppMethodBeat.i(109662);
        this.username = str;
        this.rZZ = arrayList;
        this.rZe = eVar;
        this.rZe.EP(this.rZZ.size());
        for (String str2 : this.rZZ) {
            ab.i(this.TAG, "LogStory: ".concat(String.valueOf(str2)));
            this.rYW.add(new ArrayList());
            this.rYX.add(new g(str2));
        }
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().a(764, (com.tencent.mm.ai.f) this);
        RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().a((int) i.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(109662);
    }

    public final void ET(int i) {
    }

    private final void ly(boolean z) {
        AppMethodBeat.i(109650);
        com.tencent.mm.ab.b.a(new e(this, z));
        AppMethodBeat.o(109650);
    }

    private final void r(String str, List<com.tencent.mm.plugin.story.model.d.g> list) {
        AppMethodBeat.i(109651);
        int indexOf = this.rZZ.indexOf(str);
        if (list.isEmpty()) {
            com.tencent.mm.ab.b.a(new c(this, indexOf));
            AppMethodBeat.o(109651);
            return;
        }
        com.tencent.mm.ab.b.a(new d(this, indexOf, list));
        AppMethodBeat.o(109651);
    }

    public final void czB() {
        AppMethodBeat.i(109652);
        this.rYZ = -1;
        this.rZa = -1;
        com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
        com.tencent.mm.plugin.story.model.n.a.cyo();
        AppMethodBeat.o(109652);
    }

    public final void resume() {
    }

    public final void pause() {
    }

    public final void destroy() {
        AppMethodBeat.i(109653);
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().b((int) i.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().b(764, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(109653);
    }

    public final void EO(int i) {
    }

    public final void czC() {
        Object obj;
        String str;
        Object obj2;
        int i = 0;
        AppMethodBeat.i(109654);
        Iterator it = this.rZZ.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                a.a.l.dWs();
            }
            ((g) this.rYX.get(i2)).rZv = 1;
            i2 = i3;
        }
        Iterator it2 = this.rZZ.iterator();
        int i4 = 0;
        while (it2.hasNext()) {
            int i5;
            it2.next();
            int i6 = i4 + 1;
            if (i4 < 0) {
                a.a.l.dWs();
            }
            obj = this.rZZ.get(i4);
            j.o(obj, "dateList[dateIndex]");
            str = (String) obj;
            obj2 = this.rYW.get(i4);
            j.o(obj2, "dateGalleryMap[dateIndex]");
            ArrayList arrayList = (ArrayList) obj2;
            Object obj3 = this.rYX.get(i4);
            j.o(obj3, "dateState[dateIndex]");
            g gVar = (g) obj3;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.h aaZ = com.tencent.mm.plugin.story.model.j.a.cxZ().aaZ(str);
            if (aaZ != null) {
                i5 = aaZ.field_count;
            } else {
                i5 = 0;
            }
            ab.i(this.TAG, "LogStory: preloadForDate " + str + " historyCount " + i5);
            ArrayList gz = com.tencent.mm.plugin.story.f.h.a.gz(this.username, str);
            if (gz.size() > 0) {
                arrayList.addAll(gz);
                if (gz.size() == i5) {
                    gVar.rZv = 2;
                } else {
                    gVar.rZv = 1;
                }
                ab.i(this.TAG, "LogStory: preload Db data " + gz.size());
                i4 = i6;
            } else {
                if (i5 != 0) {
                    gVar.rZv = 1;
                    ab.i(this.TAG, "LogStory: initLoad Sync data");
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
                a.a.l.dWs();
            }
            obj = this.rZZ.get(i);
            j.o(obj, "dateList[index]");
            str = (String) obj;
            obj2 = this.rYW.get(i);
            j.o(obj2, "dateGalleryMap[index]");
            r(str, (List) obj2);
            i = i4;
        }
        AppMethodBeat.o(109654);
    }

    public final void czE() {
    }

    public final void fM(int i, int i2) {
        AppMethodBeat.i(109655);
        ab.i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(i)));
        if (i >= 0 && i < this.rZZ.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cno().post(new b(this, i, i2));
        }
        AppMethodBeat.o(109655);
    }

    public final void fN(int i, int i2) {
        Object obj = null;
        AppMethodBeat.i(109656);
        this.rZb = i;
        this.rZc = i2;
        ab.d(this.TAG, "onSelected row=" + i + " column=" + i2);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new f(this, i));
        if (this.rZb >= 0 && this.rZb < this.rYW.size()) {
            com.tencent.mm.plugin.story.model.d.f fVar;
            Object obj2 = this.rYW.get(this.rZb);
            j.o(obj2, "dateGalleryMap[selectedRow]");
            com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) t.x((ArrayList) obj2, this.rZc);
            if (gVar != null) {
                fVar = gVar.rWa;
            } else {
                fVar = null;
            }
            String str = this.TAG;
            StringBuilder append = new StringBuilder("setSelectedRead ").append(this.rZc).append(", ");
            if (fVar != null) {
                obj = Boolean.valueOf(fVar.rVh);
            }
            ab.i(str, append.append(obj).toString());
            if (fVar != null && fVar.rrj.size() > 0) {
                com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
                long j = fVar.rUJ;
                obj2 = fVar.rrj.getLast();
                j.o(obj2, "comment.commentList.last");
                if (com.tencent.mm.plugin.story.model.b.b.b(j, (com.tencent.mm.plugin.story.model.b.a) obj2)) {
                    fVar.rVh = false;
                    this.rZe.czD();
                }
            }
        }
        AppMethodBeat.o(109656);
    }

    public final void n(int i, int i2, boolean z) {
        AppMethodBeat.i(109657);
        ab.i(this.TAG, "LogStory: setPrivacy row:" + i + " column:" + i2);
        if (i >= 0 && i < this.rZZ.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            boolean z2 = !z;
            Object obj = ((ArrayList) this.rYW.get(i)).get(i2);
            j.o(obj, "dateGalleryMap[row][column]");
            com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
            ab.i(this.TAG, "LogStory: setPrivacy storyinfo " + gVar + " targetPrivacy:" + z2);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe((int) gVar.rWb.xDa);
            if (Fe != null) {
                long j;
                com.tencent.mm.plugin.story.g.e eVar = com.tencent.mm.plugin.story.g.e.sbS;
                com.tencent.mm.plugin.story.g.e.lD(z2);
                if (z2) {
                    j = 3;
                } else {
                    j = 4;
                }
                com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.a(j, String.valueOf(Fe.field_storyID), 2, 0, 16);
                com.tencent.mm.plugin.story.model.n.a aVar2 = n.rTi;
                com.tencent.mm.plugin.story.model.n.a.b(Fe.field_storyID, (int) Fe.xDa, z2, Fe.cBX());
                AppMethodBeat.o(109657);
                return;
            }
        }
        AppMethodBeat.o(109657);
    }

    public final void ES(int i) {
        AppMethodBeat.i(109658);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new a(this, i));
        AppMethodBeat.o(109658);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(109659);
        j.p(mVar, "scene");
        ab.i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str);
        if ((mVar instanceof com.tencent.mm.plugin.story.model.a.e) && bo.isEqual(((com.tencent.mm.plugin.story.model.a.e) mVar).userName, this.username)) {
            Integer num = (Integer) this.rYY.poll();
            if (num != null) {
                int intValue = num.intValue();
                int size = this.rZZ.size();
                if (intValue < 0) {
                    AppMethodBeat.o(109659);
                    return;
                }
                if (size > intValue) {
                    ab.d(this.TAG, intValue + ' ' + ((String) this.rZZ.get(intValue)));
                    this.rZD = false;
                    ((g) this.rYX.get(intValue)).rZv = 2;
                    ab.i(this.TAG, "LogStory: updateUserGalleryItemsFromDb ".concat(String.valueOf(intValue)));
                    Object obj = this.rZZ.get(intValue);
                    j.o(obj, "dateList[dateIndex]");
                    String str2 = (String) obj;
                    Object obj2 = this.rYW.get(intValue);
                    j.o(obj2, "dateGalleryMap[dateIndex]");
                    ArrayList arrayList = (ArrayList) obj2;
                    ArrayList gz = com.tencent.mm.plugin.story.f.h.a.gz(this.username, str2);
                    arrayList.clear();
                    arrayList.addAll(gz);
                    ab.i(this.TAG, "LogStory: db data " + str2 + ' ' + arrayList.size());
                    r(str2, arrayList);
                    czF();
                }
                AppMethodBeat.o(109659);
                return;
            }
            AppMethodBeat.o(109659);
            return;
        }
        if (mVar instanceof com.tencent.mm.plugin.story.model.a.g) {
            com.tencent.mm.plugin.story.model.a.a cyX = ((com.tencent.mm.plugin.story.model.a.g) mVar).cyX();
            if (cyX != null) {
                com.tencent.mm.plugin.story.model.n.a aVar;
                if (cyX instanceof com.tencent.mm.plugin.story.model.a.m) {
                    if (i2 == 0) {
                        aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.EL(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE);
                    }
                    ly(i2 == 0);
                    AppMethodBeat.o(109659);
                    return;
                }
                if (cyX instanceof com.tencent.mm.plugin.story.model.a.n) {
                    ab.i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i + ", errcode:" + i2);
                    if (i2 == 0) {
                        aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.fJ(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE, ((com.tencent.mm.plugin.story.model.a.n) cyX).rVf);
                        if (((com.tencent.mm.plugin.story.model.a.n) cyX).rVf != 1 || ((com.tencent.mm.plugin.story.model.a.n) cyX).rVg) {
                            z = false;
                        }
                        com.tencent.mm.ab.b.a(new h(this, z));
                        AppMethodBeat.o(109659);
                        return;
                    }
                } else if (cyX instanceof com.tencent.mm.plugin.story.model.a.l) {
                    ab.i(this.TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((com.tencent.mm.plugin.story.model.a.g) mVar).cNE + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                    if (i2 == 0) {
                        aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.fK(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE, ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                        if (((com.tencent.mm.plugin.story.model.a.l) cyX).rVe != 1) {
                            z = false;
                        }
                        com.tencent.mm.ab.b.a(new g(this, z));
                    }
                }
                AppMethodBeat.o(109659);
                return;
            }
        }
        AppMethodBeat.o(109659);
    }

    public final void o(int i, int i2, boolean z) {
        AppMethodBeat.i(138816);
        ab.i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(i2)));
        if (i >= 0 && i < this.rZZ.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            boolean z2;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            Object obj = ((ArrayList) this.rYW.get(i)).get(i2);
            j.o(obj, "dateGalleryMap[row][column]");
            com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
            ab.i(this.TAG, "LogStory: setFavorite storyinfo " + gVar + " localid " + gVar.rVZ.cNE + " targetFavorite:" + z2);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe((int) gVar.rWb.xDa);
            if (Fe != null) {
                long j;
                com.tencent.mm.plugin.story.g.e eVar = com.tencent.mm.plugin.story.g.e.sbS;
                com.tencent.mm.plugin.story.g.e.lC(z2);
                if (z2) {
                    j = 1;
                } else {
                    j = 2;
                }
                com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.a(j, String.valueOf(Fe.field_storyID), 2, 0, 16);
                com.tencent.mm.plugin.story.model.n.a aVar2 = n.rTi;
                com.tencent.mm.plugin.story.model.n.a.h(Fe.field_storyID, (int) Fe.xDa, z2);
            }
        }
        AppMethodBeat.o(138816);
    }

    private final void czF() {
        AppMethodBeat.i(109661);
        while (!this.rZD && this.rYY.size() > 0) {
            Object obj = this.rYY.get(0);
            j.o(obj, "loadingIndexQueue[0]");
            int intValue = ((Number) obj).intValue();
            obj = this.rZZ.get(intValue);
            j.o(obj, "dateList[dateIndex]");
            String str = (String) obj;
            ab.i(this.TAG, "LogStory: loadRemoteForDate ".concat(String.valueOf(str)));
            if (((g) this.rYX.get(intValue)).rZv != 2) {
                com.tencent.mm.plugin.story.model.a.e eVar = new com.tencent.mm.plugin.story.model.a.e(this.username, str);
                com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
                j.o(RO, "MMKernel.network()");
                RO.Rg().d((m) eVar);
                this.rZD = true;
                AppMethodBeat.o(109661);
                return;
            }
            this.rYY.remove(0);
        }
        AppMethodBeat.o(109661);
    }
}
