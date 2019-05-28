package com.tencent.p177mm.plugin.story.model.p533d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.api.C39864o;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/FavStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "dateList", "", "", "username", "(JLjava/util/List;Ljava/lang/String;)V", "getDateList", "()Ljava/util/List;", "getUsername", "()Ljava/lang/String;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.d.c */
public final class C22233c extends C39864o {
    final List<String> rVW;
    public final String username;

    public C22233c(long j, List<String> list, String str) {
        C25052j.m39376p(list, "dateList");
        C25052j.m39376p(str, "username");
        super(j);
        AppMethodBeat.m2504i(109304);
        this.rVW = list;
        this.username = str;
        AppMethodBeat.m2505o(109304);
    }
}
