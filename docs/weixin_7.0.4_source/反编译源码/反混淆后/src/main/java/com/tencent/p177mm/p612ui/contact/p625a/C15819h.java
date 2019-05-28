package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;

/* renamed from: com.tencent.mm.ui.contact.a.h */
public final class C15819h extends C5445a {
    public String mKQ;
    private C15820b zqc = new C15820b();
    C15818a zqd = new C15818a();

    /* renamed from: com.tencent.mm.ui.contact.a.h$a */
    public class C15818a extends C5446a {
        public TextView kxr;

        public C15818a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.h$b */
    public class C15820b extends C5447b {
        public C15820b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(105293);
            View inflate = LayoutInflater.from(context).inflate(2130970608, viewGroup, false);
            C15818a c15818a = C15819h.this.zqd;
            c15818a.kxr = (TextView) inflate.findViewById(2131822768);
            inflate.setTag(c15818a);
            AppMethodBeat.m2505o(105293);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105294);
            C3201m.m5502b(((C15819h) c5445a).mKQ, ((C15818a) c5446a).kxr);
            AppMethodBeat.m2505o(105294);
        }

        public final boolean aov() {
            return false;
        }
    }

    public C15819h(int i) {
        super(0, i);
        AppMethodBeat.m2504i(105295);
        AppMethodBeat.m2505o(105295);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
    }

    public final C5447b aou() {
        return this.zqc;
    }
}
