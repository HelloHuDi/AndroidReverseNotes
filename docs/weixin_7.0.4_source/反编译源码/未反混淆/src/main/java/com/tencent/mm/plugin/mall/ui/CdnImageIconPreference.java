package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.IconPreference;

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
        AppMethodBeat.i(43131);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.kr, viewGroup2);
        AppMethodBeat.o(43131);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(43132);
        super.onBindView(view);
        this.oll = (CdnImageView) view.findViewById(R.id.aga);
        if (!bo.isNullOrNil(this.iconUrl)) {
            this.oll.setUseSdcardCache(true);
            this.oll.setUrl(this.iconUrl);
            this.oll.setVisibility(0);
        }
        AppMethodBeat.o(43132);
    }
}
