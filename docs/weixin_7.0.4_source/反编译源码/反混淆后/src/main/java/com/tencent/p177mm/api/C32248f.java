package com.tencent.p177mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26301bw;
import com.tencent.p177mm.protocal.protobuf.C40545mk;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.api.f */
public final class C32248f extends C26301bw {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: cD */
    public final void mo52949cD(String str) {
        AppMethodBeat.m2504i(59556);
        if (!C5046bo.isNullOrNil(str)) {
            this.field_cgi = str;
        }
        AppMethodBeat.m2505o(59556);
    }

    public final void setCmdId(int i) {
        this.field_cmdid = i;
    }

    /* renamed from: ga */
    public final void mo52954ga(int i) {
        this.field_opCode = i;
    }

    /* renamed from: Ah */
    public final int mo52933Ah() {
        return this.field_opCode;
    }

    /* renamed from: cE */
    public final void mo52950cE(String str) {
        AppMethodBeat.m2504i(59557);
        if (!C5046bo.isNullOrNil(str)) {
            this.field_functionmsgid = str;
        }
        AppMethodBeat.m2505o(59557);
    }

    /* renamed from: Ai */
    public final String mo52934Ai() {
        return this.field_functionmsgid;
    }

    /* renamed from: aG */
    public final void mo52944aG(long j) {
        this.field_version = j;
    }

    public final long getVersion() {
        return this.field_version;
    }

    /* renamed from: aH */
    public final void mo52945aH(long j) {
        this.field_preVersion = j;
    }

    /* renamed from: Aj */
    public final long mo52935Aj() {
        return this.field_preVersion;
    }

    public final void setRetryInterval(int i) {
        this.field_retryinterval = i;
    }

    /* renamed from: gb */
    public final void mo52955gb(int i) {
        this.field_reportid = i;
    }

    /* renamed from: gc */
    public final void mo52956gc(int i) {
        this.field_successkey = i;
    }

    /* renamed from: gd */
    public final void mo52957gd(int i) {
        this.field_failkey = i;
    }

    /* renamed from: ge */
    public final void mo52958ge(int i) {
        this.field_finalfailkey = i;
    }

    /* renamed from: cF */
    public final void mo52951cF(String str) {
        AppMethodBeat.m2504i(59558);
        if (!C5046bo.isNullOrNil(str)) {
            this.field_custombuff = str;
        }
        AppMethodBeat.m2505o(59558);
    }

    /* renamed from: Ak */
    public final String mo52936Ak() {
        return this.field_custombuff;
    }

    /* renamed from: a */
    public final void mo52942a(C7254cm c7254cm) {
        if (c7254cm != null) {
            this.field_addMsg = c7254cm;
        }
    }

    /* renamed from: Al */
    public final C7254cm mo52937Al() {
        return this.field_addMsg;
    }

    /* renamed from: cG */
    public final void mo52952cG(String str) {
        if (str != null) {
            this.field_defaultContent = str;
        }
    }

    /* renamed from: a */
    public final void mo52943a(C40545mk c40545mk) {
        this.field_businessInfo = c40545mk;
    }

    /* renamed from: aI */
    public final void mo52946aI(long j) {
        this.field_delayTime = j;
    }

    /* renamed from: Am */
    public final long mo52938Am() {
        return this.field_delayTime;
    }

    /* renamed from: An */
    public final long mo52939An() {
        return this.field_actionTime;
    }

    /* renamed from: aJ */
    public final void mo52947aJ(long j) {
        this.field_actionTime = j;
    }

    /* renamed from: Ao */
    public final void mo52940Ao() {
        this.field_status = -1;
    }

    public final int getStatus() {
        return this.field_status;
    }

    /* renamed from: be */
    public final void mo52948be(boolean z) {
        this.field_needShow = z;
    }

    /* renamed from: Ap */
    public final void mo52941Ap() {
        this.field_retryCount = 0;
    }

    /* renamed from: gf */
    public final void mo52961gf(int i) {
        this.field_retryCountLimit = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(59560);
        if (obj instanceof C32248f) {
            C32248f c32248f = (C32248f) obj;
            if (c32248f.field_functionmsgid.equals(this.field_functionmsgid) && c32248f.xDa == this.xDa) {
                AppMethodBeat.m2505o(59560);
                return true;
            }
            AppMethodBeat.m2505o(59560);
            return false;
        }
        AppMethodBeat.m2505o(59560);
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(59561);
        String str = "@null";
        if (!C5046bo.isNullOrNil(this.field_cgi)) {
            String[] split = this.field_cgi.split("/");
            if (split.length > 0) {
                str = split[split.length - 1];
            }
        }
        str = "FunctionMsgItem{cgi='" + str + '\'' + ", cmdid=" + this.field_cmdid + ", functionmsgid='" + this.field_functionmsgid + '\'' + ", version=" + this.field_version + ", preVersion=" + this.field_preVersion + ", status=" + this.field_status + ", actionTime=" + this.field_actionTime + ", delayTime=" + this.field_delayTime + ", retryCount=" + this.field_retryCount + ", retryCount=" + this.field_opCode + '}';
        AppMethodBeat.m2505o(59561);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(59559);
        int hashCode = this.field_functionmsgid.hashCode();
        AppMethodBeat.m2505o(59559);
        return hashCode;
    }

    static {
        AppMethodBeat.m2504i(59562);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[21];
        c4924a.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "cgi";
        c4924a.xDd.put("cgi", "TEXT");
        stringBuilder.append(" cgi TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "cmdid";
        c4924a.xDd.put("cmdid", "INTEGER");
        stringBuilder.append(" cmdid INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "functionmsgid";
        c4924a.xDd.put("functionmsgid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "functionmsgid";
        c4924a.columns[3] = "version";
        c4924a.xDd.put("version", "LONG");
        stringBuilder.append(" version LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "preVersion";
        c4924a.xDd.put("preVersion", "LONG");
        stringBuilder.append(" preVersion LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "retryinterval";
        c4924a.xDd.put("retryinterval", "INTEGER");
        stringBuilder.append(" retryinterval INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "reportid";
        c4924a.xDd.put("reportid", "INTEGER");
        stringBuilder.append(" reportid INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "successkey";
        c4924a.xDd.put("successkey", "INTEGER");
        stringBuilder.append(" successkey INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "failkey";
        c4924a.xDd.put("failkey", "INTEGER");
        stringBuilder.append(" failkey INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "finalfailkey";
        c4924a.xDd.put("finalfailkey", "INTEGER");
        stringBuilder.append(" finalfailkey INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "custombuff";
        c4924a.xDd.put("custombuff", "TEXT");
        stringBuilder.append(" custombuff TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "addMsg";
        c4924a.xDd.put("addMsg", "BLOB");
        stringBuilder.append(" addMsg BLOB");
        stringBuilder.append(", ");
        c4924a.columns[12] = "status";
        c4924a.xDd.put("status", "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "needShow";
        c4924a.xDd.put("needShow", "INTEGER default 'false' ");
        stringBuilder.append(" needShow INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "defaultContent";
        c4924a.xDd.put("defaultContent", "TEXT");
        stringBuilder.append(" defaultContent TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "actionTime";
        c4924a.xDd.put("actionTime", "LONG default '-1' ");
        stringBuilder.append(" actionTime LONG default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "delayTime";
        c4924a.xDd.put("delayTime", "LONG default '-1' ");
        stringBuilder.append(" delayTime LONG default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[17] = "retryCount";
        c4924a.xDd.put("retryCount", "INTEGER default '0' ");
        stringBuilder.append(" retryCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "retryCountLimit";
        c4924a.xDd.put("retryCountLimit", "INTEGER default '0' ");
        stringBuilder.append(" retryCountLimit INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[19] = "businessInfo";
        c4924a.xDd.put("businessInfo", "BLOB");
        stringBuilder.append(" businessInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[20] = "opCode";
        c4924a.xDd.put("opCode", "INTEGER default '-1' ");
        stringBuilder.append(" opCode INTEGER default '-1' ");
        c4924a.columns[21] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(59562);
    }
}
