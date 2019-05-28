package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class k extends c {
    public ImageView jOX;
    public View jPS;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.k$1 */
    public class AnonymousClass1 implements a {
        final /* synthetic */ int ewG;
        final /* synthetic */ q jEl;
        final /* synthetic */ int sN;

        public AnonymousClass1(int i, q qVar, int i2) {
            this.ewG = i;
            this.jEl = qVar;
            this.sN = i2;
        }

        public final void onFinish() {
            AppMethodBeat.i(14272);
            k.this.jPi.setTextColor(k.this.mContext.getResources().getColor(R.color.a69));
            k.this.jPa.setTextColor(-436207617);
            if (this.ewG == 1) {
                k.this.jPS.setBackgroundResource(R.drawable.el);
            } else {
                k.this.jPS.setBackgroundResource(R.drawable.eh);
            }
            k.this.jPm.jNp.m(this.jEl.field_msgId, this.sN);
            AppMethodBeat.o(14272);
        }
    }

    public final void a(View view, com.tencent.mm.plugin.brandservice.ui.timeline.a aVar) {
        AppMethodBeat.i(14273);
        super.a(view, aVar);
        if (this.jOR != null) {
            AppMethodBeat.o(14273);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7q);
        if (viewStub == null) {
            AppMethodBeat.o(14273);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(R.id.a8b);
        this.jPn = view.findViewById(R.id.a8c);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(R.id.a82);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.qm);
        this.jPd = (ImageView) this.jOR.findViewById(R.id.a8j);
        this.jPe = (ImageView) this.jOR.findViewById(R.id.a8e);
        this.jPS = this.jOR.findViewById(R.id.a8d);
        AppMethodBeat.o(14273);
    }
}
