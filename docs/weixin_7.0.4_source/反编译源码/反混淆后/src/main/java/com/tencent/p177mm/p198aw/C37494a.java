package com.tencent.p177mm.p198aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C45337kd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.List;

/* renamed from: com.tencent.mm.aw.a */
public final class C37494a {

    /* renamed from: com.tencent.mm.aw.a$1 */
    static class C12971 implements Runnable {
        C12971() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137232);
            C45337kd c45337kd = new C45337kd();
            c45337kd.cFz.action = 1;
            C4879a.xxA.mo10055m(c45337kd);
            AppMethodBeat.m2505o(137232);
        }
    }

    /* renamed from: com.tencent.mm.aw.a$2 */
    static class C12982 implements Runnable {
        C12982() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137233);
            C45337kd c45337kd = new C45337kd();
            c45337kd.cFz.action = 2;
            C4879a.xxA.mo10055m(c45337kd);
            AppMethodBeat.m2505o(137233);
        }
    }

    /* renamed from: com.tencent.mm.aw.a$3 */
    static class C12993 implements Runnable {
        C12993() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137234);
            C45337kd c45337kd = new C45337kd();
            c45337kd.cFz.action = -1;
            C4879a.xxA.mo10055m(c45337kd);
            AppMethodBeat.m2505o(137234);
        }
    }

    /* renamed from: com.tencent.mm.aw.a$4 */
    static class C13004 implements Runnable {
        C13004() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137235);
            C45337kd c45337kd = new C45337kd();
            c45337kd.cFz.action = 11;
            C4879a.xxA.mo10055m(c45337kd);
            AppMethodBeat.m2505o(137235);
        }
    }

    /* renamed from: com.tencent.mm.aw.a$9 */
    public static class C258469 implements Runnable {
        final /* synthetic */ List fJO;
        final /* synthetic */ boolean fJP = true;

        public C258469(List list) {
            this.fJO = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(137240);
            C45337kd c45337kd = new C45337kd();
            c45337kd.cFz.action = 5;
            c45337kd.cFz.cAV = this.fJO;
            c45337kd.cFz.cFD = this.fJP;
            C4879a.xxA.mo10055m(c45337kd);
            AppMethodBeat.m2505o(137240);
        }
    }

    /* renamed from: com.tencent.mm.aw.a$7 */
    public static class C374957 implements Runnable {
        final /* synthetic */ List fJM;
        final /* synthetic */ int fJN;

        public C374957(List list, int i) {
            this.fJM = list;
            this.fJN = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(137238);
            C45337kd c45337kd = new C45337kd();
            c45337kd.cFz.action = 0;
            c45337kd.cFz.cAV = this.fJM;
            c45337kd.cFz.cFC = this.fJN;
            C4879a.xxA.mo10055m(c45337kd);
            AppMethodBeat.m2505o(137238);
        }
    }

    /* renamed from: KX */
    public static final void m63277KX() {
        AppMethodBeat.m2504i(137241);
        C5004al.m7441d(new C12971());
        AppMethodBeat.m2505o(137241);
    }

    /* renamed from: KY */
    public static final void m63278KY() {
        AppMethodBeat.m2504i(137242);
        C5004al.m7441d(new C12982());
        AppMethodBeat.m2505o(137242);
    }

    public static final void aic() {
        AppMethodBeat.m2504i(137243);
        C5004al.m7441d(new C12993());
        AppMethodBeat.m2505o(137243);
    }

    public static final void aid() {
        AppMethodBeat.m2504i(137244);
        C5004al.m7441d(new C13004());
        AppMethodBeat.m2505o(137244);
    }

    /* renamed from: a */
    public static final void m63279a(final C9058e c9058e) {
        AppMethodBeat.m2504i(137245);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(137236);
                C45337kd c45337kd = new C45337kd();
                c45337kd.cFz.action = 6;
                c45337kd.cFz.cFB = c9058e;
                C4879a.xxA.mo10055m(c45337kd);
                AppMethodBeat.m2505o(137236);
            }
        });
        AppMethodBeat.m2505o(137245);
    }

    public static boolean aie() {
        AppMethodBeat.m2504i(137246);
        C45337kd c45337kd = new C45337kd();
        c45337kd.cFz.action = -3;
        C4879a.xxA.mo10055m(c45337kd);
        boolean z = c45337kd.cFA.csN;
        AppMethodBeat.m2505o(137246);
        return z;
    }

    public static boolean aif() {
        AppMethodBeat.m2504i(137247);
        C45337kd c45337kd = new C45337kd();
        c45337kd.cFz.action = 10;
        C4879a.xxA.mo10055m(c45337kd);
        boolean z = c45337kd.cFA.csN;
        AppMethodBeat.m2505o(137247);
        return z;
    }

    public static boolean aig() {
        AppMethodBeat.m2504i(137248);
        C45337kd c45337kd = new C45337kd();
        c45337kd.cFz.action = 9;
        C4879a.xxA.mo10055m(c45337kd);
        boolean z = c45337kd.cFA.csN;
        AppMethodBeat.m2505o(137248);
        return z;
    }

    public static C9058e aih() {
        AppMethodBeat.m2504i(137249);
        C45337kd c45337kd = new C45337kd();
        c45337kd.cFz.action = -2;
        C4879a.xxA.mo10055m(c45337kd);
        C9058e c9058e = c45337kd.cFA.cFB;
        AppMethodBeat.m2505o(137249);
        return c9058e;
    }

    /* renamed from: b */
    public static void m63280b(final C9058e c9058e) {
        AppMethodBeat.m2504i(137250);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(137237);
                C45337kd c45337kd = new C45337kd();
                c45337kd.cFz.action = 0;
                c45337kd.cFz.cFB = c9058e;
                C4879a.xxA.mo10055m(c45337kd);
                AppMethodBeat.m2505o(137237);
            }
        });
        AppMethodBeat.m2505o(137250);
    }

    /* renamed from: c */
    public static void m63281c(final C9058e c9058e) {
        AppMethodBeat.m2504i(137251);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(137239);
                C45337kd c45337kd = new C45337kd();
                c45337kd.cFz.action = 3;
                c45337kd.cFz.cFB = c9058e;
                C4879a.xxA.mo10055m(c45337kd);
                AppMethodBeat.m2505o(137239);
            }
        });
        AppMethodBeat.m2505o(137251);
    }

    /* renamed from: d */
    public static boolean m63282d(C9058e c9058e) {
        if (c9058e == null) {
            return false;
        }
        switch (c9058e.fJS) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: lP */
    public static boolean m63283lP(int i) {
        AppMethodBeat.m2504i(137252);
        C45337kd c45337kd = new C45337kd();
        c45337kd.cFz.action = 7;
        c45337kd.cFz.position = i;
        C4879a.xxA.mo10055m(c45337kd);
        boolean z = c45337kd.cFA.csN;
        AppMethodBeat.m2505o(137252);
        return z;
    }

    public static C37496c aii() {
        AppMethodBeat.m2504i(137253);
        C45337kd c45337kd = new C45337kd();
        c45337kd.cFz.action = 8;
        C4879a.xxA.mo10055m(c45337kd);
        C37496c c37496c = c45337kd.cFA.cFF;
        AppMethodBeat.m2505o(137253);
        return c37496c;
    }
}
