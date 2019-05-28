package com.tencent.p177mm.plugin.mall.p451ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mall.ui.CdnImageIconPreference */
public class CdnImageIconPreference extends IconPreference {
    String iconUrl;
    private CdnImageView oll;

    public CdnImageIconPreference(Context context) {
        super(context);
    }

    public CdnImageIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CdnImageIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43131);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130969000, viewGroup2);
        AppMethodBeat.m2505o(43131);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43132);
        super.onBindView(view);
        this.oll = (CdnImageView) view.findViewById(2131822184);
        if (!C5046bo.isNullOrNil(this.iconUrl)) {
            this.oll.setUseSdcardCache(true);
            this.oll.setUrl(this.iconUrl);
            this.oll.setVisibility(0);
        }
        AppMethodBeat.m2505o(43132);
    }
}
