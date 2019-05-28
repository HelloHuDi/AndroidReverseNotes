package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.storage.C46627q;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.k */
public final class C38698k extends C45762c {
    public ImageView jOX;
    public View jPS;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.k$1 */
    public class C112401 implements C35837a {
        final /* synthetic */ int ewG;
        final /* synthetic */ C46627q jEl;
        /* renamed from: sN */
        final /* synthetic */ int f2893sN;

        public C112401(int i, C46627q c46627q, int i2) {
            this.ewG = i;
            this.jEl = c46627q;
            this.f2893sN = i2;
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(14272);
            C38698k.this.jPi.setTextColor(C38698k.this.mContext.getResources().getColor(C25738R.color.a69));
            C38698k.this.jPa.setTextColor(-436207617);
            if (this.ewG == 1) {
                C38698k.this.jPS.setBackgroundResource(C25738R.drawable.f6450el);
            } else {
                C38698k.this.jPS.setBackgroundResource(C25738R.drawable.f6447eh);
            }
            C38698k.this.jPm.jNp.mo6785m(this.jEl.field_msgId, this.f2893sN);
            AppMethodBeat.m2505o(14272);
        }
    }

    /* renamed from: a */
    public final void mo22941a(View view, C38701a c38701a) {
        AppMethodBeat.m2504i(14273);
        super.mo22941a(view, c38701a);
        if (this.jOR != null) {
            AppMethodBeat.m2505o(14273);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(2131821830);
        if (viewStub == null) {
            AppMethodBeat.m2505o(14273);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(2131821852);
        this.jPn = view.findViewById(2131821853);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(2131821842);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821185);
        this.jPd = (ImageView) this.jOR.findViewById(2131821860);
        this.jPe = (ImageView) this.jOR.findViewById(2131821855);
        this.jPS = this.jOR.findViewById(2131821854);
        AppMethodBeat.m2505o(14273);
    }
}
