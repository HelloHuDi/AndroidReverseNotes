package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public abstract class aj extends a {
    public abstract int y(Intent intent);

    public void l(Context context, Intent intent) {
        if (z(intent)) {
            dx(true);
            m(context, intent);
            return;
        }
        dx(false);
    }

    /* Access modifiers changed, original: protected */
    public void dx(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void m(Context context, Intent intent) {
        String decrypt = c.decrypt(w.n(intent, "id"));
        String decrypt2 = c.decrypt(w.n(intent, "ext_info"));
        int a = w.a(intent, "ext_info_1", 0);
        se seVar = new se();
        seVar.cOf.appId = decrypt2;
        seVar.cOf.userName = decrypt;
        seVar.cOf.cOi = a;
        seVar.cOf.scene = y(intent);
        seVar.cOf.cOl = true;
        seVar.cOf.context = context;
        seVar.cOf.cOm = false;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        if (seVar.cOg.cOw) {
            ab.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", decrypt);
        } else if (a == 1) {
            Toast.makeText(context, R.string.hl, 0).show();
        } else if (a == 2) {
            Toast.makeText(context, R.string.l7, 0).show();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean z(Intent intent) {
        String decrypt = c.decrypt(w.n(intent, "id"));
        String decrypt2 = c.decrypt(w.n(intent, "ext_info"));
        String n = w.n(intent, "token");
        int a = w.a(intent, "ext_info_1", 0);
        if (TextUtils.isEmpty(decrypt) || TextUtils.isEmpty(decrypt2) || TextUtils.isEmpty(n)) {
            ab.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
            return false;
        } else if (l.mg(decrypt)) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            if (!n.equals(c.db(decrypt2, stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString()))) {
                SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
                if (sharedPreferences == null) {
                    ab.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
                    return false;
                }
                Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                if (stringSet == null || stringSet.isEmpty()) {
                    ab.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
                    return false;
                }
                HashSet hashSet = new HashSet();
                for (String decrypt3 : stringSet) {
                    hashSet.add(c.db(decrypt2, decrypt3));
                }
                if (!hashSet.contains(n)) {
                    ab.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", n);
                    return false;
                }
            }
            if (b.dnO() || a != 1) {
                return true;
            }
            ab.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
            return false;
        } else {
            ab.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", decrypt3);
            e.pXa.a(647, 1, 1, false);
            return false;
        }
    }
}
