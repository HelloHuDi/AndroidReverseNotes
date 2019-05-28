package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.story.model.C35199a.C22217b;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C35251l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.c */
public final class C29304c {
    private static final String TAG = TAG;
    private static final LinkedList<WeakReference<C35251l>> eow = new LinkedList();
    private static C35199a rSc;
    public static final C29304c rSd = new C29304c();

    static {
        AppMethodBeat.m2504i(109012);
        AppMethodBeat.m2505o(109012);
    }

    private C29304c() {
    }

    /* renamed from: a */
    public static void m46523a(C35251l c35251l) {
        Object obj;
        AppMethodBeat.m2504i(109010);
        C25052j.m39376p(c35251l, "ui");
        C4990ab.m7416i(TAG, "GalleryMgr register ".concat(String.valueOf(c35251l)));
        for (Object next : eow) {
            if (C25052j.m39373j(c35251l, (C35251l) ((WeakReference) next).get())) {
                obj = next;
                break;
            }
        }
        obj = null;
        if (((WeakReference) obj) == null) {
            eow.add(new WeakReference(c35251l));
        }
        if (eow.size() > 0) {
            C35199a c35199a = rSc;
            if (c35199a != null) {
                C4990ab.m7416i(c35199a.TAG, "cancel");
                c35199a.qHJ = false;
                AppMethodBeat.m2505o(109010);
                return;
            }
        }
        AppMethodBeat.m2505o(109010);
    }

    /* renamed from: b */
    public static void m46524b(C35251l c35251l) {
        Object obj;
        AppMethodBeat.m2504i(109011);
        C25052j.m39376p(c35251l, "ui");
        for (Object next : eow) {
            if (C25052j.m39373j(c35251l, (C35251l) ((WeakReference) next).get())) {
                obj = next;
                break;
            }
        }
        obj = null;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference != null) {
            eow.remove(weakReference);
        }
        C4990ab.m7416i(TAG, "GalleryMgr unregister " + c35251l + ' ' + eow.size());
        if (eow.size() <= 1) {
            C35199a c35199a = new C35199a();
            rSc = c35199a;
            C8902b.m16044a("cleanCacheFiles", (C31214a) new C22217b(c35199a));
            AppMethodBeat.m2505o(109011);
            return;
        }
        AppMethodBeat.m2505o(109011);
    }
}
