package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.product.p481b.C12813n.C3596a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.ui.l */
public final class C43377l extends BaseAdapter {
    private Context mContext;
    List<C3596a> pjG;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(44136);
        C3596a AR = m77406AR(i);
        AppMethodBeat.m2505o(44136);
        return AR;
    }

    public C43377l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44133);
        if (this.pjG != null) {
            int size = this.pjG.size();
            AppMethodBeat.m2505o(44133);
            return size;
        }
        AppMethodBeat.m2505o(44133);
        return 0;
    }

    /* renamed from: AR */
    private C3596a m77406AR(int i) {
        AppMethodBeat.m2504i(44134);
        C3596a c3596a = (C3596a) this.pjG.get(i);
        AppMethodBeat.m2505o(44134);
        return c3596a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C18765a c18765a;
        AppMethodBeat.m2504i(44135);
        C3596a AR = m77406AR(i);
        if (view == null || view.getTag() == null) {
            C43379m c43379m = new C43379m();
            view = View.inflate(this.mContext, 2130970398, null);
            c43379m.gne = (TextView) view.findViewById(2131826616);
            c43379m.iyo = (ImageView) view.findViewById(2131826615);
            view.setTag(c43379m);
            c18765a = c43379m;
        } else {
            C43379m c18765a2 = (C43379m) view.getTag();
        }
        c18765a2.pjH = AR;
        c18765a2.gne.setText(AR.title);
        c18765a2.iyo.setImageBitmap(C18764x.m29325a(new C39492c(AR.iconUrl)));
        C18764x.m29326a(c18765a2);
        AppMethodBeat.m2505o(44135);
        return view;
    }
}
