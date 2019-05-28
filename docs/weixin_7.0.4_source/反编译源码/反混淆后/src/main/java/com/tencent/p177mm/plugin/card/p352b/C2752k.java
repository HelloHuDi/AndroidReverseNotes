package com.tencent.p177mm.plugin.card.p352b;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.plugin.card.model.C38747g;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.card.b.k */
public final class C2752k {
    private List<WeakReference<C2754a>> kaD = new ArrayList();
    public List<C38747g> kbM = new ArrayList();
    public int kbN = 0;

    /* renamed from: com.tencent.mm.plugin.card.b.k$1 */
    static class C27531 implements Runnable {
        C27531() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87739);
            C4990ab.m7416i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(0));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.FALSE);
            if (C16112c.m24429PK().mo28552bY(262152, 266256)) {
                C16112c.m24429PK().mo28557y(262152, false);
            }
            if (C16112c.m24429PK().mo28551bX(262152, 266256)) {
                C16112c.m24429PK().mo28556x(262152, false);
            }
            if (C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC)) {
                C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
            }
            if (C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC)) {
                C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
            }
            C4990ab.m7416i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
            AppMethodBeat.m2505o(87739);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.b.k$a */
    public interface C2754a {
        /* renamed from: a */
        void mo6836a(C38747g c38747g);

        void aVU();
    }

    public C2752k() {
        int i;
        AppMethodBeat.m2504i(87740);
        loadFromDB();
        Object obj = C1720g.m3536RP().mo5239Ry().get(139268, null);
        if (obj == null) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        this.kbN = i;
        AppMethodBeat.m2505o(87740);
    }

    /* renamed from: a */
    public final void mo6830a(C38747g c38747g) {
        AppMethodBeat.m2504i(87741);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87741);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C2754a c2754a = (C2754a) weakReference.get();
                    if (c2754a != null) {
                        c2754a.mo6836a(c38747g);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87741);
                return;
            }
        }
    }

    public final void aVU() {
        AppMethodBeat.m2504i(87742);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87742);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C2754a c2754a = (C2754a) weakReference.get();
                    if (c2754a != null) {
                        c2754a.aVU();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87742);
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo6829a(C2754a c2754a) {
        AppMethodBeat.m2504i(87743);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(c2754a));
        AppMethodBeat.m2505o(87743);
    }

    /* renamed from: b */
    public final void mo6832b(C2754a c2754a) {
        AppMethodBeat.m2504i(87744);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87744);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C2754a c2754a2 = (C2754a) weakReference.get();
                    if (c2754a2 != null && c2754a2.equals(c2754a)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.m2505o(87744);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87744);
                return;
            }
        }
    }

    /* renamed from: c */
    public static void m4999c(C38747g c38747g) {
        AppMethodBeat.m2504i(87745);
        if (!C42852am.baY().mo10101b((C4925c) c38747g)) {
            C4990ab.m7412e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + c38747g.field_msg_id);
        }
        AppMethodBeat.m2505o(87745);
    }

    private void loadFromDB() {
        AppMethodBeat.m2504i(87746);
        Cursor baR = C42852am.baY().baR();
        if (baR != null && baR.getCount() > 0) {
            baR.moveToFirst();
            int columnIndex = baR.getColumnIndex("card_type");
            int columnIndex2 = baR.getColumnIndex("title");
            int columnIndex3 = baR.getColumnIndex("description");
            int columnIndex4 = baR.getColumnIndex("logo_url");
            int columnIndex5 = baR.getColumnIndex("time");
            int columnIndex6 = baR.getColumnIndex("card_id");
            int columnIndex7 = baR.getColumnIndex("card_tp_id");
            int columnIndex8 = baR.getColumnIndex("msg_id");
            int columnIndex9 = baR.getColumnIndex("msg_type");
            int columnIndex10 = baR.getColumnIndex("jump_type");
            int columnIndex11 = baR.getColumnIndex("url");
            int columnIndex12 = baR.getColumnIndex("buttonData");
            int columnIndex13 = baR.getColumnIndex("operData");
            int columnIndex14 = baR.getColumnIndex("report_scene");
            int columnIndex15 = baR.getColumnIndex("read_state");
            while (!baR.isAfterLast()) {
                C38747g c38747g = new C38747g();
                c38747g.field_card_type = baR.getInt(columnIndex);
                c38747g.field_title = baR.getString(columnIndex2);
                c38747g.field_description = baR.getString(columnIndex3);
                c38747g.field_logo_url = baR.getString(columnIndex4);
                c38747g.field_time = baR.getInt(columnIndex5);
                c38747g.field_card_id = baR.getString(columnIndex6);
                c38747g.field_card_tp_id = baR.getString(columnIndex7);
                c38747g.field_msg_id = baR.getString(columnIndex8);
                c38747g.field_msg_type = baR.getInt(columnIndex9);
                c38747g.field_jump_type = baR.getInt(columnIndex10);
                c38747g.field_url = baR.getString(columnIndex11);
                c38747g.field_buttonData = baR.getBlob(columnIndex12);
                c38747g.field_operData = baR.getBlob(columnIndex13);
                c38747g.field_report_scene = baR.getInt(columnIndex14);
                c38747g.field_read_state = baR.getInt(columnIndex15);
                baR.moveToNext();
                this.kbM.add(c38747g);
            }
        }
        if (baR != null) {
            baR.close();
        }
        AppMethodBeat.m2505o(87746);
    }

    /* renamed from: h */
    public static String m5001h(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(87747);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (C5046bo.isNullOrNil((String) map.get(str2 + ".title"))) {
                break;
            }
            stringBuilder.append("<jump_buttons>");
            stringBuilder.append("<title>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<description>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".description"))) + "</description>");
            stringBuilder.append("<button_wording>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".button_wording"))) + "</button_wording>");
            stringBuilder.append("<jump_url>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".jump_url"))) + "</jump_url>");
            stringBuilder.append("</jump_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!C5046bo.isNullOrNil(stringBuilder.toString())) {
            stringBuilder2.append("<jump_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</jump_buttons_list>");
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.m2505o(87747);
        return stringBuilder3;
    }

    /* renamed from: i */
    public static String m5002i(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(87748);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".accept_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            String str3 = (String) map.get(str2 + ".title");
            if (C5046bo.isNullOrNil((String) map.get(str2 + ".card_id")) && C5046bo.isNullOrNil(str3)) {
                break;
            }
            stringBuilder.append("<accept_buttons>");
            stringBuilder.append("<title>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<sub_title>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".sub_title"))) + "</sub_title>");
            stringBuilder.append("<card_id>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".card_id"))) + "</card_id>");
            stringBuilder.append("<card_ext>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".card_ext"))) + "</card_ext>");
            stringBuilder.append("<end_time>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".end_time"))) + "</end_time>");
            stringBuilder.append("<action_type>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".action_type"))) + "</action_type>");
            stringBuilder.append("</accept_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!C5046bo.isNullOrNil(stringBuilder.toString())) {
            stringBuilder2.append("<accept_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</accept_buttons_list>");
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.m2505o(87748);
        return stringBuilder3;
    }

    /* renamed from: j */
    public static String m5003j(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(87749);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".unavailable_qr_code_list" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (C5046bo.isNullOrNil((String) map.get(str2 + ".code_id"))) {
                break;
            }
            stringBuilder.append("<unavailable_qr_codes>");
            stringBuilder.append("<code_id>" + C5046bo.ani(C5046bo.nullAsNil((String) map.get(str2 + ".code_id"))) + "</code_id>");
            stringBuilder.append("</unavailable_qr_codes>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!C5046bo.isNullOrNil(stringBuilder.toString())) {
            stringBuilder2.append("<unavailable_qr_code_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</unavailable_qr_code_list>");
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.m2505o(87749);
        return stringBuilder3;
    }

    /* renamed from: Gq */
    public final boolean mo6827Gq(String str) {
        AppMethodBeat.m2504i(87750);
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87750);
            return false;
        }
        int i = 0;
        while (i < this.kbM.size()) {
            C38747g c38747g = (C38747g) this.kbM.get(i);
            if (c38747g == null || c38747g.field_msg_id == null || !c38747g.field_msg_id.equals(str)) {
                i++;
            } else {
                AppMethodBeat.m2505o(87750);
                return true;
            }
        }
        AppMethodBeat.m2505o(87750);
        return false;
    }

    /* renamed from: Gr */
    public final boolean mo6828Gr(String str) {
        AppMethodBeat.m2504i(87751);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87751);
            return false;
        }
        Object obj;
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            obj = null;
        } else {
            for (int i = 0; i < this.kbM.size(); i++) {
                C38747g obj2 = (C38747g) this.kbM.get(i);
                if (str.equals(obj2.field_msg_id)) {
                    break;
                }
            }
            obj2 = null;
        }
        if (obj2 != null) {
            this.kbM.remove(obj2);
            C2752k.m5000d(obj2);
            AppMethodBeat.m2505o(87751);
            return true;
        }
        AppMethodBeat.m2505o(87751);
        return false;
    }

    /* renamed from: d */
    public static boolean m5000d(C38747g c38747g) {
        boolean z = false;
        AppMethodBeat.m2504i(87752);
        if (c38747g == null) {
            AppMethodBeat.m2505o(87752);
        } else {
            z = C42852am.baY().mo16760a((C4925c) c38747g, new String[0]);
            if (!z) {
                C4990ab.m7412e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + c38747g.field_msg_id);
            }
            AppMethodBeat.m2505o(87752);
        }
        return z;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(87753);
        if (this.kbM == null || this.kbM.isEmpty()) {
            AppMethodBeat.m2505o(87753);
            return 0;
        }
        int size = this.kbM.size();
        AppMethodBeat.m2505o(87753);
        return size;
    }

    public final void baJ() {
        AppMethodBeat.m2504i(87754);
        this.kbN = 0;
        C1720g.m3536RP().mo5239Ry().set(139268, Integer.valueOf(this.kbN));
        AppMethodBeat.m2505o(87754);
    }

    public static void baK() {
        AppMethodBeat.m2504i(87755);
        C4990ab.m7416i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        C7305d.post(new C27531(), "clearRedDotAndWording");
        AppMethodBeat.m2505o(87755);
    }
}
