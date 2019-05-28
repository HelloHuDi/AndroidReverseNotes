package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.f */
public class C42882f extends C33813d {
    private C8910b kul;
    public String kuu;
    private String kuv;

    private C8910b bfv() {
        AppMethodBeat.m2504i(54295);
        if (this.kul == null) {
            this.kul = C8910b.m16064me(this.kua.field_content);
        }
        C8910b c8910b = this.kul;
        AppMethodBeat.m2505o(54295);
        return c8910b;
    }

    public String bfo() {
        AppMethodBeat.m2504i(54296);
        String str;
        if (bfv() != null) {
            str = bfv().fgp;
            AppMethodBeat.m2505o(54296);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(54296);
        return str;
    }

    public String getFileName() {
        AppMethodBeat.m2504i(54297);
        String str;
        if (bfv() != null) {
            str = bfv().title;
            AppMethodBeat.m2505o(54297);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(54297);
        return str;
    }

    public int bfp() {
        AppMethodBeat.m2504i(54298);
        if (bfv() != null) {
            int i = bfv().fgo;
            AppMethodBeat.m2505o(54298);
            return i;
        }
        AppMethodBeat.m2505o(54298);
        return 0;
    }

    /* renamed from: a */
    public final void mo6914a(C38787m c38787m, int i) {
        AppMethodBeat.m2504i(54299);
        super.mo6912a(c38787m, i);
        c38787m.kuI.setVisibility(0);
        c38787m.kuI.setText(getFileName());
        c38787m.kuJ.setVisibility(0);
        c38787m.kuJ.setText(C5046bo.m7565ga((long) bfp()));
        ImageView imageView = c38787m.kuG;
        if (this.kuv == null) {
            this.kuv = C42887b.m76152HL(bfo());
        }
        imageView.setBackgroundColor(Color.parseColor(this.kuv));
        AppMethodBeat.m2505o(54299);
    }

    public C42882f(C33817g c33817g, C7620bi c7620bi, String str) {
        super(c33817g, c7620bi);
        this.kuu = str;
    }

    /* renamed from: a */
    public void mo6913a(View view, C11376a c11376a) {
        AppMethodBeat.m2504i(54300);
        if (!(bfn().mo68416gZ(this.kua.field_msgId) || mo23124kq())) {
            if (isEnable()) {
                C42887b.m76164f(getContext(), this.kua.field_msgId);
                AppMethodBeat.m2505o(54300);
                return;
            }
            C42887b.m76153I(getContext(), bfn().mMaxCount);
        }
        AppMethodBeat.m2505o(54300);
    }

    public int getType() {
        return 1;
    }
}
