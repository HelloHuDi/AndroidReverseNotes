package com.tencent.p177mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.base.stub.d */
public class C38669d {
    protected String appId;
    protected Context context;
    protected C27497a jDq;
    protected String openId;

    /* renamed from: com.tencent.mm.plugin.base.stub.d$a */
    public interface C27497a {
        /* renamed from: ft */
        void mo11382ft(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.d$2 */
    class C386702 implements OnClickListener {
        C386702() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(18123);
            C43155a bDb = C20928a.bDb();
            if (bDb != null) {
                bDb.mo36282m(C38669d.this.openId, C1853r.m3821YC(), C38669d.this.appId);
            }
            C38669d.this.jDq.mo11382ft(false);
            AppMethodBeat.m2505o(18123);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.d$1 */
    class C386711 implements OnClickListener {
        C386711() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(18122);
            C43155a bDb = C20928a.bDb();
            if (bDb != null) {
                bDb.mo36282m(C38669d.this.openId, C1853r.m3821YC(), C38669d.this.appId);
            }
            C38669d.this.jDq.mo11382ft(true);
            AppMethodBeat.m2505o(18122);
        }
    }

    public C38669d(Context context, String str, String str2, C27497a c27497a) {
        this.context = context;
        this.appId = str;
        this.openId = str2;
        this.jDq = c27497a;
    }

    public final void aVi() {
        AppMethodBeat.m2504i(18124);
        if (this.openId == null || this.openId.length() == 0) {
            C4990ab.m7420w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.jDq.mo11382ft(true);
            AppMethodBeat.m2505o(18124);
            return;
        }
        C40439f bT = C46494g.m87739bT(this.appId, false);
        if (bT == null) {
            C4990ab.m7412e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.jDq.mo11382ft(true);
            AppMethodBeat.m2505o(18124);
        } else if (C42252ah.isNullOrNil(bT.field_openId)) {
            C4990ab.m7420w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            C4990ab.m7410d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            C14877am.bYL().mo9878wy(this.appId);
            this.jDq.mo11382ft(true);
            AppMethodBeat.m2505o(18124);
        } else if (this.openId.equalsIgnoreCase(bT.field_openId)) {
            C4990ab.m7410d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.jDq.mo11382ft(true);
            AppMethodBeat.m2505o(18124);
        } else {
            C4990ab.m7420w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + bT.field_openId);
            aVh();
            AppMethodBeat.m2505o(18124);
        }
    }

    /* Access modifiers changed, original: protected */
    public void aVh() {
        AppMethodBeat.m2504i(18125);
        C30379h.m48459b(this.context, (int) C25738R.string.daw, new C386711(), new C386702());
        AppMethodBeat.m2505o(18125);
    }
}
