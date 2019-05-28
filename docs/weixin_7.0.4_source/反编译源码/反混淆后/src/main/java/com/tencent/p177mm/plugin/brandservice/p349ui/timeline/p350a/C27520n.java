package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.n */
public final class C27520n extends C45762c {
    public ImageView jOY;
    public TextView jPY;
    public MMNeat7extView jPi;

    /* renamed from: a */
    public final void mo22941a(View view, C38701a c38701a) {
        AppMethodBeat.m2504i(14277);
        super.mo22941a(view, c38701a);
        if (this.jOR != null) {
            AppMethodBeat.m2505o(14277);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(2131821833);
        if (viewStub == null) {
            AppMethodBeat.m2505o(14277);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(2131821874);
        this.jPn = view.findViewById(2131821875);
        aWI();
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821185);
        this.jPY = (TextView) this.jOR.findViewById(2131821873);
        this.jOY = (ImageView) this.jOR.findViewById(2131821876);
        AppMethodBeat.m2505o(14277);
    }
}
