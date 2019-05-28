package com.tencent.p177mm.p612ui.chatting;

import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.IChattingUIProxy;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.y */
public final class C36230y implements IChattingUIProxy {
    private MMFragmentActivity iWA;
    private BaseChattingUIFragment ypn;

    public C36230y(MMFragmentActivity mMFragmentActivity, BaseChattingUIFragment baseChattingUIFragment) {
        this.ypn = baseChattingUIFragment;
        this.iWA = mMFragmentActivity;
    }

    public final void onInit(int i, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(30911);
        this.ypn.yHj = true;
        List<Fragment> fragments = this.iWA.getSupportFragmentManager().getFragments();
        if (fragments == null) {
            C4990ab.m7416i("MicroMsg.ChattingUIProxy", "fragments is null");
        } else if (fragments.size() >= 5) {
            C4990ab.m7413e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", Integer.valueOf(fragments.size()));
            for (Fragment fragment : fragments) {
                if (fragment instanceof ChattingUIFragment) {
                    C4990ab.m7412e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
                    z2 = false;
                    break;
                }
            }
        } else {
            C4990ab.m7417i("MicroMsg.ChattingUIProxy", "fragments size %s", Integer.valueOf(fragments.size()));
        }
        z2 = true;
        C4990ab.m7417i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z2) {
            this.iWA.getSupportFragmentManager().beginTransaction().mo552a(i, this.ypn).commitAllowingStateLoss();
            this.iWA.getSupportFragmentManager().executePendingTransactions();
        } else {
            this.iWA.getSupportFragmentManager().beginTransaction().mo556b(i, this.ypn).commitAllowingStateLoss();
        }
        if (z) {
            onExitBegin();
            onExitEnd();
        }
        this.ypn.yHj = false;
        AppMethodBeat.m2505o(30911);
    }

    public final void onEnterBegin() {
        AppMethodBeat.m2504i(30912);
        C4990ab.m7416i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
        this.ypn.dBE();
        this.ypn.onEnterBegin();
        this.ypn.dBF();
        AppMethodBeat.m2505o(30912);
    }

    public final void onEnterEnd() {
        AppMethodBeat.m2504i(30913);
        C4990ab.m7416i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
        if (this.ypn.mo39461Oe(256)) {
            this.ypn.dBG();
            this.ypn.onEnterEnd();
        }
        AppMethodBeat.m2505o(30913);
    }

    public final void onExitBegin() {
        AppMethodBeat.m2504i(30914);
        C4990ab.m7416i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
        if (!this.ypn.dBM()) {
            this.ypn.onExitBegin();
        }
        AppMethodBeat.m2505o(30914);
    }

    public final void onExitEnd() {
        AppMethodBeat.m2504i(30915);
        C4990ab.m7416i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
        this.ypn.dBH();
        this.ypn.dBI();
        this.ypn.dBJ();
        this.ypn.onExitEnd();
        AppMethodBeat.m2505o(30915);
    }
}
