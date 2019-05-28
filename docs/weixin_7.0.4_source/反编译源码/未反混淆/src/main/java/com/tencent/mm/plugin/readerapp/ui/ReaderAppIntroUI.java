package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI extends MMActivity {
    private int cJB = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.an3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(76800);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(76800);
    }

    public final void initView() {
        AppMethodBeat.i(76801);
        ImageView imageView = (ImageView) findViewById(R.id.dv8);
        TextView textView = (TextView) findViewById(R.id.dv9);
        this.cJB = getIntent().getIntExtra("type", 0);
        if (this.cJB == 20) {
            setMMTitle((int) R.string.cb1);
            imageView.setImageResource(R.drawable.an6);
            textView.setText(R.string.az8);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(76798);
                ReaderAppIntroUI.this.finish();
                AppMethodBeat.o(76798);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(76799);
                a.gkE.c(new Intent().putExtra("Contact_User", bl.kG(ReaderAppIntroUI.this.cJB)), ReaderAppIntroUI.this);
                ReaderAppIntroUI.this.finish();
                AppMethodBeat.o(76799);
                return true;
            }
        });
        AppMethodBeat.o(76801);
    }
}
