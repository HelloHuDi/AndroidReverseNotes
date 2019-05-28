package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

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
        AppMethodBeat.i(35008);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(35008);
    }

    public final void a(Region region) {
        AppMethodBeat.i(35009);
        if (region == null || ah.isNullOrNil(region.getName()) || ah.isNullOrNil(region.getCode())) {
            ab.e("MicroMsg.ZonePreference", "setZoneItem item = null");
            AppMethodBeat.o(35009);
            return;
        }
        setKey(region.getCode() + region.isCity());
        this.zIi = region;
        AppMethodBeat.o(35009);
    }

    public final void setSummary(CharSequence charSequence) {
        AppMethodBeat.i(35010);
        this.zIj = charSequence;
        dKa();
        AppMethodBeat.o(35010);
    }

    private void dKa() {
        AppMethodBeat.i(35011);
        if (this.zIk == null) {
            AppMethodBeat.o(35011);
            return;
        }
        if (this.zIj == null || ah.isNullOrNil(this.zIj.toString())) {
            this.zIk.setVisibility(8);
        } else {
            this.zIk.setVisibility(0);
        }
        this.zIk.setText(this.zIj);
        AppMethodBeat.o(35011);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(35012);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.af_, viewGroup2);
        AppMethodBeat.o(35012);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(35013);
        super.onBindView(view);
        if (this.zIi == null) {
            AppMethodBeat.o(35013);
            return;
        }
        ((TextView) view.findViewById(R.id.d_s)).setText(this.zIi.getName());
        this.zIk = (TextView) view.findViewById(R.id.d_v);
        dKa();
        AppMethodBeat.o(35013);
    }
}
