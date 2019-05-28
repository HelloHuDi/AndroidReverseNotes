package com.tencent.p177mm.plugin.sight.draft.p1021ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.modelvideo.C1883k;
import com.tencent.p177mm.modelvideo.C9716j;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sight.draft.ui.SightDraftUI */
public class SightDraftUI extends MMActivity {
    private LinkedList<String> qAa = new LinkedList();
    private int qzY = 1;
    SightDraftContainerView qzZ;

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.SightDraftUI$2 */
    class C413082 implements C39714a {

        /* renamed from: com.tencent.mm.plugin.sight.draft.ui.SightDraftUI$2$1 */
        class C218491 implements OnMenuItemClickListener {
            C218491() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(25025);
                SightDraftUI.m77793b(SightDraftUI.this);
                AppMethodBeat.m2505o(25025);
                return true;
            }
        }

        C413082() {
        }

        public final void clu() {
            AppMethodBeat.m2504i(25026);
            SightDraftUI.this.addTextOptionMenu(SightDraftUI.this.qzY, SightDraftUI.this.getString(C25738R.string.ei3), new C218491());
            AppMethodBeat.m2505o(25026);
        }

        public final void clv() {
            AppMethodBeat.m2504i(25027);
            SightDraftUI.this.removeOptionMenu(SightDraftUI.this.qzY);
            AppMethodBeat.m2505o(25027);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.SightDraftUI$1 */
    class C435301 implements OnMenuItemClickListener {
        C435301() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25024);
            SightDraftUI.this.finish();
            AppMethodBeat.m2505o(25024);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SightDraftUI() {
        AppMethodBeat.m2504i(25028);
        AppMethodBeat.m2505o(25028);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25029);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.eid);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(C25738R.color.f11782h4));
        this.qzZ = new SightDraftContainerView(this);
        setContentView((View) this.qzZ);
        this.qzZ.clx();
        setBackBtn(new C435301());
        this.qzZ.setSightDraftCallback(new C413082());
        AppMethodBeat.m2505o(25029);
    }

    /* renamed from: b */
    static /* synthetic */ void m77793b(SightDraftUI sightDraftUI) {
        AppMethodBeat.m2504i(25030);
        C9716j lastDrafInfo = sightDraftUI.qzZ.getLastDrafInfo();
        if (lastDrafInfo != null) {
            String tX = C1883k.m3987tX(lastDrafInfo.field_fileName);
            if (!sightDraftUI.qAa.contains(tX)) {
                sightDraftUI.qAa.add(tX);
                String str = C6457e.euR + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), "mp4"});
                C4990ab.m7417i("MicroMsg.SightDraftUI", "save src %s dest %s ", tX, str);
                C5730e.m8644y(tX, str);
                C40612a.m70043a(str, sightDraftUI);
                C23639t.makeText(sightDraftUI, sightDraftUI.getString(C25738R.string.eic, new Object[]{C6457e.euR}), 1).show();
            }
        }
        AppMethodBeat.m2505o(25030);
    }
}
