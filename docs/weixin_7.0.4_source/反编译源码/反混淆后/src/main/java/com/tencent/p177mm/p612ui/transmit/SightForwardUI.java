package com.tencent.p177mm.p612ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.encode.p513ui.C21856d;
import com.tencent.p177mm.plugin.sight.encode.p513ui.C43534b;
import com.tencent.p177mm.plugin.sight.encode.p513ui.C46207c;
import com.tencent.p177mm.plugin.sight.encode.p513ui.MainSightForwardContainerView;
import com.tencent.p177mm.plugin.sight.encode.p513ui.MainSightForwardContainerView.C290231;
import com.tencent.p177mm.plugin.sight.encode.p513ui.MainSightForwardContainerView.C290242;
import com.tencent.p177mm.plugin.sight.encode.p513ui.MainSightForwardContainerView.C397193;
import com.tencent.p177mm.plugin.sight.encode.p513ui.MainSightSelectContactView;
import com.tencent.p177mm.plugin.sight.encode.p513ui.SightCameraView;
import com.tencent.p177mm.pluginsdk.p1082i.C40435a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashSet;

/* renamed from: com.tencent.mm.ui.transmit.SightForwardUI */
public class SightForwardUI extends MMActivity {
    private String mPath;
    private MainSightForwardContainerView zKP;

    /* renamed from: com.tencent.mm.ui.transmit.SightForwardUI$1 */
    class C240731 implements C43534b {
        C240731() {
        }

        public final void startChattingUI(String str) {
            AppMethodBeat.m2504i(35274);
            Intent intent = new Intent(SightForwardUI.this.mController.ylL, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", str);
            SightForwardUI.this.startActivity(intent);
            SightForwardUI.this.finish();
            AppMethodBeat.m2505o(35274);
        }

        public final void clG() {
            AppMethodBeat.m2504i(35275);
            Intent intent = new Intent();
            intent.setClass(SightForwardUI.this.mController.ylL, LauncherUI.class).addFlags(67108864);
            SightForwardUI.this.startActivity(intent);
            SightForwardUI.this.finish();
            AppMethodBeat.m2505o(35275);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35276);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getSupportActionBar().hide();
        this.mPath = getIntent().getStringExtra("sight_local_path");
        if (!C21846d.m33387WQ(this.mPath)) {
            C4990ab.m7413e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", this.mPath);
            finish();
            AppMethodBeat.m2505o(35276);
        } else if (C9638aw.m17179RK()) {
            String ug = C9720t.m17302ug(String.valueOf(SystemClock.elapsedRealtime()));
            C37961o.all();
            ug = C9720t.m17303uh(ug);
            if (C5730e.m8644y(this.mPath, ug) <= 0) {
                C4990ab.m7413e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", this.mPath, ug);
                finish();
                AppMethodBeat.m2505o(35276);
                return;
            }
            this.mPath = ug;
            C4990ab.m7417i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", this.mPath);
            this.zKP = (MainSightForwardContainerView) findViewById(2131825720);
            this.zKP.setIMainSightViewCallback(new C240731());
            MainSightForwardContainerView mainSightForwardContainerView = this.zKP;
            ug = this.mPath;
            mainSightForwardContainerView.iWA = this;
            mainSightForwardContainerView.qAD = ug;
            mainSightForwardContainerView.qAB = C1178g.m2587cz(ug);
            long currentTimeMillis = System.currentTimeMillis();
            mainSightForwardContainerView.qAE = 1.3333334f;
            mainSightForwardContainerView.qAu = (SightCameraView) ((ViewStub) mainSightForwardContainerView.findViewById(2131825721)).inflate();
            mainSightForwardContainerView.qAu.setTargetWidth(C40435a.ouQ);
            mainSightForwardContainerView.qAu.setFixPreviewRate(mainSightForwardContainerView.qAE);
            mainSightForwardContainerView.qAu.setVisibility(0);
            mainSightForwardContainerView.qAy = mainSightForwardContainerView.findViewById(2131825726);
            mainSightForwardContainerView.qAy.setLayoutParams(new LayoutParams(-1, getSupportActionBar().getHeight()));
            mainSightForwardContainerView.qAx = mainSightForwardContainerView.findViewById(2131825727);
            mainSightForwardContainerView.ofJ = mainSightForwardContainerView.findViewById(2131825728);
            mainSightForwardContainerView.qAw = mainSightForwardContainerView.findViewById(2131825722);
            mainSightForwardContainerView.qAx.setOnClickListener(new C290231());
            mainSightForwardContainerView.ofJ.setOnClickListener(new C290242());
            mainSightForwardContainerView.clF();
            C4990ab.m7411d("MicroMsg.MainSightContainerView", "init concrol view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.zKP.clE();
            mainSightForwardContainerView = this.zKP;
            if (mainSightForwardContainerView.qAt == null) {
                DisplayMetrics displayMetrics = mainSightForwardContainerView.getResources().getDisplayMetrics();
                float f = ((float) displayMetrics.widthPixels) / mainSightForwardContainerView.qAE;
                mainSightForwardContainerView.qAt = (MainSightSelectContactView) mainSightForwardContainerView.findViewById(2131825725);
                MainSightSelectContactView mainSightSelectContactView = mainSightForwardContainerView.qAt;
                MMFragmentActivity mMFragmentActivity = mainSightForwardContainerView.iWA;
                int i = (int) (((float) displayMetrics.heightPixels) - f);
                int i2 = displayMetrics.heightPixels;
                mainSightSelectContactView.iWA = mMFragmentActivity;
                mainSightSelectContactView.qBf = i;
                mainSightSelectContactView.setMainSightContentView(mainSightForwardContainerView);
                mainSightSelectContactView.addView(View.inflate(mainSightSelectContactView.getContext(), 2130970020, null), -1, -2);
                mainSightSelectContactView.mListView = (ListView) mainSightSelectContactView.findViewById(2131820897);
                mainSightSelectContactView.qBi = new C46207c(mainSightSelectContactView);
                mainSightSelectContactView.qBl = new LinearLayout(mainSightSelectContactView.getContext());
                mainSightSelectContactView.qBl.addView(new View(mainSightSelectContactView.getContext()), -1, mainSightSelectContactView.qBk.getViewHeight() - mainSightSelectContactView.qBf);
                mainSightSelectContactView.qBl.getChildAt(0).setBackgroundColor(0);
                mainSightSelectContactView.mListView.addHeaderView(mainSightSelectContactView.qBl);
                mainSightSelectContactView.mListView.setAdapter(mainSightSelectContactView.qBi);
                mainSightSelectContactView.mListView.setOnItemClickListener(mainSightForwardContainerView);
                mainSightSelectContactView.qBp = new HashSet();
                mainSightSelectContactView.qBq = new HashSet();
                mainSightSelectContactView.mListView.setOnScrollListener(mainSightSelectContactView);
                mainSightSelectContactView.qBg = new C21856d();
                mainSightSelectContactView.qBg.qBb = mainSightSelectContactView;
                mainSightForwardContainerView.qAt.setSearchView(mainSightForwardContainerView.findViewById(2131823137));
                mainSightForwardContainerView.qAt.setEmptyBgView(mainSightForwardContainerView.findViewById(2131825723));
                mainSightForwardContainerView.qAt.setMainSightContentView(mainSightForwardContainerView);
            }
            mainSightForwardContainerView.mo62693kF(true);
            mainSightForwardContainerView.qAu.postDelayed(new C397193(), 50);
            AppMethodBeat.m2505o(35276);
        } else {
            C4990ab.m7412e("MicroMsg.SightForwardUI", "acc not ready");
            finish();
            AppMethodBeat.m2505o(35276);
        }
    }

    public final int getLayoutId() {
        return 2130970019;
    }

    public void onResume() {
        AppMethodBeat.m2504i(35277);
        super.onResume();
        this.zKP.onResume();
        AppMethodBeat.m2505o(35277);
    }

    public void onPause() {
        AppMethodBeat.m2504i(35278);
        super.onPause();
        this.zKP.onPause();
        AppMethodBeat.m2505o(35278);
    }
}
