package com.tencent.p177mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32697fh;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.bjg;
import com.tencent.p177mm.protocal.protobuf.csg;
import com.tencent.p177mm.protocal.protobuf.csl;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.ag */
public final class C43806ag extends C32697fh {
    public static C4924a ccO;
    public String nYG = "";
    private bjg tCF = new bjg();
    public csg tCG = null;
    public csl tCH = null;
    public boolean tCI = false;
    public String tCJ = "";
    public String tCK = "";
    public String tCL = "";
    public String tCM = "";

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C43806ag() {
        AppMethodBeat.m2504i(46941);
        if (this.tCG == null) {
            this.tCG = new csg();
        }
        if (this.tCH == null) {
            this.tCH = new csl();
        }
        AppMethodBeat.m2505o(46941);
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(46942);
        super.mo8995d(cursor);
        this.tCF = new bjg();
        try {
            this.tCF = (bjg) this.tCF.parseFrom(this.field_wallet_grey_item_buf);
            this.tCG = this.tCF.wMz;
            this.tCH = this.tCF.wMA;
            this.tCI = this.tCF.wMB;
            this.tCM = "";
            Iterator it = this.tCF.wMC.iterator();
            while (it.hasNext()) {
                this.tCM += ((String) it.next()) + IOUtils.LINE_SEPARATOR_UNIX;
            }
            if (this.tCF.wMx != null) {
                this.tCJ = C1946aa.m4147a(this.tCF.wMx.xpO);
                this.tCK = C1946aa.m4147a(this.tCF.wMx.xpP);
            }
            if (this.tCF.wMy != null) {
                this.tCL = C1946aa.m4147a(this.tCF.wMy.xpM);
                this.nYG = C1946aa.m4147a(this.tCF.wMy.xpN);
            }
            C4990ab.m7419v("WalletRegionGreyItem", "noticeContent %s", this.tCL);
        } catch (Exception e) {
            C4990ab.m7412e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.tCG == null) {
            this.tCG = new csg();
        }
        if (this.tCH == null) {
            this.tCH = new csl();
        }
        AppMethodBeat.m2505o(46942);
    }

    static {
        AppMethodBeat.m2504i(46943);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "wallet_region";
        c4924a.xDd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "wallet_region";
        c4924a.columns[1] = "wallet_grey_item_buf";
        c4924a.xDd.put("wallet_grey_item_buf", "BLOB");
        stringBuilder.append(" wallet_grey_item_buf BLOB");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46943);
    }
}
