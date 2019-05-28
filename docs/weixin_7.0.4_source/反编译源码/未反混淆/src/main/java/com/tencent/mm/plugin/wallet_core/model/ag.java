package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fh;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class ag extends fh {
    public static a ccO;
    public String nYG = "";
    private bjg tCF = new bjg();
    public csg tCG = null;
    public csl tCH = null;
    public boolean tCI = false;
    public String tCJ = "";
    public String tCK = "";
    public String tCL = "";
    public String tCM = "";

    public final a Ag() {
        return ccO;
    }

    public ag() {
        AppMethodBeat.i(46941);
        if (this.tCG == null) {
            this.tCG = new csg();
        }
        if (this.tCH == null) {
            this.tCH = new csl();
        }
        AppMethodBeat.o(46941);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(46942);
        super.d(cursor);
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
                this.tCJ = aa.a(this.tCF.wMx.xpO);
                this.tCK = aa.a(this.tCF.wMx.xpP);
            }
            if (this.tCF.wMy != null) {
                this.tCL = aa.a(this.tCF.wMy.xpM);
                this.nYG = aa.a(this.tCF.wMy.xpN);
            }
            ab.v("WalletRegionGreyItem", "noticeContent %s", this.tCL);
        } catch (Exception e) {
            ab.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.tCG == null) {
            this.tCG = new csg();
        }
        if (this.tCH == null) {
            this.tCH = new csl();
        }
        AppMethodBeat.o(46942);
    }

    static {
        AppMethodBeat.i(46943);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.xDd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "wallet_region";
        aVar.columns[1] = "wallet_grey_item_buf";
        aVar.xDd.put("wallet_grey_item_buf", "BLOB");
        stringBuilder.append(" wallet_grey_item_buf BLOB");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46943);
    }
}
