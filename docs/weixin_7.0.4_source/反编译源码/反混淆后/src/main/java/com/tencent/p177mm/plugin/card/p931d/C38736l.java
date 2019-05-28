package com.tencent.p177mm.plugin.card.p931d;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.compat.p1477a.C38733a;
import com.tencent.p177mm.plugin.card.model.C11286b;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.protocal.protobuf.C44153op;
import com.tencent.p177mm.protocal.protobuf.bzm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
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

/* renamed from: com.tencent.mm.plugin.card.d.l */
public final class C38736l {
    private static SimpleDateFormat krM = null;
    private static SimpleDateFormat krN = null;
    private static SimpleDateFormat krO = null;

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.m2504i(88883);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                AppMethodBeat.m2505o(88883);
                return true;
            }
        }
        AppMethodBeat.m2505o(88883);
        return false;
    }

    /* renamed from: Hn */
    public static int m65701Hn(String str) {
        AppMethodBeat.m2504i(88884);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            C4990ab.m7412e("MicroMsg.CardUtil", "string format error");
            AppMethodBeat.m2505o(88884);
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
                AppMethodBeat.m2505o(88884);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.CardUtil", e.toString());
                AppMethodBeat.m2505o(88884);
            }
        }
        return rgb;
    }

    /* renamed from: bS */
    public static int m65720bS(String str, int i) {
        AppMethodBeat.m2504i(88885);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            C4990ab.m7412e("MicroMsg.CardUtil", "string format error");
            AppMethodBeat.m2505o(88885);
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(i, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
                AppMethodBeat.m2505o(88885);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.CardUtil", e.toString());
                AppMethodBeat.m2505o(88885);
            }
        }
        return rgb;
    }

    /* renamed from: H */
    public static ShapeDrawable m65700H(Context context, int i) {
        AppMethodBeat.m2504i(88886);
        ShapeDrawable dI = C38736l.m65725dI(i, context.getResources().getDimensionPixelOffset(C25738R.dimen.f10235va));
        AppMethodBeat.m2505o(88886);
        return dI;
    }

    /* renamed from: dI */
    public static ShapeDrawable m65725dI(int i, int i2) {
        AppMethodBeat.m2504i(88887);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        AppMethodBeat.m2505o(88887);
        return shapeDrawable;
    }

    /* renamed from: b */
    public static ShapeDrawable m65718b(Context context, int i, int i2) {
        AppMethodBeat.m2504i(88888);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9981m7);
        float[] fArr = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStrokeWidth((float) dimensionPixelSize);
        AppMethodBeat.m2505o(88888);
        return shapeDrawable;
    }

    /* renamed from: bj */
    public static List<C11286b> m65722bj(List<C44153op> list) {
        AppMethodBeat.m2504i(88889);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(88889);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C44153op c44153op = (C44153op) list.get(i);
            C11286b c11286b = new C11286b();
            c11286b.title = c44153op.title;
            c11286b.kbW = c44153op.kbW;
            c11286b.kfM = c44153op.kfM;
            c11286b.url = c44153op.url;
            c11286b.vUW = c44153op.vUW;
            c11286b.kch = false;
            c11286b.vUX = c44153op.vUX;
            c11286b.vUY = c44153op.vUY;
            c11286b.kKZ = c44153op.kKZ;
            c11286b.vTL = c44153op.vTL;
            c11286b.vTM = c44153op.vTM;
            c11286b.kcg = 1;
            arrayList.add(c11286b);
        }
        AppMethodBeat.m2505o(88889);
        return arrayList;
    }

    /* renamed from: fQ */
    public static String m65728fQ(long j) {
        AppMethodBeat.m2504i(88890);
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (krM == null) {
            krM = new SimpleDateFormat("yyyy.MM.dd");
        }
        String format = krM.format(new Date(j2));
        AppMethodBeat.m2505o(88890);
        return format;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.m2504i(88891);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.m2505o(88891);
        return matches;
    }

    /* renamed from: J */
    public static Bitmap m65708J(Bitmap bitmap) {
        boolean z = true;
        AppMethodBeat.m2504i(88892);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.CardUtil";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        C4990ab.m7410d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        AppMethodBeat.m2505o(88892);
        return createBitmap;
    }

    /* renamed from: K */
    public static void m65709K(Bitmap bitmap) {
        AppMethodBeat.m2504i(88893);
        if (!(bitmap == null || bitmap.isRecycled())) {
            C4990ab.m7417i("MicroMsg.CardUtil", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        AppMethodBeat.m2505o(88893);
    }

    /* renamed from: b */
    public static boolean m65719b(CardInfo cardInfo) {
        AppMethodBeat.m2504i(88894);
        if (cardInfo == null) {
            C4990ab.m7412e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            AppMethodBeat.m2505o(88894);
            return false;
        }
        CardInfo Gu = C42852am.baW().mo45383Gu(cardInfo.field_card_id);
        if (Gu == null) {
            boolean b = C42852am.baW().mo10101b((C4925c) cardInfo);
            C4990ab.m7411d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", Boolean.valueOf(b));
            if (!b) {
                C4990ab.m7412e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            AppMethodBeat.m2505o(88894);
            return b;
        }
        cardInfo.field_stickyIndex = Gu.field_stickyIndex;
        cardInfo.field_stickyEndTime = Gu.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = Gu.field_stickyAnnouncement;
        C4990ab.m7411d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", Boolean.valueOf(C42852am.baW().mo10103c(cardInfo, new String[0])));
        AppMethodBeat.m2505o(88894);
        return C42852am.baW().mo10103c(cardInfo, new String[0]);
    }

    /* renamed from: a */
    public static void m65711a(C42837b c42837b, String str, String str2, int i) {
        byte[] ai;
        C8910b c8910b = null;
        AppMethodBeat.m2504i(88895);
        Bitmap a = C18764x.m29325a(new C33770m(c42837b.aZV().kbV));
        if (a != null) {
            ai = C5056d.m7636ai(a);
        } else {
            ai = null;
        }
        C38733a c38733a = (C38733a) C1720g.m3528K(C38733a.class);
        if (c42837b != null) {
            int i2;
            if (i == 23) {
                i = 2;
                i2 = 1;
            } else {
                i2 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            C8910b c8910b2 = new C8910b();
            if (c42837b.aZV() != null) {
                c8910b2.title = c42837b.aZX().wYl;
                c8910b2.description = c42837b.aZV().title;
                c8910b2.type = 16;
                c8910b2.showType = 0;
                c8910b2.fgr = 3;
                c8910b2.appId = c42837b.aZV().csB;
                c8910b2.ffZ = 0;
                c8910b2.thumburl = c42837b.aZV().kbV;
                c8910b2.fhD = i;
                c8910b2.fhC = c42837b.aZV().kdg;
                c8910b2.url = c42837b.aZV().vUc;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<from_username>").append(c42837b.bab()).append("</from_username>");
            if (C38736l.m65734tm(i)) {
                stringBuilder2.append("<card_id>").append(c42837b.baa()).append("</card_id>");
            } else if (i == 5) {
                stringBuilder2.append("<card_id>").append(c42837b.aZZ()).append("</card_id>");
            }
            stringBuilder2.append("<card_type>").append(c42837b.aZV().iAd).append("</card_type>");
            stringBuilder2.append("<from_scene>").append(i).append("</from_scene>");
            stringBuilder2.append("<color>").append(c42837b.aZV().color).append("</color>");
            stringBuilder2.append("<card_type_name>").append(c42837b.aZV().kdf).append("</card_type_name>");
            stringBuilder2.append("<brand_name>").append(c42837b.aZV().kdg).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                stringBuilder2.append("<card_ext></card_ext>");
            } else {
                stringBuilder2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            stringBuilder2.append("<is_recommend>").append(i2).append("</is_recommend>");
            stringBuilder2.append("<recommend_card_id>").append(c42837b.aZZ()).append("</recommend_card_id>");
            c8910b2.fhB = stringBuilder.append(stringBuilder2.toString()).toString();
            c8910b2.cDt = C8910b.m16061a(c8910b2, null, null);
            c8910b = c8910b2;
        }
        c38733a.mo6838b(c8910b, c42837b.aZV().csB, c42837b.aZV().kdg, str, ai);
        AppMethodBeat.m2505o(88895);
    }

    /* renamed from: dw */
    public static void m65727dw(String str, String str2) {
        AppMethodBeat.m2504i(88896);
        if (!C5046bo.isNullOrNil(str)) {
            C18372qb c18372qb = new C18372qb();
            c18372qb.cMq.cMr = str2;
            c18372qb.cMq.content = str;
            c18372qb.cMq.type = C1855t.m3925nK(str2);
            c18372qb.cMq.flags = 0;
            C4879a.xxA.mo10055m(c18372qb);
        }
        AppMethodBeat.m2505o(88896);
    }

    /* renamed from: tm */
    public static boolean m65734tm(int i) {
        return i == 0 || i == 1 || i == 2 || i == 9 || i == 12 || i == 17 || i == 21;
    }

    /* renamed from: tn */
    public static boolean m65735tn(int i) {
        return i == 7 || i == 8 || i == 16 || i == 26;
    }

    /* renamed from: to */
    public static boolean m65736to(int i) {
        return i == 3 || i == 4 || i == 5 || i == 15;
    }

    /* renamed from: sP */
    public static boolean m65733sP(int i) {
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
        AppMethodBeat.m2504i(88897);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(282883, null);
        if (num == null || num.intValue() != 1) {
            C4990ab.m7416i("MicroMsg.CardUtil", "open card entrance");
            C1720g.m3536RP().mo5239Ry().set(282883, Integer.valueOf(1));
            AppMethodBeat.m2505o(88897);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardUtil", "card entrance is open");
        AppMethodBeat.m2505o(88897);
    }

    public static boolean beC() {
        AppMethodBeat.m2504i(88898);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(282883, null);
        if (num == null || num.intValue() != 1) {
            AppMethodBeat.m2505o(88898);
            return false;
        }
        AppMethodBeat.m2505o(88898);
        return true;
    }

    public static void beD() {
        AppMethodBeat.m2504i(88899);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            C4990ab.m7416i("MicroMsg.CardUtil", "open share card entrance");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(1));
            AppMethodBeat.m2505o(88899);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardUtil", "share card entrance is open");
        AppMethodBeat.m2505o(88899);
    }

    public static boolean beE() {
        AppMethodBeat.m2504i(88900);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, null);
        if (num == null || num.intValue() != 1) {
            AppMethodBeat.m2505o(88900);
            return false;
        }
        AppMethodBeat.m2505o(88900);
        return true;
    }

    /* renamed from: g */
    public static String m65730g(Context context, float f) {
        AppMethodBeat.m2504i(88901);
        String str;
        if (f <= 0.0f) {
            str = "";
            AppMethodBeat.m2505o(88901);
            return str;
        } else if (f > 0.0f && f < 1000.0f) {
            str = context.getString(C25738R.string.adm, new Object[]{((int) f)});
            AppMethodBeat.m2505o(88901);
            return str;
        } else if (f >= 1000.0f) {
            Object[] objArr = new Object[1];
            objArr[0] = new DecimalFormat("0.00").format((double) (f / 1000.0f));
            str = context.getString(C25738R.string.adl, objArr);
            AppMethodBeat.m2505o(88901);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(88901);
            return str;
        }
    }

    public static boolean agA() {
        AppMethodBeat.m2504i(88902);
        try {
            boolean isProviderEnabled = ((LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION)).isProviderEnabled("gps");
            AppMethodBeat.m2505o(88902);
            return isProviderEnabled;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(88902);
            return false;
        }
    }

    public static boolean agB() {
        AppMethodBeat.m2504i(88903);
        try {
            boolean isProviderEnabled = ((LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION)).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            AppMethodBeat.m2505o(88903);
            return isProviderEnabled;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(88903);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m65713a(ShareCardInfo shareCardInfo) {
        AppMethodBeat.m2504i(88904);
        if (shareCardInfo == null) {
            C4990ab.m7412e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            AppMethodBeat.m2505o(88904);
            return false;
        }
        ShareCardInfo GK = C42852am.bbe().mo35397GK(shareCardInfo.field_card_id);
        if (GK == null) {
            boolean b = C42852am.bbe().mo10101b((C4925c) shareCardInfo);
            C4990ab.m7411d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", Boolean.valueOf(b));
            if (b) {
                C42856b.m76084do(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            } else {
                C4990ab.m7412e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            }
            AppMethodBeat.m2505o(88904);
            return b;
        }
        shareCardInfo.field_categoryType = GK.field_categoryType;
        shareCardInfo.field_itemIndex = GK.field_itemIndex;
        C4990ab.m7411d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", Boolean.valueOf(C42852am.bbe().mo10103c(shareCardInfo, new String[0])));
        AppMethodBeat.m2505o(88904);
        return C42852am.bbe().mo10103c(shareCardInfo, new String[0]);
    }

    /* renamed from: h */
    public static boolean m65732h(C42837b c42837b) {
        boolean c;
        AppMethodBeat.m2504i(88905);
        if (c42837b instanceof CardInfo) {
            c = C42852am.baW().mo10103c((CardInfo) c42837b, new String[0]);
            if (!c) {
                C4990ab.m7413e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", c42837b.aZZ());
            }
        } else if (c42837b instanceof ShareCardInfo) {
            c = C42852am.bbe().mo10103c((ShareCardInfo) c42837b, new String[0]);
            if (!c) {
                C4990ab.m7413e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", c42837b.aZZ());
            }
        } else {
            c = false;
        }
        AppMethodBeat.m2505o(88905);
        return c;
    }

    /* renamed from: Ho */
    public static void m65702Ho(String str) {
        AppMethodBeat.m2504i(88906);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) str);
        AppMethodBeat.m2505o(88906);
    }

    public static String beF() {
        AppMethodBeat.m2504i(88907);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(88907);
        return str;
    }

    /* renamed from: Hp */
    public static String m65703Hp(String str) {
        AppMethodBeat.m2504i(88908);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.m2505o(88908);
            return str;
        }
        String mK = C1854s.m3867mK(str);
        String mJ = C1854s.m3866mJ(str);
        if (!TextUtils.isEmpty(mK)) {
            AppMethodBeat.m2505o(88908);
            return mK;
        } else if (TextUtils.isEmpty(mJ)) {
            AppMethodBeat.m2505o(88908);
            return str;
        } else {
            AppMethodBeat.m2505o(88908);
            return mJ;
        }
    }

    /* renamed from: bk */
    public static ArrayList<String> m65723bk(List<String> list) {
        AppMethodBeat.m2504i(88909);
        if (list == null || list.isEmpty()) {
            C4990ab.m7412e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            AppMethodBeat.m2505o(88909);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (String PE : list) {
            List PH = C21156a.bJa().mo41635PH(C21156a.bJa().mo41632PE(PE));
            if (PH == null || PH.size() == 0) {
                C4990ab.m7412e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(PH);
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.m2505o(88909);
        return arrayList;
    }

    /* renamed from: bl */
    public static ArrayList<String> m65724bl(List<String> list) {
        AppMethodBeat.m2504i(88910);
        if (list == null || list.isEmpty()) {
            C4990ab.m7412e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            AppMethodBeat.m2505o(88910);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String PE : list) {
            String PE2 = C21156a.bJa().mo41632PE(PE2);
            if (!TextUtils.isEmpty(PE2)) {
                arrayList.add(PE2);
            }
        }
        AppMethodBeat.m2505o(88910);
        return arrayList;
    }

    /* renamed from: Hq */
    public static String m65704Hq(String str) {
        List list;
        String c;
        Object Oj;
        AppMethodBeat.m2504i(88911);
        List<Object> asList = Arrays.asList(str.split(","));
        LinkedList linkedList = new LinkedList();
        if (C1720g.m3531RK()) {
            if (asList == null || asList.size() == 0) {
                list = linkedList;
                c = C5046bo.m7536c(list, ",");
                AppMethodBeat.m2505o(88911);
                return c;
            }
            for (Object Oj2 : asList) {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(Oj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    Oj2 = aoO.mo16707Oj();
                }
                linkedList.add(Oj2);
            }
        }
        Oj2 = linkedList;
        c = C5046bo.m7536c(list, ",");
        AppMethodBeat.m2505o(88911);
        return c;
    }

    /* renamed from: a */
    public static bzm m65710a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        int i2 = 0;
        AppMethodBeat.m2504i(88912);
        C4990ab.m7416i("MicroMsg.CardUtil", "getShareTag()");
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
                    if (!TextUtils.isEmpty(str) && C38736l.isNumeric(str)) {
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
                    if (!TextUtils.isEmpty(str) && C38736l.isNumeric(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                    i2 = i3 + 1;
                }
                bzm.wYy.addAll(arrayList3);
            }
        }
        AppMethodBeat.m2505o(88912);
        return bzm;
    }

    /* renamed from: a */
    public static boolean m65714a(C23446tm c23446tm, String str) {
        AppMethodBeat.m2504i(88913);
        if (!C38736l.m65731gT(c23446tm.vUW)) {
            C4990ab.m7416i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
            AppMethodBeat.m2505o(88913);
            return false;
        } else if (C38736l.m65705Hr(str)) {
            C4990ab.m7416i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
            AppMethodBeat.m2505o(88913);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            AppMethodBeat.m2505o(88913);
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m65712a(C11286b c11286b, String str) {
        AppMethodBeat.m2504i(88914);
        if (!C38736l.m65731gT(c11286b.vUW)) {
            C4990ab.m7416i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
            AppMethodBeat.m2505o(88914);
            return false;
        } else if (C38736l.m65705Hr(str)) {
            C4990ab.m7416i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
            AppMethodBeat.m2505o(88914);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            AppMethodBeat.m2505o(88914);
            return true;
        }
    }

    /* renamed from: gT */
    private static boolean m65731gT(long j) {
        AppMethodBeat.m2504i(88915);
        if ((8 & j) > 0) {
            C4990ab.m7416i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
            AppMethodBeat.m2505o(88915);
            return true;
        }
        AppMethodBeat.m2505o(88915);
        return false;
    }

    /* renamed from: Hr */
    private static boolean m65705Hr(String str) {
        AppMethodBeat.m2504i(88916);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            AppMethodBeat.m2505o(88916);
            return true;
        }
        C4990ab.m7416i("MicroMsg.CardUtil", "hasShowWarning()");
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str2)) {
            C4990ab.m7412e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            AppMethodBeat.m2505o(88916);
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            C4990ab.m7412e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            AppMethodBeat.m2505o(88916);
            return false;
        }
        for (Object equals : split) {
            if (str.equals(equals)) {
                AppMethodBeat.m2505o(88916);
                return true;
            }
        }
        AppMethodBeat.m2505o(88916);
        return false;
    }

    /* renamed from: Hs */
    public static void m65706Hs(String str) {
        AppMethodBeat.m2504i(88917);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            AppMethodBeat.m2505o(88917);
            return;
        }
        Object str2;
        C4990ab.m7416i("MicroMsg.CardUtil", "setShowWarningFlag()");
        String str3 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str3)) {
            C4990ab.m7412e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str3.split(",");
            if (split == null || split.length == 0) {
                C4990ab.m7412e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
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
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, str2);
        AppMethodBeat.m2505o(88917);
    }

    /* renamed from: A */
    public static String m65699A(String str, long j) {
        AppMethodBeat.m2504i(88918);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.m2505o(88918);
            return str;
        }
        float f = C42852am.bbc().ect;
        float f2 = C42852am.bbc().ecs;
        if (f == -1000.0f || f2 == -85.0f) {
            C4990ab.m7412e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            AppMethodBeat.m2505o(88918);
            return str;
        } else if ((16 & j) > 0) {
            String replace = str.replace("#", ("&longitude=" + f + "&latitude=" + f2) + "#");
            C4990ab.m7416i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:".concat(String.valueOf(str)));
            C4990ab.m7416i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:".concat(String.valueOf(replace)));
            AppMethodBeat.m2505o(88918);
            return replace;
        } else {
            AppMethodBeat.m2505o(88918);
            return str;
        }
    }

    /* renamed from: Ht */
    public static int m65707Ht(String str) {
        AppMethodBeat.m2504i(88919);
        if (TextUtils.isEmpty(str) || str.equals(C1853r.m3846Yz())) {
            AppMethodBeat.m2505o(88919);
            return 0;
        }
        AppMethodBeat.m2505o(88919);
        return 1;
    }

    /* renamed from: g */
    public static Drawable m65729g(Context context, String str, int i) {
        AppMethodBeat.m2504i(88920);
        ShapeDrawable b = C38736l.m65718b(context, C38736l.m65701Hn(str), i);
        ShapeDrawable dI = C38736l.m65725dI(C38736l.m65701Hn(str), i);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, dI);
        stateListDrawable.addState(new int[0], b);
        AppMethodBeat.m2505o(88920);
        return stateListDrawable;
    }

    /* renamed from: ah */
    public static ColorStateList m65715ah(Context context, String str) {
        AppMethodBeat.m2504i(88921);
        int[][] iArr = new int[][]{new int[]{16842919, 16842910}, new int[0]};
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{context.getResources().getColor(C25738R.color.a69), C38736l.m65701Hn(str)});
        AppMethodBeat.m2505o(88921);
        return colorStateList;
    }

    /* renamed from: bT */
    public static int m65721bT(String str, int i) {
        AppMethodBeat.m2504i(88922);
        int dJ = C38736l.m65726dJ(Color.parseColor(str), i);
        AppMethodBeat.m2505o(88922);
        return dJ;
    }

    /* renamed from: dJ */
    public static int m65726dJ(int i, int i2) {
        AppMethodBeat.m2504i(88923);
        if (i2 <= 0) {
            AppMethodBeat.m2505o(88923);
            return i;
        }
        i = C5225ah.m7960dJ(i, i2);
        AppMethodBeat.m2505o(88923);
        return i;
    }

    /* renamed from: ai */
    public static void m65716ai(Context context, String str) {
        AppMethodBeat.m2504i(88924);
        if (C5046bo.isNullOrNil(str)) {
            C30379h.m48461b(context, context.getString(C25738R.string.aih), "", false);
            AppMethodBeat.m2505o(88924);
            return;
        }
        Toast.makeText(C4996ah.getContext(), str, 1).show();
        AppMethodBeat.m2505o(88924);
    }

    /* renamed from: aj */
    public static void m65717aj(Context context, String str) {
        AppMethodBeat.m2504i(88925);
        if (C5046bo.isNullOrNil(str)) {
            str = context.getString(C25738R.string.aih);
        }
        C30379h.m48461b(context, str, "", false);
        AppMethodBeat.m2505o(88925);
    }
}
