package com.tencent.mm.plugin.brandservice.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private View iqO;
    private int iqQ = 0;
    private final Set<b> iqR = Collections.newSetFromMap(new ConcurrentHashMap());
    private Context mContext;
    private int mOrientation;

    public a(Context context) {
        AppMethodBeat.i(14459);
        this.mContext = context;
        AppMethodBeat.o(14459);
    }

    public final void G(View view, int i) {
        AppMethodBeat.i(14460);
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
        AppMethodBeat.o(14460);
    }

    public final boolean aIZ() {
        AppMethodBeat.i(14461);
        if (this.iqO == null) {
            AppMethodBeat.o(14461);
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
        AppMethodBeat.o(14461);
        return true;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(14462);
        this.iqR.add(bVar);
        AppMethodBeat.o(14462);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(14463);
        this.iqR.remove(bVar);
        AppMethodBeat.o(14463);
    }

    private void aJa() {
        AppMethodBeat.i(14464);
        Iterator it = this.iqR.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(14464);
    }

    private void aJb() {
        AppMethodBeat.i(14465);
        for (b aDI : this.iqR) {
            aDI.aDI();
        }
        AppMethodBeat.o(14465);
    }
}
