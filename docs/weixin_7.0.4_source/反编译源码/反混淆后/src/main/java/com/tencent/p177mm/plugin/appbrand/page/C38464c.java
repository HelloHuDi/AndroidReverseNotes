package com.tencent.p177mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.page.c */
public final class C38464c {
    private View iqO;
    CustomViewCallback iqP;
    private int iqQ = 0;
    final Set<C19623ai> iqR = Collections.newSetFromMap(new ConcurrentHashMap());
    private Context mContext;
    private int mOrientation;

    C38464c(Context context) {
        AppMethodBeat.m2504i(91081);
        this.mContext = context;
        AppMethodBeat.m2505o(91081);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: G */
    public final void mo61148G(View view, int i) {
        AppMethodBeat.m2504i(91082);
        aIZ();
        this.iqO = view;
        Activity activity = (Activity) this.mContext;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        this.iqQ = viewGroup.getSystemUiVisibility();
        viewGroup.addView(view, layoutParams);
        view.setX(0.0f);
        view.setY(0.0f);
        if (C1443d.m3067fP(19)) {
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
        AppMethodBeat.m2505o(91082);
    }

    /* Access modifiers changed, original: final */
    public final boolean aIZ() {
        AppMethodBeat.m2504i(91083);
        if (this.iqO == null) {
            AppMethodBeat.m2505o(91083);
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
        AppMethodBeat.m2505o(91083);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo61149a(C19623ai c19623ai) {
        AppMethodBeat.m2504i(91084);
        this.iqR.add(c19623ai);
        AppMethodBeat.m2505o(91084);
    }

    private void aJa() {
        AppMethodBeat.m2504i(91085);
        for (C19623ai aJY : this.iqR) {
            aJY.aJY();
        }
        AppMethodBeat.m2505o(91085);
    }

    private void aJb() {
        AppMethodBeat.m2504i(91086);
        for (C19623ai aDI : this.iqR) {
            aDI.aDI();
        }
        AppMethodBeat.m2505o(91086);
    }
}
