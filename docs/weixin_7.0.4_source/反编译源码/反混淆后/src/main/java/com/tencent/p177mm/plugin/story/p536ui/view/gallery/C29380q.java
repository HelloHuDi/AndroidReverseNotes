package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g.C4126a;
import com.tencent.p177mm.plugin.story.p531g.C35180c;
import com.tencent.p177mm.plugin.story.p531g.C4116b;
import com.tencent.p177mm.plugin.story.p531g.C4116b.C4117a;
import com.tencent.p177mm.plugin.story.p531g.C4116b.C4118b;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", "username", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.q */
public final class C29380q {
    private static List<C22319p> sru = Collections.synchronizedList(new LinkedList());
    public static final C29380q srv = new C29380q();

    static {
        AppMethodBeat.m2504i(111005);
        AppMethodBeat.m2505o(111005);
    }

    private C29380q() {
    }

    public static boolean abg(String str) {
        AppMethodBeat.m2504i(111002);
        C25052j.m39376p(str, "username");
        C4990ab.m7416i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + str + " pool " + sru.size());
        C22241k c22241k;
        C22319p c22319p;
        if (sru.size() > 0) {
            c22241k = C22241k.rTc;
            C4119f aap = C22241k.aap(str);
            if (aap.isValid()) {
                C4126a c4126a = C43640g.rWe;
                C43640g a = C4126a.m6451a(aap);
                List list = sru;
                C25052j.m39375o(list, "pool");
                c22319p = (C22319p) C25035t.m39338fK(list);
                if (c22319p != null) {
                    c22319p.mo37862o(a.rVZ);
                }
            }
            AppMethodBeat.m2505o(111002);
            return false;
        }
        c22241k = C22241k.rTc;
        C4119f aap2 = C22241k.aap(str);
        C35180c c35180c = C35180c.sbQ;
        C35180c.m57809lj(aap2.field_syncId);
        C4116b c4116b = C4116b.sbw;
        C4116b.m6442lj(aap2.field_syncId);
        if (aap2.cBL() > 0) {
            c4116b = C4116b.sbw;
            C4116b.czQ();
        }
        if (aap2.isValid()) {
            C4126a c4126a2 = C43640g.rWe;
            C43640g a2 = C4126a.m6451a(aap2);
            c4116b = C4116b.sbw;
            C25052j.m39376p(a2, "galleryItem");
            C25052j.m39376p(aap2, Constants.EXTINFO);
            C4116b.sbn = a2;
            C4116b.sbj = new C4117a(aap2.getUserName(), C4118b.PLAY);
            C4117a c4117a;
            if (aap2.cBL() > 0) {
                C4116b.m6441l(C4116b.lhy, 4, 1);
                c4117a = C4116b.sbj;
                if (c4117a != null) {
                    c4117a.koC = false;
                    c4117a.sbB = C5046bo.anU();
                }
            } else {
                c4117a = C4116b.sbj;
                if (c4117a != null) {
                    c4117a.koC = true;
                    c4117a.sbB = C5046bo.anU();
                }
            }
            if (a2.rVZ != null) {
                if (aap2.cBN()) {
                    C4116b.m6441l(C4116b.lhy, 140, 1);
                    if (aap2.cBL() > 0) {
                        C4116b.m6441l(C4116b.lhy, 142, 1);
                    }
                }
                if (C4116b.m6438c(a2.rVZ) == 1) {
                    C4116b.m6441l(C4116b.lhy, 5, 1);
                    if (aap2.cBN()) {
                        C4116b.m6441l(C4116b.lhy, 141, 1);
                    }
                }
            }
            c22319p = new C22319p();
            if (c22319p.sqW == null) {
                Context context = C4996ah.getContext();
                C25052j.m39375o(context, "MMApplicationContext.getContext()");
                c22319p.mo37861eX(context);
            }
            c22319p.setMute(true);
            c22319p.mo37862o(a2.rVZ);
            c22319p.cDe();
            sru.add(c22319p);
            AppMethodBeat.m2505o(111002);
            return true;
        }
        AppMethodBeat.m2505o(111002);
        return false;
    }

    public static C22319p cDg() {
        AppMethodBeat.m2504i(111003);
        C4990ab.m7416i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + sru.size());
        List list = sru;
        C25052j.m39375o(list, "pool");
        C22319p c22319p = (C22319p) C25035t.m39338fK(list);
        if (c22319p != null) {
            sru.remove(c22319p);
        }
        AppMethodBeat.m2505o(111003);
        return c22319p;
    }

    public static void clean() {
        AppMethodBeat.m2504i(111004);
        C4990ab.m7416i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + sru.size());
        List<C22319p> list = sru;
        C25052j.m39375o(list, "pool");
        for (C22319p c22319p : list) {
            StoryVideoView storyVideoView = c22319p.sqW;
            if (storyVideoView != null) {
                storyVideoView.stop();
            }
        }
        sru.clear();
        AppMethodBeat.m2505o(111004);
    }
}
