package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.protocal.protobuf.C15321ay;
import com.tencent.p177mm.protocal.protobuf.C15381rg;
import com.tencent.p177mm.protocal.protobuf.axn;
import com.tencent.p177mm.protocal.protobuf.bhm;
import com.tencent.p177mm.protocal.protobuf.cwn;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.g.c.cs */
public abstract class C9526cs extends C4925c {
    private static final int dIp = "appIdHash".hashCode();
    private static final int dIq = "launchAction".hashCode();
    private static final int dIr = "jsapiInfo".hashCode();
    private static final int dIs = "hostInfo".hashCode();
    private static final int dIt = "actionsheetInfo".hashCode();
    private static final int dIu = "operationInfo".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private boolean dIj = true;
    private boolean dIk = true;
    private boolean dIl = true;
    private boolean dIm = true;
    private boolean dIn = true;
    private boolean dIo = true;
    private boolean dkE = true;
    public C15321ay field_actionsheetInfo;
    public String field_appId;
    public int field_appIdHash;
    public cwn field_hostInfo;
    public C15381rg field_jsapiInfo;
    public axn field_launchAction;
    public bhm field_operationInfo;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (dIp == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.dIj = true;
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dIq == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_launchAction = (axn) new axn().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
                    }
                } else if (dIr == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_jsapiInfo = (C15381rg) new C15381rg().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
                    }
                } else if (dIs == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_hostInfo = (cwn) new cwn().parseFrom(blob);
                        }
                    } catch (IOException e22) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
                    }
                } else if (dIt == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_actionsheetInfo = (C15321ay) new C15321ay().parseFrom(blob);
                        }
                    } catch (IOException e222) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
                    }
                } else if (dIu == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_operationInfo = (bhm) new bhm().parseFrom(blob);
                        }
                    } catch (IOException e2222) {
                        C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2222.getMessage());
                    }
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dIj) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dIk && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
            }
        }
        if (this.dIl && this.field_jsapiInfo != null) {
            try {
                contentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
            } catch (IOException e2) {
                C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
            }
        }
        if (this.dIm && this.field_hostInfo != null) {
            try {
                contentValues.put("hostInfo", this.field_hostInfo.toByteArray());
            } catch (IOException e22) {
                C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
            }
        }
        if (this.dIn && this.field_actionsheetInfo != null) {
            try {
                contentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            } catch (IOException e222) {
                C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
            }
        }
        if (this.dIo && this.field_operationInfo != null) {
            try {
                contentValues.put("operationInfo", this.field_operationInfo.toByteArray());
            } catch (IOException e2222) {
                C4990ab.m7412e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2222.getMessage());
            }
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
