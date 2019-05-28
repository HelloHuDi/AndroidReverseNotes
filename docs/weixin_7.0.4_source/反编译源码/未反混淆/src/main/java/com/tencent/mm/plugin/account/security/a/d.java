package com.tencent.mm.plugin.account.security.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dz;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends dz {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public d() {
        this.field_uid = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public d(aza aza) {
        AppMethodBeat.i(69834);
        this.field_uid = aza.eCq;
        this.field_devicetype = aza.devicetype;
        this.field_name = aza.devicename;
        this.field_createtime = (long) aza.wCN;
        AppMethodBeat.o(69834);
    }

    static {
        AppMethodBeat.i(69835);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "uid";
        aVar.xDd.put("uid", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "uid";
        aVar.columns[1] = "name";
        aVar.xDd.put("name", "TEXT default '' ");
        stringBuilder.append(" name TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "devicetype";
        aVar.xDd.put("devicetype", "TEXT default '' ");
        stringBuilder.append(" devicetype TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createtime";
        aVar.xDd.put("createtime", "LONG default '0' ");
        stringBuilder.append(" createtime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(69835);
    }
}
