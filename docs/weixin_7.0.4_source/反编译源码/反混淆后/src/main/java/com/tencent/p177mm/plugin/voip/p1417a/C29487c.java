package com.tencent.p177mm.plugin.voip.p1417a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.voip.a.c */
public final class C29487c {
    public int mState;
    private Map<Integer, Map<Integer, Integer>> sZi;

    public C29487c(int i) {
        this.mState = i;
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: al */
    public final void mo47749al(int i, int i2, int i3) {
        Map map;
        AppMethodBeat.m2504i(ReaderCallback.SEARCH_SELECT_TEXT);
        if (this.sZi == null) {
            this.sZi = new HashMap();
        }
        if (this.sZi.containsKey(Integer.valueOf(i))) {
            map = (Map) this.sZi.get(Integer.valueOf(i));
        } else {
            map = new HashMap();
            this.sZi.put(Integer.valueOf(i), map);
        }
        map.put(Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(ReaderCallback.SEARCH_SELECT_TEXT);
    }

    /* renamed from: GQ */
    public final boolean mo47747GQ(int i) {
        AppMethodBeat.m2504i(ReaderCallback.READER_TOAST);
        if (this.sZi == null || !this.sZi.containsKey(Integer.valueOf(this.mState))) {
            C4990ab.m7413e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", C40025b.m68545GK(this.mState));
            AppMethodBeat.m2505o(ReaderCallback.READER_TOAST);
            return false;
        } else if (((Map) this.sZi.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(i))) {
            AppMethodBeat.m2505o(ReaderCallback.READER_TOAST);
            return true;
        } else {
            C4990ab.m7413e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", C40025b.m68545GK(this.mState), C40025b.m68545GK(i));
            AppMethodBeat.m2505o(ReaderCallback.READER_TOAST);
            return false;
        }
    }

    /* renamed from: GR */
    public final void mo47748GR(int i) {
        AppMethodBeat.m2504i(ReaderCallback.SHOW_DIALOG);
        if (mo47747GQ(i)) {
            C4990ab.m7411d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", C40025b.m68545GK(this.mState), C40025b.m68545GK(((Integer) ((Map) this.sZi.get(Integer.valueOf(this.mState))).get(Integer.valueOf(i))).intValue()), C40025b.m68545GK(i));
            this.mState = r0;
            AppMethodBeat.m2505o(ReaderCallback.SHOW_DIALOG);
            return;
        }
        C4990ab.m7412e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
        AppMethodBeat.m2505o(ReaderCallback.SHOW_DIALOG);
    }
}
