package com.tencent.p177mm.plugin.story.model.p533d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.api.C39864o;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a*\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, dWq = {"getGalleryFilterList", "", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "dataSeed", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "getGalleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "getGalleryUserList", "", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.d.e */
public final class C43638e {
    /* renamed from: a */
    public static final List<String> m78106a(C39864o c39864o) {
        AppMethodBeat.m2504i(109308);
        C25052j.m39376p(c39864o, "dataSeed");
        List<String> list;
        if (c39864o instanceof C29305b) {
            List list2 = ((C29305b) c39864o).fxt;
            AppMethodBeat.m2505o(109308);
            return list2;
        } else if (c39864o instanceof C22232a) {
            list = ((C22232a) c39864o).fxt;
            AppMethodBeat.m2505o(109308);
            return list;
        } else if (c39864o instanceof C22233c) {
            list = ((C22233c) c39864o).rVW;
            AppMethodBeat.m2505o(109308);
            return list;
        } else {
            list = new ArrayList();
            AppMethodBeat.m2505o(109308);
            return list;
        }
    }
}
