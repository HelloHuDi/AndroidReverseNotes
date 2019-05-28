package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;
import java.util.ArrayList;
import java.util.List;

public final class f extends e {
    public LinearLayout jOP;
    public LinearLayout jOQ;
    public l jPA = new l();
    public OnClickListener jPB = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(14257);
            q qVar = (q) view.getTag();
            qVar.field_isExpand = true;
            z.aeX().h(qVar);
            f.this.jPm.jNy.d(qVar, 0);
            AppMethodBeat.o(14257);
        }
    };
    public LinearLayout jPr;
    public LinearLayout jPs;
    public TextView jPt;
    public List<b> jPu = new ArrayList();
    public k jPv = new k();
    public m jPw = new m();
    public j jPx = new j();
    public n jPy = new n();
    public i jPz = new i();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.f$2 */
    public class AnonymousClass2 implements a {
        final /* synthetic */ q jEl;
        final /* synthetic */ b jPD;
        final /* synthetic */ p jPE;
        final /* synthetic */ int jPF;

        public AnonymousClass2(b bVar, p pVar, q qVar, int i) {
            this.jPD = bVar;
            this.jPE = pVar;
            this.jEl = qVar;
            this.jPF = i;
        }

        public final void onFinish() {
            AppMethodBeat.i(14258);
            this.jPD.a(this.jPE, this.jEl, this.jPF, true);
            f.this.jPm.jNp.m(this.jEl.field_msgId, this.jPF);
            AppMethodBeat.o(14258);
        }
    }

    public f() {
        AppMethodBeat.i(14259);
        AppMethodBeat.o(14259);
    }

    private void a(View view, c cVar, boolean z) {
        AppMethodBeat.i(14260);
        if (z) {
            if (cVar.jOR == null) {
                cVar.a(view, this.jPm);
            }
            if (cVar.jOR != null) {
                cVar.jOR.setVisibility(0);
                AppMethodBeat.o(14260);
                return;
            }
        } else if (cVar.jOR != null) {
            cVar.jOR.setVisibility(8);
        }
        AppMethodBeat.o(14260);
    }

    public final void a(f fVar, int i, int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(14261);
        boolean z3 = i == 5;
        a(fVar.jPr, fVar.jPw, z3);
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
        a(fVar.jPr, fVar.jPx, z3);
        if (z3) {
            z = true;
        }
        if (i == 7) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(fVar.jPr, fVar.jPy, z3);
        if (z3) {
            z = true;
        }
        if (i == 6) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(fVar.jPr, fVar.jPz, z3);
        if (z3) {
            z = true;
        }
        if (i == 10) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(fVar.jPr, fVar.jPA, z3);
        if (z3) {
            z3 = true;
        } else {
            z3 = z;
        }
        View view = fVar.jPr;
        c cVar = fVar.jPv;
        if (z3 || i2 <= 0 || i == -1) {
            z2 = false;
        }
        a(view, cVar, z2);
        AppMethodBeat.o(14261);
    }

    public static void r(View view, int i, int i2) {
        AppMethodBeat.i(14262);
        view.setPadding(0, i - com.tencent.mm.plugin.brandservice.ui.timeline.a.jNk, 0, i2 - com.tencent.mm.plugin.brandservice.ui.timeline.a.jNk);
        AppMethodBeat.o(14262);
    }

    public static void O(View view, int i) {
        AppMethodBeat.i(14263);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.rightMargin = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(14263);
    }
}
