package com.tencent.mm.plugin.card.b;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class k {
    private List<WeakReference<a>> kaD = new ArrayList();
    public List<g> kbM = new ArrayList();
    public int kbN = 0;

    public interface a {
        void a(g gVar);

        void aVU();
    }

    public k() {
        int i;
        AppMethodBeat.i(87740);
        loadFromDB();
        Object obj = com.tencent.mm.kernel.g.RP().Ry().get(139268, null);
        if (obj == null) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        this.kbN = i;
        AppMethodBeat.o(87740);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(87741);
        if (this.kaD == null) {
            AppMethodBeat.o(87741);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.a(gVar);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87741);
                return;
            }
        }
    }

    public final void aVU() {
        AppMethodBeat.i(87742);
        if (this.kaD == null) {
            AppMethodBeat.o(87742);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.aVU();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87742);
                return;
            }
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(87743);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(aVar));
        AppMethodBeat.o(87743);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(87744);
        if (this.kaD == null) {
            AppMethodBeat.o(87744);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.o(87744);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87744);
                return;
            }
        }
    }

    public static void c(g gVar) {
        AppMethodBeat.i(87745);
        if (!am.baY().b((c) gVar)) {
            ab.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + gVar.field_msg_id);
        }
        AppMethodBeat.o(87745);
    }

    private void loadFromDB() {
        AppMethodBeat.i(87746);
        Cursor baR = am.baY().baR();
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
                g gVar = new g();
                gVar.field_card_type = baR.getInt(columnIndex);
                gVar.field_title = baR.getString(columnIndex2);
                gVar.field_description = baR.getString(columnIndex3);
                gVar.field_logo_url = baR.getString(columnIndex4);
                gVar.field_time = baR.getInt(columnIndex5);
                gVar.field_card_id = baR.getString(columnIndex6);
                gVar.field_card_tp_id = baR.getString(columnIndex7);
                gVar.field_msg_id = baR.getString(columnIndex8);
                gVar.field_msg_type = baR.getInt(columnIndex9);
                gVar.field_jump_type = baR.getInt(columnIndex10);
                gVar.field_url = baR.getString(columnIndex11);
                gVar.field_buttonData = baR.getBlob(columnIndex12);
                gVar.field_operData = baR.getBlob(columnIndex13);
                gVar.field_report_scene = baR.getInt(columnIndex14);
                gVar.field_read_state = baR.getInt(columnIndex15);
                baR.moveToNext();
                this.kbM.add(gVar);
            }
        }
        if (baR != null) {
            baR.close();
        }
        AppMethodBeat.o(87746);
    }

    public static String h(Map<String, String> map, String str) {
        AppMethodBeat.i(87747);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (bo.isNullOrNil((String) map.get(str2 + ".title"))) {
                break;
            }
            stringBuilder.append("<jump_buttons>");
            stringBuilder.append("<title>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<description>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".description"))) + "</description>");
            stringBuilder.append("<button_wording>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".button_wording"))) + "</button_wording>");
            stringBuilder.append("<jump_url>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".jump_url"))) + "</jump_url>");
            stringBuilder.append("</jump_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bo.isNullOrNil(stringBuilder.toString())) {
            stringBuilder2.append("<jump_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</jump_buttons_list>");
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.o(87747);
        return stringBuilder3;
    }

    public static String i(Map<String, String> map, String str) {
        AppMethodBeat.i(87748);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".accept_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            String str3 = (String) map.get(str2 + ".title");
            if (bo.isNullOrNil((String) map.get(str2 + ".card_id")) && bo.isNullOrNil(str3)) {
                break;
            }
            stringBuilder.append("<accept_buttons>");
            stringBuilder.append("<title>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<sub_title>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".sub_title"))) + "</sub_title>");
            stringBuilder.append("<card_id>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".card_id"))) + "</card_id>");
            stringBuilder.append("<card_ext>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".card_ext"))) + "</card_ext>");
            stringBuilder.append("<end_time>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".end_time"))) + "</end_time>");
            stringBuilder.append("<action_type>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".action_type"))) + "</action_type>");
            stringBuilder.append("</accept_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bo.isNullOrNil(stringBuilder.toString())) {
            stringBuilder2.append("<accept_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</accept_buttons_list>");
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.o(87748);
        return stringBuilder3;
    }

    public static String j(Map<String, String> map, String str) {
        AppMethodBeat.i(87749);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".unavailable_qr_code_list" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (bo.isNullOrNil((String) map.get(str2 + ".code_id"))) {
                break;
            }
            stringBuilder.append("<unavailable_qr_codes>");
            stringBuilder.append("<code_id>" + bo.ani(bo.nullAsNil((String) map.get(str2 + ".code_id"))) + "</code_id>");
            stringBuilder.append("</unavailable_qr_codes>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bo.isNullOrNil(stringBuilder.toString())) {
            stringBuilder2.append("<unavailable_qr_code_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</unavailable_qr_code_list>");
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.o(87749);
        return stringBuilder3;
    }

    public final boolean Gq(String str) {
        AppMethodBeat.i(87750);
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87750);
            return false;
        }
        int i = 0;
        while (i < this.kbM.size()) {
            g gVar = (g) this.kbM.get(i);
            if (gVar == null || gVar.field_msg_id == null || !gVar.field_msg_id.equals(str)) {
                i++;
            } else {
                AppMethodBeat.o(87750);
                return true;
            }
        }
        AppMethodBeat.o(87750);
        return false;
    }

    public final boolean Gr(String str) {
        AppMethodBeat.i(87751);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87751);
            return false;
        }
        Object obj;
        if (this.kbM == null || TextUtils.isEmpty(str)) {
            obj = null;
        } else {
            for (int i = 0; i < this.kbM.size(); i++) {
                g obj2 = (g) this.kbM.get(i);
                if (str.equals(obj2.field_msg_id)) {
                    break;
                }
            }
            obj2 = null;
        }
        if (obj2 != null) {
            this.kbM.remove(obj2);
            d(obj2);
            AppMethodBeat.o(87751);
            return true;
        }
        AppMethodBeat.o(87751);
        return false;
    }

    public static boolean d(g gVar) {
        boolean z = false;
        AppMethodBeat.i(87752);
        if (gVar == null) {
            AppMethodBeat.o(87752);
        } else {
            z = am.baY().a((c) gVar, new String[0]);
            if (!z) {
                ab.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + gVar.field_msg_id);
            }
            AppMethodBeat.o(87752);
        }
        return z;
    }

    public final int getCount() {
        AppMethodBeat.i(87753);
        if (this.kbM == null || this.kbM.isEmpty()) {
            AppMethodBeat.o(87753);
            return 0;
        }
        int size = this.kbM.size();
        AppMethodBeat.o(87753);
        return size;
    }

    public final void baJ() {
        AppMethodBeat.i(87754);
        this.kbN = 0;
        com.tencent.mm.kernel.g.RP().Ry().set(139268, Integer.valueOf(this.kbN));
        AppMethodBeat.o(87754);
    }

    public static void baK() {
        AppMethodBeat.i(87755);
        ab.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87739);
                ab.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(0));
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.FALSE);
                if (com.tencent.mm.x.c.PK().bY(262152, 266256)) {
                    com.tencent.mm.x.c.PK().y(262152, false);
                }
                if (com.tencent.mm.x.c.PK().bX(262152, 266256)) {
                    com.tencent.mm.x.c.PK().x(262152, false);
                }
                if (com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC)) {
                    com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                }
                if (com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC)) {
                    com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                }
                ab.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
                AppMethodBeat.o(87739);
            }
        }, "clearRedDotAndWording");
        AppMethodBeat.o(87755);
    }
}
