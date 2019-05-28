package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.cd.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.y;

public final class f implements a<String> {
    public long ewQ;
    private String field_alias;
    public String field_conRemark;
    public int field_deleteFlag;
    public String field_descWording;
    public String field_descWordingId;
    public String field_descWordingQuanpin;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_openImAppid;
    public String field_remarkDesc;
    public int field_showHead;
    public String field_signature;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public CharSequence xHQ;

    public final void d(Cursor cursor) {
        AppMethodBeat.i(136948);
        this.field_username = cursor.getString(0);
        this.field_nickname = cursor.getString(1);
        this.field_alias = cursor.getString(2);
        this.field_conRemark = cursor.getString(3);
        this.field_verifyFlag = cursor.getInt(4);
        this.field_showHead = cursor.getInt(5);
        this.field_weiboFlag = cursor.getInt(6);
        this.ewQ = cursor.getLong(7);
        this.field_deleteFlag = cursor.getInt(8);
        this.field_lvbuff = cursor.getBlob(9);
        this.field_descWordingId = cursor.getString(10);
        this.field_openImAppid = cursor.getString(11);
        if (cursor.getColumnCount() >= 14) {
            this.field_descWording = cursor.getString(12);
            this.field_descWordingQuanpin = cursor.getString(13);
        }
        drv();
        AppMethodBeat.o(136948);
    }

    public final String Oj() {
        AppMethodBeat.i(136949);
        String kN;
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            kN = com.tencent.mm.n.a.kN(this.field_username);
            if (kN != null) {
                AppMethodBeat.o(136949);
                return kN;
            } else if (this.field_nickname == null || this.field_nickname.length() <= 0) {
                kN = this.field_alias;
                if (bo.isNullOrNil(kN)) {
                    kN = this.field_username;
                    if (kN == null) {
                        kN = null;
                    } else if (kN.toLowerCase().endsWith("@t.qq.com")) {
                        kN = "@" + kN.replace("@t.qq.com", "");
                    } else if (kN.toLowerCase().endsWith("@qqim")) {
                        kN = kN.replace("@qqim", "");
                        long longValue = Long.valueOf(kN).longValue();
                        if (longValue < 0) {
                            kN = new p(longValue).toString();
                        }
                    }
                    if (kN == null || kN.length() == 0) {
                        kN = this.field_username;
                        AppMethodBeat.o(136949);
                        return kN;
                    }
                    AppMethodBeat.o(136949);
                    return kN;
                }
                AppMethodBeat.o(136949);
                return kN;
            } else {
                kN = this.field_nickname;
                AppMethodBeat.o(136949);
                return kN;
            }
        }
        kN = this.field_conRemark;
        AppMethodBeat.o(136949);
        return kN;
    }

    private void drv() {
        AppMethodBeat.i(136950);
        if (this.field_lvbuff == null) {
            AppMethodBeat.o(136950);
            return;
        }
        try {
            if (this.field_lvbuff == null || this.field_lvbuff.length == 0) {
                AppMethodBeat.o(136950);
                return;
            }
            y yVar = new y();
            if (yVar.bX(this.field_lvbuff) != 0) {
                AppMethodBeat.o(136950);
                return;
            }
            yVar.LW(4);
            yVar.LW(4);
            yVar.doe();
            yVar.LW(8);
            yVar.LW(4);
            yVar.doe();
            yVar.doe();
            yVar.LW(4);
            yVar.LW(4);
            yVar.doe();
            yVar.doe();
            yVar.LW(4);
            yVar.LW(4);
            this.field_signature = yVar.getString();
            yVar.doe();
            yVar.doe();
            yVar.doe();
            yVar.LW(4);
            yVar.LW(4);
            yVar.doe();
            yVar.LW(4);
            yVar.doe();
            yVar.doe();
            yVar.LW(4);
            yVar.LW(4);
            if (!yVar.dof()) {
                this.field_remarkDesc = yVar.getString();
            }
            this.field_lvbuff = null;
            AppMethodBeat.o(136950);
        } catch (Exception e) {
            ab.e("MicroMsg.AddressUIContact", "exception:%s", bo.l(e));
            AppMethodBeat.o(136950);
        }
    }

    public final void q(int i, byte[] bArr) {
        if (i == 9) {
            this.field_lvbuff = bArr;
        }
    }

    public final void bK(int i, String str) {
        switch (i) {
            case 0:
                this.field_username = str;
                return;
            case 1:
                this.field_nickname = str;
                return;
            case 2:
                this.field_alias = str;
                return;
            case 3:
                this.field_conRemark = str;
                return;
            case 10:
                this.field_descWordingId = str;
                return;
            case 11:
                this.field_openImAppid = str;
                return;
            case 12:
                this.field_descWording = str;
                return;
            case 13:
                this.field_descWordingQuanpin = str;
                return;
            default:
                return;
        }
    }

    public final void drw() {
        AppMethodBeat.i(136951);
        drv();
        AppMethodBeat.o(136951);
    }

    public final void ag(int i, long j) {
        switch (i) {
            case 4:
                this.field_verifyFlag = (int) j;
                return;
            case 5:
                this.field_showHead = (int) j;
                return;
            case 6:
                this.field_weiboFlag = (int) j;
                return;
            case 7:
                this.ewQ = j;
                return;
            case 8:
                this.field_deleteFlag = (int) j;
                return;
            default:
                return;
        }
    }

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }
}
