package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior */
public class VoiceInputBehavior extends C1331a {
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79155);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.cancel);
            c6093a.mo13480iz(2, this.send);
            c6093a.mo13480iz(3, this.click);
            c6093a.mo13480iz(4, this.longClick);
            c6093a.mo13472ai(5, this.longClickTime);
            c6093a.mo13480iz(6, this.textClick);
            c6093a.mo13480iz(7, this.textChangeCount);
            c6093a.mo13472ai(8, this.textChangeTime);
            c6093a.mo13480iz(9, this.textChangeReturn);
            c6093a.mo13472ai(10, this.voiceInputTime);
            c6093a.mo13480iz(11, this.fail);
            c6093a.mo13480iz(12, this.clear);
            c6093a.mo13480iz(13, this.smileIconClick);
            c6093a.mo13480iz(14, this.voiceIconClick);
            c6093a.mo13480iz(15, this.fullScreenVoiceLongClick);
            c6093a.mo13472ai(16, this.fullScreenVoiceLongClickTime);
            c6093a.mo13480iz(17, this.showInit);
            c6093a.mo13472ai(18, this.initChoose);
            c6093a.mo13480iz(19, this.chooseArea);
            c6093a.mo13480iz(20, this.chooseCantonese);
            c6093a.mo13480iz(21, this.setlanguage);
            c6093a.mo13480iz(22, this.setSwitchCantonese);
            c6093a.mo13480iz(23, this.setDefaultLanguage);
            AppMethodBeat.m2505o(79155);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((((((((((((C6091a.m9572bs(1, this.cancel) + 0) + C6091a.m9572bs(2, this.send)) + C6091a.m9572bs(3, this.click)) + C6091a.m9572bs(4, this.longClick)) + C6091a.m9578o(5, this.longClickTime)) + C6091a.m9572bs(6, this.textClick)) + C6091a.m9572bs(7, this.textChangeCount)) + C6091a.m9578o(8, this.textChangeTime)) + C6091a.m9572bs(9, this.textChangeReturn)) + C6091a.m9578o(10, this.voiceInputTime)) + C6091a.m9572bs(11, this.fail)) + C6091a.m9572bs(12, this.clear)) + C6091a.m9572bs(13, this.smileIconClick)) + C6091a.m9572bs(14, this.voiceIconClick)) + C6091a.m9572bs(15, this.fullScreenVoiceLongClick)) + C6091a.m9578o(16, this.fullScreenVoiceLongClickTime)) + C6091a.m9572bs(17, this.showInit)) + C6091a.m9578o(18, this.initChoose)) + C6091a.m9572bs(19, this.chooseArea)) + C6091a.m9572bs(20, this.chooseCantonese)) + C6091a.m9572bs(21, this.setlanguage)) + C6091a.m9572bs(22, this.setSwitchCantonese)) + C6091a.m9572bs(23, this.setDefaultLanguage);
            AppMethodBeat.m2505o(79155);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79155);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            VoiceInputBehavior voiceInputBehavior = (VoiceInputBehavior) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    voiceInputBehavior.cancel = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 2:
                    voiceInputBehavior.send = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 3:
                    voiceInputBehavior.click = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 4:
                    voiceInputBehavior.longClick = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 5:
                    voiceInputBehavior.longClickTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 6:
                    voiceInputBehavior.textClick = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 7:
                    voiceInputBehavior.textChangeCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 8:
                    voiceInputBehavior.textChangeTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 9:
                    voiceInputBehavior.textChangeReturn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 10:
                    voiceInputBehavior.voiceInputTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 11:
                    voiceInputBehavior.fail = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 12:
                    voiceInputBehavior.clear = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 13:
                    voiceInputBehavior.smileIconClick = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 14:
                    voiceInputBehavior.voiceIconClick = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 15:
                    voiceInputBehavior.fullScreenVoiceLongClick = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 16:
                    voiceInputBehavior.fullScreenVoiceLongClickTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 17:
                    voiceInputBehavior.showInit = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 18:
                    voiceInputBehavior.initChoose = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 19:
                    voiceInputBehavior.chooseArea = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 20:
                    voiceInputBehavior.chooseCantonese = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 21:
                    voiceInputBehavior.setlanguage = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 22:
                    voiceInputBehavior.setSwitchCantonese = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                case 23:
                    voiceInputBehavior.setDefaultLanguage = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79155);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79155);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79155);
            return -1;
        }
    }
}
