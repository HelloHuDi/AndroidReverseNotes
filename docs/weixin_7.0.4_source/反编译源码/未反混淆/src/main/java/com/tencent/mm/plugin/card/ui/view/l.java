package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.wz;
import java.util.LinkedList;

public final class l extends i {
    View kqM;
    LinearLayout kqN;
    boolean kqO = false;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.i(88755);
        if (this.kqM == null) {
            this.kqM = ((ViewStub) findViewById(R.id.ac6)).inflate();
        }
        final wz wzVar = this.kqK.bcv().aZW().vSl;
        ((TextView) this.kqM.findViewById(R.id.abn)).setText(wzVar.title);
        if (wzVar.wcV != null && wzVar.wcV.size() > 0) {
            this.kqN = (LinearLayout) this.kqM.findViewById(R.id.abo);
            this.kqN.removeAllViews();
            final LinkedList linkedList = wzVar.wcV;
            final LayoutInflater layoutInflater = (LayoutInflater) this.kqK.bcy().getSystemService("layout_inflater");
            int i;
            TextView textView;
            if (wzVar.wcU >= linkedList.size() || this.kqO) {
                this.kqM.findViewById(R.id.abp).setVisibility(8);
                for (i = 0; i < linkedList.size(); i++) {
                    textView = (TextView) layoutInflater.inflate(R.layout.kh, null, false);
                    textView.setText(((tm) linkedList.get(i)).title);
                    this.kqN.addView(textView);
                }
                this.kqN.invalidate();
                AppMethodBeat.o(88755);
                return;
            }
            for (i = 0; i < wzVar.wcU; i++) {
                textView = (TextView) layoutInflater.inflate(R.layout.kh, null, false);
                textView.setText(((tm) linkedList.get(i)).title);
                this.kqN.addView(textView);
            }
            this.kqN.invalidate();
            this.kqM.findViewById(R.id.abp).setVisibility(0);
            this.kqM.findViewById(R.id.abp).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88754);
                    l.this.kqO = true;
                    l.this.kqM.findViewById(R.id.abp).setVisibility(8);
                    int i = wzVar.wcU;
                    while (true) {
                        int i2 = i;
                        if (i2 < linkedList.size()) {
                            TextView textView = (TextView) layoutInflater.inflate(R.layout.kh, null, false);
                            textView.setText(((tm) linkedList.get(i2)).title);
                            l.this.kqN.addView(textView);
                            i = i2 + 1;
                        } else {
                            l.this.kqN.invalidate();
                            AppMethodBeat.o(88754);
                            return;
                        }
                    }
                }
            });
        }
        AppMethodBeat.o(88755);
    }

    public final void bes() {
        AppMethodBeat.i(88756);
        if (this.kqM != null) {
            this.kqM.setVisibility(8);
        }
        AppMethodBeat.o(88756);
    }
}
