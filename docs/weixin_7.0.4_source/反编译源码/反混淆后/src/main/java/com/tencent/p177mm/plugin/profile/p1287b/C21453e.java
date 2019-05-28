package com.tencent.p177mm.plugin.profile.p1287b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.profile.b.e */
public final class C21453e extends C1304a {
    public String pkI = null;
    public int status = 0;
    public String username = null;

    public C21453e(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
    }

    public C21453e(Map<String, String> map) {
        super(map);
    }

    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(23290);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] values == null ");
            AppMethodBeat.m2505o(23290);
            return false;
        }
        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type:%s, values size:%s", C5046bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (C5046bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMFriReqAcceptedInWxWork")) {
            C4990ab.m7413e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "[parseXml] type err :%s", C5046bo.nullAsNil(this.TYPE));
            AppMethodBeat.m2505o(23290);
            return false;
        }
        String str = ".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.username";
        String str2 = ".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.climsgid";
        String str3 = ".sysmsg.NewXmlOpenIMFriReqAcceptedInWxWork.status";
        if (this.values.containsKey(str)) {
            this.username = C5046bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.pkI = C5046bo.nullAsNil((String) this.values.get(str2));
        }
        if (this.values.containsKey(str2)) {
            this.status = C5046bo.getInt((String) this.values.get(str3), 0);
        }
        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "username:%s climsgid:%s status:%s", this.username, this.pkI, Integer.valueOf(this.status));
        str3 = this.pkI;
        int i = this.status;
        C1720g.m3537RQ();
        str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, (Object) "");
        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() climsgid:%s state:%s ", str3, Integer.valueOf(i));
        try {
            C41726i c41726i;
            Object valueOf;
            Object optString;
            if (C5046bo.isNullOrNil(str)) {
                c41726i = new C41726i();
                valueOf = String.valueOf(i);
                str2 = str3;
            } else {
                int i2;
                c41726i = new C41726i(str);
                optString = c41726i.optString("svrids");
                String optString2 = c41726i.optString("states");
                String[] split = optString.split(",");
                String[] split2 = optString2.split(",");
                if (!(split == null || split2 == null)) {
                    for (i2 = 0; i2 < split.length; i2++) {
                        if (C5046bo.isEqual(str3, split[i2])) {
                            split2[i2] = String.valueOf(i);
                            i2 = 1;
                            break;
                        }
                    }
                }
                i2 = 0;
                c41726i = new C41726i();
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
            c41726i.mo67475g("svrids", optString);
            c41726i.mo67475g("states", valueOf);
            C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() result:%s", str3, Integer.valueOf(i), c41726i.toString());
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, c41726i.toString());
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactByWework() Exception:%s", e.getMessage());
        }
        C21453e.m32906cO(this.username, this.status);
        AppMethodBeat.m2505o(23290);
        return true;
    }

    /* renamed from: cO */
    private static void m32906cO(String str, int i) {
        AppMethodBeat.m2504i(23291);
        C1720g.m3537RQ();
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, (Object) "");
        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() username:%s state:%s ", str, Integer.valueOf(i));
        try {
            C41726i c41726i;
            Object valueOf;
            Object optString;
            if (C5046bo.isNullOrNil(str2)) {
                c41726i = new C41726i();
                valueOf = String.valueOf(i);
                String optString2 = str;
            } else {
                int i2;
                c41726i = new C41726i(str2);
                optString2 = c41726i.optString("usernames");
                String optString3 = c41726i.optString("states");
                String[] split = optString2.split(",");
                String[] split2 = optString3.split(",");
                if (!(split == null || split2 == null)) {
                    for (i2 = 0; i2 < split.length; i2++) {
                        if (C5046bo.isEqual(str, split[i2])) {
                            split2[i2] = String.valueOf(i);
                            i2 = 1;
                            break;
                        }
                    }
                }
                i2 = 0;
                c41726i = new C41726i();
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
            c41726i.mo67475g("usernames", optString2);
            c41726i.mo67475g("states", valueOf);
            C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() result:%s", str, Integer.valueOf(i), c41726i.toString());
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, c41726i.toString());
            AppMethodBeat.m2505o(23291);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "dealAddContactUsernameByWework() Exception:%s", e.getMessage());
            AppMethodBeat.m2505o(23291);
        }
    }

    /* renamed from: UL */
    public static int m32904UL(String str) {
        AppMethodBeat.m2504i(23292);
        C1720g.m3537RQ();
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_STRING_SYNC, (Object) "");
        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() climsgid:%s", str);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(23292);
            return 1;
        }
        try {
            C41726i c41726i = new C41726i(str2);
            str2 = c41726i.optString("svrids");
            String optString = c41726i.optString("states");
            String[] split = str2.split(",");
            String[] split2 = optString.split(",");
            if (split == null || split2 == null) {
                AppMethodBeat.m2505o(23292);
                return 1;
            }
            for (int i = 0; i < split.length; i++) {
                if (C5046bo.isEqual(str, split[i])) {
                    try {
                        i = Integer.valueOf(split2[i]).intValue();
                    } catch (NumberFormatException e) {
                        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", e.getMessage());
                        i = 0;
                    }
                    AppMethodBeat.m2505o(23292);
                    return i;
                }
            }
            AppMethodBeat.m2505o(23292);
            return 1;
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactByWework() Exception:%s", e2.getMessage());
            AppMethodBeat.m2505o(23292);
            return 1;
        }
    }

    /* renamed from: UM */
    public static boolean m32905UM(String str) {
        AppMethodBeat.m2504i(23293);
        C1720g.m3537RQ();
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_USERNAME_STRING_SYNC, (Object) "");
        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() username:%s", str);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(23293);
            return false;
        }
        try {
            C41726i c41726i = new C41726i(str2);
            str2 = c41726i.optString("usernames");
            String optString = c41726i.optString("states");
            String[] split = str2.split(",");
            String[] split2 = optString.split(",");
            if (split == null || split2 == null) {
                AppMethodBeat.m2505o(23293);
                return false;
            }
            for (int i = 0; i < split.length; i++) {
                if (C5046bo.isEqual(str, split[i])) {
                    int intValue;
                    try {
                        intValue = Integer.valueOf(split2[i]).intValue();
                    } catch (NumberFormatException e) {
                        C4990ab.m7417i("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", e.getMessage());
                        intValue = 0;
                    }
                    if (C5046bo.m7563gW(intValue, 2) || C5046bo.m7563gW(intValue, 3)) {
                        AppMethodBeat.m2505o(23293);
                        return true;
                    } else if (C5046bo.m7563gW(intValue, 1)) {
                        AppMethodBeat.m2505o(23293);
                        return false;
                    }
                }
            }
            AppMethodBeat.m2505o(23293);
            return false;
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.OpenIMFriReqAcceptedInWxWorkMsg", "getStateAddContactUsernameByWework() Exception:%s", e2.getMessage());
            AppMethodBeat.m2505o(23293);
            return false;
        }
    }
}
