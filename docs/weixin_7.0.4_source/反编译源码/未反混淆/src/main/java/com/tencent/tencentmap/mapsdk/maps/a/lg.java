package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class lg extends ListView {
    private a a;

    public interface a {
        void c();
    }

    public lg(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    public void handleDataChanged() {
        AppMethodBeat.i(100358);
        super.handleDataChanged();
        if (this.a != null) {
            this.a.c();
        }
        AppMethodBeat.o(100358);
    }

    public void setOnDataChangedListener(a aVar) {
        this.a = aVar;
    }
}
