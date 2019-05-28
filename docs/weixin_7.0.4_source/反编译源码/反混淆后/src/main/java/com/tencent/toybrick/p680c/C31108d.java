package com.tencent.toybrick.p680c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.toybrick.p1113g.C46821b.C16333b;
import com.tencent.toybrick.p1113g.C46821b.C31115c;
import com.tencent.toybrick.p1578f.C41100a;
import com.tencent.toybrick.p680c.C44830g.C36553a;
import com.tencent.toybrick.p682e.C41097c;
import com.tencent.toybrick.p682e.C41097c.C41095a;

/* renamed from: com.tencent.toybrick.c.d */
public final class C31108d extends C44830g<C31108d, C24446a> {
    public static final int AFW = 2130970697;
    private Drawable AFX;
    private C16333b<C31108d> AFY;
    private Drawable AGj;
    private C16333b<C31108d> AGk;
    private C36553a AGv;
    private C31115c<C31108d> AGw;
    private CharSequence ppl;

    /* renamed from: com.tencent.toybrick.c.d$a */
    public static class C24446a extends C41100a {
        public TextView AGb;
        public ImageView AGc;
        public ImageView AGd;
        public ImageView AGq;
        public TextView gne;
        public TextView pnu;

        public C24446a(View view) {
            super(view);
            AppMethodBeat.m2504i(113212);
            this.gne = (TextView) view.findViewById(16908310);
            this.AGd = (ImageView) view.findViewById(2131822736);
            this.AGq = (ImageView) view.findViewById(2131824533);
            this.AGb = (TextView) view.findViewById(2131822349);
            this.AGc = (ImageView) view.findViewById(2131822737);
            this.pnu = (TextView) view.findViewById(2131821841);
            AppMethodBeat.m2505o(113212);
        }
    }

    /* renamed from: com.tencent.toybrick.c.d$2 */
    class C311102 implements C41095a<C24446a, Integer> {
        C311102() {
        }

        /* renamed from: H */
        public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
            AppMethodBeat.m2504i(113209);
            C24446a c24446a = (C24446a) obj;
            if (((Integer) obj2).intValue() > 0) {
                c24446a.AGb.setVisibility(0);
                c24446a.AGb.setText(C31108d.this.AGA.getString(C25738R.string.ey3));
                AppMethodBeat.m2505o(113209);
                return;
            }
            c24446a.AGb.setVisibility(8);
            AppMethodBeat.m2505o(113209);
        }
    }

    /* renamed from: com.tencent.toybrick.c.d$1 */
    class C311111 implements C41095a<C24446a, Integer> {
        C311111() {
        }

        /* renamed from: H */
        public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
            AppMethodBeat.m2504i(113208);
            C24446a c24446a = (C24446a) obj;
            if (((Integer) obj2).intValue() > 0) {
                c24446a.AGc.setVisibility(0);
                AppMethodBeat.m2505o(113208);
                return;
            }
            c24446a.AGc.setVisibility(8);
            AppMethodBeat.m2505o(113208);
        }
    }

    /* renamed from: com.tencent.toybrick.c.d$3 */
    class C311123 implements C41095a<C24446a, Integer> {
        C311123() {
        }

        /* renamed from: H */
        public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
            AppMethodBeat.m2504i(113210);
            C24446a c24446a = (C24446a) obj;
            Integer num = (Integer) obj2;
            if (num.intValue() > 0) {
                c24446a.AGb.setVisibility(0);
                c24446a.AGb.setText(String.valueOf(num));
                AppMethodBeat.m2505o(113210);
                return;
            }
            c24446a.AGb.setVisibility(8);
            AppMethodBeat.m2505o(113210);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29716a(C41100a c41100a) {
        AppMethodBeat.m2504i(113214);
        c41100a = (C24446a) c41100a;
        c41100a.gne.setText(this.f17612IT);
        if (this.AFX != null) {
            c41100a.AGd.setImageDrawable(this.AFX);
            c41100a.AGd.setVisibility(0);
        } else if (this.AFY != null) {
            C41097c.AHh.mo65240a(c41100a, this.AFY, c41100a.AGd);
        } else {
            c41100a.AGd.setVisibility(8);
        }
        if (this.AGj != null) {
            c41100a.AGq.setImageDrawable(this.AGj);
            c41100a.AGq.setVisibility(0);
        } else if (this.AGk != null) {
            C41097c.AHh.mo65240a(c41100a, this.AGk, c41100a.AGq);
        } else {
            c41100a.AGq.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.ppl)) {
            c41100a.pnu.setVisibility(8);
        } else {
            c41100a.pnu.setVisibility(0);
            c41100a.pnu.setText(this.ppl);
        }
        switch (this.AGv) {
            case NONE:
                c41100a.AGc.setVisibility(8);
                c41100a.AGb.setVisibility(8);
                AppMethodBeat.m2505o(113214);
                return;
            case RED_DOT:
                c41100a.AGb.setVisibility(8);
                C41097c.AHh.mo65241a(c41100a, this.AGw, new C311111());
                AppMethodBeat.m2505o(113214);
                return;
            case RED_NEW:
                c41100a.AGc.setVisibility(8);
                int dimension = (int) this.AGA.getResources().getDimension(C25738R.dimen.f10011nc);
                c41100a.AGb.setPadding(dimension, 0, dimension, 0);
                C41097c.AHh.mo65241a(c41100a, this.AGw, new C311102());
                AppMethodBeat.m2505o(113214);
                return;
            case RED_NUM:
                c41100a.AGb.setPadding(0, 0, 0, 0);
                c41100a.AGc.setVisibility(8);
                C41097c.AHh.mo65241a(c41100a, this.AGw, new C311123());
                break;
        }
        AppMethodBeat.m2505o(113214);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    /* renamed from: fy */
    public final /* synthetic */ C41100a mo29718fy(View view) {
        AppMethodBeat.m2504i(113213);
        C24446a c24446a = new C24446a(view);
        AppMethodBeat.m2505o(113213);
        return c24446a;
    }
}
