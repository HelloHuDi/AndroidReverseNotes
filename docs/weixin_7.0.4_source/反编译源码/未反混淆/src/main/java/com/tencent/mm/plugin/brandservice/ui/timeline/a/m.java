package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class m extends c {
    public ImageView iNr;
    public ImageView jOX;
    public View jPQ;
    public TextView jPV;
    public View jPW;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.m$1 */
    public class AnonymousClass1 implements a {
        final /* synthetic */ q jEl;
        final /* synthetic */ int sN;

        public AnonymousClass1(q qVar, int i) {
            this.jEl = qVar;
            this.sN = i;
        }

        public final void onFinish() {
            AppMethodBeat.i(14275);
            m.this.jPd.setVisibility(0);
            m.this.jPV.setTextColor(m.this.mContext.getResources().getColor(R.color.a69));
            m.this.jPi.setTextColor(m.this.mContext.getResources().getColor(R.color.a69));
            m.this.jPa.setTextColor(-436207617);
            m.this.jPm.jNp.m(this.jEl.field_msgId, this.sN);
            AppMethodBeat.o(14275);
        }
    }

    public final void a(View view, com.tencent.mm.plugin.brandservice.ui.timeline.a aVar) {
        AppMethodBeat.i(14276);
        super.a(view, aVar);
        if (this.jOR != null) {
            AppMethodBeat.o(14276);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7r);
        if (viewStub == null) {
            AppMethodBeat.o(14276);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(R.id.a8r);
        this.jPn = view.findViewById(R.id.a8s);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(R.id.wj);
        this.jPd = (ImageView) this.jOR.findViewById(R.id.a8j);
        this.iNr = (ImageView) this.jOR.findViewById(R.id.a8v);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.qm);
        this.jPV = (TextView) this.jOR.findViewById(R.id.a8w);
        this.jPQ = this.jOR.findViewById(R.id.a8t);
        this.jPe = (ImageView) this.jOR.findViewById(R.id.a8e);
        this.jPW = this.jOR.findViewById(R.id.a8u);
        AppMethodBeat.o(14276);
    }
}
