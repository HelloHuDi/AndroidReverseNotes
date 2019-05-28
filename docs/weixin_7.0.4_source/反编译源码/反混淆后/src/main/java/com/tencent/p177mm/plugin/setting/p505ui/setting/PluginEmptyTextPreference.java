package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.PluginEmptyTextPreference */
public final class PluginEmptyTextPreference extends Preference {
    private Context context;
    private TextView eku;
    private String text;

    public PluginEmptyTextPreference(Context context) {
        this(context, null, 0);
        AppMethodBeat.m2504i(126975);
        this.text = context.getString(C25738R.string.e_6);
        AppMethodBeat.m2505o(126975);
    }

    public PluginEmptyTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(126976);
        this.eku = null;
        this.context = context;
        setLayoutResource(2130970363);
        AppMethodBeat.m2505o(126976);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(126977);
        View onCreateView = super.onCreateView(viewGroup);
        View.inflate(this.context, 2130970363, null);
        AppMethodBeat.m2505o(126977);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(126978);
        super.onBindView(view);
        this.eku = (TextView) view.findViewById(2131821457);
        this.eku.setText(this.text);
        AppMethodBeat.m2505o(126978);
    }
}
