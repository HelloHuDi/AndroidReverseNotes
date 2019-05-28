package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C11053b;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C2594a;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C20337e;
import com.tencent.p177mm.plugin.downloader_app.p377b.C20339h;
import com.tencent.p177mm.plugin.downloader_app.p377b.C38861i;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C11517b;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C11519d;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C20336a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C38860f;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C42919e;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C42920g;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45836c;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45837j;
import com.tencent.p177mm.plugin.downloader_app.p380ui.C44731b.C277251;
import com.tencent.p177mm.plugin.downloader_app.p380ui.DownloadMainUI.C27724a;
import com.tencent.p177mm.plugin.downloader_app.p380ui.TaskItemView.C115342;
import com.tencent.p177mm.plugin.downloader_app.p380ui.TaskItemView.C1153710;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView */
public class TaskListView extends MRecyclerView {
    private Map<String, C38861i> kOT = new HashMap();
    C44731b kQZ;
    C27724a kRa;
    boolean kRb;
    private C11519d kRc = new C29171();
    private C20336a kRd = new C29183();
    private C11517b kRe = new C29254();
    private C38860f kRf = new C29245();
    private C42919e kRg = new C29266();
    private C42920g kRh = new C29237();
    private boolean kRi = true;

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$1 */
    class C29171 implements C11519d {
        C29171() {
        }

        /* renamed from: E */
        public final void mo7097E(int i, long j) {
            AppMethodBeat.m2504i(136292);
            C42911a hv = C2895c.m5147hv(j);
            if (hv != null) {
                TaskListView.m5193a(TaskListView.this, i, hv.field_appId);
            }
            AppMethodBeat.m2505o(136292);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$3 */
    class C29183 implements C20336a {
        C29183() {
        }

        /* renamed from: gg */
        public final void mo7098gg(boolean z) {
            AppMethodBeat.m2504i(136293);
            TaskListView taskListView = TaskListView.this;
            Iterator it = taskListView.kQZ.kQR.iterator();
            while (it.hasNext()) {
                C38861i c38861i = (C38861i) it.next();
                if (c38861i.biN()) {
                    c38861i.gBF = z;
                }
            }
            taskListView.kQZ.aop.notifyChanged();
            C42918d.m76214gf(z);
            AppMethodBeat.m2505o(136293);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$2 */
    class C29192 implements OnClickListener {
        C29192() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$8 */
    class C29208 implements C11053b {
        C29208() {
        }

        /* renamed from: L */
        public final boolean mo7100L(View view, int i) {
            AppMethodBeat.m2504i(136298);
            if (TaskListView.this.kRi) {
                if (((ViewGroup) view).getChildAt(0) instanceof TaskItemView) {
                    C20339h c20339h = TaskListView.this.kQZ.kQR;
                    if (c20339h != null) {
                        Iterator it = c20339h.iterator();
                        while (it.hasNext()) {
                            ((C38861i) it.next()).kci = true;
                        }
                        ((TaskItemView) ((ViewGroup) view).getChildAt(0)).setSelected(true);
                        TaskListView.m5199c(TaskListView.this);
                    }
                }
                AppMethodBeat.m2505o(136298);
                return true;
            }
            AppMethodBeat.m2505o(136298);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$9 */
    class C29219 implements C2594a {
        C29219() {
        }

        /* renamed from: I */
        public final void mo6645I(View view, int i) {
            AppMethodBeat.m2504i(136299);
            C4990ab.m7410d("MicroMsg.TaskListView", "onItemClick");
            View childAt = ((ViewGroup) view).getChildAt(0);
            C20339h c20339h = TaskListView.this.kQZ.kQR;
            if (i < 0 || i >= c20339h.size()) {
                AppMethodBeat.m2505o(136299);
                return;
            }
            C38861i c38861i = (C38861i) c20339h.get(i);
            if (c38861i.type == 7) {
                C44731b b = TaskListView.this.kQZ;
                if (!b.kQW) {
                    b.kQW = true;
                    b.aop.notifyChanged();
                }
                C45838a.m84850a(10, 1004, 101, 2, "", "", "");
                AppMethodBeat.m2505o(136299);
            } else if (!TaskListView.this.kRi) {
                boolean z;
                if (c38861i.gBF) {
                    z = false;
                } else {
                    z = true;
                }
                childAt.setSelected(z);
                AppMethodBeat.m2505o(136299);
            } else if (C5046bo.isNullOrNil(c38861i.jumpUrl)) {
                AppMethodBeat.m2505o(136299);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("rawUrl", c38861i.jumpUrl);
                ((C38855d) C1720g.m3528K(C38855d.class)).mo61733f(TaskListView.this.getContext(), bundle);
                C45838a.m84850a(10, C45838a.m84852tQ(c38861i.type), c38861i.position, 40, c38861i.appId, "", "");
                AppMethodBeat.m2505o(136299);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$10 */
    class C292210 implements OnClickListener {
        C292210() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(136300);
            TaskListView taskListView = TaskListView.this;
            LinkedList linkedList = new LinkedList();
            Iterator it = taskListView.kQZ.kQR.iterator();
            while (it.hasNext()) {
                C38861i c38861i = (C38861i) it.next();
                if (c38861i.gBF) {
                    int i2;
                    linkedList.add(c38861i);
                    C45837j.m84848kP(c38861i.appId);
                    C45836c.m84842b(c38861i);
                    switch (c38861i.type) {
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
                    C45838a.m84850a(11, i2, c38861i.position, 81, c38861i.appId, "", "");
                }
            }
            if (linkedList.size() != 0) {
                taskListView.kQZ.mo71808P(linkedList);
                if (taskListView.kQZ.biL()) {
                    taskListView.biU();
                }
            }
            C42918d.m76214gf(false);
            AppMethodBeat.m2505o(136300);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$7 */
    class C29237 implements C42920g {
        C29237() {
        }

        /* renamed from: IK */
        public final void mo7102IK(String str) {
            AppMethodBeat.m2504i(136297);
            TaskListView.m5200c(TaskListView.this, str);
            AppMethodBeat.m2505o(136297);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$5 */
    class C29245 implements C38860f {
        C29245() {
        }

        /* renamed from: IJ */
        public final void mo7103IJ(String str) {
            AppMethodBeat.m2504i(136295);
            TaskListView.m5194a(TaskListView.this, str);
            AppMethodBeat.m2505o(136295);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$4 */
    class C29254 implements C11517b {
        C29254() {
        }

        public final void onClick() {
            AppMethodBeat.m2504i(136294);
            TaskListView taskListView = TaskListView.this;
            C30379h.m48466d(taskListView.getContext(), taskListView.getContext().getString(C25738R.string.b5a), "", taskListView.getContext().getString(C25738R.string.ev_), taskListView.getContext().getString(C25738R.string.ev9), new C292210(), new C29192());
            AppMethodBeat.m2505o(136294);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.TaskListView$6 */
    class C29266 implements C42919e {
        C29266() {
        }

        /* renamed from: II */
        public final void mo7105II(String str) {
            AppMethodBeat.m2504i(136296);
            TaskListView.m5197b(TaskListView.this, str);
            AppMethodBeat.m2505o(136296);
        }
    }

    public TaskListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(136301);
        AppMethodBeat.m2505o(136301);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(136302);
        super.onFinishInflate();
        C4990ab.m7410d("MicroMsg.TaskListView", "onFinishInflate");
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.kQZ = new C44731b(getContext());
        setAdapter(this.kQZ);
        mo66330a(new C42929a(getResources()));
        setOnItemLongClickListener(new C29208());
        setOnItemClickListener(new C29219());
        AppMethodBeat.m2505o(136302);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(136303);
        super.onAttachedToWindow();
        C42918d.m76202a(this.kRc);
        C42918d.m76199a(this.kRd);
        C42918d.m76200a(this.kRe);
        C42918d.m76204a(this.kRf);
        C42918d.m76203a(this.kRg);
        C42918d.m76205a(this.kRh);
        AppMethodBeat.m2505o(136303);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(136304);
        super.onDetachedFromWindow();
        C42918d.m76209b(this.kRc);
        C42918d.m76206b(this.kRd);
        C42918d.m76207b(this.kRe);
        C42918d.m76211b(this.kRf);
        C42918d.m76210b(this.kRg);
        C42918d.m76212b(this.kRh);
        AppMethodBeat.m2505o(136304);
    }

    public void setData(LinkedList<C38861i> linkedList) {
        AppMethodBeat.m2504i(136305);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C38861i c38861i = (C38861i) it.next();
            if (!C5046bo.isNullOrNil(c38861i.appId)) {
                this.kOT.put(c38861i.appId, c38861i);
            }
        }
        C44731b c44731b = this.kQZ;
        c44731b.kQR.clear();
        C20339h c20339h = c44731b.kQR;
        for (C20337e a : linkedList) {
            c20339h.mo35575a(a);
        }
        c44731b.kQR.mo35575a(new C38861i(1));
        c44731b.kQR.mo35575a(new C38861i(3));
        c44731b.kQR.mo35575a(new C38861i(5));
        c44731b.kQR.mo35575a(new C38861i(7));
        c44731b.aop.notifyChanged();
        AppMethodBeat.m2505o(136305);
    }

    /* renamed from: c */
    private void m5198c(C38861i c38861i) {
        int i;
        Object obj;
        AppMethodBeat.m2504i(136306);
        C44731b c44731b = this.kQZ;
        c44731b.kQR.remove(c38861i);
        C20339h c20339h = c44731b.kQR;
        for (int i2 = 0; i2 < c20339h.size(); i2++) {
            if (c38861i.biK() <= ((C20337e) c20339h.get(i2)).biK()) {
                i = i2;
                obj = 1;
                break;
            }
        }
        i = 0;
        obj = null;
        if (obj == null) {
            i = c20339h.size();
        }
        c20339h.add(i, c38861i);
        C18514l.m28819q(new C277251());
        AppMethodBeat.m2505o(136306);
    }

    public int getSize() {
        AppMethodBeat.m2504i(136307);
        int size = this.kQZ.kQR.size();
        AppMethodBeat.m2505o(136307);
        return size;
    }

    public final void biU() {
        AppMethodBeat.m2504i(136308);
        this.kRb = false;
        if (this.kRa != null) {
            this.kRa.mo45557gl(false);
        }
        C20339h c20339h = this.kQZ.kQR;
        if (this.kQZ.biL()) {
            ((DownloadMainUI) getContext()).mo68458gk(true);
            AppMethodBeat.m2505o(136308);
            return;
        }
        Iterator it = c20339h.iterator();
        while (it.hasNext()) {
            C38861i c38861i = (C38861i) it.next();
            c38861i.kci = false;
            c38861i.gBF = false;
        }
        this.kQZ.kQX = true;
        this.kQZ.aop.notifyChanged();
        this.kRi = true;
        AppMethodBeat.m2505o(136308);
    }

    /* renamed from: a */
    static /* synthetic */ void m5193a(TaskListView taskListView, int i, String str) {
        AppMethodBeat.m2504i(136309);
        if (taskListView.kOT.containsKey(str)) {
            C38861i c38861i = (C38861i) taskListView.kOT.get(str);
            if (i == 9) {
                c38861i.type = 6;
                taskListView.m5198c(c38861i);
                AppMethodBeat.m2505o(136309);
                return;
            } else if (c38861i.type == 6) {
                c38861i.type = 2;
                taskListView.m5198c(c38861i);
                AppMethodBeat.m2505o(136309);
                return;
            } else {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
                int childCount = linearLayoutManager.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (linearLayoutManager.getChildAt(i2) != null) {
                        View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i2)).getChildAt(0);
                        if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                            TaskItemView taskItemView = (TaskItemView) childAt;
                            C4990ab.m7417i("MicroMsg.TaskItemView", "refreshDownloadStatus, event = %s, appId: %s", Integer.valueOf(i), str);
                            if (!(taskItemView.kPV.getVisibility() == 0 || !str.equals(taskItemView.kQL.appId) || C2895c.m5140In(taskItemView.kQL.appId) == null)) {
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
        AppMethodBeat.m2505o(136309);
    }

    /* renamed from: a */
    static /* synthetic */ void m5194a(TaskListView taskListView, String str) {
        AppMethodBeat.m2504i(136310);
        C38861i c38861i = (C38861i) taskListView.kOT.get(str);
        if (c38861i != null) {
            if (c38861i.type == 6) {
                c38861i.type = 2;
                taskListView.m5198c(c38861i);
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
            int childCount = linearLayoutManager.getChildCount();
            for (int i = 0; i <= childCount; i++) {
                if (linearLayoutManager.getChildAt(i) != null) {
                    View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i)).getChildAt(0);
                    if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                        TaskItemView taskItemView = (TaskItemView) childAt;
                        if (taskItemView.kQL.appId.equals(str)) {
                            C4990ab.m7417i("MicroMsg.TaskItemView", "onTaskPreStartDownload, appId: %s", str);
                            taskItemView.kQM = true;
                            taskItemView.post(new C1153710());
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(136310);
    }

    /* renamed from: b */
    static /* synthetic */ void m5197b(TaskListView taskListView, String str) {
        AppMethodBeat.m2504i(136311);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
        int childCount = linearLayoutManager.getChildCount();
        for (int i = 0; i <= childCount; i++) {
            if (linearLayoutManager.getChildAt(i) != null) {
                View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i)).getChildAt(0);
                if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                    TaskItemView taskItemView = (TaskItemView) childAt;
                    if (taskItemView.kQL.appId.equals(str)) {
                        C4990ab.m7417i("MicroMsg.TaskItemView", "onOrderWifiDownload, appId: %s", str);
                        taskItemView.kQM = false;
                        taskItemView.post(new C115342());
                    }
                }
            }
        }
        AppMethodBeat.m2505o(136311);
    }

    /* renamed from: c */
    static /* synthetic */ void m5200c(TaskListView taskListView, String str) {
        int i;
        AppMethodBeat.m2504i(136312);
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        Iterator it = taskListView.kQZ.kQR.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            C38861i c38861i = (C38861i) it.next();
            if (c38861i.appId.equals(str)) {
                linkedList.add(c38861i);
                C45837j.m84848kP(c38861i.appId);
                break;
            }
            i2 = i + 1;
        }
        if (linkedList.size() != 0) {
            taskListView.kQZ.mo71808P(linkedList);
            taskListView.kQZ.mo66318ci(i);
        }
        AppMethodBeat.m2505o(136312);
    }
}
