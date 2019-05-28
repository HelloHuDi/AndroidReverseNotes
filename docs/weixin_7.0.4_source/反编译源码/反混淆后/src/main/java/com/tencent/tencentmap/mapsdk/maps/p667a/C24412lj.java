package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ZoomControls;
import com.tencent.map.lib.C1015d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44533le.C36531b;
import com.tencent.tencentmap.mapsdk.p666a.C36463bi.C16187a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lj */
public class C24412lj implements C44533le {
    /* renamed from: a */
    private Context f4846a;
    /* renamed from: b */
    private ZoomControls f4847b;
    /* renamed from: c */
    private C31078lk f4848c = null;
    /* renamed from: d */
    private ViewGroup f4849d;
    /* renamed from: e */
    private C36531b f4850e = C36531b.RIGHT_BOTTOM;
    /* renamed from: f */
    private C16187a f4851f = null;
    /* renamed from: g */
    private C31061iz f4852g;
    /* renamed from: h */
    private int f4853h = 0;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lj$1 */
    class C59031 implements OnClickListener {
        C59031() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(100412);
            C24412lj.this.f4852g.mo75386b().mo20179a(null);
            AppMethodBeat.m2505o(100412);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lj$2 */
    class C59042 implements OnClickListener {
        C59042() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(100413);
            C24412lj.this.f4852g.mo75386b().mo20199b(null);
            AppMethodBeat.m2505o(100413);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lj$3 */
    class C59053 implements OnClickListener {
        C59053() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(100414);
            if (C24412lj.this.f4851f != null) {
                C24412lj.this.f4851f.mo29103a();
            }
            AppMethodBeat.m2505o(100414);
        }
    }

    public C24412lj(Context context, C31061iz c31061iz) {
        AppMethodBeat.m2504i(100416);
        this.f4846a = context;
        this.f4852g = c31061iz;
        m37973a(context);
        m37976d();
        AppMethodBeat.m2505o(100416);
    }

    /* renamed from: a */
    public void mo40422a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo40698a() {
        AppMethodBeat.m2504i(100417);
        if (this.f4848c != null) {
            this.f4848c.mo50530a();
        }
        AppMethodBeat.m2505o(100417);
    }

    /* renamed from: a */
    public boolean mo40708a(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(100418);
        if (viewGroup == null || this.f4847b == null || this.f4848c == null) {
            AppMethodBeat.m2505o(100418);
            return false;
        }
        this.f4849d = viewGroup;
        LayoutParams e = m37977e();
        if (viewGroup.indexOfChild(this.f4847b) < 0) {
            viewGroup.addView(this.f4847b, e);
        } else {
            viewGroup.updateViewLayout(this.f4847b, e);
        }
        e = new LayoutParams(-2, -2);
        e.gravity = 85;
        e.bottomMargin = this.f4853h + 5;
        e.rightMargin = 5;
        if (viewGroup.indexOfChild(this.f4848c) < 0) {
            viewGroup.addView(this.f4848c, e);
        } else {
            viewGroup.updateViewLayout(this.f4848c, e);
        }
        AppMethodBeat.m2505o(100418);
        return true;
    }

    /* renamed from: a */
    public void mo40731a(C36531b c36531b) {
        AppMethodBeat.m2504i(100419);
        if (this.f4850e != c36531b) {
            this.f4850e = c36531b;
            mo40708a(this.f4849d);
        }
        AppMethodBeat.m2505o(100419);
    }

    /* renamed from: a */
    private void m37973a(Context context) {
        AppMethodBeat.m2504i(100420);
        this.f4848c = new C31078lk(context);
        this.f4848c.setVisibility(8);
        m37975c();
        try {
            this.f4847b = new ZoomControls(context);
            this.f4847b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f4853h = this.f4847b.getMeasuredHeight();
            this.f4847b.setVisibility(8);
            AppMethodBeat.m2505o(100420);
        } catch (Exception e) {
            AppMethodBeat.m2505o(100420);
        }
    }

    /* renamed from: c */
    private void m37975c() {
        AppMethodBeat.m2504i(100421);
        Bitmap b = C36520ic.m60483b(C36520ic.m60482b(this.f4846a, "location_enable.png"));
        Bitmap b2 = C36520ic.m60483b(C36520ic.m60482b(this.f4846a, "location_state_normal.png"));
        Bitmap b3 = C36520ic.m60483b(C36520ic.m60482b(this.f4846a, "location_state_selected.png"));
        this.f4848c.setScaleType(ScaleType.CENTER);
        this.f4848c.setImageBitmap(b);
        this.f4848c.mo50531a(this.f4846a, b2, b3);
        AppMethodBeat.m2505o(100421);
    }

    /* renamed from: a */
    public void mo40730a(C16187a c16187a) {
        this.f4851f = c16187a;
    }

    /* renamed from: d */
    private void m37976d() {
        AppMethodBeat.m2504i(100422);
        if (this.f4847b != null) {
            this.f4847b.setOnZoomInClickListener(new C59031());
            this.f4847b.setOnZoomOutClickListener(new C59042());
        }
        this.f4848c.setOnClickListener(new C59053());
        AppMethodBeat.m2505o(100422);
    }

    /* renamed from: a */
    public void mo40733a(boolean z, boolean z2) {
        AppMethodBeat.m2504i(100423);
        if (this.f4847b != null) {
            this.f4847b.setIsZoomInEnabled(z);
            this.f4847b.setIsZoomOutEnabled(z2);
        }
        AppMethodBeat.m2505o(100423);
    }

    /* renamed from: a */
    public void mo40732a(boolean z) {
        AppMethodBeat.m2504i(100424);
        if (this.f4847b != null) {
            this.f4847b.setVisibility(z ? 0 : 4);
        }
        AppMethodBeat.m2505o(100424);
    }

    /* renamed from: b */
    public boolean mo40735b() {
        AppMethodBeat.m2504i(100425);
        if (this.f4847b == null) {
            AppMethodBeat.m2505o(100425);
            return false;
        } else if (this.f4847b.getVisibility() == 0) {
            AppMethodBeat.m2505o(100425);
            return true;
        } else {
            AppMethodBeat.m2505o(100425);
            return false;
        }
    }

    /* renamed from: b */
    public void mo40734b(boolean z) {
        AppMethodBeat.m2504i(100426);
        this.f4848c.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(100426);
    }

    /* renamed from: e */
    private LayoutParams m37977e() {
        AppMethodBeat.m2504i(100427);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        switch (this.f4850e) {
            case LEFT_BOTTOM:
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = 5;
                layoutParams.leftMargin = 5;
                break;
            case CENTER_BOTTOM:
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = 5;
                break;
            case RIGHT_BOTTOM:
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = 5;
                layoutParams.rightMargin = 5;
                break;
            case LEFT_TOP:
                layoutParams.gravity = 51;
                layoutParams.topMargin = 5;
                layoutParams.leftMargin = 5;
                break;
            case CENTER_TOP:
                layoutParams.gravity = 49;
                layoutParams.topMargin = 5;
                break;
            case RIGHT_TOP:
                layoutParams.gravity = 53;
                layoutParams.topMargin = 5;
                layoutParams.rightMargin = 5;
                break;
            default:
                C1015d.m2290b("Unknown position:" + this.f4850e);
                break;
        }
        AppMethodBeat.m2505o(100427);
        return layoutParams;
    }
}
