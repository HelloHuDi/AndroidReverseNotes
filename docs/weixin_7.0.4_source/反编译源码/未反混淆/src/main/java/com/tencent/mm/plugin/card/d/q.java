package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q {
    EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND(1),
    EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD(2),
    EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL(3);
    
    public int scene;

    static {
        AppMethodBeat.o(88945);
    }

    private q(int i) {
        this.scene = i;
    }
}
