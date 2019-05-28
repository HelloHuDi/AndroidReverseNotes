package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileMobilePhoneView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference */
public class PhoneNumPreference extends Preference {
    public C15541f iFE;
    public C7616ad ldh;
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
        AppMethodBeat.m2504i(28110);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            ProfileMobilePhoneView profileMobilePhoneView = new ProfileMobilePhoneView(onCreateView.getContext());
            this.vrm = profileMobilePhoneView;
            viewGroup2.addView(profileMobilePhoneView, new LayoutParams(-1, -2));
            this.vrm.mo38944hG(this.vim, this.vin);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.m2505o(28110);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28111);
        super.onBindView(view);
        this.vrm.cby();
        AppMethodBeat.m2505o(28111);
    }

    public final void dlc() {
        AppMethodBeat.m2504i(28112);
        if (this.ldh == null || !C7486a.m12942jh(this.ldh.field_type) || C7616ad.aox(this.ldh.field_username) || (C5046bo.isNullOrNil(this.vim) && C5046bo.isNullOrNil(this.vin))) {
            this.iFE.mo27715ce("contact_profile_phone", true);
            AppMethodBeat.m2505o(28112);
            return;
        }
        this.iFE.mo27715ce("contact_profile_phone", false);
        AppMethodBeat.m2505o(28112);
    }
}
