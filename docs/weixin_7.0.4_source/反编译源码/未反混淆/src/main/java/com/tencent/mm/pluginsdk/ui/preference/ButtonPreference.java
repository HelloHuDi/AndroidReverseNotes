package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.preference.Preference;

public class ButtonPreference extends Preference {
    private Drawable icon;
    private Context mContext;
    private View omq;
    private TextView sW;
    private int textColor;
    private ImageView vqi;
    private int vqj;
    private String vqk;
    public int vql;

    public ButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(28019);
        setLayoutResource(R.layout.ae4);
        c(context, attributeSet);
        AppMethodBeat.o(28019);
    }

    public ButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(28020);
        setLayoutResource(R.layout.ae4);
        c(context, attributeSet);
        AppMethodBeat.o(28020);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28021);
        if (this.omq == null) {
            this.omq = LayoutInflater.from(this.mContext).inflate(R.layout.akq, null);
        }
        View view = this.omq;
        AppMethodBeat.o(28021);
        return view;
    }

    private void c(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(28022);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.ButtonPreference);
        this.vqj = obtainStyledAttributes.getColor(0, 0);
        this.textColor = obtainStyledAttributes.getColor(2, 0);
        this.vqk = obtainStyledAttributes.getString(3);
        this.icon = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(28022);
    }

    public final void ed(String str, int i) {
        AppMethodBeat.i(28023);
        this.vqk = str;
        this.textColor = i;
        if (this.sW != null) {
            this.sW.setText(str);
            this.sW.setTextColor(i);
            this.sW.getPaint().setFakeBoldText(true);
        }
        AppMethodBeat.o(28023);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28024);
        super.onBindView(view);
        this.vqi = (ImageView) view.findViewById(R.id.jb);
        this.sW = (TextView) view.findViewById(R.id.ct);
        if (!(this.vqi == null || this.icon == null)) {
            this.vqi.setVisibility(0);
            this.vqi.setImageDrawable(ah.e(this.icon, this.vqj));
        }
        if (this.sW != null) {
            this.sW.setText(this.vqk);
            this.sW.setTextColor(this.textColor);
            this.sW.getPaint().setFakeBoldText(true);
        }
        if (!(this.omq == null || this.vql == 0)) {
            this.omq.setId(this.vql);
        }
        AppMethodBeat.o(28024);
    }
}
