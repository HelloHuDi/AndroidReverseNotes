package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.storage.C46627q;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.m */
public final class C38699m extends C45762c {
    public ImageView iNr;
    public ImageView jOX;
    public View jPQ;
    public TextView jPV;
    public View jPW;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.m$1 */
    public class C387001 implements C35837a {
        final /* synthetic */ C46627q jEl;
        /* renamed from: sN */
        final /* synthetic */ int f16162sN;

        public C387001(C46627q c46627q, int i) {
            this.jEl = c46627q;
            this.f16162sN = i;
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(14275);
            C38699m.this.jPd.setVisibility(0);
            C38699m.this.jPV.setTextColor(C38699m.this.mContext.getResources().getColor(C25738R.color.a69));
            C38699m.this.jPi.setTextColor(C38699m.this.mContext.getResources().getColor(C25738R.color.a69));
            C38699m.this.jPa.setTextColor(-436207617);
            C38699m.this.jPm.jNp.mo6785m(this.jEl.field_msgId, this.f16162sN);
            AppMethodBeat.m2505o(14275);
        }
    }

    /* renamed from: a */
    public final void mo22941a(View view, C38701a c38701a) {
        AppMethodBeat.m2504i(14276);
        super.mo22941a(view, c38701a);
        if (this.jOR != null) {
            AppMethodBeat.m2505o(14276);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(2131821831);
        if (viewStub == null) {
            AppMethodBeat.m2505o(14276);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(2131821868);
        this.jPn = view.findViewById(2131821869);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(2131821404);
        this.jPd = (ImageView) this.jOR.findViewById(2131821860);
        this.iNr = (ImageView) this.jOR.findViewById(2131821872);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821185);
        this.jPV = (TextView) this.jOR.findViewById(2131821873);
        this.jPQ = this.jOR.findViewById(2131821870);
        this.jPe = (ImageView) this.jOR.findViewById(2131821855);
        this.jPW = this.jOR.findViewById(2131821871);
        AppMethodBeat.m2505o(14276);
    }
}
