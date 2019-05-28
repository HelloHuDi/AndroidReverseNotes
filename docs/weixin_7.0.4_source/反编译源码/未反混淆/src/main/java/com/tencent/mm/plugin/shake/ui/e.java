package com.tencent.mm.plugin.shake.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class e {
    public static void a(ImageView imageView, String str, int i, boolean z) {
        AppMethodBeat.i(24908);
        if (imageView == null) {
            AppMethodBeat.o(24908);
            return;
        }
        imageView.setImageBitmap(null);
        if (!bo.isNullOrNil(str)) {
            a aVar = new a();
            aVar.ePJ = m.sw(str);
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.eQf = z;
            if (i != 0) {
                aVar.ePV = i;
            }
            o.ahp().a(str, imageView, aVar.ahG());
        }
        AppMethodBeat.o(24908);
    }

    public static String ckT() {
        AppMethodBeat.i(24909);
        List<f> cjK = m.cjT().cjK();
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar : cjK) {
            stringBuilder.append(fVar.field_reserved1);
            stringBuilder.append("|");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(24909);
        return stringBuilder2;
    }
}
