package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C38689c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.storage.C46627q;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.i */
public final class C11237i extends C45762c {
    public ImageView jOX;
    public ImageView jOY;
    public TextView jPN;
    public ImageView jPO;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.i$1 */
    public class C112381 implements C35837a {
        final /* synthetic */ C46627q jEl;
        /* renamed from: sN */
        final /* synthetic */ int f2891sN;

        public C112381(C46627q c46627q, int i) {
            this.jEl = c46627q;
            this.f2891sN = i;
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(14268);
            C11237i.this.jPd.setVisibility(0);
            if ((this.jEl.field_msgId + "_0").equals(C38689c.aYR())) {
                C11237i.this.jOY.setImageResource(C25738R.drawable.f6566ic);
            } else {
                C11237i.this.jOY.setImageResource(C25738R.drawable.f6567id);
            }
            C11237i.this.jPm.jNp.mo6785m(this.jEl.field_msgId, this.f2891sN);
            AppMethodBeat.m2505o(14268);
        }
    }

    /* renamed from: a */
    public final void mo22941a(View view, C38701a c38701a) {
        AppMethodBeat.m2504i(14269);
        super.mo22941a(view, c38701a);
        if (this.jOR != null) {
            AppMethodBeat.m2505o(14269);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(2131821834);
        if (viewStub == null) {
            AppMethodBeat.m2505o(14269);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(2131821856);
        this.jPn = view.findViewById(2131821857);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(2131821404);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821185);
        this.jPN = (TextView) this.jOR.findViewById(2131821858);
        this.jOY = (ImageView) this.jOR.findViewById(2131821843);
        this.jPO = (ImageView) this.jOR.findViewById(2131821859);
        this.jPd = (ImageView) this.jOR.findViewById(2131821860);
        AppMethodBeat.m2505o(14269);
    }
}
