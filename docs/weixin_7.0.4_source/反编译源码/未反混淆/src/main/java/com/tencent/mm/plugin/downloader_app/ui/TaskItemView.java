package com.tencent.mm.plugin.downloader_app.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.vfs.e;
import java.util.Iterator;

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
    i kQL;
    boolean kQM = false;
    private boolean kQN = false;
    private AppIconView kQv;
    private TextView kQw;
    private TextView kQx;
    private TextView kQy;
    private FrameLayout kQz;

    static /* synthetic */ void b(TaskItemView taskItemView) {
        AppMethodBeat.i(136280);
        taskItemView.biT();
        AppMethodBeat.o(136280);
    }

    public TaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(136272);
        super.onFinishInflate();
        this.kPV = (ImageView) findViewById(R.id.b9a);
        this.kQv = (AppIconView) findViewById(R.id.jb);
        this.kQw = (TextView) findViewById(R.id.ba3);
        this.kQx = (TextView) findViewById(R.id.ba4);
        this.kQy = (TextView) findViewById(R.id.ba5);
        this.kQz = (FrameLayout) findViewById(R.id.ba6);
        this.gHA = (ProgressBar) findViewById(R.id.oa);
        this.gHA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136260);
                c.a(TaskItemView.this.kQL);
                AppMethodBeat.o(136260);
            }
        });
        this.gHA.setSecondaryProgress(100);
        this.kQA = (ImageView) findViewById(R.id.ba7);
        this.kQA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136263);
                if (com.tencent.mm.plugin.downloader.model.c.In(TaskItemView.this.kQL.appId).field_status == 1) {
                    c.a(TaskItemView.this.kQL);
                    AppMethodBeat.o(136263);
                    return;
                }
                c.a(TaskItemView.this.getContext(), TaskItemView.this.kQL, new b() {
                    public final void a(a aVar, long j) {
                        AppMethodBeat.i(136262);
                        if (aVar == a.WAIT_FOR_WIFI) {
                            TaskItemView.b(TaskItemView.this);
                        }
                        AppMethodBeat.o(136262);
                    }
                });
                AppMethodBeat.o(136263);
            }
        });
        this.kQB = (Button) findViewById(R.id.ba8);
        this.kQB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136265);
                if (TaskItemView.this.kQL.type == 6) {
                    c.c(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                    AppMethodBeat.o(136265);
                    return;
                }
                com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(TaskItemView.this.kQL.appId);
                if (In == null) {
                    c.a(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                } else if (TaskItemView.this.kQB.getText().equals(TaskItemView.this.getResources().getString(R.string.f7x))) {
                    c.a(TaskItemView.this.getContext(), In.field_downloadId, new b() {
                        public final void a(a aVar, long j) {
                            AppMethodBeat.i(136264);
                            if (aVar != a.WAIT_FOR_WIFI) {
                                TaskItemView.b(TaskItemView.this);
                            }
                            AppMethodBeat.o(136264);
                        }
                    });
                    AppMethodBeat.o(136265);
                    return;
                } else if (TaskItemView.this.kQB.getText().equals(TaskItemView.this.getResources().getString(R.string.cdv))) {
                    c.b(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                    AppMethodBeat.o(136265);
                    return;
                } else if (!TaskItemView.this.kQB.getText().equals(TaskItemView.this.getResources().getString(R.string.cz9))) {
                    c.a(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                    AppMethodBeat.o(136265);
                    return;
                } else if (!e.ct(In.field_filePath)) {
                    c.a(TaskItemView.this.getContext(), TaskItemView.this.kQL);
                    AppMethodBeat.o(136265);
                    return;
                }
                AppMethodBeat.o(136265);
            }
        });
        this.kQC = (RelativeLayout) findViewById(R.id.ba9);
        this.kQD = (TextView) findViewById(R.id.baa);
        this.kQE = (LinearLayout) findViewById(R.id.bab);
        this.kQF = (TextView) findViewById(R.id.bac);
        this.kQF.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(136266);
                if (TaskItemView.this.kQF.getLineCount() <= 2) {
                    TaskItemView.this.kQE.setVisibility(8);
                    TaskItemView.this.kQF.setVisibility(8);
                    AppMethodBeat.o(136266);
                } else if (TaskItemView.this.kQN) {
                    TaskItemView.this.kQE.setVisibility(8);
                    TaskItemView.this.kQF.setVisibility(0);
                    AppMethodBeat.o(136266);
                } else {
                    TaskItemView.this.kQE.setVisibility(0);
                    TaskItemView.this.kQF.setVisibility(8);
                    AppMethodBeat.o(136266);
                }
            }
        });
        this.kQE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136267);
                TaskItemView.this.kQN = false;
                TaskItemView.this.kQD.setMaxLines(2);
                TaskItemView.this.kQE.setVisibility(8);
                TaskItemView.this.kQF.setVisibility(0);
                AppMethodBeat.o(136267);
            }
        });
        this.kQF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136268);
                TaskItemView.this.kQN = true;
                TaskItemView.this.kQD.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                TaskItemView.this.kQE.setVisibility(0);
                TaskItemView.this.kQF.setVisibility(8);
                com.tencent.mm.plugin.downloader_app.c.a.a(10, 1003, 0, 2, TaskItemView.this.kQL.appId, "", "");
                AppMethodBeat.o(136268);
            }
        });
        this.kQG = (LinearLayout) findViewById(R.id.bad);
        this.kQH = (ImageView) findViewById(R.id.bae);
        this.kQI = (TextView) findViewById(R.id.baf);
        this.kQJ = (LinearLayout) findViewById(R.id.bag);
        this.kQJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136269);
                if (!(TaskItemView.this.kQL == null || TaskItemView.this.kQL.kPe == null || bo.isNullOrNil(TaskItemView.this.kQL.kPe.kKN))) {
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", TaskItemView.this.kQL.kPe.kKN);
                    ((d) g.K(d.class)).f(TaskItemView.this.getContext(), bundle);
                    com.tencent.mm.plugin.downloader_app.c.a.a(10, 1006, TaskItemView.this.kQL.position, 40, TaskItemView.this.kQL.appId, "", "");
                }
                AppMethodBeat.o(136269);
            }
        });
        this.kQK = (TextView) findViewById(R.id.bah);
        AppMethodBeat.o(136272);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(136273);
        super.onDetachedFromWindow();
        AppMethodBeat.o(136273);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(136274);
        super.onAttachedToWindow();
        AppMethodBeat.o(136274);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.i(136275);
        ab.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", Boolean.valueOf(z), this.kQL.appId);
        this.kQL.gBF = z;
        if (z) {
            this.kPV.setImageResource(R.drawable.at5);
        } else {
            this.kPV.setImageResource(R.drawable.at6);
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TaskListView) {
                boolean z2;
                TaskListView taskListView = (TaskListView) parent;
                h hVar = taskListView.kQZ.kQR;
                Iterator it = hVar.iterator();
                int i = 0;
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar.biN() && iVar.gBF) {
                        i++;
                    }
                    i = i;
                }
                if (i > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com.tencent.mm.plugin.downloader_app.b.d.gf(z2);
                if (i != hVar.size() - 3) {
                    ((DownloadMainUI) taskListView.getContext()).gj(false);
                } else if (taskListView.getContext() instanceof DownloadMainUI) {
                    ((DownloadMainUI) taskListView.getContext()).gj(true);
                    AppMethodBeat.o(136275);
                    return;
                }
                AppMethodBeat.o(136275);
                return;
            }
        }
        AppMethodBeat.o(136275);
    }

    public void setData(i iVar) {
        AppMethodBeat.i(136276);
        this.kQL = iVar;
        if (iVar == null) {
            setVisibility(8);
            AppMethodBeat.o(136276);
            return;
        }
        setVisibility(0);
        this.kQz.setVisibility(8);
        this.kQB.setVisibility(8);
        this.kQC.setVisibility(8);
        this.kQG.setVisibility(8);
        new com.tencent.mm.at.a.a.c.a().ePH = true;
        o.ahp().a(this.kQL.iconUrl, this.kQv);
        this.kQw.setText(this.kQL.appName);
        com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(this.kQL.appId);
        if (In == null || !In.field_autoDownload) {
            this.kQx.setVisibility(8);
        } else {
            this.kQx.setVisibility(0);
        }
        if (this.kQL.kci) {
            if (this.kPV.getVisibility() != 0) {
                this.kPV.setVisibility(0);
                this.kPV.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.cv));
            }
            setSelected(this.kQL.gBF);
            H(this.kQL.kPc.kKP, this.kQL.kPc.kKP);
            AppMethodBeat.o(136276);
            return;
        }
        this.kPV.setVisibility(8);
        if (this.kQL.kPe != null) {
            LayoutParams layoutParams = (LayoutParams) this.kQG.getLayoutParams();
            if (this.kQL.kci) {
                layoutParams.leftMargin = aj.fromDPToPix(getContext(), 114);
            } else {
                layoutParams.leftMargin = aj.fromDPToPix(getContext(), 78);
            }
            this.kQG.setLayoutParams(layoutParams);
            this.kQG.setVisibility(0);
            new com.tencent.mm.at.a.a.c.a().ePH = true;
            o.ahp().a(this.kQL.kPe.cIY, this.kQH);
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
                com.tencent.mm.plugin.downloader_app.c.a.a(10, 1006, this.kQL.position, 1, this.kQL.appId, "", "");
            }
        } else {
            this.kQG.setVisibility(8);
        }
        H(this.kQL.kPc.kKP, this.kQL.kPc.kKP);
        if (this.kQL.type == 4) {
            In = com.tencent.mm.plugin.downloader.model.c.In(this.kQL.appId);
            if (In == null || In.field_status == 0 || In.field_status == 5) {
                this.kQz.setVisibility(8);
                this.kQB.setVisibility(0);
                this.kQB.setText(getContext().getResources().getString(R.string.ez4));
                if (!bo.isNullOrNil(this.kQL.kPa)) {
                    this.kQC.setVisibility(0);
                    this.kQD.setText(this.kQL.kPa);
                    this.kQD.setMaxLines(2);
                    AppMethodBeat.o(136276);
                    return;
                }
            }
            biT();
            AppMethodBeat.o(136276);
        } else if (this.kQL.type == 6) {
            this.kQz.setVisibility(8);
            this.kQB.setVisibility(0);
            this.kQB.setText(getContext().getResources().getString(R.string.cm9));
            AppMethodBeat.o(136276);
        } else {
            biT();
            AppMethodBeat.o(136276);
        }
    }

    /* Access modifiers changed, original: final */
    public final void biT() {
        AppMethodBeat.i(136277);
        ab.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", this.kQL.appId);
        this.gHA.setIndeterminate(false);
        com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(this.kQL.appId);
        if (In == null || In.field_status == 5) {
            H(this.kQL.kPc.kKP, this.kQL.kPc.kKP);
            this.kQz.setVisibility(0);
            this.gHA.setIndeterminate(true);
            this.kQA.setVisibility(8);
            this.kQB.setVisibility(8);
            AppMethodBeat.o(136277);
            return;
        }
        H(In.field_downloadedSize, this.kQL.kPc.kKP);
        if (In.field_status == 3) {
            this.kQz.setVisibility(8);
            this.kQB.setText(R.string.cdv);
            this.kQB.setVisibility(0);
            AppMethodBeat.o(136277);
        } else if (In.field_status == 6) {
            this.kQz.setVisibility(8);
            this.kQB.setText(getResources().getString(R.string.cz9));
            this.kQB.setVisibility(0);
            AppMethodBeat.o(136277);
        } else {
            this.kQz.setVisibility(0);
            this.gHA.setVisibility(0);
            this.kQB.setVisibility(8);
            if (this.kQM) {
                this.kQA.setVisibility(8);
                this.gHA.setIndeterminate(true);
                AppMethodBeat.o(136277);
            } else if (In.field_status == 1) {
                this.kQM = false;
                this.kQA.setImageResource(R.drawable.au4);
                this.kQA.setVisibility(0);
                AppMethodBeat.o(136277);
            } else if (In.field_reserveInWifi && !at.isWifi(getContext())) {
                this.kQz.setVisibility(8);
                this.kQB.setText(R.string.f7x);
                this.kQB.setVisibility(0);
                AppMethodBeat.o(136277);
            } else if (In.field_status == 4) {
                this.kQz.setVisibility(8);
                this.kQB.setText(R.string.b6z);
                this.kQB.setVisibility(0);
                AppMethodBeat.o(136277);
            } else {
                this.kQA.setImageResource(R.drawable.au3);
                this.kQA.setVisibility(0);
                AppMethodBeat.o(136277);
            }
        }
    }

    private void H(long j, long j2) {
        AppMethodBeat.i(136278);
        float f = ((float) j2) / 1.07374182E9f;
        float f2 = ((float) j2) / 1048576.0f;
        if (j < j2) {
            f = ((float) j) / 1048576.0f;
            this.kQy.setText(String.format("%.1fMB / %.1fMB", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
            final int i = (int) ((100 * j) / j2);
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(136270);
                    TaskItemView.this.gHA.setSecondaryProgress(100);
                    TaskItemView.this.gHA.setProgress(i);
                    AppMethodBeat.o(136270);
                }
            });
            AppMethodBeat.o(136278);
        } else if (f >= 1.0f) {
            this.kQy.setText(String.format("%.1fGB", new Object[]{Float.valueOf(f)}));
            AppMethodBeat.o(136278);
        } else {
            this.kQy.setText(String.format("%.1fMB", new Object[]{Float.valueOf(f2)}));
            AppMethodBeat.o(136278);
        }
    }

    public int getNamePaddingLeft() {
        AppMethodBeat.i(136279);
        int dimensionPixelSize;
        if (this.kPV.getVisibility() == 0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.xc);
            AppMethodBeat.o(136279);
            return dimensionPixelSize;
        }
        dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.xb);
        AppMethodBeat.o(136279);
        return dimensionPixelSize;
    }
}
