package com.tencent.p177mm.plugin.brandservice.p349ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.a */
public final class C2751a {
    private View iqO;
    private int iqQ = 0;
    private final Set<C33752b> iqR = Collections.newSetFromMap(new ConcurrentHashMap());
    private Context mContext;
    private int mOrientation;

    public C2751a(Context context) {
        AppMethodBeat.m2504i(14459);
        this.mContext = context;
        AppMethodBeat.m2505o(14459);
    }

    /* renamed from: G */
    public final void mo6823G(View view, int i) {
        AppMethodBeat.m2504i(14460);
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
        AppMethodBeat.m2505o(14460);
    }

    public final boolean aIZ() {
        AppMethodBeat.m2504i(14461);
        if (this.iqO == null) {
            AppMethodBeat.m2505o(14461);
            return false;
        }
        Activity activity = (Activity) this.mContext;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        viewGroup.setSystemUiVisibility(this.iqQ);
        viewGroup.removeView(this.iqO);
        activity.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        activity.setRequestedOrientation(this.mOrientation);
        this.iqO = null;
        aJb();
        AppMethodBeat.m2505o(14461);
        return true;
    }

    /* renamed from: a */
    public final void mo6824a(C33752b c33752b) {
        AppMethodBeat.m2504i(14462);
        this.iqR.add(c33752b);
        AppMethodBeat.m2505o(14462);
    }

    /* renamed from: b */
    public final void mo6826b(C33752b c33752b) {
        AppMethodBeat.m2504i(14463);
        this.iqR.remove(c33752b);
        AppMethodBeat.m2505o(14463);
    }

    private void aJa() {
        AppMethodBeat.m2504i(14464);
        Iterator it = this.iqR.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(14464);
    }

    private void aJb() {
        AppMethodBeat.m2504i(14465);
        for (C33752b aDI : this.iqR) {
            aDI.aDI();
        }
        AppMethodBeat.m2505o(14465);
    }
}
