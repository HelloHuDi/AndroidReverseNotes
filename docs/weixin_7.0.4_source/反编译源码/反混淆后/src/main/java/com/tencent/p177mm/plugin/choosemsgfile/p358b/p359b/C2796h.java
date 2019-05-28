package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.h */
public final class C2796h extends C33813d {
    private String kum;
    private String kuw;

    /* Access modifiers changed, original: protected|final */
    public final String aan() {
        AppMethodBeat.m2504i(54304);
        if (this.kum == null) {
            C37961o.all();
            this.kum = C9720t.m17304ui(this.kua.field_imgPath);
        }
        String str = this.kum;
        AppMethodBeat.m2505o(54304);
        return str;
    }

    public C2796h(C33817g c33817g, C7620bi c7620bi) {
        super(c33817g, c7620bi);
    }

    /* renamed from: a */
    public final void mo6914a(C38787m c38787m, int i) {
        AppMethodBeat.m2504i(54305);
        super.mo6912a(c38787m, i);
        c38787m.kuK.setVisibility(0);
        c38787m.kuL.setVisibility(0);
        TextView textView = c38787m.kuL;
        if (this.kuw == null) {
            this.kuw = C5046bo.m7577mK(C26494u.m42268ut(this.kua.field_imgPath).fXd);
        }
        textView.setText(C5046bo.m7532bc(this.kuw, ""));
        AppMethodBeat.m2505o(54305);
    }

    public final int getType() {
        return 3;
    }

    /* renamed from: a */
    public final void mo6913a(View view, C11376a c11376a) {
        AppMethodBeat.m2504i(54306);
        C42887b.m76158a(this.kuj.bfy().getContext(), view, c11376a);
        AppMethodBeat.m2505o(54306);
    }
}
