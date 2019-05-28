package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p213cd.p214a.C1351a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5069y;

/* renamed from: com.tencent.mm.storage.f */
public final class C40629f implements C1351a<String> {
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

    /* renamed from: d */
    public final void mo64095d(Cursor cursor) {
        AppMethodBeat.m2504i(136948);
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
        AppMethodBeat.m2505o(136948);
    }

    /* renamed from: Oj */
    public final String mo64094Oj() {
        AppMethodBeat.m2504i(136949);
        String kN;
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            kN = C7486a.m12943kN(this.field_username);
            if (kN != null) {
                AppMethodBeat.m2505o(136949);
                return kN;
            } else if (this.field_nickname == null || this.field_nickname.length() <= 0) {
                kN = this.field_alias;
                if (C5046bo.isNullOrNil(kN)) {
                    kN = this.field_username;
                    if (kN == null) {
                        kN = null;
                    } else if (kN.toLowerCase().endsWith("@t.qq.com")) {
                        kN = "@" + kN.replace("@t.qq.com", "");
                    } else if (kN.toLowerCase().endsWith("@qqim")) {
                        kN = kN.replace("@qqim", "");
                        long longValue = Long.valueOf(kN).longValue();
                        if (longValue < 0) {
                            kN = new C1183p(longValue).toString();
                        }
                    }
                    if (kN == null || kN.length() == 0) {
                        kN = this.field_username;
                        AppMethodBeat.m2505o(136949);
                        return kN;
                    }
                    AppMethodBeat.m2505o(136949);
                    return kN;
                }
                AppMethodBeat.m2505o(136949);
                return kN;
            } else {
                kN = this.field_nickname;
                AppMethodBeat.m2505o(136949);
                return kN;
            }
        }
        kN = this.field_conRemark;
        AppMethodBeat.m2505o(136949);
        return kN;
    }

    private void drv() {
        AppMethodBeat.m2504i(136950);
        if (this.field_lvbuff == null) {
            AppMethodBeat.m2505o(136950);
            return;
        }
        try {
            if (this.field_lvbuff == null || this.field_lvbuff.length == 0) {
                AppMethodBeat.m2505o(136950);
                return;
            }
            C5069y c5069y = new C5069y();
            if (c5069y.mo10393bX(this.field_lvbuff) != 0) {
                AppMethodBeat.m2505o(136950);
                return;
            }
            c5069y.mo10390LW(4);
            c5069y.mo10390LW(4);
            c5069y.doe();
            c5069y.mo10390LW(8);
            c5069y.mo10390LW(4);
            c5069y.doe();
            c5069y.doe();
            c5069y.mo10390LW(4);
            c5069y.mo10390LW(4);
            c5069y.doe();
            c5069y.doe();
            c5069y.mo10390LW(4);
            c5069y.mo10390LW(4);
            this.field_signature = c5069y.getString();
            c5069y.doe();
            c5069y.doe();
            c5069y.doe();
            c5069y.mo10390LW(4);
            c5069y.mo10390LW(4);
            c5069y.doe();
            c5069y.mo10390LW(4);
            c5069y.doe();
            c5069y.doe();
            c5069y.mo10390LW(4);
            c5069y.mo10390LW(4);
            if (!c5069y.dof()) {
                this.field_remarkDesc = c5069y.getString();
            }
            this.field_lvbuff = null;
            AppMethodBeat.m2505o(136950);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AddressUIContact", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(136950);
        }
    }

    /* renamed from: q */
    public final void mo4704q(int i, byte[] bArr) {
        if (i == 9) {
            this.field_lvbuff = bArr;
        }
    }

    /* renamed from: bK */
    public final void mo4701bK(int i, String str) {
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
        AppMethodBeat.m2504i(136951);
        drv();
        AppMethodBeat.m2505o(136951);
    }

    /* renamed from: ag */
    public final void mo4700ag(int i, long j) {
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
