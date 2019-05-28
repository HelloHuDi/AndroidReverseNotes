package com.tencent.p177mm.plugin.story.p530f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.api.C46269m.C29273a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p533d.C22232a;
import com.tencent.p177mm.plugin.story.model.p533d.C22233c;
import com.tencent.p177mm.plugin.story.model.p533d.C43638e;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.C0220l;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/GalleryPresenterFactory;", "", "()V", "getPresenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "dataSeed", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "", "isForSns", "", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.f */
public final class C39875f {
    public static final C39875f rZu = new C39875f();

    static {
        AppMethodBeat.m2504i(109577);
        AppMethodBeat.m2505o(109577);
    }

    private C39875f() {
    }

    /* renamed from: a */
    public static C39876h m68280a(Object obj, C43632e c43632e, C29273a c29273a, String str, boolean z) {
        AppMethodBeat.m2504i(109576);
        C25052j.m39376p(c43632e, "groupCallback");
        C25052j.m39376p(c29273a, "galleryType");
        C22212h c22212h;
        C39876h c43630d;
        if (obj instanceof C39864o) {
            Map map;
            List a = C43638e.m78106a((C39864o) obj);
            C39864o c39864o = (C39864o) obj;
            C25052j.m39376p(c39864o, "dataSeed");
            if (c39864o instanceof C22232a) {
                map = ((C22232a) c39864o).rVV;
            } else {
                map = new HashMap();
            }
            c22212h = C22212h.scu;
            C22212h.cAs().mo20754bR((long) a.size());
            if (obj instanceof C22233c) {
                c43630d = new C43630d(((C22233c) obj).username, a, c43632e);
                AppMethodBeat.m2505o(109576);
                return c43630d;
            }
            c43630d = new C22191i(a, null, c43632e, z, map);
            AppMethodBeat.m2505o(109576);
            return c43630d;
        }
        ArrayList arrayList;
        C22212h c22212h2;
        if (C7987l.listOf(C29273a.SelfGallery, C29273a.SelfTabGallery).contains(c29273a)) {
            if (obj instanceof String) {
                c22212h = C22212h.scu;
                C22212h.cAs().mo20754bR(1);
                c43630d = new C22197j((String) obj, c43632e);
                AppMethodBeat.m2505o(109576);
                return c43630d;
            }
        } else if (c29273a == C29273a.SingleGallery || c29273a == C29273a.ProfileGallery) {
            if (obj instanceof String) {
                arrayList = new ArrayList();
                arrayList.add(obj);
                c22212h2 = C22212h.scu;
                C22212h.cAs().mo20754bR((long) arrayList.size());
                c43630d = new C22191i(arrayList, str, c43632e, z);
                AppMethodBeat.m2505o(109576);
                return c43630d;
            }
        } else if (c29273a == C29273a.MultiUserGallery) {
            arrayList = new ArrayList();
            if (obj instanceof Collection) {
                for (Object next : (Iterable) obj) {
                    if (next instanceof String) {
                        arrayList.add(next);
                    }
                }
                c22212h2 = C22212h.scu;
                C22212h.cAs().mo20754bR((long) arrayList.size());
                c43630d = new C22191i(arrayList, str, c43632e, z);
                AppMethodBeat.m2505o(109576);
                return c43630d;
            }
        } else if (c29273a == C29273a.HistoryGallery) {
            ArrayList arrayList2 = new ArrayList();
            if (obj instanceof Collection) {
                for (Object next2 : (Iterable) obj) {
                    if (next2 instanceof String) {
                        arrayList2.add(next2);
                    }
                }
                C4133a c4133a = C43644j.rST;
                c43630d = new C22204k(C4133a.cnk(), arrayList2, c43632e);
                AppMethodBeat.m2505o(109576);
                return c43630d;
            }
        }
        Throwable runtimeException = new RuntimeException("Cannot handler dataSeed ".concat(String.valueOf(obj)));
        AppMethodBeat.m2505o(109576);
        throw runtimeException;
    }
}
