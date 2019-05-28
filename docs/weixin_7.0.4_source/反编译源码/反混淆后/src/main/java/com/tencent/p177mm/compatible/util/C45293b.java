package com.tencent.p177mm.compatible.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;

/* renamed from: com.tencent.mm.compatible.util.b */
public final class C45293b {
    C37658b euH = null;
    private final String euI = "audio_lock";
    Context mContext = null;

    /* renamed from: com.tencent.mm.compatible.util.b$1 */
    class C14421 implements C41932a {
        C14421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(93059);
            C45293b.this.euH = new C32475c(C45293b.this.mContext);
            AppMethodBeat.m2505o(93059);
        }
    }

    /* renamed from: com.tencent.mm.compatible.util.b$a */
    public interface C32474a {
        /* renamed from: gF */
        void mo4587gF(int i);
    }

    /* renamed from: com.tencent.mm.compatible.util.b$b */
    public interface C37658b {
        /* renamed from: Mm */
        boolean mo53112Mm();

        /* renamed from: a */
        void mo53113a(C32474a c32474a);

        boolean requestFocus();
    }

    public C45293b(Context context) {
        AppMethodBeat.m2504i(93060);
        this.mContext = context;
        C41933a.m74069a(8, new C14421());
        AppMethodBeat.m2505o(93060);
    }

    public final boolean requestFocus() {
        boolean z;
        AppMethodBeat.m2504i(93061);
        synchronized ("audio_lock") {
            try {
                if (this.euH == null) {
                    z = false;
                } else {
                    z = this.euH.requestFocus();
                    AppMethodBeat.m2505o(93061);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93061);
            }
        }
        return z;
    }

    /* renamed from: Mm */
    public final boolean mo73178Mm() {
        boolean z;
        AppMethodBeat.m2504i(93062);
        synchronized ("audio_lock") {
            try {
                if (this.euH == null) {
                    z = false;
                } else {
                    z = this.euH.mo53112Mm();
                    AppMethodBeat.m2505o(93062);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93062);
            }
        }
        return z;
    }

    /* renamed from: a */
    public final void mo73179a(C32474a c32474a) {
        AppMethodBeat.m2504i(93063);
        if (this.euH != null) {
            this.euH.mo53113a(c32474a);
        }
        AppMethodBeat.m2505o(93063);
    }
}
