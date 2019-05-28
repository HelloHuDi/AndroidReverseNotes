package com.tencent.mm.plugin.story.g;

import a.f.b.j;
import a.l;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ad;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class i {
    public static final a scv = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static int aaR(String str) {
            AppMethodBeat.i(109848);
            j.p(str, "userName");
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(109848);
                return 0;
            }
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            if (j.j(com.tencent.mm.plugin.story.model.j.a.cnk(), str)) {
                AppMethodBeat.o(109848);
                return 1;
            }
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
            j.o(aoO, UserDataStore.CITY);
            if (aoO.Oc()) {
                AppMethodBeat.o(109848);
                return 3;
            } else if (aoO.NX()) {
                AppMethodBeat.o(109848);
                return 4;
            } else {
                AppMethodBeat.o(109848);
                return 5;
            }
        }

        public static long Fb(int i) {
            AppMethodBeat.i(109849);
            switch (i) {
                case 0:
                    AppMethodBeat.o(109849);
                    return 7;
                case 4:
                    AppMethodBeat.o(109849);
                    return 8;
                case 5:
                    h hVar = h.scu;
                    long FF = h.cAs().FF();
                    AppMethodBeat.o(109849);
                    return FF;
                case 6:
                    AppMethodBeat.o(109849);
                    return 9;
                default:
                    AppMethodBeat.o(109849);
                    return 0;
            }
        }
    }

    static {
        AppMethodBeat.i(109850);
        AppMethodBeat.o(109850);
    }
}
