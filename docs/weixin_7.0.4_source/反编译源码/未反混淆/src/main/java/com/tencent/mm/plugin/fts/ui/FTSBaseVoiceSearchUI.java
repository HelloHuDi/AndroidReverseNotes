package com.tencent.mm.plugin.fts.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.o.b;

@a(19)
public abstract class FTSBaseVoiceSearchUI extends MMActivity implements d.a, e, b {
    private ak mHE = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(61784);
            if (message.what == 1 && !bo.isNullOrNil(FTSBaseVoiceSearchUI.this.query)) {
                FTSBaseVoiceSearchUI.this.bAM();
            }
            AppMethodBeat.o(61784);
        }
    };
    ListView mIn;
    private d mIo;
    TextView mIp;
    private boolean mIq = false;
    protected d mIu;
    private RelativeLayout mIv;
    private boolean mIw;
    String query;

    public abstract d a(e eVar);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dyf();
        setMMTitle("");
        xE(this.mController.ylL.getResources().getColor(R.color.vy));
        bAQ();
        this.mIu = new d();
        this.mIu.zHa = this;
        this.mIu.mNe = false;
        this.mIn = (ListView) findViewById(R.id.bxr);
        if (aWz() != null) {
            ab.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView");
            this.mIn.addFooterView(aWz());
        }
        this.mIo = a((e) this);
        this.mIo.mIm = this;
        this.mIn.setAdapter(this.mIo);
        this.mIn.setOnScrollListener(this.mIo);
        this.mIn.setOnItemClickListener(this.mIo);
        this.mIn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(61782);
                FTSBaseVoiceSearchUI.this.mIu.clearFocus();
                FTSBaseVoiceSearchUI.this.aqX();
                AppMethodBeat.o(61782);
                return false;
            }
        });
        this.mIp = (TextView) findViewById(R.id.j0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(61783);
                FTSBaseVoiceSearchUI.this.finish();
                AppMethodBeat.o(61783);
                return true;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void bAQ() {
    }

    /* Access modifiers changed, original: protected */
    public View aWz() {
        return null;
    }

    public final void app() {
        ab.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
    }

    public final void apo() {
        ab.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
        finish();
    }

    public void vO(String str) {
        ab.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", str);
        if (bo.isNullOrNil(str)) {
            if (!this.mIu.dJs()) {
                this.mIu.dJt();
                showVKB();
            }
            bAV();
        }
        String Nc = com.tencent.mm.plugin.fts.a.d.Nc(str);
        if (bo.isNullOrNil(this.query) || !this.query.equals(Nc)) {
            this.query = Nc;
            if (bo.isNullOrNil(this.query)) {
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
        ab.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", this.query, Nc);
    }

    public final void apq() {
    }

    public boolean vN(String str) {
        ab.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", str);
        aqX();
        if (this.mIu != null) {
            this.mIu.clearFocus();
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void bAM() {
        this.mIq = true;
        this.mIo.Nu(this.query);
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
        this.mIp.setText(f.a(getString(R.string.dzw), getString(R.string.dzv), com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mDR);
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
        this.mIu.a(this, menu);
        if (!this.mIw) {
            this.mIu.qQ(true);
            this.mIw = true;
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mIu.a((Activity) this, menu);
        return true;
    }

    public void U(int i, boolean z) {
        ab.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", Integer.valueOf(i), Boolean.valueOf(z));
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
