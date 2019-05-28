package com.tencent.p177mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i.C14947a;

/* renamed from: com.tencent.mm.plugin.pwdgroup.b */
public final class C34742b extends C46507i implements C8915a {

    /* renamed from: com.tencent.mm.plugin.pwdgroup.b$a */
    public static class C21505a {
        static C14947a pqK;

        /* renamed from: b */
        public static void m32967b(ImageView imageView, String str) {
            C34742b c34742b;
            AppMethodBeat.m2504i(23974);
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof C34742b)) {
                c34742b = new C34742b(str, (byte) 0);
            } else {
                c34742b = (C34742b) drawable;
            }
            c34742b.setTag(str);
            imageView.setImageDrawable(c34742b);
            AppMethodBeat.m2505o(23974);
        }
    }

    /* synthetic */ C34742b(String str, byte b) {
        this(str);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(23975);
        super.mo20342qj(str);
        AppMethodBeat.m2505o(23975);
    }

    private C34742b(String str) {
        super(C21505a.pqK, str);
    }
}
