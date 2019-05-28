package com.tencent.p177mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.p1430a.C41166a;

/* renamed from: com.tencent.mm.plugin.appbrand.page.ap */
public interface C2410ap {

    /* renamed from: com.tencent.mm.plugin.appbrand.page.ap$a */
    public static class C2411a implements C2410ap {
        /* renamed from: b */
        public <WIDGET extends View> WIDGET mo6322b(Context context, Class<WIDGET> cls) {
            AppMethodBeat.m2504i(87344);
            View view = (View) cls.cast(C41166a.m71619be(cls).mo65755ab(context).object);
            AppMethodBeat.m2505o(87344);
            return view;
        }
    }

    /* renamed from: b */
    <WIDGET extends View> WIDGET mo6322b(Context context, Class<WIDGET> cls);
}
