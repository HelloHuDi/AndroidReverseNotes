package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.s;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public class f extends s {
    protected static a ccO;
    public static String vbQ = "wxce6f23b478a3a2a2";
    public static String vbR = "wx7302cee7c7d6d7d6";
    public static String vbS = "wx6fa7e3bab7e15415";
    public static String vbT = "wx3cc22b542de028d4";

    static {
        AppMethodBeat.i(79254);
        a aVar = new a();
        aVar.xDb = new Field[26];
        aVar.columns = new String[27];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appId";
        aVar.columns[1] = "appName";
        aVar.xDd.put("appName", "TEXT");
        stringBuilder.append(" appName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appDiscription";
        aVar.xDd.put("appDiscription", "TEXT");
        stringBuilder.append(" appDiscription TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "appIconUrl";
        aVar.xDd.put("appIconUrl", "TEXT");
        stringBuilder.append(" appIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "appStoreUrl";
        aVar.xDd.put("appStoreUrl", "TEXT");
        stringBuilder.append(" appStoreUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "appVersion";
        aVar.xDd.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "appWatermarkUrl";
        aVar.xDd.put("appWatermarkUrl", "TEXT");
        stringBuilder.append(" appWatermarkUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfoColumns.PACKAGENAME;
        aVar.xDd.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "signature";
        aVar.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "modifyTime";
        aVar.xDd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "appName_en";
        aVar.xDd.put("appName_en", "TEXT");
        stringBuilder.append(" appName_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "appName_tw";
        aVar.xDd.put("appName_tw", "TEXT");
        stringBuilder.append(" appName_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "appName_hk";
        aVar.xDd.put("appName_hk", "TEXT");
        stringBuilder.append(" appName_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "appDiscription_en";
        aVar.xDd.put("appDiscription_en", "TEXT");
        stringBuilder.append(" appDiscription_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "appDiscription_tw";
        aVar.xDd.put("appDiscription_tw", "TEXT");
        stringBuilder.append(" appDiscription_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "appType";
        aVar.xDd.put("appType", "TEXT");
        stringBuilder.append(" appType TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "openId";
        aVar.xDd.put("openId", "TEXT");
        stringBuilder.append(" openId TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "authFlag";
        aVar.xDd.put("authFlag", "INTEGER");
        stringBuilder.append(" authFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "appInfoFlag";
        aVar.xDd.put("appInfoFlag", "INTEGER default '-1' ");
        stringBuilder.append(" appInfoFlag INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "lvbuff";
        aVar.xDd.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.columns[21] = "serviceAppType";
        aVar.xDd.put("serviceAppType", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[22] = "serviceAppInfoFlag";
        aVar.xDd.put("serviceAppInfoFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[23] = "serviceShowFlag";
        aVar.xDd.put("serviceShowFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceShowFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[24] = "appSupportContentType";
        aVar.xDd.put("appSupportContentType", "LONG default '0' ");
        stringBuilder.append(" appSupportContentType LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "svrAppSupportContentType";
        aVar.xDd.put("svrAppSupportContentType", "LONG default '0' ");
        stringBuilder.append(" svrAppSupportContentType LONG default '0' ");
        aVar.columns[26] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(79254);
    }

    public final a Ag() {
        return ccO;
    }

    public f() {
        AppMethodBeat.i(79248);
        this.field_appId = "";
        this.field_appName = "";
        this.field_appDiscription = "";
        this.field_appIconUrl = "";
        this.field_appStoreUrl = "";
        this.field_appVersion = 0;
        this.field_appWatermarkUrl = "";
        this.field_packageName = "";
        this.field_status = 4;
        this.field_signature = "";
        this.field_modifyTime = 0;
        this.field_appName_en = "";
        this.field_appName_tw = "";
        this.field_appName_hk = "";
        this.field_appDiscription_en = "";
        this.field_appDiscription_tw = "";
        this.field_appInfoFlag = 0;
        this.field_appType = "";
        this.field_openId = "";
        this.field_authFlag = 0;
        this.field_appInfoFlag = 0;
        ig("");
        m12if("");
        ih("");
        il("");
        im("");
        in("");
        AppMethodBeat.o(79248);
    }

    public final boolean xy() {
        AppMethodBeat.i(79249);
        if (bo.isNullOrNil(this.field_appType)) {
            AppMethodBeat.o(79249);
            return false;
        }
        String[] split = this.field_appType.split(",");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(79249);
            return false;
        }
        for (String equals : split) {
            if (equals.equals("1")) {
                AppMethodBeat.o(79249);
                return true;
            }
        }
        AppMethodBeat.o(79249);
        return false;
    }

    public final boolean dhx() {
        if (this.field_serviceAppType == 0) {
            return false;
        }
        return true;
    }

    public final boolean dhy() {
        if ((this.field_serviceAppInfoFlag & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean dhz() {
        if ((this.field_serviceAppInfoFlag & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean dhA() {
        AppMethodBeat.i(79250);
        if (vbR.equals(this.field_appId)) {
            AppMethodBeat.o(79250);
            return true;
        }
        AppMethodBeat.o(79250);
        return false;
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(79251);
        if (!bo.isNullOrNil(this.field_appType) && (this.field_appType.startsWith("1") || this.field_appType.startsWith("6"))) {
            this.field_appType = "," + this.field_appType;
        }
        ContentValues Hl = super.Hl();
        AppMethodBeat.o(79251);
        return Hl;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(79252);
        if (obj == null) {
            AppMethodBeat.o(79252);
            return false;
        } else if (obj == this) {
            AppMethodBeat.o(79252);
            return true;
        } else if (obj instanceof f) {
            boolean equals = ((f) obj).field_appId.equals(this.field_appId);
            AppMethodBeat.o(79252);
            return equals;
        } else {
            AppMethodBeat.o(79252);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(79253);
        int hashCode;
        if (bo.isNullOrNil(this.field_appId)) {
            hashCode = super.hashCode();
            AppMethodBeat.o(79253);
            return hashCode;
        }
        hashCode = this.field_appId.hashCode();
        AppMethodBeat.o(79253);
        return hashCode;
    }
}
