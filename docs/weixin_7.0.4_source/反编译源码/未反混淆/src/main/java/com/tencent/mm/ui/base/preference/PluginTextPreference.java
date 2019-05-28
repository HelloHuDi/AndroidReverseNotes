package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.a.a;

public final class PluginTextPreference extends Preference {
    private TextView eku;
    private ImageView pnv;
    private String text;
    private int textColor;
    public int visibility;
    public int yCV;

    public PluginTextPreference(Context context) {
        this(context, null);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107250);
        this.pnv = null;
        this.eku = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.PluginTextPreference);
        setLayoutResource(obtainStyledAttributes.getResourceId(1, R.layout.af1));
        this.yCV = obtainStyledAttributes.getResourceId(0, 0);
        this.text = obtainStyledAttributes.getString(2);
        this.textColor = obtainStyledAttributes.getColor(3, -7039852);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(107250);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107252);
        super.onBindView(view);
        this.pnv = (ImageView) view.findViewById(R.id.aga);
        this.pnv.setImageResource(this.yCV);
        this.pnv.setVisibility(this.visibility);
        this.eku = (TextView) view.findViewById(R.id.z6);
        this.eku.setText(this.text);
        this.eku.setTextColor(this.textColor);
        AppMethodBeat.o(107252);
    }

    public final void NV(int i) {
        AppMethodBeat.i(107251);
        this.text = this.mContext.getString(i);
        AppMethodBeat.o(107251);
    }
}
