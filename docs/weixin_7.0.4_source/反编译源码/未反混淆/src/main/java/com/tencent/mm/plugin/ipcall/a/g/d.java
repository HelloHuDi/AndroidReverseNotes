package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class d extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "IPCallAddressItem")};
    private static final String[] nzy = new String[]{"*", "rowid"};
    public e bSd;

    static {
        AppMethodBeat.i(21932);
        AppMethodBeat.o(21932);
    }

    public d(e eVar) {
        super(eVar, c.ccO, "IPCallAddressItem", null);
        this.bSd = eVar;
    }

    public final c OQ(String str) {
        AppMethodBeat.i(21923);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(21923);
            return null;
        }
        Cursor a = this.bSd.a("IPCallAddressItem", nzy, "contactId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                c cVar = new c();
                cVar.d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(21923);
                return cVar;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(21923);
            return null;
        } catch (Exception e) {
            ab.e("MicroMsg.IPCallAddressStorage", "getByContactId error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(21923);
        }
    }

    public final c OR(String str) {
        AppMethodBeat.i(21924);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(21924);
            return null;
        }
        Cursor a = this.bSd.a("IPCallAddressItem", nzy, "systemAddressBookUsername=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                c cVar = new c();
                cVar.d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(21924);
                return cVar;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(21924);
            return null;
        } catch (Exception e) {
            ab.d("MicroMsg.IPCallAddressStorage", "getByContactName error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(21924);
        }
    }

    public final c iU(long j) {
        AppMethodBeat.i(21925);
        Cursor a = this.bSd.a("IPCallAddressItem", nzy, "rowid=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                c cVar = new c();
                cVar.d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(21925);
                return cVar;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(21925);
            return null;
        } catch (Exception e) {
            ab.d("MicroMsg.IPCallAddressStorage", "getByLocalId error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(21925);
        }
    }

    public final ArrayList<c> bHY() {
        AppMethodBeat.i(21926);
        Cursor a = this.bSd.a("IPCallAddressItem", nzy, null, null, null, null, null, 2);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    ArrayList<c> arrayList = new ArrayList();
                    while (true) {
                        c cVar = new c();
                        cVar.d(a);
                        arrayList.add(cVar);
                        if (!a.moveToNext()) {
                            break;
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(21926);
                    return arrayList;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.IPCallAddressStorage", "getAllAddress, error: %s", e.getMessage());
                return null;
            } finally {
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(21926);
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.o(21926);
        return null;
    }

    public final Cursor bHZ() {
        AppMethodBeat.i(21927);
        Cursor query = this.bSd.query("IPCallAddressItem", nzy, null, null, null, null, "upper(sortKey) asc");
        AppMethodBeat.o(21927);
        return query;
    }

    public final Cursor OS(String str) {
        int i;
        Cursor OT;
        AppMethodBeat.i(21928);
        System.currentTimeMillis();
        for (i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i == 0) {
            OT = OT(str);
        } else {
            String str2;
            ArrayList Py = a.Py(str);
            Cursor OT2 = OT(str);
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
                ab.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", e.getMessage());
                if (OT2 != null) {
                    OT2.close();
                }
            } catch (Throwable th) {
                if (OT2 != null) {
                    OT2.close();
                }
                AppMethodBeat.o(21928);
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
        AppMethodBeat.o(21928);
        return OT;
    }

    private Cursor OT(String str) {
        AppMethodBeat.i(21929);
        Cursor query = this.bSd.query("IPCallAddressItem", nzy, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null, null, "upper(sortKey) asc");
        AppMethodBeat.o(21929);
        return query;
    }

    public final long iV(long j) {
        AppMethodBeat.i(21930);
        if (this.bSd instanceof h) {
            long iV = ((h) this.bSd).iV(j);
            AppMethodBeat.o(21930);
            return iV;
        }
        AppMethodBeat.o(21930);
        return -1;
    }

    public final void iW(long j) {
        AppMethodBeat.i(21931);
        if ((this.bSd instanceof h) && j != -1) {
            ((h) this.bSd).mB(j);
        }
        AppMethodBeat.o(21931);
    }
}
