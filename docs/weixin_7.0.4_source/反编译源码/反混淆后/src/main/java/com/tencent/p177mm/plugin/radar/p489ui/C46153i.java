package com.tencent.p177mm.plugin.radar.p489ui;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0219k;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006*\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006*\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t¨\u0006\n"}, dWq = {"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.i */
public final class C46153i {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.i$b */
    static final class C39563b extends C25053k implements C31214a<T> {
        final /* synthetic */ int pEE;
        final /* synthetic */ View pEF;

        C39563b(View view, int i) {
            this.pEF = view;
            this.pEE = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103139);
            View findViewById = this.pEF.findViewById(this.pEE);
            if (findViewById == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type T");
                AppMethodBeat.m2505o(103139);
                throw c44941v;
            }
            AppMethodBeat.m2505o(103139);
            return findViewById;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.i$a */
    static final class C46152a extends C25053k implements C31214a<T> {
        final /* synthetic */ Activity pED;
        final /* synthetic */ int pEE = 2131826801;

        C46152a(Activity activity) {
            this.pED = activity;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103138);
            View findViewById = this.pED.findViewById(this.pEE);
            if (findViewById == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type T");
                AppMethodBeat.m2505o(103138);
                throw c44941v;
            }
            AppMethodBeat.m2505o(103138);
            return findViewById;
        }
    }

    /* renamed from: aa */
    public static final <T extends View> C44856f<T> m86149aa(View view, int i) {
        AppMethodBeat.m2504i(103140);
        C25052j.m39376p(view, "receiver$0");
        C44856f a = C17344i.m26853a(C0219k.NONE, new C39563b(view, i));
        AppMethodBeat.m2505o(103140);
        return a;
    }
}
