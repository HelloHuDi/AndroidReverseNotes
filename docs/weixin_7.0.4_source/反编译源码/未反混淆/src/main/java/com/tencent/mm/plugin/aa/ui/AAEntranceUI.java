package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class AAEntranceUI extends MMActivity {
    private Button gna;
    private TextView gnb;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.a;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(40712);
        if (i2 != -1) {
            AppMethodBeat.o(40712);
            return;
        }
        if (i == 1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            ab.i("MicroMsg.AAEntranceUI", "select chatroom：%s", stringExtra);
            if (!bo.isNullOrNil(stringExtra)) {
                Intent intent2 = new Intent(this.mController.ylL, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 2);
                intent2.putExtra("chatroom_name", stringExtra);
                if (getIntent().getExtras() != null) {
                    intent2.putExtras(getIntent().getExtras());
                }
                startActivityForResult(intent2, 2);
            }
        } else if (i == 2) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(40712);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40711);
        this.yll = true;
        super.onCreate(bundle);
        xE(this.mController.dyj());
        setMMTitle((int) R.string.cm5);
        this.gna = (Button) findViewById(R.id.ii);
        this.gnb = (TextView) findViewById(R.id.ij);
        this.gna.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40708);
                AAEntranceUI.a(AAEntranceUI.this);
                AppMethodBeat.o(40708);
            }
        });
        this.gnb.setClickable(true);
        this.gnb.setOnTouchListener(new m(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.ap7));
        spannableStringBuilder.setSpan(new a(new a() {
            public final void aos() {
                AppMethodBeat.i(40709);
                AAEntranceUI.this.startActivity(new Intent(AAEntranceUI.this.mController.ylL, AAQueryListUI.class));
                AppMethodBeat.o(40709);
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.gnb.setText(spannableStringBuilder);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40710);
                AAEntranceUI.this.finish();
                AppMethodBeat.o(40710);
                return false;
            }
        });
        AppMethodBeat.o(40711);
    }

    static /* synthetic */ void a(AAEntranceUI aAEntranceUI) {
        AppMethodBeat.i(40713);
        ab.i("MicroMsg.AAEntranceUI", "go to contact");
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", false);
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("Select_block_List", r.Yz());
        intent.putExtra("recent_remittance_contact_list", h.aom());
        d.b(aAEntranceUI.mController.ylL, "remittance", ".ui.SelectRemittanceContactUI", intent, 1);
        AppMethodBeat.o(40713);
    }
}
