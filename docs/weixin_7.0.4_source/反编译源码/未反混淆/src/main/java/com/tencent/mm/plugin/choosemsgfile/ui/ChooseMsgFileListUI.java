package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.choosemsgfile.b.c.e;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e.c;

public class ChooseMsgFileListUI extends MMActivity implements a {
    private RecyclerView aiB;
    private String edV;
    private TextView emq;
    private String kux;
    private ProgressDialog kvA;
    private String kvv;
    private e kvw;
    private a kvx = new a();
    private RelativeLayout kvy;
    private Button kvz;
    private int mCount;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChooseMsgFileListUI() {
        AppMethodBeat.i(54417);
        AppMethodBeat.o(54417);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(54418);
        f.m(this);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.cg, R.anim.ce);
        this.edV = getIntent().getStringExtra("USERNAME");
        this.kux = b.mI(this.edV);
        this.mCount = getIntent().getIntExtra("COUNT", 9);
        this.kvv = getIntent().getStringExtra("EXTENSION");
        ab.i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", Integer.valueOf(this.mCount), this.kvv);
        this.kvw = new e(this);
        initView();
        findViewById(R.id.yh).setBackgroundColor(-1);
        this.aiB.setBackgroundColor(-1);
        RecyclerView recyclerView = this.aiB;
        e eVar = this.kvw;
        if (eVar.jop == null) {
            eVar.jop = new LinearLayoutManager();
        }
        recyclerView.setLayoutManager(eVar.jop);
        this.aiB.a(new h() {
            int kvg = ah.getResources().getColor(R.color.ov);
            ColorDrawable kvh = new ColorDrawable(this.kvg);
            int mSize = ((int) ah.getResources().getDimension(R.dimen.f15do));

            {
                AppMethodBeat.i(54348);
                AppMethodBeat.o(54348);
            }

            public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
                AppMethodBeat.i(54349);
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                int childCount = recyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (childAt.getTag() != null) {
                        com.tencent.mm.plugin.choosemsgfile.b.b.a ts = e.this.kuY.ts(((Integer) childAt.getTag()).intValue() + 1);
                        if (ts == null || ts.getType() != 0) {
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            int bottom = layoutParams.bottomMargin + childAt.getBottom();
                            this.kvh.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                            this.kvh.draw(canvas);
                        }
                    }
                }
                AppMethodBeat.o(54349);
            }
        });
        this.aiB.setAdapter(this.kvw.bfB());
        this.aiB.setHasFixedSize(true);
        setMMTitle(this.kux);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(54411);
                ChooseMsgFileListUI.this.finish();
                AppMethodBeat.o(54411);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.or), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(54412);
                Intent intent = new Intent();
                intent.putExtra("ERRMSG", "cancel");
                ChooseMsgFileListUI.this.setResult(1, intent);
                ChooseMsgFileListUI.this.finish();
                ChooseMsgFileListUI.this.overridePendingTransition(R.anim.cg, R.anim.ce);
                AppMethodBeat.o(54412);
                return true;
            }
        });
        this.kvz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54414);
                if (ChooseMsgFileListUI.this.kvx.bfF()) {
                    com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(ChooseMsgFileListUI.this);
                    aVar.asL(ChooseMsgFileListUI.this.getString(R.string.apg)).re(true);
                    aVar.c(new c() {
                        public final void d(boolean z, String str) {
                            AppMethodBeat.i(54413);
                            ab.i("MicroMsg.ChooseMsgFileListUI", "bOk:%b", Boolean.valueOf(z));
                            if (z) {
                                ChooseMsgFileListUI.b(ChooseMsgFileListUI.this);
                            }
                            AppMethodBeat.o(54413);
                        }
                    }).show();
                    AppMethodBeat.o(54414);
                    return;
                }
                ChooseMsgFileListUI.b(ChooseMsgFileListUI.this);
                AppMethodBeat.o(54414);
            }
        });
        this.kvw.dx("file", this.kvv);
        f.n(this);
        this.kvx.init(this.mCount);
        AppMethodBeat.o(54418);
    }

    public final a bfn() {
        return this.kvx;
    }

    public final String getUserName() {
        return this.edV;
    }

    public final void initView() {
        AppMethodBeat.i(54419);
        this.emq = (TextView) findViewById(R.id.avk);
        this.aiB = (RecyclerView) findViewById(R.id.avl);
        this.kvy = (RelativeLayout) findViewById(R.id.avm);
        this.kvz = (Button) findViewById(R.id.avn);
        AppMethodBeat.o(54419);
    }

    public void onResume() {
        AppMethodBeat.i(54420);
        super.onResume();
        this.kvw.onResume();
        AppMethodBeat.o(54420);
    }

    public void onPause() {
        AppMethodBeat.i(54421);
        super.onPause();
        this.kvw.onPause();
        AppMethodBeat.o(54421);
    }

    public void onDestroy() {
        AppMethodBeat.i(54422);
        super.onDestroy();
        this.kvw.onDestroy();
        this.kvx.uninit();
        AppMethodBeat.o(54422);
    }

    public void finish() {
        AppMethodBeat.i(54423);
        super.finish();
        overridePendingTransition(R.anim.cg, R.anim.ce);
        AppMethodBeat.o(54423);
    }

    public final int getLayoutId() {
        return R.layout.od;
    }

    public final void fO(boolean z) {
        AppMethodBeat.i(54424);
        fE(true);
        AppMethodBeat.o(54424);
    }

    public final void p(boolean z, int i) {
        AppMethodBeat.i(54425);
        fE(false);
        ab.i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (i <= 0) {
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            this.emq.setText(getString(R.string.apk));
            AppMethodBeat.o(54425);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        this.aiB.getAdapter().aop.notifyChanged();
        AppMethodBeat.o(54425);
    }

    public final View getChildAt(int i) {
        AppMethodBeat.i(54426);
        View childAt = this.aiB.getChildAt(i);
        AppMethodBeat.o(54426);
        return childAt;
    }

    private void fE(boolean z) {
        AppMethodBeat.i(54427);
        ab.i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = p.b(this, getString(R.string.cn5), true, null);
            AppMethodBeat.o(54427);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.o(54427);
    }

    public final void bfG() {
        AppMethodBeat.i(54428);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54415);
                ChooseMsgFileListUI.this.kvz.setEnabled(ChooseMsgFileListUI.this.kvx.getSelectCount() > 0);
                AppMethodBeat.o(54415);
            }
        });
        AppMethodBeat.o(54428);
    }

    public static void b(MMActivity mMActivity, String str, int i, String str2, final com.tencent.mm.choosemsgfile.compat.a.a aVar) {
        AppMethodBeat.i(54429);
        Intent intent = new Intent(mMActivity, ChooseMsgFileListUI.class);
        intent.putExtra("USERNAME", str);
        intent.putExtra("COUNT", i);
        intent.putExtra("EXTENSION", str2);
        mMActivity.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(54416);
                ab.i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                ab.d("MicroMsg.ChooseMsgFileListUI", "data:%s", intent);
                b.a(i, i2, intent, aVar);
                AppMethodBeat.o(54416);
            }
        };
        mMActivity.startActivityForResult(intent, 291);
        AppMethodBeat.o(54429);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.ylL;
    }

    static /* synthetic */ void b(ChooseMsgFileListUI chooseMsgFileListUI) {
        AppMethodBeat.i(54430);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("FILEPATHS", chooseMsgFileListUI.kvx.bfE());
        chooseMsgFileListUI.setResult(-1, intent);
        chooseMsgFileListUI.finish();
        AppMethodBeat.o(54430);
    }
}
