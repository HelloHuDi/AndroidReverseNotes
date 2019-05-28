package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.location.ui.LocationExtUI */
public class LocationExtUI extends MMActivity {
    private ArrayList<String> lfx = new ArrayList();
    private TextView nLx;
    private TextView nLy;
    private String nLz;

    /* renamed from: com.tencent.mm.plugin.location.ui.LocationExtUI$4 */
    class C77794 implements OnMenuItemClickListener {
        C77794() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(113434);
            LocationExtUI.this.finish();
            AppMethodBeat.m2505o(113434);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.LocationExtUI$1 */
    class C77801 implements OnClickListener {
        C77801() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113431);
            Intent intent = new Intent();
            intent.putExtra("key_fav_result_list", LocationExtUI.this.lfx);
            C39037b.m66352a(LocationExtUI.this.mController.ylL, ".ui.FavTagEditUI", intent, 4098);
            AppMethodBeat.m2505o(113431);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.LocationExtUI$3 */
    class C77813 implements OnMenuItemClickListener {
        C77813() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(113433);
            Intent intent = new Intent();
            intent.putExtra("key_remark_result", LocationExtUI.this.nLz);
            intent.putExtra("key_tags_result", LocationExtUI.this.lfx);
            LocationExtUI.this.setResult(-1, intent);
            LocationExtUI.this.finish();
            AppMethodBeat.m2505o(113433);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.LocationExtUI$2 */
    class C77822 implements OnClickListener {
        C77822() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113432);
            Intent intent = new Intent(LocationExtUI.this.mController.ylL, RemarkUI.class);
            intent.putExtra("key_nullable", true);
            intent.putExtra("key_value", LocationExtUI.this.getIntent().getStringExtra("key_value"));
            intent.putExtra("key_hint", LocationExtUI.this.getString(C25738R.string.cnk));
            intent.putExtra("Kwebmap_locaion", LocationExtUI.this.getIntent().getStringExtra("Kwebmap_locaion"));
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
            intent.putExtra("kFavInfoLocalId", LocationExtUI.this.getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kRemark", LocationExtUI.this.getIntent().getStringExtra("kRemark"));
            LocationExtUI.this.startActivityForResult(intent, 4097);
            AppMethodBeat.m2505o(113432);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LocationExtUI() {
        AppMethodBeat.m2504i(113435);
        AppMethodBeat.m2505o(113435);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(113436);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (C5046bo.isNullOrNil(stringExtra)) {
            findViewById(2131825268).setVisibility(8);
        } else {
            ((TextView) findViewById(2131825269)).setText(stringExtra);
        }
        this.nLx = (TextView) findViewById(2131825267);
        this.nLy = (TextView) findViewById(2131825266);
        this.nLx.setOnClickListener(new C77801());
        this.nLy.setOnClickListener(new C77822());
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C77813(), C5535b.GREEN);
        setBackBtn(new C77794());
        AppMethodBeat.m2505o(113436);
    }

    public final int getLayoutId() {
        return 2130969943;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(113437);
        if (4097 == i) {
            if (-1 != i2 || intent == null) {
                AppMethodBeat.m2505o(113437);
                return;
            }
            CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
            this.nLz = charSequenceExtra == null ? "" : charSequenceExtra.toString();
            this.nLy.setText(this.nLz);
            AppMethodBeat.m2505o(113437);
        } else if (4098 != i) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.m2505o(113437);
        } else if (-1 != i2 || intent == null) {
            AppMethodBeat.m2505o(113437);
        } else {
            this.lfx.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
                AppMethodBeat.m2505o(113437);
                return;
            }
            String str = stringArrayExtra[0];
            this.lfx.add(stringArrayExtra[0]);
            String string = getResources().getString(C25738R.string.bs0);
            for (int i3 = 1; i3 < stringArrayExtra.length; i3++) {
                this.lfx.add(stringArrayExtra[i3]);
                str = str + string + stringArrayExtra[i3];
            }
            this.nLx.setText(str);
            AppMethodBeat.m2505o(113437);
        }
    }
}
