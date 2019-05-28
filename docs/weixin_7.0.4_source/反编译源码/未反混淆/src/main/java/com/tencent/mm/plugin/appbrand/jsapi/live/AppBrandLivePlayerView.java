package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class AppBrandLivePlayerView extends TXCloudVideoView {
    k hLb;
    a hLc;
    private c hLd;
    int hLe;
    boolean hLf;
    private b hLg;

    public interface c {
        void i(boolean z, int i);
    }

    public interface b {
        void aDG();
    }

    public interface a {
        void aDF();

        boolean isFullScreen();

        void on(int i);
    }

    public AppBrandLivePlayerView(Context context) {
        super(context);
        AppMethodBeat.i(96048);
        init(context);
        AppMethodBeat.o(96048);
    }

    public AppBrandLivePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(96049);
        init(context);
        AppMethodBeat.o(96049);
    }

    public final boolean Bc(String str) {
        AppMethodBeat.i(96050);
        ab.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", Integer.valueOf(r2.errorCode), this.hLb.Bd(str).hLF);
        if (this.hLb.Bd(str).errorCode == 0) {
            AppMethodBeat.o(96050);
            return true;
        }
        AppMethodBeat.o(96050);
        return false;
    }

    public final void onExit() {
        i iVar;
        AppMethodBeat.i(96051);
        k kVar = this.hLb;
        if (kVar.mInited) {
            kVar.hLJ.stopPlay(true);
            kVar.hLJ.setPlayListener(null);
            kVar.mInited = false;
            iVar = new i();
        } else {
            iVar = new i(-3, "uninited livePlayer");
        }
        ab.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.hLF);
        if (this.hLg != null) {
            this.hLg.aDG();
        }
        AppMethodBeat.o(96051);
    }

    public final void om(int i) {
        i Bd;
        AppMethodBeat.i(96052);
        k kVar = this.hLb;
        ab.i("TXLivePlayerJSAdapter", "enterBackground");
        if ((i != 2 || kVar.hLX) && (i != 1 || kVar.hLW)) {
            kVar.hLO = kVar.hLJ.isPlaying();
            if (kVar.hLO) {
                if (kVar.hLf && kVar.hLK != null) {
                    kVar.hLK.onPlayEvent(6000, new Bundle());
                }
                Bd = kVar.Bd("pause");
            } else {
                Bd = new i();
            }
        } else {
            kVar.hLO = false;
            Bd = new i();
        }
        ab.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", Integer.valueOf(Bd.errorCode), Bd.hLF);
        AppMethodBeat.o(96052);
    }

    public void setNeedEvent(boolean z) {
        this.hLf = z;
    }

    public void setPlayEventListener(ITXLivePlayListener iTXLivePlayListener) {
        this.hLb.hLK = iTXLivePlayListener;
    }

    public void setFullScreenDelegate(a aVar) {
        this.hLc = aVar;
    }

    public void setOnFullScreenChangeListener(c cVar) {
        this.hLd = cVar;
    }

    /* Access modifiers changed, original: final */
    public final void dZ(boolean z) {
        AppMethodBeat.i(96053);
        if (this.hLf && this.hLd != null) {
            this.hLd.i(z, this.hLe);
        }
        AppMethodBeat.o(96053);
    }

    private void init(Context context) {
        AppMethodBeat.i(96054);
        this.hLb = new k(context);
        AppMethodBeat.o(96054);
    }

    public void setExitListener(b bVar) {
        this.hLg = bVar;
    }

    public void setSnapshotListener(ITXSnapshotListener iTXSnapshotListener) {
        this.hLb.hLL = iTXSnapshotListener;
    }
}
