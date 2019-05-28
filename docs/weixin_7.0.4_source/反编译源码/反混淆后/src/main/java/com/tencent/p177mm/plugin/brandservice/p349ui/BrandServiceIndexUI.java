package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p349ui.base.BrandServiceSortView;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

@C18524i
/* renamed from: com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI */
public class BrandServiceIndexUI extends MMActivity implements C4931a {
    private int fmr = 251658241;
    private TextView jLE = null;
    private BrandServiceSortView jLF;
    private boolean jLG = false;
    private boolean jLH = false;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI$1 */
    class C111921 implements OnClickListener {
        C111921() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI$2 */
    class C337242 implements OnMenuItemClickListener {
        C337242() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13915);
            BrandServiceIndexUI.this.finish();
            AppMethodBeat.m2505o(13915);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI$3 */
    class C386833 implements OnMenuItemClickListener {
        C386833() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13916);
            C4990ab.m7418v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
            Intent intent = new Intent(BrandServiceIndexUI.this, BrandServiceLocalSearchUI.class);
            intent.putExtra("is_return_result", BrandServiceIndexUI.this.jLH);
            intent.addFlags(67108864);
            BrandServiceIndexUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(13916);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI$4 */
    class C457604 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI$4$1 */
        class C26861 implements Runnable {
            C26861() {
            }

            public final void run() {
                AppMethodBeat.m2504i(13917);
                Intent cVd = C46400aa.cVd();
                cVd.putExtra("KRightBtn", true);
                cVd.putExtra("ftsneedkeyboard", true);
                cVd.putExtra("key_load_js_without_delay", true);
                cVd.putExtra("ftsType", 1);
                cVd.putExtra("ftsbizscene", 6);
                Map d = C46400aa.m87334d(6, true, 0);
                String HP = C46400aa.m87299HP(C5046bo.ank((String) d.get("scene")));
                d.put("sessionId", HP);
                d.put("subSessionId", HP);
                cVd.putExtra("sessionId", HP);
                cVd.putExtra("rawUrl", C46400aa.m87298E(d));
                C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd);
                AppMethodBeat.m2505o(13917);
            }
        }

        C457604() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13918);
            if (C46400aa.m87304HU(0)) {
                ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(C4996ah.getContext(), new C26861());
            } else {
                C4990ab.m7412e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
            }
            BrandServiceIndexUI.this.enableOptionMenu(1, false);
            AppMethodBeat.m2505o(13918);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968883;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13919);
        super.onCreate(bundle);
        this.fmr = getIntent().getIntExtra("intent_service_type", 251658241);
        this.jLH = C15830s.m24192hr(getIntent().getIntExtra("list_attr", 0), 16384);
        initView();
        C41747z.aeR().mo10116c(this);
        AppMethodBeat.m2505o(13919);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13920);
        if (this.jLG) {
            this.jLG = false;
            this.jLF.refresh();
        }
        super.onResume();
        C45287c.aNX();
        enableOptionMenu(1, true);
        AppMethodBeat.m2505o(13920);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13921);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(233474, Long.valueOf(System.currentTimeMillis()));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(233473, Long.valueOf(System.currentTimeMillis()));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(233476, Long.valueOf(System.currentTimeMillis()));
        super.onPause();
        AppMethodBeat.m2505o(13921);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13922);
        if (C1720g.m3531RK()) {
            this.jLF.release();
            C41747z.aeR().mo10117d(this);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(13922);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13923);
        setMMTitle((int) C25738R.string.f8768ef);
        this.jLF = (BrandServiceSortView) findViewById(2131821896);
        this.jLF.setShowFooterView(true);
        this.jLF.setReturnResult(this.jLH);
        this.jLE = (TextView) findViewById(2131821895);
        this.jLE.setOnClickListener(new C111921());
        this.jLE.setVisibility(8);
        setBackBtn(new C337242());
        addIconOptionMenu(0, C25738R.string.ewn, C1318a.actionbar_icon_dark_search, new C386833());
        addIconOptionMenu(1, C25738R.string.f8814fs, C1318a.actionbar_icon_dark_add, new C457604());
        AppMethodBeat.m2505o(13923);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13924);
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && this.jLH) {
            setResult(-1, intent);
            finish();
        }
        AppMethodBeat.m2505o(13924);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(13925);
        C4990ab.m7419v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", str);
        this.jLG = true;
        AppMethodBeat.m2505o(13925);
    }
}
