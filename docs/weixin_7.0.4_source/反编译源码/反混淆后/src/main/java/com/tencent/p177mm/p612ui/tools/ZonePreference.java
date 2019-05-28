package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.RegionCodeDecoder.Region;

/* renamed from: com.tencent.mm.ui.tools.ZonePreference */
public class ZonePreference extends Preference {
    Region zIi;
    private CharSequence zIj;
    private TextView zIk;

    public ZonePreference(Context context) {
        this(context, null);
    }

    public ZonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(35008);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(35008);
    }

    /* renamed from: a */
    public final void mo11311a(Region region) {
        AppMethodBeat.m2504i(35009);
        if (region == null || C42252ah.isNullOrNil(region.getName()) || C42252ah.isNullOrNil(region.getCode())) {
            C4990ab.m7412e("MicroMsg.ZonePreference", "setZoneItem item = null");
            AppMethodBeat.m2505o(35009);
            return;
        }
        setKey(region.getCode() + region.isCity());
        this.zIi = region;
        AppMethodBeat.m2505o(35009);
    }

    public final void setSummary(CharSequence charSequence) {
        AppMethodBeat.m2504i(35010);
        this.zIj = charSequence;
        dKa();
        AppMethodBeat.m2505o(35010);
    }

    private void dKa() {
        AppMethodBeat.m2504i(35011);
        if (this.zIk == null) {
            AppMethodBeat.m2505o(35011);
            return;
        }
        if (this.zIj == null || C42252ah.isNullOrNil(this.zIj.toString())) {
            this.zIk.setVisibility(8);
        } else {
            this.zIk.setVisibility(0);
        }
        this.zIk.setText(this.zIj);
        AppMethodBeat.m2505o(35011);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(35012);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970170, viewGroup2);
        AppMethodBeat.m2505o(35012);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(35013);
        super.onBindView(view);
        if (this.zIi == null) {
            AppMethodBeat.m2505o(35013);
            return;
        }
        ((TextView) view.findViewById(2131826048)).setText(this.zIi.getName());
        this.zIk = (TextView) view.findViewById(2131826051);
        dKa();
        AppMethodBeat.m2505o(35013);
    }
}
