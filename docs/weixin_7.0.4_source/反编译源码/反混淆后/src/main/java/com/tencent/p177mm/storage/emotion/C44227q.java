package com.tencent.p177mm.storage.emotion;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.storage.emotion.q */
public final class C44227q extends C7563j<SmileyInfo> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(SmileyInfo.ccO, "SmileyInfo")};
    private static final String[] ybd = new String[]{"key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", DownloadInfo.FILENAME};
    private static final String[] ybe = new String[]{"key"};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(62886);
        AppMethodBeat.m2505o(62886);
    }

    public C44227q(C4927e c4927e) {
        this(c4927e, SmileyInfo.ccO, "SmileyInfo");
    }

    private C44227q(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<SmileyInfo> bjO() {
        Throwable e;
        AppMethodBeat.m2504i(62884);
        ArrayList arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.bSd.mo10105a("SmileyInfo", ybd, "flag=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            SmileyInfo smileyInfo = new SmileyInfo();
                            smileyInfo.mo8995d(a);
                            smileyInfo.field_position = -1;
                            arrayList.add(smileyInfo);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7412e("MicroMsg.emoji.NewSmileyInfoStorage", C5046bo.m7574l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62884);
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62884);
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
            }
            AppMethodBeat.m2505o(62884);
            throw e;
        }
        AppMethodBeat.m2505o(62884);
        return arrayList;
    }

    /* renamed from: an */
    public final boolean mo69867an(ArrayList<SmileyInfo> arrayList) {
        AppMethodBeat.m2504i(62885);
        if (arrayList == null || arrayList.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
            AppMethodBeat.m2505o(62885);
            return false;
        }
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
        this.bSd.delete("SmileyInfo", null, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            mo10101b((C4925c) (SmileyInfo) it.next());
        }
        int i = -1;
        if (c7480h != null) {
            i = c7480h.mo15640mB(iV);
        }
        if (i >= 0) {
            AppMethodBeat.m2505o(62885);
            return true;
        }
        AppMethodBeat.m2505o(62885);
        return false;
    }
}
