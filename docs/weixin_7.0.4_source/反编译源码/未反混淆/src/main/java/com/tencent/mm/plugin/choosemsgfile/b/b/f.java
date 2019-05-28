package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public class f extends d {
    private b kul;
    public String kuu;
    private String kuv;

    private b bfv() {
        AppMethodBeat.i(54295);
        if (this.kul == null) {
            this.kul = b.me(this.kua.field_content);
        }
        b bVar = this.kul;
        AppMethodBeat.o(54295);
        return bVar;
    }

    public String bfo() {
        AppMethodBeat.i(54296);
        String str;
        if (bfv() != null) {
            str = bfv().fgp;
            AppMethodBeat.o(54296);
            return str;
        }
        str = "";
        AppMethodBeat.o(54296);
        return str;
    }

    public String getFileName() {
        AppMethodBeat.i(54297);
        String str;
        if (bfv() != null) {
            str = bfv().title;
            AppMethodBeat.o(54297);
            return str;
        }
        str = "";
        AppMethodBeat.o(54297);
        return str;
    }

    public int bfp() {
        AppMethodBeat.i(54298);
        if (bfv() != null) {
            int i = bfv().fgo;
            AppMethodBeat.o(54298);
            return i;
        }
        AppMethodBeat.o(54298);
        return 0;
    }

    public final void a(m mVar, int i) {
        AppMethodBeat.i(54299);
        super.a(mVar, i);
        mVar.kuI.setVisibility(0);
        mVar.kuI.setText(getFileName());
        mVar.kuJ.setVisibility(0);
        mVar.kuJ.setText(bo.ga((long) bfp()));
        ImageView imageView = mVar.kuG;
        if (this.kuv == null) {
            this.kuv = com.tencent.mm.plugin.choosemsgfile.b.d.b.HL(bfo());
        }
        imageView.setBackgroundColor(Color.parseColor(this.kuv));
        AppMethodBeat.o(54299);
    }

    public f(g gVar, bi biVar, String str) {
        super(gVar, biVar);
        this.kuu = str;
    }

    public void a(View view, a aVar) {
        AppMethodBeat.i(54300);
        if (!(bfn().gZ(this.kua.field_msgId) || kq())) {
            if (isEnable()) {
                com.tencent.mm.plugin.choosemsgfile.b.d.b.f(getContext(), this.kua.field_msgId);
                AppMethodBeat.o(54300);
                return;
            }
            com.tencent.mm.plugin.choosemsgfile.b.d.b.I(getContext(), bfn().mMaxCount);
        }
        AppMethodBeat.o(54300);
    }

    public int getType() {
        return 1;
    }
}
