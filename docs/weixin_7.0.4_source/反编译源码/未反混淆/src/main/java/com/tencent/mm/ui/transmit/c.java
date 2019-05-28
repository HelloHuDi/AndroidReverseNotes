package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    com.tencent.mm.ui.widget.a.c gud;
    a zKu;

    /* renamed from: com.tencent.mm.ui.transmit.c$1 */
    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ c zKv;

        AnonymousClass1(c cVar) {
            this.zKv = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(35211);
            this.zKv.zKu.dKi();
            AppMethodBeat.o(35211);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.c$2 */
    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ c zKv;

        AnonymousClass2(c cVar) {
            this.zKv = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(35212);
            c cVar = this.zKv;
            if (cVar.gud != null) {
                cVar.gud.dismiss();
                cVar.gud = null;
            }
            cVar.zKu.dKi();
            AppMethodBeat.o(35212);
        }
    }

    public interface a {
        void dKi();
    }

    c(a aVar) {
        this.zKu = aVar;
    }
}
