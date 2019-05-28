package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.model.C38743d;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.card.d.g */
public final class C20134g {
    /* renamed from: Hi */
    public static C38743d m31147Hi(String str) {
        AppMethodBeat.m2504i(88869);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88869);
            return null;
        }
        C38743d c38743d = new C38743d();
        Map z = C5049br.m7595z(str, "msg");
        c38743d.kde = (String) z.get(".msg.appmsg.carditem.from_username");
        c38743d.cMC = (String) z.get(".msg.appmsg.carditem.card_id");
        c38743d.iAd = C20134g.m31149Hk((String) z.get(".msg.appmsg.carditem.card_type"));
        c38743d.cME = C20134g.m31149Hk((String) z.get(".msg.appmsg.carditem.from_scene"));
        c38743d.color = (String) z.get(".msg.appmsg.carditem.color");
        c38743d.kdf = (String) z.get(".msg.appmsg.carditem.card_type_name");
        c38743d.kdg = (String) z.get(".msg.appmsg.carditem.brand_name");
        c38743d.cMD = (String) z.get(".msg.appmsg.carditem.card_ext");
        c38743d.kdh = C20134g.m31149Hk((String) z.get(".msg.appmsg.carditem.is_recommend"));
        c38743d.kdi = (String) z.get(".msg.appmsg.carditem.recommend_card_id");
        AppMethodBeat.m2505o(88869);
        return c38743d;
    }

    /* renamed from: Hj */
    public static String m31148Hj(String str) {
        AppMethodBeat.m2504i(88870);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88870);
            return null;
        }
        String str2 = (String) C5049br.m7595z(str, "msg").get(".msg.appmsg.fromusername");
        AppMethodBeat.m2505o(88870);
        return str2;
    }

    /* renamed from: Hk */
    private static int m31149Hk(String str) {
        AppMethodBeat.m2504i(88871);
        if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
            AppMethodBeat.m2505o(88871);
            return 0;
        }
        int intValue = Integer.valueOf(str).intValue();
        AppMethodBeat.m2505o(88871);
        return intValue;
    }

    /* renamed from: a */
    public static String m31150a(C38743d c38743d) {
        AppMethodBeat.m2504i(88872);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<from_username>").append(c38743d.kde).append("</from_username>");
        stringBuilder.append("<card_id>").append(c38743d.cMC).append("</card_id>");
        stringBuilder.append("<card_type>").append(c38743d.iAd).append("</card_type>");
        stringBuilder.append("<from_scene>").append(c38743d.cME).append("</from_scene>");
        stringBuilder.append("<color>").append(c38743d.color).append("</color>");
        stringBuilder.append("<card_type_name>").append(c38743d.kdf).append("</card_type_name>");
        stringBuilder.append("<brand_name>").append(c38743d.kdg).append("</brand_name>");
        if (TextUtils.isEmpty(c38743d.cMD)) {
            stringBuilder.append("<card_ext></card_ext>");
        } else {
            stringBuilder.append("<card_ext>").append(c38743d.cMD).append("</card_ext>");
        }
        stringBuilder.append("<is_recommend>").append(c38743d.kdh).append("</is_recommend>");
        stringBuilder.append("<recommend_card_id>").append(c38743d.kdi).append("</recommend_card_id>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(88872);
        return stringBuilder2;
    }
}
