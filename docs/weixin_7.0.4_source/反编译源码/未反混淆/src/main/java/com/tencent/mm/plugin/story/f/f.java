package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.d.c;
import com.tencent.mm.plugin.story.model.d.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/GalleryPresenterFactory;", "", "()V", "getPresenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "dataSeed", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "", "isForSns", "", "plugin-story_release"})
public final class f {
    public static final f rZu = new f();

    static {
        AppMethodBeat.i(109577);
        AppMethodBeat.o(109577);
    }

    private f() {
    }

    public static h a(Object obj, e eVar, a aVar, String str, boolean z) {
        AppMethodBeat.i(109576);
        j.p(eVar, "groupCallback");
        j.p(aVar, "galleryType");
        h hVar;
        h dVar;
        if (obj instanceof o) {
            Map map;
            List a = e.a((o) obj);
            o oVar = (o) obj;
            j.p(oVar, "dataSeed");
            if (oVar instanceof com.tencent.mm.plugin.story.model.d.a) {
                map = ((com.tencent.mm.plugin.story.model.d.a) oVar).rVV;
            } else {
                map = new HashMap();
            }
            hVar = h.scu;
            h.cAs().bR((long) a.size());
            if (obj instanceof c) {
                dVar = new d(((c) obj).username, a, eVar);
                AppMethodBeat.o(109576);
                return dVar;
            }
            dVar = new i(a, null, eVar, z, map);
            AppMethodBeat.o(109576);
            return dVar;
        }
        ArrayList arrayList;
        h hVar2;
        if (a.a.l.listOf(a.SelfGallery, a.SelfTabGallery).contains(aVar)) {
            if (obj instanceof String) {
                hVar = h.scu;
                h.cAs().bR(1);
                dVar = new j((String) obj, eVar);
                AppMethodBeat.o(109576);
                return dVar;
            }
        } else if (aVar == a.SingleGallery || aVar == a.ProfileGallery) {
            if (obj instanceof String) {
                arrayList = new ArrayList();
                arrayList.add(obj);
                hVar2 = h.scu;
                h.cAs().bR((long) arrayList.size());
                dVar = new i(arrayList, str, eVar, z);
                AppMethodBeat.o(109576);
                return dVar;
            }
        } else if (aVar == a.MultiUserGallery) {
            arrayList = new ArrayList();
            if (obj instanceof Collection) {
                for (Object next : (Iterable) obj) {
                    if (next instanceof String) {
                        arrayList.add(next);
                    }
                }
                hVar2 = h.scu;
                h.cAs().bR((long) arrayList.size());
                dVar = new i(arrayList, str, eVar, z);
                AppMethodBeat.o(109576);
                return dVar;
            }
        } else if (aVar == a.HistoryGallery) {
            ArrayList arrayList2 = new ArrayList();
            if (obj instanceof Collection) {
                for (Object next2 : (Iterable) obj) {
                    if (next2 instanceof String) {
                        arrayList2.add(next2);
                    }
                }
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                dVar = new k(com.tencent.mm.plugin.story.model.j.a.cnk(), arrayList2, eVar);
                AppMethodBeat.o(109576);
                return dVar;
            }
        }
        Throwable runtimeException = new RuntimeException("Cannot handler dataSeed ".concat(String.valueOf(obj)));
        AppMethodBeat.o(109576);
        throw runtimeException;
    }
}
