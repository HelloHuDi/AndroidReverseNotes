package com.tencent.p177mm.plugin.extqlauncher.p965ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.extqlauncher.C45910b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.extqlauncher.ui.QLauncherCreateShortcutUI */
public class QLauncherCreateShortcutUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20494);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(2130969253);
        Intent intent = new Intent();
        int C = C15830s.m24190C(C15830s.znD, 64, 16384);
        C15830s.m24193hs(C, 1);
        intent.putExtra("list_attr", C);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(C25738R.string.f8782eu));
        intent.putExtra("block_contact", C1853r.m3846Yz());
        C25985d.m41466b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.m2505o(20494);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(20495);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7411d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", Integer.valueOf(i2));
        if (i2 != -1) {
            finish();
            AppMethodBeat.m2505o(20495);
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    if (C9638aw.m17179RK()) {
                        List list;
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            list = null;
                        } else {
                            list = C5046bo.m7508P(stringExtra.split(","));
                        }
                        if (list != null && list.size() > 0) {
                            C4990ab.m7410d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + list.size());
                            String Yz = C1853r.m3846Yz();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                                for (int i3 = 0; i3 < list.size(); i3++) {
                                    C9638aw.m17190ZK();
                                    C7616ad aoO = C18628c.m29078XM().aoO((String) list.get(i3));
                                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                        C4990ab.m7412e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                        AppMethodBeat.m2505o(20495);
                                        return;
                                    }
                                    String Ft = C42781b.m75856Ft((String) list.get(i3));
                                    if (C5046bo.isNullOrNil(Ft)) {
                                        C4990ab.m7412e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                        finish();
                                        AppMethodBeat.m2505o(20495);
                                        return;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("source_key", C42781b.SOURCE_KEY);
                                    contentValues.put("owner_id", C42781b.m75856Ft(Yz));
                                    contentValues.put("unique_id", Ft);
                                    contentValues.put("container", Integer.valueOf(1));
                                    contentValues.put("item_type", Integer.valueOf(C42781b.m75854C(aoO)));
                                    contentValues.put("name", C1854s.m3860a(aoO, (String) list.get(i3)));
                                    C17884o.acd();
                                    contentValues.put("icon_path", C41732d.m73515D((String) list.get(i3), false));
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.Shortcut.Username", Ft);
                                    intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    contentValues.put("intent", intent2.toUri(0));
                                    contentValuesArr[i3] = contentValues;
                                }
                                getContentResolver().bulkInsert(C11784a.lRW, contentValuesArr);
                                Toast.makeText(this, C25738R.string.bja, 0).show();
                                C45910b.bsa().bsc();
                                break;
                            } catch (Exception e) {
                                C4990ab.m7411d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", e.getMessage());
                                C4990ab.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e, "", new Object[0]);
                                Toast.makeText(this, C25738R.string.bj_, 0).show();
                                break;
                            }
                        }
                        C4990ab.m7412e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                    Toast.makeText(this, C25738R.string.bj_, 0).show();
                    finish();
                    AppMethodBeat.m2505o(20495);
                    return;
                }
                break;
        }
        finish();
        AppMethodBeat.m2505o(20495);
    }
}
