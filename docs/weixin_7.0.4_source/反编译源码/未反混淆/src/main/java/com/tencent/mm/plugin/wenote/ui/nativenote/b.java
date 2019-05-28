package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends com.tencent.mm.pluginsdk.ui.b.b {
    private TextView gne = null;
    private View jyC;
    private View jyD;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(27113);
        if (this.view != null) {
            this.gne = (TextView) this.view.findViewById(R.id.flh);
            this.jyC = this.view.findViewById(R.id.flg);
            this.jyD = this.view.findViewById(R.id.a2a);
            this.gne.setTextSize(0, (float) a.al(this.gne.getContext(), R.dimen.kr));
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(27112);
                    ab.i("WNNoteBanner", "click WNNoteBanner");
                    q deI = h.deH().deI();
                    if (deI == null) {
                        ab.i("WNNoteBanner", "keepTopItem is null");
                        b.this.setVisibility(8);
                        AppMethodBeat.o(27112);
                    } else if (deI.uOr) {
                        if (deI.mgQ) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14789, Integer.valueOf(3));
                        } else {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14789, Integer.valueOf(2));
                        }
                        ab.i("WNNoteBanner", "isOpenFromSession: true");
                        j jVar = new j();
                        c.ddG().uMN = jVar;
                        abh abh = new abh();
                        abh.scene = 8;
                        jVar.a(deI.uOv, Long.valueOf(deI.uOt), true, (Context) b.this.vlu.get(), deI.uOw, deI.uOx, abh);
                        AppMethodBeat.o(27112);
                    } else {
                        com.tencent.mm.plugin.report.service.h.pYm.e(14789, Integer.valueOf(1));
                        ab.i("WNNoteBanner", "isOpenFromSession: false");
                        g gVar = new g();
                        c.ddG().uMN = gVar;
                        abh abh2 = new abh();
                        abh2.scene = 8;
                        gVar.a(deI.uOs, (Context) b.this.vlu.get(), Boolean.TRUE, deI.uOw, deI.uOx, abh2, null);
                        AppMethodBeat.o(27112);
                    }
                }
            });
        }
        AppMethodBeat.o(27113);
    }

    public final int getLayoutId() {
        return R.layout.b7t;
    }

    public final int getOrder() {
        return 0;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(27114);
        if (this.view != null) {
            this.view.findViewById(R.id.flg).setVisibility(i);
        }
        AppMethodBeat.o(27114);
    }

    public final boolean aMN() {
        boolean z;
        AppMethodBeat.i(27115);
        q deI = h.deH().deI();
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.b7t);
            this.gne.setBackgroundResource(R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(R.drawable.a_q);
        }
        if (deI != null && deI.uOr && deI.uOt > 0 && !bo.isNullOrNil(deI.uOv)) {
            z = true;
        } else if (deI == null || deI.uOr || f.jD(deI.uOs) == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            String str = deI.uOu;
            if (this.gne != null) {
                this.gne.setText(str);
            }
            setVisibility(0);
            AppMethodBeat.o(27115);
            return true;
        }
        if (deI != null) {
            h.deH().a(null);
        }
        setVisibility(8);
        AppMethodBeat.o(27115);
        return false;
    }
}
