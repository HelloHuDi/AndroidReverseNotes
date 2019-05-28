package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference extends Preference {
    private String cIR;
    private String dFl;
    private TextView emg = null;
    Bitmap fru = null;
    ImageView moN = null;
    private TextView qkY = null;
    int qkZ = -1;
    String qla = null;
    private OnClickListener qlb;
    private String username;

    public PersonalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(126972);
        setLayoutResource(R.layout.ae4);
        setWidgetLayoutResource(R.layout.ag5);
        AppMethodBeat.o(126972);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(126973);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.aez, viewGroup2);
        AppMethodBeat.o(126973);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(126974);
        if (this.moN == null) {
            this.moN = (ImageView) view.findViewById(R.id.aga);
        }
        if (this.fru != null) {
            this.moN.setImageBitmap(this.fru);
        } else if (this.qkZ > 0) {
            this.moN.setImageResource(this.qkZ);
        } else if (this.qla != null) {
            b.b(this.moN, this.qla);
        }
        this.moN.setOnClickListener(this.qlb);
        if (!(this.emg == null || this.cIR == null)) {
            this.emg.setText(j.b(this.mContext, this.cIR, this.emg.getTextSize()));
        }
        if (this.qkY != null) {
            String str = bo.isNullOrNil(this.dFl) ? this.username : this.dFl;
            if (bo.isNullOrNil(this.dFl) && ad.aoA(this.username)) {
                this.qkY.setVisibility(8);
            }
            this.qkY.setText(this.mContext.getString(R.string.qf) + str);
        }
        super.onBindView(view);
        AppMethodBeat.o(126974);
    }
}
