package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;

public final class ay {
    public static SharedPreferences ZQ() {
        AppMethodBeat.i(58105);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("auth_info_key_prefs", h.Mu());
        if (!sharedPreferences.getBoolean("key_auth_info_prefs_created", false)) {
            e.pXa.a(148, 12, 1, true);
            y yVar = new y(ac.eSj + "autoauth.cfg");
            boolean commit;
            if (yVar.xIr || yVar.get(3) == null) {
                SharedPreferences sharedPreferences2 = ah.getContext().getSharedPreferences("auto_auth_key_prefs", h.Mu());
                Editor edit = sharedPreferences.edit();
                if (bo.isNullOrNil(sharedPreferences2.getString("_auth_key", ""))) {
                    ab.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", bo.dpG());
                } else {
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", sharedPreferences2.getInt("key_auth_update_version", 0));
                    edit.putInt("_auth_uin", sharedPreferences2.getInt("_auth_uin", 0));
                    edit.putString("_auth_key", sharedPreferences2.getString("_auth_key", ""));
                    edit.putString("server_id", ah.getContext().getSharedPreferences("server_id_prefs", h.Mu()).getString("server_id", ""));
                    commit = edit.commit();
                    ab.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                }
            } else {
                Editor edit2 = sharedPreferences.edit();
                edit2.putBoolean("key_auth_info_prefs_created", true);
                edit2.putInt("key_auth_update_version", ((Integer) yVar.get(1)).intValue());
                edit2.putInt("_auth_uin", ((Integer) yVar.get(2)).intValue());
                edit2.putString("_auth_key", (String) yVar.get(3));
                edit2.putString("server_id", (String) yVar.get(4));
                commit = edit2.commit();
                ab.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                e.pXa.a(148, 51, 1, true);
                AppMethodBeat.o(58105);
                return sharedPreferences;
            }
        }
        AppMethodBeat.o(58105);
        return sharedPreferences;
    }
}
