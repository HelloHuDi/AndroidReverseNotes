package com.tencent.p177mm.plugin.story.p530f;

import android.support.p069v7.p075h.C0595c.C0601b;
import android.support.p069v7.p075h.C44964d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.api.C35168e;
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
import com.tencent.p177mm.plugin.story.model.p744a.C35194j;
import com.tencent.p177mm.plugin.story.model.p744a.C35197l;
import com.tencent.p177mm.plugin.story.model.p744a.C35198m;
import com.tencent.p177mm.plugin.story.model.p744a.C39885a;
import com.tencent.p177mm.plugin.story.model.p744a.C7138g;
import com.tencent.p177mm.plugin.story.p530f.C39876h.C29290a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C46273e;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0016H\u0002J,\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010-\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0016H\u0002J\b\u00102\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u00020\u0017H\u0016J*\u00104\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u00105\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u000107H\u0016J \u00108\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020\u0017H\u0002J\b\u0010;\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R,\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006="}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "galleryCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "deleteItemIndex", "", "getGalleryCallback", "()Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "galleryState", "privateItemIndex", "selectedIndex", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "getUsername", "()Ljava/lang/String;", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "onSetPrivacyCallback", "isPrivacy", "pause", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "updateCommentRead", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.j */
public final class C22197j extends C39876h implements C1202f {
    private static final String TAG = TAG;
    private static boolean rZF = true;
    public static final C22202a rZV = new C22202a();
    private int biG = -1;
    private final C0011r<Long, Boolean, String, String, C37091y> rWK = new C13758g(this);
    private final ArrayList<C43640g> rZR = new ArrayList();
    private int rZS = -1;
    private int rZT = -1;
    final C43632e rZU;
    private int rZd;
    private final String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.j$g */
    static final class C13758g extends C25053k implements C0011r<Long, Boolean, String, String, C37091y> {
        final /* synthetic */ C22197j rZW;

        C13758g(C22197j c22197j) {
            this.rZW = c22197j;
            super(4);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo47a(Object obj, Object obj2, Object obj3, Object obj4) {
            int i;
            AppMethodBeat.m2504i(138814);
            long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            String str = (String) obj4;
            C25052j.m39376p((String) obj3, "fromUser");
            C25052j.m39376p(str, "storyOwner");
            if (booleanValue) {
                C22202a c22202a = C22197j.rZV;
                C22197j.rZF = true;
            }
            int i2 = 0;
            for (C43640g c43640g : this.rZW.rZR) {
                if ((c43640g.rWa.rUJ == longValue ? 1 : null) != null) {
                    i = i2;
                    break;
                }
                i2++;
            }
            i = -1;
            int size = this.rZW.rZR.size();
            if (i >= 0 && size > i) {
                C4133a c4133a = C43644j.rST;
                if (C5046bo.isEqual(str, C4133a.cnk())) {
                    C25052j.m39375o(this.rZW.rZR.get(i), "galleryItems[index]");
                    c4133a = C43644j.rST;
                    final C39879j lx = C4133a.cxT().mo74417lx(longValue);
                    if (lx != null) {
                        C4126a c4126a = C43640g.rWe;
                        final C43640g c = C4126a.m6453c(lx);
                        C8902b.m16042a(new C31214a<C37091y>(this) {
                            final /* synthetic */ C13758g rZX;

                            public final /* synthetic */ Object invoke() {
                                AppMethodBeat.m2504i(109621);
                                if (booleanValue && !lx.cBX()) {
                                    this.rZX.rZW.rZR.set(i, c);
                                    this.rZX.rZW.rZU.mo55972j(0, this.rZX.rZW.rZR);
                                    this.rZX.rZW.rZU.mo55970ak(0, i, 1);
                                    this.rZX.rZW.rZU.czD();
                                    C22197j.m33835f(this.rZX.rZW);
                                }
                                C37091y c37091y = C37091y.AUy;
                                AppMethodBeat.m2505o(109621);
                                return c37091y;
                            }
                        });
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138814);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.j$e */
    static final class C22196e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C22197j rZW;
        final /* synthetic */ boolean rZn;

        C22196e(C22197j c22197j, boolean z) {
            this.rZW = c22197j;
            this.rZn = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109619);
            this.rZW.rZU.mo55974lB(this.rZn);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109619);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.j$d */
    static final class C22198d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean rXE;
        final /* synthetic */ C22197j rZW;

        C22198d(C22197j c22197j, boolean z) {
            this.rZW = c22197j;
            this.rXE = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109618);
            if (this.rXE) {
                int size = this.rZW.rZR.size();
                int b = this.rZW.rZS;
                if (b >= 0 && size > b) {
                    this.rZW.rZR.remove(this.rZW.rZS);
                    this.rZW.rZU.mo55972j(0, this.rZW.rZR);
                    this.rZW.rZU.mo55969aj(0, this.rZW.rZS, 1);
                    this.rZW.rZU.czD();
                }
            }
            this.rZW.rZU.mo55975lz(this.rXE);
            this.rZW.rZS = -1;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109618);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.j$f */
    static final class C22199f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C22197j rZW;

        C22199f(C22197j c22197j) {
            this.rZW = c22197j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109620);
            int size = this.rZW.rZR.size();
            int d = this.rZW.rZT;
            if (d >= 0 && size > d) {
                this.rZW.rZR.remove(this.rZW.rZT);
                this.rZW.rZU.mo55972j(0, this.rZW.rZR);
                this.rZW.rZU.mo55969aj(0, this.rZW.rZT, 1);
                this.rZW.rZU.czD();
            }
            this.rZW.rZT = -1;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109620);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$initLoad$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.j$c */
    public static final class C22200c implements C44964d {
        final /* synthetic */ C22197j rZW;

        C22200c(C22197j c22197j) {
            this.rZW = c22197j;
        }

        /* renamed from: a */
        public final void mo1472a(int i, int i2, Object obj) {
            AppMethodBeat.m2504i(109614);
            C4990ab.m7416i(C22197j.TAG, "onChanged: " + i + ' ' + i2);
            this.rZW.rZU.mo55970ak(0, i, i2);
            AppMethodBeat.m2505o(109614);
        }

        /* renamed from: I */
        public final void mo1471I(int i, int i2) {
            AppMethodBeat.m2504i(109615);
            C4990ab.m7416i(C22197j.TAG, "onMoved: " + i + ' ' + i2);
            AppMethodBeat.m2505o(109615);
        }

        /* renamed from: G */
        public final void mo1469G(int i, int i2) {
            AppMethodBeat.m2504i(109616);
            C4990ab.m7416i(C22197j.TAG, "onInserted: " + i + ' ' + i2);
            this.rZW.rZU.mo55968ai(0, i, i2);
            AppMethodBeat.m2505o(109616);
        }

        /* renamed from: H */
        public final void mo1470H(int i, int i2) {
            AppMethodBeat.m2504i(109617);
            C4990ab.m7416i(C22197j.TAG, "onRemoved: " + i + ' ' + i2);
            this.rZW.rZU.mo55969aj(0, i, i2);
            AppMethodBeat.m2505o(109617);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.j$b */
    static final class C22201b implements Runnable {
        final /* synthetic */ C43640g rZj;

        C22201b(C43640g c43640g) {
            this.rZj = c43640g;
        }

        public final void run() {
            AppMethodBeat.m2504i(109613);
            C4990ab.m7416i(C22197j.TAG, "LogStory: deleteItem fake " + this.rZj);
            C29311a c29311a = C29310n.rTi;
            C29311a.m46531EL(this.rZj.rVZ.cNE);
            C22210l c22210l = C22210l.sac;
            C22210l.m33885li(this.rZj.rVZ.timeStamp);
            c22210l = C22210l.sac;
            c22210l = C22210l.sac;
            C22210l.m33880b(C22210l.m33884lh(this.rZj.rVZ.timeStamp));
            AppMethodBeat.m2505o(109613);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$Companion;", "", "()V", "TAG", "", "needLoadRemote", "", "getNeedLoadRemote", "()Z", "setNeedLoadRemote", "(Z)V", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.j$a */
    public static final class C22202a {
        private C22202a() {
        }

        public /* synthetic */ C22202a(byte b) {
            this();
        }
    }

    /* renamed from: f */
    public static final /* synthetic */ void m33835f(C22197j c22197j) {
        AppMethodBeat.m2504i(109640);
        c22197j.czG();
        AppMethodBeat.m2505o(109640);
    }

    public C22197j(String str, C43632e c43632e) {
        C25052j.m39376p(str, "username");
        C25052j.m39376p(c43632e, "galleryCallback");
        AppMethodBeat.m2504i(109638);
        this.username = str;
        this.rZU = c43632e;
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(273, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(764, (C1202f) this);
        C46279b c46279b = C46279b.rVw;
        C46279b.m86757a(this.rWK);
        this.rZU.mo55965EP(1);
        AppMethodBeat.m2505o(109638);
    }

    static {
        AppMethodBeat.m2504i(109639);
        AppMethodBeat.m2505o(109639);
    }

    /* renamed from: ET */
    public final void mo37742ET(int i) {
    }

    /* renamed from: ly */
    private final void m33836ly(boolean z) {
        AppMethodBeat.m2504i(109623);
        C8902b.m16042a(new C22198d(this, z));
        AppMethodBeat.m2505o(109623);
    }

    /* renamed from: EO */
    public final void mo37740EO(int i) {
        AppMethodBeat.m2504i(109624);
        this.rZd = i;
        if (i == 0) {
            czE();
            AppMethodBeat.m2505o(109624);
            return;
        }
        czA();
        AppMethodBeat.m2505o(109624);
    }

    public final void czC() {
        AppMethodBeat.m2504i(109625);
        C4990ab.m7416i(TAG, "LogStory: initLoad");
        C43640g c43640g = (C43640g) C25035t.m39361x(this.rZR, 0);
        ArrayList bu = C29290a.m46506bu(this.username, false);
        C4990ab.m7416i(TAG, "LogStory: preload Db count " + bu.size());
        C43640g c43640g2 = (C43640g) C25035t.m39361x(bu, 0);
        if (c43640g == null || c43640g2 == null || c43640g.rUJ == c43640g2.rUJ) {
            C0601b m = C29290a.m46508m(this.rZR, bu);
            this.rZR.clear();
            this.rZR.addAll(bu);
            this.rZU.mo55972j(0, this.rZR);
            this.rZU.czD();
            m.mo1479a((C44964d) new C22200c(this));
        } else {
            this.rZR.clear();
            this.rZR.addAll(bu);
            this.rZU.mo55972j(0, this.rZR);
            this.rZU.mo55967ER(0);
            this.rZU.czD();
        }
        czG();
        czE();
        AppMethodBeat.m2505o(109625);
    }

    public final void czE() {
        AppMethodBeat.m2504i(109626);
        if (rZF && this.rZd == 0) {
            rZF = false;
            C35168e c35168e = (C35168e) C1720g.m3530M(C35168e.class);
            C4133a c4133a = C43644j.rST;
            c35168e.loadStory(C4133a.cnk(), null);
        }
        AppMethodBeat.m2505o(109626);
    }

    /* renamed from: fM */
    public final void mo37746fM(int i, int i2) {
        AppMethodBeat.m2504i(109627);
        C4990ab.m7416i(TAG, "LogStory: deleteItem ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.rZR.size()) {
            this.rZS = i2;
            Object obj = this.rZR.get(i2);
            C25052j.m39375o(obj, "galleryItems[column]");
            C43640g c43640g = (C43640g) obj;
            C4990ab.m7416i(TAG, "LogStory: deleteItem1 storyinfo " + c43640g + " deleteItemIndex " + this.rZS + " localid " + c43640g.rVZ.cNE);
            C4133a c4133a = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe(c43640g.rVZ.cNE);
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxT().aba(c43640g.rVZ.cNE + '_' + c43640g.rVZ.fDG);
            if (Fe != null) {
                C4990ab.m7416i(TAG, "LogStory: deleteItem2 storyinfo " + c43640g + " deleteItemIndex " + this.rZS + " localid " + c43640g.rVZ.cNE + ' ' + Fe.field_storyID);
                if (Fe.field_storyID == 0) {
                    C29311a c29311a = C29310n.rTi;
                    C29311a.m46531EL(c43640g.rVZ.cNE);
                    m33836ly(true);
                } else if (this.rZS != -1) {
                    C29311a c29311a2 = C29310n.rTi;
                    C29311a.m46530D(Fe.field_storyID, c43640g.rVZ.cNE);
                }
            }
            if (c43640g.rVZ.cze()) {
                c4133a = C43644j.rST;
                C4133a.cno().post(new C22201b(c43640g));
            }
        }
        AppMethodBeat.m2505o(109627);
    }

    public final void czB() {
        AppMethodBeat.m2504i(109628);
        this.rZS = -1;
        C29311a c29311a = C29310n.rTi;
        C29311a.cyo();
        AppMethodBeat.m2505o(109628);
    }

    /* renamed from: fN */
    public final void mo37747fN(int i, int i2) {
        AppMethodBeat.m2504i(109629);
        this.biG = i2;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.m2505o(109629);
    }

    /* renamed from: n */
    public final void mo37753n(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(109630);
        C4990ab.m7416i(TAG, "LogStory: setPrivacy ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.rZR.size()) {
            this.rZT = i2;
            boolean z2 = !z;
            Object obj = this.rZR.get(i2);
            C25052j.m39375o(obj, "galleryItems[column]");
            C43640g c43640g = (C43640g) obj;
            C4990ab.m7416i(TAG, "LogStory: setPrivacy storyinfo " + c43640g + " setPrivacyItemIndex " + this.rZT + " localid " + c43640g.rVZ.cNE + " targetPrivacy:" + z2);
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
                C22212h.m33892a(j, String.valueOf(Fe.field_storyID), 1, 0, 24);
                C29311a c29311a = C29310n.rTi;
                C29311a.m46535b(Fe.field_storyID, (int) Fe.xDa, z2, false);
                AppMethodBeat.m2505o(109630);
                return;
            }
        }
        AppMethodBeat.m2505o(109630);
    }

    /* renamed from: o */
    public final void mo37754o(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(138815);
        C4990ab.m7416i(TAG, "LogStory: setFavorite ".concat(String.valueOf(i2)));
        if (i2 >= 0 && i2 < this.rZR.size()) {
            boolean z2;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            Object obj = this.rZR.get(i2);
            C25052j.m39375o(obj, "galleryItems[column]");
            C43640g c43640g = (C43640g) obj;
            C4990ab.m7416i(TAG, "LogStory: setFavorite storyinfo " + c43640g + " localid " + c43640g.rVZ.cNE + " targetFavorite:" + z2);
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
                C22212h.m33892a(j, String.valueOf(Fe.field_storyID), 1, 0, 24);
                C29311a c29311a = C29310n.rTi;
                C29311a.m46539h(Fe.field_storyID, (int) Fe.xDa, z2);
                AppMethodBeat.m2505o(138815);
                return;
            }
        }
        AppMethodBeat.m2505o(138815);
    }

    private final void czA() {
        C43639f c43639f;
        Object obj = null;
        AppMethodBeat.m2504i(109632);
        C43640g c43640g = (C43640g) C25035t.m39361x(this.rZR, this.biG);
        if (c43640g != null) {
            c43639f = c43640g.rWa;
        } else {
            c43639f = null;
        }
        String str = TAG;
        StringBuilder append = new StringBuilder("setSelectedRead ").append(this.biG).append(", ");
        if (c43639f != null) {
            obj = Boolean.valueOf(c43639f.rVh);
        }
        C4990ab.m7416i(str, append.append(obj).toString());
        if (c43639f != null && c43639f.rrj.size() > 0) {
            C46279b c46279b = C46279b.rVw;
            long j = c43639f.rUJ;
            Object last = c43639f.rrj.getLast();
            C25052j.m39375o(last, "comment.commentList.last");
            if (C46279b.m86765b(j, (C39889a) last)) {
                c43639f.rVh = false;
                this.rZU.czD();
            }
        }
        czG();
        AppMethodBeat.m2505o(109632);
    }

    private final void czG() {
        boolean z;
        AppMethodBeat.m2504i(109633);
        Iterable<C43640g> iterable = this.rZR;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C43640g c43640g : iterable) {
                if (c43640g.rWa.rVh) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean isEmpty = this.rZR.isEmpty();
        C4990ab.m7416i(TAG, "LogStory: updateCommentRead " + z + ' ' + isEmpty);
        C46279b c46279b = C46279b.rVw;
        C46279b.m86753M(z, isEmpty);
        AppMethodBeat.m2505o(109633);
    }

    public final void resume() {
        AppMethodBeat.m2504i(109634);
        C4990ab.m7416i(TAG, "LogStory: resume");
        AppMethodBeat.m2505o(109634);
    }

    public final void pause() {
        AppMethodBeat.m2504i(109635);
        C4990ab.m7416i(TAG, "LogStory: pause");
        AppMethodBeat.m2505o(109635);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(109636);
        C4990ab.m7416i(TAG, "LogStory: destroy");
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(273, (C1202f) this);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(764, (C1202f) this);
        C46279b c46279b = C46279b.rVw;
        C46279b.m86763b(this.rWK);
        AppMethodBeat.m2505o(109636);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(109637);
        C4990ab.m7416i(TAG, "LogStory: " + i + ' ' + i2 + ' ' + str);
        if ((c1207m instanceof C35194j) && C5046bo.isEqual(((C35194j) c1207m).userName, this.username)) {
            if (i == 0 || i == 4) {
                int i3 = ((C35194j) c1207m).cvd;
                C35184a c35184a = C35183a.sdm;
                if (i3 == C35183a.sdi) {
                    rZF = false;
                    czC();
                    AppMethodBeat.m2505o(109637);
                    return;
                }
            }
        } else if (c1207m instanceof C7138g) {
            C39885a cyX = ((C7138g) c1207m).cyX();
            if (cyX != null) {
                if (cyX instanceof C35198m) {
                    if (i2 == 0) {
                        C29311a c29311a = C29310n.rTi;
                        C29311a.m46531EL(((C7138g) c1207m).cNE);
                    }
                    m33836ly(i2 == 0);
                    AppMethodBeat.m2505o(109637);
                    return;
                }
                C29311a c29311a2;
                if (cyX instanceof C29300n) {
                    C4990ab.m7416i(TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i + ", errcode:" + i2);
                    if (i2 == 0) {
                        c29311a2 = C29310n.rTi;
                        C29311a.m46537fJ(((C7138g) c1207m).cNE, ((C29300n) cyX).rVf);
                        C8902b.m16042a(new C22199f(this));
                        AppMethodBeat.m2505o(109637);
                        return;
                    }
                } else if (cyX instanceof C35197l) {
                    C4990ab.m7416i(TAG, "onSceneEnd update story favorite: errType " + i + ", errcode " + i2 + ", localId " + ((C7138g) c1207m).cNE + ", favorite:" + ((C35197l) cyX).rVe);
                    if (i2 == 0) {
                        c29311a2 = C29310n.rTi;
                        C29311a.m46538fK(((C7138g) c1207m).cNE, ((C35197l) cyX).rVe);
                        if (((C35197l) cyX).rVe != 1) {
                            z = false;
                        }
                        C8902b.m16042a(new C22196e(this, z));
                    }
                }
                AppMethodBeat.m2505o(109637);
                return;
            }
        }
        AppMethodBeat.m2505o(109637);
    }
}
