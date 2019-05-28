package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private View iqO;
    CustomViewCallback iqP;
    private int iqQ = 0;
    final Set<ai> iqR = Collections.newSetFromMap(new ConcurrentHashMap());
    private Context mContext;
    private int mOrientation;

    c(Context context) {
        AppMethodBeat.i(91081);
        this.mContext = context;
        AppMethodBeat.o(91081);
    }

    /* Access modifiers changed, original: final */
    public final void G(View view, int i) {
        AppMethodBeat.i(91082);
        aIZ();
        this.iqO = view;
        Activity activity = (Activity) this.mContext;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        this.iqQ = viewGroup.getSystemUiVisibility();
        viewGroup.addView(view, layoutParams);
        view.setX(0.0f);
        view.setY(0.0f);
        if (d.fP(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4102);
        }
        activity.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mOrientation = activity.getRequestedOrientation();
        switch (i) {
            case -90:
                activity.setRequestedOrientation(8);
                break;
            case 0:
                activity.setRequestedOrientation(1);
                break;
            case 90:
                activity.setRequestedOrientation(0);
                break;
            default:
                activity.setRequestedOrientation(9);
                break;
        }
        aJa();
        AppMethodBeat.o(91082);
    }

    /* Access modifiers changed, original: final */
    public final boolean aIZ() {
        AppMethodBeat.i(91083);
        if (this.iqO == null) {
            AppMethodBeat.o(91083);
            return false;
        }
        if (this.iqP != null) {
            this.iqP.onCustomViewHidden();
        }
        Activity activity = (Activity) this.mContext;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        viewGroup.setSystemUiVisibility(this.iqQ);
        viewGroup.removeView(this.iqO);
        activity.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        activity.setRequestedOrientation(this.mOrientation);
        this.iqO = null;
        this.iqP = null;
        aJb();
        AppMethodBeat.o(91083);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void a(ai aiVar) {
        AppMethodBeat.i(91084);
        this.iqR.add(aiVar);
        AppMethodBeat.o(91084);
    }

    private void aJa() {
        AppMethodBeat.i(91085);
        for (ai aJY : this.iqR) {
            aJY.aJY();
        }
        AppMethodBeat.o(91085);
    }

    private void aJb() {
        AppMethodBeat.i(91086);
        for (ai aDI : this.iqR) {
            aDI.aDI();
        }
        AppMethodBeat.o(91086);
    }
}
