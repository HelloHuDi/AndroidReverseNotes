package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bg.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class c {
    public static cok af(LinkedList<blt> linkedList) {
        AppMethodBeat.i(22468);
        if (linkedList == null || linkedList.size() <= 0) {
            AppMethodBeat.o(22468);
            return null;
        }
        cok cok = new cok();
        cok.xlZ = linkedList.size();
        cok.xma = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            blt blt = (blt) it.next();
            coj coj = new coj();
            coj.xfs = Pz(blt.wCK);
            coj.wOO = blt.wOO;
            cok.xma.add(coj);
        }
        AppMethodBeat.o(22468);
        return cok;
    }

    private static int Pz(String str) {
        AppMethodBeat.i(22469);
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                for (byte b : address) {
                    i = (i << 8) | (b & 255);
                }
                ab.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i));
                AppMethodBeat.o(22469);
                return i;
            }
        } catch (UnknownHostException e) {
            ab.printErrStackTrace("MicroMsg.IPCallUtil", e, "", new Object[0]);
        }
        AppMethodBeat.o(22469);
        return 0;
    }

    public static int bIP() {
        AppMethodBeat.i(22470);
        Context context = ah.getContext();
        if (at.is2G(context)) {
            AppMethodBeat.o(22470);
            return 1;
        } else if (at.is3G(context)) {
            AppMethodBeat.o(22470);
            return 3;
        } else if (at.is4G(context)) {
            AppMethodBeat.o(22470);
            return 5;
        } else if (at.isWifi(context)) {
            AppMethodBeat.o(22470);
            return 4;
        } else {
            AppMethodBeat.o(22470);
            return 0;
        }
    }

    public static String PA(String str) {
        AppMethodBeat.i(22471);
        String trim = str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
        AppMethodBeat.o(22471);
        return trim;
    }

    public static String xy(int i) {
        AppMethodBeat.i(22472);
        Context context = ah.getContext();
        String string;
        switch (i) {
            case 1:
                string = context.getString(R.string.ci4);
                AppMethodBeat.o(22472);
                return string;
            case 2:
                string = context.getString(R.string.ci4);
                AppMethodBeat.o(22472);
                return string;
            case 6:
                string = context.getString(R.string.ci0);
                AppMethodBeat.o(22472);
                return string;
            case 7:
                string = context.getString(R.string.ci1);
                AppMethodBeat.o(22472);
                return string;
            default:
                string = context.getString(R.string.ci4);
                AppMethodBeat.o(22472);
                return string;
        }
    }

    public static CharSequence i(Context context, long j) {
        AppMethodBeat.i(22473);
        CharSequence format = DateFormat.format(context.getString(R.string.bxq), j);
        AppMethodBeat.o(22473);
        return format;
    }

    public static String aJ(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(22474);
        String[] stringArray = context.getResources().getStringArray(R.array.aq);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (int i2 = i; i2 < stringArray.length; i2++) {
            arrayList.add(stringArray[i2]);
        }
        try {
            i = bo.getInt(str, 0);
        } catch (Exception e) {
        }
        String str2;
        if (i >= arrayList.size()) {
            str2 = "";
            AppMethodBeat.o(22474);
            return str2;
        }
        str2 = (String) arrayList.get(i);
        AppMethodBeat.o(22474);
        return str2;
    }

    public static String iY(long j) {
        AppMethodBeat.i(22475);
        Context context = ah.getContext();
        String format;
        if (iZ(j)) {
            format = new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j));
            AppMethodBeat.o(22475);
            return format;
        } else if (ja(j)) {
            format = context.getString(R.string.cge);
            AppMethodBeat.o(22475);
            return format;
        } else {
            format = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j));
            AppMethodBeat.o(22475);
            return format;
        }
    }

    private static boolean iZ(long j) {
        AppMethodBeat.i(22476);
        if (jb(j) == 0) {
            AppMethodBeat.o(22476);
            return true;
        }
        AppMethodBeat.o(22476);
        return false;
    }

    private static boolean ja(long j) {
        AppMethodBeat.i(22477);
        if (jb(j) == -1) {
            AppMethodBeat.o(22477);
            return true;
        }
        AppMethodBeat.o(22477);
        return false;
    }

    private static long bIQ() {
        AppMethodBeat.i(22478);
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        AppMethodBeat.o(22478);
        return timeInMillis2;
    }

    private static long jb(long j) {
        AppMethodBeat.i(22479);
        long bIQ = bIQ();
        bIQ = (j / bIQ) - (Calendar.getInstance().getTimeInMillis() / bIQ);
        AppMethodBeat.o(22479);
        return bIQ;
    }

    public static String jc(long j) {
        AppMethodBeat.i(22480);
        Context context = ah.getContext();
        String string;
        if (((double) j) <= 60.0d) {
            string = context.getString(R.string.cgn, new Object[]{String.valueOf(j)});
            AppMethodBeat.o(22480);
            return string;
        }
        int i = (int) (((double) j) / 60.0d);
        if ((((double) j) / 60.0d) - ((double) i) > 0.0d) {
            i++;
        }
        string = context.getString(R.string.cgm, new Object[]{String.valueOf(i)});
        AppMethodBeat.o(22480);
        return string;
    }

    public static boolean eo(Context context) {
        int i = R.string.cdo;
        AppMethodBeat.i(22481);
        if (d.cLx()) {
            i = R.string.cdq;
        } else if (d.cLy()) {
            i = R.string.cdp;
        } else if (!e.akK()) {
            if (a.Oo()) {
                i = R.string.cdl;
            } else if (!e.akJ()) {
                i = 0;
            }
        }
        if (i == 0) {
            AppMethodBeat.o(22481);
            return true;
        }
        h.g(context, i, R.string.tz);
        AppMethodBeat.o(22481);
        return false;
    }

    public static void PB(String str) {
        AppMethodBeat.i(22482);
        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
        AppMethodBeat.o(22482);
    }

    public static String bIR() {
        AppMethodBeat.i(22483);
        String string = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (bo.isNullOrNil(string)) {
            string = a.bIN();
            AppMethodBeat.o(22483);
            return string;
        }
        string = string.replace("+", "");
        AppMethodBeat.o(22483);
        return string;
    }

    public static boolean bIS() {
        AppMethodBeat.i(22484);
        if (g.Nu().getInt("WCOSecondPurchaseSwitch", 0) > 0) {
            AppMethodBeat.o(22484);
            return true;
        }
        AppMethodBeat.o(22484);
        return false;
    }

    public static boolean bIT() {
        AppMethodBeat.i(22485);
        if (g.Nu().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0) {
            AppMethodBeat.o(22485);
            return true;
        }
        AppMethodBeat.o(22485);
        return false;
    }

    public static aqq bIU() {
        AppMethodBeat.i(22486);
        aw.ZK();
        Object obj = com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, null);
        if (obj != null) {
            aqq aqq = new aqq();
            try {
                aqq.parseFrom(bo.anf(obj.toString()));
                ab.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", aqq.wut, aqq.nzz, aqq.Title, aqq.Desc, aqq.wuu, aqq.wuv, aqq.wuw, aqq.wux, aqq.wuE);
                AppMethodBeat.o(22486);
                return aqq;
            } catch (IOException e) {
                ab.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", e.getMessage());
            }
        }
        AppMethodBeat.o(22486);
        return null;
    }

    public static String xz(int i) {
        AppMethodBeat.i(22487);
        Context context = ah.getContext();
        String str;
        if ((i & 1) > 0 && (i & 2) <= 0) {
            str = context.getString(R.string.cjx) + " ";
            AppMethodBeat.o(22487);
            return str;
        } else if ((i & 8) > 0) {
            str = context.getString(R.string.cjy) + " ";
            AppMethodBeat.o(22487);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(22487);
            return str;
        }
    }
}
