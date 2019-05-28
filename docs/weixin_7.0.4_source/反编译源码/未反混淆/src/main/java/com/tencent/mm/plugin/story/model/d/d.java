package com.tencent.mm.plugin.story.model.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.api.o.a;
import com.tencent.mm.plugin.story.api.o.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b0\tH\u0016J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "createFavDataSeed", "dateList", "username", "genKey", "plugin-story_release"})
public final class d implements b {
    public static final d rVX = new d();

    static {
        AppMethodBeat.i(109307);
        AppMethodBeat.o(109307);
    }

    private d() {
    }

    public final long c(List<String> list, Map<String, ? extends ArrayList<Long>> map) {
        AppMethodBeat.i(138769);
        j.p(list, "userList");
        j.p(map, "filterList");
        a aVar = new a(cb.aaE(), list, map);
        a.cxg().a(aVar.key, aVar);
        long j = aVar.key;
        AppMethodBeat.o(138769);
        return j;
    }

    public final long i(List<String> list, String str) {
        AppMethodBeat.i(109306);
        j.p(list, "dateList");
        j.p(str, "username");
        c cVar = new c(cb.aaE(), list, str);
        a.cxg().a(cVar.key, cVar);
        long j = cVar.key;
        AppMethodBeat.o(109306);
        return j;
    }
}
