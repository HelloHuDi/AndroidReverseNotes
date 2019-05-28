package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;

public final class j extends c {
    public ImageView iNr;
    public ImageView jOX;
    public View jPQ;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.j$1 */
    public class AnonymousClass1 implements a {
        final /* synthetic */ q jEl;
        final /* synthetic */ int sN;

        public AnonymousClass1(q qVar, int i) {
            this.jEl = qVar;
            this.sN = i;
        }

        public final void onFinish() {
            AppMethodBeat.i(14270);
            j.this.jPd.setVisibility(0);
            j.this.jPa.setTextColor(j.this.mContext.getResources().getColor(R.color.a69));
            j.this.iNr.setBackgroundResource(R.raw.chatting_item_biz_pic_icon);
            j.this.jPm.jNp.m(this.jEl.field_msgId, this.sN);
            AppMethodBeat.o(14270);
        }
    }

    public final void a(View view, com.tencent.mm.plugin.brandservice.ui.timeline.a aVar) {
        AppMethodBeat.i(14271);
        super.a(view, aVar);
        if (this.jOR != null) {
            AppMethodBeat.o(14271);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7s);
        if (viewStub == null) {
            AppMethodBeat.o(14271);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(R.id.a8k);
        this.jPn = view.findViewById(R.id.a8l);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(R.id.wj);
        this.jPd = (ImageView) this.jOR.findViewById(R.id.a8j);
        this.iNr = (ImageView) this.jOR.findViewById(R.id.a8n);
        this.jPQ = this.jOR.findViewById(R.id.a8m);
        this.jPe = (ImageView) this.jOR.findViewById(R.id.a8e);
        AppMethodBeat.o(14271);
    }
}
