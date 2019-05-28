package com.tencent.p177mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.base.stub.C38669d.C27497a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;

/* renamed from: com.tencent.mm.plugin.base.stub.a */
public final class C2677a extends C38669d {

    /* renamed from: com.tencent.mm.plugin.base.stub.a$1 */
    class C26761 implements OnClickListener {
        C26761() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(18109);
            C43155a bDb = C20928a.bDb();
            if (bDb != null) {
                bDb.mo36282m(C2677a.this.openId, C1853r.m3821YC(), C2677a.this.appId);
            }
            C2677a.this.jDq.mo11382ft(false);
            AppMethodBeat.m2505o(18109);
        }
    }

    public C2677a(Context context, String str, String str2, C27497a c27497a) {
        super(context, str, str2, c27497a);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aVh() {
        AppMethodBeat.m2504i(18110);
        C30379h.m48433a(this.context, (int) C25738R.string.c7h, (int) C25738R.string.f9238tz, false, new C26761());
        AppMethodBeat.m2505o(18110);
    }
}
