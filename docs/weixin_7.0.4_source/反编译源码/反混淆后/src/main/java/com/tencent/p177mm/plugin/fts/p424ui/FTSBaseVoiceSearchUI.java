package com.tencent.p177mm.plugin.fts.p424ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p424ui.C12067d.C12068a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C12073d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI */
public abstract class FTSBaseVoiceSearchUI extends MMActivity implements C12068a, C28149e, C5600b {
    private C7306ak mHE = new C281393();
    ListView mIn;
    private C12067d mIo;
    TextView mIp;
    private boolean mIq = false;
    protected C12073d mIu;
    private RelativeLayout mIv;
    private boolean mIw;
    String query;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI$1 */
    class C208631 implements OnTouchListener {
        C208631() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(61782);
            FTSBaseVoiceSearchUI.this.mIu.clearFocus();
            FTSBaseVoiceSearchUI.this.aqX();
            AppMethodBeat.m2505o(61782);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI$2 */
    class C208642 implements OnMenuItemClickListener {
        C208642() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(61783);
            FTSBaseVoiceSearchUI.this.finish();
            AppMethodBeat.m2505o(61783);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI$3 */
    class C281393 extends C7306ak {
        C281393() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(61784);
            if (message.what == 1 && !C5046bo.isNullOrNil(FTSBaseVoiceSearchUI.this.query)) {
                FTSBaseVoiceSearchUI.this.bAM();
            }
            AppMethodBeat.m2505o(61784);
        }
    }

    /* renamed from: a */
    public abstract C12067d mo7445a(C28149e c28149e);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dyf();
        setMMTitle("");
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f12206vy));
        bAQ();
        this.mIu = new C12073d();
        this.mIu.zHa = this;
        this.mIu.mNe = false;
        this.mIn = (ListView) findViewById(2131824198);
        if (aWz() != null) {
            C4990ab.m7416i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView");
            this.mIn.addFooterView(aWz());
        }
        this.mIo = mo7445a((C28149e) this);
        this.mIo.mIm = this;
        this.mIn.setAdapter(this.mIo);
        this.mIn.setOnScrollListener(this.mIo);
        this.mIn.setOnItemClickListener(this.mIo);
        this.mIn.setOnTouchListener(new C208631());
        this.mIp = (TextView) findViewById(2131820903);
        setBackBtn(new C208642());
    }

    /* Access modifiers changed, original: protected */
    public void bAQ() {
    }

    /* Access modifiers changed, original: protected */
    public View aWz() {
        return null;
    }

    public final void app() {
        C4990ab.m7410d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
    }

    public final void apo() {
        C4990ab.m7410d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
        finish();
    }

    /* renamed from: vO */
    public void mo7460vO(String str) {
        C4990ab.m7419v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", str);
        if (C5046bo.isNullOrNil(str)) {
            if (!this.mIu.dJs()) {
                this.mIu.dJt();
                showVKB();
            }
            bAV();
        }
        String Nc = C3161d.m5405Nc(str);
        if (C5046bo.isNullOrNil(this.query) || !this.query.equals(Nc)) {
            this.query = Nc;
            if (C5046bo.isNullOrNil(this.query)) {
                this.mHE.removeMessages(1);
                this.mIq = false;
                this.mIo.stopSearch();
                bAV();
                return;
            }
            this.mHE.removeMessages(1);
            this.mHE.sendEmptyMessageDelayed(1, 300);
            return;
        }
        C4990ab.m7417i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", this.query, Nc);
    }

    public final void apq() {
    }

    /* renamed from: vN */
    public boolean mo7459vN(String str) {
        C4990ab.m7411d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", str);
        aqX();
        if (this.mIu != null) {
            this.mIu.clearFocus();
        }
        return false;
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
        if (this.mIv != null) {
            this.mIv.setVisibility(8);
        }
        this.mIn.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public void bAT() {
        this.mIp.setVisibility(0);
        this.mIp.setText(C34204f.m56087a(getString(C25738R.string.dzw), getString(C25738R.string.dzv), C39127d.m66573b(this.query, this.query)).mDR);
        if (this.mIv != null) {
            this.mIv.setVisibility(8);
        }
        this.mIn.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public void bAU() {
        this.mIp.setVisibility(8);
        if (this.mIv != null) {
            this.mIv.setVisibility(8);
        }
        this.mIn.setVisibility(0);
    }

    /* Access modifiers changed, original: protected */
    public void bAV() {
        this.mIp.setVisibility(8);
        if (this.mIv != null) {
            this.mIv.setVisibility(8);
        }
        this.mIn.setVisibility(8);
    }

    public void onPause() {
        super.onPause();
        this.mIu.clearFocus();
    }

    public void onDestroy() {
        this.mHE.removeMessages(1);
        this.mIo.finish();
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.mIu.mo11359a(this, menu);
        if (!this.mIw) {
            this.mIu.mo11371qQ(true);
            this.mIw = true;
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mIu.mo11358a((Activity) this, menu);
        return true;
    }

    /* renamed from: U */
    public void mo7444U(int i, boolean z) {
        C4990ab.m7417i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", Integer.valueOf(i), Boolean.valueOf(z));
        if (z) {
            bAX();
            if (i > 0) {
                bAU();
            } else {
                bAT();
            }
        } else if (i > 0) {
            bAU();
            bAW();
        } else {
            bAS();
            bAX();
        }
        if (this.mIq) {
            this.mIq = false;
            this.mIn.setSelection(0);
        }
    }

    /* Access modifiers changed, original: protected */
    public void bAW() {
    }

    /* Access modifiers changed, original: protected */
    public void bAX() {
    }

    public final void apr() {
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.ylL;
    }
}
