package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.ez;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k extends j<g> {
    private static long fXo = 0;
    public static final String[] fnj = new String[]{j.a(g.ccO, "VoiceRemindInfo")};
    e bSd;
    private Map<String, c> stq = new HashMap();

    static {
        AppMethodBeat.i(25323);
        AppMethodBeat.o(25323);
    }

    public k(e eVar) {
        super(eVar, g.ccO, "VoiceRemindInfo", ez.diI);
        AppMethodBeat.i(25316);
        this.bSd = eVar;
        AppMethodBeat.o(25316);
    }

    public static String ug(String str) {
        AppMethodBeat.i(25317);
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.x(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = fXo;
        fXo = 1 + currentTimeMillis;
        format = append.append(currentTimeMillis).toString();
        AppMethodBeat.o(25317);
        return format;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(25318);
        Assert.assertTrue(str.length() > 0);
        if (this.bSd.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            ab.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(25318);
        return true;
    }

    public final c abo(String str) {
        AppMethodBeat.i(25319);
        if (this.stq.get(str) == null) {
            this.stq.put(str, new c(str));
        }
        c cVar = (c) this.stq.get(str);
        AppMethodBeat.o(25319);
        return cVar;
    }

    public final void uO(String str) {
        AppMethodBeat.i(25320);
        c cVar = (c) this.stq.get(str);
        if (cVar != null) {
            cVar.alO();
            this.stq.remove(str);
        }
        AppMethodBeat.o(25320);
    }

    public final g abp(String str) {
        AppMethodBeat.i(25321);
        g gVar = null;
        String str2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
        Cursor a = this.bSd.a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            gVar = new g();
            gVar.d(a);
        }
        a.close();
        AppMethodBeat.o(25321);
        return gVar;
    }

    public final boolean a(String str, g gVar) {
        boolean z;
        AppMethodBeat.i(25322);
        Assert.assertTrue(str.length() > 0);
        if (gVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues Hl = gVar.Hl();
        if (Hl.size() <= 0) {
            ab.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
        } else {
            if (this.bSd.update("VoiceRemindInfo", Hl, "filename= ?", new String[]{str}) > 0) {
                doNotify();
                AppMethodBeat.o(25322);
                return true;
            }
        }
        AppMethodBeat.o(25322);
        return false;
    }
}
