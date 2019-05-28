package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.brandservice.p349ui.BizSearchResultItemContainer.C2685c;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38691b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15361mn;
import com.tencent.p177mm.protocal.protobuf.C35934mh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI */
public class BizSearchDetailPageUI extends MMActivity implements C5600b {
    /* renamed from: Lp */
    private int f17192Lp;
    private int emC;
    private C5601o jKT;
    private BizSearchResultItemContainer jKU;
    private long jKV;
    private String jKW;
    private int jKX;
    private Runnable jKY = new C337211();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI$1 */
    class C337211 implements Runnable {
        C337211() {
        }

        public final void run() {
            AppMethodBeat.m2504i(13875);
            BizSearchDetailPageUI.this.jKU.mo61525bH(BizSearchDetailPageUI.this.jKW, BizSearchDetailPageUI.this.f17192Lp);
            BizSearchDetailPageUI.this.f17192Lp = 0;
            AppMethodBeat.m2505o(13875);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI$3 */
    class C337223 implements C38691b {
        C337223() {
        }

        /* renamed from: a */
        public final void mo35292a(C42811c c42811c, C46635a c46635a, int i, String str, int i2, int i3) {
            AppMethodBeat.m2504i(13877);
            if (BizSearchDetailPageUI.this.emC == 1 && c46635a.type == 5) {
                C15361mn c15361mn = (C15361mn) c46635a.getData();
                if (c15361mn.vQv == null || c15361mn.vQv.vQb == null) {
                    C4990ab.m7412e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                    AppMethodBeat.m2505o(13877);
                    return;
                }
                C35934mh sa = c42811c.mo68274sa(i3);
                String str2 = C5046bo.nullAsNil(BizSearchDetailPageUI.this.jKW) + "," + i + "," + C5046bo.nullAsNil(str) + "," + i2 + "," + c42811c.jLe + "," + (sa == null ? "" : sa.vQg + ",1");
                C7060h.pYm.mo8374X(10866, str2);
                C4990ab.m7410d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(str2)));
                if ((c15361mn.vQv.vQb.wBT & 8) > 0) {
                    C7060h.pYm.mo8374X(10298, str + ",35");
                }
            }
            AppMethodBeat.m2505o(13877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI$4 */
    class C337234 implements OnTouchListener {
        C337234() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(13878);
            if (BizSearchDetailPageUI.this.jKT != null) {
                BizSearchDetailPageUI.this.jKT.clearFocus();
            }
            BizSearchDetailPageUI.this.aqX();
            AppMethodBeat.m2505o(13878);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI$2 */
    class C427972 implements OnMenuItemClickListener {
        C427972() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13876);
            BizSearchDetailPageUI.this.finish();
            AppMethodBeat.m2505o(13876);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BizSearchDetailPageUI() {
        AppMethodBeat.m2504i(13879);
        AppMethodBeat.m2505o(13879);
    }

    public final int getLayoutId() {
        return 2130968855;
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13880);
        super.onCreate(bundle);
        setBackBtn(new C427972());
        Intent intent = getIntent();
        this.jKV = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.emC = intent.getIntExtra("fromScene", 0);
        this.jKX = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.f17192Lp = intent.getIntExtra("offset", 0);
        if (this.jKV == 0 || C5046bo.isNullOrNil(stringExtra2)) {
            C4990ab.m7413e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", Long.valueOf(this.jKV));
            finish();
            AppMethodBeat.m2505o(13880);
            return;
        }
        C35934mh c35934mh;
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        Object obj = null;
        if (byteArrayExtra != null) {
            try {
                C35934mh c35934mh2 = (C35934mh) new C35934mh().parseFrom(byteArrayExtra);
                if (c35934mh2 != null) {
                    obj = 1;
                }
                c35934mh = c35934mh2;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", e, "", new Object[0]);
                finish();
                AppMethodBeat.m2505o(13880);
                return;
            }
        }
        c35934mh = null;
        this.jKU = (BizSearchResultItemContainer) findViewById(2131821800);
        this.jKU.setAdapter(new C42811c(this));
        this.jKU.setBusinessTypes(this.jKV);
        this.jKU.setMode(1);
        this.jKU.setDisplayArgs$25decb5(booleanExtra2);
        this.jKU.setScene(this.emC);
        this.jKU.setAddContactScene(this.jKX);
        this.jKU.setReporter(new C337223());
        if (booleanExtra) {
            this.jKT = new C5601o();
            mo17380a(this.jKT);
            this.jKT.mo11371qQ(false);
            this.jKT.clearFocus();
            this.jKT.setSearchContent(stringExtra2);
            this.jKT.zHa = this;
            this.jKU.setOnTouchListener(new C337234());
        } else if (!C5046bo.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        if (obj != null) {
            BizSearchResultItemContainer bizSearchResultItemContainer = this.jKU;
            int i = this.f17192Lp;
            bizSearchResultItemContainer.reset();
            if (c35934mh == null) {
                C4990ab.m7412e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                AppMethodBeat.m2505o(13880);
                return;
            }
            boolean z;
            bizSearchResultItemContainer.jLp.ctj = stringExtra2;
            bizSearchResultItemContainer.setBusinessTypes(c35934mh.vQd);
            bizSearchResultItemContainer.jLp.jLh = c35934mh.vQe;
            bizSearchResultItemContainer.jLu = i;
            LinkedList linkedList = new LinkedList();
            linkedList.add(c35934mh);
            bizSearchResultItemContainer.jLn.mo35289h(stringExtra2, linkedList);
            bizSearchResultItemContainer.jLp.offset = i + c35934mh.vOq;
            C2685c c2685c = bizSearchResultItemContainer.jLp;
            if (bizSearchResultItemContainer.jLn.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            c2685c.jLD = z;
            AppMethodBeat.m2505o(13880);
            return;
        }
        mo7460vO(stringExtra2);
        AppMethodBeat.m2505o(13880);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(13881);
        if (this.jKT != null) {
            this.jKT.mo11359a((FragmentActivity) this, menu);
        }
        AppMethodBeat.m2505o(13881);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(13882);
        if (this.jKT != null) {
            this.jKT.mo11358a((Activity) this, menu);
        }
        AppMethodBeat.m2505o(13882);
        return true;
    }

    public void onPause() {
        AppMethodBeat.m2504i(13883);
        super.onPause();
        if (this.jKT != null) {
            this.jKT.clearFocus();
        }
        AppMethodBeat.m2505o(13883);
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        return false;
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        AppMethodBeat.m2504i(13884);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(13884);
            return;
        }
        String trim = str.trim();
        if (!trim.equals(this.jKW)) {
            C5004al.m7439af(this.jKY);
            this.jKW = trim;
            C5004al.m7442n(this.jKY, 400);
        }
        AppMethodBeat.m2505o(13884);
    }

    public final void apo() {
        AppMethodBeat.m2504i(13885);
        finish();
        AppMethodBeat.m2505o(13885);
    }

    public final void app() {
    }
}
