package com.tencent.p177mm.plugin.expt.p394a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1694a;

/* renamed from: com.tencent.mm.plugin.expt.a.c */
public interface C43014c extends C1694a {

    /* renamed from: com.tencent.mm.plugin.expt.a.c$a */
    public enum C38982a {
        MM_DEFAULT(0),
        MMAppMgr_Activated(1),
        MMAppMgr_Deactivated(2),
        MMLifeCall_OnResume(3),
        MMLifeCall_OnPause(4),
        MMActivity_OnResume(5),
        MMActivity_OnPause(6),
        MMActivity_Back2Front(7),
        MMActivity_Front2Back(8);
        
        public int value;

        static {
            AppMethodBeat.m2505o(128627);
        }

        private C38982a(int i) {
            this.value = i;
        }

        /* renamed from: uW */
        public static C38982a m66222uW(int i) {
            switch (i) {
                case 1:
                    return MMAppMgr_Activated;
                case 2:
                    return MMAppMgr_Deactivated;
                case 3:
                    return MMLifeCall_OnResume;
                case 4:
                    return MMLifeCall_OnPause;
                case 5:
                    return MMActivity_OnResume;
                case 6:
                    return MMActivity_OnPause;
                case 7:
                    return MMActivity_Back2Front;
                case 8:
                    return MMActivity_Front2Back;
                default:
                    return MM_DEFAULT;
            }
        }
    }

    void logout();
}
