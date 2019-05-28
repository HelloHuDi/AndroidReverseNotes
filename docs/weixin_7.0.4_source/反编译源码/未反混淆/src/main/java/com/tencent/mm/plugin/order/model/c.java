package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    public List<j> kbM = new ArrayList();
    private List<a> pbW = new ArrayList();

    public c() {
        AppMethodBeat.i(43753);
        loadFromDB();
        bYX();
        bYW();
        bYY();
        AppMethodBeat.o(43753);
    }

    public final void a(j jVar, String str, String str2) {
        AppMethodBeat.i(43754);
        if (jVar == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43754);
            return;
        }
        a aVar = new a();
        aVar.field_msgId = jVar.cJb;
        aVar.field_msgContentXml = str;
        aVar.field_isRead = str2;
        b.bYR();
        if (!b.bYT().a(aVar)) {
            ab.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + jVar.cJb);
        }
        this.pbW.add(aVar);
        AppMethodBeat.o(43754);
    }

    private void loadFromDB() {
        AppMethodBeat.i(43755);
        b.bYR();
        Cursor baR = b.bYT().baR();
        if (baR != null && baR.getCount() > 0) {
            baR.moveToFirst();
            int columnIndex = baR.getColumnIndex("msgId");
            int columnIndex2 = baR.getColumnIndex("msgContentXml");
            int columnIndex3 = baR.getColumnIndex("isRead");
            while (!baR.isAfterLast()) {
                a aVar = new a();
                aVar.field_msgId = baR.getString(columnIndex);
                aVar.field_msgContentXml = baR.getString(columnIndex2);
                aVar.field_isRead = baR.getString(columnIndex3);
                baR.moveToNext();
                this.pbW.add(aVar);
            }
        }
        if (baR != null) {
            baR.close();
        }
        AppMethodBeat.o(43755);
    }

    private void bYW() {
        AppMethodBeat.i(43756);
        if (this.kbM == null || this.kbM.size() == 0) {
            AppMethodBeat.o(43756);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.kbM);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                j jVar = (j) arrayList.get(i2);
                if (jVar.pdo != null && com.tencent.mm.plugin.order.c.c.isNumeric(jVar.pdo)) {
                    int intValue = Integer.valueOf(jVar.pdo).intValue();
                    if (!(intValue == 2 || intValue == 1)) {
                        Uu(jVar.cJb);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43756);
                return;
            }
        }
    }

    public static j Ut(String str) {
        AppMethodBeat.i(43757);
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.o(43757);
            return null;
        }
        CharSequence charSequence;
        String str2;
        String charSequence2;
        j jVar = new j();
        jVar.pdo = (String) z.get(".sysmsg.paymsg.PayMsgType");
        jVar.pdp = (String) z.get(".sysmsg.paymsg.Brief.IconUrl");
        jVar.pdq = (String) z.get(".sysmsg.paymsg.Brief.CreateTime");
        jVar.pdr = (String) z.get(".sysmsg.paymsg.StatusSection.IconUrl");
        jVar.pds = (String) z.get(".sysmsg.paymsg.StatusSection.StatusDesc");
        jVar.cJh = (String) z.get(".sysmsg.paymsg.StatusSection.Content");
        jVar.pdt = (String) z.get(".sysmsg.paymsg.StatusSection.JumpUrl");
        jVar.pdu = (String) z.get(".sysmsg.paymsg.ContactSection.AppUserName");
        jVar.pde = (String) z.get(".sysmsg.paymsg.ContactSection.AppNickName");
        jVar.pdv = (String) z.get(".sysmsg.paymsg.ContactSection.AppTelephone");
        int i = 0;
        while (true) {
            if (i == 0) {
                charSequence2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button.Name");
                str2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");
            } else {
                charSequence2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
                str2 = (String) z.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(charSequence2)) {
                break;
            }
            j.a aVar = new j.a();
            aVar.name = charSequence2;
            aVar.jumpUrl = str2;
            if (jVar.pdw == null) {
                jVar.pdw = new ArrayList();
            }
            jVar.pdw.add(aVar);
            i++;
        }
        i = 0;
        while (true) {
            String str3;
            if (i == 0) {
                charSequence2 = (String) z.get(".sysmsg.paymsg.NormalSection.Name");
                str2 = (String) z.get(".sysmsg.paymsg.NormalSection.Value");
                str3 = (String) z.get(".sysmsg.paymsg.NormalSection.JumpUrl");
            } else {
                charSequence2 = (String) z.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
                str2 = (String) z.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
                str3 = (String) z.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(charSequence2)) {
                AppMethodBeat.o(43757);
                return jVar;
            }
            j.b bVar = new j.b();
            bVar.name = charSequence2;
            bVar.value = str2;
            bVar.jumpUrl = str3;
            if (jVar.pdx == null) {
                jVar.pdx = new ArrayList();
            }
            jVar.pdx.add(bVar);
            i++;
        }
    }

    public final boolean Uu(String str) {
        AppMethodBeat.i(43758);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43758);
            return false;
        }
        j Uw = Uw(str);
        if (Uw != null) {
            this.kbM.remove(Uw);
            a(Uw);
            AppMethodBeat.o(43758);
            return true;
        }
        AppMethodBeat.o(43758);
        return false;
    }

    private boolean a(j jVar) {
        AppMethodBeat.i(43759);
        if (jVar == null) {
            AppMethodBeat.o(43759);
            return false;
        }
        for (int i = 0; i < this.pbW.size(); i++) {
            a aVar = (a) this.pbW.get(i);
            if (jVar.cJb.equals(aVar.field_msgId)) {
                this.pbW.remove(aVar);
                b.bYR();
                boolean a = b.bYT().a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
                AppMethodBeat.o(43759);
                return a;
            }
        }
        AppMethodBeat.o(43759);
        return false;
    }

    private void bYX() {
        AppMethodBeat.i(43760);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pbW.size()) {
                a aVar = (a) this.pbW.get(i2);
                String str = aVar.field_msgContentXml;
                j Ut = Ut(str);
                Ut.cJb = aVar.field_msgId;
                this.kbM.add(Ut);
                ab.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43760);
                return;
            }
        }
    }

    public final boolean Uv(String str) {
        AppMethodBeat.i(43761);
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43761);
            return false;
        }
        int i = 0;
        while (i < this.kbM.size()) {
            j jVar = (j) this.kbM.get(i);
            if (jVar == null || !jVar.cJb.equals(str)) {
                i++;
            } else {
                AppMethodBeat.o(43761);
                return true;
            }
        }
        AppMethodBeat.o(43761);
        return false;
    }

    public final j Uw(String str) {
        AppMethodBeat.i(43762);
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43762);
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kbM.size()) {
                j jVar = (j) this.kbM.get(i2);
                if (str.equals(jVar.cJb)) {
                    AppMethodBeat.o(43762);
                    return jVar;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43762);
                return null;
            }
        }
    }

    public final a Ux(String str) {
        AppMethodBeat.i(43763);
        if (this.pbW == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43763);
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pbW.size()) {
                a aVar = (a) this.pbW.get(i2);
                if (str.equals(aVar.field_msgId)) {
                    AppMethodBeat.o(43763);
                    return aVar;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43763);
                return null;
            }
        }
    }

    public final void bYY() {
        AppMethodBeat.i(43764);
        int bYZ = bYZ();
        g.RQ();
        g.RP().Ry().set(204820, Integer.valueOf(bYZ));
        ab.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(bYZ)));
        AppMethodBeat.o(43764);
    }

    public final int bYZ() {
        AppMethodBeat.i(43765);
        if (this.pbW == null || this.pbW.size() == 0) {
            AppMethodBeat.o(43765);
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.pbW.size(); i2++) {
            a aVar = (a) this.pbW.get(i2);
            if (aVar != null && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(aVar.field_isRead)) {
                i++;
            }
        }
        ab.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(i)));
        AppMethodBeat.o(43765);
        return i;
    }
}
