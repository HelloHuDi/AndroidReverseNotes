package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference */
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
        AppMethodBeat.m2504i(26185);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(26185);
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(26186);
        this.mTitle = "";
        this.lXY = 255;
        this.lYb = null;
        this.lYc = "";
        this.lYd = "";
        this.crP = (MMActivity) context;
        setLayoutResource(2130971017);
        AppMethodBeat.m2505o(26186);
    }

    /* renamed from: ej */
    public final void mo47728ej(String str, String str2) {
        AppMethodBeat.m2504i(26187);
        this.lYc = str;
        this.lYd = str2;
        if (this.gne != null) {
            if (C5046bo.isNullOrNil(this.lYc)) {
                this.gne.setVisibility(8);
            } else {
                this.gne.setText(this.lYc);
                this.gne.setVisibility(0);
            }
        }
        if (this.gJE != null) {
            if (C5046bo.isNullOrNil(this.lYd)) {
                this.gJE.setVisibility(8);
            } else {
                this.gJE.setText(this.lYd);
                this.gJE.setVisibility(0);
                AppMethodBeat.m2505o(26187);
                return;
            }
        }
        AppMethodBeat.m2505o(26187);
    }

    /* renamed from: a */
    public final void mo47727a(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(26188);
        this.lYb = onClickListener;
        if (this.lXZ == null || this.lYa == null) {
            AppMethodBeat.m2505o(26188);
        } else if (this.lXZ == null || this.lYb == null) {
            this.lXZ.setVisibility(8);
            this.lYa.setVisibility(8);
            AppMethodBeat.m2505o(26188);
        } else {
            this.lXZ.setOnClickListener(onClickListener);
            this.lXZ.setVisibility(0);
            this.lYa.setVisibility(0);
            AppMethodBeat.m2505o(26188);
        }
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(26189);
        super.onBindView(view);
        this.iyo = (ImageView) view.findViewById(2131823772);
        this.gne = (TextView) view.findViewById(2131828458);
        this.gJE = (TextView) view.findViewById(2131823773);
        this.lXZ = (Button) view.findViewById(2131823774);
        this.lYa = view.findViewById(2131823792);
        if (C5046bo.isNullOrNil(this.lYc)) {
            this.gne.setVisibility(8);
        } else {
            this.gne.setText(this.lYc);
            this.gne.setVisibility(0);
        }
        if (C5046bo.isNullOrNil(this.lYd)) {
            this.gJE.setVisibility(8);
        } else {
            this.gJE.setText(this.lYd);
            this.gJE.setVisibility(0);
        }
        if (this.lXZ == null || this.lYb == null) {
            this.lXZ.setVisibility(8);
            this.lYa.setVisibility(8);
            AppMethodBeat.m2505o(26189);
            return;
        }
        this.lXZ.setOnClickListener(this.lYb);
        this.lXZ.setVisibility(0);
        this.lYa.setVisibility(0);
        AppMethodBeat.m2505o(26189);
    }
}
