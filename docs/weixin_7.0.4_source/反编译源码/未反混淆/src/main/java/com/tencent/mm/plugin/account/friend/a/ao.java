package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ao {
    int bJt = -1;
    String frQ = "";
    String frR = "";
    public int frS = 0;
    public int frT = 0;
    public long gwC = 0;
    public int gwD = 0;
    int gwE = 0;
    String gwF = "";
    String gwG = "";
    String gwH = "";
    String gwI = "";
    String gwJ = "";
    public String gwK = "";
    String gwL = "";
    String gwM = "";
    public String nickname = "";
    public String username = "";

    public ao() {
        AppMethodBeat.i(108498);
        AppMethodBeat.o(108498);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(108499);
        this.gwC = cursor.getLong(0);
        int i = cursor.getInt(1);
        if (i == 65536) {
            this.gwD = 0;
        } else {
            this.gwD = i;
        }
        this.gwE = cursor.getInt(2);
        this.username = cursor.getString(3);
        this.nickname = cursor.getString(4);
        this.gwF = cursor.getString(5);
        this.gwG = cursor.getString(6);
        this.gwH = cursor.getString(7);
        this.gwI = cursor.getString(8);
        this.gwJ = cursor.getString(9);
        this.gwK = cursor.getString(10);
        this.gwL = cursor.getString(11);
        this.gwM = cursor.getString(12);
        this.frQ = cursor.getString(13);
        this.frR = cursor.getString(14);
        this.frS = cursor.getInt(15);
        this.frT = cursor.getInt(16);
        AppMethodBeat.o(108499);
    }

    public final ContentValues aqn() {
        String str;
        String str2;
        AppMethodBeat.i(108500);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("qq", Long.valueOf(this.gwC));
        }
        if ((this.bJt & 2) != 0) {
            int i = this.gwD;
            if (i == 0) {
                contentValues.put("wexinstatus", Integer.valueOf(65536));
            } else {
                contentValues.put("wexinstatus", Integer.valueOf(i));
            }
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("groupid", Integer.valueOf(this.gwE));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("nickname", Hs());
        }
        if ((this.bJt & 32) != 0) {
            str = "pyinitial";
            if (this.gwF == null) {
                str2 = "";
            } else {
                str2 = this.gwF;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 64) != 0) {
            str = "quanpin";
            if (this.gwG == null) {
                str2 = "";
            } else {
                str2 = this.gwG;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("qqnickname", aqo());
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("qqpyinitial", aqp());
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("qqquanpin", aqq());
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("qqremark", aqr());
        }
        if ((this.bJt & 2048) != 0) {
            contentValues.put("qqremarkpyinitial", aqs());
        }
        if ((this.bJt & 4096) != 0) {
            contentValues.put("qqremarkquanpin", aqt());
        }
        if ((this.bJt & 16384) != 0) {
            str = "reserved2";
            if (this.frR == null) {
                str2 = "";
            } else {
                str2 = this.frR;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 32768) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.frS));
        }
        if ((this.bJt & 65536) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.frT));
        }
        AppMethodBeat.o(108500);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String Hs() {
        return this.nickname == null ? "" : this.nickname;
    }

    public final String aqo() {
        return this.gwH == null ? "" : this.gwH;
    }

    public final String aqp() {
        return this.gwI == null ? "" : this.gwI;
    }

    public final String aqq() {
        return this.gwJ == null ? "" : this.gwJ;
    }

    public final String aqr() {
        return this.gwK == null ? "" : this.gwK;
    }

    public final String aqs() {
        return this.gwL == null ? "" : this.gwL;
    }

    public final String aqt() {
        return this.gwM == null ? "" : this.gwM;
    }

    public final String getDisplayName() {
        AppMethodBeat.i(108501);
        String aqo;
        if (aqr() == null || aqr().length() <= 0) {
            aqo = aqo();
            AppMethodBeat.o(108501);
            return aqo;
        }
        aqo = aqr();
        AppMethodBeat.o(108501);
        return aqo;
    }

    public final void aqu() {
        this.frS |= 1;
    }

    public final String toString() {
        AppMethodBeat.i(108502);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("groupID\t:").append(this.gwE).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("qq\t:").append(this.gwC).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("username\t:").append(this.username).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("nickname\t:").append(this.nickname).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("wexinStatus\t:").append(this.gwD).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("reserved3\t:").append(this.frS).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("reserved4\t:").append(this.frT).append(IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(108502);
        return stringBuilder2;
    }
}
