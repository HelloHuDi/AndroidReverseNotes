package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p659pb.common.p1102c.C40956g;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24194aw;
import com.tencent.p659pb.p1514a.p1515a.C36407a;

/* renamed from: com.tencent.wecall.talkroom.model.d */
public final class C6003d {
    C24193av AJb;
    private C24194aw AJc;
    private String rAH;

    public C6003d(C24193av c24193av) {
        AppMethodBeat.m2504i(127811);
        mo13135a(c24193av);
        AppMethodBeat.m2505o(127811);
    }

    public C6003d(C24193av c24193av, C24194aw c24194aw) {
        AppMethodBeat.m2504i(127812);
        mo13135a(c24193av);
        if (c24194aw == null) {
            C44443c.m80392w("tagorewang:TalkRoomMember", "set null profile");
            AppMethodBeat.m2505o(127812);
            return;
        }
        this.AJc = c24194aw;
        AppMethodBeat.m2505o(127812);
    }

    /* renamed from: a */
    public final void mo13135a(C24193av c24193av) {
        AppMethodBeat.m2504i(127813);
        if (c24193av == null) {
            C44443c.m80392w("tagorewang:TalkRoomMember", "set null info");
            AppMethodBeat.m2505o(127813);
            return;
        }
        this.AJb = c24193av;
        AppMethodBeat.m2505o(127813);
    }

    public final String dTi() {
        if (this.AJb != null) {
            return this.AJb.Aop;
        }
        return "";
    }

    public final String getDisplayName() {
        AppMethodBeat.m2504i(127814);
        String stringBuilder;
        try {
            String str = this.rAH;
            if (str == null || str.trim().length() == 0) {
                AppMethodBeat.m2505o(127814);
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
                AppMethodBeat.m2505o(127814);
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
            AppMethodBeat.m2505o(127814);
            return stringBuilder;
        } catch (Exception e) {
            C44443c.m80392w("tagorewang:TalkRoomMember", "getDisplayName err: ", e);
            stringBuilder = this.rAH;
            AppMethodBeat.m2505o(127814);
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
        AppMethodBeat.m2504i(127815);
        int i = 0;
        if (this.AJb != null) {
            i = this.AJb.vzt;
        } else if (this.AJc != null) {
            i = this.AJc.vzt;
        }
        String concat;
        if (this.AJb == null || this.AJc == null) {
            concat = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i));
            AppMethodBeat.m2505o(127815);
            return concat;
        }
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        C24193av c24193av = this.AJb;
        if (c24193av == null) {
            concat = BuildConfig.COMMAND;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("VoiceGroupMem");
            stringBuilder.append(" uuid:").append(c24193av.vzt);
            stringBuilder.append(" openClientId:").append(c24193av.Apl);
            stringBuilder.append(" invite uuid: ").append(c24193av.Aph);
            stringBuilder.append(" member id:").append(c24193av.kyZ);
            stringBuilder.append(" status: ").append(c24193av.status);
            stringBuilder.append(" reason: ").append(c24193av.boZ);
            concat = stringBuilder.toString();
        }
        stringBuilder = stringBuilder2.append(concat).append(" ");
        C24194aw c24194aw = this.AJc;
        if (c24194aw == null) {
            concat = BuildConfig.COMMAND;
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("VoiceGroupUsrProfile");
            stringBuilder3.append(" uuid: ").append(c24194aw.vzt);
            stringBuilder3.append(" user name: ").append(c24194aw.username);
            stringBuilder3.append(" head url: ").append(c24194aw.pHn);
            concat = stringBuilder3.toString();
        }
        stringBuilder.append(concat);
        concat = stringBuilder2.toString();
        AppMethodBeat.m2505o(127815);
        return concat;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(127816);
        if (obj == null || !(obj instanceof C6003d)) {
            AppMethodBeat.m2505o(127816);
            return false;
        }
        boolean equals = C40956g.equals(dTi(), ((C6003d) obj).dTi());
        AppMethodBeat.m2505o(127816);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(127817);
        String dTi = dTi();
        if (dTi == null) {
            AppMethodBeat.m2505o(127817);
            return 0;
        }
        int hashCode = dTi.hashCode();
        AppMethodBeat.m2505o(127817);
        return hashCode;
    }

    public final boolean dTk() {
        AppMethodBeat.m2504i(127818);
        boolean equals = C40956g.equals(C36407a.dPM(), dTi());
        AppMethodBeat.m2505o(127818);
        return equals;
    }
}
