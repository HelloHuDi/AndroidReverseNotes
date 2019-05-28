package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private List<c> oeL = new LinkedList();
    private boolean oeM = false;
    private boolean oeN = false;
    private TextView oeO;

    public b() {
        AppMethodBeat.i(42732);
        AppMethodBeat.o(42732);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(42733);
        if (cVar == null) {
            AppMethodBeat.o(42733);
            return;
        }
        this.oeL.add(cVar);
        AppMethodBeat.o(42733);
    }

    public final void i(TextView textView) {
        if (textView != null) {
            this.oeO = textView;
        }
    }

    public final void clear() {
        AppMethodBeat.i(42734);
        this.oeL.clear();
        this.oeO = null;
        AppMethodBeat.o(42734);
    }

    public final boolean bMy() {
        AppMethodBeat.i(42735);
        this.oeN = false;
        this.oeM = false;
        for (int i = 0; i < this.oeL.size(); i++) {
            c cVar = (c) this.oeL.get(i);
            int bKW = cVar.bKW();
            if (bKW != 0) {
                cVar.onError();
                Qn(cVar.xH(bKW));
                this.oeN = true;
            } else {
                cVar.restore();
            }
        }
        if (!(this.oeN || this.oeO == null)) {
            this.oeO.setVisibility(8);
            this.oeM = false;
        }
        boolean z = this.oeN;
        AppMethodBeat.o(42735);
        return z;
    }

    public final boolean bMz() {
        AppMethodBeat.i(42736);
        for (int i = 0; i < this.oeL.size(); i++) {
            if (((c) this.oeL.get(i)).bKW() != 0) {
                AppMethodBeat.o(42736);
                return true;
            }
        }
        AppMethodBeat.o(42736);
        return false;
    }

    private void Qn(String str) {
        AppMethodBeat.i(42737);
        if (!(this.oeO == null || bo.isNullOrNil(str))) {
            if (!this.oeM) {
                this.oeO.setText(str);
            }
            this.oeO.setVisibility(0);
            this.oeM = true;
        }
        AppMethodBeat.o(42737);
    }

    public final void Dv(String str) {
        AppMethodBeat.i(42738);
        if (this.oeO == null || bo.isNullOrNil(str)) {
            if (this.oeO != null) {
                this.oeO.setVisibility(8);
                this.oeM = false;
            }
            AppMethodBeat.o(42738);
            return;
        }
        this.oeO.setText(str);
        this.oeO.setVisibility(0);
        this.oeM = true;
        AppMethodBeat.o(42738);
    }
}
