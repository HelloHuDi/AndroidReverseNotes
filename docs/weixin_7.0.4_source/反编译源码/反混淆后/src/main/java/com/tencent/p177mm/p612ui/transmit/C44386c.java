package com.tencent.p177mm.p612ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;

/* renamed from: com.tencent.mm.ui.transmit.c */
public final class C44386c {
    C5653c gud;
    C40895a zKu;

    /* renamed from: com.tencent.mm.ui.transmit.c$1 */
    static class C159711 implements OnClickListener {
        final /* synthetic */ C44386c zKv;

        C159711(C44386c c44386c) {
            this.zKv = c44386c;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35211);
            this.zKv.zKu.dKi();
            AppMethodBeat.m2505o(35211);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.c$2 */
    static class C159722 implements OnClickListener {
        final /* synthetic */ C44386c zKv;

        C159722(C44386c c44386c) {
            this.zKv = c44386c;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35212);
            C44386c c44386c = this.zKv;
            if (c44386c.gud != null) {
                c44386c.gud.dismiss();
                c44386c.gud = null;
            }
            c44386c.zKu.dKi();
            AppMethodBeat.m2505o(35212);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.c$a */
    public interface C40895a {
        void dKi();
    }

    C44386c(C40895a c40895a) {
        this.zKu = c40895a;
    }
}
