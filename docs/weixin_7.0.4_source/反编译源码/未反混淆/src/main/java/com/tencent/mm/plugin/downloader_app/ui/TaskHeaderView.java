package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader_app.b.i;

public class TaskHeaderView extends LinearLayout {
    private TextView kQr;
    private TextView kQs;
    private View kQt;

    public TaskHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(136255);
        super.onFinishInflate();
        this.kQt = findViewById(R.id.b_z);
        this.kQr = (TextView) findViewById(R.id.ail);
        this.kQs = (TextView) findViewById(R.id.aiq);
        AppMethodBeat.o(136255);
    }

    public final void a(i iVar, boolean z) {
        AppMethodBeat.i(136256);
        if (iVar.type == 1) {
            this.kQr.setText(getResources().getString(R.string.b73));
            this.kQs.setVisibility(8);
        } else if (iVar.type == 3) {
            this.kQr.setText(getResources().getString(R.string.ez6));
            this.kQs.setText(getResources().getString(R.string.ez5, new Object[]{Integer.valueOf(iVar.kPb)}));
            this.kQs.setVisibility(0);
        } else if (iVar.type == 5) {
            this.kQr.setText(getResources().getString(R.string.b6r));
            this.kQs.setVisibility(8);
        }
        if (z) {
            this.kQt.setVisibility(0);
        } else {
            this.kQt.setVisibility(8);
        }
        if (iVar.kci) {
            this.kQr.setTextColor(getContext().getResources().getColor(R.color.mi));
            this.kQs.setVisibility(8);
            AppMethodBeat.o(136256);
            return;
        }
        this.kQr.setTextColor(getContext().getResources().getColor(R.color.sp));
        this.kQs.setVisibility(0);
        AppMethodBeat.o(136256);
    }
}
