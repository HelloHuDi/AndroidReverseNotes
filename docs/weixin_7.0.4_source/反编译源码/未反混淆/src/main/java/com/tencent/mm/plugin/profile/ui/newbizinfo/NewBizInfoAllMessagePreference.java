package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference extends Preference {
    private MMActivity crP;
    private TextView gne;
    private TextView nDX;
    d ppN;
    private LinearLayout ppR;

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23842);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(23842);
    }

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23843);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(23843);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23844);
        this.ppR = (LinearLayout) view.findViewById(R.id.b1h);
        this.gne = (TextView) view.findViewById(R.id.b1i);
        this.nDX = (TextView) view.findViewById(R.id.b1j);
        if (this.ppN == null || !this.ppN.cbN()) {
            this.ppR.setVisibility(8);
            AppMethodBeat.o(23844);
            return;
        }
        this.ppR.setVisibility(0);
        this.gne.setText(this.crP.getString(R.string.au9));
        this.nDX.setText(this.ppN.field_allArticleWording);
        AppMethodBeat.o(23844);
    }
}
