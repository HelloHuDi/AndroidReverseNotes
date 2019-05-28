package com.tencent.mm.plugin.appbrand.page.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.page.b.c.b;
import com.tencent.mm.plugin.appbrand.page.u;

@TargetApi(21)
public class a extends b {
    private int ivr = 0;

    protected a(u uVar) {
        super(uVar);
    }

    public void aBr() {
        AppMethodBeat.i(87365);
        aKi();
        AppMethodBeat.o(87365);
    }

    private void aKi() {
        AppMethodBeat.i(87366);
        this.ivt.set(b.SHOWN);
        if (this.ivs.mContext instanceof Activity) {
            Window window = ((Activity) this.ivs.mContext).getWindow();
            if (window == null) {
                AppMethodBeat.o(87366);
                return;
            }
            View decorView = window.getDecorView();
            window.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -5);
        }
        AppMethodBeat.o(87366);
    }

    public void aBs() {
        AppMethodBeat.i(87367);
        this.ivt.set(b.HIDDEN);
        if (this.ivs.mContext instanceof Activity) {
            Window window = ((Activity) this.ivs.mContext).getWindow();
            if (window == null) {
                AppMethodBeat.o(87367);
                return;
            }
            window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | 4) | 256);
        }
        AppMethodBeat.o(87367);
    }

    public void aAS() {
        AppMethodBeat.i(87368);
        super.aAS();
        switch ((b) this.ivt.get()) {
            case SHOWN:
                aKi();
                AppMethodBeat.o(87368);
                return;
            case HIDDEN:
                aBs();
                AppMethodBeat.o(87368);
                return;
            default:
                AppMethodBeat.o(87368);
                return;
        }
    }

    public void onOrientationChanged(int i) {
        AppMethodBeat.i(87369);
        super.onOrientationChanged(i);
        Object obj = i != this.ivr ? 1 : null;
        this.ivr = i;
        if (2 == i) {
            aBs();
            AppMethodBeat.o(87369);
            return;
        }
        if (obj != null || this.ivt.get() == b.SHOWN) {
            aBr();
        }
        AppMethodBeat.o(87369);
    }
}
