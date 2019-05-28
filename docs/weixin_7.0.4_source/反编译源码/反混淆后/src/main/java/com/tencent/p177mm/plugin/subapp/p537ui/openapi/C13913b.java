package com.tencent.p177mm.plugin.subapp.p537ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.b */
public final class C13913b extends BaseAdapter implements C4931a {
    private Context context;
    private List<C40439f> qnw;
    boolean suv = false;

    public C13913b(Context context, List<C40439f> list) {
        this.context = context;
        this.qnw = list;
    }

    /* renamed from: lX */
    public final void mo26126lX(boolean z) {
        AppMethodBeat.m2504i(25463);
        this.suv = z;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(25463);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C46292c c46292c;
        AppMethodBeat.m2504i(25464);
        if (view == null) {
            c46292c = new C46292c();
            view = View.inflate(this.context, 2130968753, null);
            c46292c.iyo = (ImageView) view.findViewById(2131821444);
            c46292c.suQ = (TextView) view.findViewById(2131821445);
            c46292c.gtb = (TextView) view.findViewById(2131821447);
            c46292c.suR = view.findViewById(2131821446);
            view.setTag(c46292c);
        } else {
            c46292c = (C46292c) view.getTag();
        }
        c46292c.suR.setVisibility(4);
        if (mo26127wK(i)) {
            c46292c.iyo.setVisibility(4);
            c46292c.suQ.setVisibility(4);
            c46292c.gtb.setVisibility(4);
            AppMethodBeat.m2505o(25464);
        } else {
            C40439f c40439f = (C40439f) getItem(i);
            c46292c.iyo.setVisibility(0);
            Bitmap b = C46494g.m87732b(c40439f.field_appId, 5, C1338a.getDensity(this.context));
            if (b == null) {
                c46292c.iyo.setBackgroundResource(C25738R.drawable.aau);
            } else {
                c46292c.iyo.setBackgroundDrawable(new BitmapDrawable(b));
            }
            c46292c.gtb.setVisibility(0);
            c46292c.gtb.setText(C46494g.m87733b(this.context, c40439f, null));
            if (this.suv) {
                c46292c.suQ.setVisibility(0);
            } else {
                c46292c.suQ.setVisibility(8);
            }
            AppMethodBeat.m2505o(25464);
        }
        return view;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(25465);
        int realCount = getRealCount() + bFs();
        AppMethodBeat.m2505o(25465);
        return realCount;
    }

    /* renamed from: wK */
    public final boolean mo26127wK(int i) {
        AppMethodBeat.m2504i(25466);
        int size = this.qnw.size();
        if (i < size || i >= size + bFs()) {
            AppMethodBeat.m2505o(25466);
            return false;
        }
        AppMethodBeat.m2505o(25466);
        return true;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(25467);
        if (mo26127wK(i)) {
            AppMethodBeat.m2505o(25467);
            return null;
        }
        Object obj = this.qnw.get(i);
        AppMethodBeat.m2505o(25467);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int getRealCount() {
        AppMethodBeat.m2504i(25468);
        int size = this.qnw.size();
        AppMethodBeat.m2505o(25468);
        return size;
    }

    private int bFs() {
        AppMethodBeat.m2504i(25469);
        int realCount = (4 - (getRealCount() % 4)) % 4;
        AppMethodBeat.m2505o(25469);
        return realCount;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(25470);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(25470);
    }
}
