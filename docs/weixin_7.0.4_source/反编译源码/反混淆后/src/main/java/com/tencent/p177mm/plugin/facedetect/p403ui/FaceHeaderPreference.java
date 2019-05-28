package com.tencent.p177mm.plugin.facedetect.p403ui;

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
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference */
public final class FaceHeaderPreference extends Preference {
    private MMActivity crP;
    private TextView gne;
    private ImageView iyo;
    private int lXY;
    private Button lXZ;
    private View lYa;
    private OnClickListener lYb;
    private String lYc;
    private String lYd;
    private String mTitle;

    public FaceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(500);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(500);
    }

    public FaceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(501);
        this.mTitle = "";
        this.lXY = 255;
        this.lYb = null;
        this.lYc = "";
        this.lYd = "";
        this.crP = (MMActivity) context;
        setLayoutResource(2130969472);
        AppMethodBeat.m2505o(501);
    }

    /* renamed from: ej */
    public final void mo73762ej(String str, String str2) {
        AppMethodBeat.m2504i(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
        this.lYc = str;
        this.lYd = str2;
        if (this.gne != null) {
            if (C5046bo.isNullOrNil(this.lYc)) {
                this.gne.setVisibility(8);
            } else {
                this.gne.setText(this.lYc);
                this.gne.setVisibility(0);
                AppMethodBeat.m2505o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                return;
            }
        }
        AppMethodBeat.m2505o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
    }

    /* renamed from: a */
    public final void mo73761a(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        this.lYb = onClickListener;
        if (this.lXZ == null || this.lYa == null) {
            AppMethodBeat.m2505o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        } else if (this.lXZ == null || this.lYb == null) {
            this.lXZ.setVisibility(8);
            this.lYa.setVisibility(8);
            AppMethodBeat.m2505o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        } else {
            this.lXZ.setOnClickListener(onClickListener);
            this.lXZ.setVisibility(0);
            this.lYa.setVisibility(0);
            AppMethodBeat.m2505o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        }
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(504);
        super.onBindView(view);
        this.iyo = (ImageView) view.findViewById(2131823790);
        this.gne = (TextView) view.findViewById(2131823791);
        this.lXZ = (Button) view.findViewById(2131823774);
        this.lYa = view.findViewById(2131823792);
        if (C5046bo.isNullOrNil(this.lYc)) {
            this.gne.setVisibility(8);
        } else {
            this.gne.setText(this.lYc);
            this.gne.setVisibility(0);
        }
        if (this.lXZ == null || this.lYb == null) {
            if (this.lXZ != null) {
                this.lXZ.setVisibility(8);
            }
            this.lYa.setVisibility(8);
            AppMethodBeat.m2505o(504);
            return;
        }
        this.lXZ.setOnClickListener(this.lYb);
        this.lXZ.setVisibility(0);
        this.lYa.setVisibility(0);
        AppMethodBeat.m2505o(504);
    }
}
