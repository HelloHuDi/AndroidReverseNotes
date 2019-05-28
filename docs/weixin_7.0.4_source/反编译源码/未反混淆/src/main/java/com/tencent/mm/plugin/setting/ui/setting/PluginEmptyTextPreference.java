package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference extends Preference {
    private Context context;
    private TextView eku;
    private String text;

    public PluginEmptyTextPreference(Context context) {
        this(context, null, 0);
        AppMethodBeat.i(126975);
        this.text = context.getString(R.string.e_6);
        AppMethodBeat.o(126975);
    }

    public PluginEmptyTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(126976);
        this.eku = null;
        this.context = context;
        setLayoutResource(R.layout.akg);
        AppMethodBeat.o(126976);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(126977);
        View onCreateView = super.onCreateView(viewGroup);
        View.inflate(this.context, R.layout.akg, null);
        AppMethodBeat.o(126977);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(126978);
        super.onBindView(view);
        this.eku = (TextView) view.findViewById(R.id.xz);
        this.eku.setText(this.text);
        AppMethodBeat.o(126978);
    }
}
