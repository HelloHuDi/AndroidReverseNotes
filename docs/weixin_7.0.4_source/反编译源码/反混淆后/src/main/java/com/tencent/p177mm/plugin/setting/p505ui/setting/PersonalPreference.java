package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.PersonalPreference */
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
        AppMethodBeat.m2504i(126972);
        setLayoutResource(2130970127);
        setWidgetLayoutResource(2130970202);
        AppMethodBeat.m2505o(126972);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(126973);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970159, viewGroup2);
        AppMethodBeat.m2505o(126973);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(126974);
        if (this.moN == null) {
            this.moN = (ImageView) view.findViewById(2131822184);
        }
        if (this.fru != null) {
            this.moN.setImageBitmap(this.fru);
        } else if (this.qkZ > 0) {
            this.moN.setImageResource(this.qkZ);
        } else if (this.qla != null) {
            C40460b.m69434b(this.moN, this.qla);
        }
        this.moN.setOnClickListener(this.qlb);
        if (!(this.emg == null || this.cIR == null)) {
            this.emg.setText(C44089j.m79293b(this.mContext, this.cIR, this.emg.getTextSize()));
        }
        if (this.qkY != null) {
            String str = C5046bo.isNullOrNil(this.dFl) ? this.username : this.dFl;
            if (C5046bo.isNullOrNil(this.dFl) && C7616ad.aoA(this.username)) {
                this.qkY.setVisibility(8);
            }
            this.qkY.setText(this.mContext.getString(C25738R.string.f9131qf) + str);
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(126974);
    }
}
