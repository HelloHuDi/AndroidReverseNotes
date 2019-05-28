package com.tencent.p177mm.plugin.ipcall.p1275b;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p230g.p231a.C18226aw;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.ipcall.b.a */
public final class C46041a {
    public static int nGS = 3;
    public static String nGT = "+";
    public static String nGU = "00";
    public static String nGV = null;
    private static C5025av nGW = new C5025av();
    private static HashMap<String, C34381b> nGX = new HashMap();
    private static HashMap<String, String> nGY = new HashMap();
    private static HashMap<String, String> nGZ = new HashMap();
    private static HashMap<String, String> nHa = new HashMap();
    private static HashMap<String, String> nHb = new HashMap();

    /* renamed from: com.tencent.mm.plugin.ipcall.b.a$a */
    static class C34380a implements Comparator<String> {
        private C34380a() {
        }

        /* synthetic */ C34380a(byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(22439);
            int length = ((String) obj).length() - ((String) obj2).length();
            AppMethodBeat.m2505o(22439);
            return length;
        }
    }

    static {
        AppMethodBeat.m2504i(22466);
        AppMethodBeat.m2505o(22466);
    }

    /* renamed from: aE */
    public static String m85640aE(Context context, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(22440);
        if (C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
            Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, new String[]{"contact_id", "data1"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (!query.isAfterLast()) {
                            if (PhoneNumberUtils.compare(C46482a.m87698ws(str), query.getString(1))) {
                                str2 = query.getString(0);
                                break;
                            }
                            query.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7411d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(22440);
                }
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(22440);
        } else {
            C4990ab.m7412e("MicroMsg.IPCallAddressUtil", "no contact permission");
            AppMethodBeat.m2505o(22440);
        }
        return str2;
    }

    /* renamed from: aF */
    public static String m85641aF(Context context, String str) {
        AppMethodBeat.m2504i(22441);
        String aE = C46041a.m85640aE(context, str);
        if (C5046bo.isNullOrNil(aE)) {
            AppMethodBeat.m2505o(22441);
            return null;
        }
        aE = C46482a.m87697i(aE, context);
        AppMethodBeat.m2505o(22441);
        return aE;
    }

    /* renamed from: aG */
    public static String m85642aG(Context context, String str) {
        AppMethodBeat.m2504i(22442);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22442);
            return null;
        }
        String i = C46482a.m87697i(str, context);
        AppMethodBeat.m2505o(22442);
        return i;
    }

    /* renamed from: aH */
    public static Bitmap m85643aH(Context context, String str) {
        AppMethodBeat.m2504i(22443);
        Bitmap g = C46041a.m85647g(context, str, false);
        AppMethodBeat.m2505o(22443);
        return g;
    }

    /* renamed from: g */
    public static Bitmap m85647g(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(22444);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22444);
            return null;
        }
        Bitmap a = C46482a.m87690a(str, context, z);
        AppMethodBeat.m2505o(22444);
        return a;
    }

    /* renamed from: aI */
    public static Bitmap m85644aI(Context context, String str) {
        AppMethodBeat.m2504i(22445);
        String aE = C46041a.m85640aE(context, str);
        Bitmap bitmap = null;
        if (!C5046bo.isNullOrNil(aE)) {
            bitmap = C46041a.m85647g(context, aE, true);
        }
        if (bitmap == null && C46041a.apV()) {
            aE = C46041a.m85628Pn(str);
            C4990ab.m7411d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", aE);
            if (!C5046bo.isNullOrNil(aE)) {
                bitmap = C41730b.m73493d(aE, 320, 320, 4);
            }
        }
        AppMethodBeat.m2505o(22445);
        return bitmap;
    }

    /* renamed from: Pn */
    public static String m85628Pn(String str) {
        AppMethodBeat.m2504i(22446);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22446);
            return null;
        }
        String vY = C32923a.getAddrUploadStg().mo34094vY(C1178g.m2591x(C34382c.m56377PA(str).getBytes()));
        AppMethodBeat.m2505o(22446);
        return vY;
    }

    /* renamed from: Po */
    public static String m85629Po(String str) {
        AppMethodBeat.m2504i(22447);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22447);
            return null;
        }
        String vZ = C32923a.getAddrUploadStg().mo34095vZ(str);
        AppMethodBeat.m2505o(22447);
        return vZ;
    }

    /* renamed from: xx */
    public static String m85648xx(int i) {
        AppMethodBeat.m2504i(22448);
        Context context = C4996ah.getContext();
        String string;
        switch (i) {
            case 1:
                string = context.getString(C25738R.string.dce);
                AppMethodBeat.m2505o(22448);
                return string;
            case 2:
                string = context.getString(C25738R.string.dcg);
                AppMethodBeat.m2505o(22448);
                return string;
            case 4:
                string = context.getString(C25738R.string.dcd);
                AppMethodBeat.m2505o(22448);
                return string;
            case 5:
                string = context.getString(C25738R.string.dcf);
                AppMethodBeat.m2505o(22448);
                return string;
            case 10:
                string = context.getString(C25738R.string.dcc);
                AppMethodBeat.m2505o(22448);
                return string;
            default:
                string = context.getString(C25738R.string.dch);
                AppMethodBeat.m2505o(22448);
                return string;
        }
    }

    public static HashMap<String, C34381b> bIM() {
        AppMethodBeat.m2504i(22450);
        if (nGX.size() == 0) {
            C46041a.bIL();
        }
        HashMap hashMap = nGX;
        AppMethodBeat.m2505o(22450);
        return hashMap;
    }

    /* renamed from: Pp */
    public static String m85630Pp(String str) {
        AppMethodBeat.m2504i(22451);
        if (nGX.size() == 0) {
            C46041a.bIL();
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22451);
            return null;
        }
        C34381b c34381b = (C34381b) nGX.get(str);
        if (c34381b != null) {
            String str2 = c34381b.nHe;
            AppMethodBeat.m2505o(22451);
            return str2;
        }
        AppMethodBeat.m2505o(22451);
        return null;
    }

    /* renamed from: Pq */
    public static String m85631Pq(String str) {
        AppMethodBeat.m2504i(22452);
        if (nGY.size() == 0) {
            C46041a.bIL();
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22452);
            return null;
        }
        String str2 = (String) nGY.get(str);
        AppMethodBeat.m2505o(22452);
        return str2;
    }

    /* renamed from: Pr */
    public static String m85632Pr(String str) {
        AppMethodBeat.m2504i(22453);
        if (nHa.size() == 0) {
            C46041a.bIL();
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22453);
            return null;
        }
        String str2 = (String) nHa.get(str);
        AppMethodBeat.m2505o(22453);
        return str2;
    }

    /* renamed from: eO */
    public static int m85645eO(String str, String str2) {
        AppMethodBeat.m2504i(22454);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(22454);
            return -1;
        }
        int eP = C46041a.m85646eP(str, str2);
        if (eP == -1 && str2.startsWith("+")) {
            String Ps = C46041a.m85633Ps(str2);
            if (!C5046bo.isNullOrNil(Ps)) {
                str2 = str2.substring("+".concat(String.valueOf(Ps)).length());
            }
            eP = C46041a.m85646eP(str, str2);
        }
        AppMethodBeat.m2505o(22454);
        return eP;
    }

    /* renamed from: eP */
    private static int m85646eP(String str, String str2) {
        AppMethodBeat.m2504i(22455);
        if (C35805b.m58714o(C4996ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = C4996ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            String PA = C34382c.m56377PA(str2);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        int i = query.getInt(query.getColumnIndex("data2"));
                        if (C34382c.m56377PA(query.getString(query.getColumnIndex("data1"))).equals(PA)) {
                            query.close();
                            AppMethodBeat.m2505o(22455);
                            return i;
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallAddressUtil", "getPhoneTypeByContactIdAndPhoneNumber error: %s", e.getMessage());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.m2505o(22455);
            }
            AppMethodBeat.m2505o(22455);
            return -1;
        }
        C4990ab.m7412e("MicroMsg.IPCallAddressUtil", "no contact permission");
        AppMethodBeat.m2505o(22455);
        return -1;
    }

    /* renamed from: Ps */
    public static String m85633Ps(String str) {
        AppMethodBeat.m2504i(22456);
        if (nGY.size() == 0) {
            C46041a.bIL();
        }
        if (C46041a.m85635Pu(str)) {
            String PA = C34382c.m56377PA(C46041a.m85636Pv(str));
            ArrayList<String> arrayList = new ArrayList(nGY.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new C34380a()));
            for (String str2 : arrayList) {
                if (PA.startsWith(str2)) {
                    AppMethodBeat.m2505o(22456);
                    return str2;
                }
            }
        }
        AppMethodBeat.m2505o(22456);
        return null;
    }

    /* renamed from: Pt */
    public static boolean m85634Pt(String str) {
        AppMethodBeat.m2504i(22457);
        if (nGY.size() == 0) {
            C46041a.bIL();
        }
        if (nGY.containsKey(str)) {
            AppMethodBeat.m2505o(22457);
            return true;
        }
        AppMethodBeat.m2505o(22457);
        return false;
    }

    /* renamed from: Pu */
    public static boolean m85635Pu(String str) {
        AppMethodBeat.m2504i(22458);
        if (C5046bo.isNullOrNil(str) || !(str.startsWith(nGT) || str.startsWith(nGU))) {
            AppMethodBeat.m2505o(22458);
            return false;
        }
        AppMethodBeat.m2505o(22458);
        return true;
    }

    /* renamed from: Pv */
    public static String m85636Pv(String str) {
        AppMethodBeat.m2504i(22459);
        if (!C5046bo.isNullOrNil(str)) {
            if (str.startsWith(nGT)) {
                str = str.substring(nGT.length());
                AppMethodBeat.m2505o(22459);
                return str;
            } else if (str.startsWith(nGU)) {
                str = str.substring(nGU.length());
                AppMethodBeat.m2505o(22459);
                return str;
            }
        }
        AppMethodBeat.m2505o(22459);
        return str;
    }

    /* renamed from: Pw */
    public static String m85637Pw(String str) {
        AppMethodBeat.m2504i(22460);
        String PA = C34382c.m56377PA(str);
        String PA2 = C34382c.m56377PA(PA);
        String str2 = null;
        if (C46041a.m85635Pu(PA2)) {
            str2 = C46041a.m85633Ps(PA2);
        }
        if (C5046bo.isNullOrNil(str2)) {
            str2 = C5025av.amM(PA);
        } else {
            PA = C46041a.m85636Pv(PA2).substring(str2.length());
            PA2 = C5025av.formatNumber(str2, PA);
            if (!C5046bo.isNullOrNil(PA2)) {
                PA = PA2;
            }
            if (PA.startsWith("+")) {
                str2 = "+" + str2 + " " + PA.replace("+", "");
            } else {
                str2 = "+" + str2 + " " + PA;
            }
        }
        if (str2.length() > 25) {
            str2 = str2.substring(0, 25) + "...";
        }
        AppMethodBeat.m2505o(22460);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String bIN() {
        AppMethodBeat.m2504i(22461);
        if (nGZ.size() == 0) {
            C46041a.bIL();
        }
        String gQ = C5046bo.m7555gQ(C4996ah.getContext());
        if (!C5046bo.isNullOrNil(gQ)) {
            C4990ab.m7417i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", gQ);
            gQ = (String) nHb.get(gQ.toUpperCase());
            if (!C5046bo.isNullOrNil(gQ)) {
                C4990ab.m7417i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", gQ);
                if (C5046bo.isNullOrNil(gQ)) {
                    AppMethodBeat.m2505o(22461);
                    return gQ;
                }
                gQ = C32782bp.aao().countryCode;
                C4990ab.m7417i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", gQ);
                if (!C5046bo.isNullOrNil(gQ)) {
                    gQ = (String) nHb.get(gQ);
                    if (!C5046bo.isNullOrNil(gQ)) {
                        C4990ab.m7417i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", gQ);
                        AppMethodBeat.m2505o(22461);
                        return gQ;
                    }
                }
                C4990ab.m7417i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", C4996ah.getContext().getString(C25738R.string.b3a));
                gQ = gQ.replace("+", "");
                AppMethodBeat.m2505o(22461);
                return gQ;
            }
        }
        gQ = "";
        if (C5046bo.isNullOrNil(gQ)) {
        }
    }

    public static void bIO() {
        AppMethodBeat.m2504i(22462);
        C46041a.bIL();
        AppMethodBeat.m2505o(22462);
    }

    /* renamed from: Px */
    public static String m85638Px(String str) {
        AppMethodBeat.m2504i(22463);
        if (nGY.size() == 0) {
            C46041a.bIL();
        }
        if (C46041a.m85635Pu(str)) {
            str = C34382c.m56377PA(C46041a.m85636Pv(str));
            ArrayList<String> arrayList = new ArrayList(nGY.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new C34380a()));
            for (String str2 : arrayList) {
                if (str.startsWith(str2)) {
                    str = str.substring(str2.length());
                    AppMethodBeat.m2505o(22463);
                    return str;
                }
            }
        }
        AppMethodBeat.m2505o(22463);
        return str;
    }

    public static boolean apV() {
        AppMethodBeat.m2504i(22464);
        C18226aw c18226aw = new C18226aw();
        C4879a.xxA.mo10055m(c18226aw);
        C4990ab.m7411d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", Boolean.valueOf(c18226aw.ctZ.csN));
        boolean z = c18226aw.ctZ.csN;
        AppMethodBeat.m2505o(22464);
        return z;
    }

    /* renamed from: Py */
    public static ArrayList<String> m85639Py(String str) {
        AppMethodBeat.m2504i(22465);
        ArrayList<String> arrayList = new ArrayList();
        if (C35805b.m58714o(C4996ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = C4996ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("contact_id")));
                        query.moveToNext();
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallAddressUtil", "getQueryPhoneNumberContactIdList error: %s", e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(22465);
            }
            AppMethodBeat.m2505o(22465);
            return arrayList;
        }
        C4990ab.m7412e("MicroMsg.IPCallAddressUtil", "no contact permission");
        AppMethodBeat.m2505o(22465);
        return arrayList;
    }

    private static void bIL() {
        String str;
        AppMethodBeat.m2504i(22449);
        nGY.clear();
        nGZ.clear();
        nHa.clear();
        nHb.clear();
        nGX.clear();
        InputStream inputStream = null;
        String str2 = "";
        try {
            inputStream = C4996ah.getContext().getAssets().open("ipcall_country_code.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.IPCallAddressUtil", "exception:%s", C5046bo.m7574l(e));
                }
            }
        } catch (IOException e2) {
            C4990ab.m7413e("MicroMsg.IPCallAddressUtil", "exception:%s", C5046bo.m7574l(e2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str = str2;
                } catch (IOException e22) {
                    C4990ab.m7413e("MicroMsg.IPCallAddressUtil", "exception:%s", C5046bo.m7574l(e22));
                    str = str2;
                }
            } else {
                str = str2;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C4990ab.m7413e("MicroMsg.IPCallAddressUtil", "exception:%s", C5046bo.m7574l(e3));
                }
            }
            AppMethodBeat.m2505o(22449);
        }
        String[] split = str.trim().split(IOUtils.LINE_SEPARATOR_UNIX);
        for (String str3 : split) {
            String[] split2 = str3.trim().split(" ");
            if (split2.length < 2) {
                C4990ab.m7413e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", split[r1]);
            } else {
                C34381b c34381b = new C34381b();
                c34381b.nHc = split2[0];
                c34381b.nHd = split2[1];
                RegionCodeDecoder.duj();
                str3 = RegionCodeDecoder.getLocName(split2[0]);
                if (C5046bo.isNullOrNil(str3)) {
                    str3 = new Locale("", split2[0]).getDisplayCountry(C4996ah.getResources().getConfiguration().locale);
                }
                c34381b.nHe = str3;
                nHa.put(c34381b.nHd, c34381b.nHc);
                nHb.put(c34381b.nHc, c34381b.nHd);
                nGY.put(c34381b.nHd, c34381b.nHe);
                nGZ.put(c34381b.nHe, c34381b.nHd);
                nGX.put(c34381b.nHc, c34381b);
            }
        }
        AppMethodBeat.m2505o(22449);
    }
}
