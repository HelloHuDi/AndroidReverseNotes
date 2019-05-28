package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends ai {
    protected static com.tencent.mm.sdk.e.c.a ccO;
    public List<c> kdA = null;
    public String kdn = "";
    public String kdo = "";
    public String kdp;
    public String kdq;
    public String kdr;
    public boolean kds = false;
    public nm kdt;
    public nz kdu;
    public List<a> kdv = null;
    public List<b> kdw = null;
    public int kdx = 0;
    public int kdy = 0;
    public boolean kdz;

    public class a {
        public String cardId;
        public int endTime;
        public String jcF;
        public String kdB;
        public int kdC;
        public String title;
    }

    public class c {
        public String kdG;
    }

    public class b {
        public String description;
        public String kdE;
        public String kdF;
        public String title;
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public final nm baM() {
        AppMethodBeat.i(87829);
        nm nmVar;
        if (this.kdt != null) {
            nmVar = this.kdt;
            AppMethodBeat.o(87829);
            return nmVar;
        }
        try {
            this.kdt = (nm) new nm().parseFrom(this.field_buttonData);
            nmVar = this.kdt;
            AppMethodBeat.o(87829);
            return nmVar;
        } catch (Exception e) {
            ab.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            nmVar = new nm();
            AppMethodBeat.o(87829);
            return nmVar;
        }
    }

    public final nz baN() {
        AppMethodBeat.i(87830);
        nz nzVar;
        if (this.kdu != null) {
            nzVar = this.kdu;
            AppMethodBeat.o(87830);
            return nzVar;
        }
        try {
            this.kdu = (nz) new nz().parseFrom(this.field_operData);
            nzVar = this.kdu;
            AppMethodBeat.o(87830);
            return nzVar;
        } catch (Exception e) {
            ab.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            nzVar = new nz();
            AppMethodBeat.o(87830);
            return nzVar;
        }
    }

    public final void baO() {
        AppMethodBeat.i(87831);
        if (this.kdv == null) {
            this.kdv = new ArrayList();
            if (!bo.isNullOrNil(this.field_accept_buttons)) {
                Map z = br.z(this.field_accept_buttons, "accept_buttons_list");
                if (z != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        String str2 = (String) z.get(str + ".title");
                        if (bo.isNullOrNil((String) z.get(str + ".card_id")) && bo.isNullOrNil(str2)) {
                            break;
                        }
                        int i2 = bo.getInt((String) z.get(str + ".end_time"), 0);
                        if (i2 == 0 || ((long) i2) > bo.anT()) {
                            a aVar = new a();
                            aVar.title = (String) z.get(str + ".title");
                            aVar.jcF = (String) z.get(str + ".sub_title");
                            aVar.kdB = (String) z.get(str + ".card_ext");
                            aVar.cardId = (String) z.get(str + ".card_id");
                            aVar.kdC = bo.getInt((String) z.get(str + ".action_type"), 0);
                            aVar.endTime = i2;
                            this.kdv.add(aVar);
                        }
                        i++;
                    }
                } else {
                    AppMethodBeat.o(87831);
                    return;
                }
            }
            AppMethodBeat.o(87831);
            return;
        }
        AppMethodBeat.o(87831);
    }

    public final void baP() {
        AppMethodBeat.i(87832);
        if (this.kdw == null) {
            this.kdw = new ArrayList();
            if (!bo.isNullOrNil(this.field_jump_buttons)) {
                Map z = br.z(this.field_jump_buttons, "jump_buttons_list");
                if (z != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 100) {
                            break;
                        }
                        String str = ".jump_buttons_list.jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
                        if (bo.isNullOrNil((String) z.get(str + ".title"))) {
                            break;
                        }
                        b bVar = new b();
                        bVar.title = (String) z.get(str + ".title");
                        bVar.description = (String) z.get(str + ".description");
                        bVar.kdE = (String) z.get(str + ".button_wording");
                        bVar.kdF = (String) z.get(str + ".jump_url");
                        this.kdw.add(bVar);
                        i = i2 + 1;
                    }
                } else {
                    AppMethodBeat.o(87832);
                    return;
                }
            }
            AppMethodBeat.o(87832);
            return;
        }
        AppMethodBeat.o(87832);
    }

    public final void baQ() {
        AppMethodBeat.i(87833);
        if (this.kdA == null) {
            this.kdA = new ArrayList();
            if (!bo.isNullOrNil(this.field_unavailable_qr_code_list)) {
                Map z = br.z(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
                if (z != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 100) {
                            break;
                        }
                        String str = ".unavailable_qr_code_list.unavailable_qr_codes" + (i2 > 0 ? Integer.valueOf(i2) : "");
                        if (bo.isNullOrNil((String) z.get(str + ".code_id"))) {
                            break;
                        }
                        c cVar = new c();
                        cVar.kdG = (String) z.get(str + ".code_id");
                        this.kdA.add(cVar);
                        i = i2 + 1;
                    }
                } else {
                    AppMethodBeat.o(87833);
                    return;
                }
            }
            AppMethodBeat.o(87833);
            return;
        }
        AppMethodBeat.o(87833);
    }

    static {
        AppMethodBeat.i(87834);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[22];
        aVar.columns = new String[23];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_type";
        aVar.xDd.put("card_type", "INTEGER");
        stringBuilder.append(" card_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "description";
        aVar.xDd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "logo_url";
        aVar.xDd.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "time";
        aVar.xDd.put("time", "INTEGER");
        stringBuilder.append(" time INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "card_id";
        aVar.xDd.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "card_tp_id";
        aVar.xDd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "msg_id";
        aVar.xDd.put("msg_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msg_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msg_id";
        aVar.columns[8] = "msg_type";
        aVar.xDd.put("msg_type", "INTEGER");
        stringBuilder.append(" msg_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "jump_type";
        aVar.xDd.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "buttonData";
        aVar.xDd.put("buttonData", "BLOB");
        stringBuilder.append(" buttonData BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "operData";
        aVar.xDd.put("operData", "BLOB");
        stringBuilder.append(" operData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "report_scene";
        aVar.xDd.put("report_scene", "INTEGER");
        stringBuilder.append(" report_scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "read_state";
        aVar.xDd.put("read_state", "INTEGER default '0' ");
        stringBuilder.append(" read_state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "accept_buttons";
        aVar.xDd.put("accept_buttons", "TEXT");
        stringBuilder.append(" accept_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "consumed_box_id";
        aVar.xDd.put("consumed_box_id", "TEXT");
        stringBuilder.append(" consumed_box_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "jump_buttons";
        aVar.xDd.put("jump_buttons", "TEXT");
        stringBuilder.append(" jump_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "logo_color";
        aVar.xDd.put("logo_color", "TEXT");
        stringBuilder.append(" logo_color TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "unavailable_qr_code_list";
        aVar.xDd.put("unavailable_qr_code_list", "TEXT");
        stringBuilder.append(" unavailable_qr_code_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "all_unavailable";
        aVar.xDd.put("all_unavailable", "INTEGER default 'false' ");
        stringBuilder.append(" all_unavailable INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "need_pull_card_entrance";
        aVar.xDd.put("need_pull_card_entrance", "INTEGER default 'false' ");
        stringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
        aVar.columns[22] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(87834);
    }
}
