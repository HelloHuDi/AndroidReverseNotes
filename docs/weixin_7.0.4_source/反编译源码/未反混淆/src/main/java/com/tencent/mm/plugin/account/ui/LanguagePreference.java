package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class LanguagePreference extends Preference {
    public a gBB;

    public static class a {
        String gBC;
        private String gBD;
        public String gBE;
        public boolean gBF;

        public a(String str, String str2, String str3, boolean z) {
            this.gBC = str;
            this.gBD = str2;
            this.gBE = str3;
            this.gBF = z;
        }
    }

    public LanguagePreference(Context context) {
        this(context, null);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(124905);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(124905);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(124906);
        if (aVar == null || bo.isNullOrNil(aVar.gBE)) {
            ab.e("MicroMsg.LanguagePreference", "setInfo info error");
            AppMethodBeat.o(124906);
            return;
        }
        this.gBB = aVar;
        setKey(aVar.gBE);
        AppMethodBeat.o(124906);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(124907);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.aev, viewGroup2);
        AppMethodBeat.o(124907);
        return onCreateView;
    }

    public final void onBindView(View view) {
        int i = 1;
        AppMethodBeat.i(124908);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.a6_);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.c94);
        int i2 = textView != null ? 1 : 0;
        if (checkBox == null) {
            i = 0;
        }
        if ((i & i2) != 0) {
            textView.setText(this.gBB.gBC);
            checkBox.setChecked(this.gBB.gBF);
        }
        NW(8);
        AppMethodBeat.o(124908);
    }
}
