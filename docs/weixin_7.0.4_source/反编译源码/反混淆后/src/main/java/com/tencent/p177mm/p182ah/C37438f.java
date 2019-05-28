package com.tencent.p177mm.p182ah;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: com.tencent.mm.ah.f */
public final class C37438f {
    int bJt = -1;
    int coc;
    int frL;
    int frM;
    String frN;
    int frO;
    int frP;
    String frQ;
    String frR;
    int frS;
    int frT;
    String username;

    public C37438f() {
        AppMethodBeat.m2504i(77915);
        reset();
        AppMethodBeat.m2505o(77915);
    }

    public final void reset() {
        this.username = "";
        this.frL = 0;
        this.frM = 0;
        this.frN = "";
        this.frO = 0;
        this.coc = 0;
        this.frP = 0;
        this.frQ = "";
        this.frR = "";
        this.frS = 0;
        this.frT = 0;
    }

    /* renamed from: Hl */
    public final ContentValues mo60326Hl() {
        String str;
        String str2;
        AppMethodBeat.m2504i(77916);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            str = "username";
            if (this.username == null) {
                str2 = "";
            } else {
                str2 = this.username;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("imgwidth", Integer.valueOf(this.frL));
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("imgheigth", Integer.valueOf(this.frM));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("imgformat", aci());
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.frO));
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("startpos", Integer.valueOf(this.coc));
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("headimgtype", Integer.valueOf(this.frP));
        }
        if ((this.bJt & 128) != 0) {
            str = "reserved1";
            if (this.frQ == null) {
                str2 = "";
            } else {
                str2 = this.frQ;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 256) != 0) {
            str = "reserved2";
            if (this.frR == null) {
                str2 = "";
            } else {
                str2 = this.frR;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.frS));
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.frT));
        }
        AppMethodBeat.m2505o(77916);
        return contentValues;
    }

    public final String aci() {
        return this.frN == null ? "" : this.frN;
    }
}
