package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5069y;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.tencent.mm.plugin.account.friend.a.a */
public final class C18817a {
    String bCu = "";
    public int bJt = -1;
    private String cvZ = "";
    public String dtV = "";
    public String eBb = "";
    public String frQ = "";
    public int frT = 0;
    public String guC = "";
    long guD = 0;
    public String guE = "";
    public String guF = "";
    String guG = "";
    String guH = "";
    public String guI = "";
    public int guJ = 0;
    public byte[] guK;
    public int guL;
    public String guM = "";
    public int guN = 0;
    public String guO = "";
    public String guP = "";
    public String guQ = "";
    int guR = 0;
    public String guS = "";
    int guT = 0;
    int guU = 0;
    String guV = "";
    public String guW = "";
    String guX = "";
    int guY = -1;
    String guZ = "";
    long gva = -1;
    int gvb = -1;
    String gvc = "";
    String gvd = "";
    String gve = "";
    public long gvf = 0;
    /* renamed from: id */
    private int f4337id = 0;
    public int status = 0;
    public int type = 0;
    public String username = "";

    public C18817a() {
        AppMethodBeat.m2504i(108301);
        AppMethodBeat.m2505o(108301);
    }

    /* renamed from: d */
    public final void mo34080d(Cursor cursor) {
        AppMethodBeat.m2504i(108302);
        mo34083vS(cursor.getString(1));
        this.guC = cursor.getString(2);
        this.guD = cursor.getLong(3);
        this.eBb = cursor.getString(4);
        this.guE = cursor.getString(5);
        this.guF = cursor.getString(6);
        this.username = cursor.getString(7);
        this.bCu = cursor.getString(8);
        this.guG = cursor.getString(9);
        this.guH = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.guI = cursor.getString(12);
        this.dtV = cursor.getString(13);
        int i = cursor.getInt(14);
        if (i == 65536) {
            this.status = 0;
        } else {
            this.status = i;
        }
        this.guJ = cursor.getInt(17);
        this.frQ = cursor.getString(15);
        this.frT = cursor.getInt(18);
        this.guK = cursor.getBlob(19);
        if (!C5046bo.m7540cb(this.guK)) {
            m29384ah(this.guK);
        }
        this.guL = cursor.getInt(20);
        AppMethodBeat.m2505o(108302);
    }

    /* renamed from: ah */
    private void m29384ah(byte[] bArr) {
        AppMethodBeat.m2504i(108303);
        try {
            C5069y c5069y = new C5069y();
            int bX = c5069y.mo10393bX(bArr);
            if (bX != 0) {
                C4990ab.m7412e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(bX)));
                AppMethodBeat.m2505o(108303);
                return;
            }
            this.guM = c5069y.getString();
            this.guN = c5069y.getInt();
            this.guO = c5069y.getString();
            this.guP = c5069y.getString();
            this.guQ = c5069y.getString();
            this.guR = c5069y.getInt();
            this.guS = c5069y.getString();
            this.guT = c5069y.getInt();
            this.guU = c5069y.getInt();
            this.guV = c5069y.getString();
            this.guW = c5069y.getString();
            this.guX = c5069y.getString();
            this.guY = c5069y.getInt();
            this.guZ = c5069y.getString();
            this.gva = c5069y.getLong();
            this.gvb = c5069y.getInt();
            this.gvc = c5069y.getString();
            this.gvd = c5069y.getString();
            this.gve = c5069y.getString();
            this.gvf = c5069y.getLong();
            AppMethodBeat.m2505o(108303);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            AppMethodBeat.m2505o(108303);
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo34068Hl() {
        AppMethodBeat.m2504i(108304);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("id", Integer.valueOf(this.f4337id));
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("md5", mo34067Aq());
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("peopleid", apz());
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.guD));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("realname", apA());
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("realnamepyinitial", apB());
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("realnamequanpin", apC());
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("nickname", apD());
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("nicknamepyinitial", apE());
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("nicknamequanpin", apF());
        }
        if ((this.bJt & 2048) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.bJt & 4096) != 0) {
            contentValues.put("moblie", apG());
        }
        if ((this.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            contentValues.put(Scopes.EMAIL, getEmail());
        }
        if ((this.bJt & 16384) != 0) {
            int i = this.status;
            if (i == 0) {
                contentValues.put("status", Integer.valueOf(65536));
            } else {
                contentValues.put("status", Integer.valueOf(i));
            }
        }
        if ((this.bJt & 32768) != 0) {
            contentValues.put("reserved1", this.frQ);
        }
        if ((this.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.guJ));
        }
        if ((this.bJt & 262144) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.frT));
        }
        if ((this.bJt & SQLiteGlobal.journalSizeLimit) != 0) {
            this.guK = apy();
            contentValues.put("lvbuf", this.guK);
        }
        if ((this.bJt & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.guL));
        }
        AppMethodBeat.m2505o(108304);
        return contentValues;
    }

    private byte[] apy() {
        AppMethodBeat.m2504i(108305);
        try {
            C5069y c5069y = new C5069y();
            c5069y.dog();
            c5069y.amu(this.guM);
            c5069y.mo10391LY(this.guN);
            c5069y.amu(this.guO);
            c5069y.amu(this.guP);
            c5069y.amu(this.guQ);
            c5069y.mo10391LY(this.guR);
            c5069y.amu(this.guS);
            c5069y.mo10391LY(this.guT);
            c5069y.mo10391LY(this.guU);
            c5069y.amu(this.guV);
            c5069y.amu(this.guW);
            c5069y.amu(this.guX);
            c5069y.mo10391LY(this.guY);
            c5069y.amu(this.guZ);
            c5069y.mo10403mq(this.gva);
            c5069y.mo10391LY(this.gvb);
            c5069y.amu(this.gvc);
            c5069y.amu(this.gvd);
            c5069y.amu(this.gve);
            c5069y.mo10403mq(this.gvf);
            byte[] doh = c5069y.doh();
            AppMethodBeat.m2505o(108305);
            return doh;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            AppMethodBeat.m2505o(108305);
            return null;
        }
    }

    /* renamed from: vR */
    public static int m29385vR(String str) {
        int i = 0;
        AppMethodBeat.m2504i(108306);
        try {
            i = C5046bo.anc("0x" + str.substring(0, 8));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AddrUpload", e, "md5: %s", str);
        }
        AppMethodBeat.m2505o(108306);
        return i;
    }

    /* renamed from: vS */
    public final void mo34083vS(String str) {
        AppMethodBeat.m2504i(108307);
        this.cvZ = str;
        this.f4337id = C18817a.m29385vR(str);
        AppMethodBeat.m2505o(108307);
    }

    /* renamed from: Aq */
    public final String mo34067Aq() {
        return this.cvZ == null ? "" : this.cvZ;
    }

    public final String apz() {
        return this.guC == null ? "" : this.guC;
    }

    public final String apA() {
        return this.eBb == null ? "" : this.eBb;
    }

    public final String apB() {
        return this.guE == null ? "" : this.guE;
    }

    public final String apC() {
        return this.guF == null ? "" : this.guF;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String apD() {
        return this.bCu == null ? "" : this.bCu;
    }

    public final String apE() {
        return this.guG == null ? "" : this.guG;
    }

    public final String apF() {
        return this.guH == null ? "" : this.guH;
    }

    public final String apG() {
        return this.guI == null ? "" : this.guI;
    }

    public final String getEmail() {
        return this.dtV == null ? "" : this.dtV;
    }

    public final void apH() {
        this.guJ |= 1;
    }

    public final boolean apI() {
        return (this.guJ & 1) == 0;
    }

    /* renamed from: Ny */
    public final int mo34069Ny() {
        AppMethodBeat.m2504i(108308);
        int i = 32;
        if (!C5046bo.isNullOrNil(apB())) {
            i = apB().charAt(0);
        } else if (!C5046bo.isNullOrNil(apC())) {
            i = apC().charAt(0);
        }
        if (i >= 97 && i <= 122) {
            i = (char) (i - 32);
        } else if (i < 65 || i > 90) {
            i = 123;
        }
        AppMethodBeat.m2505o(108308);
        return i;
    }
}
