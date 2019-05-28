package com.tencent.mm.plugin.appbrand.page.a;

import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.m;
import java.util.LinkedList;

public abstract class f extends a {
    public final LinkedList<a> ivn = new LinkedList<a>() {
        public final boolean remove(Object obj) {
            AppMethodBeat.i(87352);
            boolean remove = super.remove(obj);
            f.a(f.this);
            AppMethodBeat.o(87352);
            return remove;
        }
    };

    protected final class a implements com.tencent.mm.plugin.appbrand.page.a.c.a {
        CharSequence IV = null;
        Drawable mDrawable = null;

        protected a() {
        }

        public final void setLogo(final Drawable drawable) {
            AppMethodBeat.i(87358);
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87353);
                    a.this.mDrawable = drawable;
                    if (a.a(a.this)) {
                        f.this.q(a.this.mDrawable);
                    }
                    AppMethodBeat.o(87353);
                }
            });
            AppMethodBeat.o(87358);
        }

        public final void setLogo(final int i) {
            AppMethodBeat.i(87359);
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87354);
                    try {
                        a.this.setLogo(b.g(f.this.getContext(), i));
                        AppMethodBeat.o(87354);
                    } catch (NotFoundException e) {
                        a.this.setLogo(null);
                        AppMethodBeat.o(87354);
                    }
                }
            });
            AppMethodBeat.o(87359);
        }

        public final void setDescription(final CharSequence charSequence) {
            AppMethodBeat.i(87360);
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87355);
                    a.this.IV = charSequence;
                    if (a.a(a.this)) {
                        f.this.y(charSequence);
                    }
                    AppMethodBeat.o(87355);
                }
            });
            AppMethodBeat.o(87360);
        }

        public final void pE(final int i) {
            AppMethodBeat.i(87361);
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87356);
                    try {
                        a.this.setDescription(f.this.getContext().getResources().getString(i));
                        AppMethodBeat.o(87356);
                    } catch (NotFoundException e) {
                        a.this.setDescription(null);
                        AppMethodBeat.o(87356);
                    }
                }
            });
            AppMethodBeat.o(87361);
        }

        public final void dismiss() {
            AppMethodBeat.i(87362);
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87357);
                    f.this.ivn.remove(a.this);
                    AppMethodBeat.o(87357);
                }
            });
            AppMethodBeat.o(87362);
        }

        static /* synthetic */ boolean a(a aVar) {
            AppMethodBeat.i(87363);
            if (f.this.ivn.peekFirst() == aVar) {
                AppMethodBeat.o(87363);
                return true;
            }
            AppMethodBeat.o(87363);
            return false;
        }
    }

    static /* synthetic */ void a(f fVar) {
        CharSequence charSequence;
        Drawable drawable = null;
        a aVar = (a) fVar.ivn.peekFirst();
        if (aVar == null) {
            charSequence = null;
        } else {
            charSequence = aVar.IV;
        }
        fVar.y(charSequence);
        if (aVar != null) {
            drawable = aVar.mDrawable;
        }
        fVar.q(drawable);
    }

    public final void destroy() {
        this.ivn.clear();
    }

    public final com.tencent.mm.plugin.appbrand.page.a.c.a aKh() {
        a aVar = new a();
        this.ivn.addFirst(aVar);
        return aVar;
    }
}
