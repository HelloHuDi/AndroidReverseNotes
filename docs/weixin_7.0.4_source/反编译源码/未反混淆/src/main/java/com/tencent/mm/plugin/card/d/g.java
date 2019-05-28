package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class g {
    public static d Hi(String str) {
        AppMethodBeat.i(88869);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88869);
            return null;
        }
        d dVar = new d();
        Map z = br.z(str, "msg");
        dVar.kde = (String) z.get(".msg.appmsg.carditem.from_username");
        dVar.cMC = (String) z.get(".msg.appmsg.carditem.card_id");
        dVar.iAd = Hk((String) z.get(".msg.appmsg.carditem.card_type"));
        dVar.cME = Hk((String) z.get(".msg.appmsg.carditem.from_scene"));
        dVar.color = (String) z.get(".msg.appmsg.carditem.color");
        dVar.kdf = (String) z.get(".msg.appmsg.carditem.card_type_name");
        dVar.kdg = (String) z.get(".msg.appmsg.carditem.brand_name");
        dVar.cMD = (String) z.get(".msg.appmsg.carditem.card_ext");
        dVar.kdh = Hk((String) z.get(".msg.appmsg.carditem.is_recommend"));
        dVar.kdi = (String) z.get(".msg.appmsg.carditem.recommend_card_id");
        AppMethodBeat.o(88869);
        return dVar;
    }

    public static String Hj(String str) {
        AppMethodBeat.i(88870);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88870);
            return null;
        }
        String str2 = (String) br.z(str, "msg").get(".msg.appmsg.fromusername");
        AppMethodBeat.o(88870);
        return str2;
    }

    private static int Hk(String str) {
        AppMethodBeat.i(88871);
        if (TextUtils.isEmpty(str) || !l.isNumeric(str)) {
            AppMethodBeat.o(88871);
            return 0;
        }
        int intValue = Integer.valueOf(str).intValue();
        AppMethodBeat.o(88871);
        return intValue;
    }

    public static String a(d dVar) {
        AppMethodBeat.i(88872);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<from_username>").append(dVar.kde).append("</from_username>");
        stringBuilder.append("<card_id>").append(dVar.cMC).append("</card_id>");
        stringBuilder.append("<card_type>").append(dVar.iAd).append("</card_type>");
        stringBuilder.append("<from_scene>").append(dVar.cME).append("</from_scene>");
        stringBuilder.append("<color>").append(dVar.color).append("</color>");
        stringBuilder.append("<card_type_name>").append(dVar.kdf).append("</card_type_name>");
        stringBuilder.append("<brand_name>").append(dVar.kdg).append("</brand_name>");
        if (TextUtils.isEmpty(dVar.cMD)) {
            stringBuilder.append("<card_ext></card_ext>");
        } else {
            stringBuilder.append("<card_ext>").append(dVar.cMD).append("</card_ext>");
        }
        stringBuilder.append("<is_recommend>").append(dVar.kdh).append("</is_recommend>");
        stringBuilder.append("<recommend_card_id>").append(dVar.kdi).append("</recommend_card_id>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(88872);
        return stringBuilder2;
    }
}
