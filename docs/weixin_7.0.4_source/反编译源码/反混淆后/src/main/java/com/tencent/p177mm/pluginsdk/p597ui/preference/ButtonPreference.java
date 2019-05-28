package com.tencent.p177mm.pluginsdk.p597ui.preference;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.ButtonPreference */
public class ButtonPreference extends Preference {
    private Drawable icon;
    private Context mContext;
    private View omq;
    /* renamed from: sW */
    private TextView f4957sW;
    private int textColor;
    private ImageView vqi;
    private int vqj;
    private String vqk;
    public int vql;

    public ButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28019);
        setLayoutResource(2130970127);
        m39042c(context, attributeSet);
        AppMethodBeat.m2505o(28019);
    }

    public ButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(28020);
        setLayoutResource(2130970127);
        m39042c(context, attributeSet);
        AppMethodBeat.m2505o(28020);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(28021);
        if (this.omq == null) {
            this.omq = LayoutInflater.from(this.mContext).inflate(2130970373, null);
        }
        View view = this.omq;
        AppMethodBeat.m2505o(28021);
        return view;
    }

    /* renamed from: c */
    private void m39042c(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(28022);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25738R.C8899a.ButtonPreference);
        this.vqj = obtainStyledAttributes.getColor(0, 0);
        this.textColor = obtainStyledAttributes.getColor(2, 0);
        this.vqk = obtainStyledAttributes.getString(3);
        this.icon = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(28022);
    }

    /* renamed from: ed */
    public final void mo41835ed(String str, int i) {
        AppMethodBeat.m2504i(28023);
        this.vqk = str;
        this.textColor = i;
        if (this.f4957sW != null) {
            this.f4957sW.setText(str);
            this.f4957sW.setTextColor(i);
            this.f4957sW.getPaint().setFakeBoldText(true);
        }
        AppMethodBeat.m2505o(28023);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28024);
        super.onBindView(view);
        this.vqi = (ImageView) view.findViewById(2131820915);
        this.f4957sW = (TextView) view.findViewById(2131820674);
        if (!(this.vqi == null || this.icon == null)) {
            this.vqi.setVisibility(0);
            this.vqi.setImageDrawable(C5225ah.m7961e(this.icon, this.vqj));
        }
        if (this.f4957sW != null) {
            this.f4957sW.setText(this.vqk);
            this.f4957sW.setTextColor(this.textColor);
            this.f4957sW.getPaint().setFakeBoldText(true);
        }
        if (!(this.omq == null || this.vql == 0)) {
            this.omq.setId(this.vql);
        }
        AppMethodBeat.m2505o(28024);
    }
}
