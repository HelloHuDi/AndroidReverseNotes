package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.f;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;
import java.util.HashSet;

public class CleanMsgUI extends MMActivity {
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
    private TextView kya;
    private TextView kyb;
    private TextView kyc;
    private TextView kyd;
    private TextView kye;
    private LinearLayout kyf;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI, long j, long j2, long j3) {
        AppMethodBeat.i(18810);
        cleanMsgUI.h(j, j2, j3);
        AppMethodBeat.o(18810);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18804);
        super.onCreate(bundle);
        h.pYm.a(714, 10, 1, false);
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
        this.kye = (TextView) findViewById(R.id.awz);
        this.kyf = (LinearLayout) findViewById(R.id.awy);
        this.kyb = (TextView) findViewById(R.id.awf);
        this.kyc = (TextView) findViewById(R.id.awk);
        this.kyd = (TextView) findViewById(R.id.awo);
        this.kxY = findViewById(R.id.awh);
        setMMTitle((int) R.string.aqb);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18797);
                CleanMsgUI.this.finish();
                AppMethodBeat.o(18797);
                return false;
            }
        });
        this.kxT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18799);
                com.tencent.mm.ui.base.h.a(CleanMsgUI.this, CleanMsgUI.this.getString(R.string.aqf, new Object[]{bo.my(j.bgd().kvX)}), "", CleanMsgUI.this.getString(R.string.s6), CleanMsgUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(18798);
                        CleanMsgUI.a(CleanMsgUI.this, j.bgd().kww);
                        AppMethodBeat.o(18798);
                    }
                }, null, (int) R.color.xy);
                AppMethodBeat.o(18799);
            }
        });
        this.kxS.setEnabled(true);
        this.kxS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18800);
                CleanMsgUI.this.startActivityForResult(new Intent(CleanMsgUI.this, CleanChattingUI.class), 0);
                h.pYm.a(714, 12, 1, false);
                AppMethodBeat.o(18800);
            }
        });
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.apz), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.ehJ.dismiss();
        h(j.bgd().kvV, j.bgd().kvW, j.bgd().kvX);
        AppMethodBeat.o(18804);
    }

    public final int getLayoutId() {
        return R.layout.on;
    }

    private void h(long j, long j2, long j3) {
        int i;
        AppMethodBeat.i(18805);
        if (j <= 0) {
            j = 1;
            h.pYm.a(714, 61, 1, false);
        }
        int i2 = (int) ((360 * j2) / j);
        if (j2 <= 0 || i2 >= 5) {
            i = i2;
        } else {
            i = 5;
        }
        i2 = 0;
        if (j3 > 0) {
            i2 = (int) ((360 * j3) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j2) - j3;
        int i3 = (int) ((100 * j2) / j);
        int i4 = (int) ((100 * j3) / j);
        int i5 = (int) ((100 * j4) / j);
        ab.i("MicroMsg.CleanMsgUI", "update acc[%d %d] otherAcc[%d %d] other[%d %d] wechat[%d] stack[%s]", Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j), bo.dpG());
        this.kxQ.setGreenTargetAngle(i);
        this.kxQ.setOtherAccTargetAngle(i2);
        this.kxQ.setStage(1);
        this.kxP.setVisibility(0);
        this.kxU.setText(bo.ga(j2));
        this.kxV.setText(bo.ga(j3));
        this.kxW.setText(bo.ga(j4));
        if (j3 > 0) {
            this.kxY.setVisibility(0);
            this.kxT.setEnabled(true);
        } else {
            this.kxT.setEnabled(false);
            this.kxY.setVisibility(0);
        }
        this.kyb.setText(getString(R.string.aps));
        this.kyc.setText(getString(R.string.aqe));
        this.kyd.setText(getString(R.string.aqh));
        if (((Integer) g.RP().Ry().get(a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(0))).intValue() > 0) {
            this.kyf.setVisibility(0);
            this.kye.setVisibility(0);
            this.kye.setText(l(j.bgd().kwI));
        }
        AppMethodBeat.o(18805);
    }

    public void onDestroy() {
        AppMethodBeat.i(18806);
        super.onDestroy();
        AppMethodBeat.o(18806);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(18807);
        super.onActivityResult(i, i2, intent);
        h(j.bgd().kvV, j.bgd().kvW, j.bgd().kvX);
        AppMethodBeat.o(18807);
    }

    private static String l(HashMap<String, Long> hashMap) {
        AppMethodBeat.i(18808);
        StringBuffer stringBuffer = new StringBuffer();
        if (!hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                stringBuffer.append(str).append(" : ").append(bo.ga(((Long) hashMap.get(str)).longValue())).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        String str2 = stringBuffer.toString();
        AppMethodBeat.o(18808);
        return str2;
    }

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI, HashSet hashSet) {
        AppMethodBeat.i(18809);
        ab.i("MicroMsg.CleanMsgUI", "%d begin deleteOtherAcc", Integer.valueOf(cleanMsgUI.hashCode()));
        h.pYm.a(714, 11, 1, false);
        new f(hashSet, new com.tencent.mm.plugin.clean.c.h() {
            public final void dP(int i, int i2) {
                AppMethodBeat.i(18802);
                CleanMsgUI.this.ehJ.setMessage(CleanMsgUI.this.getString(R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
                AppMethodBeat.o(18802);
            }

            public final void hi(final long j) {
                AppMethodBeat.i(18803);
                ab.i("MicroMsg.CleanMsgUI", "onDeleteEnd %d ", Long.valueOf(j));
                al.d(new Runnable() {
                    public final void run() {
                        long j = 0;
                        AppMethodBeat.i(18801);
                        if (CleanMsgUI.this.ehJ != null) {
                            CleanMsgUI.this.ehJ.dismiss();
                        }
                        long j2 = j.bgd().kvX;
                        long j3 = j.bgd().kvX - j;
                        if (j3 < 0) {
                            j2 = j.bgd().kvV - j2;
                        } else {
                            j2 = j.bgd().kvV - j;
                            j = j3;
                        }
                        j.bgd().kvX = j;
                        j.bgd().kvV = j2;
                        CleanMsgUI.a(CleanMsgUI.this, j.bgd().kvV, j.bgd().kvW, j.bgd().kvX);
                        AppMethodBeat.o(18801);
                    }
                });
                h.pYm.a(714, 13, 1, false);
                AppMethodBeat.o(18803);
            }
        }).start();
        cleanMsgUI.ehJ.show();
        AppMethodBeat.o(18809);
    }
}
