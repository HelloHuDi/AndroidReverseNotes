package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a extends b {
    int aLB = 0;
    private View jAp = null;
    b zvN;
    private d zvO;
    a zvP;

    public interface a {
        void aeT(String str);

        void in(String str, String str2);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(34632);
        if (this.view != null) {
            this.jAp = this.view.findViewById(R.id.o4);
            this.zvO = new d();
            this.zvO.zvT = this.jAp;
            this.zvO.zvU = (Button) this.view.findViewById(R.id.o5);
            this.zvO.zvU.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34628);
                    if (!(a.this.zvN == null || a.this.zvP == null)) {
                        a.this.zvP.aeT(a.this.zvN.Pz(a.this.aLB).zvS.id);
                    }
                    AppMethodBeat.o(34628);
                }
            });
            this.jAp.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34629);
                    if (!(a.this.zvN == null || a.this.zvP == null)) {
                        c Pz = a.this.zvN.Pz(a.this.aLB);
                        a.this.zvP.in(Pz.zvS.id, Pz.zvS.url);
                    }
                    AppMethodBeat.o(34629);
                }
            });
        }
        AppMethodBeat.o(34632);
    }

    public final int getLayoutId() {
        return R.layout.b5;
    }

    public final void destroy() {
        AppMethodBeat.i(34633);
        if (g.RN().QY()) {
            aw.ZK();
            c.Ry().b(this.zvN);
        }
        AppMethodBeat.o(34633);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(34634);
        if (this.jAp != null) {
            this.jAp.setVisibility(i);
        }
        AppMethodBeat.o(34634);
    }

    public final void release() {
        this.zvN = null;
    }

    public final boolean aMN() {
        AppMethodBeat.i(34635);
        this.zvN = new b((Context) this.vlu.get());
        this.zvP = new a() {
            public final void in(String str, String str2) {
                AppMethodBeat.i(34630);
                com.tencent.mm.pluginsdk.h.a.a.diD();
                aw.ZK();
                c.XL().c(new l(2, str));
                ab.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(str2)));
                com.tencent.mm.pluginsdk.r.a.vax.a((Context) a.this.vlu.get(), str2, true);
                AppMethodBeat.o(34630);
            }

            public final void aeT(String str) {
                AppMethodBeat.i(34631);
                com.tencent.mm.pluginsdk.h.a.a.diD();
                aw.ZK();
                c.XL().c(new l(3, str));
                AppMethodBeat.o(34631);
            }
        };
        com.tencent.mm.pluginsdk.h.a.a fO = com.tencent.mm.pluginsdk.h.a.a.fO(ah.getContext());
        if (this.zvN != null) {
            if (fO != null) {
                int i;
                this.zvN.zvR = fO;
                this.zvN.KC();
                if (this.zvN == null || this.zvN.getCount() <= 0 || this.zvN.Pz(0).a(this.zvO) != 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    ab.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
                    setVisibility(0);
                    AppMethodBeat.o(34635);
                    return true;
                }
            }
            setVisibility(8);
        }
        setVisibility(8);
        AppMethodBeat.o(34635);
        return false;
    }
}
