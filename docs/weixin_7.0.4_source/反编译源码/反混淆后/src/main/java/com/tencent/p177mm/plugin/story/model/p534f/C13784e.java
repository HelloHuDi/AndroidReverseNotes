package com.tencent.p177mm.plugin.story.model.p534f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.story.api.C29269k;
import p000a.C0220l;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcherFactory;", "", "()V", "getFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.f.e */
public final class C13784e {
    public static final C13784e rXx = new C13784e();

    static {
        AppMethodBeat.m2504i(109426);
        AppMethodBeat.m2505o(109426);
    }

    private C13784e() {
    }

    public static C29269k aaM(String str) {
        AppMethodBeat.m2504i(109425);
        CharSequence charSequence = str;
        Object obj = (charSequence == null || C6163u.m9837ar(charSequence)) ? 1 : null;
        C29269k c31431d;
        if (obj != null) {
            AppMethodBeat.m2505o(109425);
            return null;
        } else if (C1855t.m3902mO(str)) {
            c31431d = new C31431d(str);
            AppMethodBeat.m2505o(109425);
            return c31431d;
        } else {
            c31431d = new C46283b(str);
            AppMethodBeat.m2505o(109425);
            return c31431d;
        }
    }
}
