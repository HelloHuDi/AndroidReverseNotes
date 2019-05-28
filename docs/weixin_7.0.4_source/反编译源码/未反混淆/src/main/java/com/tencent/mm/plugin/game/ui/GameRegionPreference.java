package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference extends Preference {
    a nlP;

    public static class a {
        public String dui;
        public boolean gBF;
        public boolean isDefault;
        public String nlQ;
        public String nlR;
        public String nlS;
    }

    public GameRegionPreference(Context context) {
        this(context, null);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112154);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(112154);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(112155);
        if (aVar == null || bo.isNullOrNil(aVar.dui)) {
            ab.e("MicroMsg.GameRegionPreference", "setData region error");
            AppMethodBeat.o(112155);
            return;
        }
        this.nlP = aVar;
        setKey(aVar.dui);
        AppMethodBeat.o(112155);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(112156);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.a5i, viewGroup2);
        AppMethodBeat.o(112156);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(112157);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.c93);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.c94);
        if (!(textView == null || checkBox == null || this.nlP == null)) {
            textView.setText(e.a(this.nlP));
            checkBox.setChecked(this.nlP.gBF);
        }
        AppMethodBeat.o(112157);
    }
}
