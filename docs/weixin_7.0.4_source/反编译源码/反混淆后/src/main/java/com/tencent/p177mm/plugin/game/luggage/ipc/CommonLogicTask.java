package com.tencent.p177mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.p731d.C39197dd;
import com.tencent.p177mm.plugin.webview.model.C43914ap;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C14610c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameSettingParams;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask */
public class CommonLogicTask extends MainProcessTask {
    public static final Creator<CommonLogicTask> CREATOR = new C121521();
    public Runnable mUa;
    public Bundle mqu = new Bundle();
    public int type;

    /* renamed from: com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask$1 */
    static class C121521 implements Creator<CommonLogicTask> {
        C121521() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonLogicTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(135855);
            CommonLogicTask commonLogicTask = new CommonLogicTask(parcel);
            AppMethodBeat.m2505o(135855);
            return commonLogicTask;
        }
    }

    public final void asQ() {
        AppMethodBeat.m2504i(135856);
        if (this.mUa != null) {
            this.mUa.run();
        }
        AppMethodBeat.m2505o(135856);
    }

    public final void asP() {
        boolean z = true;
        int i = 0;
        AppMethodBeat.m2504i(135857);
        int vn;
        Bundle bundle;
        String str;
        switch (this.type) {
            case 1:
                if (this.mqu != null) {
                    z = this.mqu.getBoolean("permission_allow", false);
                    String string = this.mqu.getString("url");
                    if (!C5046bo.isNullOrNil(string)) {
                        C23257a.vax.mo52971a(C4996ah.getContext(), string, z);
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
                    AppMethodBeat.m2505o(135857);
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
                            C1720g.m3537RQ();
                            arrayList.add(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(i2, null)));
                            i++;
                        }
                        this.mqu.putStringArrayList("getConfigStgValue", arrayList);
                        break;
                    }
                    AppMethodBeat.m2505o(135857);
                    return;
                }
                break;
            case 3:
                if (this.mqu != null) {
                    WebViewJSSDKFileItem aex = C29833g.cYF().aex(this.mqu.getString("localId"));
                    if (aex != null) {
                        this.mqu.putParcelable("item", aex);
                        break;
                    }
                }
                break;
            case 4:
                vn = CommonLogicTask.m32233vn("WebViewDownLoadFileSwitch");
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
                vn = CommonLogicTask.m32233vn("EnableWebviewScanQRCode");
                bundle = this.mqu;
                str = "allow_webview_scan";
                if (vn != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 6:
                this.mqu.putBoolean("has_set_uin", C1720g.m3531RK());
                break;
            case 8:
                this.mqu.putString("file_path", C43914ap.aeC(this.mqu.getString("localId")));
                break;
            case 9:
                String string2 = this.mqu.getString("game_hv_menu_appid");
                C9367gu c9367gu = new C9367gu();
                c9367gu.cBw.f2862Cn = 3;
                c9367gu.cBw.cBy = string2;
                C4879a.xxA.mo10055m(c9367gu);
                this.mqu.putString("game_hv_menu_pbcache", c9367gu.cBx.result);
                break;
            case 10:
                C39197dd bDg = C45985a.bDg();
                if (bDg != null) {
                    GameSettingParams gameSettingParams = new GameSettingParams();
                    gameSettingParams.uDr = bDg.color;
                    gameSettingParams.uDs = bDg.mYo;
                    this.mqu.putParcelable("game_setting_params", gameSettingParams);
                    break;
                }
                break;
            case 11:
                C14610c.m22840an(this.mqu);
                break;
        }
        aCb();
        AppMethodBeat.m2505o(135857);
    }

    /* renamed from: vn */
    private static int m32233vn(String str) {
        int i = 1;
        AppMethodBeat.m2504i(135858);
        try {
            i = C5046bo.getInt(C26373g.m41964Nu().getValue(str), 1);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(135858);
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(135859);
        parcel.writeInt(this.type);
        parcel.writeBundle(this.mqu);
        AppMethodBeat.m2505o(135859);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(135860);
        this.type = parcel.readInt();
        this.mqu = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.m2505o(135860);
    }

    public CommonLogicTask() {
        AppMethodBeat.m2504i(135861);
        AppMethodBeat.m2505o(135861);
    }

    CommonLogicTask(Parcel parcel) {
        AppMethodBeat.m2504i(135862);
        mo6032g(parcel);
        AppMethodBeat.m2505o(135862);
    }

    static {
        AppMethodBeat.m2504i(135863);
        AppMethodBeat.m2505o(135863);
    }
}
