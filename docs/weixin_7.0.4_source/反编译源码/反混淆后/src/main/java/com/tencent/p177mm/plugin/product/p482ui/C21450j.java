package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.product.p737c.C34682m;
import com.tencent.p177mm.plugin.product.p737c.C46133h;

/* renamed from: com.tencent.mm.plugin.product.ui.j */
public final class C21450j extends BaseAdapter {
    private Context mContext;
    C34682m pjB;
    String pjC;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(44128);
        C46133h AP = m32901AP(i);
        AppMethodBeat.m2505o(44128);
        return AP;
    }

    public C21450j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44124);
        if (this.pjB.phZ != null) {
            int size = this.pjB.phZ.size();
            AppMethodBeat.m2505o(44124);
            return size;
        }
        AppMethodBeat.m2505o(44124);
        return 0;
    }

    /* renamed from: AP */
    private C46133h m32901AP(int i) {
        AppMethodBeat.m2504i(44125);
        C46133h c46133h = (C46133h) this.pjB.phZ.get(i);
        AppMethodBeat.m2505o(44125);
        return c46133h;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        AppMethodBeat.m2504i(44126);
        boolean z = m32901AP(i).phS;
        AppMethodBeat.m2505o(44126);
        return z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        AppMethodBeat.m2504i(44127);
        C46133h AP = m32901AP(i);
        if (view == null || view.getTag() == null) {
            inflate = View.inflate(this.mContext, 2130970395, null);
        } else {
            inflate = view;
        }
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(AP.name);
        checkBox.setEnabled(AP.phS);
        checkBox.setChecked(AP.f17901id.equals(this.pjC));
        if (!AP.phS) {
            inflate.setBackgroundResource(C25738R.drawable.bex);
        } else if (AP.f17901id.equals(this.pjC)) {
            inflate.setBackgroundResource(C25738R.drawable.bez);
        } else {
            inflate.setBackgroundResource(C25738R.drawable.bey);
        }
        inflate.setTag(new Pair(this.pjB.phX, AP.f17901id));
        AppMethodBeat.m2505o(44127);
        return inflate;
    }
}
