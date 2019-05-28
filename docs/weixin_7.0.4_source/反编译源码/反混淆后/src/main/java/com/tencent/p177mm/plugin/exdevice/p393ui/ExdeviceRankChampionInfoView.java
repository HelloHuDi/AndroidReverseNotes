package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView */
public class ExdeviceRankChampionInfoView extends LinearLayout {
    private int eOf = 0;
    private String igi;
    private TextView klC;
    private ImageView lxS;
    /* renamed from: oz */
    private TextPaint f17199oz;

    public void setAlpha(float f) {
        AppMethodBeat.m2504i(20111);
        this.klC.setAlpha(f);
        this.lxS.setAlpha(f);
        AppMethodBeat.m2505o(20111);
    }

    public ExdeviceRankChampionInfoView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(20112);
        View inflate = LayoutInflater.from(context).inflate(2130969435, this, true);
        this.f17199oz = new TextPaint(1);
        this.klC = (TextView) inflate.findViewById(2131823623);
        this.lxS = (ImageView) inflate.findViewById(2131823652);
        this.lxS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(20109);
                if (C5046bo.isNullOrNil(ExdeviceRankChampionInfoView.this.igi)) {
                    C4990ab.m7420w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    AppMethodBeat.m2505o(20109);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", ExdeviceRankChampionInfoView.this.igi);
                context.startActivity(intent);
                AppMethodBeat.m2505o(20109);
            }
        });
        this.klC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(20110);
                if (C5046bo.isNullOrNil(ExdeviceRankChampionInfoView.this.igi)) {
                    C4990ab.m7420w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    AppMethodBeat.m2505o(20110);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", ExdeviceRankChampionInfoView.this.igi);
                context.startActivity(intent);
                AppMethodBeat.m2505o(20110);
            }
        });
        try {
            this.eOf = context.getResources().getDimensionPixelSize(C25738R.dimen.f9838hb);
            if (this.eOf <= 0) {
                this.eOf = 128;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", e, "", new Object[0]);
            if (this.eOf <= 0) {
                this.eOf = 128;
            }
        } catch (Throwable th) {
            if (this.eOf <= 0) {
                this.eOf = 128;
            }
            AppMethodBeat.m2505o(20112);
        }
        C4990ab.m7411d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", Integer.valueOf(this.eOf));
        AppMethodBeat.m2505o(20112);
    }

    /* renamed from: KF */
    public final void mo68561KF(String str) {
        AppMethodBeat.m2504i(20113);
        this.igi = str;
        if (this.klC != null) {
            if (C5046bo.isNullOrNil(str)) {
                this.klC.setVisibility(8);
                this.klC.setText("");
            } else {
                this.klC.setVisibility(0);
                Context context = getContext();
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.ellipsize(C44089j.m79292b(getContext(), C1854s.m3866mJ(this.igi)), this.f17199oz, (float) this.eOf, TruncateAt.END);
                C4990ab.m7411d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", C44089j.m79292b(getContext(), context.getString(C25738R.string.bf_, objArr)));
                this.klC.setText(C44089j.m79293b(getContext(), r0, this.klC.getTextSize()));
            }
        }
        if (this.lxS != null) {
            if (C5046bo.isNullOrNil(str)) {
                this.lxS.setVisibility(4);
            } else {
                C40460b.m69437r(this.lxS, str);
                this.lxS.setVisibility(0);
                AppMethodBeat.m2505o(20113);
                return;
            }
        }
        AppMethodBeat.m2505o(20113);
    }
}
