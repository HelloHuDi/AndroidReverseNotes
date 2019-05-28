package com.tencent.p177mm.plugin.readerapp.p490ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C32779bl;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.readerapp.p1654b.C46155a;

/* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI */
public class ReaderAppIntroUI extends MMActivity {
    private int cJB = 0;

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI$1 */
    class C287971 implements OnMenuItemClickListener {
        C287971() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(76798);
            ReaderAppIntroUI.this.finish();
            AppMethodBeat.m2505o(76798);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI$2 */
    class C287982 implements OnMenuItemClickListener {
        C287982() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(76799);
            C46155a.gkE.mo38912c(new Intent().putExtra("Contact_User", C32779bl.m53547kG(ReaderAppIntroUI.this.cJB)), ReaderAppIntroUI.this);
            ReaderAppIntroUI.this.finish();
            AppMethodBeat.m2505o(76799);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970460;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(76800);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(76800);
    }

    public final void initView() {
        AppMethodBeat.m2504i(76801);
        ImageView imageView = (ImageView) findViewById(2131826841);
        TextView textView = (TextView) findViewById(2131826842);
        this.cJB = getIntent().getIntExtra("type", 0);
        if (this.cJB == 20) {
            setMMTitle((int) C25738R.string.cb1);
            imageView.setImageResource(C25738R.drawable.an6);
            textView.setText(C25738R.string.az8);
        }
        setBackBtn(new C287971());
        addIconOptionMenu(0, C1318a.actionbar_setting_icon, new C287982());
        AppMethodBeat.m2505o(76801);
    }
}
