package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference extends Preference {
    private MMActivity crP;
    private TextView gJE;
    private TextView gne;
    private ImageView iyo;
    private int lXY;
    private Button lXZ;
    private View lYa;
    private OnClickListener lYb;
    private String lYc;
    private String lYd;
    private String mTitle;

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(26185);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(26185);
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(26186);
        this.mTitle = "";
        this.lXY = 255;
        this.lYb = null;
        this.lYc = "";
        this.lYd = "";
        this.crP = (MMActivity) context;
        setLayoutResource(R.layout.b23);
        AppMethodBeat.o(26186);
    }

    public final void ej(String str, String str2) {
        AppMethodBeat.i(26187);
        this.lYc = str;
        this.lYd = str2;
        if (this.gne != null) {
            if (bo.isNullOrNil(this.lYc)) {
                this.gne.setVisibility(8);
            } else {
                this.gne.setText(this.lYc);
                this.gne.setVisibility(0);
            }
        }
        if (this.gJE != null) {
            if (bo.isNullOrNil(this.lYd)) {
                this.gJE.setVisibility(8);
            } else {
                this.gJE.setText(this.lYd);
                this.gJE.setVisibility(0);
                AppMethodBeat.o(26187);
                return;
            }
        }
        AppMethodBeat.o(26187);
    }

    public final void a(OnClickListener onClickListener) {
        AppMethodBeat.i(26188);
        this.lYb = onClickListener;
        if (this.lXZ == null || this.lYa == null) {
            AppMethodBeat.o(26188);
        } else if (this.lXZ == null || this.lYb == null) {
            this.lXZ.setVisibility(8);
            this.lYa.setVisibility(8);
            AppMethodBeat.o(26188);
        } else {
            this.lXZ.setOnClickListener(onClickListener);
            this.lXZ.setVisibility(0);
            this.lYa.setVisibility(0);
            AppMethodBeat.o(26188);
        }
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(26189);
        super.onBindView(view);
        this.iyo = (ImageView) view.findViewById(R.id.bm9);
        this.gne = (TextView) view.findViewById(R.id.f1x);
        this.gJE = (TextView) view.findViewById(R.id.bm_);
        this.lXZ = (Button) view.findViewById(R.id.bma);
        this.lYa = view.findViewById(R.id.bms);
        if (bo.isNullOrNil(this.lYc)) {
            this.gne.setVisibility(8);
        } else {
            this.gne.setText(this.lYc);
            this.gne.setVisibility(0);
        }
        if (bo.isNullOrNil(this.lYd)) {
            this.gJE.setVisibility(8);
        } else {
            this.gJE.setText(this.lYd);
            this.gJE.setVisibility(0);
        }
        if (this.lXZ == null || this.lYb == null) {
            this.lXZ.setVisibility(8);
            this.lYa.setVisibility(8);
            AppMethodBeat.o(26189);
            return;
        }
        this.lXZ.setOnClickListener(this.lYb);
        this.lXZ.setVisibility(0);
        this.lYa.setVisibility(0);
        AppMethodBeat.o(26189);
    }
}
