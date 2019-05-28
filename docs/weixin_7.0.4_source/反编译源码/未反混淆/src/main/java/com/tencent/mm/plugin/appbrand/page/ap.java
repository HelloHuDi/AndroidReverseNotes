package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ap {

    public static class a implements ap {
        public <WIDGET extends View> WIDGET b(Context context, Class<WIDGET> cls) {
            AppMethodBeat.i(87344);
            View view = (View) cls.cast(org.a.a.be(cls).ab(context).object);
            AppMethodBeat.o(87344);
            return view;
        }
    }

    <WIDGET extends View> WIDGET b(Context context, Class<WIDGET> cls);
}
