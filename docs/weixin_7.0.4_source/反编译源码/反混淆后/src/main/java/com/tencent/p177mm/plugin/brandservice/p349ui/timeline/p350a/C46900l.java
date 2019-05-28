package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.l */
public final class C46900l extends C45762c {
    public View jPU;
    public MMNeat7extView jPi;

    /* renamed from: a */
    public final void mo22941a(View view, C38701a c38701a) {
        AppMethodBeat.m2504i(14274);
        super.mo22941a(view, c38701a);
        if (this.jOR != null) {
            AppMethodBeat.m2505o(14274);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(2131821835);
        if (viewStub == null) {
            AppMethodBeat.m2505o(14274);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(2131821865);
        this.jPn = view.findViewById(2131821866);
        aWI();
        this.jPU = view.findViewById(2131820695);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821185);
        AppMethodBeat.m2505o(14274);
    }
}
