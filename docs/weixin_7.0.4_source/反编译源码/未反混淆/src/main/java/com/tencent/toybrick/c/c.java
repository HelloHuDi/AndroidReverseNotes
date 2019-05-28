package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.g.b.b;
import com.tencent.toybrick.g.b.d;

public final class c extends g<c, a> {
    public static final int AFW = R.layout.aou;
    private Drawable AFX;
    private b<c> AFY;
    private Drawable AGj;
    private b<c> AGk;
    private d<c> AGl;
    private boolean AGm;
    private com.tencent.toybrick.g.b<Boolean, c> AGn;
    private com.tencent.toybrick.g.b<Boolean, c> AGo;
    private CharSequence ppl;

    public class a extends com.tencent.toybrick.c.d.a {
        ImageView AGq;
        ImageView AGr;
        ImageView AGs;
        TextView AGt;
        View AGu;
        ImageView qZa;

        public a(View view) {
            super(view);
            AppMethodBeat.i(113205);
            this.AGq = (ImageView) view.findViewById(R.id.aku);
            this.AGt = (TextView) view.findViewById(R.id.d77);
            this.AGr = (ImageView) view.findViewById(R.id.akv);
            this.AGu = view.findViewById(R.id.akt);
            this.qZa = (ImageView) view.findViewById(R.id.z_);
            this.AGs = (ImageView) view.findViewById(R.id.akw);
            AppMethodBeat.o(113205);
        }
    }

    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        int i = 0;
        AppMethodBeat.i(113207);
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
            aVar.AGu.setVisibility(0);
            aVar.AGq.setVisibility(0);
            aVar.AGq.setImageDrawable(this.AFX);
        } else if (this.AGk != null) {
            aVar.AGu.setVisibility(0);
            com.tencent.toybrick.e.c.AHh.a(aVar, this.AGk, aVar.AGq);
        } else {
            aVar.AGq.setVisibility(8);
            aVar.AGu.setVisibility(8);
        }
        com.tencent.toybrick.e.c.AHh.a(aVar, this.AGn, new com.tencent.toybrick.e.c.a<a, Boolean>() {
            public final /* synthetic */ void H(Object obj, Object obj2) {
                int i;
                AppMethodBeat.i(113202);
                Boolean bool = (Boolean) obj2;
                ImageView imageView = ((a) obj).AGs;
                if (bool.booleanValue()) {
                    i = 0;
                } else {
                    i = 8;
                }
                imageView.setVisibility(i);
                AppMethodBeat.o(113202);
            }
        });
        com.tencent.toybrick.e.c.AHh.a(aVar, this.AGo, new com.tencent.toybrick.e.c.a<a, Boolean>() {
            public final /* synthetic */ void H(Object obj, Object obj2) {
                int i;
                AppMethodBeat.i(113203);
                Boolean bool = (Boolean) obj2;
                ImageView imageView = ((a) obj).AGr;
                if (bool.booleanValue()) {
                    i = 0;
                } else {
                    i = 8;
                }
                imageView.setVisibility(i);
                AppMethodBeat.o(113203);
            }
        });
        com.tencent.toybrick.e.c.AHh.a(aVar, this.AGl, new com.tencent.toybrick.e.c.a<a, CharSequence>() {
            public final /* synthetic */ void H(Object obj, Object obj2) {
                AppMethodBeat.i(113204);
                a aVar = (a) obj;
                CharSequence charSequence = (CharSequence) obj2;
                aVar.AGt.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
                aVar.AGt.setText(charSequence);
                AppMethodBeat.o(113204);
            }
        });
        if (TextUtils.isEmpty(this.ppl)) {
            aVar.pnu.setVisibility(8);
        } else {
            aVar.pnu.setVisibility(0);
            aVar.pnu.setText(this.ppl);
        }
        ImageView imageView = aVar.qZa;
        if (!this.AGm) {
            i = 8;
        }
        imageView.setVisibility(i);
        AppMethodBeat.o(113207);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    public final /* synthetic */ com.tencent.toybrick.f.a fy(View view) {
        AppMethodBeat.i(113206);
        a aVar = new a(view);
        AppMethodBeat.o(113206);
        return aVar;
    }
}
