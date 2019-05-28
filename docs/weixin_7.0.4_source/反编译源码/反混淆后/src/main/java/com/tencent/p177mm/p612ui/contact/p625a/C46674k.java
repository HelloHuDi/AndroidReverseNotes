package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;

/* renamed from: com.tencent.mm.ui.contact.a.k */
public final class C46674k extends C5445a {
    private C44356a zqk = new C44356a();
    C44357b zql = new C44357b();

    /* renamed from: com.tencent.mm.ui.contact.a.k$a */
    public class C44356a extends C5447b {
        public C44356a() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(105303);
            View inflate = LayoutInflater.from(context).inflate(2130970611, viewGroup, false);
            C44357b c44357b = C46674k.this.zql;
            c44357b.gnB = (TextView) inflate.findViewById(2131821185);
            c44357b.contentView = inflate.findViewById(2131826213);
            c44357b.gnD = (CheckBox) inflate.findViewById(2131821593);
            inflate.setTag(c44357b);
            AppMethodBeat.m2505o(105303);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105304);
            C44357b c44357b = (C44357b) c5446a;
            c44357b.gnB.setText(C25738R.string.e1k);
            c44357b.gnD.setBackgroundResource(C25738R.drawable.f6886ud);
            c44357b.gnD.setChecked(z2);
            c44357b.gnD.setEnabled(true);
            c44357b.gnD.setVisibility(0);
            c44357b.contentView.setBackgroundResource(C25738R.drawable.f6625k7);
            AppMethodBeat.m2505o(105304);
        }

        public final boolean aov() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.k$b */
    public class C44357b extends C5446a {
        public View contentView;
        public TextView gnB;
        public CheckBox gnD;

        public C44357b() {
            super();
        }
    }

    public C46674k(int i) {
        super(7, i);
        AppMethodBeat.m2504i(105305);
        AppMethodBeat.m2505o(105305);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
    }

    public final C5447b aou() {
        return this.zqk;
    }
}
