package com.tencent.mm.plugin.story.model.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "storyOwner", "", "storyIds", "Ljava/util/HashMap;", "", "", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getStoryIds", "()Ljava/util/HashMap;", "getStoryOwner", "()Ljava/lang/String;", "toString", "plugin-story_release"})
public final class c {
    private final String rVl;
    final HashMap<Long, Integer> rXi;

    public /* synthetic */ c(String str) {
        this(str, new HashMap());
        AppMethodBeat.i(138796);
        AppMethodBeat.o(138796);
    }

    private c(String str, HashMap<Long, Integer> hashMap) {
        j.p(str, "storyOwner");
        j.p(hashMap, "storyIds");
        AppMethodBeat.i(138795);
        this.rVl = str;
        this.rXi = hashMap;
        AppMethodBeat.o(138795);
    }

    public final String toString() {
        AppMethodBeat.i(138794);
        String str = "StoryCommentReply[" + this.rVl + " : " + this.rXi + ']';
        AppMethodBeat.o(138794);
        return str;
    }
}
