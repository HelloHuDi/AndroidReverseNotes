package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.compat.a.a;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class l {
    private static SimpleDateFormat krM = null;
    private static SimpleDateFormat krN = null;
    private static SimpleDateFormat krO = null;

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.i(88883);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                AppMethodBeat.o(88883);
                return true;
            }
        }
        AppMethodBeat.o(88883);
        return false;
    }

    public static int Hn(String str) {
        AppMethodBeat.i(88884);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            ab.e("MicroMsg.CardUtil", "string format error");
            AppMethodBeat.o(88884);
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
                AppMethodBeat.o(88884);
            } catch (Exception e) {
                ab.e("MicroMsg.CardUtil", e.toString());
                AppMethodBeat.o(88884);
            }
        }
        return rgb;
    }

    public static int bS(String str, int i) {
        AppMethodBeat.i(88885);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            ab.e("MicroMsg.CardUtil", "string format error");
            AppMethodBeat.o(88885);
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(i, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
                AppMethodBeat.o(88885);
            } catch (Exception e) {
                ab.e("MicroMsg.CardUtil", e.toString());
                AppMethodBeat.o(88885);
            }
        }
        return rgb;
    }

    public static ShapeDrawable H(Context context, int i) {
        AppMethodBeat.i(88886);
        ShapeDrawable dI = dI(i, context.getResources().getDimensionPixelOffset(R.dimen.va));
        AppMethodBeat.o(88886);
        return dI;
    }

    public static ShapeDrawable dI(int i, int i2) {
        AppMethodBeat.i(88887);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        AppMethodBeat.o(88887);
        return shapeDrawable;
    }

    public static ShapeDrawable b(Context context, int i, int i2) {
        AppMethodBeat.i(88888);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.m7);
        float[] fArr = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStrokeWidth((float) dimensionPixelSize);
        AppMethodBeat.o(88888);
        return shapeDrawable;
    }

    public static List<b> bj(List<op> list) {
        AppMethodBeat.i(88889);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(88889);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            op opVar = (op) list.get(i);
            b bVar = new b();
            bVar.title = opVar.title;
            bVar.kbW = opVar.kbW;
            bVar.kfM = opVar.kfM;
            bVar.url = opVar.url;
            bVar.vUW = opVar.vUW;
            bVar.kch = false;
            bVar.vUX = opVar.vUX;
            bVar.vUY = opVar.vUY;
            bVar.kKZ = opVar.kKZ;
            bVar.vTL = opVar.vTL;
            bVar.vTM = opVar.vTM;
            bVar.kcg = 1;
            arrayList.add(bVar);
        }
        AppMethodBeat.o(88889);
        return arrayList;
    }

    public static String fQ(long j) {
        AppMethodBeat.i(88890);
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (krM == null) {
            krM = new SimpleDateFormat("yyyy.MM.dd");
        }
        String format = krM.format(new Date(j2));
        AppMethodBeat.o(88890);
        return format;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(88891);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(88891);
        return matches;
    }

    public static Bitmap J(Bitmap bitmap) {
        boolean z = true;
        AppMethodBeat.i(88892);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.CardUtil";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        ab.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        AppMethodBeat.o(88892);
        return createBitmap;
    }

    public static void K(Bitmap bitmap) {
        AppMethodBeat.i(88893);
        if (!(bitmap == null || bitmap.isRecycled())) {
            ab.i("MicroMsg.CardUtil", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        AppMethodBeat.o(88893);
    }

    public static boolean b(CardInfo cardInfo) {
        AppMethodBeat.i(88894);
        if (cardInfo == null) {
            ab.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            AppMethodBeat.o(88894);
            return false;
        }
        CardInfo Gu = am.baW().Gu(cardInfo.field_card_id);
        if (Gu == null) {
            boolean b = am.baW().b((c) cardInfo);
            ab.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", Boolean.valueOf(b));
            if (!b) {
                ab.e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            AppMethodBeat.o(88894);
            return b;
        }
        cardInfo.field_stickyIndex = Gu.field_stickyIndex;
        cardInfo.field_stickyEndTime = Gu.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = Gu.field_stickyAnnouncement;
        ab.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", Boolean.valueOf(am.baW().c(cardInfo, new String[0])));
        AppMethodBeat.o(88894);
        return am.baW().c(cardInfo, new String[0]);
    }

    public static void a(com.tencent.mm.plugin.card.base.b bVar, String str, String str2, int i) {
        byte[] ai;
        j.b bVar2 = null;
        AppMethodBeat.i(88895);
        Bitmap a = x.a(new m(bVar.aZV().kbV));
        if (a != null) {
            ai = d.ai(a);
        } else {
            ai = null;
        }
        a aVar = (a) g.K(a.class);
        if (bVar != null) {
            int i2;
            if (i == 23) {
                i = 2;
                i2 = 1;
            } else {
                i2 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            j.b bVar3 = new j.b();
            if (bVar.aZV() != null) {
                bVar3.title = bVar.aZX().wYl;
                bVar3.description = bVar.aZV().title;
                bVar3.type = 16;
                bVar3.showType = 0;
                bVar3.fgr = 3;
                bVar3.appId = bVar.aZV().csB;
                bVar3.ffZ = 0;
                bVar3.thumburl = bVar.aZV().kbV;
                bVar3.fhD = i;
                bVar3.fhC = bVar.aZV().kdg;
                bVar3.url = bVar.aZV().vUc;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<from_username>").append(bVar.bab()).append("</from_username>");
            if (tm(i)) {
                stringBuilder2.append("<card_id>").append(bVar.baa()).append("</card_id>");
            } else if (i == 5) {
                stringBuilder2.append("<card_id>").append(bVar.aZZ()).append("</card_id>");
            }
            stringBuilder2.append("<card_type>").append(bVar.aZV().iAd).append("</card_type>");
            stringBuilder2.append("<from_scene>").append(i).append("</from_scene>");
            stringBuilder2.append("<color>").append(bVar.aZV().color).append("</color>");
            stringBuilder2.append("<card_type_name>").append(bVar.aZV().kdf).append("</card_type_name>");
            stringBuilder2.append("<brand_name>").append(bVar.aZV().kdg).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                stringBuilder2.append("<card_ext></card_ext>");
            } else {
                stringBuilder2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            stringBuilder2.append("<is_recommend>").append(i2).append("</is_recommend>");
            stringBuilder2.append("<recommend_card_id>").append(bVar.aZZ()).append("</recommend_card_id>");
            bVar3.fhB = stringBuilder.append(stringBuilder2.toString()).toString();
            bVar3.cDt = j.b.a(bVar3, null, null);
            bVar2 = bVar3;
        }
        aVar.b(bVar2, bVar.aZV().csB, bVar.aZV().kdg, str, ai);
        AppMethodBeat.o(88895);
    }

    public static void dw(String str, String str2) {
        AppMethodBeat.i(88896);
        if (!bo.isNullOrNil(str)) {
            qb qbVar = new qb();
            qbVar.cMq.cMr = str2;
            qbVar.cMq.content = str;
            qbVar.cMq.type = t.nK(str2);
            qbVar.cMq.flags = 0;
            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
        }
        AppMethodBeat.o(88896);
    }

    public static boolean tm(int i) {
        return i == 0 || i == 1 || i == 2 || i == 9 || i == 12 || i == 17 || i == 21;
    }

    public static boolean tn(int i) {
        return i == 7 || i == 8 || i == 16 || i == 26;
    }

    public static boolean to(int i) {
        return i == 3 || i == 4 || i == 5 || i == 15;
    }

    public static boolean sP(int i) {
        switch (i) {
            case 0:
            case 10:
            case 11:
            case 20:
            case 30:
                return true;
            default:
                return false;
        }
    }

    public static void beB() {
        AppMethodBeat.i(88897);
        Integer num = (Integer) g.RP().Ry().get(282883, null);
        if (num == null || num.intValue() != 1) {
            ab.i("MicroMsg.CardUtil", "open card entrance");
            g.RP().Ry().set(282883, Integer.valueOf(1));
            AppMethodBeat.o(88897);
            return;
        }
        ab.i("MicroMsg.CardUtil", "card entrance is open");
        AppMethodBeat.o(88897);
    }

    public static boolean beC() {
        AppMethodBeat.i(88898);
        Integer num = (Integer) g.RP().Ry().get(282883, null);
        if (num == null || num.intValue() != 1) {
            AppMethodBeat.o(88898);
            return false;
        }
        AppMethodBeat.o(88898);
        return true;
    }

    public static void beD() {
        AppMethodBeat.i(88899);
        Integer num = (Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            ab.i("MicroMsg.CardUtil", "open share card entrance");
            g.RP().Ry().set(ac.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(1));
            AppMethodBeat.o(88899);
            return;
        }
        ab.i("MicroMsg.CardUtil", "share card entrance is open");
        AppMethodBeat.o(88899);
    }

    public static boolean beE() {
        AppMethodBeat.i(88900);
        Integer num = (Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, null);
        if (num == null || num.intValue() != 1) {
            AppMethodBeat.o(88900);
            return false;
        }
        AppMethodBeat.o(88900);
        return true;
    }

    public static String g(Context context, float f) {
        AppMethodBeat.i(88901);
        String str;
        if (f <= 0.0f) {
            str = "";
            AppMethodBeat.o(88901);
            return str;
        } else if (f > 0.0f && f < 1000.0f) {
            str = context.getString(R.string.adm, new Object[]{((int) f)});
            AppMethodBeat.o(88901);
            return str;
        } else if (f >= 1000.0f) {
            Object[] objArr = new Object[1];
            objArr[0] = new DecimalFormat("0.00").format((double) (f / 1000.0f));
            str = context.getString(R.string.adl, objArr);
            AppMethodBeat.o(88901);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(88901);
            return str;
        }
    }

    public static boolean agA() {
        AppMethodBeat.i(88902);
        try {
            boolean isProviderEnabled = ((LocationManager) ah.getContext().getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps");
            AppMethodBeat.o(88902);
            return isProviderEnabled;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            AppMethodBeat.o(88902);
            return false;
        }
    }

    public static boolean agB() {
        AppMethodBeat.i(88903);
        try {
            boolean isProviderEnabled = ((LocationManager) ah.getContext().getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            AppMethodBeat.o(88903);
            return isProviderEnabled;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            AppMethodBeat.o(88903);
            return false;
        }
    }

    public static boolean a(ShareCardInfo shareCardInfo) {
        AppMethodBeat.i(88904);
        if (shareCardInfo == null) {
            ab.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            AppMethodBeat.o(88904);
            return false;
        }
        ShareCardInfo GK = am.bbe().GK(shareCardInfo.field_card_id);
        if (GK == null) {
            boolean b = am.bbe().b((c) shareCardInfo);
            ab.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", Boolean.valueOf(b));
            if (b) {
                com.tencent.mm.plugin.card.sharecard.a.b.m19do(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            } else {
                ab.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            }
            AppMethodBeat.o(88904);
            return b;
        }
        shareCardInfo.field_categoryType = GK.field_categoryType;
        shareCardInfo.field_itemIndex = GK.field_itemIndex;
        ab.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", Boolean.valueOf(am.bbe().c(shareCardInfo, new String[0])));
        AppMethodBeat.o(88904);
        return am.bbe().c(shareCardInfo, new String[0]);
    }

    public static boolean h(com.tencent.mm.plugin.card.base.b bVar) {
        boolean c;
        AppMethodBeat.i(88905);
        if (bVar instanceof CardInfo) {
            c = am.baW().c((CardInfo) bVar, new String[0]);
            if (!c) {
                ab.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.aZZ());
            }
        } else if (bVar instanceof ShareCardInfo) {
            c = am.bbe().c((ShareCardInfo) bVar, new String[0]);
            if (!c) {
                ab.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.aZZ());
            }
        } else {
            c = false;
        }
        AppMethodBeat.o(88905);
        return c;
    }

    public static void Ho(String str) {
        AppMethodBeat.i(88906);
        g.RP().Ry().set(ac.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) str);
        AppMethodBeat.o(88906);
    }

    public static String beF() {
        AppMethodBeat.i(88907);
        String str = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) "");
        AppMethodBeat.o(88907);
        return str;
    }

    public static String Hp(String str) {
        AppMethodBeat.i(88908);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.o(88908);
            return str;
        }
        String mK = s.mK(str);
        String mJ = s.mJ(str);
        if (!TextUtils.isEmpty(mK)) {
            AppMethodBeat.o(88908);
            return mK;
        } else if (TextUtils.isEmpty(mJ)) {
            AppMethodBeat.o(88908);
            return str;
        } else {
            AppMethodBeat.o(88908);
            return mJ;
        }
    }

    public static ArrayList<String> bk(List<String> list) {
        AppMethodBeat.i(88909);
        if (list == null || list.isEmpty()) {
            ab.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            AppMethodBeat.o(88909);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (String PE : list) {
            List PH = com.tencent.mm.plugin.label.a.a.bJa().PH(com.tencent.mm.plugin.label.a.a.bJa().PE(PE));
            if (PH == null || PH.size() == 0) {
                ab.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(PH);
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.o(88909);
        return arrayList;
    }

    public static ArrayList<String> bl(List<String> list) {
        AppMethodBeat.i(88910);
        if (list == null || list.isEmpty()) {
            ab.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            AppMethodBeat.o(88910);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String PE : list) {
            String PE2 = com.tencent.mm.plugin.label.a.a.bJa().PE(PE2);
            if (!TextUtils.isEmpty(PE2)) {
                arrayList.add(PE2);
            }
        }
        AppMethodBeat.o(88910);
        return arrayList;
    }

    public static String Hq(String str) {
        List list;
        String c;
        Object Oj;
        AppMethodBeat.i(88911);
        List<Object> asList = Arrays.asList(str.split(","));
        LinkedList linkedList = new LinkedList();
        if (g.RK()) {
            if (asList == null || asList.size() == 0) {
                list = linkedList;
                c = bo.c(list, ",");
                AppMethodBeat.o(88911);
                return c;
            }
            for (Object Oj2 : asList) {
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(Oj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    Oj2 = aoO.Oj();
                }
                linkedList.add(Oj2);
            }
        }
        Oj2 = linkedList;
        c = bo.c(list, ",");
        AppMethodBeat.o(88911);
        return c;
    }

    public static bzm a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        int i2 = 0;
        AppMethodBeat.i(88912);
        ab.i("MicroMsg.CardUtil", "getShareTag()");
        bzm bzm = new bzm();
        ArrayList arrayList3;
        int i3;
        String str;
        if (i == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                bzm.wYv.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                while (true) {
                    i3 = i2;
                    if (i3 >= arrayList2.size()) {
                        break;
                    }
                    str = (String) arrayList2.get(i3);
                    if (!TextUtils.isEmpty(str) && isNumeric(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                    i2 = i3 + 1;
                }
                bzm.wYx.addAll(arrayList3);
            }
        } else if (i == 3) {
            if (arrayList != null && arrayList.size() > 0) {
                bzm.wYw.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                while (true) {
                    i3 = i2;
                    if (i3 >= arrayList2.size()) {
                        break;
                    }
                    str = (String) arrayList2.get(i3);
                    if (!TextUtils.isEmpty(str) && isNumeric(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                    i2 = i3 + 1;
                }
                bzm.wYy.addAll(arrayList3);
            }
        }
        AppMethodBeat.o(88912);
        return bzm;
    }

    public static boolean a(tm tmVar, String str) {
        AppMethodBeat.i(88913);
        if (!gT(tmVar.vUW)) {
            ab.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
            AppMethodBeat.o(88913);
            return false;
        } else if (Hr(str)) {
            ab.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
            AppMethodBeat.o(88913);
            return false;
        } else {
            ab.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            AppMethodBeat.o(88913);
            return true;
        }
    }

    public static boolean a(b bVar, String str) {
        AppMethodBeat.i(88914);
        if (!gT(bVar.vUW)) {
            ab.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
            AppMethodBeat.o(88914);
            return false;
        } else if (Hr(str)) {
            ab.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
            AppMethodBeat.o(88914);
            return false;
        } else {
            ab.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            AppMethodBeat.o(88914);
            return true;
        }
    }

    private static boolean gT(long j) {
        AppMethodBeat.i(88915);
        if ((8 & j) > 0) {
            ab.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
            AppMethodBeat.o(88915);
            return true;
        }
        AppMethodBeat.o(88915);
        return false;
    }

    private static boolean Hr(String str) {
        AppMethodBeat.i(88916);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            AppMethodBeat.o(88916);
            return true;
        }
        ab.i("MicroMsg.CardUtil", "hasShowWarning()");
        String str2 = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str2)) {
            ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            AppMethodBeat.o(88916);
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            AppMethodBeat.o(88916);
            return false;
        }
        for (Object equals : split) {
            if (str.equals(equals)) {
                AppMethodBeat.o(88916);
                return true;
            }
        }
        AppMethodBeat.o(88916);
        return false;
    }

    public static void Hs(String str) {
        AppMethodBeat.i(88917);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            AppMethodBeat.o(88917);
            return;
        }
        Object str2;
        ab.i("MicroMsg.CardUtil", "setShowWarningFlag()");
        String str3 = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str3)) {
            ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str3.split(",");
            if (split == null || split.length == 0) {
                ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
                str3 = str2;
            }
            Object obj = null;
            for (Object equals : split) {
                if (str2.equals(equals)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                str2 = str3 + "," + str2;
            } else {
                str2 = str3;
            }
        }
        g.RP().Ry().set(ac.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, str2);
        AppMethodBeat.o(88917);
    }

    public static String A(String str, long j) {
        AppMethodBeat.i(88918);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.o(88918);
            return str;
        }
        float f = am.bbc().ect;
        float f2 = am.bbc().ecs;
        if (f == -1000.0f || f2 == -85.0f) {
            ab.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            AppMethodBeat.o(88918);
            return str;
        } else if ((16 & j) > 0) {
            String replace = str.replace("#", ("&longitude=" + f + "&latitude=" + f2) + "#");
            ab.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:".concat(String.valueOf(str)));
            ab.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:".concat(String.valueOf(replace)));
            AppMethodBeat.o(88918);
            return replace;
        } else {
            AppMethodBeat.o(88918);
            return str;
        }
    }

    public static int Ht(String str) {
        AppMethodBeat.i(88919);
        if (TextUtils.isEmpty(str) || str.equals(r.Yz())) {
            AppMethodBeat.o(88919);
            return 0;
        }
        AppMethodBeat.o(88919);
        return 1;
    }

    public static Drawable g(Context context, String str, int i) {
        AppMethodBeat.i(88920);
        ShapeDrawable b = b(context, Hn(str), i);
        ShapeDrawable dI = dI(Hn(str), i);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, dI);
        stateListDrawable.addState(new int[0], b);
        AppMethodBeat.o(88920);
        return stateListDrawable;
    }

    public static ColorStateList ah(Context context, String str) {
        AppMethodBeat.i(88921);
        int[][] iArr = new int[][]{new int[]{16842919, 16842910}, new int[0]};
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{context.getResources().getColor(R.color.a69), Hn(str)});
        AppMethodBeat.o(88921);
        return colorStateList;
    }

    public static int bT(String str, int i) {
        AppMethodBeat.i(88922);
        int dJ = dJ(Color.parseColor(str), i);
        AppMethodBeat.o(88922);
        return dJ;
    }

    public static int dJ(int i, int i2) {
        AppMethodBeat.i(88923);
        if (i2 <= 0) {
            AppMethodBeat.o(88923);
            return i;
        }
        i = com.tencent.mm.ui.ah.dJ(i, i2);
        AppMethodBeat.o(88923);
        return i;
    }

    public static void ai(Context context, String str) {
        AppMethodBeat.i(88924);
        if (bo.isNullOrNil(str)) {
            h.b(context, context.getString(R.string.aih), "", false);
            AppMethodBeat.o(88924);
            return;
        }
        Toast.makeText(ah.getContext(), str, 1).show();
        AppMethodBeat.o(88924);
    }

    public static void aj(Context context, String str) {
        AppMethodBeat.i(88925);
        if (bo.isNullOrNil(str)) {
            str = context.getString(R.string.aih);
        }
        h.b(context, str, "", false);
        AppMethodBeat.o(88925);
    }
}
