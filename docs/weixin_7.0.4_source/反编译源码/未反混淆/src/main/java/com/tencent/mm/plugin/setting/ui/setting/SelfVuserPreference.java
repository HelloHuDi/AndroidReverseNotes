package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class SelfVuserPreference extends Preference {
    Drawable drawable;
    private String qlD;
    String text;

    public SelfVuserPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelfVuserPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(127040);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(127040);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(127041);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.ag4, viewGroup2);
        AppMethodBeat.o(127041);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(127042);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.aga);
        if (imageView != null) {
            imageView.setImageDrawable(this.drawable);
            ab.d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
            if (!bo.isNullOrNil(this.qlD)) {
                imageView.setContentDescription(this.qlD);
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.z6);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(this.text);
        }
        AppMethodBeat.o(127042);
    }
}
