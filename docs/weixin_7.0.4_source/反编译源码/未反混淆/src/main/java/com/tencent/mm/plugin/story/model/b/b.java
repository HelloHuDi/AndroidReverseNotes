package com.tencent.mm.plugin.story.model.b;

import a.a.t;
import a.f.a.r;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J,\u0010$\u001a\u00020 2$\u0010#\u001a \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001dJ\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020 2\u0006\u0010&\u001a\u00020'J(\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u0005J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0017H\u0002J\"\u00100\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u00101\u001a\u00020 J\u0006\u00102\u001a\u00020 J\u0016\u00103\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0019J*\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010/\u001a\u00020\u0017H\u0002J0\u0010=\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u0005J8\u0010A\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0007JL\u0010C\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010E\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0017H\u0002J\u0010\u0010F\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J,\u0010G\u001a\u00020 2$\u0010#\u001a \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001dJ\u0010\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020<H\u0002J\u0010\u0010J\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010K\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001eJ\u0016\u0010L\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\u0019J\u0010\u0010M\u001a\u00020<2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010N\u001a\u00020 H\u0002J\u0016\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u001fJ\u0010\u0010R\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001eH\u0002J\u0012\u0010S\u001a\u00020 2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0006\u0010V\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000RZ\u0010\u001b\u001aN\u0012\"\u0012 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001d0\u001cj&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001d`!X\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, dWq = {"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "", "", "", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "postCommentToRemote", "removeCommentChangeListener", "removeStoryCommentChangeListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b implements com.tencent.mm.ai.f, com.tencent.mm.plugin.story.api.h {
    public static final String TAG = TAG;
    private static final int mzJ = Integer.MAX_VALUE;
    public static final String rVo;
    private static final int rVp = 50;
    public static final cdu rVq = new cdu();
    private static cdw rVr;
    private static a rVs;
    private static int rVt = -1;
    private static final ArrayList<r<Long, Boolean, String, String, y>> rVu = new ArrayList();
    private static final LinkedList<Object> rVv = new LinkedList();
    public static final b rVw = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class i extends k implements a.f.a.a<y> {
        final /* synthetic */ boolean rVH;

        i(boolean z) {
            this.rVH = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109267);
            b bVar = b.rVw;
            Iterator it = b.rVv.iterator();
            while (it.hasNext()) {
                it.next();
            }
            com.tencent.mm.x.c.PK().x(352279, this.rVH);
            y yVar = y.AUy;
            AppMethodBeat.o(109267);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ a.f.b.u.c rVx;

        public a(a.f.b.u.c cVar) {
            this.rVx = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109262);
            b bVar = b.rVw;
            for (r a : b.rVu) {
                a.a(Long.valueOf(((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).field_storyId), Boolean.TRUE, ((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).cEV, ((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).rVl);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109262);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
    static final class g extends k implements a.f.a.a<y> {
        final /* synthetic */ a.f.b.u.c rVF;
        final /* synthetic */ com.tencent.mm.plugin.story.h.j rVG;

        g(a.f.b.u.c cVar, com.tencent.mm.plugin.story.h.j jVar) {
            this.rVF = cVar;
            this.rVG = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138756);
            b bVar = b.rVw;
            for (r a : b.rVu) {
                a.a(Long.valueOf(((com.tencent.mm.plugin.story.h.c) this.rVF.AVE).field_storyId), Boolean.FALSE, ((com.tencent.mm.plugin.story.h.c) this.rVF.AVE).cEV, ((com.tencent.mm.plugin.story.h.c) this.rVF.AVE).rVl);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138756);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ String rVA;
        final /* synthetic */ long rVy;
        final /* synthetic */ int rVz;

        b(long j, int i, String str) {
            this.rVy = j;
            this.rVz = i;
            this.rVA = str;
        }

        public final void run() {
            AppMethodBeat.i(138751);
            b bVar = b.rVw;
            b.h(this.rVy, this.rVz, this.rVA);
            AppMethodBeat.o(138751);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends k implements a.f.a.a<y> {
        final /* synthetic */ a.f.b.u.c rVx;

        h(a.f.b.u.c cVar) {
            this.rVx = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109266);
            b bVar = b.rVw;
            for (r a : b.rVu) {
                a.a(Long.valueOf(((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).field_storyId), Boolean.FALSE, ((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).cEV, ((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).rVl);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109266);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class j extends k implements a.f.a.a<y> {
        final /* synthetic */ a.f.b.u.c rVx;

        j(a.f.b.u.c cVar) {
            this.rVx = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138757);
            b bVar = b.rVw;
            for (r a : b.rVu) {
                a.a(Long.valueOf(((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).field_storyId), Boolean.TRUE, ((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).cEV, ((com.tencent.mm.plugin.story.h.c) this.rVx.AVE).rVl);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138757);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        public static final e rVD = new e();

        static {
            AppMethodBeat.i(138755);
            AppMethodBeat.o(138755);
        }

        e() {
        }

        public final void run() {
            AppMethodBeat.i(138754);
            b bVar = b.rVw;
            b.czc();
            AppMethodBeat.o(138754);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ cdy rVB;

        c(cdy cdy) {
            this.rVB = cdy;
        }

        public final void run() {
            AppMethodBeat.i(109263);
            b bVar = b.rVw;
            b.b(this.rVB.xdJ);
            AppMethodBeat.o(109263);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        public static final d rVC = new d();

        static {
            AppMethodBeat.i(138753);
            AppMethodBeat.o(138753);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(138752);
            b bVar = b.rVw;
            b.czc();
            AppMethodBeat.o(138752);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ cdw rVE;

        f(cdw cdw) {
            this.rVE = cdw;
        }

        public final void run() {
            AppMethodBeat.i(109265);
            b bVar = b.rVw;
            b.a(b.b(this.rVE));
            AppMethodBeat.o(109265);
        }
    }

    static {
        AppMethodBeat.i(109281);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.i.a aVar = com.tencent.mm.plugin.story.model.i.rSv;
        rVo = stringBuilder.append(com.tencent.mm.plugin.story.model.i.rSr).append("commentCache.proto").toString();
        AppMethodBeat.o(109281);
    }

    private b() {
    }

    public static final /* synthetic */ void czc() {
        AppMethodBeat.i(109284);
        col();
        AppMethodBeat.o(109284);
    }

    public static final /* synthetic */ void h(long j, int i, String str) {
        AppMethodBeat.i(138766);
        g(j, i, str);
        AppMethodBeat.o(138766);
    }

    public static void cyZ() {
        AppMethodBeat.i(109268);
        com.tencent.mm.vfs.e.q(rVo, rVq.toByteArray());
        AppMethodBeat.o(109268);
    }

    public static void a(r<? super Long, ? super Boolean, ? super String, ? super String, y> rVar) {
        AppMethodBeat.i(138758);
        a.f.b.j.p(rVar, CastExtraArgs.LISTENER);
        if (!rVu.contains(rVar)) {
            rVu.add(rVar);
        }
        AppMethodBeat.o(138758);
    }

    public static void b(r<? super Long, ? super Boolean, ? super String, ? super String, y> rVar) {
        AppMethodBeat.i(138759);
        a.f.b.j.p(rVar, CastExtraArgs.LISTENER);
        rVu.remove(rVar);
        AppMethodBeat.o(138759);
    }

    public static void b(long j, int i, String str, String str2) {
        AppMethodBeat.i(139084);
        a.f.b.j.p(str2, com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
        ab.i(TAG, "deleteComment storyId:" + j + " commentId:" + i + " sessionId:" + str + " content:" + str2);
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.cnk()).append(bo.yz()).toString();
            Charset charset = a.k.d.UTF_8;
            if (stringBuilder2 == null) {
                v vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(139084);
                throw vVar;
            }
            byte[] bytes = stringBuilder2.getBytes(charset);
            a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
            stringBuilder2 = com.tencent.xweb.util.d.x(bytes);
            cdw cdw = new cdw();
            cdw.rUJ = j;
            cdw.clientId = stringBuilder2;
            cdw.rVd = i;
            cdw.fDG = cb.aaF();
            cdw.state = 3;
            cdw.cvF = str;
            rVq.xdx.add(cdw);
            col();
        }
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new b(j, i, str2));
        AppMethodBeat.o(139084);
    }

    public static void a(long j, a aVar) {
        AppMethodBeat.i(109272);
        a.f.b.j.p(aVar, "commentItem");
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.c lr = com.tencent.mm.plugin.story.model.j.a.cxW().lr(j);
        if (lr == null) {
            lr = new com.tencent.mm.plugin.story.h.c();
            lr.field_storyId = j;
        }
        lr.field_readCommentId = aVar.rVd;
        lr.field_readCommentTime = aVar.fDG;
        com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxW().c(lr, new String[0]);
        AppMethodBeat.o(109272);
    }

    public static boolean b(long j, a aVar) {
        AppMethodBeat.i(109273);
        a.f.b.j.p(aVar, "commentDetail");
        a.f.b.u.c cVar = new a.f.b.u.c();
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        cVar.AVE = com.tencent.mm.plugin.story.model.j.a.cxW().lr(j);
        if (((com.tencent.mm.plugin.story.h.c) cVar.AVE) == null) {
            cVar.AVE = new com.tencent.mm.plugin.story.h.c();
            ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_storyId = j;
        }
        if (((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentId == aVar.rVd || ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentTime >= aVar.fDG) {
            AppMethodBeat.o(109273);
            return false;
        }
        ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentId = aVar.rVd;
        ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentTime = aVar.fDG;
        ((com.tencent.mm.plugin.story.h.c) cVar.AVE).aaS(aVar.cEV);
        ((com.tencent.mm.plugin.story.h.c) cVar.AVE).aaG(aVar.rVl);
        ((com.tencent.mm.plugin.story.h.c) cVar.AVE).cBE();
        aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxW().c((com.tencent.mm.plugin.story.h.c) cVar.AVE, new String[0]);
        com.tencent.mm.ab.b.a(new h(cVar));
        AppMethodBeat.o(109273);
        return true;
    }

    public static void lc(long j) {
        AppMethodBeat.i(138760);
        a.f.b.u.c cVar = new a.f.b.u.c();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        cVar.AVE = com.tencent.mm.plugin.story.model.j.a.cxW().lr(j);
        if (((com.tencent.mm.plugin.story.h.c) cVar.AVE) == null) {
            cVar.AVE = new com.tencent.mm.plugin.story.h.c();
            ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_storyId = j;
        }
        aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(j);
        if (lx == null) {
            AppMethodBeat.o(138760);
            return;
        }
        byte[] bArr;
        Object obj;
        cer cer = new cer();
        if (lx != null) {
            try {
                bArr = lx.field_attrBuf;
            } catch (Exception e) {
            }
        } else {
            bArr = null;
        }
        cer.parseFrom(bArr);
        LinkedList linkedList = cer.xeo;
        a.f.b.j.o(linkedList, "storyObj.CommentList");
        List list = linkedList;
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            int i;
            Object previous = listIterator.previous();
            if (((cdv) previous).wZG != 0) {
                i = 1;
                continue;
            } else {
                i = 0;
                continue;
            }
            if (i != 0) {
                obj = previous;
                break;
            }
        }
        obj = null;
        cdv cdv = (cdv) obj;
        if (cdv != null) {
            if (((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentId != cdv.wZG && ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentTime < cdv.pcX) {
                ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentId = cdv.wZG;
                ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentTime = cdv.pcX;
                com.tencent.mm.plugin.story.h.c cVar2 = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
                String str = cdv.ndG;
                a.f.b.j.o(str, "it.FromUserName");
                cVar2.aaS(str);
                com.tencent.mm.plugin.story.h.c cVar3 = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
                String str2 = lx.field_userName;
                if (str2 == null) {
                    str2 = "";
                }
                cVar3.aaG(str2);
                ((com.tencent.mm.plugin.story.h.c) cVar.AVE).cBE();
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxW().c((com.tencent.mm.plugin.story.h.c) cVar.AVE, new String[0]);
                com.tencent.mm.ab.b.a(new g(cVar, lx));
            }
            AppMethodBeat.o(138760);
            return;
        }
        AppMethodBeat.o(138760);
    }

    public static void M(boolean z, boolean z2) {
        AppMethodBeat.i(109274);
        boolean bX = com.tencent.mm.x.c.PK().bX(352279, 266241);
        ab.i(TAG, "updateCommentRead: " + bX + ", " + z);
        if (bX != z || z2) {
            com.tencent.mm.ab.b.a(new i(z));
        }
        AppMethodBeat.o(109274);
    }

    public static void col() {
        cdw cdw;
        int i = 0;
        AppMethodBeat.i(109275);
        ArrayList arrayList = new ArrayList();
        int size = rVq.xdx.size();
        for (int i2 = 0; i2 < size; i2++) {
            cdw = (cdw) rVq.xdx.get(i2);
            if ((cdw.state == 1 || cdw.state == 3) && cdw.fDG > cb.aaF() - 86400) {
                arrayList.add(cdw);
            }
        }
        rVq.xdx.clear();
        rVq.xdx.addAll(arrayList);
        rVt++;
        if (arrayList.size() == 0) {
            rVt = -1;
            AppMethodBeat.o(109275);
            return;
        }
        rVt %= arrayList.size();
        Collection arrayList2 = new ArrayList();
        size = 0;
        for (Object next : arrayList) {
            int i3;
            int i4 = size + 1;
            if (size < 0) {
                a.a.l.dWs();
            }
            cdw cdw2 = (cdw) next;
            if (size < rVt || cdw2.retryCount >= mzJ) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (i3 != 0) {
                arrayList2.add(next);
            }
            size = i4;
        }
        cdw = (cdw) t.fK((List) arrayList2);
        if (cdw == null || cdw.state != 1) {
            if (cdw != null && cdw.state == 3) {
                ab.i(TAG, "deleteCommentToRemote " + cdw.toUser + ' ' + cdw.rUJ + ' ' + cdw.rVd + ' ' + cdw.fDG);
                rVr = cdw;
                arrayList = new ArrayList();
                long j = cdw.rUJ;
                com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
                arrayList.add(new com.tencent.mm.plugin.story.model.a.k(j, com.tencent.mm.plugin.story.h.a.scM, cdw.rVd));
                com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
                a.f.b.j.o(RO, "network()");
                RO.Rg().d((m) new com.tencent.mm.plugin.story.model.a.g(arrayList, 0));
            }
            AppMethodBeat.o(109275);
            return;
        }
        ab.i(TAG, "postCommentToRemote " + cdw.toUser + ' ' + cdw.rUJ + ' ' + cdw.xdD + ' ' + cdw.fDG);
        rVr = cdw;
        cdv a = a(cdw);
        CharSequence charSequence = a.ncM;
        if (charSequence == null || charSequence.length() == 0) {
            i = 1;
        }
        com.tencent.mm.plugin.story.g.e eVar;
        if (i != 0) {
            eVar = com.tencent.mm.plugin.story.g.e.sbS;
            com.tencent.mm.plugin.story.g.e.czZ();
        } else {
            eVar = com.tencent.mm.plugin.story.g.e.sbS;
            com.tencent.mm.plugin.story.g.e.cAa();
        }
        com.tencent.mm.kernel.b RO2 = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO2, "network()");
        p Rg = RO2.Rg();
        String str = cdw.clientId;
        a.f.b.j.o(str, "commentOp.clientId");
        Rg.d((m) new com.tencent.mm.plugin.story.model.a.d(str, a, cdw.cvF, rVs));
        AppMethodBeat.o(109275);
    }

    public static a a(long j, String str, String str2, boolean z, String str3, String str4, int i) {
        int i2 = 1;
        AppMethodBeat.i(138761);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.cnk()).append(bo.yz()).toString();
        Charset charset = a.k.d.UTF_8;
        if (stringBuilder2 == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(138761);
            throw vVar;
        }
        byte[] bytes = stringBuilder2.getBytes(charset);
        a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        stringBuilder2 = com.tencent.xweb.util.d.x(bytes);
        cdw cdw = new cdw();
        cdw.clientId = stringBuilder2;
        cdw.rUJ = j;
        cdw.content = str2;
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        cdw.cEV = com.tencent.mm.plugin.story.model.j.a.cnk();
        cdw.toUser = str;
        cdw.fDG = cb.aaF();
        cdw.state = 1;
        cdw.xdD = 0;
        if (!z) {
            i2 = 0;
        }
        cdw.xdE = i2;
        cdw.cvF = str3;
        cdw.rVl = str4;
        cdw.rVm = i;
        rVq.xdx.add(cdw);
        rVs = new a(cdw);
        col();
        com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cno().post(new f(cdw));
        a aVar4 = rVs;
        if (aVar4 == null) {
            a.f.b.j.dWJ();
        }
        AppMethodBeat.o(138761);
        return aVar4;
    }

    private static cdv a(cdw cdw) {
        AppMethodBeat.i(109277);
        cdv cdv = new cdv();
        cdv.vQE = cdw.rUJ;
        cdv.wZG = cdw.rVd;
        cdv.ndG = cdw.cEV;
        cdv.ndF = cdw.toUser;
        cdv.ncM = cdw.content;
        cdv.pcX = cdw.fDG;
        cdv.xdB = cdw.xdD;
        cdv.xdC = cdw.xdE;
        cdv.wZF = cdw.rVm;
        AppMethodBeat.o(109277);
        return cdv;
    }

    private static void a(cer cer) {
        AppMethodBeat.i(138762);
        if (cer != null) {
            int cAO;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(cer.vQE);
            if (lx == null) {
                lx = new com.tencent.mm.plugin.story.h.j();
            }
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.a.a aVar3;
            if (bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), cer.jBB)) {
                aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                cAO = com.tencent.mm.plugin.story.h.a.scw;
            } else {
                aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                cAO = com.tencent.mm.plugin.story.h.a.scx;
            }
            com.tencent.mm.plugin.story.model.n.a aVar4 = n.rTi;
            com.tencent.mm.plugin.story.model.n.a.a(lx, cer, cAO);
            AppMethodBeat.o(138762);
            return;
        }
        AppMethodBeat.o(138762);
    }

    public static void g(long j, int i, String str) {
        int i2 = 0;
        AppMethodBeat.i(138764);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(j);
        if (lx == null) {
            AppMethodBeat.o(138764);
            return;
        }
        int i3;
        cer cer = new cer();
        try {
            cer.parseFrom(lx.field_attrBuf);
        } catch (Exception e) {
        }
        LinkedList<cdv> linkedList;
        if (i != 0) {
            linkedList = cer.xeo;
            a.f.b.j.o(linkedList, "storyObj.CommentList");
            i3 = 0;
            for (cdv cdv : linkedList) {
                if ((cdv.wZG == i ? 1 : 0) != 0) {
                    break;
                }
                i3++;
            }
            i3 = -1;
        } else {
            linkedList = cer.xeo;
            a.f.b.j.o(linkedList, "storyObj.CommentList");
            for (cdv cdv2 : linkedList) {
                if (bo.isEqual(cdv2.ncM, str)) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            i3 = i2;
        }
        if (i3 != -1) {
            cer.xeo.remove(i3);
            cer.xar = cer.xeo.size();
            try {
                lx.field_attrBuf = cer.toByteArray();
            } catch (Exception e2) {
            }
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().a(j, lx);
        }
        AppMethodBeat.o(138764);
    }

    /* JADX WARNING: Missing block: B:9:0x005d, code skipped:
            if (r1 == null) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:46:0x011e, code skipped:
            if (r0 == null) goto L_0x0120;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void ld(long j) {
        Object obj = null;
        int i = 0;
        AppMethodBeat.i(138765);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(j);
        a.f.b.u.c cVar = new a.f.b.u.c();
        aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.c lr = com.tencent.mm.plugin.story.model.j.a.cxW().lr(j);
        if (lr == null) {
            AppMethodBeat.o(138765);
            return;
        }
        String str;
        cVar.AVE = lr;
        if (lx == null) {
            ab.i(TAG, "updateLastCommentSync will reset to 0 0");
            ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentTime = 0;
            ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentId = 0;
            ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_syncCommentTime = 0;
            ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_syncCommentId = 0;
            ((com.tencent.mm.plugin.story.h.c) cVar.AVE).aaS("");
        } else {
            cdv cdv;
            Object obj2;
            int i2;
            String str2;
            cer cer = new cer();
            try {
                cer.parseFrom(lx.field_attrBuf);
            } catch (Exception e) {
            }
            LinkedList linkedList = cer.xeo;
            a.f.b.j.o(linkedList, "storyObj.CommentList");
            List list = linkedList;
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                int i3;
                Object previous = listIterator.previous();
                cdv = (cdv) previous;
                if (cdv.wZG == 0 || cdv.pcX > ((com.tencent.mm.plugin.story.h.c) cVar.AVE).field_readCommentTime) {
                    i3 = 0;
                    continue;
                } else {
                    i3 = 1;
                    continue;
                }
                if (i3 != 0) {
                    obj2 = previous;
                    break;
                }
            }
            obj2 = null;
            cdv = (cdv) obj2;
            String str3 = TAG;
            StringBuilder append = new StringBuilder("updateLastCommentSync will reset to ").append(cdv != null ? Integer.valueOf(cdv.pcX) : null).append(' ');
            if (cdv != null) {
                obj = Integer.valueOf(cdv.wZG);
            }
            ab.i(str3, append.append(obj).toString());
            com.tencent.mm.plugin.story.h.c cVar2 = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
            if (cdv != null) {
                i2 = cdv.pcX;
            } else {
                i2 = 0;
            }
            cVar2.field_readCommentTime = i2;
            cVar2 = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
            if (cdv != null) {
                i2 = cdv.wZG;
            } else {
                i2 = 0;
            }
            cVar2.field_readCommentId = i2;
            cVar2 = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
            if (cdv != null) {
                i2 = cdv.pcX;
            } else {
                i2 = 0;
            }
            cVar2.field_syncCommentTime = i2;
            cVar2 = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
            if (cdv != null) {
                i = cdv.wZG;
            }
            cVar2.field_syncCommentId = i;
            cVar2 = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
            if (cdv != null) {
                str2 = cdv.ndG;
            }
            str2 = "";
            cVar2.aaS(str2);
        }
        lr = (com.tencent.mm.plugin.story.h.c) cVar.AVE;
        if (lx != null) {
            str = lx.field_userName;
        }
        str = "";
        lr.aaG(str);
        aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxW().a((com.tencent.mm.plugin.story.h.c) cVar.AVE);
        com.tencent.mm.ab.b.a(new j(cVar));
        AppMethodBeat.o(138765);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        long j = 100;
        int i3 = 0;
        AppMethodBeat.i(109280);
        a.f.b.j.p(mVar, "scene");
        int type = mVar.getType();
        ab.i(TAG, "onSceneEnd " + i + ", " + i2 + ", " + str + ", " + type);
        cdw cdw;
        cdw cdw2;
        String str2;
        StringBuilder stringBuilder;
        com.tencent.mm.plugin.story.model.j.a aVar;
        if (type == com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX) {
            com.tencent.mm.bt.a acA = ((com.tencent.mm.plugin.story.model.a.d) mVar).ehh.acA();
            if (acA == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
                AppMethodBeat.o(109280);
                throw vVar;
            }
            long j2;
            cdy cdy = (cdy) acA;
            a aVar2 = ((com.tencent.mm.plugin.story.model.a.d) mVar).rUN;
            if (i == 0 && i2 == 0) {
                String str3 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder("post comment success ");
                cdw = rVr;
                ab.i(str3, stringBuilder2.append(cdw != null ? cdw.content : null).append(' ').append(cdy.wZG).toString());
                com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cno().post(new c(cdy));
                if (aVar2 != null) {
                    aVar2.rVd = cdy.wZG;
                }
                cdw = rVr;
                if (cdw != null) {
                    cdw.rVd = cdy.wZG;
                }
                cdw2 = rVr;
                if (cdw2 != null) {
                    cdw2.state = 2;
                }
                rVr = null;
                j2 = 100;
            } else {
                str2 = TAG;
                stringBuilder = new StringBuilder("post comment fail ");
                cdw2 = rVr;
                ab.i(str2, stringBuilder.append(cdw2 != null ? cdw2.content : null).toString());
                cdw2 = rVr;
                if (cdw2 != null) {
                    i3 = cdw2.retryCount;
                }
                if (i == 4) {
                    cdw2 = rVr;
                    if (cdw2 != null) {
                        cdw2.retryCount = mzJ;
                    }
                } else {
                    cdw2 = rVr;
                    if (cdw2 != null) {
                        cdw2.retryCount = i3 + 1;
                    }
                }
                rVr = null;
                j2 = 300000;
            }
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cno().postDelayed(d.rVC, j2);
            AppMethodBeat.o(109280);
            return;
        }
        if (type == 764 && (((com.tencent.mm.plugin.story.model.a.g) mVar).cyX() instanceof com.tencent.mm.plugin.story.model.a.k)) {
            if (i == 0 && i2 == 0) {
                String str4 = TAG;
                StringBuilder stringBuilder3 = new StringBuilder("delete comment success ");
                cdw2 = rVr;
                ab.i(str4, stringBuilder3.append(cdw2 != null ? cdw2.content : null).toString());
                cdw2 = rVr;
                if (cdw2 != null) {
                    cdw2.state = 4;
                }
                rVr = null;
            } else {
                str2 = TAG;
                stringBuilder = new StringBuilder("delete comment fail ");
                cdw2 = rVr;
                ab.i(str2, stringBuilder.append(cdw2 != null ? cdw2.content : null).toString());
                cdw2 = rVr;
                if (cdw2 != null) {
                    type = cdw2.retryCount;
                } else {
                    type = 0;
                }
                if (i == 4) {
                    cdw2 = rVr;
                    if (cdw2 != null) {
                        cdw2.retryCount = mzJ;
                    }
                } else {
                    cdw = rVr;
                    if (cdw != null) {
                        cdw.retryCount = type + 1;
                    }
                }
                rVr = null;
                j = 60000;
            }
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cno().postDelayed(e.rVD, j);
        }
        AppMethodBeat.o(109280);
    }

    public static void a(cex cex) {
        AppMethodBeat.i(138763);
        cdv cdv = new cdv();
        cdv.vQE = cex.vQE;
        cdv.wZG = cex.xex.wZG;
        cdv.ndG = cex.xex.ndG;
        cdv.ndF = cex.xex.ndF;
        cdv.ncM = cex.xex.ncM;
        cdv.pcX = cex.xex.pcX;
        cdv.xdB = cex.xex.xdB;
        cdv.wZF = cex.xex.wZF;
        long j = cdv.vQE;
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(j);
        if (lx == null) {
            a(cex.xex.xdJ);
            AppMethodBeat.o(138763);
            return;
        }
        Object obj;
        cer cer = new cer();
        try {
            cer.parseFrom(lx.field_attrBuf);
        } catch (Exception e) {
        }
        LinkedList linkedList;
        int i;
        if (bo.isNullOrNil(cdv.ncM)) {
            if (cdv.wZG != 0) {
                linkedList = cer.xeq;
                a.f.b.j.o(linkedList, "storyObj.BubbleList");
                for (Object next : linkedList) {
                    if (((cdv) next).wZG == cdv.wZG) {
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
                if (((cdv) obj) == null) {
                    cer.xeq.add(cdv);
                    obj = 1;
                }
                obj = null;
            } else {
                cer.xeq.add(cdv);
                i = 1;
            }
        } else if (cdv.wZG != 0) {
            linkedList = cer.xeo;
            a.f.b.j.o(linkedList, "storyObj.CommentList");
            for (Object next2 : linkedList) {
                if (((cdv) next2).wZG == cdv.wZG) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    obj = next2;
                    break;
                }
            }
            obj = null;
            if (((cdv) obj) == null) {
                cer.xeo.add(cdv);
                i = 1;
            }
            obj = null;
        } else {
            cer.xeo.add(cdv);
            i = 1;
        }
        if (obj != null) {
            cer.xar = cer.xeo.size();
            cer.xep = cer.xeq.size();
            try {
                lx.field_attrBuf = cer.toByteArray();
            } catch (Exception e2) {
            }
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().a(j, lx);
        }
        AppMethodBeat.o(138763);
    }
}
