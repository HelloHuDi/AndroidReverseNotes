package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class g implements a {
    private n jOM;
    public long jON = 0;
    private BaseAdapter jOO;

    public g(BaseAdapter baseAdapter) {
        this.jOO = baseAdapter;
    }

    public final n aWG() {
        AppMethodBeat.i(14229);
        if (this.jOM == null) {
            this.jOM = new n();
        }
        n nVar = this.jOM;
        AppMethodBeat.o(14229);
        return nVar;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(14230);
        if (this.jOM == null || !this.jOM.buH()) {
            AppMethodBeat.o(14230);
            return false;
        }
        AppMethodBeat.o(14230);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.i(14231);
        if (isPlaying()) {
            aWG().stopPlay();
        }
        AppMethodBeat.o(14231);
    }

    public final void bI(String str, int i) {
        AppMethodBeat.i(14232);
        this.jOO.notifyDataSetChanged();
        AppMethodBeat.o(14232);
    }

    public final void onFinish() {
        AppMethodBeat.i(14233);
        this.jON = 0;
        this.jOO.notifyDataSetChanged();
        AppMethodBeat.o(14233);
    }

    public final void onPause() {
        AppMethodBeat.i(14234);
        this.jON = 0;
        this.jOO.notifyDataSetChanged();
        AppMethodBeat.o(14234);
    }
}
