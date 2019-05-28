package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.ay.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class e extends a {
    public String pkI = null;
    public int status = 0;
    public String username = null;

    public e(Map<String, String> map, bi biVar) {
        super(map, biVar);
    }

    public e(Map<String, String> map) {
        super(map);
    }

    public final boolean Yt() {
        AppMethodBeat.i(23290);
        if (this.values == null) {
            ab.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] values == null ");
            AppMethodBeat.o(23290);
            return false;
        }
        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type:%s, values size:%s", bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMFriReqAcceptedInWxWork")) {
            ab.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type err :%s", bo.nullAsNil(this.TYPE));
            AppMethodBeat.o(23290);
            return false;
        }
        String str = ".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username";
        String str2 = ".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid";
        String str3 = ".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.status";
        if (this.values.containsKey(str)) {
            this.username = bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.pkI = bo.nullAsNil((String) this.values.get(str2));
        }
        if (this.values.containsKey(str2)) {
            this.status = bo.getInt((String) this.values.get(str3), 0);
        }
        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "username:%s climsgid:%s status:%s", this.username, this.pkI, Integer.valueOf(this.status));
        str3 = this.pkI;
        int i = this.status;
        g.RQ();
        str = (String) g.RP().Ry().get(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, (Object) "");
        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() climsgid:%s state:%s ", str3, Integer.valueOf(i));
        try {
            i iVar;
            Object valueOf;
            Object optString;
            if (bo.isNullOrNil(str)) {
                iVar = new i();
                valueOf = String.valueOf(i);
                str2 = str3;
            } else {
                int i2;
                iVar = new i(str);
                optString = iVar.optString("svrids");
                String optString2 = iVar.optString("states");
                String[] split = optString.split(",");
                String[] split2 = optString2.split(",");
                if (!(split == null || split2 == null)) {
                    for (i2 = 0; i2 < split.length; i2++) {
                        if (bo.isEqual(str3, split[i2])) {
                            split2[i2] = String.valueOf(i);
                            i2 = 1;
                            break;
                        }
                    }
                }
                i2 = 0;
                iVar = new i();
                if (i2 == 0) {
                    optString = optString + "," + str3;
                    valueOf = optString2 + "," + i;
                } else {
                    optString2 = "";
                    for (String str4 : split2) {
                        optString2 = optString2 + str4 + ",";
                    }
                    valueOf = optString2.substring(0, optString2.length() - 1);
                }
            }
            iVar.g("svrids", optString);
            iVar.g("states", valueOf);
            ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() result:%s", str3, Integer.valueOf(i), iVar.toString());
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, iVar.toString());
        } catch (Exception e) {
            ab.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() Exception:%s", e.getMessage());
        }
        cO(this.username, this.status);
        AppMethodBeat.o(23290);
        return true;
    }

    private static void cO(String str, int i) {
        AppMethodBeat.i(23291);
        g.RQ();
        String str2 = (String) g.RP().Ry().get(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, (Object) "");
        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() username:%s state:%s ", str, Integer.valueOf(i));
        try {
            i iVar;
            Object valueOf;
            Object optString;
            if (bo.isNullOrNil(str2)) {
                iVar = new i();
                valueOf = String.valueOf(i);
                String optString2 = str;
            } else {
                int i2;
                iVar = new i(str2);
                optString2 = iVar.optString("usernames");
                String optString3 = iVar.optString("states");
                String[] split = optString2.split(",");
                String[] split2 = optString3.split(",");
                if (!(split == null || split2 == null)) {
                    for (i2 = 0; i2 < split.length; i2++) {
                        if (bo.isEqual(str, split[i2])) {
                            split2[i2] = String.valueOf(i);
                            i2 = 1;
                            break;
                        }
                    }
                }
                i2 = 0;
                iVar = new i();
                if (i2 == 0) {
                    optString2 = optString2 + "," + str;
                    valueOf = optString3 + "," + i;
                } else {
                    optString3 = "";
                    for (String str3 : split2) {
                        optString3 = optString3 + str3 + ",";
                    }
                    valueOf = optString3.substring(0, optString3.length() - 1);
                }
            }
            iVar.g("usernames", optString2);
            iVar.g("states", valueOf);
            ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() result:%s", str, Integer.valueOf(i), iVar.toString());
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, iVar.toString());
            AppMethodBeat.o(23291);
        } catch (Exception e) {
            ab.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() Exception:%s", e.getMessage());
            AppMethodBeat.o(23291);
        }
    }

    public static int UL(String str) {
        AppMethodBeat.i(23292);
        g.RQ();
        String str2 = (String) g.RP().Ry().get(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, (Object) "");
        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() climsgid:%s", str);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(23292);
            return 1;
        }
        try {
            i iVar = new i(str2);
            str2 = iVar.optString("svrids");
            String optString = iVar.optString("states");
            String[] split = str2.split(",");
            String[] split2 = optString.split(",");
            if (split == null || split2 == null) {
                AppMethodBeat.o(23292);
                return 1;
            }
            for (int i = 0; i < split.length; i++) {
                if (bo.isEqual(str, split[i])) {
                    try {
                        i = Integer.valueOf(split2[i]).intValue();
                    } catch (NumberFormatException e) {
                        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", e.getMessage());
                        i = 0;
                    }
                    AppMethodBeat.o(23292);
                    return i;
                }
            }
            AppMethodBeat.o(23292);
            return 1;
        } catch (Exception e2) {
            ab.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", e2.getMessage());
            AppMethodBeat.o(23292);
            return 1;
        }
    }

    public static boolean UM(String str) {
        AppMethodBeat.i(23293);
        g.RQ();
        String str2 = (String) g.RP().Ry().get(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, (Object) "");
        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() username:%s", str);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(23293);
            return false;
        }
        try {
            i iVar = new i(str2);
            str2 = iVar.optString("usernames");
            String optString = iVar.optString("states");
            String[] split = str2.split(",");
            String[] split2 = optString.split(",");
            if (split == null || split2 == null) {
                AppMethodBeat.o(23293);
                return false;
            }
            for (int i = 0; i < split.length; i++) {
                if (bo.isEqual(str, split[i])) {
                    int intValue;
                    try {
                        intValue = Integer.valueOf(split2[i]).intValue();
                    } catch (NumberFormatException e) {
                        ab.i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", e.getMessage());
                        intValue = 0;
                    }
                    if (bo.gW(intValue, 2) || bo.gW(intValue, 3)) {
                        AppMethodBeat.o(23293);
                        return true;
                    } else if (bo.gW(intValue, 1)) {
                        AppMethodBeat.o(23293);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(23293);
            return false;
        } catch (Exception e2) {
            ab.e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", e2.getMessage());
            AppMethodBeat.o(23293);
            return false;
        }
    }
}
