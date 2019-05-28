package com.tencent.mm.plugin.story.f;

import a.a.t;
import a.f.a.r;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;

@l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0016H\u0002J,\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010-\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0016H\u0002J\b\u00102\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u00020\u0017H\u0016J*\u00104\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u00105\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u000107H\u0016J \u00108\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020\u0017H\u0002J\b\u0010;\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R,\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006="}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "galleryCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "deleteItemIndex", "", "getGalleryCallback", "()Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "galleryState", "privateItemIndex", "selectedIndex", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "getUsername", "()Ljava/lang/String;", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "onSetPrivacyCallback", "isPrivacy", "pause", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "updateCommentRead", "Companion", "plugin-story_release"})
public final class j extends h implements com.tencent.mm.ai.f {
    private static final String TAG = TAG;
    private static boolean rZF = true;
    public static final a rZV = new a();
    private int biG = -1;
    private final r<Long, Boolean, String, String, y> rWK = new g(this);
    private final ArrayList<com.tencent.mm.plugin.story.model.d.g> rZR = new ArrayList();
    private int rZS = -1;
    private int rZT = -1;
    final e rZU;
    private int rZd;
    private final String username;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class g extends k implements r<Long, Boolean, String, String, y> {
        final /* synthetic */ j rZW;

        g(j jVar) {
            this.rZW = jVar;
            super(4);
        }

        public final /* synthetic */ Object a(Object obj, Object obj2, Object obj3, Object obj4) {
            int i;
            AppMethodBeat.i(138814);
            long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            String str = (String) obj4;
            a.f.b.j.p((String) obj3, "fromUser");
            a.f.b.j.p(str, "storyOwner");
            if (booleanValue) {
                a aVar = j.rZV;
                j.rZF = true;
            }
            int i2 = 0;
            for (com.tencent.mm.plugin.story.model.d.g gVar : this.rZW.rZR) {
                if ((gVar.rWa.rUJ == longValue ? 1 : null) != null) {
                    i = i2;
                    break;
                }
                i2++;
            }
            i = -1;
            int size = this.rZW.rZR.size();
            if (i >= 0 && size > i) {
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                if (bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                    a.f.b.j.o(this.rZW.rZR.get(i), "galleryItems[index]");
                    aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                    final com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(longValue);
                    if (lx != null) {
                        com.tencent.mm.plugin.story.model.d.g.a aVar3 = com.tencent.mm.plugin.story.model.d.g.rWe;
                        final com.tencent.mm.plugin.story.model.d.g c = com.tencent.mm.plugin.story.model.d.g.a.c(lx);
                        com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                            final /* synthetic */ g rZX;

                            public final /* synthetic */ Object invoke() {
                                AppMethodBeat.i(109621);
                                if (booleanValue && !lx.cBX()) {
                                    this.rZX.rZW.rZR.set(i, c);
                                    this.rZX.rZW.rZU.j(0, this.rZX.rZW.rZR);
                                    this.rZX.rZW.rZU.ak(0, i, 1);
                                    this.rZX.rZW.rZU.czD();
                                    j.f(this.rZX.rZW);
                                }
                                y yVar = y.AUy;
                                AppMethodBeat.o(109621);
                                return yVar;
                            }
                        });
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138814);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ j rZW;
        final /* synthetic */ boolean rZn;

        e(j jVar, boolean z) {
            this.rZW = jVar;
            this.rZn = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109619);
            this.rZW.rZU.lB(this.rZn);
            y yVar = y.AUy;
            AppMethodBeat.o(109619);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ boolean rXE;
        final /* synthetic */ j rZW;

        d(j jVar, boolean z) {
            this.rZW = jVar;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109618);
            if (this.rXE) {
                int size = this.rZW.rZR.size();
                int b = this.rZW.rZS;
                if (b >= 0 && size > b) {
                    this.rZW.rZR.remove(this.rZW.rZS);
                    this.rZW.rZU.j(0, this.rZW.rZR);
                    this.rZW.rZU.aj(0, this.rZW.rZS, 1);
                    this.rZW.rZU.czD();
                }
            }
            this.rZW.rZU.lz(this.rXE);
            this.rZW.rZS = -1;
            y yVar = y.AUy;
            AppMethodBeat.o(109618);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ j rZW;

        f(j jVar) {
            this.rZW = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109620);
            int size = this.rZW.rZR.size();
            int d = this.rZW.rZT;
            if (d >= 0 && size > d) {
                this.rZW.rZR.remove(this.rZW.rZT);
                this.rZW.rZU.j(0, this.rZW.rZR);
                this.rZW.rZU.aj(0, this.rZW.rZT, 1);
                this.rZW.rZU.czD();
            }
            this.rZW.rZT = -1;
            y yVar = y.AUy;
            AppMethodBeat.o(109620);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$initLoad$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
    public static final class c implements android.support.v7.h.d {
        final /* synthetic */ j rZW;

        c(j jVar) {
            this.rZW = jVar;
        }

        public final void a(int i, int i2, Object obj) {
            AppMethodBeat.i(109614);
            ab.i(j.TAG, "onChanged: " + i + ' ' + i2);
            this.rZW.rZU.ak(0, i, i2);
            AppMethodBeat.o(109614);
        }

        public final void I(int i, int i2) {
            AppMethodBeat.i(109615);
            ab.i(j.TAG, "onMoved: " + i + ' ' + i2);
            AppMethodBeat.o(109615);
        }

        public final void G(int i, int i2) {
            AppMethodBeat.i(109616);
            ab.i(j.TAG, "onInserted: " + i + ' ' + i2);
            this.rZW.rZU.ai(0, i, i2);
            AppMethodBeat.o(109616);
        }

        public final void H(int i, int i2) {
            AppMethodBeat.i(109617);
            ab.i(j.TAG, "onRemoved: " + i + ' ' + i2);
            this.rZW.rZU.aj(0, i, i2);
            AppMethodBeat.o(109617);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.story.model.d.g rZj;

        b(com.tencent.mm.plugin.story.model.d.g gVar) {
            this.rZj = gVar;
        }

        public final void run() {
            AppMethodBeat.i(109613);
            ab.i(j.TAG, "LogStory: deleteItem fake " + this.rZj);
            com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
            com.tencent.mm.plugin.story.model.n.a.EL(this.rZj.rVZ.cNE);
            l lVar = l.sac;
            l.li(this.rZj.rVZ.timeStamp);
            lVar = l.sac;
            lVar = l.sac;
            l.b(l.lh(this.rZj.rVZ.timeStamp));
            AppMethodBeat.o(109613);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$Companion;", "", "()V", "TAG", "", "needLoadRemote", "", "getNeedLoadRemote", "()Z", "setNeedLoadRemote", "(Z)V", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static final /* synthetic */ void f(j jVar) {
        AppMethodBeat.i(109640);
        jVar.czG();
        AppMethodBeat.o(109640);
    }

    public j(String str, e eVar) {
        a.f.b.j.p(str, "username");
        a.f.b.j.p(eVar, "galleryCallback");
        AppMethodBeat.i(109638);
        this.username = str;
        this.rZU = eVar;
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(273, (com.tencent.mm.ai.f) this);
        RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(764, (com.tencent.mm.ai.f) this);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.a(this.rWK);
        this.rZU.EP(1);
        AppMethodBeat.o(109638);
    }

    static {
        AppMethodBeat.i(109639);
        AppMethodBeat.o(109639);
    }

    public final void ET(int i) {
    }

    private final void ly(boolean z) {
        AppMethodBeat.i(109623);
        com.tencent.mm.ab.b.a(new d(this, z));
        AppMethodBeat.o(109623);
    }

    public final void EO(int i) {
        AppMethodBeat.i(109624);
        this.rZd = i;
        if (i == 0) {
            czE();
            AppMethodBeat.o(109624);
            return;
        }
        czA();
        AppMethodBeat.o(109624);
    }

    public final void czC() {
        AppMethodBeat.i(109625);
        ab.i(TAG, "LogStory: initLoad");
        com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) t.x(this.rZR, 0);
        ArrayList bu = com.tencent.mm.plugin.story.f.h.a.bu(this.username, false);
        ab.i(TAG, "LogStory: preload Db count " + bu.size());
        com.tencent.mm.plugin.story.model.d.g gVar2 = (com.tencent.mm.plugin.story.model.d.g) t.x(bu, 0);
        if (gVar == null || gVar2 == null || gVar.rUJ == gVar2.rUJ) {
            android.support.v7.h.c.b m = com.tencent.mm.plugin.story.f.h.a.m(this.rZR, bu);
            this.rZR.clear();
            this.rZR.addAll(bu);
            this.rZU.j(0, this.rZR);
            this.rZU.czD();
            m.a((android.support.v7.h.d) new c(this));
        } else {
            this.rZR.clear();
            this.rZR.addAll(bu);
            this.rZU.j(0, this.rZR);
            this.rZU.ER(0);
            this.rZU.czD();
        }
        czG();
        czE();
        AppMethodBeat.o(109625);
    }

    public final void czE() {
        AppMethodBeat.i(109626);
        if (rZF && this.rZd == 0) {
            rZF = false;
            com.tencent.mm.plugin.story.api.e eVar = (com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            eVar.loadStory(com.tencent.mm.plugin.story.model.j.a.cnk(), null);
        }
        AppMethodBeat.o(109626);
    }

    public final void fM(int i, int i2) {
        AppMethodBeat.i(109627);
        ab.i(TAG, "LogStory: deleteItem ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.rZR.size()) {
            this.rZS = i2;
            Object obj = this.rZR.get(i2);
            a.f.b.j.o(obj, "galleryItems[column]");
            com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
            ab.i(TAG, "LogStory: deleteItem1 storyinfo " + gVar + " deleteItemIndex " + this.rZS + " localid " + gVar.rVZ.cNE);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(gVar.rVZ.cNE);
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().aba(gVar.rVZ.cNE + '_' + gVar.rVZ.fDG);
            if (Fe != null) {
                ab.i(TAG, "LogStory: deleteItem2 storyinfo " + gVar + " deleteItemIndex " + this.rZS + " localid " + gVar.rVZ.cNE + ' ' + Fe.field_storyID);
                if (Fe.field_storyID == 0) {
                    com.tencent.mm.plugin.story.model.n.a aVar3 = n.rTi;
                    com.tencent.mm.plugin.story.model.n.a.EL(gVar.rVZ.cNE);
                    ly(true);
                } else if (this.rZS != -1) {
                    com.tencent.mm.plugin.story.model.n.a aVar4 = n.rTi;
                    com.tencent.mm.plugin.story.model.n.a.D(Fe.field_storyID, gVar.rVZ.cNE);
                }
            }
            if (gVar.rVZ.cze()) {
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cno().post(new b(gVar));
            }
        }
        AppMethodBeat.o(109627);
    }

    public final void czB() {
        AppMethodBeat.i(109628);
        this.rZS = -1;
        com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
        com.tencent.mm.plugin.story.model.n.a.cyo();
        AppMethodBeat.o(109628);
    }

    public final void fN(int i, int i2) {
        AppMethodBeat.i(109629);
        this.biG = i2;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.o(109629);
    }

    public final void n(int i, int i2, boolean z) {
        AppMethodBeat.i(109630);
        ab.i(TAG, "LogStory: setPrivacy ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.rZR.size()) {
            this.rZT = i2;
            boolean z2 = !z;
            Object obj = this.rZR.get(i2);
            a.f.b.j.o(obj, "galleryItems[column]");
            com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
            ab.i(TAG, "LogStory: setPrivacy storyinfo " + gVar + " setPrivacyItemIndex " + this.rZT + " localid " + gVar.rVZ.cNE + " targetPrivacy:" + z2);
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
                h hVar = h.scu;
                h.a(j, String.valueOf(Fe.field_storyID), 1, 0, 24);
                com.tencent.mm.plugin.story.model.n.a aVar2 = n.rTi;
                com.tencent.mm.plugin.story.model.n.a.b(Fe.field_storyID, (int) Fe.xDa, z2, false);
                AppMethodBeat.o(109630);
                return;
            }
        }
        AppMethodBeat.o(109630);
    }

    public final void o(int i, int i2, boolean z) {
        AppMethodBeat.i(138815);
        ab.i(TAG, "LogStory: setFavorite ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.rZR.size()) {
            boolean z2;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            Object obj = this.rZR.get(i2);
            a.f.b.j.o(obj, "galleryItems[column]");
            com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
            ab.i(TAG, "LogStory: setFavorite storyinfo " + gVar + " localid " + gVar.rVZ.cNE + " targetFavorite:" + z2);
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
                h hVar = h.scu;
                h.a(j, String.valueOf(Fe.field_storyID), 1, 0, 24);
                com.tencent.mm.plugin.story.model.n.a aVar2 = n.rTi;
                com.tencent.mm.plugin.story.model.n.a.h(Fe.field_storyID, (int) Fe.xDa, z2);
                AppMethodBeat.o(138815);
                return;
            }
        }
        AppMethodBeat.o(138815);
    }

    private final void czA() {
        com.tencent.mm.plugin.story.model.d.f fVar;
        Object obj = null;
        AppMethodBeat.i(109632);
        com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) t.x(this.rZR, this.biG);
        if (gVar != null) {
            fVar = gVar.rWa;
        } else {
            fVar = null;
        }
        String str = TAG;
        StringBuilder append = new StringBuilder("setSelectedRead ").append(this.biG).append(", ");
        if (fVar != null) {
            obj = Boolean.valueOf(fVar.rVh);
        }
        ab.i(str, append.append(obj).toString());
        if (fVar != null && fVar.rrj.size() > 0) {
            com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
            long j = fVar.rUJ;
            Object last = fVar.rrj.getLast();
            a.f.b.j.o(last, "comment.commentList.last");
            if (com.tencent.mm.plugin.story.model.b.b.b(j, (com.tencent.mm.plugin.story.model.b.a) last)) {
                fVar.rVh = false;
                this.rZU.czD();
            }
        }
        czG();
        AppMethodBeat.o(109632);
    }

    private final void czG() {
        boolean z;
        AppMethodBeat.i(109633);
        Iterable<com.tencent.mm.plugin.story.model.d.g> iterable = this.rZR;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (com.tencent.mm.plugin.story.model.d.g gVar : iterable) {
                if (gVar.rWa.rVh) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean isEmpty = this.rZR.isEmpty();
        ab.i(TAG, "LogStory: updateCommentRead " + z + ' ' + isEmpty);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.M(z, isEmpty);
        AppMethodBeat.o(109633);
    }

    public final void resume() {
        AppMethodBeat.i(109634);
        ab.i(TAG, "LogStory: resume");
        AppMethodBeat.o(109634);
    }

    public final void pause() {
        AppMethodBeat.i(109635);
        ab.i(TAG, "LogStory: pause");
        AppMethodBeat.o(109635);
    }

    public final void destroy() {
        AppMethodBeat.i(109636);
        ab.i(TAG, "LogStory: destroy");
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(273, (com.tencent.mm.ai.f) this);
        RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(764, (com.tencent.mm.ai.f) this);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.b(this.rWK);
        AppMethodBeat.o(109636);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(109637);
        ab.i(TAG, "LogStory: " + i + ' ' + i2 + ' ' + str);
        if ((mVar instanceof com.tencent.mm.plugin.story.model.a.j) && bo.isEqual(((com.tencent.mm.plugin.story.model.a.j) mVar).userName, this.username)) {
            if (i == 0 || i == 4) {
                int i3 = ((com.tencent.mm.plugin.story.model.a.j) mVar).cvd;
                com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
                if (i3 == com.tencent.mm.plugin.story.h.a.sdi) {
                    rZF = false;
                    czC();
                    AppMethodBeat.o(109637);
                    return;
                }
            }
        } else if (mVar instanceof com.tencent.mm.plugin.story.model.a.g) {
            com.tencent.mm.plugin.story.model.a.a cyX = ((com.tencent.mm.plugin.story.model.a.g) mVar).cyX();
            if (cyX != null) {
                if (cyX instanceof com.tencent.mm.plugin.story.model.a.m) {
                    if (i2 == 0) {
                        com.tencent.mm.plugin.story.model.n.a aVar2 = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.EL(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE);
                    }
                    ly(i2 == 0);
                    AppMethodBeat.o(109637);
                    return;
                }
                com.tencent.mm.plugin.story.model.n.a aVar3;
                if (cyX instanceof com.tencent.mm.plugin.story.model.a.n) {
                    ab.i(TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i + ", errcode:" + i2);
                    if (i2 == 0) {
                        aVar3 = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.fJ(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE, ((com.tencent.mm.plugin.story.model.a.n) cyX).rVf);
                        com.tencent.mm.ab.b.a(new f(this));
                        AppMethodBeat.o(109637);
                        return;
                    }
                } else if (cyX instanceof com.tencent.mm.plugin.story.model.a.l) {
                    ab.i(TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((com.tencent.mm.plugin.story.model.a.g) mVar).cNE + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                    if (i2 == 0) {
                        aVar3 = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.fK(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE, ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                        if (((com.tencent.mm.plugin.story.model.a.l) cyX).rVe != 1) {
                            z = false;
                        }
                        com.tencent.mm.ab.b.a(new e(this, z));
                    }
                }
                AppMethodBeat.o(109637);
                return;
            }
        }
        AppMethodBeat.o(109637);
    }
}
