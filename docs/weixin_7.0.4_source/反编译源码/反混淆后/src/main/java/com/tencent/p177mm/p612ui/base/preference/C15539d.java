package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.base.preference.d */
final class C15539d extends BaseAdapter {
    private final Context context;
    protected int piC = -1;
    private final int style;
    protected String value;
    protected final HashMap<CharSequence, C15538c> values = new HashMap();
    protected CharSequence[] yBt;
    protected CharSequence[] yBu;

    /* renamed from: com.tencent.mm.ui.base.preference.d$a */
    static class C15540a {
        TextView piD;
        CheckBox piE;
        RadioButton piF;

        C15540a() {
        }
    }

    public C15539d(Context context) {
        AppMethodBeat.m2504i(107151);
        this.context = context;
        this.style = 1;
        AppMethodBeat.m2505o(107151);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dAw() {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(107152);
        if (this.yBt == null) {
            this.yBt = new CharSequence[0];
        }
        if (this.yBu == null) {
            this.yBu = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.yBt.length == this.yBu.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.yBu.length) {
            this.values.put(this.yBu[i], new C15538c(this.yBt[i], 1048576 + i));
            i++;
        }
        AppMethodBeat.m2505o(107152);
    }

    public final int getCount() {
        return this.yBu.length;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107153);
        if (view == null) {
            view = C5616v.m8409hu(this.context).inflate(2130970175, null);
            C15540a c15540a = new C15540a();
            c15540a.piD = (TextView) view.findViewById(2131820674);
            c15540a.piE = (CheckBox) view.findViewById(2131826057);
            c15540a.piF = (RadioButton) view.findViewById(2131820934);
            view.setTag(c15540a);
        }
        C15540a c15540a2 = (C15540a) view.getTag();
        c15540a2.piD.setText(this.yBt[i]);
        switch (this.style) {
            case 1:
                c15540a2.piE.setVisibility(8);
                c15540a2.piF.setVisibility(0);
                c15540a2.piF.setChecked(this.yBu[i].equals(this.value));
                break;
            case 2:
                c15540a2.piE.setVisibility(0);
                c15540a2.piF.setVisibility(8);
                c15540a2.piE.setChecked(this.yBu[i].equals(this.value));
                break;
            default:
                c15540a2.piE.setVisibility(8);
                c15540a2.piF.setVisibility(8);
                break;
        }
        AppMethodBeat.m2505o(107153);
        return view;
    }
}
