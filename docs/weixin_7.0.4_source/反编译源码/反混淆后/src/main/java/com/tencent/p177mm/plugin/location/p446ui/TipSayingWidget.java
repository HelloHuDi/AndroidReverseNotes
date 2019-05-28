package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.location.ui.TipSayingWidget */
public class TipSayingWidget extends LinearLayout {
    private Context context;
    private String ecX;
    private TextView eku;
    private ImageView nNH;
    private Chronometer nNI;
    private int nNJ = 0;

    public TipSayingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113552);
        this.context = context;
        View inflate = View.inflate(this.context, 2130970927, this);
        this.nNH = (ImageView) inflate.findViewById(2131828236);
        this.eku = (TextView) inflate.findViewById(2131828237);
        this.nNI = (Chronometer) findViewById(2131826443);
        AppMethodBeat.m2505o(113552);
    }

    public void setCurSaying(String str) {
        AppMethodBeat.m2504i(113553);
        if (C5046bo.isNullOrNil(str)) {
            setVisibility(8);
            AppMethodBeat.m2505o(113553);
            return;
        }
        setVisibility(0);
        C40460b.m69439t(this.nNH, str);
        if (C5046bo.isNullOrNil(this.ecX)) {
            this.ecX = C1853r.m3846Yz();
        }
        if (this.ecX.equals(str)) {
            this.eku.setText(this.context.getString(C25738R.string.ext, new Object[]{str}));
            this.nNI.setVisibility(0);
            AppMethodBeat.m2505o(113553);
            return;
        }
        this.eku.setText(this.context.getString(C25738R.string.ext, new Object[]{str}));
        this.nNI.setVisibility(8);
        AppMethodBeat.m2505o(113553);
    }
}
