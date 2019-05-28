package com.tencent.p177mm.plugin.shake.p511ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.shake.p1019b.C13248f;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.shake.ui.e */
public final class C43527e {
    /* renamed from: a */
    public static void m77787a(ImageView imageView, String str, int i, boolean z) {
        AppMethodBeat.m2504i(24908);
        if (imageView == null) {
            AppMethodBeat.m2505o(24908);
            return;
        }
        imageView.setImageBitmap(null);
        if (!C5046bo.isNullOrNil(str)) {
            C17927a c17927a = new C17927a();
            c17927a.ePJ = C28987m.m46015sw(str);
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.eQf = z;
            if (i != 0) {
                c17927a.ePV = i;
            }
            C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        }
        AppMethodBeat.m2505o(24908);
    }

    public static String ckT() {
        AppMethodBeat.m2504i(24909);
        List<C13248f> cjK = C28987m.cjT().cjK();
        StringBuilder stringBuilder = new StringBuilder();
        for (C13248f c13248f : cjK) {
            stringBuilder.append(c13248f.field_reserved1);
            stringBuilder.append("|");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(24909);
        return stringBuilder2;
    }
}
