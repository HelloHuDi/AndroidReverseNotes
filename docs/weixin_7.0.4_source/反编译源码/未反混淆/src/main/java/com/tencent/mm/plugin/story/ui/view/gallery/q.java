package com.tencent.mm.plugin.story.ui.view.gallery;

import a.a.t;
import a.f.b.j;
import a.l;
import android.content.Context;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.b;
import com.tencent.mm.plugin.story.g.c;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.g.a;
import com.tencent.mm.plugin.story.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
public final class q {
    private static List<p> sru = Collections.synchronizedList(new LinkedList());
    public static final q srv = new q();

    static {
        AppMethodBeat.i(111005);
        AppMethodBeat.o(111005);
    }

    private q() {
    }

    public static boolean abg(String str) {
        AppMethodBeat.i(111002);
        j.p(str, "username");
        ab.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + str + " pool " + sru.size());
        k kVar;
        p pVar;
        if (sru.size() > 0) {
            kVar = k.rTc;
            f aap = k.aap(str);
            if (aap.isValid()) {
                a aVar = g.rWe;
                g a = a.a(aap);
                List list = sru;
                j.o(list, "pool");
                pVar = (p) t.fK(list);
                if (pVar != null) {
                    pVar.o(a.rVZ);
                }
            }
            AppMethodBeat.o(111002);
            return false;
        }
        kVar = k.rTc;
        f aap2 = k.aap(str);
        c cVar = c.sbQ;
        c.lj(aap2.field_syncId);
        b bVar = b.sbw;
        b.lj(aap2.field_syncId);
        if (aap2.cBL() > 0) {
            bVar = b.sbw;
            b.czQ();
        }
        if (aap2.isValid()) {
            a aVar2 = g.rWe;
            g a2 = a.a(aap2);
            bVar = b.sbw;
            j.p(a2, "galleryItem");
            j.p(aap2, Constants.EXTINFO);
            b.sbn = a2;
            b.sbj = new b.a(aap2.getUserName(), b.b.PLAY);
            b.a aVar3;
            if (aap2.cBL() > 0) {
                b.l(b.lhy, 4, 1);
                aVar3 = b.sbj;
                if (aVar3 != null) {
                    aVar3.koC = false;
                    aVar3.sbB = bo.anU();
                }
            } else {
                aVar3 = b.sbj;
                if (aVar3 != null) {
                    aVar3.koC = true;
                    aVar3.sbB = bo.anU();
                }
            }
            if (a2.rVZ != null) {
                if (aap2.cBN()) {
                    b.l(b.lhy, 140, 1);
                    if (aap2.cBL() > 0) {
                        b.l(b.lhy, 142, 1);
                    }
                }
                if (b.c(a2.rVZ) == 1) {
                    b.l(b.lhy, 5, 1);
                    if (aap2.cBN()) {
                        b.l(b.lhy, 141, 1);
                    }
                }
            }
            pVar = new p();
            if (pVar.sqW == null) {
                Context context = ah.getContext();
                j.o(context, "MMApplicationContext.getContext()");
                pVar.eX(context);
            }
            pVar.setMute(true);
            pVar.o(a2.rVZ);
            pVar.cDe();
            sru.add(pVar);
            AppMethodBeat.o(111002);
            return true;
        }
        AppMethodBeat.o(111002);
        return false;
    }

    public static p cDg() {
        AppMethodBeat.i(111003);
        ab.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + sru.size());
        List list = sru;
        j.o(list, "pool");
        p pVar = (p) t.fK(list);
        if (pVar != null) {
            sru.remove(pVar);
        }
        AppMethodBeat.o(111003);
        return pVar;
    }

    public static void clean() {
        AppMethodBeat.i(111004);
        ab.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + sru.size());
        List<p> list = sru;
        j.o(list, "pool");
        for (p pVar : list) {
            StoryVideoView storyVideoView = pVar.sqW;
            if (storyVideoView != null) {
                storyVideoView.stop();
            }
        }
        sru.clear();
        AppMethodBeat.o(111004);
    }
}
