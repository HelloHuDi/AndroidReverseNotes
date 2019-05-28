package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanMsgUI extends MMActivity implements g, h {
    private ProgressDialog ehJ;
    private View kxP;
    private PieView kxQ;
    private TextView kxR;
    private Button kxS;
    private Button kxT;
    private TextView kxU;
    private TextView kxV;
    private TextView kxW;
    private TextView kxX;
    private View kxY;
    private TextView kxZ;
    private e kyL;
    private c kyR;
    private TextView kya;
    private TextView kyb;
    private TextView kyc;
    private TextView kyd;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI, long j, long j2, long j3) {
        AppMethodBeat.i(18910);
        cleanMsgUI.i(j, j2, j3);
        AppMethodBeat.o(18910);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18897);
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.h.pYm.a(282, 3, 1, false);
        d.bfZ();
        this.kxR = (TextView) findViewById(R.id.awb);
        this.kxQ = (PieView) findViewById(R.id.awa);
        this.kxS = (Button) findViewById(R.id.aww);
        this.kxT = (Button) findViewById(R.id.awx);
        this.kxP = findViewById(R.id.awc);
        this.kxU = (TextView) findViewById(R.id.awg);
        this.kxU.setTextSize(1, 16.0f);
        this.kxV = (TextView) findViewById(R.id.awl);
        this.kxV.setTextSize(1, 16.0f);
        this.kxW = (TextView) findViewById(R.id.awp);
        this.kxW.setTextSize(1, 16.0f);
        this.kxX = (TextView) findViewById(R.id.awt);
        this.kxX.setTextSize(1, 16.0f);
        this.kxZ = (TextView) findViewById(R.id.awu);
        this.kya = (TextView) findViewById(R.id.awv);
        this.kyb = (TextView) findViewById(R.id.awf);
        this.kyc = (TextView) findViewById(R.id.awk);
        this.kyd = (TextView) findViewById(R.id.awo);
        this.kxY = findViewById(R.id.awh);
        setMMTitle((int) R.string.aqq);
        d.a(new b());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18887);
                CleanMsgUI.this.finish();
                AppMethodBeat.o(18887);
                return false;
            }
        });
        this.kxT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18889);
                com.tencent.mm.ui.base.h.d(CleanMsgUI.this, CleanMsgUI.this.getString(R.string.aqf, new Object[]{bo.my(d.bfV())}), "", CleanMsgUI.this.getString(R.string.s6), CleanMsgUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(18888);
                        CleanMsgUI.a(CleanMsgUI.this, d.bfR());
                        AppMethodBeat.o(18888);
                    }
                }, null);
                AppMethodBeat.o(18889);
            }
        });
        this.kxS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18890);
                CleanMsgUI.this.startActivityForResult(new Intent(CleanMsgUI.this, CleanChattingUI.class), 0);
                com.tencent.mm.plugin.report.service.h.pYm.a(282, 4, 1, false);
                AppMethodBeat.o(18890);
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18891);
                CleanMsgUI.a(CleanMsgUI.this);
                AppMethodBeat.o(18891);
                return false;
            }
        });
        enableOptionMenu(0, false);
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.apz), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.ehJ.dismiss();
        if (d.bfS() != null) {
            this.kxR.setVisibility(8);
            this.kxS.setEnabled(true);
            enableOptionMenu(0, true);
            d.bfW();
            i(d.bfT(), d.bfV(), d.bfU());
            AppMethodBeat.o(18897);
            return;
        }
        b bfQ = d.bfQ();
        if (bfQ != null) {
            this.kyR = new c(bfQ, this);
            com.tencent.mm.sdk.g.d.post(this.kyR, "CleanUI_clean");
            this.kxR.setText(getString(R.string.fp, new Object[]{"0%"}));
        }
        AppMethodBeat.o(18897);
    }

    public final int getLayoutId() {
        return R.layout.on;
    }

    private void h(long j, long j2, long j3) {
        int i;
        AppMethodBeat.i(18898);
        int i2 = (int) ((360 * j2) / j);
        if (i2 < 5) {
            i = 5;
        } else {
            i = i2;
        }
        i2 = 0;
        if (j3 > 0) {
            i2 = (int) ((360 * j3) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j2) - j3;
        int i3 = (int) ((360 * j4) / j);
        ab.i("MicroMsg.CleanMsgUI", "update [%d %d] [%d %d] [%d %d] wechatSize[%d]", Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Integer.valueOf(i3), Long.valueOf(j));
        this.kxQ.setGreenTargetAngle(i);
        this.kxQ.setOtherAccTargetAngle(i2);
        this.kxQ.setStage(1);
        this.kxP.setVisibility(0);
        this.kxU.setText(bo.ga(j2));
        this.kxV.setText(bo.ga(j3));
        this.kxW.setText(bo.ga(j4));
        if (j3 > 0) {
            this.kxY.setVisibility(0);
            this.kxT.setVisibility(0);
        } else {
            this.kxT.setVisibility(8);
            this.kxY.setVisibility(8);
        }
        i2 = (int) ((100 * j2) / j);
        this.kyb.setText(getString(R.string.aps, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j3) / j);
        this.kyc.setText(getString(R.string.aqe, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j4) / j);
        this.kyd.setText(getString(R.string.aqh, new Object[]{i2 + "%"}));
        AppMethodBeat.o(18898);
    }

    private void i(long j, long j2, long j3) {
        AppMethodBeat.i(18899);
        h(j, j3, j2);
        AppMethodBeat.o(18899);
    }

    public void onDestroy() {
        AppMethodBeat.i(18900);
        if (this.kyR != null) {
            Runnable runnable = this.kyR;
            ab.i("MicroMsg.CleanController", "stop CleanController [%d]", Integer.valueOf(runnable.hashCode()));
            runnable.isStop = true;
            com.tencent.mm.sdk.g.d.xDG.remove(runnable);
        }
        if (this.kyL != null) {
            this.kyL.bgb();
        }
        if (d.bfQ() != null) {
            b bfQ = d.bfQ();
            for (ak removeCallbacksAndMessages : bfQ.kwM.values()) {
                removeCallbacksAndMessages.removeCallbacksAndMessages(null);
            }
            for (ak removeCallbacksAndMessages2 : bfQ.kwM.values()) {
                removeCallbacksAndMessages2.getLooper().getThread().interrupt();
                removeCallbacksAndMessages2.getLooper().quit();
            }
            ab.i("MicroMsg.ThreadController", "finish thread controller [%d]", Integer.valueOf(bfQ.hashCode()));
        }
        d.bga();
        d.bfY();
        super.onDestroy();
        AppMethodBeat.o(18900);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(18901);
        super.onActivityResult(i, i2, intent);
        d.bfW();
        i(d.bfT(), d.bfV(), d.bfU());
        AppMethodBeat.o(18901);
    }

    public final void dO(int i, int i2) {
        AppMethodBeat.i(18902);
        this.kxR.setText(getString(R.string.fp, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.o(18902);
    }

    public final void a(long j, long j2, long j3, ArrayList<com.tencent.mm.plugin.clean.c.b> arrayList, long j4, HashSet<String> hashSet) {
        AppMethodBeat.i(18903);
        ab.i("MicroMsg.CleanMsgUI", "%d on clean result cleanDataSize[%d] wechatSize[%d] otherAccSize[%d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j4));
        this.kxR.setVisibility(8);
        this.kxS.setEnabled(true);
        enableOptionMenu(0, true);
        i(j2, j4, j3);
        if (j > 0) {
            this.kxZ.setVisibility(0);
            this.kxZ.setText(getString(R.string.aq1, new Object[]{bo.ga(j)}));
        } else {
            this.kxZ.setVisibility(8);
            this.kxZ.setText("");
        }
        d.hg(j);
        d.hd(j2);
        d.hf(j4);
        d.b(hashSet);
        d.he(j3);
        d.u(arrayList);
        if (j4 > 0) {
            com.tencent.mm.plugin.report.service.h.pYm.a(282, 9, 1, false);
            AppMethodBeat.o(18903);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(282, 10, 1, false);
        AppMethodBeat.o(18903);
    }

    public final void dP(int i, int i2) {
        AppMethodBeat.i(18904);
        this.ehJ.setMessage(getString(R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.o(18904);
    }

    public final void hi(long j) {
        AppMethodBeat.i(18905);
        this.ehJ.dismiss();
        d.hd(d.bfT() - j);
        d.hg(d.bfW() + j);
        d.bfW();
        i(d.bfT(), d.bfV(), d.bfU());
        AppMethodBeat.o(18905);
    }

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI) {
        AppMethodBeat.i(18907);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(cleanMsgUI.getString(R.string.dgs));
        arrayList2.add(Integer.valueOf(0));
        com.tencent.mm.ui.base.h.a((Context) cleanMsgUI, null, arrayList, arrayList2, null, false, new com.tencent.mm.ui.base.h.d() {
            public final void bV(int i, int i2) {
                AppMethodBeat.i(18893);
                switch (i2) {
                    case 0:
                        if (CleanMsgUI.bgm() <= 0) {
                            Toast.makeText(CleanMsgUI.this, R.string.d7r, 0).show();
                            break;
                        }
                        com.tencent.mm.ui.base.h.d(CleanMsgUI.this, CleanMsgUI.this.getString(R.string.aqn, new Object[]{bo.ga(r2)}), "", CleanMsgUI.this.getString(R.string.b53), CleanMsgUI.this.getString(R.string.abx), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(18892);
                                CleanMsgUI.this.kyL = new e(d.bfQ(), CleanMsgUI.this, CleanMsgUI.bgn());
                                CleanMsgUI.this.kyL.start();
                                CleanMsgUI.this.ehJ.show();
                                AppMethodBeat.o(18892);
                            }
                        }, null);
                        AppMethodBeat.o(18893);
                        return;
                }
                AppMethodBeat.o(18893);
            }
        });
        AppMethodBeat.o(18907);
    }

    static /* synthetic */ long bgm() {
        long j;
        AppMethodBeat.i(18908);
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        long j2 = 0;
        if (d.bfS() != null) {
            Iterator it = d.bfS().iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mm.plugin.clean.c.b bVar = (com.tencent.mm.plugin.clean.c.b) it.next();
                if (bVar.kwf != null) {
                    Iterator it2 = bVar.kwf.iterator();
                    while (it2.hasNext()) {
                        a aVar = (a) it2.next();
                        if (aVar.fXb < timeInMillis) {
                            j += aVar.size;
                        }
                    }
                }
                j2 = j;
            }
        } else {
            j = 0;
        }
        AppMethodBeat.o(18908);
        return j;
    }

    static /* synthetic */ ArrayList bgn() {
        AppMethodBeat.i(18909);
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        for (int size = d.bfS().size() - 1; size >= 0; size--) {
            com.tencent.mm.plugin.clean.c.b bVar = (com.tencent.mm.plugin.clean.c.b) d.bfS().get(size);
            for (int size2 = bVar.kwf.size() - 1; size2 >= 0; size2--) {
                if (((a) bVar.kwf.get(size2)).fXb < timeInMillis) {
                    arrayList.add(bVar.kwf.get(size2));
                    bVar.kwf.remove(size2);
                }
            }
            if (!bVar.bfI()) {
                d.bfS().remove(size);
            }
        }
        AppMethodBeat.o(18909);
        return arrayList;
    }
}
