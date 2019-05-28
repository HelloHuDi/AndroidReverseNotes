package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.plugin.sight.encode.ui.c;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.vfs.e;
import java.util.HashSet;

public class SightForwardUI extends MMActivity {
    private String mPath;
    private MainSightForwardContainerView zKP;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35276);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getSupportActionBar().hide();
        this.mPath = getIntent().getStringExtra("sight_local_path");
        if (!d.WQ(this.mPath)) {
            ab.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", this.mPath);
            finish();
            AppMethodBeat.o(35276);
        } else if (aw.RK()) {
            String ug = t.ug(String.valueOf(SystemClock.elapsedRealtime()));
            o.all();
            ug = t.uh(ug);
            if (e.y(this.mPath, ug) <= 0) {
                ab.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", this.mPath, ug);
                finish();
                AppMethodBeat.o(35276);
                return;
            }
            this.mPath = ug;
            ab.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", this.mPath);
            this.zKP = (MainSightForwardContainerView) findViewById(R.id.d1x);
            this.zKP.setIMainSightViewCallback(new b() {
                public final void startChattingUI(String str) {
                    AppMethodBeat.i(35274);
                    Intent intent = new Intent(SightForwardUI.this.mController.ylL, ChattingUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("Chat_User", str);
                    SightForwardUI.this.startActivity(intent);
                    SightForwardUI.this.finish();
                    AppMethodBeat.o(35274);
                }

                public final void clG() {
                    AppMethodBeat.i(35275);
                    Intent intent = new Intent();
                    intent.setClass(SightForwardUI.this.mController.ylL, LauncherUI.class).addFlags(67108864);
                    SightForwardUI.this.startActivity(intent);
                    SightForwardUI.this.finish();
                    AppMethodBeat.o(35275);
                }
            });
            MainSightForwardContainerView mainSightForwardContainerView = this.zKP;
            ug = this.mPath;
            mainSightForwardContainerView.iWA = this;
            mainSightForwardContainerView.qAD = ug;
            mainSightForwardContainerView.qAB = g.cz(ug);
            long currentTimeMillis = System.currentTimeMillis();
            mainSightForwardContainerView.qAE = 1.3333334f;
            mainSightForwardContainerView.qAu = (SightCameraView) ((ViewStub) mainSightForwardContainerView.findViewById(R.id.d1y)).inflate();
            mainSightForwardContainerView.qAu.setTargetWidth(a.ouQ);
            mainSightForwardContainerView.qAu.setFixPreviewRate(mainSightForwardContainerView.qAE);
            mainSightForwardContainerView.qAu.setVisibility(0);
            mainSightForwardContainerView.qAy = mainSightForwardContainerView.findViewById(R.id.d23);
            mainSightForwardContainerView.qAy.setLayoutParams(new LayoutParams(-1, getSupportActionBar().getHeight()));
            mainSightForwardContainerView.qAx = mainSightForwardContainerView.findViewById(R.id.d24);
            mainSightForwardContainerView.ofJ = mainSightForwardContainerView.findViewById(R.id.d25);
            mainSightForwardContainerView.qAw = mainSightForwardContainerView.findViewById(R.id.d1z);
            mainSightForwardContainerView.qAx.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(25034);
                    MainSightForwardContainerView.this.kE(true);
                    AppMethodBeat.o(25034);
                }
            });
            mainSightForwardContainerView.ofJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(25035);
                    MainSightForwardContainerView.this.clH();
                    AppMethodBeat.o(25035);
                }
            });
            mainSightForwardContainerView.clF();
            ab.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.zKP.clE();
            mainSightForwardContainerView = this.zKP;
            if (mainSightForwardContainerView.qAt == null) {
                DisplayMetrics displayMetrics = mainSightForwardContainerView.getResources().getDisplayMetrics();
                float f = ((float) displayMetrics.widthPixels) / mainSightForwardContainerView.qAE;
                mainSightForwardContainerView.qAt = (MainSightSelectContactView) mainSightForwardContainerView.findViewById(R.id.d22);
                MainSightSelectContactView mainSightSelectContactView = mainSightForwardContainerView.qAt;
                MMFragmentActivity mMFragmentActivity = mainSightForwardContainerView.iWA;
                int i = (int) (((float) displayMetrics.heightPixels) - f);
                int i2 = displayMetrics.heightPixels;
                mainSightSelectContactView.iWA = mMFragmentActivity;
                mainSightSelectContactView.qBf = i;
                mainSightSelectContactView.setMainSightContentView(mainSightForwardContainerView);
                mainSightSelectContactView.addView(View.inflate(mainSightSelectContactView.getContext(), R.layout.ab8, null), -1, -2);
                mainSightSelectContactView.mListView = (ListView) mainSightSelectContactView.findViewById(R.id.iu);
                mainSightSelectContactView.qBi = new c(mainSightSelectContactView);
                mainSightSelectContactView.qBl = new LinearLayout(mainSightSelectContactView.getContext());
                mainSightSelectContactView.qBl.addView(new View(mainSightSelectContactView.getContext()), -1, mainSightSelectContactView.qBk.getViewHeight() - mainSightSelectContactView.qBf);
                mainSightSelectContactView.qBl.getChildAt(0).setBackgroundColor(0);
                mainSightSelectContactView.mListView.addHeaderView(mainSightSelectContactView.qBl);
                mainSightSelectContactView.mListView.setAdapter(mainSightSelectContactView.qBi);
                mainSightSelectContactView.mListView.setOnItemClickListener(mainSightForwardContainerView);
                mainSightSelectContactView.qBp = new HashSet();
                mainSightSelectContactView.qBq = new HashSet();
                mainSightSelectContactView.mListView.setOnScrollListener(mainSightSelectContactView);
                mainSightSelectContactView.qBg = new com.tencent.mm.plugin.sight.encode.ui.d();
                mainSightSelectContactView.qBg.qBb = mainSightSelectContactView;
                mainSightForwardContainerView.qAt.setSearchView(mainSightForwardContainerView.findViewById(R.id.b63));
                mainSightForwardContainerView.qAt.setEmptyBgView(mainSightForwardContainerView.findViewById(R.id.d20));
                mainSightForwardContainerView.qAt.setMainSightContentView(mainSightForwardContainerView);
            }
            mainSightForwardContainerView.kF(true);
            mainSightForwardContainerView.qAu.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(25036);
                    MainSightSelectContactView a = MainSightForwardContainerView.this.qAt;
                    a.qAC = false;
                    a.mListView.clearAnimation();
                    a.mListView.clearFocus();
                    a.mListView.setAdapter(a.qBi);
                    a.I(false, true);
                    a.setVisibility(0);
                    if (a.qBh == null) {
                        a.qBh = new TranslateAnimation(0.0f, 0.0f, (float) a.qBf, 0.0f);
                        a.qBh.setDuration(300);
                    }
                    a.mListView.startAnimation(a.qBh);
                    AppMethodBeat.o(25036);
                }
            }, 50);
            AppMethodBeat.o(35276);
        } else {
            ab.e("MicroMsg.SightForwardUI", "acc not ready");
            finish();
            AppMethodBeat.o(35276);
        }
    }

    public final int getLayoutId() {
        return R.layout.ab7;
    }

    public void onResume() {
        AppMethodBeat.i(35277);
        super.onResume();
        this.zKP.onResume();
        AppMethodBeat.o(35277);
    }

    public void onPause() {
        AppMethodBeat.i(35278);
        super.onPause();
        this.zKP.onPause();
        AppMethodBeat.o(35278);
    }
}
