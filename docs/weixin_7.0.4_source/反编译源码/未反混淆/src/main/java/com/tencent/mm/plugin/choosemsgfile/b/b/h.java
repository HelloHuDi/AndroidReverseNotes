package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class h extends d {
    private String kum;
    private String kuw;

    /* Access modifiers changed, original: protected|final */
    public final String aan() {
        AppMethodBeat.i(54304);
        if (this.kum == null) {
            o.all();
            this.kum = t.ui(this.kua.field_imgPath);
        }
        String str = this.kum;
        AppMethodBeat.o(54304);
        return str;
    }

    public h(g gVar, bi biVar) {
        super(gVar, biVar);
    }

    public final void a(m mVar, int i) {
        AppMethodBeat.i(54305);
        super.a(mVar, i);
        mVar.kuK.setVisibility(0);
        mVar.kuL.setVisibility(0);
        TextView textView = mVar.kuL;
        if (this.kuw == null) {
            this.kuw = bo.mK(u.ut(this.kua.field_imgPath).fXd);
        }
        textView.setText(bo.bc(this.kuw, ""));
        AppMethodBeat.o(54305);
    }

    public final int getType() {
        return 3;
    }

    public final void a(View view, a aVar) {
        AppMethodBeat.i(54306);
        b.a(this.kuj.bfy().getContext(), view, aVar);
        AppMethodBeat.o(54306);
    }
}
