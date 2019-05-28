package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.b.d.b;
import com.tencent.mm.plugin.downloader_app.b.d.d;
import com.tencent.mm.plugin.downloader_app.b.d.e;
import com.tencent.mm.plugin.downloader_app.b.d.f;
import com.tencent.mm.plugin.downloader_app.b.d.g;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView extends MRecyclerView {
    private Map<String, i> kOT = new HashMap();
    b kQZ;
    a kRa;
    boolean kRb;
    private d kRc = new d() {
        public final void E(int i, long j) {
            AppMethodBeat.i(136292);
            com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
            if (hv != null) {
                TaskListView.a(TaskListView.this, i, hv.field_appId);
            }
            AppMethodBeat.o(136292);
        }
    };
    private com.tencent.mm.plugin.downloader_app.b.d.a kRd = new com.tencent.mm.plugin.downloader_app.b.d.a() {
        public final void gg(boolean z) {
            AppMethodBeat.i(136293);
            TaskListView taskListView = TaskListView.this;
            Iterator it = taskListView.kQZ.kQR.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.biN()) {
                    iVar.gBF = z;
                }
            }
            taskListView.kQZ.aop.notifyChanged();
            com.tencent.mm.plugin.downloader_app.b.d.gf(z);
            AppMethodBeat.o(136293);
        }
    };
    private b kRe = new b() {
        public final void onClick() {
            AppMethodBeat.i(136294);
            TaskListView taskListView = TaskListView.this;
            h.d(taskListView.getContext(), taskListView.getContext().getString(R.string.b5a), "", taskListView.getContext().getString(R.string.ev_), taskListView.getContext().getString(R.string.ev9), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136300);
                    TaskListView taskListView = TaskListView.this;
                    LinkedList linkedList = new LinkedList();
                    Iterator it = taskListView.kQZ.kQR.iterator();
                    while (it.hasNext()) {
                        i iVar = (i) it.next();
                        if (iVar.gBF) {
                            int i2;
                            linkedList.add(iVar);
                            j.kP(iVar.appId);
                            com.tencent.mm.plugin.downloader_app.b.c.b(iVar);
                            switch (iVar.type) {
                                case 2:
                                    i2 = 1101;
                                    break;
                                case 4:
                                    i2 = 1102;
                                    break;
                                case 6:
                                    i2 = 1103;
                                    break;
                                default:
                                    i2 = 0;
                                    break;
                            }
                            com.tencent.mm.plugin.downloader_app.c.a.a(11, i2, iVar.position, 81, iVar.appId, "", "");
                        }
                    }
                    if (linkedList.size() != 0) {
                        taskListView.kQZ.P(linkedList);
                        if (taskListView.kQZ.biL()) {
                            taskListView.biU();
                        }
                    }
                    com.tencent.mm.plugin.downloader_app.b.d.gf(false);
                    AppMethodBeat.o(136300);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(136294);
        }
    };
    private f kRf = new f() {
        public final void IJ(String str) {
            AppMethodBeat.i(136295);
            TaskListView.a(TaskListView.this, str);
            AppMethodBeat.o(136295);
        }
    };
    private e kRg = new e() {
        public final void II(String str) {
            AppMethodBeat.i(136296);
            TaskListView.b(TaskListView.this, str);
            AppMethodBeat.o(136296);
        }
    };
    private g kRh = new g() {
        public final void IK(String str) {
            AppMethodBeat.i(136297);
            TaskListView.c(TaskListView.this, str);
            AppMethodBeat.o(136297);
        }
    };
    private boolean kRi = true;

    public TaskListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(136301);
        AppMethodBeat.o(136301);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(136302);
        super.onFinishInflate();
        ab.d("MicroMsg.TaskListView", "onFinishInflate");
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.kQZ = new b(getContext());
        setAdapter(this.kQZ);
        a(new a(getResources()));
        setOnItemLongClickListener(new MRecyclerView.b() {
            public final boolean L(View view, int i) {
                AppMethodBeat.i(136298);
                if (TaskListView.this.kRi) {
                    if (((ViewGroup) view).getChildAt(0) instanceof TaskItemView) {
                        com.tencent.mm.plugin.downloader_app.b.h hVar = TaskListView.this.kQZ.kQR;
                        if (hVar != null) {
                            Iterator it = hVar.iterator();
                            while (it.hasNext()) {
                                ((i) it.next()).kci = true;
                            }
                            ((TaskItemView) ((ViewGroup) view).getChildAt(0)).setSelected(true);
                            TaskListView.c(TaskListView.this);
                        }
                    }
                    AppMethodBeat.o(136298);
                    return true;
                }
                AppMethodBeat.o(136298);
                return false;
            }
        });
        setOnItemClickListener(new MRecyclerView.a() {
            public final void I(View view, int i) {
                AppMethodBeat.i(136299);
                ab.d("MicroMsg.TaskListView", "onItemClick");
                View childAt = ((ViewGroup) view).getChildAt(0);
                com.tencent.mm.plugin.downloader_app.b.h hVar = TaskListView.this.kQZ.kQR;
                if (i < 0 || i >= hVar.size()) {
                    AppMethodBeat.o(136299);
                    return;
                }
                i iVar = (i) hVar.get(i);
                if (iVar.type == 7) {
                    b b = TaskListView.this.kQZ;
                    if (!b.kQW) {
                        b.kQW = true;
                        b.aop.notifyChanged();
                    }
                    com.tencent.mm.plugin.downloader_app.c.a.a(10, 1004, 101, 2, "", "", "");
                    AppMethodBeat.o(136299);
                } else if (!TaskListView.this.kRi) {
                    boolean z;
                    if (iVar.gBF) {
                        z = false;
                    } else {
                        z = true;
                    }
                    childAt.setSelected(z);
                    AppMethodBeat.o(136299);
                } else if (bo.isNullOrNil(iVar.jumpUrl)) {
                    AppMethodBeat.o(136299);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", iVar.jumpUrl);
                    ((com.tencent.mm.plugin.downloader_app.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).f(TaskListView.this.getContext(), bundle);
                    com.tencent.mm.plugin.downloader_app.c.a.a(10, com.tencent.mm.plugin.downloader_app.c.a.tQ(iVar.type), iVar.position, 40, iVar.appId, "", "");
                    AppMethodBeat.o(136299);
                }
            }
        });
        AppMethodBeat.o(136302);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(136303);
        super.onAttachedToWindow();
        com.tencent.mm.plugin.downloader_app.b.d.a(this.kRc);
        com.tencent.mm.plugin.downloader_app.b.d.a(this.kRd);
        com.tencent.mm.plugin.downloader_app.b.d.a(this.kRe);
        com.tencent.mm.plugin.downloader_app.b.d.a(this.kRf);
        com.tencent.mm.plugin.downloader_app.b.d.a(this.kRg);
        com.tencent.mm.plugin.downloader_app.b.d.a(this.kRh);
        AppMethodBeat.o(136303);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(136304);
        super.onDetachedFromWindow();
        com.tencent.mm.plugin.downloader_app.b.d.b(this.kRc);
        com.tencent.mm.plugin.downloader_app.b.d.b(this.kRd);
        com.tencent.mm.plugin.downloader_app.b.d.b(this.kRe);
        com.tencent.mm.plugin.downloader_app.b.d.b(this.kRf);
        com.tencent.mm.plugin.downloader_app.b.d.b(this.kRg);
        com.tencent.mm.plugin.downloader_app.b.d.b(this.kRh);
        AppMethodBeat.o(136304);
    }

    public void setData(LinkedList<i> linkedList) {
        AppMethodBeat.i(136305);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!bo.isNullOrNil(iVar.appId)) {
                this.kOT.put(iVar.appId, iVar);
            }
        }
        b bVar = this.kQZ;
        bVar.kQR.clear();
        com.tencent.mm.plugin.downloader_app.b.h hVar = bVar.kQR;
        for (com.tencent.mm.plugin.downloader_app.b.e a : linkedList) {
            hVar.a(a);
        }
        bVar.kQR.a(new i(1));
        bVar.kQR.a(new i(3));
        bVar.kQR.a(new i(5));
        bVar.kQR.a(new i(7));
        bVar.aop.notifyChanged();
        AppMethodBeat.o(136305);
    }

    private void c(i iVar) {
        int i;
        Object obj;
        AppMethodBeat.i(136306);
        b bVar = this.kQZ;
        bVar.kQR.remove(iVar);
        com.tencent.mm.plugin.downloader_app.b.h hVar = bVar.kQR;
        for (int i2 = 0; i2 < hVar.size(); i2++) {
            if (iVar.biK() <= ((com.tencent.mm.plugin.downloader_app.b.e) hVar.get(i2)).biK()) {
                i = i2;
                obj = 1;
                break;
            }
        }
        i = 0;
        obj = null;
        if (obj == null) {
            i = hVar.size();
        }
        hVar.add(i, iVar);
        l.q(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136281);
                b.this.aop.notifyChanged();
                AppMethodBeat.o(136281);
            }
        });
        AppMethodBeat.o(136306);
    }

    public int getSize() {
        AppMethodBeat.i(136307);
        int size = this.kQZ.kQR.size();
        AppMethodBeat.o(136307);
        return size;
    }

    public final void biU() {
        AppMethodBeat.i(136308);
        this.kRb = false;
        if (this.kRa != null) {
            this.kRa.gl(false);
        }
        com.tencent.mm.plugin.downloader_app.b.h hVar = this.kQZ.kQR;
        if (this.kQZ.biL()) {
            ((DownloadMainUI) getContext()).gk(true);
            AppMethodBeat.o(136308);
            return;
        }
        Iterator it = hVar.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            iVar.kci = false;
            iVar.gBF = false;
        }
        this.kQZ.kQX = true;
        this.kQZ.aop.notifyChanged();
        this.kRi = true;
        AppMethodBeat.o(136308);
    }

    static /* synthetic */ void a(TaskListView taskListView, int i, String str) {
        AppMethodBeat.i(136309);
        if (taskListView.kOT.containsKey(str)) {
            i iVar = (i) taskListView.kOT.get(str);
            if (i == 9) {
                iVar.type = 6;
                taskListView.c(iVar);
                AppMethodBeat.o(136309);
                return;
            } else if (iVar.type == 6) {
                iVar.type = 2;
                taskListView.c(iVar);
                AppMethodBeat.o(136309);
                return;
            } else {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
                int childCount = linearLayoutManager.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (linearLayoutManager.getChildAt(i2) != null) {
                        View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i2)).getChildAt(0);
                        if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                            TaskItemView taskItemView = (TaskItemView) childAt;
                            ab.i("MicroMsg.TaskItemView", "refreshDownloadStatus, event = %s, appId: %s", Integer.valueOf(i), str);
                            if (!(taskItemView.kPV.getVisibility() == 0 || !str.equals(taskItemView.kQL.appId) || c.In(taskItemView.kQL.appId) == null)) {
                                if (!(i == 1 || i == 7)) {
                                    taskItemView.kQM = false;
                                    taskItemView.gHA.setIndeterminate(false);
                                }
                                taskItemView.biT();
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(136309);
    }

    static /* synthetic */ void a(TaskListView taskListView, String str) {
        AppMethodBeat.i(136310);
        i iVar = (i) taskListView.kOT.get(str);
        if (iVar != null) {
            if (iVar.type == 6) {
                iVar.type = 2;
                taskListView.c(iVar);
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
            int childCount = linearLayoutManager.getChildCount();
            for (int i = 0; i <= childCount; i++) {
                if (linearLayoutManager.getChildAt(i) != null) {
                    View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i)).getChildAt(0);
                    if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                        TaskItemView taskItemView = (TaskItemView) childAt;
                        if (taskItemView.kQL.appId.equals(str)) {
                            ab.i("MicroMsg.TaskItemView", "onTaskPreStartDownload, appId: %s", str);
                            taskItemView.kQM = true;
                            taskItemView.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(136271);
                                    TaskItemView.this.kQz.setVisibility(0);
                                    TaskItemView.this.gHA.setIndeterminate(true);
                                    TaskItemView.this.kQA.setVisibility(8);
                                    TaskItemView.this.kQB.setVisibility(8);
                                    AppMethodBeat.o(136271);
                                }
                            });
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(136310);
    }

    static /* synthetic */ void b(TaskListView taskListView, String str) {
        AppMethodBeat.i(136311);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
        int childCount = linearLayoutManager.getChildCount();
        for (int i = 0; i <= childCount; i++) {
            if (linearLayoutManager.getChildAt(i) != null) {
                View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i)).getChildAt(0);
                if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                    TaskItemView taskItemView = (TaskItemView) childAt;
                    if (taskItemView.kQL.appId.equals(str)) {
                        ab.i("MicroMsg.TaskItemView", "onOrderWifiDownload, appId: %s", str);
                        taskItemView.kQM = false;
                        taskItemView.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(136261);
                                TaskItemView.this.kQz.setVisibility(8);
                                TaskItemView.this.kQB.setText(TaskItemView.this.getResources().getString(R.string.f7x));
                                TaskItemView.this.kQB.setVisibility(0);
                                AppMethodBeat.o(136261);
                            }
                        });
                    }
                }
            }
        }
        AppMethodBeat.o(136311);
    }

    static /* synthetic */ void c(TaskListView taskListView, String str) {
        int i;
        AppMethodBeat.i(136312);
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        Iterator it = taskListView.kQZ.kQR.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i iVar = (i) it.next();
            if (iVar.appId.equals(str)) {
                linkedList.add(iVar);
                j.kP(iVar.appId);
                break;
            }
            i2 = i + 1;
        }
        if (linkedList.size() != 0) {
            taskListView.kQZ.P(linkedList);
            taskListView.kQZ.ci(i);
        }
        AppMethodBeat.o(136312);
    }
}
