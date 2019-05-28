package com.tencent.p177mm.plugin.story.model.p1035b;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33379c;
import com.tencent.p177mm.plugin.story.api.C39863h;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43641i;
import com.tencent.p177mm.plugin.story.model.C43641i.C43642a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p744a.C35196k;
import com.tencent.p177mm.plugin.story.model.p744a.C39887d;
import com.tencent.p177mm.plugin.story.model.p744a.C7138g;
import com.tencent.p177mm.plugin.story.p531g.C46273e;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C35191c;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.protocal.protobuf.cdu;
import com.tencent.p177mm.protocal.protobuf.cdv;
import com.tencent.p177mm.protocal.protobuf.cdw;
import com.tencent.p177mm.protocal.protobuf.cdy;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.protocal.protobuf.cex;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.xweb.util.C6037d;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C31596c;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J,\u0010$\u001a\u00020 2$\u0010#\u001a \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001dJ\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020 2\u0006\u0010&\u001a\u00020'J(\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u0005J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0017H\u0002J\"\u00100\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u00101\u001a\u00020 J\u0006\u00102\u001a\u00020 J\u0016\u00103\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0019J*\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010/\u001a\u00020\u0017H\u0002J0\u0010=\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u0005J8\u0010A\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0007JL\u0010C\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010E\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0017H\u0002J\u0010\u0010F\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J,\u0010G\u001a\u00020 2$\u0010#\u001a \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001dJ\u0010\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020<H\u0002J\u0010\u0010J\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010K\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001eJ\u0016\u0010L\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\u0019J\u0010\u0010M\u001a\u00020<2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010N\u001a\u00020 H\u0002J\u0016\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u001fJ\u0010\u0010R\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001eH\u0002J\u0012\u0010S\u001a\u00020 2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0006\u0010V\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000RZ\u0010\u001b\u001aN\u0012\"\u0012 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001d0\u001cj&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001d`!X\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, dWq = {"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "", "", "", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "postCommentToRemote", "removeCommentChangeListener", "removeStoryCommentChangeListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.b.b */
public final class C46279b implements C1202f, C39863h {
    public static final String TAG = TAG;
    private static final int mzJ = Integer.MAX_VALUE;
    public static final String rVo;
    private static final int rVp = 50;
    public static final cdu rVq = new cdu();
    private static cdw rVr;
    private static C39889a rVs;
    private static int rVt = -1;
    private static final ArrayList<C0011r<Long, Boolean, String, String, C37091y>> rVu = new ArrayList();
    private static final LinkedList<Object> rVv = new LinkedList();
    public static final C46279b rVw = new C46279b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$i */
    static final class C13773i extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean rVH;

        C13773i(boolean z) {
            this.rVH = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109267);
            C46279b c46279b = C46279b.rVw;
            Iterator it = C46279b.rVv.iterator();
            while (it.hasNext()) {
                it.next();
            }
            C16112c.m24429PK().mo28556x(352279, this.rVH);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109267);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$a */
    public static final class C22224a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31596c rVx;

        public C22224a(C31596c c31596c) {
            this.rVx = c31596c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109262);
            C46279b c46279b = C46279b.rVw;
            for (C0011r a : C46279b.rVu) {
                a.mo47a(Long.valueOf(((C35191c) this.rVx.AVE).field_storyId), Boolean.TRUE, ((C35191c) this.rVx.AVE).cEV, ((C35191c) this.rVx.AVE).rVl);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109262);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$g */
    static final class C22225g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31596c rVF;
        final /* synthetic */ C39879j rVG;

        C22225g(C31596c c31596c, C39879j c39879j) {
            this.rVF = c31596c;
            this.rVG = c39879j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(138756);
            C46279b c46279b = C46279b.rVw;
            for (C0011r a : C46279b.rVu) {
                a.mo47a(Long.valueOf(((C35191c) this.rVF.AVE).field_storyId), Boolean.FALSE, ((C35191c) this.rVF.AVE).cEV, ((C35191c) this.rVF.AVE).rVl);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138756);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$b */
    static final class C29303b implements Runnable {
        final /* synthetic */ String rVA;
        final /* synthetic */ long rVy;
        final /* synthetic */ int rVz;

        C29303b(long j, int i, String str) {
            this.rVy = j;
            this.rVz = i;
            this.rVA = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(138751);
            C46279b c46279b = C46279b.rVw;
            C46279b.m86767h(this.rVy, this.rVz, this.rVA);
            AppMethodBeat.m2505o(138751);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$h */
    static final class C31568h extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31596c rVx;

        C31568h(C31596c c31596c) {
            this.rVx = c31596c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109266);
            C46279b c46279b = C46279b.rVw;
            for (C0011r a : C46279b.rVu) {
                a.mo47a(Long.valueOf(((C35191c) this.rVx.AVE).field_storyId), Boolean.FALSE, ((C35191c) this.rVx.AVE).cEV, ((C35191c) this.rVx.AVE).rVl);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109266);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$j */
    static final class C31569j extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31596c rVx;

        C31569j(C31596c c31596c) {
            this.rVx = c31596c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(138757);
            C46279b c46279b = C46279b.rVw;
            for (C0011r a : C46279b.rVu) {
                a.mo47a(Long.valueOf(((C35191c) this.rVx.AVE).field_storyId), Boolean.TRUE, ((C35191c) this.rVx.AVE).cEV, ((C35191c) this.rVx.AVE).rVl);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138757);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$e */
    static final class C39890e implements Runnable {
        public static final C39890e rVD = new C39890e();

        static {
            AppMethodBeat.m2504i(138755);
            AppMethodBeat.m2505o(138755);
        }

        C39890e() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138754);
            C46279b c46279b = C46279b.rVw;
            C46279b.czc();
            AppMethodBeat.m2505o(138754);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$c */
    static final class C43634c implements Runnable {
        final /* synthetic */ cdy rVB;

        C43634c(cdy cdy) {
            this.rVB = cdy;
        }

        public final void run() {
            AppMethodBeat.m2504i(109263);
            C46279b c46279b = C46279b.rVw;
            C46279b.m86764b(this.rVB.xdJ);
            AppMethodBeat.m2505o(109263);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$d */
    static final class C43635d implements Runnable {
        public static final C43635d rVC = new C43635d();

        static {
            AppMethodBeat.m2504i(138753);
            AppMethodBeat.m2505o(138753);
        }

        C43635d() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138752);
            C46279b c46279b = C46279b.rVw;
            C46279b.czc();
            AppMethodBeat.m2505o(138752);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.b.b$f */
    static final class C46278f implements Runnable {
        final /* synthetic */ cdw rVE;

        C46278f(cdw cdw) {
            this.rVE = cdw;
        }

        public final void run() {
            AppMethodBeat.m2504i(109265);
            C46279b c46279b = C46279b.rVw;
            C46279b.m86758a(C46279b.m86761b(this.rVE));
            AppMethodBeat.m2505o(109265);
        }
    }

    static {
        AppMethodBeat.m2504i(109281);
        StringBuilder stringBuilder = new StringBuilder();
        C43642a c43642a = C43641i.rSv;
        rVo = stringBuilder.append(C43641i.rSr).append("commentCache.proto").toString();
        AppMethodBeat.m2505o(109281);
    }

    private C46279b() {
    }

    public static final /* synthetic */ void czc() {
        AppMethodBeat.m2504i(109284);
        C46279b.col();
        AppMethodBeat.m2505o(109284);
    }

    /* renamed from: h */
    public static final /* synthetic */ void m86767h(long j, int i, String str) {
        AppMethodBeat.m2504i(138766);
        C46279b.m86766g(j, i, str);
        AppMethodBeat.m2505o(138766);
    }

    public static void cyZ() {
        AppMethodBeat.m2504i(109268);
        C5730e.m8640q(rVo, rVq.toByteArray());
        AppMethodBeat.m2505o(109268);
    }

    /* renamed from: a */
    public static void m86757a(C0011r<? super Long, ? super Boolean, ? super String, ? super String, C37091y> c0011r) {
        AppMethodBeat.m2504i(138758);
        C25052j.m39376p(c0011r, CastExtraArgs.LISTENER);
        if (!rVu.contains(c0011r)) {
            rVu.add(c0011r);
        }
        AppMethodBeat.m2505o(138758);
    }

    /* renamed from: b */
    public static void m86763b(C0011r<? super Long, ? super Boolean, ? super String, ? super String, C37091y> c0011r) {
        AppMethodBeat.m2504i(138759);
        C25052j.m39376p(c0011r, CastExtraArgs.LISTENER);
        rVu.remove(c0011r);
        AppMethodBeat.m2505o(138759);
    }

    /* renamed from: b */
    public static void m86762b(long j, int i, String str, String str2) {
        AppMethodBeat.m2504i(139084);
        C25052j.m39376p(str2, C8741b.CONTENT);
        C4990ab.m7416i(TAG, "deleteComment storyId:" + j + " commentId:" + i + " sessionId:" + str + " content:" + str2);
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            C4133a c4133a = C43644j.rST;
            String stringBuilder2 = stringBuilder.append(C4133a.cnk()).append(C5046bo.m7588yz()).toString();
            Charset charset = C17355d.UTF_8;
            if (stringBuilder2 == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(139084);
                throw c44941v;
            }
            byte[] bytes = stringBuilder2.getBytes(charset);
            C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
            stringBuilder2 = C6037d.m9506x(bytes);
            cdw cdw = new cdw();
            cdw.rUJ = j;
            cdw.clientId = stringBuilder2;
            cdw.rVd = i;
            cdw.fDG = C1839cb.aaF();
            cdw.state = 3;
            cdw.cvF = str;
            rVq.xdx.add(cdw);
            C46279b.col();
        }
        C4133a c4133a2 = C43644j.rST;
        C4133a.cno().post(new C29303b(j, i, str2));
        AppMethodBeat.m2505o(139084);
    }

    /* renamed from: a */
    public static void m86756a(long j, C39889a c39889a) {
        AppMethodBeat.m2504i(109272);
        C25052j.m39376p(c39889a, "commentItem");
        C4133a c4133a = C43644j.rST;
        C35191c lr = C4133a.cxW().mo55842lr(j);
        if (lr == null) {
            lr = new C35191c();
            lr.field_storyId = j;
        }
        lr.field_readCommentId = c39889a.rVd;
        lr.field_readCommentTime = c39889a.fDG;
        C4133a c4133a2 = C43644j.rST;
        C4133a.cxW().mo10103c(lr, new String[0]);
        AppMethodBeat.m2505o(109272);
    }

    /* renamed from: b */
    public static boolean m86765b(long j, C39889a c39889a) {
        AppMethodBeat.m2504i(109273);
        C25052j.m39376p(c39889a, "commentDetail");
        C31596c c31596c = new C31596c();
        C4133a c4133a = C43644j.rST;
        c31596c.AVE = C4133a.cxW().mo55842lr(j);
        if (((C35191c) c31596c.AVE) == null) {
            c31596c.AVE = new C35191c();
            ((C35191c) c31596c.AVE).field_storyId = j;
        }
        if (((C35191c) c31596c.AVE).field_readCommentId == c39889a.rVd || ((C35191c) c31596c.AVE).field_readCommentTime >= c39889a.fDG) {
            AppMethodBeat.m2505o(109273);
            return false;
        }
        ((C35191c) c31596c.AVE).field_readCommentId = c39889a.rVd;
        ((C35191c) c31596c.AVE).field_readCommentTime = c39889a.fDG;
        ((C35191c) c31596c.AVE).aaS(c39889a.cEV);
        ((C35191c) c31596c.AVE).aaG(c39889a.rVl);
        ((C35191c) c31596c.AVE).cBE();
        c4133a = C43644j.rST;
        C4133a.cxW().mo10103c((C35191c) c31596c.AVE, new String[0]);
        C8902b.m16042a(new C31568h(c31596c));
        AppMethodBeat.m2505o(109273);
        return true;
    }

    /* renamed from: lc */
    public static void m86768lc(long j) {
        AppMethodBeat.m2504i(138760);
        C31596c c31596c = new C31596c();
        C4133a c4133a = C43644j.rST;
        c31596c.AVE = C4133a.cxW().mo55842lr(j);
        if (((C35191c) c31596c.AVE) == null) {
            c31596c.AVE = new C35191c();
            ((C35191c) c31596c.AVE).field_storyId = j;
        }
        c4133a = C43644j.rST;
        C39879j lx = C4133a.cxT().mo74417lx(j);
        if (lx == null) {
            AppMethodBeat.m2505o(138760);
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
        C25052j.m39375o(linkedList, "storyObj.CommentList");
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
            if (((C35191c) c31596c.AVE).field_readCommentId != cdv.wZG && ((C35191c) c31596c.AVE).field_readCommentTime < cdv.pcX) {
                ((C35191c) c31596c.AVE).field_readCommentId = cdv.wZG;
                ((C35191c) c31596c.AVE).field_readCommentTime = cdv.pcX;
                C35191c c35191c = (C35191c) c31596c.AVE;
                String str = cdv.ndG;
                C25052j.m39375o(str, "it.FromUserName");
                c35191c.aaS(str);
                C35191c c35191c2 = (C35191c) c31596c.AVE;
                String str2 = lx.field_userName;
                if (str2 == null) {
                    str2 = "";
                }
                c35191c2.aaG(str2);
                ((C35191c) c31596c.AVE).cBE();
                c4133a = C43644j.rST;
                C4133a.cxW().mo10103c((C35191c) c31596c.AVE, new String[0]);
                C8902b.m16042a(new C22225g(c31596c, lx));
            }
            AppMethodBeat.m2505o(138760);
            return;
        }
        AppMethodBeat.m2505o(138760);
    }

    /* renamed from: M */
    public static void m86753M(boolean z, boolean z2) {
        AppMethodBeat.m2504i(109274);
        boolean bX = C16112c.m24429PK().mo28551bX(352279, 266241);
        C4990ab.m7416i(TAG, "updateCommentRead: " + bX + ", " + z);
        if (bX != z || z2) {
            C8902b.m16042a(new C13773i(z));
        }
        AppMethodBeat.m2505o(109274);
    }

    public static void col() {
        cdw cdw;
        int i = 0;
        AppMethodBeat.m2504i(109275);
        ArrayList arrayList = new ArrayList();
        int size = rVq.xdx.size();
        for (int i2 = 0; i2 < size; i2++) {
            cdw = (cdw) rVq.xdx.get(i2);
            if ((cdw.state == 1 || cdw.state == 3) && cdw.fDG > C1839cb.aaF() - 86400) {
                arrayList.add(cdw);
            }
        }
        rVq.xdx.clear();
        rVq.xdx.addAll(arrayList);
        rVt++;
        if (arrayList.size() == 0) {
            rVt = -1;
            AppMethodBeat.m2505o(109275);
            return;
        }
        rVt %= arrayList.size();
        Collection arrayList2 = new ArrayList();
        size = 0;
        for (Object next : arrayList) {
            int i3;
            int i4 = size + 1;
            if (size < 0) {
                C7987l.dWs();
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
        cdw = (cdw) C25035t.m39338fK((List) arrayList2);
        if (cdw == null || cdw.state != 1) {
            if (cdw != null && cdw.state == 3) {
                C4990ab.m7416i(TAG, "deleteCommentToRemote " + cdw.toUser + ' ' + cdw.rUJ + ' ' + cdw.rVd + ' ' + cdw.fDG);
                rVr = cdw;
                arrayList = new ArrayList();
                long j = cdw.rUJ;
                C35184a c35184a = C35183a.sdm;
                arrayList.add(new C35196k(j, C35183a.scM, cdw.rVd));
                C1682b RO = C1720g.m3535RO();
                C25052j.m39375o(RO, "network()");
                RO.mo5186Rg().mo14552d((C1207m) new C7138g(arrayList, 0));
            }
            AppMethodBeat.m2505o(109275);
            return;
        }
        C4990ab.m7416i(TAG, "postCommentToRemote " + cdw.toUser + ' ' + cdw.rUJ + ' ' + cdw.xdD + ' ' + cdw.fDG);
        rVr = cdw;
        cdv a = C46279b.m86755a(cdw);
        CharSequence charSequence = a.ncM;
        if (charSequence == null || charSequence.length() == 0) {
            i = 1;
        }
        C46273e c46273e;
        if (i != 0) {
            c46273e = C46273e.sbS;
            C46273e.czZ();
        } else {
            c46273e = C46273e.sbS;
            C46273e.cAa();
        }
        C1682b RO2 = C1720g.m3535RO();
        C25052j.m39375o(RO2, "network()");
        C6300p Rg = RO2.mo5186Rg();
        String str = cdw.clientId;
        C25052j.m39375o(str, "commentOp.clientId");
        Rg.mo14552d((C1207m) new C39887d(str, a, cdw.cvF, rVs));
        AppMethodBeat.m2505o(109275);
    }

    /* renamed from: a */
    public static C39889a m86754a(long j, String str, String str2, boolean z, String str3, String str4, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(138761);
        StringBuilder stringBuilder = new StringBuilder();
        C4133a c4133a = C43644j.rST;
        String stringBuilder2 = stringBuilder.append(C4133a.cnk()).append(C5046bo.m7588yz()).toString();
        Charset charset = C17355d.UTF_8;
        if (stringBuilder2 == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(138761);
            throw c44941v;
        }
        byte[] bytes = stringBuilder2.getBytes(charset);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        stringBuilder2 = C6037d.m9506x(bytes);
        cdw cdw = new cdw();
        cdw.clientId = stringBuilder2;
        cdw.rUJ = j;
        cdw.content = str2;
        C4133a c4133a2 = C43644j.rST;
        cdw.cEV = C4133a.cnk();
        cdw.toUser = str;
        cdw.fDG = C1839cb.aaF();
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
        rVs = new C39889a(cdw);
        C46279b.col();
        C4133a c4133a3 = C43644j.rST;
        C4133a.cno().post(new C46278f(cdw));
        C39889a c39889a = rVs;
        if (c39889a == null) {
            C25052j.dWJ();
        }
        AppMethodBeat.m2505o(138761);
        return c39889a;
    }

    /* renamed from: a */
    private static cdv m86755a(cdw cdw) {
        AppMethodBeat.m2504i(109277);
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
        AppMethodBeat.m2505o(109277);
        return cdv;
    }

    /* renamed from: a */
    private static void m86759a(cer cer) {
        AppMethodBeat.m2504i(138762);
        if (cer != null) {
            int cAO;
            C4133a c4133a = C43644j.rST;
            C39879j lx = C4133a.cxT().mo74417lx(cer.vQE);
            if (lx == null) {
                lx = new C39879j();
            }
            C4133a c4133a2 = C43644j.rST;
            C35184a c35184a;
            if (C5046bo.isEqual(C4133a.cnk(), cer.jBB)) {
                c35184a = C35183a.sdm;
                cAO = C35183a.scw;
            } else {
                c35184a = C35183a.sdm;
                cAO = C35183a.scx;
            }
            C29311a c29311a = C29310n.rTi;
            C29311a.m46532a(lx, cer, cAO);
            AppMethodBeat.m2505o(138762);
            return;
        }
        AppMethodBeat.m2505o(138762);
    }

    /* renamed from: g */
    public static void m86766g(long j, int i, String str) {
        int i2 = 0;
        AppMethodBeat.m2504i(138764);
        C4133a c4133a = C43644j.rST;
        C39879j lx = C4133a.cxT().mo74417lx(j);
        if (lx == null) {
            AppMethodBeat.m2505o(138764);
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
            C25052j.m39375o(linkedList, "storyObj.CommentList");
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
            C25052j.m39375o(linkedList, "storyObj.CommentList");
            for (cdv cdv2 : linkedList) {
                if (C5046bo.isEqual(cdv2.ncM, str)) {
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
            c4133a = C43644j.rST;
            C4133a.cxT().mo74401a(j, lx);
        }
        AppMethodBeat.m2505o(138764);
    }

    /* JADX WARNING: Missing block: B:9:0x005d, code skipped:
            if (r1 == null) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:46:0x011e, code skipped:
            if (r0 == null) goto L_0x0120;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ld */
    public static void m86769ld(long j) {
        Object obj = null;
        int i = 0;
        AppMethodBeat.m2504i(138765);
        C4133a c4133a = C43644j.rST;
        C39879j lx = C4133a.cxT().mo74417lx(j);
        C31596c c31596c = new C31596c();
        c4133a = C43644j.rST;
        C35191c lr = C4133a.cxW().mo55842lr(j);
        if (lr == null) {
            AppMethodBeat.m2505o(138765);
            return;
        }
        String str;
        c31596c.AVE = lr;
        if (lx == null) {
            C4990ab.m7416i(TAG, "updateLastCommentSync will reset to 0 0");
            ((C35191c) c31596c.AVE).field_readCommentTime = 0;
            ((C35191c) c31596c.AVE).field_readCommentId = 0;
            ((C35191c) c31596c.AVE).field_syncCommentTime = 0;
            ((C35191c) c31596c.AVE).field_syncCommentId = 0;
            ((C35191c) c31596c.AVE).aaS("");
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
            C25052j.m39375o(linkedList, "storyObj.CommentList");
            List list = linkedList;
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                int i3;
                Object previous = listIterator.previous();
                cdv = (cdv) previous;
                if (cdv.wZG == 0 || cdv.pcX > ((C35191c) c31596c.AVE).field_readCommentTime) {
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
            C4990ab.m7416i(str3, append.append(obj).toString());
            C35191c c35191c = (C35191c) c31596c.AVE;
            if (cdv != null) {
                i2 = cdv.pcX;
            } else {
                i2 = 0;
            }
            c35191c.field_readCommentTime = i2;
            c35191c = (C35191c) c31596c.AVE;
            if (cdv != null) {
                i2 = cdv.wZG;
            } else {
                i2 = 0;
            }
            c35191c.field_readCommentId = i2;
            c35191c = (C35191c) c31596c.AVE;
            if (cdv != null) {
                i2 = cdv.pcX;
            } else {
                i2 = 0;
            }
            c35191c.field_syncCommentTime = i2;
            c35191c = (C35191c) c31596c.AVE;
            if (cdv != null) {
                i = cdv.wZG;
            }
            c35191c.field_syncCommentId = i;
            c35191c = (C35191c) c31596c.AVE;
            if (cdv != null) {
                str2 = cdv.ndG;
            }
            str2 = "";
            c35191c.aaS(str2);
        }
        lr = (C35191c) c31596c.AVE;
        if (lx != null) {
            str = lx.field_userName;
        }
        str = "";
        lr.aaG(str);
        c4133a = C43644j.rST;
        C4133a.cxW().mo10099a((C35191c) c31596c.AVE);
        C8902b.m16042a(new C31569j(c31596c));
        AppMethodBeat.m2505o(138765);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        long j = 100;
        int i3 = 0;
        AppMethodBeat.m2504i(109280);
        C25052j.m39376p(c1207m, "scene");
        int type = c1207m.getType();
        C4990ab.m7416i(TAG, "onSceneEnd " + i + ", " + i2 + ", " + str + ", " + type);
        cdw cdw;
        cdw cdw2;
        String str2;
        StringBuilder stringBuilder;
        C4133a c4133a;
        if (type == C33379c.CTRL_INDEX) {
            C1331a acA = ((C39887d) c1207m).ehh.acA();
            if (acA == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
                AppMethodBeat.m2505o(109280);
                throw c44941v;
            }
            long j2;
            cdy cdy = (cdy) acA;
            C39889a c39889a = ((C39887d) c1207m).rUN;
            if (i == 0 && i2 == 0) {
                String str3 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder("post comment success ");
                cdw = rVr;
                C4990ab.m7416i(str3, stringBuilder2.append(cdw != null ? cdw.content : null).append(' ').append(cdy.wZG).toString());
                C4133a c4133a2 = C43644j.rST;
                C4133a.cno().post(new C43634c(cdy));
                if (c39889a != null) {
                    c39889a.rVd = cdy.wZG;
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
                C4990ab.m7416i(str2, stringBuilder.append(cdw2 != null ? cdw2.content : null).toString());
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
            c4133a = C43644j.rST;
            C4133a.cno().postDelayed(C43635d.rVC, j2);
            AppMethodBeat.m2505o(109280);
            return;
        }
        if (type == 764 && (((C7138g) c1207m).cyX() instanceof C35196k)) {
            if (i == 0 && i2 == 0) {
                String str4 = TAG;
                StringBuilder stringBuilder3 = new StringBuilder("delete comment success ");
                cdw2 = rVr;
                C4990ab.m7416i(str4, stringBuilder3.append(cdw2 != null ? cdw2.content : null).toString());
                cdw2 = rVr;
                if (cdw2 != null) {
                    cdw2.state = 4;
                }
                rVr = null;
            } else {
                str2 = TAG;
                stringBuilder = new StringBuilder("delete comment fail ");
                cdw2 = rVr;
                C4990ab.m7416i(str2, stringBuilder.append(cdw2 != null ? cdw2.content : null).toString());
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
            c4133a = C43644j.rST;
            C4133a.cno().postDelayed(C39890e.rVD, j);
        }
        AppMethodBeat.m2505o(109280);
    }

    /* renamed from: a */
    public static void m86760a(cex cex) {
        AppMethodBeat.m2504i(138763);
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
        C4133a c4133a = C43644j.rST;
        C39879j lx = C4133a.cxT().mo74417lx(j);
        if (lx == null) {
            C46279b.m86759a(cex.xex.xdJ);
            AppMethodBeat.m2505o(138763);
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
        if (C5046bo.isNullOrNil(cdv.ncM)) {
            if (cdv.wZG != 0) {
                linkedList = cer.xeq;
                C25052j.m39375o(linkedList, "storyObj.BubbleList");
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
            C25052j.m39375o(linkedList, "storyObj.CommentList");
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
            c4133a = C43644j.rST;
            C4133a.cxT().mo74401a(j, lx);
        }
        AppMethodBeat.m2505o(138763);
    }
}
