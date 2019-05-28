package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.v;
import java.util.HashMap;
import junit.framework.Assert;

final class d extends BaseAdapter {
    private final Context context;
    protected int piC = -1;
    private final int style;
    protected String value;
    protected final HashMap<CharSequence, c> values = new HashMap();
    protected CharSequence[] yBt;
    protected CharSequence[] yBu;

    static class a {
        TextView piD;
        CheckBox piE;
        RadioButton piF;

        a() {
        }
    }

    public d(Context context) {
        AppMethodBeat.i(107151);
        this.context = context;
        this.style = 1;
        AppMethodBeat.o(107151);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dAw() {
        boolean z;
        int i = 0;
        AppMethodBeat.i(107152);
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
            this.values.put(this.yBu[i], new c(this.yBt[i], 1048576 + i));
            i++;
        }
        AppMethodBeat.o(107152);
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
        AppMethodBeat.i(107153);
        if (view == null) {
            view = v.hu(this.context).inflate(R.layout.afe, null);
            a aVar = new a();
            aVar.piD = (TextView) view.findViewById(R.id.ct);
            aVar.piE = (CheckBox) view.findViewById(R.id.da1);
            aVar.piF = (RadioButton) view.findViewById(R.id.ju);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.piD.setText(this.yBt[i]);
        switch (this.style) {
            case 1:
                aVar2.piE.setVisibility(8);
                aVar2.piF.setVisibility(0);
                aVar2.piF.setChecked(this.yBu[i].equals(this.value));
                break;
            case 2:
                aVar2.piE.setVisibility(0);
                aVar2.piF.setVisibility(8);
                aVar2.piE.setChecked(this.yBu[i].equals(this.value));
                break;
            default:
                aVar2.piE.setVisibility(8);
                aVar2.piF.setVisibility(8);
                break;
        }
        AppMethodBeat.o(107153);
        return view;
    }
}
