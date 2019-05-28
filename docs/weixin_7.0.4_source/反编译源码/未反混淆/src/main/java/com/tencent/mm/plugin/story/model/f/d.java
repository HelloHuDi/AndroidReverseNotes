package com.tencent.mm.plugin.story.model.f;

import a.a.p;
import a.f.b.j;
import a.l;
import a.o;
import a.v;
import a.y;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
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

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001 \u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001FB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0002J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0005H\u0002J\u001c\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u000105H\u0016J*\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0012\u0010>\u001a\u00020(2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020(H\u0016J\b\u0010A\u001a\u00020(H\u0016J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u00020(H\u0002J\b\u0010D\u001a\u00020(H\u0002J\u0018\u0010E\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\rH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000Rb\u0010\n\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000Rb\u0010\u0019\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000Rb\u0010\u001a\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000RN\u0010$\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r\u0018\u00010&0%X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "talker", "", "(Ljava/lang/String;)V", "blackTagList", "", "chatRoomStgListener", "friendUnreadList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "kotlin.jvm.PlatformType", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "hasStory", "", "hasUnread", "isPause", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "nextFetchTime", "", "normalUnreadList", "readList", "roomMember", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "roomMemberReady", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1;", "tryStartFetchRunnable", "Ljava/lang/Runnable;", "userUpdateMap", "", "", "addNewUserStory", "", "username", "extInfo", "checkChatRoomState", "checkExpire", "checkFetch", "checkStoryUnread", "destroy", "isRoomMember", "userName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "registerNotifyListener", "removeUserStory", "resume", "start", "tryStartFetch", "updateChatRoomState", "updateGalleryUserList", "updateUserState", "Companion", "plugin-story_release"})
public final class d implements com.tencent.mm.ai.f, k, com.tencent.mm.sdk.e.k.a {
    private static final String TAG = TAG;
    public static final a rXt = new a();
    private boolean cAY;
    private final ak handler;
    private boolean pls;
    private List<String> qGk;
    public com.tencent.mm.plugin.story.api.k.a rXb;
    private boolean rXd;
    private final List<o<String, com.tencent.mm.plugin.story.h.f>> rXj = Collections.synchronizedList(new ArrayList());
    private final List<o<String, com.tencent.mm.plugin.story.h.f>> rXk = Collections.synchronizedList(new ArrayList());
    private final List<o<String, com.tencent.mm.plugin.story.h.f>> rXl = Collections.synchronizedList(new ArrayList());
    private long rXm;
    private final Map<String, com.tencent.mm.plugin.story.h.f> rXn = Collections.synchronizedMap(new HashMap());
    private final Runnable rXo;
    private final ArrayList<String> rXp;
    private boolean rXq;
    private final com.tencent.mm.sdk.e.k.a rXr;
    private final d rXs;
    private final String talker;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class b implements com.tencent.mm.sdk.e.k.a {
        final /* synthetic */ d rXu;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.d$b$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ b rXv;

            AnonymousClass1(b bVar) {
                this.rXv = bVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109392);
                d.d(this.rXv.rXu);
                y yVar = y.AUy;
                AppMethodBeat.o(109392);
                return yVar;
            }
        }

        b(d dVar) {
            this.rXu = dVar;
        }

        public final void a(String str, m mVar) {
            AppMethodBeat.i(109393);
            ab.i(d.TAG, "chatRoomStgListener ".concat(String.valueOf(str)));
            if (!this.rXu.rXq && j.j(str, this.rXu.talker)) {
                com.tencent.mm.ab.b.a("StoryStateFetcher_updateChatRoom", (a.f.a.a) new AnonymousClass1(this));
            }
            AppMethodBeat.o(109393);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class i<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.i(109401);
            int a = a.b.b.a(Long.valueOf(((com.tencent.mm.plugin.story.h.f) ((o) t2).second).field_readTime), Long.valueOf(((com.tencent.mm.plugin.story.h.f) ((o) t).second).field_readTime));
            AppMethodBeat.o(109401);
            return a;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ d rXu;

        c(d dVar) {
            this.rXu = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            y yVar;
            AppMethodBeat.i(109394);
            ArrayList<String> arrayList = new ArrayList();
            List e = this.rXu.rXl;
            j.o(e, "friendUnreadList");
            Object<o> obj = e;
            synchronized (obj) {
                try {
                    for (o oVar : obj) {
                        if (!((com.tencent.mm.plugin.story.h.f) oVar.second).isValid()) {
                            arrayList.add(oVar.first);
                        }
                    }
                    yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(109394);
                }
            }
            e = this.rXu.rXk;
            j.o(e, "normalUnreadList");
            Iterable<o> iterable = e;
            synchronized (iterable) {
                try {
                    for (o oVar2 : iterable) {
                        if (!((com.tencent.mm.plugin.story.h.f) oVar2.second).isValid()) {
                            arrayList.add(oVar2.first);
                        }
                    }
                    yVar = y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.o(109394);
                }
            }
            e = this.rXu.rXj;
            j.o(e, "readList");
            iterable = e;
            synchronized (iterable) {
                try {
                    for (o oVar22 : iterable) {
                        if (!((com.tencent.mm.plugin.story.h.f) oVar22.second).isValid()) {
                            arrayList.add(oVar22.first);
                        }
                    }
                    yVar = y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.o(109394);
                }
            }
            for (String str : arrayList) {
                ab.i(d.TAG, "LogStory: expired ".concat(String.valueOf(str)));
                com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
                com.tencent.mm.plugin.story.model.k.aan(str);
            }
            Object obj2 = y.AUy;
            return obj2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class d extends com.tencent.mm.sdk.b.c<ro> {
        final /* synthetic */ d rXu;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ ro rWW;
            final /* synthetic */ d rXw;

            a(d dVar, ro roVar) {
                this.rXw = dVar;
                this.rWW = roVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                com.tencent.mm.g.a.ro.a aVar;
                AppMethodBeat.i(109395);
                ro roVar = this.rWW;
                if (roVar != null) {
                    aVar = roVar.cNw;
                } else {
                    aVar = null;
                }
                if (!(aVar == null || !this.rWW.cNw.cNx || TextUtils.isEmpty(this.rWW.cNw.username))) {
                    d dVar = this.rXw.rXu;
                    String str = this.rWW.cNw.username;
                    j.o(str, "event.data.username");
                    if (d.a(dVar, str)) {
                        if (this.rWW.cNw.cNz) {
                            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                            com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
                            str = this.rWW.cNw.username;
                            j.o(str, "event.data.username");
                            com.tencent.mm.plugin.story.h.f aap = cxU.aap(str);
                            d dVar2 = this.rXw.rXu;
                            String str2 = this.rWW.cNw.username;
                            j.o(str2, "event.data.username");
                            d.a(dVar2, str2, aap);
                        } else {
                            dVar = this.rXw.rXu;
                            str = this.rWW.cNw.username;
                            j.o(str, "event.data.username");
                            d.b(dVar, str);
                        }
                        d.j(this.rXw.rXu);
                        d.k(this.rXw.rXu);
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(109395);
                return yVar;
            }
        }

        d(d dVar) {
            this.rXu = dVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(109396);
            com.tencent.mm.ab.b.a(new a(this, (ro) bVar));
            AppMethodBeat.o(109396);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ d rXu;

        e(d dVar) {
            this.rXu = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109397);
            ab.i(d.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + cb.aaD());
            ab.i(d.TAG, "startSession " + this.rXu.talker + ' ' + this.rXu.hashCode());
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.l abc = com.tencent.mm.plugin.story.model.j.a.cxV().abc(this.rXu.talker);
            d dVar = this.rXu;
            List cmt = com.tencent.mm.plugin.sns.e.a.cmt();
            j.o(cmt, "StoryStateMiddleLayer.getBlackTagList()");
            dVar.qGk = cmt;
            this.rXu.rXm = abc.field_nextSyncTime;
            ab.i(d.TAG, "next sync time " + this.rXu.rXm);
            d.c(this.rXu);
            d.d(this.rXu);
            y yVar = y.AUy;
            AppMethodBeat.o(109397);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class g<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.i(109399);
            int a = a.b.b.a(Integer.valueOf(((com.tencent.mm.plugin.story.h.f) ((o) t2).second).field_storyPostTime), Integer.valueOf(((com.tencent.mm.plugin.story.h.f) ((o) t).second).field_storyPostTime));
            AppMethodBeat.o(109399);
            return a;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ d rXu;

        f(d dVar) {
            this.rXu = dVar;
        }

        public final void run() {
            AppMethodBeat.i(109398);
            d.h(this.rXu);
            AppMethodBeat.o(109398);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class h<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.i(109400);
            int a = a.b.b.a(Integer.valueOf(((com.tencent.mm.plugin.story.h.f) ((o) t2).second).field_storyPostTime), Integer.valueOf(((com.tencent.mm.plugin.story.h.f) ((o) t).second).field_storyPostTime));
            AppMethodBeat.o(109400);
            return a;
        }
    }

    public d(String str) {
        j.p(str, "talker");
        AppMethodBeat.i(109415);
        this.talker = str;
        al RS = com.tencent.mm.kernel.g.RS();
        j.o(RS, "MMKernel.getPizzaWorkerThread()");
        this.handler = new ak(RS.getLooper());
        this.rXo = new f(this);
        this.qGk = new LinkedList();
        this.rXp = new ArrayList();
        this.rXr = new b(this);
        this.rXs = new d(this);
        AppMethodBeat.o(109415);
    }

    public static final /* synthetic */ void a(d dVar, String str, com.tencent.mm.plugin.story.h.f fVar) {
        AppMethodBeat.i(109422);
        dVar.b(str, fVar);
        AppMethodBeat.o(109422);
    }

    public static final /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(109417);
        dVar.czt();
        AppMethodBeat.o(109417);
    }

    public static final /* synthetic */ void j(d dVar) {
        AppMethodBeat.i(109423);
        dVar.czr();
        AppMethodBeat.o(109423);
    }

    public static final /* synthetic */ void k(d dVar) {
        AppMethodBeat.i(109424);
        dVar.czs();
        AppMethodBeat.o(109424);
    }

    static {
        AppMethodBeat.i(109416);
        AppMethodBeat.o(109416);
    }

    public final void start() {
        AppMethodBeat.i(109402);
        com.tencent.mm.ab.b.a("StoryStateFetcher_start", (a.f.a.a) new e(this));
        this.rXs.dnU();
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().a((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, (com.tencent.mm.ai.f) this);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().a(this, Looper.getMainLooper());
        com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class);
        j.o(K, "MMKernel.service(IChatroomService::class.java)");
        ((com.tencent.mm.plugin.chatroom.a.c) K).XV().c(this.rXr);
        AppMethodBeat.o(109402);
    }

    public final void resume() {
        AppMethodBeat.i(109403);
        this.cAY = false;
        czt();
        com.tencent.mm.ab.b.a("StoryStateFetcher_checkExpire", (a.f.a.a) new c(this));
        AppMethodBeat.o(109403);
    }

    public final void pause() {
        AppMethodBeat.i(109404);
        this.cAY = true;
        this.handler.removeCallbacks(this.rXo);
        AppMethodBeat.o(109404);
    }

    public final void destroy() {
        AppMethodBeat.i(109405);
        ab.i(TAG, "endSession " + this.talker + ' ' + hashCode());
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        j.o(RO, "network()");
        RO.Rg().b((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, (com.tencent.mm.ai.f) this);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().d(this);
        com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class);
        j.o(K, "MMKernel.service(IChatroomService::class.java)");
        ((com.tencent.mm.plugin.chatroom.a.c) K).XV().d(this.rXr);
        this.handler.removeCallbacks(this.rXo);
        this.rXs.dead();
        AppMethodBeat.o(109405);
    }

    public final boolean ZW(String str) {
        AppMethodBeat.i(109406);
        j.p(str, "username");
        if (this.rXn.get(str) == null) {
            Map map = this.rXn;
            j.o(map, "userUpdateMap");
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            map.put(str, com.tencent.mm.plugin.story.model.j.a.cxU().aap(str));
        }
        com.tencent.mm.plugin.story.h.f fVar = (com.tencent.mm.plugin.story.h.f) this.rXn.get(str);
        if (fVar == null || !fVar.cBN()) {
            AppMethodBeat.o(109406);
            return false;
        }
        AppMethodBeat.o(109406);
        return true;
    }

    public final void a(com.tencent.mm.plugin.story.api.k.a aVar) {
        this.rXb = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void czr() {
        boolean z;
        boolean z2;
        com.tencent.mm.plugin.story.api.k.a aVar;
        AppMethodBeat.i(109407);
        List list = this.rXk;
        j.o(list, "normalUnreadList");
        if ((!((Collection) list).isEmpty() ? 1 : null) == null) {
            list = this.rXl;
            j.o(list, "friendUnreadList");
            if ((!((Collection) list).isEmpty() ? 1 : null) == null) {
                z = false;
                if (!z) {
                    Object obj;
                    list = this.rXj;
                    j.o(list, "readList");
                    if (list.isEmpty()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        z2 = false;
                        if (!(this.pls == z2 && this.rXd == z)) {
                            aVar = this.rXb;
                            if (aVar != null) {
                                aVar.L(z2, z);
                                AppMethodBeat.o(109407);
                                return;
                            }
                        }
                        AppMethodBeat.o(109407);
                    }
                }
                z2 = true;
                aVar = this.rXb;
                if (aVar != null) {
                }
                AppMethodBeat.o(109407);
            }
        }
        z = true;
        if (z) {
        }
        z2 = true;
        aVar = this.rXb;
        if (aVar != null) {
        }
        AppMethodBeat.o(109407);
    }

    private final void czs() {
        Object obj;
        y yVar;
        String obj2;
        Object obj3;
        AppMethodBeat.i(109408);
        ArrayList arrayList = new ArrayList();
        List list = this.rXl;
        j.o(list, "friendUnreadList");
        if (list.size() > 1) {
            p.a(list, new g());
        }
        list = this.rXk;
        j.o(list, "normalUnreadList");
        if (list.size() > 1) {
            p.a(list, new h());
        }
        String str = "";
        List list2 = this.rXk;
        j.o(list2, "normalUnreadList");
        Iterable<o> iterable = list2;
        synchronized (iterable) {
            try {
                int i = 0;
                for (o oVar : iterable) {
                    int i2 = i + 1;
                    String str2 = str + "unRead:" + i + ' ' + bo.ga(((com.tencent.mm.plugin.story.h.f) oVar.second).cBL()) + "  userName:" + ((com.tencent.mm.plugin.story.h.f) oVar.second).getUserName() + " |, ";
                    if (i > 2) {
                        obj2 = str2;
                        break;
                    }
                    i = i2;
                    str = str2;
                }
                yVar = y.AUy;
                obj2 = str;
            } finally {
                AppMethodBeat.o(109408);
            }
        }
        ab.i(TAG, "unRead preLoadCache: ".concat(String.valueOf(obj2)));
        ArrayList<String> arrayList2 = new ArrayList();
        list2 = this.rXl;
        j.o(list2, "friendUnreadList");
        if ((!((Collection) list2).isEmpty() ? 1 : null) != null) {
            if (((com.tencent.mm.plugin.story.h.f) ((o) this.rXl.get(0)).second).cBL() > 0) {
                obj2 = (o) this.rXl.get(0);
                this.rXl.remove(obj2);
            } else {
                obj2 = null;
            }
            list = this.rXl;
            j.o(list, "friendUnreadList");
            Collections.shuffle(list, new Random());
            if (obj2 != null) {
                this.rXl.add(0, obj2);
            }
            obj3 = obj2;
        } else {
            obj3 = null;
        }
        list2 = this.rXl;
        j.o(list2, "friendUnreadList");
        iterable = list2;
        synchronized (iterable) {
            try {
                for (o oVar2 : iterable) {
                    arrayList2.add(oVar2.first);
                }
                yVar = y.AUy;
            } finally {
                AppMethodBeat.o(109408);
            }
        }
        if (arrayList2.isEmpty()) {
            list2 = this.rXk;
            j.o(list2, "normalUnreadList");
            if ((!((Collection) list2).isEmpty() ? 1 : null) != null) {
                if (((com.tencent.mm.plugin.story.h.f) ((o) this.rXk.get(0)).second).cBL() > 0) {
                    obj2 = (o) this.rXk.get(0);
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
        j.o(list2, "normalUnreadList");
        iterable = list2;
        synchronized (iterable) {
            try {
                for (o oVar22 : iterable) {
                    arrayList2.add(oVar22.first);
                }
                yVar = y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.o(109408);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        list2 = this.rXj;
        j.o(list2, "readList");
        iterable = list2;
        synchronized (iterable) {
            try {
                for (o oVar222 : iterable) {
                    arrayList3.add(oVar222);
                }
                yVar = y.AUy;
            } catch (Throwable th2) {
                AppMethodBeat.o(109408);
            }
        }
        ArrayList<String> arrayList4 = new ArrayList();
        list2 = arrayList3;
        if (list2.size() > 1) {
            p.a(list2, new i());
        }
        Iterable<o> iterable2 = arrayList3;
        synchronized (iterable2) {
            try {
                for (o oVar3 : iterable2) {
                    arrayList4.add(oVar3.first);
                }
                y yVar2 = y.AUy;
            } catch (Throwable th3) {
                AppMethodBeat.o(109408);
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
        com.tencent.mm.plugin.story.api.k.a aVar = this.rXb;
        if (aVar != null) {
            aVar.a(arrayList, arrayList2);
        }
    }

    private final void czt() {
        long j = 0;
        AppMethodBeat.i(109409);
        long currentTimeMillis = this.rXm - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            this.rXm = System.currentTimeMillis();
        } else {
            j = currentTimeMillis;
        }
        this.handler.removeCallbacks(this.rXo);
        this.handler.postDelayed(this.rXo, j);
        AppMethodBeat.o(109409);
    }

    private final void a(String str, com.tencent.mm.plugin.story.h.f fVar) {
        AppMethodBeat.i(109410);
        if (this.qGk.contains(str)) {
            AppMethodBeat.o(109410);
            return;
        }
        com.tencent.mm.plugin.story.api.k.a aVar = this.rXb;
        if (aVar != null) {
            aVar.bs(str, fVar.cBN());
        }
        aaL(str);
        b(str, fVar);
        czr();
        czs();
        AppMethodBeat.o(109410);
    }

    private final void aaL(String str) {
        List list;
        Object obj;
        o oVar;
        AppMethodBeat.i(109411);
        List list2 = this.rXk;
        j.o(list2, "normalUnreadList");
        synchronized (list2) {
            try {
                list = this.rXk;
                j.o(list, "normalUnreadList");
                for (Object next : list) {
                    if (j.j((String) ((o) next).first, str)) {
                        obj = next;
                        break;
                    }
                }
                obj = null;
                oVar = (o) obj;
                if (oVar != null) {
                    Boolean.valueOf(this.rXk.remove(oVar));
                }
            } finally {
                AppMethodBeat.o(109411);
            }
        }
        list2 = this.rXl;
        j.o(list2, "friendUnreadList");
        synchronized (list2) {
            try {
                list = this.rXl;
                j.o(list, "friendUnreadList");
                for (Object next2 : list) {
                    if (j.j((String) ((o) next2).first, str)) {
                        obj = next2;
                        break;
                    }
                }
                obj = null;
                oVar = (o) obj;
                if (oVar != null) {
                    Boolean.valueOf(this.rXl.remove(oVar));
                }
            } catch (Throwable th) {
                AppMethodBeat.o(109411);
            }
        }
        list2 = this.rXj;
        j.o(list2, "readList");
        synchronized (list2) {
            try {
                list = this.rXj;
                j.o(list, "readList");
                for (Object next22 : list) {
                    if (j.j((String) ((o) next22).first, str)) {
                        obj = next22;
                        break;
                    }
                }
                obj = null;
                oVar = (o) obj;
                if (oVar != null) {
                    Boolean.valueOf(this.rXj.remove(oVar));
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(109411);
            }
        }
    }

    private final void b(String str, com.tencent.mm.plugin.story.h.f fVar) {
        AppMethodBeat.i(109412);
        com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "service(IMessengerStorage::class.java)");
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
        boolean NX = aoO != null ? aoO.NX() : false;
        if (!fVar.cBN()) {
            if (fVar.isValid()) {
                this.rXj.add(new o(str, fVar));
            }
            AppMethodBeat.o(109412);
        } else if (NX) {
            this.rXl.add(new o(str, fVar));
            AppMethodBeat.o(109412);
        } else {
            this.rXk.add(new o(str, fVar));
            AppMethodBeat.o(109412);
        }
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(109413);
        if (!(str == null || mVar == null || !(mVar.obj instanceof com.tencent.mm.plugin.story.h.f))) {
            Object obj = mVar.obj;
            if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                AppMethodBeat.o(109413);
                throw vVar;
            }
            com.tencent.mm.plugin.story.h.f fVar = (com.tencent.mm.plugin.story.h.f) obj;
            if (!this.rXp.contains(fVar.getUserName())) {
                AppMethodBeat.o(109413);
                return;
            } else if (com.tencent.mm.plugin.sns.e.a.Xv(fVar.getUserName())) {
                AppMethodBeat.o(109413);
                return;
            } else {
                Map map = this.rXn;
                j.o(map, "userUpdateMap");
                map.put(fVar.getUserName(), fVar);
                if (j.j(str, "notify_story_read")) {
                    ab.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + " as read");
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(109413);
                    return;
                } else if (j.j(str, "notify_story_unread")) {
                    ab.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + " as unread");
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(109413);
                    return;
                } else if (j.j(str, "notify_story_preload")) {
                    ab.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + " as preload " + fVar.cBL());
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(109413);
                    return;
                } else if (j.j(str, "notify_story_invalid")) {
                    ab.i(TAG, "update user " + fVar.getUserName() + " as invalid");
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(109413);
                    return;
                } else if (j.j(str, "notify_story_valid")) {
                    ab.i(TAG, "update user " + fVar.getUserName() + " as valid");
                    a(fVar.getUserName(), fVar);
                }
            }
        }
        AppMethodBeat.o(109413);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(109414);
        j.p(mVar, "scene");
        ab.i(TAG, "onSceneEnd " + i + ", " + i2 + ", " + str + ", " + mVar.getType());
        if (mVar.getType() == TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR && (mVar instanceof com.tencent.mm.plugin.story.model.a.c)) {
            com.tencent.mm.plugin.story.model.j.a aVar;
            if ((j.j(((com.tencent.mm.plugin.story.model.a.c) mVar).gpx, this.talker) ^ 1) != 0) {
                AppMethodBeat.o(109414);
                return;
            } else if (i == 0 && i2 == 0) {
                com.tencent.mm.bt.a acA = ((com.tencent.mm.plugin.story.model.a.c) mVar).ehh.acA();
                if (acA == null) {
                    v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncResponse");
                    AppMethodBeat.o(109414);
                    throw vVar;
                }
                cdt cdt = (cdt) acA;
                ab.i(TAG, "response: count " + cdt.xdu + ", interval " + cdt.xdw);
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                this.rXm = com.tencent.mm.plugin.story.model.j.a.cxV().abc(this.talker).field_nextSyncTime;
                czt();
                AppMethodBeat.o(109414);
                return;
            } else {
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                this.rXm = com.tencent.mm.plugin.story.model.j.a.cxV().abc(this.talker).field_nextSyncTime;
                czt();
            }
        }
        AppMethodBeat.o(109414);
    }

    public static final /* synthetic */ void d(d dVar) {
        AppMethodBeat.i(109418);
        com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a("checkChatRoomState");
        List my = n.my(dVar.talker);
        if (my == null) {
            AppMethodBeat.o(109418);
            return;
        }
        dVar.rXp.addAll(my);
        dVar.rXq = dVar.rXp.size() > 0;
        ab.i(TAG, "room member size " + dVar.rXp.size());
        Iterable<String> iterable = my;
        synchronized (iterable) {
            try {
                for (String str : iterable) {
                    if (str != null) {
                        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                        if (!(bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), str) || dVar.qGk.contains(str))) {
                            aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                            com.tencent.mm.plugin.story.h.f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap(str);
                            boolean isValid = aap.isValid();
                            boolean cBN = aap.cBN();
                            com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                            j.o(K, "service(IMessengerStorage::class.java)");
                            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
                            boolean NX = aoO != null ? aoO.NX() : false;
                            if (cBN) {
                                if (NX) {
                                    dVar.rXl.add(new o(str, aap));
                                } else {
                                    dVar.rXk.add(new o(str, aap));
                                }
                                dVar.czr();
                            } else if (isValid) {
                                dVar.rXj.add(new o(str, aap));
                                dVar.czr();
                            }
                        }
                    }
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(109418);
            }
        }
        dVar.czs();
        aVar.SW();
    }

    public static final /* synthetic */ void h(d dVar) {
        AppMethodBeat.i(109419);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        if (com.tencent.mm.plugin.story.model.j.a.cyg() && !bo.isNullOrNil(dVar.talker) && t.mO(dVar.talker)) {
            ab.i(TAG, "tryStartFetch " + dVar.talker);
            if (!com.tencent.mm.plugin.story.api.n.cxe()) {
                ab.i(TAG, "filter RoomSync");
            } else if (!dVar.cAY) {
                ab.i(TAG, "start fetch " + dVar.talker);
                com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
                j.o(RO, "network()");
                RO.Rg().d((com.tencent.mm.ai.m) new com.tencent.mm.plugin.story.model.a.c(dVar.talker));
                AppMethodBeat.o(109419);
                return;
            }
        }
        AppMethodBeat.o(109419);
    }
}
