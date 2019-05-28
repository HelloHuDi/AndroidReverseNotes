package com.tencent.toybrick.p680c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.p1113g.C46821b;
import com.tencent.toybrick.p1113g.C46821b.C16333b;
import com.tencent.toybrick.p1113g.C46821b.C24447d;
import com.tencent.toybrick.p1578f.C41100a;
import com.tencent.toybrick.p680c.C31108d.C24446a;
import com.tencent.toybrick.p682e.C41097c;
import com.tencent.toybrick.p682e.C41097c.C41095a;

/* renamed from: com.tencent.toybrick.c.c */
public final class C24442c extends C44830g<C24442c, C24445a> {
    public static final int AFW = 2130970525;
    private Drawable AFX;
    private C16333b<C24442c> AFY;
    private Drawable AGj;
    private C16333b<C24442c> AGk;
    private C24447d<C24442c> AGl;
    private boolean AGm;
    private C46821b<Boolean, C24442c> AGn;
    private C46821b<Boolean, C24442c> AGo;
    private CharSequence ppl;

    /* renamed from: com.tencent.toybrick.c.c$2 */
    class C244412 implements C41095a<C24445a, Boolean> {
        C244412() {
        }

        /* renamed from: H */
        public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
            int i;
            AppMethodBeat.m2504i(113203);
            Boolean bool = (Boolean) obj2;
            ImageView imageView = ((C24445a) obj).AGr;
            if (bool.booleanValue()) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
            AppMethodBeat.m2505o(113203);
        }
    }

    /* renamed from: com.tencent.toybrick.c.c$1 */
    class C244431 implements C41095a<C24445a, Boolean> {
        C244431() {
        }

        /* renamed from: H */
        public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
            int i;
            AppMethodBeat.m2504i(113202);
            Boolean bool = (Boolean) obj2;
            ImageView imageView = ((C24445a) obj).AGs;
            if (bool.booleanValue()) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
            AppMethodBeat.m2505o(113202);
        }
    }

    /* renamed from: com.tencent.toybrick.c.c$3 */
    class C244443 implements C41095a<C24445a, CharSequence> {
        C244443() {
        }

        /* renamed from: H */
        public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
            AppMethodBeat.m2504i(113204);
            C24445a c24445a = (C24445a) obj;
            CharSequence charSequence = (CharSequence) obj2;
            c24445a.AGt.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            c24445a.AGt.setText(charSequence);
            AppMethodBeat.m2505o(113204);
        }
    }

    /* renamed from: com.tencent.toybrick.c.c$a */
    public class C24445a extends C24446a {
        ImageView AGq;
        ImageView AGr;
        ImageView AGs;
        TextView AGt;
        View AGu;
        ImageView qZa;

        public C24445a(View view) {
            super(view);
            AppMethodBeat.m2504i(113205);
            this.AGq = (ImageView) view.findViewById(2131822352);
            this.AGt = (TextView) view.findViewById(2131825915);
            this.AGr = (ImageView) view.findViewById(2131822353);
            this.AGu = view.findViewById(2131822351);
            this.qZa = (ImageView) view.findViewById(2131821517);
            this.AGs = (ImageView) view.findViewById(2131822354);
            AppMethodBeat.m2505o(113205);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29716a(C41100a c41100a) {
        int i = 0;
        AppMethodBeat.m2504i(113207);
        c41100a = (C24445a) c41100a;
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
            c41100a.AGu.setVisibility(0);
            c41100a.AGq.setVisibility(0);
            c41100a.AGq.setImageDrawable(this.AFX);
        } else if (this.AGk != null) {
            c41100a.AGu.setVisibility(0);
            C41097c.AHh.mo65240a(c41100a, this.AGk, c41100a.AGq);
        } else {
            c41100a.AGq.setVisibility(8);
            c41100a.AGu.setVisibility(8);
        }
        C41097c.AHh.mo65241a(c41100a, this.AGn, new C244431());
        C41097c.AHh.mo65241a(c41100a, this.AGo, new C244412());
        C41097c.AHh.mo65241a(c41100a, this.AGl, new C244443());
        if (TextUtils.isEmpty(this.ppl)) {
            c41100a.pnu.setVisibility(8);
        } else {
            c41100a.pnu.setVisibility(0);
            c41100a.pnu.setText(this.ppl);
        }
        ImageView imageView = c41100a.qZa;
        if (!this.AGm) {
            i = 8;
        }
        imageView.setVisibility(i);
        AppMethodBeat.m2505o(113207);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    /* renamed from: fy */
    public final /* synthetic */ C41100a mo29718fy(View view) {
        AppMethodBeat.m2504i(113206);
        C24445a c24445a = new C24445a(view);
        AppMethodBeat.m2505o(113206);
        return c24445a;
    }
}
