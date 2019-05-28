package com.tencent.toybrick.p680c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.toybrick.p1113g.C46821b.C16333b;
import com.tencent.toybrick.p1113g.C46821b.C31114a;
import com.tencent.toybrick.p1578f.C41100a;
import com.tencent.toybrick.p682e.C41097c;
import com.tencent.toybrick.p682e.C41097c.C41095a;

/* renamed from: com.tencent.toybrick.c.a */
public final class C41093a extends C44830g<C41093a, C31104a> {
    public static final int AFW = 2130969130;
    private Drawable AFX;
    private C16333b<C41093a> AFY;
    private C31114a<C41093a> AFZ;
    private CharSequence ppl;

    /* renamed from: com.tencent.toybrick.c.a$a */
    public class C31104a extends C41100a {
        public TextView AGb;
        public ImageView AGc;
        public ImageView AGd;
        public MMSwitchBtn AGe;
        public TextView gne;
        public TextView pnu;

        public C31104a(View view) {
            super(view);
            AppMethodBeat.m2504i(113196);
            this.gne = (TextView) view.findViewById(16908310);
            this.AGd = (ImageView) view.findViewById(2131822736);
            this.AGb = (TextView) view.findViewById(2131822349);
            this.AGc = (ImageView) view.findViewById(2131822737);
            this.pnu = (TextView) view.findViewById(2131821841);
            this.AGe = (MMSwitchBtn) view.findViewById(2131820932);
            this.AGe.setSwitchListener(new C30795a(C41093a.this) {
                /* renamed from: di */
                public final void mo6646di(boolean z) {
                }
            });
            AppMethodBeat.m2505o(113196);
        }
    }

    /* renamed from: com.tencent.toybrick.c.a$1 */
    class C410941 implements C41095a<C31104a, Boolean> {
        C410941() {
        }

        /* renamed from: H */
        public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
            AppMethodBeat.m2504i(113195);
            ((C31104a) obj).AGe.setCheck(((Boolean) obj2).booleanValue());
            AppMethodBeat.m2505o(113195);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29716a(C41100a c41100a) {
        AppMethodBeat.m2504i(113198);
        c41100a = (C31104a) c41100a;
        c41100a.gne.setText(this.f17612IT);
        if (TextUtils.isEmpty(this.ppl)) {
            c41100a.pnu.setVisibility(8);
        } else {
            c41100a.pnu.setVisibility(0);
            c41100a.pnu.setText(this.ppl);
        }
        if (this.AFX != null) {
            c41100a.AGd.setImageDrawable(this.AFX);
            c41100a.AGd.setVisibility(0);
        } else if (this.AFY != null) {
            C41097c.AHh.mo65240a(c41100a, this.AFY, c41100a.AGd);
        } else {
            c41100a.AGd.setVisibility(8);
        }
        C41097c.AHh.mo65241a(c41100a, this.AFZ, new C410941());
        AppMethodBeat.m2505o(113198);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    /* renamed from: fy */
    public final /* synthetic */ C41100a mo29718fy(View view) {
        AppMethodBeat.m2504i(113197);
        C31104a c31104a = new C31104a(view);
        AppMethodBeat.m2505o(113197);
        return c31104a;
    }
}
