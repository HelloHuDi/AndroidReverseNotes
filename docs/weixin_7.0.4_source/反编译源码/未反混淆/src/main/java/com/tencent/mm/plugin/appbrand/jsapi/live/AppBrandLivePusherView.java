package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import org.json.JSONObject;

public class AppBrandLivePusherView extends TXCloudVideoView {
    t hLh;
    public int hLi = 0;
    private a hLj = new a();
    l hLk;
    private ITXLivePushListener hLl;
    private c hLm;
    private b hLn;
    private Handler mHandler = new Handler(getContext().getMainLooper());

    public interface c {
        void aDH();
    }

    class a implements Runnable {
        int hLq;
        int number = 0;

        a() {
        }

        public final void run() {
            AppMethodBeat.i(96057);
            this.number++;
            ab.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.hLq);
            int c = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
            if (c == this.hLq) {
                AppBrandLivePusherView.a(AppBrandLivePusherView.this, c);
                AppMethodBeat.o(96057);
                return;
            }
            if (this.number < 8) {
                AppBrandLivePusherView.this.mHandler.postDelayed(this, 250);
            }
            AppMethodBeat.o(96057);
        }
    }

    public interface b {
        void a(int i, String str, HashMap<String, Object> hashMap);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] hLp = new int[com.tencent.mm.plugin.appbrand.s.t.a.values().length];

        static {
            AppMethodBeat.i(96056);
            try {
                hLp[com.tencent.mm.plugin.appbrand.s.t.a.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hLp[com.tencent.mm.plugin.appbrand.s.t.a.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hLp[com.tencent.mm.plugin.appbrand.s.t.a.REVERSE_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                hLp[com.tencent.mm.plugin.appbrand.s.t.a.REVERSE_LANDSCAPE.ordinal()] = 4;
                AppMethodBeat.o(96056);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(96056);
            }
        }
    }

    static /* synthetic */ boolean a(AppBrandLivePusherView appBrandLivePusherView, int i) {
        AppMethodBeat.i(96069);
        boolean oo = appBrandLivePusherView.oo(i);
        AppMethodBeat.o(96069);
        return oo;
    }

    static /* synthetic */ int c(AppBrandLivePusherView appBrandLivePusherView) {
        AppMethodBeat.i(96068);
        int rotationAngle = appBrandLivePusherView.getRotationAngle();
        AppMethodBeat.o(96068);
        return rotationAngle;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(96058);
        super.onConfigurationChanged(configuration);
        oo(getRotationAngle());
        AppMethodBeat.o(96058);
    }

    public AppBrandLivePusherView(Context context) {
        super(context);
        AppMethodBeat.i(96059);
        init(context);
        AppMethodBeat.o(96059);
    }

    public AppBrandLivePusherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(96060);
        init(context);
        AppMethodBeat.o(96060);
    }

    private void init(Context context) {
        AppMethodBeat.i(96061);
        this.hLk = new l(context);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.hLh = new t(getContext(), new com.tencent.mm.plugin.appbrand.s.t.b() {
            public final void a(com.tencent.mm.plugin.appbrand.s.t.a aVar, com.tencent.mm.plugin.appbrand.s.t.a aVar2) {
                int i;
                AppMethodBeat.i(96055);
                switch (AnonymousClass2.hLp[aVar2.ordinal()]) {
                    case 1:
                        i = 1;
                        break;
                    case 2:
                        i = 0;
                        break;
                    case 3:
                        i = 2;
                        break;
                    case 4:
                        i = 3;
                        break;
                    default:
                        i = 0;
                        break;
                }
                a a = AppBrandLivePusherView.this.hLj;
                a.number = 0;
                AppBrandLivePusherView.this.mHandler.removeCallbacks(a);
                AppBrandLivePusherView.this.hLj.hLq = i;
                a a2 = AppBrandLivePusherView.this.hLj;
                AppBrandLivePusherView.this.mHandler.postDelayed(a2, 250);
                AppMethodBeat.o(96055);
            }
        });
        this.hLh.enable();
        oo(getRotationAngle());
        AppMethodBeat.o(96061);
    }

    private int getRotationAngle() {
        AppMethodBeat.i(96062);
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        AppMethodBeat.o(96062);
        return rotation;
    }

    private boolean oo(int i) {
        AppMethodBeat.i(96063);
        if (i != this.hLi) {
            this.hLi = i;
            ab.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(i)));
            this.hLk.op(i);
            AppMethodBeat.o(96063);
            return true;
        }
        AppMethodBeat.o(96063);
        return false;
    }

    public final void y(Bundle bundle) {
        i iVar;
        AppMethodBeat.i(96064);
        l lVar = this.hLk;
        if (bundle == null) {
            iVar = new i(-1, "invalid params");
        } else {
            l.l(h.NAME, bundle);
            if (lVar.mInited) {
                lVar.c(bundle, false);
                String string = bundle.getString("pushUrl", lVar.hMc);
                if (!(string == null || string.isEmpty() || lVar.hMc == null || lVar.hMc.equalsIgnoreCase(string) || !lVar.hMa.isPushing())) {
                    ab.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
                    lVar.stopPreview();
                    lVar.hMa.stopPusher();
                }
                lVar.hMc = string;
                lVar.hMk = bundle.getBoolean("autopush", lVar.hMk);
                if (!(!lVar.hMk || lVar.hMc == null || lVar.hMc.isEmpty() || lVar.hMa.isPushing())) {
                    ab.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
                    lVar.ea(lVar.hMp);
                    lVar.hMa.startPusher(lVar.hMc);
                }
                iVar = new i();
            } else {
                iVar = new i(-3, "uninited livePusher");
            }
        }
        ab.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.hLF);
        AppMethodBeat.o(96064);
    }

    public final boolean b(String str, JSONObject jSONObject) {
        AppMethodBeat.i(96065);
        ab.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", Integer.valueOf(r2.errorCode), this.hLk.c(str, jSONObject).hLF);
        if (this.hLk.c(str, jSONObject).errorCode == 0) {
            AppMethodBeat.o(96065);
            return true;
        }
        AppMethodBeat.o(96065);
        return false;
    }

    public final void onExit() {
        i iVar;
        AppMethodBeat.i(96066);
        l lVar = this.hLk;
        if (lVar.mInited) {
            lVar.hMa.stopBGM();
            lVar.stopPreview();
            lVar.hMa.stopPusher();
            lVar.hMa.setPushListener(null);
            lVar.mInited = false;
            iVar = new i();
        } else {
            iVar = new i(-3, "uninited livePusher");
        }
        ab.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.hLF);
        if (this.hLm != null) {
            this.hLm.aDH();
        }
        AppMethodBeat.o(96066);
    }

    public final void a(int i, String str, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(96067);
        ab.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", Integer.valueOf(i), str);
        if (this.hLn != null) {
            this.hLn.a(i, str, hashMap);
        }
        AppMethodBeat.o(96067);
    }

    public void setOnPushEventListener(ITXLivePushListener iTXLivePushListener) {
        this.hLl = iTXLivePushListener;
        this.hLk.hMb = this.hLl;
    }

    public void setSnapshotListener(ITXSnapshotListener iTXSnapshotListener) {
        this.hLk.hMg = iTXSnapshotListener;
    }

    public void setBGMNotifyListener(OnBGMNotify onBGMNotify) {
        this.hLk.hMh = onBGMNotify;
    }

    public void setOnExitListener(c cVar) {
        this.hLm = cVar;
    }

    public void setOnErrorListener(b bVar) {
        this.hLn = bVar;
    }
}
