package com.tencent.mm.plugin.facedetect.ui;

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
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

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
        AppMethodBeat.i(500);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(500);
    }

    public FaceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(501);
        this.mTitle = "";
        this.lXY = 255;
        this.lYb = null;
        this.lYc = "";
        this.lYd = "";
        this.crP = (MMActivity) context;
        setLayoutResource(R.layout.xg);
        AppMethodBeat.o(501);
    }

    public final void ej(String str, String str2) {
        AppMethodBeat.i(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
        this.lYc = str;
        this.lYd = str2;
        if (this.gne != null) {
            if (bo.isNullOrNil(this.lYc)) {
                this.gne.setVisibility(8);
            } else {
                this.gne.setText(this.lYc);
                this.gne.setVisibility(0);
                AppMethodBeat.o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                return;
            }
        }
        AppMethodBeat.o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
    }

    public final void a(OnClickListener onClickListener) {
        AppMethodBeat.i(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        this.lYb = onClickListener;
        if (this.lXZ == null || this.lYa == null) {
            AppMethodBeat.o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        } else if (this.lXZ == null || this.lYb == null) {
            this.lXZ.setVisibility(8);
            this.lYa.setVisibility(8);
            AppMethodBeat.o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        } else {
            this.lXZ.setOnClickListener(onClickListener);
            this.lXZ.setVisibility(0);
            this.lYa.setVisibility(0);
            AppMethodBeat.o(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        }
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(504);
        super.onBindView(view);
        this.iyo = (ImageView) view.findViewById(R.id.bmq);
        this.gne = (TextView) view.findViewById(R.id.bmr);
        this.lXZ = (Button) view.findViewById(R.id.bma);
        this.lYa = view.findViewById(R.id.bms);
        if (bo.isNullOrNil(this.lYc)) {
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
            AppMethodBeat.o(504);
            return;
        }
        this.lXZ.setOnClickListener(this.lYb);
        this.lXZ.setVisibility(0);
        this.lYa.setVisibility(0);
        AppMethodBeat.o(504);
    }
}
