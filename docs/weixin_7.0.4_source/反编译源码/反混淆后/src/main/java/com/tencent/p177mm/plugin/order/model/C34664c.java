package com.tencent.p177mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.order.model.C43365j.C28660a;
import com.tencent.p177mm.plugin.order.model.C43365j.C34665b;
import com.tencent.p177mm.plugin.order.p1007a.C34657b;
import com.tencent.p177mm.plugin.order.p1008c.C12785c;
import com.tencent.p177mm.plugin.order.p767b.C34658a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.order.model.c */
public final class C34664c {
    public List<C43365j> kbM = new ArrayList();
    private List<C34658a> pbW = new ArrayList();

    public C34664c() {
        AppMethodBeat.m2504i(43753);
        loadFromDB();
        bYX();
        bYW();
        bYY();
        AppMethodBeat.m2505o(43753);
    }

    /* renamed from: a */
    public final void mo55271a(C43365j c43365j, String str, String str2) {
        AppMethodBeat.m2504i(43754);
        if (c43365j == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43754);
            return;
        }
        C34658a c34658a = new C34658a();
        c34658a.field_msgId = c43365j.cJb;
        c34658a.field_msgContentXml = str;
        c34658a.field_isRead = str2;
        C34657b.bYR();
        if (!C34657b.bYT().mo17048a(c34658a)) {
            C4990ab.m7412e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + c43365j.cJb);
        }
        this.pbW.add(c34658a);
        AppMethodBeat.m2505o(43754);
    }

    private void loadFromDB() {
        AppMethodBeat.m2504i(43755);
        C34657b.bYR();
        Cursor baR = C34657b.bYT().baR();
        if (baR != null && baR.getCount() > 0) {
            baR.moveToFirst();
            int columnIndex = baR.getColumnIndex("msgId");
            int columnIndex2 = baR.getColumnIndex("msgContentXml");
            int columnIndex3 = baR.getColumnIndex("isRead");
            while (!baR.isAfterLast()) {
                C34658a c34658a = new C34658a();
                c34658a.field_msgId = baR.getString(columnIndex);
                c34658a.field_msgContentXml = baR.getString(columnIndex2);
                c34658a.field_isRead = baR.getString(columnIndex3);
                baR.moveToNext();
                this.pbW.add(c34658a);
            }
        }
        if (baR != null) {
            baR.close();
        }
        AppMethodBeat.m2505o(43755);
    }

    private void bYW() {
        AppMethodBeat.m2504i(43756);
        if (this.kbM == null || this.kbM.size() == 0) {
            AppMethodBeat.m2505o(43756);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.kbM);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                C43365j c43365j = (C43365j) arrayList.get(i2);
                if (c43365j.pdo != null && C12785c.isNumeric(c43365j.pdo)) {
                    int intValue = Integer.valueOf(c43365j.pdo).intValue();
                    if (!(intValue == 2 || intValue == 1)) {
                        mo55267Uu(c43365j.cJb);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43756);
                return;
            }
        }
    }

    /* renamed from: Ut */
    public static C43365j m56903Ut(String str) {
        AppMethodBeat.m2504i(43757);
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.m2505o(43757);
            return null;
        }
        CharSequence charSequence;
        String str2;
        String charSequence2;
        C43365j c43365j = new C43365j();
        c43365j.pdo = (String) z.get(".sysmsg.paymsg.PayMsgType");
        c43365j.pdp = (String) z.get(".sysmsg.paymsg.Brief.IconUrl");
        c43365j.pdq = (String) z.get(".sysmsg.paymsg.Brief.CreateTime");
        c43365j.pdr = (String) z.get(".sysmsg.paymsg.StatusSection.IconUrl");
        c43365j.pds = (String) z.get(".sysmsg.paymsg.StatusSection.StatusDesc");
        c43365j.cJh = (String) z.get(".sysmsg.paymsg.StatusSection.Content");
        c43365j.pdt = (String) z.get(".sysmsg.paymsg.StatusSection.JumpUrl");
        c43365j.pdu = (String) z.get(".sysmsg.paymsg.ContactSection.AppUserName");
        c43365j.pde = (String) z.get(".sysmsg.paymsg.ContactSection.AppNickName");
        c43365j.pdv = (String) z.get(".sysmsg.paymsg.ContactSection.AppTelephone");
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
            C28660a c28660a = new C28660a();
            c28660a.name = charSequence2;
            c28660a.jumpUrl = str2;
            if (c43365j.pdw == null) {
                c43365j.pdw = new ArrayList();
            }
            c43365j.pdw.add(c28660a);
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
                AppMethodBeat.m2505o(43757);
                return c43365j;
            }
            C34665b c34665b = new C34665b();
            c34665b.name = charSequence2;
            c34665b.value = str2;
            c34665b.jumpUrl = str3;
            if (c43365j.pdx == null) {
                c43365j.pdx = new ArrayList();
            }
            c43365j.pdx.add(c34665b);
            i++;
        }
    }

    /* renamed from: Uu */
    public final boolean mo55267Uu(String str) {
        AppMethodBeat.m2504i(43758);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43758);
            return false;
        }
        C43365j Uw = mo55269Uw(str);
        if (Uw != null) {
            this.kbM.remove(Uw);
            m56904a(Uw);
            AppMethodBeat.m2505o(43758);
            return true;
        }
        AppMethodBeat.m2505o(43758);
        return false;
    }

    /* renamed from: a */
    private boolean m56904a(C43365j c43365j) {
        AppMethodBeat.m2504i(43759);
        if (c43365j == null) {
            AppMethodBeat.m2505o(43759);
            return false;
        }
        for (int i = 0; i < this.pbW.size(); i++) {
            C34658a c34658a = (C34658a) this.pbW.get(i);
            if (c43365j.cJb.equals(c34658a.field_msgId)) {
                this.pbW.remove(c34658a);
                C34657b.bYR();
                boolean a = C34657b.bYT().mo16760a((C4925c) c34658a, new String[0]);
                AppMethodBeat.m2505o(43759);
                return a;
            }
        }
        AppMethodBeat.m2505o(43759);
        return false;
    }

    private void bYX() {
        AppMethodBeat.m2504i(43760);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pbW.size()) {
                C34658a c34658a = (C34658a) this.pbW.get(i2);
                String str = c34658a.field_msgContentXml;
                C43365j Ut = C34664c.m56903Ut(str);
                Ut.cJb = c34658a.field_msgId;
                this.kbM.add(Ut);
                C4990ab.m7418v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43760);
                return;
            }
        }
    }

    /* renamed from: Uv */
    public final boolean mo55268Uv(String str) {
        AppMethodBeat.m2504i(43761);
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43761);
            return false;
        }
        int i = 0;
        while (i < this.kbM.size()) {
            C43365j c43365j = (C43365j) this.kbM.get(i);
            if (c43365j == null || !c43365j.cJb.equals(str)) {
                i++;
            } else {
                AppMethodBeat.m2505o(43761);
                return true;
            }
        }
        AppMethodBeat.m2505o(43761);
        return false;
    }

    /* renamed from: Uw */
    public final C43365j mo55269Uw(String str) {
        AppMethodBeat.m2504i(43762);
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43762);
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kbM.size()) {
                C43365j c43365j = (C43365j) this.kbM.get(i2);
                if (str.equals(c43365j.cJb)) {
                    AppMethodBeat.m2505o(43762);
                    return c43365j;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43762);
                return null;
            }
        }
    }

    /* renamed from: Ux */
    public final C34658a mo55270Ux(String str) {
        AppMethodBeat.m2504i(43763);
        if (this.pbW == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43763);
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pbW.size()) {
                C34658a c34658a = (C34658a) this.pbW.get(i2);
                if (str.equals(c34658a.field_msgId)) {
                    AppMethodBeat.m2505o(43763);
                    return c34658a;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43763);
                return null;
            }
        }
    }

    public final void bYY() {
        AppMethodBeat.m2504i(43764);
        int bYZ = bYZ();
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(204820, Integer.valueOf(bYZ));
        C4990ab.m7418v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(bYZ)));
        AppMethodBeat.m2505o(43764);
    }

    public final int bYZ() {
        AppMethodBeat.m2504i(43765);
        if (this.pbW == null || this.pbW.size() == 0) {
            AppMethodBeat.m2505o(43765);
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.pbW.size(); i2++) {
            C34658a c34658a = (C34658a) this.pbW.get(i2);
            if (c34658a != null && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(c34658a.field_isRead)) {
                i++;
            }
        }
        C4990ab.m7418v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(43765);
        return i;
    }
}
