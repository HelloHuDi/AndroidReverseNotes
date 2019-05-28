package com.tencent.mm.plugin.story.f;

import a.f.a.r;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\u001e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0002J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0015H\u0002J*\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J \u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u00152\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u001dH\u0002J*\u00108\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J \u0010<\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0015H\u0016J\b\u0010>\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R,\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/FavStoryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "dateList", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "TAG", "dateGalleryMap", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "", "deleteRowIndex", "galleryState", "isSelf", "", "loadingIndexQueue", "Ljava/util/LinkedList;", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initLoad", "notifyDateUpdate", "userIndex", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "selectedDate", "onSetPrivacyCallback", "isPrivacy", "preloadForUser", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "plugin-story_release"})
public final class d extends h implements com.tencent.mm.ai.f {
    private final String TAG = "MicroMsg.FavStoryPresenter";
    private boolean czr;
    private final List<String> rVW;
    private final r<Long, Boolean, String, String, y> rWK = new i(this);
    private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> rYW = new ArrayList();
    private final ArrayList<g> rYX = new ArrayList();
    private final LinkedList<Integer> rYY = new LinkedList();
    private int rYZ = -1;
    private int rZa = -1;
    private int rZb = -1;
    private int rZc = -1;
    private int rZd;
    private final e rZe;
    private final String username;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ d rZf;
        final /* synthetic */ int rZg;
        final /* synthetic */ int rZh;

        a(d dVar, int i, int i2) {
            this.rZf = dVar;
            this.rZg = i;
            this.rZh = i2;
        }

        public final void run() {
            AppMethodBeat.i(109555);
            this.rZf.rYZ = this.rZg;
            this.rZf.rZa = this.rZh;
            Object obj = ((ArrayList) this.rZf.rYW.get(this.rZg)).get(this.rZh);
            j.o(obj, "dateGalleryMap[row][column]");
            final com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(gVar.rVZ.cNE);
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().aba(gVar.rVZ.cNE + '_' + gVar.rVZ.fDG);
            if (Fe != null) {
                ab.i(this.rZf.TAG, "LogStory: deleteItem2 storyinfo " + gVar + " deleteItemRow " + this.rZf.rYZ + " deleteItemCol " + this.rZf.rZa + " localid " + gVar.rVZ.cNE + ' ' + Fe.field_storyID);
                if (Fe.field_storyID == 0) {
                    com.tencent.mm.plugin.story.model.n.a aVar3 = n.rTi;
                    com.tencent.mm.plugin.story.model.n.a.EL(gVar.rVZ.cNE);
                    d.f(this.rZf);
                } else if (!(this.rZf.rYZ == -1 || this.rZf.rZa == -1)) {
                    com.tencent.mm.plugin.story.model.n.a aVar4 = n.rTi;
                    com.tencent.mm.plugin.story.model.n.a.D(Fe.field_storyID, gVar.rVZ.cNE);
                }
            }
            if (gVar.rVZ.cze()) {
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cno().post(new Runnable(this) {
                    final /* synthetic */ a rZi;

                    public final void run() {
                        AppMethodBeat.i(109554);
                        ab.i(this.rZi.rZf.TAG, "LogStory: deleteItem fake " + gVar);
                        com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.EL(gVar.rVZ.cNE);
                        l lVar = l.sac;
                        l.li(gVar.rVZ.timeStamp);
                        lVar = l.sac;
                        lVar = l.sac;
                        l.b(l.lh(gVar.rVZ.timeStamp));
                        AppMethodBeat.o(109554);
                    }
                });
            }
            AppMethodBeat.o(109555);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends k implements a.f.a.a<y> {
        final /* synthetic */ d rZf;
        final /* synthetic */ boolean rZn;

        g(d dVar, boolean z) {
            this.rZf = dVar;
            this.rZn = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109561);
            this.rZf.rZe.lB(this.rZn);
            y yVar = y.AUy;
            AppMethodBeat.o(109561);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class i extends k implements r<Long, Boolean, String, String, y> {
        final /* synthetic */ d rZf;

        i(d dVar) {
            this.rZf = dVar;
            super(4);
        }

        public final /* synthetic */ Object a(Object obj, Object obj2, Object obj3, Object obj4) {
            AppMethodBeat.i(138800);
            long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            String str = (String) obj4;
            j.p((String) obj3, "fromUser");
            j.p(str, "storyOwner");
            int i = 0;
            for (Iterable<com.tencent.mm.plugin.story.model.d.g> iterable : this.rZf.rYW) {
                Object obj5;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (com.tencent.mm.plugin.story.model.d.g gVar : iterable) {
                        if (gVar.rUJ == longValue) {
                            obj5 = 1;
                            continue;
                        } else {
                            obj5 = null;
                            continue;
                        }
                        if (obj5 != null) {
                            obj5 = 1;
                            break;
                        }
                    }
                }
                obj5 = null;
                if (obj5 != null) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                int i2;
                Object obj6 = this.rZf.rYW.get(i);
                j.o(obj6, "dateGalleryMap[rowIndex]");
                final ArrayList<com.tencent.mm.plugin.story.model.d.g> arrayList = (ArrayList) obj6;
                int i3 = 0;
                for (com.tencent.mm.plugin.story.model.d.g gVar2 : arrayList) {
                    if ((gVar2.rUJ == longValue ? 1 : null) != null) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                i2 = -1;
                if (i2 != -1) {
                    com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(longValue);
                    if (lx != null) {
                        com.tencent.mm.plugin.story.model.d.g.a aVar2 = com.tencent.mm.plugin.story.model.d.g.rWe;
                        final com.tencent.mm.plugin.story.model.d.g c = com.tencent.mm.plugin.story.model.d.g.a.c(lx);
                        com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                            final /* synthetic */ i rZp;

                            public final /* synthetic */ Object invoke() {
                                AppMethodBeat.i(138799);
                                if (booleanValue) {
                                    ab.i(this.rZp.rZf.TAG, "commentChanged, will update row:" + i + " col:" + i2);
                                    arrayList.set(i2, c);
                                    this.rZp.rZf.rZe.j(i, arrayList);
                                    this.rZp.rZf.rZe.ak(i, i2, 1);
                                    this.rZp.rZf.rZe.czD();
                                }
                                y yVar = y.AUy;
                                AppMethodBeat.o(138799);
                                return yVar;
                            }
                        });
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138800);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/FavStoryPresenter$onSetFavoriteCallback$1$1"})
    static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ d rZf;
        final /* synthetic */ int rZm;

        f(int i, d dVar) {
            this.rZm = i;
            this.rZf = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109560);
            this.rZf.rZe.EQ(this.rZm);
            y yVar = y.AUy;
            AppMethodBeat.o(109560);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends k implements a.f.a.a<y> {
        final /* synthetic */ d rZf;
        final /* synthetic */ boolean rZo;

        h(d dVar, boolean z) {
            this.rZf = dVar;
            this.rZo = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109562);
            this.rZf.rZe.lA(this.rZo);
            y yVar = y.AUy;
            AppMethodBeat.o(109562);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ d rZf;
        final /* synthetic */ int rZk;

        b(d dVar, int i) {
            this.rZf = dVar;
            this.rZk = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109556);
            this.rZf.rZe.EQ(this.rZk);
            y yVar = y.AUy;
            AppMethodBeat.o(109556);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ d rZf;
        final /* synthetic */ int rZk;
        final /* synthetic */ List rZl;

        c(d dVar, int i, List list) {
            this.rZf = dVar;
            this.rZk = i;
            this.rZl = list;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109557);
            this.rZf.rZe.j(this.rZk, this.rZl);
            this.rZf.rZe.ER(this.rZk);
            this.rZf.rZe.czD();
            y yVar = y.AUy;
            AppMethodBeat.o(109557);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ d rZf;
        final /* synthetic */ int rZg;

        e(d dVar, int i) {
            this.rZf = dVar;
            this.rZg = i;
        }

        public final void run() {
            AppMethodBeat.i(109559);
            if (((g) this.rZf.rYX.get(this.rZg)).rZv != 2) {
                this.rZf.rYY.add(Integer.valueOf(this.rZg));
            }
            AppMethodBeat.o(109559);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ boolean rXE;
        final /* synthetic */ d rZf;

        d(d dVar, boolean z) {
            this.rZf = dVar;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109558);
            if (this.rXE) {
                int size = this.rZf.rYW.size();
                int b = this.rZf.rYZ;
                if (b >= 0 && size > b) {
                    Object obj = this.rZf.rYW.get(this.rZf.rYZ);
                    j.o(obj, "dateGalleryMap[deleteRowIndex]");
                    ArrayList arrayList = (ArrayList) obj;
                    b = arrayList.size();
                    int c = this.rZf.rZa;
                    if (c >= 0 && b > c) {
                        arrayList.remove(this.rZf.rZa);
                        d.a(this.rZf, this.rZf.rYZ, arrayList);
                    }
                }
            }
            this.rZf.rZe.lz(this.rXE);
            this.rZf.rYZ = -1;
            this.rZf.rZa = -1;
            y yVar = y.AUy;
            AppMethodBeat.o(109558);
            return yVar;
        }
    }

    public static final /* synthetic */ void a(d dVar, int i, List list) {
        AppMethodBeat.i(138805);
        dVar.i(i, list);
        AppMethodBeat.o(138805);
    }

    public static final /* synthetic */ void f(d dVar) {
        AppMethodBeat.i(109575);
        dVar.ly(true);
        AppMethodBeat.o(109575);
    }

    public d(String str, List<String> list, e eVar) {
        j.p(str, "username");
        j.p(list, "dateList");
        j.p(eVar, "galleryUserCallback");
        AppMethodBeat.i(109573);
        this.username = str;
        this.rVW = list;
        this.rZe = eVar;
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        this.czr = bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), this.username);
        this.rZe.EP(this.rVW.size());
        for (String str2 : this.rVW) {
            ab.i(this.TAG, "LogStory: ".concat(String.valueOf(str2)));
            this.rYW.add(new ArrayList());
            this.rYX.add(new g(str2));
        }
        if (this.czr) {
            com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
            j.o(RO, "MMKernel.network()");
            RO.Rg().a(764, (com.tencent.mm.ai.f) this);
        }
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.a(this.rWK);
        AppMethodBeat.o(109573);
    }

    private final void ly(boolean z) {
        AppMethodBeat.i(109563);
        com.tencent.mm.ab.b.a(new d(this, z));
        AppMethodBeat.o(109563);
    }

    private final void i(int i, List<com.tencent.mm.plugin.story.model.d.g> list) {
        AppMethodBeat.i(138801);
        if (list.isEmpty()) {
            com.tencent.mm.ab.b.a(new b(this, i));
            AppMethodBeat.o(138801);
            return;
        }
        com.tencent.mm.ab.b.a(new c(this, i, list));
        AppMethodBeat.o(138801);
    }

    private final void czA() {
        AppMethodBeat.i(138802);
        if (this.rZb >= 0 && this.rZb < this.rYW.size() && this.rZc >= 0 && this.rZc < ((ArrayList) this.rYW.get(this.rZb)).size()) {
            Object obj = ((ArrayList) this.rYW.get(this.rZb)).get(this.rZc);
            j.o(obj, "dateGalleryMap[selectedRow][selectedCol]");
            com.tencent.mm.plugin.story.model.d.f fVar = ((com.tencent.mm.plugin.story.model.d.g) obj).rWa;
            ab.i(this.TAG, "setSelectedRead " + this.rZc + ", " + fVar.rVh);
            if (fVar.rrj.size() > 0) {
                com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
                long j = fVar.rUJ;
                obj = fVar.rrj.getLast();
                j.o(obj, "comment.commentList.last");
                if (com.tencent.mm.plugin.story.model.b.b.b(j, (com.tencent.mm.plugin.story.model.b.a) obj)) {
                    fVar.rVh = false;
                    this.rZe.czD();
                }
            }
        }
        AppMethodBeat.o(138802);
    }

    public final void czB() {
        AppMethodBeat.i(109565);
        this.rYZ = -1;
        this.rZa = -1;
        com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
        com.tencent.mm.plugin.story.model.n.a.cyo();
        AppMethodBeat.o(109565);
    }

    public final void destroy() {
        AppMethodBeat.i(109566);
        if (this.czr) {
            com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
            j.o(RO, "MMKernel.network()");
            RO.Rg().b(764, (com.tencent.mm.ai.f) this);
        }
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.b(this.rWK);
        AppMethodBeat.o(109566);
    }

    public final void czC() {
        int i;
        Object obj;
        int i2 = 0;
        AppMethodBeat.i(109567);
        Iterator it = this.rVW.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            it.next();
            i = i3 + 1;
            if (i3 < 0) {
                a.a.l.dWs();
            }
            ((g) this.rYX.get(i3)).rZv = 1;
            i3 = i;
        }
        String str = this.username;
        j.p(str, "username");
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        Iterator it2 = cxT.bx(str, bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk())).iterator();
        while (it2.hasNext()) {
            com.tencent.mm.plugin.story.h.j jVar = (com.tencent.mm.plugin.story.h.j) it2.next();
            cfb cBR = jVar.cBR();
            if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                com.tencent.mm.plugin.story.model.d.g.a aVar3 = com.tencent.mm.plugin.story.model.d.g.rWe;
                j.o(jVar, "story");
                arrayList.add(com.tencent.mm.plugin.story.model.d.g.a.c(jVar));
                ab.i(h.TAG, "getFavGalleryItemsFromDb story username " + str + ' ' + arrayList.size() + ' ' + "content " + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + " id:" + jVar.field_storyID + " storyUsername: " + jVar.field_userName);
            }
        }
        if (arrayList.size() > 0) {
            i = 0;
            for (Object obj2 : arrayList) {
                int i4 = i + 1;
                if (i < 0) {
                    a.a.l.dWs();
                }
                com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj2;
                if (i < this.rYW.size()) {
                    ((ArrayList) this.rYW.get(i)).add(gVar);
                }
                i = i4;
            }
            ab.i(this.TAG, "LogStory: preload Db data " + arrayList.size());
        } else {
            ab.i(this.TAG, "LogStory: initLoad no data");
        }
        it = this.rVW.iterator();
        while (it.hasNext()) {
            it.next();
            i = i2 + 1;
            if (i2 < 0) {
                a.a.l.dWs();
            }
            obj2 = this.rYW.get(i2);
            j.o(obj2, "dateGalleryMap[index]");
            i(i2, (List) obj2);
            i2 = i;
        }
        AppMethodBeat.o(109567);
    }

    public final void fM(int i, int i2) {
        AppMethodBeat.i(109568);
        ab.i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(i)));
        if (i >= 0 && i < this.rYW.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cno().post(new a(this, i, i2));
        }
        AppMethodBeat.o(109568);
    }

    public final void EO(int i) {
        AppMethodBeat.i(138803);
        this.rZd = i;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.o(138803);
    }

    public final void fN(int i, int i2) {
        AppMethodBeat.i(109569);
        ab.d(this.TAG, "onSelected row=" + i + " column=" + i2);
        this.rZb = i;
        this.rZc = i2;
        if (this.rZd == 1) {
            czA();
        }
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new e(this, i));
        AppMethodBeat.o(109569);
    }

    public final void n(int i, int i2, boolean z) {
        AppMethodBeat.i(109570);
        ab.i(this.TAG, "LogStory: setPrivacy row:" + i + " column:" + i2);
        if (i >= 0 && i < this.rVW.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
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
                com.tencent.mm.plugin.story.g.h.a(j, String.valueOf(Fe.field_storyID), 0, 0, 28);
                com.tencent.mm.plugin.story.model.n.a aVar2 = n.rTi;
                com.tencent.mm.plugin.story.model.n.a.b(Fe.field_storyID, (int) Fe.xDa, z2, Fe.cBX());
            }
        }
        AppMethodBeat.o(109570);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(109571);
        j.p(mVar, "scene");
        ab.i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str);
        if (mVar instanceof com.tencent.mm.plugin.story.model.a.g) {
            com.tencent.mm.plugin.story.model.a.a cyX = ((com.tencent.mm.plugin.story.model.a.g) mVar).cyX();
            if (cyX != null) {
                com.tencent.mm.plugin.story.model.n.a aVar;
                if (cyX instanceof com.tencent.mm.plugin.story.model.a.m) {
                    boolean z;
                    if (i2 == 0) {
                        aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.EL(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE);
                    }
                    if (i2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ly(z);
                    AppMethodBeat.o(109571);
                    return;
                }
                boolean z2;
                if (cyX instanceof com.tencent.mm.plugin.story.model.a.n) {
                    ab.i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i + ", errcode:" + i2);
                    if (i2 == 0) {
                        aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.fJ(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE, ((com.tencent.mm.plugin.story.model.a.n) cyX).rVf);
                        if (((com.tencent.mm.plugin.story.model.a.n) cyX).rVf != 1 || ((com.tencent.mm.plugin.story.model.a.n) cyX).rVg) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        com.tencent.mm.ab.b.a(new h(this, z2));
                        AppMethodBeat.o(109571);
                        return;
                    }
                } else if (cyX instanceof com.tencent.mm.plugin.story.model.a.l) {
                    ab.i(this.TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((com.tencent.mm.plugin.story.model.a.g) mVar).cNE + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                    if (i2 == 0) {
                        Object obj;
                        aVar = n.rTi;
                        com.tencent.mm.plugin.story.model.n.a.fK(((com.tencent.mm.plugin.story.model.a.g) mVar).cNE, ((com.tencent.mm.plugin.story.model.a.l) cyX).rVe);
                        for (Object next : this.rYW) {
                            for (Object next2 : (ArrayList) next) {
                                if (((int) ((com.tencent.mm.plugin.story.model.d.g) next2).rWb.xDa) == ((com.tencent.mm.plugin.story.model.a.g) mVar).cNE) {
                                    obj = 1;
                                    continue;
                                } else {
                                    obj = null;
                                    continue;
                                }
                                if (obj != null) {
                                    break;
                                }
                            }
                            Object next22 = null;
                            if (next22 != null) {
                                obj = 1;
                                continue;
                            } else {
                                obj = null;
                                continue;
                            }
                            if (obj != null) {
                                obj = next;
                                break;
                            }
                        }
                        obj = null;
                        ArrayList arrayList = (ArrayList) obj;
                        if (((com.tencent.mm.plugin.story.model.a.l) cyX).rVe == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!(z2 || arrayList == null)) {
                            int indexOf = this.rYW.indexOf(arrayList);
                            this.rYW.remove(arrayList);
                            com.tencent.mm.ab.b.a(new f(indexOf, this));
                        }
                        com.tencent.mm.ab.b.a(new g(this, z2));
                    }
                }
                AppMethodBeat.o(109571);
                return;
            }
        }
        AppMethodBeat.o(109571);
    }

    public final void o(int i, int i2, boolean z) {
        AppMethodBeat.i(138804);
        ab.i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(i2)));
        if (i >= 0 && i < this.rVW.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
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
                com.tencent.mm.plugin.story.g.h.a(j, String.valueOf(Fe.field_storyID), 0, 0, 28);
                com.tencent.mm.plugin.story.model.n.a aVar2 = n.rTi;
                com.tencent.mm.plugin.story.model.n.a.h(Fe.field_storyID, (int) Fe.xDa, z2);
            }
        }
        AppMethodBeat.o(138804);
    }
}
