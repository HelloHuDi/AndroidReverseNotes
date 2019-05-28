package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fav.p407a.C36764n;
import com.tencent.p177mm.plugin.fav.p407a.C36764n.C27973a;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.g */
public final class C2696g implements C27973a {
    private C36764n jOM;
    public long jON = 0;
    private BaseAdapter jOO;

    public C2696g(BaseAdapter baseAdapter) {
        this.jOO = baseAdapter;
    }

    public final C36764n aWG() {
        AppMethodBeat.m2504i(14229);
        if (this.jOM == null) {
            this.jOM = new C36764n();
        }
        C36764n c36764n = this.jOM;
        AppMethodBeat.m2505o(14229);
        return c36764n;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(14230);
        if (this.jOM == null || !this.jOM.buH()) {
            AppMethodBeat.m2505o(14230);
            return false;
        }
        AppMethodBeat.m2505o(14230);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(14231);
        if (isPlaying()) {
            aWG().stopPlay();
        }
        AppMethodBeat.m2505o(14231);
    }

    /* renamed from: bI */
    public final void mo6771bI(String str, int i) {
        AppMethodBeat.m2504i(14232);
        this.jOO.notifyDataSetChanged();
        AppMethodBeat.m2505o(14232);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(14233);
        this.jON = 0;
        this.jOO.notifyDataSetChanged();
        AppMethodBeat.m2505o(14233);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(14234);
        this.jON = 0;
        this.jOO.notifyDataSetChanged();
        AppMethodBeat.m2505o(14234);
    }
}
