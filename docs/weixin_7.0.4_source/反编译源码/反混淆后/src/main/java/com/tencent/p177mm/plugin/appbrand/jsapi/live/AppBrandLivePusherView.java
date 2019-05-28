package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t.C10731b;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t.C45687a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView */
public class AppBrandLivePusherView extends TXCloudVideoView {
    C45688t hLh;
    public int hLi = 0;
    private C19418a hLj = new C19418a();
    C2309l hLk;
    private ITXLivePushListener hLl;
    private C10450c hLm;
    private C33348b hLn;
    private Handler mHandler = new Handler(getContext().getMainLooper());

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView$c */
    public interface C10450c {
        void aDH();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView$1 */
    class C194171 implements C10731b {
        C194171() {
        }

        /* renamed from: a */
        public final void mo22009a(C45687a c45687a, C45687a c45687a2) {
            int i;
            AppMethodBeat.m2504i(96055);
            switch (C412352.hLp[c45687a2.ordinal()]) {
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
            C19418a a = AppBrandLivePusherView.this.hLj;
            a.number = 0;
            AppBrandLivePusherView.this.mHandler.removeCallbacks(a);
            AppBrandLivePusherView.this.hLj.hLq = i;
            C19418a a2 = AppBrandLivePusherView.this.hLj;
            AppBrandLivePusherView.this.mHandler.postDelayed(a2, 250);
            AppMethodBeat.m2505o(96055);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView$a */
    class C19418a implements Runnable {
        int hLq;
        int number = 0;

        C19418a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(96057);
            this.number++;
            C4990ab.m7416i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.hLq);
            int c = AppBrandLivePusherView.m71776c(AppBrandLivePusherView.this);
            if (c == this.hLq) {
                AppBrandLivePusherView.m71774a(AppBrandLivePusherView.this, c);
                AppMethodBeat.m2505o(96057);
                return;
            }
            if (this.number < 8) {
                AppBrandLivePusherView.this.mHandler.postDelayed(this, 250);
            }
            AppMethodBeat.m2505o(96057);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView$b */
    public interface C33348b {
        /* renamed from: a */
        void mo34560a(int i, String str, HashMap<String, Object> hashMap);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView$2 */
    static /* synthetic */ class C412352 {
        static final /* synthetic */ int[] hLp = new int[C45687a.values().length];

        static {
            AppMethodBeat.m2504i(96056);
            try {
                hLp[C45687a.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hLp[C45687a.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hLp[C45687a.REVERSE_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                hLp[C45687a.REVERSE_LANDSCAPE.ordinal()] = 4;
                AppMethodBeat.m2505o(96056);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(96056);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m71774a(AppBrandLivePusherView appBrandLivePusherView, int i) {
        AppMethodBeat.m2504i(96069);
        boolean oo = appBrandLivePusherView.m71777oo(i);
        AppMethodBeat.m2505o(96069);
        return oo;
    }

    /* renamed from: c */
    static /* synthetic */ int m71776c(AppBrandLivePusherView appBrandLivePusherView) {
        AppMethodBeat.m2504i(96068);
        int rotationAngle = appBrandLivePusherView.getRotationAngle();
        AppMethodBeat.m2505o(96068);
        return rotationAngle;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(96058);
        super.onConfigurationChanged(configuration);
        m71777oo(getRotationAngle());
        AppMethodBeat.m2505o(96058);
    }

    public AppBrandLivePusherView(Context context) {
        super(context);
        AppMethodBeat.m2504i(96059);
        init(context);
        AppMethodBeat.m2505o(96059);
    }

    public AppBrandLivePusherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(96060);
        init(context);
        AppMethodBeat.m2505o(96060);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(96061);
        this.hLk = new C2309l(context);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.hLh = new C45688t(getContext(), new C194171());
        this.hLh.enable();
        m71777oo(getRotationAngle());
        AppMethodBeat.m2505o(96061);
    }

    private int getRotationAngle() {
        AppMethodBeat.m2504i(96062);
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        AppMethodBeat.m2505o(96062);
        return rotation;
    }

    /* renamed from: oo */
    private boolean m71777oo(int i) {
        AppMethodBeat.m2504i(96063);
        if (i != this.hLi) {
            this.hLi = i;
            C4990ab.m7416i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(i)));
            this.hLk.mo6183op(i);
            AppMethodBeat.m2505o(96063);
            return true;
        }
        AppMethodBeat.m2505o(96063);
        return false;
    }

    /* renamed from: y */
    public final void mo65891y(Bundle bundle) {
        C33353i c33353i;
        AppMethodBeat.m2504i(96064);
        C2309l c2309l = this.hLk;
        if (bundle == null) {
            c33353i = new C33353i(-1, "invalid params");
        } else {
            C2309l.m4530l(C38333h.NAME, bundle);
            if (c2309l.mInited) {
                c2309l.mo6180c(bundle, false);
                String string = bundle.getString("pushUrl", c2309l.hMc);
                if (!(string == null || string.isEmpty() || c2309l.hMc == null || c2309l.hMc.equalsIgnoreCase(string) || !c2309l.hMa.isPushing())) {
                    C4990ab.m7416i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
                    c2309l.stopPreview();
                    c2309l.hMa.stopPusher();
                }
                c2309l.hMc = string;
                c2309l.hMk = bundle.getBoolean("autopush", c2309l.hMk);
                if (!(!c2309l.hMk || c2309l.hMc == null || c2309l.hMc.isEmpty() || c2309l.hMa.isPushing())) {
                    C4990ab.m7416i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
                    c2309l.mo6181ea(c2309l.hMp);
                    c2309l.hMa.startPusher(c2309l.hMc);
                }
                c33353i = new C33353i();
            } else {
                c33353i = new C33353i(-3, "uninited livePusher");
            }
        }
        C4990ab.m7417i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", Integer.valueOf(c33353i.errorCode), c33353i.hLF);
        AppMethodBeat.m2505o(96064);
    }

    /* renamed from: b */
    public final boolean mo65883b(String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96065);
        C4990ab.m7417i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", Integer.valueOf(r2.errorCode), this.hLk.mo6179c(str, jSONObject).hLF);
        if (this.hLk.mo6179c(str, jSONObject).errorCode == 0) {
            AppMethodBeat.m2505o(96065);
            return true;
        }
        AppMethodBeat.m2505o(96065);
        return false;
    }

    public final void onExit() {
        C33353i c33353i;
        AppMethodBeat.m2504i(96066);
        C2309l c2309l = this.hLk;
        if (c2309l.mInited) {
            c2309l.hMa.stopBGM();
            c2309l.stopPreview();
            c2309l.hMa.stopPusher();
            c2309l.hMa.setPushListener(null);
            c2309l.mInited = false;
            c33353i = new C33353i();
        } else {
            c33353i = new C33353i(-3, "uninited livePusher");
        }
        C4990ab.m7417i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", Integer.valueOf(c33353i.errorCode), c33353i.hLF);
        if (this.hLm != null) {
            this.hLm.aDH();
        }
        AppMethodBeat.m2505o(96066);
    }

    /* renamed from: a */
    public final void mo65882a(int i, String str, HashMap<String, Object> hashMap) {
        AppMethodBeat.m2504i(96067);
        C4990ab.m7421w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", Integer.valueOf(i), str);
        if (this.hLn != null) {
            this.hLn.mo34560a(i, str, hashMap);
        }
        AppMethodBeat.m2505o(96067);
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

    public void setOnExitListener(C10450c c10450c) {
        this.hLm = c10450c;
    }

    public void setOnErrorListener(C33348b c33348b) {
        this.hLn = c33348b;
    }
}
