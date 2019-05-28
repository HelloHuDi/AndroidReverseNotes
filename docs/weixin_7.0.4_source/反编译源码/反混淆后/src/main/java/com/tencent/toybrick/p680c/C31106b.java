package com.tencent.toybrick.p680c;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.p1578f.C41100a;
import com.tencent.toybrick.p680c.C44830g.C36554b;

/* renamed from: com.tencent.toybrick.c.b */
public final class C31106b extends C44830g<C31106b, C31107a> {
    public static final int AFW = 2130969818;

    /* renamed from: com.tencent.toybrick.c.b$a */
    public class C31107a extends C41100a {
        TextView AGh;

        public C31107a(View view) {
            super(view);
            AppMethodBeat.m2504i(113199);
            this.AGh = (TextView) view.findViewById(16908310);
            AppMethodBeat.m2505o(113199);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29716a(C41100a c41100a) {
        AppMethodBeat.m2504i(113201);
        ((C31107a) c41100a).AGh.setText(this.f17612IT);
        AppMethodBeat.m2505o(113201);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    public final C36554b dSy() {
        return C36554b.HINT;
    }

    /* renamed from: fy */
    public final /* synthetic */ C41100a mo29718fy(View view) {
        AppMethodBeat.m2504i(113200);
        C31107a c31107a = new C31107a(view);
        AppMethodBeat.m2505o(113200);
        return c31107a;
    }
}
