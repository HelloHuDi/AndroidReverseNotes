package com.tencent.mm.pluginsdk.ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    private int background = -1;
    boolean eic;
    int index;
    OnClickListener pLd = new OnClickListener() {
        public final void onClick(View view) {
        }
    };
    int row;
    j vkt;
    a vkz;
    private final OnTouchListener vla = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    int vlf;
    b vlg;

    public interface b {
        boolean iD(int i);
    }

    public interface a {
        void KT(int i);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$3 */
    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ int sN;
        final /* synthetic */ ViewGroup val$container;

        AnonymousClass3(ViewGroup viewGroup, int i) {
            this.val$container = viewGroup;
            this.sN = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(79782);
            k.this.vkz.KT(this.sN);
            AppMethodBeat.o(79782);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.k$4 */
    class AnonymousClass4 implements OnLongClickListener {
        final /* synthetic */ int sN;
        final /* synthetic */ ViewGroup val$container;

        AnonymousClass4(ViewGroup viewGroup, int i) {
            this.val$container = viewGroup;
            this.sN = i;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(79783);
            boolean iD = k.this.vlg.iD(this.sN);
            AppMethodBeat.o(79783);
            return iD;
        }
    }

    public k() {
        AppMethodBeat.i(79784);
        AppMethodBeat.o(79784);
    }
}
