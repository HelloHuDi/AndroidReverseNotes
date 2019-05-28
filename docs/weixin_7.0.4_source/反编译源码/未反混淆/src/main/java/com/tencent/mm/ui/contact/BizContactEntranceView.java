package com.tencent.mm.ui.contact;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.bz.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView extends RelativeLayout {
    private View kRC = null;
    private Context mContext;
    private View zlb;
    private TextView zlc;
    TextView zld;
    private boolean zle = true;
    private boolean zlf;

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(33543);
        this.mContext = context;
        init();
        dHC();
        AppMethodBeat.o(33543);
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33544);
        this.mContext = context;
        init();
        dHC();
        AppMethodBeat.o(33544);
    }

    public BizContactEntranceView(Context context) {
        super(context);
        AppMethodBeat.i(33545);
        this.mContext = context;
        init();
        dHC();
        AppMethodBeat.o(33545);
    }

    private void init() {
        AppMethodBeat.i(33546);
        this.zlf = false;
        View.inflate(getContext(), R.layout.gt, this);
        this.kRC = findViewById(R.id.nc);
        this.zlb = this.kRC.findViewById(R.id.a6u);
        LayoutParams layoutParams = this.zlb.getLayoutParams();
        layoutParams.height = (int) (((float) a.am(getContext(), R.dimen.f4)) * a.fZ(getContext()));
        this.zlb.setLayoutParams(layoutParams);
        this.kRC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33539);
                Intent intent = new Intent();
                intent.putExtra("intent_service_type", 251658241);
                d.b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
                AppMethodBeat.o(33539);
            }
        });
        this.zlb.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(33540);
                if (BizContactEntranceView.this.mContext instanceof MMActivity) {
                    ((MMActivity) BizContactEntranceView.this.mContext).aqX();
                }
                AppMethodBeat.o(33540);
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) this.zlb.findViewById(R.id.a6v);
        ImageView imageView = (ImageView) maskLayout.getContentView();
        o.acd();
        imageView.setImageBitmap(com.tencent.mm.ah.d.qh("service_officialaccounts"));
        this.zlc = (TextView) maskLayout.findViewById(R.id.nf);
        this.zld = (TextView) maskLayout.findViewById(R.id.a6w);
        AppMethodBeat.o(33546);
    }

    /* Access modifiers changed, original: final */
    public final void dHC() {
        AppMethodBeat.i(33547);
        long currentTimeMillis = System.currentTimeMillis();
        aw.ZK();
        if (c.XM().dsw() > 0) {
            this.zle = true;
        } else {
            this.zle = false;
        }
        this.zlb.setVisibility(this.zle ? 0 : 8);
        if (this.zle) {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    long j = 0;
                    AppMethodBeat.i(33542);
                    e aeR = z.aeR();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select updateTime from BizInfo where type = 1");
                    stringBuilder.append(" and status = 1 ORDER BY updateTime DESC");
                    ab.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", stringBuilder.toString());
                    Cursor rawQuery = aeR.rawQuery(r1, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            j = rawQuery.getLong(0);
                            rawQuery.close();
                        } else {
                            rawQuery.close();
                        }
                    }
                    aw.ZK();
                    final long cE = bo.cE(c.Ry().get(233473, null));
                    ab.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", Long.valueOf(j), Long.valueOf(cE));
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(33541);
                            TextView c = BizContactEntranceView.this.zlc;
                            int i = (!BizContactEntranceView.this.zlf || j <= cE) ? 4 : 0;
                            c.setVisibility(i);
                            AppMethodBeat.o(33541);
                        }
                    });
                    AppMethodBeat.o(33542);
                }
            });
        }
        ab.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", Integer.valueOf(r4), Boolean.valueOf(this.zle), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(33547);
    }

    public void setVisible(boolean z) {
        int i = 0;
        AppMethodBeat.i(33548);
        ab.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", Boolean.valueOf(z), Boolean.valueOf(this.zle));
        View view = this.kRC;
        if (!(z && this.zle)) {
            i = 8;
        }
        view.setVisibility(i);
        AppMethodBeat.o(33548);
    }
}
