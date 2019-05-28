package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.TipRightIconPreference */
public class TipRightIconPreference extends IconPreference {
    public TipRightIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TipRightIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(127631);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970181, viewGroup2);
        AppMethodBeat.m2505o(127631);
        return onCreateView;
    }
}
