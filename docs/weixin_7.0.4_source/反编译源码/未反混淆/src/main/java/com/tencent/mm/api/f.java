package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bw;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;

public final class f extends bw {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final void cD(String str) {
        AppMethodBeat.i(59556);
        if (!bo.isNullOrNil(str)) {
            this.field_cgi = str;
        }
        AppMethodBeat.o(59556);
    }

    public final void setCmdId(int i) {
        this.field_cmdid = i;
    }

    public final void ga(int i) {
        this.field_opCode = i;
    }

    public final int Ah() {
        return this.field_opCode;
    }

    public final void cE(String str) {
        AppMethodBeat.i(59557);
        if (!bo.isNullOrNil(str)) {
            this.field_functionmsgid = str;
        }
        AppMethodBeat.o(59557);
    }

    public final String Ai() {
        return this.field_functionmsgid;
    }

    public final void aG(long j) {
        this.field_version = j;
    }

    public final long getVersion() {
        return this.field_version;
    }

    public final void aH(long j) {
        this.field_preVersion = j;
    }

    public final long Aj() {
        return this.field_preVersion;
    }

    public final void setRetryInterval(int i) {
        this.field_retryinterval = i;
    }

    public final void gb(int i) {
        this.field_reportid = i;
    }

    public final void gc(int i) {
        this.field_successkey = i;
    }

    public final void gd(int i) {
        this.field_failkey = i;
    }

    public final void ge(int i) {
        this.field_finalfailkey = i;
    }

    public final void cF(String str) {
        AppMethodBeat.i(59558);
        if (!bo.isNullOrNil(str)) {
            this.field_custombuff = str;
        }
        AppMethodBeat.o(59558);
    }

    public final String Ak() {
        return this.field_custombuff;
    }

    public final void a(cm cmVar) {
        if (cmVar != null) {
            this.field_addMsg = cmVar;
        }
    }

    public final cm Al() {
        return this.field_addMsg;
    }

    public final void cG(String str) {
        if (str != null) {
            this.field_defaultContent = str;
        }
    }

    public final void a(mk mkVar) {
        this.field_businessInfo = mkVar;
    }

    public final void aI(long j) {
        this.field_delayTime = j;
    }

    public final long Am() {
        return this.field_delayTime;
    }

    public final long An() {
        return this.field_actionTime;
    }

    public final void aJ(long j) {
        this.field_actionTime = j;
    }

    public final void Ao() {
        this.field_status = -1;
    }

    public final int getStatus() {
        return this.field_status;
    }

    public final void be(boolean z) {
        this.field_needShow = z;
    }

    public final void Ap() {
        this.field_retryCount = 0;
    }

    public final void gf(int i) {
        this.field_retryCountLimit = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59560);
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.field_functionmsgid.equals(this.field_functionmsgid) && fVar.xDa == this.xDa) {
                AppMethodBeat.o(59560);
                return true;
            }
            AppMethodBeat.o(59560);
            return false;
        }
        AppMethodBeat.o(59560);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(59561);
        String str = "@null";
        if (!bo.isNullOrNil(this.field_cgi)) {
            String[] split = this.field_cgi.split("/");
            if (split.length > 0) {
                str = split[split.length - 1];
            }
        }
        str = "FunctionMsgItem{cgi='" + str + '\'' + ", cmdid=" + this.field_cmdid + ", functionmsgid='" + this.field_functionmsgid + '\'' + ", version=" + this.field_version + ", preVersion=" + this.field_preVersion + ", status=" + this.field_status + ", actionTime=" + this.field_actionTime + ", delayTime=" + this.field_delayTime + ", retryCount=" + this.field_retryCount + ", retryCount=" + this.field_opCode + '}';
        AppMethodBeat.o(59561);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.i(59559);
        int hashCode = this.field_functionmsgid.hashCode();
        AppMethodBeat.o(59559);
        return hashCode;
    }

    static {
        AppMethodBeat.i(59562);
        a aVar = new a();
        aVar.xDb = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cgi";
        aVar.xDd.put("cgi", "TEXT");
        stringBuilder.append(" cgi TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cmdid";
        aVar.xDd.put("cmdid", "INTEGER");
        stringBuilder.append(" cmdid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "functionmsgid";
        aVar.xDd.put("functionmsgid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "functionmsgid";
        aVar.columns[3] = "version";
        aVar.xDd.put("version", "LONG");
        stringBuilder.append(" version LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "preVersion";
        aVar.xDd.put("preVersion", "LONG");
        stringBuilder.append(" preVersion LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryinterval";
        aVar.xDd.put("retryinterval", "INTEGER");
        stringBuilder.append(" retryinterval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportid";
        aVar.xDd.put("reportid", "INTEGER");
        stringBuilder.append(" reportid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "successkey";
        aVar.xDd.put("successkey", "INTEGER");
        stringBuilder.append(" successkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "failkey";
        aVar.xDd.put("failkey", "INTEGER");
        stringBuilder.append(" failkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "finalfailkey";
        aVar.xDd.put("finalfailkey", "INTEGER");
        stringBuilder.append(" finalfailkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "custombuff";
        aVar.xDd.put("custombuff", "TEXT");
        stringBuilder.append(" custombuff TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "addMsg";
        aVar.xDd.put("addMsg", "BLOB");
        stringBuilder.append(" addMsg BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "status";
        aVar.xDd.put("status", "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "needShow";
        aVar.xDd.put("needShow", "INTEGER default 'false' ");
        stringBuilder.append(" needShow INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "defaultContent";
        aVar.xDd.put("defaultContent", "TEXT");
        stringBuilder.append(" defaultContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "actionTime";
        aVar.xDd.put("actionTime", "LONG default '-1' ");
        stringBuilder.append(" actionTime LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "delayTime";
        aVar.xDd.put("delayTime", "LONG default '-1' ");
        stringBuilder.append(" delayTime LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "retryCount";
        aVar.xDd.put("retryCount", "INTEGER default '0' ");
        stringBuilder.append(" retryCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "retryCountLimit";
        aVar.xDd.put("retryCountLimit", "INTEGER default '0' ");
        stringBuilder.append(" retryCountLimit INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "businessInfo";
        aVar.xDd.put("businessInfo", "BLOB");
        stringBuilder.append(" businessInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[20] = "opCode";
        aVar.xDd.put("opCode", "INTEGER default '-1' ");
        stringBuilder.append(" opCode INTEGER default '-1' ");
        aVar.columns[21] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(59562);
    }
}
