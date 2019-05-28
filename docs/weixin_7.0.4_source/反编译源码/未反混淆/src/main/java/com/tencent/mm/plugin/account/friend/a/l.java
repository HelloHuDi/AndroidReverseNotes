package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ax;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l {
    private static Map<String, String> gvw = null;

    public enum a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD;

        static {
            AppMethodBeat.o(108362);
        }
    }

    public static void apP() {
        AppMethodBeat.i(108363);
        g.RP().Ry().set(12322, Boolean.TRUE);
        AppMethodBeat.o(108363);
    }

    public static boolean apQ() {
        AppMethodBeat.i(108364);
        if (g.RP() == null || g.RP().Ry() == null) {
            ab.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMKernel.storage() is null!!!");
            AppMethodBeat.o(108364);
            return false;
        }
        boolean a = bo.a((Boolean) g.RP().Ry().get(12322, Boolean.TRUE), true);
        AppMethodBeat.o(108364);
        return a;
    }

    public static boolean apR() {
        AppMethodBeat.i(108365);
        ab.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", apS().toString());
        if (apS() == a.SUCC) {
            ab.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", Boolean.valueOf(bo.a((Boolean) g.RP().Ry().get(12322, Boolean.FALSE), false)));
            if (bo.a((Boolean) g.RP().Ry().get(12322, Boolean.FALSE), false)) {
                AppMethodBeat.o(108365);
                return false;
            }
            AppMethodBeat.o(108365);
            return true;
        }
        AppMethodBeat.o(108365);
        return false;
    }

    public static a apS() {
        AppMethodBeat.i(108366);
        a aVar;
        try {
            String str = (String) g.RP().Ry().get(4097, (Object) "");
            String str2 = (String) g.RP().Ry().get(6, (Object) "");
            boolean Zc = r.Zc();
            ab.i("MicroMsg.FriendLogic", "isUpload " + Zc + " stat " + r.YD());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                aVar = a.NO_INIT;
                AppMethodBeat.o(108366);
                return aVar;
            } else if (str != null && str2 == null) {
                aVar = a.SET_MOBILE;
                AppMethodBeat.o(108366);
                return aVar;
            } else if (Zc) {
                aVar = a.SUCC;
                AppMethodBeat.o(108366);
                return aVar;
            } else {
                aVar = a.SUCC_UNLOAD;
                AppMethodBeat.o(108366);
                return aVar;
            }
        } catch (Exception e) {
            aVar = a.NO_INIT;
            AppMethodBeat.o(108366);
            return aVar;
        }
    }

    public static void apT() {
        AppMethodBeat.i(108367);
        g.RP().Ry().set(4097, (Object) "");
        g.RP().Ry().set(6, (Object) "");
        AppMethodBeat.o(108367);
    }

    public static String apU() {
        AppMethodBeat.i(108368);
        String str = (String) g.RP().Ry().get(6, (Object) "");
        AppMethodBeat.o(108368);
        return str;
    }

    public static boolean apV() {
        AppMethodBeat.i(108369);
        if (g.RK()) {
            int i;
            if (apS() == a.SUCC) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 == 0) {
                ab.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", Boolean.FALSE);
                AppMethodBeat.o(108369);
                return false;
            }
            if (apQ()) {
                AppMethodBeat.o(108369);
                return true;
            }
            ab.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", Boolean.valueOf(apQ()));
            AppMethodBeat.o(108369);
            return false;
        }
        ab.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", Boolean.valueOf(g.RK()));
        AppMethodBeat.o(108369);
        return false;
    }

    public static boolean apW() {
        return true;
    }

    public static void apX() {
    }

    public static boolean a(String str, Context context, byte[] bArr) {
        AppMethodBeat.i(108371);
        boolean b = com.tencent.mm.pluginsdk.a.b(str, context, bArr);
        AppMethodBeat.o(108371);
        return b;
    }

    public static void apY() {
        AppMethodBeat.i(108372);
        b bVar = (b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
        int delete = bVar.fni.delete("addr_upload2", null, null);
        ab.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            bVar.b(5, bVar, null);
        }
        AppMethodBeat.o(108372);
    }

    public static void apZ() {
        AppMethodBeat.i(108373);
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) ((j) g.K(j.class)).bOq().bOw()).iterator();
        while (it.hasNext()) {
            ax axVar = (ax) it.next();
            com.tencent.mm.storage.bi.a Rn = ((j) g.K(j.class)).bOr().Rn(axVar.field_msgContent);
            if (Rn != null && (Rn.scene == 10 || Rn.scene == 11)) {
                hashSet.add(axVar.field_talker);
            }
        }
        ab.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            we((String) it2.next());
        }
        AppMethodBeat.o(108373);
    }

    private static void we(String str) {
        AppMethodBeat.i(108374);
        ab.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", Long.valueOf(0), str);
        ab.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(((j) g.K(j.class)).bOp().p(0, str))));
        ab.i("MicroMsg.FriendLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(((j) g.K(j.class)).bOq().QS(str))));
        AppMethodBeat.o(108374);
    }

    public static void ar(List<String> list) {
        AppMethodBeat.i(108375);
        if (list.size() == 0) {
            AppMethodBeat.o(108375);
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) ((j) g.K(j.class)).bOq().bOw()).iterator();
        while (it.hasNext()) {
            ax axVar = (ax) it.next();
            com.tencent.mm.storage.bi.a Rn = ((j) g.K(j.class)).bOr().Rn(axVar.field_msgContent);
            if (Rn != null) {
                String str = Rn.xZj;
                String str2 = Rn.xZi;
                if ((Rn.scene == 10 || Rn.scene == 11) && (list.contains(str) || list.contains(str2))) {
                    hashSet.add(axVar.field_talker);
                }
            }
        }
        ab.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            we((String) it2.next());
        }
        AppMethodBeat.o(108375);
    }

    public static String wf(String str) {
        AppMethodBeat.i(108376);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.o(108376);
            return str2;
        }
        b bVar = (b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
        Cursor a = bVar.fni.a("select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + a.vR(str) + "\"", null, 2);
        if (a == null) {
            str2 = "";
            AppMethodBeat.o(108376);
            return str2;
        }
        str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(0);
        }
        a.close();
        AppMethodBeat.o(108376);
        return str2;
    }

    public static void as(List<a> list) {
        AppMethodBeat.i(108377);
        if (list == null) {
            ab.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
            AppMethodBeat.o(108377);
            return;
        }
        ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aa(list);
        AppMethodBeat.o(108377);
    }

    public static void at(List<String> list) {
        AppMethodBeat.i(108378);
        if (list == null) {
            ab.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
            AppMethodBeat.o(108378);
            return;
        }
        ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).aq(list);
        AppMethodBeat.o(108378);
    }

    public static List<String> aqa() {
        AppMethodBeat.i(108379);
        Cursor a = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).fni.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0));
        }
        a.close();
        AppMethodBeat.o(108379);
        return arrayList;
    }

    public static List<String> aqb() {
        AppMethodBeat.i(108380);
        Cursor a = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).fni.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            String ws = com.tencent.mm.pluginsdk.a.ws(a.getString(0));
            if (com.tencent.mm.pluginsdk.a.aij(ws)) {
                arrayList.add(ws);
            }
        }
        a.close();
        AppMethodBeat.o(108380);
        return arrayList;
    }

    public static boolean mX(int i) {
        AppMethodBeat.i(108381);
        am mY = ((an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).mY(i);
        boolean mZ = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).mZ(i);
        if (mY == null) {
            AppMethodBeat.o(108381);
            return false;
        } else if (mY.gwz == 1 || mZ) {
            AppMethodBeat.o(108381);
            return true;
        } else {
            AppMethodBeat.o(108381);
            return false;
        }
    }

    public static Bitmap b(String str, Context context) {
        AppMethodBeat.i(108370);
        Bitmap a = com.tencent.mm.pluginsdk.a.a(str, context, false);
        AppMethodBeat.o(108370);
        return a;
    }
}
