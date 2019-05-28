package com.tencent.p177mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1851p;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvoice.u */
public final class C18719u extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT, checksum INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )"};
    public C7480h fni;
    Map<String, C31277a> gav = new HashMap();
    Map<String, C1884l> gaw = new HashMap();
    Map<String, C45462h> gax = new HashMap();

    public C18719u(C7480h c7480h) {
        AppMethodBeat.m2504i(116663);
        C18719u.m29274b(c7480h);
        this.fni = c7480h;
        AppMethodBeat.m2505o(116663);
    }

    /* renamed from: b */
    private static void m29274b(C7480h c7480h) {
        AppMethodBeat.m2504i(116664);
        Cursor a = c7480h.mo10104a("PRAGMA table_info(voiceinfo)", null, 0);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
            AppMethodBeat.m2505o(116664);
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
            c7480h.mo10108hY("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
        }
        if (i4 == 0) {
            c7480h.mo10108hY("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
        }
        if (i3 == 0) {
            c7480h.mo10108hY("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
        }
        if (i2 == 0) {
            c7480h.mo10108hY("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
        }
        if (i == 0) {
            c7480h.mo10108hY("voiceinfo", "Alter table voiceinfo add checksum INT DEFAULT 0");
        }
        AppMethodBeat.m2505o(116664);
    }

    /* renamed from: uY */
    public static String m29275uY(String str) {
        AppMethodBeat.m2504i(116665);
        String m = C1851p.m3818m(str, C5046bo.anU());
        AppMethodBeat.m2505o(116665);
        return m;
    }

    /* renamed from: b */
    public final boolean mo33983b(C32849p c32849p) {
        AppMethodBeat.m2504i(116666);
        Assert.assertTrue(c32849p != null);
        ContentValues Hl = c32849p.mo53417Hl();
        if (Hl.size() <= 0) {
            C4990ab.m7412e("MicroMsg.VoiceStorage", "insert falied, no values set");
        } else if (this.fni.insert("voiceinfo", "FileName", Hl) != -1) {
            doNotify();
            AppMethodBeat.m2505o(116666);
            return true;
        }
        AppMethodBeat.m2505o(116666);
        return false;
    }

    /* renamed from: pI */
    public final boolean mo33986pI(String str) {
        AppMethodBeat.m2504i(116667);
        Assert.assertTrue(str.length() > 0);
        if (this.fni.delete("voiceinfo", "FileName= ?", new String[]{str}) <= 0) {
            C4990ab.m7420w("MicroMsg.VoiceStorage", "delete failed, no such file:".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(116667);
        return true;
    }

    /* renamed from: a */
    public final boolean mo33982a(String str, C32849p c32849p) {
        boolean z;
        AppMethodBeat.m2504i(116668);
        Assert.assertTrue(str.length() > 0);
        if (c32849p != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues Hl = c32849p.mo53417Hl();
        if (Hl.size() <= 0) {
            C4990ab.m7412e("MicroMsg.VoiceStorage", "update failed, no values set");
        } else {
            if (this.fni.update("voiceinfo", Hl, "FileName= ?", new String[]{str}) > 0) {
                doNotify();
                AppMethodBeat.m2505o(116668);
                return true;
            }
        }
        AppMethodBeat.m2505o(116668);
        return false;
    }

    /* renamed from: fZ */
    public final C32849p mo33984fZ(long j) {
        C32849p c32849p = null;
        AppMethodBeat.m2504i(116669);
        Cursor a = this.fni.mo10104a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgId=" + j, null, 2);
        if (a.moveToFirst()) {
            c32849p = new C32849p();
            c32849p.mo53420d(a);
        }
        a.close();
        AppMethodBeat.m2505o(116669);
        return c32849p;
    }

    /* renamed from: mv */
    public final C32849p mo33985mv(int i) {
        C32849p c32849p = null;
        AppMethodBeat.m2504i(116670);
        Cursor a = this.fni.mo10104a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgLocalId=" + i, null, 2);
        if (a.moveToFirst()) {
            c32849p = new C32849p();
            c32849p.mo53420d(a);
        }
        a.close();
        AppMethodBeat.m2505o(116670);
        return c32849p;
    }

    /* renamed from: uZ */
    public final C32849p mo33987uZ(String str) {
        AppMethodBeat.m2504i(116671);
        C32849p c32849p = null;
        String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
        Cursor a = this.fni.mo10104a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            c32849p = new C32849p();
            c32849p.mo53420d(a);
        }
        a.close();
        AppMethodBeat.m2505o(116671);
        return c32849p;
    }
}
