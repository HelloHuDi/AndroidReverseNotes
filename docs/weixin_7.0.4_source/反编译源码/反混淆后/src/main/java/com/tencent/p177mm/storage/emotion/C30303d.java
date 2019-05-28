package com.tencent.p177mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.emoji.C20371e;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.storage.emotion.d */
public final class C30303d extends C7563j<EmojiInfo> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(EmojiInfo.ccO, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )", "CREATE INDEX IF NOT EXISTS emojiinfogatalogindex  on EmojiInfo  (  catalog )"};
    private static int[] yaY = new int[]{2, 4, 8};
    public C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(62844);
        boolean F = mo48554F((EmojiInfo) c4925c);
        AppMethodBeat.m2505o(62844);
        return F;
    }

    static {
        AppMethodBeat.m2504i(62845);
        AppMethodBeat.m2505o(62845);
    }

    public C30303d(C4927e c4927e) {
        super(c4927e, EmojiInfo.ccO, "EmojiInfo", null);
        this.bSd = c4927e;
    }

    public final String getTableName() {
        return "EmojiInfo";
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* renamed from: hi */
    public final boolean mo48583hi(Context context) {
        AppMethodBeat.m2504i(62801);
        C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        EmojiInfo aqi = aqi("86cb157e9c44b2c9934e4e430790776d");
        EmojiInfo aqi2 = aqi("68f9864ca5c0a5d823ed7184e113a4aa");
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", Integer.valueOf(m48224Mx(EmojiInfo.yay)));
        if (aqi != null || ((aqi2 != null && aqi2.getContent().length() == 0) || r2 <= 2)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            mo48561MC(EmojiInfo.yax);
            mo48561MC(EmojiInfo.yaA);
            mo48561MC(EmojiInfo.yaz);
        }
        aqi = aqi("9bd1281af3a31710a45b84d736363691");
        if (aqi != null && aqi.field_catalog == EmojiInfo.yax) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            mo48561MC(EmojiInfo.yax);
            mo48561MC(EmojiInfo.yaA);
            mo48561MC(EmojiInfo.yaz);
        }
        InputStream bJ = EmojiInfo.m48210bJ(context, "icon_002_cover.png");
        if (bJ != null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            mo48561MC(EmojiInfo.yax);
            mo48561MC(EmojiInfo.yaA);
            mo48561MC(EmojiInfo.yaz);
        }
        if (bJ != null) {
            try {
                bJ.close();
            } catch (Exception e) {
            }
        }
        if (m48224Mx(EmojiInfo.yax) != 0) {
            AppMethodBeat.m2505o(62801);
            return true;
        }
        InputStream inputStream = null;
        try {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            List<EmojiInfo> a = C30303d.m48225a(new InputStream[]{inputStream});
            C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a.size() > 0 && a.size() > 0) {
                C7480h c7480h;
                currentTimeMillis = -1;
                if (this.bSd instanceof C7480h) {
                    C7480h c7480h2 = (C7480h) this.bSd;
                    currentTimeMillis = c7480h2.mo15639iV(Thread.currentThread().getId());
                    c7480h = c7480h2;
                } else {
                    c7480h = null;
                }
                for (EmojiInfo aqi3 : a) {
                    if (this.bSd.replace("EmojiInfo", "md5", aqi3.mo10098Hl()) < 0) {
                        if (c7480h != null) {
                            c7480h.mo15640mB(currentTimeMillis);
                        }
                    }
                }
                if (c7480h != null) {
                    c7480h.mo15640mB(currentTimeMillis);
                }
            }
            C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            C4990ab.m7410d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e2));
                }
            }
        } catch (IOException e3) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e22) {
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e22));
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e4));
                }
            }
            AppMethodBeat.m2505o(62801);
        }
        AppMethodBeat.m2505o(62801);
        return true;
    }

    /* renamed from: E */
    public final EmojiInfo mo48553E(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62802);
        if (emojiInfo == null || C5046bo.isNullOrNil(emojiInfo.mo20410Aq()) || emojiInfo.mo20410Aq().length() <= 0) {
            C4990ab.m7414f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.m2505o(62802);
            return null;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "create: %s", emojiInfo.field_md5);
        if (mo48554F(emojiInfo)) {
            anF("create_emoji_info_notify");
            AppMethodBeat.m2505o(62802);
            return emojiInfo;
        }
        AppMethodBeat.m2505o(62802);
        return null;
    }

    /* renamed from: d */
    public final EmojiInfo mo48574d(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.m2504i(62803);
        EmojiInfo b = mo48573b(str, str2, i, i2, i3, null, str3);
        AppMethodBeat.m2505o(62803);
        return b;
    }

    /* renamed from: a */
    public final EmojiInfo mo48565a(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        AppMethodBeat.m2504i(62804);
        EmojiInfo b = mo48573b(str, str2, i, i2, i3, str3, str4);
        AppMethodBeat.m2505o(62804);
        return b;
    }

    /* renamed from: e */
    public final EmojiInfo mo48578e(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.m2504i(62805);
        EmojiInfo b = mo48573b(str, str2, i, i2, i3, null, str3);
        AppMethodBeat.m2505o(62805);
        return b;
    }

    /* renamed from: b */
    public final EmojiInfo mo48573b(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        AppMethodBeat.m2504i(62806);
        if (str == null || str.length() <= 0) {
            C4990ab.m7414f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.m2505o(62806);
            return null;
        }
        EmojiInfo c = m48226c(str, str2, i, i2, i3, str3, str4);
        c.field_state = EmojiInfo.zZb;
        if (mo48554F(c)) {
            anF("create_emoji_info_notify");
            AppMethodBeat.m2505o(62806);
            return c;
        }
        AppMethodBeat.m2505o(62806);
        return null;
    }

    /* renamed from: c */
    private EmojiInfo m48226c(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        AppMethodBeat.m2504i(62807);
        if (str == null || str.length() <= 0) {
            C4990ab.m7414f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.m2505o(62807);
            return null;
        }
        EmojiInfo aqi = aqi(str);
        if (aqi == null) {
            C20371e.bjc();
            aqi = new EmojiInfo(C20371e.bjd());
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
        AppMethodBeat.m2505o(62807);
        return aqi;
    }

    /* renamed from: F */
    public final boolean mo48554F(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62808);
        if (emojiInfo == null || !emojiInfo.cVD()) {
            C4990ab.m7414f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.m2505o(62808);
            return false;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s", emojiInfo.field_md5);
        long replace = this.bSd.replace("EmojiInfo", "md5", emojiInfo.mo10098Hl());
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s, %s", emojiInfo.field_md5, Long.valueOf(replace));
        if (replace != -1) {
            anF(emojiInfo.mo20410Aq());
        }
        if (replace >= 0) {
            AppMethodBeat.m2505o(62808);
            return true;
        }
        AppMethodBeat.m2505o(62808);
        return false;
    }

    /* renamed from: G */
    public final boolean mo48555G(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62809);
        if (emojiInfo == null || !emojiInfo.cVD()) {
            C4990ab.m7414f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.m2505o(62809);
            return false;
        }
        int update = this.bSd.update("EmojiInfo", emojiInfo.mo10098Hl(), "md5=?", new String[]{emojiInfo.mo20410Aq()});
        if (update > 0) {
            anF(emojiInfo.mo20410Aq());
            anF("event_update_emoji");
        }
        if (update > 0) {
            AppMethodBeat.m2505o(62809);
            return true;
        }
        AppMethodBeat.m2505o(62809);
        return false;
    }

    /* renamed from: H */
    public final boolean mo48556H(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62810);
        if (emojiInfo == null || !emojiInfo.cVD()) {
            C4990ab.m7414f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.m2505o(62810);
            return false;
        }
        if (this.bSd.update("EmojiInfo", emojiInfo.mo10098Hl(), "md5=?", new String[]{emojiInfo.mo20410Aq()}) > 0) {
            AppMethodBeat.m2505o(62810);
            return true;
        }
        AppMethodBeat.m2505o(62810);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiInfo aqi(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(62811);
        if (C5046bo.isNullOrNil(str) || str.length() != 32) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "md5 is null or invalue. md5:%s", str);
            AppMethodBeat.m2505o(62811);
            return null;
        }
        EmojiInfo emojiInfo;
        Cursor a;
        try {
            a = this.bSd.mo10105a("EmojiInfo", null, "md5=?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        C20371e.bjc();
                        emojiInfo = new EmojiInfo(C20371e.bjd());
                        try {
                            emojiInfo.mo8995d(a);
                            if (a != null) {
                                a.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", e.toString());
                                if (a != null) {
                                    a.close();
                                }
                                AppMethodBeat.m2505o(62811);
                                return emojiInfo;
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                    a.close();
                                }
                                AppMethodBeat.m2505o(62811);
                                throw th;
                            }
                        }
                        AppMethodBeat.m2505o(62811);
                        return emojiInfo;
                    }
                } catch (Exception e3) {
                    e = e3;
                    emojiInfo = null;
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", e.toString());
                    if (a != null) {
                    }
                    AppMethodBeat.m2505o(62811);
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
            AppMethodBeat.m2505o(62811);
            throw th;
        }
        AppMethodBeat.m2505o(62811);
        return emojiInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: mU */
    public final EmojiInfo mo48587mU(long j) {
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(62812);
        if (j == 0) {
            AppMethodBeat.m2505o(62812);
            return null;
        }
        EmojiInfo emojiInfo;
        Cursor a;
        try {
            a = this.bSd.mo10105a("EmojiInfo", null, "captureEnterTime=?", new String[]{String.valueOf(j)}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        C20371e.bjc();
                        emojiInfo = new EmojiInfo(C20371e.bjd());
                        try {
                            emojiInfo.mo8995d(a);
                            if (a != null) {
                                a.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiInfoStorage", e, "", new Object[0]);
                                if (a != null) {
                                    a.close();
                                }
                                AppMethodBeat.m2505o(62812);
                                return emojiInfo;
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                }
                                AppMethodBeat.m2505o(62812);
                                throw th;
                            }
                        }
                        AppMethodBeat.m2505o(62812);
                        return emojiInfo;
                    }
                } catch (Exception e3) {
                    e = e3;
                    emojiInfo = null;
                    C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiInfoStorage", e, "", new Object[0]);
                    if (a != null) {
                    }
                    AppMethodBeat.m2505o(62812);
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
            AppMethodBeat.m2505o(62812);
            throw th;
        }
        AppMethodBeat.m2505o(62812);
        return emojiInfo;
    }

    /* renamed from: Mx */
    private int m48224Mx(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(62813);
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i2 = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7412e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62813);
        }
        AppMethodBeat.m2505o(62813);
        return i2;
    }

    /* renamed from: Jp */
    public final int mo48558Jp(String str) {
        int i;
        AppMethodBeat.m2504i(62814);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                i = 0;
            } else {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7412e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
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
            AppMethodBeat.m2505o(62814);
        }
        C4990ab.m7411d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(62814);
        return i;
    }

    /* renamed from: y */
    public final int mo48592y(boolean z, boolean z2) {
        String str;
        String[] strArr;
        int i = 0;
        AppMethodBeat.m2504i(62815);
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
            cursor = this.bSd.mo10104a(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62815);
        }
        AppMethodBeat.m2505o(62815);
        return i;
    }

    /* renamed from: pr */
    public final int mo48589pr(boolean z) {
        String str;
        String[] strArr;
        int i = 0;
        AppMethodBeat.m2504i(62816);
        Cursor cursor = null;
        if (z) {
            str = "select count(*) from EmojiInfo where groupId=? AND captureStatus=0";
            strArr = new String[]{"capture"};
        } else {
            str = "select count(*) from EmojiInfo where groupId=?";
            strArr = new String[]{"capture"};
        }
        try {
            cursor = this.bSd.mo10104a(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62816);
        }
        AppMethodBeat.m2505o(62816);
        return i;
    }

    /* renamed from: My */
    public final List<EmojiInfo> mo48563My(int i) {
        AppMethodBeat.m2504i(62817);
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
                    emojiInfo.mo8995d(rawQuery);
                    arrayList.add(emojiInfo);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        AppMethodBeat.m2505o(62817);
        return arrayList;
    }

    /* renamed from: ps */
    public final List<EmojiInfo> mo48590ps(boolean z) {
        String str;
        AppMethodBeat.m2504i(62818);
        ArrayList arrayList = new ArrayList();
        if (z) {
            str = "select * from EmojiInfo where catalog =?  order by reserved3 asc";
        } else {
            str = "select * from EmojiInfo where catalog =? and state != " + EmojiInfo.zZc + " order by reserved3 asc";
        }
        Cursor a = this.bSd.mo10104a(str, new String[]{EmojiGroupInfo.yat}, 2);
        if (a.moveToFirst()) {
            do {
                C20371e.bjc();
                EmojiInfo emojiInfo = new EmojiInfo(C20371e.bjd());
                emojiInfo.mo8995d(a);
                arrayList.add(emojiInfo);
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.m2505o(62818);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Mz */
    public final List<String> mo48564Mz(int i) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(62819);
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select md5 from EmojiInfo");
        if (i == 1) {
            stringBuilder.append(" where groupId = \"capture\" order by idx asc ");
        } else {
            stringBuilder.append(" where catalog = ").append(EmojiGroupInfo.yat).append(" order by reserved3 asc ");
        }
        try {
            cursor = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62819);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(62819);
            return arrayList;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", C5046bo.m7574l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62819);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: MA */
    public final List<String> mo48559MA(int i) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(62820);
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
            cursor = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62820);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(62820);
            return arrayList;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", C5046bo.m7574l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62820);
        }
    }

    /* renamed from: MB */
    public final Cursor mo48560MB(int i) {
        AppMethodBeat.m2504i(62821);
        Cursor query = this.bSd.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i), AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null);
        AppMethodBeat.m2505o(62821);
        return query;
    }

    public final boolean aqj(String str) {
        AppMethodBeat.m2504i(62822);
        if (str == null || str.length() != 32) {
            C4990ab.m7414f("MicroMsg.emoji.EmojiInfoStorage", "delete by md5 assertion");
            AppMethodBeat.m2505o(62822);
            return false;
        }
        int delete = this.bSd.delete("EmojiInfo", "md5=?", new String[]{String.valueOf(str)});
        if (delete > 0) {
            anF("event_update_emoji");
        }
        if (delete > 0) {
            AppMethodBeat.m2505o(62822);
            return true;
        }
        AppMethodBeat.m2505o(62822);
        return false;
    }

    /* renamed from: mV */
    public final boolean mo48588mV(long j) {
        AppMethodBeat.m2504i(62823);
        if (j == 0) {
            AppMethodBeat.m2505o(62823);
            return false;
        }
        int delete = this.bSd.delete("EmojiInfo", "captureEnterTime=".concat(String.valueOf(j)), null);
        if (delete > 0) {
            anF("event_update_emoji");
        }
        if (delete > 0) {
            AppMethodBeat.m2505o(62823);
            return true;
        }
        AppMethodBeat.m2505o(62823);
        return false;
    }

    /* renamed from: MC */
    public final boolean mo48561MC(int i) {
        AppMethodBeat.m2504i(62824);
        if (this.bSd.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i)}) >= 0) {
            AppMethodBeat.m2505o(62824);
            return true;
        }
        AppMethodBeat.m2505o(62824);
        return false;
    }

    /* renamed from: a */
    private static List<EmojiInfo> m48225a(InputStream[] inputStreamArr) {
        AppMethodBeat.m2504i(62826);
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
                            C20371e.bjc();
                            EmojiInfo emojiInfo = new EmojiInfo(C20371e.bjd());
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
            C4990ab.m7412e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e.getMessage());
        }
        AppMethodBeat.m2505o(62826);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiInfo aqk(String str) {
        EmojiInfo emojiInfo;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(62827);
        Cursor a;
        try {
            a = this.bSd.mo10104a("select * from EmojiInfo where +groupId = ? and temp=? limit 1 ", new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            try {
                if (a.moveToFirst()) {
                    C20371e.bjc();
                    emojiInfo = new EmojiInfo(C20371e.bjd());
                    try {
                        emojiInfo.mo8995d(a);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.m7412e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + e.getMessage());
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.m2505o(62827);
                            return emojiInfo;
                        } catch (Throwable th2) {
                            th = th2;
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.m2505o(62827);
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
                C4990ab.m7412e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + e.getMessage());
                if (a != null) {
                }
                AppMethodBeat.m2505o(62827);
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
            AppMethodBeat.m2505o(62827);
            throw th;
        }
        AppMethodBeat.m2505o(62827);
        return emojiInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Jg */
    public final List<EmojiInfo> mo48557Jg(String str) {
        AppMethodBeat.m2504i(62828);
        ArrayList arrayList = new ArrayList();
        String str2 = "select * from EmojiInfo where groupId=? and temp=? order by idx asc";
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a(str2, new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62828);
                return arrayList;
            }
            do {
                C20371e.bjc();
                EmojiInfo emojiInfo = new EmojiInfo(C20371e.bjd());
                emojiInfo.mo8995d(cursor);
                arrayList.add(emojiInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(62828);
            return arrayList;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62828);
        }
    }

    /* renamed from: u */
    public final boolean mo48591u(List<String> list, int i) {
        AppMethodBeat.m2504i(62829);
        boolean eK;
        if (i == 1) {
            eK = mo48580eK(list);
            AppMethodBeat.m2505o(62829);
            return eK;
        }
        eK = mo48579eJ(list);
        AppMethodBeat.m2505o(62829);
        return eK;
    }

    /* renamed from: eJ */
    public final boolean mo48579eJ(List<String> list) {
        boolean z = false;
        AppMethodBeat.m2504i(62830);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(62830);
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
        C4990ab.m7410d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.bSd.mo10108hY("EmojiInfo", stringBuilder.toString())) {
            anF("delete_emoji_info_notify");
        }
        AppMethodBeat.m2505o(62830);
        return true;
    }

    /* renamed from: eK */
    public final boolean mo48580eK(List<String> list) {
        boolean z = false;
        AppMethodBeat.m2504i(62831);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(62831);
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
        C4990ab.m7410d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.bSd.mo10108hY("EmojiInfo", stringBuilder.toString())) {
            anF("delete_emoji_info_notify");
        }
        AppMethodBeat.m2505o(62831);
        return true;
    }

    /* renamed from: l */
    public final boolean mo48585l(int i, List<String> list) {
        AppMethodBeat.m2504i(62832);
        C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            AppMethodBeat.m2505o(62832);
            return false;
        }
        long iV;
        List<String> Mz = mo48564Mz(i);
        C7480h c7480h = null;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            iV = c7480h2.mo15639iV(Thread.currentThread().getId());
            c7480h = c7480h2;
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
                if (!(aqi == null || C5046bo.isNullOrNil(aqi.mo20410Aq()))) {
                    if (i == 1) {
                        aqi.field_idx = i3;
                    } else {
                        aqi.field_reserved3 = i3;
                    }
                    if (!Mz.isEmpty()) {
                        Mz.remove(str);
                    }
                    i3++;
                    if (this.bSd.replace("EmojiInfo", "md5", aqi.mo10098Hl()) < 0) {
                        if (c7480h != null) {
                            c7480h.mo15640mB(iV);
                        }
                        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(62832);
                        return false;
                    }
                }
                i2 = i3;
            } else {
                if (!Mz.isEmpty()) {
                    for (String str2 : Mz) {
                        EmojiInfo aqi2 = aqi(str2);
                        if (!(aqi2 == null || C5046bo.isNullOrNil(aqi2.mo20410Aq()))) {
                            if (i == 1) {
                                aqi2.field_idx = i3;
                            } else {
                                aqi2.field_reserved3 = i3;
                            }
                            i3++;
                            if (this.bSd.replace("EmojiInfo", "md5", aqi2.mo10098Hl()) < 0) {
                                if (c7480h != null) {
                                    c7480h.mo15640mB(iV);
                                }
                                C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                AppMethodBeat.m2505o(62832);
                                return false;
                            }
                        }
                    }
                }
                if (c7480h != null) {
                    c7480h.mo15640mB(iV);
                }
                String str3 = "MicroMsg.emoji.EmojiInfoStorage";
                String str4 = "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
                C4990ab.m7417i(str3, str4, objArr);
                AppMethodBeat.m2505o(62832);
                return true;
            }
        }
    }

    /* renamed from: j */
    public final boolean mo48584j(List<EmojiInfo> list, String str) {
        AppMethodBeat.m2504i(62833);
        if (list.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            AppMethodBeat.m2505o(62833);
            return false;
        }
        long iV;
        EmojiInfo emojiInfo;
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", str, Integer.valueOf(list.size()));
        C7480h c7480h = null;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            iV = c7480h2.mo15639iV(Thread.currentThread().getId());
            c7480h = c7480h2;
        } else {
            iV = -1;
        }
        List<EmojiInfo> Jg = mo48557Jg(str);
        HashMap hashMap = new HashMap();
        for (EmojiInfo emojiInfo2 : Jg) {
            hashMap.put(emojiInfo2.mo20410Aq(), emojiInfo2);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            emojiInfo2 = (EmojiInfo) list.get(i2);
            emojiInfo2.field_temp = 0;
            this.bSd.replace("EmojiInfo", "md5", emojiInfo2.mo10098Hl());
            hashMap.remove(emojiInfo2.mo20410Aq());
            i = i2 + 1;
        }
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            emojiInfo2 = (EmojiInfo) entry.getValue();
            emojiInfo2.field_temp = 1;
            this.bSd.update("EmojiInfo", emojiInfo2.mo10098Hl(), "md5=?", new String[]{str2});
            C4990ab.m7411d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", emojiInfo2.field_groupId);
        }
        if (c7480h != null) {
            c7480h.mo15640mB(iV);
        }
        AppMethodBeat.m2505o(62833);
        return true;
    }

    public final boolean aql(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(62834);
        String str2 = "select * from EmojiInfo where md5=?";
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a(str2, new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", str, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62834);
        }
        AppMethodBeat.m2505o(62834);
        return z;
    }

    public final boolean aqm(String str) {
        AppMethodBeat.m2504i(62835);
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.bSd.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                    AppMethodBeat.m2505o(62835);
                    return true;
                }
                AppMethodBeat.m2505o(62835);
                return false;
            } catch (Exception e) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(62835);
        return false;
    }

    /* renamed from: m */
    public final synchronized boolean mo48586m(int i, List<EmojiInfo> list) {
        boolean z;
        AppMethodBeat.m2504i(62836);
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList %s, %s", Integer.valueOf(i), Integer.valueOf(list.size()));
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
            z = false;
            AppMethodBeat.m2505o(62836);
        } else {
            long iV;
            C7480h c7480h;
            if (this.bSd instanceof C7480h) {
                C7480h c7480h2 = (C7480h) this.bSd;
                iV = c7480h2.mo15639iV(Thread.currentThread().getId());
                c7480h = c7480h2;
            } else {
                iV = -1;
                c7480h = null;
            }
            int i2 = 1;
            for (EmojiInfo emojiInfo : list) {
                String Aq = emojiInfo.mo20410Aq();
                EmojiInfo aqi = aqi(Aq);
                if (aqi == null || C5046bo.isNullOrNil(aqi.mo20410Aq())) {
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
                    aqi.field_size = (int) C5730e.asZ(aqi.dve());
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
                C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "preparedDownloadCustomEmojiList: %s, %s, %s", aqi.mo20410Aq(), Integer.valueOf(aqi.field_state), Integer.valueOf(aqi.field_size));
                int i3 = i2 + 1;
                if (this.bSd.replace("EmojiInfo", "md5", aqi.mo10098Hl()) < 0) {
                    if (c7480h != null) {
                        c7480h.mo15640mB(iV);
                    }
                    C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    z = false;
                    AppMethodBeat.m2505o(62836);
                } else {
                    i2 = i3;
                }
            }
            if (c7480h != null) {
                c7480h.mo15640mB(iV);
            }
            String str = "MicroMsg.emoji.EmojiInfoStorage";
            String str2 = "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
            C4990ab.m7417i(str, str2, objArr);
            z = true;
            AppMethodBeat.m2505o(62836);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: MD */
    public final List<String> mo48562MD(int i) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(62837);
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
            cursor = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62837);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(62837);
            return arrayList;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", C5046bo.m7574l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62837);
        }
    }

    /* renamed from: aG */
    public final boolean mo48567aG(LinkedList<String> linkedList) {
        int i = 0;
        AppMethodBeat.m2504i(62838);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            AppMethodBeat.m2505o(62838);
            return false;
        }
        C7060h.pYm.mo15419k(164, 12, 1);
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", Integer.valueOf(linkedList.size()));
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
                C4990ab.m7410d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                boolean hY = this.bSd.mo10108hY("EmojiInfo", stringBuilder.toString());
                AppMethodBeat.m2505o(62838);
                return hY;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<String> dvh() {
        AppMethodBeat.m2504i(62839);
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a("select md5 from EmojiInfo where needupload=? and catalog=?", new String[]{String.valueOf(EmojiInfo.zZh), String.valueOf(EmojiGroupInfo.yat)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62839);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(62839);
            return arrayList;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", C5046bo.m7574l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62839);
        }
    }

    public final int dvi() {
        int i = 0;
        AppMethodBeat.m2504i(62840);
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(EmojiGroupInfo.yat)}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", C5046bo.m7574l(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62840);
        }
        AppMethodBeat.m2505o(62840);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<EmojiInfo> dvj() {
        Throwable e;
        AppMethodBeat.m2504i(62841);
        Cursor a;
        try {
            a = this.bSd.mo10104a("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[]{String.valueOf(EmojiGroupInfo.yat), String.valueOf(EmojiGroupInfo.yau)}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ArrayList arrayList = new ArrayList();
                        do {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.mo8995d(a);
                            if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                                arrayList.add(emojiInfo);
                            }
                        } while (a.moveToNext());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62841);
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", C5046bo.m7574l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62841);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                        }
                        AppMethodBeat.m2505o(62841);
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
            AppMethodBeat.m2505o(62841);
            throw e;
        }
        AppMethodBeat.m2505o(62841);
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
        AppMethodBeat.m2504i(62842);
        Cursor a;
        try {
            a = this.bSd.mo10104a("SELECT md5 FROM EmojiInfo WHERE catalog =?", new String[]{"153"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        string = a.getString(0);
                        C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "had key :%s" + C5046bo.anv(string));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62842);
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", C5046bo.m7574l(e));
                        if (a != null) {
                            a.close();
                        }
                        string = C5046bo.m7552gN(C4996ah.getContext());
                        if (C5046bo.isNullOrNil(string)) {
                        }
                        C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + C5046bo.anv(string));
                        emojiInfo = new EmojiInfo();
                        emojiInfo.field_md5 = string;
                        emojiInfo.field_catalog = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
                        if (mo48554F(emojiInfo)) {
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                        }
                        AppMethodBeat.m2505o(62842);
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
            AppMethodBeat.m2505o(62842);
            throw e;
        }
        string = C5046bo.m7552gN(C4996ah.getContext());
        if (C5046bo.isNullOrNil(string)) {
            string = C1178g.m2591x(string.getBytes());
        } else {
            string = C1178g.m2591x("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
        }
        C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + C5046bo.anv(string));
        emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = string;
        emojiInfo.field_catalog = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
        if (mo48554F(emojiInfo)) {
            AppMethodBeat.m2505o(62842);
            return string;
        }
        AppMethodBeat.m2505o(62842);
        return null;
    }

    /* renamed from: eL */
    public final boolean mo48581eL(List<C40588xx> list) {
        AppMethodBeat.m2504i(62843);
        if (list == null || list.isEmpty()) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            AppMethodBeat.m2505o(62843);
            return false;
        }
        long iV;
        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", Integer.valueOf(list.size()));
        C7480h c7480h = null;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            iV = c7480h2.mo15639iV(Thread.currentThread().getId());
            C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", Long.valueOf(iV));
            c7480h = c7480h2;
        } else {
            iV = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            C40588xx c40588xx = (C40588xx) list.get(i);
            EmojiInfo aqi = aqi(c40588xx.Md5);
            if (aqi == null) {
                aqi = new EmojiInfo();
                aqi.field_md5 = c40588xx.Md5;
                aqi.field_catalog = EmojiInfo.yau;
                C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            C2933b.m5222a(c40588xx, aqi);
            mo48555G(aqi);
        }
        if (c7480h != null) {
            c7480h.mo15640mB(iV);
            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        AppMethodBeat.m2505o(62843);
        return true;
    }

    /* renamed from: a */
    public final void mo48566a(Context context, EmojiInfo emojiInfo) {
        int available;
        AppMethodBeat.m2504i(62825);
        if (emojiInfo.field_catalog == EmojiInfo.yax || emojiInfo.field_catalog == EmojiInfo.yaA || emojiInfo.field_catalog == EmojiInfo.yaz) {
            InputStream inputStream = null;
            try {
                inputStream = EmojiInfo.m48210bJ(context, emojiInfo.getName());
                if (inputStream != null) {
                    available = inputStream.available();
                } else {
                    available = 0;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e));
                    }
                }
            } catch (IOException e2) {
                C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        available = 0;
                    } catch (IOException e22) {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e22));
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
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", C5046bo.m7574l(e3));
                    }
                }
                AppMethodBeat.m2505o(62825);
            }
        } else {
            available = (int) C5730e.asZ(emojiInfo.dve());
        }
        if (!(available == 0 || available == emojiInfo.field_size)) {
            emojiInfo.field_size = available;
            mo48555G(emojiInfo);
        }
        AppMethodBeat.m2505o(62825);
    }
}
