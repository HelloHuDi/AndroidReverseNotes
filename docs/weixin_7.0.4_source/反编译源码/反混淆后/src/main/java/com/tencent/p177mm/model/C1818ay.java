package com.tencent.p177mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5144y;

/* renamed from: com.tencent.mm.model.ay */
public final class C1818ay {
    /* renamed from: ZQ */
    public static SharedPreferences m3737ZQ() {
        AppMethodBeat.m2504i(58105);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("auth_info_key_prefs", C1448h.m3078Mu());
        if (!sharedPreferences.getBoolean("key_auth_info_prefs_created", false)) {
            C7053e.pXa.mo8378a(148, 12, 1, true);
            C5144y c5144y = new C5144y(C5128ac.eSj + "autoauth.cfg");
            boolean commit;
            if (c5144y.xIr || c5144y.get(3) == null) {
                SharedPreferences sharedPreferences2 = C4996ah.getContext().getSharedPreferences("auto_auth_key_prefs", C1448h.m3078Mu());
                Editor edit = sharedPreferences.edit();
                if (C5046bo.isNullOrNil(sharedPreferences2.getString("_auth_key", ""))) {
                    C4990ab.m7417i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", C5046bo.dpG());
                } else {
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", sharedPreferences2.getInt("key_auth_update_version", 0));
                    edit.putInt("_auth_uin", sharedPreferences2.getInt("_auth_uin", 0));
                    edit.putString("_auth_key", sharedPreferences2.getString("_auth_key", ""));
                    edit.putString("server_id", C4996ah.getContext().getSharedPreferences("server_id_prefs", C1448h.m3078Mu()).getString("server_id", ""));
                    commit = edit.commit();
                    C4990ab.m7417i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                }
            } else {
                Editor edit2 = sharedPreferences.edit();
                edit2.putBoolean("key_auth_info_prefs_created", true);
                edit2.putInt("key_auth_update_version", ((Integer) c5144y.get(1)).intValue());
                edit2.putInt("_auth_uin", ((Integer) c5144y.get(2)).intValue());
                edit2.putString("_auth_key", (String) c5144y.get(3));
                edit2.putString("server_id", (String) c5144y.get(4));
                commit = edit2.commit();
                C4990ab.m7417i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                C7053e.pXa.mo8378a(148, 51, 1, true);
                AppMethodBeat.m2505o(58105);
                return sharedPreferences;
            }
        }
        AppMethodBeat.m2505o(58105);
        return sharedPreferences;
    }
}
