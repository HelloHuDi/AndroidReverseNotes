package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.contact.BizContactEntranceView */
public class BizContactEntranceView extends RelativeLayout {
    private View kRC = null;
    private Context mContext;
    private View zlb;
    private TextView zlc;
    TextView zld;
    private boolean zle = true;
    private boolean zlf;

    /* renamed from: com.tencent.mm.ui.contact.BizContactEntranceView$1 */
    class C362311 implements OnClickListener {
        C362311() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33539);
            Intent intent = new Intent();
            intent.putExtra("intent_service_type", 251658241);
            C25985d.m41467b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
            AppMethodBeat.m2505o(33539);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.BizContactEntranceView$2 */
    class C362322 implements OnTouchListener {
        C362322() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(33540);
            if (BizContactEntranceView.this.mContext instanceof MMActivity) {
                ((MMActivity) BizContactEntranceView.this.mContext).aqX();
            }
            AppMethodBeat.m2505o(33540);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.BizContactEntranceView$3 */
    class C362333 implements Runnable {
        C362333() {
        }

        public final void run() {
            long j = 0;
            AppMethodBeat.m2504i(33542);
            C25764e aeR = C41747z.aeR();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select updateTime from BizInfo where type = 1");
            stringBuilder.append(" and status = 1 ORDER BY updateTime DESC");
            C4990ab.m7417i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", stringBuilder.toString());
            Cursor rawQuery = aeR.rawQuery(r1, new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    j = rawQuery.getLong(0);
                    rawQuery.close();
                } else {
                    rawQuery.close();
                }
            }
            C9638aw.m17190ZK();
            final long cE = C5046bo.m7538cE(C18628c.m29072Ry().get(233473, null));
            C4990ab.m7417i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", Long.valueOf(j), Long.valueOf(cE));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(33541);
                    TextView c = BizContactEntranceView.this.zlc;
                    int i = (!BizContactEntranceView.this.zlf || j <= cE) ? 4 : 0;
                    c.setVisibility(i);
                    AppMethodBeat.m2505o(33541);
                }
            });
            AppMethodBeat.m2505o(33542);
        }
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(33543);
        this.mContext = context;
        init();
        dHC();
        AppMethodBeat.m2505o(33543);
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(33544);
        this.mContext = context;
        init();
        dHC();
        AppMethodBeat.m2505o(33544);
    }

    public BizContactEntranceView(Context context) {
        super(context);
        AppMethodBeat.m2504i(33545);
        this.mContext = context;
        init();
        dHC();
        AppMethodBeat.m2505o(33545);
    }

    private void init() {
        AppMethodBeat.m2504i(33546);
        this.zlf = false;
        View.inflate(getContext(), 2130968854, this);
        this.kRC = findViewById(2131821064);
        this.zlb = this.kRC.findViewById(2131821797);
        LayoutParams layoutParams = this.zlb.getLayoutParams();
        layoutParams.height = (int) (((float) C1338a.m2857am(getContext(), C25738R.dimen.f9768f4)) * C1338a.m2863fZ(getContext()));
        this.zlb.setLayoutParams(layoutParams);
        this.kRC.setOnClickListener(new C362311());
        this.zlb.setOnTouchListener(new C362322());
        MaskLayout maskLayout = (MaskLayout) this.zlb.findViewById(2131821798);
        ImageView imageView = (ImageView) maskLayout.getContentView();
        C17884o.acd();
        imageView.setImageBitmap(C41732d.m73527qh("service_officialaccounts"));
        this.zlc = (TextView) maskLayout.findViewById(2131821067);
        this.zld = (TextView) maskLayout.findViewById(2131821799);
        AppMethodBeat.m2505o(33546);
    }

    /* Access modifiers changed, original: final */
    public final void dHC() {
        AppMethodBeat.m2504i(33547);
        long currentTimeMillis = System.currentTimeMillis();
        C9638aw.m17190ZK();
        if (C18628c.m29078XM().dsw() > 0) {
            this.zle = true;
        } else {
            this.zle = false;
        }
        this.zlb.setVisibility(this.zle ? 0 : 8);
        if (this.zle) {
            C9638aw.m17180RS().mo10302aa(new C362333());
        }
        C4990ab.m7417i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", Integer.valueOf(r4), Boolean.valueOf(this.zle), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(33547);
    }

    public void setVisible(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(33548);
        C4990ab.m7417i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", Boolean.valueOf(z), Boolean.valueOf(this.zle));
        View view = this.kRC;
        if (!(z && this.zle)) {
            i = 8;
        }
        view.setVisibility(i);
        AppMethodBeat.m2505o(33548);
    }
}
