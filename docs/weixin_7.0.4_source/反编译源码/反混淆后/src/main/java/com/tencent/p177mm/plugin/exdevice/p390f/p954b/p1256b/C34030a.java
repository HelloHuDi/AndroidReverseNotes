package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C45883b;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.protocal.protobuf.ach;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.b.a */
public final class C34030a extends C7563j<C34028c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C34028c.ccO, "HardDeviceRankFollowInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(19502);
        AppMethodBeat.m2505o(19502);
    }

    public C34030a(C4927e c4927e) {
        super(c4927e, C34028c.ccO, "HardDeviceRankFollowInfo", null);
        AppMethodBeat.m2504i(19490);
        this.bSd = c4927e;
        c4927e.mo10108hY("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
        AppMethodBeat.m2505o(19490);
    }

    /* renamed from: a */
    public final C34028c mo54563a(C45883b c45883b) {
        AppMethodBeat.m2504i(19491);
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "username", "appusername"});
        Cursor a = this.bSd.mo10104a(format, new String[]{C5046bo.m7532bc(c45883b.lvL, ""), C5046bo.m7532bc(c45883b.username, ""), C5046bo.m7532bc(c45883b.appName, "")}, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
            AppMethodBeat.m2505o(19491);
            return null;
        }
        C34028c c34028c = null;
        if (a.moveToFirst()) {
            c34028c = new C34028c();
            c34028c.mo8995d(a);
        } else {
            C4990ab.m7410d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
        }
        a.close();
        AppMethodBeat.m2505o(19491);
        return c34028c;
    }

    /* renamed from: Kp */
    public final boolean mo54561Kp(String str) {
        AppMethodBeat.m2504i(19492);
        boolean N = m55746N("hardcode_rank_id", "hardcode_app_name", str);
        AppMethodBeat.m2505o(19492);
        return N;
    }

    /* renamed from: N */
    private boolean m55746N(String str, String str2, String str3) {
        AppMethodBeat.m2504i(19493);
        String format = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername", "username"});
        Cursor a = this.bSd.mo10104a(format, new String[]{C5046bo.m7532bc(str, ""), C5046bo.m7532bc(str2, ""), C5046bo.m7532bc(str3, "")}, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
            AppMethodBeat.m2505o(19493);
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        C4990ab.m7411d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", Boolean.valueOf(moveToFirst));
        AppMethodBeat.m2505o(19493);
        return moveToFirst;
    }

    public final ArrayList<C34028c> bpk() {
        ArrayList<C34028c> arrayList = null;
        AppMethodBeat.m2504i(19494);
        String format = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername"});
        Cursor a = this.bSd.mo10104a(format, new String[]{"hardcode_rank_id", "hardcode_app_name"}, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
            AppMethodBeat.m2505o(19494);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    C34028c c34028c = new C34028c();
                    c34028c.mo8995d(a);
                    C4990ab.m7411d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", Integer.valueOf(a.getColumnIndex("rowid")), c34028c.toString());
                    arrayList.add(c34028c);
                } while (a.moveToNext());
                C4990ab.m7411d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", Integer.valueOf(arrayList.size()), arrayList.toString());
            } else {
                C4990ab.m7410d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            a.close();
            AppMethodBeat.m2505o(19494);
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo54564a(ArrayList<ach> arrayList, String str, String str2) {
        AppMethodBeat.m2504i(19495);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ach ach = (ach) it.next();
                C34028c c34028c = new C34028c();
                c34028c.field_rankID = str;
                c34028c.field_step = ach.hzv;
                c34028c.field_username = ach.username;
                c34028c.field_appusername = str2;
                m55748a(c34028c);
            }
        }
        AppMethodBeat.m2505o(19495);
    }

    /* renamed from: by */
    public final void mo54566by(List<C34028c> list) {
        AppMethodBeat.m2504i(19496);
        String str = "hardcode_app_name";
        if (C5046bo.isNullOrNil("hardcode_rank_id") || C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
        } else {
            int delete = this.bSd.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[]{r0, str});
            C4990ab.m7411d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", r0, str, Integer.valueOf(delete));
        }
        if (list != null) {
            for (C34028c c34028c : list) {
                c34028c.field_rankID = "hardcode_rank_id";
                c34028c.field_appusername = "hardcode_app_name";
                m55748a(c34028c);
            }
        }
        AppMethodBeat.m2505o(19496);
    }

    /* renamed from: a */
    private boolean m55748a(C34028c c34028c) {
        AppMethodBeat.m2504i(19497);
        if (m55749b(c34028c)) {
            AppMethodBeat.m2505o(19497);
        } else {
            m55750c(c34028c);
            AppMethodBeat.m2505o(19497);
        }
        return true;
    }

    /* renamed from: Kq */
    public final boolean mo54562Kq(String str) {
        AppMethodBeat.m2504i(19498);
        boolean O = m55747O("hardcode_rank_id", "hardcode_app_name", str);
        AppMethodBeat.m2505o(19498);
        return O;
    }

    /* renamed from: O */
    private boolean m55747O(String str, String str2, String str3) {
        AppMethodBeat.m2504i(19499);
        C34028c a = mo54563a(new C45883b(str, str2, str3));
        if (a != null) {
            mo16760a((C4925c) a, "rankID", "appusername", "username");
            C4990ab.m7410d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            AppMethodBeat.m2505o(19499);
            return true;
        }
        AppMethodBeat.m2505o(19499);
        return false;
    }

    /* renamed from: b */
    private boolean m55749b(C34028c c34028c) {
        AppMethodBeat.m2504i(19500);
        Assert.assertTrue(c34028c != null);
        C34028c a = mo54563a(new C45883b(c34028c.field_rankID, c34028c.field_appusername, c34028c.field_username));
        if (a != null) {
            a.field_step = c34028c.field_step;
            mo10103c(a, "rankID", "appusername", "username");
            C4990ab.m7410d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            AppMethodBeat.m2505o(19500);
            return true;
        }
        AppMethodBeat.m2505o(19500);
        return false;
    }

    /* renamed from: c */
    private boolean m55750c(C34028c c34028c) {
        AppMethodBeat.m2504i(19501);
        Assert.assertTrue(c34028c != null);
        mo10101b((C4925c) c34028c);
        C4990ab.m7410d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
        AppMethodBeat.m2505o(19501);
        return true;
    }
}
