package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;

/* renamed from: com.tencent.mm.ui.contact.a.i */
public final class C30659i extends C5445a {
    private CharSequence mKU;
    private C23921b zqf = new C23921b();
    C5446a zqg = new C23920a();

    /* renamed from: com.tencent.mm.ui.contact.a.i$a */
    public class C23920a extends C5446a {
        public TextView mKx;

        public C23920a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.i$b */
    public class C23921b extends C5447b {
        public C23921b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(105296);
            View inflate = LayoutInflater.from(context).inflate(2130970609, viewGroup, false);
            C23920a c23920a = (C23920a) C30659i.this.zqg;
            c23920a.mKx = (TextView) inflate.findViewById(2131824214);
            inflate.setTag(c23920a);
            AppMethodBeat.m2505o(105296);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105297);
            C3201m.m5501a(C30659i.this.mKU, ((C23920a) c5446a).mKx);
            AppMethodBeat.m2505o(105297);
        }

        public final boolean aov() {
            return false;
        }
    }

    public C30659i(int i) {
        super(6, i);
        AppMethodBeat.m2504i(105298);
        AppMethodBeat.m2505o(105298);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        AppMethodBeat.m2504i(105299);
        this.mKU = C34204f.m56087a(context.getString(C25738R.string.dzw), context.getString(C25738R.string.dzv), C39127d.m66573b(this.query, this.query)).mDR;
        AppMethodBeat.m2505o(105299);
    }

    public final C5447b aou() {
        return this.zqf;
    }
}
