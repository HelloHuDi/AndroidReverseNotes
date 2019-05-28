package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20331a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20332b;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C20339h;
import com.tencent.p177mm.plugin.downloader_app.p377b.C38861i;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45836c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView */
public class TaskItemView extends LinearLayout {
    ProgressBar gHA;
    ImageView kPV;
    private ImageView kQA;
    private Button kQB;
    private RelativeLayout kQC;
    private TextView kQD;
    private LinearLayout kQE;
    private TextView kQF;
    private LinearLayout kQG;
    private ImageView kQH;
    private TextView kQI;
    private LinearLayout kQJ;
    private TextView kQK;
    C38861i kQL;
    boolean kQM = false;
    private boolean kQN = false;
    private AppIconView kQv;
    private TextView kQw;
    private TextView kQx;
    private TextView kQy;
    private FrameLayout kQz;

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$1 */
    class C115311 implements OnClickListener {
        C115311() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136260);
            C45836c.m84839a(TaskItemView.this.kQL);
            AppMethodBeat.m2505o(136260);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$3 */
    class C115323 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$3$1 */
        class C115331 implements C20332b {
            C115331() {
            }

            /* renamed from: a */
            public final void mo9713a(C20331a c20331a, long j) {
                AppMethodBeat.m2504i(136262);
                if (c20331a == C20331a.WAIT_FOR_WIFI) {
                    TaskItemView.m19347b(TaskItemView.this);
                }
                AppMethodBeat.m2505o(136262);
            }
        }

        C115323() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136263);
            if (C2895c.m5140In(TaskItemView.this.kQL.appId).field_status == 1) {
                C45836c.m84839a(TaskItemView.this.kQL);
                AppMethodBeat.m2505o(136263);
                return;
            }
            C45836c.m84836a(TaskItemView.this.getContext(), TaskItemView.this.kQL, new C115331());
            AppMethodBeat.m2505o(136263);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$2 */
    class C115342 implements Runnable {
        C115342() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136261);
            TaskItemView.this.kQz.setVisibility(8);
            TaskItemView.this.kQB.setText(TaskItemView.this.getResources().getString(C25738R.string.f7x));
            TaskItemView.this.kQB.setVisibility(0);
            AppMethodBeat.m2505o(136261);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$4 */
    class C115354 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$4$1 */
        class C115361 implements C20332b {
            C115361() {
            }

            /* renamed from: a */
            public final void mo9713a(C20331a c20331a, long j) {
                AppMethodBeat.m2504i(136264);
                if (c20331a != C20331a.WAIT_FOR_WIFI) {
                    TaskItemView.m19347b(TaskItemView.this);
                }
                AppMethodBeat.m2505o(136264);
            }
        }

        C115354() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136265);
            if (TaskItemView.this.kQL.type == 6) {
                C45836c.m84844c(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                AppMethodBeat.m2505o(136265);
                return;
            }
            C42911a In = C2895c.m5140In(TaskItemView.this.kQL.appId);
            if (In == null) {
                C45836c.m84835a(TaskItemView.this.getContext(), TaskItemView.this.kQL);
            } else if (TaskItemView.this.kQB.getText().equals(TaskItemView.this.getResources().getString(C25738R.string.f7x))) {
                C45836c.m84832a(TaskItemView.this.getContext(), In.field_downloadId, new C115361());
                AppMethodBeat.m2505o(136265);
                return;
            } else if (TaskItemView.this.kQB.getText().equals(TaskItemView.this.getResources().getString(C25738R.string.cdv))) {
                C45836c.m84843b(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                AppMethodBeat.m2505o(136265);
                return;
            } else if (!TaskItemView.this.kQB.getText().equals(TaskItemView.this.getResources().getString(C25738R.string.cz9))) {
                C45836c.m84835a(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                AppMethodBeat.m2505o(136265);
                return;
            } else if (!C5730e.m8628ct(In.field_filePath)) {
                C45836c.m84835a(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                AppMethodBeat.m2505o(136265);
                return;
            }
            AppMethodBeat.m2505o(136265);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$10 */
    class C1153710 implements Runnable {
        C1153710() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136271);
            TaskItemView.this.kQz.setVisibility(0);
            TaskItemView.this.gHA.setIndeterminate(true);
            TaskItemView.this.kQA.setVisibility(8);
            TaskItemView.this.kQB.setVisibility(8);
            AppMethodBeat.m2505o(136271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$5 */
    class C115385 implements OnGlobalLayoutListener {
        C115385() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(136266);
            if (TaskItemView.this.kQF.getLineCount() <= 2) {
                TaskItemView.this.kQE.setVisibility(8);
                TaskItemView.this.kQF.setVisibility(8);
                AppMethodBeat.m2505o(136266);
            } else if (TaskItemView.this.kQN) {
                TaskItemView.this.kQE.setVisibility(8);
                TaskItemView.this.kQF.setVisibility(0);
                AppMethodBeat.m2505o(136266);
            } else {
                TaskItemView.this.kQE.setVisibility(0);
                TaskItemView.this.kQF.setVisibility(8);
                AppMethodBeat.m2505o(136266);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$7 */
    class C115397 implements OnClickListener {
        C115397() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136268);
            TaskItemView.this.kQN = true;
            TaskItemView.this.kQD.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            TaskItemView.this.kQE.setVisibility(0);
            TaskItemView.this.kQF.setVisibility(8);
            C45838a.m84850a(10, 1003, 0, 2, TaskItemView.this.kQL.appId, "", "");
            AppMethodBeat.m2505o(136268);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$6 */
    class C115406 implements OnClickListener {
        C115406() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136267);
            TaskItemView.this.kQN = false;
            TaskItemView.this.kQD.setMaxLines(2);
            TaskItemView.this.kQE.setVisibility(8);
            TaskItemView.this.kQF.setVisibility(0);
            AppMethodBeat.m2505o(136267);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$8 */
    class C115418 implements OnClickListener {
        C115418() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136269);
            if (!(TaskItemView.this.kQL == null || TaskItemView.this.kQL.kPe == null || C5046bo.isNullOrNil(TaskItemView.this.kQL.kPe.kKN))) {
                Bundle bundle = new Bundle();
                bundle.putString("rawUrl", TaskItemView.this.kQL.kPe.kKN);
                ((C38855d) C1720g.m3528K(C38855d.class)).mo61733f(TaskItemView.this.getContext(), bundle);
                C45838a.m84850a(10, 1006, TaskItemView.this.kQL.position, 40, TaskItemView.this.kQL.appId, "", "");
            }
            AppMethodBeat.m2505o(136269);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m19347b(TaskItemView taskItemView) {
        AppMethodBeat.m2504i(136280);
        taskItemView.biT();
        AppMethodBeat.m2505o(136280);
    }

    public TaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(136272);
        super.onFinishInflate();
        this.kPV = (ImageView) findViewById(2131823256);
        this.kQv = (AppIconView) findViewById(2131820915);
        this.kQw = (TextView) findViewById(2131823322);
        this.kQx = (TextView) findViewById(2131823323);
        this.kQy = (TextView) findViewById(2131823324);
        this.kQz = (FrameLayout) findViewById(2131823325);
        this.gHA = (ProgressBar) findViewById(2131821099);
        this.gHA.setOnClickListener(new C115311());
        this.gHA.setSecondaryProgress(100);
        this.kQA = (ImageView) findViewById(2131823326);
        this.kQA.setOnClickListener(new C115323());
        this.kQB = (Button) findViewById(2131823327);
        this.kQB.setOnClickListener(new C115354());
        this.kQC = (RelativeLayout) findViewById(2131823328);
        this.kQD = (TextView) findViewById(2131823330);
        this.kQE = (LinearLayout) findViewById(2131823331);
        this.kQF = (TextView) findViewById(2131823332);
        this.kQF.getViewTreeObserver().addOnGlobalLayoutListener(new C115385());
        this.kQE.setOnClickListener(new C115406());
        this.kQF.setOnClickListener(new C115397());
        this.kQG = (LinearLayout) findViewById(2131823333);
        this.kQH = (ImageView) findViewById(2131823334);
        this.kQI = (TextView) findViewById(2131823335);
        this.kQJ = (LinearLayout) findViewById(2131823336);
        this.kQJ.setOnClickListener(new C115418());
        this.kQK = (TextView) findViewById(2131823337);
        AppMethodBeat.m2505o(136272);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(136273);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(136273);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(136274);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(136274);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.m2504i(136275);
        C4990ab.m7411d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", Boolean.valueOf(z), this.kQL.appId);
        this.kQL.gBF = z;
        if (z) {
            this.kPV.setImageResource(C25738R.drawable.at5);
        } else {
            this.kPV.setImageResource(C25738R.drawable.at6);
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TaskListView) {
                boolean z2;
                TaskListView taskListView = (TaskListView) parent;
                C20339h c20339h = taskListView.kQZ.kQR;
                Iterator it = c20339h.iterator();
                int i = 0;
                while (it.hasNext()) {
                    C38861i c38861i = (C38861i) it.next();
                    if (c38861i.biN() && c38861i.gBF) {
                        i++;
                    }
                    i = i;
                }
                if (i > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C42918d.m76214gf(z2);
                if (i != c20339h.size() - 3) {
                    ((DownloadMainUI) taskListView.getContext()).mo68457gj(false);
                } else if (taskListView.getContext() instanceof DownloadMainUI) {
                    ((DownloadMainUI) taskListView.getContext()).mo68457gj(true);
                    AppMethodBeat.m2505o(136275);
                    return;
                }
                AppMethodBeat.m2505o(136275);
                return;
            }
        }
        AppMethodBeat.m2505o(136275);
    }

    public void setData(C38861i c38861i) {
        AppMethodBeat.m2504i(136276);
        this.kQL = c38861i;
        if (c38861i == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(136276);
            return;
        }
        setVisibility(0);
        this.kQz.setVisibility(8);
        this.kQB.setVisibility(8);
        this.kQC.setVisibility(8);
        this.kQG.setVisibility(8);
        new C17927a().ePH = true;
        C32291o.ahp().mo43765a(this.kQL.iconUrl, this.kQv);
        this.kQw.setText(this.kQL.appName);
        C42911a In = C2895c.m5140In(this.kQL.appId);
        if (In == null || !In.field_autoDownload) {
            this.kQx.setVisibility(8);
        } else {
            this.kQx.setVisibility(0);
        }
        if (this.kQL.kci) {
            if (this.kPV.getVisibility() != 0) {
                this.kPV.setVisibility(0);
                this.kPV.startAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8388cv));
            }
            setSelected(this.kQL.gBF);
            m19344H(this.kQL.kPc.kKP, this.kQL.kPc.kKP);
            AppMethodBeat.m2505o(136276);
            return;
        }
        this.kPV.setVisibility(8);
        if (this.kQL.kPe != null) {
            LayoutParams layoutParams = (LayoutParams) this.kQG.getLayoutParams();
            if (this.kQL.kci) {
                layoutParams.leftMargin = C5229aj.fromDPToPix(getContext(), 114);
            } else {
                layoutParams.leftMargin = C5229aj.fromDPToPix(getContext(), 78);
            }
            this.kQG.setLayoutParams(layoutParams);
            this.kQG.setVisibility(0);
            new C17927a().ePH = true;
            C32291o.ahp().mo43765a(this.kQL.kPe.cIY, this.kQH);
            if (this.kQL.kPe.kKL != null) {
                this.kQI.setText(this.kQL.kPe.kKL.value);
                try {
                    this.kQI.setTextColor(Color.parseColor(this.kQL.kPe.kKL.color));
                } catch (Exception e) {
                }
            }
            if (this.kQL.kPe.kKM != null) {
                this.kQJ.setVisibility(0);
                this.kQK.setText(this.kQL.kPe.kKM.value);
                try {
                    this.kQK.setTextColor(Color.parseColor(this.kQL.kPe.kKM.color));
                } catch (Exception e2) {
                }
            } else {
                this.kQJ.setVisibility(8);
            }
            if (!this.kQL.kOZ) {
                this.kQL.kOZ = true;
                C45838a.m84850a(10, 1006, this.kQL.position, 1, this.kQL.appId, "", "");
            }
        } else {
            this.kQG.setVisibility(8);
        }
        m19344H(this.kQL.kPc.kKP, this.kQL.kPc.kKP);
        if (this.kQL.type == 4) {
            In = C2895c.m5140In(this.kQL.appId);
            if (In == null || In.field_status == 0 || In.field_status == 5) {
                this.kQz.setVisibility(8);
                this.kQB.setVisibility(0);
                this.kQB.setText(getContext().getResources().getString(C25738R.string.ez4));
                if (!C5046bo.isNullOrNil(this.kQL.kPa)) {
                    this.kQC.setVisibility(0);
                    this.kQD.setText(this.kQL.kPa);
                    this.kQD.setMaxLines(2);
                    AppMethodBeat.m2505o(136276);
                    return;
                }
            }
            biT();
            AppMethodBeat.m2505o(136276);
        } else if (this.kQL.type == 6) {
            this.kQz.setVisibility(8);
            this.kQB.setVisibility(0);
            this.kQB.setText(getContext().getResources().getString(C25738R.string.cm9));
            AppMethodBeat.m2505o(136276);
        } else {
            biT();
            AppMethodBeat.m2505o(136276);
        }
    }

    /* Access modifiers changed, original: final */
    public final void biT() {
        AppMethodBeat.m2504i(136277);
        C4990ab.m7411d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", this.kQL.appId);
        this.gHA.setIndeterminate(false);
        C42911a In = C2895c.m5140In(this.kQL.appId);
        if (In == null || In.field_status == 5) {
            m19344H(this.kQL.kPc.kKP, this.kQL.kPc.kKP);
            this.kQz.setVisibility(0);
            this.gHA.setIndeterminate(true);
            this.kQA.setVisibility(8);
            this.kQB.setVisibility(8);
            AppMethodBeat.m2505o(136277);
            return;
        }
        m19344H(In.field_downloadedSize, this.kQL.kPc.kKP);
        if (In.field_status == 3) {
            this.kQz.setVisibility(8);
            this.kQB.setText(C25738R.string.cdv);
            this.kQB.setVisibility(0);
            AppMethodBeat.m2505o(136277);
        } else if (In.field_status == 6) {
            this.kQz.setVisibility(8);
            this.kQB.setText(getResources().getString(C25738R.string.cz9));
            this.kQB.setVisibility(0);
            AppMethodBeat.m2505o(136277);
        } else {
            this.kQz.setVisibility(0);
            this.gHA.setVisibility(0);
            this.kQB.setVisibility(8);
            if (this.kQM) {
                this.kQA.setVisibility(8);
                this.gHA.setIndeterminate(true);
                AppMethodBeat.m2505o(136277);
            } else if (In.field_status == 1) {
                this.kQM = false;
                this.kQA.setImageResource(C25738R.drawable.au4);
                this.kQA.setVisibility(0);
                AppMethodBeat.m2505o(136277);
            } else if (In.field_reserveInWifi && !C5023at.isWifi(getContext())) {
                this.kQz.setVisibility(8);
                this.kQB.setText(C25738R.string.f7x);
                this.kQB.setVisibility(0);
                AppMethodBeat.m2505o(136277);
            } else if (In.field_status == 4) {
                this.kQz.setVisibility(8);
                this.kQB.setText(C25738R.string.b6z);
                this.kQB.setVisibility(0);
                AppMethodBeat.m2505o(136277);
            } else {
                this.kQA.setImageResource(C25738R.drawable.au3);
                this.kQA.setVisibility(0);
                AppMethodBeat.m2505o(136277);
            }
        }
    }

    /* renamed from: H */
    private void m19344H(long j, long j2) {
        AppMethodBeat.m2504i(136278);
        float f = ((float) j2) / 1.07374182E9f;
        float f2 = ((float) j2) / 1048576.0f;
        if (j < j2) {
            f = ((float) j) / 1048576.0f;
            this.kQy.setText(String.format("%.1fMB / %.1fMB", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
            final int i = (int) ((100 * j) / j2);
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(136270);
                    TaskItemView.this.gHA.setSecondaryProgress(100);
                    TaskItemView.this.gHA.setProgress(i);
                    AppMethodBeat.m2505o(136270);
                }
            });
            AppMethodBeat.m2505o(136278);
        } else if (f >= 1.0f) {
            this.kQy.setText(String.format("%.1fGB", new Object[]{Float.valueOf(f)}));
            AppMethodBeat.m2505o(136278);
        } else {
            this.kQy.setText(String.format("%.1fMB", new Object[]{Float.valueOf(f2)}));
            AppMethodBeat.m2505o(136278);
        }
    }

    public int getNamePaddingLeft() {
        AppMethodBeat.m2504i(136279);
        int dimensionPixelSize;
        if (this.kPV.getVisibility() == 0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10303xc);
            AppMethodBeat.m2505o(136279);
            return dimensionPixelSize;
        }
        dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10302xb);
        AppMethodBeat.m2505o(136279);
        return dimensionPixelSize;
    }
}
