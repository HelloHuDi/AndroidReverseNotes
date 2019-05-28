package com.tencent.p177mm.plugin.downloader_app.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C2594a;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C11504c;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C20311d;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C20312j;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C38845f;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C11503o;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C20307c;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C20309l;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C27703m;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C33904d;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C42907h;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI */
public class DownloadSearchUI extends MMActivity implements C5600b {
    private C5601o elS;
    private ProgressBar gHA;
    private DownloadSearchListView kPD;
    private TextView kPE;
    private String kPF;
    private boolean kPG;

    /* renamed from: com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI$1 */
    class C388661 implements C2594a {
        C388661() {
        }

        /* renamed from: I */
        public final void mo6645I(View view, int i) {
            C42924b c42924b;
            AppMethodBeat.m2504i(136181);
            ArrayList arrayList = DownloadSearchUI.this.kPD.kPy.iPr;
            if (arrayList == null || i < 0 || i >= arrayList.size()) {
                c42924b = null;
            } else {
                c42924b = (C42924b) arrayList.get(i);
            }
            if (c42924b == null) {
                AppMethodBeat.m2505o(136181);
            } else if (c42924b.type == 2) {
                DownloadSearchUI.this.kPD.mo54482IN(c42924b.kPJ);
                DownloadSearchUI.this.elS.setSearchContent(c42924b.kPJ);
                C45838a.m84850a(13, 1302, c42924b.position, 2, "", "", C45838a.m84851dD("search_key_word", c42924b.kPJ));
                AppMethodBeat.m2505o(136181);
            } else {
                if (c42924b.type == 3) {
                    DownloadSearchUI.this.kPD.mo54482IN(DownloadSearchUI.this.elS.getSearchContent());
                    if (!C5046bo.isNullOrNil(c42924b.jumpUrl)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("rawUrl", c42924b.jumpUrl);
                        ((C38855d) C1720g.m3528K(C38855d.class)).mo61733f(DownloadSearchUI.this.mController.ylL, bundle);
                    }
                    C45838a.m84850a(13, 1303, c42924b.position, 40, c42924b.appId, "", "");
                }
                AppMethodBeat.m2505o(136181);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(136183);
        super.onCreate(bundle);
        initView();
        C45838a.m84850a(13, 0, 0, 1, "", "", "");
        AppMethodBeat.m2505o(136183);
    }

    public final void initView() {
        AppMethodBeat.m2504i(136184);
        super.initView();
        this.kPD = (DownloadSearchListView) findViewById(2131823338);
        this.gHA = (ProgressBar) findViewById(2131823339);
        this.kPE = (TextView) findViewById(2131821905);
        this.elS = new C5601o();
        this.elS.mo11371qQ(true);
        this.elS.zHa = this;
        this.kPD.setOnItemClickListener(new C388661());
        AppMethodBeat.m2505o(136184);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(136185);
        this.elS.mo11359a((FragmentActivity) this, menu);
        this.elS.setHint(getString(C25738R.string.b7p));
        AppMethodBeat.m2505o(136185);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(136186);
        this.elS.mo11358a((Activity) this, menu);
        AppMethodBeat.m2505o(136186);
        return true;
    }

    public final void app() {
        AppMethodBeat.m2504i(136187);
        C4990ab.m7416i("MicroMsg.DownloadSearchUI", "onEnterSearch");
        AppMethodBeat.m2505o(136187);
    }

    public final void apo() {
        AppMethodBeat.m2504i(136188);
        C4990ab.m7416i("MicroMsg.DownloadSearchUI", "onQuitSearch");
        aqX();
        onBackPressed();
        AppMethodBeat.m2505o(136188);
    }

    /* renamed from: vO */
    public final void mo7460vO(final String str) {
        AppMethodBeat.m2504i(136189);
        C4990ab.m7416i("MicroMsg.DownloadSearchUI", "onSearchChange");
        this.kPE.setVisibility(8);
        if (this.kPF == null || !this.kPF.equals(C5046bo.nullAsNil(str))) {
            this.kPF = str;
            if (C5046bo.isNullOrNil(str)) {
                this.gHA.setVisibility(8);
                DownloadSearchListView downloadSearchListView = this.kPD;
                downloadSearchListView.setVisibility(0);
                if (C5046bo.m7548ek(downloadSearchListView.kPz)) {
                    downloadSearchListView.kPz = C42924b.m76229dD(downloadSearchListView.mContext);
                }
                downloadSearchListView.setData(downloadSearchListView.kPz);
                this.kPG = true;
                AppMethodBeat.m2505o(136189);
                return;
            }
            this.kPD.setData(null);
            this.kPG = false;
            this.kPD.setData(null);
            this.gHA.setVisibility(0);
            C1196a c1196a = new C1196a();
            C20309l c20309l = new C20309l();
            c20309l.kKE = str;
            C11503o c11503o = new C11503o();
            c11503o.offset = 0;
            c11503o.limit = 5;
            c20309l.kKF = c11503o;
            c1196a.fsJ = c20309l;
            c1196a.fsK = new C27703m();
            c1196a.uri = "/cgi-bin/mmgame-bin/getgamesearch";
            c1196a.fsI = 2688;
            C1226w.m2654a(c1196a.acD(), new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(136182);
                    C4990ab.m7417i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (DownloadSearchUI.this.kPG) {
                        AppMethodBeat.m2505o(136182);
                        return 0;
                    }
                    DownloadSearchUI.this.gHA.setVisibility(8);
                    if (i == 0 && i2 == 0) {
                        C27703m c27703m = (C27703m) c7472b.fsH.fsP;
                        if (c27703m == null || c27703m.kKH == null || C5046bo.m7548ek(c27703m.kKH.kKA)) {
                            DownloadSearchUI.this.kPD.setVisibility(8);
                            DownloadSearchUI.this.kPE.setVisibility(0);
                            DownloadSearchUI.this.kPE.setText(DownloadSearchUI.this.getString(C25738R.string.b7n, new Object[]{str}));
                            C45838a.m84850a(13, 1304, 0, 1, "", "", "");
                        } else {
                            ArrayList arrayList = new ArrayList();
                            int i3 = 0;
                            Iterator it = c27703m.kKH.kKA.iterator();
                            while (it.hasNext()) {
                                C42924b c42924b;
                                int i4;
                                C42907h c42907h = (C42907h) it.next();
                                String str2 = str;
                                if (c42907h == null) {
                                    c42924b = null;
                                } else {
                                    c42924b = new C42924b();
                                    c42924b.type = 3;
                                    C33904d c33904d = c42907h.kKy;
                                    if (c33904d == null) {
                                        c42924b = null;
                                    } else {
                                        C20312j c20312j = c33904d.kKr;
                                        C20307c c20307c = c33904d.kKt;
                                        if (c20307c != null) {
                                            c42924b.jumpUrl = c20307c.kKq;
                                        }
                                        if (c20312j == null) {
                                            c42924b = null;
                                        } else {
                                            C11504c c11504c = c20312j.kLw;
                                            C20311d c20311d = c20312j.kLx;
                                            C38845f c38845f = c20312j.kLy;
                                            if (c11504c == null) {
                                                c42924b = null;
                                            } else if (c11504c.status != 0) {
                                                c42924b = null;
                                            } else {
                                                c42924b.appId = c11504c.csB;
                                                c42924b.kPK = c42907h.kKz;
                                                c42924b.iconUrl = c11504c.kKZ;
                                                if (!(c20311d == null || C5046bo.m7548ek(c20311d.kLf))) {
                                                    c42924b.kPL = c20311d.kLf;
                                                }
                                                if (!(c38845f == null || c38845f.kLn == null)) {
                                                    c42924b.size = c38845f.kLn.kKP;
                                                }
                                                c42924b.kPJ = str2;
                                                c42924b.state = 1;
                                                if (!(c38845f == null || c38845f.kLn == null)) {
                                                    PackageInfo packageInfo = C19679b.getPackageInfo(C4996ah.getContext(), c38845f.kLn.kKO);
                                                    C42911a In = C2895c.m5140In(c42924b.appId);
                                                    if (packageInfo == null) {
                                                        if (In != null && In.field_status == 3 && C5730e.m8628ct(In.field_filePath)) {
                                                            c42924b.state = 4;
                                                        }
                                                    } else if (packageInfo.versionCode < c38845f.kLn.kKS) {
                                                        c42924b.state = 3;
                                                    } else {
                                                        c42924b.state = 2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (c42924b != null) {
                                    i4 = i3 + 1;
                                    c42924b.position = i4;
                                    arrayList.add(c42924b);
                                } else {
                                    i4 = i3;
                                }
                                i3 = i4;
                            }
                            DownloadSearchUI.this.kPE.setVisibility(8);
                            DownloadSearchListView a = DownloadSearchUI.this.kPD;
                            a.setVisibility(0);
                            a.kPA.clear();
                            if (!C5046bo.m7548ek(arrayList)) {
                                a.kPA.addAll(arrayList);
                            }
                            a.setData(a.kPA);
                            C45838a.m84850a(13, 1303, 0, 1, "", "", "");
                        }
                    }
                    AppMethodBeat.m2505o(136182);
                    return 0;
                }
            });
            C45838a.m84850a(13, 1301, 1, 2, "", "", C45838a.m84851dD("search_key_word", str));
            AppMethodBeat.m2505o(136189);
            return;
        }
        C4990ab.m7410d("MicroMsg.DownloadSearchUI", "repeat searchChange");
        AppMethodBeat.m2505o(136189);
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        AppMethodBeat.m2504i(136190);
        C4990ab.m7416i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136190);
        } else {
            this.kPD.mo54482IN(str);
            AppMethodBeat.m2505o(136190);
        }
        return true;
    }

    public final void apq() {
        AppMethodBeat.m2504i(136191);
        C4990ab.m7416i("MicroMsg.DownloadSearchUI", "onClickClearText");
        C45838a.m84850a(13, 1301, 2, 81, "", "", "");
        AppMethodBeat.m2505o(136191);
    }

    public final void apr() {
        AppMethodBeat.m2504i(136192);
        C4990ab.m7416i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
        AppMethodBeat.m2505o(136192);
    }

    public final int getLayoutId() {
        return 2130969302;
    }
}
