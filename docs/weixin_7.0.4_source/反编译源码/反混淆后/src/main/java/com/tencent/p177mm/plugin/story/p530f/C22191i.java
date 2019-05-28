package com.tencent.p177mm.plugin.story.p530f;

import android.support.p069v7.p075h.C0595c.C0601b;
import android.support.p069v7.p075h.C44964d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p533d.C43639f;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g.C4126a;
import com.tencent.p177mm.plugin.story.model.p744a.C35194j;
import com.tencent.p177mm.plugin.story.p530f.C39876h.C29290a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001=BS\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\f¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0018\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\"H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\b\u0010+\u001a\u00020\"H\u0016J\b\u0010,\u001a\u00020\"H\u0002J(\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00182\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u0002000\rj\b\u0012\u0004\u0012\u000200`\u000fH\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0013H\u0016J*\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\b\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010:\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u0018H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u0018H\u0002R\u000e\u0010\u0011\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00040\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R,\u0010 \u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\fX\u0004¢\u0006\u0002\n\u0000R2\u0010#\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00040\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "users", "", "", "chatRoom", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "isForSns", "", "storyFilterList", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;ZLjava/util/Map;)V", "TAG", "expectPos", "", "galleryState", "isLoadNetScene", "loadingUserQueue", "", "Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "kotlin.jvm.PlatformType", "needFilter", "needLoadRemote", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "userList", "checkLoadMore", "row", "deleteItem", "column", "destroy", "initExpectPosition", "initLoad", "loadMore", "loadNextQueuedUser", "notifyUser", "user", "items", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "onGalleryState", "state", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "preloadForUser", "setSelectedRead", "updateUserGalleryItemsFromDb", "UserData", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.i */
public final class C22191i extends C39876h implements C1202f {
    private final String TAG;
    private final List<C22192a> fxt;
    private final String gpx;
    private final C0011r<Long, Boolean, String, String, C37091y> rWK;
    private final int rZA;
    private final int rZB;
    private final List<C22192a> rZC;
    private boolean rZD;
    private int rZE;
    private boolean rZF;
    private boolean rZG;
    private final C43632e rZH;
    private final boolean rZI;
    private final Map<String, ArrayList<Long>> rZJ;
    private int rZb;
    private int rZc;
    private int rZd;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.i$e */
    static final class C22187e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C22191i rZK;
        final /* synthetic */ C0601b rZN;
        final /* synthetic */ int rZk;
        final /* synthetic */ ArrayList rZt;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$notifyUser$3$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.f.i$e$1 */
        public static final class C221881 implements C44964d {
            final /* synthetic */ C22187e rZO;

            C221881(C22187e c22187e) {
                this.rZO = c22187e;
            }

            /* renamed from: a */
            public final void mo1472a(int i, int i2, Object obj) {
                AppMethodBeat.m2504i(109596);
                C4990ab.m7416i(this.rZO.rZK.TAG, "onChanged: " + i + ' ' + i2);
                this.rZO.rZK.rZH.mo55970ak(this.rZO.rZk, i, i2);
                AppMethodBeat.m2505o(109596);
            }

            /* renamed from: I */
            public final void mo1471I(int i, int i2) {
                AppMethodBeat.m2504i(109597);
                C4990ab.m7416i(this.rZO.rZK.TAG, "onMoved: " + i + ' ' + i2);
                AppMethodBeat.m2505o(109597);
            }

            /* renamed from: G */
            public final void mo1469G(int i, int i2) {
                AppMethodBeat.m2504i(109598);
                C4990ab.m7416i(this.rZO.rZK.TAG, "onInserted: " + i + ' ' + i2);
                this.rZO.rZK.rZH.mo55968ai(this.rZO.rZk, i, i2);
                AppMethodBeat.m2505o(109598);
            }

            /* renamed from: H */
            public final void mo1470H(int i, int i2) {
                AppMethodBeat.m2504i(109599);
                C4990ab.m7416i(this.rZO.rZK.TAG, "onRemoved: " + i + ' ' + i2);
                this.rZO.rZK.rZH.mo55969aj(this.rZO.rZk, i, i2);
                AppMethodBeat.m2505o(109599);
            }
        }

        C22187e(C22191i c22191i, int i, ArrayList arrayList, C0601b c0601b) {
            this.rZK = c22191i;
            this.rZk = i;
            this.rZt = arrayList;
            this.rZN = c0601b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109600);
            this.rZK.rZH.mo55972j(this.rZk, this.rZt);
            this.rZK.rZH.czD();
            this.rZN.mo1479a((C44964d) new C221881(this));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109600);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.f.i$f */
    static final class C22189f implements Runnable {
        final /* synthetic */ C22191i rZK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.i$f$1 */
        static final class C137571 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C22189f rZP;

            C137571(C22189f c22189f) {
                this.rZP = c22189f;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(138807);
                this.rZP.rZK.rZH.czD();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(138807);
                return c37091y;
            }
        }

        C22189f(C22191i c22191i) {
            this.rZK = c22191i;
        }

        public final void run() {
            Object obj = null;
            AppMethodBeat.m2504i(138808);
            boolean z = this.rZK.rZb >= 0 && this.rZK.rZb < this.rZK.fxt.size() && (this.rZK.rZb == this.rZK.rZE || this.rZK.rZE == -1);
            if (z) {
                C43639f c43639f;
                C43640g c43640g = (C43640g) C25035t.m39361x(((C22192a) this.rZK.fxt.get(this.rZK.rZb)).cHb, this.rZK.rZc);
                if (c43640g != null) {
                    c43639f = c43640g.rWa;
                } else {
                    c43639f = null;
                }
                String h = this.rZK.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.rZK.rZc).append(", ");
                if (c43639f != null) {
                    obj = Boolean.valueOf(c43639f.rVh);
                }
                C4990ab.m7416i(h, append.append(obj).toString());
                if (c43639f != null && c43639f.rrj.size() > 0) {
                    C46279b c46279b = C46279b.rVw;
                    long j = c43639f.rUJ;
                    Object last = c43639f.rrj.getLast();
                    C25052j.m39375o(last, "comment.commentList.last");
                    if (C46279b.m86765b(j, (C39889a) last)) {
                        c43639f.rVh = false;
                        C8902b.m16042a(new C137571(this));
                    }
                }
                this.rZK.rZE = -1;
            }
            AppMethodBeat.m2505o(138808);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.i$g */
    static final class C22190g extends C25053k implements C0011r<Long, Boolean, String, String, C37091y> {
        final /* synthetic */ C22191i rZK;

        C22190g(C22191i c22191i) {
            this.rZK = c22191i;
            super(4);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo47a(Object obj, Object obj2, Object obj3, Object obj4) {
            int i;
            int i2;
            AppMethodBeat.m2504i(138810);
            long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            String str = (String) obj4;
            C25052j.m39376p((String) obj3, "fromUser");
            C25052j.m39376p(str, "storyOwner");
            if (booleanValue) {
                this.rZK.rZF = true;
            }
            List d = this.rZK.fxt;
            C25052j.m39375o(d, "userList");
            int i3 = 0;
            Iterator it = d.iterator();
            while (true) {
                i = i3;
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (C5046bo.isEqual(((C22192a) it.next()).username, str)) {
                    i2 = i;
                    break;
                } else {
                    i3 = i + 1;
                }
            }
            if (i2 != -1) {
                int i4;
                final ArrayList<C43640g> arrayList = ((C22192a) this.rZK.fxt.get(i2)).cHb;
                i = 0;
                for (C43640g c43640g : arrayList) {
                    if ((c43640g.rUJ == longValue ? 1 : null) != null) {
                        i4 = i;
                        break;
                    }
                    i++;
                }
                i4 = -1;
                if (i4 != -1) {
                    C4133a c4133a = C43644j.rST;
                    C39879j lx = C4133a.cxT().mo74417lx(longValue);
                    if (lx != null) {
                        C4126a c4126a = C43640g.rWe;
                        final C43640g c = C4126a.m6453c(lx);
                        C8902b.m16042a(new C31214a<C37091y>(this) {
                            final /* synthetic */ C22190g rZQ;

                            public final /* synthetic */ Object invoke() {
                                AppMethodBeat.m2504i(138809);
                                if (booleanValue) {
                                    C4990ab.m7416i(this.rZQ.rZK.TAG, "commentChanged, will update row:" + i2 + " col:" + i4);
                                    arrayList.set(i4, c);
                                    this.rZQ.rZK.rZH.mo55972j(i2, arrayList);
                                    this.rZQ.rZK.rZH.mo55970ak(i2, i4, 1);
                                    this.rZQ.rZK.rZH.czD();
                                }
                                C37091y c37091y = C37091y.AUy;
                                AppMethodBeat.m2505o(138809);
                                return c37091y;
                            }
                        });
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138810);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "", "username", "", "state", "", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ILjava/util/ArrayList;)V", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getState", "()I", "setState", "(I)V", "getUsername", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.i$a */
    public static final class C22192a {
        ArrayList<C43640g> cHb;
        int state = 0;
        final String username;

        /* JADX WARNING: Missing block: B:11:0x002b, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r5.cHb, r6.cHb) != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(109592);
            if (this != obj) {
                if (obj instanceof C22192a) {
                    C22192a c22192a = (C22192a) obj;
                    if (C25052j.m39373j(this.username, c22192a.username)) {
                        if (this.state == c22192a.state) {
                        }
                    }
                }
                AppMethodBeat.m2505o(109592);
                return false;
            }
            AppMethodBeat.m2505o(109592);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.m2504i(109591);
            String str = this.username;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.state) * 31;
            ArrayList arrayList = this.cHb;
            if (arrayList != null) {
                i = arrayList.hashCode();
            }
            hashCode += i;
            AppMethodBeat.m2505o(109591);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(109590);
            String str = "UserData(username=" + this.username + ", state=" + this.state + ", items=" + this.cHb + ")";
            AppMethodBeat.m2505o(109590);
            return str;
        }

        public C22192a(String str, ArrayList<C43640g> arrayList) {
            C25052j.m39376p(str, "username");
            C25052j.m39376p(arrayList, "items");
            AppMethodBeat.m2504i(109589);
            this.username = str;
            this.cHb = arrayList;
            AppMethodBeat.m2505o(109589);
        }

        /* renamed from: V */
        public final void mo37748V(ArrayList<C43640g> arrayList) {
            AppMethodBeat.m2504i(109588);
            C25052j.m39376p(arrayList, "<set-?>");
            this.cHb = arrayList;
            AppMethodBeat.m2505o(109588);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.i$b */
    static final class C22193b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C22191i rZK;
        final /* synthetic */ C22192a rZL;
        final /* synthetic */ C22192a rZM;

        C22193b(C22191i c22191i, C22192a c22192a, C22192a c22192a2) {
            this.rZK = c22191i;
            this.rZL = c22192a;
            this.rZM = c22192a2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109593);
            C22192a c22192a = this.rZL;
            if (c22192a != null) {
                C22191i.m33814a(this.rZK, c22192a);
            }
            c22192a = this.rZM;
            if (c22192a != null) {
                this.rZK.rZC.add(c22192a);
            }
            C22191i.m33815b(this.rZK);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109593);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.i$c */
    static final class C22194c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C22191i rZK;
        final /* synthetic */ int rZk;

        C22194c(C22191i c22191i, int i) {
            this.rZK = c22191i;
            this.rZk = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109594);
            this.rZK.fxt.remove(this.rZk);
            this.rZK.rZH.mo55966EQ(this.rZk);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109594);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.i$d */
    static final class C22195d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C22191i rZK;
        final /* synthetic */ int rZk;
        final /* synthetic */ ArrayList rZt;

        C22195d(C22191i c22191i, int i, ArrayList arrayList) {
            this.rZK = c22191i;
            this.rZk = i;
            this.rZt = arrayList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109595);
            this.rZK.rZH.mo55972j(this.rZk, this.rZt);
            this.rZK.rZH.mo55967ER(this.rZk);
            this.rZK.rZH.czD();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109595);
            return c37091y;
        }
    }

    /* renamed from: b */
    public static final /* synthetic */ void m33815b(C22191i c22191i) {
        AppMethodBeat.m2504i(109612);
        c22191i.czF();
        AppMethodBeat.m2505o(109612);
    }

    public /* synthetic */ C22191i(List list, String str, C43632e c43632e, boolean z) {
        this(list, str, c43632e, z, new HashMap());
        AppMethodBeat.m2504i(109610);
        AppMethodBeat.m2505o(109610);
    }

    public C22191i(List<String> list, String str, C43632e c43632e, boolean z, Map<String, ? extends ArrayList<Long>> map) {
        C25052j.m39376p(list, "users");
        C25052j.m39376p(c43632e, "groupCallback");
        C25052j.m39376p(map, "storyFilterList");
        AppMethodBeat.m2504i(138813);
        this.gpx = str;
        this.rZH = c43632e;
        this.rZI = z;
        this.rZJ = map;
        this.TAG = "MicroMsg.MultiUserGalleryPresenter";
        this.rZA = 3;
        this.rZB = 1;
        this.fxt = Collections.synchronizedList(new ArrayList());
        this.rZC = Collections.synchronizedList(new LinkedList());
        this.rZb = -1;
        this.rZc = -1;
        this.rZG = !this.rZJ.isEmpty();
        this.rWK = new C22190g(this);
        C4990ab.m7416i(this.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + C1839cb.aaD());
        C4990ab.m7416i(this.TAG, "chatRoom is " + this.gpx);
        for (String str2 : list) {
            C4990ab.m7416i(this.TAG, "LogStory: ".concat(String.valueOf(str2)));
            this.fxt.add(new C22192a(str2, new ArrayList()));
        }
        this.rZH.mo55965EP(this.fxt.size());
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14539a(273, (C1202f) this);
        C46279b c46279b = C46279b.rVw;
        C46279b.m86757a(this.rWK);
        AppMethodBeat.m2505o(138813);
    }

    /* renamed from: ET */
    public final void mo37742ET(int i) {
        this.rZE = i;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(109602);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14546b(273, (C1202f) this);
        C46279b c46279b = C46279b.rVw;
        C46279b.m86763b(this.rWK);
        AppMethodBeat.m2505o(109602);
    }

    /* renamed from: EO */
    public final void mo37740EO(int i) {
        AppMethodBeat.m2504i(109603);
        this.rZd = i;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.m2505o(109603);
    }

    public final void czC() {
        int size;
        AppMethodBeat.m2504i(109604);
        if (this.fxt.size() <= 3) {
            size = this.fxt.size();
        } else {
            size = 3;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.fxt.get(i);
            C25052j.m39375o(obj, "userList[i]");
            m33812a((C22192a) obj);
        }
        if (this.fxt.size() > 0) {
            this.rZC.add(this.fxt.get(0));
            czF();
        }
        AppMethodBeat.m2505o(109604);
    }

    public final void czE() {
    }

    /* renamed from: fM */
    public final void mo37746fM(int i, int i2) {
    }

    /* renamed from: fN */
    public final void mo37747fN(int i, int i2) {
        AppMethodBeat.m2504i(138811);
        this.rZb = i;
        this.rZc = i2;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.m2505o(138811);
    }

    /* renamed from: ES */
    public final void mo37741ES(int i) {
        AppMethodBeat.m2504i(109605);
        List list = this.fxt;
        C25052j.m39375o(list, "userList");
        C22192a c22192a = (C22192a) C25035t.m39361x(list, i);
        if (c22192a != null) {
            m33812a(c22192a);
        }
        list = this.fxt;
        C25052j.m39375o(list, "userList");
        c22192a = (C22192a) C25035t.m39361x(list, this.rZA + i);
        List list2 = this.fxt;
        C25052j.m39375o(list2, "userList");
        C8902b.m16044a("MultiUserGalleryPresenter_checkLoadMore", (C31214a) new C22193b(this, c22192a, (C22192a) C25035t.m39361x(list2, this.rZB + i)));
        AppMethodBeat.m2505o(109605);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(109606);
        C25052j.m39376p(c1207m, "scene");
        if (this.rZC.size() <= 0) {
            AppMethodBeat.m2505o(109606);
            return;
        }
        C22192a c22192a = (C22192a) this.rZC.get(0);
        int indexOf = this.fxt.indexOf(c22192a);
        int size = this.fxt.size();
        if (indexOf < 0 || size <= indexOf) {
            this.rZC.remove(0);
            this.rZD = false;
            czF();
            AppMethodBeat.m2505o(109606);
            return;
        }
        C4990ab.m7416i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str + ", " + indexOf + ' ' + c22192a);
        if (c1207m instanceof C35194j) {
            size = this.fxt.size();
            if (indexOf < 0) {
                AppMethodBeat.m2505o(109606);
                return;
            } else if (size > indexOf && C5046bo.isEqual(((C35194j) c1207m).userName, c22192a.username)) {
                this.rZC.remove(0);
                this.rZD = false;
                C25052j.m39375o(c22192a, "user");
                C4990ab.m7416i(this.TAG, "LogStory: updateUserGalleryItemsFromDb " + c22192a.username + ' ' + this.fxt.indexOf(c22192a));
                ArrayList bu = C29290a.m46506bu(c22192a.username, this.rZI);
                C4990ab.m7416i(this.TAG, "LogStory: db data " + c22192a + ' ' + bu.size());
                m33813a(c22192a, bu);
                czF();
            }
        }
        AppMethodBeat.m2505o(109606);
    }

    private final void czA() {
        AppMethodBeat.m2504i(138812);
        C4133a c4133a = C43644j.rST;
        C4133a.cno().post(new C22189f(this));
        AppMethodBeat.m2505o(138812);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final void m33813a(C22192a c22192a, ArrayList<C43640g> arrayList) {
        boolean z;
        String str;
        StringBuilder stringBuilder;
        List list;
        ArrayList arrayList2;
        boolean z2 = false;
        AppMethodBeat.m2504i(109607);
        int indexOf = this.fxt.indexOf(c22192a);
        if (arrayList.isEmpty()) {
            int i = this.rZb + 1;
            if (this.rZb - 1 > indexOf || i < indexOf) {
                boolean z3;
                z = true;
                if (arrayList.isEmpty()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.rZd == 0) {
                    z2 = true;
                }
                str = this.TAG;
                stringBuilder = new StringBuilder("notifyUser: selection ");
                list = this.fxt;
                C25052j.m39375o(list, "userList");
                C4990ab.m7416i(str, stringBuilder.append((C22192a) C25035t.m39361x(list, indexOf)).append(' ').append(indexOf).append(' ').append(this.rZb).append(", ").append(arrayList.size()).append(' ').append(this.rZd).append(", result ").append(z).append(' ').append(z2).toString());
                arrayList2 = c22192a.cHb;
                c22192a.mo37748V(arrayList);
                if (!z) {
                    C4990ab.m7416i(this.TAG, "remove user from gallery " + indexOf + ' ' + c22192a);
                    C8902b.m16042a(new C22194c(this, indexOf));
                    AppMethodBeat.m2505o(109607);
                    return;
                } else if (!z2) {
                    AppMethodBeat.m2505o(109607);
                    return;
                } else if (this.rZd == 0 || indexOf != this.rZb) {
                    C8902b.m16042a(new C22195d(this, indexOf, arrayList));
                    AppMethodBeat.m2505o(109607);
                    return;
                } else {
                    C8902b.m16042a(new C22187e(this, indexOf, arrayList, C29290a.m46508m(arrayList2, arrayList)));
                    AppMethodBeat.m2505o(109607);
                    return;
                }
            }
        }
        z = false;
        if (arrayList.isEmpty()) {
        }
        z2 = true;
        str = this.TAG;
        stringBuilder = new StringBuilder("notifyUser: selection ");
        list = this.fxt;
        C25052j.m39375o(list, "userList");
        C4990ab.m7416i(str, stringBuilder.append((C22192a) C25035t.m39361x(list, indexOf)).append(' ').append(indexOf).append(' ').append(this.rZb).append(", ").append(arrayList.size()).append(' ').append(this.rZd).append(", result ").append(z).append(' ').append(z2).toString());
        arrayList2 = c22192a.cHb;
        c22192a.mo37748V(arrayList);
        if (!z) {
        }
    }

    /* renamed from: a */
    private final void m33812a(C22192a c22192a) {
        AppMethodBeat.m2504i(109608);
        if (this.fxt.indexOf(c22192a) < 0) {
            AppMethodBeat.m2505o(109608);
        } else if (c22192a.state != 0) {
            C4990ab.m7416i(this.TAG, "LogStory: preloadForUser already preload");
            AppMethodBeat.m2505o(109608);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList b;
            if (this.rZG) {
                c22192a.state = 2;
                String str = c22192a.username;
                String str2 = c22192a.username;
                C4133a c4133a = C43644j.rST;
                b = C29290a.m46504b(str, C5046bo.isEqual(str2, C4133a.cnk()), (ArrayList) this.rZJ.get(c22192a.username));
                if ((!((Collection) b).isEmpty() ? 1 : 0) != 0) {
                    C4990ab.m7416i(this.TAG, "LogStory: preload add sync item and local item, " + b.size());
                    arrayList.addAll(b);
                }
            } else {
                c22192a.state = 1;
                C4990ab.m7416i(this.TAG, "LogStory: preloadForUser ".concat(String.valueOf(c22192a)));
                C43640g bt = C29290a.m46505bt(c22192a.username, this.rZI);
                if (bt == null) {
                    m33813a(c22192a, arrayList);
                    AppMethodBeat.m2505o(109608);
                    return;
                }
                b = C29290a.m46506bu(c22192a.username, this.rZI);
                if (b.size() > 0) {
                    C4990ab.m7416i(this.TAG, "LogStory: preload add sync item and local item, " + b.size());
                    if (((C43640g) b.get(0)).rUJ != bt.rUJ) {
                        arrayList.add(bt);
                    }
                    arrayList.addAll(b);
                } else {
                    C4990ab.m7416i(this.TAG, "LogStory: preload add sync item");
                    arrayList.add(bt);
                }
            }
            m33813a(c22192a, arrayList);
            AppMethodBeat.m2505o(109608);
        }
    }

    private final void czF() {
        AppMethodBeat.m2504i(109609);
        while (!this.rZD && this.rZC.size() > 0) {
            C22192a c22192a = (C22192a) this.rZC.get(0);
            int indexOf = this.fxt.indexOf(c22192a);
            int size = this.fxt.size();
            if (indexOf >= 0 && size > indexOf && c22192a.state != 2) {
                c22192a.state = 2;
                C4990ab.m7416i(this.TAG, "LogStory: loadRemoteForUser ".concat(String.valueOf(c22192a)));
                ((C35168e) C1720g.m3530M(C35168e.class)).loadStory(c22192a.username, this.gpx);
                this.rZD = true;
                AppMethodBeat.m2505o(109609);
                return;
            }
            this.rZC.remove(0);
        }
        AppMethodBeat.m2505o(109609);
    }
}
