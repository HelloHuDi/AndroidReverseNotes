package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.ui.DisasterUI */
public class DisasterUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.account.ui.DisasterUI$2 */
    class C76712 implements OnMenuItemClickListener {
        C76712() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124755);
            C7060h.pYm.mo8381e(13939, Integer.valueOf(3));
            C4990ab.m7416i("MicroMsg.DisasterUI", "summerdiz back");
            DisasterUI.this.finish();
            AppMethodBeat.m2505o(124755);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124756);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_disaster_content");
        final String stringExtra2 = getIntent().getStringExtra("key_disaster_url");
        C4990ab.m7417i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", Integer.valueOf(hashCode()), stringExtra, stringExtra2);
        ((TextView) findViewById(2131823312)).setText(stringExtra);
        findViewById(2131823313).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(124754);
                C4990ab.m7416i("MicroMsg.DisasterUI", "summerdiz jump link");
                C7060h.pYm.mo8381e(13939, Integer.valueOf(1));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringExtra2));
                DisasterUI.this.startActivity(intent);
                AppMethodBeat.m2505o(124754);
            }
        });
        setMMTitle(getString(C25738R.string.b6d));
        setBackBtn(new C76712());
        AppMethodBeat.m2505o(124756);
    }

    public final int getLayoutId() {
        return 2130969294;
    }

    public final boolean needShowIdcError() {
        return false;
    }
}
