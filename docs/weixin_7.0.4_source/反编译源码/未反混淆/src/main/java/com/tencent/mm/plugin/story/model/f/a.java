package com.tencent.mm.plugin.story.model.f;

import a.a.p;
import a.a.t;
import a.f.a.r;
import a.l;
import a.v;
import a.y;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.model.cb;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000f\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0002J\u0012\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010$\u001a\u00020\u0015J\u0012\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0016J:\u00102\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130403j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001304j\b\u0012\u0004\u0012\u00020\u0013`6`5H\u0016J\b\u00107\u001a\u000200H\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u0006\u0010;\u001a\u00020\u0015J\u0006\u0010<\u001a\u00020\u0015J\b\u0010=\u001a\u00020\u0015H\u0002J\u001c\u0010>\u001a\u00020\u00152\b\u0010?\u001a\u0004\u0018\u00010\u00052\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0006\u0010B\u001a\u00020\u0015J\u0012\u0010C\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010D\u001a\u00020\u0015H\u0002J\u0010\u0010E\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R,\u0010\u0011\u001a \u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0012X\u0004¢\u0006\u0002\n\u0000RN\u0010\u0016\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00180\u0018 \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00190\u0017X\u0004¢\u0006\u0002\n\u0000RN\u0010\u001a\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u001b0\u001b \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u00190\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayOlderUserList", "", "kotlin.jvm.PlatformType", "", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "updateUser", "plugin-story_release"})
public final class a implements com.tencent.mm.plugin.story.api.k.c, com.tencent.mm.sdk.e.k.a {
    public static final String TAG = TAG;
    public static final LinkedList<com.tencent.mm.plugin.story.api.k.b> ilQ = new LinkedList();
    private static final Map<String, com.tencent.mm.plugin.story.h.f> rWF = Collections.synchronizedMap(new ConcurrentHashMap());
    private static final Map<String, c> rWG = Collections.synchronizedMap(new ConcurrentHashMap());
    private static final List<String> rWH = Collections.synchronizedList(new LinkedList());
    private static final List<String> rWI = Collections.synchronizedList(new LinkedList());
    public static final i rWJ = new i();
    public static final r<Long, Boolean, String, String, y> rWK = j.rWX;
    public static final a rWL = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ m rWT;

        g(m mVar) {
            this.rWT = mVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138781);
            Object obj = this.rWT.obj;
            v vVar;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryInfo");
                AppMethodBeat.o(138781);
                throw vVar;
            }
            String str = ((com.tencent.mm.plugin.story.h.j) obj).field_userName;
            obj = this.rWT.obj;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryInfo");
                AppMethodBeat.o(138781);
                throw vVar;
            }
            HashMap hashMap;
            long j = ((com.tencent.mm.plugin.story.h.j) obj).field_storyID;
            a aVar = a.rWL;
            ab.i(a.TAG, "[StoryInfo] onNotifyChange: " + str + ' ' + j);
            aVar = a.rWL;
            c cVar = (c) a.rWG.get(str);
            if (cVar != null) {
                hashMap = cVar.rXi;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                hashMap.remove(Long.valueOf(j));
                if (hashMap.isEmpty()) {
                    aVar = a.rWL;
                    a.rWG.remove(str);
                }
            }
            aVar = a.rWL;
            a.czk();
            com.tencent.mm.ab.b.a(AnonymousClass1.rWU);
            y yVar = y.AUy;
            AppMethodBeat.o(138781);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class i extends com.tencent.mm.sdk.b.c<ro> {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ ro rWW;

            a(ro roVar) {
                this.rWW = roVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109360);
                ro roVar = this.rWW;
                if (!((roVar != null ? roVar.cNw : null) == null || !this.rWW.cNw.cNx || TextUtils.isEmpty(this.rWW.cNw.username))) {
                    a aVar = a.rWL;
                    if (!a.aaK(this.rWW.cNw.username)) {
                        if (this.rWW.cNw.cNz) {
                            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                            com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
                            String str = this.rWW.cNw.username;
                            a.f.b.j.o(str, "event.data.username");
                            com.tencent.mm.plugin.story.h.f aap = cxU.aap(str);
                            a aVar3 = a.rWL;
                            Map czo = a.rWF;
                            a.f.b.j.o(czo, "userStateMap");
                            czo.put(this.rWW.cNw.username, aap);
                        } else {
                            aVar = a.rWL;
                            a.rWF.remove(this.rWW.cNw.username);
                        }
                        aVar = a.rWL;
                        String str2 = this.rWW.cNw.username;
                        a.f.b.j.o(str2, "event.data.username");
                        a.aaJ(str2);
                        aVar = a.rWL;
                        a.czl();
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(109360);
                return yVar;
            }
        }

        i() {
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(109361);
            com.tencent.mm.ab.b.a(new a((ro) bVar));
            AppMethodBeat.o(109361);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ String hBP;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.a$f$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ f rWS;

            AnonymousClass1(f fVar) {
                this.rWS = fVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109356);
                a aVar = a.rWL;
                a.czl();
                aVar = a.rWL;
                a.aaJ(this.rWS.hBP);
                y yVar = y.AUy;
                AppMethodBeat.o(109356);
                return yVar;
            }
        }

        f(String str) {
            this.hBP = str;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109357);
            a aVar = a.rWL;
            a.czk();
            com.tencent.mm.ab.b.a(new AnonymousClass1(this));
            y yVar = y.AUy;
            AppMethodBeat.o(109357);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<y> {
        public static final d rWP = new d();

        static {
            AppMethodBeat.i(109351);
            AppMethodBeat.o(109351);
        }

        d() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109350);
            a aVar = a.rWL;
            a.czi();
            y yVar = y.AUy;
            AppMethodBeat.o(109350);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.a<y> {
        public static final h rWV = new h();

        static {
            AppMethodBeat.i(109359);
            AppMethodBeat.o(109359);
        }

        h() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109358);
            a aVar = a.rWL;
            com.tencent.mm.ab.a aVar2 = new com.tencent.mm.ab.a(a.TAG);
            com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
            Cursor dsH = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().dsH();
            if (dsH != null) {
                while (dsH.moveToNext()) {
                    ad adVar = new ad();
                    adVar.d(dsH);
                    ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).loadStory(adVar.getUsername(), "");
                }
                dsH.close();
            } else {
                aVar = a.rWL;
                ab.w(a.TAG, "checkContactState: cursor is null");
            }
            aVar2.SW();
            aVar = a.rWL;
            ab.i(a.TAG, "pullTest done ");
            y yVar = y.AUy;
            AppMethodBeat.o(109358);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<y> {
        public static final b rWO = new b();

        static {
            AppMethodBeat.i(138778);
            AppMethodBeat.o(138778);
        }

        b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138777);
            a aVar = a.rWL;
            a.czm();
            aVar = a.rWL;
            a.czn();
            aVar = a.rWL;
            a.czk();
            aVar = a.rWL;
            String czj = a.TAG;
            StringBuilder stringBuilder = new StringBuilder("checkContactState: user size is ");
            a aVar2 = a.rWL;
            stringBuilder = stringBuilder.append(a.rWF.size()).append(", unread ");
            aVar2 = a.rWL;
            ab.i(czj, stringBuilder.append(a.rWI.size()).toString());
            y yVar = y.AUy;
            AppMethodBeat.o(138777);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<y> {
        public static final e rWQ = new e();

        static {
            AppMethodBeat.i(109355);
            AppMethodBeat.o(109355);
        }

        e() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109354);
            a aVar = a.rWL;
            a.czk();
            com.tencent.mm.ab.b.a(AnonymousClass1.rWR);
            y yVar = y.AUy;
            AppMethodBeat.o(109354);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class k<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            long j;
            long j2;
            AppMethodBeat.i(109362);
            com.tencent.mm.plugin.story.h.f fVar = (com.tencent.mm.plugin.story.h.f) t2;
            if (fVar.field_updateTime == 0) {
                j = ((long) fVar.field_storyPostTime) * 1000;
            } else {
                j = fVar.field_updateTime;
            }
            Comparable valueOf = Long.valueOf(j);
            com.tencent.mm.plugin.story.h.f fVar2 = (com.tencent.mm.plugin.story.h.f) t;
            if (fVar2.field_updateTime == 0) {
                j2 = ((long) fVar2.field_storyPostTime) * 1000;
            } else {
                j2 = fVar2.field_updateTime;
            }
            int a = a.b.b.a(valueOf, Long.valueOf(j2));
            AppMethodBeat.o(109362);
            return a;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<y> {
        public static final a rWM = new a();

        static {
            AppMethodBeat.i(109348);
            AppMethodBeat.o(109348);
        }

        a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109347);
            a aVar = a.rWL;
            a.czk();
            com.tencent.mm.ab.b.a(AnonymousClass1.rWN);
            y yVar = y.AUy;
            AppMethodBeat.o(109347);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class c<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.i(109349);
            int a = a.b.b.a(Long.valueOf(((com.tencent.mm.plugin.story.h.f) t2).field_readTime), Long.valueOf(((com.tencent.mm.plugin.story.h.f) t).field_readTime));
            AppMethodBeat.o(109349);
            return a;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class j extends a.f.b.k implements r<Long, Boolean, String, String, y> {
        public static final j rWX = new j();

        static {
            AppMethodBeat.i(138786);
            AppMethodBeat.o(138786);
        }

        j() {
            super(4);
        }

        public final /* synthetic */ Object a(Object obj, Object obj2, Object obj3, Object obj4) {
            AppMethodBeat.i(138785);
            final long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            final String str = (String) obj3;
            final String str2 = (String) obj4;
            a.f.b.j.p(str, "fromUser");
            a.f.b.j.p(str2, "storyOwner");
            com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a) new a.f.a.a<y>() {
                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(138784);
                    com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(longValue);
                    if (com.tencent.mm.plugin.story.c.a.a.rQZ.cxi() || com.tencent.mm.plugin.story.c.a.a.rQZ.cwU()) {
                        a aVar2 = a.rWL;
                        if (a.g(lx)) {
                            a aVar3;
                            aVar2 = a.rWL;
                            ab.i(a.TAG, "new comment in " + longValue + ", isUnread:" + booleanValue + ", fromUser:" + str2 + ", fromUser:" + str);
                            com.tencent.mm.plugin.story.model.j.a aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                            com.tencent.mm.plugin.story.h.c lr = com.tencent.mm.plugin.story.model.j.a.cxW().lr(longValue);
                            if (lx == null || lr == null) {
                                aVar3 = a.rWL;
                                a.rWG.remove(str2);
                            } else {
                                cer cer = new cer();
                                try {
                                    cer.parseFrom(lx.field_attrBuf);
                                } catch (Exception e) {
                                }
                                LinkedList linkedList = cer.xeo;
                                a.f.b.j.o(linkedList, "storyObj.CommentList");
                                Collection arrayList = new ArrayList();
                                for (Object next : linkedList) {
                                    cdv cdv = (cdv) next;
                                    a aVar5 = a.rWL;
                                    a.f.b.j.o(cdv, "it");
                                    if (a.b(cdv, lr)) {
                                        arrayList.add(next);
                                    }
                                }
                                int size = ((List) arrayList).size();
                                aVar3 = a.rWL;
                                ab.i(a.TAG, "commentCount ".concat(String.valueOf(size)));
                                c cVar;
                                if (size > 0) {
                                    aVar3 = a.rWL;
                                    if (a.rWG.get(str2) == null) {
                                        aVar3 = a.rWL;
                                        Map czq = a.rWG;
                                        a.f.b.j.o(czq, "userReplyStateMap");
                                        String str = str2;
                                        c cVar2 = new c(str2);
                                        cVar2.rXi.put(Long.valueOf(longValue), Integer.valueOf(size));
                                        czq.put(str, cVar2);
                                    } else {
                                        aVar3 = a.rWL;
                                        cVar = (c) a.rWG.get(str2);
                                        if (cVar != null) {
                                            cVar.rXi.put(Long.valueOf(longValue), Integer.valueOf(size));
                                        }
                                    }
                                } else {
                                    aVar3 = a.rWL;
                                    if (a.rWG.get(str2) != null) {
                                        aVar3 = a.rWL;
                                        cVar = (c) a.rWG.get(str2);
                                        if (cVar != null) {
                                            HashMap hashMap = cVar.rXi;
                                            if (hashMap != null) {
                                                hashMap.remove(Long.valueOf(longValue));
                                            }
                                        }
                                        if (cVar != null) {
                                            HashMap hashMap2 = cVar.rXi;
                                            if (hashMap2 != null && hashMap2.isEmpty()) {
                                                aVar3 = a.rWL;
                                                a.rWG.remove(str2);
                                            }
                                        }
                                    }
                                }
                            }
                            aVar3 = a.rWL;
                            a.czk();
                            com.tencent.mm.ab.b.a(AnonymousClass1.rXa);
                        }
                    }
                    y yVar = y.AUy;
                    AppMethodBeat.o(138784);
                    return yVar;
                }
            });
            y yVar = y.AUy;
            AppMethodBeat.o(138785);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(109374);
        AppMethodBeat.o(109374);
    }

    private a() {
    }

    public static final /* synthetic */ boolean aaK(String str) {
        AppMethodBeat.i(109378);
        boolean aaI = aaI(str);
        AppMethodBeat.o(109378);
        return aaI;
    }

    public static final /* synthetic */ boolean b(cdv cdv, com.tencent.mm.plugin.story.h.c cVar) {
        AppMethodBeat.i(138793);
        boolean a = a(cdv, cVar);
        AppMethodBeat.o(138793);
        return a;
    }

    public static final /* synthetic */ boolean g(com.tencent.mm.plugin.story.h.j jVar) {
        AppMethodBeat.i(139086);
        boolean f = f(jVar);
        AppMethodBeat.o(139086);
        return f;
    }

    public final void init() {
        AppMethodBeat.i(109363);
        ab.i(TAG, "init: ");
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().c(this);
        aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxT().c(this);
        com.tencent.mm.ab.b.a(1000, (a.f.a.a) d.rWP);
        rWJ.dnU();
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.a(rWK);
        AppMethodBeat.o(109363);
    }

    public static void czg() {
        AppMethodBeat.i(109364);
        com.tencent.mm.ab.b.a("ContactSyncFetcher_pullTest", (a.f.a.a) h.rWV);
        AppMethodBeat.o(109364);
    }

    public final void a(com.tencent.mm.plugin.story.api.k.b bVar) {
        AppMethodBeat.i(109365);
        if (!ilQ.contains(bVar)) {
            ilQ.add(bVar);
        }
        AppMethodBeat.o(109365);
    }

    public final void b(com.tencent.mm.plugin.story.api.k.b bVar) {
        AppMethodBeat.i(109366);
        ilQ.remove(bVar);
        AppMethodBeat.o(109366);
    }

    public final List<String> cxc() {
        AppMethodBeat.i(109367);
        LinkedList linkedList = new LinkedList();
        List<String> entrySet = rWF.entrySet();
        synchronized (entrySet) {
            try {
                Iterator it = entrySet.iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!(aaI((String) entry.getKey()) || !((com.tencent.mm.plugin.story.h.f) entry.getValue()).isValid() || ((com.tencent.mm.plugin.story.h.f) entry.getValue()).cBN())) {
                        linkedList.add(entry.getValue());
                    }
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(109367);
            }
        }
        List list = linkedList;
        if (list.size() > 1) {
            p.a(list, new c());
        }
        ab.i(TAG, "getReadList: size " + linkedList.size());
        Iterable<com.tencent.mm.plugin.story.h.f> iterable = linkedList;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (com.tencent.mm.plugin.story.h.f userName : iterable) {
            arrayList.add(userName.getUserName());
        }
        entrySet = (List) arrayList;
        return entrySet;
    }

    public final List<String> cwY() {
        AppMethodBeat.i(109368);
        ab.i(TAG, "getUnreadList: size " + rWI.size());
        List linkedList = new LinkedList(rWI);
        AppMethodBeat.o(109368);
        return linkedList;
    }

    public final List<String> cwZ() {
        AppMethodBeat.i(109369);
        ab.i(TAG, "getOlderList: size " + rWH.size());
        List linkedList = new LinkedList(rWH);
        AppMethodBeat.o(109369);
        return linkedList;
    }

    public final LinkedHashMap<String, ArrayList<Long>> cxa() {
        AppMethodBeat.i(138787);
        ab.i(TAG, "getNewReplyList: size " + rWG.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this) {
            try {
                Map map = rWG;
                a.f.b.j.o(map, "userReplyStateMap");
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    c cVar = (c) entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(cVar.rXi.keySet());
                    map = linkedHashMap;
                    a.f.b.j.o(str, "storyOwner");
                    map.put(str, arrayList);
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(138787);
            }
        }
        return linkedHashMap;
    }

    public final int cxb() {
        AppMethodBeat.i(138788);
        int i = 0;
        Iterable<Entry> entrySet = rWG.entrySet();
        synchronized (entrySet) {
            try {
                for (Entry value : entrySet) {
                    for (Entry value2 : ((c) value.getValue()).rXi.entrySet()) {
                        i = ((Number) value2.getValue()).intValue() + i;
                    }
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(138788);
            }
        }
        return i;
    }

    public final int aaH(String str) {
        int i;
        AppMethodBeat.i(138789);
        a.f.b.j.p(str, "storyOwner");
        ab.i(TAG, "getNewReplyCount: storyOwner ".concat(String.valueOf(str)));
        int i2 = 0;
        synchronized (this) {
            try {
                c cVar = (c) rWG.get(str);
                if (cVar != null) {
                    HashMap hashMap = cVar.rXi;
                    if (hashMap != null) {
                        for (Entry value : hashMap.entrySet()) {
                            i2 += ((Number) value.getValue()).intValue();
                        }
                        y yVar = y.AUy;
                        i = i2;
                    }
                }
                i = 0;
            } finally {
                AppMethodBeat.o(138789);
            }
        }
        return i;
    }

    public final void cxd() {
        AppMethodBeat.i(109370);
        com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a) a.rWM);
        AppMethodBeat.o(109370);
    }

    private static boolean aaI(String str) {
        Object obj;
        AppMethodBeat.i(109371);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (!a.f.b.j.j(str, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                AppMethodBeat.o(109371);
                return false;
            }
        }
        AppMethodBeat.o(109371);
        return true;
    }

    private static boolean a(cdv cdv, com.tencent.mm.plugin.story.h.c cVar) {
        AppMethodBeat.i(138790);
        if (cdv.wZG != 0 && cdv.pcX > cVar.field_readCommentTime) {
            String str = cdv.ndG;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (!bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                AppMethodBeat.o(138790);
                return true;
            }
        }
        AppMethodBeat.o(138790);
        return false;
    }

    private static boolean f(com.tencent.mm.plugin.story.h.j jVar) {
        AppMethodBeat.i(139085);
        if (jVar == null) {
            AppMethodBeat.o(139085);
            return false;
        } else if (jVar.cBX()) {
            boolean cBW = jVar.cBW();
            AppMethodBeat.o(139085);
            return cBW;
        } else {
            String str = jVar.field_userName;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                AppMethodBeat.o(139085);
                return false;
            }
            AppMethodBeat.o(139085);
            return true;
        }
    }

    public static void czh() {
        AppMethodBeat.i(109372);
        com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a) e.rWQ);
        AppMethodBeat.o(109372);
    }

    /* JADX WARNING: Missing block: B:7:0x0017, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i(TAG, "[StoryExtInfo] unknown event ".concat(java.lang.String.valueOf(r7)));
            com.tencent.matrix.trace.core.AppMethodBeat.o(109373);
     */
    /* JADX WARNING: Missing block: B:9:0x0032, code skipped:
            if (r7.equals("notify_story_unread") != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:10:0x0034, code skipped:
            r0 = r8.obj;
     */
    /* JADX WARNING: Missing block: B:11:0x0036, code skipped:
            if (r0 != null) goto L_0x006c;
     */
    /* JADX WARNING: Missing block: B:12:0x0038, code skipped:
            r0 = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
            com.tencent.matrix.trace.core.AppMethodBeat.o(109373);
     */
    /* JADX WARNING: Missing block: B:13:0x0043, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:15:0x004b, code skipped:
            if (r7.equals("notify_story_invalid") != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:17:0x0055, code skipped:
            if (r7.equals("notify_story_valid") != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:19:0x005f, code skipped:
            if (r7.equals("notify_story_read") != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:21:0x0069, code skipped:
            if (r7.equals("notify_story_preload") != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:22:0x006c, code skipped:
            r0 = (com.tencent.mm.plugin.story.h.f) r0;
            r1 = r0.getUserName();
            com.tencent.mm.sdk.platformtools.ab.i(TAG, "[StoryExtInfo] onNotifyChange: event " + r7 + ' ' + r1);
     */
    /* JADX WARNING: Missing block: B:23:0x0095, code skipped:
            if (r0.isValid() == false) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:24:0x0097, code skipped:
            r2 = rWF;
            a.f.b.j.o(r2, "userStateMap");
            r2.put(r1, r0);
     */
    /* JADX WARNING: Missing block: B:26:0x00ab, code skipped:
            if ((a.f.b.j.j(r7, "notify_story_preload") ^ 1) == 0) goto L_0x0107;
     */
    /* JADX WARNING: Missing block: B:28:0x00b4, code skipped:
            if (a.f.b.j.j(r7, "notify_story_read") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Missing block: B:30:0x00bd, code skipped:
            if (a.f.b.j.j(r7, "notify_story_invalid") == false) goto L_0x00d4;
     */
    /* JADX WARNING: Missing block: B:31:0x00bf, code skipped:
            rWI.remove(r1);
            rWH.remove(r1);
            com.tencent.matrix.trace.core.AppMethodBeat.o(109373);
     */
    /* JADX WARNING: Missing block: B:32:0x00ce, code skipped:
            rWF.remove(r1);
     */
    /* JADX WARNING: Missing block: B:33:0x00d4, code skipped:
            com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a) new com.tencent.mm.plugin.story.model.f.a.f(r1));
            com.tencent.matrix.trace.core.AppMethodBeat.o(109373);
     */
    /* JADX WARNING: Missing block: B:45:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(String str, m mVar) {
        AppMethodBeat.i(109373);
        if (str != null && mVar != null && (mVar.obj instanceof com.tencent.mm.plugin.story.h.f)) {
            switch (str.hashCode()) {
                case -1921532343:
                    break;
                case -533270468:
                    break;
                case 356729399:
                    break;
                case 398324054:
                    break;
                case 632036207:
                    break;
            }
        } else if (!(str == null || mVar == null || !(mVar.obj instanceof com.tencent.mm.plugin.story.h.j))) {
            switch (str.hashCode()) {
                case 317345436:
                    if (str.equals("notify_story_info_delete")) {
                        com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a) new g(mVar));
                        AppMethodBeat.o(109373);
                        return;
                    }
                    break;
            }
            ab.i(TAG, "[StoryInfo] unknown event ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(109373);
    }

    public static final /* synthetic */ void czi() {
        AppMethodBeat.i(138791);
        com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a) b.rWO);
        AppMethodBeat.o(138791);
    }

    public static final /* synthetic */ void czk() {
        y yVar;
        long j;
        com.tencent.mm.plugin.story.h.f fVar;
        AppMethodBeat.i(109376);
        LinkedList<com.tencent.mm.plugin.story.h.f> linkedList = new LinkedList();
        Map map = rWF;
        a.f.b.j.o(map, "userStateMap");
        synchronized (map) {
            try {
                for (Entry entry : rWF.entrySet()) {
                    if (!aaI((String) entry.getKey()) && ((com.tencent.mm.plugin.story.h.f) entry.getValue()).cBN()) {
                        linkedList.add(entry.getValue());
                    }
                }
                yVar = y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.o(109376);
            }
        }
        com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class);
        a.f.b.j.o(K, "MMKernel.service<IConfig…onfigService::class.java)");
        int i = ((com.tencent.mm.plugin.zero.b.a) K).Nu().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
        K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class);
        a.f.b.j.o(K, "MMKernel.service<IConfig…onfigService::class.java)");
        int i2 = ((com.tencent.mm.plugin.zero.b.a) K).Nu().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
        ab.i(TAG, "updateUnreadList: unread " + linkedList.size() + ", displayUnread:" + rWI.size() + ", displayOld:" + rWH.size() + ", displayNewReply:" + rWG.size() + ", totalCount:" + i + ", showDuration:" + i2);
        Object obj = null;
        if ((rWI.size() + rWH.size()) + rWG.size() > 0) {
            obj = 1;
        }
        if (obj == null && linkedList.size() >= i) {
            com.tencent.mm.plugin.report.service.h.pYm.k(1015, 10, 1);
            obj = 1;
        }
        if (obj == null) {
            for (com.tencent.mm.plugin.story.h.f fVar2 : linkedList) {
                Object obj2;
                j = fVar2.field_updateTime;
                if (j == 0) {
                    j = ((long) fVar2.field_storyPostTime) * 1000;
                }
                if (bo.fp(j / 1000) >= ((long) i2)) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(1015, 11, 1);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
        }
        if (obj != null) {
            List list = linkedList;
            if (list.size() > 1) {
                p.a(list, new k());
            }
            fVar2 = (com.tencent.mm.plugin.story.h.f) t.fK(linkedList);
            if (fVar2 != null) {
                linkedList.remove(fVar2);
                linkedList.add(0, fVar2);
            }
            rWI.clear();
            rWH.clear();
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            long a = RP.Ry().a(com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, 0);
            Iterable<com.tencent.mm.plugin.story.h.f> iterable = linkedList;
            synchronized (iterable) {
                try {
                    for (com.tencent.mm.plugin.story.h.f fVar3 : iterable) {
                        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                        List h = com.tencent.mm.plugin.story.model.j.a.cxT().h(fVar3.getUserName(), false, cb.aaF() - 86400);
                        aVar = com.tencent.mm.plugin.story.model.j.rST;
                        boolean z = com.tencent.mm.plugin.story.h.k.a(com.tencent.mm.plugin.story.model.j.a.cxT(), fVar3.getUserName(), false, cb.aaF() - 86400).size() != h.size();
                        String str;
                        StringBuilder append;
                        boolean z2;
                        if (!z) {
                            if (fVar3.field_updateTime == 0) {
                                j = ((long) fVar3.field_storyPostTime) * 1000;
                            } else {
                                j = fVar3.field_updateTime;
                            }
                            if (j > a) {
                                rWI.add(fVar3.getUserName());
                            } else {
                                rWH.add(fVar3.getUserName());
                            }
                            str = TAG;
                            append = new StringBuilder("make list username:").append(fVar3.getUserName()).append(" updateTime:").append(fVar3.field_updateTime).append(" posTime:").append(fVar3.field_storyPostTime).append(" makeTime:").append(a).append(" itUpdateTime ").append(j).append(" result ");
                            if (j > a) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            ab.i(str, append.append(z2).append(" hasInvisibleItem:").append(z).toString());
                        } else if (!h.isEmpty()) {
                            j = ((long) ((com.tencent.mm.plugin.story.h.j) h.get(0)).field_createTime) * 1000;
                            if (j > fVar3.field_readTime) {
                                if (j > a) {
                                    rWI.add(fVar3.getUserName());
                                } else {
                                    rWH.add(fVar3.getUserName());
                                }
                            }
                            str = TAG;
                            append = new StringBuilder("make list username:").append(fVar3.getUserName()).append(" updateTime:").append(fVar3.field_updateTime).append(" posTime:").append(fVar3.field_storyPostTime).append(" makeTime:").append(a).append(" itUpdateTime ").append(j).append(" result ");
                            if (j > a) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            ab.i(str, append.append(z2).append(" hasInvisibleItem:").append(z).toString());
                        }
                    }
                    yVar = y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.o(109376);
                }
            }
            ab.i(TAG, "update time " + a + " displayUnreadUserList " + rWI + " displayOlderUserList " + rWH + " userReplyStateMap " + rWG);
        }
        AppMethodBeat.o(109376);
    }

    public static final /* synthetic */ void czl() {
        AppMethodBeat.i(109377);
        for (com.tencent.mm.plugin.story.api.k.b cvv : ilQ) {
            cvv.cvv();
        }
        AppMethodBeat.o(109377);
    }

    public static final /* synthetic */ void czm() {
        AppMethodBeat.i(109375);
        com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a(TAG);
        com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
        Cursor dsH = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().dsH();
        if (dsH != null) {
            while (dsH.moveToNext()) {
                ad adVar = new ad();
                adVar.d(dsH);
                String username = adVar.getUsername();
                if (!(aaI(username) || com.tencent.mm.plugin.sns.e.a.Xv(username))) {
                    Map map = rWF;
                    a.f.b.j.o(map, "userStateMap");
                    com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
                    a.f.b.j.o(username, "username");
                    map.put(username, cxU.aap(username));
                }
            }
            dsH.close();
        } else {
            ab.w(TAG, "checkContactState: cursor is null");
        }
        aVar.SW();
        AppMethodBeat.o(109375);
    }

    public static final /* synthetic */ void czn() {
        AppMethodBeat.i(138792);
        if (com.tencent.mm.plugin.story.c.a.a.rQZ.cxi() || com.tencent.mm.plugin.story.c.a.a.rQZ.cwU()) {
            com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a(TAG);
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.b cxW = com.tencent.mm.plugin.story.model.j.a.cxW();
            String str = com.tencent.mm.plugin.story.h.b.sdC + " WHERE " + cxW.sdB;
            ArrayList<com.tencent.mm.plugin.story.h.c> arrayList = new ArrayList();
            Cursor rawQuery = cxW.bSd.rawQuery(str, null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    com.tencent.mm.plugin.story.h.c cVar = new com.tencent.mm.plugin.story.h.c();
                    cVar.d(rawQuery);
                    arrayList.add(cVar);
                }
                rawQuery.close();
            }
            for (com.tencent.mm.plugin.story.h.c cVar2 : arrayList) {
                aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.h.j lx = com.tencent.mm.plugin.story.model.j.a.cxT().lx(cVar2.field_storyId);
                if (lx != null && f(lx)) {
                    String str2 = lx.field_userName;
                    cer cer = new cer();
                    try {
                        cer.parseFrom(lx.field_attrBuf);
                    } catch (Exception e) {
                    }
                    LinkedList linkedList = cer.xeo;
                    a.f.b.j.o(linkedList, "storyObj.CommentList");
                    Collection arrayList2 = new ArrayList();
                    for (Object next : linkedList) {
                        cdv cdv = (cdv) next;
                        a.f.b.j.o(cdv, "it");
                        if (a(cdv, cVar2)) {
                            arrayList2.add(next);
                        }
                    }
                    int size = ((List) arrayList2).size();
                    if (str2 != null) {
                        if ((((CharSequence) str2).length() > 0 ? 1 : null) != null && size > 0) {
                            if (rWG.get(str2) == null) {
                                Map map = rWG;
                                a.f.b.j.o(map, "userReplyStateMap");
                                c cVar3 = new c(str2);
                                cVar3.rXi.put(Long.valueOf(lx.field_storyID), Integer.valueOf(size));
                                map.put(str2, cVar3);
                            } else {
                                c cVar4 = (c) rWG.get(str2);
                                if (cVar4 != null) {
                                    cVar4.rXi.put(Long.valueOf(lx.field_storyID), Integer.valueOf(size));
                                }
                            }
                            ab.i(TAG, "checkCommentState " + ((c) rWG.get(str2)));
                        }
                    }
                }
            }
            aVar.SW();
        }
        AppMethodBeat.o(138792);
    }

    public static final /* synthetic */ void aaJ(String str) {
        AppMethodBeat.i(109379);
        com.tencent.mm.plugin.story.h.f fVar = (com.tencent.mm.plugin.story.h.f) rWF.get(str);
        if (fVar != null) {
            fVar.cBN();
        }
        Iterator it = ilQ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(109379);
    }
}
