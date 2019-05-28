package com.tencent.p177mm.plugin.multitalk.p459ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e.C15815a;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e.C40844b;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.a */
public final class C21335a extends C40843e {
    private C21336a oHY = new C21336a();

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.a$a */
    public class C21336a extends C40844b {
        public C21336a() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(54182);
            View inflate = LayoutInflater.from(context).inflate(2130970265, viewGroup, false);
            C15815a c15815a = (C15815a) C21335a.m32717a(C21335a.this);
            c15815a.ejo = (ImageView) inflate.findViewById(2131821183);
            c15815a.gnB = (TextView) inflate.findViewById(2131821185);
            c15815a.gnC = (TextView) inflate.findViewById(2131820991);
            c15815a.contentView = inflate.findViewById(2131826213);
            c15815a.gnD = (CheckBox) inflate.findViewById(2131821593);
            inflate.setTag(c15815a);
            AppMethodBeat.m2505o(54182);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(54183);
            C15815a c15815a = (C15815a) c5446a;
            C40843e c40843e = (C40843e) c5445a;
            if (c40843e.username == null || c40843e.username.length() <= 0) {
                c15815a.ejo.setImageResource(C25738R.drawable.ad2);
            } else {
                C40460b.m69434b(c15815a.ejo, c40843e.username);
            }
            C3201m.m5501a(c40843e.gnx, c15815a.gnB);
            if (C21335a.this.zmW) {
                if (z) {
                    c15815a.gnD.setChecked(true);
                    c15815a.gnD.setEnabled(false);
                } else {
                    c15815a.gnD.setChecked(z2);
                    c15815a.gnD.setEnabled(true);
                }
                c15815a.gnD.setVisibility(0);
                AppMethodBeat.m2505o(54183);
                return;
            }
            c15815a.gnD.setVisibility(8);
            AppMethodBeat.m2505o(54183);
        }
    }

    /* renamed from: a */
    static /* synthetic */ C5446a m32717a(C21335a c21335a) {
        AppMethodBeat.m2504i(54185);
        C5446a clJ = c21335a.clJ();
        AppMethodBeat.m2505o(54185);
        return clJ;
    }

    public C21335a(int i) {
        super(i);
        AppMethodBeat.m2504i(54184);
        AppMethodBeat.m2505o(54184);
    }

    public final C5447b aou() {
        return this.oHY;
    }
}
