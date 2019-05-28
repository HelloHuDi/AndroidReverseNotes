package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelmulti.C37942k;
import com.tencent.p177mm.p230g.p231a.C32641tl;
import com.tencent.p177mm.p230g.p231a.C42011iv;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.conversation.a.q */
public final class C46680q extends C14933b {
    private TextView gnB;
    private ImageView iqT;
    private View jAp = null;
    private boolean zwX = false;
    boolean zxl = false;
    private C4884c zxm;

    /* renamed from: com.tencent.mm.ui.conversation.a.q$1 */
    class C443591 extends C4884c<C42011iv> {
        C443591() {
            AppMethodBeat.m2504i(34732);
            this.xxI = C42011iv.class.getName().hashCode();
            AppMethodBeat.m2505o(34732);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34733);
            if (((C42011iv) c4883b).cDY.cCA) {
                C46680q.this.zxl = false;
                C46680q.this.aMN();
            } else {
                C4990ab.m7417i("MicroMsg.TryNewInitBanner", "summerinit onSceneEnd -1 show tryNewInitBanner[%s]", C46680q.this);
                C46680q.this.zxl = true;
                C46680q.this.aMN();
            }
            AppMethodBeat.m2505o(34733);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.q$2 */
    class C443602 implements OnClickListener {
        C443602() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34734);
            C4990ab.m7416i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
            C46680q.this.setVisibility(8);
            C4879a.xxA.mo10055m(new C32641tl());
            C4990ab.m7416i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
            AppMethodBeat.m2505o(34734);
        }
    }

    public C46680q(Context context) {
        super(context);
        AppMethodBeat.m2504i(34735);
        if (!(this.zwX || this.view == null)) {
            this.jAp = this.view.findViewById(2131828364);
            this.gnB = (TextView) this.view.findViewById(2131828366);
            this.iqT = (ImageView) this.view.findViewById(2131828365);
            this.zwX = true;
            this.zxm = new C443591();
            C4879a.xxA.mo10052c(this.zxm);
        }
        AppMethodBeat.m2505o(34735);
    }

    public final int getLayoutId() {
        return 2130970970;
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(34736);
        if (!this.zxl) {
            C4990ab.m7417i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", Boolean.valueOf(this.zxl));
            this.jAp.setVisibility(8);
            AppMethodBeat.m2505o(34736);
            return false;
        } else if (C37942k.ahT()) {
            boolean z;
            this.gnB.setText(C25738R.string.a5j);
            this.iqT.setVisibility(0);
            this.jAp.setOnClickListener(new C443602());
            this.jAp.setVisibility(0);
            String str = "MicroMsg.TryNewInitBanner";
            String str2 = "summerinit update set visible [%b]";
            Object[] objArr = new Object[1];
            if (this.jAp.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(34736);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
            this.zxl = false;
            this.jAp.setVisibility(8);
            AppMethodBeat.m2505o(34736);
            return false;
        }
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(34737);
        if (this.jAp != null) {
            this.jAp.setVisibility(i);
        }
        AppMethodBeat.m2505o(34737);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(34738);
        C4879a.xxA.mo10053d(this.zxm);
        AppMethodBeat.m2505o(34738);
    }
}
