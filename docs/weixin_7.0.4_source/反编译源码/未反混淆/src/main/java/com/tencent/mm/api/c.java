package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class c extends FrameLayout {
    r ccE = new r() {
        public final void a(e eVar) {
            AppMethodBeat.i(73797);
            ab.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", eVar.name());
            AppMethodBeat.o(73797);
        }

        public final void a(e eVar, int i) {
            AppMethodBeat.i(73798);
            ab.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", eVar.name(), Integer.valueOf(i));
            AppMethodBeat.o(73798);
        }

        public final void bd(boolean z) {
        }
    };

    public abstract void setActionBarCallback(g gVar);

    public abstract void setActionBarVisible(boolean z);

    public abstract void setAutoShowFooterAndBar(boolean z);

    public abstract void setFooterVisible(boolean z);

    public c(Context context) {
        super(context);
    }

    public void setSelectedFeatureListener(r rVar) {
        this.ccE = rVar;
    }

    public r getSelectedFeatureListener() {
        return this.ccE;
    }
}
