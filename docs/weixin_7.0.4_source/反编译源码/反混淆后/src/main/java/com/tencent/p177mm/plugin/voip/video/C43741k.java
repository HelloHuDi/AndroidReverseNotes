package com.tencent.p177mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.voip.video.k */
public final class C43741k {
    public ArrayList<C22477a> jFO = new ArrayList();
    public int mRotateAngle = 0;
    public v2protocal sSz = new v2protocal(new C7306ak(Looper.myLooper()));
    public int tbA;
    public boolean tby = false;
    public int tbz;

    /* renamed from: com.tencent.mm.plugin.voip.video.k$a */
    public interface C22477a {
        /* renamed from: a */
        void mo30880a(int[] iArr, boolean z, int i);
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.k$b */
    public class C43740b {
        public int tbB;
        public int tbC;
        public int tbD;
        public int tbE;

        public final String toString() {
            AppMethodBeat.m2504i(5115);
            String format = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[]{Integer.valueOf(this.tbB), Integer.valueOf(this.tbC), Integer.valueOf(this.tbD), Integer.valueOf(this.tbE)});
            AppMethodBeat.m2505o(5115);
            return format;
        }
    }

    public C43741k() {
        AppMethodBeat.m2504i(5116);
        AppMethodBeat.m2505o(5116);
    }

    /* renamed from: a */
    public final void mo69434a(C22477a c22477a) {
        AppMethodBeat.m2504i(5117);
        if (this.jFO.contains(c22477a)) {
            this.jFO.remove(c22477a);
        }
        AppMethodBeat.m2505o(5117);
    }
}
