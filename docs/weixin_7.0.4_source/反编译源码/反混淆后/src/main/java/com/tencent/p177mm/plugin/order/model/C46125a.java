package com.tencent.p177mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.order.p480ui.p1009a.C39483e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.order.model.a */
public final class C46125a {

    /* renamed from: com.tencent.mm.plugin.order.model.a$a */
    public interface C3567a {
        /* renamed from: a */
        List<Preference> mo8135a(Context context, C15541f c15541f, MallTransactionObject mallTransactionObject);
    }

    /* renamed from: a */
    public static C39483e m86078a(final Context context, final MallTransactionObject mallTransactionObject) {
        AppMethodBeat.m2504i(43748);
        C39483e c39483e = new C39483e(context);
        if (C5046bo.isNullOrNil(mallTransactionObject.pcv)) {
            c39483e.pez = context.getString(C25738R.string.flq);
        } else {
            c39483e.pez = context.getString(C25738R.string.fln);
        }
        c39483e.mOnClickListener = new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.order.model.a$1$1 */
            class C214201 implements C30382d {
                C214201() {
                }

                /* renamed from: bV */
                public final void mo4975bV(int i, int i2) {
                    AppMethodBeat.m2504i(43746);
                    C46125a.m86079a(i2, context, mallTransactionObject);
                    AppMethodBeat.m2505o(43746);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(43747);
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                if (!C5046bo.isNullOrNil(mallTransactionObject.pcm)) {
                    linkedList2.add(Integer.valueOf(0));
                    linkedList.add(context.getString(C25738R.string.flo));
                }
                if (!C5046bo.isNullOrNil(mallTransactionObject.pbP)) {
                    linkedList2.add(Integer.valueOf(1));
                    linkedList.add(context.getString(C25738R.string.flp));
                }
                if (!C5046bo.isNullOrNil(mallTransactionObject.pcv)) {
                    linkedList2.add(Integer.valueOf(2));
                    linkedList.add(context.getString(C25738R.string.flr));
                }
                if (linkedList2.size() == 1) {
                    C46125a.m86079a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                    AppMethodBeat.m2505o(43747);
                    return;
                }
                C30379h.m48420a(context, null, linkedList, linkedList2, null, true, new C214201());
                AppMethodBeat.m2505o(43747);
            }
        };
        AppMethodBeat.m2505o(43748);
        return c39483e;
    }

    /* renamed from: a */
    public static void m86079a(int i, Context context, MallTransactionObject mallTransactionObject) {
        AppMethodBeat.m2504i(43749);
        switch (i) {
            case 0:
                C1720g.m3537RQ();
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(mallTransactionObject.pcm);
                if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                    C36391e.m59991ae(context, mallTransactionObject.pcm);
                    AppMethodBeat.m2505o(43749);
                    return;
                }
                C36391e.m59993ag(context, mallTransactionObject.pcm);
                AppMethodBeat.m2505o(43749);
                return;
            case 1:
                C36391e.m59999bU(context, mallTransactionObject.pbP);
                AppMethodBeat.m2505o(43749);
                return;
            case 2:
                C36391e.m60016n(context, mallTransactionObject.pcv, false);
                break;
        }
        AppMethodBeat.m2505o(43749);
    }
}
