package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;

public final class d {
    av AJb;
    private aw AJc;
    private String rAH;

    public d(av avVar) {
        AppMethodBeat.i(127811);
        a(avVar);
        AppMethodBeat.o(127811);
    }

    public d(av avVar, aw awVar) {
        AppMethodBeat.i(127812);
        a(avVar);
        if (awVar == null) {
            c.w("tagorewang:TalkRoomMember", "set null profile");
            AppMethodBeat.o(127812);
            return;
        }
        this.AJc = awVar;
        AppMethodBeat.o(127812);
    }

    public final void a(av avVar) {
        AppMethodBeat.i(127813);
        if (avVar == null) {
            c.w("tagorewang:TalkRoomMember", "set null info");
            AppMethodBeat.o(127813);
            return;
        }
        this.AJb = avVar;
        AppMethodBeat.o(127813);
    }

    public final String dTi() {
        if (this.AJb != null) {
            return this.AJb.Aop;
        }
        return "";
    }

    public final String getDisplayName() {
        AppMethodBeat.i(127814);
        String stringBuilder;
        try {
            String str = this.rAH;
            if (str == null || str.trim().length() == 0) {
                AppMethodBeat.o(127814);
                return str;
            }
            char[] toCharArray = str.trim().toCharArray();
            int i = 0;
            for (char c : toCharArray) {
                if (c >= 161) {
                    i += 2;
                } else {
                    i++;
                }
            }
            if (i <= 10) {
                AppMethodBeat.o(127814);
                return str;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            i = 0;
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                if (toCharArray[i2] >= 161) {
                    i += 2;
                } else {
                    i++;
                }
                if (i + 1 > 10) {
                    break;
                }
                stringBuilder2.append(toCharArray[i2]);
            }
            stringBuilder2.append(8230);
            stringBuilder = stringBuilder2.toString();
            AppMethodBeat.o(127814);
            return stringBuilder;
        } catch (Exception e) {
            c.w("tagorewang:TalkRoomMember", "getDisplayName err: ", e);
            stringBuilder = this.rAH;
            AppMethodBeat.o(127814);
            return stringBuilder;
        }
    }

    public final int getState() {
        if (this.AJb == null) {
            return 0;
        }
        return this.AJb.status;
    }

    public final int dTj() {
        if (this.AJb == null) {
            return -1;
        }
        return this.AJb.kyZ;
    }

    public final String toString() {
        AppMethodBeat.i(127815);
        int i = 0;
        if (this.AJb != null) {
            i = this.AJb.vzt;
        } else if (this.AJc != null) {
            i = this.AJc.vzt;
        }
        String concat;
        if (this.AJb == null || this.AJc == null) {
            concat = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i));
            AppMethodBeat.o(127815);
            return concat;
        }
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        av avVar = this.AJb;
        if (avVar == null) {
            concat = BuildConfig.COMMAND;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("VoiceGroupMem");
            stringBuilder.append(" uuid:").append(avVar.vzt);
            stringBuilder.append(" openClientId:").append(avVar.Apl);
            stringBuilder.append(" invite uuid: ").append(avVar.Aph);
            stringBuilder.append(" member id:").append(avVar.kyZ);
            stringBuilder.append(" status: ").append(avVar.status);
            stringBuilder.append(" reason: ").append(avVar.boZ);
            concat = stringBuilder.toString();
        }
        stringBuilder = stringBuilder2.append(concat).append(" ");
        aw awVar = this.AJc;
        if (awVar == null) {
            concat = BuildConfig.COMMAND;
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("VoiceGroupUsrProfile");
            stringBuilder3.append(" uuid: ").append(awVar.vzt);
            stringBuilder3.append(" user name: ").append(awVar.username);
            stringBuilder3.append(" head url: ").append(awVar.pHn);
            concat = stringBuilder3.toString();
        }
        stringBuilder.append(concat);
        concat = stringBuilder2.toString();
        AppMethodBeat.o(127815);
        return concat;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(127816);
        if (obj == null || !(obj instanceof d)) {
            AppMethodBeat.o(127816);
            return false;
        }
        boolean equals = g.equals(dTi(), ((d) obj).dTi());
        AppMethodBeat.o(127816);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.i(127817);
        String dTi = dTi();
        if (dTi == null) {
            AppMethodBeat.o(127817);
            return 0;
        }
        int hashCode = dTi.hashCode();
        AppMethodBeat.o(127817);
        return hashCode;
    }

    public final boolean dTk() {
        AppMethodBeat.i(127818);
        boolean equals = g.equals(a.dPM(), dTi());
        AppMethodBeat.o(127818);
        return equals;
    }
}
