package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.b;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.d.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract class FTSBaseUI extends MMActivity implements a, e, FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.widget.a.a {
    private ak mHE = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(61781);
            if (message.what == 1 && !bo.isNullOrNil(FTSBaseUI.this.query)) {
                FTSBaseUI.this.bAM();
            }
            AppMethodBeat.o(61781);
        }
    };
    ListView mIn;
    private d mIo;
    private TextView mIp;
    private boolean mIq = false;
    com.tencent.mm.plugin.fts.ui.widget.a mIr;
    private String mIs = null;
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
        xE(b.i(this.mController.ylL, R.color.vy));
        bAQ();
        bAP();
    }

    /* Access modifiers changed, original: protected */
    public void bAQ() {
    }

    /* Access modifiers changed, original: protected */
    public void bAP() {
        this.mIr = new com.tencent.mm.plugin.fts.ui.widget.a(this);
        this.mIr.setSearchViewListener(this);
        this.mIr.getFtsEditText().setHint(getHint());
        this.mIr.getFtsEditText().setFtsEditTextListener(this);
        this.mIr.getFtsEditText().setCanDeleteTag(false);
        getSupportActionBar().setCustomView(this.mIr);
        this.mIn = (ListView) findViewById(R.id.bxr);
        this.mIo = a((e) this);
        this.mIo.mIm = this;
        this.mIn.setAdapter(this.mIo);
        this.mIn.setOnScrollListener(this.mIo);
        this.mIn.setOnItemClickListener(this.mIo);
        this.mIn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(61779);
                FTSBaseUI.this.mIr.getFtsEditText().mLL.clearFocus();
                FTSBaseUI.this.aqX();
                AppMethodBeat.o(61779);
                return false;
            }
        });
        this.mIp = (TextView) findViewById(R.id.j0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(61780);
                FTSBaseUI.this.finish();
                AppMethodBeat.o(61780);
                return true;
            }
        });
    }

    public String getHint() {
        if (this.mIs != null) {
            return this.mIs;
        }
        return getString(R.string.te);
    }

    public final void setHint(String str) {
        this.mIs = str;
        this.mIr.getFtsEditText().setHint(getHint());
    }

    public void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
    }

    public void onClickBackBtn(View view) {
        finish();
    }

    public void onClickCancelBtn(View view) {
    }

    public final void bAR() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void l(String str, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list) {
        this.query = str;
        this.mIr.getFtsEditText().n(str, list);
    }

    public void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.UserInput) {
            String Nc = d.Nc(str);
            if (bo.isNullOrNil(this.query) || !this.query.equals(Nc)) {
                Nv(Nc);
                return;
            }
            ab.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", this.query, Nc);
        }
    }

    /* Access modifiers changed, original: protected */
    public void Nv(String str) {
        if (bo.isNullOrNil(str)) {
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

    public final void hz(boolean z) {
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
        this.mIo.Nu(this.query);
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
        this.mIp.setText(f.a(getString(R.string.dzw), getString(R.string.dzv), com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mDR);
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

    public final void U(int i, boolean z) {
        ab.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", Integer.valueOf(i), Boolean.valueOf(z));
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
