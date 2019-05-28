package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public final class k {
    public ArrayList<a> jFO = new ArrayList();
    public int mRotateAngle = 0;
    public v2protocal sSz = new v2protocal(new ak(Looper.myLooper()));
    public int tbA;
    public boolean tby = false;
    public int tbz;

    public interface a {
        void a(int[] iArr, boolean z, int i);
    }

    public class b {
        public int tbB;
        public int tbC;
        public int tbD;
        public int tbE;

        public final String toString() {
            AppMethodBeat.i(5115);
            String format = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[]{Integer.valueOf(this.tbB), Integer.valueOf(this.tbC), Integer.valueOf(this.tbD), Integer.valueOf(this.tbE)});
            AppMethodBeat.o(5115);
            return format;
        }
    }

    public k() {
        AppMethodBeat.i(5116);
        AppMethodBeat.o(5116);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(5117);
        if (this.jFO.contains(aVar)) {
            this.jFO.remove(aVar);
        }
        AppMethodBeat.o(5117);
    }
}
