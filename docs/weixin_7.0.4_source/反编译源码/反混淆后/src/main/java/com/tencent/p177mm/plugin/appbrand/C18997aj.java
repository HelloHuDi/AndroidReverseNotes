package com.tencent.p177mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.plugin.base.model.C11157c;
import com.tencent.p177mm.plugin.p1622w.C44774a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.aj */
public abstract class C18997aj extends C44774a {
    /* renamed from: y */
    public abstract int mo34257y(Intent intent);

    /* renamed from: l */
    public void mo26753l(Context context, Intent intent) {
        if (mo34258z(intent)) {
            mo34255dx(true);
            mo34256m(context, intent);
            return;
        }
        mo34255dx(false);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dx */
    public void mo34255dx(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: m */
    public void mo34256m(Context context, Intent intent) {
        String decrypt = C11157c.decrypt(C5068w.m7689n(intent, "id"));
        String decrypt2 = C11157c.decrypt(C5068w.m7689n(intent, "ext_info"));
        int a = C5068w.m7682a(intent, "ext_info_1", 0);
        C32628se c32628se = new C32628se();
        c32628se.cOf.appId = decrypt2;
        c32628se.cOf.userName = decrypt;
        c32628se.cOf.cOi = a;
        c32628se.cOf.scene = mo34257y(intent);
        c32628se.cOf.cOl = true;
        c32628se.cOf.context = context;
        c32628se.cOf.cOm = false;
        C4879a.xxA.mo10055m(c32628se);
        if (c32628se.cOg.cOw) {
            C4990ab.m7417i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", decrypt);
        } else if (a == 1) {
            Toast.makeText(context, C25738R.string.f8867hl, 0).show();
        } else if (a == 2) {
            Toast.makeText(context, C25738R.string.f8970l7, 0).show();
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: z */
    public boolean mo34258z(Intent intent) {
        String decrypt = C11157c.decrypt(C5068w.m7689n(intent, "id"));
        String decrypt2 = C11157c.decrypt(C5068w.m7689n(intent, "ext_info"));
        String n = C5068w.m7689n(intent, "token");
        int a = C5068w.m7682a(intent, "ext_info_1", 0);
        if (TextUtils.isEmpty(decrypt) || TextUtils.isEmpty(decrypt2) || TextUtils.isEmpty(n)) {
            C4990ab.m7412e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
            return false;
        } else if (C1192l.m2624mg(decrypt)) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            if (!n.equals(C11157c.m18864db(decrypt2, stringBuilder.append(C1668a.m3383QF()).toString()))) {
                SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
                if (sharedPreferences == null) {
                    C4990ab.m7420w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
                    return false;
                }
                Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                if (stringSet == null || stringSet.isEmpty()) {
                    C4990ab.m7420w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
                    return false;
                }
                HashSet hashSet = new HashSet();
                for (String decrypt3 : stringSet) {
                    hashSet.add(C11157c.m18864db(decrypt2, decrypt3));
                }
                if (!hashSet.contains(n)) {
                    C4990ab.m7413e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", n);
                    return false;
                }
            }
            if (C4872b.dnO() || a != 1) {
                return true;
            }
            C4990ab.m7416i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
            return false;
        } else {
            C4990ab.m7413e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", decrypt3);
            C7053e.pXa.mo8378a(647, 1, 1, false);
            return false;
        }
    }
}
