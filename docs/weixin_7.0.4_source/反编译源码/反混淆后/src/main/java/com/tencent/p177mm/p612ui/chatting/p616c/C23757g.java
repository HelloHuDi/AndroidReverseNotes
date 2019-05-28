package com.tencent.p177mm.p612ui.chatting.p616c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a.C15589a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.c.g */
public final class C23757g {
    private static Class[] yOI = new Class[]{C40741t.class, C30482q.class, C44812c.class, C23712ae.class, C23725ap.class, C23755f.class, C23719ao.class, C36128ac.class, C30464am.class, C30479o.class, C23740e.class, C44803aj.class, C41342aa.class, C44809as.class, C46648j.class, C36155u.class, C36152s.class, C44816k.class, C44806ar.class, C15598ag.class, C5332z.class, C24951an.class, C44810b.class, C44801ah.class, C5328y.class, C46649m.class, C31492ad.class, C44802ai.class, C15622n.class, C44805aq.class, C36131af.class, C36126ab.class, C23760p.class, C44815d.class, C40736r.class, C40717al.class};
    private static List<C23758a> yOJ;

    /* renamed from: com.tencent.mm.ui.chatting.c.g$a */
    public static class C23758a {
        public Class<? extends C5326v> aIl;
        public Class<? extends C5326v> yOK;

        public C23758a(Class<? extends C5326v> cls, Class<? extends C5326v> cls2) {
            this.aIl = cls;
            this.yOK = cls2;
        }

        public final C5326v dDK() {
            AppMethodBeat.m2504i(31287);
            try {
                C5326v c5326v = (C5326v) this.yOK.newInstance();
                AppMethodBeat.m2505o(31287);
                return c5326v;
            } catch (InstantiationException e) {
                C4990ab.printErrStackTrace("ChattingComponentFactory", e, "", new Object[0]);
                AppMethodBeat.m2505o(31287);
                return null;
            } catch (IllegalAccessException e2) {
                C4990ab.printErrStackTrace("ChattingComponentFactory", e2, "", new Object[0]);
                AppMethodBeat.m2505o(31287);
                return null;
            }
        }
    }

    public static List<C23758a> getComponents() {
        AppMethodBeat.m2504i(31288);
        if (yOJ == null) {
            yOJ = new LinkedList();
            for (Class cls : yOI) {
                if (cls.isAnnotationPresent(C15590a.class)) {
                    C15590a c15590a = (C15590a) cls.getAnnotation(C15590a.class);
                    if (c15590a.dFp() == C15589a.class) {
                        yOJ.add(new C23758a(cls, cls));
                    } else {
                        yOJ.add(new C23758a(c15590a.dFp(), cls));
                    }
                } else {
                    yOJ.add(new C23758a(cls, cls));
                }
            }
        }
        List list = yOJ;
        AppMethodBeat.m2505o(31288);
        return list;
    }
}
