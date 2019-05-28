package com.tencent.mm.plugin.ipcall.b;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

public final class a {
    public static int nGS = 3;
    public static String nGT = "+";
    public static String nGU = "00";
    public static String nGV = null;
    private static av nGW = new av();
    private static HashMap<String, b> nGX = new HashMap();
    private static HashMap<String, String> nGY = new HashMap();
    private static HashMap<String, String> nGZ = new HashMap();
    private static HashMap<String, String> nHa = new HashMap();
    private static HashMap<String, String> nHb = new HashMap();

    static class a implements Comparator<String> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(22439);
            int length = ((String) obj).length() - ((String) obj2).length();
            AppMethodBeat.o(22439);
            return length;
        }
    }

    static {
        AppMethodBeat.i(22466);
        AppMethodBeat.o(22466);
    }

    public static String aE(Context context, String str) {
        String str2 = null;
        AppMethodBeat.i(22440);
        if (b.o(context, "android.permission.READ_CONTACTS")) {
            Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, new String[]{"contact_id", "data1"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (!query.isAfterLast()) {
                            if (PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.a.ws(str), query.getString(1))) {
                                str2 = query.getString(0);
                                break;
                            }
                            query.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    ab.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(22440);
                }
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(22440);
        } else {
            ab.e("MicroMsg.IPCallAddressUtil", "no contact permission");
            AppMethodBeat.o(22440);
        }
        return str2;
    }

    public static String aF(Context context, String str) {
        AppMethodBeat.i(22441);
        String aE = aE(context, str);
        if (bo.isNullOrNil(aE)) {
            AppMethodBeat.o(22441);
            return null;
        }
        aE = com.tencent.mm.pluginsdk.a.i(aE, context);
        AppMethodBeat.o(22441);
        return aE;
    }

    public static String aG(Context context, String str) {
        AppMethodBeat.i(22442);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22442);
            return null;
        }
        String i = com.tencent.mm.pluginsdk.a.i(str, context);
        AppMethodBeat.o(22442);
        return i;
    }

    public static Bitmap aH(Context context, String str) {
        AppMethodBeat.i(22443);
        Bitmap g = g(context, str, false);
        AppMethodBeat.o(22443);
        return g;
    }

    public static Bitmap g(Context context, String str, boolean z) {
        AppMethodBeat.i(22444);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22444);
            return null;
        }
        Bitmap a = com.tencent.mm.pluginsdk.a.a(str, context, z);
        AppMethodBeat.o(22444);
        return a;
    }

    public static Bitmap aI(Context context, String str) {
        AppMethodBeat.i(22445);
        String aE = aE(context, str);
        Bitmap bitmap = null;
        if (!bo.isNullOrNil(aE)) {
            bitmap = g(context, aE, true);
        }
        if (bitmap == null && apV()) {
            aE = Pn(str);
            ab.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", aE);
            if (!bo.isNullOrNil(aE)) {
                bitmap = com.tencent.mm.ah.b.d(aE, 320, 320, 4);
            }
        }
        AppMethodBeat.o(22445);
        return bitmap;
    }

    public static String Pn(String str) {
        AppMethodBeat.i(22446);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22446);
            return null;
        }
        String vY = com.tencent.mm.plugin.account.a.getAddrUploadStg().vY(g.x(c.PA(str).getBytes()));
        AppMethodBeat.o(22446);
        return vY;
    }

    public static String Po(String str) {
        AppMethodBeat.i(22447);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22447);
            return null;
        }
        String vZ = com.tencent.mm.plugin.account.a.getAddrUploadStg().vZ(str);
        AppMethodBeat.o(22447);
        return vZ;
    }

    public static String xx(int i) {
        AppMethodBeat.i(22448);
        Context context = ah.getContext();
        String string;
        switch (i) {
            case 1:
                string = context.getString(R.string.dce);
                AppMethodBeat.o(22448);
                return string;
            case 2:
                string = context.getString(R.string.dcg);
                AppMethodBeat.o(22448);
                return string;
            case 4:
                string = context.getString(R.string.dcd);
                AppMethodBeat.o(22448);
                return string;
            case 5:
                string = context.getString(R.string.dcf);
                AppMethodBeat.o(22448);
                return string;
            case 10:
                string = context.getString(R.string.dcc);
                AppMethodBeat.o(22448);
                return string;
            default:
                string = context.getString(R.string.dch);
                AppMethodBeat.o(22448);
                return string;
        }
    }

    public static HashMap<String, b> bIM() {
        AppMethodBeat.i(22450);
        if (nGX.size() == 0) {
            bIL();
        }
        HashMap hashMap = nGX;
        AppMethodBeat.o(22450);
        return hashMap;
    }

    public static String Pp(String str) {
        AppMethodBeat.i(22451);
        if (nGX.size() == 0) {
            bIL();
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22451);
            return null;
        }
        b bVar = (b) nGX.get(str);
        if (bVar != null) {
            String str2 = bVar.nHe;
            AppMethodBeat.o(22451);
            return str2;
        }
        AppMethodBeat.o(22451);
        return null;
    }

    public static String Pq(String str) {
        AppMethodBeat.i(22452);
        if (nGY.size() == 0) {
            bIL();
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22452);
            return null;
        }
        String str2 = (String) nGY.get(str);
        AppMethodBeat.o(22452);
        return str2;
    }

    public static String Pr(String str) {
        AppMethodBeat.i(22453);
        if (nHa.size() == 0) {
            bIL();
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22453);
            return null;
        }
        String str2 = (String) nHa.get(str);
        AppMethodBeat.o(22453);
        return str2;
    }

    public static int eO(String str, String str2) {
        AppMethodBeat.i(22454);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(22454);
            return -1;
        }
        int eP = eP(str, str2);
        if (eP == -1 && str2.startsWith("+")) {
            String Ps = Ps(str2);
            if (!bo.isNullOrNil(Ps)) {
                str2 = str2.substring("+".concat(String.valueOf(Ps)).length());
            }
            eP = eP(str, str2);
        }
        AppMethodBeat.o(22454);
        return eP;
    }

    private static int eP(String str, String str2) {
        AppMethodBeat.i(22455);
        if (b.o(ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            String PA = c.PA(str2);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        int i = query.getInt(query.getColumnIndex("data2"));
                        if (c.PA(query.getString(query.getColumnIndex("data1"))).equals(PA)) {
                            query.close();
                            AppMethodBeat.o(22455);
                            return i;
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                ab.e("MicroMsg.IPCallAddressUtil", "getPhoneTypeByContactIdAndPhoneNumber error: %s", e.getMessage());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.o(22455);
            }
            AppMethodBeat.o(22455);
            return -1;
        }
        ab.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        AppMethodBeat.o(22455);
        return -1;
    }

    public static String Ps(String str) {
        AppMethodBeat.i(22456);
        if (nGY.size() == 0) {
            bIL();
        }
        if (Pu(str)) {
            String PA = c.PA(Pv(str));
            ArrayList<String> arrayList = new ArrayList(nGY.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new a()));
            for (String str2 : arrayList) {
                if (PA.startsWith(str2)) {
                    AppMethodBeat.o(22456);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(22456);
        return null;
    }

    public static boolean Pt(String str) {
        AppMethodBeat.i(22457);
        if (nGY.size() == 0) {
            bIL();
        }
        if (nGY.containsKey(str)) {
            AppMethodBeat.o(22457);
            return true;
        }
        AppMethodBeat.o(22457);
        return false;
    }

    public static boolean Pu(String str) {
        AppMethodBeat.i(22458);
        if (bo.isNullOrNil(str) || !(str.startsWith(nGT) || str.startsWith(nGU))) {
            AppMethodBeat.o(22458);
            return false;
        }
        AppMethodBeat.o(22458);
        return true;
    }

    public static String Pv(String str) {
        AppMethodBeat.i(22459);
        if (!bo.isNullOrNil(str)) {
            if (str.startsWith(nGT)) {
                str = str.substring(nGT.length());
                AppMethodBeat.o(22459);
                return str;
            } else if (str.startsWith(nGU)) {
                str = str.substring(nGU.length());
                AppMethodBeat.o(22459);
                return str;
            }
        }
        AppMethodBeat.o(22459);
        return str;
    }

    public static String Pw(String str) {
        AppMethodBeat.i(22460);
        String PA = c.PA(str);
        String PA2 = c.PA(PA);
        String str2 = null;
        if (Pu(PA2)) {
            str2 = Ps(PA2);
        }
        if (bo.isNullOrNil(str2)) {
            str2 = av.amM(PA);
        } else {
            PA = Pv(PA2).substring(str2.length());
            PA2 = av.formatNumber(str2, PA);
            if (!bo.isNullOrNil(PA2)) {
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
        AppMethodBeat.o(22460);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String bIN() {
        AppMethodBeat.i(22461);
        if (nGZ.size() == 0) {
            bIL();
        }
        String gQ = bo.gQ(ah.getContext());
        if (!bo.isNullOrNil(gQ)) {
            ab.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", gQ);
            gQ = (String) nHb.get(gQ.toUpperCase());
            if (!bo.isNullOrNil(gQ)) {
                ab.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", gQ);
                if (bo.isNullOrNil(gQ)) {
                    AppMethodBeat.o(22461);
                    return gQ;
                }
                gQ = bp.aao().countryCode;
                ab.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", gQ);
                if (!bo.isNullOrNil(gQ)) {
                    gQ = (String) nHb.get(gQ);
                    if (!bo.isNullOrNil(gQ)) {
                        ab.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", gQ);
                        AppMethodBeat.o(22461);
                        return gQ;
                    }
                }
                ab.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", ah.getContext().getString(R.string.b3a));
                gQ = gQ.replace("+", "");
                AppMethodBeat.o(22461);
                return gQ;
            }
        }
        gQ = "";
        if (bo.isNullOrNil(gQ)) {
        }
    }

    public static void bIO() {
        AppMethodBeat.i(22462);
        bIL();
        AppMethodBeat.o(22462);
    }

    public static String Px(String str) {
        AppMethodBeat.i(22463);
        if (nGY.size() == 0) {
            bIL();
        }
        if (Pu(str)) {
            str = c.PA(Pv(str));
            ArrayList<String> arrayList = new ArrayList(nGY.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new a()));
            for (String str2 : arrayList) {
                if (str.startsWith(str2)) {
                    str = str.substring(str2.length());
                    AppMethodBeat.o(22463);
                    return str;
                }
            }
        }
        AppMethodBeat.o(22463);
        return str;
    }

    public static boolean apV() {
        AppMethodBeat.i(22464);
        aw awVar = new aw();
        com.tencent.mm.sdk.b.a.xxA.m(awVar);
        ab.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", Boolean.valueOf(awVar.ctZ.csN));
        boolean z = awVar.ctZ.csN;
        AppMethodBeat.o(22464);
        return z;
    }

    public static ArrayList<String> Py(String str) {
        AppMethodBeat.i(22465);
        ArrayList<String> arrayList = new ArrayList();
        if (b.o(ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
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
                ab.e("MicroMsg.IPCallAddressUtil", "getQueryPhoneNumberContactIdList error: %s", e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(22465);
            }
            AppMethodBeat.o(22465);
            return arrayList;
        }
        ab.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        AppMethodBeat.o(22465);
        return arrayList;
    }

    private static void bIL() {
        String str;
        AppMethodBeat.i(22449);
        nGY.clear();
        nGZ.clear();
        nHa.clear();
        nHb.clear();
        nGX.clear();
        InputStream inputStream = null;
        String str2 = "";
        try {
            inputStream = ah.getContext().getAssets().open("ipcall_country_code.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", bo.l(e));
                }
            }
        } catch (IOException e2) {
            ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", bo.l(e2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str = str2;
                } catch (IOException e22) {
                    ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", bo.l(e22));
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
                    ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", bo.l(e3));
                }
            }
            AppMethodBeat.o(22449);
        }
        String[] split = str.trim().split(IOUtils.LINE_SEPARATOR_UNIX);
        for (String str3 : split) {
            String[] split2 = str3.trim().split(" ");
            if (split2.length < 2) {
                ab.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", split[r1]);
            } else {
                b bVar = new b();
                bVar.nHc = split2[0];
                bVar.nHd = split2[1];
                RegionCodeDecoder.duj();
                str3 = RegionCodeDecoder.getLocName(split2[0]);
                if (bo.isNullOrNil(str3)) {
                    str3 = new Locale("", split2[0]).getDisplayCountry(ah.getResources().getConfiguration().locale);
                }
                bVar.nHe = str3;
                nHa.put(bVar.nHd, bVar.nHc);
                nHb.put(bVar.nHc, bVar.nHd);
                nGY.put(bVar.nHd, bVar.nHe);
                nGZ.put(bVar.nHe, bVar.nHd);
                nGX.put(bVar.nHc, bVar);
            }
        }
        AppMethodBeat.o(22449);
    }
}
