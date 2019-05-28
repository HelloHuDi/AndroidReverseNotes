package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.emoji.p725b.C45845a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.l */
public final class C14930l extends BaseAdapter {
    private List<String> gnO;
    private Context mContext;
    private List<String> vli;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.l$a */
    static class C14931a {
        public ImageView ejo;
        public TextView gxi;

        private C14931a() {
        }

        /* synthetic */ C14931a(byte b) {
            this();
        }
    }

    public C14930l(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.gnO = list2;
        this.vli = list;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(27717);
        int size = this.gnO.size();
        AppMethodBeat.m2505o(27717);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(27718);
        Object obj = this.gnO.get(i);
        AppMethodBeat.m2505o(27718);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C14931a ex;
        AppMethodBeat.m2504i(27719);
        if (view == null) {
            view = View.inflate(this.mContext, 2130969006, null);
            ex = C14930l.m23213ex(view);
        } else {
            C14931a c14931a = (C14931a) view.getTag();
            if (c14931a == null) {
                ex = C14930l.m23213ex(view);
            } else {
                ex = c14931a;
            }
        }
        int size = this.gnO.size() % 4;
        if (i >= 0 && i < this.gnO.size() && i < this.vli.size()) {
            ex.ejo.setVisibility(0);
            ex.gxi.setVisibility(0);
            C40460b.m69434b(ex.ejo, (String) this.vli.get(i));
            ex.gxi.setText((CharSequence) this.gnO.get(i));
            ex.gxi.setText(((C45845a) C1720g.m3528K(C45845a.class)).mo68462a(this.mContext, (CharSequence) this.gnO.get(i), ex.gxi.getTextSize()));
            if (this.gnO.size() <= 12 || i < this.gnO.size() - size) {
                ex.gxi.setPadding(0, 0, 0, 0);
            } else {
                ex.gxi.setPadding(0, 0, 0, C1338a.m2856al(this.mContext, C25738R.dimen.f9784fj));
            }
        }
        AppMethodBeat.m2505o(27719);
        return view;
    }

    /* renamed from: ex */
    private static C14931a m23213ex(View view) {
        AppMethodBeat.m2504i(27720);
        C14931a c14931a = new C14931a();
        c14931a.ejo = (ImageView) view.findViewById(2131822361);
        c14931a.gxi = (TextView) view.findViewById(2131822362);
        view.setTag(c14931a);
        AppMethodBeat.m2505o(27720);
        return c14931a;
    }
}
