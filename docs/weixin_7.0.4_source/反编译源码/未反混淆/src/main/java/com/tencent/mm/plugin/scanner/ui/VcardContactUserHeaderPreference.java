package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.a.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference extends Preference {
    private String bCu;
    private final Context context;
    private String qaA;
    private ImageView qgZ;
    private TextView qha;
    private TextView qhb;
    private TextView qhc;
    private TextView qhd;
    private String qhe;
    private String title;

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81360);
        super.onBindView(view);
        ab.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.qgZ = (ImageView) view.findViewById(R.id.f02);
        this.qha = (TextView) view.findViewById(R.id.f03);
        if (this.qhe != null) {
            this.qha.setText(this.qhe);
        }
        this.qhb = (TextView) view.findViewById(R.id.f04);
        if (this.bCu != null) {
            this.qhb.setText(this.context.getString(R.string.f05, new Object[]{this.bCu}));
            this.qhb.setVisibility(0);
        }
        this.qhc = (TextView) view.findViewById(R.id.f06);
        if (this.qaA != null) {
            this.qhc.setText(this.context.getString(R.string.f0_, new Object[]{this.qaA}));
            this.qhc.setVisibility(0);
        }
        this.qhd = (TextView) view.findViewById(R.id.f05);
        if (this.title != null) {
            this.qhd.setText(this.context.getString(R.string.f0a, new Object[]{this.title}));
            this.qhd.setVisibility(0);
        }
        AppMethodBeat.o(81360);
    }

    public final void a(r rVar) {
        AppMethodBeat.i(81361);
        if (rVar != null) {
            if (!bo.isNullOrNil(rVar.qam.aDu())) {
                this.qhe = rVar.qam.aDu();
            }
            if (!bo.isNullOrNil(rVar.bCu)) {
                this.bCu = rVar.bCu;
            }
            if (!bo.isNullOrNil(rVar.qaA)) {
                this.qaA = rVar.qaA;
            }
            if (!bo.isNullOrNil(rVar.title)) {
                this.title = rVar.title;
            }
        }
        AppMethodBeat.o(81361);
    }
}
