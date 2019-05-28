package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class PhoneNumPreference extends Preference {
    public f iFE;
    public ad ldh;
    private View omq;
    public String vim;
    public String vin;
    ProfileMobilePhoneView vrm;

    public PhoneNumPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PhoneNumPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28110);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            ProfileMobilePhoneView profileMobilePhoneView = new ProfileMobilePhoneView(onCreateView.getContext());
            this.vrm = profileMobilePhoneView;
            viewGroup2.addView(profileMobilePhoneView, new LayoutParams(-1, -2));
            this.vrm.hG(this.vim, this.vin);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.o(28110);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28111);
        super.onBindView(view);
        this.vrm.cby();
        AppMethodBeat.o(28111);
    }

    public final void dlc() {
        AppMethodBeat.i(28112);
        if (this.ldh == null || !a.jh(this.ldh.field_type) || ad.aox(this.ldh.field_username) || (bo.isNullOrNil(this.vim) && bo.isNullOrNil(this.vin))) {
            this.iFE.ce("contact_profile_phone", true);
            AppMethodBeat.o(28112);
            return;
        }
        this.iFE.ce("contact_profile_phone", false);
        AppMethodBeat.o(28112);
    }
}
