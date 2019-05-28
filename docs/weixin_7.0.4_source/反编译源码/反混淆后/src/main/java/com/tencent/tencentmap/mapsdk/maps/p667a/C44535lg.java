package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lg */
public class C44535lg extends ListView {
    /* renamed from: a */
    private C24403a f17483a;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lg$a */
    public interface C24403a {
        /* renamed from: c */
        void mo40691c();
    }

    public C44535lg(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    public void handleDataChanged() {
        AppMethodBeat.m2504i(100358);
        super.handleDataChanged();
        if (this.f17483a != null) {
            this.f17483a.mo40691c();
        }
        AppMethodBeat.m2505o(100358);
    }

    public void setOnDataChangedListener(C24403a c24403a) {
        this.f17483a = c24403a;
    }
}
