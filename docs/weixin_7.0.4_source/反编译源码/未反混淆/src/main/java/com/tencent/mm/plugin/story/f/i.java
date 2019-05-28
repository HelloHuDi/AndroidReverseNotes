package com.tencent.mm.plugin.story.f;

import a.a.t;
import a.f.a.r;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001=BS\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\f¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0018\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\"H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\b\u0010+\u001a\u00020\"H\u0016J\b\u0010,\u001a\u00020\"H\u0002J(\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00182\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u0002000\rj\b\u0012\u0004\u0012\u000200`\u000fH\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0013H\u0016J*\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\b\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010:\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u0018H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u0018H\u0002R\u000e\u0010\u0011\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00040\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R,\u0010 \u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\fX\u0004¢\u0006\u0002\n\u0000R2\u0010#\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00040\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "users", "", "", "chatRoom", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "isForSns", "", "storyFilterList", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;ZLjava/util/Map;)V", "TAG", "expectPos", "", "galleryState", "isLoadNetScene", "loadingUserQueue", "", "Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "kotlin.jvm.PlatformType", "needFilter", "needLoadRemote", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "userList", "checkLoadMore", "row", "deleteItem", "column", "destroy", "initExpectPosition", "initLoad", "loadMore", "loadNextQueuedUser", "notifyUser", "user", "items", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "onGalleryState", "state", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "preloadForUser", "setSelectedRead", "updateUserGalleryItemsFromDb", "UserData", "plugin-story_release"})
public final class i extends h implements com.tencent.mm.ai.f {
    private final String TAG;
    private final List<a> fxt;
    private final String gpx;
    private final r<Long, Boolean, String, String, y> rWK;
    private final int rZA;
    private final int rZB;
    private final List<a> rZC;
    private boolean rZD;
    private int rZE;
    private boolean rZF;
    private boolean rZG;
    private final e rZH;
    private final boolean rZI;
    private final Map<String, ArrayList<Long>> rZJ;
    private int rZb;
    private int rZc;
    private int rZd;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ i rZK;
        final /* synthetic */ android.support.v7.h.c.b rZN;
        final /* synthetic */ int rZk;
        final /* synthetic */ ArrayList rZt;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$notifyUser$3$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.f.i$e$1 */
        public static final class AnonymousClass1 implements android.support.v7.h.d {
            final /* synthetic */ e rZO;

            AnonymousClass1(e eVar) {
                this.rZO = eVar;
            }

            public final void a(int i, int i2, Object obj) {
                AppMethodBeat.i(109596);
                ab.i(this.rZO.rZK.TAG, "onChanged: " + i + ' ' + i2);
                this.rZO.rZK.rZH.ak(this.rZO.rZk, i, i2);
                AppMethodBeat.o(109596);
            }

            public final void I(int i, int i2) {
                AppMethodBeat.i(109597);
                ab.i(this.rZO.rZK.TAG, "onMoved: " + i + ' ' + i2);
                AppMethodBeat.o(109597);
            }

            public final void G(int i, int i2) {
                AppMethodBeat.i(109598);
                ab.i(this.rZO.rZK.TAG, "onInserted: " + i + ' ' + i2);
                this.rZO.rZK.rZH.ai(this.rZO.rZk, i, i2);
                AppMethodBeat.o(109598);
            }

            public final void H(int i, int i2) {
                AppMethodBeat.i(109599);
                ab.i(this.rZO.rZK.TAG, "onRemoved: " + i + ' ' + i2);
                this.rZO.rZK.rZH.aj(this.rZO.rZk, i, i2);
                AppMethodBeat.o(109599);
            }
        }

        e(i iVar, int i, ArrayList arrayList, android.support.v7.h.c.b bVar) {
            this.rZK = iVar;
            this.rZk = i;
            this.rZt = arrayList;
            this.rZN = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109600);
            this.rZK.rZH.j(this.rZk, this.rZt);
            this.rZK.rZH.czD();
            this.rZN.a((android.support.v7.h.d) new AnonymousClass1(this));
            y yVar = y.AUy;
            AppMethodBeat.o(109600);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ i rZK;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.i$f$1 */
        static final class AnonymousClass1 extends k implements a.f.a.a<y> {
            final /* synthetic */ f rZP;

            AnonymousClass1(f fVar) {
                this.rZP = fVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(138807);
                this.rZP.rZK.rZH.czD();
                y yVar = y.AUy;
                AppMethodBeat.o(138807);
                return yVar;
            }
        }

        f(i iVar) {
            this.rZK = iVar;
        }

        public final void run() {
            Object obj = null;
            AppMethodBeat.i(138808);
            boolean z = this.rZK.rZb >= 0 && this.rZK.rZb < this.rZK.fxt.size() && (this.rZK.rZb == this.rZK.rZE || this.rZK.rZE == -1);
            if (z) {
                com.tencent.mm.plugin.story.model.d.f fVar;
                com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) t.x(((a) this.rZK.fxt.get(this.rZK.rZb)).cHb, this.rZK.rZc);
                if (gVar != null) {
                    fVar = gVar.rWa;
                } else {
                    fVar = null;
                }
                String h = this.rZK.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.rZK.rZc).append(", ");
                if (fVar != null) {
                    obj = Boolean.valueOf(fVar.rVh);
                }
                ab.i(h, append.append(obj).toString());
                if (fVar != null && fVar.rrj.size() > 0) {
                    com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
                    long j = fVar.rUJ;
                    Object last = fVar.rrj.getLast();
                    j.o(last, "comment.commentList.last");
                    if (com.tencent.mm.plugin.story.model.b.b.b(j, (com.tencent.mm.plugin.story.model.b.a) last)) {
                        fVar.rVh = false;
                        com.tencent.mm.ab.b.a(new AnonymousClass1(this));
                    }
                }
                this.rZK.rZE = -1;
            }
            AppMethodBeat.o(138808);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class g extends k implements r<Long, Boolean, String, String, y> {
        final /* synthetic */ i rZK;

        g(i iVar) {
            this.rZK = iVar;
            super(4);
        }

        public final /* synthetic */ Object a(Object obj, Object obj2, Object obj3, Object obj4) {
            int i;
            int i2;
            AppMethodBeat.i(138810);
            long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            String str = (String) obj4;
            j.p((String) obj3, "fromUser");
            j.p(str, "storyOwner");
            if (booleanValue) {
                this.rZK.rZF = true;
            }
            List d = this.rZK.fxt;
            j.o(d, "userList");
            int i3 = 0;
            Iterator it = d.iterator();
            while (true) {
                i = i3;
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (bo.isEqual(((a) it.next()).username, str)) {
                    i2 = i;
                    break;
                } else {
                    i3 = i + 1;
                }
            }
            if (i2 != -1) {
                int i4;
                final ArrayList<com.tencent.mm.plugin.story.model.d.g> arrayList = ((a) this.rZK.fxt.get(i2)).cHb;
                i = 0;
                for (com.tencent.mm.plugin.story.model.d.g gVar : arrayList) {
                    if ((gVar.rUJ == longValue ? 1 : null) != null) {
                        i4 = i;
                        break;
                    }
                    i++;
                }
                i4 = -1;
                if (i4 != -1) {
                    com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(longValue);
                    if (lx != null) {
                        com.tencent.mm.plugin.story.model.d.g.a aVar2 = com.tencent.mm.plugin.story.model.d.g.rWe;
                        final com.tencent.mm.plugin.story.model.d.g c = com.tencent.mm.plugin.story.model.d.g.a.c(lx);
                        com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                            final /* synthetic */ g rZQ;

                            public final /* synthetic */ Object invoke() {
                                AppMethodBeat.i(138809);
                                if (booleanValue) {
                                    ab.i(this.rZQ.rZK.TAG, "commentChanged, will update row:" + i2 + " col:" + i4);
                                    arrayList.set(i4, c);
                                    this.rZQ.rZK.rZH.j(i2, arrayList);
                                    this.rZQ.rZK.rZH.ak(i2, i4, 1);
                                    this.rZQ.rZK.rZH.czD();
                                }
                                y yVar = y.AUy;
                                AppMethodBeat.o(138809);
                                return yVar;
                            }
                        });
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138810);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "", "username", "", "state", "", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ILjava/util/ArrayList;)V", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getState", "()I", "setState", "(I)V", "getUsername", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-story_release"})
    public static final class a {
        ArrayList<com.tencent.mm.plugin.story.model.d.g> cHb;
        int state = 0;
        final String username;

        /* JADX WARNING: Missing block: B:11:0x002b, code skipped:
            if (a.f.b.j.j(r5.cHb, r6.cHb) != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(109592);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (j.j(this.username, aVar.username)) {
                        if (this.state == aVar.state) {
                        }
                    }
                }
                AppMethodBeat.o(109592);
                return false;
            }
            AppMethodBeat.o(109592);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.i(109591);
            String str = this.username;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.state) * 31;
            ArrayList arrayList = this.cHb;
            if (arrayList != null) {
                i = arrayList.hashCode();
            }
            hashCode += i;
            AppMethodBeat.o(109591);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(109590);
            String str = "UserData(username=" + this.username + ", state=" + this.state + ", items=" + this.cHb + ")";
            AppMethodBeat.o(109590);
            return str;
        }

        public a(String str, ArrayList<com.tencent.mm.plugin.story.model.d.g> arrayList) {
            j.p(str, "username");
            j.p(arrayList, "items");
            AppMethodBeat.i(109589);
            this.username = str;
            this.cHb = arrayList;
            AppMethodBeat.o(109589);
        }

        public final void V(ArrayList<com.tencent.mm.plugin.story.model.d.g> arrayList) {
            AppMethodBeat.i(109588);
            j.p(arrayList, "<set-?>");
            this.cHb = arrayList;
            AppMethodBeat.o(109588);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ i rZK;
        final /* synthetic */ a rZL;
        final /* synthetic */ a rZM;

        b(i iVar, a aVar, a aVar2) {
            this.rZK = iVar;
            this.rZL = aVar;
            this.rZM = aVar2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109593);
            a aVar = this.rZL;
            if (aVar != null) {
                i.a(this.rZK, aVar);
            }
            aVar = this.rZM;
            if (aVar != null) {
                this.rZK.rZC.add(aVar);
            }
            i.b(this.rZK);
            y yVar = y.AUy;
            AppMethodBeat.o(109593);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ i rZK;
        final /* synthetic */ int rZk;

        c(i iVar, int i) {
            this.rZK = iVar;
            this.rZk = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109594);
            this.rZK.fxt.remove(this.rZk);
            this.rZK.rZH.EQ(this.rZk);
            y yVar = y.AUy;
            AppMethodBeat.o(109594);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ i rZK;
        final /* synthetic */ int rZk;
        final /* synthetic */ ArrayList rZt;

        d(i iVar, int i, ArrayList arrayList) {
            this.rZK = iVar;
            this.rZk = i;
            this.rZt = arrayList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109595);
            this.rZK.rZH.j(this.rZk, this.rZt);
            this.rZK.rZH.ER(this.rZk);
            this.rZK.rZH.czD();
            y yVar = y.AUy;
            AppMethodBeat.o(109595);
            return yVar;
        }
    }

    public static final /* synthetic */ void b(i iVar) {
        AppMethodBeat.i(109612);
        iVar.czF();
        AppMethodBeat.o(109612);
    }

    public /* synthetic */ i(List list, String str, e eVar, boolean z) {
        this(list, str, eVar, z, new HashMap());
        AppMethodBeat.i(109610);
        AppMethodBeat.o(109610);
    }

    public i(List<String> list, String str, e eVar, boolean z, Map<String, ? extends ArrayList<Long>> map) {
        j.p(list, "users");
        j.p(eVar, "groupCallback");
        j.p(map, "storyFilterList");
        AppMethodBeat.i(138813);
        this.gpx = str;
        this.rZH = eVar;
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
        this.rWK = new g(this);
        ab.i(this.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + cb.aaD());
        ab.i(this.TAG, "chatRoom is " + this.gpx);
        for (String str2 : list) {
            ab.i(this.TAG, "LogStory: ".concat(String.valueOf(str2)));
            this.fxt.add(new a(str2, new ArrayList()));
        }
        this.rZH.EP(this.fxt.size());
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().a(273, (com.tencent.mm.ai.f) this);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.a(this.rWK);
        AppMethodBeat.o(138813);
    }

    public final void ET(int i) {
        this.rZE = i;
    }

    public final void destroy() {
        AppMethodBeat.i(109602);
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().b(273, (com.tencent.mm.ai.f) this);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.b(this.rWK);
        AppMethodBeat.o(109602);
    }

    public final void EO(int i) {
        AppMethodBeat.i(109603);
        this.rZd = i;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.o(109603);
    }

    public final void czC() {
        int size;
        AppMethodBeat.i(109604);
        if (this.fxt.size() <= 3) {
            size = this.fxt.size();
        } else {
            size = 3;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.fxt.get(i);
            j.o(obj, "userList[i]");
            a((a) obj);
        }
        if (this.fxt.size() > 0) {
            this.rZC.add(this.fxt.get(0));
            czF();
        }
        AppMethodBeat.o(109604);
    }

    public final void czE() {
    }

    public final void fM(int i, int i2) {
    }

    public final void fN(int i, int i2) {
        AppMethodBeat.i(138811);
        this.rZb = i;
        this.rZc = i2;
        if (this.rZd == 1) {
            czA();
        }
        AppMethodBeat.o(138811);
    }

    public final void ES(int i) {
        AppMethodBeat.i(109605);
        List list = this.fxt;
        j.o(list, "userList");
        a aVar = (a) t.x(list, i);
        if (aVar != null) {
            a(aVar);
        }
        list = this.fxt;
        j.o(list, "userList");
        aVar = (a) t.x(list, this.rZA + i);
        List list2 = this.fxt;
        j.o(list2, "userList");
        com.tencent.mm.ab.b.a("MultiUserGalleryPresenter_checkLoadMore", (a.f.a.a) new b(this, aVar, (a) t.x(list2, this.rZB + i)));
        AppMethodBeat.o(109605);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(109606);
        j.p(mVar, "scene");
        if (this.rZC.size() <= 0) {
            AppMethodBeat.o(109606);
            return;
        }
        a aVar = (a) this.rZC.get(0);
        int indexOf = this.fxt.indexOf(aVar);
        int size = this.fxt.size();
        if (indexOf < 0 || size <= indexOf) {
            this.rZC.remove(0);
            this.rZD = false;
            czF();
            AppMethodBeat.o(109606);
            return;
        }
        ab.i(this.TAG, "LogStory: " + i + ' ' + i2 + ' ' + str + ", " + indexOf + ' ' + aVar);
        if (mVar instanceof com.tencent.mm.plugin.story.model.a.j) {
            size = this.fxt.size();
            if (indexOf < 0) {
                AppMethodBeat.o(109606);
                return;
            } else if (size > indexOf && bo.isEqual(((com.tencent.mm.plugin.story.model.a.j) mVar).userName, aVar.username)) {
                this.rZC.remove(0);
                this.rZD = false;
                j.o(aVar, "user");
                ab.i(this.TAG, "LogStory: updateUserGalleryItemsFromDb " + aVar.username + ' ' + this.fxt.indexOf(aVar));
                ArrayList bu = com.tencent.mm.plugin.story.f.h.a.bu(aVar.username, this.rZI);
                ab.i(this.TAG, "LogStory: db data " + aVar + ' ' + bu.size());
                a(aVar, bu);
                czF();
            }
        }
        AppMethodBeat.o(109606);
    }

    private final void czA() {
        AppMethodBeat.i(138812);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new f(this));
        AppMethodBeat.o(138812);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(a aVar, ArrayList<com.tencent.mm.plugin.story.model.d.g> arrayList) {
        boolean z;
        String str;
        StringBuilder stringBuilder;
        List list;
        ArrayList arrayList2;
        boolean z2 = false;
        AppMethodBeat.i(109607);
        int indexOf = this.fxt.indexOf(aVar);
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
                j.o(list, "userList");
                ab.i(str, stringBuilder.append((a) t.x(list, indexOf)).append(' ').append(indexOf).append(' ').append(this.rZb).append(", ").append(arrayList.size()).append(' ').append(this.rZd).append(", result ").append(z).append(' ').append(z2).toString());
                arrayList2 = aVar.cHb;
                aVar.V(arrayList);
                if (!z) {
                    ab.i(this.TAG, "remove user from gallery " + indexOf + ' ' + aVar);
                    com.tencent.mm.ab.b.a(new c(this, indexOf));
                    AppMethodBeat.o(109607);
                    return;
                } else if (!z2) {
                    AppMethodBeat.o(109607);
                    return;
                } else if (this.rZd == 0 || indexOf != this.rZb) {
                    com.tencent.mm.ab.b.a(new d(this, indexOf, arrayList));
                    AppMethodBeat.o(109607);
                    return;
                } else {
                    com.tencent.mm.ab.b.a(new e(this, indexOf, arrayList, com.tencent.mm.plugin.story.f.h.a.m(arrayList2, arrayList)));
                    AppMethodBeat.o(109607);
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
        j.o(list, "userList");
        ab.i(str, stringBuilder.append((a) t.x(list, indexOf)).append(' ').append(indexOf).append(' ').append(this.rZb).append(", ").append(arrayList.size()).append(' ').append(this.rZd).append(", result ").append(z).append(' ').append(z2).toString());
        arrayList2 = aVar.cHb;
        aVar.V(arrayList);
        if (!z) {
        }
    }

    private final void a(a aVar) {
        AppMethodBeat.i(109608);
        if (this.fxt.indexOf(aVar) < 0) {
            AppMethodBeat.o(109608);
        } else if (aVar.state != 0) {
            ab.i(this.TAG, "LogStory: preloadForUser already preload");
            AppMethodBeat.o(109608);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList b;
            if (this.rZG) {
                aVar.state = 2;
                String str = aVar.username;
                String str2 = aVar.username;
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                b = com.tencent.mm.plugin.story.f.h.a.b(str, bo.isEqual(str2, com.tencent.mm.plugin.story.model.j.a.cnk()), (ArrayList) this.rZJ.get(aVar.username));
                if ((!((Collection) b).isEmpty() ? 1 : 0) != 0) {
                    ab.i(this.TAG, "LogStory: preload add sync item and local item, " + b.size());
                    arrayList.addAll(b);
                }
            } else {
                aVar.state = 1;
                ab.i(this.TAG, "LogStory: preloadForUser ".concat(String.valueOf(aVar)));
                com.tencent.mm.plugin.story.model.d.g bt = com.tencent.mm.plugin.story.f.h.a.bt(aVar.username, this.rZI);
                if (bt == null) {
                    a(aVar, arrayList);
                    AppMethodBeat.o(109608);
                    return;
                }
                b = com.tencent.mm.plugin.story.f.h.a.bu(aVar.username, this.rZI);
                if (b.size() > 0) {
                    ab.i(this.TAG, "LogStory: preload add sync item and local item, " + b.size());
                    if (((com.tencent.mm.plugin.story.model.d.g) b.get(0)).rUJ != bt.rUJ) {
                        arrayList.add(bt);
                    }
                    arrayList.addAll(b);
                } else {
                    ab.i(this.TAG, "LogStory: preload add sync item");
                    arrayList.add(bt);
                }
            }
            a(aVar, arrayList);
            AppMethodBeat.o(109608);
        }
    }

    private final void czF() {
        AppMethodBeat.i(109609);
        while (!this.rZD && this.rZC.size() > 0) {
            a aVar = (a) this.rZC.get(0);
            int indexOf = this.fxt.indexOf(aVar);
            int size = this.fxt.size();
            if (indexOf >= 0 && size > indexOf && aVar.state != 2) {
                aVar.state = 2;
                ab.i(this.TAG, "LogStory: loadRemoteForUser ".concat(String.valueOf(aVar)));
                ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).loadStory(aVar.username, this.gpx);
                this.rZD = true;
                AppMethodBeat.o(109609);
                return;
            }
            this.rZC.remove(0);
        }
        AppMethodBeat.o(109609);
    }
}
