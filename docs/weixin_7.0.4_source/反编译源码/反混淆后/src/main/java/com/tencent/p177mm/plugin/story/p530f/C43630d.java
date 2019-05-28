package com.tencent.p177mm.plugin.story.p530f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p533d.C43639f;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g.C4126a;
import com.tencent.p177mm.plugin.story.model.p744a.C29300n;
import com.tencent.p177mm.plugin.story.model.p744a.C35197l;
import com.tencent.p177mm.plugin.story.model.p744a.C35198m;
import com.tencent.p177mm.plugin.story.model.p744a.C39885a;
import com.tencent.p177mm.plugin.story.model.p744a.C7138g;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C46273e;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\u001e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0002J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0015H\u0002J*\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J \u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u00152\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u001dH\u0002J*\u00108\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J \u0010<\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0015H\u0016J\b\u0010>\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R,\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/FavStoryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "dateList", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "TAG", "dateGalleryMap", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "", "deleteRowIndex", "galleryState", "isSelf", "", "loadingIndexQueue", "Ljava/util/LinkedList;", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initLoad", "notifyDateUpdate", "userIndex", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "selectedDate", "onSetPrivacyCallback", "isPrivacy", "preloadForUser", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.d */
public final class C43630d extends C39876h implements C1202f {
    private final String TAG = "MicroMsg.FavStoryPresenter";
    private boolean czr;
    private final List<String> rVW;
    private final C0011r<Long, Boolean, String, String, C37091y> rWK = new C31427i(this);
    private final ArrayList<ArrayList<C43640g>> rYW = new ArrayList();
    private final ArrayList<C46272g> rYX = new ArrayList();
    private final LinkedList<Integer> rYY = new LinkedList();
    private int rYZ = -1;
    private int rZa = -1;
    private int rZb = -1;
    private int rZc = -1;
    private int rZd;
    private final C43632e rZe;
    private final String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$a */
    static final class C13754a implements Runnable {
        final /* synthetic */ C43630d rZf;
        final /* synthetic */ int rZg;
        final /* synthetic */ int rZh;

        C13754a(C43630d c43630d, int i, int i2) {
            this.rZf = c43630d;
            this.rZg = i;
            this.rZh = i2;
        }

        public final void run() {
            AppMethodBeat.m2504i(109555);
            this.rZf.rYZ = this.rZg;
            this.rZf.rZa = this.rZh;
            Object obj = ((ArrayList) this.rZf.rYW.get(this.rZg)).get(this.rZh);
            C25052j.m39375o(obj, "dateGalleryMap[row][column]");
            final C43640g c43640g = (C43640g) obj;
            C4133a c4133a = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe(c43640g.rVZ.cNE);
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxT().aba(c43640g.rVZ.cNE + '_' + c43640g.rVZ.fDG);
            if (Fe != null) {
                C4990ab.m7416i(this.rZf.TAG, "LogStory: deleteItem2 storyinfo " + c43640g + " deleteItemRow " + this.rZf.rYZ + " deleteItemCol " + this.rZf.rZa + " localid " + c43640g.rVZ.cNE + ' ' + Fe.field_storyID);
                if (Fe.field_storyID == 0) {
                    C29311a c29311a = C29310n.rTi;
                    C29311a.m46531EL(c43640g.rVZ.cNE);
                    C43630d.m78078f(this.rZf);
                } else if (!(this.rZf.rYZ == -1 || this.rZf.rZa == -1)) {
                    C29311a c29311a2 = C29310n.rTi;
                    C29311a.m46530D(Fe.field_storyID, c43640g.rVZ.cNE);
                }
            }
            if (c43640g.rVZ.cze()) {
                c4133a = C43644j.rST;
                C4133a.cno().post(new Runnable(this) {
                    final /* synthetic */ C13754a rZi;

                    public final void run() {
                        AppMethodBeat.m2504i(109554);
                        C4990ab.m7416i(this.rZi.rZf.TAG, "LogStory: deleteItem fake " + c43640g);
                        C29311a c29311a = C29310n.rTi;
                        C29311a.m46531EL(c43640g.rVZ.cNE);
                        C22210l c22210l = C22210l.sac;
                        C22210l.m33885li(c43640g.rVZ.timeStamp);
                        c22210l = C22210l.sac;
                        c22210l = C22210l.sac;
                        C22210l.m33880b(C22210l.m33884lh(c43640g.rVZ.timeStamp));
                        AppMethodBeat.m2505o(109554);
                    }
                });
            }
            AppMethodBeat.m2505o(109555);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$g */
    static final class C13756g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C43630d rZf;
        final /* synthetic */ boolean rZn;

        C13756g(C43630d c43630d, boolean z) {
            this.rZf = c43630d;
            this.rZn = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109561);
            this.rZf.rZe.mo55974lB(this.rZn);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109561);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$i */
    static final class C31427i extends C25053k implements C0011r<Long, Boolean, String, String, C37091y> {
        final /* synthetic */ C43630d rZf;

        C31427i(C43630d c43630d) {
            this.rZf = c43630d;
            super(4);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo47a(Object obj, Object obj2, Object obj3, Object obj4) {
            AppMethodBeat.m2504i(138800);
            long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            String str = (String) obj4;
            C25052j.m39376p((String) obj3, "fromUser");
            C25052j.m39376p(str, "storyOwner");
            int i = 0;
            for (Iterable<C43640g> iterable : this.rZf.rYW) {
                Object obj5;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (C43640g c43640g : iterable) {
                        if (c43640g.rUJ == longValue) {
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
                C25052j.m39375o(obj6, "dateGalleryMap[rowIndex]");
                final ArrayList<C43640g> arrayList = (ArrayList) obj6;
                int i3 = 0;
                for (C43640g c43640g2 : arrayList) {
                    if ((c43640g2.rUJ == longValue ? 1 : null) != null) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                i2 = -1;
                if (i2 != -1) {
                    C4133a c4133a = C43644j.rST;
                    C39879j lx = C4133a.cxT().mo74417lx(longValue);
                    if (lx != null) {
                        C4126a c4126a = C43640g.rWe;
                        final C43640g c = C4126a.m6453c(lx);
                        C8902b.m16042a(new C31214a<C37091y>(this) {
                            final /* synthetic */ C31427i rZp;

                            public final /* synthetic */ Object invoke() {
                                AppMethodBeat.m2504i(138799);
                                if (booleanValue) {
                                    C4990ab.m7416i(this.rZp.rZf.TAG, "commentChanged, will update row:" + i + " col:" + i2);
                                    arrayList.set(i2, c);
                                    this.rZp.rZf.rZe.mo55972j(i, arrayList);
                                    this.rZp.rZf.rZe.mo55970ak(i, i2, 1);
                                    this.rZp.rZf.rZe.czD();
                                }
                                C37091y c37091y = C37091y.AUy;
                                AppMethodBeat.m2505o(138799);
                                return c37091y;
                            }
                        });
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138800);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/FavStoryPresenter$onSetFavoriteCallback$1$1"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$f */
    static final class C31566f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C43630d rZf;
        final /* synthetic */ int rZm;

        C31566f(int i, C43630d c43630d) {
            this.rZm = i;
            this.rZf = c43630d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109560);
            this.rZf.rZe.mo55966EQ(this.rZm);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109560);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$h */
    static final class C31567h extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C43630d rZf;
        final /* synthetic */ boolean rZo;

        C31567h(C43630d c43630d, boolean z) {
            this.rZf = c43630d;
            this.rZo = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109562);
            this.rZf.rZe.mo55973lA(this.rZo);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109562);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$b */
    static final class C35175b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C43630d rZf;
        final /* synthetic */ int rZk;

        C35175b(C43630d c43630d, int i) {
            this.rZf = c43630d;
            this.rZk = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109556);
            this.rZf.rZe.mo55966EQ(this.rZk);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109556);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$c */
    static final class C39873c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C43630d rZf;
        final /* synthetic */ int rZk;
        final /* synthetic */ List rZl;

        C39873c(C43630d c43630d, int i, List list) {
            this.rZf = c43630d;
            this.rZk = i;
            this.rZl = list;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109557);
            this.rZf.rZe.mo55972j(this.rZk, this.rZl);
            this.rZf.rZe.mo55967ER(this.rZk);
            this.rZf.rZe.czD();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109557);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$e */
    static final class C39874e implements Runnable {
        final /* synthetic */ C43630d rZf;
        final /* synthetic */ int rZg;

        C39874e(C43630d c43630d, int i) {
            this.rZf = c43630d;
            this.rZg = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(109559);
            if (((C46272g) this.rZf.rYX.get(this.rZg)).rZv != 2) {
                this.rZf.rYY.add(Integer.valueOf(this.rZg));
            }
            AppMethodBeat.m2505o(109559);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.d$d */
    static final class C43631d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean rXE;
        final /* synthetic */ C43630d rZf;

        C43631d(C43630d c43630d, boolean z) {
            this.rZf = c43630d;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109558);
            if (this.rXE) {
                int size = this.rZf.rYW.size();
                int b = this.rZf.rYZ;
                if (b >= 0 && size > b) {
                    Object obj = this.rZf.rYW.get(this.rZf.rYZ);
                    C25052j.m39375o(obj, "dateGalleryMap[deleteRowIndex]");
                    ArrayList arrayList = (ArrayList) obj;
                    b = arrayList.size();
                    int c = this.rZf.rZa;
                    if (c >= 0 && b > c) {
                        arrayList.remove(this.rZf.rZa);
                        C43630d.m78072a(this.rZf, this.rZf.rYZ, arrayList);
                    }
                }
            }
            this.rZf.rZe.mo55975lz(this.rXE);
            this.rZf.rYZ = -1;
            this.rZf.rZa = -1;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109558);
            return c37091y;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m78072a(C43630d c43630d, int i, List list) {
        AppMethodBeat.m2504i(138805);
        c43630d.m78081i(i, list);
        AppMethodBeat.m2505o(138805);
    }

    /* renamed from: f */
    public static final /* synthetic */ void m78078f(C43630d c43630d) {
        AppMethodBeat.m2504i(109575);
        c43630d.m78082ly(true);
        AppMethodBeat.m2505o(109575);
    }

    public C43630d(String str, List<String> list, C43632e c43632e) {
        C25052j.m39376p(str, "username");
        C25052j.m39376p(list, "dateList");
        C25052j.m39376p(c43632e, "galleryUserCallback");
        AppMethodBeat.m2504i(109573);
        this.username = str;
        this.rVW = list;
        this.rZe = c43632e;
        C4133a c4133a = C43644j.rST;
        this.czr = C5046bo.isEqual(C4133a.cnk(), this.username);
        this.rZe.mo55965EP(this.rVW.size());
        for (String str2 : this.rVW) {
            C4990ab.m7416i(this.TAG, "LogStory: ".concat(String.valueOf(str2)));
            this.rYW.add(new ArrayList());
            this.rYX.add(new C46272g(str2));
        }
        if (this.czr) {
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().mo14539a(764, (C1202f) this);
        }
        C46279b c46279b = C46279b.rVw;
        C46279b.m86757a(this.rWK);
        AppMethodBeat.m2505o(109573);
    }

    /* renamed from: ly */
    private final void m78082ly(boolean z) {
        AppMethodBeat.m2504i(109563);
        C8902b.m16042a(new C43631d(this, z));
        AppMethodBeat.m2505o(109563);
    }

    /* renamed from: i */
    private final void m78081i(int i, List<C43640g> list) {
        AppMethodBeat.m2504i(138801);
        if (list.isEmpty()) {
            C8902b.m16042a(new C35175b(this, i));
            AppMethodBeat.m2505o(138801);
            return;
        }
        C8902b.m16042a(new C39873c(this, i, list));
        AppMethodBeat.m2505o(138801);
    }

    private final void czA() {
        AppMethodBeat.m2504i(138802);
        if (this.rZb >= 0 && this.rZb < this.rYW.size() && this.rZc >= 0 && this.rZc < ((ArrayList) this.rYW.get(this.rZb)).size()) {
            Object obj = ((ArrayList) this.rYW.get(this.rZb)).get(this.rZc);
            C25052j.m39375o(obj, "dateGalleryMap[selectedRow][selectedCol]");
            C43639f c43639f = ((C43640g) obj).rWa;
            C4990ab.m7416i(this.TAG, "setSelectedRead " + this.rZc + ", " + c43639f.rVh);
            if (c43639f.rrj.size() > 0) {
                C46279b c46279b = C46279b.rVw;
                long j = c43639f.rUJ;
                obj = c43639f.rrj.getLast();
                C25052j.m39375o(obj, "comment.commentList.last");
                if (C46279b.m86765b(j, (C39889a) obj)) {
                    c43639f.rVh = false;
                    this.rZe.czD();
                }
            }
        }
        AppMethodBeat.m2505o(138802);
    }

    public final void czB() {
        AppMethodBeat.m2504i(109565);
        this.rYZ = -1;
        this.rZa = -1;
        C29311a c29311a = C29310n.rTi;
        C29311a.cyo();
        AppMethodBeat.m2505o(109565);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(109566);
        if (this.czr) {
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().mo14546b(764, (C1202f) this);
        }
        C46279b c46279b = C46279b.rVw;
        C46279b.m86763b(this.rWK);
        AppMethodBeat.m2505o(109566);
    }

    public final void czC() {
        int i;
        Object obj;
        int i2 = 0;
        AppMethodBeat.m2504i(109567);
        Iterator it = this.rVW.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            it.next();
            i = i3 + 1;
            if (i3 < 0) {
                C7987l.dWs();
            }
            ((C46272g) this.rYX.get(i3)).rZv = 1;
            i3 = i;
        }
        String str = this.username;
        C25052j.m39376p(str, "username");
        ArrayList arrayList = new ArrayList();
        C4133a c4133a = C43644j.rST;
        C46275k cxT = C4133a.cxT();
        C4133a c4133a2 = C43644j.rST;
        Iterator it2 = cxT.mo74407bx(str, C5046bo.isEqual(str, C4133a.cnk())).iterator();
        while (it2.hasNext()) {
            C39879j c39879j = (C39879j) it2.next();
            cfb cBR = c39879j.cBR();
            if (!(cBR.xeA == null || cBR.xeA.wbK.size() == 0)) {
                C4126a c4126a = C43640g.rWe;
                C25052j.m39375o(c39879j, "story");
                arrayList.add(C4126a.m6453c(c39879j));
                C4990ab.m7416i(C39876h.TAG, "getFavGalleryItemsFromDb story username " + str + ' ' + arrayList.size() + ' ' + "content " + ((cek) cBR.xeA.wbK.get(0)).wEH + ' ' + "and " + ((cek) cBR.xeA.wbK.get(0)).Url + " id:" + c39879j.field_storyID + " storyUsername: " + c39879j.field_userName);
            }
        }
        if (arrayList.size() > 0) {
            i = 0;
            for (Object obj2 : arrayList) {
                int i4 = i + 1;
                if (i < 0) {
                    C7987l.dWs();
                }
                C43640g c43640g = (C43640g) obj2;
                if (i < this.rYW.size()) {
                    ((ArrayList) this.rYW.get(i)).add(c43640g);
                }
                i = i4;
            }
            C4990ab.m7416i(this.TAG, "LogStory: preload Db data " + arrayList.size());
        } else {
            C4990ab.m7416i(this.TAG, "LogStory: initLoad no data");
        }
        it = this.rVW.iterator();
        while (it.hasNext()) {
            it.next();
            i = i2 + 1;
            if (i2 < 0) {
                C7987l.dWs();
            }
            obj2 = this.rYW.get(i2);
            C25052j.m39375o(obj2, "dateGalleryMap[index]");
            m78081i(i2, (List) obj2);
            i2 = i;
        }
        AppMethodBeat.m2505o(109567);
    }

    /* renamed from: fM */
    public final void mo37746fM(int i, int i2) {
        AppMethodBeat.m2504i(109568);
        C4990ab.m7416i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(i)));
        if (i >= 0 && i < this.rYW.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
            C4133a c4133a = C43644j.rST;
            C4133a.cno().post(new C13754a(this, i, i2));
        }
        AppMethodBeat.m2505o(109568);
    }

    /* renamed from: EO */
    public final void mo37740EO(int i) {
        AppMethodBeat.m2504i(138803);
        this.rZd = i;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.m2505o(138803);
    }

    /* renamed from: fN */
    public final void mo37747fN(int i, int i2) {
        AppMethodBeat.m2504i(109569);
        C4990ab.m7410d(this.TAG, "onSelected row=" + i + " column=" + i2);
        this.rZb = i;
        this.rZc = i2;
        if (this.rZd == 1) {
            czA();
        }
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C39874e(this, i));
        AppMethodBeat.m2505o(109569);
    }

    /* renamed from: n */
    public final void mo37753n(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(109570);
        C4990ab.m7416i(this.TAG, "LogStory: setPrivacy row:" + i + " column:" + i2);
        if (i >= 0 && i < this.rVW.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
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
                C22212h.m33892a(j, String.valueOf(Fe.field_storyID), 0, 0, 28);
                C29311a c29311a = C29310n.rTi;
                C29311a.m46535b(Fe.field_storyID, (int) Fe.xDa, z2, Fe.cBX());
            }
        }
        AppMethodBeat.m2505o(109570);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(109571);
        C25052j.m39376p(c1207m, "scene");
        C4990ab.m7416i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str);
        if (c1207m instanceof C7138g) {
            C39885a cyX = ((C7138g) c1207m).cyX();
            if (cyX != null) {
                C29311a c29311a;
                if (cyX instanceof C35198m) {
                    boolean z;
                    if (i2 == 0) {
                        c29311a = C29310n.rTi;
                        C29311a.m46531EL(((C7138g) c1207m).cNE);
                    }
                    if (i2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m78082ly(z);
                    AppMethodBeat.m2505o(109571);
                    return;
                }
                boolean z2;
                if (cyX instanceof C29300n) {
                    C4990ab.m7416i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i + ", errcode:" + i2);
                    if (i2 == 0) {
                        c29311a = C29310n.rTi;
                        C29311a.m46537fJ(((C7138g) c1207m).cNE, ((C29300n) cyX).rVf);
                        if (((C29300n) cyX).rVf != 1 || ((C29300n) cyX).rVg) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        C8902b.m16042a(new C31567h(this, z2));
                        AppMethodBeat.m2505o(109571);
                        return;
                    }
                } else if (cyX instanceof C35197l) {
                    C4990ab.m7416i(this.TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((C7138g) c1207m).cNE + ", favorite:" + ((C35197l) cyX).rVe);
                    if (i2 == 0) {
                        Object obj;
                        c29311a = C29310n.rTi;
                        C29311a.m46538fK(((C7138g) c1207m).cNE, ((C35197l) cyX).rVe);
                        for (Object next : this.rYW) {
                            for (Object next2 : (ArrayList) next) {
                                if (((int) ((C43640g) next2).rWb.xDa) == ((C7138g) c1207m).cNE) {
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
                        if (((C35197l) cyX).rVe == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!(z2 || arrayList == null)) {
                            int indexOf = this.rYW.indexOf(arrayList);
                            this.rYW.remove(arrayList);
                            C8902b.m16042a(new C31566f(indexOf, this));
                        }
                        C8902b.m16042a(new C13756g(this, z2));
                    }
                }
                AppMethodBeat.m2505o(109571);
                return;
            }
        }
        AppMethodBeat.m2505o(109571);
    }

    /* renamed from: o */
    public final void mo37754o(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(138804);
        C4990ab.m7416i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(i2)));
        if (i >= 0 && i < this.rVW.size() && i2 >= 0 && i2 < ((ArrayList) this.rYW.get(i)).size()) {
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
                C22212h.m33892a(j, String.valueOf(Fe.field_storyID), 0, 0, 28);
                C29311a c29311a = C29310n.rTi;
                C29311a.m46539h(Fe.field_storyID, (int) Fe.xDa, z2);
            }
        }
        AppMethodBeat.m2505o(138804);
    }
}
