package com.tencent.p177mm.plugin.traceroute.p745ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.traceroute.p1415a.C29464a;

/* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI */
public class NetworkDiagnoseIntroUI extends MMActivity {
    private Button sJd;
    private TextView sJe;

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI$1 */
    class C224321 implements OnClickListener {
        C224321() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26011);
            C9638aw.m17190ZK();
            if (!C18628c.isSDCardAvailable()) {
                C23639t.m36492hO(NetworkDiagnoseIntroUI.this);
                AppMethodBeat.m2505o(26011);
            } else if (C9638aw.m17182Rg().acS() == 0) {
                Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(C25738R.string.bx9), 0).show();
                AppMethodBeat.m2505o(26011);
            } else {
                NetworkDiagnoseIntroUI.this.startActivity(new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class));
                NetworkDiagnoseIntroUI.this.finish();
                AppMethodBeat.m2505o(26011);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI$3 */
    class C224333 implements OnMenuItemClickListener {
        C224333() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26013);
            NetworkDiagnoseIntroUI.this.finish();
            AppMethodBeat.m2505o(26013);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI$2 */
    class C224342 implements OnClickListener {
        C224342() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26012);
            Intent intent = new Intent();
            intent.putExtra("title", NetworkDiagnoseIntroUI.this.getString(C25738R.string.dek));
            intent.putExtra("rawUrl", NetworkDiagnoseIntroUI.this.getString(C25738R.string.ezj));
            intent.putExtra("showShare", false);
            C29464a.gkE.mo38924i(intent, NetworkDiagnoseIntroUI.this.mController.ylL);
            AppMethodBeat.m2505o(26012);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26014);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(26014);
    }

    public final void initView() {
        AppMethodBeat.m2504i(26015);
        this.sJd = (Button) findViewById(2131826327);
        this.sJd.setOnClickListener(new C224321());
        this.sJe = (TextView) findViewById(2131826328);
        this.sJe.setOnClickListener(new C224342());
        setMMTitle("");
        setBackBtn(new C224333());
        AppMethodBeat.m2505o(26015);
    }

    public final int getLayoutId() {
        return 2130970297;
    }
}
