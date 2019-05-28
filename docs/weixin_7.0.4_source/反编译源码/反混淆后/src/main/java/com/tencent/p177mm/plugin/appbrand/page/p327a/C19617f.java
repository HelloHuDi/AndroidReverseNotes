package com.tencent.p177mm.plugin.appbrand.page.p327a;

import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.C0380b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.page.a.f */
public abstract class C19617f extends C44705a {
    public final LinkedList<C19619a> ivn = new C196181();

    /* renamed from: com.tencent.mm.plugin.appbrand.page.a.f$1 */
    class C196181 extends LinkedList<C19619a> {
        C196181() {
        }

        public final boolean remove(Object obj) {
            AppMethodBeat.m2504i(87352);
            boolean remove = super.remove(obj);
            C19617f.m30416a(C19617f.this);
            AppMethodBeat.m2505o(87352);
            return remove;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.a.f$a */
    protected final class C19619a implements C2405a {
        /* renamed from: IV */
        CharSequence f4354IV = null;
        Drawable mDrawable = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.page.a.f$a$5 */
        class C106585 implements Runnable {
            C106585() {
            }

            public final void run() {
                AppMethodBeat.m2504i(87357);
                C19617f.this.ivn.remove(C19619a.this);
                AppMethodBeat.m2505o(87357);
            }
        }

        protected C19619a() {
        }

        public final void setLogo(final Drawable drawable) {
            AppMethodBeat.m2504i(87358);
            C45673m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87353);
                    C19619a.this.mDrawable = drawable;
                    if (C19619a.m30418a(C19619a.this)) {
                        C19617f.this.mo54077q(C19619a.this.mDrawable);
                    }
                    AppMethodBeat.m2505o(87353);
                }
            });
            AppMethodBeat.m2505o(87358);
        }

        public final void setLogo(final int i) {
            AppMethodBeat.m2504i(87359);
            C45673m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87354);
                    try {
                        C19619a.this.setLogo(C0380b.m649g(C19617f.this.getContext(), i));
                        AppMethodBeat.m2505o(87354);
                    } catch (NotFoundException e) {
                        C19619a.this.setLogo(null);
                        AppMethodBeat.m2505o(87354);
                    }
                }
            });
            AppMethodBeat.m2505o(87359);
        }

        public final void setDescription(final CharSequence charSequence) {
            AppMethodBeat.m2504i(87360);
            C45673m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87355);
                    C19619a.this.f4354IV = charSequence;
                    if (C19619a.m30418a(C19619a.this)) {
                        C19617f.this.mo54078y(charSequence);
                    }
                    AppMethodBeat.m2505o(87355);
                }
            });
            AppMethodBeat.m2505o(87360);
        }

        /* renamed from: pE */
        public final void mo6314pE(final int i) {
            AppMethodBeat.m2504i(87361);
            C45673m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87356);
                    try {
                        C19619a.this.setDescription(C19617f.this.getContext().getResources().getString(i));
                        AppMethodBeat.m2505o(87356);
                    } catch (NotFoundException e) {
                        C19619a.this.setDescription(null);
                        AppMethodBeat.m2505o(87356);
                    }
                }
            });
            AppMethodBeat.m2505o(87361);
        }

        public final void dismiss() {
            AppMethodBeat.m2504i(87362);
            C45673m.runOnUiThread(new C106585());
            AppMethodBeat.m2505o(87362);
        }

        /* renamed from: a */
        static /* synthetic */ boolean m30418a(C19619a c19619a) {
            AppMethodBeat.m2504i(87363);
            if (C19617f.this.ivn.peekFirst() == c19619a) {
                AppMethodBeat.m2505o(87363);
                return true;
            }
            AppMethodBeat.m2505o(87363);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m30416a(C19617f c19617f) {
        CharSequence charSequence;
        Drawable drawable = null;
        C19619a c19619a = (C19619a) c19617f.ivn.peekFirst();
        if (c19619a == null) {
            charSequence = null;
        } else {
            charSequence = c19619a.f4354IV;
        }
        c19617f.mo54078y(charSequence);
        if (c19619a != null) {
            drawable = c19619a.mDrawable;
        }
        c19617f.mo54077q(drawable);
    }

    public final void destroy() {
        this.ivn.clear();
    }

    public final C2405a aKh() {
        C19619a c19619a = new C19619a();
        this.ivn.addFirst(c19619a);
        return c19619a;
    }
}
