package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.q;
import java.util.ArrayList;

public class LocationExtUI extends MMActivity {
    private ArrayList<String> lfx = new ArrayList();
    private TextView nLx;
    private TextView nLy;
    private String nLz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LocationExtUI() {
        AppMethodBeat.i(113435);
        AppMethodBeat.o(113435);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113436);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bo.isNullOrNil(stringExtra)) {
            findViewById(R.id.cpp).setVisibility(8);
        } else {
            ((TextView) findViewById(R.id.cpq)).setText(stringExtra);
        }
        this.nLx = (TextView) findViewById(R.id.cpo);
        this.nLy = (TextView) findViewById(R.id.cpn);
        this.nLx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113431);
                Intent intent = new Intent();
                intent.putExtra("key_fav_result_list", LocationExtUI.this.lfx);
                b.a(LocationExtUI.this.mController.ylL, ".ui.FavTagEditUI", intent, 4098);
                AppMethodBeat.o(113431);
            }
        });
        this.nLy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113432);
                Intent intent = new Intent(LocationExtUI.this.mController.ylL, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", LocationExtUI.this.getIntent().getStringExtra("key_value"));
                intent.putExtra("key_hint", LocationExtUI.this.getString(R.string.cnk));
                intent.putExtra("Kwebmap_locaion", LocationExtUI.this.getIntent().getStringExtra("Kwebmap_locaion"));
                intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
                intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
                intent.putExtra("kFavInfoLocalId", LocationExtUI.this.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", LocationExtUI.this.getIntent().getStringExtra("kRemark"));
                LocationExtUI.this.startActivityForResult(intent, 4097);
                AppMethodBeat.o(113432);
            }
        });
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113433);
                Intent intent = new Intent();
                intent.putExtra("key_remark_result", LocationExtUI.this.nLz);
                intent.putExtra("key_tags_result", LocationExtUI.this.lfx);
                LocationExtUI.this.setResult(-1, intent);
                LocationExtUI.this.finish();
                AppMethodBeat.o(113433);
                return true;
            }
        }, q.b.GREEN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113434);
                LocationExtUI.this.finish();
                AppMethodBeat.o(113434);
                return true;
            }
        });
        AppMethodBeat.o(113436);
    }

    public final int getLayoutId() {
        return R.layout.a_5;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(113437);
        if (4097 == i) {
            if (-1 != i2 || intent == null) {
                AppMethodBeat.o(113437);
                return;
            }
            CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
            this.nLz = charSequenceExtra == null ? "" : charSequenceExtra.toString();
            this.nLy.setText(this.nLz);
            AppMethodBeat.o(113437);
        } else if (4098 != i) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.o(113437);
        } else if (-1 != i2 || intent == null) {
            AppMethodBeat.o(113437);
        } else {
            this.lfx.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
                AppMethodBeat.o(113437);
                return;
            }
            String str = stringArrayExtra[0];
            this.lfx.add(stringArrayExtra[0]);
            String string = getResources().getString(R.string.bs0);
            for (int i3 = 1; i3 < stringArrayExtra.length; i3++) {
                this.lfx.add(stringArrayExtra[i3]);
                str = str + string + stringArrayExtra[i3];
            }
            this.nLx.setText(str);
            AppMethodBeat.o(113437);
        }
    }
}
