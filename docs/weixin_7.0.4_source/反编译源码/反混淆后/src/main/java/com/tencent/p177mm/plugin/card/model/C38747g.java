package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45385ai;
import com.tencent.p177mm.protocal.protobuf.C15368nz;
import com.tencent.p177mm.protocal.protobuf.C46570nm;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.card.model.g */
public final class C38747g extends C45385ai {
    protected static C4924a ccO;
    public List<C38746c> kdA = null;
    public String kdn = "";
    public String kdo = "";
    public String kdp;
    public String kdq;
    public String kdr;
    public boolean kds = false;
    public C46570nm kdt;
    public C15368nz kdu;
    public List<C38745a> kdv = null;
    public List<C38748b> kdw = null;
    public int kdx = 0;
    public int kdy = 0;
    public boolean kdz;

    /* renamed from: com.tencent.mm.plugin.card.model.g$a */
    public class C38745a {
        public String cardId;
        public int endTime;
        public String jcF;
        public String kdB;
        public int kdC;
        public String title;
    }

    /* renamed from: com.tencent.mm.plugin.card.model.g$c */
    public class C38746c {
        public String kdG;
    }

    /* renamed from: com.tencent.mm.plugin.card.model.g$b */
    public class C38748b {
        public String description;
        public String kdE;
        public String kdF;
        public String title;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final C46570nm baM() {
        AppMethodBeat.m2504i(87829);
        C46570nm c46570nm;
        if (this.kdt != null) {
            c46570nm = this.kdt;
            AppMethodBeat.m2505o(87829);
            return c46570nm;
        }
        try {
            this.kdt = (C46570nm) new C46570nm().parseFrom(this.field_buttonData);
            c46570nm = this.kdt;
            AppMethodBeat.m2505o(87829);
            return c46570nm;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            c46570nm = new C46570nm();
            AppMethodBeat.m2505o(87829);
            return c46570nm;
        }
    }

    public final C15368nz baN() {
        AppMethodBeat.m2504i(87830);
        C15368nz c15368nz;
        if (this.kdu != null) {
            c15368nz = this.kdu;
            AppMethodBeat.m2505o(87830);
            return c15368nz;
        }
        try {
            this.kdu = (C15368nz) new C15368nz().parseFrom(this.field_operData);
            c15368nz = this.kdu;
            AppMethodBeat.m2505o(87830);
            return c15368nz;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            c15368nz = new C15368nz();
            AppMethodBeat.m2505o(87830);
            return c15368nz;
        }
    }

    public final void baO() {
        AppMethodBeat.m2504i(87831);
        if (this.kdv == null) {
            this.kdv = new ArrayList();
            if (!C5046bo.isNullOrNil(this.field_accept_buttons)) {
                Map z = C5049br.m7595z(this.field_accept_buttons, "accept_buttons_list");
                if (z != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        String str2 = (String) z.get(str + ".title");
                        if (C5046bo.isNullOrNil((String) z.get(str + ".card_id")) && C5046bo.isNullOrNil(str2)) {
                            break;
                        }
                        int i2 = C5046bo.getInt((String) z.get(str + ".end_time"), 0);
                        if (i2 == 0 || ((long) i2) > C5046bo.anT()) {
                            C38745a c38745a = new C38745a();
                            c38745a.title = (String) z.get(str + ".title");
                            c38745a.jcF = (String) z.get(str + ".sub_title");
                            c38745a.kdB = (String) z.get(str + ".card_ext");
                            c38745a.cardId = (String) z.get(str + ".card_id");
                            c38745a.kdC = C5046bo.getInt((String) z.get(str + ".action_type"), 0);
                            c38745a.endTime = i2;
                            this.kdv.add(c38745a);
                        }
                        i++;
                    }
                } else {
                    AppMethodBeat.m2505o(87831);
                    return;
                }
            }
            AppMethodBeat.m2505o(87831);
            return;
        }
        AppMethodBeat.m2505o(87831);
    }

    public final void baP() {
        AppMethodBeat.m2504i(87832);
        if (this.kdw == null) {
            this.kdw = new ArrayList();
            if (!C5046bo.isNullOrNil(this.field_jump_buttons)) {
                Map z = C5049br.m7595z(this.field_jump_buttons, "jump_buttons_list");
                if (z != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 100) {
                            break;
                        }
                        String str = ".jump_buttons_list.jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
                        if (C5046bo.isNullOrNil((String) z.get(str + ".title"))) {
                            break;
                        }
                        C38748b c38748b = new C38748b();
                        c38748b.title = (String) z.get(str + ".title");
                        c38748b.description = (String) z.get(str + ".description");
                        c38748b.kdE = (String) z.get(str + ".button_wording");
                        c38748b.kdF = (String) z.get(str + ".jump_url");
                        this.kdw.add(c38748b);
                        i = i2 + 1;
                    }
                } else {
                    AppMethodBeat.m2505o(87832);
                    return;
                }
            }
            AppMethodBeat.m2505o(87832);
            return;
        }
        AppMethodBeat.m2505o(87832);
    }

    public final void baQ() {
        AppMethodBeat.m2504i(87833);
        if (this.kdA == null) {
            this.kdA = new ArrayList();
            if (!C5046bo.isNullOrNil(this.field_unavailable_qr_code_list)) {
                Map z = C5049br.m7595z(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
                if (z != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 100) {
                            break;
                        }
                        String str = ".unavailable_qr_code_list.unavailable_qr_codes" + (i2 > 0 ? Integer.valueOf(i2) : "");
                        if (C5046bo.isNullOrNil((String) z.get(str + ".code_id"))) {
                            break;
                        }
                        C38746c c38746c = new C38746c();
                        c38746c.kdG = (String) z.get(str + ".code_id");
                        this.kdA.add(c38746c);
                        i = i2 + 1;
                    }
                } else {
                    AppMethodBeat.m2505o(87833);
                    return;
                }
            }
            AppMethodBeat.m2505o(87833);
            return;
        }
        AppMethodBeat.m2505o(87833);
    }

    static {
        AppMethodBeat.m2504i(87834);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[22];
        c4924a.columns = new String[23];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "card_type";
        c4924a.xDd.put("card_type", "INTEGER");
        stringBuilder.append(" card_type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[1] = "title";
        c4924a.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "description";
        c4924a.xDd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "logo_url";
        c4924a.xDd.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "time";
        c4924a.xDd.put("time", "INTEGER");
        stringBuilder.append(" time INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "card_id";
        c4924a.xDd.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "card_tp_id";
        c4924a.xDd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "msg_id";
        c4924a.xDd.put("msg_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msg_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "msg_id";
        c4924a.columns[8] = "msg_type";
        c4924a.xDd.put("msg_type", "INTEGER");
        stringBuilder.append(" msg_type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "jump_type";
        c4924a.xDd.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "url";
        c4924a.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "buttonData";
        c4924a.xDd.put("buttonData", "BLOB");
        stringBuilder.append(" buttonData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[12] = "operData";
        c4924a.xDd.put("operData", "BLOB");
        stringBuilder.append(" operData BLOB");
        stringBuilder.append(", ");
        c4924a.columns[13] = "report_scene";
        c4924a.xDd.put("report_scene", "INTEGER");
        stringBuilder.append(" report_scene INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[14] = "read_state";
        c4924a.xDd.put("read_state", "INTEGER default '0' ");
        stringBuilder.append(" read_state INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "accept_buttons";
        c4924a.xDd.put("accept_buttons", "TEXT");
        stringBuilder.append(" accept_buttons TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "consumed_box_id";
        c4924a.xDd.put("consumed_box_id", "TEXT");
        stringBuilder.append(" consumed_box_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[17] = "jump_buttons";
        c4924a.xDd.put("jump_buttons", "TEXT");
        stringBuilder.append(" jump_buttons TEXT");
        stringBuilder.append(", ");
        c4924a.columns[18] = "logo_color";
        c4924a.xDd.put("logo_color", "TEXT");
        stringBuilder.append(" logo_color TEXT");
        stringBuilder.append(", ");
        c4924a.columns[19] = "unavailable_qr_code_list";
        c4924a.xDd.put("unavailable_qr_code_list", "TEXT");
        stringBuilder.append(" unavailable_qr_code_list TEXT");
        stringBuilder.append(", ");
        c4924a.columns[20] = "all_unavailable";
        c4924a.xDd.put("all_unavailable", "INTEGER default 'false' ");
        stringBuilder.append(" all_unavailable INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[21] = "need_pull_card_entrance";
        c4924a.xDd.put("need_pull_card_entrance", "INTEGER default 'false' ");
        stringBuilder.append(" need_pull_card_entrance INTEGER default 'false' ");
        c4924a.columns[22] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(87834);
    }
}
