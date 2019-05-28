package com.tencent.mm.plugin.story.model.f;

import a.a.v;
import a.l;
import a.y;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u001c\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b implements k, com.tencent.mm.sdk.e.k.a {
    private static final String TAG = TAG;
    public static final a rXf = new a();
    private boolean isInBlackList;
    private boolean pls;
    private com.tencent.mm.plugin.story.api.k.a rXb;
    private f rXc;
    private boolean rXd;
    private final c rXe = new c(this);
    private final String username;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ b rXg;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.model.f.b$d$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ d rXh;

            AnonymousClass1(d dVar) {
                this.rXh = dVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(109382);
                com.tencent.mm.plugin.story.api.k.a f = this.rXh.rXg.rXb;
                if (f != null) {
                    f.bs(this.rXh.rXg.username, this.rXh.rXg.rXd);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(109382);
                return yVar;
            }
        }

        d(b bVar) {
            this.rXg = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            b bVar;
            boolean z = false;
            AppMethodBeat.i(109383);
            this.rXg.isInBlackList = com.tencent.mm.plugin.sns.e.a.Xv(this.rXg.username);
            if (this.rXg.isInBlackList) {
                this.rXg.pls = false;
                bVar = this.rXg;
            } else {
                boolean isValid;
                bVar = this.rXg;
                com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
                bVar.rXc = com.tencent.mm.plugin.story.model.j.a.cxU().aaX(this.rXg.username);
                b bVar2 = this.rXg;
                f e = this.rXg.rXc;
                if (e != null) {
                    isValid = e.isValid();
                } else {
                    isValid = false;
                }
                bVar2.pls = isValid;
                bVar = this.rXg;
                f e2 = this.rXg.rXc;
                if (e2 != null) {
                    z = e2.cBN();
                }
            }
            bVar.rXd = z;
            com.tencent.mm.ab.b.a(new AnonymousClass1(this));
            b.g(this.rXg);
            y yVar = y.AUy;
            AppMethodBeat.o(109383);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ b rXg;

        b(b bVar) {
            this.rXg = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(109380);
            com.tencent.mm.plugin.story.api.k.a f = this.rXg.rXb;
            if (f != null) {
                f.L(this.rXg.pls, this.rXg.rXd);
            }
            if (this.rXg.pls) {
                f = this.rXg.rXb;
                if (f != null) {
                    f.a(a.a.k.listOf(this.rXg.username), new ArrayList());
                }
            } else {
                com.tencent.mm.plugin.story.api.k.a f2 = this.rXg.rXb;
                if (f2 != null) {
                    f2.a(v.AUP, new ArrayList());
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109380);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class c extends com.tencent.mm.sdk.b.c<ro> {
        final /* synthetic */ b rXg;

        c(b bVar) {
            this.rXg = bVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(109381);
            ro roVar = (ro) bVar;
            if ((roVar != null ? roVar.cNw : null) == null || !roVar.cNw.cNx || TextUtils.isEmpty(roVar.cNw.username) || (a.f.b.j.j(this.rXg.username, roVar.cNw.username) ^ 1) != 0) {
                AppMethodBeat.o(109381);
            } else {
                b bVar2;
                boolean isValid;
                if (roVar.cNw.cNz) {
                    this.rXg.isInBlackList = false;
                    b bVar3 = this.rXg;
                    com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
                    g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
                    String str = roVar.cNw.username;
                    a.f.b.j.o(str, "event.data.username");
                    bVar3.rXc = cxU.aap(str);
                    bVar2 = this.rXg;
                    f e = this.rXg.rXc;
                    if (e != null) {
                        isValid = e.isValid();
                    } else {
                        isValid = false;
                    }
                    bVar2.pls = isValid;
                    bVar2 = this.rXg;
                    e = this.rXg.rXc;
                    if (e != null) {
                        isValid = e.cBN();
                    } else {
                        isValid = false;
                    }
                } else {
                    this.rXg.isInBlackList = true;
                    this.rXg.pls = false;
                    bVar2 = this.rXg;
                    isValid = false;
                }
                bVar2.rXd = isValid;
                b.g(this.rXg);
                AppMethodBeat.o(109381);
            }
            return false;
        }
    }

    public b(String str) {
        a.f.b.j.p(str, "username");
        AppMethodBeat.i(109389);
        this.username = str;
        AppMethodBeat.o(109389);
    }

    public static final /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(109391);
        bVar.cna();
        AppMethodBeat.o(109391);
    }

    static {
        AppMethodBeat.i(109390);
        AppMethodBeat.o(109390);
    }

    public final void start() {
        AppMethodBeat.i(109384);
        com.tencent.mm.ab.b.a("SingleUserStateFetcher_start", (a.f.a.a) new d(this));
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().c(this);
        com.tencent.mm.sdk.b.a.xxA.c(this.rXe);
        AppMethodBeat.o(109384);
    }

    public final void resume() {
        AppMethodBeat.i(109385);
        f fVar = this.rXc;
        if (fVar != null) {
            if (this.pls && !fVar.isValid()) {
                ab.i(TAG, "LogStory: expired " + this.username);
                com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
                com.tencent.mm.plugin.story.model.k.aan(this.username);
            }
            AppMethodBeat.o(109385);
            return;
        }
        AppMethodBeat.o(109385);
    }

    public final void pause() {
    }

    public final void destroy() {
        AppMethodBeat.i(109386);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().d(this);
        com.tencent.mm.sdk.b.a.xxA.d(this.rXe);
        AppMethodBeat.o(109386);
    }

    public final boolean ZW(String str) {
        return this.rXd;
    }

    public final void a(com.tencent.mm.plugin.story.api.k.a aVar) {
        this.rXb = aVar;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(109387);
        if (this.isInBlackList) {
            AppMethodBeat.o(109387);
            return;
        }
        if (!(str == null || mVar == null || !(mVar.obj instanceof f))) {
            Object obj = mVar.obj;
            if (obj == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                AppMethodBeat.o(109387);
                throw vVar;
            }
            f fVar = (f) obj;
            if ((a.f.b.j.j(this.username, fVar.getUserName()) ^ 1) != 0) {
                AppMethodBeat.o(109387);
                return;
            } else if (a.f.b.j.j(str, "notify_story_read") || a.f.b.j.j(str, "notify_story_unread") || a.f.b.j.j(str, "notify_story_invalid") || a.f.b.j.j(str, "notify_story_valid")) {
                ab.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + ' ' + str);
                Object obj2 = this.rXd != fVar.cBN() ? 1 : null;
                this.rXc = fVar;
                this.pls = fVar.isValid();
                this.rXd = fVar.cBN();
                cna();
                if (obj2 != null) {
                    com.tencent.mm.plugin.story.api.k.a aVar = this.rXb;
                    if (aVar != null) {
                        aVar.bs(this.username, this.rXd);
                        AppMethodBeat.o(109387);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(109387);
    }

    private final void cna() {
        AppMethodBeat.i(109388);
        ab.i(TAG, "notifyListener: " + this.pls + ' ' + this.rXd);
        com.tencent.mm.ab.b.a(new b(this));
        AppMethodBeat.o(109388);
    }
}
