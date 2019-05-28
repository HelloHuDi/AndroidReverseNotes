package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public final class c {
    private static int jJK = 1;
    private static int jJL = 1;

    public static String Fz(String str) {
        AppMethodBeat.i(18533);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(18533);
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            AppMethodBeat.o(18533);
            return null;
        }
        String str2 = split[1];
        AppMethodBeat.o(18533);
        return str2;
    }

    public static void FA(String str) {
        String[] strArr = null;
        AppMethodBeat.i(18534);
        a.gkF.BS();
        aw.ZK();
        if (com.tencent.mm.model.c.XO().Rp(str) != 1) {
            AppMethodBeat.o(18534);
            return;
        }
        aw.ZK();
        bi Rb = com.tencent.mm.model.c.XO().Rb(str);
        if (Rb == null || !Rb.field_talker.equals(str)) {
            AppMethodBeat.o(18534);
            return;
        }
        String Fz = Fz(str);
        if (bo.isNullOrNil(Fz)) {
            AppMethodBeat.o(18534);
            return;
        }
        a aVar;
        b aVM = d.aVM();
        Cursor a = aVM.fni.a("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bo.vA(String.valueOf(Fz)) + "\"", null, 0);
        if (a == null) {
            aVar = null;
        } else {
            if (a.moveToFirst()) {
                strArr = new a();
                strArr.jJE = a.getString(0);
                strArr.jJF = a.getInt(1);
                strArr.jJG = a.getString(2);
                strArr.jJH = a.getInt(3);
                strArr.msgType = a.getInt(4);
                strArr.jJI = a.getInt(5);
                strArr.content = a.getString(6);
                strArr.jJJ = a.getLong(7);
                strArr.fne = a.getInt(8);
                strArr.fCx = a.getInt(9);
                strArr.fng = a.getString(10);
                strArr.fnh = a.getString(11);
            }
            a.close();
            aVar = strArr;
        }
        if (aVar != null) {
            String str2;
            if (aVar.jJG == null) {
                str2 = "";
            } else {
                str2 = aVar.jJG;
            }
            if (str2.equals(Fz)) {
                if (aVar.jJH != 1) {
                    AppMethodBeat.o(18534);
                    return;
                }
                long j;
                int i;
                bi biVar = new bi();
                biVar.ju(str);
                if (Rb.field_createTime <= aVar.jJJ) {
                    j = Rb.field_createTime - 1;
                } else {
                    j = aVar.jJJ;
                }
                biVar.eJ(j);
                switch (aVar.msgType) {
                    case 1:
                        i = 1;
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 34;
                        break;
                    case 4:
                        i = 43;
                        break;
                    default:
                        i = -1;
                        break;
                }
                biVar.setType(i);
                biVar.setStatus(2);
                biVar.hO(1);
                if (biVar.getType() == 34) {
                    biVar.setContent(n.d(r.Yz(), (long) aVar.jJI, false));
                    str2 = aVar.getContent() + bo.anU();
                    if (e.y(q.getFullPath(aVar.getContent()), q.getFullPath(str2)) < 0) {
                        ab.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + aVar.getContent());
                        AppMethodBeat.o(18534);
                        return;
                    }
                    biVar.jv(str2);
                } else {
                    biVar.setContent(aVar.getContent());
                }
                aw.ZK();
                com.tencent.mm.model.c.XO().Z(biVar);
                AppMethodBeat.o(18534);
                return;
            }
        }
        AppMethodBeat.o(18534);
    }

    public static void aVK() {
        String[] strArr;
        AppMethodBeat.i(18535);
        b aVM = d.aVM();
        Cursor a = aVM.fni.a("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(bo.anU() - 7776000000L)), null, 0);
        int count = a.getCount();
        if (count > 0) {
            strArr = new String[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                if (a.getInt(1) == 3) {
                    strArr[i] = a.getString(0);
                } else {
                    strArr[i] = null;
                }
            }
        } else {
            strArr = null;
        }
        a.close();
        if (count > 0) {
            aVM.fni.delete("bottleinfo1", "createtime< ?", new String[]{String.valueOf(r6)});
        }
        if (strArr == null) {
            AppMethodBeat.o(18535);
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            ab.d("MicroMsg.BottleLogic", "delete path:" + q.getFullPath(strArr[i2]));
            if (!bo.isNullOrNil(q.getFullPath(strArr[i2]))) {
                e.deleteFile(q.getFullPath(strArr[i2]));
            }
        }
        AppMethodBeat.o(18535);
    }

    public static String a(Context context, ad adVar) {
        AppMethodBeat.i(18536);
        String string;
        if (adVar == null) {
            string = context.getString(R.string.ab0);
            AppMethodBeat.o(18536);
            return string;
        } else if (RegionCodeDecoder.apQ(adVar.getCountryCode())) {
            string = adVar.getCity();
            if (bo.isNullOrNil(string)) {
                string = s.mL(adVar.getProvince());
                if (bo.isNullOrNil(string)) {
                    RegionCodeDecoder.duj();
                    string = RegionCodeDecoder.getLocName(adVar.getCountryCode());
                    AppMethodBeat.o(18536);
                    return string;
                }
                AppMethodBeat.o(18536);
                return string;
            }
            AppMethodBeat.o(18536);
            return string;
        } else {
            string = context.getString(R.string.ab0);
            AppMethodBeat.o(18536);
            return string;
        }
    }
}
