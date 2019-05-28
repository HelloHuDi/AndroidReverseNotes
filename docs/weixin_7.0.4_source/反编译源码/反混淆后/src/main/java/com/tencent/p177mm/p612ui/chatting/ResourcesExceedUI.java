package com.tencent.p177mm.p612ui.chatting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.ui.chatting.ResourcesExceedUI */
public class ResourcesExceedUI extends MMActivity {
    private int type = 0;
    private TextView yLY;

    /* renamed from: com.tencent.mm.ui.chatting.ResourcesExceedUI$1 */
    class C236861 implements OnMenuItemClickListener {
        C236861() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30984);
            ResourcesExceedUI.this.finish();
            AppMethodBeat.m2505o(30984);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30985);
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        setMMTitle("");
        initView();
        AppMethodBeat.m2505o(30985);
    }

    public final void initView() {
        AppMethodBeat.m2504i(30986);
        setBackBtn(new C236861());
        this.yLY = (TextView) findViewById(2131823352);
        switch (this.type) {
            case 0:
                this.yLY.setText(C25738R.string.f18);
                AppMethodBeat.m2505o(30986);
                return;
            case 1:
                this.yLY.setText(C25738R.string.cdi);
                break;
            case 2:
                this.yLY.setText(C25738R.string.bt0);
                AppMethodBeat.m2505o(30986);
                return;
        }
        AppMethodBeat.m2505o(30986);
    }

    public final int getLayoutId() {
        return 2130970524;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30987);
        super.onDestroy();
        AppMethodBeat.m2505o(30987);
    }
}
