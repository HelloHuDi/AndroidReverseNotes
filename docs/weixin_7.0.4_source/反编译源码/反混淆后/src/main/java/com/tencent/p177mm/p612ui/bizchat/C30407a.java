package com.tencent.p177mm.p612ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C25781a;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.bizchat.a */
public final class C30407a extends C5445a {
    private static Map<String, C25814c> yDP = new HashMap();
    public CharSequence gnx;
    public long jMj = -1;
    public String username;
    public String yDO;
    private C30409b yDQ = new C30409b();
    C30408a yDR = new C30408a();

    /* renamed from: com.tencent.mm.ui.bizchat.a$a */
    public class C30408a extends C5446a {
        public ImageView ejo;
        public TextView ejp;
        public TextView gnC;

        public C30408a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.a$b */
    public class C30409b extends C5447b {
        public C30409b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.m2504i(105184);
            if (C1338a.m2865ga(context)) {
                inflate = LayoutInflater.from(context).inflate(2130970606, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(2130970605, viewGroup, false);
            }
            C30408a c30408a = C30407a.this.yDR;
            c30408a.ejo = (ImageView) inflate.findViewById(2131821183);
            c30408a.ejp = (TextView) inflate.findViewById(2131821185);
            c30408a.gnC = (TextView) inflate.findViewById(2131820991);
            c30408a.gnC.setVisibility(8);
            inflate.setTag(c30408a);
            AppMethodBeat.m2505o(105184);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105185);
            C30407a c30407a = (C30407a) c5445a;
            C30408a c30408a = (C30408a) c5446a;
            C3201m.m5501a(c30407a.gnx, c30408a.ejp);
            C32291o.ahp().mo43766a(c30407a.yDO, c30408a.ejo, C30407a.aqU(c30407a.username));
            AppMethodBeat.m2505o(105185);
        }

        public final boolean aov() {
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(105189);
        AppMethodBeat.m2505o(105189);
    }

    public C30407a(int i) {
        super(4, i);
        AppMethodBeat.m2504i(105186);
        AppMethodBeat.m2505o(105186);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        AppMethodBeat.m2504i(105187);
        this.gnx = C44089j.m79294b(context, this.gnx, C1338a.m2856al(context, C25738R.dimen.f9980m5));
        AppMethodBeat.m2505o(105187);
    }

    public final C5447b aou() {
        return this.yDQ;
    }

    static /* synthetic */ C25814c aqU(String str) {
        AppMethodBeat.m2504i(105188);
        C25814c ahG;
        if (str == null) {
            AppMethodBeat.m2505o(105188);
            return null;
        } else if (!yDP.containsKey(str) || yDP.get(str) == null) {
            C17927a c17927a = new C17927a();
            c17927a.ePK = C25781a.m40991cC(str);
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.ePT = C1318a.default_avatar;
            ahG = c17927a.ahG();
            yDP.put(str, ahG);
            AppMethodBeat.m2505o(105188);
            return ahG;
        } else {
            ahG = (C25814c) yDP.get(str);
            AppMethodBeat.m2505o(105188);
            return ahG;
        }
    }
}
