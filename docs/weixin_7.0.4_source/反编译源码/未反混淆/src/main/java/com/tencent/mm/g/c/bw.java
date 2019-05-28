package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class bw extends c {
    private static final int dCM = "cgi".hashCode();
    private static final int dCN = "cmdid".hashCode();
    private static final int dCO = "functionmsgid".hashCode();
    private static final int dCP = "preVersion".hashCode();
    private static final int dCQ = "retryinterval".hashCode();
    private static final int dCR = "reportid".hashCode();
    private static final int dCS = "successkey".hashCode();
    private static final int dCT = "failkey".hashCode();
    private static final int dCU = "finalfailkey".hashCode();
    private static final int dCV = "custombuff".hashCode();
    private static final int dCW = "addMsg".hashCode();
    private static final int dCX = "needShow".hashCode();
    private static final int dCY = "defaultContent".hashCode();
    private static final int dCZ = "actionTime".hashCode();
    private static final int dDa = "delayTime".hashCode();
    private static final int dDb = "retryCount".hashCode();
    private static final int dDc = "retryCountLimit".hashCode();
    private static final int dDd = "businessInfo".hashCode();
    private static final int dDe = "opCode".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dlS = "version".hashCode();
    private boolean dCA = true;
    private boolean dCB = true;
    private boolean dCC = true;
    private boolean dCD = true;
    private boolean dCE = true;
    private boolean dCF = true;
    private boolean dCG = true;
    private boolean dCH = true;
    private boolean dCI = true;
    private boolean dCJ = true;
    private boolean dCK = true;
    private boolean dCL = true;
    private boolean dCt = true;
    private boolean dCu = true;
    private boolean dCv = true;
    private boolean dCw = true;
    private boolean dCx = true;
    private boolean dCy = true;
    private boolean dCz = true;
    private boolean diU = true;
    private boolean dlM = true;
    public long field_actionTime;
    public cm field_addMsg;
    public mk field_businessInfo;
    public String field_cgi;
    public int field_cmdid;
    public String field_custombuff;
    public String field_defaultContent;
    public long field_delayTime;
    public int field_failkey;
    public int field_finalfailkey;
    public String field_functionmsgid;
    public boolean field_needShow;
    public int field_opCode;
    public long field_preVersion;
    public int field_reportid;
    public int field_retryCount;
    public int field_retryCountLimit;
    public int field_retryinterval;
    public int field_status;
    public int field_successkey;
    public long field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (dCM == hashCode) {
                    this.field_cgi = cursor.getString(i);
                } else if (dCN == hashCode) {
                    this.field_cmdid = cursor.getInt(i);
                } else if (dCO == hashCode) {
                    this.field_functionmsgid = cursor.getString(i);
                    this.dCv = true;
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getLong(i);
                } else if (dCP == hashCode) {
                    this.field_preVersion = cursor.getLong(i);
                } else if (dCQ == hashCode) {
                    this.field_retryinterval = cursor.getInt(i);
                } else if (dCR == hashCode) {
                    this.field_reportid = cursor.getInt(i);
                } else if (dCS == hashCode) {
                    this.field_successkey = cursor.getInt(i);
                } else if (dCT == hashCode) {
                    this.field_failkey = cursor.getInt(i);
                } else if (dCU == hashCode) {
                    this.field_finalfailkey = cursor.getInt(i);
                } else if (dCV == hashCode) {
                    this.field_custombuff = cursor.getString(i);
                } else if (dCW == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_addMsg = (cm) new cm().parseFrom(blob);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
                    }
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dCX == hashCode) {
                    this.field_needShow = cursor.getInt(i) != 0;
                } else if (dCY == hashCode) {
                    this.field_defaultContent = cursor.getString(i);
                } else if (dCZ == hashCode) {
                    this.field_actionTime = cursor.getLong(i);
                } else if (dDa == hashCode) {
                    this.field_delayTime = cursor.getLong(i);
                } else if (dDb == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (dDc == hashCode) {
                    this.field_retryCountLimit = cursor.getInt(i);
                } else if (dDd == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_businessInfo = (mk) new mk().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        ab.e("MicroMsg.SDK.BaseFunctionMsgItem", e2.getMessage());
                    }
                } else if (dDe == hashCode) {
                    this.field_opCode = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dCt) {
            contentValues.put("cgi", this.field_cgi);
        }
        if (this.dCu) {
            contentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
        }
        if (this.dCv) {
            contentValues.put("functionmsgid", this.field_functionmsgid);
        }
        if (this.dlM) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.dCw) {
            contentValues.put("preVersion", Long.valueOf(this.field_preVersion));
        }
        if (this.dCx) {
            contentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
        }
        if (this.dCy) {
            contentValues.put("reportid", Integer.valueOf(this.field_reportid));
        }
        if (this.dCz) {
            contentValues.put("successkey", Integer.valueOf(this.field_successkey));
        }
        if (this.dCA) {
            contentValues.put("failkey", Integer.valueOf(this.field_failkey));
        }
        if (this.dCB) {
            contentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
        }
        if (this.dCC) {
            contentValues.put("custombuff", this.field_custombuff);
        }
        if (this.dCD && this.field_addMsg != null) {
            try {
                contentValues.put("addMsg", this.field_addMsg.toByteArray());
            } catch (IOException e) {
                ab.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
            }
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dCE) {
            contentValues.put("needShow", Boolean.valueOf(this.field_needShow));
        }
        if (this.dCF) {
            contentValues.put("defaultContent", this.field_defaultContent);
        }
        if (this.dCG) {
            contentValues.put("actionTime", Long.valueOf(this.field_actionTime));
        }
        if (this.dCH) {
            contentValues.put("delayTime", Long.valueOf(this.field_delayTime));
        }
        if (this.dCI) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.dCJ) {
            contentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
        }
        if (this.dCK && this.field_businessInfo != null) {
            try {
                contentValues.put("businessInfo", this.field_businessInfo.toByteArray());
            } catch (IOException e2) {
                ab.e("MicroMsg.SDK.BaseFunctionMsgItem", e2.getMessage());
            }
        }
        if (this.dCL) {
            contentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
