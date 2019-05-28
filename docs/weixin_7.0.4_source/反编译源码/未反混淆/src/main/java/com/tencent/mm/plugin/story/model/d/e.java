package com.tencent.mm.plugin.story.model.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a*\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, dWq = {"getGalleryFilterList", "", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "dataSeed", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "getGalleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "getGalleryUserList", "", "plugin-story_release"})
public final class e {
    public static final List<String> a(o oVar) {
        AppMethodBeat.i(109308);
        j.p(oVar, "dataSeed");
        List<String> list;
        if (oVar instanceof b) {
            List list2 = ((b) oVar).fxt;
            AppMethodBeat.o(109308);
            return list2;
        } else if (oVar instanceof a) {
            list = ((a) oVar).fxt;
            AppMethodBeat.o(109308);
            return list;
        } else if (oVar instanceof c) {
            list = ((c) oVar).rVW;
            AppMethodBeat.o(109308);
            return list;
        } else {
            list = new ArrayList();
            AppMethodBeat.o(109308);
            return list;
        }
    }
}
