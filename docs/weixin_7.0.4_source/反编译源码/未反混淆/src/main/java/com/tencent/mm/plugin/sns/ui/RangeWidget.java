package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget extends RelativeLayout {
    private View contentView;
    private Activity gNy;
    private ImageView rhd;
    SnsUploadConfigView rhg;
    private TextView rke;
    private TextView rmD;
    private boolean rmE = true;
    private int rmF = 0;
    String rmG = "";
    private String rmH = "";
    private String rmI = "";
    public int style = 0;

    public RangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38540);
        init(context);
        AppMethodBeat.o(38540);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38541);
        init(context);
        AppMethodBeat.o(38541);
    }

    public void setEnablePrivate(boolean z) {
        this.rmE = z;
    }

    public int getLabelRange() {
        return this.rmF;
    }

    private void init(Context context) {
        AppMethodBeat.i(38542);
        this.gNy = (Activity) context;
        this.contentView = View.inflate(context, getLayoutResource(), this);
        this.rmD = (TextView) this.contentView.findViewById(R.id.duh);
        this.rke = (TextView) this.contentView.findViewById(R.id.bbp);
        this.rhd = (ImageView) this.contentView.findViewById(R.id.dug);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38539);
                Intent intent = new Intent(RangeWidget.this.gNy, SnsLabelUI.class);
                intent.putExtra("KLabel_range_index", RangeWidget.this.rmF);
                intent.putExtra("Klabel_name_list", RangeWidget.this.rmH);
                intent.putExtra("Kother_user_name_list", RangeWidget.this.rmI);
                intent.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
                RangeWidget.this.gNy.startActivityForResult(intent, 5);
                AppMethodBeat.o(38539);
            }
        });
        AppMethodBeat.o(38542);
    }

    private static List<String> O(List<String> list) {
        AppMethodBeat.i(38543);
        LinkedList linkedList = new LinkedList();
        g.RQ();
        if (!g.RN().QY()) {
            AppMethodBeat.o(38543);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(38543);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                g.RQ();
                ad aoO = ((j) g.K(j.class)).XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.o(38543);
            return linkedList;
        }
    }

    public boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        String c;
        AppMethodBeat.i(38544);
        this.rmF = intent.getIntExtra("Ktag_range_index", 0);
        this.rmH = intent.getStringExtra("Klabel_name_list");
        this.rmI = intent.getStringExtra("Kother_user_name_list");
        int maxTagNameLen = getMaxTagNameLen();
        CharSequence charSequence = "";
        if (!bo.isNullOrNil(this.rmH)) {
            charSequence = charSequence + this.rmH;
        }
        if (!bo.isNullOrNil(this.rmI)) {
            c = bo.c(O(Arrays.asList(this.rmI.split(","))), ",");
            if (charSequence.length() > 0) {
                charSequence = charSequence + "," + c;
            } else {
                charSequence = charSequence + c;
            }
        }
        if (!(maxTagNameLen == -1 || charSequence == null || charSequence.length() <= maxTagNameLen)) {
            charSequence = charSequence.substring(0, maxTagNameLen) + "...";
        }
        maxTagNameLen = this.rmF;
        if (this.rhd != null) {
            this.rhd.setImageDrawable(ah.f(this.gNy, R.raw.album_group_icon_pressed, getContext().getResources().getColor(R.color.a61)));
            this.rke.setTextColor(getResources().getColor(R.color.r8));
            this.rmD.setTextColor(getResources().getColor(R.color.r8));
        }
        if (this.rhg != null) {
            this.rhg.setPrivated(false);
        }
        switch (maxTagNameLen) {
            case 0:
                if (this.rhd != null) {
                    this.rhd.setImageDrawable(ah.f(this.gNy, R.raw.album_group_icon_normal, WebView.NIGHT_MODE_COLOR));
                    this.rke.setTextColor(getResources().getColor(R.color.w4));
                    this.rmD.setTextColor(getResources().getColor(R.color.s0));
                }
                this.rmD.setText(R.string.elx);
                break;
            case 1:
                if (this.rhg != null) {
                    this.rhg.setPrivated(true);
                }
                if (!(atContactWidget == null || this.rhg == null || atContactWidget.getAtList().size() <= 0)) {
                    h.g(this.gNy, R.string.epa, R.string.tz);
                    atContactWidget.crA();
                    this.rhg.cux();
                }
                this.rmD.setText(R.string.elv);
                break;
            case 2:
                this.rmD.setText(charSequence);
                break;
            case 3:
                TextView textView = this.rmD;
                c = this.gNy.getString(R.string.elj);
                String str = c + "  " + charSequence;
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(-65536), c.length() + 2, str.length(), 33);
                textView.setText(spannableString);
                break;
        }
        AppMethodBeat.o(38544);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return R.layout.amm;
    }

    /* Access modifiers changed, original: protected */
    public int getMaxTagNameLen() {
        return -1;
    }
}
