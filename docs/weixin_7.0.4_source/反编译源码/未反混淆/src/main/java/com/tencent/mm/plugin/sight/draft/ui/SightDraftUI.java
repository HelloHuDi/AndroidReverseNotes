package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;

public class SightDraftUI extends MMActivity {
    private LinkedList<String> qAa = new LinkedList();
    private int qzY = 1;
    SightDraftContainerView qzZ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SightDraftUI() {
        AppMethodBeat.i(25028);
        AppMethodBeat.o(25028);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25029);
        super.onCreate(bundle);
        setMMTitle((int) R.string.eid);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.h4));
        this.qzZ = new SightDraftContainerView(this);
        setContentView((View) this.qzZ);
        this.qzZ.clx();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25024);
                SightDraftUI.this.finish();
                AppMethodBeat.o(25024);
                return false;
            }
        });
        this.qzZ.setSightDraftCallback(new a() {
            public final void clu() {
                AppMethodBeat.i(25026);
                SightDraftUI.this.addTextOptionMenu(SightDraftUI.this.qzY, SightDraftUI.this.getString(R.string.ei3), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(25025);
                        SightDraftUI.b(SightDraftUI.this);
                        AppMethodBeat.o(25025);
                        return true;
                    }
                });
                AppMethodBeat.o(25026);
            }

            public final void clv() {
                AppMethodBeat.i(25027);
                SightDraftUI.this.removeOptionMenu(SightDraftUI.this.qzY);
                AppMethodBeat.o(25027);
            }
        });
        AppMethodBeat.o(25029);
    }

    static /* synthetic */ void b(SightDraftUI sightDraftUI) {
        AppMethodBeat.i(25030);
        j lastDrafInfo = sightDraftUI.qzZ.getLastDrafInfo();
        if (lastDrafInfo != null) {
            String tX = k.tX(lastDrafInfo.field_fileName);
            if (!sightDraftUI.qAa.contains(tX)) {
                sightDraftUI.qAa.add(tX);
                String str = e.euR + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), "mp4"});
                ab.i("MicroMsg.SightDraftUI", "save src %s dest %s ", tX, str);
                com.tencent.mm.vfs.e.y(tX, str);
                a.a(str, sightDraftUI);
                t.makeText(sightDraftUI, sightDraftUI.getString(R.string.eic, new Object[]{e.euR}), 1).show();
            }
        }
        AppMethodBeat.o(25030);
    }
}
