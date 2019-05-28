package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

@Deprecated
public class FreeWifiAuthStateUI extends FreeWifiStateUI {
    private boolean myf = true;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20911);
        super.onCreate(bundle);
        AppMethodBeat.o(20911);
    }

    public final void initView() {
        AppMethodBeat.i(20912);
        super.initView();
        setMMTitle((int) R.string.c0t);
        d.a(this.ssid, 4, getIntent());
        AppMethodBeat.o(20912);
    }

    /* JADX WARNING: Missing block: B:3:0x0029, code skipped:
            if (com.tencent.mm.pluginsdk.permission.b.a(r9, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null) == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        int i = false;
        AppMethodBeat.i(20913);
        super.onResume();
        if (this.myf) {
            ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
        }
        if (b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (com.tencent.mm.modelgeo.d.agA()) {
                i = 1;
            } else {
                h.a((Context) this, getString(R.string.c9z), getString(R.string.tz), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(20910);
                        com.tencent.mm.modelgeo.d.bX(FreeWifiAuthStateUI.this);
                        AppMethodBeat.o(20910);
                    }
                }, null);
            }
        }
        if (i == 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "check permission not passed!");
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
        AppMethodBeat.o(20913);
    }

    public void onDestroy() {
        AppMethodBeat.i(20914);
        super.onDestroy();
        AppMethodBeat.o(20914);
    }

    public final void a(State state) {
        AppMethodBeat.i(20915);
        ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.MD(this.ssid)) {
            bzD();
            bzF();
        }
        AppMethodBeat.o(20915);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.i(20916);
        j.bzb().a(this.ssid, new g.b() {
            public final void ci(String str, int i) {
                AppMethodBeat.i(20909);
                ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiAuthStateUI.this.jUg, d.byK());
                if (!bo.isNullOrNil(str)) {
                    String str2 = str;
                    new a(FreeWifiAuthStateUI.this.jUg, FreeWifiAuthStateUI.this.ssid, r3, FreeWifiAuthStateUI.this.mxW, str2, "", i, m.V(FreeWifiAuthStateUI.this.getIntent())).c(new f() {
                        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                            AppMethodBeat.i(20908);
                            ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            FreeWifiAuthStateUI.this.mxY = false;
                            if (i == 0 && i2 == 0) {
                                a aVar = (a) mVar;
                                ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", aVar.bze());
                                gj bzj = aVar.bzj();
                                if (bzj != null) {
                                    ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                                    FreeWifiAuthStateUI.this.csB = bzj.vEn;
                                    FreeWifiAuthStateUI.this.mwH = bzj.jCH;
                                    FreeWifiAuthStateUI.this.cBb = bzj.jBB;
                                    FreeWifiAuthStateUI.this.mzZ = bzj.vID;
                                    FreeWifiAuthStateUI.this.mAa = bzj.vIE;
                                    FreeWifiAuthStateUI.this.signature = bzj.guQ;
                                    FreeWifiAuthStateUI.this.mAb = bzj.vIF;
                                }
                                j.bzb().a(FreeWifiAuthStateUI.this.ssid, r0, FreeWifiAuthStateUI.this.getIntent());
                                AppMethodBeat.o(20908);
                            } else if (i2 == -2014) {
                                d.a(FreeWifiAuthStateUI.this.ssid, -2014, FreeWifiAuthStateUI.this.getIntent());
                                AppMethodBeat.o(20908);
                            } else {
                                d.a(FreeWifiAuthStateUI.this.ssid, 3, FreeWifiAuthStateUI.this.getIntent());
                                AppMethodBeat.o(20908);
                            }
                        }
                    });
                }
                AppMethodBeat.o(20909);
            }
        }, this.cdf, getIntent());
        AppMethodBeat.o(20916);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(20917);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(20917);
            return;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        if (iArr.length == 0) {
            AppMethodBeat.o(20917);
            return;
        }
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    this.myf = false;
                    break;
                }
                break;
        }
        AppMethodBeat.o(20917);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzy() {
        AppMethodBeat.i(20918);
        bzC();
        d.ME(this.ssid);
        AppMethodBeat.o(20918);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.i(20919);
        j.byV();
        int MC = d.MC(this.ssid);
        AppMethodBeat.o(20919);
        return MC;
    }
}
