package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class u extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT, checksum INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )"};
    public h fni;
    Map<String, a> gav = new HashMap();
    Map<String, l> gaw = new HashMap();
    Map<String, h> gax = new HashMap();

    public u(h hVar) {
        AppMethodBeat.i(116663);
        b(hVar);
        this.fni = hVar;
        AppMethodBeat.o(116663);
    }

    private static void b(h hVar) {
        AppMethodBeat.i(116664);
        Cursor a = hVar.a("PRAGMA table_info(voiceinfo)", null, 0);
        if (a == null) {
            ab.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
            AppMethodBeat.o(116664);
            return;
        }
        int columnIndex = a.getColumnIndex("name");
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                int i6;
                String string = a.getString(columnIndex);
                if ("MsgSource".equals(string)) {
                    i5 = 1;
                }
                if ("MsgFlag".equals(string)) {
                    i4 = 1;
                }
                if ("MsgSeq".equals(string)) {
                    i3 = 1;
                }
                if ("MasterBufId".equals(string)) {
                    i6 = 1;
                } else {
                    i6 = i2;
                }
                if ("checksum".equals(string)) {
                    i = 1;
                }
                i2 = i6;
            }
        }
        a.close();
        if (i5 == 0) {
            hVar.hY("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
        }
        if (i4 == 0) {
            hVar.hY("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
        }
        if (i3 == 0) {
            hVar.hY("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
        }
        if (i2 == 0) {
            hVar.hY("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
        }
        if (i == 0) {
            hVar.hY("voiceinfo", "Alter table voiceinfo add checksum INT DEFAULT 0");
        }
        AppMethodBeat.o(116664);
    }

    public static String uY(String str) {
        AppMethodBeat.i(116665);
        String m = p.m(str, bo.anU());
        AppMethodBeat.o(116665);
        return m;
    }

    public final boolean b(p pVar) {
        AppMethodBeat.i(116666);
        Assert.assertTrue(pVar != null);
        ContentValues Hl = pVar.Hl();
        if (Hl.size() <= 0) {
            ab.e("MicroMsg.VoiceStorage", "insert falied, no values set");
        } else if (this.fni.insert("voiceinfo", "FileName", Hl) != -1) {
            doNotify();
            AppMethodBeat.o(116666);
            return true;
        }
        AppMethodBeat.o(116666);
        return false;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(116667);
        Assert.assertTrue(str.length() > 0);
        if (this.fni.delete("voiceinfo", "FileName= ?", new String[]{str}) <= 0) {
            ab.w("MicroMsg.VoiceStorage", "delete failed, no such file:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(116667);
        return true;
    }

    public final boolean a(String str, p pVar) {
        boolean z;
        AppMethodBeat.i(116668);
        Assert.assertTrue(str.length() > 0);
        if (pVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues Hl = pVar.Hl();
        if (Hl.size() <= 0) {
            ab.e("MicroMsg.VoiceStorage", "update failed, no values set");
        } else {
            if (this.fni.update("voiceinfo", Hl, "FileName= ?", new String[]{str}) > 0) {
                doNotify();
                AppMethodBeat.o(116668);
                return true;
            }
        }
        AppMethodBeat.o(116668);
        return false;
    }

    public final p fZ(long j) {
        p pVar = null;
        AppMethodBeat.i(116669);
        Cursor a = this.fni.a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgId=" + j, null, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.d(a);
        }
        a.close();
        AppMethodBeat.o(116669);
        return pVar;
    }

    public final p mv(int i) {
        p pVar = null;
        AppMethodBeat.i(116670);
        Cursor a = this.fni.a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgLocalId=" + i, null, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.d(a);
        }
        a.close();
        AppMethodBeat.o(116670);
        return pVar;
    }

    public final p uZ(String str) {
        AppMethodBeat.i(116671);
        p pVar = null;
        String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
        Cursor a = this.fni.a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.d(a);
        }
        a.close();
        AppMethodBeat.o(116671);
        return pVar;
    }
}
