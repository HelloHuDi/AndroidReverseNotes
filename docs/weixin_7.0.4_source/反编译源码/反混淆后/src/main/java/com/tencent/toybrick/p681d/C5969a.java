package com.tencent.toybrick.p681d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.toybrick.p1427ui.BaseToyUI;
import com.tencent.toybrick.p680c.C44830g;
import java.util.LinkedList;

/* renamed from: com.tencent.toybrick.d.a */
public final class C5969a {
    public C5970a AFT;
    private BaseToyUI AGA;

    /* renamed from: com.tencent.toybrick.d.a$a */
    public class C5970a {
        public LinkedList<C44830g> AGQ = new LinkedList();
        public boolean AGR = true;
        public Drawable AGS;

        public C5970a(Context context) {
            AppMethodBeat.m2504i(113224);
            this.AGS = new ColorDrawable(context.getResources().getColor(C25738R.color.f12125t_));
            AppMethodBeat.m2505o(113224);
        }
    }

    public C5969a(BaseToyUI baseToyUI) {
        AppMethodBeat.m2504i(113225);
        this.AGA = baseToyUI;
        this.AFT = new C5970a(baseToyUI);
        AppMethodBeat.m2505o(113225);
    }
}
