package com.tencent.p177mm.plugin.fts.p424ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.p057v4.content.C0380b;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.C12067d.C12068a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12070a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20892a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseUI */
public abstract class FTSBaseUI extends MMActivity implements C12068a, C28149e, C20892a, C12070a {
    private C7306ak mHE = new C431263();
    ListView mIn;
    private C12067d mIo;
    private TextView mIp;
    private boolean mIq = false;
    C43138a mIr;
    private String mIs = null;
    String query;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseUI$1 */
    class C342261 implements OnTouchListener {
        C342261() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(61779);
            FTSBaseUI.this.mIr.getFtsEditText().mLL.clearFocus();
            FTSBaseUI.this.aqX();
            AppMethodBeat.m2505o(61779);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseUI$2 */
    class C391422 implements OnMenuItemClickListener {
        C391422() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(61780);
            FTSBaseUI.this.finish();
            AppMethodBeat.m2505o(61780);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseUI$3 */
    class C431263 extends C7306ak {
        C431263() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(61781);
            if (message.what == 1 && !C5046bo.isNullOrNil(FTSBaseUI.this.query)) {
                FTSBaseUI.this.bAM();
            }
            AppMethodBeat.m2505o(61781);
        }
    }

    /* renamed from: a */
    public abstract C12067d mo7440a(C28149e c28149e);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dyf();
        setMMTitle("");
        mo17446xE(C0380b.m652i(this.mController.ylL, C25738R.color.f12206vy));
        bAQ();
        bAP();
    }

    /* Access modifiers changed, original: protected */
    public void bAQ() {
    }

    /* Access modifiers changed, original: protected */
    public void bAP() {
        this.mIr = new C43138a(this);
        this.mIr.setSearchViewListener(this);
        this.mIr.getFtsEditText().setHint(getHint());
        this.mIr.getFtsEditText().setFtsEditTextListener(this);
        this.mIr.getFtsEditText().setCanDeleteTag(false);
        getSupportActionBar().setCustomView(this.mIr);
        this.mIn = (ListView) findViewById(2131824198);
        this.mIo = mo7440a((C28149e) this);
        this.mIo.mIm = this;
        this.mIn.setAdapter(this.mIo);
        this.mIn.setOnScrollListener(this.mIo);
        this.mIn.setOnItemClickListener(this.mIo);
        this.mIn.setOnTouchListener(new C342261());
        this.mIp = (TextView) findViewById(2131820903);
        setBackBtn(new C391422());
    }

    public String getHint() {
        if (this.mIs != null) {
            return this.mIs;
        }
        return getString(C25738R.string.f9220te);
    }

    public final void setHint(String str) {
        this.mIs = str;
        this.mIr.getFtsEditText().setHint(getHint());
    }

    /* renamed from: a */
    public void mo7441a(C3154a c3154a) {
    }

    public void onClickBackBtn(View view) {
        finish();
    }

    public void onClickCancelBtn(View view) {
    }

    public final void bAR() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: l */
    public final void mo68643l(String str, List<C12071b> list) {
        this.query = str;
        this.mIr.getFtsEditText().mo36173n(str, list);
    }

    /* renamed from: a */
    public void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        if (c20890b == C20890b.UserInput) {
            String Nc = C3161d.m5405Nc(str);
            if (C5046bo.isNullOrNil(this.query) || !this.query.equals(Nc)) {
                mo68638Nv(Nc);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", this.query, Nc);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Nv */
    public void mo68638Nv(String str) {
        if (C5046bo.isNullOrNil(str)) {
            stopSearch();
            return;
        }
        this.query = str;
        this.mHE.removeMessages(1);
        this.mHE.sendEmptyMessageDelayed(1, 300);
    }

    /* Access modifiers changed, original: protected */
    public void stopSearch() {
        this.query = "";
        this.mHE.removeMessages(1);
        this.mIq = false;
        this.mIo.stopSearch();
        this.mIr.getFtsEditText().setHint(getHint());
        bAV();
    }

    /* renamed from: hz */
    public final void mo25276hz(boolean z) {
    }

    public void onClickClearTextBtn(View view) {
        stopSearch();
        this.mIr.getFtsEditText().bBo();
        showVKB();
    }

    public boolean aMo() {
        aqX();
        this.mIr.getFtsEditText().mLL.clearFocus();
        return false;
    }

    public void onDestroy() {
        this.mHE.removeMessages(1);
        this.mIo.finish();
        super.onDestroy();
    }

    /* Access modifiers changed, original: protected */
    public void bAM() {
        this.mIq = true;
        this.mIo.mo23893Nu(this.query);
        bAS();
    }

    /* Access modifiers changed, original: protected */
    public void bAS() {
        this.mIp.setVisibility(8);
        this.mIn.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public void bAT() {
        this.mIp.setVisibility(0);
        this.mIp.setText(C34204f.m56087a(getString(C25738R.string.dzw), getString(C25738R.string.dzv), C39127d.m66573b(this.query, this.query)).mDR);
        this.mIn.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public void bAU() {
        this.mIp.setVisibility(8);
        this.mIn.setVisibility(0);
    }

    /* Access modifiers changed, original: protected */
    public void bAV() {
        this.mIp.setVisibility(8);
        this.mIn.setVisibility(8);
    }

    /* renamed from: U */
    public final void mo7444U(int i, boolean z) {
        C4990ab.m7417i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", Integer.valueOf(i), Boolean.valueOf(z));
        if (z) {
            if (i > 0) {
                bAU();
            } else {
                bAT();
            }
        } else if (i > 0) {
            bAU();
        } else {
            bAS();
        }
        if (this.mIq) {
            this.mIq = false;
            this.mIn.setSelection(0);
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.ylL;
    }
}
