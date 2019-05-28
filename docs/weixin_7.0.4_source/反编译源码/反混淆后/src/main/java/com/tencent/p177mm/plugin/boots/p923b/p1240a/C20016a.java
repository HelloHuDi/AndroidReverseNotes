package com.tencent.p177mm.plugin.boots.p923b.p1240a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.plugin.boots.p348a.C2678a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.boots.b.a.a */
public final class C20016a extends C7563j<C2678a> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C2678a.ccO, "ActiveInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(90537);
        AppMethodBeat.m2505o(90537);
    }

    public C20016a(C4927e c4927e) {
        super(c4927e, C2678a.ccO, "ActiveInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    public final String getTableName() {
        return "ActiveInfo";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: rU */
    public final int mo35255rU(int i) {
        Object obj;
        int i2;
        String str;
        String[] strArr;
        long insert;
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(90534);
        String str2 = "key=?";
        String[] strArr2 = new String[]{String.valueOf(i)};
        C2678a c2678a = new C2678a();
        Cursor query;
        try {
            query = this.bSd.query("ActiveInfo", null, str2, strArr2, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c2678a.mo8995d(query);
                        obj = null;
                        if (query != null) {
                            query.close();
                        }
                        i2 = (c2678a.field_useTime >= C5046bo.dpC() - 86400000 || c2678a.field_useTime > C5046bo.dpC()) ? c2678a.field_useTime >= C5046bo.dpC() - 86400000 ? c2678a.field_dau > 0 ? c2678a.field_dau : 1 : 1 : c2678a.field_dau + 1;
                        c2678a.field_useTime = System.currentTimeMillis();
                        c2678a.field_dau = i2;
                        c2678a.field_mau = 1;
                        str = "key=?";
                        strArr = new String[]{String.valueOf(i)};
                        if (obj != null) {
                            insert = this.bSd.insert("ActiveInfo", "key", c2678a.mo10098Hl());
                        } else {
                            insert = (long) this.bSd.update("ActiveInfo", c2678a.mo10098Hl(), str, strArr);
                        }
                        if (insert < 0) {
                            C4990ab.m7420w("MicroMsg.Tinker.ActiveInfoStorage", "update tinker info failed");
                        }
                        AppMethodBeat.m2505o(90534);
                        return i2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    obj = null;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "touch active key failed.", new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                        if (c2678a.field_useTime >= C5046bo.dpC() - 86400000) {
                        }
                        if (c2678a.field_useTime >= C5046bo.dpC() - 86400000) {
                        }
                        c2678a.field_useTime = System.currentTimeMillis();
                        c2678a.field_dau = i2;
                        c2678a.field_mau = 1;
                        str = "key=?";
                        strArr = new String[]{String.valueOf(i)};
                        if (obj != null) {
                        }
                        if (insert < 0) {
                        }
                        AppMethodBeat.m2505o(90534);
                        return i2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(90534);
                        throw th;
                    }
                }
            }
            obj = 1;
            try {
                c2678a.field_key = i;
                if (query != null) {
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            obj = null;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(90534);
            throw th;
        }
        if (c2678a.field_useTime >= C5046bo.dpC() - 86400000) {
        }
        if (c2678a.field_useTime >= C5046bo.dpC() - 86400000) {
        }
        c2678a.field_useTime = System.currentTimeMillis();
        c2678a.field_dau = i2;
        c2678a.field_mau = 1;
        str = "key=?";
        strArr = new String[]{String.valueOf(i)};
        if (obj != null) {
        }
        if (insert < 0) {
        }
        AppMethodBeat.m2505o(90534);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: rV */
    public final C2678a mo35256rV(int i) {
        Throwable e;
        AppMethodBeat.m2504i(90535);
        C2678a c2678a = new C2678a();
        Cursor query;
        try {
            query = this.bSd.query("ActiveInfo", null, "key =?", new String[]{String.valueOf(i)}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c2678a.mo8995d(query);
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "getActiveInfoByKey %s failed.", Integer.toHexString(i));
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(90535);
                        return c2678a;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(90535);
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(90535);
            throw e;
        }
        AppMethodBeat.m2505o(90535);
        return c2678a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<C2678a> aVJ() {
        AppMethodBeat.m2504i(90536);
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a("select * from ActiveInfo where useTime >= ?", new String[]{String.valueOf(C5046bo.dpC() - 86400000)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(90536);
                return arrayList;
            }
            do {
                C2678a c2678a = new C2678a();
                c2678a.mo8995d(cursor);
                arrayList.add(c2678a);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(90536);
            return arrayList;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "getDayActiveFeature failed.", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(90536);
        }
    }
}
