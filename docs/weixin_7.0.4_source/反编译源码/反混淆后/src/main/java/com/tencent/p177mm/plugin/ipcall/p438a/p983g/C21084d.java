package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.d */
public final class C21084d extends C7563j<C21083c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C21083c.ccO, "IPCallAddressItem")};
    private static final String[] nzy = new String[]{"*", "rowid"};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(21932);
        AppMethodBeat.m2505o(21932);
    }

    public C21084d(C4927e c4927e) {
        super(c4927e, C21083c.ccO, "IPCallAddressItem", null);
        this.bSd = c4927e;
    }

    /* renamed from: OQ */
    public final C21083c mo36404OQ(String str) {
        AppMethodBeat.m2504i(21923);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(21923);
            return null;
        }
        Cursor a = this.bSd.mo10105a("IPCallAddressItem", nzy, "contactId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                C21083c c21083c = new C21083c();
                c21083c.mo8995d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(21923);
                return c21083c;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(21923);
            return null;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.IPCallAddressStorage", "getByContactId error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(21923);
        }
    }

    /* renamed from: OR */
    public final C21083c mo36405OR(String str) {
        AppMethodBeat.m2504i(21924);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(21924);
            return null;
        }
        Cursor a = this.bSd.mo10105a("IPCallAddressItem", nzy, "systemAddressBookUsername=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                C21083c c21083c = new C21083c();
                c21083c.mo8995d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(21924);
                return c21083c;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(21924);
            return null;
        } catch (Exception e) {
            C4990ab.m7411d("MicroMsg.IPCallAddressStorage", "getByContactName error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(21924);
        }
    }

    /* renamed from: iU */
    public final C21083c mo36409iU(long j) {
        AppMethodBeat.m2504i(21925);
        Cursor a = this.bSd.mo10105a("IPCallAddressItem", nzy, "rowid=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                C21083c c21083c = new C21083c();
                c21083c.mo8995d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(21925);
                return c21083c;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(21925);
            return null;
        } catch (Exception e) {
            C4990ab.m7411d("MicroMsg.IPCallAddressStorage", "getByLocalId error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(21925);
        }
    }

    public final ArrayList<C21083c> bHY() {
        AppMethodBeat.m2504i(21926);
        Cursor a = this.bSd.mo10105a("IPCallAddressItem", nzy, null, null, null, null, null, 2);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    ArrayList<C21083c> arrayList = new ArrayList();
                    while (true) {
                        C21083c c21083c = new C21083c();
                        c21083c.mo8995d(a);
                        arrayList.add(c21083c);
                        if (!a.moveToNext()) {
                            break;
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(21926);
                    return arrayList;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallAddressStorage", "getAllAddress, error: %s", e.getMessage());
                return null;
            } finally {
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(21926);
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.m2505o(21926);
        return null;
    }

    public final Cursor bHZ() {
        AppMethodBeat.m2504i(21927);
        Cursor query = this.bSd.query("IPCallAddressItem", nzy, null, null, null, null, "upper(sortKey) asc");
        AppMethodBeat.m2505o(21927);
        return query;
    }

    /* renamed from: OS */
    public final Cursor mo36406OS(String str) {
        int i;
        Cursor OT;
        AppMethodBeat.m2504i(21928);
        System.currentTimeMillis();
        for (i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i == 0) {
            OT = m32392OT(str);
        } else {
            String str2;
            ArrayList Py = C46041a.m85639Py(str);
            Cursor OT2 = m32392OT(str);
            try {
                if (OT2.moveToFirst()) {
                    while (!OT2.isAfterLast()) {
                        Py.add(OT2.getString(OT2.getColumnIndex("contactId")));
                        OT2.moveToNext();
                    }
                }
                if (OT2 != null) {
                    OT2.close();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", e.getMessage());
                if (OT2 != null) {
                    OT2.close();
                }
            } catch (Throwable th) {
                if (OT2 != null) {
                    OT2.close();
                }
                AppMethodBeat.m2505o(21928);
            }
            String str3 = "";
            Iterator it = Py.iterator();
            while (true) {
                str2 = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str2 + ((String) it.next()) + ",";
            }
            if (str2.lastIndexOf(",") >= 0) {
                str2 = str2.substring(0, str2.lastIndexOf(","));
            }
            String str4 = null;
            String str5 = null;
            OT = this.bSd.query("IPCallAddressItem", nzy, "contactId IN ".concat(String.valueOf("(" + str2 + ")")), null, str4, str5, "upper(sortKey) asc");
        }
        System.currentTimeMillis();
        AppMethodBeat.m2505o(21928);
        return OT;
    }

    /* renamed from: OT */
    private Cursor m32392OT(String str) {
        AppMethodBeat.m2504i(21929);
        Cursor query = this.bSd.query("IPCallAddressItem", nzy, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null, null, "upper(sortKey) asc");
        AppMethodBeat.m2505o(21929);
        return query;
    }

    /* renamed from: iV */
    public final long mo36410iV(long j) {
        AppMethodBeat.m2504i(21930);
        if (this.bSd instanceof C7480h) {
            long iV = ((C7480h) this.bSd).mo15639iV(j);
            AppMethodBeat.m2505o(21930);
            return iV;
        }
        AppMethodBeat.m2505o(21930);
        return -1;
    }

    /* renamed from: iW */
    public final void mo36411iW(long j) {
        AppMethodBeat.m2504i(21931);
        if ((this.bSd instanceof C7480h) && j != -1) {
            ((C7480h) this.bSd).mo15640mB(j);
        }
        AppMethodBeat.m2505o(21931);
    }
}
