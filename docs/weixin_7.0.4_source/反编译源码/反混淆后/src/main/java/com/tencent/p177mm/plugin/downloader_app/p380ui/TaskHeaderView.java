package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.downloader_app.p377b.C38861i;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView */
public class TaskHeaderView extends LinearLayout {
    private TextView kQr;
    private TextView kQs;
    private View kQt;

    public TaskHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(136255);
        super.onFinishInflate();
        this.kQt = findViewById(2131823318);
        this.kQr = (TextView) findViewById(2131822269);
        this.kQs = (TextView) findViewById(2131822274);
        AppMethodBeat.m2505o(136255);
    }

    /* renamed from: a */
    public final void mo7089a(C38861i c38861i, boolean z) {
        AppMethodBeat.m2504i(136256);
        if (c38861i.type == 1) {
            this.kQr.setText(getResources().getString(C25738R.string.b73));
            this.kQs.setVisibility(8);
        } else if (c38861i.type == 3) {
            this.kQr.setText(getResources().getString(C25738R.string.ez6));
            this.kQs.setText(getResources().getString(C25738R.string.ez5, new Object[]{Integer.valueOf(c38861i.kPb)}));
            this.kQs.setVisibility(0);
        } else if (c38861i.type == 5) {
            this.kQr.setText(getResources().getString(C25738R.string.b6r));
            this.kQs.setVisibility(8);
        }
        if (z) {
            this.kQt.setVisibility(0);
        } else {
            this.kQt.setVisibility(8);
        }
        if (c38861i.kci) {
            this.kQr.setTextColor(getContext().getResources().getColor(C25738R.color.f11944mi));
            this.kQs.setVisibility(8);
            AppMethodBeat.m2505o(136256);
            return;
        }
        this.kQr.setTextColor(getContext().getResources().getColor(C25738R.color.f12107sp));
        this.kQs.setVisibility(0);
        AppMethodBeat.m2505o(136256);
    }
}
