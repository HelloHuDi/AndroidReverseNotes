package com.tencent.p177mm.plugin.bottle.p924a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.plugin.bottle.C24727a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.bottle.a.c */
public final class C38676c {
    private static int jJK = 1;
    private static int jJL = 1;

    /* renamed from: Fz */
    public static String m65606Fz(String str) {
        AppMethodBeat.m2504i(18533);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(18533);
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            AppMethodBeat.m2505o(18533);
            return null;
        }
        String str2 = split[1];
        AppMethodBeat.m2505o(18533);
        return str2;
    }

    /* renamed from: FA */
    public static void m65605FA(String str) {
        String[] strArr = null;
        AppMethodBeat.m2504i(18534);
        C24727a.gkF.mo38844BS();
        C9638aw.m17190ZK();
        if (C18628c.m29080XO().mo15262Rp(str) != 1) {
            AppMethodBeat.m2505o(18534);
            return;
        }
        C9638aw.m17190ZK();
        C7620bi Rb = C18628c.m29080XO().mo15248Rb(str);
        if (Rb == null || !Rb.field_talker.equals(str)) {
            AppMethodBeat.m2505o(18534);
            return;
        }
        String Fz = C38676c.m65606Fz(str);
        if (C5046bo.isNullOrNil(Fz)) {
            AppMethodBeat.m2505o(18534);
            return;
        }
        C38675a c38675a;
        C45757b aVM = C45759d.aVM();
        Cursor a = aVM.fni.mo10104a("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + C5046bo.m7586vA(String.valueOf(Fz)) + "\"", null, 0);
        if (a == null) {
            c38675a = null;
        } else {
            if (a.moveToFirst()) {
                strArr = new C38675a();
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
            c38675a = strArr;
        }
        if (c38675a != null) {
            String str2;
            if (c38675a.jJG == null) {
                str2 = "";
            } else {
                str2 = c38675a.jJG;
            }
            if (str2.equals(Fz)) {
                if (c38675a.jJH != 1) {
                    AppMethodBeat.m2505o(18534);
                    return;
                }
                long j;
                int i;
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo14794ju(str);
                if (Rb.field_createTime <= c38675a.jJJ) {
                    j = Rb.field_createTime - 1;
                } else {
                    j = c38675a.jJJ;
                }
                c7620bi.mo14775eJ(j);
                switch (c38675a.msgType) {
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
                c7620bi.setType(i);
                c7620bi.setStatus(2);
                c7620bi.mo14781hO(1);
                if (c7620bi.getType() == 34) {
                    c7620bi.setContent(C42230n.m74526d(C1853r.m3846Yz(), (long) c38675a.jJI, false));
                    str2 = c38675a.getContent() + C5046bo.anU();
                    if (C5730e.m8644y(C32850q.getFullPath(c38675a.getContent()), C32850q.getFullPath(str2)) < 0) {
                        C4990ab.m7412e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + c38675a.getContent());
                        AppMethodBeat.m2505o(18534);
                        return;
                    }
                    c7620bi.mo14795jv(str2);
                } else {
                    c7620bi.setContent(c38675a.getContent());
                }
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15281Z(c7620bi);
                AppMethodBeat.m2505o(18534);
                return;
            }
        }
        AppMethodBeat.m2505o(18534);
    }

    public static void aVK() {
        String[] strArr;
        AppMethodBeat.m2504i(18535);
        C45757b aVM = C45759d.aVM();
        Cursor a = aVM.fni.mo10104a("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(C5046bo.anU() - 7776000000L)), null, 0);
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
            AppMethodBeat.m2505o(18535);
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            C4990ab.m7410d("MicroMsg.BottleLogic", "delete path:" + C32850q.getFullPath(strArr[i2]));
            if (!C5046bo.isNullOrNil(C32850q.getFullPath(strArr[i2]))) {
                C5730e.deleteFile(C32850q.getFullPath(strArr[i2]));
            }
        }
        AppMethodBeat.m2505o(18535);
    }

    /* renamed from: a */
    public static String m65607a(Context context, C7616ad c7616ad) {
        AppMethodBeat.m2504i(18536);
        String string;
        if (c7616ad == null) {
            string = context.getString(C25738R.string.ab0);
            AppMethodBeat.m2505o(18536);
            return string;
        } else if (RegionCodeDecoder.apQ(c7616ad.getCountryCode())) {
            string = c7616ad.getCity();
            if (C5046bo.isNullOrNil(string)) {
                string = C1854s.m3868mL(c7616ad.getProvince());
                if (C5046bo.isNullOrNil(string)) {
                    RegionCodeDecoder.duj();
                    string = RegionCodeDecoder.getLocName(c7616ad.getCountryCode());
                    AppMethodBeat.m2505o(18536);
                    return string;
                }
                AppMethodBeat.m2505o(18536);
                return string;
            }
            AppMethodBeat.m2505o(18536);
            return string;
        } else {
            string = context.getString(C25738R.string.ab0);
            AppMethodBeat.m2505o(18536);
            return string;
        }
    }
}
