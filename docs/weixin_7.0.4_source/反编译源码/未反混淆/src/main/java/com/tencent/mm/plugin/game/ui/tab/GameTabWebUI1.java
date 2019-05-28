package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameTabWebUI1 extends GameTabWebUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
