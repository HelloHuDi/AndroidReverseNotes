package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124756);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_disaster_content");
        final String stringExtra2 = getIntent().getStringExtra("key_disaster_url");
        ab.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", Integer.valueOf(hashCode()), stringExtra, stringExtra2);
        ((TextView) findViewById(R.id.b_t)).setText(stringExtra);
        findViewById(R.id.b_u).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(124754);
                ab.i("MicroMsg.DisasterUI", "summerdiz jump link");
                h.pYm.e(13939, Integer.valueOf(1));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringExtra2));
                DisasterUI.this.startActivity(intent);
                AppMethodBeat.o(124754);
            }
        });
        setMMTitle(getString(R.string.b6d));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124755);
                h.pYm.e(13939, Integer.valueOf(3));
                ab.i("MicroMsg.DisasterUI", "summerdiz back");
                DisasterUI.this.finish();
                AppMethodBeat.o(124755);
                return true;
            }
        });
        AppMethodBeat.o(124756);
    }

    public final int getLayoutId() {
        return R.layout.sn;
    }

    public final boolean needShowIdcError() {
        return false;
    }
}
