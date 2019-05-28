package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class ct extends c {
    private static final int dIA = "pkgType".hashCode();
    private static final int dIB = "widgetType".hashCode();
    private static final int dIC = "jsApiInfo".hashCode();
    private static final int dID = "versionInfo".hashCode();
    private static final int dIE = "widgetSetting".hashCode();
    private static final int dIp = "appIdHash".hashCode();
    private static final int dIq = "launchAction".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private boolean dIj = true;
    private boolean dIk = true;
    private boolean dIv = true;
    private boolean dIw = true;
    private boolean dIx = true;
    private boolean dIy = true;
    private boolean dIz = true;
    private boolean dkE = true;
    public String field_appId;
    public int field_appIdHash;
    public rg field_jsApiInfo;
    public cvx field_launchAction;
    public int field_pkgType;
    public cvy field_versionInfo;
    public cyd field_widgetSetting;
    public int field_widgetType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (dIp == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dIA == hashCode) {
                    this.field_pkgType = cursor.getInt(i);
                } else if (dIB == hashCode) {
                    this.field_widgetType = cursor.getInt(i);
                } else if (dIq == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_launchAction = (cvx) new cvx().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
                    }
                } else if (dIC == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_jsApiInfo = (rg) new rg().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
                    }
                } else if (dID == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_versionInfo = (cvy) new cvy().parseFrom(blob);
                        }
                    } catch (IOException e22) {
                        ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
                    }
                } else if (dIE == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_widgetSetting = (cyd) new cyd().parseFrom(blob);
                        }
                    } catch (IOException e222) {
                        ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
                    }
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dIj) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dIv) {
            contentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
        }
        if (this.dIw) {
            contentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
        }
        if (this.dIk && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
            }
        }
        if (this.dIx && this.field_jsApiInfo != null) {
            try {
                contentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
            } catch (IOException e2) {
                ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
            }
        }
        if (this.dIy && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e22) {
                ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
            }
        }
        if (this.dIz && this.field_widgetSetting != null) {
            try {
                contentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
            } catch (IOException e222) {
                ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
            }
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
