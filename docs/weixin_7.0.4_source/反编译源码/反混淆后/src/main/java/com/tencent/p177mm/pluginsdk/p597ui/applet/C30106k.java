package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.k */
public final class C30106k {
    private int background = -1;
    boolean eic;
    int index;
    OnClickListener pLd = new C301072();
    int row;
    C14926j vkt;
    C30105a vkz;
    private final OnTouchListener vla = new C301101();
    int vlf;
    C14929b vlg;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$b */
    public interface C14929b {
        /* renamed from: iD */
        boolean mo4758iD(int i);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$a */
    public interface C30105a {
        /* renamed from: KT */
        void mo27250KT(int i);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$2 */
    class C301072 implements OnClickListener {
        C301072() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$3 */
    class C301083 implements OnClickListener {
        /* renamed from: sN */
        final /* synthetic */ int f13728sN;
        final /* synthetic */ ViewGroup val$container;

        C301083(ViewGroup viewGroup, int i) {
            this.val$container = viewGroup;
            this.f13728sN = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(79782);
            C30106k.this.vkz.mo27250KT(this.f13728sN);
            AppMethodBeat.m2505o(79782);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$4 */
    class C301094 implements OnLongClickListener {
        /* renamed from: sN */
        final /* synthetic */ int f13729sN;
        final /* synthetic */ ViewGroup val$container;

        C301094(ViewGroup viewGroup, int i) {
            this.val$container = viewGroup;
            this.f13729sN = i;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(79783);
            boolean iD = C30106k.this.vlg.mo4758iD(this.f13729sN);
            AppMethodBeat.m2505o(79783);
            return iD;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$1 */
    class C301101 implements OnTouchListener {
        C301101() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public C30106k() {
        AppMethodBeat.m2504i(79784);
        AppMethodBeat.m2505o(79784);
    }
}
