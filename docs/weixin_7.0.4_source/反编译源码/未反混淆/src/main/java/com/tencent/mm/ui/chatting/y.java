package com.tencent.mm.ui.chatting;

import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.List;

public final class y implements IChattingUIProxy {
    private MMFragmentActivity iWA;
    private BaseChattingUIFragment ypn;

    public y(MMFragmentActivity mMFragmentActivity, BaseChattingUIFragment baseChattingUIFragment) {
        this.ypn = baseChattingUIFragment;
        this.iWA = mMFragmentActivity;
    }

    public final void onInit(int i, boolean z) {
        boolean z2;
        AppMethodBeat.i(30911);
        this.ypn.yHj = true;
        List<Fragment> fragments = this.iWA.getSupportFragmentManager().getFragments();
        if (fragments == null) {
            ab.i("MicroMsg.ChattingUIProxy", "fragments is null");
        } else if (fragments.size() >= 5) {
            ab.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", Integer.valueOf(fragments.size()));
            for (Fragment fragment : fragments) {
                if (fragment instanceof ChattingUIFragment) {
                    ab.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
                    z2 = false;
                    break;
                }
            }
        } else {
            ab.i("MicroMsg.ChattingUIProxy", "fragments size %s", Integer.valueOf(fragments.size()));
        }
        z2 = true;
        ab.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z2) {
            this.iWA.getSupportFragmentManager().beginTransaction().a(i, this.ypn).commitAllowingStateLoss();
            this.iWA.getSupportFragmentManager().executePendingTransactions();
        } else {
            this.iWA.getSupportFragmentManager().beginTransaction().b(i, this.ypn).commitAllowingStateLoss();
        }
        if (z) {
            onExitBegin();
            onExitEnd();
        }
        this.ypn.yHj = false;
        AppMethodBeat.o(30911);
    }

    public final void onEnterBegin() {
        AppMethodBeat.i(30912);
        ab.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
        this.ypn.dBE();
        this.ypn.onEnterBegin();
        this.ypn.dBF();
        AppMethodBeat.o(30912);
    }

    public final void onEnterEnd() {
        AppMethodBeat.i(30913);
        ab.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
        if (this.ypn.Oe(256)) {
            this.ypn.dBG();
            this.ypn.onEnterEnd();
        }
        AppMethodBeat.o(30913);
    }

    public final void onExitBegin() {
        AppMethodBeat.i(30914);
        ab.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
        if (!this.ypn.dBM()) {
            this.ypn.onExitBegin();
        }
        AppMethodBeat.o(30914);
    }

    public final void onExitEnd() {
        AppMethodBeat.i(30915);
        ab.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
        this.ypn.dBH();
        this.ypn.dBI();
        this.ypn.dBJ();
        this.ypn.onExitEnd();
        AppMethodBeat.o(30915);
    }
}
