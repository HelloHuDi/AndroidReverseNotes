package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c extends com.tencent.mm.kernel.c.a {

    public enum a {
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
            AppMethodBeat.o(128627);
        }

        private a(int i) {
            this.value = i;
        }

        public static a uW(int i) {
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
