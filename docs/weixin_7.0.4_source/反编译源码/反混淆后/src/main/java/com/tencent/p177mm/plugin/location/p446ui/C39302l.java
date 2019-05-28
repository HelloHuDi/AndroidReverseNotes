package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.plugin.location.ui.l */
public final class C39302l {
    private C5653c hkR = null;
    public Context mContext;
    public Resources mResources;
    C3357a nNK;

    /* renamed from: com.tencent.mm.plugin.location.ui.l$a */
    public interface C3357a {
        void bKd();

        void bKe();

        /* renamed from: xD */
        void mo7765xD(int i);
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.l$5 */
    public class C211865 implements OnClickListener {
        final /* synthetic */ int bVv;

        public C211865(int i) {
            this.bVv = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(113557);
            if (C39302l.this.nNK != null) {
                C39302l.this.nNK.mo7765xD(this.bVv);
            }
            AppMethodBeat.m2505o(113557);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.l$1 */
    class C393001 implements OnClickListener {
        C393001() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(113554);
            if (C39302l.this.nNK != null) {
                C39302l.this.nNK.bKd();
            }
            AppMethodBeat.m2505o(113554);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.l$3 */
    public class C393013 implements OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(113555);
            if (C39302l.this.nNK != null) {
                C39302l.this.nNK.bKe();
            }
            AppMethodBeat.m2505o(113555);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.l$2 */
    class C393032 implements OnClickListener {
        C393032() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.l$4 */
    public class C393044 implements OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(113556);
            C7060h.pYm.mo8381e(10997, "18", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(113556);
        }
    }

    public C39302l(Context context, C3357a c3357a) {
        AppMethodBeat.m2504i(113558);
        this.mContext = context;
        this.nNK = c3357a;
        this.mResources = this.mContext.getResources();
        AppMethodBeat.m2505o(113558);
    }

    public final void bKc() {
        boolean z;
        AppMethodBeat.m2504i(113559);
        Object obj = C1720g.m3536RP().mo5239Ry().get(67590, null);
        if (obj == null) {
            z = false;
        } else {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            if (this.nNK != null) {
                this.nNK.bKd();
            }
            AppMethodBeat.m2505o(113559);
            return;
        }
        C30379h.m48449a(this.mContext, this.mResources.getString(C25738R.string.cnu), "", false, new C393001(), new C393032());
        C1720g.m3536RP().mo5239Ry().set(67590, Boolean.TRUE);
        AppMethodBeat.m2505o(113559);
    }
}
