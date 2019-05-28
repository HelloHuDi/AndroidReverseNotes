package com.tencent.p177mm.plugin.story.p531g;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.storage.C7616ad;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil;", "", "()V", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.g.i */
public final class C29293i {
    public static final C29294a scv = new C29294a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.g.i$a */
    public static final class C29294a {
        private C29294a() {
        }

        public /* synthetic */ C29294a(byte b) {
            this();
        }

        public static int aaR(String str) {
            AppMethodBeat.m2504i(109848);
            C25052j.m39376p(str, "userName");
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.m2505o(109848);
                return 0;
            }
            C4133a c4133a = C43644j.rST;
            if (C25052j.m39373j(C4133a.cnk(), str)) {
                AppMethodBeat.m2505o(109848);
                return 1;
            }
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            C25052j.m39375o(aoO, UserDataStore.CITY);
            if (aoO.mo16700Oc()) {
                AppMethodBeat.m2505o(109848);
                return 3;
            } else if (aoO.mo16693NX()) {
                AppMethodBeat.m2505o(109848);
                return 4;
            } else {
                AppMethodBeat.m2505o(109848);
                return 5;
            }
        }

        /* renamed from: Fb */
        public static long m46511Fb(int i) {
            AppMethodBeat.m2504i(109849);
            switch (i) {
                case 0:
                    AppMethodBeat.m2505o(109849);
                    return 7;
                case 4:
                    AppMethodBeat.m2505o(109849);
                    return 8;
                case 5:
                    C22212h c22212h = C22212h.scu;
                    long FF = C22212h.cAs().mo20732FF();
                    AppMethodBeat.m2505o(109849);
                    return FF;
                case 6:
                    AppMethodBeat.m2505o(109849);
                    return 9;
                default:
                    AppMethodBeat.m2505o(109849);
                    return 0;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(109850);
        AppMethodBeat.m2505o(109850);
    }
}
