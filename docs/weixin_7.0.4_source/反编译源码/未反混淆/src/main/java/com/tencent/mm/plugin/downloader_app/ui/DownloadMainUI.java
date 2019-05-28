package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class DownloadMainUI extends MMActivity {
    private View emz;
    private f kOV;
    TaskListView kQc;
    private DeleteTaskFooterView kQd;
    private TaskManagerHeaderView kQe;
    private View kQf;
    private boolean kQg;
    private boolean kQh;
    private com.tencent.mm.plugin.downloader_app.b.f kQi;
    private boolean kQj = false;
    private String mAppId;

    public interface a {
        void gl(boolean z);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(DownloadMainUI downloadMainUI, com.tencent.mm.plugin.downloader_app.b.f fVar, boolean z) {
        AppMethodBeat.i(136248);
        downloadMainUI.a(fVar, z);
        AppMethodBeat.o(136248);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(136237);
        super.onCreate(bundle);
        overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.yng, com.tencent.mm.ui.MMFragmentActivity.a.ynh);
        ab.i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
        this.kQh = true;
        xE(getResources().getColor(R.color.ms));
        dyc();
        setMMTitle((int) R.string.g0e);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(136224);
                DownloadMainUI.this.finish();
                AppMethodBeat.o(136224);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(136225);
                DownloadMainUI.this.startActivity(new Intent(DownloadMainUI.this, DownloadSearchUI.class));
                com.tencent.mm.plugin.downloader_app.c.a.a(10, 1001, 1, 2, "", "", "");
                AppMethodBeat.o(136225);
                return true;
            }
        });
        this.kQc = (TaskListView) findViewById(R.id.l9);
        this.kQd = (DeleteTaskFooterView) findViewById(R.id.ba0);
        this.kQc.kRa = new a() {
            public final void gl(boolean z) {
                AppMethodBeat.i(136226);
                if (z) {
                    DownloadMainUI.this.kQd.setVisibility(0);
                    DownloadMainUI.this.kQd.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.aa));
                    DownloadMainUI.this.kQe.setVisibility(0);
                    DownloadMainUI.this.kQe.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.dz));
                    AppMethodBeat.o(136226);
                    return;
                }
                DownloadMainUI.this.kQd.setVisibility(8);
                DownloadMainUI.this.kQd.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.ab));
                DownloadMainUI.this.kQe.setVisibility(8);
                DownloadMainUI.this.kQe.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, R.anim.e0));
                AppMethodBeat.o(136226);
            }
        };
        this.kQe = (TaskManagerHeaderView) findViewById(R.id.abv);
        this.kQf = findViewById(R.id.ba1);
        this.mAppId = getIntent().getStringExtra("appId");
        this.kQj = getIntent().getBooleanExtra("view_task", false);
        g.bT(this.mAppId, true);
        Kh();
        com.tencent.mm.plugin.downloader_app.c.a.a(10, 0, 0, 1, "", "", "");
        AppMethodBeat.o(136237);
    }

    public void onResume() {
        AppMethodBeat.i(136238);
        super.onResume();
        this.kQg = true;
        if (!this.kQh) {
            this.kQi = com.tencent.mm.plugin.downloader_app.b.g.biM();
            a(this.kQi, true);
        }
        this.kQh = false;
        AppMethodBeat.o(136238);
    }

    public void onPause() {
        AppMethodBeat.i(136239);
        super.onPause();
        if (this.kQi != null) {
            ((com.tencent.mm.plugin.game.commlib.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.game.commlib.a.a.class)).a("pb_appinfo", this.kQi.kOS);
        }
        this.kQg = false;
        AppMethodBeat.o(136239);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(136240);
        setIntent(intent);
        this.kQc.biU();
        this.mAppId = intent.getStringExtra("appId");
        this.kQj = intent.getBooleanExtra("view_task", false);
        g.bT(this.mAppId, true);
        Kh();
        AppMethodBeat.o(136240);
    }

    public void onDestroy() {
        AppMethodBeat.i(136241);
        super.onDestroy();
        com.tencent.mm.plugin.downloader_app.b.g.kOX = null;
        AppMethodBeat.o(136241);
    }

    public void onBackPressed() {
        AppMethodBeat.i(136242);
        if (this.kQc != null) {
            Object obj;
            TaskListView taskListView = this.kQc;
            if (taskListView.kRb) {
                taskListView.biU();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.o(136242);
                return;
            }
        }
        super.onBackPressed();
        AppMethodBeat.o(136242);
    }

    private void Kh() {
        AppMethodBeat.i(136243);
        d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136229);
                DownloadMainUI.this.kQi = com.tencent.mm.plugin.downloader_app.b.g.biM();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136227);
                        DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.this.kQi, false);
                        AppMethodBeat.o(136227);
                    }
                });
                boolean a = DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.this.mAppId);
                if (DownloadMainUI.this.kQj || a) {
                    DownloadMainUI.this.c(j.biP(), null);
                    AppMethodBeat.o(136229);
                    return;
                }
                LinkedList biP = j.biP();
                if (!biP.contains(DownloadMainUI.this.mAppId)) {
                    biP.add(DownloadMainUI.this.mAppId);
                }
                DownloadMainUI.this.c(biP, DownloadMainUI.this.mAppId);
                l.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136228);
                        DownloadMainUI.f(DownloadMainUI.this);
                        AppMethodBeat.o(136228);
                    }
                });
                AppMethodBeat.o(136229);
            }
        });
        AppMethodBeat.o(136243);
    }

    public final void c(LinkedList<String> linkedList, final String str) {
        AppMethodBeat.i(136244);
        com.tencent.mm.plugin.downloader_app.b.g.a(linkedList, new com.tencent.mm.plugin.downloader_app.b.g.a() {
            public final void gd(boolean z) {
                AppMethodBeat.i(136236);
                l.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136233);
                        DownloadMainUI.h(DownloadMainUI.this);
                        AppMethodBeat.o(136233);
                    }
                });
                if (z) {
                    DownloadMainUI.this.kQi = com.tencent.mm.plugin.downloader_app.b.g.biM();
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(136235);
                            if (!bo.isNullOrNil(str)) {
                                final i IL = DownloadMainUI.this.kQi.IL(str);
                                if (IL != null) {
                                    j.Iz(str);
                                    l.postDelayed(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(136234);
                                            c.a(DownloadMainUI.this, IL, true);
                                            AppMethodBeat.o(136234);
                                        }
                                    }, 200);
                                } else {
                                    h.b(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(R.string.d7h), true);
                                }
                            }
                            DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.this.kQi, true);
                            AppMethodBeat.o(136235);
                        }
                    });
                    AppMethodBeat.o(136236);
                    return;
                }
                if (!bo.isNullOrNil(str)) {
                    h.b(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(R.string.ail), true);
                }
                AppMethodBeat.o(136236);
            }
        });
        AppMethodBeat.o(136244);
    }

    private void a(com.tencent.mm.plugin.downloader_app.b.f fVar, boolean z) {
        f fVar2;
        AppMethodBeat.i(136245);
        if (fVar != null) {
            fVar2 = fVar.kOV;
        } else {
            fVar2 = null;
        }
        this.kOV = fVar2;
        if (fVar == null || fVar.biL()) {
            if (z) {
                gk(true);
            }
            AppMethodBeat.o(136245);
            return;
        }
        LinkedList O = fVar.O(j.biP());
        if (bo.ek(O)) {
            gk(true);
            AppMethodBeat.o(136245);
            return;
        }
        gk(false);
        this.kQc.setData(O);
        AppMethodBeat.o(136245);
    }

    public final void gj(boolean z) {
        AppMethodBeat.i(136246);
        DeleteTaskFooterView deleteTaskFooterView = this.kQd;
        deleteTaskFooterView.kPZ = z;
        if (deleteTaskFooterView.kPZ) {
            deleteTaskFooterView.kPV.setImageResource(R.drawable.at5);
            AppMethodBeat.o(136246);
            return;
        }
        deleteTaskFooterView.kPV.setImageResource(R.drawable.at6);
        AppMethodBeat.o(136246);
    }

    /* Access modifiers changed, original: final */
    public final void gk(boolean z) {
        AppMethodBeat.i(136247);
        if (z) {
            if (this.kQf instanceof ViewStub) {
                this.kQf = ((ViewStub) this.kQf).inflate();
                this.kQf.setVisibility(0);
            }
        } else if (!(this.kQf instanceof ViewStub)) {
            this.kQf.setVisibility(8);
        }
        if (z) {
            this.kQf.setVisibility(0);
            ((NoTaskLayout) this.kQf).setData(this.kOV);
        }
        AppMethodBeat.o(136247);
    }

    public final int getLayoutId() {
        return R.layout.st;
    }

    static /* synthetic */ void f(DownloadMainUI downloadMainUI) {
        AppMethodBeat.i(136250);
        if (downloadMainUI.emz == null) {
            downloadMainUI.emz = downloadMainUI.findViewById(R.id.ue);
            downloadMainUI.emz = ((ViewStub) downloadMainUI.emz).inflate();
        }
        downloadMainUI.emz.setVisibility(0);
        AppMethodBeat.o(136250);
    }

    static /* synthetic */ void h(DownloadMainUI downloadMainUI) {
        AppMethodBeat.i(136251);
        if (downloadMainUI.emz != null) {
            downloadMainUI.emz.setVisibility(8);
        }
        AppMethodBeat.o(136251);
    }
}
