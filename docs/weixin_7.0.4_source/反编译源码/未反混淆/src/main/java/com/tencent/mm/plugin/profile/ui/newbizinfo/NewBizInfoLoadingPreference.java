package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference extends Preference {
    private MMActivity crP;
    private View gbS;
    private TextView hrg;
    private boolean lyb = false;
    private d ppN;
    private ProgressBar ppY;
    private boolean ppZ = false;
    private int state = 1;

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23864);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23864);
    }

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23865);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23865);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23866);
        this.gbS = view.findViewById(R.id.b3h);
        this.hrg = (TextView) view.findViewById(R.id.b3j);
        this.ppY = (ProgressBar) view.findViewById(R.id.b3i);
        this.lyb = true;
        initView();
        AppMethodBeat.o(23866);
    }

    private void initView() {
        AppMethodBeat.i(23867);
        if (!this.lyb) {
            AppMethodBeat.o(23867);
        } else if (this.state == 1) {
            this.gbS.setVisibility(0);
            this.ppY.setVisibility(0);
            this.hrg.setVisibility(8);
            AppMethodBeat.o(23867);
        } else if (this.state == 2) {
            this.gbS.setVisibility(0);
            this.hrg.setText(j.d(this.crP, this.ppN.field_newBanReason, (int) this.hrg.getTextSize()));
            this.hrg.setMovementMethod(LinkMovementMethod.getInstance());
            this.hrg.setVisibility(0);
            this.ppY.setVisibility(8);
            AppMethodBeat.o(23867);
        } else if (this.state == 3) {
            this.gbS.setVisibility(0);
            this.hrg.setText(this.crP.getString(R.string.b1u));
            this.hrg.setVisibility(0);
            this.ppY.setVisibility(8);
            AppMethodBeat.o(23867);
        } else {
            this.gbS.setVisibility(8);
            AppMethodBeat.o(23867);
        }
    }

    public final void a(d dVar, boolean z) {
        AppMethodBeat.i(23868);
        this.ppN = dVar;
        this.ppZ = z;
        cbv();
        initView();
        AppMethodBeat.o(23868);
    }

    private void cbv() {
        AppMethodBeat.i(23869);
        if (this.ppN != null && this.ppN.cbP()) {
            this.state = 2;
            AppMethodBeat.o(23869);
        } else if (this.ppZ) {
            this.state = 3;
            AppMethodBeat.o(23869);
        } else if (this.ppN != null) {
            this.state = 0;
            AppMethodBeat.o(23869);
        } else {
            this.state = 1;
            AppMethodBeat.o(23869);
        }
    }
}
