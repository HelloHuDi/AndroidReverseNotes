package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class ExdeviceRankChampionInfoView extends LinearLayout {
    private int eOf = 0;
    private String igi;
    private TextView klC;
    private ImageView lxS;
    private TextPaint oz;

    public void setAlpha(float f) {
        AppMethodBeat.i(20111);
        this.klC.setAlpha(f);
        this.lxS.setAlpha(f);
        AppMethodBeat.o(20111);
    }

    public ExdeviceRankChampionInfoView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(20112);
        View inflate = LayoutInflater.from(context).inflate(R.layout.wg, this, true);
        this.oz = new TextPaint(1);
        this.klC = (TextView) inflate.findViewById(R.id.bi8);
        this.lxS = (ImageView) inflate.findViewById(R.id.bj0);
        this.lxS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20109);
                if (bo.isNullOrNil(ExdeviceRankChampionInfoView.this.igi)) {
                    ab.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    AppMethodBeat.o(20109);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", ExdeviceRankChampionInfoView.this.igi);
                context.startActivity(intent);
                AppMethodBeat.o(20109);
            }
        });
        this.klC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20110);
                if (bo.isNullOrNil(ExdeviceRankChampionInfoView.this.igi)) {
                    ab.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    AppMethodBeat.o(20110);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", ExdeviceRankChampionInfoView.this.igi);
                context.startActivity(intent);
                AppMethodBeat.o(20110);
            }
        });
        try {
            this.eOf = context.getResources().getDimensionPixelSize(R.dimen.hb);
            if (this.eOf <= 0) {
                this.eOf = 128;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", e, "", new Object[0]);
            if (this.eOf <= 0) {
                this.eOf = 128;
            }
        } catch (Throwable th) {
            if (this.eOf <= 0) {
                this.eOf = 128;
            }
            AppMethodBeat.o(20112);
        }
        ab.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", Integer.valueOf(this.eOf));
        AppMethodBeat.o(20112);
    }

    public final void KF(String str) {
        AppMethodBeat.i(20113);
        this.igi = str;
        if (this.klC != null) {
            if (bo.isNullOrNil(str)) {
                this.klC.setVisibility(8);
                this.klC.setText("");
            } else {
                this.klC.setVisibility(0);
                Context context = getContext();
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.ellipsize(j.b(getContext(), s.mJ(this.igi)), this.oz, (float) this.eOf, TruncateAt.END);
                ab.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", j.b(getContext(), context.getString(R.string.bf_, objArr)));
                this.klC.setText(j.b(getContext(), r0, this.klC.getTextSize()));
            }
        }
        if (this.lxS != null) {
            if (bo.isNullOrNil(str)) {
                this.lxS.setVisibility(4);
            } else {
                b.r(this.lxS, str);
                this.lxS.setVisibility(0);
                AppMethodBeat.o(20113);
                return;
            }
        }
        AppMethodBeat.o(20113);
    }
}
