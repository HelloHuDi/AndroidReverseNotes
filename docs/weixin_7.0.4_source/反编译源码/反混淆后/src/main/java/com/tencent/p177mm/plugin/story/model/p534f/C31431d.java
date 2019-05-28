package com.tencent.p177mm.plugin.story.model.p534f;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.p230g.p231a.C18384ro.C18385a;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.story.api.C29269k;
import com.tencent.p177mm.plugin.story.api.C29269k.C29271a;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p744a.C35193c;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C39882l;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.protocal.protobuf.cdt;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import p000a.C0220l;
import p000a.C31826o;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C41363p;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p772b.C7992b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001 \u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001FB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0002J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0005H\u0002J\u001c\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u000105H\u0016J*\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0012\u0010>\u001a\u00020(2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020(H\u0016J\b\u0010A\u001a\u00020(H\u0016J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u00020(H\u0002J\b\u0010D\u001a\u00020(H\u0002J\u0018\u0010E\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\rH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000Rb\u0010\n\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000Rb\u0010\u0019\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000Rb\u0010\u001a\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000RN\u0010$\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r\u0018\u00010&0%X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "talker", "", "(Ljava/lang/String;)V", "blackTagList", "", "chatRoomStgListener", "friendUnreadList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "kotlin.jvm.PlatformType", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "hasStory", "", "hasUnread", "isPause", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "nextFetchTime", "", "normalUnreadList", "readList", "roomMember", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "roomMemberReady", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1;", "tryStartFetchRunnable", "Ljava/lang/Runnable;", "userUpdateMap", "", "", "addNewUserStory", "", "username", "extInfo", "checkChatRoomState", "checkExpire", "checkFetch", "checkStoryUnread", "destroy", "isRoomMember", "userName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "registerNotifyListener", "removeUserStory", "resume", "start", "tryStartFetch", "updateChatRoomState", "updateGalleryUserList", "updateUserState", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.f.d */
public final class C31431d implements C1202f, C29269k, C4931a {
    private static final String TAG = TAG;
    public static final C29306a rXt = new C29306a();
    private boolean cAY;
    private final C7306ak handler;
    private boolean pls;
    private List<String> qGk;
    public C29271a rXb;
    private boolean rXd;
    private final List<C31826o<String, C4119f>> rXj = Collections.synchronizedList(new ArrayList());
    private final List<C31826o<String, C4119f>> rXk = Collections.synchronizedList(new ArrayList());
    private final List<C31826o<String, C4119f>> rXl = Collections.synchronizedList(new ArrayList());
    private long rXm;
    private final Map<String, C4119f> rXn = Collections.synchronizedMap(new HashMap());
    private final Runnable rXo;
    private final ArrayList<String> rXp;
    private boolean rXq;
    private final C4931a rXr;
    private final C31433d rXs;
    private final String talker;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$b */
    static final class C13782b implements C4931a {
        final /* synthetic */ C31431d rXu;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.d$b$1 */
        static final class C137831 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C13782b rXv;

            C137831(C13782b c13782b) {
                this.rXv = c13782b;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109392);
                C31431d.m50827d(this.rXv.rXu);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109392);
                return c37091y;
            }
        }

        C13782b(C31431d c31431d) {
            this.rXu = c31431d;
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(109393);
            C4990ab.m7416i(C31431d.TAG, "chatRoomStgListener ".concat(String.valueOf(str)));
            if (!this.rXu.rXq && C25052j.m39373j(str, this.rXu.talker)) {
                C8902b.m16044a("StoryStateFetcher_updateChatRoom", (C31214a) new C137831(this));
            }
            AppMethodBeat.m2505o(109393);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$i */
    public static final class C22237i<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.m2504i(109401);
            int a = C7992b.m14176a(Long.valueOf(((C4119f) ((C31826o) t2).second).field_readTime), Long.valueOf(((C4119f) ((C31826o) t).second).field_readTime));
            AppMethodBeat.m2505o(109401);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$a */
    public static final class C29306a {
        private C29306a() {
        }

        public /* synthetic */ C29306a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$c */
    static final class C31432c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31431d rXu;

        C31432c(C31431d c31431d) {
            this.rXu = c31431d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            C37091y c37091y;
            AppMethodBeat.m2504i(109394);
            ArrayList<String> arrayList = new ArrayList();
            List e = this.rXu.rXl;
            C25052j.m39375o(e, "friendUnreadList");
            Object<C31826o> obj = e;
            synchronized (obj) {
                try {
                    for (C31826o c31826o : obj) {
                        if (!((C4119f) c31826o.second).isValid()) {
                            arrayList.add(c31826o.first);
                        }
                    }
                    c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(109394);
                }
            }
            e = this.rXu.rXk;
            C25052j.m39375o(e, "normalUnreadList");
            Iterable<C31826o> iterable = e;
            synchronized (iterable) {
                try {
                    for (C31826o c31826o2 : iterable) {
                        if (!((C4119f) c31826o2.second).isValid()) {
                            arrayList.add(c31826o2.first);
                        }
                    }
                    c37091y = C37091y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(109394);
                }
            }
            e = this.rXu.rXj;
            C25052j.m39375o(e, "readList");
            iterable = e;
            synchronized (iterable) {
                try {
                    for (C31826o c31826o22 : iterable) {
                        if (!((C4119f) c31826o22.second).isValid()) {
                            arrayList.add(c31826o22.first);
                        }
                    }
                    c37091y = C37091y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(109394);
                }
            }
            for (String str : arrayList) {
                C4990ab.m7416i(C31431d.TAG, "LogStory: expired ".concat(String.valueOf(str)));
                C22241k c22241k = C22241k.rTc;
                C22241k.aan(str);
            }
            Object obj2 = C37091y.AUy;
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$d */
    public static final class C31433d extends C4884c<C18384ro> {
        final /* synthetic */ C31431d rXu;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.d$d$a */
        static final class C31434a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C18384ro rWW;
            final /* synthetic */ C31433d rXw;

            C31434a(C31433d c31433d, C18384ro c18384ro) {
                this.rXw = c31433d;
                this.rWW = c18384ro;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                C18385a c18385a;
                AppMethodBeat.m2504i(109395);
                C18384ro c18384ro = this.rWW;
                if (c18384ro != null) {
                    c18385a = c18384ro.cNw;
                } else {
                    c18385a = null;
                }
                if (!(c18385a == null || !this.rWW.cNw.cNx || TextUtils.isEmpty(this.rWW.cNw.username))) {
                    C31431d c31431d = this.rXw.rXu;
                    String str = this.rWW.cNw.username;
                    C25052j.m39375o(str, "event.data.username");
                    if (C31431d.m50822a(c31431d, str)) {
                        if (this.rWW.cNw.cNz) {
                            C4133a c4133a = C43644j.rST;
                            C29296g cxU = C4133a.cxU();
                            str = this.rWW.cNw.username;
                            C25052j.m39375o(str, "event.data.username");
                            C4119f aap = cxU.aap(str);
                            C31431d c31431d2 = this.rXw.rXu;
                            String str2 = this.rWW.cNw.username;
                            C25052j.m39375o(str2, "event.data.username");
                            C31431d.m50819a(c31431d2, str2, aap);
                        } else {
                            c31431d = this.rXw.rXu;
                            str = this.rWW.cNw.username;
                            C25052j.m39375o(str, "event.data.username");
                            C31431d.m50824b(c31431d, str);
                        }
                        C31431d.m50833j(this.rXw.rXu);
                        C31431d.m50834k(this.rXw.rXu);
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109395);
                return c37091y;
            }
        }

        C31433d(C31431d c31431d) {
            this.rXu = c31431d;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(109396);
            C8902b.m16042a(new C31434a(this, (C18384ro) c4883b));
            AppMethodBeat.m2505o(109396);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$e */
    static final class C31435e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C31431d rXu;

        C31435e(C31431d c31431d) {
            this.rXu = c31431d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109397);
            C4990ab.m7416i(C31431d.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + C1839cb.aaD());
            C4990ab.m7416i(C31431d.TAG, "startSession " + this.rXu.talker + ' ' + this.rXu.hashCode());
            C4133a c4133a = C43644j.rST;
            C39882l abc = C4133a.cxV().abc(this.rXu.talker);
            C31431d c31431d = this.rXu;
            List cmt = C39732a.cmt();
            C25052j.m39375o(cmt, "StoryStateMiddleLayer.getBlackTagList()");
            c31431d.qGk = cmt;
            this.rXu.rXm = abc.field_nextSyncTime;
            C4990ab.m7416i(C31431d.TAG, "next sync time " + this.rXu.rXm);
            C31431d.m50826c(this.rXu);
            C31431d.m50827d(this.rXu);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109397);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$g */
    public static final class C31436g<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.m2504i(109399);
            int a = C7992b.m14176a(Integer.valueOf(((C4119f) ((C31826o) t2).second).field_storyPostTime), Integer.valueOf(((C4119f) ((C31826o) t).second).field_storyPostTime));
            AppMethodBeat.m2505o(109399);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$f */
    static final class C31437f implements Runnable {
        final /* synthetic */ C31431d rXu;

        C31437f(C31431d c31431d) {
            this.rXu = c31431d;
        }

        public final void run() {
            AppMethodBeat.m2504i(109398);
            C31431d.m50831h(this.rXu);
            AppMethodBeat.m2505o(109398);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.d$h */
    public static final class C31438h<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.m2504i(109400);
            int a = C7992b.m14176a(Integer.valueOf(((C4119f) ((C31826o) t2).second).field_storyPostTime), Integer.valueOf(((C4119f) ((C31826o) t).second).field_storyPostTime));
            AppMethodBeat.m2505o(109400);
            return a;
        }
    }

    public C31431d(String str) {
        C25052j.m39376p(str, "talker");
        AppMethodBeat.m2504i(109415);
        this.talker = str;
        C5004al RS = C1720g.m3539RS();
        C25052j.m39375o(RS, "MMKernel.getPizzaWorkerThread()");
        this.handler = new C7306ak(RS.getLooper());
        this.rXo = new C31437f(this);
        this.qGk = new LinkedList();
        this.rXp = new ArrayList();
        this.rXr = new C13782b(this);
        this.rXs = new C31433d(this);
        AppMethodBeat.m2505o(109415);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m50819a(C31431d c31431d, String str, C4119f c4119f) {
        AppMethodBeat.m2504i(109422);
        c31431d.m50825b(str, c4119f);
        AppMethodBeat.m2505o(109422);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m50826c(C31431d c31431d) {
        AppMethodBeat.m2504i(109417);
        c31431d.czt();
        AppMethodBeat.m2505o(109417);
    }

    /* renamed from: j */
    public static final /* synthetic */ void m50833j(C31431d c31431d) {
        AppMethodBeat.m2504i(109423);
        c31431d.czr();
        AppMethodBeat.m2505o(109423);
    }

    /* renamed from: k */
    public static final /* synthetic */ void m50834k(C31431d c31431d) {
        AppMethodBeat.m2504i(109424);
        c31431d.czs();
        AppMethodBeat.m2505o(109424);
    }

    static {
        AppMethodBeat.m2504i(109416);
        AppMethodBeat.m2505o(109416);
    }

    public final void start() {
        AppMethodBeat.m2504i(109402);
        C8902b.m16044a("StoryStateFetcher_start", (C31214a) new C31435e(this));
        this.rXs.dnU();
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14539a((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, (C1202f) this);
        C4133a c4133a = C43644j.rST;
        C4133a.cxU().mo10114a(this, Looper.getMainLooper());
        C1694a K = C1720g.m3528K(C6822c.class);
        C25052j.m39375o(K, "MMKernel.service(IChatroomService::class.java)");
        ((C6822c) K).mo15090XV().mo10116c(this.rXr);
        AppMethodBeat.m2505o(109402);
    }

    public final void resume() {
        AppMethodBeat.m2504i(109403);
        this.cAY = false;
        czt();
        C8902b.m16044a("StoryStateFetcher_checkExpire", (C31214a) new C31432c(this));
        AppMethodBeat.m2505o(109403);
    }

    public final void pause() {
        AppMethodBeat.m2504i(109404);
        this.cAY = true;
        this.handler.removeCallbacks(this.rXo);
        AppMethodBeat.m2505o(109404);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(109405);
        C4990ab.m7416i(TAG, "endSession " + this.talker + ' ' + hashCode());
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14546b((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, (C1202f) this);
        C4133a c4133a = C43644j.rST;
        C4133a.cxU().mo10117d(this);
        C1694a K = C1720g.m3528K(C6822c.class);
        C25052j.m39375o(K, "MMKernel.service(IChatroomService::class.java)");
        ((C6822c) K).mo15090XV().mo10117d(this.rXr);
        this.handler.removeCallbacks(this.rXo);
        this.rXs.dead();
        AppMethodBeat.m2505o(109405);
    }

    /* renamed from: ZW */
    public final boolean mo47443ZW(String str) {
        AppMethodBeat.m2504i(109406);
        C25052j.m39376p(str, "username");
        if (this.rXn.get(str) == null) {
            Map map = this.rXn;
            C25052j.m39375o(map, "userUpdateMap");
            C4133a c4133a = C43644j.rST;
            map.put(str, C4133a.cxU().aap(str));
        }
        C4119f c4119f = (C4119f) this.rXn.get(str);
        if (c4119f == null || !c4119f.cBN()) {
            AppMethodBeat.m2505o(109406);
            return false;
        }
        AppMethodBeat.m2505o(109406);
        return true;
    }

    /* renamed from: a */
    public final void mo47444a(C29271a c29271a) {
        this.rXb = c29271a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void czr() {
        boolean z;
        boolean z2;
        C29271a c29271a;
        AppMethodBeat.m2504i(109407);
        List list = this.rXk;
        C25052j.m39375o(list, "normalUnreadList");
        if ((!((Collection) list).isEmpty() ? 1 : null) == null) {
            list = this.rXl;
            C25052j.m39375o(list, "friendUnreadList");
            if ((!((Collection) list).isEmpty() ? 1 : null) == null) {
                z = false;
                if (!z) {
                    Object obj;
                    list = this.rXj;
                    C25052j.m39375o(list, "readList");
                    if (list.isEmpty()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        z2 = false;
                        if (!(this.pls == z2 && this.rXd == z)) {
                            c29271a = this.rXb;
                            if (c29271a != null) {
                                c29271a.mo47449L(z2, z);
                                AppMethodBeat.m2505o(109407);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(109407);
                    }
                }
                z2 = true;
                c29271a = this.rXb;
                if (c29271a != null) {
                }
                AppMethodBeat.m2505o(109407);
            }
        }
        z = true;
        if (z) {
        }
        z2 = true;
        c29271a = this.rXb;
        if (c29271a != null) {
        }
        AppMethodBeat.m2505o(109407);
    }

    private final void czs() {
        Object obj;
        C37091y c37091y;
        String obj2;
        Object obj3;
        AppMethodBeat.m2504i(109408);
        ArrayList arrayList = new ArrayList();
        List list = this.rXl;
        C25052j.m39375o(list, "friendUnreadList");
        if (list.size() > 1) {
            C41363p.m72150a(list, new C31436g());
        }
        list = this.rXk;
        C25052j.m39375o(list, "normalUnreadList");
        if (list.size() > 1) {
            C41363p.m72150a(list, new C31438h());
        }
        String str = "";
        List list2 = this.rXk;
        C25052j.m39375o(list2, "normalUnreadList");
        Iterable<C31826o> iterable = list2;
        synchronized (iterable) {
            try {
                int i = 0;
                for (C31826o c31826o : iterable) {
                    int i2 = i + 1;
                    String str2 = str + "unRead:" + i + ' ' + C5046bo.m7565ga(((C4119f) c31826o.second).cBL()) + "  userName:" + ((C4119f) c31826o.second).getUserName() + " |, ";
                    if (i > 2) {
                        obj2 = str2;
                        break;
                    }
                    i = i2;
                    str = str2;
                }
                c37091y = C37091y.AUy;
                obj2 = str;
            } finally {
                AppMethodBeat.m2505o(109408);
            }
        }
        C4990ab.m7416i(TAG, "unRead preLoadCache: ".concat(String.valueOf(obj2)));
        ArrayList<String> arrayList2 = new ArrayList();
        list2 = this.rXl;
        C25052j.m39375o(list2, "friendUnreadList");
        if ((!((Collection) list2).isEmpty() ? 1 : null) != null) {
            if (((C4119f) ((C31826o) this.rXl.get(0)).second).cBL() > 0) {
                obj2 = (C31826o) this.rXl.get(0);
                this.rXl.remove(obj2);
            } else {
                obj2 = null;
            }
            list = this.rXl;
            C25052j.m39375o(list, "friendUnreadList");
            Collections.shuffle(list, new Random());
            if (obj2 != null) {
                this.rXl.add(0, obj2);
            }
            obj3 = obj2;
        } else {
            obj3 = null;
        }
        list2 = this.rXl;
        C25052j.m39375o(list2, "friendUnreadList");
        iterable = list2;
        synchronized (iterable) {
            try {
                for (C31826o c31826o2 : iterable) {
                    arrayList2.add(c31826o2.first);
                }
                c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(109408);
            }
        }
        if (arrayList2.isEmpty()) {
            list2 = this.rXk;
            C25052j.m39375o(list2, "normalUnreadList");
            if ((!((Collection) list2).isEmpty() ? 1 : null) != null) {
                if (((C4119f) ((C31826o) this.rXk.get(0)).second).cBL() > 0) {
                    obj2 = (C31826o) this.rXk.get(0);
                    this.rXk.remove(obj2);
                } else {
                    obj2 = obj3;
                }
                if (obj2 != null) {
                    this.rXk.add(0, obj2);
                }
            }
        }
        list2 = this.rXk;
        C25052j.m39375o(list2, "normalUnreadList");
        iterable = list2;
        synchronized (iterable) {
            try {
                for (C31826o c31826o22 : iterable) {
                    arrayList2.add(c31826o22.first);
                }
                c37091y = C37091y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(109408);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        list2 = this.rXj;
        C25052j.m39375o(list2, "readList");
        iterable = list2;
        synchronized (iterable) {
            try {
                for (C31826o c31826o222 : iterable) {
                    arrayList3.add(c31826o222);
                }
                c37091y = C37091y.AUy;
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(109408);
            }
        }
        ArrayList<String> arrayList4 = new ArrayList();
        list2 = arrayList3;
        if (list2.size() > 1) {
            C41363p.m72150a(list2, new C22237i());
        }
        Iterable<C31826o> iterable2 = arrayList3;
        synchronized (iterable2) {
            try {
                for (C31826o c31826o3 : iterable2) {
                    arrayList4.add(c31826o3.first);
                }
                C37091y c37091y2 = C37091y.AUy;
            } catch (Throwable th3) {
                AppMethodBeat.m2505o(109408);
            }
        }
        for (String obj22 : arrayList2) {
            if (!arrayList.contains(obj22)) {
                arrayList.add(obj22);
            }
        }
        for (String obj222 : arrayList4) {
            if (!arrayList.contains(obj222)) {
                arrayList.add(obj222);
            }
        }
        C29271a c29271a = this.rXb;
        if (c29271a != null) {
            c29271a.mo47450a(arrayList, arrayList2);
        }
    }

    private final void czt() {
        long j = 0;
        AppMethodBeat.m2504i(109409);
        long currentTimeMillis = this.rXm - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            this.rXm = System.currentTimeMillis();
        } else {
            j = currentTimeMillis;
        }
        this.handler.removeCallbacks(this.rXo);
        this.handler.postDelayed(this.rXo, j);
        AppMethodBeat.m2505o(109409);
    }

    /* renamed from: a */
    private final void m50821a(String str, C4119f c4119f) {
        AppMethodBeat.m2504i(109410);
        if (this.qGk.contains(str)) {
            AppMethodBeat.m2505o(109410);
            return;
        }
        C29271a c29271a = this.rXb;
        if (c29271a != null) {
            c29271a.mo47451bs(str, c4119f.cBN());
        }
        aaL(str);
        m50825b(str, c4119f);
        czr();
        czs();
        AppMethodBeat.m2505o(109410);
    }

    private final void aaL(String str) {
        List list;
        Object obj;
        C31826o c31826o;
        AppMethodBeat.m2504i(109411);
        List list2 = this.rXk;
        C25052j.m39375o(list2, "normalUnreadList");
        synchronized (list2) {
            try {
                list = this.rXk;
                C25052j.m39375o(list, "normalUnreadList");
                for (Object next : list) {
                    if (C25052j.m39373j((String) ((C31826o) next).first, str)) {
                        obj = next;
                        break;
                    }
                }
                obj = null;
                c31826o = (C31826o) obj;
                if (c31826o != null) {
                    Boolean.valueOf(this.rXk.remove(c31826o));
                }
            } finally {
                AppMethodBeat.m2505o(109411);
            }
        }
        list2 = this.rXl;
        C25052j.m39375o(list2, "friendUnreadList");
        synchronized (list2) {
            try {
                list = this.rXl;
                C25052j.m39375o(list, "friendUnreadList");
                for (Object next2 : list) {
                    if (C25052j.m39373j((String) ((C31826o) next2).first, str)) {
                        obj = next2;
                        break;
                    }
                }
                obj = null;
                c31826o = (C31826o) obj;
                if (c31826o != null) {
                    Boolean.valueOf(this.rXl.remove(c31826o));
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(109411);
            }
        }
        list2 = this.rXj;
        C25052j.m39375o(list2, "readList");
        synchronized (list2) {
            try {
                list = this.rXj;
                C25052j.m39375o(list, "readList");
                for (Object next22 : list) {
                    if (C25052j.m39373j((String) ((C31826o) next22).first, str)) {
                        obj = next22;
                        break;
                    }
                }
                obj = null;
                c31826o = (C31826o) obj;
                if (c31826o != null) {
                    Boolean.valueOf(this.rXj.remove(c31826o));
                }
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(109411);
            }
        }
    }

    /* renamed from: b */
    private final void m50825b(String str, C4119f c4119f) {
        AppMethodBeat.m2504i(109412);
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
        C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
        boolean NX = aoO != null ? aoO.mo16693NX() : false;
        if (!c4119f.cBN()) {
            if (c4119f.isValid()) {
                this.rXj.add(new C31826o(str, c4119f));
            }
            AppMethodBeat.m2505o(109412);
        } else if (NX) {
            this.rXl.add(new C31826o(str, c4119f));
            AppMethodBeat.m2505o(109412);
        } else {
            this.rXk.add(new C31826o(str, c4119f));
            AppMethodBeat.m2505o(109412);
        }
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(109413);
        if (!(str == null || c4935m == null || !(c4935m.obj instanceof C4119f))) {
            Object obj = c4935m.obj;
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                AppMethodBeat.m2505o(109413);
                throw c44941v;
            }
            C4119f c4119f = (C4119f) obj;
            if (!this.rXp.contains(c4119f.getUserName())) {
                AppMethodBeat.m2505o(109413);
                return;
            } else if (C39732a.m67945Xv(c4119f.getUserName())) {
                AppMethodBeat.m2505o(109413);
                return;
            } else {
                Map map = this.rXn;
                C25052j.m39375o(map, "userUpdateMap");
                map.put(c4119f.getUserName(), c4119f);
                if (C25052j.m39373j(str, "notify_story_read")) {
                    C4990ab.m7416i(TAG, "update user " + c4119f.getUserName() + ' ' + c4119f.field_syncId + " as read");
                    m50821a(c4119f.getUserName(), c4119f);
                    AppMethodBeat.m2505o(109413);
                    return;
                } else if (C25052j.m39373j(str, "notify_story_unread")) {
                    C4990ab.m7416i(TAG, "update user " + c4119f.getUserName() + ' ' + c4119f.field_syncId + " as unread");
                    m50821a(c4119f.getUserName(), c4119f);
                    AppMethodBeat.m2505o(109413);
                    return;
                } else if (C25052j.m39373j(str, "notify_story_preload")) {
                    C4990ab.m7416i(TAG, "update user " + c4119f.getUserName() + ' ' + c4119f.field_syncId + " as preload " + c4119f.cBL());
                    m50821a(c4119f.getUserName(), c4119f);
                    AppMethodBeat.m2505o(109413);
                    return;
                } else if (C25052j.m39373j(str, "notify_story_invalid")) {
                    C4990ab.m7416i(TAG, "update user " + c4119f.getUserName() + " as invalid");
                    m50821a(c4119f.getUserName(), c4119f);
                    AppMethodBeat.m2505o(109413);
                    return;
                } else if (C25052j.m39373j(str, "notify_story_valid")) {
                    C4990ab.m7416i(TAG, "update user " + c4119f.getUserName() + " as valid");
                    m50821a(c4119f.getUserName(), c4119f);
                }
            }
        }
        AppMethodBeat.m2505o(109413);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(109414);
        C25052j.m39376p(c1207m, "scene");
        C4990ab.m7416i(TAG, "onSceneEnd " + i + ", " + i2 + ", " + str + ", " + c1207m.getType());
        if (c1207m.getType() == TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR && (c1207m instanceof C35193c)) {
            C4133a c4133a;
            if ((C25052j.m39373j(((C35193c) c1207m).gpx, this.talker) ^ 1) != 0) {
                AppMethodBeat.m2505o(109414);
                return;
            } else if (i == 0 && i2 == 0) {
                C1331a acA = ((C35193c) c1207m).ehh.acA();
                if (acA == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncResponse");
                    AppMethodBeat.m2505o(109414);
                    throw c44941v;
                }
                cdt cdt = (cdt) acA;
                C4990ab.m7416i(TAG, "response: count " + cdt.xdu + ", interval " + cdt.xdw);
                c4133a = C43644j.rST;
                this.rXm = C4133a.cxV().abc(this.talker).field_nextSyncTime;
                czt();
                AppMethodBeat.m2505o(109414);
                return;
            } else {
                c4133a = C43644j.rST;
                this.rXm = C4133a.cxV().abc(this.talker).field_nextSyncTime;
                czt();
            }
        }
        AppMethodBeat.m2505o(109414);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m50827d(C31431d c31431d) {
        AppMethodBeat.m2504i(109418);
        C8901a c8901a = new C8901a("checkChatRoomState");
        List my = C37921n.m64074my(c31431d.talker);
        if (my == null) {
            AppMethodBeat.m2505o(109418);
            return;
        }
        c31431d.rXp.addAll(my);
        c31431d.rXq = c31431d.rXp.size() > 0;
        C4990ab.m7416i(TAG, "room member size " + c31431d.rXp.size());
        Iterable<String> iterable = my;
        synchronized (iterable) {
            try {
                for (String str : iterable) {
                    if (str != null) {
                        C4133a c4133a = C43644j.rST;
                        if (!(C5046bo.isEqual(C4133a.cnk(), str) || c31431d.qGk.contains(str))) {
                            c4133a = C43644j.rST;
                            C4119f aap = C4133a.cxU().aap(str);
                            boolean isValid = aap.isValid();
                            boolean cBN = aap.cBN();
                            C1694a K = C1720g.m3528K(C6982j.class);
                            C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                            C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
                            boolean NX = aoO != null ? aoO.mo16693NX() : false;
                            if (cBN) {
                                if (NX) {
                                    c31431d.rXl.add(new C31826o(str, aap));
                                } else {
                                    c31431d.rXk.add(new C31826o(str, aap));
                                }
                                c31431d.czr();
                            } else if (isValid) {
                                c31431d.rXj.add(new C31826o(str, aap));
                                c31431d.czr();
                            }
                        }
                    }
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(109418);
            }
        }
        c31431d.czs();
        c8901a.mo20314SW();
    }

    /* renamed from: h */
    public static final /* synthetic */ void m50831h(C31431d c31431d) {
        AppMethodBeat.m2504i(109419);
        C4133a c4133a = C43644j.rST;
        if (C4133a.cyg() && !C5046bo.isNullOrNil(c31431d.talker) && C1855t.m3902mO(c31431d.talker)) {
            C4990ab.m7416i(TAG, "tryStartFetch " + c31431d.talker);
            if (!C46270n.cxe()) {
                C4990ab.m7416i(TAG, "filter RoomSync");
            } else if (!c31431d.cAY) {
                C4990ab.m7416i(TAG, "start fetch " + c31431d.talker);
                C1682b RO = C1720g.m3535RO();
                C25052j.m39375o(RO, "network()");
                RO.mo5186Rg().mo14552d((C1207m) new C35193c(c31431d.talker));
                AppMethodBeat.m2505o(109419);
                return;
            }
        }
        AppMethodBeat.m2505o(109419);
    }
}
