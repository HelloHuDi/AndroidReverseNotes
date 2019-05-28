package com.tencent.p177mm.plugin.subapp.p1039c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p711c.C32694ez;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.c.k */
public final class C43667k extends C7563j<C29385g> {
    private static long fXo = 0;
    public static final String[] fnj = new String[]{C7563j.m13217a(C29385g.ccO, "VoiceRemindInfo")};
    C4927e bSd;
    private Map<String, C35265c> stq = new HashMap();

    static {
        AppMethodBeat.m2504i(25323);
        AppMethodBeat.m2505o(25323);
    }

    public C43667k(C4927e c4927e) {
        super(c4927e, C29385g.ccO, "VoiceRemindInfo", C32694ez.diI);
        AppMethodBeat.m2504i(25316);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(25316);
    }

    /* renamed from: ug */
    public static String m78198ug(String str) {
        AppMethodBeat.m2504i(25317);
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + C1178g.m2591x(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = fXo;
        fXo = 1 + currentTimeMillis;
        format = append.append(currentTimeMillis).toString();
        AppMethodBeat.m2505o(25317);
        return format;
    }

    /* renamed from: pI */
    public final boolean mo69308pI(String str) {
        AppMethodBeat.m2504i(25318);
        Assert.assertTrue(str.length() > 0);
        if (this.bSd.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            C4990ab.m7420w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(25318);
        return true;
    }

    public final C35265c abo(String str) {
        AppMethodBeat.m2504i(25319);
        if (this.stq.get(str) == null) {
            this.stq.put(str, new C35265c(str));
        }
        C35265c c35265c = (C35265c) this.stq.get(str);
        AppMethodBeat.m2505o(25319);
        return c35265c;
    }

    /* renamed from: uO */
    public final void mo69309uO(String str) {
        AppMethodBeat.m2504i(25320);
        C35265c c35265c = (C35265c) this.stq.get(str);
        if (c35265c != null) {
            c35265c.alO();
            this.stq.remove(str);
        }
        AppMethodBeat.m2505o(25320);
    }

    public final C29385g abp(String str) {
        AppMethodBeat.m2504i(25321);
        C29385g c29385g = null;
        String str2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
        Cursor a = this.bSd.mo10104a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            c29385g = new C29385g();
            c29385g.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(25321);
        return c29385g;
    }

    /* renamed from: a */
    public final boolean mo69305a(String str, C29385g c29385g) {
        boolean z;
        AppMethodBeat.m2504i(25322);
        Assert.assertTrue(str.length() > 0);
        if (c29385g != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues Hl = c29385g.mo10098Hl();
        if (Hl.size() <= 0) {
            C4990ab.m7412e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
        } else {
            if (this.bSd.update("VoiceRemindInfo", Hl, "filename= ?", new String[]{str}) > 0) {
                doNotify();
                AppMethodBeat.m2505o(25322);
                return true;
            }
        }
        AppMethodBeat.m2505o(25322);
        return false;
    }
}
