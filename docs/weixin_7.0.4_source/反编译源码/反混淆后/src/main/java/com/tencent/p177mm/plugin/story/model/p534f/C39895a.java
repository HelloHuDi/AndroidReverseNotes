package com.tencent.p177mm.plugin.story.model.p534f;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.story.api.C29269k.C29270b;
import com.tencent.p177mm.plugin.story.api.C29269k.C29272c;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C35189b;
import com.tencent.p177mm.plugin.story.p532h.C35191c;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.cdv;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
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
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C41363p;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p772b.C7992b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000f\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0002J\u0012\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010$\u001a\u00020\u0015J\u0012\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0016J:\u00102\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130403j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001304j\b\u0012\u0004\u0012\u00020\u0013`6`5H\u0016J\b\u00107\u001a\u000200H\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u0006\u0010;\u001a\u00020\u0015J\u0006\u0010<\u001a\u00020\u0015J\b\u0010=\u001a\u00020\u0015H\u0002J\u001c\u0010>\u001a\u00020\u00152\b\u0010?\u001a\u0004\u0018\u00010\u00052\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0006\u0010B\u001a\u00020\u0015J\u0012\u0010C\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010D\u001a\u00020\u0015H\u0002J\u0010\u0010E\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R,\u0010\u0011\u001a \u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0012X\u0004¢\u0006\u0002\n\u0000RN\u0010\u0016\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00180\u0018 \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00190\u0017X\u0004¢\u0006\u0002\n\u0000RN\u0010\u001a\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u001b0\u001b \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \b*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u00190\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayOlderUserList", "", "kotlin.jvm.PlatformType", "", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "updateUser", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.f.a */
public final class C39895a implements C29272c, C4931a {
    public static final String TAG = TAG;
    public static final LinkedList<C29270b> ilQ = new LinkedList();
    private static final Map<String, C4119f> rWF = Collections.synchronizedMap(new ConcurrentHashMap());
    private static final Map<String, C39901c> rWG = Collections.synchronizedMap(new ConcurrentHashMap());
    private static final List<String> rWH = Collections.synchronizedList(new LinkedList());
    private static final List<String> rWI = Collections.synchronizedList(new LinkedList());
    public static final C22236i rWJ = new C22236i();
    public static final C0011r<Long, Boolean, String, String, C37091y> rWK = C39899j.rWX;
    public static final C39895a rWL = new C39895a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$g */
    static final class C13777g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C4935m rWT;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.a$g$1 */
        static final class C137781 extends C25053k implements C31214a<C37091y> {
            public static final C137781 rWU = new C137781();

            static {
                AppMethodBeat.m2504i(138780);
                AppMethodBeat.m2505o(138780);
            }

            C137781() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(138779);
                C39895a c39895a = C39895a.rWL;
                C39895a.czl();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(138779);
                return c37091y;
            }
        }

        C13777g(C4935m c4935m) {
            this.rWT = c4935m;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(138781);
            Object obj = this.rWT.obj;
            C44941v c44941v;
            if (obj == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryInfo");
                AppMethodBeat.m2505o(138781);
                throw c44941v;
            }
            String str = ((C39879j) obj).field_userName;
            obj = this.rWT.obj;
            if (obj == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryInfo");
                AppMethodBeat.m2505o(138781);
                throw c44941v;
            }
            HashMap hashMap;
            long j = ((C39879j) obj).field_storyID;
            C39895a c39895a = C39895a.rWL;
            C4990ab.m7416i(C39895a.TAG, "[StoryInfo] onNotifyChange: " + str + ' ' + j);
            c39895a = C39895a.rWL;
            C39901c c39901c = (C39901c) C39895a.rWG.get(str);
            if (c39901c != null) {
                hashMap = c39901c.rXi;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                hashMap.remove(Long.valueOf(j));
                if (hashMap.isEmpty()) {
                    c39895a = C39895a.rWL;
                    C39895a.rWG.remove(str);
                }
            }
            c39895a = C39895a.rWL;
            C39895a.czk();
            C8902b.m16042a(C137781.rWU);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138781);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$i */
    public static final class C22236i extends C4884c<C18384ro> {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.a$i$a */
        static final class C13779a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C18384ro rWW;

            C13779a(C18384ro c18384ro) {
                this.rWW = c18384ro;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109360);
                C18384ro c18384ro = this.rWW;
                if (!((c18384ro != null ? c18384ro.cNw : null) == null || !this.rWW.cNw.cNx || TextUtils.isEmpty(this.rWW.cNw.username))) {
                    C39895a c39895a = C39895a.rWL;
                    if (!C39895a.aaK(this.rWW.cNw.username)) {
                        if (this.rWW.cNw.cNz) {
                            C4133a c4133a = C43644j.rST;
                            C29296g cxU = C4133a.cxU();
                            String str = this.rWW.cNw.username;
                            C25052j.m39375o(str, "event.data.username");
                            C4119f aap = cxU.aap(str);
                            C39895a c39895a2 = C39895a.rWL;
                            Map czo = C39895a.rWF;
                            C25052j.m39375o(czo, "userStateMap");
                            czo.put(this.rWW.cNw.username, aap);
                        } else {
                            c39895a = C39895a.rWL;
                            C39895a.rWF.remove(this.rWW.cNw.username);
                        }
                        c39895a = C39895a.rWL;
                        String str2 = this.rWW.cNw.username;
                        C25052j.m39375o(str2, "event.data.username");
                        C39895a.aaJ(str2);
                        c39895a = C39895a.rWL;
                        C39895a.czl();
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109360);
                return c37091y;
            }
        }

        C22236i() {
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(109361);
            C8902b.m16042a(new C13779a((C18384ro) c4883b));
            AppMethodBeat.m2505o(109361);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$f */
    static final class C31571f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ String hBP;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.a$f$1 */
        static final class C315701 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C31571f rWS;

            C315701(C31571f c31571f) {
                this.rWS = c31571f;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109356);
                C39895a c39895a = C39895a.rWL;
                C39895a.czl();
                c39895a = C39895a.rWL;
                C39895a.aaJ(this.rWS.hBP);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109356);
                return c37091y;
            }
        }

        C31571f(String str) {
            this.hBP = str;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109357);
            C39895a c39895a = C39895a.rWL;
            C39895a.czk();
            C8902b.m16042a(new C315701(this));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109357);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$d */
    static final class C35207d extends C25053k implements C31214a<C37091y> {
        public static final C35207d rWP = new C35207d();

        static {
            AppMethodBeat.m2504i(109351);
            AppMethodBeat.m2505o(109351);
        }

        C35207d() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109350);
            C39895a c39895a = C39895a.rWL;
            C39895a.czi();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109350);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$h */
    static final class C35208h extends C25053k implements C31214a<C37091y> {
        public static final C35208h rWV = new C35208h();

        static {
            AppMethodBeat.m2504i(109359);
            AppMethodBeat.m2505o(109359);
        }

        C35208h() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109358);
            C39895a c39895a = C39895a.rWL;
            C8901a c8901a = new C8901a(C39895a.TAG);
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
            Cursor dsH = ((C6982j) K).mo15369XM().dsH();
            if (dsH != null) {
                while (dsH.moveToNext()) {
                    C7616ad c7616ad = new C7616ad();
                    c7616ad.mo8995d(dsH);
                    ((C35168e) C1720g.m3530M(C35168e.class)).loadStory(c7616ad.getUsername(), "");
                }
                dsH.close();
            } else {
                c39895a = C39895a.rWL;
                C4990ab.m7420w(C39895a.TAG, "checkContactState: cursor is null");
            }
            c8901a.mo20314SW();
            c39895a = C39895a.rWL;
            C4990ab.m7416i(C39895a.TAG, "pullTest done ");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109358);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$b */
    static final class C39892b extends C25053k implements C31214a<C37091y> {
        public static final C39892b rWO = new C39892b();

        static {
            AppMethodBeat.m2504i(138778);
            AppMethodBeat.m2505o(138778);
        }

        C39892b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(138777);
            C39895a c39895a = C39895a.rWL;
            C39895a.czm();
            c39895a = C39895a.rWL;
            C39895a.czn();
            c39895a = C39895a.rWL;
            C39895a.czk();
            c39895a = C39895a.rWL;
            String czj = C39895a.TAG;
            StringBuilder stringBuilder = new StringBuilder("checkContactState: user size is ");
            C39895a c39895a2 = C39895a.rWL;
            stringBuilder = stringBuilder.append(C39895a.rWF.size()).append(", unread ");
            c39895a2 = C39895a.rWL;
            C4990ab.m7416i(czj, stringBuilder.append(C39895a.rWI.size()).toString());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138777);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$e */
    static final class C39893e extends C25053k implements C31214a<C37091y> {
        public static final C39893e rWQ = new C39893e();

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.a$e$1 */
        static final class C398941 extends C25053k implements C31214a<C37091y> {
            public static final C398941 rWR = new C398941();

            static {
                AppMethodBeat.m2504i(109353);
                AppMethodBeat.m2505o(109353);
            }

            C398941() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109352);
                C39895a c39895a = C39895a.rWL;
                C39895a.czl();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109352);
                return c37091y;
            }
        }

        static {
            AppMethodBeat.m2504i(109355);
            AppMethodBeat.m2505o(109355);
        }

        C39893e() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109354);
            C39895a c39895a = C39895a.rWL;
            C39895a.czk();
            C8902b.m16042a(C398941.rWR);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109354);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$k */
    public static final class C39896k<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            long j;
            long j2;
            AppMethodBeat.m2504i(109362);
            C4119f c4119f = (C4119f) t2;
            if (c4119f.field_updateTime == 0) {
                j = ((long) c4119f.field_storyPostTime) * 1000;
            } else {
                j = c4119f.field_updateTime;
            }
            Comparable valueOf = Long.valueOf(j);
            C4119f c4119f2 = (C4119f) t;
            if (c4119f2.field_updateTime == 0) {
                j2 = ((long) c4119f2.field_storyPostTime) * 1000;
            } else {
                j2 = c4119f2.field_updateTime;
            }
            int a = C7992b.m14176a(valueOf, Long.valueOf(j2));
            AppMethodBeat.m2505o(109362);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$a */
    static final class C39897a extends C25053k implements C31214a<C37091y> {
        public static final C39897a rWM = new C39897a();

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.a$a$1 */
        static final class C41281 extends C25053k implements C31214a<C37091y> {
            public static final C41281 rWN = new C41281();

            static {
                AppMethodBeat.m2504i(109346);
                AppMethodBeat.m2505o(109346);
            }

            C41281() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109345);
                C39895a c39895a = C39895a.rWL;
                C39895a.czl();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109345);
                return c37091y;
            }
        }

        static {
            AppMethodBeat.m2504i(109348);
            AppMethodBeat.m2505o(109348);
        }

        C39897a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109347);
            C39895a c39895a = C39895a.rWL;
            C39895a.czk();
            C8902b.m16042a(C41281.rWN);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109347);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$c */
    public static final class C39898c<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.m2504i(109349);
            int a = C7992b.m14176a(Long.valueOf(((C4119f) t2).field_readTime), Long.valueOf(((C4119f) t).field_readTime));
            AppMethodBeat.m2505o(109349);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.a$j */
    static final class C39899j extends C25053k implements C0011r<Long, Boolean, String, String, C37091y> {
        public static final C39899j rWX = new C39899j();

        static {
            AppMethodBeat.m2504i(138786);
            AppMethodBeat.m2505o(138786);
        }

        C39899j() {
            super(4);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo47a(Object obj, Object obj2, Object obj3, Object obj4) {
            AppMethodBeat.m2504i(138785);
            final long longValue = ((Number) obj).longValue();
            final boolean booleanValue = ((Boolean) obj2).booleanValue();
            final String str = (String) obj3;
            final String str2 = (String) obj4;
            C25052j.m39376p(str, "fromUser");
            C25052j.m39376p(str2, "storyOwner");
            C8902b.m16044a("ContactSyncFetcher_checkContactState", (C31214a) new C31214a<C37091y>() {

                @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
                /* renamed from: com.tencent.mm.plugin.story.model.f.a$j$1$1 */
                static final class C352091 extends C25053k implements C31214a<C37091y> {
                    public static final C352091 rXa = new C352091();

                    static {
                        AppMethodBeat.m2504i(138783);
                        AppMethodBeat.m2505o(138783);
                    }

                    C352091() {
                        super(0);
                    }

                    public final /* synthetic */ Object invoke() {
                        AppMethodBeat.m2504i(138782);
                        C39895a c39895a = C39895a.rWL;
                        C39895a.czl();
                        C37091y c37091y = C37091y.AUy;
                        AppMethodBeat.m2505o(138782);
                        return c37091y;
                    }
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(138784);
                    C4133a c4133a = C43644j.rST;
                    C39879j lx = C4133a.cxT().mo74417lx(longValue);
                    if (C29274a.rQZ.cxi() || C29274a.rQZ.cwU()) {
                        C39895a c39895a = C39895a.rWL;
                        if (C39895a.m68320g(lx)) {
                            C39895a c39895a2;
                            c39895a = C39895a.rWL;
                            C4990ab.m7416i(C39895a.TAG, "new comment in " + longValue + ", isUnread:" + booleanValue + ", fromUser:" + str2 + ", fromUser:" + str);
                            C4133a c4133a2 = C43644j.rST;
                            C35191c lr = C4133a.cxW().mo55842lr(longValue);
                            if (lx == null || lr == null) {
                                c39895a2 = C39895a.rWL;
                                C39895a.rWG.remove(str2);
                            } else {
                                cer cer = new cer();
                                try {
                                    cer.parseFrom(lx.field_attrBuf);
                                } catch (Exception e) {
                                }
                                LinkedList linkedList = cer.xeo;
                                C25052j.m39375o(linkedList, "storyObj.CommentList");
                                Collection arrayList = new ArrayList();
                                for (Object next : linkedList) {
                                    cdv cdv = (cdv) next;
                                    C39895a c39895a3 = C39895a.rWL;
                                    C25052j.m39375o(cdv, "it");
                                    if (C39895a.m68318b(cdv, lr)) {
                                        arrayList.add(next);
                                    }
                                }
                                int size = ((List) arrayList).size();
                                c39895a2 = C39895a.rWL;
                                C4990ab.m7416i(C39895a.TAG, "commentCount ".concat(String.valueOf(size)));
                                C39901c c39901c;
                                if (size > 0) {
                                    c39895a2 = C39895a.rWL;
                                    if (C39895a.rWG.get(str2) == null) {
                                        c39895a2 = C39895a.rWL;
                                        Map czq = C39895a.rWG;
                                        C25052j.m39375o(czq, "userReplyStateMap");
                                        String str = str2;
                                        C39901c c39901c2 = new C39901c(str2);
                                        c39901c2.rXi.put(Long.valueOf(longValue), Integer.valueOf(size));
                                        czq.put(str, c39901c2);
                                    } else {
                                        c39895a2 = C39895a.rWL;
                                        c39901c = (C39901c) C39895a.rWG.get(str2);
                                        if (c39901c != null) {
                                            c39901c.rXi.put(Long.valueOf(longValue), Integer.valueOf(size));
                                        }
                                    }
                                } else {
                                    c39895a2 = C39895a.rWL;
                                    if (C39895a.rWG.get(str2) != null) {
                                        c39895a2 = C39895a.rWL;
                                        c39901c = (C39901c) C39895a.rWG.get(str2);
                                        if (c39901c != null) {
                                            HashMap hashMap = c39901c.rXi;
                                            if (hashMap != null) {
                                                hashMap.remove(Long.valueOf(longValue));
                                            }
                                        }
                                        if (c39901c != null) {
                                            HashMap hashMap2 = c39901c.rXi;
                                            if (hashMap2 != null && hashMap2.isEmpty()) {
                                                c39895a2 = C39895a.rWL;
                                                C39895a.rWG.remove(str2);
                                            }
                                        }
                                    }
                                }
                            }
                            c39895a2 = C39895a.rWL;
                            C39895a.czk();
                            C8902b.m16042a(C352091.rXa);
                        }
                    }
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(138784);
                    return c37091y;
                }
            });
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(138785);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(109374);
        AppMethodBeat.m2505o(109374);
    }

    private C39895a() {
    }

    public static final /* synthetic */ boolean aaK(String str) {
        AppMethodBeat.m2504i(109378);
        boolean aaI = C39895a.aaI(str);
        AppMethodBeat.m2505o(109378);
        return aaI;
    }

    /* renamed from: b */
    public static final /* synthetic */ boolean m68318b(cdv cdv, C35191c c35191c) {
        AppMethodBeat.m2504i(138793);
        boolean a = C39895a.m68317a(cdv, c35191c);
        AppMethodBeat.m2505o(138793);
        return a;
    }

    /* renamed from: g */
    public static final /* synthetic */ boolean m68320g(C39879j c39879j) {
        AppMethodBeat.m2504i(139086);
        boolean f = C39895a.m68319f(c39879j);
        AppMethodBeat.m2505o(139086);
        return f;
    }

    public final void init() {
        AppMethodBeat.m2504i(109363);
        C4990ab.m7416i(TAG, "init: ");
        C4133a c4133a = C43644j.rST;
        C4133a.cxU().mo10116c(this);
        c4133a = C43644j.rST;
        C4133a.cxT().mo10116c(this);
        C8902b.m16041a(1000, (C31214a) C35207d.rWP);
        rWJ.dnU();
        C46279b c46279b = C46279b.rVw;
        C46279b.m86757a(rWK);
        AppMethodBeat.m2505o(109363);
    }

    public static void czg() {
        AppMethodBeat.m2504i(109364);
        C8902b.m16044a("ContactSyncFetcher_pullTest", (C31214a) C35208h.rWV);
        AppMethodBeat.m2505o(109364);
    }

    /* renamed from: a */
    public final void mo47452a(C29270b c29270b) {
        AppMethodBeat.m2504i(109365);
        if (!ilQ.contains(c29270b)) {
            ilQ.add(c29270b);
        }
        AppMethodBeat.m2505o(109365);
    }

    /* renamed from: b */
    public final void mo47453b(C29270b c29270b) {
        AppMethodBeat.m2504i(109366);
        ilQ.remove(c29270b);
        AppMethodBeat.m2505o(109366);
    }

    public final List<String> cxc() {
        AppMethodBeat.m2504i(109367);
        LinkedList linkedList = new LinkedList();
        List<String> entrySet = rWF.entrySet();
        synchronized (entrySet) {
            try {
                Iterator it = entrySet.iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!(C39895a.aaI((String) entry.getKey()) || !((C4119f) entry.getValue()).isValid() || ((C4119f) entry.getValue()).cBN())) {
                        linkedList.add(entry.getValue());
                    }
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(109367);
            }
        }
        List list = linkedList;
        if (list.size() > 1) {
            C41363p.m72150a(list, new C39898c());
        }
        C4990ab.m7416i(TAG, "getReadList: size " + linkedList.size());
        Iterable<C4119f> iterable = linkedList;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C4119f userName : iterable) {
            arrayList.add(userName.getUserName());
        }
        entrySet = (List) arrayList;
        return entrySet;
    }

    public final List<String> cwY() {
        AppMethodBeat.m2504i(109368);
        C4990ab.m7416i(TAG, "getUnreadList: size " + rWI.size());
        List linkedList = new LinkedList(rWI);
        AppMethodBeat.m2505o(109368);
        return linkedList;
    }

    public final List<String> cwZ() {
        AppMethodBeat.m2504i(109369);
        C4990ab.m7416i(TAG, "getOlderList: size " + rWH.size());
        List linkedList = new LinkedList(rWH);
        AppMethodBeat.m2505o(109369);
        return linkedList;
    }

    public final LinkedHashMap<String, ArrayList<Long>> cxa() {
        AppMethodBeat.m2504i(138787);
        C4990ab.m7416i(TAG, "getNewReplyList: size " + rWG.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this) {
            try {
                Map map = rWG;
                C25052j.m39375o(map, "userReplyStateMap");
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    C39901c c39901c = (C39901c) entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(c39901c.rXi.keySet());
                    map = linkedHashMap;
                    C25052j.m39375o(str, "storyOwner");
                    map.put(str, arrayList);
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(138787);
            }
        }
        return linkedHashMap;
    }

    public final int cxb() {
        AppMethodBeat.m2504i(138788);
        int i = 0;
        Iterable<Entry> entrySet = rWG.entrySet();
        synchronized (entrySet) {
            try {
                for (Entry value : entrySet) {
                    for (Entry value2 : ((C39901c) value.getValue()).rXi.entrySet()) {
                        i = ((Number) value2.getValue()).intValue() + i;
                    }
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(138788);
            }
        }
        return i;
    }

    public final int aaH(String str) {
        int i;
        AppMethodBeat.m2504i(138789);
        C25052j.m39376p(str, "storyOwner");
        C4990ab.m7416i(TAG, "getNewReplyCount: storyOwner ".concat(String.valueOf(str)));
        int i2 = 0;
        synchronized (this) {
            try {
                C39901c c39901c = (C39901c) rWG.get(str);
                if (c39901c != null) {
                    HashMap hashMap = c39901c.rXi;
                    if (hashMap != null) {
                        for (Entry value : hashMap.entrySet()) {
                            i2 += ((Number) value.getValue()).intValue();
                        }
                        C37091y c37091y = C37091y.AUy;
                        i = i2;
                    }
                }
                i = 0;
            } finally {
                AppMethodBeat.m2505o(138789);
            }
        }
        return i;
    }

    public final void cxd() {
        AppMethodBeat.m2504i(109370);
        C8902b.m16044a("ContactSyncFetcher_checkContactState", (C31214a) C39897a.rWM);
        AppMethodBeat.m2505o(109370);
    }

    private static boolean aaI(String str) {
        Object obj;
        AppMethodBeat.m2504i(109371);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            C4133a c4133a = C43644j.rST;
            if (!C25052j.m39373j(str, C4133a.cnk())) {
                AppMethodBeat.m2505o(109371);
                return false;
            }
        }
        AppMethodBeat.m2505o(109371);
        return true;
    }

    /* renamed from: a */
    private static boolean m68317a(cdv cdv, C35191c c35191c) {
        AppMethodBeat.m2504i(138790);
        if (cdv.wZG != 0 && cdv.pcX > c35191c.field_readCommentTime) {
            String str = cdv.ndG;
            C4133a c4133a = C43644j.rST;
            if (!C5046bo.isEqual(str, C4133a.cnk())) {
                AppMethodBeat.m2505o(138790);
                return true;
            }
        }
        AppMethodBeat.m2505o(138790);
        return false;
    }

    /* renamed from: f */
    private static boolean m68319f(C39879j c39879j) {
        AppMethodBeat.m2504i(139085);
        if (c39879j == null) {
            AppMethodBeat.m2505o(139085);
            return false;
        } else if (c39879j.cBX()) {
            boolean cBW = c39879j.cBW();
            AppMethodBeat.m2505o(139085);
            return cBW;
        } else {
            String str = c39879j.field_userName;
            C4133a c4133a = C43644j.rST;
            if (C5046bo.isEqual(str, C4133a.cnk())) {
                AppMethodBeat.m2505o(139085);
                return false;
            }
            AppMethodBeat.m2505o(139085);
            return true;
        }
    }

    public static void czh() {
        AppMethodBeat.m2504i(109372);
        C8902b.m16044a("ContactSyncFetcher_checkContactState", (C31214a) C39893e.rWQ);
        AppMethodBeat.m2505o(109372);
    }

    /* JADX WARNING: Missing block: B:7:0x0017, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(TAG, "[StoryExtInfo] unknown event ".concat(java.lang.String.valueOf(r7)));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(109373);
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
            r0 = new p000a.C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(109373);
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
            r0 = (com.tencent.p177mm.plugin.story.p532h.C4119f) r0;
            r1 = r0.getUserName();
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(TAG, "[StoryExtInfo] onNotifyChange: event " + r7 + ' ' + r1);
     */
    /* JADX WARNING: Missing block: B:23:0x0095, code skipped:
            if (r0.isValid() == false) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:24:0x0097, code skipped:
            r2 = rWF;
            p000a.p005f.p007b.C25052j.m39375o(r2, "userStateMap");
            r2.put(r1, r0);
     */
    /* JADX WARNING: Missing block: B:26:0x00ab, code skipped:
            if ((p000a.p005f.p007b.C25052j.m39373j(r7, "notify_story_preload") ^ 1) == 0) goto L_0x0107;
     */
    /* JADX WARNING: Missing block: B:28:0x00b4, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r7, "notify_story_read") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Missing block: B:30:0x00bd, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r7, "notify_story_invalid") == false) goto L_0x00d4;
     */
    /* JADX WARNING: Missing block: B:31:0x00bf, code skipped:
            rWI.remove(r1);
            rWH.remove(r1);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(109373);
     */
    /* JADX WARNING: Missing block: B:32:0x00ce, code skipped:
            rWF.remove(r1);
     */
    /* JADX WARNING: Missing block: B:33:0x00d4, code skipped:
            com.tencent.p177mm.p823ab.C8902b.m16044a("ContactSyncFetcher_checkContactState", (p000a.p005f.p006a.C31214a) new com.tencent.p177mm.plugin.story.model.p534f.C39895a.C31571f(r1));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(109373);
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
    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(109373);
        if (str != null && c4935m != null && (c4935m.obj instanceof C4119f)) {
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
        } else if (!(str == null || c4935m == null || !(c4935m.obj instanceof C39879j))) {
            switch (str.hashCode()) {
                case 317345436:
                    if (str.equals("notify_story_info_delete")) {
                        C8902b.m16044a("ContactSyncFetcher_checkContactState", (C31214a) new C13777g(c4935m));
                        AppMethodBeat.m2505o(109373);
                        return;
                    }
                    break;
            }
            C4990ab.m7416i(TAG, "[StoryInfo] unknown event ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(109373);
    }

    public static final /* synthetic */ void czi() {
        AppMethodBeat.m2504i(138791);
        C8902b.m16044a("ContactSyncFetcher_checkContactState", (C31214a) C39892b.rWO);
        AppMethodBeat.m2505o(138791);
    }

    public static final /* synthetic */ void czk() {
        C37091y c37091y;
        long j;
        C4119f c4119f;
        AppMethodBeat.m2504i(109376);
        LinkedList<C4119f> linkedList = new LinkedList();
        Map map = rWF;
        C25052j.m39375o(map, "userStateMap");
        synchronized (map) {
            try {
                for (Entry entry : rWF.entrySet()) {
                    if (!C39895a.aaI((String) entry.getKey()) && ((C4119f) entry.getValue()).cBN()) {
                        linkedList.add(entry.getValue());
                    }
                }
                c37091y = C37091y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(109376);
            }
        }
        C1694a K = C1720g.m3528K(C7234a.class);
        C25052j.m39375o(K, "MMKernel.service<IConfig…onfigService::class.java)");
        int i = ((C7234a) K).mo15608Nu().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
        K = C1720g.m3528K(C7234a.class);
        C25052j.m39375o(K, "MMKernel.service<IConfig…onfigService::class.java)");
        int i2 = ((C7234a) K).mo15608Nu().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
        C4990ab.m7416i(TAG, "updateUnreadList: unread " + linkedList.size() + ", displayUnread:" + rWI.size() + ", displayOld:" + rWH.size() + ", displayNewReply:" + rWG.size() + ", totalCount:" + i + ", showDuration:" + i2);
        Object obj = null;
        if ((rWI.size() + rWH.size()) + rWG.size() > 0) {
            obj = 1;
        }
        if (obj == null && linkedList.size() >= i) {
            C7060h.pYm.mo15419k(1015, 10, 1);
            obj = 1;
        }
        if (obj == null) {
            for (C4119f c4119f2 : linkedList) {
                Object obj2;
                j = c4119f2.field_updateTime;
                if (j == 0) {
                    j = ((long) c4119f2.field_storyPostTime) * 1000;
                }
                if (C5046bo.m7549fp(j / 1000) >= ((long) i2)) {
                    C7060h.pYm.mo15419k(1015, 11, 1);
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
                C41363p.m72150a(list, new C39896k());
            }
            c4119f2 = (C4119f) C25035t.m39338fK(linkedList);
            if (c4119f2 != null) {
                linkedList.remove(c4119f2);
                linkedList.add(0, c4119f2);
            }
            rWI.clear();
            rWH.clear();
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            long a = RP.mo5239Ry().mo16814a(C5127a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, 0);
            Iterable<C4119f> iterable = linkedList;
            synchronized (iterable) {
                try {
                    for (C4119f c4119f3 : iterable) {
                        C4133a c4133a = C43644j.rST;
                        List h = C4133a.cxT().mo74413h(c4119f3.getUserName(), false, C1839cb.aaF() - 86400);
                        c4133a = C43644j.rST;
                        boolean z = C46275k.m86718a(C4133a.cxT(), c4119f3.getUserName(), false, C1839cb.aaF() - 86400).size() != h.size();
                        String str;
                        StringBuilder append;
                        boolean z2;
                        if (!z) {
                            if (c4119f3.field_updateTime == 0) {
                                j = ((long) c4119f3.field_storyPostTime) * 1000;
                            } else {
                                j = c4119f3.field_updateTime;
                            }
                            if (j > a) {
                                rWI.add(c4119f3.getUserName());
                            } else {
                                rWH.add(c4119f3.getUserName());
                            }
                            str = TAG;
                            append = new StringBuilder("make list username:").append(c4119f3.getUserName()).append(" updateTime:").append(c4119f3.field_updateTime).append(" posTime:").append(c4119f3.field_storyPostTime).append(" makeTime:").append(a).append(" itUpdateTime ").append(j).append(" result ");
                            if (j > a) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            C4990ab.m7416i(str, append.append(z2).append(" hasInvisibleItem:").append(z).toString());
                        } else if (!h.isEmpty()) {
                            j = ((long) ((C39879j) h.get(0)).field_createTime) * 1000;
                            if (j > c4119f3.field_readTime) {
                                if (j > a) {
                                    rWI.add(c4119f3.getUserName());
                                } else {
                                    rWH.add(c4119f3.getUserName());
                                }
                            }
                            str = TAG;
                            append = new StringBuilder("make list username:").append(c4119f3.getUserName()).append(" updateTime:").append(c4119f3.field_updateTime).append(" posTime:").append(c4119f3.field_storyPostTime).append(" makeTime:").append(a).append(" itUpdateTime ").append(j).append(" result ");
                            if (j > a) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            C4990ab.m7416i(str, append.append(z2).append(" hasInvisibleItem:").append(z).toString());
                        }
                    }
                    c37091y = C37091y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(109376);
                }
            }
            C4990ab.m7416i(TAG, "update time " + a + " displayUnreadUserList " + rWI + " displayOlderUserList " + rWH + " userReplyStateMap " + rWG);
        }
        AppMethodBeat.m2505o(109376);
    }

    public static final /* synthetic */ void czl() {
        AppMethodBeat.m2504i(109377);
        for (C29270b cvv : ilQ) {
            cvv.cvv();
        }
        AppMethodBeat.m2505o(109377);
    }

    public static final /* synthetic */ void czm() {
        AppMethodBeat.m2504i(109375);
        C8901a c8901a = new C8901a(TAG);
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
        Cursor dsH = ((C6982j) K).mo15369XM().dsH();
        if (dsH != null) {
            while (dsH.moveToNext()) {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(dsH);
                String username = c7616ad.getUsername();
                if (!(C39895a.aaI(username) || C39732a.m67945Xv(username))) {
                    Map map = rWF;
                    C25052j.m39375o(map, "userStateMap");
                    C4133a c4133a = C43644j.rST;
                    C29296g cxU = C4133a.cxU();
                    C25052j.m39375o(username, "username");
                    map.put(username, cxU.aap(username));
                }
            }
            dsH.close();
        } else {
            C4990ab.m7420w(TAG, "checkContactState: cursor is null");
        }
        c8901a.mo20314SW();
        AppMethodBeat.m2505o(109375);
    }

    public static final /* synthetic */ void czn() {
        AppMethodBeat.m2504i(138792);
        if (C29274a.rQZ.cxi() || C29274a.rQZ.cwU()) {
            C8901a c8901a = new C8901a(TAG);
            C4133a c4133a = C43644j.rST;
            C35189b cxW = C4133a.cxW();
            String str = C35189b.sdC + " WHERE " + cxW.sdB;
            ArrayList<C35191c> arrayList = new ArrayList();
            Cursor rawQuery = cxW.bSd.rawQuery(str, null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    C35191c c35191c = new C35191c();
                    c35191c.mo8995d(rawQuery);
                    arrayList.add(c35191c);
                }
                rawQuery.close();
            }
            for (C35191c c35191c2 : arrayList) {
                c4133a = C43644j.rST;
                C39879j lx = C4133a.cxT().mo74417lx(c35191c2.field_storyId);
                if (lx != null && C39895a.m68319f(lx)) {
                    String str2 = lx.field_userName;
                    cer cer = new cer();
                    try {
                        cer.parseFrom(lx.field_attrBuf);
                    } catch (Exception e) {
                    }
                    LinkedList linkedList = cer.xeo;
                    C25052j.m39375o(linkedList, "storyObj.CommentList");
                    Collection arrayList2 = new ArrayList();
                    for (Object next : linkedList) {
                        cdv cdv = (cdv) next;
                        C25052j.m39375o(cdv, "it");
                        if (C39895a.m68317a(cdv, c35191c2)) {
                            arrayList2.add(next);
                        }
                    }
                    int size = ((List) arrayList2).size();
                    if (str2 != null) {
                        if ((((CharSequence) str2).length() > 0 ? 1 : null) != null && size > 0) {
                            if (rWG.get(str2) == null) {
                                Map map = rWG;
                                C25052j.m39375o(map, "userReplyStateMap");
                                C39901c c39901c = new C39901c(str2);
                                c39901c.rXi.put(Long.valueOf(lx.field_storyID), Integer.valueOf(size));
                                map.put(str2, c39901c);
                            } else {
                                C39901c c39901c2 = (C39901c) rWG.get(str2);
                                if (c39901c2 != null) {
                                    c39901c2.rXi.put(Long.valueOf(lx.field_storyID), Integer.valueOf(size));
                                }
                            }
                            C4990ab.m7416i(TAG, "checkCommentState " + ((C39901c) rWG.get(str2)));
                        }
                    }
                }
            }
            c8901a.mo20314SW();
        }
        AppMethodBeat.m2505o(138792);
    }

    public static final /* synthetic */ void aaJ(String str) {
        AppMethodBeat.m2504i(109379);
        C4119f c4119f = (C4119f) rWF.get(str);
        if (c4119f != null) {
            c4119f.cBN();
        }
        Iterator it = ilQ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(109379);
    }
}
