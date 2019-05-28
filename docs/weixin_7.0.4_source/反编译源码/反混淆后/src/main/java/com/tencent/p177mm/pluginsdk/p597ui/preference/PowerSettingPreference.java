package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.PowerSettingPreference */
public class PowerSettingPreference extends Preference {
    private C7616ad ldh;
    private View omq;
    private ImageView pon;
    private ImageView poo;
    private ImageView pop;

    public PowerSettingPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PowerSettingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(28113);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            viewGroup2.addView(LayoutInflater.from(this.mContext).inflate(2130970413, null), new LayoutParams(-1, -2));
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.m2505o(28113);
        return view;
    }

    public final void onBindView(View view) {
        int i = 0;
        AppMethodBeat.m2504i(28114);
        super.onBindView(view);
        if (this.ldh == null) {
            AppMethodBeat.m2505o(28114);
            return;
        }
        int i2;
        if (this.pon == null) {
            this.pon = (ImageView) view.findViewById(2131823088);
        }
        if (this.poo == null) {
            this.poo = (ImageView) view.findViewById(2131823087);
        }
        if (this.pop == null) {
            this.pop = (ImageView) view.findViewById(2131823086);
        }
        boolean Od = this.ldh.mo16701Od();
        boolean UV = C21877n.qFA.mo37357UV(this.ldh.field_username);
        ImageView imageView = this.poo;
        if (Od) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        imageView = this.pop;
        if (UV) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        ImageView imageView2 = this.pon;
        if (!this.ldh.mo16700Oc()) {
            i = 8;
        }
        imageView2.setVisibility(i);
        AppMethodBeat.m2505o(28114);
    }
}
