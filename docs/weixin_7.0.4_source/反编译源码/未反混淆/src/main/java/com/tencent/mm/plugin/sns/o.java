package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.storage.az;

public final class o implements m {
    public final TimeLineObject tC(String str) {
        AppMethodBeat.i(35637);
        TimeLineObject tC = e.tC(str);
        AppMethodBeat.o(35637);
        return tC;
    }

    public final boolean jM(long j) {
        AppMethodBeat.i(35638);
        n kD = af.cnF().kD(j);
        if (kD == null) {
            AppMethodBeat.o(35638);
            return false;
        } else if (kD.cqu().xfI.wbK.size() > 0) {
            AppMethodBeat.o(35638);
            return true;
        } else {
            AppMethodBeat.o(35638);
            return false;
        }
    }

    public final void a(long j, ImageView imageView, int i) {
        AppMethodBeat.i(35639);
        n kD = af.cnF().kD(j);
        if (kD == null) {
            AppMethodBeat.o(35639);
            return;
        }
        TimeLineObject cqu = kD.cqu();
        if (cqu.xfI.wbK.size() > 0) {
            bau bau = (bau) cqu.xfI.wbK.get(0);
            Bitmap b = af.cnC().b(bau);
            if (b != null) {
                imageView.setImageBitmap(b);
                AppMethodBeat.o(35639);
                return;
            }
            af.cnC().b(bau, imageView, i, az.xYU);
        }
        AppMethodBeat.o(35639);
    }
}
