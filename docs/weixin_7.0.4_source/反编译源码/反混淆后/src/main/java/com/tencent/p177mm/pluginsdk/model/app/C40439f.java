package com.tencent.p177mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26315s;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.pluginsdk.model.app.f */
public class C40439f extends C26315s {
    protected static C4924a ccO;
    public static String vbQ = "wxce6f23b478a3a2a2";
    public static String vbR = "wx7302cee7c7d6d7d6";
    public static String vbS = "wx6fa7e3bab7e15415";
    public static String vbT = "wx3cc22b542de028d4";

    static {
        AppMethodBeat.m2504i(79254);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[26];
        c4924a.columns = new String[27];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appId";
        c4924a.columns[1] = "appName";
        c4924a.xDd.put("appName", "TEXT");
        stringBuilder.append(" appName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "appDiscription";
        c4924a.xDd.put("appDiscription", "TEXT");
        stringBuilder.append(" appDiscription TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "appIconUrl";
        c4924a.xDd.put("appIconUrl", "TEXT");
        stringBuilder.append(" appIconUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "appStoreUrl";
        c4924a.xDd.put("appStoreUrl", "TEXT");
        stringBuilder.append(" appStoreUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "appVersion";
        c4924a.xDd.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "appWatermarkUrl";
        c4924a.xDd.put("appWatermarkUrl", "TEXT");
        stringBuilder.append(" appWatermarkUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = DownloadInfoColumns.PACKAGENAME;
        c4924a.xDd.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "signature";
        c4924a.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "modifyTime";
        c4924a.xDd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "appName_en";
        c4924a.xDd.put("appName_en", "TEXT");
        stringBuilder.append(" appName_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "appName_tw";
        c4924a.xDd.put("appName_tw", "TEXT");
        stringBuilder.append(" appName_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "appName_hk";
        c4924a.xDd.put("appName_hk", "TEXT");
        stringBuilder.append(" appName_hk TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "appDiscription_en";
        c4924a.xDd.put("appDiscription_en", "TEXT");
        stringBuilder.append(" appDiscription_en TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "appDiscription_tw";
        c4924a.xDd.put("appDiscription_tw", "TEXT");
        stringBuilder.append(" appDiscription_tw TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "appType";
        c4924a.xDd.put("appType", "TEXT");
        stringBuilder.append(" appType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[17] = "openId";
        c4924a.xDd.put("openId", "TEXT");
        stringBuilder.append(" openId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[18] = "authFlag";
        c4924a.xDd.put("authFlag", "INTEGER");
        stringBuilder.append(" authFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[19] = "appInfoFlag";
        c4924a.xDd.put("appInfoFlag", "INTEGER default '-1' ");
        stringBuilder.append(" appInfoFlag INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[20] = "lvbuff";
        c4924a.xDd.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        c4924a.columns[21] = "serviceAppType";
        c4924a.xDd.put("serviceAppType", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[22] = "serviceAppInfoFlag";
        c4924a.xDd.put("serviceAppInfoFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[23] = "serviceShowFlag";
        c4924a.xDd.put("serviceShowFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceShowFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[24] = "appSupportContentType";
        c4924a.xDd.put("appSupportContentType", "LONG default '0' ");
        stringBuilder.append(" appSupportContentType LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[25] = "svrAppSupportContentType";
        c4924a.xDd.put("svrAppSupportContentType", "LONG default '0' ");
        stringBuilder.append(" svrAppSupportContentType LONG default '0' ");
        c4924a.columns[26] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(79254);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C40439f() {
        AppMethodBeat.m2504i(79248);
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
        mo44075ig("");
        mo44074if("");
        mo44076ih("");
        mo44080il("");
        mo44081im("");
        mo44082in("");
        AppMethodBeat.m2505o(79248);
    }

    /* renamed from: xy */
    public final boolean mo63847xy() {
        AppMethodBeat.m2504i(79249);
        if (C5046bo.isNullOrNil(this.field_appType)) {
            AppMethodBeat.m2505o(79249);
            return false;
        }
        String[] split = this.field_appType.split(",");
        if (split == null || split.length == 0) {
            AppMethodBeat.m2505o(79249);
            return false;
        }
        for (String equals : split) {
            if (equals.equals("1")) {
                AppMethodBeat.m2505o(79249);
                return true;
            }
        }
        AppMethodBeat.m2505o(79249);
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
        AppMethodBeat.m2504i(79250);
        if (vbR.equals(this.field_appId)) {
            AppMethodBeat.m2505o(79250);
            return true;
        }
        AppMethodBeat.m2505o(79250);
        return false;
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        AppMethodBeat.m2504i(79251);
        if (!C5046bo.isNullOrNil(this.field_appType) && (this.field_appType.startsWith("1") || this.field_appType.startsWith("6"))) {
            this.field_appType = "," + this.field_appType;
        }
        ContentValues Hl = super.mo10098Hl();
        AppMethodBeat.m2505o(79251);
        return Hl;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(79252);
        if (obj == null) {
            AppMethodBeat.m2505o(79252);
            return false;
        } else if (obj == this) {
            AppMethodBeat.m2505o(79252);
            return true;
        } else if (obj instanceof C40439f) {
            boolean equals = ((C40439f) obj).field_appId.equals(this.field_appId);
            AppMethodBeat.m2505o(79252);
            return equals;
        } else {
            AppMethodBeat.m2505o(79252);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(79253);
        int hashCode;
        if (C5046bo.isNullOrNil(this.field_appId)) {
            hashCode = super.hashCode();
            AppMethodBeat.m2505o(79253);
            return hashCode;
        }
        hashCode = this.field_appId.hashCode();
        AppMethodBeat.m2505o(79253);
        return hashCode;
    }
}
