package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.DeviceProfileHeaderPreference */
public class DeviceProfileHeaderPreference extends Preference {
    /* renamed from: JV */
    private CharSequence f17198JV;
    private String kWC;
    protected MMActivity knn;
    private ImageView lxS;
    private TextView lxT;
    private TextView lxU;
    private TextView lxV;
    private View lxW;
    private TextView lxX;
    private boolean[] lxY;
    private OnClickListener[] lxZ;
    private String lya;
    private boolean lyb;
    private String mDeviceName;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(19759);
        this.lxY = new boolean[6];
        this.lxZ = new OnClickListener[6];
        this.lyb = false;
        this.knn = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(19759);
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(19760);
        this.lxY = new boolean[6];
        this.lxZ = new OnClickListener[6];
        this.lyb = false;
        this.knn = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(19760);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(19761);
        C4990ab.m7410d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.lxS = (ImageView) view.findViewById(2131823652);
        this.lxT = (TextView) view.findViewById(2131823625);
        this.lxU = (TextView) view.findViewById(2131823654);
        this.lxV = (TextView) view.findViewById(2131823655);
        this.lxW = view.findViewById(2131823653);
        this.lxX = (TextView) view.findViewById(2131823656);
        m76380T(this.lxS, 0);
        m76380T(this.lxT, 2);
        m76380T(this.lxU, 1);
        m76380T(this.lxV, 3);
        m76380T(this.lxW, 4);
        m76380T(this.lxX, 5);
        this.lyb = true;
        if (this.lyb) {
            this.lxT.setText(this.f17198JV);
            this.lxV.setText(this.mDeviceName);
            this.lxX.setText(this.lya);
            mo68542jl(this.kWC);
        } else {
            C4990ab.m7420w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.lyb);
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(19761);
    }

    /* renamed from: T */
    private void m76380T(View view, int i) {
        AppMethodBeat.m2504i(19762);
        view.setVisibility(this.lxY[i] ? 8 : 0);
        view.setOnClickListener(this.lxZ[i]);
        AppMethodBeat.m2505o(19762);
    }

    /* renamed from: Q */
    public final void mo68540Q(int i, boolean z) {
        View view;
        boolean z2;
        int i2 = 0;
        AppMethodBeat.m2504i(19763);
        switch (i) {
            case 0:
                view = this.lxS;
                break;
            case 1:
                view = this.lxU;
                break;
            case 2:
                view = this.lxT;
                break;
            case 3:
                view = this.lxV;
                break;
            case 4:
                view = this.lxW;
                break;
            case 5:
                view = this.lxX;
                break;
            default:
                AppMethodBeat.m2505o(19763);
                return;
        }
        boolean[] zArr = this.lxY;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[i] = z2;
        if (view != null) {
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        AppMethodBeat.m2505o(19763);
    }

    /* renamed from: a */
    public final void mo68541a(int i, OnClickListener onClickListener) {
        View view;
        AppMethodBeat.m2504i(19764);
        switch (i) {
            case 0:
                view = this.lxS;
                break;
            case 1:
                view = this.lxU;
                break;
            case 2:
                view = this.lxT;
                break;
            case 3:
                view = this.lxV;
                break;
            case 4:
                view = this.lxW;
                break;
            case 5:
                view = this.lxX;
                break;
            default:
                AppMethodBeat.m2505o(19764);
                return;
        }
        this.lxZ[i] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(19764);
    }

    public final void setName(CharSequence charSequence) {
        AppMethodBeat.m2504i(19765);
        this.f17198JV = charSequence;
        if (this.lxT != null) {
            this.lxT.setText(charSequence);
        }
        AppMethodBeat.m2505o(19765);
    }

    /* renamed from: Ky */
    public final void mo68539Ky(String str) {
        AppMethodBeat.m2504i(19766);
        this.mDeviceName = str;
        if (this.lxV != null) {
            this.lxV.setText(str);
        }
        AppMethodBeat.m2505o(19766);
    }

    /* renamed from: jo */
    public final void mo68543jo(String str) {
        AppMethodBeat.m2504i(19767);
        this.lya = str;
        if (this.lxX != null) {
            this.lxX.setText(str);
        }
        AppMethodBeat.m2505o(19767);
    }

    /* renamed from: jl */
    public final void mo68542jl(String str) {
        AppMethodBeat.m2504i(19768);
        this.kWC = str;
        if (this.lxS != null) {
            C17927a c17927a = new C17927a();
            Bitmap LV = C5056d.m7610LV(C25738R.drawable.ads);
            if (!(LV == null || LV.isRecycled())) {
                LV = C5056d.m7616a(LV, true, 0.5f * ((float) LV.getWidth()));
                if (!(LV == null || LV.isRecycled())) {
                    c17927a.ePU = new BitmapDrawable(LV);
                }
            }
            if (LV == null || LV.isRecycled()) {
                c17927a.ePT = C25738R.drawable.ads;
            }
            c17927a.eQf = true;
            C32291o.ahp().mo43766a(this.kWC, this.lxS, c17927a.ahG());
        }
        AppMethodBeat.m2505o(19768);
    }
}
