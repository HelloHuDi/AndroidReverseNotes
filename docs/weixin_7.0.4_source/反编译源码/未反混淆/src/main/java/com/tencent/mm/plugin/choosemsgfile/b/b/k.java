package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;

public class k extends a<n> {
    private String edV;
    private String kuA;
    private b kul;
    public String kuu;
    private String kux;
    private Integer kuy;
    private String kuz;

    public final /* synthetic */ void T(v vVar) {
        AppMethodBeat.i(54322);
        a((n) vVar);
        AppMethodBeat.o(54322);
    }

    private b bfv() {
        AppMethodBeat.i(54311);
        if (this.kul == null) {
            this.kul = b.me(this.kua.field_content);
        }
        b bVar = this.kul;
        AppMethodBeat.o(54311);
        return bVar;
    }

    public String getUsername() {
        AppMethodBeat.i(54312);
        if (this.edV == null) {
            this.edV = com.tencent.mm.plugin.choosemsgfile.b.d.b.b(this.kua, t.kH(this.kuu));
        }
        String str = this.edV;
        AppMethodBeat.o(54312);
        return str;
    }

    public String bfo() {
        AppMethodBeat.i(54313);
        String str;
        if (bfv() != null) {
            str = bfv().fgp;
            AppMethodBeat.o(54313);
            return str;
        }
        str = "";
        AppMethodBeat.o(54313);
        return str;
    }

    public int bfw() {
        AppMethodBeat.i(54314);
        if (this.kuy == null) {
            this.kuy = Integer.valueOf(c.LX(bfo()));
        }
        int intValue = this.kuy.intValue();
        AppMethodBeat.o(54314);
        return intValue;
    }

    public String getFileName() {
        AppMethodBeat.i(54315);
        String str;
        if (bfv() != null) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(this.kuu);
            if (aoO != null) {
                this.kux = aoO.Oi();
            }
            str = bfv().title;
            AppMethodBeat.o(54315);
            return str;
        }
        str = "";
        AppMethodBeat.o(54315);
        return str;
    }

    public int bfp() {
        AppMethodBeat.i(54316);
        if (bfv() != null) {
            int i = bfv().fgo;
            AppMethodBeat.o(54316);
            return i;
        }
        AppMethodBeat.o(54316);
        return 0;
    }

    private String bfx() {
        AppMethodBeat.i(54317);
        if (this.kuz == null) {
            u uVar = null;
            if (t.kH(this.kuu)) {
                uVar = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.kuu);
            }
            if (uVar != null) {
                this.kuz = uVar.mJ(getUsername());
            } else {
                this.kuz = "";
            }
        }
        String str = this.kuz;
        AppMethodBeat.o(54317);
        return str;
    }

    private String Hr() {
        AppMethodBeat.i(54318);
        if (this.kuA == null) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(this.kuu);
            if (aoO != null) {
                this.kuA = aoO.field_conRemark;
            } else {
                this.kuA = "";
            }
        }
        String str = this.kuA;
        AppMethodBeat.o(54318);
        return str;
    }

    public k(com.tencent.mm.plugin.choosemsgfile.b.c.g gVar, bi biVar, String str) {
        super(gVar, biVar);
        this.kuu = str;
    }

    public void a(View view, a aVar) {
        AppMethodBeat.i(54319);
        if (!(bfn().gZ(this.kua.field_msgId) || kq())) {
            if (isEnable()) {
                com.tencent.mm.plugin.choosemsgfile.b.d.b.f(getContext(), this.kua.field_msgId);
                AppMethodBeat.o(54319);
                return;
            }
            com.tencent.mm.plugin.choosemsgfile.b.d.b.I(getContext(), bfn().mMaxCount);
        }
        AppMethodBeat.o(54319);
    }

    private void a(final n nVar) {
        AppMethodBeat.i(54320);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            b(nVar);
            AppMethodBeat.o(54320);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54310);
                k.a(k.this, nVar);
                AppMethodBeat.o(54310);
            }
        });
        AppMethodBeat.o(54320);
    }

    private void b(n nVar) {
        AppMethodBeat.i(54321);
        switch (this.kuk) {
            case 0:
                nVar.gtQ.setVisibility(8);
                nVar.kuH.setVisibility(8);
                nVar.kuN.setVisibility(0);
                nVar.kuR.setVisibility(0);
                nVar.kuN.setChecked(false);
                nVar.kuP.setVisibility(8);
                break;
            case 1:
                nVar.gtQ.setVisibility(0);
                nVar.kuH.setVisibility(8);
                nVar.kuN.setVisibility(8);
                nVar.kuR.setVisibility(8);
                nVar.kuP.setVisibility(8);
                AppMethodBeat.o(54321);
                return;
            case 2:
                nVar.gtQ.setVisibility(0);
                nVar.kuH.setVisibility(0);
                nVar.kuN.setVisibility(8);
                nVar.kuR.setVisibility(8);
                nVar.kuP.setVisibility(8);
                if (this.alq > 0) {
                    int i = (int) ((((float) this.Lp) / ((float) this.alq)) * 100.0f);
                    if (i == -1 || i >= 100) {
                        nVar.kuH.setProgress(100);
                        AppMethodBeat.o(54321);
                        return;
                    }
                    nVar.kuH.setProgress(i);
                    AppMethodBeat.o(54321);
                    return;
                }
                break;
            case 3:
                nVar.gtQ.setVisibility(8);
                nVar.kuH.setVisibility(8);
                nVar.kuN.setVisibility(0);
                nVar.kuR.setVisibility(0);
                nVar.kuP.setVisibility(8);
                AppMethodBeat.o(54321);
                return;
            case 4:
                nVar.gtQ.setVisibility(8);
                nVar.kuH.setVisibility(8);
                nVar.kuN.setVisibility(8);
                nVar.kuR.setVisibility(8);
                nVar.kuP.setVisibility(0);
                nVar.hrg.setText(bfo().toUpperCase() + " " + getContext().getString(R.string.apj));
                AppMethodBeat.o(54321);
                return;
            case 5:
                nVar.gtQ.setVisibility(8);
                nVar.kuH.setVisibility(8);
                nVar.kuN.setVisibility(8);
                nVar.kuR.setVisibility(8);
                nVar.kuP.setVisibility(0);
                nVar.hrg.setText(bfo().toUpperCase() + " " + getContext().getString(R.string.api));
                AppMethodBeat.o(54321);
                return;
        }
        AppMethodBeat.o(54321);
    }

    public int getType() {
        return 1;
    }
}
