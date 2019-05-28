package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44079c;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ay */
public class C40814ay extends C44079c {
    public C8910b cJM;
    public String cMg;
    public String cMh;
    public String cRS;
    public int cSQ;
    public String chatroomName;
    public String cwg;
    public String dJv;
    public String desc;
    public String designerName;
    public String designerRediretctUrl;
    public int designerUIN;
    public String fiE;
    public String hzj;
    public String iconUrl;
    public int pageType;
    public int position;
    public String secondUrl;
    public int tid;
    public String title;
    public long unn;
    public int uno;
    public String userName;
    public boolean yFW;
    public int ziA;
    public boolean zis;
    public String zit;
    public boolean ziu;
    public boolean ziv;
    public String ziw;
    public boolean zix;
    public Bundle ziy;
    public C46627q ziz;

    public C40814ay() {
        this.cSQ = 0;
    }

    public C40814ay(C7620bi c7620bi, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        this.cSQ = 0;
        this.cKd = c7620bi;
        this.yFW = false;
        this.position = i;
        this.userName = str;
        this.zis = false;
        this.title = str2;
        this.cMg = str3;
        this.cMh = str4;
        this.zit = str5;
        this.designerUIN = i2;
        this.designerName = str6;
        this.designerRediretctUrl = str7;
        this.dJv = str8;
    }

    public C40814ay(C7620bi c7620bi, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.cSQ = 0;
        this.cKd = c7620bi;
        this.yFW = z;
        this.position = i;
        this.userName = str;
        this.zis = z2;
        this.title = str2;
        this.cMg = str3;
        this.cMh = str4;
        this.zit = str5;
        this.cwg = str6;
        this.dJv = str7;
        this.ziu = z3;
        this.ziv = z4;
    }

    public C40814ay(C7620bi c7620bi, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5) {
        this(c7620bi, z, i, str, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public C40814ay(C7620bi c7620bi, boolean z, int i, String str, boolean z2, String str2, String str3, String str4) {
        this(c7620bi, z, i, str, z2, str2, str3, str4, null);
    }

    private C40814ay(C7620bi c7620bi, boolean z, int i, String str) {
        this(c7620bi, z, i, str, false, null, null, null);
    }

    private C40814ay(C7620bi c7620bi, boolean z, int i, String str, byte b) {
        this(c7620bi, z, i, str);
    }

    public C40814ay(C7620bi c7620bi, boolean z, int i, String str, char c) {
        this(c7620bi, z, i, str, (byte) 0);
    }

    public C40814ay(C7620bi c7620bi, boolean z, int i, String str, String str2) {
        this(c7620bi, z, i, str, (byte) 0);
        this.chatroomName = str2;
    }

    public C40814ay(C7620bi c7620bi, String str) {
        this(str);
        this.cKd = c7620bi;
    }

    private C40814ay(String str) {
        this.cSQ = 0;
        this.userName = str;
    }

    public C40814ay(String str, String str2) {
        this.cSQ = 0;
        this.userName = str;
        this.chatroomName = str2;
    }

    public C40814ay(C7620bi c7620bi, String str, String str2) {
        this.cSQ = 0;
        this.cKd = c7620bi;
        this.userName = str;
        this.cKd = c7620bi;
        this.hzj = str2;
    }

    public static C40814ay arL(String str) {
        AppMethodBeat.m2504i(33443);
        C40814ay c40814ay = new C40814ay();
        c40814ay.dJv = str;
        AppMethodBeat.m2505o(33443);
        return c40814ay;
    }

    /* renamed from: a */
    public static C40814ay m70729a(C8910b c8910b, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33444);
        C40814ay c40814ay = new C40814ay();
        c40814ay.cJM = c8910b;
        c40814ay.cKd = c7620bi;
        AppMethodBeat.m2505o(33444);
        return c40814ay;
    }

    /* renamed from: b */
    public static C40814ay m70730b(C7620bi c7620bi, boolean z, int i) {
        AppMethodBeat.m2504i(33445);
        C40814ay c40814ay = new C40814ay();
        c40814ay.cKd = c7620bi;
        c40814ay.yFW = z;
        c40814ay.position = i;
        c40814ay.zix = false;
        AppMethodBeat.m2505o(33445);
        return c40814ay;
    }
}
