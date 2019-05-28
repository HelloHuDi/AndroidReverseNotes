package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class u {
    private static final List<a> fkZ = new ArrayList();

    public interface a {
        boolean a(String str, String str2, PInt pInt);
    }

    private static int a(String str, Cursor cursor) {
        int i;
        AppMethodBeat.i(59879);
        if (cursor == null || cursor.getCount() <= 0) {
            i = 0;
        } else {
            cursor.moveToFirst();
            i = cursor.getInt(0);
        }
        if (cursor != null) {
            cursor.close();
        }
        if (i <= 0) {
            AppMethodBeat.o(59879);
            return 0;
        }
        Cursor apj = ((j) g.K(j.class)).XR().apj(str);
        if (apj == null) {
            ab.w("MicroMsg.ConversationLogic", "cursor is null, return");
            AppMethodBeat.o(59879);
            return i;
        }
        apj.moveToFirst();
        while (!apj.isAfterLast()) {
            int i2;
            ad aoO = ((j) g.K(j.class)).XM().aoO(apj.getString(0));
            if (aoO == null || aoO.dua != 0) {
                i2 = i;
            } else {
                i2 = i - apj.getInt(1);
                ab.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", aoO.field_username, Integer.valueOf(i2));
            }
            apj.moveToNext();
            i = i2;
        }
        apj.close();
        i = Math.max(0, i);
        AppMethodBeat.o(59879);
        return i;
    }

    public static int nR(String str) {
        AppMethodBeat.i(59880);
        int e = e(str, new LinkedList());
        AppMethodBeat.o(59880);
        return e;
    }

    public static int e(String str, List<String> list) {
        AppMethodBeat.i(59881);
        if (g.RK()) {
            long yz = bo.yz();
            Cursor A = ((j) g.K(j.class)).XR().A(str, list);
            int a = a(str, A);
            A.close();
            String str2 = "MicroMsg.ConversationLogic";
            String str3 = "get count with black list use %d ms, blacklist size:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(bo.az(yz));
            objArr[1] = Integer.valueOf(list == null ? -1 : list.size());
            ab.i(str2, str3, objArr);
            AppMethodBeat.o(59881);
            return a;
        }
        ab.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
        AppMethodBeat.o(59881);
        return 0;
    }

    public static int ac(String str, String str2) {
        AppMethodBeat.i(59882);
        if (g.RK()) {
            int i;
            Cursor ic = ((j) g.K(j.class)).XR().ic(str, str2);
            if (ic == null || ic.getCount() <= 0) {
                i = 0;
            } else {
                ic.moveToFirst();
                i = ic.getInt(0);
            }
            if (ic != null) {
                ic.close();
            }
            AppMethodBeat.o(59882);
            return i;
        }
        ab.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
        AppMethodBeat.o(59882);
        return 0;
    }

    public static List<String> P(String str, int i) {
        AppMethodBeat.i(59884);
        List<String> list = null;
        if (g.RK()) {
            Cursor eo = ((j) g.K(j.class)).XR().eo(str, i);
            if (eo.moveToNext()) {
                ArrayList arrayList = new ArrayList();
                do {
                    ab.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", eo.getString(0));
                    arrayList.add(eo.getString(0));
                } while (eo.moveToNext());
                list = arrayList;
            }
            eo.close();
            if (list != null) {
                eo = ((j) g.K(j.class)).XR().apj(str);
                if (eo != null) {
                    eo.moveToFirst();
                    while (!eo.isAfterLast()) {
                        ad aoO = ((j) g.K(j.class)).XM().aoO(eo.getString(0));
                        if (aoO != null && aoO.dua == 0) {
                            ab.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", aoO.Oi());
                            list.remove(aoO.Oi());
                        }
                        eo.moveToNext();
                    }
                    eo.close();
                }
            }
        } else {
            ab.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
        }
        AppMethodBeat.o(59884);
        return list;
    }

    public static int ad(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(59885);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59885);
            return 0;
        }
        int i2;
        if ("notification_messages".equals(str)) {
            i2 = 8;
        } else if (str2 == null || !str2.endsWith("@chatroom")) {
            boolean a;
            PInt pInt = new PInt();
            synchronized (fkZ) {
                int i3 = 0;
                boolean z = false;
                while (i3 < fkZ.size()) {
                    try {
                        a aVar = (a) fkZ.get(i3);
                        if (aVar != null) {
                            a = aVar.a(str, str2, pInt);
                            if (a) {
                                i = pInt.value;
                                break;
                            }
                        } else {
                            a = z;
                        }
                        i3++;
                        z = a;
                    } catch (Throwable th) {
                        AppMethodBeat.o(59885);
                    }
                }
                a = z;
            }
            if (a) {
                i2 = i;
            } else {
                i2 = 1;
            }
        } else {
            i2 = 2;
        }
        AppMethodBeat.o(59885);
        return i2;
    }

    static {
        AppMethodBeat.i(59887);
        AppMethodBeat.o(59887);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(59886);
        Assert.assertNotNull(aVar);
        synchronized (fkZ) {
            try {
                fkZ.add(aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59886);
            }
        }
    }

    public static int nS(String str) {
        AppMethodBeat.i(59883);
        if (g.RK()) {
            int i;
            long yz = bo.yz();
            Cursor apk = ((j) g.K(j.class)).XR().apk(str);
            if (apk.getCount() > 0) {
                apk.moveToFirst();
                i = apk.getInt(0);
            } else {
                i = 0;
            }
            apk.close();
            if (i <= 0) {
                AppMethodBeat.o(59883);
                return 0;
            }
            apk = ((j) g.K(j.class)).XR().apj(str);
            if (apk == null) {
                ab.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cursor is null!cost %d ms count:%s ", Long.valueOf(bo.az(yz)), Integer.valueOf(i));
                AppMethodBeat.o(59883);
                return i;
            }
            apk.moveToFirst();
            while (!apk.isAfterLast()) {
                int i2;
                ad aoO = ((j) g.K(j.class)).XM().aoO(apk.getString(0));
                if (aoO == null || aoO.dua != 0) {
                    i2 = i;
                } else {
                    i2 = i - 1;
                }
                apk.moveToNext();
                i = i2;
            }
            apk.close();
            ab.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms count:%s ", Long.valueOf(bo.az(yz)), Integer.valueOf(i));
            int max = Math.max(0, i);
            AppMethodBeat.o(59883);
            return max;
        }
        ab.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
        AppMethodBeat.o(59883);
        return 0;
    }
}
