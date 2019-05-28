package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.storage.C46627q;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.j */
public final class C42814j extends C45762c {
    public ImageView iNr;
    public ImageView jOX;
    public View jPQ;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.j$1 */
    public class C112391 implements C35837a {
        final /* synthetic */ C46627q jEl;
        /* renamed from: sN */
        final /* synthetic */ int f2892sN;

        public C112391(C46627q c46627q, int i) {
            this.jEl = c46627q;
            this.f2892sN = i;
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(14270);
            C42814j.this.jPd.setVisibility(0);
            C42814j.this.jPa.setTextColor(C42814j.this.mContext.getResources().getColor(C25738R.color.a69));
            C42814j.this.iNr.setBackgroundResource(C1318a.chatting_item_biz_pic_icon);
            C42814j.this.jPm.jNp.mo6785m(this.jEl.field_msgId, this.f2892sN);
            AppMethodBeat.m2505o(14270);
        }
    }

    /* renamed from: a */
    public final void mo22941a(View view, C38701a c38701a) {
        AppMethodBeat.m2504i(14271);
        super.mo22941a(view, c38701a);
        if (this.jOR != null) {
            AppMethodBeat.m2505o(14271);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(2131821832);
        if (viewStub == null) {
            AppMethodBeat.m2505o(14271);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(2131821861);
        this.jPn = view.findViewById(2131821862);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(2131821404);
        this.jPd = (ImageView) this.jOR.findViewById(2131821860);
        this.iNr = (ImageView) this.jOR.findViewById(2131821864);
        this.jPQ = this.jOR.findViewById(2131821863);
        this.jPe = (ImageView) this.jOR.findViewById(2131821855);
        AppMethodBeat.m2505o(14271);
    }
}
