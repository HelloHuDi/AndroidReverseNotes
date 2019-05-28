package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i;

public final class b extends i implements com.tencent.mm.ah.d.a {

    public static class a {
        static com.tencent.mm.pluginsdk.ui.i.a pqK;

        public static void b(ImageView imageView, String str) {
            b bVar;
            AppMethodBeat.i(23974);
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                bVar = new b(str, (byte) 0);
            } else {
                bVar = (b) drawable;
            }
            bVar.setTag(str);
            imageView.setImageDrawable(bVar);
            AppMethodBeat.o(23974);
        }
    }

    /* synthetic */ b(String str, byte b) {
        this(str);
    }

    public final void qj(String str) {
        AppMethodBeat.i(23975);
        super.qj(str);
        AppMethodBeat.o(23975);
    }

    private b(String str) {
        super(a.pqK, str);
    }
}
