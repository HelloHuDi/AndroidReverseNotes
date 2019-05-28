package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006*\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006*\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t¨\u0006\n"}, dWq = {"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"})
public final class i {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
    static final class b extends k implements a.f.a.a<T> {
        final /* synthetic */ int pEE;
        final /* synthetic */ View pEF;

        b(View view, int i) {
            this.pEF = view;
            this.pEE = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103139);
            View findViewById = this.pEF.findViewById(this.pEE);
            if (findViewById == null) {
                v vVar = new v("null cannot be cast to non-null type T");
                AppMethodBeat.o(103139);
                throw vVar;
            }
            AppMethodBeat.o(103139);
            return findViewById;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
    static final class a extends k implements a.f.a.a<T> {
        final /* synthetic */ Activity pED;
        final /* synthetic */ int pEE = R.id.du5;

        a(Activity activity) {
            this.pED = activity;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103138);
            View findViewById = this.pED.findViewById(this.pEE);
            if (findViewById == null) {
                v vVar = new v("null cannot be cast to non-null type T");
                AppMethodBeat.o(103138);
                throw vVar;
            }
            AppMethodBeat.o(103138);
            return findViewById;
        }
    }

    public static final <T extends View> f<T> aa(View view, int i) {
        AppMethodBeat.i(103140);
        j.p(view, "receiver$0");
        f a = a.i.a(a.k.NONE, new b(view, i));
        AppMethodBeat.o(103140);
        return a;
    }
}
