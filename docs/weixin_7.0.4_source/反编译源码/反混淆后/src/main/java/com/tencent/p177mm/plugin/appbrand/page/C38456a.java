package com.tencent.p177mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C19617f;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.page.a */
public class C38456a extends C19617f {
    private static final C38456a iqA = new C384571();
    private static final HashMap<C6750i, C38456a> iqB = new HashMap();
    private final C6750i hrt;
    private Drawable iqC;
    private CharSequence iqD;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.a$a */
    public enum C2403a {
        NORMAL(-1, -1),
        LBS(C25738R.string.cu5, C25738R.drawable.avt),
        VOICE(C25738R.string.cu6, C25738R.drawable.avv),
        VIDEO(-1, C25738R.drawable.avu),
        LOADING(-1, -1);
        
        final int iqK;
        final int iqL;

        static {
            AppMethodBeat.m2505o(87026);
        }

        private C2403a(int i, int i2) {
            this.iqK = i;
            this.iqL = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.a$1 */
    static class C384571 extends C38456a {
        C384571() {
        }

        public final Context getContext() {
            AppMethodBeat.m2504i(87022);
            Context context = C4996ah.getContext();
            AppMethodBeat.m2505o(87022);
            return context;
        }

        /* renamed from: a */
        public final C2405a mo61145a(C2403a c2403a) {
            return ivi;
        }
    }

    /* synthetic */ C38456a() {
        this(null);
    }

    /* renamed from: b */
    static void m65056b(C44709u c44709u) {
        AppMethodBeat.m2504i(87027);
        C38456a z = C38456a.m65057z(c44709u.getRuntime());
        C38456a.m65054a(z.iqC, c44709u);
        C38456a.m65055a(z.iqD, c44709u);
        AppMethodBeat.m2505o(87027);
    }

    /* renamed from: z */
    public static C38456a m65057z(C6750i c6750i) {
        AppMethodBeat.m2504i(87028);
        C38456a c38456a;
        if (c6750i == null || c6750i.mFinished) {
            c38456a = iqA;
            AppMethodBeat.m2505o(87028);
            return c38456a;
        }
        c38456a = (C38456a) iqB.get(c6750i);
        if (c38456a == null) {
            c38456a = new C38456a(c6750i);
            iqB.put(c6750i, c38456a);
        }
        AppMethodBeat.m2505o(87028);
        return c38456a;
    }

    static {
        AppMethodBeat.m2504i(87036);
        AppMethodBeat.m2505o(87036);
    }

    private C38456a(final C6750i c6750i) {
        AppMethodBeat.m2504i(87029);
        this.hrt = c6750i;
        if (c6750i == null) {
            AppMethodBeat.m2505o(87029);
            return;
        }
        C33183g.m54274a(c6750i.mAppId, new C33186c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(87023);
                C38456a c38456a = (C38456a) C38456a.iqB.remove(c6750i);
                if (c38456a != null) {
                    c38456a.ivn.clear();
                }
                AppMethodBeat.m2505o(87023);
            }
        });
        AppMethodBeat.m2505o(87029);
    }

    public Context getContext() {
        AppMethodBeat.m2504i(87030);
        Activity context = this.hrt.getContext();
        AppMethodBeat.m2505o(87030);
        return context;
    }

    /* renamed from: q */
    public final void mo54077q(Drawable drawable) {
        AppMethodBeat.m2504i(87031);
        this.iqC = drawable;
        C38456a.m65054a(this.iqC, this.hrt.mo15032xT().getCurrentPageView());
        AppMethodBeat.m2505o(87031);
    }

    /* renamed from: a */
    private static void m65054a(Drawable drawable, C44709u c44709u) {
        AppMethodBeat.m2504i(87032);
        if (c44709u == null) {
            AppMethodBeat.m2505o(87032);
            return;
        }
        c44709u.getActionBar().getCapsuleBar().aKh().setLogo(drawable);
        AppMethodBeat.m2505o(87032);
    }

    /* renamed from: y */
    public final void mo54078y(CharSequence charSequence) {
        AppMethodBeat.m2504i(87033);
        this.iqD = charSequence;
        C38456a.m65055a(this.iqD, this.hrt.mo15032xT().getCurrentPageView());
        AppMethodBeat.m2505o(87033);
    }

    /* renamed from: a */
    private static void m65055a(CharSequence charSequence, C44709u c44709u) {
        AppMethodBeat.m2504i(87034);
        if (c44709u == null) {
            AppMethodBeat.m2505o(87034);
            return;
        }
        c44709u.mo71774z(charSequence);
        AppMethodBeat.m2505o(87034);
    }

    /* renamed from: a */
    public C2405a mo61145a(C2403a c2403a) {
        AppMethodBeat.m2504i(87035);
        int i = c2403a.iqK;
        int i2 = c2403a.iqL;
        C2405a aKh = super.aKh();
        aKh.setLogo(i2);
        aKh.mo6314pE(i);
        AppMethodBeat.m2505o(87035);
        return aKh;
    }
}
