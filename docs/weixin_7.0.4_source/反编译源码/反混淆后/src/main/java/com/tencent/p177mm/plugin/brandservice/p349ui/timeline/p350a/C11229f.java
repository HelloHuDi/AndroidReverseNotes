package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.storage.C46627q;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.f */
public final class C11229f extends C27519e {
    public LinearLayout jOP;
    public LinearLayout jOQ;
    public C46900l jPA = new C46900l();
    public OnClickListener jPB = new C112301();
    public LinearLayout jPr;
    public LinearLayout jPs;
    public TextView jPt;
    public List<C33730b> jPu = new ArrayList();
    public C38698k jPv = new C38698k();
    public C38699m jPw = new C38699m();
    public C42814j jPx = new C42814j();
    public C27520n jPy = new C27520n();
    public C11237i jPz = new C11237i();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.f$1 */
    class C112301 implements OnClickListener {
        C112301() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14257);
            C46627q c46627q = (C46627q) view.getTag();
            c46627q.field_isExpand = true;
            C41747z.aeX().mo64113h(c46627q);
            C11229f.this.jPm.jNy.mo35304d(c46627q, 0);
            AppMethodBeat.m2505o(14257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.f$2 */
    public class C112312 implements C35837a {
        final /* synthetic */ C46627q jEl;
        final /* synthetic */ C33730b jPD;
        final /* synthetic */ C32224p jPE;
        final /* synthetic */ int jPF;

        public C112312(C33730b c33730b, C32224p c32224p, C46627q c46627q, int i) {
            this.jPD = c33730b;
            this.jPE = c32224p;
            this.jEl = c46627q;
            this.jPF = i;
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(14258);
            this.jPD.mo54268a(this.jPE, this.jEl, this.jPF, true);
            C11229f.this.jPm.jNp.mo6785m(this.jEl.field_msgId, this.jPF);
            AppMethodBeat.m2505o(14258);
        }
    }

    public C11229f() {
        AppMethodBeat.m2504i(14259);
        AppMethodBeat.m2505o(14259);
    }

    /* renamed from: a */
    private void m18951a(View view, C45762c c45762c, boolean z) {
        AppMethodBeat.m2504i(14260);
        if (z) {
            if (c45762c.jOR == null) {
                c45762c.mo22941a(view, this.jPm);
            }
            if (c45762c.jOR != null) {
                c45762c.jOR.setVisibility(0);
                AppMethodBeat.m2505o(14260);
                return;
            }
        } else if (c45762c.jOR != null) {
            c45762c.jOR.setVisibility(8);
        }
        AppMethodBeat.m2505o(14260);
    }

    /* renamed from: a */
    public final void mo22935a(C11229f c11229f, int i, int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(14261);
        boolean z3 = i == 5;
        m18951a(c11229f.jPr, c11229f.jPw, z3);
        if (z3) {
            z = true;
        } else {
            z = false;
        }
        if (i == 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        m18951a(c11229f.jPr, c11229f.jPx, z3);
        if (z3) {
            z = true;
        }
        if (i == 7) {
            z3 = true;
        } else {
            z3 = false;
        }
        m18951a(c11229f.jPr, c11229f.jPy, z3);
        if (z3) {
            z = true;
        }
        if (i == 6) {
            z3 = true;
        } else {
            z3 = false;
        }
        m18951a(c11229f.jPr, c11229f.jPz, z3);
        if (z3) {
            z = true;
        }
        if (i == 10) {
            z3 = true;
        } else {
            z3 = false;
        }
        m18951a(c11229f.jPr, c11229f.jPA, z3);
        if (z3) {
            z3 = true;
        } else {
            z3 = z;
        }
        View view = c11229f.jPr;
        C45762c c45762c = c11229f.jPv;
        if (z3 || i2 <= 0 || i == -1) {
            z2 = false;
        }
        m18951a(view, c45762c, z2);
        AppMethodBeat.m2505o(14261);
    }

    /* renamed from: r */
    public static void m18952r(View view, int i, int i2) {
        AppMethodBeat.m2504i(14262);
        view.setPadding(0, i - C38701a.jNk, 0, i2 - C38701a.jNk);
        AppMethodBeat.m2505o(14262);
    }

    /* renamed from: O */
    public static void m18950O(View view, int i) {
        AppMethodBeat.m2504i(14263);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.rightMargin = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(14263);
    }
}
