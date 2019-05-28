package com.tencent.p177mm.plugin.story.model.p533d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import java.util.LinkedList;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010$\u001a\u00020\u000fH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getCommentList", "()Ljava/util/LinkedList;", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isUnread", "", "()Z", "setUnread", "(Z)V", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "equals", "other", "toString", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.d.f */
public final class C43639f {
    public long rUJ;
    private String rVY;
    public boolean rVh;
    public String rVl = "";
    int rqw;
    public final LinkedList<C39889a> rrj = new LinkedList();

    public C43639f() {
        AppMethodBeat.m2504i(109311);
        AppMethodBeat.m2505o(109311);
    }

    public final String toString() {
        AppMethodBeat.m2504i(109309);
        String str = "StoryGalleryComment(fromUser='" + this.rVl + "', storyId=" + this.rUJ + ", commentType=" + this.rqw + ", commentUser=" + this.rVY + ", isUnread=" + this.rVh + ", commentList=" + this.rrj + ')';
        AppMethodBeat.m2505o(109309);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(109310);
        if (!(obj instanceof C43639f)) {
            AppMethodBeat.m2505o(109310);
            return false;
        } else if (this == obj) {
            AppMethodBeat.m2505o(109310);
            return true;
        } else if (this.rUJ == ((C43639f) obj).rUJ && this.rrj.size() == ((C43639f) obj).rrj.size()) {
            AppMethodBeat.m2505o(109310);
            return true;
        } else {
            AppMethodBeat.m2505o(109310);
            return false;
        }
    }
}
