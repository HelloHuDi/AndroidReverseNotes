package com.tencent.p177mm.plugin.messenger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.plugin.messenger.SwitchContactDialogCustomView */
public class SwitchContactDialogCustomView extends LinearLayout {
    /* renamed from: TF */
    private TextView f16175TF;
    private TextView opN;
    private ImageView opO;
    private TextView opP;
    private TextView opQ;

    public SwitchContactDialogCustomView(Context context) {
        this(context, null);
    }

    public SwitchContactDialogCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(136912);
        LayoutInflater.from(context).inflate(2130968645, this);
        this.f16175TF = (TextView) findViewById(2131820678);
        this.opN = (TextView) findViewById(2131821019);
        this.opO = (ImageView) findViewById(2131821094);
        this.opP = (TextView) findViewById(2131821095);
        this.opQ = (TextView) findViewById(2131821096);
        AppMethodBeat.m2505o(136912);
    }

    public void setTilte(String str) {
        AppMethodBeat.m2504i(136913);
        this.f16175TF.setText(str);
        AppMethodBeat.m2505o(136913);
    }

    public void setContent(String str) {
        AppMethodBeat.m2504i(136914);
        this.opN.setText(str);
        AppMethodBeat.m2505o(136914);
    }

    public void setDesc(String str) {
        AppMethodBeat.m2504i(136915);
        this.opP.setText(str);
        AppMethodBeat.m2505o(136915);
    }

    public void setSubDesc(String str) {
        AppMethodBeat.m2504i(136916);
        this.opQ.setText(str);
        AppMethodBeat.m2505o(136916);
    }

    public void setPhoto(String str) {
        AppMethodBeat.m2504i(136917);
        C40460b.m69434b(this.opO, str);
        AppMethodBeat.m2505o(136917);
    }

    public void setOnPhotoOnClick(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(136918);
        if (this.opO != null) {
            this.opO.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(136918);
    }
}
