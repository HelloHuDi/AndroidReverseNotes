package com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.f */
public final class C29925f extends BaseAdapter {
    private static final String mVL = (C1761b.eSn + "Game/HvMenu/");
    private Context mContext;
    C44273l rBn;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.f$a */
    public class C29926a {
        TextView gsf;
        ImageView iNr;

        public C29926a(View view) {
            AppMethodBeat.m2504i(8844);
            this.gsf = (TextView) view.findViewById(2131820678);
            this.iNr = (ImageView) view.findViewById(2131820915);
            AppMethodBeat.m2505o(8844);
        }
    }

    static {
        AppMethodBeat.m2504i(8849);
        AppMethodBeat.m2505o(8849);
    }

    public C29925f(Context context) {
        this.mContext = context;
    }

    /* renamed from: b */
    public final void mo48172b(C44273l c44273l) {
        AppMethodBeat.m2504i(8845);
        this.rBn = c44273l;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(8845);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(8846);
        if (this.rBn == null) {
            AppMethodBeat.m2505o(8846);
            return 0;
        }
        int size = this.rBn.size();
        AppMethodBeat.m2505o(8846);
        return size;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(8847);
        View inflate = LayoutInflater.from(this.mContext).inflate(2130969748, viewGroup, false);
        C29926a c29926a = new C29926a(inflate);
        C44274m c44274m = (C44274m) this.rBn.yvT.get(i);
        if (!(c44274m == null || c44274m.getItemId() == -1)) {
            String charSequence = c44274m.getTitle().toString();
            if (!C5046bo.isNullOrNil(charSequence)) {
                String[] split = charSequence.split("__", 2);
                if (split.length == 1) {
                    c29926a.gsf.setText(split[0]);
                } else {
                    c29926a.gsf.setText(split[0]);
                    charSequence = split[1];
                    if (charSequence.startsWith("http")) {
                        String str = mVL + C1178g.m2591x(charSequence.getBytes());
                        C17927a c17927a = new C17927a();
                        c17927a.ePH = true;
                        c17927a.ePJ = str;
                        C25815a.ahv().mo43766a(charSequence, c29926a.iNr, c17927a.ahG());
                    } else {
                        c29926a.iNr.setImageResource(C4996ah.getResources().getIdentifier(charSequence, "drawable", C4996ah.getPackageName()));
                    }
                }
                inflate.setTag(c44274m);
                AppMethodBeat.m2505o(8847);
                return inflate;
            }
        }
        inflate.setTag(null);
        AppMethodBeat.m2505o(8847);
        return inflate;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(8848);
        C44274m c44274m = (C44274m) this.rBn.yvT.get(i);
        AppMethodBeat.m2505o(8848);
        return c44274m;
    }
}
