package com.tencent.mm.plugin.downloader_app.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.c.a.a.c;
import com.tencent.mm.plugin.downloader.c.a.a.h;
import com.tencent.mm.plugin.downloader.c.a.a.l;
import com.tencent.mm.plugin.downloader.c.a.a.m;
import com.tencent.mm.plugin.downloader.c.b.f;
import com.tencent.mm.plugin.downloader.c.b.j;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadSearchUI extends MMActivity implements b {
    private o elS;
    private ProgressBar gHA;
    private DownloadSearchListView kPD;
    private TextView kPE;
    private String kPF;
    private boolean kPG;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(136183);
        super.onCreate(bundle);
        initView();
        a.a(13, 0, 0, 1, "", "", "");
        AppMethodBeat.o(136183);
    }

    public final void initView() {
        AppMethodBeat.i(136184);
        super.initView();
        this.kPD = (DownloadSearchListView) findViewById(R.id.bai);
        this.gHA = (ProgressBar) findViewById(R.id.baj);
        this.kPE = (TextView) findViewById(R.id.a9r);
        this.elS = new o();
        this.elS.qQ(true);
        this.elS.zHa = this;
        this.kPD.setOnItemClickListener(new MRecyclerView.a() {
            public final void I(View view, int i) {
                b bVar;
                AppMethodBeat.i(136181);
                ArrayList arrayList = DownloadSearchUI.this.kPD.kPy.iPr;
                if (arrayList == null || i < 0 || i >= arrayList.size()) {
                    bVar = null;
                } else {
                    bVar = (b) arrayList.get(i);
                }
                if (bVar == null) {
                    AppMethodBeat.o(136181);
                } else if (bVar.type == 2) {
                    DownloadSearchUI.this.kPD.IN(bVar.kPJ);
                    DownloadSearchUI.this.elS.setSearchContent(bVar.kPJ);
                    a.a(13, 1302, bVar.position, 2, "", "", a.dD("search_key_word", bVar.kPJ));
                    AppMethodBeat.o(136181);
                } else {
                    if (bVar.type == 3) {
                        DownloadSearchUI.this.kPD.IN(DownloadSearchUI.this.elS.getSearchContent());
                        if (!bo.isNullOrNil(bVar.jumpUrl)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("rawUrl", bVar.jumpUrl);
                            ((d) g.K(d.class)).f(DownloadSearchUI.this.mController.ylL, bundle);
                        }
                        a.a(13, 1303, bVar.position, 40, bVar.appId, "", "");
                    }
                    AppMethodBeat.o(136181);
                }
            }
        });
        AppMethodBeat.o(136184);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(136185);
        this.elS.a((FragmentActivity) this, menu);
        this.elS.setHint(getString(R.string.b7p));
        AppMethodBeat.o(136185);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(136186);
        this.elS.a((Activity) this, menu);
        AppMethodBeat.o(136186);
        return true;
    }

    public final void app() {
        AppMethodBeat.i(136187);
        ab.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
        AppMethodBeat.o(136187);
    }

    public final void apo() {
        AppMethodBeat.i(136188);
        ab.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
        aqX();
        onBackPressed();
        AppMethodBeat.o(136188);
    }

    public final void vO(final String str) {
        AppMethodBeat.i(136189);
        ab.i("MicroMsg.DownloadSearchUI", "onSearchChange");
        this.kPE.setVisibility(8);
        if (this.kPF == null || !this.kPF.equals(bo.nullAsNil(str))) {
            this.kPF = str;
            if (bo.isNullOrNil(str)) {
                this.gHA.setVisibility(8);
                DownloadSearchListView downloadSearchListView = this.kPD;
                downloadSearchListView.setVisibility(0);
                if (bo.ek(downloadSearchListView.kPz)) {
                    downloadSearchListView.kPz = b.dD(downloadSearchListView.mContext);
                }
                downloadSearchListView.setData(downloadSearchListView.kPz);
                this.kPG = true;
                AppMethodBeat.o(136189);
                return;
            }
            this.kPD.setData(null);
            this.kPG = false;
            this.kPD.setData(null);
            this.gHA.setVisibility(0);
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            l lVar = new l();
            lVar.kKE = str;
            com.tencent.mm.plugin.downloader.c.a.a.o oVar = new com.tencent.mm.plugin.downloader.c.a.a.o();
            oVar.offset = 0;
            oVar.limit = 5;
            lVar.kKF = oVar;
            aVar.fsJ = lVar;
            aVar.fsK = new m();
            aVar.uri = "/cgi-bin/mmgame-bin/getgamesearch";
            aVar.fsI = 2688;
            w.a(aVar.acD(), new w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(136182);
                    ab.i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (DownloadSearchUI.this.kPG) {
                        AppMethodBeat.o(136182);
                        return 0;
                    }
                    DownloadSearchUI.this.gHA.setVisibility(8);
                    if (i == 0 && i2 == 0) {
                        m mVar2 = (m) bVar.fsH.fsP;
                        if (mVar2 == null || mVar2.kKH == null || bo.ek(mVar2.kKH.kKA)) {
                            DownloadSearchUI.this.kPD.setVisibility(8);
                            DownloadSearchUI.this.kPE.setVisibility(0);
                            DownloadSearchUI.this.kPE.setText(DownloadSearchUI.this.getString(R.string.b7n, new Object[]{str}));
                            a.a(13, 1304, 0, 1, "", "", "");
                        } else {
                            ArrayList arrayList = new ArrayList();
                            int i3 = 0;
                            Iterator it = mVar2.kKH.kKA.iterator();
                            while (it.hasNext()) {
                                b bVar2;
                                int i4;
                                h hVar = (h) it.next();
                                String str2 = str;
                                if (hVar == null) {
                                    bVar2 = null;
                                } else {
                                    bVar2 = new b();
                                    bVar2.type = 3;
                                    com.tencent.mm.plugin.downloader.c.a.a.d dVar = hVar.kKy;
                                    if (dVar == null) {
                                        bVar2 = null;
                                    } else {
                                        j jVar = dVar.kKr;
                                        c cVar = dVar.kKt;
                                        if (cVar != null) {
                                            bVar2.jumpUrl = cVar.kKq;
                                        }
                                        if (jVar == null) {
                                            bVar2 = null;
                                        } else {
                                            com.tencent.mm.plugin.downloader.c.b.c cVar2 = jVar.kLw;
                                            com.tencent.mm.plugin.downloader.c.b.d dVar2 = jVar.kLx;
                                            f fVar = jVar.kLy;
                                            if (cVar2 == null) {
                                                bVar2 = null;
                                            } else if (cVar2.status != 0) {
                                                bVar2 = null;
                                            } else {
                                                bVar2.appId = cVar2.csB;
                                                bVar2.kPK = hVar.kKz;
                                                bVar2.iconUrl = cVar2.kKZ;
                                                if (!(dVar2 == null || bo.ek(dVar2.kLf))) {
                                                    bVar2.kPL = dVar2.kLf;
                                                }
                                                if (!(fVar == null || fVar.kLn == null)) {
                                                    bVar2.size = fVar.kLn.kKP;
                                                }
                                                bVar2.kPJ = str2;
                                                bVar2.state = 1;
                                                if (!(fVar == null || fVar.kLn == null)) {
                                                    PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(ah.getContext(), fVar.kLn.kKO);
                                                    com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(bVar2.appId);
                                                    if (packageInfo == null) {
                                                        if (In != null && In.field_status == 3 && e.ct(In.field_filePath)) {
                                                            bVar2.state = 4;
                                                        }
                                                    } else if (packageInfo.versionCode < fVar.kLn.kKS) {
                                                        bVar2.state = 3;
                                                    } else {
                                                        bVar2.state = 2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (bVar2 != null) {
                                    i4 = i3 + 1;
                                    bVar2.position = i4;
                                    arrayList.add(bVar2);
                                } else {
                                    i4 = i3;
                                }
                                i3 = i4;
                            }
                            DownloadSearchUI.this.kPE.setVisibility(8);
                            DownloadSearchListView a = DownloadSearchUI.this.kPD;
                            a.setVisibility(0);
                            a.kPA.clear();
                            if (!bo.ek(arrayList)) {
                                a.kPA.addAll(arrayList);
                            }
                            a.setData(a.kPA);
                            a.a(13, 1303, 0, 1, "", "", "");
                        }
                    }
                    AppMethodBeat.o(136182);
                    return 0;
                }
            });
            a.a(13, 1301, 1, 2, "", "", a.dD("search_key_word", str));
            AppMethodBeat.o(136189);
            return;
        }
        ab.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
        AppMethodBeat.o(136189);
    }

    public final boolean vN(String str) {
        AppMethodBeat.i(136190);
        ab.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136190);
        } else {
            this.kPD.IN(str);
            AppMethodBeat.o(136190);
        }
        return true;
    }

    public final void apq() {
        AppMethodBeat.i(136191);
        ab.i("MicroMsg.DownloadSearchUI", "onClickClearText");
        a.a(13, 1301, 2, 81, "", "", "");
        AppMethodBeat.o(136191);
    }

    public final void apr() {
        AppMethodBeat.i(136192);
        ab.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
        AppMethodBeat.o(136192);
    }

    public final int getLayoutId() {
        return R.layout.sv;
    }
}
