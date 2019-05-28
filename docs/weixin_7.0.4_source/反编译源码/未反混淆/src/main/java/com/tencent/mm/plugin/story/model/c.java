package com.tencent.mm.plugin.story.model;

import a.f.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"})
public final class c {
    private static final String TAG = TAG;
    private static final LinkedList<WeakReference<com.tencent.mm.plugin.story.ui.view.gallery.l>> eow = new LinkedList();
    private static a rSc;
    public static final c rSd = new c();

    static {
        AppMethodBeat.i(109012);
        AppMethodBeat.o(109012);
    }

    private c() {
    }

    public static void a(com.tencent.mm.plugin.story.ui.view.gallery.l lVar) {
        Object obj;
        AppMethodBeat.i(109010);
        j.p(lVar, "ui");
        ab.i(TAG, "GalleryMgr register ".concat(String.valueOf(lVar)));
        for (Object next : eow) {
            if (j.j(lVar, (com.tencent.mm.plugin.story.ui.view.gallery.l) ((WeakReference) next).get())) {
                obj = next;
                break;
            }
        }
        obj = null;
        if (((WeakReference) obj) == null) {
            eow.add(new WeakReference(lVar));
        }
        if (eow.size() > 0) {
            a aVar = rSc;
            if (aVar != null) {
                ab.i(aVar.TAG, "cancel");
                aVar.qHJ = false;
                AppMethodBeat.o(109010);
                return;
            }
        }
        AppMethodBeat.o(109010);
    }

    public static void b(com.tencent.mm.plugin.story.ui.view.gallery.l lVar) {
        Object obj;
        AppMethodBeat.i(109011);
        j.p(lVar, "ui");
        for (Object next : eow) {
            if (j.j(lVar, (com.tencent.mm.plugin.story.ui.view.gallery.l) ((WeakReference) next).get())) {
                obj = next;
                break;
            }
        }
        obj = null;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference != null) {
            eow.remove(weakReference);
        }
        ab.i(TAG, "GalleryMgr unregister " + lVar + ' ' + eow.size());
        if (eow.size() <= 1) {
            a aVar = new a();
            rSc = aVar;
            b.a("cleanCacheFiles", (a) new b(aVar));
            AppMethodBeat.o(109011);
            return;
        }
        AppMethodBeat.o(109011);
    }
}
