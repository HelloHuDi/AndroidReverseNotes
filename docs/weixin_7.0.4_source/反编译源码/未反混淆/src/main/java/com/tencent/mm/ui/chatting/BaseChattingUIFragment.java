package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.bp.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.g;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.c.h;
import com.tencent.mm.ui.chatting.c.l;
import com.tencent.mm.ui.chatting.c.w;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.g.b;
import com.tencent.mm.ui.r;
import java.util.Map.Entry;

public abstract class BaseChattingUIFragment extends MMFragment implements ae, af {
    public a cgL = new a(this, this, this);
    protected String yHf;
    protected String yHg;
    private h yHh = new h();
    l yHi = new l();
    public boolean yHj = false;
    private int yHk = 0;
    int yHl;
    int yHm;

    public abstract r dBO();

    public abstract boolean dBP();

    public abstract ListView getListView();

    public BaseChattingUIFragment() {
        dBD();
    }

    public BaseChattingUIFragment(byte b) {
        super(true);
        dBD();
    }

    private void dBD() {
        Bundle bundle = new Bundle();
        if (!bundle.containsKey(getClass().getName())) {
            bundle.putInt(getClass().getName(), BaseClientBuilder.API_PRIORITY_OTHER);
        }
        setArguments(bundle);
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.yHf = getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s";
        hR(context);
        this.cgL.a(g.class, this.yHh);
        this.cgL.a(k.class, this.yHi);
        for (com.tencent.mm.ui.chatting.c.g.a aVar : com.tencent.mm.ui.chatting.c.g.getComponents()) {
            this.cgL.a(aVar.aIl, aVar.dDK());
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LayoutParams layoutParams = onCreateView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        onCreateView.setLayoutParams(layoutParams);
        return onCreateView;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dBE();
    }

    public final void onStart() {
        super.onStart();
        ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()));
        dBF();
    }

    public final void onResume() {
        super.onResume();
        ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()));
        dBG();
    }

    public final void onPause() {
        super.onPause();
        ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()), Boolean.valueOf(dBM()));
        dBH();
    }

    public final void onStop() {
        super.onStop();
        ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()), Boolean.valueOf(dBN()));
        dBI();
    }

    public final void onDestroy() {
        super.onDestroy();
        ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()));
        dBJ();
    }

    public final void onDetach() {
        super.onDetach();
        dBL();
    }

    public final void dBE() {
        dBq();
        if (this.isCurrentActivity || this.yHj) {
            onEnterBegin();
        }
    }

    public final void dBJ() {
        d(512, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30440);
                BaseChattingUIFragment.this.onExitBegin();
                AppMethodBeat.o(30440);
            }
        });
        djt();
        onExitEnd();
    }

    /* Access modifiers changed, original: protected */
    public void hR(Context context) {
        ab.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", this.yHg, Boolean.valueOf(this.yHj));
    }

    public void dBq() {
        d(2, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30443);
                BaseChattingUIFragment.this.cgL.caA = true;
                BaseChattingUIFragment.this.yHh.dxx();
                ab.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                AppMethodBeat.o(30443);
            }
        });
    }

    private void dBK() {
        d(4, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30444);
                ab.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                AppMethodBeat.o(30444);
            }
        });
    }

    public void dBr() {
        d(8, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30445);
                ab.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                BaseChattingUIFragment.this.yHh.dxA();
                AppMethodBeat.o(30445);
            }
        });
    }

    public void dBt() {
        d(16, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30446);
                ab.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                BaseChattingUIFragment.this.yHh.dxB();
                AppMethodBeat.o(30446);
            }
        });
    }

    private void bBP() {
        d(32, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30447);
                ab.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                AppMethodBeat.o(30447);
            }
        });
    }

    private void djt() {
        d(64, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30448);
                ab.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                if (!BaseChattingUIFragment.this.Oe(16) || BaseChattingUIFragment.this.Oe(8)) {
                    BaseChattingUIFragment.this.cgL.caA = false;
                    BaseChattingUIFragment.this.yHk = 0;
                    AppMethodBeat.o(30448);
                    return;
                }
                RuntimeException runtimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[]{BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj), Boolean.valueOf(BaseChattingUIFragment.this.cgL.caA), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.Oe(2))}));
                AppMethodBeat.o(30448);
                throw runtimeException;
            }
        });
    }

    public void dBL() {
        ab.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", this.yHg, Boolean.valueOf(this.yHj));
        for (Entry entry : this.cgL.yTu.yYL.entrySet()) {
            if (entry.getValue() instanceof w) {
                ((w) entry.getValue()).dDh();
            }
        }
    }

    public void onEnterBegin() {
        d(128, new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(30449);
                ab.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                boolean z = WXHardCoderJNI.hcEnterChattingEnable;
                int i2 = WXHardCoderJNI.hcEnterChattingDelay;
                int i3 = WXHardCoderJNI.hcEnterChattingCPU;
                int i4 = WXHardCoderJNI.hcEnterChattingIO;
                if (WXHardCoderJNI.hcEnterChattingThr) {
                    i = com.tencent.mm.kernel.g.RS().doL();
                }
                baseChattingUIFragment.yHl = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
                BaseChattingUIFragment.this.cgL.caA = true;
                BaseChattingUIFragment.this.yHh.dxy();
                AppMethodBeat.o(30449);
            }
        });
    }

    public final void onEnterEnd() {
        d(256, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30450);
                BaseChattingUIFragment.this.yHh.dxz();
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, baseChattingUIFragment.yHl);
                baseChattingUIFragment.yHl = 0;
                ab.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                AppMethodBeat.o(30450);
            }
        });
    }

    public void onExitBegin() {
        d(512, new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(30441);
                ab.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                boolean z = WXHardCoderJNI.hcQuitChattingEnable;
                int i2 = WXHardCoderJNI.hcQuitChattingDelay;
                int i3 = WXHardCoderJNI.hcQuitChattingCPU;
                int i4 = WXHardCoderJNI.hcQuitChattingIO;
                if (WXHardCoderJNI.hcQuitChattingThr) {
                    i = com.tencent.mm.kernel.g.RS().doL();
                }
                baseChattingUIFragment.yHm = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
                BaseChattingUIFragment.this.yHh.dxC();
                AppMethodBeat.o(30441);
            }
        });
    }

    public void onExitEnd() {
        d(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, new Runnable() {
            public final void run() {
                AppMethodBeat.i(30442);
                ab.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
                BaseChattingUIFragment.this.yHh.dxD();
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                if (baseChattingUIFragment.yHm != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, baseChattingUIFragment.yHm);
                    baseChattingUIFragment.yHm = 0;
                }
                BaseChattingUIFragment.this.cgL.caA = false;
                AppMethodBeat.o(30442);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.BaseChattingUIFragment";
        String str2 = "onActivityResult return, requestCode:%d resultCode:%s data is null? %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.cgL.caA) {
            Fragment fragment = this.cgL.yTv.getFragment();
            if (fragment != null) {
                d.a b = b.b(fragment, i);
                if (b != null) {
                    b.onActivityResult(i, i2, intent);
                }
            }
            this.yHi.onActivityResult(i, i2, intent);
            return;
        }
        ab.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", Integer.valueOf(i));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.yHi.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.yHi.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.cgL.caA) {
            this.yHi.onConfigurationChanged(configuration);
        }
    }

    public final boolean dBM() {
        return Oe(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) && !Oe(512);
    }

    private boolean dBN() {
        return Oe(256) && !Oe(128);
    }

    /* Access modifiers changed, original: protected */
    public void ac(ad adVar) {
        this.yHg = String.format(this.yHf, new Object[]{adVar.field_username});
        this.cgL.af(adVar);
    }

    public final void addHeaderView(View view) {
        getListView().addHeaderView(view);
    }

    public int getFirstVisiblePosition() {
        return getListView().getFirstVisiblePosition();
    }

    public final int getHeaderViewsCount() {
        return getListView().getHeaderViewsCount();
    }

    public final int getLastVisiblePosition() {
        return getListView().getLastVisiblePosition();
    }

    public final View getChildAt(int i) {
        return getListView().getChildAt(i);
    }

    public boolean supportNavigationSwipeBack() {
        if (this.isCurrentActivity) {
            return false;
        }
        com.tencent.mm.kernel.g.RQ();
        if (!com.tencent.mm.compatible.f.b.bD(((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.RM().Rn()).cc)) {
            return true;
        }
        ab.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
        return false;
    }

    public com.tencent.mm.ui.chatting.l.a.a dBQ() {
        return null;
    }

    public void dBR() {
    }

    public void cch() {
    }

    public String getIdentityString() {
        ad adVar = this.cgL.sRl;
        if (adVar == null || ((int) adVar.ewQ) == 0 || bo.isNullOrNil(adVar.field_username)) {
            return "";
        }
        if (com.tencent.mm.kernel.g.RK()) {
            if (f.kq(adVar.field_username)) {
                return "_EnterpriseChat";
            }
            if (f.rc(adVar.field_username)) {
                return "_EnterpriseFatherBiz";
            }
            if (f.rb(adVar.field_username)) {
                return "_EnterpriseChildBiz";
            }
        }
        if (adVar.dsf()) {
            return "_bizContact";
        }
        if (t.kH(adVar.field_username)) {
            return "_chatroom";
        }
        if (t.mR(adVar.field_username)) {
            return "_bottle";
        }
        if (t.mS(adVar.field_username)) {
            return "_QQ";
        }
        return "";
    }

    public final boolean Oe(int i) {
        return (this.yHk & i) == 0;
    }

    private void Of(int i) {
        this.yHk |= i;
    }

    private void Og(int i) {
        this.yHk &= i ^ -1;
    }

    private void d(int i, Runnable runnable) {
        boolean isStrict = isStrict(i);
        if (Oe(i) && isStrict) {
            Of(i);
            if (2 == i) {
                Og(64);
            } else if (64 == i) {
                Og(2);
            } else if (4 == i) {
                Og(32);
            } else if (32 == i) {
                Og(4);
            } else if (8 == i) {
                Og(16);
            } else if (16 == i) {
                Og(8);
            } else if (128 == i) {
                Og(256);
            } else if (256 == i) {
                Og(128);
            } else if (512 == i) {
                Og(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } else if (WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == i) {
                Og(512);
            }
            runnable.run();
            return;
        }
        ab.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", this.yHg, Integer.valueOf(i), Boolean.valueOf(r1), Boolean.valueOf(isStrict));
    }

    private boolean isStrict(int i) {
        if (4 == i && Oe(2)) {
            return false;
        }
        if (8 == i && Oe(4)) {
            return false;
        }
        if (16 == i && Oe(8)) {
            return false;
        }
        if (32 == i && Oe(4)) {
            return false;
        }
        if (64 == i && Oe(2)) {
            return false;
        }
        if (512 == i && Oe(256)) {
            return false;
        }
        return true;
    }

    public final void dBF() {
        if (this.cgL.caA) {
            dBK();
        }
    }

    public final void dBG() {
        if (this.cgL.caA) {
            dBr();
            if (this.isCurrentActivity || this.yHj) {
                onEnterEnd();
            }
        }
    }

    public final void dBH() {
        if (this.cgL.caA || isFinishing()) {
            if (!(!Oe(8) || isFinishing() || dBM())) {
                ab.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
                dBr();
                onEnterEnd();
            }
            dBt();
        }
    }

    public final void dBI() {
        if ((this.cgL.caA || isFinishing()) && !dBN()) {
            if (Oe(16)) {
                ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", this.yHg);
                dBt();
            }
            bBP();
        }
    }
}
