package com.tencent.mm.plugin.choosemsgfile.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.c;

public class ChooseMsgFileUI extends MMActivity implements a {
    private String edV;
    private TextView emq;
    private String kux;
    private ProgressDialog kvA;
    private f kvH;
    private TextView kvI;
    private RecyclerView kvJ;
    private TextView kvK;
    private TextView kvL;
    private ImageButton kvM;
    private TextView kvN;
    private boolean kvO = true;
    private int kvP;
    private String kvv;
    private a kvx = new a();
    private RelativeLayout kvy;
    private Button kvz;
    private int mCount;
    private String mType;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChooseMsgFileUI() {
        AppMethodBeat.i(54457);
        AppMethodBeat.o(54457);
    }

    static /* synthetic */ void a(ChooseMsgFileUI chooseMsgFileUI, String str) {
        AppMethodBeat.i(54473);
        chooseMsgFileUI.HM(str);
        AppMethodBeat.o(54473);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(54458);
        com.tencent.mm.pluginsdk.f.m(this);
        super.onCreate(bundle);
        this.edV = getIntent().getStringExtra("USERNAME");
        this.kux = b.mI(this.edV);
        this.mType = b.HK(getIntent().getStringExtra("TYPE"));
        this.mCount = getIntent().getIntExtra("COUNT", 9);
        this.kvv = getIntent().getStringExtra("EXTENSION");
        ab.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", this.edV, this.kux, this.mType, Integer.valueOf(this.mCount));
        ab.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", this.kvv);
        this.kvx.init(this.mCount);
        this.kvH = new f(this);
        initView();
        this.kvJ.setLayoutManager(this.kvH.bfC());
        this.kvJ.a(new com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass4(this));
        this.kvJ.setAdapter(this.kvH.bfB());
        this.kvJ.setHasFixedSize(true);
        this.kvJ.a(new m() {
            private Runnable kvR = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(54441);
                    ChooseMsgFileUI.this.kvI.startAnimation(AnimationUtils.loadAnimation(ChooseMsgFileUI.this.mController.ylL, R.anim.b6));
                    ChooseMsgFileUI.this.kvI.setVisibility(8);
                    AppMethodBeat.o(54441);
                }
            };

            {
                AppMethodBeat.i(54442);
                AppMethodBeat.o(54442);
            }

            private void fQ(boolean z) {
                AppMethodBeat.i(54443);
                if (z) {
                    ChooseMsgFileUI.this.kvI.removeCallbacks(this.kvR);
                    if (ChooseMsgFileUI.this.kvI.getVisibility() != 0) {
                        ChooseMsgFileUI.this.kvI.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(ChooseMsgFileUI.this.mController.ylL, R.anim.b5);
                        ChooseMsgFileUI.this.kvI.setVisibility(0);
                        ChooseMsgFileUI.this.kvI.startAnimation(loadAnimation);
                        AppMethodBeat.o(54443);
                        return;
                    }
                }
                ChooseMsgFileUI.this.kvI.removeCallbacks(this.kvR);
                ChooseMsgFileUI.this.kvI.postDelayed(this.kvR, 256);
                AppMethodBeat.o(54443);
            }

            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(54444);
                super.a(recyclerView, i, i2);
                com.tencent.mm.plugin.choosemsgfile.b.b.a ts = ChooseMsgFileUI.this.kvH.kvi.ts(((LinearLayoutManager) ChooseMsgFileUI.this.kvH.bfC()).iQ());
                if (ts == null) {
                    AppMethodBeat.o(54444);
                    return;
                }
                ChooseMsgFileUI.this.kvI.setText(bo.bc(b.ha(ts.getTimeStamp()), ""));
                AppMethodBeat.o(54444);
            }

            public final void c(RecyclerView recyclerView, int i) {
                AppMethodBeat.i(54445);
                if (1 == i) {
                    fQ(true);
                } else if (i == 0) {
                    fQ(false);
                }
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) recyclerView.getLayoutManager()).iQ() == 0 && !ChooseMsgFileUI.this.kvO) {
                        ChooseMsgFileUI.this.kvH.b(false, ChooseMsgFileUI.this.mType, ChooseMsgFileUI.this.kvv);
                    }
                    ChooseMsgFileUI.this.kvO = false;
                    o.ahp().cm(i);
                }
                AppMethodBeat.o(54445);
            }
        });
        setMMTitle(this.kux);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(54440);
                ChooseMsgFileUI.this.finish();
                AppMethodBeat.o(54440);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.or), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(54448);
                Intent intent = new Intent();
                intent.putExtra("ERRMSG", "cancel");
                ChooseMsgFileUI.this.setResult(1, intent);
                ChooseMsgFileUI.this.finish();
                AppMethodBeat.o(54448);
                return true;
            }
        });
        this.kvM.setOnClickListener(new OnClickListener() {
            @SuppressLint({"ResourceType"})
            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(54449);
                a a = ChooseMsgFileUI.this.kvx;
                if (a.kvs) {
                    z = false;
                } else {
                    z = true;
                }
                a.kvs = z;
                if (ChooseMsgFileUI.this.kvx.kvs) {
                    ChooseMsgFileUI.this.kvM.setImageResource(R.raw.radio_on);
                    AppMethodBeat.o(54449);
                    return;
                }
                ChooseMsgFileUI.this.kvM.setImageResource(R.raw.radio_off);
                AppMethodBeat.o(54449);
            }
        });
        this.kvN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54450);
                ChooseMsgFileUI.this.kvM.performClick();
                AppMethodBeat.o(54450);
            }
        });
        this.kvK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54451);
                ChooseMsgFileUI.c(ChooseMsgFileUI.this);
                AppMethodBeat.o(54451);
            }
        });
        this.kvL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54452);
                ChooseMsgFileUI.c(ChooseMsgFileUI.this);
                AppMethodBeat.o(54452);
            }
        });
        this.kvz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54454);
                if (ChooseMsgFileUI.this.kvx.bfF()) {
                    e.a aVar = new e.a(ChooseMsgFileUI.this);
                    aVar.asL(ChooseMsgFileUI.this.getString(R.string.apg)).re(true);
                    aVar.c(new c() {
                        public final void d(boolean z, String str) {
                            AppMethodBeat.i(54453);
                            ab.i("MicroMsg.ChooseMsgFileUI", "bOk:%b", Boolean.valueOf(z));
                            if (z) {
                                ChooseMsgFileUI.d(ChooseMsgFileUI.this);
                            }
                            AppMethodBeat.o(54453);
                        }
                    }).show();
                    AppMethodBeat.o(54454);
                    return;
                }
                ChooseMsgFileUI.d(ChooseMsgFileUI.this);
                AppMethodBeat.o(54454);
            }
        });
        this.kvH.dx(this.mType, this.kvv);
        HM(this.mType);
        com.tencent.mm.pluginsdk.f.n(this);
        AppMethodBeat.o(54458);
    }

    public final a bfn() {
        return this.kvx;
    }

    public final String getUserName() {
        return this.edV;
    }

    public void onResume() {
        AppMethodBeat.i(54459);
        super.onResume();
        this.kvH.onResume();
        AppMethodBeat.o(54459);
    }

    public void onPause() {
        AppMethodBeat.i(54460);
        super.onPause();
        ab.i("MicroMsg.ChooseMsgFileUIController", "onPause");
        AppMethodBeat.o(54460);
    }

    public void onDestroy() {
        AppMethodBeat.i(54461);
        super.onDestroy();
        this.kvH.onDestroy();
        this.kvx.uninit();
        AppMethodBeat.o(54461);
    }

    public final void initView() {
        AppMethodBeat.i(54462);
        this.emq = (TextView) findViewById(R.id.avk);
        this.kvI = (TextView) findViewById(R.id.fv);
        this.kvJ = (RecyclerView) findViewById(R.id.avl);
        this.kvy = (RelativeLayout) findViewById(R.id.avm);
        this.kvK = (TextView) findViewById(R.id.avp);
        this.kvL = (TextView) findViewById(R.id.avq);
        this.kvM = (ImageButton) findViewById(R.id.avr);
        this.kvN = (TextView) findViewById(R.id.avs);
        this.kvz = (Button) findViewById(R.id.avn);
        AppMethodBeat.o(54462);
    }

    private void HM(String str) {
        AppMethodBeat.i(54463);
        if ("image".equals(str) || "all".equals(str)) {
            this.kvM.setVisibility(0);
            this.kvN.setVisibility(0);
        } else {
            this.kvM.setVisibility(4);
            this.kvN.setVisibility(4);
        }
        if ("all".equals(this.mType)) {
            this.kvK.setVisibility(0);
            this.kvL.setVisibility(0);
            HN(str);
            AppMethodBeat.o(54463);
            return;
        }
        this.kvK.setVisibility(4);
        this.kvL.setVisibility(4);
        AppMethodBeat.o(54463);
    }

    private void HN(String str) {
        AppMethodBeat.i(54464);
        if ("all".equals(str)) {
            this.kvL.setText("");
            AppMethodBeat.o(54464);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        if ("image".equals(str)) {
            stringBuilder.append(getString(R.string.apo));
        } else if ("video".equals(str)) {
            stringBuilder.append(getString(R.string.app));
        } else if ("file".equals(str)) {
            stringBuilder.append(getString(R.string.apn));
        }
        stringBuilder.append(")");
        this.kvL.setText(stringBuilder.toString());
        AppMethodBeat.o(54464);
    }

    public final void fO(boolean z) {
        AppMethodBeat.i(54465);
        if (z) {
            fP(true);
            AppMethodBeat.o(54465);
            return;
        }
        this.kvP = ((GridLayoutManager) this.kvJ.getLayoutManager()).iS();
        AppMethodBeat.o(54465);
    }

    private void fP(boolean z) {
        AppMethodBeat.i(54466);
        ab.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = p.b(this, getString(R.string.cn5), true, null);
            AppMethodBeat.o(54466);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.o(54466);
    }

    public final void p(boolean z, int i) {
        AppMethodBeat.i(54467);
        ab.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            fP(false);
            this.kvJ.getAdapter().aop.notifyChanged();
            this.kvJ.bY(this.kvJ.getAdapter().getItemCount() - 1);
            if (i <= 0) {
                this.emq.setVisibility(0);
                this.kvJ.setVisibility(8);
                this.emq.setText(getString(R.string.apk));
                AppMethodBeat.o(54467);
                return;
            }
            this.emq.setVisibility(8);
            this.kvJ.setVisibility(0);
            AppMethodBeat.o(54467);
        } else if (i > 0) {
            this.kvJ.getAdapter().at(0, i);
            this.kvJ.getAdapter().ar(i, this.kvP + i);
            AppMethodBeat.o(54467);
        } else {
            this.kvJ.getAdapter().cg(0);
            AppMethodBeat.o(54467);
        }
    }

    public final void bfG() {
        AppMethodBeat.i(54468);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54446);
                ChooseMsgFileUI.this.kvz.setEnabled(ChooseMsgFileUI.this.kvx.getSelectCount() > 0);
                AppMethodBeat.o(54446);
            }
        });
        AppMethodBeat.o(54468);
    }

    public final View getChildAt(int i) {
        AppMethodBeat.i(54469);
        View childAt = this.kvJ.getChildAt(i);
        AppMethodBeat.o(54469);
        return childAt;
    }

    public final int getLayoutId() {
        return R.layout.oe;
    }

    public static void a(MMActivity mMActivity, String str, String str2, int i, String str3, final com.tencent.mm.choosemsgfile.compat.a.a aVar) {
        AppMethodBeat.i(54470);
        Intent intent = new Intent(mMActivity, ChooseMsgFileUI.class);
        intent.putExtra("USERNAME", str);
        intent.putExtra("TYPE", str2);
        intent.putExtra("COUNT", i);
        intent.putExtra("EXTENSION", str3);
        mMActivity.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(54447);
                ab.i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                ab.d("MicroMsg.ChooseMsgFileUI", "data:%s", intent);
                b.a(i, i2, intent, aVar);
                AppMethodBeat.o(54447);
            }
        };
        mMActivity.startActivityForResult(intent, 291);
        AppMethodBeat.o(54470);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.ylL;
    }

    static /* synthetic */ void c(ChooseMsgFileUI chooseMsgFileUI) {
        AppMethodBeat.i(54471);
        d dVar = new d(chooseMsgFileUI.mController.ylL, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(54455);
                lVar.e(0, ChooseMsgFileUI.this.getString(R.string.apm));
                lVar.e(1, ChooseMsgFileUI.this.getString(R.string.apo));
                lVar.e(2, ChooseMsgFileUI.this.getString(R.string.app));
                lVar.e(3, ChooseMsgFileUI.this.getString(R.string.apn));
                AppMethodBeat.o(54455);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                String str;
                AppMethodBeat.i(54456);
                ChooseMsgFileUI.this.mType;
                switch (i) {
                    case 0:
                        str = "all";
                        break;
                    case 1:
                        str = "image";
                        break;
                    case 2:
                        str = "video";
                        break;
                    case 3:
                        str = "file";
                        break;
                    default:
                        str = "all";
                        break;
                }
                ChooseMsgFileUI.this.kvH.b(true, str, ChooseMsgFileUI.this.kvv);
                ChooseMsgFileUI.a(ChooseMsgFileUI.this, str);
                AppMethodBeat.o(54456);
            }
        };
        dVar.cpD();
        AppMethodBeat.o(54471);
    }

    static /* synthetic */ void d(ChooseMsgFileUI chooseMsgFileUI) {
        AppMethodBeat.i(54472);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("FILEPATHS", chooseMsgFileUI.kvx.bfE());
        chooseMsgFileUI.setResult(-1, intent);
        chooseMsgFileUI.finish();
        AppMethodBeat.o(54472);
    }
}
