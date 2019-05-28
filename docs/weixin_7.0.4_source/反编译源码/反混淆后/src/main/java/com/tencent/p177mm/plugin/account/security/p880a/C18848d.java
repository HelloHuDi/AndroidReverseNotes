package com.tencent.p177mm.plugin.account.security.p880a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32690dz;
import com.tencent.p177mm.protocal.protobuf.aza;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.account.security.a.d */
public final class C18848d extends C32690dz {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C18848d() {
        this.field_uid = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public C18848d(aza aza) {
        AppMethodBeat.m2504i(69834);
        this.field_uid = aza.eCq;
        this.field_devicetype = aza.devicetype;
        this.field_name = aza.devicename;
        this.field_createtime = (long) aza.wCN;
        AppMethodBeat.m2505o(69834);
    }

    static {
        AppMethodBeat.m2504i(69835);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "uid";
        c4924a.xDd.put("uid", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "uid";
        c4924a.columns[1] = "name";
        c4924a.xDd.put("name", "TEXT default '' ");
        stringBuilder.append(" name TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "devicetype";
        c4924a.xDd.put("devicetype", "TEXT default '' ");
        stringBuilder.append(" devicetype TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "createtime";
        c4924a.xDd.put("createtime", "LONG default '0' ");
        stringBuilder.append(" createtime LONG default '0' ");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(69835);
    }
}
