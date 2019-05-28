package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI extends MMActivity {
    private int type = 0;
    private TextView yLY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30985);
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        setMMTitle("");
        initView();
        AppMethodBeat.o(30985);
    }

    public final void initView() {
        AppMethodBeat.i(30986);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30984);
                ResourcesExceedUI.this.finish();
                AppMethodBeat.o(30984);
                return true;
            }
        });
        this.yLY = (TextView) findViewById(R.id.baw);
        switch (this.type) {
            case 0:
                this.yLY.setText(R.string.f18);
                AppMethodBeat.o(30986);
                return;
            case 1:
                this.yLY.setText(R.string.cdi);
                break;
            case 2:
                this.yLY.setText(R.string.bt0);
                AppMethodBeat.o(30986);
                return;
        }
        AppMethodBeat.o(30986);
    }

    public final int getLayoutId() {
        return R.layout.aot;
    }

    public void onDestroy() {
        AppMethodBeat.i(30987);
        super.onDestroy();
        AppMethodBeat.o(30987);
    }
}
