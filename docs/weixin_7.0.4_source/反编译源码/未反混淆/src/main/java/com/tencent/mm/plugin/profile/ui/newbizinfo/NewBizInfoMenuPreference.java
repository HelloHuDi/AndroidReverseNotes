package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.List;

public class NewBizInfoMenuPreference extends Preference {
    private MMActivity crP;
    private ad ehM;
    private int lineHeight = 0;
    private boolean lyb = false;
    private d ppN;
    private LinearLayout pqa;
    private List<e> pqb;
    private int state = 0;

    public NewBizInfoMenuPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23873);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23873);
    }

    public NewBizInfoMenuPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23874);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23874);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23875);
        super.onBindView(view);
        this.pqa = (LinearLayout) view.findViewById(R.id.b1m);
        this.lyb = true;
        initView();
        AppMethodBeat.o(23875);
    }

    private void initView() {
        AppMethodBeat.i(23876);
        if (!this.lyb) {
            AppMethodBeat.o(23876);
        } else if (this.state == 1 || this.state == 2 || this.state != 3) {
            this.pqa.setVisibility(8);
            AppMethodBeat.o(23876);
        } else {
            this.pqa.setVisibility(0);
            bKH();
            AppMethodBeat.o(23876);
        }
    }

    private void bKH() {
        AppMethodBeat.i(23877);
        this.pqa.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pqb.size()) {
                final e eVar = (e) this.pqb.get(i2);
                View a = a(eVar);
                a.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(23870);
                        if (eVar == null) {
                            ab.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
                            AppMethodBeat.o(23870);
                            return;
                        }
                        c.cP(NewBizInfoMenuPreference.this.ehM.field_username, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
                        ab.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", Integer.valueOf(eVar.type));
                        switch (eVar.type) {
                            case 0:
                                NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, eVar);
                                AppMethodBeat.o(23870);
                                return;
                            case 2:
                                com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.a(eVar, NewBizInfoMenuPreference.this.crP, NewBizInfoMenuPreference.this.ehM.field_username);
                                b.b(NewBizInfoMenuPreference.this.ehM.field_username, eVar.id, eVar.key, b.pqI, eVar.name, b.fa(NewBizInfoMenuPreference.this.pqb.indexOf(eVar), -1), eVar.cRS);
                                AppMethodBeat.o(23870);
                                return;
                            case 5:
                                com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.b(eVar, NewBizInfoMenuPreference.this.crP, NewBizInfoMenuPreference.this.ehM.field_username);
                                b.b(NewBizInfoMenuPreference.this.ehM.field_username, eVar.id, eVar.key, b.pqI, eVar.name, b.fa(NewBizInfoMenuPreference.this.pqb.indexOf(eVar), -1), eVar.value);
                                break;
                        }
                        AppMethodBeat.o(23870);
                    }
                });
                this.pqa.addView(a);
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -1;
                layoutParams.weight = 1.0f;
                layoutParams.gravity = 16;
                a.setLayoutParams(layoutParams);
                if (i2 != this.pqb.size() - 1) {
                    ImageView imageView = new ImageView(this.crP);
                    imageView.setBackgroundColor(this.crP.getResources().getColor(R.color.t6));
                    this.pqa.addView(imageView);
                    layoutParams = (LayoutParams) imageView.getLayoutParams();
                    layoutParams.height = this.lineHeight;
                    layoutParams.width = a.fromDPToPix(this.crP, 1);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(23877);
                return;
            }
        }
    }

    private View a(e eVar) {
        AppMethodBeat.i(23878);
        View inflate = View.inflate(this.crP, R.layout.q4, null);
        TextView textView = (TextView) inflate.findViewById(R.id.b1k);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.b1l);
        this.lineHeight = (int) textView.getTextSize();
        X(imageView, (((int) textView.getTextSize()) * 3) / 4);
        switch (eVar.type) {
            case 0:
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.axi);
                break;
            case 2:
                imageView.setVisibility(8);
                break;
            case 5:
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.axh);
                break;
        }
        textView.setText(j.b(this.crP, eVar.name));
        AppMethodBeat.o(23878);
        return inflate;
    }

    private static void X(View view, int i) {
        AppMethodBeat.i(23879);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(23879);
    }

    public final void a(d dVar, ad adVar) {
        AppMethodBeat.i(23880);
        if (dVar == null) {
            AppMethodBeat.o(23880);
            return;
        }
        this.ehM = adVar;
        this.ppN = dVar;
        this.pqb = com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.cD(dVar.cbM());
        cbv();
        initView();
        AppMethodBeat.o(23880);
    }

    private void cbv() {
        AppMethodBeat.i(23881);
        if (this.ppN == null || this.ppN.isNormal()) {
            if (this.ppN == null || !this.ppN.cbR()) {
                this.state = 0;
            } else if (this.ppN != null && this.pqb != null && this.pqb.size() <= 0) {
                this.state = 2;
                AppMethodBeat.o(23881);
                return;
            } else if (!(this.ppN == null || this.pqb == null || this.ppN.cbM().size() <= 0)) {
                this.state = 3;
                AppMethodBeat.o(23881);
                return;
            }
            AppMethodBeat.o(23881);
            return;
        }
        this.state = 4;
        AppMethodBeat.o(23881);
    }
}
