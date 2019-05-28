package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.g.b.b;

public final class a extends g<a, a> {
    public static final int AFW = R.layout.o8;
    private Drawable AFX;
    private b<a> AFY;
    private com.tencent.toybrick.g.b.a<a> AFZ;
    private CharSequence ppl;

    public class a extends com.tencent.toybrick.f.a {
        public TextView AGb;
        public ImageView AGc;
        public ImageView AGd;
        public MMSwitchBtn AGe;
        public TextView gne;
        public TextView pnu;

        public a(View view) {
            super(view);
            AppMethodBeat.i(113196);
            this.gne = (TextView) view.findViewById(16908310);
            this.AGd = (ImageView) view.findViewById(R.id.av9);
            this.AGb = (TextView) view.findViewById(R.id.akr);
            this.AGc = (ImageView) view.findViewById(R.id.av_);
            this.pnu = (TextView) view.findViewById(R.id.a81);
            this.AGe = (MMSwitchBtn) view.findViewById(R.id.js);
            this.AGe.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a(a.this) {
                public final void di(boolean z) {
                }
            });
            AppMethodBeat.o(113196);
        }
    }

    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        AppMethodBeat.i(113198);
        aVar = (a) aVar;
        aVar.gne.setText(this.IT);
        if (TextUtils.isEmpty(this.ppl)) {
            aVar.pnu.setVisibility(8);
        } else {
            aVar.pnu.setVisibility(0);
            aVar.pnu.setText(this.ppl);
        }
        if (this.AFX != null) {
            aVar.AGd.setImageDrawable(this.AFX);
            aVar.AGd.setVisibility(0);
        } else if (this.AFY != null) {
            c.AHh.a(aVar, this.AFY, aVar.AGd);
        } else {
            aVar.AGd.setVisibility(8);
        }
        c.AHh.a(aVar, this.AFZ, new com.tencent.toybrick.e.c.a<a, Boolean>() {
            public final /* synthetic */ void H(Object obj, Object obj2) {
                AppMethodBeat.i(113195);
                ((a) obj).AGe.setCheck(((Boolean) obj2).booleanValue());
                AppMethodBeat.o(113195);
            }
        });
        AppMethodBeat.o(113198);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    public final /* synthetic */ com.tencent.toybrick.f.a fy(View view) {
        AppMethodBeat.i(113197);
        a aVar = new a(view);
        AppMethodBeat.o(113197);
        return aVar;
    }
}
