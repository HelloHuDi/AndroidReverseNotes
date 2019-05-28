package com.tencent.p177mm.plugin.ipcall.p1275b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.protocal.protobuf.aqq;
import com.tencent.p177mm.protocal.protobuf.blt;
import com.tencent.p177mm.protocal.protobuf.coj;
import com.tencent.p177mm.protocal.protobuf.cok;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
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

/* renamed from: com.tencent.mm.plugin.ipcall.b.c */
public final class C34382c {

    /* renamed from: com.tencent.mm.plugin.ipcall.b.c$1 */
    public static class C210961 implements OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22467);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(22467);
        }
    }

    /* renamed from: af */
    public static cok m56381af(LinkedList<blt> linkedList) {
        AppMethodBeat.m2504i(22468);
        if (linkedList == null || linkedList.size() <= 0) {
            AppMethodBeat.m2505o(22468);
            return null;
        }
        cok cok = new cok();
        cok.xlZ = linkedList.size();
        cok.xma = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            blt blt = (blt) it.next();
            coj coj = new coj();
            coj.xfs = C34382c.m56379Pz(blt.wCK);
            coj.wOO = blt.wOO;
            cok.xma.add(coj);
        }
        AppMethodBeat.m2505o(22468);
        return cok;
    }

    /* renamed from: Pz */
    private static int m56379Pz(String str) {
        AppMethodBeat.m2504i(22469);
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                for (byte b : address) {
                    i = (i << 8) | (b & 255);
                }
                C4990ab.m7411d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i));
                AppMethodBeat.m2505o(22469);
                return i;
            }
        } catch (UnknownHostException e) {
            C4990ab.printErrStackTrace("MicroMsg.IPCallUtil", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(22469);
        return 0;
    }

    public static int bIP() {
        AppMethodBeat.m2504i(22470);
        Context context = C4996ah.getContext();
        if (C5023at.is2G(context)) {
            AppMethodBeat.m2505o(22470);
            return 1;
        } else if (C5023at.is3G(context)) {
            AppMethodBeat.m2505o(22470);
            return 3;
        } else if (C5023at.is4G(context)) {
            AppMethodBeat.m2505o(22470);
            return 5;
        } else if (C5023at.isWifi(context)) {
            AppMethodBeat.m2505o(22470);
            return 4;
        } else {
            AppMethodBeat.m2505o(22470);
            return 0;
        }
    }

    /* renamed from: PA */
    public static String m56377PA(String str) {
        AppMethodBeat.m2504i(22471);
        String trim = str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
        AppMethodBeat.m2505o(22471);
        return trim;
    }

    /* renamed from: xy */
    public static String m56389xy(int i) {
        AppMethodBeat.m2504i(22472);
        Context context = C4996ah.getContext();
        String string;
        switch (i) {
            case 1:
                string = context.getString(C25738R.string.ci4);
                AppMethodBeat.m2505o(22472);
                return string;
            case 2:
                string = context.getString(C25738R.string.ci4);
                AppMethodBeat.m2505o(22472);
                return string;
            case 6:
                string = context.getString(C25738R.string.ci0);
                AppMethodBeat.m2505o(22472);
                return string;
            case 7:
                string = context.getString(C25738R.string.ci1);
                AppMethodBeat.m2505o(22472);
                return string;
            default:
                string = context.getString(C25738R.string.ci4);
                AppMethodBeat.m2505o(22472);
                return string;
        }
    }

    /* renamed from: i */
    public static CharSequence m56383i(Context context, long j) {
        AppMethodBeat.m2504i(22473);
        CharSequence format = DateFormat.format(context.getString(C25738R.string.bxq), j);
        AppMethodBeat.m2505o(22473);
        return format;
    }

    /* renamed from: aJ */
    public static String m56380aJ(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(22474);
        String[] stringArray = context.getResources().getStringArray(C25738R.array.f12637aq);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (int i2 = i; i2 < stringArray.length; i2++) {
            arrayList.add(stringArray[i2]);
        }
        try {
            i = C5046bo.getInt(str, 0);
        } catch (Exception e) {
        }
        String str2;
        if (i >= arrayList.size()) {
            str2 = "";
            AppMethodBeat.m2505o(22474);
            return str2;
        }
        str2 = (String) arrayList.get(i);
        AppMethodBeat.m2505o(22474);
        return str2;
    }

    /* renamed from: iY */
    public static String m56384iY(long j) {
        AppMethodBeat.m2504i(22475);
        Context context = C4996ah.getContext();
        String format;
        if (C34382c.m56385iZ(j)) {
            format = new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j));
            AppMethodBeat.m2505o(22475);
            return format;
        } else if (C34382c.m56386ja(j)) {
            format = context.getString(C25738R.string.cge);
            AppMethodBeat.m2505o(22475);
            return format;
        } else {
            format = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j));
            AppMethodBeat.m2505o(22475);
            return format;
        }
    }

    /* renamed from: iZ */
    private static boolean m56385iZ(long j) {
        AppMethodBeat.m2504i(22476);
        if (C34382c.m56387jb(j) == 0) {
            AppMethodBeat.m2505o(22476);
            return true;
        }
        AppMethodBeat.m2505o(22476);
        return false;
    }

    /* renamed from: ja */
    private static boolean m56386ja(long j) {
        AppMethodBeat.m2504i(22477);
        if (C34382c.m56387jb(j) == -1) {
            AppMethodBeat.m2505o(22477);
            return true;
        }
        AppMethodBeat.m2505o(22477);
        return false;
    }

    private static long bIQ() {
        AppMethodBeat.m2504i(22478);
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        AppMethodBeat.m2505o(22478);
        return timeInMillis2;
    }

    /* renamed from: jb */
    private static long m56387jb(long j) {
        AppMethodBeat.m2504i(22479);
        long bIQ = C34382c.bIQ();
        bIQ = (j / bIQ) - (Calendar.getInstance().getTimeInMillis() / bIQ);
        AppMethodBeat.m2505o(22479);
        return bIQ;
    }

    /* renamed from: jc */
    public static String m56388jc(long j) {
        AppMethodBeat.m2504i(22480);
        Context context = C4996ah.getContext();
        String string;
        if (((double) j) <= 60.0d) {
            string = context.getString(C25738R.string.cgn, new Object[]{String.valueOf(j)});
            AppMethodBeat.m2505o(22480);
            return string;
        }
        int i = (int) (((double) j) / 60.0d);
        if ((((double) j) / 60.0d) - ((double) i) > 0.0d) {
            i++;
        }
        string = context.getString(C25738R.string.cgm, new Object[]{String.valueOf(i)});
        AppMethodBeat.m2505o(22480);
        return string;
    }

    /* renamed from: eo */
    public static boolean m56382eo(Context context) {
        int i = C25738R.string.cdo;
        AppMethodBeat.m2504i(22481);
        if (C29488d.cLx()) {
            i = C25738R.string.cdq;
        } else if (C29488d.cLy()) {
            i = C25738R.string.cdp;
        } else if (!C17981e.akK()) {
            if (C35973a.m59176Oo()) {
                i = C25738R.string.cdl;
            } else if (!C17981e.akJ()) {
                i = 0;
            }
        }
        if (i == 0) {
            AppMethodBeat.m2505o(22481);
            return true;
        }
        C30379h.m48467g(context, i, C25738R.string.f9238tz);
        AppMethodBeat.m2505o(22481);
        return false;
    }

    /* renamed from: PB */
    public static void m56378PB(String str) {
        AppMethodBeat.m2504i(22482);
        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
        AppMethodBeat.m2505o(22482);
    }

    public static String bIR() {
        AppMethodBeat.m2504i(22483);
        String string = C4996ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (C5046bo.isNullOrNil(string)) {
            string = C46041a.bIN();
            AppMethodBeat.m2505o(22483);
            return string;
        }
        string = string.replace("+", "");
        AppMethodBeat.m2505o(22483);
        return string;
    }

    public static boolean bIS() {
        AppMethodBeat.m2504i(22484);
        if (C26373g.m41964Nu().getInt("WCOSecondPurchaseSwitch", 0) > 0) {
            AppMethodBeat.m2505o(22484);
            return true;
        }
        AppMethodBeat.m2505o(22484);
        return false;
    }

    public static boolean bIT() {
        AppMethodBeat.m2504i(22485);
        if (C26373g.m41964Nu().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0) {
            AppMethodBeat.m2505o(22485);
            return true;
        }
        AppMethodBeat.m2505o(22485);
        return false;
    }

    public static aqq bIU() {
        AppMethodBeat.m2504i(22486);
        C9638aw.m17190ZK();
        Object obj = C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, null);
        if (obj != null) {
            aqq aqq = new aqq();
            try {
                aqq.parseFrom(C5046bo.anf(obj.toString()));
                C4990ab.m7417i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", aqq.wut, aqq.nzz, aqq.Title, aqq.Desc, aqq.wuu, aqq.wuv, aqq.wuw, aqq.wux, aqq.wuE);
                AppMethodBeat.m2505o(22486);
                return aqq;
            } catch (IOException e) {
                C4990ab.m7417i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(22486);
        return null;
    }

    /* renamed from: xz */
    public static String m56390xz(int i) {
        AppMethodBeat.m2504i(22487);
        Context context = C4996ah.getContext();
        String str;
        if ((i & 1) > 0 && (i & 2) <= 0) {
            str = context.getString(C25738R.string.cjx) + " ";
            AppMethodBeat.m2505o(22487);
            return str;
        } else if ((i & 8) > 0) {
            str = context.getString(C25738R.string.cjy) + " ";
            AppMethodBeat.m2505o(22487);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(22487);
            return str;
        }
    }
}
