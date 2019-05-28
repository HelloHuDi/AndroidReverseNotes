package com.tencent.p177mm.plugin.story;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.media.p254g.C37894c;
import com.tencent.p177mm.media.p254g.C9605g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42059so;
import com.tencent.p177mm.p230g.p231a.C45366sn;
import com.tencent.p177mm.p230g.p231a.C45366sn.C18393a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.story.api.C13736l;
import com.tencent.p177mm.plugin.story.api.C22174j;
import com.tencent.p177mm.plugin.story.api.C29269k;
import com.tencent.p177mm.plugin.story.api.C29269k.C29272c;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C35169f;
import com.tencent.p177mm.plugin.story.api.C39863h;
import com.tencent.p177mm.plugin.story.api.C4107b;
import com.tencent.p177mm.plugin.story.api.C46269m;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.model.C13774d;
import com.tencent.p177mm.plugin.story.model.C13785f;
import com.tencent.p177mm.plugin.story.model.C13785f.C13786a;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C35200b;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43648r;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p534f.C13784e;
import com.tencent.p177mm.plugin.story.model.p534f.C39895a;
import com.tencent.p177mm.plugin.story.model.p744a.C35194j;
import com.tencent.p177mm.plugin.story.model.p744a.C7141i;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p1559i.C39884a;
import com.tencent.p177mm.plugin.story.p530f.C39876h;
import com.tencent.p177mm.plugin.story.p530f.C39876h.C29290a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C35180c;
import com.tencent.p177mm.plugin.story.p531g.C35180c.C35181a;
import com.tencent.p177mm.plugin.story.p531g.C4116b;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p536ui.sns.C22266b;
import com.tencent.p177mm.plugin.story.p536ui.sns.C35238c;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C29380q;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C39933n;
import com.tencent.p177mm.protocal.protobuf.cfc;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C25033k;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0003GHIB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\u0012\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u00100\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00101\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\u0012\u00104\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u00105\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020\u000eH\u0016J\u0012\u00107\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u00108\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u00109\u001a\u00020\b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010;\u001a\u00020<H\u0016J \u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0012H\u0016J\b\u0010C\u001a\u00020DH\u0016J\u001c\u0010E\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "addStoryPostListener", "", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", "username", "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.PluginStory */
public final class PluginStory extends C7597f implements C35168e {
    private static final String TAG = TAG;
    public static final C39861a rQs = new C39861a();
    private final String rQq = "oneday/";
    private final String rQr = "oneday/temp/";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryFileCleanTaskEvent;", "()V", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.PluginStory$b */
    public static final class C39859b extends C4884c<C45366sn> {
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            Integer valueOf;
            C39884a c39884a;
            AppMethodBeat.m2504i(108909);
            C45366sn c45366sn = (C45366sn) c4883b;
            if (c45366sn != null) {
                C18393a c18393a = c45366sn.cON;
                if (c18393a != null) {
                    valueOf = Integer.valueOf(c18393a.state);
                    if (valueOf != null && valueOf.intValue() == 0) {
                        C4990ab.m7416i(PluginStory.TAG, "receive a event start clean");
                        c39884a = C39884a.ser;
                    } else if (valueOf != null && valueOf.intValue() == 1) {
                        C4990ab.m7416i(PluginStory.TAG, "receive a event to stop clean");
                        c39884a = C39884a.ser;
                    }
                    AppMethodBeat.m2505o(108909);
                    return false;
                }
            }
            valueOf = null;
            if (valueOf != null) {
                C4990ab.m7416i(PluginStory.TAG, "receive a event start clean");
                c39884a = C39884a.ser;
                AppMethodBeat.m2505o(108909);
                return false;
            }
            C4990ab.m7416i(PluginStory.TAG, "receive a event to stop clean");
            c39884a = C39884a.ser;
            AppMethodBeat.m2505o(108909);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StorySyncEvent;", "()V", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.PluginStory$c */
    public static final class C39860c extends C4884c<C42059so> {
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(108910);
            C25052j.m39376p((C42059so) c4883b, "event");
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().mo14552d((C1207m) new C7141i());
            AppMethodBeat.m2505o(108910);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/PluginStory$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.PluginStory$a */
    public static final class C39861a {
        private C39861a() {
        }

        public /* synthetic */ C39861a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.PluginStory$d */
    static final class C39862d implements OnClickListener {
        final /* synthetic */ C22266b rQt;

        C39862d(C22266b c22266b) {
            this.rQt = c22266b;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108911);
            this.rQt.cancel();
            AppMethodBeat.m2505o(108911);
        }
    }

    static {
        AppMethodBeat.m2504i(108938);
        AppMethodBeat.m2505o(108938);
    }

    public final String getAccStoryPath() {
        AppMethodBeat.m2504i(108912);
        StringBuilder stringBuilder = new StringBuilder();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        String stringBuilder2 = stringBuilder.append(RP.getAccPath()).append(this.rQq).toString();
        AppMethodBeat.m2505o(108912);
        return stringBuilder2;
    }

    public final String getAccStoryTmpPath() {
        AppMethodBeat.m2504i(108913);
        StringBuilder stringBuilder = new StringBuilder();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        String stringBuilder2 = stringBuilder.append(RP.getAccPath()).append(this.rQr).toString();
        AppMethodBeat.m2505o(108913);
        return stringBuilder2;
    }

    public final String getAccStoryCachePath() {
        AppMethodBeat.m2504i(108914);
        String str = C4996ah.getContext().getCacheDir().getAbsolutePath() + "/" + this.rQq;
        AppMethodBeat.m2505o(108914);
        return str;
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(108915);
        C37894c.eXz = new C9605g();
        AppMethodBeat.m2505o(108915);
    }

    public final void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(108916);
        if (c1681g != null && c1681g.mo5181SG()) {
            C4990ab.m7416i(TAG, "PluginStory configure");
            pin(new C7485q(C43644j.class));
        }
        AppMethodBeat.m2505o(108916);
    }

    public final String name() {
        return "plugin-story";
    }

    public final boolean isStoryUnread(String str) {
        AppMethodBeat.m2504i(108917);
        C13786a c13786a = C13785f.rSp;
        boolean isStoryUnread = C13786a.isStoryUnread(str);
        AppMethodBeat.m2505o(108917);
        return isStoryUnread;
    }

    public final boolean isStoryExist(String str) {
        AppMethodBeat.m2504i(108918);
        if (!C46270n.isShowStoryCheck()) {
            AppMethodBeat.m2505o(108918);
            return false;
        } else if (str == null) {
            AppMethodBeat.m2505o(108918);
            return false;
        } else {
            boolean isValid;
            C4133a c4133a = C43644j.rST;
            if ((C25052j.m39373j(str, C4133a.cnk()) ^ 1) != 0) {
                c4133a = C43644j.rST;
                isValid = C4133a.cxU().aap(str).isValid();
                if (isValid) {
                    C4990ab.m7416i(TAG, "ret1 has story!");
                    AppMethodBeat.m2505o(108918);
                    return true;
                }
            }
            isValid = false;
            C29311a c29311a = C29310n.rTi;
            boolean dl = C29311a.m46536dl(str, C1839cb.aaF() - 86400);
            if (dl) {
                C4990ab.m7416i(TAG, "ret2 has story!");
            }
            if (isValid || dl) {
                AppMethodBeat.m2505o(108918);
                return true;
            }
            AppMethodBeat.m2505o(108918);
            return false;
        }
    }

    public final void loadStory(String str, String str2) {
        AppMethodBeat.m2504i(108919);
        if (str == null) {
            AppMethodBeat.m2505o(108919);
        } else if (C46270n.isShowStoryCheck()) {
            C4133a c4133a = C43644j.rST;
            boolean isEqual = C5046bo.isEqual(str, C4133a.cnk());
            if (!(isEqual || C46270n.cxf())) {
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
                if (aoO == null) {
                    AppMethodBeat.m2505o(108919);
                    return;
                } else if (!aoO.mo16693NX()) {
                    C4990ab.m7416i(TAG, "filter by isOpenStrangerUserPage close ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(108919);
                    return;
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            C35194j c35194j = new C35194j(str, isEqual, str2);
            C1682b RO = C1720g.m3535RO();
            C25052j.m39375o(RO, "MMKernel.network()");
            RO.mo5186Rg().mo14552d((C1207m) c35194j);
            AppMethodBeat.m2505o(108919);
        } else {
            AppMethodBeat.m2505o(108919);
        }
    }

    public final C29269k getStoryStateFetcher(String str) {
        AppMethodBeat.m2504i(108920);
        C13784e c13784e = C13784e.rXx;
        C29269k aaM = C13784e.aaM(str);
        AppMethodBeat.m2505o(108920);
        return aaM;
    }

    public final void addStoryPostListener(C22174j c22174j) {
        AppMethodBeat.m2504i(108921);
        C4133a c4133a = C43644j.rST;
        C4133a.cya().mo15483a(c22174j);
        AppMethodBeat.m2505o(108921);
    }

    public final void removeStoryPostListener(C22174j c22174j) {
        AppMethodBeat.m2504i(108922);
        C4133a c4133a = C43644j.rST;
        C4133a.cya().mo15484b(c22174j);
        AppMethodBeat.m2505o(108922);
    }

    public final void addStoryStatusNotifyListener(C13736l c13736l) {
        AppMethodBeat.m2504i(108923);
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        if (!(c13736l == null || cxU.sdL.contains(c13736l))) {
            cxU.sdL.add(c13736l);
        }
        AppMethodBeat.m2505o(108923);
    }

    public final void removeStoryStatusNotifyListener(C13736l c13736l) {
        AppMethodBeat.m2504i(108924);
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        if (c13736l != null) {
            cxU.sdL.remove(c13736l);
        }
        AppMethodBeat.m2505o(108924);
    }

    public final boolean isShowStoryCheck() {
        AppMethodBeat.m2504i(108925);
        C4133a c4133a = C43644j.rST;
        boolean cyg = C4133a.cyg();
        AppMethodBeat.m2505o(108925);
        return cyg;
    }

    public final C39863h storyComment() {
        return C46279b.rVw;
    }

    public final C46269m getStoryUIFactory() {
        return C43648r.rTS;
    }

    public final C4107b getFavourUserChecker() {
        return C35200b.rSa;
    }

    public final void checkPost() {
        AppMethodBeat.m2504i(108926);
        if (isShowStoryCheck()) {
            C4133a c4133a = C43644j.rST;
            C4133a.cya().checkPost();
            AppMethodBeat.m2505o(108926);
            return;
        }
        AppMethodBeat.m2505o(108926);
    }

    public final boolean hasNewStory(String str) {
        AppMethodBeat.m2504i(108927);
        if (C46270n.isShowStoryCheck()) {
            C22241k c22241k = C22241k.rTc;
            boolean aaq = C22241k.aaq(str);
            AppMethodBeat.m2505o(108927);
            return aaq;
        }
        AppMethodBeat.m2505o(108927);
        return false;
    }

    public final boolean canPostStory() {
        AppMethodBeat.m2504i(108928);
        C13774d c13774d = C13774d.rSg;
        boolean canPostStory = C13774d.canPostStory();
        AppMethodBeat.m2505o(108928);
        return canPostStory;
    }

    public final C35169f getStoryBasicConfig() {
        return C29274a.rQZ;
    }

    public final boolean checkReportFromChatting(int i, String str) {
        AppMethodBeat.m2504i(108929);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(108929);
            return false;
        }
        String str2;
        Object obj;
        Object obj2;
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        C4119f aap = cxU.aap(str2);
        boolean cBN = aap.cBN();
        if (aap.cBL() > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        C35180c c35180c = C35180c.sbQ;
        C35180c.clean();
        C4116b c4116b = C4116b.sbw;
        C4116b.clean();
        c4116b = C4116b.sbw;
        if (str == null) {
            obj2 = "";
        } else {
            str2 = str;
        }
        C25052j.m39376p(obj2, "user");
        C4116b.m6434EV(i);
        C4116b.clean();
        C4116b.sbp = C5046bo.anU();
        boolean z = NetStatusUtil.isWifi(C4996ah.getContext()) || NetStatusUtil.is4G(C4996ah.getContext());
        C4116b.mgU = z;
        if (z) {
            C4990ab.m7416i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + obj2 + " isWifi:" + C4116b.mgU);
            C4116b.m6441l(C4116b.lhy, 1, 1);
        }
        if (i == 1) {
            c35180c = C35180c.sbQ;
            if (str == null) {
                obj2 = "";
            } else {
                str2 = str;
            }
            C25052j.m39376p(obj2, "user");
            C35180c.clean();
            C35180c.sbM = false;
            C35180c.sbH = new C35181a(obj2, 1);
            C4990ab.m7416i("MicroMsg.StoryBrowseIDKeyStat", "chattingRight ".concat(String.valueOf(obj2)));
            C7060h.pYm.mo15419k(988, 1, 1);
            if (cBN) {
                if (obj != null) {
                    c35180c = C35180c.sbQ;
                    C35180c.czT();
                } else {
                    c35180c = C35180c.sbQ;
                    if (str == null) {
                        str = "";
                    }
                    C35180c.aaN(str);
                }
            }
        } else if (i == 2) {
            c35180c = C35180c.sbQ;
            if (str == null) {
                obj2 = "";
            } else {
                str2 = str;
            }
            C25052j.m39376p(obj2, "user");
            C35180c.clean();
            C35180c.sbM = true;
            C35180c.sbH = new C35181a(obj2, 2);
            C4990ab.m7416i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheck ".concat(String.valueOf(obj2)));
            C7060h.pYm.mo15419k(988, 2, 1);
            if (cBN) {
                if (obj != null) {
                    c35180c = C35180c.sbQ;
                    C35180c.czU();
                } else {
                    c35180c = C35180c.sbQ;
                    if (str == null) {
                        str = "";
                    }
                    C35180c.aaO(str);
                }
            }
        }
        AppMethodBeat.m2505o(108929);
        return true;
    }

    public final void enterGallery(List<String> list) {
        AppMethodBeat.m2504i(108930);
        C25052j.m39376p(list, "unreadList");
        C35180c c35180c = C35180c.sbQ;
        C35180c.m57808dF(list);
        C4116b c4116b = C4116b.sbw;
        C4116b.m6439dF(list);
        AppMethodBeat.m2505o(108930);
    }

    public final void setPreviewEnterScene(long j) {
        AppMethodBeat.m2504i(108931);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20743bG(j);
        AppMethodBeat.m2505o(108931);
    }

    public final boolean preLoadVideoViewMgr(String str) {
        AppMethodBeat.m2504i(108932);
        C29380q c29380q = C29380q.srv;
        if (str == null) {
            str = "";
        }
        C29380q.abg(str);
        AppMethodBeat.m2505o(108932);
        return true;
    }

    public final C29272c getContactFetcher() {
        return C39895a.rWL;
    }

    public final void preloadForSnsUser(String str, boolean z) {
        AppMethodBeat.m2504i(108933);
        if (str == null) {
            AppMethodBeat.m2505o(108933);
            return;
        }
        int a;
        if (z) {
            a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_with_enter_sns, 1);
        } else {
            a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_with_change_sns, 0);
        }
        C4990ab.m7416i(TAG, "preloadForSnsUser: " + a + " isEnter: " + z + " username " + str + ' ' + C5046bo.dpG());
        if (a == 1) {
            C29290a c29290a = C39876h.rZx;
            C43640g bt = C29290a.m46505bt(str, false);
            if (bt != null) {
                C39933n c39933n = C39933n.sqi;
                C39933n.m68381dK(C25033k.listOf(bt.rVZ));
                AppMethodBeat.m2505o(108933);
                return;
            }
        }
        AppMethodBeat.m2505o(108933);
    }

    public final void reportWaitPlayList(List<String> list, long j) {
        AppMethodBeat.m2504i(108934);
        C25052j.m39376p(list, "userList");
        C22241k c22241k = C22241k.rTc;
        C22241k.reportWaitPlayList(list, j);
        AppMethodBeat.m2505o(108934);
    }

    public final boolean showStoryEntranceDialog(Context context, String str, int i) {
        AppMethodBeat.m2504i(108935);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(str, "sessionId");
        C22212h c22212h = C22212h.scu;
        C22212h.cAM().mo53177fw(str);
        c22212h = C22212h.scu;
        C22212h.cAM().mo53180gJ((int) System.currentTimeMillis());
        c22212h = C22212h.scu;
        c22212h = C22212h.scu;
        C22212h.m33891Fa(C22212h.cAM().mo53173FB());
        c22212h = C22212h.scu;
        C22212h.cAM().mo53181gK(i);
        C22266b c22266b = new C22266b(context);
        c22266b.setContentView(new C35238c(context, new C39862d(c22266b)));
        c22266b.show();
        AppMethodBeat.m2505o(108935);
        return true;
    }

    public final cfc getStoryUserInfo() {
        AppMethodBeat.m2504i(108936);
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        C4133a c4133a2 = C43644j.rST;
        cfc cBM = cxU.aap(C4133a.cnk()).cBM();
        if (cBM == null) {
            cBM = new cfc();
        }
        AppMethodBeat.m2505o(108936);
        return cBM;
    }

    public final void updateStoryUserInfo(String str, cfc cfc) {
        AppMethodBeat.m2504i(108937);
        C4133a c4133a = C43644j.rST;
        C29296g cxU = C4133a.cxU();
        if (str == null || cfc == null) {
            AppMethodBeat.m2505o(108937);
            return;
        }
        byte[] toByteArray;
        C4119f aap = cxU.aap(str);
        if (cfc != null) {
            toByteArray = cfc.toByteArray();
        } else {
            toByteArray = null;
        }
        aap.field_userInfo = toByteArray;
        cxU.mo47501b(aap);
        AppMethodBeat.m2505o(108937);
    }
}
