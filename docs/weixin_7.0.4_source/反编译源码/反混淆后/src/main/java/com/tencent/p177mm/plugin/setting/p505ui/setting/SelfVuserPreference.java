package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SelfVuserPreference */
public class SelfVuserPreference extends Preference {
    Drawable drawable;
    private String qlD;
    String text;

    public SelfVuserPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelfVuserPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(127040);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(127040);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(127041);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970201, viewGroup2);
        AppMethodBeat.m2505o(127041);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(127042);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131822184);
        if (imageView != null) {
            imageView.setImageDrawable(this.drawable);
            C4990ab.m7410d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
            if (!C5046bo.isNullOrNil(this.qlD)) {
                imageView.setContentDescription(this.qlD);
            }
        }
        TextView textView = (TextView) view.findViewById(2131821513);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(this.text);
        }
        AppMethodBeat.m2505o(127042);
    }
}
