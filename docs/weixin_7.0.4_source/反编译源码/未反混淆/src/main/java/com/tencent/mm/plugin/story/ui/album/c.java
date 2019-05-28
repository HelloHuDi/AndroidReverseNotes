package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.cek;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "", "label", "", "storyInfos", "", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getStoryInfos", "()Ljava/util/List;", "toString", "plugin-story_release"})
public final class c {
    final String label;
    final List<h> sgn;

    public c() {
        this(null, null, 3);
    }

    public c(String str, List<h> list) {
        j.p(str, "label");
        j.p(list, "storyInfos");
        AppMethodBeat.i(110159);
        this.label = str;
        this.sgn = list;
        AppMethodBeat.o(110159);
    }

    public /* synthetic */ c(String str, List list, int i) {
        if ((i & 1) != 0) {
            str = "";
        }
        this(str, (i & 2) != 0 ? new ArrayList() : list);
        AppMethodBeat.i(110160);
        AppMethodBeat.o(110160);
    }

    public final String toString() {
        String str;
        AppMethodBeat.i(110158);
        StringBuilder stringBuilder = new StringBuilder();
        for (h hVar : this.sgn) {
            cek cek;
            if (hVar.rXz.cBR().xeA.wbK.size() > 0) {
                cek = (cek) hVar.rXz.cBR().xeA.wbK.get(0);
            } else {
                cek = null;
            }
            StringBuilder append = new StringBuilder("\t[date=").append(hVar.field_date).append(" localId=").append((int) hVar.rXz.xDa).append(", storyId=").append(hVar.rXz.field_storyID).append(", thumb=");
            if (cek != null) {
                str = cek.wEH;
            } else {
                str = null;
            }
            stringBuilder.append(append.append(str).append(", video=").append(cek != null ? cek.Url : null).append("]\n").toString());
        }
        str = "[" + this.label + "] \n " + stringBuilder;
        AppMethodBeat.o(110158);
        return str;
    }
}
