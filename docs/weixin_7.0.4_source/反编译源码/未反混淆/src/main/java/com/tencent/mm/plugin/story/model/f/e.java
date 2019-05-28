package com.tencent.mm.plugin.story.model.f;

import a.k.u;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.k;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcherFactory;", "", "()V", "getFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "", "plugin-story_release"})
public final class e {
    public static final e rXx = new e();

    static {
        AppMethodBeat.i(109426);
        AppMethodBeat.o(109426);
    }

    private e() {
    }

    public static k aaM(String str) {
        AppMethodBeat.i(109425);
        CharSequence charSequence = str;
        Object obj = (charSequence == null || u.ar(charSequence)) ? 1 : null;
        k dVar;
        if (obj != null) {
            AppMethodBeat.o(109425);
            return null;
        } else if (t.mO(str)) {
            dVar = new d(str);
            AppMethodBeat.o(109425);
            return dVar;
        } else {
            dVar = new b(str);
            AppMethodBeat.o(109425);
            return dVar;
        }
    }
}
