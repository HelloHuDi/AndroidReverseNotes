package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.bo;

public class ProfileNormalItemView extends ProfileItemView {
    private TextView iDT;
    String mTitle;
    private TextView pip;
    CharSequence ppl;
    OnClickListener ppm;
    private View ppn;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23753);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.ProfileNormalItemView);
        this.mTitle = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(23753);
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return R.layout.alq;
    }

    public final void init() {
        AppMethodBeat.i(23754);
        this.iDT = (TextView) findViewById(R.id.dqe);
        this.pip = (TextView) findViewById(R.id.dqf);
        this.ppn = findViewById(R.id.z_);
        AppMethodBeat.o(23754);
    }

    public final ProfileNormalItemView Bg(int i) {
        AppMethodBeat.i(23755);
        this.mTitle = getContext().getString(i);
        AppMethodBeat.o(23755);
        return this;
    }

    public final ProfileNormalItemView Bh(int i) {
        AppMethodBeat.i(23756);
        this.ppl = getContext().getString(i);
        AppMethodBeat.o(23756);
        return this;
    }

    public final ProfileNormalItemView Bi(int i) {
        AppMethodBeat.i(23757);
        this.pip.setTextColor(i);
        AppMethodBeat.o(23757);
        return this;
    }

    public final ProfileNormalItemView cbw() {
        AppMethodBeat.i(23758);
        this.pip.setSingleLine(false);
        AppMethodBeat.o(23758);
        return this;
    }

    public final ProfileNormalItemView cbx() {
        AppMethodBeat.i(23759);
        this.ppn.setVisibility(0);
        AppMethodBeat.o(23759);
        return this;
    }

    public final boolean cby() {
        AppMethodBeat.i(23760);
        this.iDT.setText(this.mTitle);
        if (bo.ac(this.ppl)) {
            setVisibility(8);
            AppMethodBeat.o(23760);
            return false;
        }
        setVisibility(0);
        this.pip.setText(this.ppl);
        setOnClickListener(this.ppm);
        AppMethodBeat.o(23760);
        return true;
    }
}
