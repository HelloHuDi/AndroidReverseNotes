package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.RangeWidget */
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

    /* renamed from: com.tencent.mm.plugin.sns.ui.RangeWidget$1 */
    class C134941 implements OnClickListener {
        C134941() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38539);
            Intent intent = new Intent(RangeWidget.this.gNy, SnsLabelUI.class);
            intent.putExtra("KLabel_range_index", RangeWidget.this.rmF);
            intent.putExtra("Klabel_name_list", RangeWidget.this.rmH);
            intent.putExtra("Kother_user_name_list", RangeWidget.this.rmI);
            intent.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
            RangeWidget.this.gNy.startActivityForResult(intent, 5);
            AppMethodBeat.m2505o(38539);
        }
    }

    public RangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38540);
        init(context);
        AppMethodBeat.m2505o(38540);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38541);
        init(context);
        AppMethodBeat.m2505o(38541);
    }

    public void setEnablePrivate(boolean z) {
        this.rmE = z;
    }

    public int getLabelRange() {
        return this.rmF;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(38542);
        this.gNy = (Activity) context;
        this.contentView = View.inflate(context, getLayoutResource(), this);
        this.rmD = (TextView) this.contentView.findViewById(2131826814);
        this.rke = (TextView) this.contentView.findViewById(2131823382);
        this.rhd = (ImageView) this.contentView.findViewById(2131826813);
        this.contentView.setOnClickListener(new C134941());
        AppMethodBeat.m2505o(38542);
    }

    /* renamed from: O */
    private static List<String> m68125O(List<String> list) {
        AppMethodBeat.m2504i(38543);
        LinkedList linkedList = new LinkedList();
        C1720g.m3537RQ();
        if (!C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(38543);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.m2505o(38543);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                C1720g.m3537RQ();
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.mo16707Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.m2505o(38543);
            return linkedList;
        }
    }

    /* renamed from: a */
    public boolean mo62963a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        String c;
        AppMethodBeat.m2504i(38544);
        this.rmF = intent.getIntExtra("Ktag_range_index", 0);
        this.rmH = intent.getStringExtra("Klabel_name_list");
        this.rmI = intent.getStringExtra("Kother_user_name_list");
        int maxTagNameLen = getMaxTagNameLen();
        CharSequence charSequence = "";
        if (!C5046bo.isNullOrNil(this.rmH)) {
            charSequence = charSequence + this.rmH;
        }
        if (!C5046bo.isNullOrNil(this.rmI)) {
            c = C5046bo.m7536c(RangeWidget.m68125O(Arrays.asList(this.rmI.split(","))), ",");
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
            this.rhd.setImageDrawable(C5225ah.m7962f(this.gNy, C1318a.album_group_icon_pressed, getContext().getResources().getColor(C25738R.color.a61)));
            this.rke.setTextColor(getResources().getColor(C25738R.color.f12069r8));
            this.rmD.setTextColor(getResources().getColor(C25738R.color.f12069r8));
        }
        if (this.rhg != null) {
            this.rhg.setPrivated(false);
        }
        switch (maxTagNameLen) {
            case 0:
                if (this.rhd != null) {
                    this.rhd.setImageDrawable(C5225ah.m7962f(this.gNy, C1318a.album_group_icon_normal, WebView.NIGHT_MODE_COLOR));
                    this.rke.setTextColor(getResources().getColor(C25738R.color.f12212w4));
                    this.rmD.setTextColor(getResources().getColor(C25738R.color.f12092s0));
                }
                this.rmD.setText(C25738R.string.elx);
                break;
            case 1:
                if (this.rhg != null) {
                    this.rhg.setPrivated(true);
                }
                if (!(atContactWidget == null || this.rhg == null || atContactWidget.getAtList().size() <= 0)) {
                    C30379h.m48467g(this.gNy, C25738R.string.epa, C25738R.string.f9238tz);
                    atContactWidget.crA();
                    this.rhg.cux();
                }
                this.rmD.setText(C25738R.string.elv);
                break;
            case 2:
                this.rmD.setText(charSequence);
                break;
            case 3:
                TextView textView = this.rmD;
                c = this.gNy.getString(C25738R.string.elj);
                String str = c + "  " + charSequence;
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(-65536), c.length() + 2, str.length(), 33);
                textView.setText(spannableString);
                break;
        }
        AppMethodBeat.m2505o(38544);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return 2130970443;
    }

    /* Access modifiers changed, original: protected */
    public int getMaxTagNameLen() {
        return -1;
    }
}
