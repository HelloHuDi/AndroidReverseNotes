package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import java.util.HashMap;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryLogic;", "", "()V", "StoryServer", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.o */
public final class C22244o {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "", "()V", "timelineRespCount", "", "userRespCounts", "", "", "getHistoryResCount", "userName", "getResPCount", "getUserPageResCount", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.o$a */
    public static final class C22245a {
        public int qMA;
        private Map<String, Integer> qMz = new HashMap();

        public C22245a() {
            AppMethodBeat.m2504i(109134);
            AppMethodBeat.m2505o(109134);
        }

        public static int aaC(String str) {
            AppMethodBeat.m2504i(109133);
            C25052j.m39376p(str, "userName");
            C35184a c35184a = C35183a.sdm;
            int cAS = C35183a.scB;
            AppMethodBeat.m2505o(109133);
            return cAS;
        }
    }
}
