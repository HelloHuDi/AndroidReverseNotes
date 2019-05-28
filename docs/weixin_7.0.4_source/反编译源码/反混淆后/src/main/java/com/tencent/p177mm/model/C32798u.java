package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.u */
public final class C32798u {
    private static final List<C18639a> fkZ = new ArrayList();

    /* renamed from: com.tencent.mm.model.u$a */
    public interface C18639a {
        /* renamed from: a */
        boolean mo33894a(String str, String str2, PInt pInt);
    }

    /* renamed from: a */
    private static int m53580a(String str, Cursor cursor) {
        int i;
        AppMethodBeat.m2504i(59879);
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
            AppMethodBeat.m2505o(59879);
            return 0;
        }
        Cursor apj = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apj(str);
        if (apj == null) {
            C4990ab.m7420w("MicroMsg.ConversationLogic", "cursor is null, return");
            AppMethodBeat.m2505o(59879);
            return i;
        }
        apj.moveToFirst();
        while (!apj.isAfterLast()) {
            int i2;
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(apj.getString(0));
            if (aoO == null || aoO.dua != 0) {
                i2 = i;
            } else {
                i2 = i - apj.getInt(1);
                C4990ab.m7411d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", aoO.field_username, Integer.valueOf(i2));
            }
            apj.moveToNext();
            i = i2;
        }
        apj.close();
        i = Math.max(0, i);
        AppMethodBeat.m2505o(59879);
        return i;
    }

    /* renamed from: nR */
    public static int m53585nR(String str) {
        AppMethodBeat.m2504i(59880);
        int e = C32798u.m53584e(str, new LinkedList());
        AppMethodBeat.m2505o(59880);
        return e;
    }

    /* renamed from: e */
    public static int m53584e(String str, List<String> list) {
        AppMethodBeat.m2504i(59881);
        if (C1720g.m3531RK()) {
            long yz = C5046bo.m7588yz();
            Cursor A = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15764A(str, list);
            int a = C32798u.m53580a(str, A);
            A.close();
            String str2 = "MicroMsg.ConversationLogic";
            String str3 = "get count with black list use %d ms, blacklist size:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(C5046bo.m7525az(yz));
            objArr[1] = Integer.valueOf(list == null ? -1 : list.size());
            C4990ab.m7417i(str2, str3, objArr);
            AppMethodBeat.m2505o(59881);
            return a;
        }
        C4990ab.m7420w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
        AppMethodBeat.m2505o(59881);
        return 0;
    }

    /* renamed from: ac */
    public static int m53582ac(String str, String str2) {
        AppMethodBeat.m2504i(59882);
        if (C1720g.m3531RK()) {
            int i;
            Cursor ic = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15823ic(str, str2);
            if (ic == null || ic.getCount() <= 0) {
                i = 0;
            } else {
                ic.moveToFirst();
                i = ic.getInt(0);
            }
            if (ic != null) {
                ic.close();
            }
            AppMethodBeat.m2505o(59882);
            return i;
        }
        C4990ab.m7420w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
        AppMethodBeat.m2505o(59882);
        return 0;
    }

    /* renamed from: P */
    public static List<String> m53579P(String str, int i) {
        AppMethodBeat.m2504i(59884);
        List<String> list = null;
        if (C1720g.m3531RK()) {
            Cursor eo = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15820eo(str, i);
            if (eo.moveToNext()) {
                ArrayList arrayList = new ArrayList();
                do {
                    C4990ab.m7411d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", eo.getString(0));
                    arrayList.add(eo.getString(0));
                } while (eo.moveToNext());
                list = arrayList;
            }
            eo.close();
            if (list != null) {
                eo = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apj(str);
                if (eo != null) {
                    eo.moveToFirst();
                    while (!eo.isAfterLast()) {
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(eo.getString(0));
                        if (aoO != null && aoO.dua == 0) {
                            C4990ab.m7411d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", aoO.mo16706Oi());
                            list.remove(aoO.mo16706Oi());
                        }
                        eo.moveToNext();
                    }
                    eo.close();
                }
            }
        } else {
            C4990ab.m7420w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
        }
        AppMethodBeat.m2505o(59884);
        return list;
    }

    /* renamed from: ad */
    public static int m53583ad(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(59885);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59885);
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
                        C18639a c18639a = (C18639a) fkZ.get(i3);
                        if (c18639a != null) {
                            a = c18639a.mo33894a(str, str2, pInt);
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
                        AppMethodBeat.m2505o(59885);
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
        AppMethodBeat.m2505o(59885);
        return i2;
    }

    static {
        AppMethodBeat.m2504i(59887);
        AppMethodBeat.m2505o(59887);
    }

    /* renamed from: a */
    public static void m53581a(C18639a c18639a) {
        AppMethodBeat.m2504i(59886);
        Assert.assertNotNull(c18639a);
        synchronized (fkZ) {
            try {
                fkZ.add(c18639a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59886);
            }
        }
    }

    /* renamed from: nS */
    public static int m53586nS(String str) {
        AppMethodBeat.m2504i(59883);
        if (C1720g.m3531RK()) {
            int i;
            long yz = C5046bo.m7588yz();
            Cursor apk = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apk(str);
            if (apk.getCount() > 0) {
                apk.moveToFirst();
                i = apk.getInt(0);
            } else {
                i = 0;
            }
            apk.close();
            if (i <= 0) {
                AppMethodBeat.m2505o(59883);
                return 0;
            }
            apk = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apj(str);
            if (apk == null) {
                C4990ab.m7417i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cursor is null!cost %d ms count:%s ", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i));
                AppMethodBeat.m2505o(59883);
                return i;
            }
            apk.moveToFirst();
            while (!apk.isAfterLast()) {
                int i2;
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(apk.getString(0));
                if (aoO == null || aoO.dua != 0) {
                    i2 = i;
                } else {
                    i2 = i - 1;
                }
                apk.moveToNext();
                i = i2;
            }
            apk.close();
            C4990ab.m7417i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms count:%s ", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i));
            int max = Math.max(0, i);
            AppMethodBeat.m2505o(59883);
            return max;
        }
        C4990ab.m7420w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
        AppMethodBeat.m2505o(59883);
        return 0;
    }
}
