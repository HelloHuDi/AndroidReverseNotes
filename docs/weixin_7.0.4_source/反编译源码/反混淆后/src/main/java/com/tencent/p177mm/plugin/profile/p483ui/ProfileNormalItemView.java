package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileItemView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.profile.ui.ProfileNormalItemView */
public class ProfileNormalItemView extends ProfileItemView {
    private TextView iDT;
    String mTitle;
    private TextView pip;
    CharSequence ppl;
    OnClickListener ppm;
    private View ppn;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23753);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25738R.C8899a.ProfileNormalItemView);
        this.mTitle = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(23753);
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return 2130970410;
    }

    public final void init() {
        AppMethodBeat.m2504i(23754);
        this.iDT = (TextView) findViewById(2131826663);
        this.pip = (TextView) findViewById(2131826664);
        this.ppn = findViewById(2131821517);
        AppMethodBeat.m2505o(23754);
    }

    /* renamed from: Bg */
    public final ProfileNormalItemView mo62465Bg(int i) {
        AppMethodBeat.m2504i(23755);
        this.mTitle = getContext().getString(i);
        AppMethodBeat.m2505o(23755);
        return this;
    }

    /* renamed from: Bh */
    public final ProfileNormalItemView mo62466Bh(int i) {
        AppMethodBeat.m2504i(23756);
        this.ppl = getContext().getString(i);
        AppMethodBeat.m2505o(23756);
        return this;
    }

    /* renamed from: Bi */
    public final ProfileNormalItemView mo62467Bi(int i) {
        AppMethodBeat.m2504i(23757);
        this.pip.setTextColor(i);
        AppMethodBeat.m2505o(23757);
        return this;
    }

    public final ProfileNormalItemView cbw() {
        AppMethodBeat.m2504i(23758);
        this.pip.setSingleLine(false);
        AppMethodBeat.m2505o(23758);
        return this;
    }

    public final ProfileNormalItemView cbx() {
        AppMethodBeat.m2504i(23759);
        this.ppn.setVisibility(0);
        AppMethodBeat.m2505o(23759);
        return this;
    }

    public final boolean cby() {
        AppMethodBeat.m2504i(23760);
        this.iDT.setText(this.mTitle);
        if (C5046bo.m7519ac(this.ppl)) {
            setVisibility(8);
            AppMethodBeat.m2505o(23760);
            return false;
        }
        setVisibility(0);
        this.pip.setText(this.ppl);
        setOnClickListener(this.ppm);
        AppMethodBeat.m2505o(23760);
        return true;
    }
}
