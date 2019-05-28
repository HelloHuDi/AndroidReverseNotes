package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class i extends c {
    public ImageView jOX;
    public ImageView jOY;
    public TextView jPN;
    public ImageView jPO;
    public MMNeat7extView jPi;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.i$1 */
    public class AnonymousClass1 implements a {
        final /* synthetic */ q jEl;
        final /* synthetic */ int sN;

        public AnonymousClass1(q qVar, int i) {
            this.jEl = qVar;
            this.sN = i;
        }

        public final void onFinish() {
            AppMethodBeat.i(14268);
            i.this.jPd.setVisibility(0);
            if ((this.jEl.field_msgId + "_0").equals(c.aYR())) {
                i.this.jOY.setImageResource(R.drawable.ic);
            } else {
                i.this.jOY.setImageResource(R.drawable.id);
            }
            i.this.jPm.jNp.m(this.jEl.field_msgId, this.sN);
            AppMethodBeat.o(14268);
        }
    }

    public final void a(View view, com.tencent.mm.plugin.brandservice.ui.timeline.a aVar) {
        AppMethodBeat.i(14269);
        super.a(view, aVar);
        if (this.jOR != null) {
            AppMethodBeat.o(14269);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7u);
        if (viewStub == null) {
            AppMethodBeat.o(14269);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(R.id.a8f);
        this.jPn = view.findViewById(R.id.a8g);
        aWI();
        this.jOX = (ImageView) this.jOR.findViewById(R.id.wj);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.qm);
        this.jPN = (TextView) this.jOR.findViewById(R.id.a8h);
        this.jOY = (ImageView) this.jOR.findViewById(R.id.a83);
        this.jPO = (ImageView) this.jOR.findViewById(R.id.a8i);
        this.jPd = (ImageView) this.jOR.findViewById(R.id.a8j);
        AppMethodBeat.o(14269);
    }
}
