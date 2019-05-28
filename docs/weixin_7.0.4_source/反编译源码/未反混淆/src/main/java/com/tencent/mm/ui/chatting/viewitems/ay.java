package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;

public class ay extends c {
    public b cJM;
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
    public q ziz;

    public ay() {
        this.cSQ = 0;
    }

    public ay(bi biVar, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        this.cSQ = 0;
        this.cKd = biVar;
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

    public ay(bi biVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.cSQ = 0;
        this.cKd = biVar;
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

    public ay(bi biVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5) {
        this(biVar, z, i, str, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public ay(bi biVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4) {
        this(biVar, z, i, str, z2, str2, str3, str4, null);
    }

    private ay(bi biVar, boolean z, int i, String str) {
        this(biVar, z, i, str, false, null, null, null);
    }

    private ay(bi biVar, boolean z, int i, String str, byte b) {
        this(biVar, z, i, str);
    }

    public ay(bi biVar, boolean z, int i, String str, char c) {
        this(biVar, z, i, str, (byte) 0);
    }

    public ay(bi biVar, boolean z, int i, String str, String str2) {
        this(biVar, z, i, str, (byte) 0);
        this.chatroomName = str2;
    }

    public ay(bi biVar, String str) {
        this(str);
        this.cKd = biVar;
    }

    private ay(String str) {
        this.cSQ = 0;
        this.userName = str;
    }

    public ay(String str, String str2) {
        this.cSQ = 0;
        this.userName = str;
        this.chatroomName = str2;
    }

    public ay(bi biVar, String str, String str2) {
        this.cSQ = 0;
        this.cKd = biVar;
        this.userName = str;
        this.cKd = biVar;
        this.hzj = str2;
    }

    public static ay arL(String str) {
        AppMethodBeat.i(33443);
        ay ayVar = new ay();
        ayVar.dJv = str;
        AppMethodBeat.o(33443);
        return ayVar;
    }

    public static ay a(b bVar, bi biVar) {
        AppMethodBeat.i(33444);
        ay ayVar = new ay();
        ayVar.cJM = bVar;
        ayVar.cKd = biVar;
        AppMethodBeat.o(33444);
        return ayVar;
    }

    public static ay b(bi biVar, boolean z, int i) {
        AppMethodBeat.i(33445);
        ay ayVar = new ay();
        ayVar.cKd = biVar;
        ayVar.yFW = z;
        ayVar.position = i;
        ayVar.zix = false;
        AppMethodBeat.o(33445);
        return ayVar;
    }
}
