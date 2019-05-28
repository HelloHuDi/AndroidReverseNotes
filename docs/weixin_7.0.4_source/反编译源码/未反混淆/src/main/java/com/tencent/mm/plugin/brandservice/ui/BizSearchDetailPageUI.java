package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import java.io.IOException;
import java.util.LinkedList;

public class BizSearchDetailPageUI extends MMActivity implements b {
    private int Lp;
    private int emC;
    private o jKT;
    private BizSearchResultItemContainer jKU;
    private long jKV;
    private String jKW;
    private int jKX;
    private Runnable jKY = new Runnable() {
        public final void run() {
            AppMethodBeat.i(13875);
            BizSearchDetailPageUI.this.jKU.bH(BizSearchDetailPageUI.this.jKW, BizSearchDetailPageUI.this.Lp);
            BizSearchDetailPageUI.this.Lp = 0;
            AppMethodBeat.o(13875);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizSearchDetailPageUI() {
        AppMethodBeat.i(13879);
        AppMethodBeat.o(13879);
    }

    public final int getLayoutId() {
        return R.layout.gu;
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13880);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13876);
                BizSearchDetailPageUI.this.finish();
                AppMethodBeat.o(13876);
                return true;
            }
        });
        Intent intent = getIntent();
        this.jKV = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.emC = intent.getIntExtra("fromScene", 0);
        this.jKX = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.Lp = intent.getIntExtra("offset", 0);
        if (this.jKV == 0 || bo.isNullOrNil(stringExtra2)) {
            ab.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", Long.valueOf(this.jKV));
            finish();
            AppMethodBeat.o(13880);
            return;
        }
        mh mhVar;
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        Object obj = null;
        if (byteArrayExtra != null) {
            try {
                mh mhVar2 = (mh) new mh().parseFrom(byteArrayExtra);
                if (mhVar2 != null) {
                    obj = 1;
                }
                mhVar = mhVar2;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", e, "", new Object[0]);
                finish();
                AppMethodBeat.o(13880);
                return;
            }
        }
        mhVar = null;
        this.jKU = (BizSearchResultItemContainer) findViewById(R.id.a6x);
        this.jKU.setAdapter(new c(this));
        this.jKU.setBusinessTypes(this.jKV);
        this.jKU.setMode(1);
        this.jKU.setDisplayArgs$25decb5(booleanExtra2);
        this.jKU.setScene(this.emC);
        this.jKU.setAddContactScene(this.jKX);
        this.jKU.setReporter(new c.b() {
            public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
                AppMethodBeat.i(13877);
                if (BizSearchDetailPageUI.this.emC == 1 && aVar.type == 5) {
                    mn mnVar = (mn) aVar.getData();
                    if (mnVar.vQv == null || mnVar.vQv.vQb == null) {
                        ab.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                        AppMethodBeat.o(13877);
                        return;
                    }
                    mh sa = cVar.sa(i3);
                    String str2 = bo.nullAsNil(BizSearchDetailPageUI.this.jKW) + "," + i + "," + bo.nullAsNil(str) + "," + i2 + "," + cVar.jLe + "," + (sa == null ? "" : sa.vQg + ",1");
                    h.pYm.X(10866, str2);
                    ab.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(str2)));
                    if ((mnVar.vQv.vQb.wBT & 8) > 0) {
                        h.pYm.X(10298, str + ",35");
                    }
                }
                AppMethodBeat.o(13877);
            }
        });
        if (booleanExtra) {
            this.jKT = new o();
            a(this.jKT);
            this.jKT.qQ(false);
            this.jKT.clearFocus();
            this.jKT.setSearchContent(stringExtra2);
            this.jKT.zHa = this;
            this.jKU.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(13878);
                    if (BizSearchDetailPageUI.this.jKT != null) {
                        BizSearchDetailPageUI.this.jKT.clearFocus();
                    }
                    BizSearchDetailPageUI.this.aqX();
                    AppMethodBeat.o(13878);
                    return false;
                }
            });
        } else if (!bo.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        if (obj != null) {
            BizSearchResultItemContainer bizSearchResultItemContainer = this.jKU;
            int i = this.Lp;
            bizSearchResultItemContainer.reset();
            if (mhVar == null) {
                ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                AppMethodBeat.o(13880);
                return;
            }
            boolean z;
            bizSearchResultItemContainer.jLp.ctj = stringExtra2;
            bizSearchResultItemContainer.setBusinessTypes(mhVar.vQd);
            bizSearchResultItemContainer.jLp.jLh = mhVar.vQe;
            bizSearchResultItemContainer.jLu = i;
            LinkedList linkedList = new LinkedList();
            linkedList.add(mhVar);
            bizSearchResultItemContainer.jLn.h(stringExtra2, linkedList);
            bizSearchResultItemContainer.jLp.offset = i + mhVar.vOq;
            c cVar = bizSearchResultItemContainer.jLp;
            if (bizSearchResultItemContainer.jLn.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            cVar.jLD = z;
            AppMethodBeat.o(13880);
            return;
        }
        vO(stringExtra2);
        AppMethodBeat.o(13880);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(13881);
        if (this.jKT != null) {
            this.jKT.a((FragmentActivity) this, menu);
        }
        AppMethodBeat.o(13881);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(13882);
        if (this.jKT != null) {
            this.jKT.a((Activity) this, menu);
        }
        AppMethodBeat.o(13882);
        return true;
    }

    public void onPause() {
        AppMethodBeat.i(13883);
        super.onPause();
        if (this.jKT != null) {
            this.jKT.clearFocus();
        }
        AppMethodBeat.o(13883);
    }

    public final boolean vN(String str) {
        return false;
    }

    public final void vO(String str) {
        AppMethodBeat.i(13884);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(13884);
            return;
        }
        String trim = str.trim();
        if (!trim.equals(this.jKW)) {
            al.af(this.jKY);
            this.jKW = trim;
            al.n(this.jKY, 400);
        }
        AppMethodBeat.o(13884);
    }

    public final void apo() {
        AppMethodBeat.i(13885);
        finish();
        AppMethodBeat.o(13885);
    }

    public final void app() {
    }
}
