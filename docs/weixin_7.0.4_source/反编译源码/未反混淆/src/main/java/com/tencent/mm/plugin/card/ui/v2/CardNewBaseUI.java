package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b&\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0014J\u001a\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001d2\b\b\u0002\u0010'\u001a\u00020\nH&J-\u0010(\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-H\u0016¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u001bJ\u0006\u00100\u001a\u00020\u001bJ\u0006\u00101\u001a\u00020\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationPermissionGrant", "", "getLocationPermissionGrant", "()Z", "setLocationPermissionGrant", "(Z)V", "longitude", "getLongitude", "setLongitude", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getOnLocationGet", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "setOnLocationGet", "(Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;)V", "overtimeTask", "Ljava/lang/Runnable;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestLocation", "showGpsAlert", "stopLocation", "Companion", "plugin-card_release"})
public abstract class CardNewBaseUI extends MMActivity {
    public static final a kpU = new a();
    float cEB = -85.0f;
    float cGm = -1000.0f;
    boolean kpR;
    private com.tencent.mm.modelgeo.b.a kpS = new b(this);
    private final Runnable kpT = new d(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI$Companion;", "", "()V", "DEFAULT_REQ_NUM", "", "DEFAULT_REQ_NUM_DISTANCE", "REQ_GPS_PERMISSION", "REQ_OPEN_GPS", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\n¢\u0006\u0002\b\f"}, dWq = {"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
    static final class b implements com.tencent.mm.modelgeo.b.a {
        final /* synthetic */ CardNewBaseUI kpV;

        b(CardNewBaseUI cardNewBaseUI) {
            this.kpV = cardNewBaseUI;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(89284);
            if (z) {
                this.kpV.cEB = f2;
                this.kpV.cGm = f;
                this.kpV.bep();
            }
            this.kpV.P(0, z);
            AppMethodBeat.o(89284);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ CardNewBaseUI kpV;

        c(CardNewBaseUI cardNewBaseUI) {
            this.kpV = cardNewBaseUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(89285);
            this.kpV.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
            AppMethodBeat.o(89285);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ CardNewBaseUI kpV;

        d(CardNewBaseUI cardNewBaseUI) {
            this.kpV = cardNewBaseUI;
        }

        public final void run() {
            AppMethodBeat.i(89286);
            ab.i("MicroMsg.CardNewBaseUI", "remove location in task");
            this.kpV.P(-2, false);
            AppMethodBeat.o(89286);
        }
    }

    public abstract void P(int i, boolean z);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kpR = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
        if (this.kpR) {
            beo();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        al.af(this.kpT);
        bep();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        j.p(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        j.p(iArr, "grantResults");
        if (i == 69) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                this.kpR = true;
                beo();
                return;
            }
            this.kpR = false;
            h.a((Context) this, getString(R.string.g6b), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.atb), false, (OnClickListener) new c(this), null);
            P(-2, false);
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ab.i("MicroMsg.CardNewBaseUI", "requestCode: %s, resultCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 563:
                beo();
                return;
            case 564:
                this.kpR = com.tencent.mm.pluginsdk.permission.b.j(dxU(), "android.permission.ACCESS_COARSE_LOCATION", false);
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    private void beo() {
        ab.i("MicroMsg.CardNewBaseUI", "request location: %s", Boolean.valueOf(this.kpR));
        if (this.kpR) {
            com.tencent.mm.modelgeo.d.agz().a(this.kpS, false);
            al.n(this.kpT, 4000);
        }
    }

    public final void bep() {
        ab.i("MicroMsg.CardNewBaseUI", "stop location");
        com.tencent.mm.modelgeo.d.agz().c(this.kpS);
    }
}
