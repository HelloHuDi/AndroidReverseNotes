package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C11518c;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView */
public class DeleteTaskFooterView extends LinearLayout {
    /* renamed from: Sr */
    private boolean f2904Sr = true;
    private LinearLayout kPU;
    ImageView kPV;
    LinearLayout kPW;
    TextView kPX;
    ImageView kPY;
    boolean kPZ = false;
    private C11518c kQa = new C115271();

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView$3 */
    class C115263 implements OnClickListener {
        C115263() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136217);
            DeleteTaskFooterView.biS();
            AppMethodBeat.m2505o(136217);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView$1 */
    class C115271 implements C11518c {
        C115271() {
        }

        /* renamed from: gh */
        public final void mo23233gh(boolean z) {
            AppMethodBeat.m2504i(136215);
            DeleteTaskFooterView deleteTaskFooterView = DeleteTaskFooterView.this;
            if (z) {
                deleteTaskFooterView.kPW.setClickable(true);
                deleteTaskFooterView.kPY.setImageResource(C25738R.drawable.au1);
                deleteTaskFooterView.kPX.setTextColor(deleteTaskFooterView.getContext().getResources().getColor(C25738R.color.f12107sp));
                AppMethodBeat.m2505o(136215);
                return;
            }
            deleteTaskFooterView.kPW.setClickable(false);
            deleteTaskFooterView.kPY.setImageResource(C25738R.drawable.au2);
            deleteTaskFooterView.kPX.setTextColor(deleteTaskFooterView.getContext().getResources().getColor(C25738R.color.f12106so));
            AppMethodBeat.m2505o(136215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView$2 */
    class C115282 implements OnClickListener {
        C115282() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136216);
            if (DeleteTaskFooterView.this.kPZ) {
                DeleteTaskFooterView.this.kPZ = false;
                DeleteTaskFooterView.this.kPV.setImageResource(C25738R.drawable.at6);
            } else {
                DeleteTaskFooterView.this.kPZ = true;
                DeleteTaskFooterView.this.kPV.setImageResource(C25738R.drawable.at5);
            }
            if (DeleteTaskFooterView.this.f2904Sr) {
                DeleteTaskFooterView.m19342gi(DeleteTaskFooterView.this.kPZ);
            }
            DeleteTaskFooterView.this.f2904Sr = true;
            AppMethodBeat.m2505o(136216);
        }
    }

    public DeleteTaskFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(136218);
        AppMethodBeat.m2505o(136218);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(136219);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(2130969270, this, true);
        this.kPU = (LinearLayout) inflate.findViewById(2131823255);
        this.kPV = (ImageView) inflate.findViewById(2131823256);
        this.kPU.setOnClickListener(new C115282());
        this.kPW = (LinearLayout) inflate.findViewById(2131823257);
        this.kPW.setOnClickListener(new C115263());
        this.kPW.setClickable(false);
        this.kPX = (TextView) inflate.findViewById(2131823259);
        this.kPY = (ImageView) inflate.findViewById(2131823258);
        AppMethodBeat.m2505o(136219);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(136220);
        super.onAttachedToWindow();
        C42918d.m76201a(this.kQa);
        AppMethodBeat.m2505o(136220);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(136221);
        super.onDetachedFromWindow();
        C42918d.m76208b(this.kQa);
        AppMethodBeat.m2505o(136221);
    }

    /* renamed from: gi */
    static /* synthetic */ void m19342gi(boolean z) {
        AppMethodBeat.m2504i(136222);
        C42918d.m76213ge(z);
        AppMethodBeat.m2505o(136222);
    }

    static /* synthetic */ void biS() {
        AppMethodBeat.m2504i(136223);
        C42918d.biJ();
        AppMethodBeat.m2505o(136223);
    }
}
