package com.tencent.p177mm.plugin.story.model.p533d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.plugin.story.api.C39864o.C35172a;
import com.tencent.p177mm.plugin.story.api.C39864o.C35173b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b0\tH\u0016J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "createFavDataSeed", "dateList", "username", "genKey", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.d.d */
public final class C43637d implements C35173b {
    public static final C43637d rVX = new C43637d();

    static {
        AppMethodBeat.m2504i(109307);
        AppMethodBeat.m2505o(109307);
    }

    private C43637d() {
    }

    /* renamed from: c */
    public final long mo55836c(List<String> list, Map<String, ? extends ArrayList<Long>> map) {
        AppMethodBeat.m2504i(138769);
        C25052j.m39376p(list, "userList");
        C25052j.m39376p(map, "filterList");
        C22232a c22232a = new C22232a(C1839cb.aaE(), list, map);
        C35172a.cxg().mo55834a(c22232a.key, c22232a);
        long j = c22232a.key;
        AppMethodBeat.m2505o(138769);
        return j;
    }

    /* renamed from: i */
    public final long mo55837i(List<String> list, String str) {
        AppMethodBeat.m2504i(109306);
        C25052j.m39376p(list, "dateList");
        C25052j.m39376p(str, "username");
        C22233c c22233c = new C22233c(C1839cb.aaE(), list, str);
        C35172a.cxg().mo55834a(c22233c.key, c22233c);
        long j = c22233c.key;
        AppMethodBeat.m2505o(109306);
        return j;
    }
}
