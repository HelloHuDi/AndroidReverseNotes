package com.tencent.p177mm.plugin.card.p931d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.card.d.q */
public enum C11280q {
    EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND(1),
    EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD(2),
    EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL(3);
    
    public int scene;

    static {
        AppMethodBeat.m2505o(88945);
    }

    private C11280q(int i) {
        this.scene = i;
    }
}
