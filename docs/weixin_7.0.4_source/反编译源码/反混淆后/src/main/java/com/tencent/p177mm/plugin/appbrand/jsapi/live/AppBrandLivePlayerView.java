package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView */
public class AppBrandLivePlayerView extends TXCloudVideoView {
    C38336k hLb;
    C38324a hLc;
    private C2301c hLd;
    int hLe;
    boolean hLf;
    private C33347b hLg;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView$c */
    public interface C2301c {
        /* renamed from: i */
        void mo6171i(boolean z, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView$b */
    public interface C33347b {
        void aDG();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView$a */
    public interface C38324a {
        void aDF();

        boolean isFullScreen();

        /* renamed from: on */
        void mo61006on(int i);
    }

    public AppBrandLivePlayerView(Context context) {
        super(context);
        AppMethodBeat.m2504i(96048);
        init(context);
        AppMethodBeat.m2505o(96048);
    }

    public AppBrandLivePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(96049);
        init(context);
        AppMethodBeat.m2505o(96049);
    }

    /* renamed from: Bc */
    public final boolean mo67993Bc(String str) {
        AppMethodBeat.m2504i(96050);
        C4990ab.m7417i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", Integer.valueOf(r2.errorCode), this.hLb.mo61009Bd(str).hLF);
        if (this.hLb.mo61009Bd(str).errorCode == 0) {
            AppMethodBeat.m2505o(96050);
            return true;
        }
        AppMethodBeat.m2505o(96050);
        return false;
    }

    public final void onExit() {
        C33353i c33353i;
        AppMethodBeat.m2504i(96051);
        C38336k c38336k = this.hLb;
        if (c38336k.mInited) {
            c38336k.hLJ.stopPlay(true);
            c38336k.hLJ.setPlayListener(null);
            c38336k.mInited = false;
            c33353i = new C33353i();
        } else {
            c33353i = new C33353i(-3, "uninited livePlayer");
        }
        C4990ab.m7417i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", Integer.valueOf(c33353i.errorCode), c33353i.hLF);
        if (this.hLg != null) {
            this.hLg.aDG();
        }
        AppMethodBeat.m2505o(96051);
    }

    /* renamed from: om */
    public final void mo67995om(int i) {
        C33353i Bd;
        AppMethodBeat.m2504i(96052);
        C38336k c38336k = this.hLb;
        C4990ab.m7416i("TXLivePlayerJSAdapter", "enterBackground");
        if ((i != 2 || c38336k.hLX) && (i != 1 || c38336k.hLW)) {
            c38336k.hLO = c38336k.hLJ.isPlaying();
            if (c38336k.hLO) {
                if (c38336k.hLf && c38336k.hLK != null) {
                    c38336k.hLK.onPlayEvent(6000, new Bundle());
                }
                Bd = c38336k.mo61009Bd("pause");
            } else {
                Bd = new C33353i();
            }
        } else {
            c38336k.hLO = false;
            Bd = new C33353i();
        }
        C4990ab.m7417i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", Integer.valueOf(Bd.errorCode), Bd.hLF);
        AppMethodBeat.m2505o(96052);
    }

    public void setNeedEvent(boolean z) {
        this.hLf = z;
    }

    public void setPlayEventListener(ITXLivePlayListener iTXLivePlayListener) {
        this.hLb.hLK = iTXLivePlayListener;
    }

    public void setFullScreenDelegate(C38324a c38324a) {
        this.hLc = c38324a;
    }

    public void setOnFullScreenChangeListener(C2301c c2301c) {
        this.hLd = c2301c;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dZ */
    public final void mo67994dZ(boolean z) {
        AppMethodBeat.m2504i(96053);
        if (this.hLf && this.hLd != null) {
            this.hLd.mo6171i(z, this.hLe);
        }
        AppMethodBeat.m2505o(96053);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(96054);
        this.hLb = new C38336k(context);
        AppMethodBeat.m2505o(96054);
    }

    public void setExitListener(C33347b c33347b) {
        this.hLg = c33347b;
    }

    public void setSnapshotListener(ITXSnapshotListener iTXSnapshotListener) {
        this.hLb.hLL = iTXSnapshotListener;
    }
}
