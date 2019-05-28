package com.tencent.p177mm.plugin.story.model.p534f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.story.api.C29269k;
import com.tencent.p177mm.plugin.story.api.C29269k.C29271a;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25033k;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u001c\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.f.b */
public final class C46283b implements C29269k, C4931a {
    private static final String TAG = TAG;
    public static final C35210a rXf = new C35210a();
    private boolean isInBlackList;
    private boolean pls;
    private C29271a rXb;
    private C4119f rXc;
    private boolean rXd;
    private final C35212c rXe = new C35212c(this);
    private final String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.b$d */
    static final class C13781d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C46283b rXg;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.b$d$1 */
        static final class C137801 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C13781d rXh;

            C137801(C13781d c13781d) {
                this.rXh = c13781d;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(109382);
                C29271a f = this.rXh.rXg.rXb;
                if (f != null) {
                    f.mo47451bs(this.rXh.rXg.username, this.rXh.rXg.rXd);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(109382);
                return c37091y;
            }
        }

        C13781d(C46283b c46283b) {
            this.rXg = c46283b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            C46283b c46283b;
            boolean z = false;
            AppMethodBeat.m2504i(109383);
            this.rXg.isInBlackList = C39732a.m67945Xv(this.rXg.username);
            if (this.rXg.isInBlackList) {
                this.rXg.pls = false;
                c46283b = this.rXg;
            } else {
                boolean isValid;
                c46283b = this.rXg;
                C4133a c4133a = C43644j.rST;
                c46283b.rXc = C4133a.cxU().aaX(this.rXg.username);
                C46283b c46283b2 = this.rXg;
                C4119f e = this.rXg.rXc;
                if (e != null) {
                    isValid = e.isValid();
                } else {
                    isValid = false;
                }
                c46283b2.pls = isValid;
                c46283b = this.rXg;
                C4119f e2 = this.rXg.rXc;
                if (e2 != null) {
                    z = e2.cBN();
                }
            }
            c46283b.rXd = z;
            C8902b.m16042a(new C137801(this));
            C46283b.m86791g(this.rXg);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109383);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.b$a */
    public static final class C35210a {
        private C35210a() {
        }

        public /* synthetic */ C35210a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.b$b */
    static final class C35211b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C46283b rXg;

        C35211b(C46283b c46283b) {
            this.rXg = c46283b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(109380);
            C29271a f = this.rXg.rXb;
            if (f != null) {
                f.mo47449L(this.rXg.pls, this.rXg.rXd);
            }
            if (this.rXg.pls) {
                f = this.rXg.rXb;
                if (f != null) {
                    f.mo47450a(C25033k.listOf(this.rXg.username), new ArrayList());
                }
            } else {
                C29271a f2 = this.rXg.rXb;
                if (f2 != null) {
                    f2.mo47450a(C17115v.AUP, new ArrayList());
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109380);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.f.b$c */
    public static final class C35212c extends C4884c<C18384ro> {
        final /* synthetic */ C46283b rXg;

        C35212c(C46283b c46283b) {
            this.rXg = c46283b;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(109381);
            C18384ro c18384ro = (C18384ro) c4883b;
            if ((c18384ro != null ? c18384ro.cNw : null) == null || !c18384ro.cNw.cNx || TextUtils.isEmpty(c18384ro.cNw.username) || (C25052j.m39373j(this.rXg.username, c18384ro.cNw.username) ^ 1) != 0) {
                AppMethodBeat.m2505o(109381);
            } else {
                C46283b c46283b;
                boolean isValid;
                if (c18384ro.cNw.cNz) {
                    this.rXg.isInBlackList = false;
                    C46283b c46283b2 = this.rXg;
                    C4133a c4133a = C43644j.rST;
                    C29296g cxU = C4133a.cxU();
                    String str = c18384ro.cNw.username;
                    C25052j.m39375o(str, "event.data.username");
                    c46283b2.rXc = cxU.aap(str);
                    c46283b = this.rXg;
                    C4119f e = this.rXg.rXc;
                    if (e != null) {
                        isValid = e.isValid();
                    } else {
                        isValid = false;
                    }
                    c46283b.pls = isValid;
                    c46283b = this.rXg;
                    e = this.rXg.rXc;
                    if (e != null) {
                        isValid = e.cBN();
                    } else {
                        isValid = false;
                    }
                } else {
                    this.rXg.isInBlackList = true;
                    this.rXg.pls = false;
                    c46283b = this.rXg;
                    isValid = false;
                }
                c46283b.rXd = isValid;
                C46283b.m86791g(this.rXg);
                AppMethodBeat.m2505o(109381);
            }
            return false;
        }
    }

    public C46283b(String str) {
        C25052j.m39376p(str, "username");
        AppMethodBeat.m2504i(109389);
        this.username = str;
        AppMethodBeat.m2505o(109389);
    }

    /* renamed from: g */
    public static final /* synthetic */ void m86791g(C46283b c46283b) {
        AppMethodBeat.m2504i(109391);
        c46283b.cna();
        AppMethodBeat.m2505o(109391);
    }

    static {
        AppMethodBeat.m2504i(109390);
        AppMethodBeat.m2505o(109390);
    }

    public final void start() {
        AppMethodBeat.m2504i(109384);
        C8902b.m16044a("SingleUserStateFetcher_start", (C31214a) new C13781d(this));
        C4133a c4133a = C43644j.rST;
        C4133a.cxU().mo10116c(this);
        C4879a.xxA.mo10052c(this.rXe);
        AppMethodBeat.m2505o(109384);
    }

    public final void resume() {
        AppMethodBeat.m2504i(109385);
        C4119f c4119f = this.rXc;
        if (c4119f != null) {
            if (this.pls && !c4119f.isValid()) {
                C4990ab.m7416i(TAG, "LogStory: expired " + this.username);
                C22241k c22241k = C22241k.rTc;
                C22241k.aan(this.username);
            }
            AppMethodBeat.m2505o(109385);
            return;
        }
        AppMethodBeat.m2505o(109385);
    }

    public final void pause() {
    }

    public final void destroy() {
        AppMethodBeat.m2504i(109386);
        C4133a c4133a = C43644j.rST;
        C4133a.cxU().mo10117d(this);
        C4879a.xxA.mo10053d(this.rXe);
        AppMethodBeat.m2505o(109386);
    }

    /* renamed from: ZW */
    public final boolean mo47443ZW(String str) {
        return this.rXd;
    }

    /* renamed from: a */
    public final void mo47444a(C29271a c29271a) {
        this.rXb = c29271a;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(109387);
        if (this.isInBlackList) {
            AppMethodBeat.m2505o(109387);
            return;
        }
        if (!(str == null || c4935m == null || !(c4935m.obj instanceof C4119f))) {
            Object obj = c4935m.obj;
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                AppMethodBeat.m2505o(109387);
                throw c44941v;
            }
            C4119f c4119f = (C4119f) obj;
            if ((C25052j.m39373j(this.username, c4119f.getUserName()) ^ 1) != 0) {
                AppMethodBeat.m2505o(109387);
                return;
            } else if (C25052j.m39373j(str, "notify_story_read") || C25052j.m39373j(str, "notify_story_unread") || C25052j.m39373j(str, "notify_story_invalid") || C25052j.m39373j(str, "notify_story_valid")) {
                C4990ab.m7416i(TAG, "update user " + c4119f.getUserName() + ' ' + c4119f.field_syncId + ' ' + str);
                Object obj2 = this.rXd != c4119f.cBN() ? 1 : null;
                this.rXc = c4119f;
                this.pls = c4119f.isValid();
                this.rXd = c4119f.cBN();
                cna();
                if (obj2 != null) {
                    C29271a c29271a = this.rXb;
                    if (c29271a != null) {
                        c29271a.mo47451bs(this.username, this.rXd);
                        AppMethodBeat.m2505o(109387);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(109387);
    }

    private final void cna() {
        AppMethodBeat.m2504i(109388);
        C4990ab.m7416i(TAG, "notifyListener: " + this.pls + ' ' + this.rXd);
        C8902b.m16042a(new C35211b(this));
        AppMethodBeat.m2505o(109388);
    }
}
