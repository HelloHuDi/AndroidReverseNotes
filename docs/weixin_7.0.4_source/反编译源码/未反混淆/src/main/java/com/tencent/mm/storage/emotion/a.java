package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ar;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class a extends j<EmojiGroupInfo> implements com.tencent.mm.cd.g.a {
    public static final String[] fnj = new String[]{j.a(EmojiGroupInfo.ccO, "EmojiGroupInfo")};
    public e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(62756);
        boolean c = c((EmojiGroupInfo) cVar);
        AppMethodBeat.o(62756);
        return c;
    }

    static {
        AppMethodBeat.i(62757);
        AppMethodBeat.o(62757);
    }

    public a(e eVar) {
        super(eVar, EmojiGroupInfo.ccO, "EmojiGroupInfo", null);
        this.bSd = eVar;
    }

    public final String getTableName() {
        return "EmojiGroupInfo";
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final boolean hi(Context context) {
        AppMethodBeat.i(62726);
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
        hj(context);
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
        AppMethodBeat.o(62726);
        return true;
    }

    private ArrayList<EmojiGroupInfo> hj(Context context) {
        AppMethodBeat.i(62727);
        InputStream inputStream = null;
        ArrayList arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            NodeList elementsByTagName = newInstance.newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                Element element = (Element) elementsByTagName.item(i);
                int intValue = Integer.decode(element.getAttribute("id")).intValue();
                if (!TextUtils.isEmpty(element.getAttribute("sort"))) {
                    Object obj;
                    ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", Integer.valueOf(intValue), Integer.decode(element.getAttribute("sort")));
                    int i2 = EmojiGroupInfo.yas;
                    if ((intValue & i2) == i2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || (dux() <= 0 && !duE())) {
                        emojiGroupInfo.field_sort = i + 1;
                    } else {
                        emojiGroupInfo.field_sort = -1;
                        com.tencent.mm.kernel.g.RP().Ry().set(208912, Boolean.TRUE);
                        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
                    }
                }
                emojiGroupInfo.field_productID = String.valueOf(intValue);
                emojiGroupInfo.field_packName = element.getAttribute("name");
                if (!TextUtils.isEmpty(element.getAttribute("type"))) {
                    emojiGroupInfo.field_type = Integer.decode(element.getAttribute("type")).intValue();
                }
                if (!TextUtils.isEmpty(element.getAttribute("free"))) {
                    emojiGroupInfo.field_packType = Integer.decode(element.getAttribute("free")).intValue();
                }
                if (emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_SYSTEM || emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
                    arrayList.add(emojiGroupInfo);
                }
            }
            if (arrayList.size() > 0) {
                eI(arrayList);
            }
            ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e, "", new Object[0]);
                }
            }
        } catch (IOException e2) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", bo.l(e2));
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + e2.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e3, "", new Object[0]);
                }
            }
        } catch (Exception e32) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", bo.l(e32));
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + e32.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e322) {
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e322, "", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(62727);
        }
        AppMethodBeat.o(62727);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiGroupInfo bZ(String str, boolean z) {
        EmojiGroupInfo emojiGroupInfo;
        Exception e;
        EmojiGroupInfo emojiGroupInfo2;
        Throwable th;
        AppMethodBeat.i(62728);
        String str2 = "select * from EmojiGroupInfo where productID= ?";
        Cursor a;
        try {
            a = this.bSd.a(str2, new String[]{str}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        emojiGroupInfo = new EmojiGroupInfo();
                        try {
                            emojiGroupInfo.d(a);
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.o(62728);
                            return emojiGroupInfo;
                        } catch (Exception e2) {
                            e = e2;
                            emojiGroupInfo2 = emojiGroupInfo;
                            try {
                                ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get getEmojiGroupInof fail. product id is" + str + " " + e.getMessage());
                                if (a == null) {
                                    a.close();
                                    emojiGroupInfo = emojiGroupInfo2;
                                } else {
                                    emojiGroupInfo = emojiGroupInfo2;
                                }
                                if (emojiGroupInfo != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                    a.close();
                                }
                                AppMethodBeat.o(62728);
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    emojiGroupInfo2 = null;
                    ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get getEmojiGroupInof fail. product id is" + str + " " + e.getMessage());
                    if (a == null) {
                    }
                    if (emojiGroupInfo != null) {
                    }
                }
            }
            if (a != null) {
                a.close();
                emojiGroupInfo = null;
            } else {
                emojiGroupInfo = null;
            }
        } catch (Exception e32) {
            e = e32;
            a = null;
            emojiGroupInfo2 = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(62728);
            throw th;
        }
        if (emojiGroupInfo != null) {
            AppMethodBeat.o(62728);
            return emojiGroupInfo;
        } else if (z) {
            AppMethodBeat.o(62728);
            return null;
        } else {
            emojiGroupInfo = new EmojiGroupInfo();
            AppMethodBeat.o(62728);
            return emojiGroupInfo;
        }
    }

    private int dux() {
        int i = 0;
        AppMethodBeat.i(62729);
        Cursor cursor = null;
        String str = "select  count(*) from EmojiInfo where catalog=?";
        try {
            cursor = this.bSd.a(str, new String[]{EmojiGroupInfo.yat}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62729);
        }
        AppMethodBeat.o(62729);
        return i;
    }

    public final boolean duy() {
        boolean z = true;
        AppMethodBeat.i(62730);
        String str = "select * from EmojiGroupInfo where type=?";
        Cursor cursor = null;
        try {
            cursor = this.bSd.a(str, new String[]{EmojiGroupInfo.TYPE_SYSTEM}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62730);
                return false;
            }
            boolean z2;
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
            emojiGroupInfo.d(cursor);
            if ((emojiGroupInfo.field_flag & 256) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                z = false;
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62730);
            return z;
        } catch (Exception e) {
            ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62730);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<EmojiGroupInfo> duz() {
        Cursor cursor = null;
        AppMethodBeat.i(62731);
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.bSd.a("select * from EmojiGroupInfo where " + duH() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62731);
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62731);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62731);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final HashMap<String, EmojiGroupInfo> duA() {
        Cursor cursor = null;
        AppMethodBeat.i(62732);
        HashMap hashMap = new HashMap();
        try {
            cursor = this.bSd.a("select * from EmojiGroupInfo where " + duH() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62732);
                return hashMap;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                hashMap.put(emojiGroupInfo.field_productID, emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62732);
            return hashMap;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62732);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<EmojiGroupInfo> duB() {
        Cursor cursor = null;
        AppMethodBeat.i(62733);
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.bSd.a("select * from EmojiGroupInfo where " + duI() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62733);
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62733);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62733);
        }
    }

    public final int duC() {
        Cursor cursor = null;
        int i = 0;
        AppMethodBeat.i(62734);
        try {
            cursor = this.bSd.a("select count(*) from EmojiGroupInfo where " + duI() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62734);
        }
        AppMethodBeat.o(62734);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final HashMap<String, ar> duD() {
        Cursor cursor = null;
        AppMethodBeat.i(62735);
        HashMap hashMap = new HashMap();
        try {
            cursor = this.bSd.a("select * from EmojiGroupInfo where " + duI() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62735);
                return hashMap;
            }
            ar arVar = new ar();
            int columnIndex = cursor.getColumnIndex("productID");
            int columnIndex2 = cursor.getColumnIndex("packName");
            do {
                String string = cursor.getString(columnIndex);
                arVar.cwg = string;
                arVar.lcC = cursor.getString(columnIndex2);
                arVar.Mo(7);
                hashMap.put(string, arVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62735);
            return hashMap;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62735);
        }
    }

    public final boolean aqc(String str) {
        Cursor cursor = null;
        boolean z = false;
        AppMethodBeat.i(62736);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
        }
        try {
            cursor = this.bSd.a("select count(*) from EmojiGroupInfo where productID = '" + str + "' AND  ( status = '7' ) " + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62736);
                return z;
            }
            if (cursor.getInt(0) > 0) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62736);
            return z;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62736);
        }
    }

    public static boolean duE() {
        AppMethodBeat.i(62737);
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(208912, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(62737);
        return booleanValue;
    }

    public final boolean c(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(62738);
        if (emojiGroupInfo == null) {
            ab.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
            AppMethodBeat.o(62738);
            return false;
        }
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        emojiGroupInfo.field_sort = 1;
        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", emojiGroupInfo.field_packName, Long.valueOf(emojiGroupInfo.field_lastUseTime));
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        d(emojiGroupInfo);
        boolean a = a(emojiGroupInfo);
        if (a) {
            b("event_update_group", 0, bo.dpG().toString());
        }
        AppMethodBeat.o(62738);
        return a;
    }

    public final boolean eI(List<EmojiGroupInfo> list) {
        AppMethodBeat.i(62739);
        if (list == null || list.size() <= 0) {
            ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
            AppMethodBeat.o(62739);
            return false;
        }
        long iV;
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", Long.valueOf(iV));
            hVar = hVar2;
        } else {
            iV = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", r0.field_productID, Long.valueOf(r0.field_lastUseTime), Integer.valueOf(((EmojiGroupInfo) list.get(i)).field_sort));
            a(r0);
        }
        if (hVar != null) {
            hVar.mB(iV);
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        b("event_update_group", 0, bo.dpG().toString());
        AppMethodBeat.o(62739);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aqd(String str) {
        boolean z;
        AppMethodBeat.i(62740);
        if (!bo.isNullOrNil(str)) {
            try {
                if (str.equals("com.tencent.xin.emoticon.tusiji")) {
                    str = EmojiGroupInfo.yar;
                }
                EmojiGroupInfo bZ = bZ(str, true);
                if (bZ == null) {
                    z = false;
                } else {
                    if (bZ != null) {
                        if (bZ.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
                            ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
                        } else {
                            bZ.field_flag |= 256;
                            bZ.field_status = -1;
                            bZ.field_sort = 1;
                            bZ.field_recommand = 0;
                            bZ.field_sync = 0;
                        }
                    }
                    bZ.field_lastUseTime = System.currentTimeMillis();
                    bZ.field_recommand = 0;
                    bZ.field_sync = 0;
                    z = a(bZ);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + e.getMessage());
            }
            if (z) {
                b("event_update_group", 0, bo.dpG().toString());
                anF("delete_group");
            }
            AppMethodBeat.o(62740);
            return z;
        }
        z = false;
        if (z) {
        }
        AppMethodBeat.o(62740);
        return z;
    }

    public final void aj(ArrayList<String> arrayList) {
        long iV;
        AppMethodBeat.i(62741);
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", Long.valueOf(iV));
            hVar = hVar2;
        } else {
            iV = -1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aqd((String) it.next());
            }
        }
        if (hVar != null) {
            hVar.mB(iV);
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
        }
        AppMethodBeat.o(62741);
    }

    public final boolean duF() {
        AppMethodBeat.i(62742);
        String[] strArr = new String[]{"1", EmojiGroupInfo.yao, "7"};
        if (this.bSd.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", strArr) > 0) {
            AppMethodBeat.o(62742);
            return true;
        }
        AppMethodBeat.o(62742);
        return false;
    }

    public final boolean ak(ArrayList<EmojiGroupInfo> arrayList) {
        AppMethodBeat.i(62743);
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
        boolean eI = eI(arrayList);
        AppMethodBeat.o(62743);
        return eI;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<EmojiGroupInfo> duG() {
        Cursor cursor = null;
        AppMethodBeat.i(62744);
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.bSd.a("select * from EmojiGroupInfo where " + duI() + " or " + Mu(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Mu(EmojiGroupInfo.TYPE_CUSTOM) + " or  ( recommand = '1' ) " + " order by sort ASC,idx ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62744);
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62744);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62744);
        }
    }

    private static boolean d(EmojiGroupInfo emojiGroupInfo) {
        if (emojiGroupInfo == null) {
            return false;
        }
        emojiGroupInfo.field_flag &= -257;
        return true;
    }

    private static String duH() {
        AppMethodBeat.i(62745);
        String str = Mt(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Mt(EmojiGroupInfo.TYPE_CUSTOM) + " or " + Mt(EmojiGroupInfo.yao) + " or " + Mt(EmojiGroupInfo.yaq);
        AppMethodBeat.o(62745);
        return str;
    }

    private static final String duI() {
        AppMethodBeat.i(62746);
        String str = " ( " + Mt(EmojiGroupInfo.yao) + " and  ( status = '7' ) " + " ) ";
        AppMethodBeat.o(62746);
        return str;
    }

    private static final String Mt(int i) {
        AppMethodBeat.i(62747);
        String str = " ( type = '" + i + "' ) ";
        AppMethodBeat.o(62747);
        return str;
    }

    private static final String Mu(int i) {
        AppMethodBeat.i(62748);
        String str = " ( " + Mt(i) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
        AppMethodBeat.o(62748);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007d A:{Splitter:B:1:0x004a, ExcHandler: all (r0_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:14:0x006d, code skipped:
            r0 = r2;
     */
    /* JADX WARNING: Missing block: B:19:0x007d, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x007e, code skipped:
            r1 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean duJ() {
        Cursor cursor;
        AppMethodBeat.i(62749);
        String[] strArr = new String[]{EmojiGroupInfo.TYPE_SYSTEM, EmojiGroupInfo.yao, AppEventsConstants.EVENT_PARAM_VALUE_NO, "7"};
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "checkStoreEmojiSync:%s", "select sync from EmojiGroupInfo where (type= ? or type= ? ) and sync=? and status=?");
        Cursor cursor2 = null;
        try {
            cursor2 = this.bSd.a("select sync from EmojiGroupInfo where (type= ? or type= ? ) and sync=? and status=?", strArr, 2);
            if (cursor2 != null) {
                if (cursor2.moveToFirst()) {
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    AppMethodBeat.o(62749);
                    return true;
                }
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Exception e) {
            cursor = cursor2;
        } catch (Throwable th) {
        }
        AppMethodBeat.o(62749);
        return false;
        try {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "checkStoreEmojiSync fail.");
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62749);
            return false;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            AppMethodBeat.o(62749);
            throw th3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<String> duK() {
        AppMethodBeat.i(62750);
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[]{EmojiGroupInfo.yao, "1"};
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select productID from EmojiGroupInfo where type=? and sync=?", strArr, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62750);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62750);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToSyncStoreEmojiProductList. exception.%s", bo.dpG());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62750);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<String> duL() {
        AppMethodBeat.i(62751);
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, EmojiGroupInfo.yao, "7", EmojiGroupInfo.TYPE_SYSTEM, AppEventsConstants.EVENT_PARAM_VALUE_NO};
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)", strArr, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62751);
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62751);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToUploadStoreEmojiProductList. exception.%s", bo.dpG());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62751);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<EmojiGroupInfo> duM() {
        AppMethodBeat.i(62752);
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[]{EmojiGroupInfo.yao, "7", EmojiGroupInfo.TYPE_SYSTEM, AppEventsConstants.EVENT_PARAM_VALUE_NO};
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC", strArr, 2);
            ab.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62752);
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.d(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(62752);
            return arrayList;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62752);
        }
    }

    public final void duN() {
        AppMethodBeat.i(62753);
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
        EmojiGroupInfo bZ = bZ(String.valueOf(EmojiGroupInfo.yas), false);
        if (bZ == null) {
            bZ = new EmojiGroupInfo();
        } else {
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", bZ.toString());
        }
        bZ.field_productID = String.valueOf(EmojiGroupInfo.yas);
        bZ.field_packName = "emoji_custom_group";
        bZ.field_type = EmojiGroupInfo.TYPE_CUSTOM;
        bZ.field_status = 0;
        bZ.field_packStatus = 1;
        bZ.field_flag = 0;
        a(bZ);
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
        AppMethodBeat.o(62753);
    }

    public final boolean duO() {
        long iV;
        int mB;
        AppMethodBeat.i(62754);
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            iV = -1;
        }
        ArrayList duB = duB();
        if (!duB.isEmpty()) {
            Iterator it = duB.iterator();
            while (it.hasNext()) {
                EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
                if (!(emojiGroupInfo == null || bo.isNullOrNil(emojiGroupInfo.field_productID))) {
                    int Jp = Jp(emojiGroupInfo.field_productID);
                    if (emojiGroupInfo.field_count != Jp) {
                        emojiGroupInfo.field_count = Jp;
                        this.bSd.update("EmojiGroupInfo", emojiGroupInfo.Hl(), "productID=?", new String[]{emojiGroupInfo.field_productID});
                    }
                }
            }
        }
        if (hVar != null) {
            mB = hVar.mB(iV);
        } else {
            mB = -1;
        }
        b("event_update_group", 0, bo.dpG().toString());
        if (mB >= 0) {
            AppMethodBeat.o(62754);
            return true;
        }
        AppMethodBeat.o(62754);
        return false;
    }

    private int Jp(String str) {
        int i;
        AppMethodBeat.i(62755);
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
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", bo.l(e));
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
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
            AppMethodBeat.o(62755);
        }
        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(62755);
        return i;
    }
}
