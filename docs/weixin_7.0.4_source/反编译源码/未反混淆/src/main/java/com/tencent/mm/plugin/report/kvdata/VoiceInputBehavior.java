package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class VoiceInputBehavior extends a {
    public int cancel;
    public int chooseArea;
    public int chooseCantonese;
    public int clear;
    public int click;
    public int fail;
    public int fullScreenVoiceLongClick;
    public long fullScreenVoiceLongClickTime;
    public long initChoose;
    public int longClick;
    public long longClickTime;
    public int send;
    public int setDefaultLanguage;
    public int setSwitchCantonese;
    public int setlanguage;
    public int showInit;
    public int smileIconClick;
    public int textChangeCount;
    public int textChangeReturn;
    public long textChangeTime;
    public int textClick;
    public int voiceIconClick;
    public long voiceInputTime;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79155);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.cancel);
            aVar.iz(2, this.send);
            aVar.iz(3, this.click);
            aVar.iz(4, this.longClick);
            aVar.ai(5, this.longClickTime);
            aVar.iz(6, this.textClick);
            aVar.iz(7, this.textChangeCount);
            aVar.ai(8, this.textChangeTime);
            aVar.iz(9, this.textChangeReturn);
            aVar.ai(10, this.voiceInputTime);
            aVar.iz(11, this.fail);
            aVar.iz(12, this.clear);
            aVar.iz(13, this.smileIconClick);
            aVar.iz(14, this.voiceIconClick);
            aVar.iz(15, this.fullScreenVoiceLongClick);
            aVar.ai(16, this.fullScreenVoiceLongClickTime);
            aVar.iz(17, this.showInit);
            aVar.ai(18, this.initChoose);
            aVar.iz(19, this.chooseArea);
            aVar.iz(20, this.chooseCantonese);
            aVar.iz(21, this.setlanguage);
            aVar.iz(22, this.setSwitchCantonese);
            aVar.iz(23, this.setDefaultLanguage);
            AppMethodBeat.o(79155);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((((((((((((e.a.a.b.b.a.bs(1, this.cancel) + 0) + e.a.a.b.b.a.bs(2, this.send)) + e.a.a.b.b.a.bs(3, this.click)) + e.a.a.b.b.a.bs(4, this.longClick)) + e.a.a.b.b.a.o(5, this.longClickTime)) + e.a.a.b.b.a.bs(6, this.textClick)) + e.a.a.b.b.a.bs(7, this.textChangeCount)) + e.a.a.b.b.a.o(8, this.textChangeTime)) + e.a.a.b.b.a.bs(9, this.textChangeReturn)) + e.a.a.b.b.a.o(10, this.voiceInputTime)) + e.a.a.b.b.a.bs(11, this.fail)) + e.a.a.b.b.a.bs(12, this.clear)) + e.a.a.b.b.a.bs(13, this.smileIconClick)) + e.a.a.b.b.a.bs(14, this.voiceIconClick)) + e.a.a.b.b.a.bs(15, this.fullScreenVoiceLongClick)) + e.a.a.b.b.a.o(16, this.fullScreenVoiceLongClickTime)) + e.a.a.b.b.a.bs(17, this.showInit)) + e.a.a.b.b.a.o(18, this.initChoose)) + e.a.a.b.b.a.bs(19, this.chooseArea)) + e.a.a.b.b.a.bs(20, this.chooseCantonese)) + e.a.a.b.b.a.bs(21, this.setlanguage)) + e.a.a.b.b.a.bs(22, this.setSwitchCantonese)) + e.a.a.b.b.a.bs(23, this.setDefaultLanguage);
            AppMethodBeat.o(79155);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79155);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            VoiceInputBehavior voiceInputBehavior = (VoiceInputBehavior) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    voiceInputBehavior.cancel = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 2:
                    voiceInputBehavior.send = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 3:
                    voiceInputBehavior.click = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 4:
                    voiceInputBehavior.longClick = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 5:
                    voiceInputBehavior.longClickTime = aVar3.BTU.ve();
                    AppMethodBeat.o(79155);
                    return 0;
                case 6:
                    voiceInputBehavior.textClick = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 7:
                    voiceInputBehavior.textChangeCount = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 8:
                    voiceInputBehavior.textChangeTime = aVar3.BTU.ve();
                    AppMethodBeat.o(79155);
                    return 0;
                case 9:
                    voiceInputBehavior.textChangeReturn = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 10:
                    voiceInputBehavior.voiceInputTime = aVar3.BTU.ve();
                    AppMethodBeat.o(79155);
                    return 0;
                case 11:
                    voiceInputBehavior.fail = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 12:
                    voiceInputBehavior.clear = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 13:
                    voiceInputBehavior.smileIconClick = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 14:
                    voiceInputBehavior.voiceIconClick = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 15:
                    voiceInputBehavior.fullScreenVoiceLongClick = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 16:
                    voiceInputBehavior.fullScreenVoiceLongClickTime = aVar3.BTU.ve();
                    AppMethodBeat.o(79155);
                    return 0;
                case 17:
                    voiceInputBehavior.showInit = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 18:
                    voiceInputBehavior.initChoose = aVar3.BTU.ve();
                    AppMethodBeat.o(79155);
                    return 0;
                case 19:
                    voiceInputBehavior.chooseArea = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 20:
                    voiceInputBehavior.chooseCantonese = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 21:
                    voiceInputBehavior.setlanguage = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 22:
                    voiceInputBehavior.setSwitchCantonese = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                case 23:
                    voiceInputBehavior.setDefaultLanguage = aVar3.BTU.vd();
                    AppMethodBeat.o(79155);
                    return 0;
                default:
                    AppMethodBeat.o(79155);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79155);
            return -1;
        }
    }
}
