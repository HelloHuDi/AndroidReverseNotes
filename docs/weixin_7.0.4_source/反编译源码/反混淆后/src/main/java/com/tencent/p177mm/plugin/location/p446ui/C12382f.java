package com.tencent.p177mm.plugin.location.p446ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.location.ui.f */
public final class C12382f implements C34411c {
    public boolean czr = false;
    public String eUu;
    private boolean isVisible = true;
    private String nJq;
    private double nJu = 1000000.0d;
    private double nJv = 1000000.0d;
    private boolean nLW = true;
    private View nLX;
    private C28354d nLY;
    private TextView nLZ;
    private String nLw = "";
    private TextView nMa;
    public ImageButton nMb;

    public C12382f(C28354d c28354d, Context context) {
        AppMethodBeat.m2504i(113459);
        View findViewById = ((Activity) context).findViewById(2131826350);
        this.nLZ = (TextView) findViewById.findViewById(2131826351);
        this.nMa = (TextView) findViewById.findViewById(2131826352);
        this.nMb = (ImageButton) findViewById.findViewById(2131826353);
        this.nLY = c28354d;
        this.nLX = findViewById;
        AppMethodBeat.m2505o(113459);
    }

    public final void setText(String str) {
        AppMethodBeat.m2504i(113460);
        this.nJq = str;
        String str2 = this.nJq;
        C4990ab.m7410d("NewItemOverlay", "popView " + this.nLX.getWidth() + " " + this.nLX.getHeight());
        if (!(str2 == null || str2.equals(""))) {
            this.nMa.setText(str2);
        }
        if (this.eUu == null || this.eUu.equals("")) {
            this.nLZ.setText(C25738R.string.cn7);
        } else {
            this.nLZ.setText(this.eUu);
        }
        if (this.nLW) {
            this.nLX.setVisibility(0);
            this.nLX.invalidate();
        }
        AppMethodBeat.m2505o(113460);
    }

    public final String getPreText() {
        return this.nLw;
    }
}
