package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p612ui.C7354r;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.chatting.p1511g.C40753b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C23757g;
import com.tencent.p177mm.p612ui.chatting.p616c.C23757g.C23758a;
import com.tencent.p177mm.p612ui.chatting.p616c.C36144h;
import com.tencent.p177mm.p612ui.chatting.p616c.C44303l;
import com.tencent.p177mm.p612ui.chatting.p616c.C5327w;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40724k;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7336g;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C17017a;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment */
public abstract class BaseChattingUIFragment extends MMFragment implements C40709ae, C44285af {
    public C46650a cgL = new C46650a(this, this, this);
    protected String yHf;
    protected String yHg;
    private C36144h yHh = new C36144h();
    C44303l yHi = new C44303l();
    public boolean yHj = false;
    private int yHk = 0;
    int yHl;
    int yHm;

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$5 */
    class C236605 implements Runnable {
        C236605() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30444);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            AppMethodBeat.m2505o(30444);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$6 */
    class C236616 implements Runnable {
        C236616() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30445);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            BaseChattingUIFragment.this.yHh.dxA();
            AppMethodBeat.m2505o(30445);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$7 */
    class C236627 implements Runnable {
        C236627() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30446);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            BaseChattingUIFragment.this.yHh.dxB();
            AppMethodBeat.m2505o(30446);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$8 */
    class C236638 implements Runnable {
        C236638() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30447);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            AppMethodBeat.m2505o(30447);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$9 */
    class C236649 implements Runnable {
        C236649() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30448);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            if (!BaseChattingUIFragment.this.mo39461Oe(16) || BaseChattingUIFragment.this.mo39461Oe(8)) {
                BaseChattingUIFragment.this.cgL.caA = false;
                BaseChattingUIFragment.this.yHk = 0;
                AppMethodBeat.m2505o(30448);
                return;
            }
            RuntimeException runtimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[]{BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj), Boolean.valueOf(BaseChattingUIFragment.this.cgL.caA), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.mo39461Oe(2))}));
            AppMethodBeat.m2505o(30448);
            throw runtimeException;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$10 */
    class C2366510 implements Runnable {
        C2366510() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(30449);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
            boolean z = WXHardCoderJNI.hcEnterChattingEnable;
            int i2 = WXHardCoderJNI.hcEnterChattingDelay;
            int i3 = WXHardCoderJNI.hcEnterChattingCPU;
            int i4 = WXHardCoderJNI.hcEnterChattingIO;
            if (WXHardCoderJNI.hcEnterChattingThr) {
                i = C1720g.m3539RS().doL();
            }
            baseChattingUIFragment.yHl = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
            BaseChattingUIFragment.this.cgL.caA = true;
            BaseChattingUIFragment.this.yHh.dxy();
            AppMethodBeat.m2505o(30449);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$11 */
    class C2366611 implements Runnable {
        C2366611() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30450);
            BaseChattingUIFragment.this.yHh.dxz();
            BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, baseChattingUIFragment.yHl);
            baseChattingUIFragment.yHl = 0;
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            AppMethodBeat.m2505o(30450);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$1 */
    class C236671 implements Runnable {
        C236671() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30440);
            BaseChattingUIFragment.this.onExitBegin();
            AppMethodBeat.m2505o(30440);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$2 */
    class C236682 implements Runnable {
        C236682() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(30441);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
            boolean z = WXHardCoderJNI.hcQuitChattingEnable;
            int i2 = WXHardCoderJNI.hcQuitChattingDelay;
            int i3 = WXHardCoderJNI.hcQuitChattingCPU;
            int i4 = WXHardCoderJNI.hcQuitChattingIO;
            if (WXHardCoderJNI.hcQuitChattingThr) {
                i = C1720g.m3539RS().doL();
            }
            baseChattingUIFragment.yHm = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
            BaseChattingUIFragment.this.yHh.dxC();
            AppMethodBeat.m2505o(30441);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$3 */
    class C236693 implements Runnable {
        C236693() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30442);
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            BaseChattingUIFragment.this.yHh.dxD();
            BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
            if (baseChattingUIFragment.yHm != 0) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, baseChattingUIFragment.yHm);
                baseChattingUIFragment.yHm = 0;
            }
            BaseChattingUIFragment.this.cgL.caA = false;
            AppMethodBeat.m2505o(30442);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.BaseChattingUIFragment$4 */
    class C236704 implements Runnable {
        C236704() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30443);
            BaseChattingUIFragment.this.cgL.caA = true;
            BaseChattingUIFragment.this.yHh.dxx();
            C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.yHg, Boolean.valueOf(BaseChattingUIFragment.this.yHj));
            AppMethodBeat.m2505o(30443);
        }
    }

    public abstract C7354r dBO();

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
        mo39485hR(context);
        this.cgL.mo74856a(C7336g.class, this.yHh);
        this.cgL.mo74856a(C40724k.class, this.yHi);
        for (C23758a c23758a : C23757g.getComponents()) {
            this.cgL.mo74856a(c23758a.aIl, c23758a.dDK());
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
        C4990ab.m7421w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()));
        dBF();
    }

    public final void onResume() {
        super.onResume();
        C4990ab.m7421w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()));
        dBG();
    }

    public final void onPause() {
        super.onPause();
        C4990ab.m7421w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()), Boolean.valueOf(dBM()));
        dBH();
    }

    public final void onStop() {
        super.onStop();
        C4990ab.m7421w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()), Boolean.valueOf(dBN()));
        dBI();
    }

    public final void onDestroy() {
        super.onDestroy();
        C4990ab.m7421w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", this.yHg, Boolean.valueOf(this.cgL.caA), Boolean.valueOf(isFinishing()));
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
        m36512d(512, new C236671());
        djt();
        onExitEnd();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: hR */
    public void mo39485hR(Context context) {
        C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", this.yHg, Boolean.valueOf(this.yHj));
    }

    public void dBq() {
        m36512d(2, new C236704());
    }

    private void dBK() {
        m36512d(4, new C236605());
    }

    public void dBr() {
        m36512d(8, new C236616());
    }

    public void dBt() {
        m36512d(16, new C236627());
    }

    private void bBP() {
        m36512d(32, new C236638());
    }

    private void djt() {
        m36512d(64, new C236649());
    }

    public void dBL() {
        C4990ab.m7417i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", this.yHg, Boolean.valueOf(this.yHj));
        for (Entry entry : this.cgL.yTu.yYL.entrySet()) {
            if (entry.getValue() instanceof C5327w) {
                ((C5327w) entry.getValue()).dDh();
            }
        }
    }

    public void onEnterBegin() {
        m36512d(128, new C2366510());
    }

    public final void onEnterEnd() {
        m36512d(256, new C2366611());
    }

    public void onExitBegin() {
        m36512d(512, new C236682());
    }

    public void onExitEnd() {
        m36512d(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, new C236693());
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
        C4990ab.m7417i(str, str2, objArr);
        if (this.cgL.caA) {
            Fragment fragment = this.cgL.yTv.getFragment();
            if (fragment != null) {
                C25987a b = C40753b.m70466b(fragment, i);
                if (b != null) {
                    b.onActivityResult(i, i2, intent);
                }
            }
            this.yHi.onActivityResult(i, i2, intent);
            return;
        }
        C4990ab.m7421w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", Integer.valueOf(i));
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
        return mo39461Oe(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) && !mo39461Oe(512);
    }

    private boolean dBN() {
        return mo39461Oe(256) && !mo39461Oe(128);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: ac */
    public void mo39462ac(C7616ad c7616ad) {
        this.yHg = String.format(this.yHf, new Object[]{c7616ad.field_username});
        this.cgL.mo74859af(c7616ad);
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
        C1720g.m3537RQ();
        if (!C37657b.m63682bD(((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc)) {
            return true;
        }
        C4990ab.m7420w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
        return false;
    }

    public C17017a dBQ() {
        return null;
    }

    public void dBR() {
    }

    public void cch() {
    }

    public String getIdentityString() {
        C7616ad c7616ad = this.cgL.sRl;
        if (c7616ad == null || ((int) c7616ad.ewQ) == 0 || C5046bo.isNullOrNil(c7616ad.field_username)) {
            return "";
        }
        if (C1720g.m3531RK()) {
            if (C17903f.m28103kq(c7616ad.field_username)) {
                return "_EnterpriseChat";
            }
            if (C17903f.m28109rc(c7616ad.field_username)) {
                return "_EnterpriseFatherBiz";
            }
            if (C17903f.m28108rb(c7616ad.field_username)) {
                return "_EnterpriseChildBiz";
            }
        }
        if (c7616ad.dsf()) {
            return "_bizContact";
        }
        if (C1855t.m3896kH(c7616ad.field_username)) {
            return "_chatroom";
        }
        if (C1855t.m3905mR(c7616ad.field_username)) {
            return "_bottle";
        }
        if (C1855t.m3906mS(c7616ad.field_username)) {
            return "_QQ";
        }
        return "";
    }

    /* renamed from: Oe */
    public final boolean mo39461Oe(int i) {
        return (this.yHk & i) == 0;
    }

    /* renamed from: Of */
    private void m36508Of(int i) {
        this.yHk |= i;
    }

    /* renamed from: Og */
    private void m36509Og(int i) {
        this.yHk &= i ^ -1;
    }

    /* renamed from: d */
    private void m36512d(int i, Runnable runnable) {
        boolean isStrict = isStrict(i);
        if (mo39461Oe(i) && isStrict) {
            m36508Of(i);
            if (2 == i) {
                m36509Og(64);
            } else if (64 == i) {
                m36509Og(2);
            } else if (4 == i) {
                m36509Og(32);
            } else if (32 == i) {
                m36509Og(4);
            } else if (8 == i) {
                m36509Og(16);
            } else if (16 == i) {
                m36509Og(8);
            } else if (128 == i) {
                m36509Og(256);
            } else if (256 == i) {
                m36509Og(128);
            } else if (512 == i) {
                m36509Og(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } else if (WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == i) {
                m36509Og(512);
            }
            runnable.run();
            return;
        }
        C4990ab.m7421w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", this.yHg, Integer.valueOf(i), Boolean.valueOf(r1), Boolean.valueOf(isStrict));
    }

    private boolean isStrict(int i) {
        if (4 == i && mo39461Oe(2)) {
            return false;
        }
        if (8 == i && mo39461Oe(4)) {
            return false;
        }
        if (16 == i && mo39461Oe(8)) {
            return false;
        }
        if (32 == i && mo39461Oe(4)) {
            return false;
        }
        if (64 == i && mo39461Oe(2)) {
            return false;
        }
        if (512 == i && mo39461Oe(256)) {
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
            if (!(!mo39461Oe(8) || isFinishing() || dBM())) {
                C4990ab.m7420w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
                dBr();
                onEnterEnd();
            }
            dBt();
        }
    }

    public final void dBI() {
        if ((this.cgL.caA || isFinishing()) && !dBN()) {
            if (mo39461Oe(16)) {
                C4990ab.m7421w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", this.yHg);
                dBt();
            }
            bBP();
        }
    }
}
