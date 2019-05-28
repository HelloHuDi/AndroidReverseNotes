package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.g.b.b;
import com.tencent.toybrick.g.b.c;

public final class d extends g<d, a> {
    public static final int AFW = R.layout.ath;
    private Drawable AFX;
    private b<d> AFY;
    private Drawable AGj;
    private b<d> AGk;
    private com.tencent.toybrick.c.g.a AGv;
    private c<d> AGw;
    private CharSequence ppl;

    public static class a extends com.tencent.toybrick.f.a {
        public TextView AGb;
        public ImageView AGc;
        public ImageView AGd;
        public ImageView AGq;
        public TextView gne;
        public TextView pnu;

        public a(View view) {
            super(view);
            AppMethodBeat.i(113212);
            this.gne = (TextView) view.findViewById(16908310);
            this.AGd = (ImageView) view.findViewById(R.id.av9);
            this.AGq = (ImageView) view.findViewById(R.id.c6t);
            this.AGb = (TextView) view.findViewById(R.id.akr);
            this.AGc = (ImageView) view.findViewById(R.id.av_);
            this.pnu = (TextView) view.findViewById(R.id.a81);
            AppMethodBeat.o(113212);
        }
    }

    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        AppMethodBeat.i(113214);
        aVar = (a) aVar;
        aVar.gne.setText(this.IT);
        if (this.AFX != null) {
            aVar.AGd.setImageDrawable(this.AFX);
            aVar.AGd.setVisibility(0);
        } else if (this.AFY != null) {
            com.tencent.toybrick.e.c.AHh.a(aVar, this.AFY, aVar.AGd);
        } else {
            aVar.AGd.setVisibility(8);
        }
        if (this.AGj != null) {
            aVar.AGq.setImageDrawable(this.AGj);
            aVar.AGq.setVisibility(0);
        } else if (this.AGk != null) {
            com.tencent.toybrick.e.c.AHh.a(aVar, this.AGk, aVar.AGq);
        } else {
            aVar.AGq.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.ppl)) {
            aVar.pnu.setVisibility(8);
        } else {
            aVar.pnu.setVisibility(0);
            aVar.pnu.setText(this.ppl);
        }
        switch (this.AGv) {
            case NONE:
                aVar.AGc.setVisibility(8);
                aVar.AGb.setVisibility(8);
                AppMethodBeat.o(113214);
                return;
            case RED_DOT:
                aVar.AGb.setVisibility(8);
                com.tencent.toybrick.e.c.AHh.a(aVar, this.AGw, new com.tencent.toybrick.e.c.a<a, Integer>() {
                    public final /* synthetic */ void H(Object obj, Object obj2) {
                        AppMethodBeat.i(113208);
                        a aVar = (a) obj;
                        if (((Integer) obj2).intValue() > 0) {
                            aVar.AGc.setVisibility(0);
                            AppMethodBeat.o(113208);
                            return;
                        }
                        aVar.AGc.setVisibility(8);
                        AppMethodBeat.o(113208);
                    }
                });
                AppMethodBeat.o(113214);
                return;
            case RED_NEW:
                aVar.AGc.setVisibility(8);
                int dimension = (int) this.AGA.getResources().getDimension(R.dimen.nc);
                aVar.AGb.setPadding(dimension, 0, dimension, 0);
                com.tencent.toybrick.e.c.AHh.a(aVar, this.AGw, new com.tencent.toybrick.e.c.a<a, Integer>() {
                    public final /* synthetic */ void H(Object obj, Object obj2) {
                        AppMethodBeat.i(113209);
                        a aVar = (a) obj;
                        if (((Integer) obj2).intValue() > 0) {
                            aVar.AGb.setVisibility(0);
                            aVar.AGb.setText(d.this.AGA.getString(R.string.ey3));
                            AppMethodBeat.o(113209);
                            return;
                        }
                        aVar.AGb.setVisibility(8);
                        AppMethodBeat.o(113209);
                    }
                });
                AppMethodBeat.o(113214);
                return;
            case RED_NUM:
                aVar.AGb.setPadding(0, 0, 0, 0);
                aVar.AGc.setVisibility(8);
                com.tencent.toybrick.e.c.AHh.a(aVar, this.AGw, new com.tencent.toybrick.e.c.a<a, Integer>() {
                    public final /* synthetic */ void H(Object obj, Object obj2) {
                        AppMethodBeat.i(113210);
                        a aVar = (a) obj;
                        Integer num = (Integer) obj2;
                        if (num.intValue() > 0) {
                            aVar.AGb.setVisibility(0);
                            aVar.AGb.setText(String.valueOf(num));
                            AppMethodBeat.o(113210);
                            return;
                        }
                        aVar.AGb.setVisibility(8);
                        AppMethodBeat.o(113210);
                    }
                });
                break;
        }
        AppMethodBeat.o(113214);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    public final /* synthetic */ com.tencent.toybrick.f.a fy(View view) {
        AppMethodBeat.i(113213);
        a aVar = new a(view);
        AppMethodBeat.o(113213);
        return aVar;
    }
}
