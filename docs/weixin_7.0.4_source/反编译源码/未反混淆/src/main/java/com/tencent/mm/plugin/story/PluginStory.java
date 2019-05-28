package com.tencent.mm.plugin.story;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.so;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.h;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.model.a.i;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0003GHIB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\u0012\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u00100\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00101\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\u0012\u00104\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u00105\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020\u000eH\u0016J\u0012\u00107\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u00108\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u00109\u001a\u00020\b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010;\u001a\u00020<H\u0016J \u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0012H\u0016J\b\u0010C\u001a\u00020DH\u0016J\u001c\u0010E\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "addStoryPostListener", "", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", "username", "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"})
public final class PluginStory extends f implements e {
    private static final String TAG = TAG;
    public static final a rQs = new a();
    private final String rQq = "oneday/";
    private final String rQr = "oneday/temp/";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryFileCleanTaskEvent;", "()V", "callback", "", "event", "plugin-story_release"})
    public static final class b extends com.tencent.mm.sdk.b.c<sn> {
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            Integer valueOf;
            com.tencent.mm.plugin.story.i.a aVar;
            AppMethodBeat.i(108909);
            sn snVar = (sn) bVar;
            if (snVar != null) {
                com.tencent.mm.g.a.sn.a aVar2 = snVar.cON;
                if (aVar2 != null) {
                    valueOf = Integer.valueOf(aVar2.state);
                    if (valueOf != null && valueOf.intValue() == 0) {
                        ab.i(PluginStory.TAG, "receive a event start clean");
                        aVar = com.tencent.mm.plugin.story.i.a.ser;
                    } else if (valueOf != null && valueOf.intValue() == 1) {
                        ab.i(PluginStory.TAG, "receive a event to stop clean");
                        aVar = com.tencent.mm.plugin.story.i.a.ser;
                    }
                    AppMethodBeat.o(108909);
                    return false;
                }
            }
            valueOf = null;
            if (valueOf != null) {
                ab.i(PluginStory.TAG, "receive a event start clean");
                aVar = com.tencent.mm.plugin.story.i.a.ser;
                AppMethodBeat.o(108909);
                return false;
            }
            ab.i(PluginStory.TAG, "receive a event to stop clean");
            aVar = com.tencent.mm.plugin.story.i.a.ser;
            AppMethodBeat.o(108909);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StorySyncEvent;", "()V", "callback", "", "event", "plugin-story_release"})
    public static final class c extends com.tencent.mm.sdk.b.c<so> {
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(108910);
            j.p((so) bVar, "event");
            com.tencent.mm.kernel.b RO = g.RO();
            j.o(RO, "MMKernel.network()");
            RO.Rg().d((m) new i());
            AppMethodBeat.o(108910);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.story.ui.sns.b rQt;

        d(com.tencent.mm.plugin.story.ui.sns.b bVar) {
            this.rQt = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(108911);
            this.rQt.cancel();
            AppMethodBeat.o(108911);
        }
    }

    static {
        AppMethodBeat.i(108938);
        AppMethodBeat.o(108938);
    }

    public final String getAccStoryPath() {
        AppMethodBeat.i(108912);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.e RP = g.RP();
        j.o(RP, "storage()");
        String stringBuilder2 = stringBuilder.append(RP.getAccPath()).append(this.rQq).toString();
        AppMethodBeat.o(108912);
        return stringBuilder2;
    }

    public final String getAccStoryTmpPath() {
        AppMethodBeat.i(108913);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.e RP = g.RP();
        j.o(RP, "storage()");
        String stringBuilder2 = stringBuilder.append(RP.getAccPath()).append(this.rQr).toString();
        AppMethodBeat.o(108913);
        return stringBuilder2;
    }

    public final String getAccStoryCachePath() {
        AppMethodBeat.i(108914);
        String str = ah.getContext().getCacheDir().getAbsolutePath() + "/" + this.rQq;
        AppMethodBeat.o(108914);
        return str;
    }

    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(108915);
        com.tencent.mm.media.g.c.eXz = new com.tencent.mm.media.g.g();
        AppMethodBeat.o(108915);
    }

    public final void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(108916);
        if (gVar != null && gVar.SG()) {
            ab.i(TAG, "PluginStory configure");
            pin(new q(com.tencent.mm.plugin.story.model.j.class));
        }
        AppMethodBeat.o(108916);
    }

    public final String name() {
        return "plugin-story";
    }

    public final boolean isStoryUnread(String str) {
        AppMethodBeat.i(108917);
        com.tencent.mm.plugin.story.model.f.a aVar = com.tencent.mm.plugin.story.model.f.rSp;
        boolean isStoryUnread = com.tencent.mm.plugin.story.model.f.a.isStoryUnread(str);
        AppMethodBeat.o(108917);
        return isStoryUnread;
    }

    public final boolean isStoryExist(String str) {
        AppMethodBeat.i(108918);
        if (!n.isShowStoryCheck()) {
            AppMethodBeat.o(108918);
            return false;
        } else if (str == null) {
            AppMethodBeat.o(108918);
            return false;
        } else {
            boolean isValid;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if ((j.j(str, com.tencent.mm.plugin.story.model.j.a.cnk()) ^ 1) != 0) {
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                isValid = com.tencent.mm.plugin.story.model.j.a.cxU().aap(str).isValid();
                if (isValid) {
                    ab.i(TAG, "ret1 has story!");
                    AppMethodBeat.o(108918);
                    return true;
                }
            }
            isValid = false;
            com.tencent.mm.plugin.story.model.n.a aVar2 = com.tencent.mm.plugin.story.model.n.rTi;
            boolean dl = com.tencent.mm.plugin.story.model.n.a.dl(str, cb.aaF() - 86400);
            if (dl) {
                ab.i(TAG, "ret2 has story!");
            }
            if (isValid || dl) {
                AppMethodBeat.o(108918);
                return true;
            }
            AppMethodBeat.o(108918);
            return false;
        }
    }

    public final void loadStory(String str, String str2) {
        AppMethodBeat.i(108919);
        if (str == null) {
            AppMethodBeat.o(108919);
        } else if (n.isShowStoryCheck()) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            boolean isEqual = bo.isEqual(str, com.tencent.mm.plugin.story.model.j.a.cnk());
            if (!(isEqual || n.cxf())) {
                com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
                if (aoO == null) {
                    AppMethodBeat.o(108919);
                    return;
                } else if (!aoO.NX()) {
                    ab.i(TAG, "filter by isOpenStrangerUserPage close ".concat(String.valueOf(str)));
                    AppMethodBeat.o(108919);
                    return;
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.story.model.a.j jVar = new com.tencent.mm.plugin.story.model.a.j(str, isEqual, str2);
            com.tencent.mm.kernel.b RO = g.RO();
            j.o(RO, "MMKernel.network()");
            RO.Rg().d((m) jVar);
            AppMethodBeat.o(108919);
        } else {
            AppMethodBeat.o(108919);
        }
    }

    public final k getStoryStateFetcher(String str) {
        AppMethodBeat.i(108920);
        com.tencent.mm.plugin.story.model.f.e eVar = com.tencent.mm.plugin.story.model.f.e.rXx;
        k aaM = com.tencent.mm.plugin.story.model.f.e.aaM(str);
        AppMethodBeat.o(108920);
        return aaM;
    }

    public final void addStoryPostListener(com.tencent.mm.plugin.story.api.j jVar) {
        AppMethodBeat.i(108921);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cya().a(jVar);
        AppMethodBeat.o(108921);
    }

    public final void removeStoryPostListener(com.tencent.mm.plugin.story.api.j jVar) {
        AppMethodBeat.i(108922);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cya().b(jVar);
        AppMethodBeat.o(108922);
    }

    public final void addStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.l lVar) {
        AppMethodBeat.i(108923);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        if (!(lVar == null || cxU.sdL.contains(lVar))) {
            cxU.sdL.add(lVar);
        }
        AppMethodBeat.o(108923);
    }

    public final void removeStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.l lVar) {
        AppMethodBeat.i(108924);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        if (lVar != null) {
            cxU.sdL.remove(lVar);
        }
        AppMethodBeat.o(108924);
    }

    public final boolean isShowStoryCheck() {
        AppMethodBeat.i(108925);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        boolean cyg = com.tencent.mm.plugin.story.model.j.a.cyg();
        AppMethodBeat.o(108925);
        return cyg;
    }

    public final h storyComment() {
        return com.tencent.mm.plugin.story.model.b.b.rVw;
    }

    public final com.tencent.mm.plugin.story.api.m getStoryUIFactory() {
        return r.rTS;
    }

    public final com.tencent.mm.plugin.story.api.b getFavourUserChecker() {
        return com.tencent.mm.plugin.story.model.b.rSa;
    }

    public final void checkPost() {
        AppMethodBeat.i(108926);
        if (isShowStoryCheck()) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
            AppMethodBeat.o(108926);
            return;
        }
        AppMethodBeat.o(108926);
    }

    public final boolean hasNewStory(String str) {
        AppMethodBeat.i(108927);
        if (n.isShowStoryCheck()) {
            com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
            boolean aaq = com.tencent.mm.plugin.story.model.k.aaq(str);
            AppMethodBeat.o(108927);
            return aaq;
        }
        AppMethodBeat.o(108927);
        return false;
    }

    public final boolean canPostStory() {
        AppMethodBeat.i(108928);
        com.tencent.mm.plugin.story.model.d dVar = com.tencent.mm.plugin.story.model.d.rSg;
        boolean canPostStory = com.tencent.mm.plugin.story.model.d.canPostStory();
        AppMethodBeat.o(108928);
        return canPostStory;
    }

    public final com.tencent.mm.plugin.story.api.f getStoryBasicConfig() {
        return com.tencent.mm.plugin.story.c.a.a.rQZ;
    }

    public final boolean checkReportFromChatting(int i, String str) {
        AppMethodBeat.i(108929);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(108929);
            return false;
        }
        String str2;
        Object obj;
        Object obj2;
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.tencent.mm.plugin.story.h.f aap = cxU.aap(str2);
        boolean cBN = aap.cBN();
        if (aap.cBL() > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
        com.tencent.mm.plugin.story.g.c.clean();
        com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
        com.tencent.mm.plugin.story.g.b.clean();
        bVar = com.tencent.mm.plugin.story.g.b.sbw;
        if (str == null) {
            obj2 = "";
        } else {
            str2 = str;
        }
        j.p(obj2, "user");
        com.tencent.mm.plugin.story.g.b.EV(i);
        com.tencent.mm.plugin.story.g.b.clean();
        com.tencent.mm.plugin.story.g.b.sbp = bo.anU();
        boolean z = NetStatusUtil.isWifi(ah.getContext()) || NetStatusUtil.is4G(ah.getContext());
        com.tencent.mm.plugin.story.g.b.mgU = z;
        if (z) {
            ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + obj2 + " isWifi:" + com.tencent.mm.plugin.story.g.b.mgU);
            com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 1, 1);
        }
        if (i == 1) {
            cVar = com.tencent.mm.plugin.story.g.c.sbQ;
            if (str == null) {
                obj2 = "";
            } else {
                str2 = str;
            }
            j.p(obj2, "user");
            com.tencent.mm.plugin.story.g.c.clean();
            com.tencent.mm.plugin.story.g.c.sbM = false;
            com.tencent.mm.plugin.story.g.c.sbH = new com.tencent.mm.plugin.story.g.c.a(obj2, 1);
            ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRight ".concat(String.valueOf(obj2)));
            com.tencent.mm.plugin.report.service.h.pYm.k(988, 1, 1);
            if (cBN) {
                if (obj != null) {
                    cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                    com.tencent.mm.plugin.story.g.c.czT();
                } else {
                    cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                    if (str == null) {
                        str = "";
                    }
                    com.tencent.mm.plugin.story.g.c.aaN(str);
                }
            }
        } else if (i == 2) {
            cVar = com.tencent.mm.plugin.story.g.c.sbQ;
            if (str == null) {
                obj2 = "";
            } else {
                str2 = str;
            }
            j.p(obj2, "user");
            com.tencent.mm.plugin.story.g.c.clean();
            com.tencent.mm.plugin.story.g.c.sbM = true;
            com.tencent.mm.plugin.story.g.c.sbH = new com.tencent.mm.plugin.story.g.c.a(obj2, 2);
            ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheck ".concat(String.valueOf(obj2)));
            com.tencent.mm.plugin.report.service.h.pYm.k(988, 2, 1);
            if (cBN) {
                if (obj != null) {
                    cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                    com.tencent.mm.plugin.story.g.c.czU();
                } else {
                    cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                    if (str == null) {
                        str = "";
                    }
                    com.tencent.mm.plugin.story.g.c.aaO(str);
                }
            }
        }
        AppMethodBeat.o(108929);
        return true;
    }

    public final void enterGallery(List<String> list) {
        AppMethodBeat.i(108930);
        j.p(list, "unreadList");
        com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
        com.tencent.mm.plugin.story.g.c.dF(list);
        com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
        com.tencent.mm.plugin.story.g.b.dF(list);
        AppMethodBeat.o(108930);
    }

    public final void setPreviewEnterScene(long j) {
        AppMethodBeat.i(108931);
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAs().bG(j);
        AppMethodBeat.o(108931);
    }

    public final boolean preLoadVideoViewMgr(String str) {
        AppMethodBeat.i(108932);
        com.tencent.mm.plugin.story.ui.view.gallery.q qVar = com.tencent.mm.plugin.story.ui.view.gallery.q.srv;
        if (str == null) {
            str = "";
        }
        com.tencent.mm.plugin.story.ui.view.gallery.q.abg(str);
        AppMethodBeat.o(108932);
        return true;
    }

    public final com.tencent.mm.plugin.story.api.k.c getContactFetcher() {
        return com.tencent.mm.plugin.story.model.f.a.rWL;
    }

    public final void preloadForSnsUser(String str, boolean z) {
        AppMethodBeat.i(108933);
        if (str == null) {
            AppMethodBeat.o(108933);
            return;
        }
        int a;
        if (z) {
            a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_with_enter_sns, 1);
        } else {
            a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_with_change_sns, 0);
        }
        ab.i(TAG, "preloadForSnsUser: " + a + " isEnter: " + z + " username " + str + ' ' + bo.dpG());
        if (a == 1) {
            com.tencent.mm.plugin.story.f.h.a aVar = com.tencent.mm.plugin.story.f.h.rZx;
            com.tencent.mm.plugin.story.model.d.g bt = com.tencent.mm.plugin.story.f.h.a.bt(str, false);
            if (bt != null) {
                com.tencent.mm.plugin.story.ui.view.gallery.n nVar = com.tencent.mm.plugin.story.ui.view.gallery.n.sqi;
                com.tencent.mm.plugin.story.ui.view.gallery.n.dK(a.a.k.listOf(bt.rVZ));
                AppMethodBeat.o(108933);
                return;
            }
        }
        AppMethodBeat.o(108933);
    }

    public final void reportWaitPlayList(List<String> list, long j) {
        AppMethodBeat.i(108934);
        j.p(list, "userList");
        com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
        com.tencent.mm.plugin.story.model.k.reportWaitPlayList(list, j);
        AppMethodBeat.o(108934);
    }

    public final boolean showStoryEntranceDialog(Context context, String str, int i) {
        AppMethodBeat.i(108935);
        j.p(context, "context");
        j.p(str, "sessionId");
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAM().fw(str);
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAM().gJ((int) System.currentTimeMillis());
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.Fa(com.tencent.mm.plugin.story.g.h.cAM().FB());
        hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAM().gK(i);
        com.tencent.mm.plugin.story.ui.sns.b bVar = new com.tencent.mm.plugin.story.ui.sns.b(context);
        bVar.setContentView(new com.tencent.mm.plugin.story.ui.sns.c(context, new d(bVar)));
        bVar.show();
        AppMethodBeat.o(108935);
        return true;
    }

    public final cfc getStoryUserInfo() {
        AppMethodBeat.i(108936);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
        cfc cBM = cxU.aap(com.tencent.mm.plugin.story.model.j.a.cnk()).cBM();
        if (cBM == null) {
            cBM = new cfc();
        }
        AppMethodBeat.o(108936);
        return cBM;
    }

    public final void updateStoryUserInfo(String str, cfc cfc) {
        AppMethodBeat.i(108937);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
        if (str == null || cfc == null) {
            AppMethodBeat.o(108937);
            return;
        }
        byte[] toByteArray;
        com.tencent.mm.plugin.story.h.f aap = cxU.aap(str);
        if (cfc != null) {
            toByteArray = cfc.toByteArray();
        } else {
            toByteArray = null;
        }
        aap.field_userInfo = toByteArray;
        cxU.b(aap);
        AppMethodBeat.o(108937);
    }
}
