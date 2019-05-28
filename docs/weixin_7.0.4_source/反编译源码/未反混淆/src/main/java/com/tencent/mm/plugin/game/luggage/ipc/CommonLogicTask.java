package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public class CommonLogicTask extends MainProcessTask {
    public static final Creator<CommonLogicTask> CREATOR = new Creator<CommonLogicTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonLogicTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(135855);
            CommonLogicTask commonLogicTask = new CommonLogicTask(parcel);
            AppMethodBeat.o(135855);
            return commonLogicTask;
        }
    };
    public Runnable mUa;
    public Bundle mqu = new Bundle();
    public int type;

    public final void asQ() {
        AppMethodBeat.i(135856);
        if (this.mUa != null) {
            this.mUa.run();
        }
        AppMethodBeat.o(135856);
    }

    public final void asP() {
        boolean z = true;
        int i = 0;
        AppMethodBeat.i(135857);
        int vn;
        Bundle bundle;
        String str;
        switch (this.type) {
            case 1:
                if (this.mqu != null) {
                    z = this.mqu.getBoolean("permission_allow", false);
                    String string = this.mqu.getString("url");
                    if (!bo.isNullOrNil(string)) {
                        a.vax.a(ah.getContext(), string, z);
                        break;
                    }
                    ab.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
                    AppMethodBeat.o(135857);
                    return;
                }
                break;
            case 2:
                if (this.mqu != null) {
                    int[] intArray = this.mqu.getIntArray("getConfigStgKey");
                    if (intArray != null && intArray.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        int length = intArray.length;
                        while (i < length) {
                            int i2 = intArray[i];
                            g.RQ();
                            arrayList.add(bo.nullAsNil((String) g.RP().Ry().get(i2, null)));
                            i++;
                        }
                        this.mqu.putStringArrayList("getConfigStgValue", arrayList);
                        break;
                    }
                    AppMethodBeat.o(135857);
                    return;
                }
                break;
            case 3:
                if (this.mqu != null) {
                    WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(this.mqu.getString("localId"));
                    if (aex != null) {
                        this.mqu.putParcelable("item", aex);
                        break;
                    }
                }
                break;
            case 4:
                vn = vn("WebViewDownLoadFileSwitch");
                if (this.mqu == null) {
                    this.mqu = new Bundle();
                }
                bundle = this.mqu;
                str = "allowDownloadFile";
                if (vn != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 5:
                vn = vn("EnableWebviewScanQRCode");
                bundle = this.mqu;
                str = "allow_webview_scan";
                if (vn != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 6:
                this.mqu.putBoolean("has_set_uin", g.RK());
                break;
            case 8:
                this.mqu.putString("file_path", ap.aeC(this.mqu.getString("localId")));
                break;
            case 9:
                String string2 = this.mqu.getString("game_hv_menu_appid");
                gu guVar = new gu();
                guVar.cBw.Cn = 3;
                guVar.cBw.cBy = string2;
                com.tencent.mm.sdk.b.a.xxA.m(guVar);
                this.mqu.putString("game_hv_menu_pbcache", guVar.cBx.result);
                break;
            case 10:
                dd bDg = com.tencent.mm.plugin.game.commlib.a.bDg();
                if (bDg != null) {
                    GameSettingParams gameSettingParams = new GameSettingParams();
                    gameSettingParams.uDr = bDg.color;
                    gameSettingParams.uDs = bDg.mYo;
                    this.mqu.putParcelable("game_setting_params", gameSettingParams);
                    break;
                }
                break;
            case 11:
                c.an(this.mqu);
                break;
        }
        aCb();
        AppMethodBeat.o(135857);
    }

    private static int vn(String str) {
        int i = 1;
        AppMethodBeat.i(135858);
        try {
            i = bo.getInt(com.tencent.mm.m.g.Nu().getValue(str), 1);
        } catch (Exception e) {
            ab.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(135858);
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(135859);
        parcel.writeInt(this.type);
        parcel.writeBundle(this.mqu);
        AppMethodBeat.o(135859);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(135860);
        this.type = parcel.readInt();
        this.mqu = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(135860);
    }

    public CommonLogicTask() {
        AppMethodBeat.i(135861);
        AppMethodBeat.o(135861);
    }

    CommonLogicTask(Parcel parcel) {
        AppMethodBeat.i(135862);
        g(parcel);
        AppMethodBeat.o(135862);
    }

    static {
        AppMethodBeat.i(135863);
        AppMethodBeat.o(135863);
    }
}
