package com.tencent.p177mm.plugin.story.p536ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.p532h.C22213h;
import com.tencent.p177mm.protocal.protobuf.cek;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "", "label", "", "storyInfos", "", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getStoryInfos", "()Ljava/util/List;", "toString", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.c */
public final class C29334c {
    final String label;
    final List<C22213h> sgn;

    public C29334c() {
        this(null, null, 3);
    }

    public C29334c(String str, List<C22213h> list) {
        C25052j.m39376p(str, "label");
        C25052j.m39376p(list, "storyInfos");
        AppMethodBeat.m2504i(110159);
        this.label = str;
        this.sgn = list;
        AppMethodBeat.m2505o(110159);
    }

    public /* synthetic */ C29334c(String str, List list, int i) {
        if ((i & 1) != 0) {
            str = "";
        }
        this(str, (i & 2) != 0 ? new ArrayList() : list);
        AppMethodBeat.m2504i(110160);
        AppMethodBeat.m2505o(110160);
    }

    public final String toString() {
        String str;
        AppMethodBeat.m2504i(110158);
        StringBuilder stringBuilder = new StringBuilder();
        for (C22213h c22213h : this.sgn) {
            cek cek;
            if (c22213h.rXz.cBR().xeA.wbK.size() > 0) {
                cek = (cek) c22213h.rXz.cBR().xeA.wbK.get(0);
            } else {
                cek = null;
            }
            StringBuilder append = new StringBuilder("\t[date=").append(c22213h.field_date).append(" localId=").append((int) c22213h.rXz.xDa).append(", storyId=").append(c22213h.rXz.field_storyID).append(", thumb=");
            if (cek != null) {
                str = cek.wEH;
            } else {
                str = null;
            }
            stringBuilder.append(append.append(str).append(", video=").append(cek != null ? cek.Url : null).append("]\n").toString());
        }
        str = "[" + this.label + "] \n " + stringBuilder;
        AppMethodBeat.m2505o(110158);
        return str;
    }
}
