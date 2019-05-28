package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C36307i.C36308a;

/* renamed from: com.tencent.mm.ui.y */
public final class C44407y extends LinearLayout implements C36308a {
    private ImageView ejo = ((ImageView) findViewById(2131821183));
    private TextView jPp = ((TextView) findViewById(2131821809));
    private TextView qha = ((TextView) findViewById(2131826146));
    private HeaderContainer yoe;
    private ImageView yof = ((ImageView) findViewById(2131826145));

    public C44407y(Context context) {
        super(context);
        AppMethodBeat.m2504i(29684);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130970246, this, true);
        AppMethodBeat.m2505o(29684);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(29685);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(29685);
    }

    public final void setHeaderContainer(HeaderContainer headerContainer) {
        this.yoe = headerContainer;
    }

    public final void setAccountName(String str) {
        AppMethodBeat.m2504i(29686);
        if (this.qha != null) {
            this.qha.setText(getResources().getString(C25738R.string.f8813fr, new Object[]{str}));
        }
        AppMethodBeat.m2505o(29686);
    }

    public final void setNickNameTV(SpannableString spannableString) {
        AppMethodBeat.m2504i(29687);
        if (this.jPp != null) {
            this.jPp.setText(spannableString);
        }
        AppMethodBeat.m2505o(29687);
    }

    public final ImageView getQrCodeIv() {
        return this.yof;
    }

    public final TextView getNickNameTV() {
        return this.jPp;
    }
}
