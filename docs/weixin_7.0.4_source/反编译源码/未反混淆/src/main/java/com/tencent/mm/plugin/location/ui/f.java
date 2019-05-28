package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class f implements c {
    public boolean czr = false;
    public String eUu;
    private boolean isVisible = true;
    private String nJq;
    private double nJu = 1000000.0d;
    private double nJv = 1000000.0d;
    private boolean nLW = true;
    private View nLX;
    private d nLY;
    private TextView nLZ;
    private String nLw = "";
    private TextView nMa;
    public ImageButton nMb;

    public f(d dVar, Context context) {
        AppMethodBeat.i(113459);
        View findViewById = ((Activity) context).findViewById(R.id.dhy);
        this.nLZ = (TextView) findViewById.findViewById(R.id.dhz);
        this.nMa = (TextView) findViewById.findViewById(R.id.di0);
        this.nMb = (ImageButton) findViewById.findViewById(R.id.di1);
        this.nLY = dVar;
        this.nLX = findViewById;
        AppMethodBeat.o(113459);
    }

    public final void setText(String str) {
        AppMethodBeat.i(113460);
        this.nJq = str;
        String str2 = this.nJq;
        ab.d("NewItemOverlay", "popView " + this.nLX.getWidth() + " " + this.nLX.getHeight());
        if (!(str2 == null || str2.equals(""))) {
            this.nMa.setText(str2);
        }
        if (this.eUu == null || this.eUu.equals("")) {
            this.nLZ.setText(R.string.cn7);
        } else {
            this.nLZ.setText(this.eUu);
        }
        if (this.nLW) {
            this.nLX.setVisibility(0);
            this.nLX.invalidate();
        }
        AppMethodBeat.o(113460);
    }

    public final String getPreText() {
        return this.nLw;
    }
}
