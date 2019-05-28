package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.friend.a.l */
public final class C38033l {
    private static Map<String, String> gvw = null;

    /* renamed from: com.tencent.mm.plugin.account.friend.a.l$a */
    public enum C38034a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD;

        static {
            AppMethodBeat.m2505o(108362);
        }
    }

    public static void apP() {
        AppMethodBeat.m2504i(108363);
        C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
        AppMethodBeat.m2505o(108363);
    }

    public static boolean apQ() {
        AppMethodBeat.m2504i(108364);
        if (C1720g.m3536RP() == null || C1720g.m3536RP().mo5239Ry() == null) {
            C4990ab.m7412e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
            AppMethodBeat.m2505o(108364);
            return false;
        }
        boolean a = C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(12322, Boolean.TRUE), true);
        AppMethodBeat.m2505o(108364);
        return a;
    }

    public static boolean apR() {
        AppMethodBeat.m2504i(108365);
        C4990ab.m7417i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", C38033l.apS().toString());
        if (C38033l.apS() == C38034a.SUCC) {
            C4990ab.m7417i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", Boolean.valueOf(C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(12322, Boolean.FALSE), false)));
            if (C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(12322, Boolean.FALSE), false)) {
                AppMethodBeat.m2505o(108365);
                return false;
            }
            AppMethodBeat.m2505o(108365);
            return true;
        }
        AppMethodBeat.m2505o(108365);
        return false;
    }

    public static C38034a apS() {
        AppMethodBeat.m2504i(108366);
        C38034a c38034a;
        try {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(4097, (Object) "");
            String str2 = (String) C1720g.m3536RP().mo5239Ry().get(6, (Object) "");
            boolean Zc = C1853r.m3849Zc();
            C4990ab.m7416i("MicroMsg.FriendLogic", "isUpload " + Zc + " stat " + C1853r.m3822YD());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                c38034a = C38034a.NO_INIT;
                AppMethodBeat.m2505o(108366);
                return c38034a;
            } else if (str != null && str2 == null) {
                c38034a = C38034a.SET_MOBILE;
                AppMethodBeat.m2505o(108366);
                return c38034a;
            } else if (Zc) {
                c38034a = C38034a.SUCC;
                AppMethodBeat.m2505o(108366);
                return c38034a;
            } else {
                c38034a = C38034a.SUCC_UNLOAD;
                AppMethodBeat.m2505o(108366);
                return c38034a;
            }
        } catch (Exception e) {
            c38034a = C38034a.NO_INIT;
            AppMethodBeat.m2505o(108366);
            return c38034a;
        }
    }

    public static void apT() {
        AppMethodBeat.m2504i(108367);
        C1720g.m3536RP().mo5239Ry().set(4097, (Object) "");
        C1720g.m3536RP().mo5239Ry().set(6, (Object) "");
        AppMethodBeat.m2505o(108367);
    }

    public static String apU() {
        AppMethodBeat.m2504i(108368);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, (Object) "");
        AppMethodBeat.m2505o(108368);
        return str;
    }

    public static boolean apV() {
        AppMethodBeat.m2504i(108369);
        if (C1720g.m3531RK()) {
            int i;
            if (C38033l.apS() == C38034a.SUCC) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 == 0) {
                C4990ab.m7417i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", Boolean.FALSE);
                AppMethodBeat.m2505o(108369);
                return false;
            }
            if (C38033l.apQ()) {
                AppMethodBeat.m2505o(108369);
                return true;
            }
            C4990ab.m7417i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", Boolean.valueOf(C38033l.apQ()));
            AppMethodBeat.m2505o(108369);
            return false;
        }
        C4990ab.m7417i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", Boolean.valueOf(C1720g.m3531RK()));
        AppMethodBeat.m2505o(108369);
        return false;
    }

    public static boolean apW() {
        return true;
    }

    public static void apX() {
    }

    /* renamed from: a */
    public static boolean m64344a(String str, Context context, byte[] bArr) {
        AppMethodBeat.m2504i(108371);
        boolean b = C46482a.m87691b(str, context, bArr);
        AppMethodBeat.m2505o(108371);
        return b;
    }

    public static void apY() {
        AppMethodBeat.m2504i(108372);
        C18818b c18818b = (C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg();
        int delete = c18818b.fni.delete("addr_upload2", null, null);
        C4990ab.m7410d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            c18818b.mo10120b(5, c18818b, null);
        }
        AppMethodBeat.m2505o(108372);
    }

    public static void apZ() {
        AppMethodBeat.m2504i(108373);
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) ((C6982j) C1720g.m3528K(C6982j.class)).bOq().bOw()).iterator();
        while (it.hasNext()) {
            C7569ax c7569ax = (C7569ax) it.next();
            C5135a Rn = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(c7569ax.field_msgContent);
            if (Rn != null && (Rn.scene == 10 || Rn.scene == 11)) {
                hashSet.add(c7569ax.field_talker);
            }
        }
        C4990ab.m7410d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            C38033l.m64350we((String) it2.next());
        }
        AppMethodBeat.m2505o(108373);
    }

    /* renamed from: we */
    private static void m64350we(String str) {
        AppMethodBeat.m2504i(108374);
        C4990ab.m7417i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", Long.valueOf(0), str);
        C4990ab.m7416i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(((C6982j) C1720g.m3528K(C6982j.class)).bOp().mo7911p(0, str))));
        C4990ab.m7416i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(((C6982j) C1720g.m3528K(C6982j.class)).bOq().mo15227QS(str))));
        AppMethodBeat.m2505o(108374);
    }

    /* renamed from: ar */
    public static void m64345ar(List<String> list) {
        AppMethodBeat.m2504i(108375);
        if (list.size() == 0) {
            AppMethodBeat.m2505o(108375);
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) ((C6982j) C1720g.m3528K(C6982j.class)).bOq().bOw()).iterator();
        while (it.hasNext()) {
            C7569ax c7569ax = (C7569ax) it.next();
            C5135a Rn = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(c7569ax.field_msgContent);
            if (Rn != null) {
                String str = Rn.xZj;
                String str2 = Rn.xZi;
                if ((Rn.scene == 10 || Rn.scene == 11) && (list.contains(str) || list.contains(str2))) {
                    hashSet.add(c7569ax.field_talker);
                }
            }
        }
        C4990ab.m7410d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            C38033l.m64350we((String) it2.next());
        }
        AppMethodBeat.m2505o(108375);
    }

    /* renamed from: wf */
    public static String m64351wf(String str) {
        AppMethodBeat.m2504i(108376);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.m2505o(108376);
            return str2;
        }
        C18818b c18818b = (C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg();
        Cursor a = c18818b.fni.mo10104a("select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + C18817a.m29385vR(str) + "\"", null, 2);
        if (a == null) {
            str2 = "";
            AppMethodBeat.m2505o(108376);
            return str2;
        }
        str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(0);
        }
        a.close();
        AppMethodBeat.m2505o(108376);
        return str2;
    }

    /* renamed from: as */
    public static void m64346as(List<C18817a> list) {
        AppMethodBeat.m2504i(108377);
        if (list == null) {
            C4990ab.m7412e("MicroMsg.FriendLogic", "sync address book failed, null info list");
            AppMethodBeat.m2505o(108377);
            return;
        }
        ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34085aa(list);
        AppMethodBeat.m2505o(108377);
    }

    /* renamed from: at */
    public static void m64347at(List<String> list) {
        AppMethodBeat.m2504i(108378);
        if (list == null) {
            C4990ab.m7412e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
            AppMethodBeat.m2505o(108378);
            return;
        }
        ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34088aq(list);
        AppMethodBeat.m2505o(108378);
    }

    public static List<String> aqa() {
        AppMethodBeat.m2504i(108379);
        Cursor a = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).fni.mo10104a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0));
        }
        a.close();
        AppMethodBeat.m2505o(108379);
        return arrayList;
    }

    public static List<String> aqb() {
        AppMethodBeat.m2504i(108380);
        Cursor a = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).fni.mo10104a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            String ws = C46482a.m87698ws(a.getString(0));
            if (C46482a.aij(ws)) {
                arrayList.add(ws);
            }
        }
        a.close();
        AppMethodBeat.m2505o(108380);
        return arrayList;
    }

    /* renamed from: mX */
    public static boolean m64349mX(int i) {
        AppMethodBeat.m2504i(108381);
        C26584am mY = ((C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg()).mo44366mY(i);
        boolean mZ = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73285mZ(i);
        if (mY == null) {
            AppMethodBeat.m2505o(108381);
            return false;
        } else if (mY.gwz == 1 || mZ) {
            AppMethodBeat.m2505o(108381);
            return true;
        } else {
            AppMethodBeat.m2505o(108381);
            return false;
        }
    }

    /* renamed from: b */
    public static Bitmap m64348b(String str, Context context) {
        AppMethodBeat.m2504i(108370);
        Bitmap a = C46482a.m87690a(str, context, false);
        AppMethodBeat.m2505o(108370);
        return a;
    }
}
