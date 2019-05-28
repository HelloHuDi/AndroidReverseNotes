package com.tencent.p177mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1024b.C29034m;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.storage.C44222az;

/* renamed from: com.tencent.mm.plugin.sns.o */
public final class C34964o implements C29034m {
    /* renamed from: tC */
    public final TimeLineObject mo47122tC(String str) {
        AppMethodBeat.m2504i(35637);
        TimeLineObject tC = C37953e.m64188tC(str);
        AppMethodBeat.m2505o(35637);
        return tC;
    }

    /* renamed from: jM */
    public final boolean mo47121jM(long j) {
        AppMethodBeat.m2504i(35638);
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD == null) {
            AppMethodBeat.m2505o(35638);
            return false;
        } else if (kD.cqu().xfI.wbK.size() > 0) {
            AppMethodBeat.m2505o(35638);
            return true;
        } else {
            AppMethodBeat.m2505o(35638);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo47120a(long j, ImageView imageView, int i) {
        AppMethodBeat.m2504i(35639);
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD == null) {
            AppMethodBeat.m2505o(35639);
            return;
        }
        TimeLineObject cqu = kD.cqu();
        if (cqu.xfI.wbK.size() > 0) {
            bau bau = (bau) cqu.xfI.wbK.get(0);
            Bitmap b = C13373af.cnC().mo37454b(bau);
            if (b != null) {
                imageView.setImageBitmap(b);
                AppMethodBeat.m2505o(35639);
                return;
            }
            C13373af.cnC().mo37455b(bau, imageView, i, C44222az.xYU);
        }
        AppMethodBeat.m2505o(35639);
    }
}
