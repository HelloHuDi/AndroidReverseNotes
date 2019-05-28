package com.tencent.mm.plugin.voip.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public int mState;
    private Map<Integer, Map<Integer, Integer>> sZi;

    public c(int i) {
        this.mState = i;
    }

    @SuppressLint({"UseSparseArrays"})
    public final void al(int i, int i2, int i3) {
        Map map;
        AppMethodBeat.i(ReaderCallback.SEARCH_SELECT_TEXT);
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
        AppMethodBeat.o(ReaderCallback.SEARCH_SELECT_TEXT);
    }

    public final boolean GQ(int i) {
        AppMethodBeat.i(ReaderCallback.READER_TOAST);
        if (this.sZi == null || !this.sZi.containsKey(Integer.valueOf(this.mState))) {
            ab.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", b.GK(this.mState));
            AppMethodBeat.o(ReaderCallback.READER_TOAST);
            return false;
        } else if (((Map) this.sZi.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(i))) {
            AppMethodBeat.o(ReaderCallback.READER_TOAST);
            return true;
        } else {
            ab.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", b.GK(this.mState), b.GK(i));
            AppMethodBeat.o(ReaderCallback.READER_TOAST);
            return false;
        }
    }

    public final void GR(int i) {
        AppMethodBeat.i(ReaderCallback.SHOW_DIALOG);
        if (GQ(i)) {
            ab.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", b.GK(this.mState), b.GK(((Integer) ((Map) this.sZi.get(Integer.valueOf(this.mState))).get(Integer.valueOf(i))).intValue()), b.GK(i));
            this.mState = r0;
            AppMethodBeat.o(ReaderCallback.SHOW_DIALOG);
            return;
        }
        ab.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
        AppMethodBeat.o(ReaderCallback.SHOW_DIALOG);
    }
}
