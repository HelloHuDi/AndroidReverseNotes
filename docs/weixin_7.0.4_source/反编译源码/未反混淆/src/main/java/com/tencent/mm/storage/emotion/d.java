package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xwalk.core.XWalkEnvironment;

public final class d extends j<EmojiInfo> implements a {
    public static final String[] fnj = new String[]{j.a(EmojiInfo.ccO, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )", "CREATE INDEX IF NOT EXISTS emojiinfogatalogindex  on EmojiInfo  (  catalog )"};
    private static int[] yaY = new int[]{2, 4, 8};
    public e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(62844);
        boolean F = F((EmojiInfo) cVar);
        AppMethodBeat.o(62844);
        return F;
    }

    static {
        AppMethodBeat.i(62845);
        AppMethodBeat.o(62845);
    }

    public d(e eVar) {
        super(eVar, EmojiInfo.ccO, "EmojiInfo", null);
        this.bSd = eVar;
    }

    public final String getTableName() {
        return "EmojiInfo";
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final boolean hi(Context context) {
        AppMethodBeat.i(62801);
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        EmojiInfo aqi = aqi("86cb157e9c44b2c9934e4e430790776d");
        EmojiInfo aqi2 = aqi("68f9864ca5c0a5d823ed7184e113a4aa");
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", Integer.valueOf(Mx(EmojiInfo.yay)));
        if (aqi != null || ((aqi2 != null && aqi2.getContent().length() == 0) || r2 <= 2)) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            MC(EmojiInfo.yax);
            MC(EmojiInfo.yaA);
            MC(EmojiInfo.yaz);
        }
        aqi = aqi("9bd1281af3a31710a45b84d736363691");
        if (aqi != null && aqi.field_catalog == EmojiInfo.yax) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            MC(EmojiInfo.yax);
            MC(EmojiInfo.yaA);
            MC(EmojiInfo.yaz);
        }
        InputStream bJ = EmojiInfo.bJ(context, "icon_002_cover.png");
        if (bJ != null) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            MC(EmojiInfo.yax);
            MC(EmojiInfo.yaA);
            MC(EmojiInfo.yaz);
        }
        if (bJ != null) {
            try {
                bJ.close();
            } catch (Exception e) {
            }
        }
        if (Mx(EmojiInfo.yax) != 0) {
            AppMethodBeat.o(62801);
            return true;
        }
        InputStream inputStream = null;
        try {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            List<EmojiInfo> a = a(new InputStream[]{inputStream});
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a.size() > 0 && a.size() > 0) {
                h hVar;
                currentTimeMillis = -1;
                if (this.bSd instanceof h) {
                    h hVar2 = (h) this.bSd;
                    currentTimeMillis = hVar2.iV(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    hVar = null;
                }
                for (EmojiInfo aqi3 : a) {
                    if (this.bSd.replace("EmojiInfo", "md5", aqi3.Hl()) < 0) {
                        if (hVar != null) {
                            hVar.mB(currentTimeMillis);
                        }
                    }
                }
                if (hVar != null) {
                    hVar.mB(currentTimeMillis);
                }
            }
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            ab.d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e2));
                }
            }
        } catch (IOException e3) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e22) {
                    ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e22));
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e4));
                }
            }
            AppMethodBeat.o(62801);
        }
        AppMethodBeat.o(62801);
        return true;
    }

    public final EmojiInfo E(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62802);
        if (emojiInfo == null || bo.isNullOrNil(emojiInfo.Aq()) || emojiInfo.Aq().length() <= 0) {
            ab.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.o(62802);
            return null;
        }
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "create: %s", emojiInfo.field_md5);
        if (F(emojiInfo)) {
            anF("create_emoji_info_notify");
            AppMethodBeat.o(62802);
            return emojiInfo;
        }
        AppMethodBeat.o(62802);
        return null;
    }

    public final EmojiInfo d(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.i(62803);
        EmojiInfo b = b(str, str2, i, i2, i3, null, str3);
        AppMethodBeat.o(62803);
        return b;
    }

    public final EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        AppMethodBeat.i(62804);
        EmojiInfo b = b(str, str2, i, i2, i3, str3, str4);
        AppMethodBeat.o(62804);
        return b;
    }

    public final EmojiInfo e(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.i(62805);
        EmojiInfo b = b(str, str2, i, i2, i3, null, str3);
        AppMethodBeat.o(62805);
        return b;
    }

    public final EmojiInfo b(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        AppMethodBeat.i(62806);
        if (str == null || str.length() <= 0) {
            ab.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.o(62806);
            return null;
        }
        EmojiInfo c = c(str, str2, i, i2, i3, str3, str4);
        c.field_state = EmojiInfo.zZb;
        if (F(c)) {
            anF("create_emoji_info_notify");
            AppMethodBeat.o(62806);
            return c;
        }
        AppMethodBeat.o(62806);
        return null;
    }

    private EmojiInfo c(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        AppMethodBeat.i(62807);
        if (str == null || str.length() <= 0) {
            ab.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.o(62807);
            return null;
        }
        EmojiInfo aqi = aqi(str);
        if (aqi == null) {
            com.tencent.mm.plugin.emoji.e.bjc();
            aqi = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bjd());
            aqi.field_catalog = i;
        }
        aqi.field_md5 = str;
        aqi.field_svrid = str2;
        aqi.field_type = i2;
        aqi.field_size = i3;
        aqi.field_state = EmojiInfo.zYZ;
        aqi.field_reserved1 = null;
        aqi.field_reserved2 = null;
        aqi.field_app_id = str3;
        aqi.field_temp = 1;
        aqi.field_reserved4 = 0;
        if (!TextUtils.isEmpty(str4)) {
            aqi.field_groupId = str4;
        }
        AppMethodBeat.o(62807);
        return aqi;
    }

    public final boolean F(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62808);
        if (emojiInfo == null || !emojiInfo.cVD()) {
            ab.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.o(62808);
            return false;
        }
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s", emojiInfo.field_md5);
        long replace = this.bSd.replace("EmojiInfo", "md5", emojiInfo.Hl());
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s, %s", emojiInfo.field_md5, Long.valueOf(replace));
        if (replace != -1) {
            anF(emojiInfo.Aq());
        }
        if (replace >= 0) {
            AppMethodBeat.o(62808);
            return true;
        }
        AppMethodBeat.o(62808);
        return false;
    }

    public final boolean G(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62809);
        if (emojiInfo == null || !emojiInfo.cVD()) {
            ab.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.o(62809);
            return false;
        }
        int update = this.bSd.update("EmojiInfo", emojiInfo.Hl(), "md5=?", new String[]{emojiInfo.Aq()});
        if (update > 0) {
            anF(emojiInfo.Aq());
            anF("event_update_emoji");
        }
        if (update > 0) {
            AppMethodBeat.o(62809);
            return true;
        }
        AppMethodBeat.o(62809);
        return false;
    }

    public final boolean H(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62810);
        if (emojiInfo == null || !emojiInfo.cVD()) {
            ab.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.o(62810);
            return false;
        }
        if (this.bSd.update("EmojiInfo", emojiInfo.Hl(), "md5=?", new String[]{emojiInfo.Aq()}) > 0) {
            AppMethodBeat.o(62810);
            return true;
        }
        AppMethodBeat.o(62810);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiInfo aqi(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(62811);
        if (bo.isNullOrNil(str) || str.length() != 32) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "md5 is null or invalue. md5:%s", str);
            AppMethodBeat.o(62811);
            return null;
        }
        EmojiInfo emojiInfo;
        Cursor a;
        try {
            a = this.bSd.a("EmojiInfo", null, "md5=?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        com.tencent.mm.plugin.emoji.e.bjc();
                        emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bjd());
                        try {
                            emojiInfo.d(a);
                            if (a != null) {
                                a.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", e.toString());
                                if (a != null) {
                                    a.close();
                                }
                                AppMethodBeat.o(62811);
                                return emojiInfo;
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                    a.close();
                                }
                                AppMethodBeat.o(62811);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(62811);
                        return emojiInfo;
                    }
                } catch (Exception e3) {
                    e = e3;
                    emojiInfo = null;
                    ab.e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", e.toString());
                    if (a != null) {
                    }
                    AppMethodBeat.o(62811);
                    return emojiInfo;
                }
            }
            emojiInfo = null;
            if (a != null) {
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            emojiInfo = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(62811);
            throw th;
        }
        AppMethodBeat.o(62811);
        return emojiInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiInfo mU(long j) {
        Throwable e;
        Throwable th;
        AppMethodBeat.i(62812);
        if (j == 0) {
            AppMethodBeat.o(62812);
            return null;
        }
        EmojiInfo emojiInfo;
        Cursor a;
        try {
            a = this.bSd.a("EmojiInfo", null, "captureEnterTime=?", new String[]{String.valueOf(j)}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        com.tencent.mm.plugin.emoji.e.bjc();
                        emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bjd());
                        try {
                            emojiInfo.d(a);
                            if (a != null) {
                                a.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.printErrStackTrace("MicroMsg.emoji.EmojiInfoStorage", e, "", new Object[0]);
                                if (a != null) {
                                    a.close();
                                }
                                AppMethodBeat.o(62812);
                                return emojiInfo;
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                }
                                AppMethodBeat.o(62812);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(62812);
                        return emojiInfo;
                    }
                } catch (Exception e3) {
                    e = e3;
                    emojiInfo = null;
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiInfoStorage", e, "", new Object[0]);
                    if (a != null) {
                    }
                    AppMethodBeat.o(62812);
                    return emojiInfo;
                }
            }
            emojiInfo = null;
            if (a != null) {
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            emojiInfo = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(62812);
            throw th;
        }
        AppMethodBeat.o(62812);
        return emojiInfo;
    }

    private int Mx(int i) {
        int i2 = 0;
        AppMethodBeat.i(62813);
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i2 = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e));
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62813);
        }
        AppMethodBeat.o(62813);
        return i2;
    }

    public final int Jp(String str) {
        int i;
        AppMethodBeat.i(62814);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                i = 0;
            } else {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e));
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62814);
        }
        ab.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(62814);
        return i;
    }

    public final int y(boolean z, boolean z2) {
        String str;
        String[] strArr;
        int i = 0;
        AppMethodBeat.i(62815);
        Cursor cursor = null;
        if (z) {
            if (z2) {
                str = "select count(*) from EmojiInfo where catalog IN (?,?) AND captureStatus=0";
                strArr = new String[]{String.valueOf(EmojiGroupInfo.yas), String.valueOf(EmojiGroupInfo.yat)};
            } else {
                str = "select count(*) from EmojiInfo where catalog IN (?,?)";
                strArr = new String[]{String.valueOf(EmojiGroupInfo.yas), String.valueOf(EmojiGroupInfo.yat)};
            }
        } else if (z2) {
            str = "select count(*) from EmojiInfo where catalog=? AND captureStatus=0";
            strArr = new String[]{EmojiGroupInfo.yat};
        } else {
            str = "select count(*) from EmojiInfo where catalog=?";
            strArr = new String[]{EmojiGroupInfo.yat};
        }
        try {
            cursor = this.bSd.a(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e));
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62815);
        }
        AppMethodBeat.o(62815);
        return i;
    }

    public final int pr(boolean z) {
        String str;
        String[] strArr;
        int i = 0;
        AppMethodBeat.i(62816);
        Cursor cursor = null;
        if (z) {
            str = "select count(*) from EmojiInfo where groupId=? AND captureStatus=0";
            strArr = new String[]{"capture"};
        } else {
            str = "select count(*) from EmojiInfo where groupId=?";
            strArr = new String[]{"capture"};
        }
        try {
            cursor = this.bSd.a(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e));
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62816);
        }
        AppMethodBeat.o(62816);
        return i;
    }

    public final List<EmojiInfo> My(int i) {
        AppMethodBeat.i(62817);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from EmojiInfo where catalog = ").append(i);
        stringBuilder.append(" and state != ").append(EmojiInfo.zZc);
        stringBuilder.append(" order by reserved3 asc ");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    EmojiInfo emojiInfo = new EmojiInfo();
                    emojiInfo.d(rawQuery);
                    arrayList.add(emojiInfo);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        AppMethodBeat.o(62817);
        return arrayList;
    }

    public final List<EmojiInfo> ps(boolean z) {
        String str;
        AppMethodBeat.i(62818);
        ArrayList arrayList = new ArrayList();
        if (z) {
            str = "select * from EmojiInfo where catalog =?  order by reserved3 asc";
        } else {
            str = "select * from EmojiInfo where catalog =? and state != " + EmojiInfo.zZc + " order by reserved3 asc";
        }
        Cursor a = this.bSd.a(str, new String[]{EmojiGroupInfo.yat}, 2);
        if (a.moveToFirst()) {
            do {
                com.tencent.mm.plugin.emoji.e.bjc();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bjd());
                emojiInfo.d(a);
                arrayList.add(emojiInfo);
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.o(62818);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<String> Mz(int i) {
        Cursor cursor = null;
        AppMethodBeat.i(62819);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select md5 from EmojiInfo");
        if (i == 1) {
            stringBuilder.append(" where groupId = \"capture\" order by idx asc ");
        } else {
            stringBuilder.append(" where catalog = ").append(EmojiGroupInfo.yat).append(" order by reserved3 asc ");
        }
        try {
            cursor = this.bSd.a(stringBuilder.toString(), null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62819);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62819);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", bo.l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62819);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<String> MA(int i) {
        Cursor cursor = null;
        AppMethodBeat.i(62820);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select md5 from EmojiInfo");
        if (i == 1) {
            stringBuilder.append(" where groupId = \"capture\" and captureStatus = 0");
        } else {
            stringBuilder.append(" where catalog = ").append(EmojiInfo.yaB);
        }
        stringBuilder.append(" and state in (").append(EmojiInfo.zZb);
        stringBuilder.append(" , ").append(EmojiInfo.zZc);
        stringBuilder.append(" ) ");
        try {
            cursor = this.bSd.a(stringBuilder.toString(), null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62820);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62820);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", bo.l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62820);
        }
    }

    public final Cursor MB(int i) {
        AppMethodBeat.i(62821);
        Cursor query = this.bSd.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i), AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null);
        AppMethodBeat.o(62821);
        return query;
    }

    public final boolean aqj(String str) {
        AppMethodBeat.i(62822);
        if (str == null || str.length() != 32) {
            ab.f("MicroMsg.emoji.EmojiInfoStorage", "delete by md5 assertion");
            AppMethodBeat.o(62822);
            return false;
        }
        int delete = this.bSd.delete("EmojiInfo", "md5=?", new String[]{String.valueOf(str)});
        if (delete > 0) {
            anF("event_update_emoji");
        }
        if (delete > 0) {
            AppMethodBeat.o(62822);
            return true;
        }
        AppMethodBeat.o(62822);
        return false;
    }

    public final boolean mV(long j) {
        AppMethodBeat.i(62823);
        if (j == 0) {
            AppMethodBeat.o(62823);
            return false;
        }
        int delete = this.bSd.delete("EmojiInfo", "captureEnterTime=".concat(String.valueOf(j)), null);
        if (delete > 0) {
            anF("event_update_emoji");
        }
        if (delete > 0) {
            AppMethodBeat.o(62823);
            return true;
        }
        AppMethodBeat.o(62823);
        return false;
    }

    public final boolean MC(int i) {
        AppMethodBeat.i(62824);
        if (this.bSd.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i)}) >= 0) {
            AppMethodBeat.o(62824);
            return true;
        }
        AppMethodBeat.o(62824);
        return false;
    }

    private static List<EmojiInfo> a(InputStream[] inputStreamArr) {
        AppMethodBeat.i(62826);
        ArrayList arrayList = new ArrayList();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            for (int i = 0; i <= 0; i++) {
                InputStream inputStream = inputStreamArr[i];
                if (inputStream != null) {
                    NodeList elementsByTagName = newDocumentBuilder.parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
                    for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                        Element element = (Element) elementsByTagName.item(i2);
                        int intValue = Integer.decode(element.getAttribute("id")).intValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("emoji");
                        for (int i3 = 0; i3 < elementsByTagName2.getLength(); i3++) {
                            com.tencent.mm.plugin.emoji.e.bjc();
                            EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bjd());
                            element = (Element) elementsByTagName2.item(i3);
                            emojiInfo.field_md5 = element.getAttribute("md5");
                            if (emojiInfo.cVD()) {
                                String data;
                                String str;
                                emojiInfo.field_catalog = intValue;
                                emojiInfo.field_groupId = String.valueOf(intValue);
                                emojiInfo.field_name = element.getAttribute("name");
                                emojiInfo.field_type = Integer.decode(element.getAttribute("type")).intValue();
                                Node firstChild = element.getFirstChild();
                                if (firstChild instanceof CharacterData) {
                                    data = ((CharacterData) firstChild).getData();
                                } else {
                                    data = "";
                                }
                                if (emojiInfo.field_type == EmojiInfo.TYPE_TEXT) {
                                    str = new String(Base64.decode(data, 0));
                                } else {
                                    str = data;
                                }
                                emojiInfo.field_content = str;
                                arrayList.add(emojiInfo);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e.getMessage());
        }
        AppMethodBeat.o(62826);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiInfo aqk(String str) {
        EmojiInfo emojiInfo;
        Exception e;
        Throwable th;
        AppMethodBeat.i(62827);
        Cursor a;
        try {
            a = this.bSd.a("select * from EmojiInfo where +groupId = ? and temp=? limit 1 ", new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            try {
                if (a.moveToFirst()) {
                    com.tencent.mm.plugin.emoji.e.bjc();
                    emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bjd());
                    try {
                        emojiInfo.d(a);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + e.getMessage());
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.o(62827);
                            return emojiInfo;
                        } catch (Throwable th2) {
                            th = th2;
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.o(62827);
                            throw th;
                        }
                    }
                }
                emojiInfo = null;
                if (a != null) {
                    a.close();
                }
            } catch (Exception e3) {
                e = e3;
                emojiInfo = null;
                ab.e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + e.getMessage());
                if (a != null) {
                }
                AppMethodBeat.o(62827);
                return emojiInfo;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            emojiInfo = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(62827);
            throw th;
        }
        AppMethodBeat.o(62827);
        return emojiInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<EmojiInfo> Jg(String str) {
        AppMethodBeat.i(62828);
        ArrayList arrayList = new ArrayList();
        String str2 = "select * from EmojiInfo where groupId=? and temp=? order by idx asc";
        Cursor cursor = null;
        try {
            cursor = this.bSd.a(str2, new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62828);
                return arrayList;
            }
            do {
                com.tencent.mm.plugin.emoji.e.bjc();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bjd());
                emojiInfo.d(cursor);
                arrayList.add(emojiInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62828);
            return arrayList;
        } catch (Exception e) {
            ab.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62828);
        }
    }

    public final boolean u(List<String> list, int i) {
        AppMethodBeat.i(62829);
        boolean eK;
        if (i == 1) {
            eK = eK(list);
            AppMethodBeat.o(62829);
            return eK;
        }
        eK = eJ(list);
        AppMethodBeat.o(62829);
        return eK;
    }

    public final boolean eJ(List<String> list) {
        boolean z = false;
        AppMethodBeat.i(62830);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(62830);
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("catalog");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.yau);
        stringBuilder.append(",");
        stringBuilder.append("source");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.zZe);
        stringBuilder.append(",");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.zZg);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        while (true) {
            boolean z2 = z;
            if (z2 >= list.size()) {
                break;
            }
            stringBuilder.append("'" + ((String) list.get(z2)) + "'");
            if (z2 < list.size() - 1) {
                stringBuilder.append(",");
            }
            z = z2 + 1;
        }
        stringBuilder.append(")");
        ab.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.bSd.hY("EmojiInfo", stringBuilder.toString())) {
            anF("delete_emoji_info_notify");
        }
        AppMethodBeat.o(62830);
        return true;
    }

    public final boolean eK(List<String> list) {
        boolean z = false;
        AppMethodBeat.i(62831);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(62831);
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("groupId");
        stringBuilder.append("=");
        stringBuilder.append("\"\"");
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        while (true) {
            boolean z2 = z;
            if (z2 >= list.size()) {
                break;
            }
            stringBuilder.append("'" + ((String) list.get(z2)) + "'");
            if (z2 < list.size() - 1) {
                stringBuilder.append(",");
            }
            z = z2 + 1;
        }
        stringBuilder.append(")");
        ab.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.bSd.hY("EmojiInfo", stringBuilder.toString())) {
            anF("delete_emoji_info_notify");
        }
        AppMethodBeat.o(62831);
        return true;
    }

    public final boolean l(int i, List<String> list) {
        AppMethodBeat.i(62832);
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            AppMethodBeat.o(62832);
            return false;
        }
        long iV;
        List<String> Mz = Mz(i);
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            iV = -1;
        }
        int i2 = 1;
        Iterator it = list.iterator();
        while (true) {
            int i3 = i2;
            String str;
            if (it.hasNext()) {
                str = (String) it.next();
                EmojiInfo aqi = aqi(str);
                if (!(aqi == null || bo.isNullOrNil(aqi.Aq()))) {
                    if (i == 1) {
                        aqi.field_idx = i3;
                    } else {
                        aqi.field_reserved3 = i3;
                    }
                    if (!Mz.isEmpty()) {
                        Mz.remove(str);
                    }
                    i3++;
                    if (this.bSd.replace("EmojiInfo", "md5", aqi.Hl()) < 0) {
                        if (hVar != null) {
                            hVar.mB(iV);
                        }
                        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(62832);
                        return false;
                    }
                }
                i2 = i3;
            } else {
                if (!Mz.isEmpty()) {
                    for (String str2 : Mz) {
                        EmojiInfo aqi2 = aqi(str2);
                        if (!(aqi2 == null || bo.isNullOrNil(aqi2.Aq()))) {
                            if (i == 1) {
                                aqi2.field_idx = i3;
                            } else {
                                aqi2.field_reserved3 = i3;
                            }
                            i3++;
                            if (this.bSd.replace("EmojiInfo", "md5", aqi2.Hl()) < 0) {
                                if (hVar != null) {
                                    hVar.mB(iV);
                                }
                                ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                AppMethodBeat.o(62832);
                                return false;
                            }
                        }
                    }
                }
                if (hVar != null) {
                    hVar.mB(iV);
                }
                String str3 = "MicroMsg.emoji.EmojiInfoStorage";
                String str4 = "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
                ab.i(str3, str4, objArr);
                AppMethodBeat.o(62832);
                return true;
            }
        }
    }

    public final boolean j(List<EmojiInfo> list, String str) {
        AppMethodBeat.i(62833);
        if (list.size() <= 0) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            AppMethodBeat.o(62833);
            return false;
        }
        long iV;
        EmojiInfo emojiInfo;
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", str, Integer.valueOf(list.size()));
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            iV = -1;
        }
        List<EmojiInfo> Jg = Jg(str);
        HashMap hashMap = new HashMap();
        for (EmojiInfo emojiInfo2 : Jg) {
            hashMap.put(emojiInfo2.Aq(), emojiInfo2);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            emojiInfo2 = (EmojiInfo) list.get(i2);
            emojiInfo2.field_temp = 0;
            this.bSd.replace("EmojiInfo", "md5", emojiInfo2.Hl());
            hashMap.remove(emojiInfo2.Aq());
            i = i2 + 1;
        }
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            emojiInfo2 = (EmojiInfo) entry.getValue();
            emojiInfo2.field_temp = 1;
            this.bSd.update("EmojiInfo", emojiInfo2.Hl(), "md5=?", new String[]{str2});
            ab.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", emojiInfo2.field_groupId);
        }
        if (hVar != null) {
            hVar.mB(iV);
        }
        AppMethodBeat.o(62833);
        return true;
    }

    public final boolean aql(String str) {
        boolean z = false;
        AppMethodBeat.i(62834);
        String str2 = "select * from EmojiInfo where md5=?";
        Cursor cursor = null;
        try {
            cursor = this.bSd.a(str2, new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", str, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62834);
        }
        AppMethodBeat.o(62834);
        return z;
    }

    public final boolean aqm(String str) {
        AppMethodBeat.i(62835);
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.bSd.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                    AppMethodBeat.o(62835);
                    return true;
                }
                AppMethodBeat.o(62835);
                return false;
            } catch (Exception e) {
                ab.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e.getMessage());
            }
        }
        AppMethodBeat.o(62835);
        return false;
    }

    public final synchronized boolean m(int i, List<EmojiInfo> list) {
        boolean z;
        AppMethodBeat.i(62836);
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList %s, %s", Integer.valueOf(i), Integer.valueOf(list.size()));
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
            z = false;
            AppMethodBeat.o(62836);
        } else {
            long iV;
            h hVar;
            if (this.bSd instanceof h) {
                h hVar2 = (h) this.bSd;
                iV = hVar2.iV(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                iV = -1;
                hVar = null;
            }
            int i2 = 1;
            for (EmojiInfo emojiInfo : list) {
                String Aq = emojiInfo.Aq();
                EmojiInfo aqi = aqi(Aq);
                if (aqi == null || bo.isNullOrNil(aqi.Aq())) {
                    aqi = new EmojiInfo();
                    aqi.field_md5 = Aq;
                    aqi.field_source = EmojiInfo.zZf;
                    aqi.field_lastUseTime = System.currentTimeMillis();
                } else {
                    aqi.field_source = EmojiInfo.zZf;
                }
                if (i == 1) {
                    if (aqi.field_catalog != EmojiInfo.yaB) {
                        aqi.field_catalog = EmojiInfo.yau;
                    }
                    aqi.field_groupId = "capture";
                    aqi.field_idx = i2;
                } else {
                    aqi.field_catalog = EmojiInfo.yaB;
                    aqi.field_reserved3 = i2;
                }
                if (aqi.duP()) {
                    aqi.field_reserved4 |= EmojiInfo.zZi;
                    aqi.field_state = EmojiInfo.zZb;
                    aqi.field_size = (int) com.tencent.mm.vfs.e.asZ(aqi.dve());
                } else {
                    aqi.field_state = EmojiInfo.zZc;
                }
                aqi.field_cdnUrl = emojiInfo.field_cdnUrl;
                aqi.field_thumbUrl = emojiInfo.field_thumbUrl;
                aqi.field_designerID = emojiInfo.field_designerID;
                aqi.field_encrypturl = emojiInfo.field_encrypturl;
                aqi.field_aeskey = emojiInfo.field_aeskey;
                aqi.field_externUrl = emojiInfo.field_externUrl;
                aqi.field_externMd5 = emojiInfo.field_externMd5;
                aqi.field_activityid = emojiInfo.field_activityid;
                aqi.field_attachedText = emojiInfo.field_attachedText;
                aqi.field_attachTextColor = emojiInfo.field_attachTextColor;
                aqi.field_lensId = emojiInfo.field_lensId;
                ab.i("MicroMsg.emoji.EmojiInfoStorage", "preparedDownloadCustomEmojiList: %s, %s, %s", aqi.Aq(), Integer.valueOf(aqi.field_state), Integer.valueOf(aqi.field_size));
                int i3 = i2 + 1;
                if (this.bSd.replace("EmojiInfo", "md5", aqi.Hl()) < 0) {
                    if (hVar != null) {
                        hVar.mB(iV);
                    }
                    ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    z = false;
                    AppMethodBeat.o(62836);
                } else {
                    i2 = i3;
                }
            }
            if (hVar != null) {
                hVar.mB(iV);
            }
            String str = "MicroMsg.emoji.EmojiInfoStorage";
            String str2 = "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
            ab.i(str, str2, objArr);
            z = true;
            AppMethodBeat.o(62836);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<String> MD(int i) {
        Cursor cursor = null;
        AppMethodBeat.i(62837);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select md5 from EmojiInfo");
        if (i == 1) {
            stringBuilder.append(" where groupId = \"capture\"");
        } else {
            stringBuilder.append(" where catalog = ").append(EmojiInfo.yaB);
        }
        stringBuilder.append(" and state = ").append(EmojiInfo.zZc);
        try {
            cursor = this.bSd.a(stringBuilder.toString(), null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62837);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62837);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", bo.l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62837);
        }
    }

    public final boolean aG(LinkedList<String> linkedList) {
        int i = 0;
        AppMethodBeat.i(62838);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            AppMethodBeat.o(62838);
            return false;
        }
        com.tencent.mm.plugin.report.service.h.pYm.k(164, 12, 1);
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", Integer.valueOf(linkedList.size()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.zZh);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                stringBuilder.append("'" + ((String) linkedList.get(i2)) + "'");
                if (i2 < linkedList.size() - 1) {
                    stringBuilder.append(",");
                }
                i = i2 + 1;
            } else {
                stringBuilder.append(")");
                ab.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                boolean hY = this.bSd.hY("EmojiInfo", stringBuilder.toString());
                AppMethodBeat.o(62838);
                return hY;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<String> dvh() {
        AppMethodBeat.i(62839);
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select md5 from EmojiInfo where needupload=? and catalog=?", new String[]{String.valueOf(EmojiInfo.zZh), String.valueOf(EmojiGroupInfo.yat)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62839);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62839);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", bo.l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62839);
        }
    }

    public final int dvi() {
        int i = 0;
        AppMethodBeat.i(62840);
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(EmojiGroupInfo.yat)}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", bo.l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62840);
        }
        AppMethodBeat.o(62840);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<EmojiInfo> dvj() {
        Throwable e;
        AppMethodBeat.i(62841);
        Cursor a;
        try {
            a = this.bSd.a("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[]{String.valueOf(EmojiGroupInfo.yat), String.valueOf(EmojiGroupInfo.yau)}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ArrayList arrayList = new ArrayList();
                        do {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.d(a);
                            if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                                arrayList.add(emojiInfo);
                            }
                        } while (a.moveToNext());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62841);
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", bo.l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62841);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                        }
                        AppMethodBeat.o(62841);
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(62841);
            throw e;
        }
        AppMethodBeat.o(62841);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String getKey() {
        String string;
        Throwable e;
        EmojiInfo emojiInfo;
        AppMethodBeat.i(62842);
        Cursor a;
        try {
            a = this.bSd.a("SELECT md5 FROM EmojiInfo WHERE catalog =?", new String[]{"153"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        string = a.getString(0);
                        ab.i("MicroMsg.emoji.EmojiInfoStorage", "had key :%s" + bo.anv(string));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62842);
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", bo.l(e));
                        if (a != null) {
                            a.close();
                        }
                        string = bo.gN(ah.getContext());
                        if (bo.isNullOrNil(string)) {
                        }
                        ab.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bo.anv(string));
                        emojiInfo = new EmojiInfo();
                        emojiInfo.field_md5 = string;
                        emojiInfo.field_catalog = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
                        if (F(emojiInfo)) {
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                        }
                        AppMethodBeat.o(62842);
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(62842);
            throw e;
        }
        string = bo.gN(ah.getContext());
        if (bo.isNullOrNil(string)) {
            string = com.tencent.mm.a.g.x(string.getBytes());
        } else {
            string = com.tencent.mm.a.g.x("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
        }
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bo.anv(string));
        emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = string;
        emojiInfo.field_catalog = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
        if (F(emojiInfo)) {
            AppMethodBeat.o(62842);
            return string;
        }
        AppMethodBeat.o(62842);
        return null;
    }

    public final boolean eL(List<xx> list) {
        AppMethodBeat.i(62843);
        if (list == null || list.isEmpty()) {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            AppMethodBeat.o(62843);
            return false;
        }
        long iV;
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", Integer.valueOf(list.size()));
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", Long.valueOf(iV));
            hVar = hVar2;
        } else {
            iV = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            xx xxVar = (xx) list.get(i);
            EmojiInfo aqi = aqi(xxVar.Md5);
            if (aqi == null) {
                aqi = new EmojiInfo();
                aqi.field_md5 = xxVar.Md5;
                aqi.field_catalog = EmojiInfo.yau;
                ab.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            b.a(xxVar, aqi);
            G(aqi);
        }
        if (hVar != null) {
            hVar.mB(iV);
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        AppMethodBeat.o(62843);
        return true;
    }

    public final void a(Context context, EmojiInfo emojiInfo) {
        int available;
        AppMethodBeat.i(62825);
        if (emojiInfo.field_catalog == EmojiInfo.yax || emojiInfo.field_catalog == EmojiInfo.yaA || emojiInfo.field_catalog == EmojiInfo.yaz) {
            InputStream inputStream = null;
            try {
                inputStream = EmojiInfo.bJ(context, emojiInfo.getName());
                if (inputStream != null) {
                    available = inputStream.available();
                } else {
                    available = 0;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e));
                    }
                }
            } catch (IOException e2) {
                ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        available = 0;
                    } catch (IOException e22) {
                        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e22));
                        available = 0;
                    }
                } else {
                    available = 0;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bo.l(e3));
                    }
                }
                AppMethodBeat.o(62825);
            }
        } else {
            available = (int) com.tencent.mm.vfs.e.asZ(emojiInfo.dve());
        }
        if (!(available == 0 || available == emojiInfo.field_size)) {
            emojiInfo.field_size = available;
            G(emojiInfo);
        }
        AppMethodBeat.o(62825);
    }
}
